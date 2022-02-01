import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSNavigateTo;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class lvt
  implements IPTSNavigateTo
{
  private final String TAG = "PTSNavigateToModule";
  
  public void navigateTo(String paramString)
  {
    QLog.i("PTSNavigateToModule", 1, "[navigateTo], url = " + paramString);
    paramString = Pattern.compile("\\/").split(paramString);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[(paramString.length - 1)];
      Intent localIntent = new Intent();
      localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", paramString);
      PublicFragmentActivity.start(BaseActivity.sTopActivity, localIntent, PTSFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvt
 * JD-Core Version:    0.7.0.1
 */