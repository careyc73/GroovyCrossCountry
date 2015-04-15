package roles

/**
 * Created by careyc on 4/14/15.
 */
class Runner {
    static firstNames = ["Chris", "Travis"]
    static lastNames = ["Carey", "Erickson"]
    static Random random = Random.newInstance()

    static def Runner next() {
        new Runner(firstName : firstNames[random.nextInt(firstNames.size())],
                  lastName : lastNames[random.nextInt(lastNames.size())],
                  talent : genTalent() )
    }

    private static int genTalent() {
        if (((random.nextInt(100)) % 100) < 5) {
            return (random.nextGaussian() * 15) + 990;
        }

        (random.nextGaussian() * 50) + 1140
    }

    def firstName
    def lastName
    def talent
}
