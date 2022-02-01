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
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;

public class wjw
{
  private static void a(Context paramContext, wjj paramwjj, whg paramwhg)
  {
    try
    {
      nou.a(paramContext, paramwjj.jdField_a_of_type_JavaLangString);
      if (paramwhg != null) {
        paramwhg.a(paramwjj);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramwhg == null) {}
      paramwhg.b(paramwjj);
    }
  }
  
  public static void a(Context paramContext, wjk paramwjk, whg paramwhg)
  {
    xvv.b("StoryBasicShareUtils", "share() data = %s", paramwjk.toString());
    if ((paramwjk instanceof wjl))
    {
      a(paramContext, (wjl)paramwjk, paramwhg);
      return;
    }
    if ((paramwjk instanceof wjj))
    {
      a(paramContext, (wjj)paramwjk, paramwhg);
      return;
    }
    if ((paramwjk instanceof wjm))
    {
      a(paramContext, (wjm)paramwjk, paramwhg);
      return;
    }
    if ((paramwjk instanceof wjo))
    {
      paramContext = (wjo)paramwjk;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramwhg);
      return;
    }
    if ((paramwjk instanceof wjn))
    {
      a(paramContext, (wjn)paramwjk, paramwhg);
      return;
    }
    paramwhg.a(paramwjk);
  }
  
  private static void a(Context paramContext, wjl paramwjl, whg paramwhg)
  {
    switch (paramwjl.b)
    {
    default: 
      return;
    case 0: 
      paramwhg = new MessageForQQStory();
      paramwhg.authorName = paramwjl.i;
      paramwhg.brief = paramwjl.jdField_d_of_type_JavaLangString;
      paramwhg.briefBgColor = paramwjl.jdField_c_of_type_Int;
      paramwhg.coverImgUrl = paramwjl.jdField_a_of_type_JavaLangString;
      paramwhg.logoImgUrl = paramwjl.jdField_c_of_type_JavaLangString;
      paramwhg.msgAction = paramwjl.h;
      paramwhg.srcAction = paramwjl.g;
      paramwhg.srcName = paramwjl.f;
      paramwhg.type = paramwjl.jdField_e_of_type_Int;
      paramwhg.mVid = paramwjl.jdField_e_of_type_JavaLangString;
      paramwhg.storyTitle = paramwjl.o;
      paramwhg.storyBrief = paramwjl.p;
      bflj.a((Activity)paramContext, paramwhg, 29782);
      return;
    case 1: 
      if (bfyv.a(paramContext, 29, paramwjl.jdField_d_of_type_Int, "web_share", paramwjl.n, paramwjl.jdField_a_of_type_JavaLangString, paramwjl.k, paramwjl.l, paramwjl.jdField_d_of_type_JavaLangString, paramwjl.jdField_a_of_type_JavaLangString, "plugin", null, paramwjl.h, paramwjl.h, "plugin", null, paramwjl.g, paramwjl.g, null, paramwjl.f, null, paramwjl.m, true))
      {
        paramwhg.a(paramwjl);
        return;
      }
      paramwhg.b(paramwjl);
      return;
    }
    bfyv.a(paramContext, 1001, 1, "web_share", "", paramwjl.jdField_a_of_type_JavaLangString, paramwjl.k, paramwjl.l, paramwjl.jdField_d_of_type_JavaLangString, paramwjl.h, "web", null, null, null, "plugin", paramwjl.g, null, null, null, paramwjl.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, wjm paramwjm, whg paramwhg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramwjm.jdField_c_of_type_JavaLangString))
    {
      localObject = paramwjm.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramwjm.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramwjm.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramwjm.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramwjm.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!QZoneShareManager.jumpToQzoneShare(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramwhg != null) {
        paramwhg.a(paramwjm);
      }
    }
    label151:
    label159:
    while (paramwhg == null)
    {
      return;
      localObject = paramwjm.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramwjm.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramwhg.b(paramwjm);
  }
  
  private static void a(Context paramContext, wjn paramwjn, whg paramwhg)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramwjn, paramContext, paramwhg));
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
            Object localObject1 = URLEncoder.encode(paramwjn.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramwjn.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramwjn.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramwjn.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramwhg == null);
          paramwhg.a(paramwjn);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramwhg == null);
      paramwhg.b(paramwjn);
    }
  }
  
  private static void a(wjo paramwjo, boolean paramBoolean, whg paramwhg)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramwhg = new wjx(str1, paramwhg, paramwjo);
    WXShareHelper.getInstance().addObserver(paramwhg);
    paramwhg = WXShareHelper.getInstance();
    String str2 = paramwjo.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramwjo.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramwjo.jdField_c_of_type_JavaLangString;
    paramwjo = paramwjo.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramwhg.shareWebPage(str1, str2, localBitmap, str3, paramwjo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */