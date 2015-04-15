import roles.Runner

/**
 * Created by careyc on 4/14/15.
 */
class Utils {
    static def String timeToString(int time) {
        String.format("%02d:%02d", (int) time / 60 , (int) time % 60)
    }

    static def String describeRunner(Runner runner) {
        String.format("%-30s%10s%15s", runner.firstName + " " + runner.lastName,
            timeToString(runner.talent), runner.year)
    }
}
