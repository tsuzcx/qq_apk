import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.3;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class zxt
{
  private static zxt a;
  private static byte[] mLock = new byte[0];
  private aquy jdField_b_of_type_Aquy = new zxu(this);
  aqva jdField_b_of_type_Aqva;
  aqvc jdField_b_of_type_Aqvc;
  private Map<String, List<zxt.a>> it = Collections.synchronizedMap(new HashMap(6));
  private MQLruCache<String, Object> j = BaseApplicationImpl.sImageCache;
  
  /* Error */
  private Bitmap a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore 6
    //   10: aload_3
    //   11: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_2
    //   18: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: aload 7
    //   26: astore 6
    //   28: aload 6
    //   30: areturn
    //   31: new 70	android/graphics/BitmapFactory$Options
    //   34: dup
    //   35: invokespecial 71	android/graphics/BitmapFactory$Options:<init>	()V
    //   38: astore 9
    //   40: aload 9
    //   42: iconst_1
    //   43: putfield 75	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: new 77	java/io/BufferedInputStream
    //   49: dup
    //   50: new 79	java/io/FileInputStream
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 7
    //   63: aload 7
    //   65: astore 6
    //   67: aload 7
    //   69: aconst_null
    //   70: aload 9
    //   72: invokestatic 91	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   75: pop
    //   76: aload 7
    //   78: ifnull +12 -> 90
    //   81: aload 7
    //   83: astore 6
    //   85: aload 7
    //   87: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   90: aload 7
    //   92: astore 6
    //   94: aload_1
    //   95: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   98: invokevirtual 106	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   101: astore_1
    //   102: aload 7
    //   104: astore 6
    //   106: aload 9
    //   108: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   111: aload_1
    //   112: getfield 115	android/util/DisplayMetrics:widthPixels	I
    //   115: idiv
    //   116: istore 4
    //   118: aload 7
    //   120: astore 6
    //   122: aload 9
    //   124: getfield 118	android/graphics/BitmapFactory$Options:outHeight	I
    //   127: aload_1
    //   128: getfield 121	android/util/DisplayMetrics:heightPixels	I
    //   131: idiv
    //   132: istore 5
    //   134: iload 4
    //   136: iload 5
    //   138: if_icmpge +118 -> 256
    //   141: aload 7
    //   143: astore 6
    //   145: aload 9
    //   147: iload 4
    //   149: putfield 124	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   152: aload 7
    //   154: astore 6
    //   156: aload 9
    //   158: getfield 124	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   161: ifgt +13 -> 174
    //   164: aload 7
    //   166: astore 6
    //   168: aload 9
    //   170: iconst_1
    //   171: putfield 124	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   174: aload 7
    //   176: astore 6
    //   178: aload 9
    //   180: iconst_0
    //   181: putfield 75	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   184: aload 7
    //   186: astore 6
    //   188: new 77	java/io/BufferedInputStream
    //   191: dup
    //   192: new 79	java/io/FileInputStream
    //   195: dup
    //   196: aload_2
    //   197: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   200: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   203: astore_1
    //   204: aload_1
    //   205: aconst_null
    //   206: aload 9
    //   208: invokestatic 91	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   211: astore 6
    //   213: aload 6
    //   215: astore_2
    //   216: aload_1
    //   217: ifnull +10 -> 227
    //   220: aload_1
    //   221: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   224: aload 6
    //   226: astore_2
    //   227: aload_2
    //   228: astore 6
    //   230: aload_0
    //   231: getfield 42	zxt:j	Landroid/support/v4/util/MQLruCache;
    //   234: ifnull -206 -> 28
    //   237: aload_2
    //   238: astore 6
    //   240: aload_2
    //   241: ifnull -213 -> 28
    //   244: aload_0
    //   245: getfield 42	zxt:j	Landroid/support/v4/util/MQLruCache;
    //   248: aload_3
    //   249: aload_2
    //   250: invokevirtual 130	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: aload_2
    //   255: areturn
    //   256: aload 7
    //   258: astore 6
    //   260: aload 9
    //   262: iload 5
    //   264: putfield 124	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   267: goto -115 -> 152
    //   270: astore_1
    //   271: aload 7
    //   273: astore 6
    //   275: aload_1
    //   276: invokevirtual 133	java/io/FileNotFoundException:printStackTrace	()V
    //   279: aload 8
    //   281: astore_2
    //   282: aload 7
    //   284: ifnull -57 -> 227
    //   287: aload 7
    //   289: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   292: aload 8
    //   294: astore_2
    //   295: goto -68 -> 227
    //   298: astore_1
    //   299: aload 8
    //   301: astore_2
    //   302: goto -75 -> 227
    //   305: astore_1
    //   306: aconst_null
    //   307: astore 7
    //   309: aload 7
    //   311: astore 6
    //   313: aload_1
    //   314: invokevirtual 134	java/lang/OutOfMemoryError:printStackTrace	()V
    //   317: aload 8
    //   319: astore_2
    //   320: aload 7
    //   322: ifnull -95 -> 227
    //   325: aload 7
    //   327: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   330: aload 8
    //   332: astore_2
    //   333: goto -106 -> 227
    //   336: astore_1
    //   337: aload 8
    //   339: astore_2
    //   340: goto -113 -> 227
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 7
    //   347: aload 7
    //   349: astore 6
    //   351: aload_1
    //   352: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   355: aload 8
    //   357: astore_2
    //   358: aload 7
    //   360: ifnull -133 -> 227
    //   363: aload 7
    //   365: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   368: aload 8
    //   370: astore_2
    //   371: goto -144 -> 227
    //   374: astore_1
    //   375: aload 8
    //   377: astore_2
    //   378: goto -151 -> 227
    //   381: astore_1
    //   382: aconst_null
    //   383: astore 6
    //   385: aload 6
    //   387: ifnull +8 -> 395
    //   390: aload 6
    //   392: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   395: aload_1
    //   396: athrow
    //   397: astore_1
    //   398: aload 6
    //   400: astore_2
    //   401: goto -174 -> 227
    //   404: astore_2
    //   405: goto -10 -> 395
    //   408: astore_1
    //   409: goto -24 -> 385
    //   412: astore_2
    //   413: aload_1
    //   414: astore 6
    //   416: aload_2
    //   417: astore_1
    //   418: goto -33 -> 385
    //   421: astore_1
    //   422: goto -75 -> 347
    //   425: astore_2
    //   426: aload_1
    //   427: astore 7
    //   429: aload_2
    //   430: astore_1
    //   431: goto -84 -> 347
    //   434: astore_1
    //   435: goto -126 -> 309
    //   438: astore_2
    //   439: aload_1
    //   440: astore 7
    //   442: aload_2
    //   443: astore_1
    //   444: goto -135 -> 309
    //   447: astore_1
    //   448: aconst_null
    //   449: astore 7
    //   451: goto -180 -> 271
    //   454: astore_2
    //   455: aload_1
    //   456: astore 7
    //   458: aload_2
    //   459: astore_1
    //   460: goto -189 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	zxt
    //   0	463	1	paramContext	Context
    //   0	463	2	paramString1	String
    //   0	463	3	paramString2	String
    //   116	32	4	i	int
    //   132	131	5	k	int
    //   8	407	6	localObject1	Object
    //   4	453	7	localObject2	Object
    //   1	375	8	localObject3	Object
    //   38	223	9	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   67	76	270	java/io/FileNotFoundException
    //   85	90	270	java/io/FileNotFoundException
    //   94	102	270	java/io/FileNotFoundException
    //   106	118	270	java/io/FileNotFoundException
    //   122	134	270	java/io/FileNotFoundException
    //   145	152	270	java/io/FileNotFoundException
    //   156	164	270	java/io/FileNotFoundException
    //   168	174	270	java/io/FileNotFoundException
    //   178	184	270	java/io/FileNotFoundException
    //   188	204	270	java/io/FileNotFoundException
    //   260	267	270	java/io/FileNotFoundException
    //   287	292	298	java/io/IOException
    //   46	63	305	java/lang/OutOfMemoryError
    //   325	330	336	java/io/IOException
    //   46	63	343	java/io/IOException
    //   363	368	374	java/io/IOException
    //   46	63	381	finally
    //   220	224	397	java/io/IOException
    //   390	395	404	java/io/IOException
    //   67	76	408	finally
    //   85	90	408	finally
    //   94	102	408	finally
    //   106	118	408	finally
    //   122	134	408	finally
    //   145	152	408	finally
    //   156	164	408	finally
    //   168	174	408	finally
    //   178	184	408	finally
    //   188	204	408	finally
    //   260	267	408	finally
    //   275	279	408	finally
    //   313	317	408	finally
    //   351	355	408	finally
    //   204	213	412	finally
    //   67	76	421	java/io/IOException
    //   85	90	421	java/io/IOException
    //   94	102	421	java/io/IOException
    //   106	118	421	java/io/IOException
    //   122	134	421	java/io/IOException
    //   145	152	421	java/io/IOException
    //   156	164	421	java/io/IOException
    //   168	174	421	java/io/IOException
    //   178	184	421	java/io/IOException
    //   188	204	421	java/io/IOException
    //   260	267	421	java/io/IOException
    //   204	213	425	java/io/IOException
    //   67	76	434	java/lang/OutOfMemoryError
    //   85	90	434	java/lang/OutOfMemoryError
    //   94	102	434	java/lang/OutOfMemoryError
    //   106	118	434	java/lang/OutOfMemoryError
    //   122	134	434	java/lang/OutOfMemoryError
    //   145	152	434	java/lang/OutOfMemoryError
    //   156	164	434	java/lang/OutOfMemoryError
    //   168	174	434	java/lang/OutOfMemoryError
    //   178	184	434	java/lang/OutOfMemoryError
    //   188	204	434	java/lang/OutOfMemoryError
    //   260	267	434	java/lang/OutOfMemoryError
    //   204	213	438	java/lang/OutOfMemoryError
    //   46	63	447	java/io/FileNotFoundException
    //   204	213	454	java/io/FileNotFoundException
  }
  
  private String a(AppInterface paramAppInterface)
  {
    return aagi.bcQ + paramAppInterface.getCurrentAccountUin() + "/preload/";
  }
  
  public static zxt a()
  {
    if (a == null) {}
    synchronized (mLock)
    {
      if (a == null) {
        a = new zxt();
      }
      return a;
    }
  }
  
  private void a(AppInterface paramAppInterface, String paramString1, String paramString2, List<zxt.a> paramList)
  {
    int k = 0;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgManager", 2, "imageZipDownBack callback error");
      }
      return;
    }
    int i;
    if ((!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists()))
    {
      i = 1;
      if (k >= paramList.size()) {
        break label125;
      }
      paramAppInterface = (zxt.a)paramList.get(k);
      if (paramAppInterface != null) {
        break label101;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      i = 0;
      break;
      label101:
      if (i != 0) {
        paramAppInterface.aM(paramString2);
      } else {
        paramAppInterface.onLoadFail();
      }
    }
    label125:
    this.it.remove(paramString1);
  }
  
  private void a(AppInterface paramAppInterface, String paramString, List<zxt.a> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgManager", 2, "imageDownBack callback error");
      }
      return;
    }
    paramAppInterface = QWalletPicHelper.getDrawableForWallet(PreloadManager.id(paramString), BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130844338));
    int i = 0;
    if (i < paramList.size())
    {
      zxt.a locala = (zxt.a)paramList.get(i);
      if (locala == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (paramAppInterface != null) {
          locala.aM(paramAppInterface);
        } else {
          locala.onLoadFail();
        }
      }
    }
    this.it.remove(paramString);
  }
  
  private String b(AppInterface paramAppInterface)
  {
    return aagi.bcS + paramAppInterface.getCurrentAccountUin() + "/preload/";
  }
  
  public Bitmap a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str1 = paramString;
    if (!paramString.endsWith(".png")) {
      str1 = paramString + ".png";
    }
    if (this.j != null) {}
    for (paramString = (Bitmap)this.j.get(str1);; paramString = null)
    {
      if (paramString == null)
      {
        String str2 = MD5.toMD5(str1);
        File localFile2 = new File(a(paramAppInterface), str2);
        File localFile1 = localFile2;
        if (!localFile2.exists()) {
          localFile1 = new File(b(paramAppInterface), str2);
        }
        if (localFile1.exists())
        {
          paramAppInterface.getApplication();
          return a(MobileQQ.getContext(), localFile1.getPath(), str1);
        }
      }
      return paramString;
    }
  }
  
  public Drawable a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramAppInterface = paramString;
      if (!paramString.endsWith(".png")) {
        paramAppInterface = paramString + ".png";
      }
    } while (this.j == null);
    return (Drawable)this.j.get(paramAppInterface);
  }
  
  public String a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramAppInterface = null;
    }
    do
    {
      return paramAppInterface;
      paramAppInterface = paramString;
      if (!paramString.endsWith(".zip")) {
        paramAppInterface = paramString + ".zip";
      }
      paramString = PreloadManager.ia(paramAppInterface);
      paramAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PreloadImgManager", 2, "getZipBitmap zipName = " + paramString);
    return paramString;
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, zxt.a parama)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = ".png";
    }
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgManager", 2, "download AppInterface is null or url is emprty ");
      }
    }
    do
    {
      return;
      paramString2 = paramString1;
      if (!paramString1.endsWith(str)) {
        paramString2 = paramString1 + str;
      }
      if (!this.it.containsKey(paramString2)) {
        break;
      }
      ((List)this.it.get(paramString2)).add(parama);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadImgManager", 2, "url is already in download set return! ");
    return;
    this.it.put(paramString2, new ArrayList(6));
    ((List)this.it.get(paramString2)).add(parama);
    ((PreloadManager)paramAppInterface.getManager(151)).c(paramString2, new zxv(this, paramAppInterface));
  }
  
  public void a(AppInterface paramAppInterface, String paramString, zxt.a parama)
  {
    a(paramAppInterface, paramString, ".png", parama);
  }
  
  public void a(AppInterface paramAppInterface, Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    HashSet localHashSet;
    do
    {
      return;
      localHashSet = new HashSet(paramSet.size());
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if ((!TextUtils.isEmpty(str)) && (!str.endsWith(".png")) && (!str.endsWith(".zip"))) {
          localHashSet.add(str + ".png");
        }
      }
    } while (localHashSet.size() <= 0);
    b(paramAppInterface, localHashSet);
  }
  
  public void b(AppInterface paramAppInterface, Set<String> paramSet)
  {
    HashMap localHashMap;
    ArrayList localArrayList;
    String str2;
    String str3;
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      if (this.jdField_b_of_type_Aqva == null)
      {
        this.jdField_b_of_type_Aqva = new aqva(paramAppInterface);
        this.jdField_b_of_type_Aqvc = this.jdField_b_of_type_Aqva.a(1);
      }
      localHashMap = new HashMap();
      localArrayList = new ArrayList();
      str2 = a(paramAppInterface);
      str3 = b(paramAppInterface);
      if (!TextUtils.isEmpty(str2)) {
        break label138;
      }
    }
    label138:
    for (String str1 = str3;; str1 = str2)
    {
      Bundle localBundle = new Bundle();
      ThreadManager.post(new PreloadImgManager.3(this, paramSet, str2, str3, paramAppInterface, localArrayList, str1, localHashMap, localBundle), 8, new zxw(this, localArrayList, localHashMap, localBundle), true);
      return;
    }
  }
  
  public void cancelAllDownload()
  {
    if (this.jdField_b_of_type_Aqvc != null) {
      this.jdField_b_of_type_Aqvc.a(true, null);
    }
  }
  
  public void onDestory()
  {
    synchronized (mLock)
    {
      cancelAllDownload();
      this.jdField_b_of_type_Aqva = null;
      if (this.it != null) {
        this.it.clear();
      }
      a = null;
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aM(Object paramObject);
    
    public abstract void onLoadFail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxt
 * JD-Core Version:    0.7.0.1
 */