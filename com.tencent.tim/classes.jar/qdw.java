import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.net.URLEncoder;
import java.util.ArrayList;

public class qdw
{
  private static void a(Context paramContext, qdj paramqdj, qbj paramqbj)
  {
    try
    {
      jpr.aD(paramContext, paramqdj.url);
      if (paramqbj != null) {
        paramqbj.a(paramqdj);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramqbj == null) {}
      paramqbj.b(paramqdj);
    }
  }
  
  public static void a(Context paramContext, qdk paramqdk, qbj paramqbj)
  {
    ram.d("StoryBasicShareUtils", "share() data = %s", paramqdk.toString());
    if ((paramqdk instanceof qdl))
    {
      a(paramContext, (qdl)paramqdk, paramqbj);
      return;
    }
    if ((paramqdk instanceof qdj))
    {
      a(paramContext, (qdj)paramqdk, paramqbj);
      return;
    }
    if ((paramqdk instanceof qdm))
    {
      a(paramContext, (qdm)paramqdk, paramqbj);
      return;
    }
    if ((paramqdk instanceof qdo))
    {
      paramContext = (qdo)paramqdk;
      a(paramContext, paramContext.isCircle, paramqbj);
      return;
    }
    if ((paramqdk instanceof qdn))
    {
      a(paramContext, (qdn)paramqdk, paramqbj);
      return;
    }
    paramqbj.a(paramqdk);
  }
  
  private static void a(Context paramContext, qdl paramqdl, qbj paramqbj)
  {
    switch (paramqdl.blM)
    {
    default: 
      return;
    case 0: 
      paramqbj = new MessageForQQStory();
      paramqbj.authorName = paramqdl.authorName;
      paramqbj.brief = paramqdl.brief;
      paramqbj.briefBgColor = paramqdl.briefBgColor;
      paramqbj.coverImgUrl = paramqdl.imgUrl;
      paramqbj.logoImgUrl = paramqdl.logoImgUrl;
      paramqbj.msgAction = paramqdl.msgAction;
      paramqbj.srcAction = paramqdl.srcAction;
      paramqbj.srcName = paramqdl.srcName;
      paramqbj.type = paramqdl.type;
      paramqbj.mVid = paramqdl.mVid;
      paramqbj.storyTitle = paramqdl.storyTitle;
      paramqbj.storyBrief = paramqdl.storyBrief;
      apzg.a((Activity)paramContext, paramqbj, 29782);
      return;
    case 1: 
      if (aqmf.a(paramContext, 29, paramqdl.shareType, "web_share", paramqdl.awT, paramqdl.imgUrl, paramqdl.title, paramqdl.summary, paramqdl.brief, paramqdl.imgUrl, "plugin", null, paramqdl.msgAction, paramqdl.msgAction, "plugin", null, paramqdl.srcAction, paramqdl.srcAction, null, paramqdl.srcName, null, paramqdl.compatibleText, true))
      {
        paramqbj.a(paramqdl);
        return;
      }
      paramqbj.b(paramqdl);
      return;
    }
    aqmf.a(paramContext, 1001, 1, "web_share", "", paramqdl.imgUrl, paramqdl.title, paramqdl.summary, paramqdl.brief, paramqdl.msgAction, "web", null, null, null, "plugin", paramqdl.srcAction, null, null, null, paramqdl.srcName, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, qdm paramqdm, qbj paramqbj)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramqdm.title))
    {
      localObject = paramqdm.url;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramqdm.summary)) {
        break label151;
      }
      localObject = paramqdm.url;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramqdm.url);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramqdm.imageUrl);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!avqq.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramqbj != null) {
        paramqbj.a(paramqdm);
      }
    }
    label151:
    label159:
    while (paramqbj == null)
    {
      return;
      localObject = paramqdm.title;
      break;
      localObject = paramqdm.summary;
      break label58;
    }
    paramqbj.b(paramqdm);
  }
  
  private static void a(Context paramContext, qdn paramqdn, qbj paramqbj)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramqdn, paramContext, paramqbj));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      do
      {
        try
        {
          do
          {
            Object localObject1 = URLEncoder.encode(paramqdn.title, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramqdn.url, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramqdn.imageUrl))
            {
              localObject1 = URLEncoder.encode(paramqdn.imageUrl, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramqbj == null);
          paramqbj.a(paramqdn);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramqbj == null);
      paramqbj.b(paramqdn);
    }
  }
  
  private static void a(qdo paramqdo, boolean paramBoolean, qbj paramqbj)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramqbj = new qdx(str1, paramqbj, paramqdo);
    WXShareHelper.a().a(paramqbj);
    paramqbj = WXShareHelper.a();
    String str2 = paramqdo.title;
    Bitmap localBitmap = paramqdo.cq;
    String str3 = paramqdo.summary;
    paramqdo = paramqdo.url;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramqbj.a(str1, str2, localBitmap, str3, paramqdo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdw
 * JD-Core Version:    0.7.0.1
 */