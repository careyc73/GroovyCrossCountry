package meets

/**
 * Created by careyc on 4/16/15.
 */
class duelMeet extends Meet {
    def conferenceSeason

    def score() {
        conferenceSeason.augment(teamPerformances[0].team, 2)
    }
}

