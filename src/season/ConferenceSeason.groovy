package season

/**
 * Created by careyc on 4/18/15.
 */
class ConferenceSeason {
    def conference
    def teamSeasons = []

    ConferenceSeason(conference) {
        this.conference = conference
        conference.teams.each() {
            teamSeasons << new TeamSeason(team : it, conferenceScore : 0)
        }
    }

    def augment(team, amount) {
        teamSeasons.each { teamSeason ->
            if (teamSeason.team == team) teamSeason.conferenceScore += amount
        }


        teamSeasons.sort() { -it.conferenceScore }
    }
}
