package meets

import meets.RunnerPerformance

/**
 * Created by careyc on 4/14/15.
 */
class Utils {
    static Random random = Random.newInstance()

    static def String timeToString(time) {
        String.format("%02d:%02d", (int) time / 60 , (int) time % 60)
    }

    static def printTeamScoring = { teamScoring ->
        0.upto(teamScoring.size - 1) {
            println (String.format("%3d %-20s %4d", it + 1,
                teamScoring[it].team.teamName, teamScoring[it].score))
        }
    }

    static def printRunnerScoring = { runnerScoring ->
        0.upto(runnerScoring.size - 1) {
            println String.format("%3d %s", it + 1,
                Utils.describeWithTime(runnerScoring[it].runner, runnerScoring[it].time))

        }
    }

    static def describeWithTime = { runner, time ->
        String.format("%-30s%10s%15s%20s", runner.firstName + " " + runner.lastName, timeToString(time), runner.year, runner.team.teamName)
    }

    static def run = { runner ->
        new RunnerPerformance(runner : runner, time : runner.talent * (0.98 + ((double) (random.nextInt(40)) / 100.0)))
    }
}
