public class Main {
    public static void main(String[] args) {
        boolean restart=true;
        while (restart) {
            Employe.menu();
            while (Employe.choix < 1 || Employe.choix > 9) {
                Employe.menuloop();
            }
            switch (Employe.choix) {
                case 1 -> Employe.ajouterEmp();
                case 2 -> Employe.modifierEmp();
                case 3 -> Employe.supEmp();
                case 4 -> Employe.afficherEmp();
                case 5 -> Employe.affichertous();
                case 6 -> Employe.afficher10000();
                case 7 -> Employe.afficherPlusAge();
                case 8 -> Employe.afficherMoinsAge();
                case 9 -> restart=false;
            }
        }
        System.out.println("Vous avez quitte le program");
    }
}
