import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.3.1;
import com.tencent.mobileqq.activity.TroopGagActivity.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vyz
  extends acnd
{
  public vyz(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.this$0.troopCode)) && (!this.this$0.troopCode.equals(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      this.this$0.a.notifyDataSetChanged();
      if (this.this$0.a.getCount() != 0) {
        break label209;
      }
      this.this$0.vp.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.getSharedPreferences("last_update_time" + this.this$0.app.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.this$0.troopCode, System.currentTimeMillis()).commit();
      ThreadManager.post(new TroopGagActivity.3.1(this, (apsw)this.this$0.app.getManager(48)), 8, null, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopGagActivity", 2, "onUpdateTroopGetMemberList: isSuccess=" + paramBoolean);
      return;
      label209:
      this.this$0.vp.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyz
 * JD-Core Version:    0.7.0.1
 */