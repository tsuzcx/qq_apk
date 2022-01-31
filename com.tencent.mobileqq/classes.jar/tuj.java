import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.GagMemInfo;
import com.tencent.mobileqq.app.TroopManager.MemberGagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class tuj
  implements Runnable
{
  tuj(tui paramtui, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      this.jdField_a_of_type_Tui.a.a.jdField_a_of_type_JavaUtilList.clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopManager.MemberGagInfo localMemberGagInfo = (TroopManager.MemberGagInfo)localIterator.next();
        TroopGagActivity.GagMemInfo localGagMemInfo = new TroopGagActivity.GagMemInfo();
        localGagMemInfo.jdField_a_of_type_JavaLangString = localMemberGagInfo.jdField_a_of_type_JavaLangString;
        localGagMemInfo.jdField_a_of_type_Long = localMemberGagInfo.jdField_a_of_type_Long;
        this.jdField_a_of_type_Tui.a.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
      }
    }
    this.jdField_a_of_type_Tui.a.a.jdField_a_of_type_Tum.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tuj
 * JD-Core Version:    0.7.0.1
 */