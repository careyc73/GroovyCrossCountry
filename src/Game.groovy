import groupings.Team
import meets.Meet
import meets.Utils
import meets.duelMeet

/**
 * Created by careyc on 4/14/15.
 */
class Game {
    static def main(args) {
        def teams = []

        teams << Team.buildTeam("Waunakee")
        teams << Team.buildTeam("Verona")
        def runnerPerformances, teamPerformances

        for (int i = 0 ; i < 4 ; i++) {
            (runnerPerformances, teamPerformances) = Meet.runMeet(teams)

            Meet meet = new duelMeet(runnerPerformances: runnerPerformances, teamPerformances: teamPerformances)

            meet.outputResults()

            teams.each {
                it.age()
            }
        }
    }
}
