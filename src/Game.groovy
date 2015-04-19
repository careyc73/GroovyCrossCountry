import groupings.Conference
import groupings.Team
import meets.Meet
import meets.Utils
import meets.duelMeet
import season.ConferenceSeason

/**
 * Created by careyc on 4/14/15.
 */
class Game {
    static def main(args) {
        def teams = []

        teams << Team.buildTeam("Waunakee")
        teams << Team.buildTeam("Verona")

        def conference = new Conference(teams : teams, conferenceName : "Badger")
        def badgerSeason = new ConferenceSeason(conference)

        def runnerPerformances, teamPerformances

        for (int i = 0 ; i < 4 ; i++) {
            (runnerPerformances, teamPerformances) = Meet.runMeet(teams)

            Meet meet = new duelMeet(   runnerPerformances: runnerPerformances, teamPerformances: teamPerformances,
                                        conferenceSeason : badgerSeason)

            meet.outputResults()
            meet.score()

            Utils.printConferenceRankings(badgerSeason)

//
//            teams.each {
//                it.age()
//            }
        }
    }
}
