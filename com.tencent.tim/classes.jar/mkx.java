import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class mkx
  implements IPTSLiteEventListener
{
  mkx(mkw parammkw) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[onTapEventTriggered], identifier is empty.");
    }
    do
    {
      do
      {
        return;
        if (TextUtils.equals(paramString, "editPersonalProfile"))
        {
          RIJUGCAddAccountFragment.ca(mkw.a(this.b));
          RIJUGCAddAccountFragment.rU(RIJUGCAddAccountFragment.aTD);
          return;
        }
      } while (!TextUtils.equals(paramString, "useOriginalAccount"));
      RIJUGCAddAccountFragment.bZ(mkw.a(this.b));
      RIJUGCAddAccountFragment.rU(RIJUGCAddAccountFragment.aTC);
    } while (!(mkw.a(this.b) instanceof BaseActivity));
    ((BaseActivity)mkw.a(this.b)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkx
 * JD-Core Version:    0.7.0.1
 */