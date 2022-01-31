import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.RspGetGroupInArea;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.troop.activity.TroopLocationActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationActivity.TroopsAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ene
  extends LBSObserver
{
  public ene(TroopLocationActivity paramTroopLocationActivity) {}
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    if (this.a == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.a.jdField_a_of_type_Boolean) {
            this.a.a(paramBoolean);
          }
        } while ((!paramBoolean) || (paramRspGetGroupInArea == null));
        paramRspGetGroupInArea = paramRspGetGroupInArea.stGroupArea;
      } while (paramRspGetGroupInArea == null);
      if (this.a.jdField_a_of_type_Boolean)
      {
        localObject = paramRspGetGroupInArea.strStreet;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.a.b.setText((CharSequence)localObject);
          this.a.b.setVisibility(0);
        }
      }
    } while ((paramRspGetGroupInArea.vGroupInfo == null) || (paramRspGetGroupInArea.vGroupInfo.size() == 0));
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRspGetGroupInArea.vGroupInfo.size());
    }
    this.a.j = ((int)paramRspGetGroupInArea.dwGroupTotalCnt);
    paramRspGetGroupInArea = paramRspGetGroupInArea.vGroupInfo.iterator();
    while (paramRspGetGroupInArea.hasNext())
    {
      localObject = (GroupInfo)paramRspGetGroupInArea.next();
      this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    if (this.a.j <= this.a.jdField_a_of_type_JavaUtilArrayList.size()) {}
    for (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter.jdField_a_of_type_Boolean = false;; this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter.jdField_a_of_type_Boolean = true)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter.b = false;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter.notifyDataSetChanged();
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      this.a.e();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ene
 * JD-Core Version:    0.7.0.1
 */