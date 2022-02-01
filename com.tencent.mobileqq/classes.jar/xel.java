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

public class xel
{
  private static void a(Context paramContext, xdy paramxdy, xbv paramxbv)
  {
    try
    {
      nlk.a(paramContext, paramxdy.jdField_a_of_type_JavaLangString);
      if (paramxbv != null) {
        paramxbv.a(paramxdy);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramxbv == null) {}
      paramxbv.b(paramxdy);
    }
  }
  
  public static void a(Context paramContext, xdz paramxdz, xbv paramxbv)
  {
    yqp.b("StoryBasicShareUtils", "share() data = %s", paramxdz.toString());
    if ((paramxdz instanceof xea))
    {
      a(paramContext, (xea)paramxdz, paramxbv);
      return;
    }
    if ((paramxdz instanceof xdy))
    {
      a(paramContext, (xdy)paramxdz, paramxbv);
      return;
    }
    if ((paramxdz instanceof xeb))
    {
      a(paramContext, (xeb)paramxdz, paramxbv);
      return;
    }
    if ((paramxdz instanceof xed))
    {
      paramContext = (xed)paramxdz;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramxbv);
      return;
    }
    if ((paramxdz instanceof xec))
    {
      a(paramContext, (xec)paramxdz, paramxbv);
      return;
    }
    paramxbv.a(paramxdz);
  }
  
  private static void a(Context paramContext, xea paramxea, xbv paramxbv)
  {
    switch (paramxea.b)
    {
    default: 
      return;
    case 0: 
      paramxbv = new MessageForQQStory();
      paramxbv.authorName = paramxea.i;
      paramxbv.brief = paramxea.jdField_d_of_type_JavaLangString;
      paramxbv.briefBgColor = paramxea.jdField_c_of_type_Int;
      paramxbv.coverImgUrl = paramxea.jdField_a_of_type_JavaLangString;
      paramxbv.logoImgUrl = paramxea.jdField_c_of_type_JavaLangString;
      paramxbv.msgAction = paramxea.h;
      paramxbv.srcAction = paramxea.g;
      paramxbv.srcName = paramxea.f;
      paramxbv.type = paramxea.jdField_e_of_type_Int;
      paramxbv.mVid = paramxea.jdField_e_of_type_JavaLangString;
      paramxbv.storyTitle = paramxea.o;
      paramxbv.storyBrief = paramxea.p;
      bgbw.a((Activity)paramContext, paramxbv, 29782);
      return;
    case 1: 
      if (bgsc.a(paramContext, 29, paramxea.jdField_d_of_type_Int, "web_share", paramxea.n, paramxea.jdField_a_of_type_JavaLangString, paramxea.k, paramxea.l, paramxea.jdField_d_of_type_JavaLangString, paramxea.jdField_a_of_type_JavaLangString, "plugin", null, paramxea.h, paramxea.h, "plugin", null, paramxea.g, paramxea.g, null, paramxea.f, null, paramxea.m, true))
      {
        paramxbv.a(paramxea);
        return;
      }
      paramxbv.b(paramxea);
      return;
    }
    bgsc.a(paramContext, 1001, 1, "web_share", "", paramxea.jdField_a_of_type_JavaLangString, paramxea.k, paramxea.l, paramxea.jdField_d_of_type_JavaLangString, paramxea.h, "web", null, null, null, "plugin", paramxea.g, null, null, null, paramxea.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, xeb paramxeb, xbv paramxbv)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramxeb.jdField_c_of_type_JavaLangString))
    {
      localObject = paramxeb.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramxeb.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramxeb.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramxeb.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramxeb.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bltb.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramxbv != null) {
        paramxbv.a(paramxeb);
      }
    }
    label151:
    label159:
    while (paramxbv == null)
    {
      return;
      localObject = paramxeb.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramxeb.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramxbv.b(paramxeb);
  }
  
  private static void a(Context paramContext, xec paramxec, xbv paramxbv)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramxec, paramContext, paramxbv));
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
            Object localObject1 = URLEncoder.encode(paramxec.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramxec.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramxec.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramxec.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramxbv == null);
          paramxbv.a(paramxec);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramxbv == null);
      paramxbv.b(paramxec);
    }
  }
  
  private static void a(xed paramxed, boolean paramBoolean, xbv paramxbv)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramxbv = new xem(str1, paramxbv, paramxed);
    WXShareHelper.a().a(paramxbv);
    paramxbv = WXShareHelper.a();
    String str2 = paramxed.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramxed.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramxed.jdField_c_of_type_JavaLangString;
    paramxed = paramxed.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramxbv.b(str1, str2, localBitmap, str3, paramxed, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xel
 * JD-Core Version:    0.7.0.1
 */