import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;

public class kwz
{
  private static final Rect av = new Rect();
  private static Drawable cw = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public static String C(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt - 1) + "…";
    }
    return str;
  }
  
  public static int N(int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public static boolean W(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    while (paramInt1 > paramInt2) {
      return false;
    }
    return true;
  }
  
  public static float a(Context paramContext, mye.b paramb)
  {
    int j = 28;
    int i;
    if (paramb != null)
    {
      i = j;
      if (paramb.topLeftRadius == 0)
      {
        i = j;
        if (paramb.topRightRadius == 0)
        {
          i = j;
          if (paramb.bottomLeftRadius == 0)
          {
            if (paramb.bottomRightRadius == 0) {
              break label56;
            }
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      return aqgz.aM(paramContext) - aqcx.dip2px(paramContext, i);
      label56:
      if ((paramb.d != null) && (paramb.d.mChannelID == 56L))
      {
        i = j;
        if (kxm.AY()) {}
      }
      else
      {
        i = 12;
      }
    }
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (paramInt - (wja.dp2px(24.0F, paramResources) + wja.dp2px(3.0F, paramResources))) / 2;
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = wja.dp2px(1.5F, localResources);
    if (paramInt2 == 56) {
      i = wja.dp2px(3.0F, localResources);
    }
    awit.c localc = awit.a(BaseApplicationImpl.getApplication().getRuntime());
    float f1;
    float f2;
    if (localc != null)
    {
      f1 = localc.Dz;
      f2 = localc.DA;
      paramInt2 = wja.dp2px(localc.eBk, localResources);
    }
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        if (paramInt2 != 0) {
          break;
        }
      }
      for (paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - wja.dp2px(6, localResources) - i * 2) / 2.1F);; paramInt1 = paramInt2)
      {
        i = (int)(paramInt1 / f2);
        paramInt2 = paramInt1;
        paramInt1 = i;
        for (;;)
        {
          return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
          paramInt2 = localResources.getDisplayMetrics().widthPixels - wja.dp2px(12, localResources);
          paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - wja.dp2px(6, localResources) - i * 2) / 2.5F * 1.3356F);
          continue;
          paramInt2 = (int)((localResources.getDisplayMetrics().widthPixels - wja.dp2px(12, localResources) - i) * 0.5F);
          paramInt1 = (int)(paramInt2 / f1);
        }
      }
      paramInt2 = 0;
      f1 = 0.7511F;
      f2 = 0.7487F;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, Context paramContext)
  {
    a(paramImageView, kxm.b(paramString), paramContext);
  }
  
  public static void a(ImageView paramImageView, URL paramURL, Context paramContext)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramImageView.setImageResource(2130842541);
      return;
    }
    if ((paramContext instanceof BaseActivity)) {}
    for (Object localObject = (BaseActivity)paramContext;; localObject = null)
    {
      if (localObject != null) {}
      for (boolean bool = SettingCloneUtil.readValue((Context)localObject, ((BaseActivity)localObject).app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
      {
        if ((!aqiw.isWifiConnected(paramContext)) && (bool) && (!noy.a().a(paramURL)))
        {
          paramImageView.setImageResource(2130842541);
          return;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130842541);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130842541);
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject));
        return;
      }
    }
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, paramContext, false);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext, boolean paramBoolean)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramKandianUrlImageView.setImageResource(2130842541);
      return;
    }
    if (a(paramContext, paramURL))
    {
      if (!paramBoolean)
      {
        paramKandianUrlImageView.setImageResource(2130842541);
        return;
      }
      paramKandianUrlImageView.setImageDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165381)));
      return;
    }
    if (!paramBoolean)
    {
      if (paramKandianUrlImageView.isRound())
      {
        paramKandianUrlImageView.setImagePlaceHolder(paramContext.getResources().getDrawable(2130841149)).setImage(paramURL);
        return;
      }
      paramKandianUrlImageView.setImagePlaceHolder(paramContext.getResources().getDrawable(2130842541)).setImage(paramURL);
      return;
    }
    paramKandianUrlImageView.setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165381)));
    paramKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(paramContext.getResources().getColor(2131165381))).setImage(paramURL);
  }
  
  public static void a(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    lic locallic = lbz.a().a();
    if ((locallic != null) && (locallic.Co()))
    {
      a(false, paramViewBase, null);
      paramBaseArticleInfo.isShowFreeNetFlow = false;
      return;
    }
    if (paramBaseArticleInfo.isShowFreeNetFlow)
    {
      a(true, paramViewBase, locallic);
      return;
    }
    if ((locallic != null) && (locallic.Cn()))
    {
      a(true, paramViewBase, locallic);
      paramBaseArticleInfo.isShowFreeNetFlow = true;
      locallic.nB(true);
      return;
    }
    a(false, paramViewBase, null);
  }
  
  public static void a(List<KandianUrlImageView> paramList, List<URL> paramList1, Context paramContext)
  {
    int j = paramList.size();
    if (j != paramList1.size()) {
      throw new IllegalArgumentException("imageViewListSize != urlListSize");
    }
    if (paramContext != null) {}
    for (boolean bool = SettingCloneUtil.readValue(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
    {
      int i;
      if ((!bool) || (aqiw.isWifiConnected(paramContext))) {
        i = 0;
      }
      while (i < j)
      {
        ((KandianUrlImageView)paramList.get(i)).setImagePlaceHolder(cw).setImage((URL)paramList1.get(i));
        i += 1;
        continue;
        i = 0;
        while (i < j)
        {
          ((KandianUrlImageView)paramList.get(i)).setImageDrawable(cw);
          i += 1;
        }
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean, ViewBase paramViewBase, lic paramlic)
  {
    if (paramViewBase == null) {}
    ViewBase localViewBase1;
    ViewBase localViewBase2;
    do
    {
      return;
      localViewBase1 = paramViewBase.findViewBaseByName("id_large_video_activity_wrapper");
      localViewBase2 = paramViewBase.findViewBaseByName("id_large_video_activity_img");
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_large_video_activity_label");
    } while ((localViewBase1 == null) || (paramViewBase == null) || (localViewBase2 == null));
    if ((paramBoolean) && (paramlic != null))
    {
      localViewBase1.setVisibility(0);
      localViewBase2.setVisibility(0);
      paramViewBase.setVisibility(0);
      paramViewBase.setText(paramlic.c());
      lic.no("0X8009660");
      return;
    }
    localViewBase1.setVisibility(8);
    localViewBase2.setVisibility(8);
    paramViewBase.setVisibility(8);
  }
  
  public static boolean a(Context paramContext, URL paramURL)
  {
    return (ao(paramContext)) && (!aqiw.isWifiConnected(paramContext)) && (!noy.a().a(paramURL));
  }
  
  private static boolean ao(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity)) {}
    for (paramContext = (BaseActivity)paramContext;; paramContext = null)
    {
      if (paramContext != null)
      {
        if (paramContext.app != null) {}
        for (String str = paramContext.app.getCurrentAccountUin();; str = kxm.getAccount()) {
          return SettingCloneUtil.readValue(paramContext, str, null, "qqsetting_kandian_download_pic_flag", false);
        }
      }
      return false;
    }
  }
  
  public static boolean b(mye.b paramb)
  {
    if (paramb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyDisplayUtils", 2, "isProtraitVideo return false for videoPlayParam is null.");
      }
      return false;
    }
    return W(paramb.videoWidth, paramb.videoHeight);
  }
  
  public static String ba(int paramInt)
  {
    int k = paramInt / 3600;
    int j = paramInt / 60;
    int i = j;
    if (k > 0) {
      i = j - k * 60;
    }
    paramInt %= 60;
    String str1;
    String str2;
    if (i >= 10)
    {
      str1 = String.valueOf(i);
      if (paramInt < 10) {
        break label117;
      }
      str2 = String.valueOf(paramInt);
      label53:
      if (k <= 0) {
        break label161;
      }
      if (k < 10) {
        break label139;
      }
    }
    label139:
    for (String str3 = String.valueOf(k);; str3 = String.format("0%d", new Object[] { Integer.valueOf(k) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(i) });
      break;
      label117:
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label53;
    }
    label161:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static float c(int paramInt1, int paramInt2)
  {
    paramInt1 = N(paramInt1, paramInt2);
    if (paramInt1 == 1) {
      return 0.5625F;
    }
    if (paramInt1 == 2) {
      return 1.333F;
    }
    return 1.0F;
  }
  
  /* Error */
  public static float c(android.view.View paramView)
  {
    // Byte code:
    //   0: ldc_w 426
    //   3: fstore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: aload_0
    //   8: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   11: invokevirtual 432	android/view/View:getLocalVisibleRect	(Landroid/graphics/Rect;)Z
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 435	android/view/View:getHeight	()I
    //   19: istore_3
    //   20: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   23: getfield 438	android/graphics/Rect:top	I
    //   26: ifne +24 -> 50
    //   29: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   32: getfield 441	android/graphics/Rect:bottom	I
    //   35: istore 4
    //   37: iload 4
    //   39: iload_3
    //   40: if_icmpne +10 -> 50
    //   43: fload_2
    //   44: fstore_1
    //   45: ldc 2
    //   47: monitorexit
    //   48: fload_1
    //   49: freturn
    //   50: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   53: getfield 438	android/graphics/Rect:top	I
    //   56: ifle +23 -> 79
    //   59: ldc_w 426
    //   62: iload_3
    //   63: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   66: getfield 438	android/graphics/Rect:top	I
    //   69: isub
    //   70: i2f
    //   71: fmul
    //   72: iload_3
    //   73: i2f
    //   74: fdiv
    //   75: fstore_1
    //   76: goto -31 -> 45
    //   79: fload_2
    //   80: fstore_1
    //   81: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   84: getfield 441	android/graphics/Rect:bottom	I
    //   87: ifle -42 -> 45
    //   90: fload_2
    //   91: fstore_1
    //   92: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   95: getfield 441	android/graphics/Rect:bottom	I
    //   98: iload_3
    //   99: if_icmpge -54 -> 45
    //   102: getstatic 32	kwz:av	Landroid/graphics/Rect;
    //   105: getfield 441	android/graphics/Rect:bottom	I
    //   108: istore 4
    //   110: ldc_w 426
    //   113: iload 4
    //   115: i2f
    //   116: fmul
    //   117: iload_3
    //   118: i2f
    //   119: fdiv
    //   120: fstore_1
    //   121: goto -76 -> 45
    //   124: astore_0
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramView	android.view.View
    //   44	77	1	f1	float
    //   3	88	2	f2	float
    //   19	99	3	i	int
    //   35	79	4	j	int
    // Exception table:
    //   from	to	target	type
    //   7	37	124	finally
    //   50	76	124	finally
    //   81	90	124	finally
    //   92	110	124	finally
  }
  
  public static void clearMemoryCache()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      return;
    }
    BaseApplicationImpl.sImageCache.evictAll();
  }
  
  public static Pair<Integer, Integer> d()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - wja.dp2px(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131299185)));
  }
  
  public static String ep(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!aofy.Z(paramString));
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < aoff.hj.length)
    {
      str = aoff.hj[i];
      int j = -1;
      for (;;)
      {
        int k = paramString.indexOf(str, j + 1);
        if (k == -1) {
          break;
        }
        j = k;
        if (k != 0)
        {
          j = k;
          if (paramString.codePointAt(k - 1) == 20)
          {
            char c = (char)i;
            paramString.replace(k, str.length() + k, String.valueOf(c));
            j = k;
          }
        }
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static Pair<Integer, Integer> f()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - wja.dp2px(3.0F, localResources)) / 2;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.33F)));
  }
  
  public static Drawable g(String paramString)
  {
    int i = Color.parseColor(paramString);
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i & 0x14FFFFFF });
    paramString.setShape(0);
    paramString.setGradientType(0);
    paramString.setBounds(0, 0, 400, 400);
    return paramString;
  }
  
  public static Pair<Integer, Integer> g()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.597F)));
  }
  
  public static Pair<Integer, Integer> h()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - wja.dp2px(3.0F, localResources)) / 3;
    return new Pair(Integer.valueOf(i), Integer.valueOf(i));
  }
  
  public static Pair<Integer, Integer> i()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static Pair<Integer, Integer> j()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.5625F)));
  }
  
  public static Pair<Integer, Integer> k()
  {
    int i = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels * 0.5F);
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.3333F)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwz
 * JD-Core Version:    0.7.0.1
 */