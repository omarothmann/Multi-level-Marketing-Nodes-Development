package Main;
public class begin {
    //<editor-fold defaultstate="collapsed" desc="Discontinued Code">
    //public static String mark = "-1";
    //public static double temprecruit = 0.0;
    //public static double tempsales = 0.0;
    //</editor-fold>
    public static Functions mlm = new Functions();
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mlm.loadCompanyInfo();
                mlm.loadUserInfo();
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {}
                Intro window = new Intro();
                window.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }
}
//<editor-fold defaultstate="collapsed" desc="Discontinued Code">     
        //Intro window = new Intro();
        //window.setLocationRelativeTo(null);
        //window.setVisible(true);
        //load the data from file
        /*String option = " ";
        while(!option.equals("user")||!option.equals("admin")||!option.equals("exit")){
            System.out.println("Welcome to main page of DreamCorporation!!!");
            System.out.print("Are you is user or admin? (Enter {'user' / 'admin' / 'exit' to end the program}): ");
            option = s.nextLine();
            if(option.equals("user")){
                String username = " ";                
                while(!username.equals("exit")){
                    System.out.print("Enter the username (Enter 'exit' to end the program.): ");
                    username = s.nextLine();
                    if(username.equals("exit")){
                        break;
                    }
                    else if(mlm.searchDATA(mlm.getRoot(), mlm.encrypt(username,mlm.getdecryptkey()))&&!username.equals("admin")){
                        System.out.println(mlm.retrieveUser(mlm.getNodebyencryptUser(mlm.getRoot(), mlm.encrypt(username,mlm.getdecryptkey())).id));
                        System.out.println("Press enter to exit.");
                        s.nextLine();
                    }
                    else{
                        System.out.println("The username is not exist.");
                        break;
                    }
                }
                
            }
            else if(option.equals("admin")){
                String pass = "";
                while(!pass.equals(mlm.getPassword())){
                    System.out.print("Enter the password: ");
                    pass = s.nextLine();
                    if(pass.equals(mlm.getPassword())){
                        while(!mark.equals("0")){
                        System.out.print("1 Create new user."
                            + "\n2 Retrieve the data of the user chosen."
                            + "\n3 Update the data of the user chosen."
                            + "\n4 Delete the user chosen."
                            + "\n5 View the tree of the hierachy."
                            + "\n6 Get the revenue of each generations."
                            + "\n7 Enter the sales."
                            + "\n8 Save the directory of data file (in txt.file)."
                            + "\n9 Change the password, decrypt key, fee and commissions."
                            + "\n0 Close the program."
                            + "\nEnter the input: ");
                        mark = s.nextLine();
                        switch (mark) {
                            case "1":
                                System.out.print("Enter the new username (The length of the name is between 10 to 12 characters and no spacing): ");
                                String newUser = s.nextLine();
                                if(newUser.length()>=10&&newUser.length()<=12&&!newUser.contains(" ")){
                                    System.out.print("Enter the user ID who recommend the user (Admin ID is 000000): ");
                                    String userParentid = s.nextLine();
                                    mlm.create(mlm.encrypt(newUser,mlm.getdecryptkey()),userParentid);
                                }
                                else{
                                    System.out.println("Invalid username. The system will return to mainpage.");
                                }                    
                                break;
                            case "2":
                                System.out.print("Enter the username ID: ");
                                String userNameid = s.nextLine();
                                System.out.println(mlm.retrieveCompany(userNameid));
                                if(mlm.searchID(mlm.getRoot(), userNameid)&&!userNameid.equals(mlm.getRoot().id)){
                                    System.out.print("Enter password to decrypt both the username and the parent's username: ");
                                    String password = s.nextLine();
                                    if(password.equals(mlm.getdecryptkey())){
                                        System.out.println("Username: " + mlm.decrypt((String)mlm.getNodebyID(mlm.getRoot(),userNameid).encrypteddata, password));
                                        System.out.println("Parent name: " + mlm.decrypt((String)mlm.getNodebyID(mlm.getRoot(),userNameid).parent.encrypteddata, password));
                                    }
                                    else{
                                        System.out.println("The key is incorrect.");
                                    }
                                }
                                break;
                            case "3":
                                System.out.print("Enter the username ID: ");
                                String usernameID = s.nextLine();
//                                mlm.update(usernameID);
                                break;
                            case "4":
                                System.out.print("Enter the user ID that need to be deleted:");
                                String userID = s.nextLine();
                                mlm.delete(userID);
                                break;
                            case "5":
                                //mlm.display();
                                break;
                            case "6"://get revenue for each generations method
                                System.out.print("Enter the generation the company gains (Start from 1): ");  
                                int gen = s.nextInt();
                                s.nextLine();
                                if(mlm.getGenerationRecruitRevenue(gen,mlm.getRoot(),0.0)==0){
                                    System.out.println("Error input.");
                                }
                                else{
                                    System.out.println("Company's recruit revenue for this generation: RM " + mlm.getGenerationRecruitRevenue(gen,mlm.getRoot(),0.0));
                                    System.out.println("Company's sales revenue for this generation: RM " + mlm.getGenerationSalesRevenue(gen,mlm.getRoot(),0.0));
                                }
                                break;
                            case "7":
                                System.out.print("Enter the sales is this format (ID/Number of goods sold/Sales): ");
                                String a = s.nextLine();
                                String id = "";
                                int number = 0;
                                double sales = 0.0;
                                try{
                                    id = a.substring(0, 6);
                                    number = Integer.parseInt(a.substring(7, a.indexOf("/", 7)));
                                    sales = Double.parseDouble(a.substring(a.indexOf("/", 7)+1));
                                    mlm.sales(id, number, sales);
                                }catch(Exception e){
                                    System.out.println("Error input.");
                                }
                                //System.out.println(id + number + sales);
                                break;
                            case "8":
                                System.out.println("The data are saved.");
                                //mlm.save();
                                mlm.saveCompanyInfo();
                                mlm.saveUserInfo();
                                System.out.println();
                                break;
                            case "9"://change the interface password and key,the change commission got problem
                                String options = "";
                                while(!options.equals("0")){
                                    System.out.print("1 Change the password."
                                        + "\n2 Change the decrypt key password."
                                        + "\n3 Change the recruit commissions for each generations."
                                        + "\n4 Change the selling commissions for each generations."
                                        + "\n5 Change the recruit fee."
                                        + "\n0 Back to homepage."
                                        + "\nEnter the input: ");
                                    options = s.nextLine();
                                    switch(options){
                                        case "1":
                                            System.out.print("Enter the current password: ");
                                            String z = s.nextLine();
                                            if(z.equals(mlm.getPassword())){
                                                System.out.print("Enter the new password: ");
                                                String d = s.nextLine();
                                                mlm.setPassword(d);
                                            }
                                            else{
                                                System.out.println("Wrong password. The server will back to homepage.");
                                            }
                                            break;
                                        case "2":
                                            System.out.print("Enter the current key password: ");
                                            String c = s.nextLine();
                                            if(c.equals(mlm.getdecryptkey())){
                                                System.out.print("Enter the new password: ");
                                                String d = s.nextLine();
                                                mlm.setdecryptkey(d);
                                            }
                                            else{
                                                System.out.println("Wrong password. The server will back to homepage.");
                                            }
                                            break;
                                        case "3":
                                            System.out.print("Enter the generation (1-5): ");
                                            int e = s.nextInt();
                                            s.nextLine();
                                            if(e-1<0||e-1>=mlm.getRecruitCommissionSize()){
                                                System.out.println("Wrong input. The server will back to homepage.");
                                            }
                                            else{
                                                double temp = 0.8;
                                                for(int x=0;x<mlm.getRecruitCommissionSize();x++){
                                                    temp -= mlm.getRecruitCommission(x);
                                                }
                                                temp += mlm.getRecruitCommission(e-1);
                                                System.out.print("Enter the new commission in % (The commission cannot exceed "+ Math.round((temp)*100) + "%!): ");
                                                double f = s.nextDouble();
                                                f/=100;
                                                s.nextLine();
                                                if(f>temp){
                                                    System.out.println("The total commission are exceed " + Math.round((temp)*100) +"%. The server will back to homepage.");
                                                }
                                                else{
                                                    mlm.setRecruitCommission(e-1, f);
                                                }
                                            }
                                            break;
                                        case "4":
                                            System.out.print("Enter the generation (1-3): ");
                                            int g = s.nextInt();
                                            s.nextLine();
                                            if(g-1<0||g-1>=mlm.getSalesCommissionSize()){
                                                System.out.println("Wrong input. The server will back to homepage.");
                                            }
                                            else{
                                                double temp = 0.5;
                                                for(int x=0;x<mlm.getSalesCommissionSize();x++){
                                                    temp -= mlm.getSalesCommission(x);
                                                }
                                                temp += mlm.getSalesCommission(g-1);
                                                System.out.print("Enter the new commission in % (The commission cannot exceed "+ Math.round((temp)*100) + "%!): ");
                                                double f = s.nextDouble();
                                                f/=100;
                                                s.nextLine();
                                                if(f>temp){
                                                    System.out.println("The total commission are exceed " + Math.round((temp)*100) + "%. The server will back to homepage.");
                                                }
                                                else{
                                                    mlm.setSalesCommission(g-1, f);
                                                }
                                            }
                                            break;
                                        case "5":
                                            System.out.print("Enter the new fee: ");
                                            double newFee = s.nextDouble();
                                            s.nextLine();
                                            mlm.setFee(newFee);
                                            break;
                                        case "0":
                                            break;
                                        default:
                                            System.out.println("Invalid input. Please enter the input again.");
                                            break;
                                    }
                                }
                                options = "";
                                break;
                            case "0":
                                System.out.println("The server will back to homepage.");
                                break;
                            default:
                                System.out.println("Invalid input. Please enter the input again.");
                                break;
                            }
                        
                        }
                        mark = "";
                    }
                    else{
                        System.out.println("Wrong password. The system will automatically shutdown.");
                        break;
                    }
                    break;
                }
                
            }
            else if(option.equals("exit")){
                System.exit(0);
            }
            else{
                System.out.println("Incorrect input. Please enter again.");
            }
        }
        
     */
// </editor-fold>    