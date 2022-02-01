import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wkj
{
  public boolean bdG;
  public Drawable img;
  public ColorStateList k;
  public String path;
  
  private static ColorStateList a(SharedPreferences paramSharedPreferences, String paramString, Bitmap paramBitmap)
  {
    paramString = "chat_backgournd_nickname_color." + paramString;
    if (paramSharedPreferences.contains(paramString)) {
      return ColorStateList.valueOf(paramSharedPreferences.getInt(paramString, -10395552));
    }
    int i = c(paramBitmap);
    paramSharedPreferences.edit().putInt(paramString, i).commit();
    return ColorStateList.valueOf(i);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 1, new Throwable(), new Object[0]);
    }
    Object localObject = new StringBuilder().append("setChatBackground, friendUin=");
    if (!TextUtils.isEmpty(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ChatBackground", 1, bool + ", path=" + paramString3);
      paramContext = getSharedPreferences(paramContext, paramString1, 4);
      paramString1 = paramContext.edit();
      if (paramString2 != null) {
        break;
      }
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString1.putInt("_chat_bg_effect", paramInt1);
      paramString2 = paramContext.getAll();
      if (paramString2 == null) {
        break label399;
      }
      paramString2 = paramString2.keySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject).matches())
        {
          String str = paramContext.getString((String)localObject, "null");
          bool = paramContext.getBoolean((String)localObject + "_is_c2c_set", false);
          if ((str == null) || (str.trim().length() == 0) || (str.equals("null")) || (str.equals("none")) || (!bool))
          {
            paramString1.putString((String)localObject, paramString3);
            paramString1.putInt((String)localObject + "_chat_bg_effect", paramInt1);
          }
        }
      }
    }
    paramString1.putString(paramString2, paramString3);
    paramString1.putInt(paramString2 + "_uinType", paramInt2);
    if (paramString3.equals("null"))
    {
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
      paramString1.remove(paramString2 + "_chat_bg_effect");
    }
    for (;;)
    {
      label399:
      paramString1.commit();
      return;
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
      paramString1.putInt(paramString2 + "_chat_bg_effect", paramInt1);
    }
  }
  
  static void a(Context paramContext, wkj paramwkj, String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    label159:
    int i;
    try
    {
      localObject2 = Shader.TileMode.REPEAT;
      localDrawable = paramContext.getResources().getDrawable(2130839260);
      if (localDrawable == null)
      {
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackground", 2, "setAIOBackgroundBmp, Drawable d=" + localDrawable + ",path=" + paramString);
      }
      if (!ThemeUtil.isNowThemeIsAnimate()) {
        break label159;
      }
      paramString = ThemeUtil.getAnimatePathByTag(3);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("key_use_rect", true);
      ((Bundle)localObject1).putBoolean("key_play_apng", paramBoolean);
      paramwkj.img = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", localDrawable, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
      paramwkj.path = paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        Drawable localDrawable;
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM1:" + paramString.getMessage());
        paramwkj.img = paramContext.getResources().getDrawable(2130851037);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "OOM1");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          anpc.a(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label196:
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM2 or Err:" + paramString.getMessage());
        paramwkj.img = paramContext.getResources().getDrawable(2130851037);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "EE");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          anpc.a(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
      QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
      return;
    }
    if (paramwkj.img != null)
    {
      paramwkj.bdG = true;
      return;
      if ((localDrawable instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localDrawable).getBitmap();
        paramString = ((BitmapDrawable)localDrawable).getTileModeX();
        i = ((BitmapDrawable)localDrawable).getGravity();
        if ((localObject1 != null) && (paramString != Shader.TileMode.REPEAT) && (i == 48)) {
          break label400;
        }
        paramwkj.img = localDrawable;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("setAIOBackgroundBmp, bgBitmap=").append(localObject1).append(", type=");
          if (paramString != Shader.TileMode.REPEAT) {
            break label670;
          }
        }
      }
    }
    label400:
    label660:
    label670:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("ChatBackground", 2, paramBoolean + ", gravity=" + i);
      for (;;)
      {
        for (;;)
        {
          if (localObject1 != null) {
            break label426;
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_FailCode", "dNull");
            paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
            anpc.a(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramContext) {}
        }
        break;
        if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
          break label660;
        }
        localObject1 = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
        i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
        break label196;
        paramString = new afeh(paramContext.getResources(), (Bitmap)localObject1);
        paramString.setGravity(i);
        paramwkj.img = paramString;
      }
      label426:
      break;
      paramString = (String)localObject2;
      i = 119;
      break label196;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, wkj paramwkj)
  {
    if (paramwkj == null)
    {
      QLog.e("ChatBackground", 1, "getChatBackground out=null");
      return false;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences(paramContext, paramString1, 0);
    Object localObject1 = null;
    if (!TextUtils.isEmpty(paramString2)) {
      localObject1 = localSharedPreferences.getString(paramString2, null);
    }
    paramString2 = (String)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString2 = (String)localObject1;
      if (localObject1 == null) {
        paramString2 = "null";
      }
    }
    String str1 = ThemeDiyStyleLogic.getDiyVFSPath(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground_Time", 2, "getChatBackground, out.isDecodeSuccess=" + paramwkj.bdG + ", path=" + str1 + ", out.path=" + paramwkj.path);
    }
    boolean bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    }
    int i;
    label163:
    boolean bool2;
    for (;;)
    {
      if ((paramInt & 0x4) != 0)
      {
        i = 1;
        if ((paramInt & 0x2) == 0) {
          break label304;
        }
        bool2 = true;
        if ((paramwkj.img != null) && (paramwkj.bdG) && (!TextUtils.isEmpty(paramwkj.path)) && (paramwkj.path.equals(str1))) {
          break label1610;
        }
      }
      for (;;)
      {
        try
        {
          if ((!TextUtils.isEmpty(str1)) && (!"null".equals(str1)) && (!"none".equals(str1))) {
            continue;
          }
          paramwkj.path = "null";
        }
        catch (OutOfMemoryError paramString1)
        {
          label304:
          QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + str1);
          paramwkj.img = paramContext.getResources().getDrawable(2130851037);
          try
          {
            paramString1 = new HashMap();
            paramString1.put("param_FailCode", "OOM0");
            paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
            anpc.a(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
          }
          catch (Exception paramContext) {}
          continue;
          if (i == 0) {
            break label697;
          }
        }
        try
        {
          paramwkj.k = paramContext.getResources().getColorStateList(2131167328);
          a(paramContext, paramwkj, str1, bool1);
          if (paramwkj.img == null) {
            QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
          }
          return true;
          bool1 = false;
          break;
          i = 0;
          break label163;
          bool2 = false;
        }
        catch (RuntimeException paramString1)
        {
          QLog.d("ChatBackground_Time", 2, "getChatBackground error");
        }
      }
    }
    long l1;
    label482:
    long l2;
    label697:
    label721:
    boolean bool3;
    if (ChatBackgroundManager.z(new File(str1)))
    {
      l1 = SystemClock.uptimeMillis();
      paramString1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      if (paramString1 == null)
      {
        paramString1 = d(paramContext, str1);
        l2 = SystemClock.uptimeMillis();
        if (paramString1 != null) {
          BaseApplicationImpl.sImageCache.put(str1, paramString1);
        }
        for (paramString2 = new afeh(paramContext.getResources(), paramString1);; paramString2 = paramContext.getResources().getDrawable(2130839260))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("key_use_rect", true);
          ((Bundle)localObject1).putBoolean("key_double_bitmap", true);
          paramwkj.img = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), str1, "-chatBg-", paramString2, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
          if ((paramwkj.img == null) && (paramString1 != null)) {
            paramwkj.img = new afeh(paramContext.getResources(), paramString1);
          }
          paramwkj.path = str1;
          paramwkj.bdG = true;
          if (paramString1 != null) {
            paramwkj.k = a(localSharedPreferences, str1, paramString1);
          }
          long l3 = SystemClock.uptimeMillis();
          QLog.d("ChatBackground_Time", 1, "APNG_getBitmap " + (l2 - l1) + " APNG_init " + (l3 - l2));
          break;
        }
      }
    }
    else
    {
      if (BaseApplicationImpl.sImageCache.get(str1) == null) {
        break label1670;
      }
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      paramString2 = (String)localObject1;
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((Bitmap)localObject1).isRecycled()) {
          paramString2 = null;
        }
      }
      bool3 = false;
      paramBoolean = bool3;
      localObject1 = paramString2;
      if (paramString2 == null)
      {
        localObject1 = new File(str1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1651;
        }
        if (((File)localObject1).isFile()) {
          break label1345;
        }
        break label1651;
        label790:
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1223;
        }
        paramBoolean = aszy.cv(paramContext);
        if ((QLog.isColorLevel()) || (!paramBoolean)) {
          QLog.d("ChatBackground", 2, "getChatBackground, sharpP exists, path=" + str1 + ", sharpPAv=" + paramBoolean);
        }
        if (!paramBoolean) {
          break label1645;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = SharpPUtil.decodeSharpPByFilePath(((File)localObject1).getAbsolutePath());
        if (!QLog.isColorLevel())
        {
          paramString2 = (String)localObject1;
          if (localObject1 != null) {
            break label1662;
          }
        }
        paramString2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (localObject1 != null)
        {
          paramBoolean = true;
          QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
          paramString2 = (String)localObject1;
          break label1662;
          label934:
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder().append("getChatBackground, check bg=");
            if (localObject1 == null) {
              break label1686;
            }
            bool3 = true;
            QLog.d("ChatBackground", 2, bool3 + ", path=" + str1);
          }
          if (localObject1 == null) {
            break label1400;
          }
          BaseApplicationImpl.sImageCache.put(str1, localObject1);
          paramwkj.path = str1;
          paramwkj.img = new afeh(paramContext.getResources(), (Bitmap)localObject1);
          paramwkj.k = a(localSharedPreferences, str1, (Bitmap)localObject1);
          paramwkj.bdG = true;
          break;
          label1051:
          localObject1 = new File(aszy.y((File)localObject1));
          break label790;
        }
        paramBoolean = false;
        continue;
        label1136:
        if (paramString2 != null) {
          break label1221;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.e("ChatBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + localUnsatisfiedLinkError.getMessage());
        if ((!QLog.isColorLevel()) && (paramString2 != null)) {
          break label1645;
        }
        localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (paramString2 == null) {
          break label1676;
        }
        paramBoolean = true;
        QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
      }
      finally
      {
        if (QLog.isColorLevel()) {}
      }
      Object localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
      if (paramString2 != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        for (;;)
        {
          QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
          label1221:
          throw paramString1;
          label1223:
          QLog.e("ChatBackground", 1, "getChatBackground Error, file == null ; path = " + str1);
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_FailCode", "dd_5");
            ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
            anpc localanpc = anpc.a(paramContext);
            String str2 = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
            if (paramString2 != null) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localanpc.collectPerformance(str2, "ChatBackgroundDecoder", paramBoolean, 1L, 0L, (HashMap)localObject2, "", false);
              paramBoolean = true;
              break;
            }
            l1 = SystemClock.uptimeMillis();
          }
          catch (Exception localException)
          {
            paramBoolean = true;
          }
          label1345:
          localObject3 = d(paramContext, str1);
          l2 = SystemClock.uptimeMillis();
          QLog.e("ChatBackground_Time", 1, "Normal_getBitmap " + (l2 - l1));
          paramBoolean = bool3;
          break label934;
          label1400:
          paramString1 = ThemeBackground.getSharedPreferences(paramContext, paramString1, 0).getString("theme_bg_aio_path_url", null);
          if (!TextUtils.isEmpty(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatBackground", 2, "getChatBackground, downloading, url=" + paramString1 + ", path=" + str1);
            }
            paramString2 = new ResData();
            paramString2.path = str1;
            paramString2.url = paramString1;
            paramString2.loadingType = 3;
            paramwkj.img = DIYThemeUtils.getDIYDrawable(paramContext, paramString2, 0, 0, -1, bool2);
            paramwkj.path = str1;
            break;
          }
          QLog.e("ChatBackground", 2, "getChatBackground, bg == null, path=" + str1 + ", fileErr=" + paramBoolean);
          paramwkj.path = "null";
          try
          {
            paramwkj.k = paramContext.getResources().getColorStateList(2131167328);
            a(paramContext, paramwkj, str1, bool1);
            if (paramBoolean) {
              break;
            }
            paramwkj.bdG = false;
          }
          catch (RuntimeException paramString1)
          {
            for (;;)
            {
              QLog.d("ChatBackground_Time", 2, "getChatBackground error");
            }
          }
        }
        label1610:
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackground", 2, "getChatBackground, bg not change, path=" + str1);
        }
        return false;
        label1645:
        break label1662;
        break label482;
        label1651:
        if (localObject3 != null) {
          break label1051;
        }
        Object localObject3 = null;
        break label790;
        label1662:
        paramBoolean = false;
        localObject3 = paramString2;
        break label934;
        label1670:
        localObject3 = null;
        break label721;
        label1676:
        paramBoolean = false;
        break label1136;
      }
      label1686:
      bool3 = false;
    }
  }
  
  public static final void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0, paramInt);
  }
  
  public static int c(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int i1 = paramBitmap.getHeight();
      int[] arrayOfInt = new int[i1];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, i1);
      j = 0;
      int m = 0;
      int n = 0;
      while (i < i1)
      {
        int i2 = arrayOfInt[i];
        n += Color.red(i2);
        m += Color.green(i2);
        j += Color.blue(i2);
        i += 1;
      }
      if ((j + (n + m)) / i1 / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  private static Bitmap d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 535	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 536	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 6
    //   9: ldc_w 538
    //   12: getstatic 543	android/os/Build:BRAND	Ljava/lang/String;
    //   15: invokevirtual 546	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   18: ifeq +475 -> 493
    //   21: aload 6
    //   23: getstatic 552	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: putfield 555	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   29: aload 6
    //   31: iconst_1
    //   32: putfield 558	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   35: aload 6
    //   37: iconst_1
    //   38: putfield 561	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   41: aload 6
    //   43: iconst_0
    //   44: putfield 558	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   47: aload_1
    //   48: aload 6
    //   50: invokestatic 566	aqcu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Laqcu$a;
    //   53: astore 5
    //   55: aload 5
    //   57: getfield 572	aqcu$a:bmp	Landroid/graphics/Bitmap;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +11 -> 75
    //   67: aload 5
    //   69: getfield 575	aqcu$a:iResult	I
    //   72: ifeq +437 -> 509
    //   75: new 21	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 577
    //   85: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 579
    //   95: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: astore 7
    //   100: aload 4
    //   102: ifnonnull +402 -> 504
    //   105: iconst_1
    //   106: istore_3
    //   107: ldc 75
    //   109: iconst_1
    //   110: aload 7
    //   112: iload_3
    //   113: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: ldc_w 581
    //   119: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 6
    //   124: getfield 561	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   127: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: new 291	java/util/HashMap
    //   139: dup
    //   140: invokespecial 292	java/util/HashMap:<init>	()V
    //   143: astore 7
    //   145: aload 7
    //   147: ldc_w 294
    //   150: new 21	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 583
    //   160: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: getfield 575	aqcu$a:iResult	I
    //   168: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: aload 7
    //   180: ldc_w 302
    //   183: invokestatic 305	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   186: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: aload_0
    //   191: invokestatic 310	anpc:a	(Landroid/content/Context;)Lanpc;
    //   194: astore 8
    //   196: getstatic 250	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   199: invokevirtual 254	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   202: checkcast 312	com/tencent/mobileqq/app/QQAppInterface
    //   205: invokevirtual 315	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   208: astore 9
    //   210: aload 4
    //   212: ifnull +355 -> 567
    //   215: iconst_1
    //   216: istore_3
    //   217: aload 8
    //   219: aload 9
    //   221: ldc_w 317
    //   224: iload_3
    //   225: lconst_1
    //   226: lconst_0
    //   227: aload 7
    //   229: ldc_w 319
    //   232: iconst_0
    //   233: invokevirtual 323	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   236: aload 5
    //   238: getfield 575	aqcu$a:iResult	I
    //   241: iconst_1
    //   242: if_icmpne +356 -> 598
    //   245: ldc 75
    //   247: iconst_1
    //   248: new 21	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 585
    //   258: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 6
    //   273: getfield 561	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   276: iconst_2
    //   277: imul
    //   278: istore_2
    //   279: iload_2
    //   280: bipush 32
    //   282: if_icmpgt +114 -> 396
    //   285: aload 6
    //   287: iload_2
    //   288: putfield 561	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   291: aload_1
    //   292: aload 6
    //   294: invokestatic 566	aqcu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Laqcu$a;
    //   297: astore 5
    //   299: aload 5
    //   301: getfield 572	aqcu$a:bmp	Landroid/graphics/Bitmap;
    //   304: astore 4
    //   306: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifne +8 -> 317
    //   312: aload 4
    //   314: ifnonnull +73 -> 387
    //   317: new 21	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 587
    //   327: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 5
    //   332: getfield 575	aqcu$a:iResult	I
    //   335: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: ldc 95
    //   340: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_1
    //   344: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 589
    //   350: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc_w 579
    //   360: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: astore 7
    //   365: aload 4
    //   367: ifnull +205 -> 572
    //   370: iconst_1
    //   371: istore_3
    //   372: ldc 75
    //   374: iconst_2
    //   375: aload 7
    //   377: iload_3
    //   378: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload 5
    //   389: getfield 575	aqcu$a:iResult	I
    //   392: iconst_1
    //   393: if_icmpeq +184 -> 577
    //   396: new 291	java/util/HashMap
    //   399: dup
    //   400: invokespecial 292	java/util/HashMap:<init>	()V
    //   403: astore_1
    //   404: aload_1
    //   405: ldc_w 294
    //   408: new 21	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 591
    //   418: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 5
    //   423: getfield 575	aqcu$a:iResult	I
    //   426: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: pop
    //   436: aload_1
    //   437: ldc_w 302
    //   440: invokestatic 305	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   443: invokevirtual 300	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   446: pop
    //   447: aload_0
    //   448: invokestatic 310	anpc:a	(Landroid/content/Context;)Lanpc;
    //   451: astore_0
    //   452: getstatic 250	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   455: invokevirtual 254	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   458: checkcast 312	com/tencent/mobileqq/app/QQAppInterface
    //   461: invokevirtual 315	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   464: astore 5
    //   466: aload 4
    //   468: ifnull +116 -> 584
    //   471: iconst_1
    //   472: istore_3
    //   473: aload_0
    //   474: aload 5
    //   476: ldc_w 317
    //   479: iload_3
    //   480: lconst_1
    //   481: lconst_0
    //   482: aload_1
    //   483: ldc_w 319
    //   486: iconst_0
    //   487: invokevirtual 323	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   490: aload 4
    //   492: areturn
    //   493: aload 6
    //   495: getstatic 594	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   498: putfield 555	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   501: goto -472 -> 29
    //   504: iconst_0
    //   505: istore_3
    //   506: goto -399 -> 107
    //   509: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq -376 -> 136
    //   515: ldc 75
    //   517: iconst_2
    //   518: new 21	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 596
    //   528: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc 95
    //   537: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 581
    //   547: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 6
    //   552: getfield 561	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   555: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: goto -428 -> 136
    //   567: iconst_0
    //   568: istore_3
    //   569: goto -352 -> 217
    //   572: iconst_0
    //   573: istore_3
    //   574: goto -202 -> 372
    //   577: iload_2
    //   578: iconst_2
    //   579: imul
    //   580: istore_2
    //   581: goto -302 -> 279
    //   584: iconst_0
    //   585: istore_3
    //   586: goto -113 -> 473
    //   589: astore_0
    //   590: aload 4
    //   592: areturn
    //   593: astore 7
    //   595: goto -359 -> 236
    //   598: aload 4
    //   600: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	paramContext	Context
    //   0	601	1	paramString	String
    //   278	303	2	i	int
    //   106	480	3	bool	boolean
    //   60	539	4	localBitmap	Bitmap
    //   53	422	5	localObject1	Object
    //   7	544	6	localOptions	android.graphics.BitmapFactory.Options
    //   98	278	7	localObject2	Object
    //   593	1	7	localException	Exception
    //   194	24	8	localanpc	anpc
    //   208	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   396	466	589	java/lang/Exception
    //   473	490	589	java/lang/Exception
    //   136	210	593	java/lang/Exception
    //   217	236	593	java/lang/Exception
  }
  
  public static String g(Context paramContext, String paramString1, String paramString2)
  {
    return ChatBackgroundManager.g(paramContext, paramString1, paramString2);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, paramInt);
    if (aczs.D("QQThemeChatBackgroundMigration", paramString) < 1)
    {
      SharedPreferences.Editor localEditor = paramContext.edit();
      QLog.d("DiySecureFileHelper", 1, "Move Chatbackground SharedPreferences");
      int i;
      if (paramContext.getAll() != null)
      {
        Iterator localIterator = paramContext.getAll().entrySet().iterator();
        paramInt = 0;
        i = paramInt;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str;
          if ((localEntry.getValue() instanceof String))
          {
            str = (String)localEntry.getValue();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                localEditor.putString((String)localEntry.getKey(), str.replace("/custom_background/" + paramString + "/", "/custom_background/" + aczs.jH(paramString) + "/"));
                i = 1;
              }
            }
            paramInt = i;
            if (str == null) {
              break label748;
            }
            paramInt = i;
            if (!str.contains("/" + paramString + "/custom_background/")) {
              break label748;
            }
            localEditor.putString((String)localEntry.getKey(), str.replace("/" + paramString + "/custom_background/", "/custom_background/" + aczs.jH(paramString) + "/"));
            paramInt = 1;
          }
          label675:
          label713:
          label748:
          for (;;)
          {
            break;
            str = (String)localEntry.getKey();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                if (!(localEntry.getValue() instanceof Integer)) {
                  break label675;
                }
                localEditor.putInt(str.replace("/custom_background/" + paramString + "/", "/custom_background/" + aczs.jH(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              }
            }
            for (i = 1;; i = paramInt)
            {
              paramInt = i;
              if (str == null) {
                break label748;
              }
              paramInt = i;
              if (!str.contains("/" + paramString + "/custom_background/")) {
                break label748;
              }
              if (!(localEntry.getValue() instanceof Integer)) {
                break label713;
              }
              localEditor.putInt(str.replace("/" + paramString + "/custom_background/", "/custom_background/" + aczs.jH(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              paramInt = 1;
              break;
              QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            }
            QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            paramInt = i;
          }
        }
      }
      else
      {
        QLog.e("DiySecureFileHelper", 1, "sf.getAll is null");
        i = 0;
      }
      if (i != 0) {
        localEditor.commit();
      }
      aczs.J("QQThemeChatBackgroundMigration", paramString, 1);
    }
    return paramContext;
  }
  
  public static final void i(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    b(paramContext, paramString1, paramString2, paramString3, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkj
 * JD-Core Version:    0.7.0.1
 */