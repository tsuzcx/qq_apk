package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String KEY_THEME_FONT = "theme_font_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static boolean a;
  static boolean b;
  static final String[][] e;
  static final int[][] f;
  static int g;
  static int h;
  static int i;
  static int j;
  static int k;
  static int l;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  private static SkinEngine o;
  private b A;
  private c B;
  private HashMap<String, Object> C;
  private HashMap<String, Object> D;
  private g E;
  private ISkinTint F;
  private final Object G = new Object();
  public HashMap<Integer, BackupForOOMData> backupForOOMData;
  final TypedValue c = new TypedValue();
  TypedValue d = new TypedValue();
  SkinEngineHandler m;
  public Resources mResources;
  BroadcastReceiver n = new SkinEngine.1(this);
  private ReentrantReadWriteLock p = new ReentrantReadWriteLock();
  private ReentrantReadWriteLock q = new ReentrantReadWriteLock();
  private boolean r = false;
  private boolean s = true;
  private final LongSparseArray<WeakReference<BaseConstantState>> t = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> u = new LongSparseArray();
  private final LongSparseArray<WeakReference<BaseConstantState>> v = new LongSparseArray();
  private String w;
  private String x;
  private int y = k;
  private e z;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23))
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 24) {
        break label639;
      }
    }
    label639:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      IS_PROBLEM_MIUI = false;
      mIconsOfCM = null;
      mComposedIconInfoOfCM = null;
      IS_PROBLEM_CM11 = false;
      mIconResourceID = null;
      Object localObject1 = { "drawable-xhdpi/", "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      Object localObject2 = { "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-mdpi/", "drawable/" };
      Object localObject3 = { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/" };
      Object localObject4 = { "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      Object localObject5 = { "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      e = new String[][] { localObject1, localObject2, localObject3, { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable/" }, localObject4, localObject5 };
      localObject1 = new int[] { 320, 640, 480, 240, 160, 160 };
      localObject2 = new int[] { 160, 160, 240, 320, 480, 640 };
      localObject3 = new int[] { 120, 160, 240, 320, 480, 640, 160 };
      localObject4 = new int[] { 480, 640, 320, 240, 160, 160 };
      localObject5 = new int[] { 640, 480, 320, 240, 160, 160 };
      f = new int[][] { localObject1, { 240, 320, 480, 640, 160, 160 }, localObject2, localObject3, localObject4, localObject5 };
      g = 0;
      h = 1;
      i = 2;
      j = 3;
      k = 4;
      l = 5;
      return;
      bool = false;
      break;
    }
  }
  
  private static int a(Resources paramResources)
  {
    int i1 = paramResources.getDisplayMetrics().densityDpi;
    if (i1 <= 160) {
      return i;
    }
    if (i1 <= 240) {
      return h;
    }
    if (i1 <= 320) {
      return g;
    }
    if (i1 <= 480) {
      return k;
    }
    if (i1 <= 640) {
      return l;
    }
    return k;
  }
  
  private static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT > 11) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("skin_tab_icon_see")) || (paramString.contains("skin_tab_icon_conversation")) || (paramString.contains("skin_tab_icon_plugin")) || (paramString.contains("skin_tab_icon_contact")))) {
      return 1;
    }
    return 2;
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
    throws IOException
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(paramTypedValue.type) + " is not valid");
  }
  
  private BaseConstantState a(int paramInt, Resources paramResources, SkinData paramSkinData, TypedValue paramTypedValue)
  {
    Rect localRect = new Rect();
    String str = paramSkinData.mFilePath;
    if ((str != null) && (!str.endsWith(".xml"))) {}
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      Object localObject6;
      int i1;
      Object localObject2;
      try
      {
        localObject3 = b(paramResources, str);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inDensity = paramSkinData.mInDensity;
        BaseConstantState localBaseConstantState1;
        try
        {
          localBaseConstantState1 = ResourcesFactory.createImageFromResourceStream(paramResources, null, (InputStream)localObject3, paramSkinData.mFileName, localOptions, localRect, this.s);
          ((InputStream)localObject3).close();
          if (localBaseConstantState1 == null) {
            break label507;
          }
          return localBaseConstantState1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          h.a("SkinEngine", 1, "res-OOM 0,file:" + str, localOutOfMemoryError2);
          if (this.m == null) {
            break label1332;
          }
        }
        if (!this.m.onDecodeOOM(localOutOfMemoryError2, paramSkinData.mFileName, true)) {
          break label1332;
        }
        ((InputStream)localObject3).close();
        localObject3 = b(paramResources, str);
        try
        {
          localBaseConstantState1 = ResourcesFactory.createImageFromResourceStream(paramResources, null, (InputStream)localObject3, paramSkinData.mFileName, localOptions, localRect, this.s);
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          h.a("SkinEngine", 1, "res-OOM 1,file:" + str, localOutOfMemoryError2);
          if (!this.m.onSecondDecodeOOM(localOutOfMemoryError1, paramSkinData.mFileName, true)) {
            continue;
          }
        }
        localOptions.inJustDecodeBounds = true;
        ((InputStream)localObject3).close();
        localObject5 = b(paramResources, str);
        localObject6 = ResourcesFactory.createImageFromResourceStream(paramResources, null, (InputStream)localObject5, paramSkinData.mFileName, localOptions, localRect, this.s);
        if ((this.backupForOOMData == null) || (!this.backupForOOMData.containsKey(Integer.valueOf(paramInt))) || (this.backupForOOMData.get(Integer.valueOf(paramInt)) == null)) {
          break label1362;
        }
        i1 = 1;
        if (i1 == 0) {
          break label1351;
        }
        localBaseConstantState2 = null;
        localObject3 = (BackupForOOMData)this.backupForOOMData.get(Integer.valueOf(paramInt));
        int i2 = Math.max(Math.min(localOptions.outWidth / 8, localOptions.outHeight / 8), 8);
        i1 = 2;
        if (i1 <= i2)
        {
          localBaseConstantState2 = a(paramResources, paramSkinData, localOptions, localRect, this.s, (BackupForOOMData)localObject3, i1, false);
          if (localBaseConstantState2 == null) {
            break label1368;
          }
        }
        localObject2 = localBaseConstantState2;
        if (localBaseConstantState2 != null) {
          break label1338;
        }
        localObject2 = a(paramResources, paramSkinData, localOptions, localRect, this.s, (BackupForOOMData)localObject3, 1, true);
      }
      catch (IOException localIOException)
      {
        BaseConstantState localBaseConstantState2;
        if (!DEBUG) {
          continue;
        }
        Log.w("SkinEngine", "Bitmap File:" + str + " is not a bitmap or error bitmap");
        h.a("SkinEngine", 1, "res-IOException,file:" + str, localIOException);
      }
      throw localBaseConstantState2;
      label507:
      if (paramSkinData.mFileName.endsWith(".xml"))
      {
        try
        {
          localObject1 = a(paramInt, paramTypedValue);
          if (str == null) {
            break label695;
          }
          if (!this.s) {
            break label687;
          }
          paramTypedValue = new AndroidXmlResourceParser();
        }
        catch (Exception paramResources)
        {
          for (;;)
          {
            h.a("SkinEngine", 1, "res-xml-Exception,file:" + str, paramResources);
            if (!DEBUG) {
              break;
            }
            paramSkinData = new Resources.NotFoundException("File " + paramSkinData.mFileName + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
            paramSkinData.initCause(paramResources);
            throw paramSkinData;
            paramTypedValue = Xml.newPullParser();
          }
          paramResources = ResourcesFactory.a(paramResources, (XmlPullParser)localObject1, null, this.s);
          ((XmlResourceParser)localObject1).close();
          a(paramResources, paramSkinData.mFileName);
          return paramResources;
          return null;
        }
        localObject2 = new FileInputStream(str);
        paramTypedValue.setInput((InputStream)localObject2, "UTF-8");
        paramResources = ResourcesFactory.a(paramResources, (XmlPullParser)localObject1, paramTypedValue, this.s);
        ((FileInputStream)localObject2).close();
        ((XmlResourceParser)localObject1).close();
        return paramResources;
      }
      label687:
      label695:
      if (IS_PROBLEM_CM11) {
        try
        {
          mIconsOfCM.setAccessible(true);
          mIconsOfCM.set(this.mResources, null);
          mComposedIconInfoOfCM.setAccessible(true);
          mComposedIconInfoOfCM.set(this.mResources, null);
          try
          {
            localObject2 = paramResources.openRawResource(paramInt, paramTypedValue);
            localObject5 = paramTypedValue.string.toString();
            localObject1 = localObject2;
            try
            {
              localObject6 = new BitmapFactory.Options();
              localObject1 = localObject2;
            }
            catch (IOException paramResources)
            {
              h.a("SkinEngine", 1, "res-default-IOException,file:" + paramSkinData.mFileName, paramResources);
              if (!DEBUG) {}
            }
          }
          catch (Exception paramResources)
          {
            h.a("SkinEngine", 1, "res-default-Exception,file:" + paramSkinData.mFileName, paramResources);
            return null;
          }
        }
        catch (Exception paramResources)
        {
          try
          {
            mIconsOfCM.setAccessible(true);
            mComposedIconInfoOfCM.setAccessible(true);
            if (mIconsOfCM.get(this.mResources) == null) {
              break label821;
            }
            localObject1 = mComposedIconInfoOfCM.get(this.mResources);
            if (localObject1 == null) {
              break label821;
            }
            return null;
          }
          catch (Exception paramResources)
          {
            return null;
          }
          paramResources = paramResources;
          return null;
        }
      }
      try
      {
        label821:
        localObject3 = ResourcesFactory.createImageFromResourceStream(paramResources, paramTypedValue, (InputStream)localObject2, (String)localObject5, (BitmapFactory.Options)localObject6, localRect, true);
        paramResources = (Resources)localObject3;
        paramTypedValue = (TypedValue)localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError4)
      {
        for (;;)
        {
          localObject1 = localObject2;
          h.a("SkinEngine", 1, "res-default-oom 0,file:" + paramSkinData.mFileName, localOutOfMemoryError4);
          localObject1 = localObject2;
          if (this.m != null)
          {
            localObject1 = localObject2;
            if (this.m.onDecodeOOM(localOutOfMemoryError4, paramSkinData.mFileName, false))
            {
              localObject1 = localObject2;
              ((InputStream)localObject2).close();
              localObject1 = localObject2;
              localObject2 = paramResources.openRawResource(paramInt, paramTypedValue);
              localObject1 = localObject2;
              try
              {
                localObject3 = ResourcesFactory.createImageFromResourceStream(paramResources, paramTypedValue, (InputStream)localObject2, (String)localObject5, (BitmapFactory.Options)localObject6, localRect, true);
                paramResources = (Resources)localObject3;
                paramTypedValue = (TypedValue)localObject2;
              }
              catch (OutOfMemoryError localOutOfMemoryError3)
              {
                localObject1 = localObject2;
                h.a("SkinEngine", 1, "res-default-oom 0,file:" + paramSkinData.mFileName, localOutOfMemoryError4);
                localObject1 = localObject2;
                if (this.m.onSecondDecodeOOM(localOutOfMemoryError3, paramSkinData.mFileName, false))
                {
                  localObject1 = localObject2;
                  ((BitmapFactory.Options)localObject6).inJustDecodeBounds = true;
                  localObject1 = localObject2;
                  localObject2 = paramResources.openRawResource(paramInt, paramTypedValue);
                  localObject1 = localObject2;
                  paramResources = ResourcesFactory.createImageFromResourceStream(paramResources, paramTypedValue, (InputStream)localObject2, (String)localObject5, (BitmapFactory.Options)localObject6, localRect, true);
                  paramTypedValue = (TypedValue)localObject2;
                  continue;
                }
                localObject1 = localObject2;
                throw localOutOfMemoryError3;
              }
              return null;
            }
          }
          paramResources = null;
          paramTypedValue = (TypedValue)localObject2;
        }
      }
      Object localObject1 = paramTypedValue;
      paramTypedValue.close();
      if (paramResources == null)
      {
        localObject1 = paramTypedValue;
        if (this.m != null)
        {
          localObject1 = paramTypedValue;
          this.m.onDecodeReturnNullBitmap(paramSkinData.mFileName, false);
        }
      }
      localObject1 = paramTypedValue;
      a(paramResources, paramSkinData.mFileName);
      return paramResources;
      paramSkinData = new Resources.NotFoundException("File " + paramSkinData.mFileName + " from drawable resource ID #0x" + Integer.toHexString(paramInt) + ", stream type: " + localObject1.getClass().getName());
      paramSkinData.initCause(paramResources);
      throw paramSkinData;
      label1332:
      localObject1 = null;
      continue;
      label1338:
      localObject1 = localObject2;
      Object localObject4 = localObject5;
      if (localObject2 == null)
      {
        label1351:
        localObject1 = localObject6;
        localObject4 = localObject5;
        continue;
        label1362:
        i1 = 0;
        continue;
        label1368:
        i1 *= 2;
      }
    }
  }
  
  private SkinnableColorStateList a(int paramInt, Resources paramResources, SkinData paramSkinData)
  {
    Object localObject;
    synchronized (this.c)
    {
      localObject = paramSkinData.mFilePath;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool)
        {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = ResourcesFactory.a(this, paramResources, new File((String)localObject), this.s);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (!DEBUG) {
              break label126;
            }
          }
          paramResources = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
          paramResources.initCause(localException);
          throw paramResources;
        }
      }
    }
    label126:
    paramSkinData = paramSkinData.mFileName;
    boolean bool = paramSkinData.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.c);
        paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
        if (this.F != null) {
          this.F.tintColorState(paramResources.getColors(), paramResources.getStateSpecs(), paramSkinData);
        }
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramSkinData = new Resources.NotFoundException("File " + paramSkinData + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paramSkinData.initCause(paramResources);
        throw paramSkinData;
      }
    }
    throw new Resources.NotFoundException("File " + paramSkinData + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private String a(Resources paramResources, String paramString)
  {
    String str = this.w + "color/" + paramString;
    try
    {
      if (!this.E.a())
      {
        if (this.E.b(paramString)) {
          return str;
        }
      }
      else
      {
        if (!str.startsWith("/asset/")) {
          break label102;
        }
        paramResources.getAssets().open(str.substring("/asset/".length())).close();
        return str;
      }
    }
    catch (IOException paramResources)
    {
      if (DEBUG) {
        Log.w("SkinEngine", paramResources);
      }
    }
    label102:
    boolean bool;
    do
    {
      return null;
      bool = new File(str).exists();
    } while (!bool);
    return str;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    String str1 = paramXmlPullParser.getName();
    HashMap localHashMap = new HashMap();
    if (str1.equals("resources"))
    {
      i1 = paramXmlPullParser.getDepth();
      for (;;)
      {
        int i2 = paramXmlPullParser.next();
        if ((i2 == 1) || ((paramXmlPullParser.getDepth() < i1 + 1) && (i2 == 3))) {
          break;
        }
        if (i2 == 2)
        {
          String str2 = paramXmlPullParser.getName();
          str1 = paramXmlPullParser.getAttributeValue(null, "name");
          if ("color".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Color.parseColor(paramXmlPullParser.nextText())));
          }
          else if ("dimen".equals(str2))
          {
            str2 = paramXmlPullParser.nextText();
            if (str2.endsWith("dp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("dip")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 3)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("sp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(2, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("px")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(0, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            }
          }
          else if ("bool".equals(str2))
          {
            localHashMap.put(str1, Boolean.valueOf("true".equalsIgnoreCase(paramXmlPullParser.nextText())));
          }
          else if ("integer".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Integer.parseInt(paramXmlPullParser.nextText())));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private static void a()
  {
    if ("huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
      h.c("SkinEngine", 2, "clearSystemSelectorCache start", null);
    }
    try
    {
      Object localObject1 = Class.forName("android.rms.iaware.AwareAppScheduleManager");
      ??? = ((Class)localObject1).getDeclaredMethod("getInstance", new Class[0]);
      localObject1 = ((Class)localObject1).getDeclaredField("mDrawableCaches");
      ??? = ((Method)???).invoke(null, new Object[0]);
      ((Field)localObject1).setAccessible(true);
      synchronized ((SparseArray)((Field)localObject1).get(???))
      {
        ((SparseArray)???).clear();
        ((Field)localObject1).setAccessible(false);
        h.c("SkinEngine", 2, "clearSystemSelectorCache done", null);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      h.a("SkinEngine", 1, "clearSystemSelectorCache fail", localException);
    }
  }
  
  /* Error */
  private void a(Resources paramResources, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_3
    //   4: ifnonnull +20 -> 24
    //   7: aload 10
    //   9: astore 9
    //   11: iload_2
    //   12: ifeq +168 -> 180
    //   15: aload 10
    //   17: astore 9
    //   19: iload 4
    //   21: ifeq +159 -> 180
    //   24: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   27: ifeq +522 -> 549
    //   30: ldc 233
    //   32: ldc_w 731
    //   35: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore 9
    //   40: aload 9
    //   42: iconst_1
    //   43: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   46: aload 9
    //   48: aload_1
    //   49: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 10
    //   54: aload 10
    //   56: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   59: ldc_w 733
    //   62: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: astore 9
    //   67: aload 9
    //   69: iconst_1
    //   70: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   73: aload 9
    //   75: aload 10
    //   77: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 12
    //   82: aload 9
    //   84: astore 11
    //   86: aload 10
    //   88: astore 9
    //   90: aload 12
    //   92: astore 10
    //   94: aload 10
    //   96: instanceof 222
    //   99: ifeq +560 -> 659
    //   102: aload_3
    //   103: ifnull +476 -> 579
    //   106: aload_0
    //   107: aload_0
    //   108: aload_1
    //   109: invokestatic 738	com/tencent/theme/e:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/g;
    //   112: putfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   115: aload_0
    //   116: getfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   119: invokevirtual 740	com/tencent/theme/g:b	()V
    //   122: aload_0
    //   123: new 735	com/tencent/theme/e
    //   126: dup
    //   127: aload_0
    //   128: aload_1
    //   129: aload_3
    //   130: aload 7
    //   132: iconst_1
    //   133: anewarray 222	android/util/LongSparseArray
    //   136: dup
    //   137: iconst_0
    //   138: aload 10
    //   140: checkcast 222	android/util/LongSparseArray
    //   143: aastore
    //   144: invokespecial 743	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   147: putfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   150: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   153: ifeq +485 -> 638
    //   156: aload 9
    //   158: ifnull +480 -> 638
    //   161: aload 11
    //   163: aload 9
    //   165: new 747	com/tencent/theme/f
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   174: invokespecial 750	com/tencent/theme/f:<init>	(ILcom/tencent/theme/e;)V
    //   177: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   183: bipush 23
    //   185: if_icmplt +76 -> 261
    //   188: ldc_w 752
    //   191: getstatic 755	android/os/Build:BRAND	Ljava/lang/String;
    //   194: invokevirtual 665	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   197: istore 8
    //   199: iload 8
    //   201: ifeq +60 -> 261
    //   204: ldc 233
    //   206: ldc_w 757
    //   209: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   212: astore_3
    //   213: aload_3
    //   214: ifnull +637 -> 851
    //   217: aload_3
    //   218: iconst_1
    //   219: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   222: aload_3
    //   223: aload_0
    //   224: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   227: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +565 -> 797
    //   235: aload_3
    //   236: instanceof 759
    //   239: ifeq +558 -> 797
    //   242: aload_3
    //   243: checkcast 759	java/util/Map
    //   246: invokeinterface 760 1 0
    //   251: ldc 47
    //   253: iconst_2
    //   254: ldc_w 762
    //   257: aconst_null
    //   258: invokestatic 685	com/tencent/theme/h:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: ldc 47
    //   263: iconst_2
    //   264: ldc_w 764
    //   267: aconst_null
    //   268: invokestatic 685	com/tencent/theme/h:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: iload 5
    //   273: ifeq +115 -> 388
    //   276: iload 6
    //   278: ifeq +110 -> 388
    //   281: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   284: ifeq +599 -> 883
    //   287: ldc 233
    //   289: ldc_w 731
    //   292: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   295: astore_3
    //   296: aload_3
    //   297: iconst_1
    //   298: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   301: aload_3
    //   302: aload_1
    //   303: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: astore 7
    //   308: aload 7
    //   310: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   313: ldc_w 766
    //   316: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   319: astore_3
    //   320: aload_3
    //   321: iconst_1
    //   322: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   325: aload_3
    //   326: aload 7
    //   328: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 222	android/util/LongSparseArray
    //   334: astore 10
    //   336: aload_3
    //   337: astore 9
    //   339: aload 10
    //   341: astore_3
    //   342: getstatic 138	com/tencent/theme/SkinEngine:a	Z
    //   345: ifeq +575 -> 920
    //   348: aload_0
    //   349: new 768	com/tencent/theme/d
    //   352: dup
    //   353: aload_0
    //   354: aload_1
    //   355: aload_3
    //   356: iload 5
    //   358: iload 6
    //   360: invokespecial 771	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   363: putfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   366: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   369: ifeq +640 -> 1009
    //   372: aload 7
    //   374: ifnull +635 -> 1009
    //   377: aload 9
    //   379: aload 7
    //   381: aload_0
    //   382: getfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   385: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   388: ldc 47
    //   390: iconst_2
    //   391: ldc_w 775
    //   394: aconst_null
    //   395: invokestatic 685	com/tencent/theme/h:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   398: aload_1
    //   399: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   402: astore_3
    //   403: aload_3
    //   404: invokevirtual 520	java/lang/Class:getName	()Ljava/lang/String;
    //   407: ldc_w 777
    //   410: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: ifeq +40 -> 453
    //   416: aload_3
    //   417: ldc_w 779
    //   420: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   423: astore_3
    //   424: aload_3
    //   425: iconst_1
    //   426: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   429: aload_3
    //   430: aload_1
    //   431: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: ifnonnull +19 -> 453
    //   437: aload_3
    //   438: aload_1
    //   439: new 711	android/util/SparseArray
    //   442: dup
    //   443: invokespecial 780	android/util/SparseArray:<init>	()V
    //   446: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   449: iconst_1
    //   450: putstatic 142	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   453: aload_1
    //   454: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   457: ldc_w 782
    //   460: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   463: putstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   466: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   469: iconst_1
    //   470: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   473: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   476: aload_1
    //   477: aconst_null
    //   478: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   481: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   484: iconst_0
    //   485: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   488: aload_1
    //   489: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   492: ldc_w 784
    //   495: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   498: putstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   501: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   504: iconst_1
    //   505: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   508: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   511: aload_1
    //   512: aconst_null
    //   513: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   519: iconst_0
    //   520: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   523: iconst_1
    //   524: putstatic 148	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   527: return
    //   528: astore 9
    //   530: aload 10
    //   532: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   535: invokevirtual 787	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   538: ldc_w 733
    //   541: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   544: astore 9
    //   546: goto -479 -> 67
    //   549: ldc 233
    //   551: ldc_w 733
    //   554: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   557: astore 11
    //   559: aload 11
    //   561: iconst_1
    //   562: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   565: aload 11
    //   567: aload_1
    //   568: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore 10
    //   573: aconst_null
    //   574: astore 9
    //   576: goto -482 -> 94
    //   579: aload_0
    //   580: aload_0
    //   581: aload_1
    //   582: invokestatic 738	com/tencent/theme/e:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/g;
    //   585: putfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   588: aload_0
    //   589: getfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   592: invokevirtual 740	com/tencent/theme/g:b	()V
    //   595: aload_0
    //   596: new 735	com/tencent/theme/e
    //   599: dup
    //   600: aload_0
    //   601: aload_1
    //   602: iload_2
    //   603: iload 4
    //   605: aload 7
    //   607: iconst_1
    //   608: anewarray 222	android/util/LongSparseArray
    //   611: dup
    //   612: iconst_0
    //   613: aload 10
    //   615: checkcast 222	android/util/LongSparseArray
    //   618: aastore
    //   619: invokespecial 790	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;IILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   622: putfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   625: goto -475 -> 150
    //   628: astore_1
    //   629: new 721	com/tencent/theme/UnSupportPlatformException
    //   632: dup
    //   633: aload_1
    //   634: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   637: athrow
    //   638: aload 11
    //   640: aload_1
    //   641: new 747	com/tencent/theme/f
    //   644: dup
    //   645: iconst_0
    //   646: aload_0
    //   647: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   650: invokespecial 750	com/tencent/theme/f:<init>	(ILcom/tencent/theme/e;)V
    //   653: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   656: goto -476 -> 180
    //   659: aload 10
    //   661: instanceof 795
    //   664: ifeq +444 -> 1108
    //   667: aload 10
    //   669: checkcast 795	[Landroid/util/LongSparseArray;
    //   672: checkcast 795	[Landroid/util/LongSparseArray;
    //   675: astore 10
    //   677: aload_3
    //   678: ifnull +70 -> 748
    //   681: aload_0
    //   682: aload_0
    //   683: aload_1
    //   684: invokestatic 738	com/tencent/theme/e:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/g;
    //   687: putfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   690: aload_0
    //   691: getfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   694: invokevirtual 740	com/tencent/theme/g:b	()V
    //   697: aload_0
    //   698: new 735	com/tencent/theme/e
    //   701: dup
    //   702: aload_0
    //   703: aload_1
    //   704: aload_3
    //   705: aload 7
    //   707: aload 10
    //   709: invokespecial 743	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   712: putfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   715: goto +396 -> 1111
    //   718: iload_2
    //   719: aload 10
    //   721: arraylength
    //   722: if_icmpge +386 -> 1108
    //   725: aload 10
    //   727: iload_2
    //   728: new 747	com/tencent/theme/f
    //   731: dup
    //   732: iload_2
    //   733: aload_0
    //   734: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   737: invokespecial 750	com/tencent/theme/f:<init>	(ILcom/tencent/theme/e;)V
    //   740: aastore
    //   741: iload_2
    //   742: iconst_1
    //   743: iadd
    //   744: istore_2
    //   745: goto -27 -> 718
    //   748: aload_0
    //   749: aload_0
    //   750: aload_1
    //   751: invokestatic 738	com/tencent/theme/e:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/g;
    //   754: putfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   757: aload_0
    //   758: getfield 568	com/tencent/theme/SkinEngine:E	Lcom/tencent/theme/g;
    //   761: invokevirtual 740	com/tencent/theme/g:b	()V
    //   764: aload_0
    //   765: new 735	com/tencent/theme/e
    //   768: dup
    //   769: aload_0
    //   770: aload_1
    //   771: iload_2
    //   772: iload 4
    //   774: aload 7
    //   776: aload 10
    //   778: invokespecial 790	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;IILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   781: putfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   784: goto +327 -> 1111
    //   787: astore_1
    //   788: new 721	com/tencent/theme/UnSupportPlatformException
    //   791: dup
    //   792: aload_1
    //   793: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   796: athrow
    //   797: ldc 47
    //   799: iconst_1
    //   800: new 312	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 797
    //   810: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_3
    //   814: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: aconst_null
    //   821: invokestatic 685	com/tencent/theme/h:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   824: goto -563 -> 261
    //   827: astore_3
    //   828: ldc 47
    //   830: iconst_1
    //   831: ldc_w 802
    //   834: aload_3
    //   835: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   838: goto -577 -> 261
    //   841: astore_1
    //   842: new 721	com/tencent/theme/UnSupportPlatformException
    //   845: dup
    //   846: aload_1
    //   847: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   850: athrow
    //   851: ldc 47
    //   853: iconst_1
    //   854: ldc_w 804
    //   857: aconst_null
    //   858: invokestatic 685	com/tencent/theme/h:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   861: goto -600 -> 261
    //   864: astore_3
    //   865: aload 7
    //   867: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   870: invokevirtual 787	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   873: ldc_w 766
    //   876: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   879: astore_3
    //   880: goto -560 -> 320
    //   883: ldc 233
    //   885: ldc_w 806
    //   888: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   891: astore 10
    //   893: aload 10
    //   895: iconst_1
    //   896: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   899: aload 10
    //   901: aload_1
    //   902: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   905: checkcast 222	android/util/LongSparseArray
    //   908: astore_3
    //   909: aload 9
    //   911: astore 7
    //   913: aload 10
    //   915: astore 9
    //   917: goto -575 -> 342
    //   920: aload_0
    //   921: new 808	com/tencent/theme/b
    //   924: dup
    //   925: aload_0
    //   926: aload_1
    //   927: aload_3
    //   928: iload 5
    //   930: iload 6
    //   932: invokespecial 809	com/tencent/theme/b:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   935: putfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   938: goto -572 -> 366
    //   941: astore_3
    //   942: ldc 233
    //   944: ldc_w 811
    //   947: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   950: astore 7
    //   952: aload 7
    //   954: iconst_1
    //   955: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   958: aload 7
    //   960: aload_1
    //   961: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: astore 9
    //   966: aload 9
    //   968: instanceof 711
    //   971: ifeq +51 -> 1022
    //   974: aload_0
    //   975: new 813	com/tencent/theme/c
    //   978: dup
    //   979: aload_0
    //   980: aload_1
    //   981: aload 9
    //   983: checkcast 711	android/util/SparseArray
    //   986: iload 5
    //   988: iload 6
    //   990: invokespecial 816	com/tencent/theme/c:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;II)V
    //   993: putfield 818	com/tencent/theme/SkinEngine:B	Lcom/tencent/theme/c;
    //   996: aload 7
    //   998: aload_1
    //   999: aload_0
    //   1000: getfield 818	com/tencent/theme/SkinEngine:B	Lcom/tencent/theme/c;
    //   1003: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1006: goto -618 -> 388
    //   1009: aload 9
    //   1011: aload_1
    //   1012: aload_0
    //   1013: getfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   1016: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1019: goto -631 -> 388
    //   1022: aload 9
    //   1024: instanceof 222
    //   1027: ifeq +38 -> 1065
    //   1030: aload_0
    //   1031: new 808	com/tencent/theme/b
    //   1034: dup
    //   1035: aload_0
    //   1036: aload_1
    //   1037: aload 9
    //   1039: checkcast 222	android/util/LongSparseArray
    //   1042: iload 5
    //   1044: iload 6
    //   1046: invokespecial 809	com/tencent/theme/b:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   1049: putfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   1052: aload 7
    //   1054: aload_1
    //   1055: aload_0
    //   1056: getfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   1059: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1062: goto -674 -> 388
    //   1065: new 721	com/tencent/theme/UnSupportPlatformException
    //   1068: dup
    //   1069: aload_3
    //   1070: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   1073: athrow
    //   1074: astore_3
    //   1075: getstatic 118	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1078: ifeq +13 -> 1091
    //   1081: ldc 47
    //   1083: ldc_w 820
    //   1086: aload_3
    //   1087: invokestatic 823	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1090: pop
    //   1091: iconst_0
    //   1092: putstatic 142	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   1095: goto -642 -> 453
    //   1098: astore_1
    //   1099: aconst_null
    //   1100: putstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1103: aconst_null
    //   1104: putstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1107: return
    //   1108: goto -928 -> 180
    //   1111: iconst_0
    //   1112: istore_2
    //   1113: goto -395 -> 718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	this	SkinEngine
    //   0	1116	1	paramResources	Resources
    //   0	1116	2	paramInt1	int
    //   0	1116	3	paramArrayOfInt	int[]
    //   0	1116	4	paramInt2	int
    //   0	1116	5	paramInt3	int
    //   0	1116	6	paramInt4	int
    //   0	1116	7	paramFile	File
    //   197	3	8	bool	boolean
    //   9	369	9	localObject1	Object
    //   528	1	9	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   544	494	9	localObject2	Object
    //   1	913	10	localObject3	Object
    //   84	555	11	localObject4	Object
    //   80	11	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	67	528	java/lang/NoSuchFieldException
    //   24	54	628	java/lang/IllegalArgumentException
    //   54	67	628	java/lang/IllegalArgumentException
    //   67	82	628	java/lang/IllegalArgumentException
    //   94	102	628	java/lang/IllegalArgumentException
    //   106	150	628	java/lang/IllegalArgumentException
    //   150	156	628	java/lang/IllegalArgumentException
    //   161	180	628	java/lang/IllegalArgumentException
    //   180	199	628	java/lang/IllegalArgumentException
    //   204	213	628	java/lang/IllegalArgumentException
    //   217	231	628	java/lang/IllegalArgumentException
    //   235	261	628	java/lang/IllegalArgumentException
    //   261	271	628	java/lang/IllegalArgumentException
    //   281	308	628	java/lang/IllegalArgumentException
    //   308	320	628	java/lang/IllegalArgumentException
    //   320	336	628	java/lang/IllegalArgumentException
    //   342	366	628	java/lang/IllegalArgumentException
    //   366	372	628	java/lang/IllegalArgumentException
    //   377	388	628	java/lang/IllegalArgumentException
    //   388	398	628	java/lang/IllegalArgumentException
    //   530	546	628	java/lang/IllegalArgumentException
    //   549	573	628	java/lang/IllegalArgumentException
    //   579	625	628	java/lang/IllegalArgumentException
    //   638	656	628	java/lang/IllegalArgumentException
    //   659	677	628	java/lang/IllegalArgumentException
    //   681	715	628	java/lang/IllegalArgumentException
    //   718	741	628	java/lang/IllegalArgumentException
    //   748	784	628	java/lang/IllegalArgumentException
    //   797	824	628	java/lang/IllegalArgumentException
    //   828	838	628	java/lang/IllegalArgumentException
    //   851	861	628	java/lang/IllegalArgumentException
    //   865	880	628	java/lang/IllegalArgumentException
    //   883	909	628	java/lang/IllegalArgumentException
    //   920	938	628	java/lang/IllegalArgumentException
    //   942	1006	628	java/lang/IllegalArgumentException
    //   1009	1019	628	java/lang/IllegalArgumentException
    //   1022	1062	628	java/lang/IllegalArgumentException
    //   1065	1074	628	java/lang/IllegalArgumentException
    //   24	54	787	java/lang/NoSuchFieldException
    //   67	82	787	java/lang/NoSuchFieldException
    //   94	102	787	java/lang/NoSuchFieldException
    //   106	150	787	java/lang/NoSuchFieldException
    //   150	156	787	java/lang/NoSuchFieldException
    //   161	180	787	java/lang/NoSuchFieldException
    //   180	199	787	java/lang/NoSuchFieldException
    //   204	213	787	java/lang/NoSuchFieldException
    //   217	231	787	java/lang/NoSuchFieldException
    //   235	261	787	java/lang/NoSuchFieldException
    //   261	271	787	java/lang/NoSuchFieldException
    //   281	308	787	java/lang/NoSuchFieldException
    //   320	336	787	java/lang/NoSuchFieldException
    //   342	366	787	java/lang/NoSuchFieldException
    //   366	372	787	java/lang/NoSuchFieldException
    //   377	388	787	java/lang/NoSuchFieldException
    //   388	398	787	java/lang/NoSuchFieldException
    //   530	546	787	java/lang/NoSuchFieldException
    //   549	573	787	java/lang/NoSuchFieldException
    //   579	625	787	java/lang/NoSuchFieldException
    //   638	656	787	java/lang/NoSuchFieldException
    //   659	677	787	java/lang/NoSuchFieldException
    //   681	715	787	java/lang/NoSuchFieldException
    //   718	741	787	java/lang/NoSuchFieldException
    //   748	784	787	java/lang/NoSuchFieldException
    //   797	824	787	java/lang/NoSuchFieldException
    //   828	838	787	java/lang/NoSuchFieldException
    //   851	861	787	java/lang/NoSuchFieldException
    //   865	880	787	java/lang/NoSuchFieldException
    //   883	909	787	java/lang/NoSuchFieldException
    //   920	938	787	java/lang/NoSuchFieldException
    //   942	1006	787	java/lang/NoSuchFieldException
    //   1009	1019	787	java/lang/NoSuchFieldException
    //   1022	1062	787	java/lang/NoSuchFieldException
    //   1065	1074	787	java/lang/NoSuchFieldException
    //   204	213	827	java/lang/Throwable
    //   217	231	827	java/lang/Throwable
    //   235	261	827	java/lang/Throwable
    //   797	824	827	java/lang/Throwable
    //   851	861	827	java/lang/Throwable
    //   24	54	841	java/lang/IllegalAccessException
    //   54	67	841	java/lang/IllegalAccessException
    //   67	82	841	java/lang/IllegalAccessException
    //   94	102	841	java/lang/IllegalAccessException
    //   106	150	841	java/lang/IllegalAccessException
    //   150	156	841	java/lang/IllegalAccessException
    //   161	180	841	java/lang/IllegalAccessException
    //   180	199	841	java/lang/IllegalAccessException
    //   204	213	841	java/lang/IllegalAccessException
    //   217	231	841	java/lang/IllegalAccessException
    //   235	261	841	java/lang/IllegalAccessException
    //   261	271	841	java/lang/IllegalAccessException
    //   281	308	841	java/lang/IllegalAccessException
    //   308	320	841	java/lang/IllegalAccessException
    //   320	336	841	java/lang/IllegalAccessException
    //   342	366	841	java/lang/IllegalAccessException
    //   366	372	841	java/lang/IllegalAccessException
    //   377	388	841	java/lang/IllegalAccessException
    //   388	398	841	java/lang/IllegalAccessException
    //   530	546	841	java/lang/IllegalAccessException
    //   549	573	841	java/lang/IllegalAccessException
    //   579	625	841	java/lang/IllegalAccessException
    //   638	656	841	java/lang/IllegalAccessException
    //   659	677	841	java/lang/IllegalAccessException
    //   681	715	841	java/lang/IllegalAccessException
    //   718	741	841	java/lang/IllegalAccessException
    //   748	784	841	java/lang/IllegalAccessException
    //   797	824	841	java/lang/IllegalAccessException
    //   828	838	841	java/lang/IllegalAccessException
    //   851	861	841	java/lang/IllegalAccessException
    //   865	880	841	java/lang/IllegalAccessException
    //   883	909	841	java/lang/IllegalAccessException
    //   920	938	841	java/lang/IllegalAccessException
    //   942	1006	841	java/lang/IllegalAccessException
    //   1009	1019	841	java/lang/IllegalAccessException
    //   1022	1062	841	java/lang/IllegalAccessException
    //   1065	1074	841	java/lang/IllegalAccessException
    //   308	320	864	java/lang/NoSuchFieldException
    //   281	308	941	java/lang/Exception
    //   308	320	941	java/lang/Exception
    //   320	336	941	java/lang/Exception
    //   342	366	941	java/lang/Exception
    //   366	372	941	java/lang/Exception
    //   377	388	941	java/lang/Exception
    //   865	880	941	java/lang/Exception
    //   883	909	941	java/lang/Exception
    //   920	938	941	java/lang/Exception
    //   1009	1019	941	java/lang/Exception
    //   398	453	1074	java/lang/Exception
    //   453	527	1098	java/lang/Exception
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.E.a())
    {
      paramResources = this.E.a(paramString);
      if (paramResources != null)
      {
        paramTypedValue.string = (this.w + paramArrayOfString[paramResources.intValue()] + paramString);
        paramTypedValue.density = paramArrayOfInt[paramResources.intValue()];
        return;
      }
      paramTypedValue.string = null;
      paramTypedValue.density = 0;
      return;
    }
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      do
      {
        try
        {
          String str = this.w + paramArrayOfString[i1] + paramString;
          if (!str.startsWith("/asset/")) {
            continue;
          }
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        catch (IOException localIOException)
        {
          if (DEBUG) {
            Log.w("SkinEngine", localIOException);
          }
          i1 += 1;
        }
        break;
      } while (!new File(localIOException).exists());
      paramTypedValue.string = localIOException;
      paramTypedValue.density = paramArrayOfInt[i1];
      return;
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  private void a(TypedValue paramTypedValue)
  {
    synchronized (this.G)
    {
      if (this.d == null) {
        this.d = paramTypedValue;
      }
      return;
    }
  }
  
  private void a(BaseConstantState paramBaseConstantState)
  {
    SkinData localSkinData = paramBaseConstantState.skinData;
    Object localObject = localSkinData.mFilePath;
    if (this.w != null)
    {
      this.c.resourceId = localSkinData.mResourcesID;
      a(this.mResources, this.c, localSkinData.mFileName, e[this.y], f[this.y]);
      if (this.c.string != null)
      {
        localSkinData.mFilePath = this.c.string.toString();
        localSkinData.mInDensity = this.c.density;
        if (b(localSkinData.mFileName)) {
          h.a("SkinEngine", a(localSkinData.mFileName), "SkinEngine reloadImage : cs -> " + paramBaseConstantState + ",fileName -> " + localSkinData.mFileName + ", mFilePath -> " + localSkinData.mFilePath + ", oldFilePath -> " + (String)localObject + ", resourceID -> " + localSkinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.t.size());
        }
        if ((localObject != null) || (localSkinData.mFilePath != null) || (localSkinData.mFileName.endsWith(".xml")) || (this.F == null) || (this.F.isTint(localSkinData.mFileName))) {
          break label344;
        }
        if ((!(paramBaseConstantState instanceof SkinnableBitmapDrawable.a)) || (((SkinnableBitmapDrawable.a)paramBaseConstantState).d == null)) {
          break label314;
        }
        ((SkinnableBitmapDrawable.a)paramBaseConstantState).d.setColorFilter(null);
      }
    }
    label314:
    label344:
    BaseConstantState localBaseConstantState;
    label534:
    label805:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localSkinData.mFilePath = null;
            break;
            localSkinData.mFilePath = null;
            break;
          } while ((!(paramBaseConstantState instanceof SkinnableNinePatchDrawable.a)) || (((SkinnableNinePatchDrawable.a)paramBaseConstantState).h == null));
          ((SkinnableNinePatchDrawable.a)paramBaseConstantState).h.setColorFilter(null);
          return;
          if (!(paramBaseConstantState instanceof SkinnableBitmapDrawable.a)) {
            break label805;
          }
          paramBaseConstantState = (SkinnableBitmapDrawable.a)paramBaseConstantState;
          localBaseConstantState = a(localSkinData.mResourcesID, this.mResources, localSkinData, this.c);
          if (localBaseConstantState != null) {
            break label534;
          }
          if (b(localSkinData.mFileName)) {
            h.a("SkinEngine", a(localSkinData.mFileName), "SkinEngine reloadImage : _loadImage fail, fileName -> " + localSkinData.mFileName + ", mFilePath -> " + localSkinData.mFilePath + ", resourceID -> " + localSkinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.t.size());
          }
        } while (!DEBUG);
        throw new NullPointerException("loadImage failed, file path: " + localSkinData.mFilePath + " , resource name:" + localSkinData.mFileName);
        if ((DEBUG) && ((localBaseConstantState instanceof SkinnableNinePatchDrawable.a))) {
          throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + localSkinData.mFilePath + " , resource name:" + localSkinData.mFileName);
        }
        if (b(localSkinData.mFileName)) {
          h.a("SkinEngine", a(localSkinData.mFileName), "SkinEngine reloadImage : _loadImage success, fileName -> " + localSkinData.mFileName + ", mFilePath -> " + localSkinData.mFilePath + ", oldFilePath -> " + (String)localObject + ", resourceID -> " + localSkinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.t.size());
        }
        localObject = (SkinnableBitmapDrawable.a)localBaseConstantState;
        paramBaseConstantState.a = ((SkinnableBitmapDrawable.a)localObject).a;
        paramBaseConstantState.bitmapType = ((SkinnableBitmapDrawable.a)localObject).bitmapType;
        paramBaseConstantState.hasProblem = ((SkinnableBitmapDrawable.a)localObject).hasProblem;
        paramBaseConstantState.d = ((SkinnableBitmapDrawable.a)localObject).d;
        paramBaseConstantState.mImageSizeWhenOOM = ((SkinnableBitmapDrawable.a)localObject).mImageSizeWhenOOM;
        if ((paramBaseConstantState.h) || (((SkinnableBitmapDrawable.a)localObject).h))
        {
          paramBaseConstantState.c = ((SkinnableBitmapDrawable.a)localObject).c;
          paramBaseConstantState.e = ((SkinnableBitmapDrawable.a)localObject).e;
          paramBaseConstantState.f = ((SkinnableBitmapDrawable.a)localObject).f;
          paramBaseConstantState.h = true;
        }
        a((BaseConstantState)localObject, localSkinData.mFileName);
        return;
      } while (!(paramBaseConstantState instanceof SkinnableNinePatchDrawable.a));
      paramBaseConstantState = (SkinnableNinePatchDrawable.a)paramBaseConstantState;
      localBaseConstantState = a(localSkinData.mResourcesID, this.mResources, localSkinData, this.c);
      if (localBaseConstantState != null) {
        break label995;
      }
      if (b(localSkinData.mFileName)) {
        h.a("SkinEngine", a(localSkinData.mFileName), "SkinEngine reloadImage : _loadImage fail, fileName -> " + localSkinData.mFileName + ", mFilePath -> " + localSkinData.mFilePath + ", resourceID -> " + localSkinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.t.size());
      }
    } while (!DEBUG);
    throw new NullPointerException("loadImage failed, file path: " + localSkinData.mFilePath + " , resource name:" + localSkinData.mFileName);
    label995:
    if ((DEBUG) && ((localBaseConstantState instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + localSkinData.mFilePath + " , resource name:" + localSkinData.mFileName);
    }
    if (b(localSkinData.mFileName)) {
      h.a("SkinEngine", a(localSkinData.mFileName), "SkinEngine reloadImage : _loadImage success, fileName -> " + localSkinData.mFileName + ", mFilePath -> " + localSkinData.mFilePath + ", oldFilePath -> " + (String)localObject + ", resourceID -> " + localSkinData.mResourcesID + "Current Thread:" + Thread.currentThread().getName() + ", cacheSize: " + this.t.size());
    }
    localObject = (SkinnableNinePatchDrawable.a)localBaseConstantState;
    paramBaseConstantState.mImageSizeWhenOOM = ((SkinnableNinePatchDrawable.a)localObject).mImageSizeWhenOOM;
    paramBaseConstantState.a = ((SkinnableNinePatchDrawable.a)localObject).a;
    paramBaseConstantState.h = ((SkinnableNinePatchDrawable.a)localObject).h;
    paramBaseConstantState.c = paramBaseConstantState.b;
    paramBaseConstantState.b = ((SkinnableNinePatchDrawable.a)localObject).b;
    paramBaseConstantState.g = ((SkinnableNinePatchDrawable.a)localObject).g;
    paramBaseConstantState.hasProblem = ((SkinnableNinePatchDrawable.a)localObject).hasProblem;
    a((BaseConstantState)localObject, localSkinData.mFileName);
  }
  
  private void a(BaseConstantState paramBaseConstantState, String paramString)
  {
    if ((this.F != null) && (paramBaseConstantState != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!(paramBaseConstantState instanceof SkinnableBitmapDrawable.a)) || (((SkinnableBitmapDrawable.a)paramBaseConstantState).d == null)) {
        break label55;
      }
      paramBaseConstantState = ((SkinnableBitmapDrawable.a)paramBaseConstantState).d;
    }
    for (;;)
    {
      this.F.tint(paramBaseConstantState, paramString);
      return;
      label55:
      if (((paramBaseConstantState instanceof SkinnableNinePatchDrawable.a)) && (((SkinnableNinePatchDrawable.a)paramBaseConstantState).a != null)) {
        paramBaseConstantState = ((SkinnableNinePatchDrawable.a)paramBaseConstantState).h;
      } else {
        paramBaseConstantState = null;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.C == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.C = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.D == null)
      {
        if (this.w == null) {
          this.D = new HashMap();
        }
      }
      else {
        return;
      }
    }
    catch (XmlPullParserException localXmlPullParserException1)
    {
      localObject = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
      ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException1);
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException1)
    {
      Object localObject;
      for (;;)
      {
        this.C = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        AndroidXmlResourceParser localAndroidXmlResourceParser = new AndroidXmlResourceParser();
        localObject = new FileInputStream(new File(this.w, "xml/theme_config.xml"));
        localAndroidXmlResourceParser.setInput((InputStream)localObject, "UTF-8");
        this.D = a(localAndroidXmlResourceParser);
        ((FileInputStream)localObject).close();
        return;
      }
      catch (XmlPullParserException localXmlPullParserException2)
      {
        for (;;)
        {
          localObject = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
          ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException2);
          throw ((Throwable)localObject);
          XmlPullParser localXmlPullParser = Xml.newPullParser();
        }
      }
      catch (IOException localIOException2)
      {
        this.D = new HashMap();
      }
    }
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new BufferedInputStream(new FileInputStream(new File(paramString)));
  }
  
  @TargetApi(16)
  private void b()
  {
    this.p.writeLock().lock();
    for (;;)
    {
      int i1;
      try
      {
        localArrayList = new ArrayList();
        int i2 = this.t.size();
        i1 = 0;
        if (i1 < i2) {
          try
          {
            Object localObject1 = (WeakReference)this.t.valueAt(i1);
            if (localObject1 == null) {
              break label179;
            }
            localObject1 = (BaseConstantState)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              break label179;
            }
            if (((BaseConstantState)localObject1).skinData.mFileName.endsWith(".xml")) {
              localArrayList.add(localObject1);
            }
          }
          catch (ClassCastException localClassCastException)
          {
            h.a("SkinEngine", 1, "updateImage()", localClassCastException);
            BaseConstantState localBaseConstantState = null;
            continue;
            a(localBaseConstantState);
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList;
        return;
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          a((BaseConstantState)localIterator.next());
          continue;
        }
      }
      finally
      {
        this.p.writeLock().unlock();
      }
      return;
      label179:
      i1 += 1;
    }
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    this.q.writeLock().lock();
    int i1 = 0;
    for (;;)
    {
      SkinData localSkinData;
      try
      {
        int i2 = this.u.size();
        if (i1 >= i2) {
          break;
        }
        try
        {
          paramContext = (WeakReference)this.u.valueAt(i1);
          if (paramContext == null) {
            i1 += 1;
          }
        }
        catch (ClassCastException paramContext)
        {
          h.a("SkinEngine", 1, "updateColorState()", paramContext);
          paramContext = null;
          continue;
          paramContext = (SkinnableColorStateList)paramContext.get();
          if (paramContext == null) {
            continue;
          }
          localSkinData = paramContext.skinData;
          str1 = localSkinData.mFilePath;
          if (this.w == null) {
            break label204;
          }
        }
        String str2 = a(this.mResources, localSkinData.mFileName);
        if (str2 == null) {
          continue;
        }
        localSkinData.mFilePath = str2;
      }
      catch (Exception paramContext)
      {
        String str1;
        return;
        localSkinData.mFilePath = null;
        continue;
      }
      finally
      {
        this.q.writeLock().unlock();
      }
      if ((str1 == null) && (localSkinData.mFilePath == null))
      {
        if (this.F != null)
        {
          this.F.tintColorState(paramContext.getColors(), paramContext.getStateSpecs(), paramContext.skinData.mFileName);
          continue;
          label204:
          localSkinData.mFilePath = null;
        }
      }
      else {
        paramContext.a(a(localSkinData.mResourcesID, this.mResources, localSkinData));
      }
    }
    this.q.writeLock().unlock();
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.contains("qq_pic_img_checkbox_deselect")) || (paramString.contains("qq_pic_img_checkbox_select")) || (paramString.contains("skin_tab_icon_see")) || (paramString.contains("skin_tab_icon_conversation")) || (paramString.contains("skin_tab_icon_plugin")) || (paramString.contains("skin_tab_icon_contact")) || (paramString.contains("skin_list_item_normal_theme_version2")) || (paramString.contains("skin_list_item_pressed_theme_version2")));
  }
  
  private TypedValue c()
  {
    synchronized (this.G)
    {
      if (this.d != null)
      {
        TypedValue localTypedValue = this.d;
        this.d = null;
      }
      if (this.d == null) {
        return new TypedValue();
      }
    }
    return this.d;
  }
  
  public static long dumpDrawableCacheMemSize()
  {
    SkinEngine localSkinEngine = getInstances();
    TypedValue localTypedValue = new TypedValue();
    long l2 = 0L;
    int i2 = 0;
    Object localObject;
    long l3;
    long l1;
    int i1;
    if (i2 < localSkinEngine.t.size())
    {
      localObject = (WeakReference)localSkinEngine.t.valueAt(i2);
      l3 = localSkinEngine.t.keyAt(i2);
      l1 = l2;
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        l1 = l2;
        if (localObject != null)
        {
          if (!(localObject instanceof SkinnableBitmapDrawable.a)) {
            break label193;
          }
          i1 = a(((SkinnableBitmapDrawable.a)localObject).a);
        }
      }
    }
    for (;;)
    {
      l2 += i1;
      localSkinEngine.mResources.getValue((int)l3, localTypedValue, true);
      l1 = l2;
      if (localTypedValue.string != null)
      {
        h.d("SkinEngine", 4, "res:" + localTypedValue.string.toString() + ",size=" + i1, null);
        l1 = l2;
      }
      i2 += 1;
      l2 = l1;
      break;
      label193:
      if ((localObject instanceof SkinnableNinePatchDrawable.a))
      {
        i1 = a(((SkinnableNinePatchDrawable.a)localObject).g);
        continue;
        h.c("SkinEngine", 4, "Total DrawableNum=" + localSkinEngine.t.size() + ",MemSize=" + l2, null);
        return l2;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (o == null) {
        o = new SkinEngine();
      }
      SkinEngine localSkinEngine = o;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, File paramFile)
    throws UnSupportPlatformException
  {
    Object localObject = new StringBuilder().append("init cacheFile:");
    if (paramFile == null) {}
    for (boolean bool = true;; bool = false)
    {
      h.c("SkinEngine", 2, bool, null);
      localObject = getInstances();
      Resources localResources = paramContext.getResources();
      ((SkinEngine)localObject).mResources = localResources;
      isSupportPlatform(paramContext, localResources);
      ((SkinEngine)localObject).y = a(((SkinEngine)localObject).mResources);
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
      ((SkinEngine)localObject).w = localSharedPreferences.getString("theme_root", null);
      if ((((SkinEngine)localObject).F != null) && (((SkinEngine)localObject).w != null)) {
        ((SkinEngine)localObject).F.loadConfig(localResources, ((SkinEngine)localObject).w + File.separator + "config.json");
      }
      TextHook.getInstance().switchFont(paramContext, localSharedPreferences.getString("theme_font_root", null));
      paramContext.getApplicationContext().registerReceiver(((SkinEngine)localObject).n, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
      ((SkinEngine)localObject).a(localResources, paramInt1, null, paramInt2, paramInt3, paramInt4, paramFile);
      ((SkinEngine)localObject).s = localSharedPreferences.getBoolean("complied", true);
      a();
      return;
    }
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.y = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.n, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, 0, paramArrayOfInt, 0, paramInt1, paramInt2, paramFile);
    paramArrayOfInt = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.w = paramArrayOfInt.getString("theme_root", null);
    if ((localSkinEngine.F != null) && (localSkinEngine.w != null)) {
      localSkinEngine.F.loadConfig(localResources, localSkinEngine.w + File.separator + "config.json");
    }
    TextHook.getInstance().switchFont(paramContext, paramArrayOfInt.getString("theme_font_root", null));
    localSkinEngine.s = paramArrayOfInt.getBoolean("complied", true);
    a();
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject = paramView.getBackground();
    Rect localRect;
    if (localObject != null)
    {
      if (!(localObject instanceof DrawableContainer)) {
        break label270;
      }
      localRect = new Rect();
      ((Drawable)localObject).getPadding(localRect);
      if ((localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
      {
        SkinnableActivityProcesser.a((Drawable)localObject);
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      if ((paramView instanceof SkinnableView)) {
        ((SkinnableView)paramView).onThemeChanged();
      }
      if (!(paramView instanceof ImageView)) {
        break label428;
      }
      localObject = ((ImageView)paramView).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject);
      ((ImageView)paramView).setImageDrawable(null);
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView.destroyDrawingCache();
      paramView.refreshDrawableState();
      paramView.invalidate();
      paramView.requestLayout();
      return;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      int i3 = paramView.getPaddingLeft();
      int i4 = paramView.getPaddingRight();
      SkinnableActivityProcesser.a((Drawable)localObject);
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      paramView.setPadding(i3, i1, i4, i2);
      break;
      label270:
      if ((localObject instanceof SkinnableNinePatchDrawable))
      {
        localRect = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject).a(localRect)) && (localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject);
          break;
        }
        i1 = paramView.getPaddingTop();
        i2 = paramView.getPaddingBottom();
        i3 = paramView.getPaddingLeft();
        i4 = paramView.getPaddingRight();
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
        paramView.setPadding(i3, i1, i4, i2);
        break;
      }
      if (!(localObject instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      break;
      label428:
      if ((paramView instanceof TextView))
      {
        localObject = ((TextView)paramView).getCompoundDrawables();
        if ((localObject[0] != null) || (localObject[1] != null) || (localObject[2] != null) || (localObject[3] != null))
        {
          ((TextView)paramView).setCompoundDrawables(null, null, null, null);
          ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(localObject[0], localObject[1], localObject[2], localObject[3]);
        }
      }
    }
  }
  
  /* Error */
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   3: ifeq +102 -> 105
    //   6: ldc 233
    //   8: ldc_w 731
    //   11: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   14: astore_3
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: ldc_w 733
    //   35: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore_3
    //   39: aload_3
    //   40: iconst_1
    //   41: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: instanceof 222
    //   55: ifne +73 -> 128
    //   58: aload_3
    //   59: instanceof 795
    //   62: ifne +66 -> 128
    //   65: new 721	com/tencent/theme/UnSupportPlatformException
    //   68: dup
    //   69: ldc_w 1258
    //   72: invokespecial 1259	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_0
    //   77: new 721	com/tencent/theme/UnSupportPlatformException
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_3
    //   87: aload 4
    //   89: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   92: invokevirtual 787	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   95: ldc_w 733
    //   98: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore_3
    //   102: goto -63 -> 39
    //   105: ldc 233
    //   107: ldc_w 733
    //   110: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   113: astore_3
    //   114: aload_3
    //   115: iconst_1
    //   116: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   119: aload_3
    //   120: aload_1
    //   121: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_3
    //   125: goto -74 -> 51
    //   128: getstatic 140	com/tencent/theme/SkinEngine:b	Z
    //   131: ifeq +145 -> 276
    //   134: ldc 233
    //   136: ldc_w 731
    //   139: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: astore_3
    //   143: aload_3
    //   144: iconst_1
    //   145: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   148: aload_3
    //   149: aload_1
    //   150: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   160: ldc_w 766
    //   163: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   166: astore_3
    //   167: aload_3
    //   168: iconst_1
    //   169: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   172: aload_3
    //   173: aload 4
    //   175: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   178: astore_3
    //   179: aload_3
    //   180: instanceof 222
    //   183: ifne +47 -> 230
    //   186: new 721	com/tencent/theme/UnSupportPlatformException
    //   189: dup
    //   190: ldc_w 1261
    //   193: invokespecial 1259	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_3
    //   198: ldc 233
    //   200: ldc_w 811
    //   203: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   206: astore 4
    //   208: aload 4
    //   210: iconst_1
    //   211: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   214: aload 4
    //   216: aload_1
    //   217: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: astore_1
    //   221: aload_1
    //   222: instanceof 711
    //   225: istore_2
    //   226: iload_2
    //   227: ifeq +72 -> 299
    //   230: aload_0
    //   231: ldc_w 1263
    //   234: invokestatic 1268	com/tencent/theme/j:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   237: ldc_w 1270
    //   240: invokevirtual 665	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   243: ifeq +92 -> 335
    //   246: new 721	com/tencent/theme/UnSupportPlatformException
    //   249: dup
    //   250: ldc_w 1272
    //   253: invokespecial 1259	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   256: athrow
    //   257: astore_3
    //   258: aload 4
    //   260: invokevirtual 515	java/lang/Object:getClass	()Ljava/lang/Class;
    //   263: invokevirtual 787	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   266: ldc_w 766
    //   269: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   272: astore_3
    //   273: goto -106 -> 167
    //   276: ldc 233
    //   278: ldc_w 806
    //   281: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   284: astore_3
    //   285: aload_3
    //   286: iconst_1
    //   287: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   290: aload_3
    //   291: aload_1
    //   292: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: astore_3
    //   296: goto -117 -> 179
    //   299: aload_1
    //   300: instanceof 222
    //   303: ifne -73 -> 230
    //   306: new 721	com/tencent/theme/UnSupportPlatformException
    //   309: dup
    //   310: aload_3
    //   311: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   314: athrow
    //   315: astore_0
    //   316: new 721	com/tencent/theme/UnSupportPlatformException
    //   319: dup
    //   320: aload_0
    //   321: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   324: athrow
    //   325: astore_0
    //   326: new 721	com/tencent/theme/UnSupportPlatformException
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 793	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   334: athrow
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramContext	Context
    //   0	336	1	paramResources	Resources
    //   225	2	2	bool	boolean
    //   14	45	3	localObject1	Object
    //   86	1	3	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   101	79	3	localObject2	Object
    //   197	1	3	localException	Exception
    //   257	1	3	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   272	39	3	localObject3	Object
    //   25	234	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	27	76	java/lang/IllegalArgumentException
    //   27	39	76	java/lang/IllegalArgumentException
    //   39	51	76	java/lang/IllegalArgumentException
    //   51	76	76	java/lang/IllegalArgumentException
    //   87	102	76	java/lang/IllegalArgumentException
    //   105	125	76	java/lang/IllegalArgumentException
    //   128	155	76	java/lang/IllegalArgumentException
    //   155	167	76	java/lang/IllegalArgumentException
    //   167	179	76	java/lang/IllegalArgumentException
    //   179	197	76	java/lang/IllegalArgumentException
    //   198	226	76	java/lang/IllegalArgumentException
    //   258	273	76	java/lang/IllegalArgumentException
    //   276	296	76	java/lang/IllegalArgumentException
    //   299	315	76	java/lang/IllegalArgumentException
    //   27	39	86	java/lang/NoSuchFieldException
    //   128	155	197	java/lang/Exception
    //   155	167	197	java/lang/Exception
    //   167	179	197	java/lang/Exception
    //   179	197	197	java/lang/Exception
    //   258	273	197	java/lang/Exception
    //   276	296	197	java/lang/Exception
    //   155	167	257	java/lang/NoSuchFieldException
    //   0	27	315	java/lang/NoSuchFieldException
    //   39	51	315	java/lang/NoSuchFieldException
    //   51	76	315	java/lang/NoSuchFieldException
    //   87	102	315	java/lang/NoSuchFieldException
    //   105	125	315	java/lang/NoSuchFieldException
    //   128	155	315	java/lang/NoSuchFieldException
    //   167	179	315	java/lang/NoSuchFieldException
    //   179	197	315	java/lang/NoSuchFieldException
    //   198	226	315	java/lang/NoSuchFieldException
    //   258	273	315	java/lang/NoSuchFieldException
    //   276	296	315	java/lang/NoSuchFieldException
    //   299	315	315	java/lang/NoSuchFieldException
    //   0	27	325	java/lang/IllegalAccessException
    //   27	39	325	java/lang/IllegalAccessException
    //   39	51	325	java/lang/IllegalAccessException
    //   51	76	325	java/lang/IllegalAccessException
    //   87	102	325	java/lang/IllegalAccessException
    //   105	125	325	java/lang/IllegalAccessException
    //   128	155	325	java/lang/IllegalAccessException
    //   155	167	325	java/lang/IllegalAccessException
    //   167	179	325	java/lang/IllegalAccessException
    //   179	197	325	java/lang/IllegalAccessException
    //   198	226	325	java/lang/IllegalAccessException
    //   258	273	325	java/lang/IllegalAccessException
    //   276	296	325	java/lang/IllegalAccessException
    //   299	315	325	java/lang/IllegalAccessException
  }
  
  public static void setSKLog(ISkinEngineLog paramISkinEngineLog)
  {
    h.a = paramISkinEngineLog;
    h.c("SkinEngine", 2, "set ISkinEngineLog ok", null);
  }
  
  /* Error */
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1282	com/tencent/theme/SkinEngine:c	()Landroid/util/TypedValue;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1286	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1289	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 225	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   20: iload_1
    //   21: i2l
    //   22: invokevirtual 1292	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   25: checkcast 1007	java/lang/ref/WeakReference
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   33: invokevirtual 1286	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   36: invokevirtual 1293	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   39: aload_3
    //   40: ifnull +116 -> 156
    //   43: aload_3
    //   44: invokevirtual 1010	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 1063	android/graphics/drawable/Drawable$ConstantState
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +49 -> 101
    //   55: aload_0
    //   56: aload 4
    //   58: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   61: aload_3
    //   62: areturn
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   68: invokevirtual 1286	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   71: invokevirtual 1293	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   74: aconst_null
    //   75: astore_3
    //   76: goto -37 -> 39
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 1286	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   87: invokevirtual 1293	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   90: aload_3
    //   91: athrow
    //   92: astore_3
    //   93: aload_0
    //   94: aload 4
    //   96: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   105: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   108: invokevirtual 998	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   111: aload_0
    //   112: getfield 225	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   115: iload_1
    //   116: i2l
    //   117: invokevirtual 1299	android/util/LongSparseArray:delete	(J)V
    //   120: ldc 47
    //   122: iconst_1
    //   123: new 312	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 1301
    //   133: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_1
    //   137: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 882	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   150: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   153: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   156: getstatic 148	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   159: istore_2
    //   160: iload_2
    //   161: ifeq +143 -> 304
    //   164: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   167: iconst_1
    //   168: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   171: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   174: aload_0
    //   175: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   178: aconst_null
    //   179: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   182: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   185: iconst_1
    //   186: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   189: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   192: aload_0
    //   193: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   196: aconst_null
    //   197: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   200: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   203: iconst_1
    //   204: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   207: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   210: iconst_1
    //   211: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   214: getstatic 144	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   217: aload_0
    //   218: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   221: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: ifnull +80 -> 304
    //   227: getstatic 146	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   230: aload_0
    //   231: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   234: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull +65 -> 304
    //   242: aload_0
    //   243: aload 4
    //   245: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_3
    //   251: aload_0
    //   252: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   255: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   258: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   261: goto -105 -> 156
    //   264: astore_3
    //   265: aload_0
    //   266: aload 4
    //   268: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   271: aload_3
    //   272: athrow
    //   273: astore_3
    //   274: aload_0
    //   275: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   278: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   281: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   284: aload_3
    //   285: athrow
    //   286: astore_3
    //   287: aload_0
    //   288: aload 4
    //   290: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   293: aconst_null
    //   294: areturn
    //   295: astore_3
    //   296: aload_0
    //   297: aload 4
    //   299: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   302: aconst_null
    //   303: areturn
    //   304: aload_0
    //   305: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   308: iload_1
    //   309: aload 4
    //   311: iconst_1
    //   312: invokevirtual 282	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   315: aload 4
    //   317: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   320: astore_3
    //   321: aload_3
    //   322: ifnonnull +11 -> 333
    //   325: aload_0
    //   326: aload 4
    //   328: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   331: aconst_null
    //   332: areturn
    //   333: aload 4
    //   335: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   338: invokeinterface 302 1 0
    //   343: astore 5
    //   345: new 344	com/tencent/theme/SkinData
    //   348: dup
    //   349: invokespecial 1302	com/tencent/theme/SkinData:<init>	()V
    //   352: astore_3
    //   353: aload_3
    //   354: iload_1
    //   355: putfield 844	com/tencent/theme/SkinData:mResourcesID	I
    //   358: aload_3
    //   359: aload 5
    //   361: aload 5
    //   363: ldc_w 1304
    //   366: invokevirtual 1307	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   369: iconst_1
    //   370: iadd
    //   371: invokevirtual 584	java/lang/String:substring	(I)Ljava/lang/String;
    //   374: putfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   377: aload_0
    //   378: getfield 564	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   381: ifnull +64 -> 445
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   389: aload 4
    //   391: aload_3
    //   392: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   395: getstatic 168	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   398: aload_0
    //   399: getfield 211	com/tencent/theme/SkinEngine:y	I
    //   402: aaload
    //   403: getstatic 172	com/tencent/theme/SkinEngine:f	[[I
    //   406: aload_0
    //   407: getfield 211	com/tencent/theme/SkinEngine:y	I
    //   410: aaload
    //   411: invokespecial 849	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   414: aload 4
    //   416: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   419: ifnull +26 -> 445
    //   422: aload_3
    //   423: aload 4
    //   425: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   428: invokeinterface 302 1 0
    //   433: putfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   436: aload_3
    //   437: aload 4
    //   439: getfield 833	android/util/TypedValue:density	I
    //   442: putfield 362	com/tencent/theme/SkinData:mInDensity	I
    //   445: aload_0
    //   446: aload_3
    //   447: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   450: invokespecial 850	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   453: ifeq +89 -> 542
    //   456: ldc 47
    //   458: aload_0
    //   459: aload_3
    //   460: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   463: invokespecial 852	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   466: new 312	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 1309
    //   476: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload_1
    //   480: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 1311
    //   486: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_3
    //   490: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   493: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 1313
    //   499: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_3
    //   503: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   506: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 1315
    //   512: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 4
    //   517: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   520: ldc_w 876
    //   523: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload_0
    //   527: getfield 225	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   530: invokevirtual 879	android/util/LongSparseArray:size	()I
    //   533: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 882	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: aload_0
    //   543: iload_1
    //   544: aload_0
    //   545: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   548: aload_3
    //   549: aload 4
    //   551: invokespecial 902	com/tencent/theme/SkinEngine:a	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/util/TypedValue;)Lcom/tencent/theme/BaseConstantState;
    //   554: astore 5
    //   556: aload 5
    //   558: ifnull +188 -> 746
    //   561: aload 5
    //   563: aload_3
    //   564: putfield 841	com/tencent/theme/BaseConstantState:skinData	Lcom/tencent/theme/SkinData;
    //   567: aload_0
    //   568: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   571: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   574: invokevirtual 998	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   577: aload_0
    //   578: getfield 225	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   581: iload_1
    //   582: i2l
    //   583: new 1007	java/lang/ref/WeakReference
    //   586: dup
    //   587: aload 5
    //   589: invokespecial 1318	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   592: invokevirtual 1321	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   595: aload_0
    //   596: aload_3
    //   597: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   600: invokespecial 850	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   603: ifeq +36 -> 639
    //   606: ldc 47
    //   608: aload_0
    //   609: aload_3
    //   610: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   613: invokespecial 852	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   616: new 312	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 1323
    //   626: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload_1
    //   630: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 882	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: aload_0
    //   640: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   643: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   646: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   649: aload_0
    //   650: aload_3
    //   651: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   654: invokespecial 850	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   657: ifeq +89 -> 746
    //   660: ldc 47
    //   662: aload_0
    //   663: aload_3
    //   664: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   667: invokespecial 852	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   670: new 312	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 1325
    //   680: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: iload_1
    //   684: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: ldc_w 1311
    //   690: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_3
    //   694: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   697: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc_w 1313
    //   703: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_3
    //   707: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   710: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: ldc_w 1315
    //   716: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload 4
    //   721: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   724: ldc_w 876
    //   727: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload_0
    //   731: getfield 225	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   734: invokevirtual 879	android/util/LongSparseArray:size	()I
    //   737: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 882	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_0
    //   747: aload 4
    //   749: invokespecial 1295	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   752: aload 5
    //   754: areturn
    //   755: astore 6
    //   757: aload_0
    //   758: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   761: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   764: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   767: goto -118 -> 649
    //   770: astore_3
    //   771: aload_0
    //   772: getfield 201	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   775: invokevirtual 993	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   778: invokevirtual 1020	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   781: aload_3
    //   782: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	this	SkinEngine
    //   0	783	1	paramInt	int
    //   159	2	2	bool	boolean
    //   28	34	3	localObject1	Object
    //   63	1	3	localException1	Exception
    //   75	1	3	localObject2	Object
    //   79	12	3	localObject3	Object
    //   92	1	3	localNotFoundException	Resources.NotFoundException
    //   237	2	3	localObject4	Object
    //   250	1	3	localException2	Exception
    //   264	8	3	localObject5	Object
    //   273	12	3	localObject6	Object
    //   286	1	3	localException3	Exception
    //   295	1	3	localException4	Exception
    //   320	387	3	localObject7	Object
    //   770	12	3	localObject8	Object
    //   4	744	4	localTypedValue	TypedValue
    //   343	410	5	localObject9	Object
    //   755	1	6	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   16	29	63	java/lang/Exception
    //   16	29	79	finally
    //   6	16	92	android/content/res/Resources$NotFoundException
    //   29	39	92	android/content/res/Resources$NotFoundException
    //   43	51	92	android/content/res/Resources$NotFoundException
    //   64	74	92	android/content/res/Resources$NotFoundException
    //   80	92	92	android/content/res/Resources$NotFoundException
    //   101	111	92	android/content/res/Resources$NotFoundException
    //   146	156	92	android/content/res/Resources$NotFoundException
    //   156	160	92	android/content/res/Resources$NotFoundException
    //   164	200	92	android/content/res/Resources$NotFoundException
    //   200	238	92	android/content/res/Resources$NotFoundException
    //   251	261	92	android/content/res/Resources$NotFoundException
    //   274	286	92	android/content/res/Resources$NotFoundException
    //   304	321	92	android/content/res/Resources$NotFoundException
    //   333	445	92	android/content/res/Resources$NotFoundException
    //   445	542	92	android/content/res/Resources$NotFoundException
    //   542	556	92	android/content/res/Resources$NotFoundException
    //   561	577	92	android/content/res/Resources$NotFoundException
    //   639	649	92	android/content/res/Resources$NotFoundException
    //   649	746	92	android/content/res/Resources$NotFoundException
    //   757	767	92	android/content/res/Resources$NotFoundException
    //   771	783	92	android/content/res/Resources$NotFoundException
    //   111	146	250	java/lang/Exception
    //   6	16	264	finally
    //   29	39	264	finally
    //   43	51	264	finally
    //   64	74	264	finally
    //   80	92	264	finally
    //   101	111	264	finally
    //   146	156	264	finally
    //   156	160	264	finally
    //   164	200	264	finally
    //   200	238	264	finally
    //   251	261	264	finally
    //   274	286	264	finally
    //   304	321	264	finally
    //   333	445	264	finally
    //   445	542	264	finally
    //   542	556	264	finally
    //   561	577	264	finally
    //   639	649	264	finally
    //   649	746	264	finally
    //   757	767	264	finally
    //   771	783	264	finally
    //   111	146	273	finally
    //   164	200	286	java/lang/Exception
    //   200	238	295	java/lang/Exception
    //   577	639	755	java/lang/Exception
    //   577	639	770	finally
  }
  
  /* Error */
  BaseConstantState a(Resources paramResources, SkinData paramSkinData, BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload 8
    //   2: ifeq +411 -> 413
    //   5: aload 6
    //   7: ifnull +406 -> 413
    //   10: new 193	android/util/TypedValue
    //   13: dup
    //   14: invokespecial 194	android/util/TypedValue:<init>	()V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   22: aload 6
    //   24: getfield 1328	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 282	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   32: aload_2
    //   33: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   36: invokeinterface 302 1 0
    //   41: astore 9
    //   43: new 344	com/tencent/theme/SkinData
    //   46: dup
    //   47: invokespecial 1302	com/tencent/theme/SkinData:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: aload 6
    //   54: getfield 1328	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   57: putfield 844	com/tencent/theme/SkinData:mResourcesID	I
    //   60: aload_3
    //   61: aload 9
    //   63: aload 9
    //   65: ldc_w 1304
    //   68: invokevirtual 1307	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   71: iconst_1
    //   72: iadd
    //   73: invokevirtual 584	java/lang/String:substring	(I)Ljava/lang/String;
    //   76: putfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 564	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   83: ifnull +60 -> 143
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   91: aload_2
    //   92: aload_3
    //   93: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   96: getstatic 168	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 211	com/tencent/theme/SkinEngine:y	I
    //   103: aaload
    //   104: getstatic 172	com/tencent/theme/SkinEngine:f	[[I
    //   107: aload_0
    //   108: getfield 211	com/tencent/theme/SkinEngine:y	I
    //   111: aaload
    //   112: invokespecial 849	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   115: aload_2
    //   116: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   119: ifnull +24 -> 143
    //   122: aload_3
    //   123: aload_2
    //   124: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   127: invokeinterface 302 1 0
    //   132: putfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   135: aload_3
    //   136: aload_2
    //   137: getfield 833	android/util/TypedValue:density	I
    //   140: putfield 362	com/tencent/theme/SkinData:mInDensity	I
    //   143: aload_3
    //   144: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   147: ifnull +114 -> 261
    //   150: new 341	android/graphics/Rect
    //   153: dup
    //   154: invokespecial 342	android/graphics/Rect:<init>	()V
    //   157: astore_2
    //   158: new 358	android/graphics/BitmapFactory$Options
    //   161: dup
    //   162: invokespecial 359	android/graphics/BitmapFactory$Options:<init>	()V
    //   165: astore 9
    //   167: aload 9
    //   169: aload_3
    //   170: getfield 362	com/tencent/theme/SkinData:mInDensity	I
    //   173: putfield 365	android/graphics/BitmapFactory$Options:inDensity	I
    //   176: aload 9
    //   178: aload 6
    //   180: getfield 1332	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   183: putfield 1333	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   186: aload_0
    //   187: aload_1
    //   188: aload_3
    //   189: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   192: invokespecial 356	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   195: astore 4
    //   197: aload_1
    //   198: aconst_null
    //   199: aload 4
    //   201: aload_3
    //   202: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   205: aload 9
    //   207: aload_2
    //   208: aload_0
    //   209: getfield 209	com/tencent/theme/SkinEngine:s	Z
    //   212: invokestatic 374	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   215: astore_2
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: invokevirtual 379	java/io/InputStream:close	()V
    //   223: aload_2
    //   224: areturn
    //   225: astore_1
    //   226: ldc 47
    //   228: iconst_1
    //   229: new 312	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 1335
    //   239: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   246: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload_1
    //   253: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -42 -> 216
    //   261: aload_1
    //   262: aload 6
    //   264: getfield 1328	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   267: aload_2
    //   268: invokevirtual 503	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   271: astore_3
    //   272: aload_2
    //   273: getfield 296	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   276: invokeinterface 302 1 0
    //   281: astore 9
    //   283: new 358	android/graphics/BitmapFactory$Options
    //   286: dup
    //   287: invokespecial 359	android/graphics/BitmapFactory$Options:<init>	()V
    //   290: astore 10
    //   292: aload_1
    //   293: aload_2
    //   294: aload_3
    //   295: aload 9
    //   297: aload 10
    //   299: aload 4
    //   301: iconst_1
    //   302: invokestatic 374	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   305: astore_2
    //   306: aload_2
    //   307: astore_1
    //   308: aload_3
    //   309: invokevirtual 379	java/io/InputStream:close	()V
    //   312: aload_2
    //   313: areturn
    //   314: astore_3
    //   315: aload_2
    //   316: astore_1
    //   317: ldc 47
    //   319: iconst_1
    //   320: ldc_w 1337
    //   323: aload_3
    //   324: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: ldc 47
    //   332: iconst_1
    //   333: ldc_w 1339
    //   336: aload_2
    //   337: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: ldc 47
    //   345: iconst_1
    //   346: new 312	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1341
    //   356: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 6
    //   361: getfield 1328	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   364: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: aload_1
    //   371: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: aconst_null
    //   375: areturn
    //   376: astore_1
    //   377: ldc 47
    //   379: iconst_1
    //   380: new 312	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 1343
    //   390: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 6
    //   395: getfield 1328	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   398: invokevirtual 865	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: aload_1
    //   405: invokestatic 386	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: aconst_null
    //   409: astore_2
    //   410: goto -104 -> 306
    //   413: aload_0
    //   414: aload_1
    //   415: aload_2
    //   416: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   419: invokespecial 356	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   422: astore 9
    //   424: aload_3
    //   425: iconst_0
    //   426: putfield 402	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   429: aload_3
    //   430: aload 6
    //   432: getfield 1332	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   435: putfield 1333	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   438: aload_3
    //   439: iload 7
    //   441: putfield 1346	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   444: aload_1
    //   445: aconst_null
    //   446: aload 9
    //   448: aload_2
    //   449: getfield 368	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   452: aload_3
    //   453: aload 4
    //   455: aload_0
    //   456: getfield 209	com/tencent/theme/SkinEngine:s	Z
    //   459: invokestatic 374	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   462: astore_1
    //   463: aload_1
    //   464: astore_2
    //   465: aload_2
    //   466: astore_1
    //   467: aload 9
    //   469: invokevirtual 379	java/io/InputStream:close	()V
    //   472: aload_2
    //   473: areturn
    //   474: astore_1
    //   475: getstatic 118	com/tencent/theme/SkinEngine:DEBUG	Z
    //   478: ifeq +38 -> 516
    //   481: ldc 47
    //   483: new 312	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 1348
    //   493: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_2
    //   497: getfield 347	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   500: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 1350
    //   506: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 444	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   515: pop
    //   516: aconst_null
    //   517: astore_2
    //   518: goto -53 -> 465
    //   521: astore_2
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -194 -> 330
    //   527: astore_3
    //   528: aconst_null
    //   529: astore_2
    //   530: goto -215 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	SkinEngine
    //   0	533	1	paramResources	Resources
    //   0	533	2	paramSkinData	SkinData
    //   0	533	3	paramOptions	BitmapFactory.Options
    //   0	533	4	paramRect	Rect
    //   0	533	5	paramBoolean1	boolean
    //   0	533	6	paramBackupForOOMData	BackupForOOMData
    //   0	533	7	paramInt	int
    //   0	533	8	paramBoolean2	boolean
    //   41	427	9	localObject	Object
    //   290	8	10	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   197	216	225	java/lang/OutOfMemoryError
    //   308	312	314	java/io/IOException
    //   218	223	329	java/lang/Throwable
    //   308	312	329	java/lang/Throwable
    //   317	327	329	java/lang/Throwable
    //   467	472	329	java/lang/Throwable
    //   261	272	342	java/lang/Exception
    //   292	306	376	java/lang/OutOfMemoryError
    //   444	463	474	java/lang/OutOfMemoryError
    //   10	143	521	java/lang/Throwable
    //   143	197	521	java/lang/Throwable
    //   197	216	521	java/lang/Throwable
    //   226	256	521	java/lang/Throwable
    //   261	272	521	java/lang/Throwable
    //   272	283	521	java/lang/Throwable
    //   283	292	521	java/lang/Throwable
    //   292	306	521	java/lang/Throwable
    //   343	374	521	java/lang/Throwable
    //   377	408	521	java/lang/Throwable
    //   413	444	521	java/lang/Throwable
    //   444	463	521	java/lang/Throwable
    //   475	516	521	java/lang/Throwable
    //   283	292	527	java/io/IOException
    //   292	306	527	java/io/IOException
    //   377	408	527	java/io/IOException
  }
  
  void a(Context paramContext)
  {
    boolean bool = true;
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    this.r = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.c)
    {
      this.x = this.w;
      this.w = str;
      this.s = bool;
      if (this.F != null)
      {
        if (this.w != null) {
          this.F.loadConfig(paramContext.getResources(), this.w + File.separator + "config.json");
        }
      }
      else
      {
        if (this.E != null) {
          this.E.b();
        }
        b(paramContext);
        b();
        localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.s).commit();
        this.r = false;
        this.x = null;
        if (SWITCH_DEBUG) {
          Log.d("SkinEngine.switch", "update done");
        }
        h.d("SkinEngine.switch", 2, "skinEngine update done", null);
        return;
      }
      this.F.clear();
    }
  }
  
  public void addBackupForOOMData(Integer paramInteger, BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.z.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    TypedValue localTypedValue = c();
    try
    {
      this.q.readLock().lock();
      try
      {
        Object localObject1 = (WeakReference)this.u.get(paramInt);
        this.q.readLock().unlock();
        if (localObject1 != null)
        {
          localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            return localObject1;
          }
        }
      }
      finally
      {
        this.q.readLock().unlock();
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      return null;
      this.q.writeLock().lock();
      try
      {
        this.u.delete(paramInt);
        this.q.writeLock().unlock();
        this.mResources.getValue(paramInt, localTypedValue, true);
        Object localObject6 = localTypedValue.string.toString();
        if (((String)localObject6).endsWith(".xml"))
        {
          SkinData localSkinData = new SkinData();
          localSkinData.mResourcesID = paramInt;
          localSkinData.mFileName = ((String)localObject6).substring(((String)localObject6).lastIndexOf("/") + 1);
          if (this.w != null) {
            localSkinData.mFilePath = a(this.mResources, localSkinData.mFileName);
          }
          localObject6 = a(paramInt, this.mResources, localSkinData);
          ((SkinnableColorStateList)localObject6).skinData = localSkinData;
          this.q.writeLock().lock();
          localObject4 = finally;
        }
      }
      finally
      {
        try
        {
          this.u.put(paramInt, new WeakReference(localObject6));
          this.q.writeLock().unlock();
          return localObject6;
        }
        finally
        {
          this.q.writeLock().unlock();
        }
        localObject3 = finally;
        this.q.writeLock().unlock();
      }
    }
    finally
    {
      a(localTypedValue);
    }
    return null;
  }
  
  public boolean checkResExist(int paramInt)
  {
    TypedValue localTypedValue = c();
    this.mResources.getValue(paramInt, localTypedValue, true);
    if (TextUtils.isEmpty(localTypedValue.string))
    {
      a(localTypedValue);
      return false;
    }
    String str = localTypedValue.string.toString();
    localTypedValue.resourceId = paramInt;
    str = str.substring(str.lastIndexOf("/") + 1);
    a(this.mResources, localTypedValue, str, e[this.y], f[this.y]);
    if (localTypedValue.string != null)
    {
      a(localTypedValue);
      return true;
    }
    a(localTypedValue);
    if (a(this.mResources, str) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.c)
    {
      TypedValue localTypedValue2 = this.c;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = b(paramInt).getDefaultColor();
        return paramInt;
      }
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(localObject.type) + " is not valid");
  }
  
  public Drawable getDefaultThemeDrawable(int paramInt)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject1 = (WeakReference)this.v.get(paramInt);
        if (localObject1 == null) {
          break label310;
        }
        Object localObject5 = (BaseConstantState)((WeakReference)localObject1).get();
        localObject1 = localObject5;
        if (localObject5 == null)
        {
          this.v.delete(paramInt);
          localObject1 = localObject5;
        }
        localObject5 = localObject1;
        Object localObject2;
        if (localObject1 == null)
        {
          boolean bool = IS_PROBLEM_CM11;
          if (bool) {
            try
            {
              mIconsOfCM.setAccessible(true);
              mIconsOfCM.set(this.mResources, null);
              mComposedIconInfoOfCM.setAccessible(true);
              mComposedIconInfoOfCM.set(this.mResources, null);
              this.mResources.getValue(paramInt, this.c, true);
            }
            catch (Exception localException1)
            {
              try
              {
                mIconsOfCM.setAccessible(true);
                mComposedIconInfoOfCM.setAccessible(true);
                if (mIconsOfCM.get(this.mResources) == null) {
                  continue;
                }
                localObject1 = mComposedIconInfoOfCM.get(this.mResources);
                if (localObject1 == null) {
                  continue;
                }
                return null;
              }
              catch (Exception localException2)
              {
                return null;
              }
              localException1 = localException1;
              return null;
            }
          }
          localObject2 = this.c.string.toString();
          SkinData localSkinData = new SkinData();
          localSkinData.mResourcesID = paramInt;
          localSkinData.mFileName = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
          localSkinData.mFilePath = null;
          localObject2 = a(paramInt, this.mResources, localSkinData, this.c);
          localObject5 = localObject2;
          if (localObject2 != null)
          {
            ((BaseConstantState)localObject2).skinData = localSkinData;
            this.v.put(paramInt, new WeakReference(localObject2));
            localObject5 = localObject2;
          }
        }
        if (localObject5 != null)
        {
          localObject2 = ((BaseConstantState)localObject5).newDrawable(this.mResources);
          return localObject2;
        }
      }
      Object localObject4 = null;
      continue;
      label310:
      localObject4 = null;
    }
  }
  
  public int getDrawableDpi(String paramString)
  {
    String[] arrayOfString = e[this.y];
    int[] arrayOfInt = f[this.y];
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      if (arrayOfString[i1].equals(paramString)) {
        return i1;
      }
      i1 += 1;
    }
    if ("color/".equals(paramString)) {
      return -2;
    }
    return -1;
  }
  
  public String getSkinRootPath()
  {
    if (this.r) {
      return this.x;
    }
    return this.w;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.c)
      {
        a(this.s);
        Object localObject2 = this.D.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.C.get(paramString);
          break label63;
          return paramObject;
        }
      }
      label63:
      while (localObject1 != null)
      {
        paramObject = localObject1;
        break;
      }
    }
  }
  
  public File getThemeDirFile()
  {
    if (this.w != null) {
      return new File(this.w);
    }
    return null;
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (this.w != null) {
      this.p.readLock().lock();
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (WeakReference)this.t.get(paramInt);
        this.p.readLock().unlock();
        if (localObject == null) {
          break label162;
        }
        localObject = (BaseConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (((BaseConstantState)localObject).skinData.mFilePath == null) {
            break label162;
          }
          paramTypedValue.type = 16777215;
          paramTypedValue.string = ((BaseConstantState)localObject).skinData.mFilePath;
          return;
        }
      }
      finally
      {
        this.p.readLock().unlock();
      }
      this.p.writeLock().lock();
      try
      {
        this.t.delete(paramInt);
        h.a("SkinEngine", 1, "getValue mDrawableCache delete res, resourcesId : " + paramInt);
        this.p.writeLock().unlock();
        label162:
        localObject = paramTypedValue.string.toString();
        localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
        TypedValue localTypedValue = new TypedValue();
        localTypedValue.resourceId = paramInt;
        a(this.mResources, localTypedValue, (String)localObject, e[this.y], f[this.y]);
        if (localTypedValue.string == null) {
          continue;
        }
        paramTypedValue.type = 16777215;
        paramTypedValue.string = localTypedValue.string;
        return;
      }
      finally
      {
        this.p.writeLock().unlock();
      }
    }
  }
  
  public int recordDpiFile(String paramString)
  {
    int[] arrayOfInt = f[this.y];
    String[] arrayOfString = e[this.y];
    int i2;
    if (this.w == null)
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= arrayOfInt.length) {
        break label107;
      }
      String str = this.w + arrayOfString[i1] + paramString;
      if (str.startsWith("/asset/")) {
        return -2;
      }
      i2 = i1;
      if (new File(str).exists()) {
        break;
      }
      i1 += 1;
    }
    label107:
    return -3;
  }
  
  /* Error */
  public Object[] releasePreloadDrawableCache()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: ldc_w 1425
    //   10: invokestatic 691	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: ldc_w 1427
    //   16: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   19: astore 11
    //   21: aload 11
    //   23: iconst_1
    //   24: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   27: iload_2
    //   28: istore_3
    //   29: lload 7
    //   31: lstore 9
    //   33: aload_0
    //   34: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   37: ifnull +328 -> 365
    //   40: iload_2
    //   41: istore_3
    //   42: lload 7
    //   44: lstore 9
    //   46: aload_0
    //   47: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   50: getfield 1429	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   53: ifnull +312 -> 365
    //   56: aload_0
    //   57: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   60: getfield 1429	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   63: astore 12
    //   65: aload 12
    //   67: arraylength
    //   68: istore 4
    //   70: iconst_0
    //   71: istore_2
    //   72: iload_1
    //   73: istore_3
    //   74: lload 7
    //   76: lstore 9
    //   78: iload_2
    //   79: iload 4
    //   81: if_icmpge +284 -> 365
    //   84: aload 12
    //   86: iload_2
    //   87: aaload
    //   88: astore 13
    //   90: iconst_0
    //   91: istore_3
    //   92: lload 7
    //   94: lstore 9
    //   96: iload_3
    //   97: aload 13
    //   99: invokevirtual 879	android/util/LongSparseArray:size	()I
    //   102: if_icmpge +247 -> 349
    //   105: aload 13
    //   107: iload_3
    //   108: invokevirtual 1005	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   111: checkcast 1063	android/graphics/drawable/Drawable$ConstantState
    //   114: astore 14
    //   116: lload 9
    //   118: lstore 7
    //   120: aload 14
    //   122: ifnull +56 -> 178
    //   125: aload 14
    //   127: invokevirtual 1431	android/graphics/drawable/Drawable$ConstantState:newDrawable	()Landroid/graphics/drawable/Drawable;
    //   130: astore 14
    //   132: aload 14
    //   134: instanceof 1433
    //   137: ifeq +106 -> 243
    //   140: aload 14
    //   142: checkcast 1433	android/graphics/drawable/BitmapDrawable
    //   145: invokevirtual 1437	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   148: astore 14
    //   150: lload 9
    //   152: lstore 7
    //   154: aload 14
    //   156: ifnull +22 -> 178
    //   159: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   162: bipush 12
    //   164: if_icmplt +55 -> 219
    //   167: lload 9
    //   169: aload 14
    //   171: invokevirtual 249	android/graphics/Bitmap:getByteCount	()I
    //   174: i2l
    //   175: ladd
    //   176: lstore 7
    //   178: iload_3
    //   179: iconst_1
    //   180: iadd
    //   181: istore_3
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: lload 7
    //   188: lstore 9
    //   190: goto -94 -> 96
    //   193: astore 12
    //   195: aconst_null
    //   196: astore 11
    //   198: aload 12
    //   200: invokevirtual 1440	java/lang/NoSuchFieldException:printStackTrace	()V
    //   203: goto -176 -> 27
    //   206: astore 12
    //   208: aconst_null
    //   209: astore 11
    //   211: aload 12
    //   213: invokevirtual 1441	java/lang/ClassNotFoundException:printStackTrace	()V
    //   216: goto -189 -> 27
    //   219: aload 14
    //   221: invokevirtual 252	android/graphics/Bitmap:getRowBytes	()I
    //   224: istore 5
    //   226: lload 9
    //   228: aload 14
    //   230: invokevirtual 255	android/graphics/Bitmap:getHeight	()I
    //   233: iload 5
    //   235: imul
    //   236: i2l
    //   237: ladd
    //   238: lstore 7
    //   240: goto -62 -> 178
    //   243: aload 14
    //   245: instanceof 1443
    //   248: ifeq +92 -> 340
    //   251: aload 11
    //   253: ifnonnull +12 -> 265
    //   256: lload 9
    //   258: lconst_1
    //   259: ladd
    //   260: lstore 7
    //   262: goto -84 -> 178
    //   265: aload 11
    //   267: aload 14
    //   269: checkcast 1443	android/graphics/drawable/NinePatchDrawable
    //   272: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 14
    //   277: lload 9
    //   279: lstore 7
    //   281: aload 14
    //   283: instanceof 1445
    //   286: ifeq -108 -> 178
    //   289: aload 14
    //   291: checkcast 1445	android/graphics/NinePatch
    //   294: astore 14
    //   296: aload 14
    //   298: invokevirtual 1448	android/graphics/NinePatch:getWidth	()I
    //   301: istore 5
    //   303: aload 14
    //   305: invokevirtual 1449	android/graphics/NinePatch:getHeight	()I
    //   308: istore 6
    //   310: lload 9
    //   312: iload 6
    //   314: iload 5
    //   316: imul
    //   317: i2l
    //   318: ladd
    //   319: lstore 7
    //   321: goto -143 -> 178
    //   324: astore 14
    //   326: aload 14
    //   328: invokevirtual 1450	java/lang/IllegalAccessException:printStackTrace	()V
    //   331: lload 9
    //   333: lconst_1
    //   334: ladd
    //   335: lstore 7
    //   337: goto -159 -> 178
    //   340: lload 9
    //   342: lconst_1
    //   343: ladd
    //   344: lstore 7
    //   346: goto -168 -> 178
    //   349: aload 13
    //   351: invokevirtual 1451	android/util/LongSparseArray:clear	()V
    //   354: iload_2
    //   355: iconst_1
    //   356: iadd
    //   357: istore_2
    //   358: lload 9
    //   360: lstore 7
    //   362: goto -290 -> 72
    //   365: iconst_2
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: iload_3
    //   372: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   375: aastore
    //   376: dup
    //   377: iconst_1
    //   378: lload 9
    //   380: invokestatic 1456	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   383: aastore
    //   384: areturn
    //   385: astore 12
    //   387: goto -176 -> 211
    //   390: astore 12
    //   392: goto -194 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	SkinEngine
    //   6	180	1	i1	int
    //   4	354	2	i2	int
    //   28	344	3	i3	int
    //   68	14	4	i4	int
    //   224	93	5	i5	int
    //   308	9	6	i6	int
    //   1	360	7	l1	long
    //   31	348	9	l2	long
    //   19	247	11	localField	Field
    //   63	22	12	arrayOfLongSparseArray	LongSparseArray[]
    //   193	6	12	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   206	6	12	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   385	1	12	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   390	1	12	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   88	262	13	localLongSparseArray	LongSparseArray
    //   114	190	14	localObject	Object
    //   324	3	14	localIllegalAccessException	java.lang.IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   7	21	193	java/lang/NoSuchFieldException
    //   7	21	206	java/lang/ClassNotFoundException
    //   265	277	324	java/lang/IllegalAccessException
    //   281	310	324	java/lang/IllegalAccessException
    //   21	27	385	java/lang/ClassNotFoundException
    //   21	27	390	java/lang/NoSuchFieldException
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.m = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.r)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
      if (SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        Log.d("SkinEngine.switch", "[setSkinRootPath] done");
      }
      return true;
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      if (str.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File(str);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG) {
            Log.w("SkinEngine", "[setSkinRootPath] wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  public void setSkinTint(ISkinTint paramISkinTint)
  {
    this.F = paramISkinTint;
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   4: ifnull +39 -> 43
    //   7: ldc 233
    //   9: ldc_w 733
    //   12: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 1492	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 1495	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   37: getfield 1429	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc 233
    //   45: ldc_w 806
    //   48: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 222	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   75: getfield 1497	com/tencent/theme/b:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 745	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   88: getfield 1429	com/tencent/theme/e:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: getstatic 118	com/tencent/theme/SkinEngine:DEBUG	Z
    //   103: ifeq -22 -> 81
    //   106: ldc 47
    //   108: ldc_w 1499
    //   111: aload_1
    //   112: invokestatic 823	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   115: pop
    //   116: return
    //   117: astore_1
    //   118: ldc 233
    //   120: ldc_w 811
    //   123: invokevirtual 703	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 494	java/lang/reflect/Field:setAccessible	(Z)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 278	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   137: invokevirtual 499	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore_2
    //   141: aload_2
    //   142: instanceof 711
    //   145: ifeq +16 -> 161
    //   148: aload_1
    //   149: aconst_null
    //   150: aload_0
    //   151: getfield 818	com/tencent/theme/SkinEngine:B	Lcom/tencent/theme/c;
    //   154: getfield 1502	com/tencent/theme/c:b	Landroid/util/SparseArray;
    //   157: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: return
    //   161: aload_2
    //   162: instanceof 222
    //   165: ifeq -84 -> 81
    //   168: aload_1
    //   169: aconst_null
    //   170: aload_0
    //   171: getfield 773	com/tencent/theme/SkinEngine:A	Lcom/tencent/theme/b;
    //   174: getfield 1497	com/tencent/theme/b:b	Landroid/util/LongSparseArray;
    //   177: invokevirtual 498	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	13	1	localException1	Exception
    //   117	1	1	localException2	Exception
    //   126	43	1	localField2	Field
    //   68	94	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   118	160	99	java/lang/Exception
    //   161	180	99	java/lang/Exception
    //   43	81	117	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.z.a(paramFile);
  }
  
  public static class BackupForOOMData
  {
    public int backFileResId;
    public Bitmap.Config inPreferredConfig;
    public int orgkFileResId;
    
    public BackupForOOMData(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.orgkFileResId = paramInt1;
      this.backFileResId = paramInt2;
      this.inPreferredConfig = paramConfig;
    }
  }
  
  class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
      }
      h.a("SkinEngine", 1, "UpdateTask switch theme start");
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
      }
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
      }
      h.a("SkinEngine", 1, "UpdateTask switch theme end");
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (SkinEngine.SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */