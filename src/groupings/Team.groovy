package groupings

import roles.Runner

/**
 * Created by careyc on 4/14/15.
 */
class Team {
    static final int teamSize = 8

    def teamMembers = []
    def teamName

    static def Team buildTeam(teamName) {
        Team team = new Team()
        team.teamName = teamName

        0.upto(teamSize - 1) {
            team.teamMembers << Runner.next(team)
        }

        team
    }

    void forEvery(func) {
        teamMembers.each func
    }

    def age() {
        def toRemove = []

        teamMembers.each {
            if (it.year == Runner.Year.Senior) {
                toRemove << it
            }
            else
                it.age()
        }

        toRemove.each {
            teamMembers = teamMembers - it
            teamMembers << Runner.next(this)
        }
    }
}
