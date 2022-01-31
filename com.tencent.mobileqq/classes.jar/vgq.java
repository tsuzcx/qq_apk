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

public class vgq
{
  private static void a(Context paramContext, vgd paramvgd, vea paramvea)
  {
    try
    {
      ncr.a(paramContext, paramvgd.jdField_a_of_type_JavaLangString);
      if (paramvea != null) {
        paramvea.a(paramvgd);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramvea == null) {}
      paramvea.b(paramvgd);
    }
  }
  
  public static void a(Context paramContext, vge paramvge, vea paramvea)
  {
    wsv.b("StoryBasicShareUtils", "share() data = %s", paramvge.toString());
    if ((paramvge instanceof vgf))
    {
      a(paramContext, (vgf)paramvge, paramvea);
      return;
    }
    if ((paramvge instanceof vgd))
    {
      a(paramContext, (vgd)paramvge, paramvea);
      return;
    }
    if ((paramvge instanceof vgg))
    {
      a(paramContext, (vgg)paramvge, paramvea);
      return;
    }
    if ((paramvge instanceof vgi))
    {
      paramContext = (vgi)paramvge;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramvea);
      return;
    }
    if ((paramvge instanceof vgh))
    {
      a(paramContext, (vgh)paramvge, paramvea);
      return;
    }
    paramvea.a(paramvge);
  }
  
  private static void a(Context paramContext, vgf paramvgf, vea paramvea)
  {
    switch (paramvgf.b)
    {
    default: 
      return;
    case 0: 
      paramvea = new MessageForQQStory();
      paramvea.authorName = paramvgf.i;
      paramvea.brief = paramvgf.jdField_d_of_type_JavaLangString;
      paramvea.briefBgColor = paramvgf.jdField_c_of_type_Int;
      paramvea.coverImgUrl = paramvgf.jdField_a_of_type_JavaLangString;
      paramvea.logoImgUrl = paramvgf.jdField_c_of_type_JavaLangString;
      paramvea.msgAction = paramvgf.h;
      paramvea.srcAction = paramvgf.g;
      paramvea.srcName = paramvgf.f;
      paramvea.type = paramvgf.jdField_e_of_type_Int;
      paramvea.mVid = paramvgf.jdField_e_of_type_JavaLangString;
      paramvea.storyTitle = paramvgf.o;
      paramvea.storyBrief = paramvgf.p;
      bctc.a((Activity)paramContext, paramvea, 29782);
      return;
    case 1: 
      if (bdir.a(paramContext, 29, paramvgf.jdField_d_of_type_Int, "web_share", paramvgf.n, paramvgf.jdField_a_of_type_JavaLangString, paramvgf.k, paramvgf.l, paramvgf.jdField_d_of_type_JavaLangString, paramvgf.jdField_a_of_type_JavaLangString, "plugin", null, paramvgf.h, paramvgf.h, "plugin", null, paramvgf.g, paramvgf.g, null, paramvgf.f, null, paramvgf.m, true))
      {
        paramvea.a(paramvgf);
        return;
      }
      paramvea.b(paramvgf);
      return;
    }
    bdir.a(paramContext, 1001, 1, "web_share", "", paramvgf.jdField_a_of_type_JavaLangString, paramvgf.k, paramvgf.l, paramvgf.jdField_d_of_type_JavaLangString, paramvgf.h, "web", null, null, null, "plugin", paramvgf.g, null, null, null, paramvgf.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, vgg paramvgg, vea paramvea)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramvgg.jdField_c_of_type_JavaLangString))
    {
      localObject = paramvgg.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramvgg.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramvgg.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramvgg.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramvgg.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!bjao.a(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramvea != null) {
        paramvea.a(paramvgg);
      }
    }
    label151:
    label159:
    while (paramvea == null)
    {
      return;
      localObject = paramvgg.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramvgg.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramvea.b(paramvgg);
  }
  
  private static void a(Context paramContext, vgh paramvgh, vea paramvea)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramvgh, paramContext, paramvea));
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
            Object localObject1 = URLEncoder.encode(paramvgh.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "http://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramvgh.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramvgh.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramvgh.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramvea == null);
          paramvea.a(paramvgh);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramvea == null);
      paramvea.b(paramvgh);
    }
  }
  
  private static void a(vgi paramvgi, boolean paramBoolean, vea paramvea)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramvea = new vgr(str1, paramvea, paramvgi);
    WXShareHelper.a().a(paramvea);
    paramvea = WXShareHelper.a();
    String str2 = paramvgi.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramvgi.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramvgi.jdField_c_of_type_JavaLangString;
    paramvgi = paramvgi.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramvea.b(str1, str2, localBitmap, str3, paramvgi, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */