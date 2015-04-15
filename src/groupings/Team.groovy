package groupings

import roles.Runner

/**
 * Created by careyc on 4/14/15.
 */
class Team {
    static final int teamSize = 8

    static def Team buildTeam(teamName) {
        Team team = new Team()
        team.teamName = teamName

        0.upto(teamSize) {
            team.teamMembers.add(Runner.next())
        }

        team
    }

    def teamMembers = []
    def teamName
}
