import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.net.BusinessTask;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONObject;

public final class avoh
{
  public static boolean dnI;
  private static boolean iI;
  
  public static String FW()
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    return localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels;
  }
  
  @Nullable
  public static Bitmap H(String paramString)
  {
    return drawableToBitmap(t(paramString));
  }
  
  public static boolean a(Date paramDate1, Date paramDate2)
  {
    return (paramDate1.getYear() != paramDate2.getYear()) || (paramDate1.getMonth() != paramDate2.getMonth()) || (paramDate1.getDay() != paramDate2.getDay());
  }
  
  @Nullable
  public static Object b(String paramString, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Iterator localIterator = paramJSONObject.keys();
    if ((localIterator == null) || (!localIterator.hasNext())) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.get((String)localObject1);
        if ((localObject1 instanceof JSONObject))
        {
          Object localObject2 = b(paramString, (JSONObject)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (!paramString.equals(localObject1)) {}
      }
      else
      {
        try
        {
          localObject1 = paramJSONObject.get((String)localObject1);
          return localObject1;
        }
        catch (Exception localException1) {}
        return null;
      }
    }
  }
  
  public static void cH(Activity paramActivity)
  {
    boolean bool = false;
    if (iI) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramActivity == null);
        paramActivity = paramActivity.getIntent();
      } while (paramActivity == null);
      paramActivity = paramActivity.getStringExtra("readerDpcConfig");
      Log.i("Utility", "initReaderDPC dpc = " + paramActivity);
    } while (TextUtils.isEmpty(paramActivity));
    Integer[] arrayOfInteger = new Integer[6];
    Arrays.fill(arrayOfInteger, Integer.valueOf(0));
    if (DeviceProfileManager.a(paramActivity, arrayOfInteger, new DeviceProfileManager.e()) >= arrayOfInteger.length)
    {
      if (arrayOfInteger[5].intValue() == 1) {
        bool = true;
      }
      dnI = bool;
    }
    iI = true;
  }
  
  @Nullable
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static String getChannelId()
  {
    if (ChannelIdHelper.isFromUnknown()) {
      return QRBridgeActivity.cMc;
    }
    return ChannelIdHelper.getChannelId();
  }
  
  public static int getScreenHeight()
  {
    return BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth()
  {
    return BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
  }
  
  public static void gt(Context paramContext)
  {
    BusinessTask localBusinessTask = new BusinessTask("GetEnterShelfOnOffTask");
    localBusinessTask.a(new avoi(paramContext), true);
    localBusinessTask.execute();
  }
  
  public static Drawable h(@ColorInt int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt2);
    localGradientDrawable.setColor(paramInt1);
    return localGradientDrawable;
  }
  
  public static String j(@NonNull Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels;
  }
  
  public static void l(View paramView, float paramFloat)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      localMarginLayoutParams.topMargin = ((int)paramFloat);
      paramView.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public static String rK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return paramString;
          localUri = Uri.parse(paramString);
          if (!localUri.getPath().contains("bookDetails.html")) {
            break;
          }
          localObject = localUri.getQueryParameter("id");
        } while (TextUtils.isEmpty((CharSequence)localObject));
        return localUri.getScheme() + "://" + localUri.getHost() + "/club/client/read/6/rel/book_outDetail.html?ChannelID=100060&_wv=1&_wwv=4&bid=" + (String)localObject;
      } while (!localUri.getPath().contains("bookDetail_index.html"));
      String str = localUri.getQueryParameter("nbid");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = localUri.getQueryParameter("bid");
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    return localUri.getScheme() + "://" + localUri.getHost() + "/club/client/read/6/rel/bookDetail_out_detail.html?ChannelID=100060&_wv=1&_wwv=4&nbid=" + (String)localObject;
  }
  
  @Nullable
  public static Drawable t(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    else
    {
      return localObject;
    }
    ((URLDrawable)localObject).startDownload();
    return localObject;
  }
  
  public static long y(Context paramContext)
  {
    long l1 = avog.w(paramContext);
    if (l1 == -1L)
    {
      avog.gs(paramContext);
      return 0L;
    }
    long l2 = System.currentTimeMillis();
    avog.gs(paramContext);
    return l2 - l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoh
 * JD-Core Version:    0.7.0.1
 */