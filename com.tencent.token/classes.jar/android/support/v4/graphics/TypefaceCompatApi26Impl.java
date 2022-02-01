package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi26Impl
  extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  private static final Method sAbortCreation;
  private static final Method sAddFontFromAssetManager;
  private static final Method sAddFontFromBuffer;
  private static final Method sCreateFromFamiliesWithDefault;
  private static final Class sFontFamily;
  private static final Constructor sFontFamilyCtor;
  private static final Method sFreeze;
  
  static
  {
    Object localObject3 = null;
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod1 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class });
      localObject4 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class, Integer.TYPE, Integer.TYPE });
      localObject5 = localClass.getMethod("freeze", new Class[0]);
      localObject1 = localClass.getMethod("abortCreation", new Class[0]);
      Method localMethod2 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
      localMethod2.setAccessible(true);
      localObject3 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject1;
      localObject1 = localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Object localObject2 = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Method localMethod1 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label232;
    }
    sFontFamilyCtor = localConstructor;
    sFontFamily = localClass;
    sAddFontFromAssetManager = localMethod1;
    sAddFontFromBuffer = (Method)localObject5;
    sFreeze = (Method)localObject4;
    sAbortCreation = localObject3;
    sCreateFromFamiliesWithDefault = (Method)localObject1;
  }
  
  private static void abortCreation(Object paramObject)
  {
    try
    {
      sAbortCreation.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label14:
      break label14;
    }
  }
  
  private static boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)sAddFontFromAssetManager.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), null })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      label78:
      break label78;
    }
  }
  
  private static boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)sAddFontFromBuffer.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label53:
      break label53;
    }
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(sFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label50:
      break label50;
    }
  }
  
  private static boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)sFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label21:
      break label21;
    }
  }
  
  private static boolean isFontFamilyPrivateAPIAvailable()
  {
    if (sAddFontFromAssetManager == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    return sAddFontFromAssetManager != null;
  }
  
  private static Object newFamily()
  {
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label14;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label14:
      break label14;
    }
  }
  
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromFontFamilyFilesResourceEntry(paramContext, paramFontFamilyFilesResourceEntry, paramResources, paramInt);
    }
    paramResources = newFamily();
    paramFontFamilyFilesResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int j = paramFontFamilyFilesResourceEntry.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramFontFamilyFilesResourceEntry[paramInt];
      String str = localObject.getFileName();
      int k = localObject.getWeight();
      if (localObject.isItalic()) {}
      for (int i = 1; !addFontFromAssetManager(paramContext, paramResources, str, 0, k, i); i = 0)
      {
        abortCreation(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  /* Error */
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +7 -> 10
    //   6: aconst_null
    //   7: astore_1
    //   8: aload_1
    //   9: areturn
    //   10: invokestatic 203	android/support/v4/graphics/TypefaceCompatApi26Impl:isFontFamilyPrivateAPIAvailable	()Z
    //   13: ifne +164 -> 177
    //   16: aload_0
    //   17: aload_3
    //   18: iload 4
    //   20: invokevirtual 245	android/support/v4/graphics/TypefaceCompatApi26Impl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   23: astore 10
    //   25: aload_1
    //   26: invokevirtual 249	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: astore_1
    //   30: aload_1
    //   31: aload 10
    //   33: invokevirtual 255	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   36: ldc_w 257
    //   39: aload_2
    //   40: invokevirtual 263	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   43: astore_3
    //   44: aconst_null
    //   45: astore_1
    //   46: aload_3
    //   47: ifnonnull +34 -> 81
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_3
    //   53: ifnull -45 -> 8
    //   56: iconst_0
    //   57: ifeq +18 -> 75
    //   60: aload_3
    //   61: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_1
    //   67: new 270	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 271	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: aload_3
    //   76: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: new 273	android/graphics/Typeface$Builder
    //   84: dup
    //   85: aload_3
    //   86: invokevirtual 277	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   89: invokespecial 280	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   92: aload 10
    //   94: invokevirtual 281	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   97: invokevirtual 285	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   100: aload 10
    //   102: invokevirtual 286	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   105: invokevirtual 290	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   108: invokevirtual 294	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull -107 -> 8
    //   118: iconst_0
    //   119: ifeq +18 -> 137
    //   122: aload_3
    //   123: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   126: aload_2
    //   127: areturn
    //   128: astore_1
    //   129: new 270	java/lang/NullPointerException
    //   132: dup
    //   133: invokespecial 271	java/lang/NullPointerException:<init>	()V
    //   136: athrow
    //   137: aload_3
    //   138: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   141: aload_2
    //   142: areturn
    //   143: astore_1
    //   144: aload_1
    //   145: athrow
    //   146: astore_2
    //   147: aload_3
    //   148: ifnull +11 -> 159
    //   151: aload_1
    //   152: ifnull +18 -> 170
    //   155: aload_3
    //   156: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   159: aload_2
    //   160: athrow
    //   161: astore_3
    //   162: aload_1
    //   163: aload_3
    //   164: invokevirtual 297	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   167: goto -8 -> 159
    //   170: aload_3
    //   171: invokevirtual 268	android/os/ParcelFileDescriptor:close	()V
    //   174: goto -15 -> 159
    //   177: aload_1
    //   178: aload_3
    //   179: aload_2
    //   180: invokestatic 303	android/support/v4/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroid/support/v4/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   183: astore 11
    //   185: invokestatic 207	android/support/v4/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   188: astore 10
    //   190: iconst_0
    //   191: istore 5
    //   193: aload_3
    //   194: arraylength
    //   195: istore 7
    //   197: iconst_0
    //   198: istore 6
    //   200: iload 6
    //   202: iload 7
    //   204: if_icmpge +92 -> 296
    //   207: aload_3
    //   208: iload 6
    //   210: aaload
    //   211: astore_1
    //   212: aload 11
    //   214: aload_1
    //   215: invokevirtual 255	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   218: invokeinterface 309 2 0
    //   223: checkcast 81	java/nio/ByteBuffer
    //   226: astore_2
    //   227: aload_2
    //   228: ifnonnull +12 -> 240
    //   231: iload 6
    //   233: iconst_1
    //   234: iadd
    //   235: istore 6
    //   237: goto -37 -> 200
    //   240: aload_1
    //   241: invokevirtual 312	android/support/v4/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   244: istore 8
    //   246: aload_1
    //   247: invokevirtual 281	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   250: istore 9
    //   252: aload_1
    //   253: invokevirtual 286	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   256: ifeq +28 -> 284
    //   259: iconst_1
    //   260: istore 5
    //   262: aload 10
    //   264: aload_2
    //   265: iload 8
    //   267: iload 9
    //   269: iload 5
    //   271: invokestatic 314	android/support/v4/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   274: ifne +16 -> 290
    //   277: aload 10
    //   279: invokestatic 229	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   282: aconst_null
    //   283: areturn
    //   284: iconst_0
    //   285: istore 5
    //   287: goto -25 -> 262
    //   290: iconst_1
    //   291: istore 5
    //   293: goto -62 -> 231
    //   296: iload 5
    //   298: ifne +10 -> 308
    //   301: aload 10
    //   303: invokestatic 229	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   306: aconst_null
    //   307: areturn
    //   308: aload 10
    //   310: invokestatic 231	android/support/v4/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   313: ifne +5 -> 318
    //   316: aconst_null
    //   317: areturn
    //   318: aload 10
    //   320: invokestatic 233	android/support/v4/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   323: iload 4
    //   325: invokestatic 318	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   328: areturn
    //   329: astore_2
    //   330: goto -183 -> 147
    //   333: astore_1
    //   334: aconst_null
    //   335: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	TypefaceCompatApi26Impl
    //   0	336	1	paramContext	Context
    //   0	336	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	336	3	paramArrayOfFontInfo	android.support.v4.provider.FontsContractCompat.FontInfo[]
    //   0	336	4	paramInt	int
    //   191	106	5	i	int
    //   198	38	6	j	int
    //   195	10	7	k	int
    //   244	22	8	m	int
    //   250	18	9	n	int
    //   23	296	10	localObject	Object
    //   183	30	11	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   60	64	66	java/lang/Throwable
    //   122	126	128	java/lang/Throwable
    //   81	112	143	java/lang/Throwable
    //   144	146	146	finally
    //   155	159	161	java/lang/Throwable
    //   81	112	329	finally
    //   30	44	333	java/io/IOException
    //   60	64	333	java/io/IOException
    //   67	75	333	java/io/IOException
    //   75	79	333	java/io/IOException
    //   122	126	333	java/io/IOException
    //   129	137	333	java/io/IOException
    //   137	141	333	java/io/IOException
    //   155	159	333	java/io/IOException
    //   159	161	333	java/io/IOException
    //   162	167	333	java/io/IOException
    //   170	174	333	java/io/IOException
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = newFamily();
    if (!addFontFromAssetManager(paramContext, paramResources, paramString, 0, -1, -1))
    {
      abortCreation(paramResources);
      return null;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi26Impl
 * JD-Core Version:    0.7.0.1
 */