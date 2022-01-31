import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.adapter.ForwardTroopListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class eyj
  implements Comparator
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardTroopListAdapter.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardTroopListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  
  public eyj(ForwardTroopListAdapter paramForwardTroopListAdapter)
  {
    ChnToSpell.a(paramForwardTroopListAdapter.jdField_a_of_type_AndroidContentContext);
  }
  
  public int a(TroopInfo paramTroopInfo1, TroopInfo paramTroopInfo2)
  {
    int i = 1;
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardTroopListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramTroopInfo1.troopuin, 1L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardTroopListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramTroopInfo2.troopuin, 1L);
    if (l1 == l2) {
      i = ChnToSpell.a(paramTroopInfo1.troopname, 1).compareTo(ChnToSpell.a(paramTroopInfo2.troopname, 1));
    }
    while (l1 <= l2) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyj
 * JD-Core Version:    0.7.0.1
 */