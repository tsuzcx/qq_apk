package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static final String a = "SKinEngine";
  static boolean b;
  static final String[][] d;
  static final int[][] e;
  static int f;
  static int g;
  static int h;
  static int i;
  static int j;
  private static SkinEngine m;
  final TypedValue c = new TypedValue();
  SkinEngineHandler k;
  BroadcastReceiver l = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      new SkinEngine.a(SkinEngine.this, null).execute(new Context[] { paramAnonymousContext });
    }
  };
  public Resources mResources;
  private boolean n = false;
  private boolean o = true;
  private final LongSparseArray<WeakReference<b>> p = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> q = new LongSparseArray();
  private String r;
  private String s;
  private int t = h;
  private g u;
  private d v;
  private e w;
  private HashMap<String, Object> x;
  private HashMap<String, Object> y;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      IS_PROBLEM_MIUI = false;
      d = new String[][] { { "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-hdpi/", "drawable-xhdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/" }, { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable/" }, { "drawable-xxhdpi", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" } };
      e = new int[][] { { 320, 240, 160, 160 }, { 240, 320, 160, 160 }, { 160, 160, 240, 320 }, { 120, 160, 240, 320, 160 }, { 480, 320, 240, 160, 160 } };
      f = 0;
      g = 1;
      h = 2;
      i = 3;
      j = 4;
      return;
    }
  }
  
  private static int a(Resources paramResources)
  {
    switch (paramResources.getDisplayMetrics().densityDpi)
    {
    default: 
      return h;
    case 320: 
      return f;
    case 240: 
      return g;
    case 120: 
      return i;
    }
    return j;
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
  
  private b a(int paramInt, Resources paramResources, j paramj)
  {
    for (;;)
    {
      Rect localRect;
      Object localObject3;
      synchronized (this.c)
      {
        localRect = new Rect();
        localObject3 = paramj.b;
        boolean bool;
        if (localObject3 != null)
        {
          bool = ((String)localObject3).endsWith(".xml");
          if (!bool) {
            try
            {
              localObject2 = b(paramResources, (String)localObject3);
              localObject4 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject4).inDensity = paramj.c;
              try
              {
                b localb1 = i.a(paramResources, null, (InputStream)localObject2, paramj.d, (BitmapFactory.Options)localObject4, localRect, this.o);
                ((InputStream)localObject2).close();
                if (localb1 == null) {
                  continue;
                }
                return localb1;
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                if (this.k == null) {
                  break label821;
                }
              }
              if (!this.k.onDecodeOOM(localOutOfMemoryError1, paramj.d, true)) {
                break label821;
              }
              ((InputStream)localObject2).close();
              localObject2 = b(paramResources, (String)localObject3);
              try
              {
                b localb2 = i.a(paramResources, null, (InputStream)localObject2, paramj.d, (BitmapFactory.Options)localObject4, localRect, this.o);
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                b localb3;
                if (this.k.onSecondDecodeOOM(localOutOfMemoryError2, paramj.d, true))
                {
                  ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
                  localObject2 = b(paramResources, (String)localObject3);
                  localb3 = i.a(paramResources, null, (InputStream)localObject2, paramj.d, (BitmapFactory.Options)localObject4, localRect, this.o);
                  continue;
                }
                throw localb3;
              }
              bool = paramj.d.endsWith(".xml");
            }
            catch (IOException localIOException)
            {
              if (DEBUG) {
                Log.w("SKinEngine", "Bitmap File:" + (String)localObject3 + " is not a bitmap or error bitmap");
              }
            }
          }
        }
        if (!bool) {
          break label471;
        }
      }
      try
      {
        localObject2 = a(paramInt, this.c);
        if (localObject3 != null)
        {
          if (this.o) {}
          for (localObject1 = new a();; localObject1 = Xml.newPullParser())
          {
            localObject3 = new FileInputStream((String)localObject3);
            ((XmlPullParser)localObject1).setInput((InputStream)localObject3, "UTF-8");
            paramResources = i.a(paramResources, (XmlPullParser)localObject2, (XmlPullParser)localObject1, this.o);
            ((FileInputStream)localObject3).close();
            ((XmlResourceParser)localObject2).close();
            return paramResources;
            paramResources = finally;
            throw paramResources;
          }
        }
        paramResources = i.a(paramResources, (XmlPullParser)localObject2, null, this.o);
        ((XmlResourceParser)localObject2).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramj = new Resources.NotFoundException("File " + paramj.d + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
        paramj.initCause(paramResources);
        throw paramj;
      }
      label471:
      Object localObject4 = this.c;
      Object localObject2 = paramResources.openRawResource(paramInt, (TypedValue)localObject4);
      String str = ((TypedValue)localObject4).string.toString();
      Object localObject1 = localObject2;
      label816:
      for (;;)
      {
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localObject1 = localObject2;
          try
          {
            localObject3 = i.a(paramResources, (TypedValue)localObject4, (InputStream)localObject2, str, localOptions, localRect, true);
            paramResources = (Resources)localObject3;
            localObject1 = localObject2;
            ((InputStream)localObject2).close();
            if (paramResources == null)
            {
              localObject1 = localObject2;
              if (this.k != null)
              {
                localObject1 = localObject2;
                this.k.onDecodeReturnNullBitmap(paramj.d, false);
              }
            }
            return paramResources;
          }
          catch (OutOfMemoryError localOutOfMemoryError3)
          {
            localObject1 = localObject2;
            if (this.k == null) {
              break label816;
            }
          }
          localObject1 = localObject2;
          if (this.k.onDecodeOOM(localOutOfMemoryError3, paramj.d, false))
          {
            localObject1 = localObject2;
            ((InputStream)localObject2).close();
            localObject1 = localObject2;
            localObject2 = paramResources.openRawResource(paramInt, (TypedValue)localObject4);
            localObject1 = localObject2;
            try
            {
              b localb4 = i.a(paramResources, (TypedValue)localObject4, (InputStream)localObject2, str, localOptions, localRect, true);
              paramResources = localb4;
            }
            catch (OutOfMemoryError localOutOfMemoryError4)
            {
              localObject1 = localObject2;
              if (this.k.onSecondDecodeOOM(localOutOfMemoryError4, paramj.d, false))
              {
                localObject1 = localObject2;
                localOptions.inJustDecodeBounds = true;
                localObject1 = localObject2;
                localObject2 = paramResources.openRawResource(paramInt, (TypedValue)localObject4);
                localObject1 = localObject2;
                paramResources = i.a(paramResources, (TypedValue)localObject4, (InputStream)localObject2, str, localOptions, localRect, true);
                continue;
              }
              localObject1 = localObject2;
              throw localOutOfMemoryError4;
            }
          }
          else
          {
            paramResources = null;
          }
        }
        catch (IOException paramResources)
        {
          paramj = new Resources.NotFoundException("File " + paramj.d + " from drawable resource ID #0x" + Integer.toHexString(paramInt) + ", stream type: " + localObject1.getClass().getName());
          paramj.initCause(paramResources);
          throw paramj;
        }
      }
      label821:
      localObject1 = null;
    }
  }
  
  private String a(Resources paramResources, String paramString)
  {
    paramString = this.r + "color/" + paramString;
    try
    {
      if (paramString.startsWith("/asset/"))
      {
        paramResources.getAssets().open(paramString.substring("/asset/".length())).close();
        return paramString;
      }
      boolean bool = new File(paramString).exists();
      if (bool) {
        return paramString;
      }
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        if (DEBUG) {
          Log.w("SKinEngine", paramResources);
        }
      }
    }
    return null;
    return paramString;
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
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = 0;
    while (i1 < paramArrayOfInt.length) {
      try
      {
        String str = this.r + paramArrayOfString[i1] + paramString;
        if (str.startsWith("/asset/"))
        {
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        if (new File(str).exists())
        {
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SKinEngine", localIOException);
        }
        i1 += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  /* Error */
  private void a(Resources paramResources, Class paramClass1, int[] paramArrayOfInt, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +12 -> 13
    //   4: aload_2
    //   5: ifnull +90 -> 95
    //   8: iload 4
    //   10: ifeq +85 -> 95
    //   13: ldc 176
    //   15: ldc_w 497
    //   18: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   21: astore 8
    //   23: aload 8
    //   25: iconst_1
    //   26: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   29: aload 8
    //   31: aload_1
    //   32: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 9
    //   37: aload 9
    //   39: instanceof 167
    //   42: ifeq +218 -> 260
    //   45: aload_3
    //   46: ifnull +171 -> 217
    //   49: aload_0
    //   50: new 513	com/tencent/theme/g
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: aload_3
    //   57: aload 7
    //   59: iconst_1
    //   60: anewarray 167	android/util/LongSparseArray
    //   63: dup
    //   64: iconst_0
    //   65: aload 9
    //   67: checkcast 167	android/util/LongSparseArray
    //   70: aastore
    //   71: invokespecial 516	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   74: putfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   77: aload 8
    //   79: aload_1
    //   80: new 520	com/tencent/theme/h
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   89: invokespecial 523	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   92: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   95: aload 5
    //   97: ifnull +64 -> 161
    //   100: iload 6
    //   102: ifeq +59 -> 161
    //   105: ldc 176
    //   107: ldc_w 529
    //   110: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   113: astore_2
    //   114: aload_2
    //   115: iconst_1
    //   116: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 167	android/util/LongSparseArray
    //   127: astore_3
    //   128: getstatic 110	com/tencent/theme/SkinEngine:b	Z
    //   131: ifeq +240 -> 371
    //   134: aload_0
    //   135: new 531	com/tencent/theme/f
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: aload_3
    //   142: aload 5
    //   144: iload 6
    //   146: invokespecial 534	com/tencent/theme/f:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   149: putfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   152: aload_2
    //   153: aload_1
    //   154: aload_0
    //   155: getfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   158: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   161: aload_1
    //   162: invokevirtual 361	java/lang/Object:getClass	()Ljava/lang/Class;
    //   165: astore_2
    //   166: aload_2
    //   167: invokevirtual 366	java/lang/Class:getName	()Ljava/lang/String;
    //   170: ldc_w 538
    //   173: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +40 -> 216
    //   179: aload_2
    //   180: ldc_w 540
    //   183: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   186: astore_2
    //   187: aload_2
    //   188: iconst_1
    //   189: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: ifnonnull +19 -> 216
    //   200: aload_2
    //   201: aload_1
    //   202: new 542	android/util/SparseArray
    //   205: dup
    //   206: invokespecial 543	android/util/SparseArray:<init>	()V
    //   209: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   212: iconst_1
    //   213: putstatic 112	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   216: return
    //   217: aload_0
    //   218: new 513	com/tencent/theme/g
    //   221: dup
    //   222: aload_0
    //   223: aload_1
    //   224: aload_2
    //   225: iload 4
    //   227: aload 7
    //   229: iconst_1
    //   230: anewarray 167	android/util/LongSparseArray
    //   233: dup
    //   234: iconst_0
    //   235: aload 9
    //   237: checkcast 167	android/util/LongSparseArray
    //   240: aastore
    //   241: invokespecial 546	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   244: putfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   247: goto -170 -> 77
    //   250: astore_1
    //   251: new 489	com/tencent/theme/UnSupportPlatformException
    //   254: dup
    //   255: aload_1
    //   256: invokespecial 549	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   259: athrow
    //   260: aload 9
    //   262: instanceof 551
    //   265: ifeq -170 -> 95
    //   268: aload 9
    //   270: checkcast 551	[Landroid/util/LongSparseArray;
    //   273: checkcast 551	[Landroid/util/LongSparseArray;
    //   276: astore 8
    //   278: aload_3
    //   279: ifnull +59 -> 338
    //   282: aload_0
    //   283: new 513	com/tencent/theme/g
    //   286: dup
    //   287: aload_0
    //   288: aload_1
    //   289: aload_3
    //   290: aload 7
    //   292: aload 8
    //   294: invokespecial 516	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   297: putfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   300: goto +239 -> 539
    //   303: iload 4
    //   305: aload 8
    //   307: arraylength
    //   308: if_icmpge -213 -> 95
    //   311: aload 8
    //   313: iload 4
    //   315: new 520	com/tencent/theme/h
    //   318: dup
    //   319: iload 4
    //   321: aload_0
    //   322: getfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   325: invokespecial 523	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   328: aastore
    //   329: iload 4
    //   331: iconst_1
    //   332: iadd
    //   333: istore 4
    //   335: goto -32 -> 303
    //   338: aload_0
    //   339: new 513	com/tencent/theme/g
    //   342: dup
    //   343: aload_0
    //   344: aload_1
    //   345: aload_2
    //   346: iload 4
    //   348: aload 7
    //   350: aload 8
    //   352: invokespecial 546	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   355: putfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   358: goto +181 -> 539
    //   361: astore_1
    //   362: new 489	com/tencent/theme/UnSupportPlatformException
    //   365: dup
    //   366: aload_1
    //   367: invokespecial 549	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   370: athrow
    //   371: aload_0
    //   372: new 553	com/tencent/theme/d
    //   375: dup
    //   376: aload_0
    //   377: aload_1
    //   378: aload_3
    //   379: aload 5
    //   381: iload 6
    //   383: invokespecial 554	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   386: putfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   389: goto -237 -> 152
    //   392: astore_2
    //   393: ldc 176
    //   395: ldc_w 556
    //   398: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   401: astore_3
    //   402: aload_3
    //   403: iconst_1
    //   404: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   407: aload_3
    //   408: aload_1
    //   409: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   412: astore 7
    //   414: aload 7
    //   416: instanceof 542
    //   419: ifeq +47 -> 466
    //   422: aload_0
    //   423: new 558	com/tencent/theme/e
    //   426: dup
    //   427: aload_0
    //   428: aload_1
    //   429: aload 7
    //   431: checkcast 542	android/util/SparseArray
    //   434: aload 5
    //   436: iload 6
    //   438: invokespecial 561	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;Ljava/lang/Class;I)V
    //   441: putfield 563	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/e;
    //   444: aload_3
    //   445: aload_1
    //   446: aload_0
    //   447: getfield 563	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/e;
    //   450: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   453: goto -292 -> 161
    //   456: astore_1
    //   457: new 489	com/tencent/theme/UnSupportPlatformException
    //   460: dup
    //   461: aload_1
    //   462: invokespecial 549	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   465: athrow
    //   466: aload 7
    //   468: instanceof 167
    //   471: ifeq +37 -> 508
    //   474: aload_0
    //   475: new 553	com/tencent/theme/d
    //   478: dup
    //   479: aload_0
    //   480: aload_1
    //   481: aload 7
    //   483: checkcast 167	android/util/LongSparseArray
    //   486: aload 5
    //   488: iload 6
    //   490: invokespecial 554	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   493: putfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   496: aload_3
    //   497: aload_1
    //   498: aload_0
    //   499: getfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   502: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   505: goto -344 -> 161
    //   508: new 489	com/tencent/theme/UnSupportPlatformException
    //   511: dup
    //   512: aload_2
    //   513: invokespecial 549	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   516: athrow
    //   517: astore_1
    //   518: getstatic 90	com/tencent/theme/SkinEngine:DEBUG	Z
    //   521: ifeq +13 -> 534
    //   524: ldc 46
    //   526: ldc_w 565
    //   529: aload_1
    //   530: invokestatic 568	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   533: pop
    //   534: iconst_0
    //   535: putstatic 112	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   538: return
    //   539: iconst_0
    //   540: istore 4
    //   542: goto -239 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	SkinEngine
    //   0	545	1	paramResources	Resources
    //   0	545	2	paramClass1	Class
    //   0	545	3	paramArrayOfInt	int[]
    //   0	545	4	paramInt1	int
    //   0	545	5	paramClass2	Class
    //   0	545	6	paramInt2	int
    //   0	545	7	paramFile	File
    //   21	330	8	localObject1	Object
    //   35	234	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	45	250	java/lang/IllegalArgumentException
    //   49	77	250	java/lang/IllegalArgumentException
    //   77	95	250	java/lang/IllegalArgumentException
    //   105	152	250	java/lang/IllegalArgumentException
    //   152	161	250	java/lang/IllegalArgumentException
    //   217	247	250	java/lang/IllegalArgumentException
    //   260	278	250	java/lang/IllegalArgumentException
    //   282	300	250	java/lang/IllegalArgumentException
    //   303	329	250	java/lang/IllegalArgumentException
    //   338	358	250	java/lang/IllegalArgumentException
    //   371	389	250	java/lang/IllegalArgumentException
    //   393	453	250	java/lang/IllegalArgumentException
    //   466	505	250	java/lang/IllegalArgumentException
    //   508	517	250	java/lang/IllegalArgumentException
    //   13	45	361	java/lang/NoSuchFieldException
    //   49	77	361	java/lang/NoSuchFieldException
    //   77	95	361	java/lang/NoSuchFieldException
    //   105	152	361	java/lang/NoSuchFieldException
    //   152	161	361	java/lang/NoSuchFieldException
    //   217	247	361	java/lang/NoSuchFieldException
    //   260	278	361	java/lang/NoSuchFieldException
    //   282	300	361	java/lang/NoSuchFieldException
    //   303	329	361	java/lang/NoSuchFieldException
    //   338	358	361	java/lang/NoSuchFieldException
    //   371	389	361	java/lang/NoSuchFieldException
    //   393	453	361	java/lang/NoSuchFieldException
    //   466	505	361	java/lang/NoSuchFieldException
    //   508	517	361	java/lang/NoSuchFieldException
    //   105	152	392	java/lang/Exception
    //   152	161	392	java/lang/Exception
    //   371	389	392	java/lang/Exception
    //   13	45	456	java/lang/IllegalAccessException
    //   49	77	456	java/lang/IllegalAccessException
    //   77	95	456	java/lang/IllegalAccessException
    //   105	152	456	java/lang/IllegalAccessException
    //   152	161	456	java/lang/IllegalAccessException
    //   217	247	456	java/lang/IllegalAccessException
    //   260	278	456	java/lang/IllegalAccessException
    //   282	300	456	java/lang/IllegalAccessException
    //   303	329	456	java/lang/IllegalAccessException
    //   338	358	456	java/lang/IllegalAccessException
    //   371	389	456	java/lang/IllegalAccessException
    //   393	453	456	java/lang/IllegalAccessException
    //   466	505	456	java/lang/IllegalAccessException
    //   508	517	456	java/lang/IllegalAccessException
    //   161	216	517	java/lang/Exception
  }
  
  private void a(b paramb)
  {
    Object localObject1 = paramb.f;
    Object localObject2 = ((j)localObject1).b;
    if (this.r != null)
    {
      a(this.mResources, this.c, ((j)localObject1).d, d[this.t], e[this.t]);
      if (this.c.string != null)
      {
        ((j)localObject1).b = this.c.string.toString();
        ((j)localObject1).c = this.c.density;
        if ((localObject2 != null) || (((j)localObject1).b != null) || (((j)localObject1).d.endsWith(".xml"))) {
          break label127;
        }
      }
    }
    label127:
    do
    {
      do
      {
        return;
        ((j)localObject1).b = null;
        break;
        ((j)localObject1).b = null;
        break;
        if (!(paramb instanceof SkinnableBitmapDrawable.a)) {
          break label291;
        }
        paramb = (SkinnableBitmapDrawable.a)paramb;
        localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
        if ((DEBUG) && ((localObject2 instanceof SkinnableNinePatchDrawable.a))) {
          throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
        }
        localObject1 = (SkinnableBitmapDrawable.a)localObject2;
        paramb.i = ((SkinnableBitmapDrawable.a)localObject1).i;
        paramb.g = ((SkinnableBitmapDrawable.a)localObject1).g;
        paramb.h = ((SkinnableBitmapDrawable.a)localObject1).h;
      } while ((!paramb.p) && (!((SkinnableBitmapDrawable.a)localObject1).p));
      paramb.k = ((SkinnableBitmapDrawable.a)localObject1).k;
      paramb.l = ((SkinnableBitmapDrawable.a)localObject1).l;
      paramb.m = ((SkinnableBitmapDrawable.a)localObject1).m;
      paramb.n = ((SkinnableBitmapDrawable.a)localObject1).n;
      paramb.p = true;
      return;
    } while (!(paramb instanceof SkinnableNinePatchDrawable.a));
    label291:
    paramb = (SkinnableNinePatchDrawable.a)paramb;
    localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
    if ((DEBUG) && ((localObject2 instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
    }
    localObject1 = (SkinnableNinePatchDrawable.a)localObject2;
    paramb.h = ((SkinnableNinePatchDrawable.a)localObject1).h;
    paramb.i = ((SkinnableNinePatchDrawable.a)localObject1).i;
    paramb.k = paramb.j;
    paramb.j = ((SkinnableNinePatchDrawable.a)localObject1).j;
    paramb.o = ((SkinnableNinePatchDrawable.a)localObject1).o;
    paramb.g = ((SkinnableNinePatchDrawable.a)localObject1).g;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.x == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.x = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.y == null)
      {
        if (this.r == null) {
          this.y = new HashMap();
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
        this.x = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        a locala = new a();
        localObject = new FileInputStream(new File(this.r, "xml/theme_config.xml"));
        locala.setInput((InputStream)localObject, "UTF-8");
        this.y = a(locala);
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
        this.y = new HashMap();
      }
    }
  }
  
  private SkinnableColorStateList b(int paramInt, Resources paramResources, j paramj)
  {
    Object localObject;
    synchronized (this.c)
    {
      localObject = paramj.b;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool) {
          try
          {
            paramResources = i.a(paramResources, new File((String)localObject), this.o);
            return paramResources;
          }
          catch (Exception paramResources)
          {
            paramj = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
            paramj.initCause(paramResources);
            throw paramj;
          }
        }
      }
    }
    paramj = paramj.d;
    boolean bool = paramj.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.c);
        paramResources = SkinnableColorStateList.createFromXml(paramResources, (XmlPullParser)localObject, true);
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramj = new Resources.NotFoundException("File " + paramj + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paramj.initCause(paramResources);
        throw paramj;
      }
    }
    throw new Resources.NotFoundException("File " + paramj + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new FileInputStream(new File(paramString));
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    paramContext = this.c;
    int i1 = 0;
    for (;;)
    {
      j localj;
      try
      {
        if (i1 >= this.q.size()) {
          break label150;
        }
        SkinnableColorStateList localSkinnableColorStateList = (SkinnableColorStateList)((WeakReference)this.q.valueAt(i1)).get();
        if (localSkinnableColorStateList == null) {
          break label153;
        }
        localj = localSkinnableColorStateList.skinData;
        String str1 = localj.b;
        if (this.r != null)
        {
          String str2 = a(this.mResources, localj.d);
          if (str2 != null)
          {
            localj.b = str2;
            if ((str1 != null) || (localj.b != null)) {
              break label128;
            }
            break label153;
          }
          localj.b = null;
          continue;
        }
        localj.b = null;
      }
      finally {}
      continue;
      label128:
      localObject.a(b(localj.a, this.mResources, localj));
      break label153;
      label150:
      return;
      label153:
      i1 += 1;
    }
  }
  
  @TargetApi(16)
  private void c(Context arg1)
  {
    for (;;)
    {
      int i1;
      synchronized (this.c)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.p.size())
        {
          b localb = (b)((WeakReference)this.p.valueAt(i1)).get();
          if (localb == null) {
            break label126;
          }
          if (localb.f.d.endsWith(".xml")) {
            localArrayList.add(localb);
          } else {
            a(localb);
          }
        }
      }
      Iterator localIterator = localObject.iterator();
      while (localIterator.hasNext()) {
        a((b)localIterator.next());
      }
      return;
      label126:
      i1 += 1;
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (m == null) {
        m = new SkinEngine();
      }
      SkinEngine localSkinEngine = m;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, Class paramClass1, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.t = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.l, new IntentFilter("com.tencent.qplus.THEME_UPDATE"));
    localSkinEngine.a(localResources, paramClass1, null, paramInt1, paramClass2, paramInt2, paramFile);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      paramContext = paramContext.getSharedPreferences("theme", paramInt1);
      localSkinEngine.r = paramContext.getString("theme_root", null);
      localSkinEngine.o = paramContext.getBoolean("complied", true);
      return;
    }
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, Class paramClass, int paramInt, File paramFile)
    throws UnSupportPlatformException
  {
    int i1 = 0;
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.t = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.l, new IntentFilter("com.tencent.qplus.THEME_UPDATE"));
    localSkinEngine.a(localResources, null, paramArrayOfInt, 0, paramClass, paramInt, paramFile);
    paramInt = i1;
    if (Build.VERSION.SDK_INT >= 11) {
      paramInt = 4;
    }
    paramContext = paramContext.getSharedPreferences("theme", paramInt);
    localSkinEngine.r = paramContext.getString("theme_root", null);
    localSkinEngine.o = paramContext.getBoolean("complied", true);
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
  
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    try
    {
      localObject = Resources.class.getDeclaredField("sPreloadedDrawables");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramResources);
      if ((!(localObject instanceof LongSparseArray)) && (!(localObject instanceof LongSparseArray[]))) {
        throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      Object localObject;
      throw new UnSupportPlatformException(paramContext);
      try
      {
        localObject = Resources.class.getDeclaredField("sPreloadedColorStateLists");
        ((Field)localObject).setAccessible(true);
        if (!(((Field)localObject).get(paramResources) instanceof LongSparseArray)) {
          throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
        }
      }
      catch (Exception localException)
      {
        Field localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
        localField.setAccessible(true);
        paramResources = localField.get(paramResources);
        boolean bool = paramResources instanceof SparseArray;
        if (bool) {}
        while (l.a(paramContext, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22"))
        {
          throw new UnSupportPlatformException("lewa is not supported");
          if (!(paramResources instanceof LongSparseArray)) {
            throw new UnSupportPlatformException(localException);
          }
        }
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
  }
  
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject1 = (WeakReference)this.p.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.p.delete(paramInt);
      }
      this.mResources.getValue(paramInt, this.c, true);
      Object localObject3 = this.c.string.toString();
      localObject1 = new j();
      ((j)localObject1).a = paramInt;
      ((j)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
      if (this.r != null)
      {
        a(this.mResources, this.c, ((j)localObject1).d, d[this.t], e[this.t]);
        if (this.c.string != null)
        {
          ((j)localObject1).b = this.c.string.toString();
          ((j)localObject1).c = this.c.density;
        }
      }
      localObject3 = a(paramInt, this.mResources, (j)localObject1);
      if (localObject3 != null)
      {
        ((b)localObject3).f = ((j)localObject1);
        this.p.put(paramInt, new WeakReference(localObject3));
      }
      return localObject3;
    }
  }
  
  void a(Context paramContext)
  {
    this.n = true;
    int i1;
    if (Build.VERSION.SDK_INT >= 11) {
      i1 = 4;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", i1);
      String str = localSharedPreferences.getString("pending_theme_root", null);
      boolean bool;
      if (str != null) {
        bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
      }
      synchronized (this.c)
      {
        this.s = this.r;
        this.r = str;
        this.o = bool;
        c(paramContext);
        b(paramContext);
        localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.o).commit();
        this.n = false;
        this.s = null;
        return;
        i1 = 0;
        continue;
        bool = true;
      }
    }
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.u.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject1 = (WeakReference)this.q.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.q.delete(paramInt);
      }
      this.mResources.getValue(paramInt, this.c, true);
      Object localObject3 = this.c.string.toString();
      if (((String)localObject3).endsWith(".xml"))
      {
        localObject1 = new j();
        ((j)localObject1).a = paramInt;
        ((j)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
        if (this.r != null) {
          ((j)localObject1).b = a(this.mResources, ((j)localObject1).d);
        }
        localObject3 = b(paramInt, this.mResources, (j)localObject1);
        ((SkinnableColorStateList)localObject3).skinData = ((j)localObject1);
        this.q.put(paramInt, new WeakReference(localObject3));
        return localObject3;
      }
    }
    return null;
  }
  
  public String getSkinRootPath()
  {
    if (this.n) {
      return this.s;
    }
    return this.r;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.c)
      {
        a(this.o);
        Object localObject2 = this.y.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.x.get(paramString);
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
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    Object localObject;
    if (this.r != null)
    {
      localObject = (WeakReference)this.p.get(paramInt);
      if (localObject == null) {
        break label83;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject == null) {
        break label74;
      }
      if (((b)localObject).f.b == null) {
        break label83;
      }
      paramTypedValue.type = 16777215;
      paramTypedValue.string = ((b)localObject).f.b;
    }
    label74:
    label83:
    TypedValue localTypedValue;
    do
    {
      return;
      this.p.delete(paramInt);
      localObject = paramTypedValue.string.toString();
      localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      localTypedValue = new TypedValue();
      a(this.mResources, localTypedValue, (String)localObject, d[this.t], e[this.t]);
    } while (localTypedValue.string == null);
    paramTypedValue.type = 16777215;
    paramTypedValue.string = localTypedValue.string;
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.k = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    if (this.n) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      i1 = 4;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", i1);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"));
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
            Log.w("SKinEngine", "wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   4: ifnull +39 -> 43
    //   7: ldc 176
    //   9: ldc_w 497
    //   12: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 963	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 966	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   37: getfield 968	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc 176
    //   45: ldc_w 529
    //   48: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 190	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 167	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   75: getfield 970	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 518	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/g;
    //   88: getfield 968	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: ldc_w 972
    //   103: ldc_w 974
    //   106: aload_1
    //   107: invokestatic 568	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: pop
    //   111: return
    //   112: astore_1
    //   113: ldc 176
    //   115: ldc_w 556
    //   118: invokevirtual 501	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   121: astore_1
    //   122: aload_1
    //   123: iconst_1
    //   124: invokevirtual 507	java/lang/reflect/Field:setAccessible	(Z)V
    //   127: aload_1
    //   128: aload_0
    //   129: getfield 190	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   132: invokevirtual 511	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore_2
    //   136: aload_2
    //   137: instanceof 542
    //   140: ifeq +16 -> 156
    //   143: aload_1
    //   144: aconst_null
    //   145: aload_0
    //   146: getfield 563	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/e;
    //   149: getfield 977	com/tencent/theme/e:b	Landroid/util/SparseArray;
    //   152: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   155: return
    //   156: aload_2
    //   157: instanceof 167
    //   160: ifeq -79 -> 81
    //   163: aload_1
    //   164: aconst_null
    //   165: aload_0
    //   166: getfield 536	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/d;
    //   169: getfield 970	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   172: invokevirtual 527	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	8	1	localException1	Exception
    //   112	1	1	localException2	Exception
    //   121	43	1	localField2	Field
    //   68	89	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   113	155	99	java/lang/Exception
    //   156	175	99	java/lang/Exception
    //   43	81	112	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.u.a(paramFile);
  }
  
  private class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */