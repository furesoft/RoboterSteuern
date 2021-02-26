import java.awt.*;

public class RoboterSteuern {


    private static WELT myWelt;
    private static ROBOTER myRob1;
    private static ROBOTER myRob2;

    public static void main(String[] args) {
        //Todo: haus bauen
        myWelt = new WELT(10, 10 ,20);
        myRob1 = new ROBOTER(myWelt);

        buildCeiling();
    }

    private static void buildCeiling() {
        myRob1.LinksDrehen();

        for (int x = 0; x < myWelt.getWeltBreite(); x++) {
            for (int y = 0; y < myWelt.getWeltLaenge()-1; y++) {
                myRob1.Hinlegen("grün");
                myRob1.Schritt();

                if(x == myWelt.getWeltBreite()  / 2 && y == myWelt.getWeltLaenge() /2) {
                    myRob2 = new ROBOTER(myWelt);
                    myRob2.LinksDrehen();
                    myRob2.Schritt();
                    myRob2.Schritt();
                    myRob2.RechtsDrehen();
                    myRob2.Schritt();
                    myRob2.Schritt();
                }

                if(myRob1.IstWand()) {
                    if(myRob1.IstBlickOsten()) {
                        myRob1.RechtsDrehen();
                        myRob1.Hinlegen("grün");
                        myRob1.Schritt();
                        myRob1.RechtsDrehen();
                    }

                    else if(myRob1.IstBlickWesten()) {
                        myRob1.LinksDrehen();

                        if(myRob1.IstBlickSueden() && myRob1.IstWand()) {
                            myRob1.RechtsDrehen();
                            myRob1.RechtsDrehen();

                            while(!myRob1.IstWand()) {
                                if(myRob1.IstZiegel()) {
                                    myRob1.Schritt();
                                }
                                else {
                                    myRob1.Hinlegen("grün");
                                }
                            }

                            break;
                        }

                        myRob1.Hinlegen("grün");
                        myRob1.Schritt();
                        myRob1.LinksDrehen();

                        if(myRob1.IstWand()) {
                            myRob1.RechtsDrehen();
                        }
                    }


                }
            }
        }
    }
}