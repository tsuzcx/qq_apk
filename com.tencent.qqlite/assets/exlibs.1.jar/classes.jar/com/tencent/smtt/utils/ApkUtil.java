package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ApkUtil
{
  private static Class<AssetManager> CLASS_ASSET;
  private static final String LOGTAG = "ApkUtil";
  private static Method METHOD_ADD_ASSET;
  public static final String TBS_APK_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  
  static
  {
    try
    {
      CLASS_ASSET = AssetManager.class;
      METHOD_ADD_ASSET = CLASS_ASSET.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private static boolean checkApkFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    return true;
  }
  
  public static ApkInfo getApkInfo(Context paramContext, String paramString)
  {
    if (!checkApkFile(paramString)) {
      return null;
    }
    Object localObject2 = null;
    for (;;)
    {
      ApplicationInfo localApplicationInfo;
      try
      {
        localPackageInfo = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
        paramString = getResources(paramContext, paramString);
        if ((localPackageInfo == null) || (paramString == null)) {
          break;
        }
        localApplicationInfo = localPackageInfo.applicationInfo;
        if (localApplicationInfo == null)
        {
          str = null;
          break label163;
          localObject1 = paramString;
          if (paramString == null)
          {
            localObject1 = paramString;
            if (localApplicationInfo != null) {
              localObject1 = paramContext.getPackageManager().getApplicationIcon(localApplicationInfo);
            }
          }
          paramContext = new ApkInfo();
        }
      }
      catch (Throwable paramString)
      {
        PackageInfo localPackageInfo;
        String str;
        Object localObject1;
        paramContext = localObject2;
        paramString.printStackTrace();
        return paramContext;
      }
      try
      {
        paramContext.packageInfo = localPackageInfo;
        paramContext.packageName = localPackageInfo.packageName;
        paramContext.name = str;
        paramContext.icon = ((Drawable)localObject1);
        paramContext.version = localPackageInfo.versionCode;
        return paramContext;
      }
      catch (Throwable paramString)
      {
        continue;
      }
      str = getString(paramString, localApplicationInfo.labelRes);
      break label163;
      paramString = getDrawable(paramString, localApplicationInfo.icon);
      continue;
      label163:
      if (localApplicationInfo == null) {
        paramString = null;
      }
    }
  }
  
  public static int getApkVersion(Context paramContext, File paramFile)
  {
    int j = 0;
    int i = j;
    if (paramFile != null)
    {
      i = j;
      if (paramFile.exists())
      {
        paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
        i = j;
        if (paramContext != null) {
          i = paramContext.versionCode;
        }
      }
    }
    return i;
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext, String paramString)
  {
    return getApplicationInfo(paramContext, paramString, 0);
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext, String paramString, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!checkApkFile(paramString))
    {
      localObject1 = localObject2;
      return localObject1;
    }
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, paramInt);
    if (paramContext == null) {}
    for (paramContext = (Context)localObject1;; paramContext = paramContext.applicationInfo)
    {
      localObject1 = paramContext;
      if (paramContext == null) {
        break;
      }
      paramContext.sourceDir = paramString;
      paramContext.publicSourceDir = paramString;
      return paramContext;
    }
  }
  
  private static Drawable getDrawable(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getDrawable(paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return null;
  }
  
  /* Error */
  public static String getMd5(File paramFile)
  {
    // Byte code:
    //   0: bipush 16
    //   2: newarray char
    //   4: astore 8
    //   6: aload 8
    //   8: dup
    //   9: iconst_0
    //   10: ldc 173
    //   12: castore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 174
    //   17: castore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 175
    //   22: castore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 176
    //   27: castore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 177
    //   32: castore
    //   33: dup
    //   34: iconst_5
    //   35: ldc 178
    //   37: castore
    //   38: dup
    //   39: bipush 6
    //   41: ldc 179
    //   43: castore
    //   44: dup
    //   45: bipush 7
    //   47: ldc 180
    //   49: castore
    //   50: dup
    //   51: bipush 8
    //   53: ldc 181
    //   55: castore
    //   56: dup
    //   57: bipush 9
    //   59: ldc 182
    //   61: castore
    //   62: dup
    //   63: bipush 10
    //   65: ldc 183
    //   67: castore
    //   68: dup
    //   69: bipush 11
    //   71: ldc 184
    //   73: castore
    //   74: dup
    //   75: bipush 12
    //   77: ldc 185
    //   79: castore
    //   80: dup
    //   81: bipush 13
    //   83: ldc 186
    //   85: castore
    //   86: dup
    //   87: bipush 14
    //   89: ldc 187
    //   91: castore
    //   92: dup
    //   93: bipush 15
    //   95: ldc 188
    //   97: castore
    //   98: pop
    //   99: aconst_null
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 7
    //   105: bipush 32
    //   107: newarray char
    //   109: astore 9
    //   111: aload 6
    //   113: astore 5
    //   115: ldc 190
    //   117: invokestatic 196	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   120: astore 10
    //   122: aload 6
    //   124: astore 5
    //   126: new 198	java/io/FileInputStream
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   134: astore_0
    //   135: sipush 8192
    //   138: newarray byte
    //   140: astore 5
    //   142: aload_0
    //   143: aload 5
    //   145: invokevirtual 205	java/io/FileInputStream:read	([B)I
    //   148: istore_1
    //   149: iload_1
    //   150: iconst_m1
    //   151: if_icmpeq +35 -> 186
    //   154: aload 10
    //   156: aload 5
    //   158: iconst_0
    //   159: iload_1
    //   160: invokevirtual 209	java/security/MessageDigest:update	([BII)V
    //   163: goto -21 -> 142
    //   166: astore 6
    //   168: aload_0
    //   169: astore 5
    //   171: aload 6
    //   173: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 213	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: aload 10
    //   188: invokevirtual 217	java/security/MessageDigest:digest	()[B
    //   191: astore 5
    //   193: iconst_0
    //   194: istore_1
    //   195: iconst_0
    //   196: istore_2
    //   197: iload_1
    //   198: bipush 16
    //   200: if_icmpge +50 -> 250
    //   203: aload 5
    //   205: iload_1
    //   206: baload
    //   207: istore_3
    //   208: iload_2
    //   209: iconst_1
    //   210: iadd
    //   211: istore 4
    //   213: aload 9
    //   215: iload_2
    //   216: aload 8
    //   218: iload_3
    //   219: iconst_4
    //   220: iushr
    //   221: bipush 15
    //   223: iand
    //   224: caload
    //   225: castore
    //   226: iload 4
    //   228: iconst_1
    //   229: iadd
    //   230: istore_2
    //   231: aload 9
    //   233: iload 4
    //   235: aload 8
    //   237: iload_3
    //   238: bipush 15
    //   240: iand
    //   241: caload
    //   242: castore
    //   243: iload_1
    //   244: iconst_1
    //   245: iadd
    //   246: istore_1
    //   247: goto -50 -> 197
    //   250: new 41	java/lang/String
    //   253: dup
    //   254: aload 9
    //   256: invokespecial 220	java/lang/String:<init>	([C)V
    //   259: astore 5
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 213	java/io/FileInputStream:close	()V
    //   269: aload 5
    //   271: areturn
    //   272: astore_0
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 213	java/io/FileInputStream:close	()V
    //   283: aload_0
    //   284: athrow
    //   285: astore 5
    //   287: aload 5
    //   289: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   292: goto -9 -> 283
    //   295: astore_0
    //   296: aload_0
    //   297: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_0
    //   303: aload_0
    //   304: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   307: goto -38 -> 269
    //   310: astore 6
    //   312: aload_0
    //   313: astore 5
    //   315: aload 6
    //   317: astore_0
    //   318: goto -45 -> 273
    //   321: astore 6
    //   323: aload_0
    //   324: astore 5
    //   326: aload 6
    //   328: astore_0
    //   329: goto -56 -> 273
    //   332: astore 6
    //   334: aload 7
    //   336: astore_0
    //   337: goto -169 -> 168
    //   340: astore 6
    //   342: goto -174 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramFile	File
    //   148	99	1	i	int
    //   196	35	2	j	int
    //   207	34	3	k	int
    //   211	23	4	m	int
    //   113	166	5	localObject1	Object
    //   285	3	5	localIOException	IOException
    //   313	12	5	localFile	File
    //   100	23	6	localObject2	Object
    //   166	6	6	localException1	Exception
    //   310	6	6	localObject3	Object
    //   321	6	6	localObject4	Object
    //   332	1	6	localException2	Exception
    //   340	1	6	localException3	Exception
    //   103	232	7	localObject5	Object
    //   4	232	8	arrayOfChar1	char[]
    //   109	146	9	arrayOfChar2	char[]
    //   120	67	10	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   135	142	166	java/lang/Exception
    //   142	149	166	java/lang/Exception
    //   154	163	166	java/lang/Exception
    //   186	193	166	java/lang/Exception
    //   115	122	272	finally
    //   126	135	272	finally
    //   171	176	272	finally
    //   278	283	285	java/io/IOException
    //   180	184	295	java/io/IOException
    //   265	269	302	java/io/IOException
    //   135	142	310	finally
    //   142	149	310	finally
    //   154	163	310	finally
    //   186	193	310	finally
    //   250	261	321	finally
    //   115	122	332	java/lang/Exception
    //   126	135	332	java/lang/Exception
    //   250	261	340	java/lang/Exception
  }
  
  private static PackageInfo getPackageArchiveInfo(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Class.forName("android.content.pm.PackageParser");
        Object localObject2 = ((Class)localObject1).getDeclaredClasses();
        Method localMethod2 = null;
        int j = localObject2.length;
        i = 0;
        Method localMethod1 = localMethod2;
        if (i < j)
        {
          localMethod1 = localObject2[i];
          if (localMethod1.getName().compareTo("android.content.pm.PackageParser$Package") != 0) {}
        }
        else
        {
          Object localObject3 = ((Class)localObject1).getConstructor(new Class[] { String.class });
          localObject2 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
          localMethod2 = ((Class)localObject1).getDeclaredMethod("collectCertificates", new Class[] { localMethod1, Integer.TYPE });
          localMethod1 = ((Class)localObject1).getDeclaredMethod("generatePackageInfo", new Class[] { localMethod1, [I.class, Integer.TYPE, Long.TYPE, Long.TYPE });
          ((Constructor)localObject3).setAccessible(true);
          ((Method)localObject2).setAccessible(true);
          localMethod2.setAccessible(true);
          localMethod1.setAccessible(true);
          localObject1 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
          localObject3 = new DisplayMetrics();
          ((DisplayMetrics)localObject3).setToDefaults();
          paramString = ((Method)localObject2).invoke(localObject1, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
          if (paramString == null) {
            return null;
          }
          if ((paramInt & 0x40) != 0) {
            localMethod2.invoke(localObject1, new Object[] { paramString, Integer.valueOf(0) });
          }
          paramString = (PackageInfo)localMethod1.invoke(null, new Object[] { paramString, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    return getPackageInfo(paramContext, paramString, 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString, int paramInt)
  {
    if (!checkApkFile(paramString)) {
      paramContext = null;
    }
    PackageInfo localPackageInfo;
    do
    {
      do
      {
        return paramContext;
        localPackageInfo = paramContext.getPackageManager().getPackageArchiveInfo(paramString, paramInt);
        if (localPackageInfo == null) {
          return null;
        }
        paramContext = localPackageInfo;
      } while ((paramInt & 0x40) == 0);
      paramContext = localPackageInfo;
    } while (localPackageInfo.signatures != null);
    localPackageInfo.signatures = Certificates.collectCertificates(paramString);
    return localPackageInfo;
  }
  
  public static Resources getResources(Context paramContext, String paramString)
  {
    Object localObject4;
    if (!checkApkFile(paramString)) {
      localObject4 = null;
    }
    for (;;)
    {
      return localObject4;
      Object localObject5 = null;
      Object localObject1 = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      if (localObject1 == null)
      {
        localObject4 = null;
        localObject1 = localObject5;
        if (localObject4 != null)
        {
          ((ApplicationInfo)localObject4).sourceDir = paramString;
          ((ApplicationInfo)localObject4).publicSourceDir = paramString;
        }
      }
      try
      {
        localObject1 = paramContext.getPackageManager().getResourcesForApplication((ApplicationInfo)localObject4);
        localObject4 = localObject1;
        if (localObject1 != null) {
          continue;
        }
        return getResourcesWithReflect(paramContext, paramString);
        localObject4 = ((PackageInfo)localObject1).applicationInfo;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          Object localObject2 = localObject5;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject3 = localObject5;
        }
      }
    }
  }
  
  private static Resources getResourcesWithReflect(Context paramContext, String paramString)
  {
    if ((CLASS_ASSET == null) || (METHOD_ADD_ASSET == null)) {}
    while (!checkApkFile(paramString)) {
      return null;
    }
    try
    {
      AssetManager localAssetManager = (AssetManager)CLASS_ASSET.newInstance();
      METHOD_ADD_ASSET.invoke(localAssetManager, new Object[] { paramString });
      paramContext = new Resources(localAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (InstantiationException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getSignatureFromApk(Context paramContext, File paramFile)
  {
    Object localObject2 = getSignatureFromApk(paramContext, paramFile, false);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getSignatureFromApk(paramFile);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getSignatureFromApk(paramContext, paramFile, true);
    }
    return localObject2;
  }
  
  private static String getSignatureFromApk(Context paramContext, File paramFile, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramBoolean)
    {
      paramFile = getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      localObject2 = null;
      paramContext = localObject2;
      if (paramFile != null) {
        if ((paramFile.signatures == null) || (paramFile.signatures.length <= 0)) {
          break label78;
        }
      }
    }
    for (paramContext = paramFile.signatures[0];; paramContext = localObject2)
    {
      paramFile = localObject1;
      if (paramContext != null) {
        paramFile = paramContext.toCharsString();
      }
      return paramFile;
      paramFile = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      break;
      label78:
      TbsLog.w("ApkUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
    }
  }
  
  private static String getSignatureFromApk(File paramFile)
  {
    try
    {
      JarFile localJarFile = new JarFile(paramFile);
      paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
      byte[] arrayOfByte = new byte[8192];
      String str1 = toCharsString(loadCertificates(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
      Enumeration localEnumeration = localJarFile.entries();
      boolean bool;
      do
      {
        String str2;
        do
        {
          do
          {
            paramFile = str1;
            if (!localEnumeration.hasMoreElements()) {
              break;
            }
            paramFile = (JarEntry)localEnumeration.nextElement();
            str2 = paramFile.getName();
          } while (str2 == null);
          Certificate[] arrayOfCertificate = loadCertificates(localJarFile, paramFile, arrayOfByte);
          paramFile = null;
          if (arrayOfCertificate != null) {
            paramFile = toCharsString(arrayOfCertificate[0].getEncoded());
          }
          if (paramFile != null) {
            break;
          }
        } while (str2.startsWith("META-INF/"));
        return null;
        bool = paramFile.equals(str1);
      } while (bool);
      return null;
    }
    catch (Exception localException)
    {
      paramFile = null;
      localException.printStackTrace();
    }
    return paramFile;
  }
  
  private static String getString(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getString(paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return null;
  }
  
  private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
    throws Exception
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  private static String toCharsString(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label44:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label44;
        label97:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  public static boolean verifyTbsApk(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return false;
      if ((paramLong <= 0L) || (paramLong == paramFile.length())) {
        try
        {
          if (paramInt == getApkVersion(paramContext, paramFile))
          {
            boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(getSignatureFromApk(paramContext, paramFile));
            if (bool) {
              return true;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  public static class ApkInfo
  {
    public Drawable icon;
    public String name;
    public PackageInfo packageInfo;
    public String packageName;
    public float version;
  }
  
  public static class Certificates
  {
    private static final String ANDROID_DEX_FILENAME = "classes.dex";
    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    private static final boolean DEBUG_JAR = false;
    public static final String[] IMPORTANT_ENTRY = { "AndroidManifest.xml", "classes.dex" };
    public static final String[] MANIFEST_ENTRY = { "AndroidManifest.xml" };
    private static final String TAG = "Certificates";
    private static WeakReference<byte[]> mReadBuffer;
    private static final Object mSync = new Object();
    
    public static Signature[] collectCertificates(String paramString)
    {
      return collectCertificates(paramString, false);
    }
    
    public static Signature[] collectCertificates(String paramString, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (String[] arrayOfString = IMPORTANT_ENTRY;; arrayOfString = null) {
        return collectCertificates(paramString, arrayOfString);
      }
    }
    
    public static Signature[] collectCertificates(String paramString, String... paramVarArgs)
    {
      if (!isArchiveValid(paramString)) {
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        ??? = null;
        WeakReference localWeakReference;
        Object localObject2;
        synchronized (mSync)
        {
          localWeakReference = mReadBuffer;
          if (localWeakReference != null)
          {
            mReadBuffer = null;
            ??? = (byte[])localWeakReference.get();
          }
          localObject2 = ???;
          if (??? == null)
          {
            localObject2 = new byte[8192];
            localWeakReference = new WeakReference(localObject2);
          }
        }
        do
        {
          try
          {
            ??? = new JarFile(paramString);
            ??? = null;
            Enumeration localEnumeration = createJarEntries((JarFile)???, paramVarArgs);
            for (paramVarArgs = (String[])???;; paramVarArgs = (String[])???)
            {
              do
              {
                if (!localEnumeration.hasMoreElements()) {
                  break;
                }
                localJarEntry = (JarEntry)localEnumeration.nextElement();
              } while ((localJarEntry == null) || (localJarEntry.isDirectory()) || (localJarEntry.getName().startsWith("META-INF/")));
              ??? = loadCertificates((JarFile)???, localJarEntry, (byte[])localObject2);
              if (??? == null)
              {
                TbsLog.e("Certificates", "File " + paramString + " has no certificates at entry " + localJarEntry.getName() + "; ignoring!");
                ((JarFile)???).close();
                return null;
                paramString = finally;
                throw paramString;
              }
              if (paramVarArgs != null) {
                break;
              }
            }
            i = 0;
          }
          catch (IOException paramString)
          {
            JarEntry localJarEntry;
            int m;
            int k;
            return null;
          }
          catch (RuntimeException paramString)
          {
            for (;;)
            {
              int i;
              int j;
              return null;
              j += 1;
              continue;
              i += 1;
            }
          }
          catch (CertificateEncodingException paramString) {}
        } while (i >= paramVarArgs.length);
        m = 0;
        j = 0;
        k = m;
        if (j < ???.length)
        {
          if ((paramVarArgs[i] == null) || (!paramVarArgs[i].equals(???[j]))) {
            break label456;
          }
          k = 1;
        }
        if ((k != 0) && (paramVarArgs.length == ???.length)) {
          break label463;
        }
        Log.e("Certificates", "File " + paramString + " has mismatched certificates at entry " + localJarEntry.getName() + "; ignoring!");
        ((JarFile)???).close();
        return null;
        ((JarFile)???).close();
        synchronized (mSync)
        {
          mReadBuffer = localWeakReference;
          if ((paramVarArgs != null) && (paramVarArgs.length > 0))
          {
            j = paramVarArgs.length;
            ??? = new Signature[paramVarArgs.length];
            i = 0;
            paramString = (String)???;
            if (i >= j) {
              continue;
            }
            ???[i] = new Signature(paramVarArgs[i].getEncoded());
            i += 1;
          }
        }
      }
      Log.e("Certificates", "File " + paramString + " has no certificates; ignoring!");
      return null;
      label456:
      label463:
      return null;
    }
    
    private static Enumeration<JarEntry> createJarEntries(JarFile paramJarFile, String... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        return paramJarFile.entries();
      }
      return new JarFileEnumerator(paramJarFile, paramVarArgs);
    }
    
    private static boolean isArchiveValid(String paramString)
    {
      if ((paramString == null) || (paramString.length() == 0)) {}
      do
      {
        return false;
        paramString = new File(paramString);
      } while ((!paramString.exists()) || (!paramString.isFile()));
      return true;
    }
    
    /* Error */
    private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 7
      //   5: aconst_null
      //   6: astore 5
      //   8: aconst_null
      //   9: astore 6
      //   11: aconst_null
      //   12: astore 4
      //   14: new 186	java/io/BufferedInputStream
      //   17: dup
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 190	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      //   23: invokespecial 193	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   26: astore_0
      //   27: aload_0
      //   28: aload_2
      //   29: iconst_0
      //   30: aload_2
      //   31: arraylength
      //   32: invokevirtual 199	java/io/InputStream:read	([BII)I
      //   35: iconst_m1
      //   36: if_icmpne -9 -> 27
      //   39: aload 7
      //   41: astore_2
      //   42: aload_1
      //   43: ifnull +8 -> 51
      //   46: aload_1
      //   47: invokevirtual 203	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
      //   50: astore_2
      //   51: aload_0
      //   52: ifnull +7 -> 59
      //   55: aload_0
      //   56: invokevirtual 204	java/io/InputStream:close	()V
      //   59: aload_2
      //   60: areturn
      //   61: astore_0
      //   62: aload 4
      //   64: astore_1
      //   65: aload_1
      //   66: ifnull +7 -> 73
      //   69: aload_1
      //   70: invokevirtual 204	java/io/InputStream:close	()V
      //   73: aload_0
      //   74: athrow
      //   75: astore_0
      //   76: aload 5
      //   78: astore_0
      //   79: aload_3
      //   80: astore_2
      //   81: aload_0
      //   82: ifnull -23 -> 59
      //   85: aload_0
      //   86: invokevirtual 204	java/io/InputStream:close	()V
      //   89: aconst_null
      //   90: areturn
      //   91: aload_3
      //   92: astore_2
      //   93: aload_0
      //   94: ifnull -35 -> 59
      //   97: aload_0
      //   98: invokevirtual 204	java/io/InputStream:close	()V
      //   101: aconst_null
      //   102: areturn
      //   103: astore_1
      //   104: goto -31 -> 73
      //   107: astore_0
      //   108: goto -49 -> 59
      //   111: astore_2
      //   112: aload_0
      //   113: astore_1
      //   114: aload_2
      //   115: astore_0
      //   116: goto -51 -> 65
      //   119: astore_1
      //   120: goto -29 -> 91
      //   123: astore_1
      //   124: goto -45 -> 79
      //   127: astore_0
      //   128: aconst_null
      //   129: areturn
      //   130: astore_0
      //   131: aload 6
      //   133: astore_0
      //   134: goto -43 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	137	0	paramJarFile	JarFile
      //   0	137	1	paramJarEntry	JarEntry
      //   0	137	2	paramArrayOfByte	byte[]
      //   1	91	3	localObject1	Object
      //   12	51	4	localObject2	Object
      //   6	71	5	localObject3	Object
      //   9	123	6	localObject4	Object
      //   3	37	7	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   14	27	61	finally
      //   14	27	75	java/io/IOException
      //   69	73	103	java/lang/Exception
      //   55	59	107	java/lang/Exception
      //   27	39	111	finally
      //   46	51	111	finally
      //   27	39	119	java/lang/RuntimeException
      //   46	51	119	java/lang/RuntimeException
      //   27	39	123	java/io/IOException
      //   46	51	123	java/io/IOException
      //   85	89	127	java/lang/Exception
      //   97	101	127	java/lang/Exception
      //   14	27	130	java/lang/RuntimeException
    }
    
    static class JarFileEnumerator
      implements Enumeration<JarEntry>
    {
      private final String[] entryNames;
      private int index = 0;
      private final JarFile jarFile;
      
      public JarFileEnumerator(JarFile paramJarFile, String... paramVarArgs)
      {
        this.jarFile = paramJarFile;
        this.entryNames = paramVarArgs;
      }
      
      public boolean hasMoreElements()
      {
        return this.index < this.entryNames.length;
      }
      
      public JarEntry nextElement()
      {
        JarFile localJarFile = this.jarFile;
        String[] arrayOfString = this.entryNames;
        int i = this.index;
        this.index = (i + 1);
        return localJarFile.getJarEntry(arrayOfString[i]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.ApkUtil
 * JD-Core Version:    0.7.0.1
 */