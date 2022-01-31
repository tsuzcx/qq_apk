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

public class try
{
  private static void a(Context paramContext, trl paramtrl, tpi paramtpi)
  {
    try
    {
      mzx.a(paramContext, paramtrl.jdField_a_of_type_JavaLangString);
      if (paramtpi != null) {
        paramtpi.a(paramtrl);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramtpi == null) {}
      paramtpi.b(paramtrl);
    }
  }
  
  public static void a(Context paramContext, trm paramtrm, tpi paramtpi)
  {
    ved.b("StoryBasicShareUtils", "share() data = %s", paramtrm.toString());
    if ((paramtrm instanceof trn))
    {
      a(paramContext, (trn)paramtrm, paramtpi);
      return;
    }
    if ((paramtrm instanceof trl))
    {
      a(paramContext, (trl)paramtrm, paramtpi);
      return;
    }
    if ((paramtrm instanceof tro))
    {
      a(paramContext, (tro)paramtrm, paramtpi);
      return;
    }
    if ((paramtrm instanceof trq))
    {
      paramContext = (trq)paramtrm;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramtpi);
      return;
    }
    if ((paramtrm instanceof trp))
    {
      a(paramContext, (trp)paramtrm, paramtpi);
      return;
    }
    paramtpi.a(paramtrm);
  }
  
  private static void a(Context paramContext, trn paramtrn, tpi paramtpi)
  {
    switch (paramtrn.b)
    {
    default: 
      return;
    case 0: 
      paramtpi = new MessageForQQStory();
      paramtpi.authorName = paramtrn.i;
      paramtpi.brief = paramtrn.jdField_d_of_type_JavaLangString;
      paramtpi.briefBgColor = paramtrn.jdField_c_of_type_Int;
      paramtpi.coverImgUrl = paramtrn.jdField_a_of_type_JavaLangString;
      paramtpi.logoImgUrl = paramtrn.jdField_c_of_type_JavaLangString;
      paramtpi.msgAction = paramtrn.h;
      paramtpi.srcAction = paramtrn.g;
      paramtpi.srcName = paramtrn.f;
      paramtpi.type = paramtrn.jdField_e_of_type_Int;
      paramtpi.mVid = paramtrn.jdField_e_of_type_JavaLangString;
      paramtpi.storyTitle = paramtrn.o;
      paramtpi.storyBrief = paramtrn.p;
      baui.a((Activity)paramContext, paramtpi, 29782);
      return;
    case 1: 
      if (bbjx.a(paramContext, 29, paramtrn.jdField_d_of_type_Int, "web_share", paramtrn.n, paramtrn.jdField_a_of_type_JavaLangString, paramtrn.k, paramtrn.l, paramtrn.jdField_d_of_type_JavaLangString, paramtrn.jdField_a_of_type_JavaLangString, "plugin", null, paramtrn.h, paramtrn.h, "plugin", null, paramtrn.g, paramtrn.g, null, paramtrn.f, null, paramtrn.m, true))
      {
        paramtpi.a(paramtrn);
        return;
      }
      paramtpi.b(paramtrn);
      return;
    }
    bbjx.a(paramContext, 1001, 1, "web_share", "", paramtrn.jdField_a_of_type_JavaLangString, paramtrn.k, paramtrn.l, paramtrn.jdField_d_of_type_JavaLangString, paramtrn.h, "web", null, null, null, "plugin", paramtrn.g, null, null, null, paramtrn.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, tro paramtro, tpi paramtpi)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramtro.jdField_c_of_type_JavaLangString))
    {
      localObject = paramtro.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramtro.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramtro.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramtro.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramtro.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bgzl.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramtpi != null) {
        paramtpi.a(paramtro);
      }
    }
    label151:
    label159:
    while (paramtpi == null)
    {
      return;
      localObject = paramtro.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramtro.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramtpi.b(paramtro);
  }
  
  private static void a(Context paramContext, trp paramtrp, tpi paramtpi)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramtrp, paramContext, paramtpi));
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
            Object localObject1 = URLEncoder.encode(paramtrp.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "http://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramtrp.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramtrp.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramtrp.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramtpi == null);
          paramtpi.a(paramtrp);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramtpi == null);
      paramtpi.b(paramtrp);
    }
  }
  
  private static void a(trq paramtrq, boolean paramBoolean, tpi paramtpi)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramtpi = new trz(str1, paramtpi, paramtrq);
    WXShareHelper.a().a(paramtpi);
    paramtpi = WXShareHelper.a();
    String str2 = paramtrq.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramtrq.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramtrq.jdField_c_of_type_JavaLangString;
    paramtrq = paramtrq.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramtpi.b(str1, str2, localBitmap, str3, paramtrq, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     try
 * JD-Core Version:    0.7.0.1
 */