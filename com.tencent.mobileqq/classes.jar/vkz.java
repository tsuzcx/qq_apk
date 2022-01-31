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

public class vkz
{
  private static void a(Context paramContext, vkm paramvkm, vij paramvij)
  {
    try
    {
      ncr.a(paramContext, paramvkm.jdField_a_of_type_JavaLangString);
      if (paramvij != null) {
        paramvij.a(paramvkm);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramvij == null) {}
      paramvij.b(paramvkm);
    }
  }
  
  public static void a(Context paramContext, vkn paramvkn, vij paramvij)
  {
    wxe.b("StoryBasicShareUtils", "share() data = %s", paramvkn.toString());
    if ((paramvkn instanceof vko))
    {
      a(paramContext, (vko)paramvkn, paramvij);
      return;
    }
    if ((paramvkn instanceof vkm))
    {
      a(paramContext, (vkm)paramvkn, paramvij);
      return;
    }
    if ((paramvkn instanceof vkp))
    {
      a(paramContext, (vkp)paramvkn, paramvij);
      return;
    }
    if ((paramvkn instanceof vkr))
    {
      paramContext = (vkr)paramvkn;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramvij);
      return;
    }
    if ((paramvkn instanceof vkq))
    {
      a(paramContext, (vkq)paramvkn, paramvij);
      return;
    }
    paramvij.a(paramvkn);
  }
  
  private static void a(Context paramContext, vko paramvko, vij paramvij)
  {
    switch (paramvko.b)
    {
    default: 
      return;
    case 0: 
      paramvij = new MessageForQQStory();
      paramvij.authorName = paramvko.i;
      paramvij.brief = paramvko.jdField_d_of_type_JavaLangString;
      paramvij.briefBgColor = paramvko.jdField_c_of_type_Int;
      paramvij.coverImgUrl = paramvko.jdField_a_of_type_JavaLangString;
      paramvij.logoImgUrl = paramvko.jdField_c_of_type_JavaLangString;
      paramvij.msgAction = paramvko.h;
      paramvij.srcAction = paramvko.g;
      paramvij.srcName = paramvko.f;
      paramvij.type = paramvko.jdField_e_of_type_Int;
      paramvij.mVid = paramvko.jdField_e_of_type_JavaLangString;
      paramvij.storyTitle = paramvko.o;
      paramvij.storyBrief = paramvko.p;
      bcxl.a((Activity)paramContext, paramvij, 29782);
      return;
    case 1: 
      if (bdna.a(paramContext, 29, paramvko.jdField_d_of_type_Int, "web_share", paramvko.n, paramvko.jdField_a_of_type_JavaLangString, paramvko.k, paramvko.l, paramvko.jdField_d_of_type_JavaLangString, paramvko.jdField_a_of_type_JavaLangString, "plugin", null, paramvko.h, paramvko.h, "plugin", null, paramvko.g, paramvko.g, null, paramvko.f, null, paramvko.m, true))
      {
        paramvij.a(paramvko);
        return;
      }
      paramvij.b(paramvko);
      return;
    }
    bdna.a(paramContext, 1001, 1, "web_share", "", paramvko.jdField_a_of_type_JavaLangString, paramvko.k, paramvko.l, paramvko.jdField_d_of_type_JavaLangString, paramvko.h, "web", null, null, null, "plugin", paramvko.g, null, null, null, paramvko.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, vkp paramvkp, vij paramvij)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramvkp.jdField_c_of_type_JavaLangString))
    {
      localObject = paramvkp.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramvkp.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramvkp.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramvkp.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramvkp.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bjev.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramvij != null) {
        paramvij.a(paramvkp);
      }
    }
    label151:
    label159:
    while (paramvij == null)
    {
      return;
      localObject = paramvkp.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramvkp.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramvij.b(paramvkp);
  }
  
  private static void a(Context paramContext, vkq paramvkq, vij paramvij)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramvkq, paramContext, paramvij));
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
            Object localObject1 = URLEncoder.encode(paramvkq.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "http://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramvkq.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramvkq.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramvkq.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramvij == null);
          paramvij.a(paramvkq);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramvij == null);
      paramvij.b(paramvkq);
    }
  }
  
  private static void a(vkr paramvkr, boolean paramBoolean, vij paramvij)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramvij = new vla(str1, paramvij, paramvkr);
    WXShareHelper.a().a(paramvij);
    paramvij = WXShareHelper.a();
    String str2 = paramvkr.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramvkr.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramvkr.jdField_c_of_type_JavaLangString;
    paramvkr = paramvkr.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramvij.b(str1, str2, localBitmap, str3, paramvkr, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */