import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class kcu
{
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean1, String paramString4, boolean paramBoolean2, odg.e parame)
  {
    int k = 0;
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
          if (i != -1) {
            rwt.ez(0, i);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoShareUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", toWeChat=" + paramBoolean1);
            }
            return;
            if (WXShareHelper.a().isWXsupportApi()) {
              break label279;
            }
            i = 2131721936;
            break;
            paramString2 = String.valueOf(System.currentTimeMillis());
            parame = new kcv(paramString2, parame);
            WXShareHelper.a().a(parame);
            if ((!paramBoolean1) || (TextUtils.isEmpty(paramString4)) || (paramBoolean2)) {
              break label183;
            }
            WxShareHelperFromReadInjoy.a().b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, paramString4);
          }
          label183:
          if (awit.y(kxm.getAppRuntime()) == 1)
          {
            paramString4 = WXShareHelper.a();
            paramBitmap = t(paramBitmap);
            if (paramBoolean1) {}
            for (i = j;; i = 1)
            {
              paramString4.b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
              break;
            }
          }
          paramString4 = WxShareHelperFromReadInjoy.a();
          paramBitmap = t(paramBitmap);
          if (paramBoolean1) {}
          for (i = k;; i = 1)
          {
            paramString4.b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
            break;
          }
          label279:
          i = -1;
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
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR e=" + paramBitmap.getMessage());
        }
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcu
 * JD-Core Version:    0.7.0.1
 */