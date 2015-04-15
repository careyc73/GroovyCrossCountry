import roles.Runner

/**
 * Created by careyc on 4/14/15.
 */
class Game {
    static def main(args) {
        0.upto(100) {
            Runner runner = Runner.next()
            println(runner.firstName << " " << runner.lastName << " " << Utils.timeToString(runner.talent))
        }
    }
}
