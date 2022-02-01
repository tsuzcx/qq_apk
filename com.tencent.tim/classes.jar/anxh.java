import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;

public final class anxh
{
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new QZoneShareData();
    paramBundle.mTitle = localBundle.getString("title");
    paramBundle.mSummary = localBundle.getString("summary");
    String str = localBundle.getString("imageUrl");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(str);
    paramBundle.ER = localArrayList;
    paramBundle.targetUrl = localBundle.getString("targetUrl");
    paramBundle.iUrlInfoFrm = -1;
    paramBundle.azQ = System.currentTimeMillis();
    paramBundle.from = 0;
    avqq.a(paramActivity, paramString, paramBundle, null, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent, String paramString)
  {
    QLog.d(paramString, 2, "handleShareToFriend: resultCode=" + paramInt);
    paramActivity.setResult(paramInt);
  }
  
  public static void d(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Object localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    String str1 = ((Bundle)localObject).getString("title");
    String str2 = ((Bundle)localObject).getString("summary");
    String str3 = ((Bundle)localObject).getString("imageUrl");
    String str4 = ((Bundle)localObject).getString("targetUrl");
    String str5 = ((Bundle)localObject).getString("sourceName");
    String str6 = ((Bundle)localObject).getString("iconUrl");
    localObject = ((Bundle)localObject).getString("sourceUrl");
    String str7 = paramActivity.getString(2131698632, new Object[] { str1 });
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramBundle = " ";; paramBundle = "web")
    {
      aqmf.a(paramActivity, 1001, 1, "web_share", "", str3, str1, str2, str7, str4, "web", null, null, null, paramBundle, null, null, null, str6, str5, "", null, paramInt, (String)localObject, -1L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxh
 * JD-Core Version:    0.7.0.1
 */