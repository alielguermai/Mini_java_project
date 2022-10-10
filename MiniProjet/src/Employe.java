import java.util.ArrayList;
import java.util.Scanner;

public class Employe {
    private String nom,prenom;
    private int matricule,age;
    private double salaire;

    public Employe(int matricule, String nom, String prenom, int age, double salaire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.salaire = salaire;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule=" + matricule +
                ", age=" + age +
                ", salaire=" + salaire +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

//    Les methodes :

    static Scanner sc = new Scanner(System.in);
    static int choix;
    static ArrayList<Employe> arrayEmp = new ArrayList<>();

    static void menu(){
        System.out.println("""
                --------------------------Menu du programme-----------------------------
                1 - Ajouter un nouvel employé
                2 - Modifier un employé\s
                3 - Supprimer un employé\s
                4 - Afficher un employé\s
                5 - Afficher tous les employés\s
                6 - Calculer le nombre des employés ayant un salaire qui dépasse 10000.\s
                7 - Afficher l’employé le plus âgé.\s
                8 - Afficher l’employé le moins âgé.\s
                9 - Quitter""");
        boolean error=true;
        while (error) {
            try {
                System.out.print("Donner votre choix :");
                choix = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Il faut entrer un nombre !");
                sc.next();
            }
        }
    }
    static void menuloop(){
        System.out.println("Entrez un nombre de choix entre (1 et 9) :");
        boolean error=true;
        while (error) {
            try {
                System.out.print("Donner votre choix :");
                choix = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Il faut entrer un nombre !");
                sc.next();
            }
        }
    }
    static void ajouterEmp(){
        int mat = 0;
        boolean error=true;
        while (error) {
            try {
                System.out.print("Entrer le matricule :");
                mat = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Il faut entrer un nombre !");
                sc.next();
            }
        }
        System.out.print("Entrer le nom :");
        String nom=sc.next();
        System.out.print("Enter le prenom :");
        String prenom=sc.next();
        int age=0;
        error=true;
        while (error) {
            try {
                System.out.print("Entrer l'age :");
                age = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Il faut entrer un nombre !");
                sc.next();
            }
        }
        double sal=0;
        error=true;
        while (error) {
            try {
                System.out.print("Entrer le salaire :");
                sal = sc.nextDouble();
                error = false;
            } catch (Exception e) {
                System.out.println("Il faut entrer un nombre !");
                sc.next();
            }
        }
        Employe e = new Employe(mat,nom,prenom,age,sal);
        arrayEmp.add(e);
        System.out.println("L'employe a ete ajoute avec success !");
    }
    static void modifierEmp() {
        if (arrayEmp.isEmpty()) {
            System.out.println("Il n'y a aucun employe !");
        } else {
            System.out.println("Entrer le matricule d'employe pour le modifier :");
            int mat = 0;
            boolean error=true;
            while (error) {
                try {
                    System.out.print("Entrer le matricule :");
                    mat = sc.nextInt();
                    error = false;
                } catch (Exception e) {
                    System.out.println("Il faut entrer un nombre !");
                    sc.next();
                }
            }
            boolean exist = false;
            int i = 0;
            int ind = 0;
            for (Employe e : arrayEmp) {
                if (e.getMatricule() == mat) {
                    exist = true;
                    ind = i;
                }
                i++;
            }
            if (exist) {
                System.out.println("Modification :");
                error=true;
                while (error) {
                    try {
                        System.out.print("Entrer le matricule :");
                        mat = sc.nextInt();
                        error = false;
                    } catch (Exception e) {
                        System.out.println("Il faut entrer un nombre !");
                        sc.next();
                    }
                }
                System.out.print("Entrer le nom :");
                String nom = sc.next();
                System.out.print("Enter le prenom :");
                String prenom = sc.next();
                error=true;
                int age =0;
                while (error) {
                    try {
                        System.out.print("Entrer l'age :");
                        age = sc.nextInt();
                        error = false;
                    } catch (Exception e) {
                        System.out.println("Il faut entrer un nombre !");
                        sc.next();
                    }
                }
                error=true;
                double sal =0;
                while (error) {
                    try {
                        System.out.print("Entrer le salaire :");
                        sal = sc.nextInt();
                        error = false;
                    } catch (Exception e) {
                        System.out.println("Il faut entrer un nombre !");
                        sc.next();
                    }
                }
                Employe e = new Employe(mat, nom, prenom, age, sal);
                arrayEmp.set(ind, e);
                System.out.println("L'employe a ete modifie avec success !");
            } else {
                System.out.println("Cet employe n'extste pas !");
            }
        }
    }
    static void supEmp() {
        if (arrayEmp.isEmpty()) {
            System.out.println("Il n'y a aucun employe !");
        } else {
            System.out.print("Entrer le matricule d'employe pour le supprimer :");
            int mat = 0;
            boolean error=true;
            while (error) {
                try {
                    System.out.print("Entrer le matricule :");
                    mat = sc.nextInt();
                    error = false;
                } catch (Exception e) {
                    System.out.println("Il faut entrer un nombre !");
                    sc.next();
                }
            }
            boolean exist = false;
            int i = 0;
            int ind = 0;
            for (Employe e : arrayEmp) {
                if (e.getMatricule() == mat) {
                    exist = true;
                    ind = i;
                }
                i++;
            }
            if (exist) {
                arrayEmp.remove(ind);
                System.out.println("L'employe a ete supprime avec success !");
            } else {
                System.out.println("Cet employe n'extste pas !");
            }
        }
    }
    static void afficherEmp() {
        if (arrayEmp.isEmpty()) {
            System.out.println("Il n'y a aucun employe !");
        } else {
            System.out.print("Entrer le matricule d'employe pour l'afficher :");
            int mat = 0;
            boolean error=true;
            while (error) {
                try {
                    System.out.print("Entrer le matricule :");
                    mat = sc.nextInt();
                    error = false;
                } catch (Exception e) {
                    System.out.println("Il faut entrer un nombre !");
                    sc.next();
                }
            }
            boolean exist = false;
            int i = 0;
            int ind = 0;
            for (Employe e : arrayEmp) {
                if (e.getMatricule() == mat) {
                    exist = true;
                    ind = i;
                }
                i++;
            }
            if (exist) {
                System.out.println(arrayEmp.get(ind));
            } else {
                System.out.println("Cet employe n'extste pas !");
            }
        }
    }
    static void affichertous() {
        System.out.println("Affichage des tous les employes :");
        if (arrayEmp.isEmpty()) {
            System.out.println("Il n'y a aucun employe !");
        } else {
            for (Employe e : arrayEmp) {
                System.out.println(e);
            }
        }
    }
    static void afficher10000(){
        if (arrayEmp.isEmpty()){
            System.out.println("Il n'y a aucun employe !");
        }
        ArrayList<Employe> depass=new ArrayList<>();
        for (Employe e :arrayEmp){
            if (e.getSalaire()>10000){
                depass.add(e);
            }
        }
        if (depass.isEmpty()){
            System.out.println("Il n'y a pas d'employe qui depasse 10000 !");
        }
        else {
            System.out.println("Les employes ayant un salaire qui depasse 10000 sont :");
            for (Employe e:depass){
                System.out.println(e);
            }
        }
    }
    static void afficherPlusAge(){
        if (arrayEmp.isEmpty()){
            System.out.println("Il n'y a aucun employe !");
        }
        else {
            Employe emp = null;
            int max=0;
            for (Employe e:arrayEmp){
                if (e.getAge()>max){
                    max=e.getAge();
                    emp=e;
                }
            }
            System.out.println("L'employe le plue age est :");
            System.out.println(emp);
        }
    }
    static void afficherMoinsAge(){
        if (arrayEmp.isEmpty()){
            System.out.println("Il n'y a aucun employe !");
        }
        else {
            Employe emp = null;
            int min=150;
            for (Employe e:arrayEmp){
                if (e.getAge()<min){
                    min=e.getAge();
                    emp=e;
                }
            }
            System.out.println("L'employe le plue age est :");
            System.out.println(emp);
        }
    }
}
