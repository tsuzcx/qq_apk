import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.screendetect.ScreenShotHelper.2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppActivity;

public class amiw
{
  private static List<Integer> De = new ArrayList();
  private static amir.a a;
  private static boolean cor;
  public static boolean isOpened = true;
  
  static
  {
    De.clear();
    De.add(Integer.valueOf(0));
    De.add(Integer.valueOf(1));
    De.add(Integer.valueOf(3000));
    De.add(Integer.valueOf(1004));
    De.add(Integer.valueOf(1000));
    De.add(Integer.valueOf(1022));
    De.add(Integer.valueOf(1001));
    De.add(Integer.valueOf(10002));
    De.add(Integer.valueOf(1006));
    De.add(Integer.valueOf(1005));
    De.add(Integer.valueOf(10008));
  }
  
  public static Point a(Context paramContext)
  {
    try
    {
      localObject = new Point();
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
          paramContext.getRealSize((Point)localObject);
        }
        for (;;)
        {
          return localObject;
          try
          {
            Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
            Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
            ((Point)localObject).set(((Integer)localMethod1.invoke(paramContext, new Object[0])).intValue(), ((Integer)localMethod2.invoke(paramContext, new Object[0])).intValue());
          }
          catch (Exception localException2)
          {
            ((Point)localObject).set(paramContext.getWidth(), paramContext.getHeight());
            localException2.printStackTrace();
          }
        }
        QLog.e("ScreenShotHelper", 1, "getRealScreenSize error.", (Throwable)localObject);
      }
      catch (Exception localException3)
      {
        paramContext = (Context)localObject;
        localObject = localException3;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  private List<RecentBaseData> a(List<RecentBaseData> paramList, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int j;
      try
      {
        int k = paramList.size();
        j = 0;
        int i = -1;
        if (j < k)
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(j);
          if (e(localRecentBaseData))
          {
            localArrayList.add(localRecentBaseData);
          }
          else if ((localRecentBaseData.ng() == 6000) && (TextUtils.equals(localRecentBaseData.qx(), acbn.bkw)))
          {
            localArrayList.add(localRecentBaseData);
            i = j;
          }
        }
        else
        {
          if ((localArrayList.size() == 0) || (i == -1))
          {
            QLog.d("ScreenShotHelper", 2, "filterRecentUser resultList.size = " + localArrayList.size() + ", index = " + i);
            paramList = aaiv.a(new RecentUser(acbn.bkw, 6000), paramQQAppInterface, paramActivity);
            if (paramList != null)
            {
              paramList.mTitleName = paramActivity.getResources().getString(2131695446);
              localArrayList.add(paramList);
            }
          }
          Collections.sort(localArrayList, new aaiw(paramQQAppInterface));
          return localArrayList;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ScreenShotHelper", 1, "filterRecentUser error.", paramList);
        return localArrayList;
      }
      j += 1;
    }
  }
  
