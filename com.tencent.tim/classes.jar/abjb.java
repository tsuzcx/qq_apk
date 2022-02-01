import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class abjb
  extends aqrd
{
  public abjb(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  protected void onGetExploreMsg(boolean paramBoolean, Object paramObject)
  {
    super.onGetExploreMsg(paramBoolean, paramObject);
    if (paramBoolean) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        QQSettingMe localQQSettingMe = (QQSettingMe)SettingMeApolloViewController.a(this.this$0).get();
        if (localQQSettingMe == null) {
          return;
        }
        QQAppInterface localQQAppInterface = localQQSettingMe.getApp();
        if (localQQAppInterface == null) {
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.this$0).get();
        if (localViewGroup == null) {
          return;
        }
        Object localObject = new JSONObject((String)paramObject);
        if (((JSONObject)localObject).optInt("entry_id", -1) != 1) {
          return;
        }
        localObject = new abkz(localQQAppInterface, (JSONObject)localObject, localQQSettingMe);
        this.this$0.a.a((abkx)localObject);
        if ((localQQSettingMe.isResume()) && (SettingMeApolloViewController.a(this.this$0) > 0)) {
          this.this$0.a.a(SettingMeApolloViewController.a(this.this$0), localViewGroup.getContext(), localQQAppInterface, this.this$0.mRoleId);
        }
        QLog.d("SettingMeApolloViewController", 2, "[onGetExploreMsg] onGetExploreMsg data:" + paramObject.toString());
        return;
      }
      catch (Exception paramObject) {}
    } else {
      QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjb
 * JD-Core Version:    0.7.0.1
 */