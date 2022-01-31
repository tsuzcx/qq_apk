import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;
import java.util.ArrayList;

public class gsq
  extends BroadcastReceiver
{
  public gsq(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if ("key_photo_delete_action".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      if ((i >= 0) && (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
        paramContext = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() >= 8) {
          break label128;
        }
        bool = true;
        paramContext.a(bool, true);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
        break label134;
      }
    }
    label128:
    label134:
    for (paramContext = "0";; paramContext = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "del_photo", paramContext, "", "", "");
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsq
 * JD-Core Version:    0.7.0.1
 */