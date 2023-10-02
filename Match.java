package BoksOyunu;

public class Match {
    Boxer b1, b2;
    int minWeight, maxWeight;

    Match(Boxer b1, Boxer b2, int minWeight, int maxWeight) {
        // İlk yumruğu atan kişiyi rastgele seçmek için tanımlanan koşul:
        if (Math.random() <= 0.5) {
            this.b1 = b1;
            this.b2 = b2;
        } else {
            this.b1 = b2;
            this.b2 = b1;
        }

        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    boolean isCheck() {
        return (this.b1.weight >= this.minWeight && this.b1.weight <= this.maxWeight) &&
                (this.b2.weight >= this.minWeight && this.b2.weight <= this.maxWeight);
    }

    void run() {
        if (isCheck()) {
            while (this.b1.health > 0 && this.b2.health > 0) {
                System.out.println("-----YENİ ROUND----- ");

                this.b2.health = this.b1.Hit(this.b2);
                if (isWin()) {
                    break;
                }

                this.b1.health = this.b2.Hit(this.b1);
                if (isWin()) {
                    break;
                }

                System.out.println(this.b1.name + " sağlık: " + this.b1.health);
                System.out.println(this.b2.name + " sağlık: " + this.b2.health);
            }
        } else {
            System.out.println("Boksörlerin sikletleri uymuyor!");
        }
    }

    boolean isWin() {
        if (this.b1.health == 0) {
            System.out.println(this.b2.name + " kazandı!");
            return true;
        } else if (this.b2.health == 0) {
            System.out.println(this.b1.name + " kazandı!");
            return true;
        }
        return false;
    }

}