  public static void a(Activity paramActivity, Handler paramHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onActivityResumeHideFloatView");
    }
    View localView = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131377741);
    if (localView != null)
    {
      localView.setVisibility(0);
      paramHandler.postDelayed(new ScreenShotHelper.2(new WeakReference(paramActivity), localView, paramHandler), 5000L);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Handler paramHandler)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView().getRootView();
    Object localObject1 = localViewGroup.findViewById(2131377741);
    int k = aqnm.dpToPx(79.0F);
    Object localObject3 = a(paramActivity);
    int j = (int)(((Point)localObject3).y / ((Point)localObject3).x * k);
    if (j > 2.5D * k) {
      j = (int)(2.5D * k);
    }
    for (;;)
    {
      ImageView localImageView;
      if ((localObject1 == null) && ((localViewGroup instanceof FrameLayout)))
      {
        localObject3 = View.inflate(paramActivity, 2131563003, null);
        localImageView = (ImageView)((View)localObject3).findViewById(2131377744);
        localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).height = j;
        ((RelativeLayout.LayoutParams)localObject1).width = k;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        try
        {
          paramActivity.getResources().getDrawable(2130840732);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = j;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.am();
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.getFailedDrawable();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
          localObject1 = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          localImageView.setImageDrawable((Drawable)localObject1);
          localObject1 = new FrameLayout.LayoutParams(aqnm.dpToPx(96.0F), -2);
          ((FrameLayout.LayoutParams)localObject1).gravity = 21;
          ((FrameLayout.LayoutParams)localObject1).rightMargin = aqnm.dpToPx(16.0F);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localViewGroup.addView((View)localObject3);
          ((View)localObject3).setId(2131377741);
          localObject1 = localObject3;
          if (localObject1 != null)
          {
            hC((View)localObject1);
            ((View)localObject1).setTag(paramString);
            ((View)localObject1).setOnClickListener(new amix());
            a(paramActivity, paramHandler);
            return;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          int i = 1;
          if (j > 0) {
            i = ((BitmapFactory.Options)localObject1).outHeight / j;
          }
          j = 1;
          if (k > 0) {
            j = ((BitmapFactory.Options)localObject1).outWidth / k;
          }
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          k = j;
          if (i > j) {
            k = i;
          }
          ((BitmapFactory.Options)localObject1).inSampleSize = k;
          ((BitmapFactory.Options)localObject1).inTargetDensity = 320;
          Object localObject2;
          if (BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi > ((BitmapFactory.Options)localObject1).inDensity)
          {
            ((BitmapFactory.Options)localObject1).inDensity = 320;
            try
            {
              localObject1 = new BitmapDrawable(BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1));
            }
            catch (Throwable localThrowable)
            {
              QLog.e("ScreenShotHelper", 1, "decode screenshot failed ", localIllegalStateException);
              localObject2 = null;
            }
          }
          else
          {
            localObject2.inDensity = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
            continue;
            QLog.e("ScreenShotHelper", 1, "screenshot float view failed ");
            return;
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, android.net.Uri paramUri, View paramView1, View paramView2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: new 461	android/util/SparseArray
    //   14: dup
    //   15: iconst_2
    //   16: invokespecial 463	android/util/SparseArray:<init>	(I)V
    //   19: astore 9
    //   21: aload_1
    //   22: aload_0
    //   23: iconst_3
    //   24: aload 9
    //   26: invokestatic 468	rvx:a	(Landroid/net/Uri;Landroid/content/Context;ILandroid/util/SparseArray;)I
    //   29: istore 6
    //   31: iload 6
    //   33: invokestatic 472	rvx:fb	(I)Z
    //   36: ifeq +262 -> 298
    //   39: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +12 -> 54
    //   45: ldc 107
    //   47: iconst_2
    //   48: ldc_w 474
    //   51: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload 9
    //   56: iconst_2
    //   57: invokevirtual 475	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   60: astore_0
    //   61: aload_0
    //   62: instanceof 477
    //   65: ifeq +228 -> 293
    //   68: aload_0
    //   69: checkcast 477	java/lang/String
    //   72: astore_1
    //   73: new 479	org/json/JSONObject
    //   76: dup
    //   77: invokespecial 480	org/json/JSONObject:<init>	()V
    //   80: astore_0
    //   81: aload_0
    //   82: ldc_w 482
    //   85: aload_1
    //   86: invokevirtual 486	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_0
    //   91: ifnonnull +167 -> 258
    //   94: ldc_w 488
    //   97: astore_0
    //   98: aload_3
    //   99: iconst_0
    //   100: invokevirtual 242	android/view/View:setVisibility	(I)V
    //   103: aload_3
    //   104: aload_0
    //   105: invokevirtual 391	android/view/View:setTag	(Ljava/lang/Object;)V
    //   108: iconst_1
    //   109: istore 5
    //   111: iload 6
    //   113: invokestatic 491	rvx:fa	(I)Z
    //   116: ifeq -106 -> 10
    //   119: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 107
    //   127: iconst_2
    //   128: ldc_w 493
    //   131: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 9
    //   136: iconst_1
    //   137: invokevirtual 475	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   140: astore_1
    //   141: aload 8
    //   143: astore_0
    //   144: aload_1
    //   145: instanceof 495
    //   148: ifeq +56 -> 204
    //   151: aload_1
    //   152: checkcast 495	android/util/Pair
    //   155: astore_0
    //   156: aload_0
    //   157: getfield 499	android/util/Pair:second	Ljava/lang/Object;
    //   160: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 505	java/lang/String:trim	()Ljava/lang/String;
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 508	android/util/Pair:first	Ljava/lang/Object;
    //   171: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokevirtual 505	java/lang/String:trim	()Ljava/lang/String;
    //   177: astore_3
    //   178: new 479	org/json/JSONObject
    //   181: dup
    //   182: invokespecial 480	org/json/JSONObject:<init>	()V
    //   185: astore_0
    //   186: aload_0
    //   187: ldc_w 510
    //   190: aload_1
    //   191: invokevirtual 486	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload_0
    //   196: ldc_w 512
    //   199: aload_3
    //   200: invokevirtual 486	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload_0
    //   205: ifnonnull +72 -> 277
    //   208: ldc_w 488
    //   211: astore_0
    //   212: iload 5
    //   214: ifeq +8 -> 222
    //   217: iload 4
    //   219: ifeq -209 -> 10
    //   222: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +12 -> 237
    //   228: ldc 107
    //   230: iconst_2
    //   231: ldc_w 514
    //   234: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_2
    //   238: iconst_0
    //   239: invokevirtual 242	android/view/View:setVisibility	(I)V
    //   242: aload_2
    //   243: aload_0
    //   244: invokevirtual 391	android/view/View:setTag	(Ljava/lang/Object;)V
    //   247: return
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_1
    //   252: invokevirtual 515	org/json/JSONException:printStackTrace	()V
    //   255: goto -165 -> 90
    //   258: aload_0
    //   259: invokevirtual 516	org/json/JSONObject:toString	()Ljava/lang/String;
    //   262: astore_0
    //   263: goto -165 -> 98
    //   266: astore_1
    //   267: aload 7
    //   269: astore_0
    //   270: aload_1
    //   271: invokevirtual 515	org/json/JSONException:printStackTrace	()V
    //   274: goto -70 -> 204
    //   277: aload_0
    //   278: invokevirtual 516	org/json/JSONObject:toString	()Ljava/lang/String;
    //   281: astore_0
    //   282: goto -70 -> 212
    //   285: astore_1
    //   286: goto -16 -> 270
    //   289: astore_1
    //   290: goto -39 -> 251
    //   293: aconst_null
    //   294: astore_0
    //   295: goto -205 -> 90
    //   298: iconst_0
    //   299: istore 5
    //   301: goto -190 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramUri	android.net.Uri
    //   0	304	2	paramView1	View
    //   0	304	3	paramView2	View
    //   0	304	4	paramBoolean	boolean
    //   109	191	5	i	int
    //   29	83	6	j	int
    //   1	267	7	localObject1	Object
    //   4	138	8	localObject2	Object
    //   19	116	9	localSparseArray	android.util.SparseArray
    // Exception table:
    //   from	to	target	type
    //   73	81	248	org/json/JSONException
    //   178	186	266	org/json/JSONException
    //   186	204	285	org/json/JSONException
    //   81	90	289	org/json/JSONException
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Handler paramHandler)
  {
    try
    {
      if (!(paramContext instanceof Activity)) {
        return;
      }
      if ((Build.VERSION.SDK_INT >= 24) && (((Activity)paramContext).isInMultiWindowMode()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ScreenShotHelper", 2, "start float view is error and errMsg : isInMultiWindowMode");
        return;
      }
      a((Activity)paramContext, paramString, paramHandler);
      paramString = sws.a;
      if (paramString == null) {
        return;
      }
      if ((paramContext instanceof AppActivity))
      {
        AppActivity.setActivityDispatchCallback(paramString);
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotHelper", 2, paramContext, new Object[0]);
      return;
    }
    PluginProxyActivity.setActivityDispatchCallback(paramString);
  }
  
  private static boolean a(QQBrowserActivity paramQQBrowserActivity)
  {
    if (paramQQBrowserActivity == null)
    {
      QLog.e("ScreenShotHelper", 1, "isCurrentPageIsWebFragment activity is null");
      return false;
    }
    return paramQQBrowserActivity.getSupportFragmentManager().findFragmentById(2131365379) instanceof WebViewFragment;
  }
  
  public static void aS(String paramString1, String paramString2, String paramString3)
  {
    anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public static boolean aqC()
  {
    if (cor) {
      return isOpened;
    }
    cor = true;
    dxJ();
    isOpened = a.agI();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData isSwitchOpened = " + isOpened);
    }
    return isOpened;
  }
  
  public static void b(amir.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "onConfUpdate : " + parama);
    }
    if (parama != null) {
      isOpened = parama.agI();
    }
  }
  
  public static void bP(Context paramContext, String paramString)
  {
    if ((paramContext instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView().getRootView()).findViewById(2131377741);
      if (localObject != null) {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("screen_path", paramString);
    int j = 0;
    int i = j;
    if ((paramContext instanceof BaseActivity))
    {
      paramString = (BaseActivity)paramContext;
      QQAppInterface localQQAppInterface = paramString.app;
      i = j;
      if (localQQAppInterface != null)
      {
        i = j;
        if (localQQAppInterface.b() != null)
        {
          i = j;
          if (localQQAppInterface.b().Op())
          {
            i = j;
            if (localQQAppInterface.b().cu() != null)
            {
              i = j;
              if (localQQAppInterface.b().cu().size() > 0)
              {
                ((Intent)localObject).putExtra("is_aio_page_with_msg", true);
                PublicFragmentActivity.b.startForResult(paramString, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 9011);
                i = 1;
              }
            }
          }
        }
      }
    }
    if (((paramContext instanceof QQBrowserActivity)) && (a((QQBrowserActivity)paramContext)))
    {
      ((Intent)localObject).putExtra("is_screen_shot_from_web", true);
      PublicFragmentActivity.b.startForResult((QQBrowserActivity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class, 11);
    }
    while (i != 0) {
      return;
    }
    PublicFragmentActivity.b.start(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
  
  public static void cN(String paramString, int paramInt)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void cc(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "removeFloatView() called with: activity = [" + paramActivity + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131377741);
    if (paramActivity != null) {
      ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
    }
  }
  
  public static void cd(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "hideFloatView() called with: activity = [" + paramActivity + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131377741);
    if (paramActivity != null) {
      paramActivity.setVisibility(8);
    }
  }
  
  public static void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "disaptchTouchEventCallback() called with: activity = [" + paramActivity + "], ev = [" + paramMotionEvent + "]");
    }
    paramActivity = ((ViewGroup)paramActivity.getWindow().getDecorView().getRootView()).findViewById(2131377741);
    if (paramActivity != null)
    {
      int[] arrayOfInt = new int[2];
      paramActivity.getLocationOnScreen(arrayOfInt);
      if (!new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramActivity.getWidth(), arrayOfInt[1] + paramActivity.getHeight()).contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
        ((ViewGroup)paramActivity.getParent()).removeView(paramActivity);
      }
    }
  }
  
  private static void dxJ()
  {
    amir.a locala2 = (amir.a)aeif.a().o(485);
    amir.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = new amir.a();
      locala1 = locala2;
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData = null, general new bean, so switch default is opened!");
        locala1 = locala2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper", 2, "ScreenShotConfigData switch isOpened = " + locala1);
    }
    a = locala1;
  }
  
  private boolean e(RecentBaseData paramRecentBaseData)
  {
    return De.contains(Integer.valueOf(paramRecentBaseData.ng()));
  }
  
  public static void hC(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(300L);
    paramView.start();
  }
  
  public List<RecentBaseData> a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramQQAppInterface.a().a().q(false).size() > 0) {
        localArrayList.addAll(aajt.a().fl);
      }
      return a(localArrayList, paramActivity, paramQQAppInterface);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ScreenShotHelper", 1, "getRecentUser error.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiw
 * JD-Core Version:    0.7.0.1
 */