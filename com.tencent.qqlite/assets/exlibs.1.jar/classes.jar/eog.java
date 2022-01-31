import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.AddTroopHelper;

public class eog
  extends TroopObserver
{
  public eog(AddTroopHelper paramAddTroopHelper) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    this.a.jdField_a_of_type_Int = 0;
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if ((!paramBoolean1) || (paramTroopInfo == null) || (paramTroopInfo.troopuin == null) || (this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin))) {
      return;
    }
    switch (paramByte)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return;
    }
    AddTroopHelper.a(this.a, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.jdField_a_of_type_Int = 0;
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {}
    do
    {
      return;
      paramString = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString);
    } while (paramString == null);
    AddTroopHelper.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eog
 * JD-Core Version:    0.7.0.1
 */