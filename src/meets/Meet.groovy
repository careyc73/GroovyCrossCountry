package meets

/**
 * Created by careyc on 4/17/15.
 */
class Meet {
    def runnerPerformances = []
    def teamPerformances = []

    static def runMeet(teams) {
        def performances = []

        teams.each {
            team ->
            team.forEvery {
                runner ->
                    performances << Utils.run(runner)
            }
        }

        performances.sort() { it.time }

        def teamScoreCounts = [:]
        def totalScore, runnersCounted
        0.upto(performances.size() - 1) {
            def team = performances[it].runner.team
            if (!teamScoreCounts.containsKey(team)) {
                teamScoreCounts[team] = [0, 0]
            }

            (totalScore, runnersCounted) = teamScoreCounts[team]

            if (runnersCounted < 5) {
                teamScoreCounts[team] = [totalScore + it + 1, runnersCounted + 1]
            }
        }

        def teamPerformances = []
        teamScoreCounts.each {
            k, v ->
            teamPerformances << new TeamPerformance(team : k, score : v[0])
        }
        teamPerformances.sort() { it.score }

        [ performances, teamPerformances ]
    }

    def outputResults() {
        Utils.printTeamScoring(teamPerformances)
        println("-----------------------------------------------------------------------------------------------------------")
        Utils.printRunnerScoring(runnerPerformances)

    }

}
