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

public class wyr
{
  private static void a(Context paramContext, wye paramwye, wwb paramwwb)
  {
    try
    {
      nvv.a(paramContext, paramwye.jdField_a_of_type_JavaLangString);
      if (paramwwb != null) {
        paramwwb.a(paramwye);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramwwb == null) {}
      paramwwb.b(paramwye);
    }
  }
  
  public static void a(Context paramContext, wyf paramwyf, wwb paramwwb)
  {
    ykq.b("StoryBasicShareUtils", "share() data = %s", paramwyf.toString());
    if ((paramwyf instanceof wyg))
    {
      a(paramContext, (wyg)paramwyf, paramwwb);
      return;
    }
    if ((paramwyf instanceof wye))
    {
      a(paramContext, (wye)paramwyf, paramwwb);
      return;
    }
    if ((paramwyf instanceof wyh))
    {
      a(paramContext, (wyh)paramwyf, paramwwb);
      return;
    }
    if ((paramwyf instanceof wyj))
    {
      paramContext = (wyj)paramwyf;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramwwb);
      return;
    }
    if ((paramwyf instanceof wyi))
    {
      a(paramContext, (wyi)paramwyf, paramwwb);
      return;
    }
    paramwwb.a(paramwyf);
  }
  
  private static void a(Context paramContext, wyg paramwyg, wwb paramwwb)
  {
    switch (paramwyg.b)
    {
    default: 
      return;
    case 0: 
      paramwwb = new MessageForQQStory();
      paramwwb.authorName = paramwyg.i;
      paramwwb.brief = paramwyg.jdField_d_of_type_JavaLangString;
      paramwwb.briefBgColor = paramwyg.jdField_c_of_type_Int;
      paramwwb.coverImgUrl = paramwyg.jdField_a_of_type_JavaLangString;
      paramwwb.logoImgUrl = paramwyg.jdField_c_of_type_JavaLangString;
      paramwwb.msgAction = paramwyg.h;
      paramwwb.srcAction = paramwyg.g;
      paramwwb.srcName = paramwyg.f;
      paramwwb.type = paramwyg.jdField_e_of_type_Int;
      paramwwb.mVid = paramwyg.jdField_e_of_type_JavaLangString;
      paramwwb.storyTitle = paramwyg.o;
      paramwwb.storyBrief = paramwyg.p;
      bgua.a((Activity)paramContext, paramwwb, 29782);
      return;
    case 1: 
      if (bhhn.a(paramContext, 29, paramwyg.jdField_d_of_type_Int, "web_share", paramwyg.n, paramwyg.jdField_a_of_type_JavaLangString, paramwyg.k, paramwyg.l, paramwyg.jdField_d_of_type_JavaLangString, paramwyg.jdField_a_of_type_JavaLangString, "plugin", null, paramwyg.h, paramwyg.h, "plugin", null, paramwyg.g, paramwyg.g, null, paramwyg.f, null, paramwyg.m, true))
      {
        paramwwb.a(paramwyg);
        return;
      }
      paramwwb.b(paramwyg);
      return;
    }
    bhhn.a(paramContext, 1001, 1, "web_share", "", paramwyg.jdField_a_of_type_JavaLangString, paramwyg.k, paramwyg.l, paramwyg.jdField_d_of_type_JavaLangString, paramwyg.h, "web", null, null, null, "plugin", paramwyg.g, null, null, null, paramwyg.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, wyh paramwyh, wwb paramwwb)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramwyh.jdField_c_of_type_JavaLangString))
    {
      localObject = paramwyh.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramwyh.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramwyh.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramwyh.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramwyh.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!QZoneShareManager.jumpToQzoneShare(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramwwb != null) {
        paramwwb.a(paramwyh);
      }
    }
    label151:
    label159:
    while (paramwwb == null)
    {
      return;
      localObject = paramwyh.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramwyh.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramwwb.b(paramwyh);
  }
  
  private static void a(Context paramContext, wyi paramwyi, wwb paramwwb)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramwyi, paramContext, paramwwb));
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
            Object localObject1 = URLEncoder.encode(paramwyi.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramwyi.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramwyi.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramwyi.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramwwb == null);
          paramwwb.a(paramwyi);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramwwb == null);
      paramwwb.b(paramwyi);
    }
  }
  
  private static void a(wyj paramwyj, boolean paramBoolean, wwb paramwwb)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramwwb = new wys(str1, paramwwb, paramwyj);
    WXShareHelper.a().a(paramwwb);
    paramwwb = WXShareHelper.a();
    String str2 = paramwyj.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramwyj.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramwyj.jdField_c_of_type_JavaLangString;
    paramwyj = paramwyj.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramwwb.b(str1, str2, localBitmap, str3, paramwyj, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyr
 * JD-Core Version:    0.7.0.1
 */