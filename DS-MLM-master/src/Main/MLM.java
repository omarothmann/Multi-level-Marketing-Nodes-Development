package Main;

public interface MLM<E> {
    /**create new user information
     * @param String newencryptuser, String encryptuserparent
     */
    public void create(String newencryptUser,String encryptuserParent);
    /**retrieve the user information in company interface
     * @param String userid
     * @return user information
     */
    public String retrieveCompany(String userid);
    /**retrieve the user information in user interface
     * @param String userid
     * @return user information
     */
    public String retrieveUser(String userid) ;
    /**update the user information, such as username and id number
     * @param String userid
     */
    public void update(String userid, boolean changeName, String newName, boolean changeParent, String newParent);
    //delete the user information
    /**delete the user, the down line of the user will connected to the company and its generations will change according to the current hierarchy
     * @param String userid
     */
    public void delete(String userid);
    /**encrypt the username
     * @param String name, String key
     * @return encrypted name
     */
    public String encrypt(String name,String key);
    /**decrypt the username
     * @param String encryptedname, String key
     * @return name
     */
    public String decrypt(String encryptedname,String key);
    /**save the user information
     * 
     */
    public void saveUserInfo();
    /**load the user information
     * 
     */
    public void loadUserInfo();
    /**save the company information
     * 
     */
    public void saveCompanyInfo();
    /**save the company information
     * 
     */
    public void loadCompanyInfo();
    //<editor-fold defaultstate="collapsed" desc="Discontinued Code">
    /**display the entire tree of user
     * 
     */
    //public void display();
    //</editor-fold>
    /**get the company recruit revenue from selected generation
     * @param int indexPlusONE,TreeNode<String> current,double companyrevenue
     * @return double getGenerationRecruitRevenue
     */
    public double getGenerationRecruitRevenue(int indexPlusONE,TreeNode<String> current,double companyrevenue);
    /**set the recruit fee
     * @param double fee
     */
    public void setFee(double fee);
    /**set the recruit commission
     * @param int gen, double newCommission
     */
    public void setRecruitCommission(int gen, double newCommission);
}

