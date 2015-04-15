import groupings.Team
import roles.Runner

/**
 * Created by careyc on 4/14/15.
 */
class Game {
    static def main(args) {
        Team team = Team.buildTeam("Waunakee")

        println(team.teamName)
        for (Runner runner : team.teamMembers) {
            println(Utils.describeRunner(runner))
        }
    }
}
