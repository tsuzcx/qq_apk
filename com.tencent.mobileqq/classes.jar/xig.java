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

public class xig
{
  private static void a(Context paramContext, xht paramxht, xfq paramxfq)
  {
    try
    {
      nnf.a(paramContext, paramxht.jdField_a_of_type_JavaLangString);
      if (paramxfq != null) {
        paramxfq.a(paramxht);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramxfq == null) {}
      paramxfq.b(paramxht);
    }
  }
  
  public static void a(Context paramContext, xhu paramxhu, xfq paramxfq)
  {
    yuk.b("StoryBasicShareUtils", "share() data = %s", paramxhu.toString());
    if ((paramxhu instanceof xhv))
    {
      a(paramContext, (xhv)paramxhu, paramxfq);
      return;
    }
    if ((paramxhu instanceof xht))
    {
      a(paramContext, (xht)paramxhu, paramxfq);
      return;
    }
    if ((paramxhu instanceof xhw))
    {
      a(paramContext, (xhw)paramxhu, paramxfq);
      return;
    }
    if ((paramxhu instanceof xhy))
    {
      paramContext = (xhy)paramxhu;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramxfq);
      return;
    }
    if ((paramxhu instanceof xhx))
    {
      a(paramContext, (xhx)paramxhu, paramxfq);
      return;
    }
    paramxfq.a(paramxhu);
  }
  
  private static void a(Context paramContext, xhv paramxhv, xfq paramxfq)
  {
    switch (paramxhv.b)
    {
    default: 
      return;
    case 0: 
      paramxfq = new MessageForQQStory();
      paramxfq.authorName = paramxhv.i;
      paramxfq.brief = paramxhv.jdField_d_of_type_JavaLangString;
      paramxfq.briefBgColor = paramxhv.jdField_c_of_type_Int;
      paramxfq.coverImgUrl = paramxhv.jdField_a_of_type_JavaLangString;
      paramxfq.logoImgUrl = paramxhv.jdField_c_of_type_JavaLangString;
      paramxfq.msgAction = paramxhv.h;
      paramxfq.srcAction = paramxhv.g;
      paramxfq.srcName = paramxhv.f;
      paramxfq.type = paramxhv.jdField_e_of_type_Int;
      paramxfq.mVid = paramxhv.jdField_e_of_type_JavaLangString;
      paramxfq.storyTitle = paramxhv.o;
      paramxfq.storyBrief = paramxhv.p;
      bhbx.a((Activity)paramContext, paramxfq, 29782);
      return;
    case 1: 
      if (bhse.a(paramContext, 29, paramxhv.jdField_d_of_type_Int, "web_share", paramxhv.n, paramxhv.jdField_a_of_type_JavaLangString, paramxhv.k, paramxhv.l, paramxhv.jdField_d_of_type_JavaLangString, paramxhv.jdField_a_of_type_JavaLangString, "plugin", null, paramxhv.h, paramxhv.h, "plugin", null, paramxhv.g, paramxhv.g, null, paramxhv.f, null, paramxhv.m, true))
      {
        paramxfq.a(paramxhv);
        return;
      }
      paramxfq.b(paramxhv);
      return;
    }
    bhse.a(paramContext, 1001, 1, "web_share", "", paramxhv.jdField_a_of_type_JavaLangString, paramxhv.k, paramxhv.l, paramxhv.jdField_d_of_type_JavaLangString, paramxhv.h, "web", null, null, null, "plugin", paramxhv.g, null, null, null, paramxhv.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, xhw paramxhw, xfq paramxfq)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramxhw.jdField_c_of_type_JavaLangString))
    {
      localObject = paramxhw.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramxhw.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramxhw.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramxhw.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramxhw.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bmud.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramxfq != null) {
        paramxfq.a(paramxhw);
      }
    }
    label151:
    label159:
    while (paramxfq == null)
    {
      return;
      localObject = paramxhw.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramxhw.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramxfq.b(paramxhw);
  }
  
  private static void a(Context paramContext, xhx paramxhx, xfq paramxfq)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramxhx, paramContext, paramxfq));
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
            Object localObject1 = URLEncoder.encode(paramxhx.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramxhx.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramxhx.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramxhx.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramxfq == null);
          paramxfq.a(paramxhx);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramxfq == null);
      paramxfq.b(paramxhx);
    }
  }
  
  private static void a(xhy paramxhy, boolean paramBoolean, xfq paramxfq)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramxfq = new xih(str1, paramxfq, paramxhy);
    WXShareHelper.a().a(paramxfq);
    paramxfq = WXShareHelper.a();
    String str2 = paramxhy.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramxhy.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramxhy.jdField_c_of_type_JavaLangString;
    paramxhy = paramxhy.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramxfq.b(str1, str2, localBitmap, str3, paramxhy, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xig
 * JD-Core Version:    0.7.0.1
 */