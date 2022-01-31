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

public class tsb
{
  private static void a(Context paramContext, tro paramtro, tpl paramtpl)
  {
    try
    {
      naa.a(paramContext, paramtro.jdField_a_of_type_JavaLangString);
      if (paramtpl != null) {
        paramtpl.a(paramtro);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramtpl == null) {}
      paramtpl.b(paramtro);
    }
  }
  
  public static void a(Context paramContext, trp paramtrp, tpl paramtpl)
  {
    veg.b("StoryBasicShareUtils", "share() data = %s", paramtrp.toString());
    if ((paramtrp instanceof trq))
    {
      a(paramContext, (trq)paramtrp, paramtpl);
      return;
    }
    if ((paramtrp instanceof tro))
    {
      a(paramContext, (tro)paramtrp, paramtpl);
      return;
    }
    if ((paramtrp instanceof trr))
    {
      a(paramContext, (trr)paramtrp, paramtpl);
      return;
    }
    if ((paramtrp instanceof trt))
    {
      paramContext = (trt)paramtrp;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramtpl);
      return;
    }
    if ((paramtrp instanceof trs))
    {
      a(paramContext, (trs)paramtrp, paramtpl);
      return;
    }
    paramtpl.a(paramtrp);
  }
  
  private static void a(Context paramContext, trq paramtrq, tpl paramtpl)
  {
    switch (paramtrq.b)
    {
    default: 
      return;
    case 0: 
      paramtpl = new MessageForQQStory();
      paramtpl.authorName = paramtrq.i;
      paramtpl.brief = paramtrq.jdField_d_of_type_JavaLangString;
      paramtpl.briefBgColor = paramtrq.jdField_c_of_type_Int;
      paramtpl.coverImgUrl = paramtrq.jdField_a_of_type_JavaLangString;
      paramtpl.logoImgUrl = paramtrq.jdField_c_of_type_JavaLangString;
      paramtpl.msgAction = paramtrq.h;
      paramtpl.srcAction = paramtrq.g;
      paramtpl.srcName = paramtrq.f;
      paramtpl.type = paramtrq.jdField_e_of_type_Int;
      paramtpl.mVid = paramtrq.jdField_e_of_type_JavaLangString;
      paramtpl.storyTitle = paramtrq.o;
      paramtpl.storyBrief = paramtrq.p;
      batu.a((Activity)paramContext, paramtpl, 29782);
      return;
    case 1: 
      if (bbjj.a(paramContext, 29, paramtrq.jdField_d_of_type_Int, "web_share", paramtrq.n, paramtrq.jdField_a_of_type_JavaLangString, paramtrq.k, paramtrq.l, paramtrq.jdField_d_of_type_JavaLangString, paramtrq.jdField_a_of_type_JavaLangString, "plugin", null, paramtrq.h, paramtrq.h, "plugin", null, paramtrq.g, paramtrq.g, null, paramtrq.f, null, paramtrq.m, true))
      {
        paramtpl.a(paramtrq);
        return;
      }
      paramtpl.b(paramtrq);
      return;
    }
    bbjj.a(paramContext, 1001, 1, "web_share", "", paramtrq.jdField_a_of_type_JavaLangString, paramtrq.k, paramtrq.l, paramtrq.jdField_d_of_type_JavaLangString, paramtrq.h, "web", null, null, null, "plugin", paramtrq.g, null, null, null, paramtrq.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, trr paramtrr, tpl paramtpl)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramtrr.jdField_c_of_type_JavaLangString))
    {
      localObject = paramtrr.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramtrr.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramtrr.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramtrr.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramtrr.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bgyu.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramtpl != null) {
        paramtpl.a(paramtrr);
      }
    }
    label151:
    label159:
    while (paramtpl == null)
    {
      return;
      localObject = paramtrr.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramtrr.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramtpl.b(paramtrr);
  }
  
  private static void a(Context paramContext, trs paramtrs, tpl paramtpl)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramtrs, paramContext, paramtpl));
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
            Object localObject1 = URLEncoder.encode(paramtrs.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "http://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramtrs.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramtrs.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramtrs.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramtpl == null);
          paramtpl.a(paramtrs);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramtpl == null);
      paramtpl.b(paramtrs);
    }
  }
  
  private static void a(trt paramtrt, boolean paramBoolean, tpl paramtpl)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramtpl = new tsc(str1, paramtpl, paramtrt);
    WXShareHelper.a().a(paramtpl);
    paramtpl = WXShareHelper.a();
    String str2 = paramtrt.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramtrt.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramtrt.jdField_c_of_type_JavaLangString;
    paramtrt = paramtrt.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramtpl.b(str1, str2, localBitmap, str3, paramtrt, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */