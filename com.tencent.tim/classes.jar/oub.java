import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class oub
{
  public static ConcurrentHashMap<String, SoftReference<Bitmap>> bF = new ConcurrentHashMap();
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt)
  {
    int j = 0;
    if (paramString1 == null) {}
    for (paramBaseActivity = "";; paramBaseActivity = paramString1)
    {
      if (paramString2 == null) {}
      for (paramString1 = "";; paramString1 = paramString2)
      {
        int i;
        if (!WXShareHelper.a().isWXinstalled()) {
          i = 2131721935;
        }
        for (;;)
        {
          if (i != -1)
          {
            rwt.ez(0, i);
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountImageCollectionUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", action=" + paramInt);
            }
            return;
            if (!WXShareHelper.a().isWXsupportApi()) {
              i = 2131721936;
            }
          }
          else
          {
            paramString2 = String.valueOf(System.currentTimeMillis());
            Object localObject = new ouc(paramString2);
            WXShareHelper.a().a((WXShareHelper.a)localObject);
            localObject = WXShareHelper.a();
            paramBitmap = t(paramBitmap);
            if (paramInt == 9) {}
            for (i = j;; i = 1)
            {
              ((WXShareHelper)localObject).a(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
              break;
            }
          }
          i = -1;
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return false;
    }
    paramIntent.putExtra("articleid", paramString);
    paramActivity.startActivity(paramIntent);
    return true;
  }
  
  public static boolean ad(ArticleInfo paramArticleInfo)
  {
    int i = m(paramArticleInfo);
    return (i == 8) || (i == 7);
  }
  
  public static int m(ArticleInfo paramArticleInfo)
  {
    int i = 3;
    if (paramArticleInfo == null) {
      return 0;
    }
    if (kxm.j(paramArticleInfo)) {
      if (paramArticleInfo.mVideoType == 0) {
        i = 4;
      }
    }
    for (;;)
    {
      return i;
      i = 5;
      continue;
      if (paramArticleInfo.mShowBigPicture)
      {
        if (paramArticleInfo.mIsGallery == 0) {
          i = 2;
        } else {
          i = 8;
        }
      }
      else if ((paramArticleInfo.mPictures == null) || (paramArticleInfo.mPictures.length < 3)) {
        if (TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl)) {
          i = 0;
        } else if (paramArticleInfo.mIsGallery == 0) {
          i = 1;
        } else {
          i = 7;
        }
      }
    }
  }
  
  private static Bitmap t(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(j * d), true);
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        System.gc();
        paramBitmap.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionUtils", 2, "scaleBitmapForWeChat ERROR e=" + paramBitmap.getMessage());
        }
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static class a
  {
    public oub.b a;
    public String ari;
    public String articleId;
    public String articleUrl;
    public int enable;
    public String imgUrl;
    public ArrayList<oub.c> infos;
    public String puin;
    public String title;
  }
  
  public static class b
  {
    public String arj;
    public String ark;
    public String arl;
    public String url;
  }
  
  public static class c
  {
    public String arm;
    public String content;
    public boolean hasRead;
    public int height = 400;
    public String url;
    public int width = 600;
  }
  
  public static class d
  {
    public String arn;
    public String source;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oub
 * JD-Core Version:    0.7.0.1
 */