package roles

/**
 * Created by careyc on 4/14/15.
 */
class Runner {
    public static enum Year {
        Freshman,
        Sophmore,
        Junior,
        Senior
    }

    static firstNames = ["Chris", "Travis", "Mike", "Bob", "Tom", "Kurt", "Jeff", "Tim", "Gabe", "Phil", "Myles", "Matt",
        "Bryon", "John", "Jon", "Riley", "Cooper", "Alan"]
    static lastNames = ["Carey", "Erickson", "Raemisch", "Richardson", "Kenas", "Hebl", "Hacker", "Solinsky", "Jennings", "Downs",
        "Smith", "Kramer", "Mills", "Porter", "Cobb"]
    static Random random = Random.newInstance()

    static def Runner next(team) {
        new Runner( firstName : firstNames[random.nextInt(firstNames.size())],
                    lastName : lastNames[random.nextInt(lastNames.size())],
                    talent : genTalent(),
                    year : genYear(),
                    team : team)
    }

    private static int genTalent() {
        final def bucket = (random.nextInt(100)) % 100

        if (bucket < 5) {
            (random.nextGaussian() * 15) + 975;
        } else if (bucket < 15)
            (random.nextGaussian() * 20) + 1035;
        else {
            (random.nextGaussian() * 50) + 1150
        }
    }

    private static Year genYear() {
        int year = (random.nextInt(100))

        if (year < 55)
            Year.Freshman
        else if (year < 75)
            Year.Sophmore
        else if (year < 90)
            Year.Junior
        else if (year >= 90)
            Year.Senior
    }

    def age() {
        def considerableImprovement = random.nextInt(100) < 15
        def improvement = (considerableImprovement) ?
            0.94 + (random.nextInt(40) / 1000) :
            0.96 + (random.nextInt(60) / 1000)

        talent = (int) improvement * talent

        if (year == Year.Junior) year = Year.Senior
        else if (year == Year.Sophmore) year = Year.Junior
        else year = Year.Sophmore
    }

    def firstName
    def lastName
    def talent
    def year
    def team
}
