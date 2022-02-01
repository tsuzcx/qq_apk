import EncounterSvc.RespEncounterInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity.1.1;
import com.tencent.mobileqq.dating.MsgBoxListActivity.1.2;
import com.tencent.mobileqq.dating.MsgBoxListActivity.1.3;
import java.util.ArrayList;
import java.util.List;

public class afcq
  extends acgs
{
  public afcq(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void l(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && ((paramArrayOfObject instanceof Object[])) && (MsgBoxListActivity.a(this.this$0) != null))
    {
      MsgBoxListActivity.a(this.this$0).b((List)paramArrayOfObject[0], 0, (ArrayList)paramArrayOfObject[1]);
      this.this$0.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig = MsgBoxListActivity.a(this.this$0).a();
      this.this$0.app.getPreferences().edit().putLong("sp_key_dating_config_time", System.currentTimeMillis()).commit();
      this.this$0.runOnUiThread(new MsgBoxListActivity.1.3(this));
    }
  }
  
  protected void m(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i;
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      if (paramArrayOfObject == null) {
        break label101;
      }
      i = 1;
      if (((i & paramArrayOfObject instanceof Object[]) != 0) && (this.this$0.BC != null) && (this.this$0.jdField_a_of_type_Akkv != null) && (((Integer)paramArrayOfObject[1]).intValue() == 1))
      {
        paramArrayOfObject = (List)paramArrayOfObject[0];
        localLinearLayout = (LinearLayout)this.this$0.BC.findViewById(2131373861);
        if (localLinearLayout.getChildCount() != 0) {
          break label106;
        }
        this.this$0.runOnUiThread(new MsgBoxListActivity.1.1(this, paramArrayOfObject));
      }
    }
    for (;;)
    {
      return;
      label101:
      i = 0;
      break;
      label106:
      if (localLinearLayout.getChildCount() == paramArrayOfObject.size())
      {
        i = 0;
        while (i < localLinearLayout.getChildCount())
        {
          View localView = localLinearLayout.getChildAt(i);
          RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramArrayOfObject.get(i);
          this.this$0.runOnUiThread(new MsgBoxListActivity.1.2(this, localView, localRespEncounterInfo));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcq
 * JD-Core Version:    0.7.0.1
 */