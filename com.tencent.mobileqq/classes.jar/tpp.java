import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class tpp
{
  public static ConcurrentHashMap<String, SoftReference<Bitmap>> a = new ConcurrentHashMap();
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    int i = 3;
    if (paramArticleInfo == null) {
      return 0;
    }
    if (ors.a(paramArticleInfo)) {
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
  
  private static Bitmap a(Bitmap paramBitmap)
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
        if (!WXShareHelper.a().a()) {
          i = 2131721491;
        }
        for (;;)
        {
          if (i != -1)
          {
            ybk.a(0, i);
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountImageCollectionUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", action=" + paramInt);
            }
            return;
            if (!WXShareHelper.a().b()) {
              i = 2131721492;
            }
          }
          else
          {
            paramString2 = String.valueOf(System.currentTimeMillis());
            Object localObject = new tpq(paramString2);
            WXShareHelper.a().a((bfah)localObject);
            localObject = WXShareHelper.a();
            paramBitmap = a(paramBitmap);
            if (paramInt == 9) {}
            for (i = j;; i = 1)
            {
              ((WXShareHelper)localObject).b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
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
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    int i = a(paramArticleInfo);
    return (i == 8) || (i == 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tpp
 * JD-Core Version:    0.7.0.1
 */