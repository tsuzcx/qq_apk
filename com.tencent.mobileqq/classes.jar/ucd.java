import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ucd
  extends TroopObserver
{
  public ucd(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList, int paramInt, long paramLong)
  {
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Ucf.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_Ucf.getCount() != 0) {
        break label209;
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 0).edit().putLong("key_last_update_time" + this.a.jdField_a_of_type_JavaLangString, System.currentTimeMillis()).commit();
      ThreadManager.post(new uce(this, (TroopGagMgr)this.a.app.getManager(47)), 8, null, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopGagActivity", 2, "onUpdateTroopGetMemberList: isSuccess=" + paramBoolean);
      return;
      label209:
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucd
 * JD-Core Version:    0.7.0.1
 */