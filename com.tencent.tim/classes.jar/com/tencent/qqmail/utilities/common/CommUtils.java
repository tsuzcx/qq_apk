package com.tencent.qqmail.utilities.common;

import alkw;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ClipData;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.MediaBucketGridActivity;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommUtils
{
  public static String COMPOSE_CACHE;
  public static String COMPOSE_MIME;
  public static String COMPOSE_OTHER_FILE = "others";
  public static String COMPOSE_THUMBNAIL;
  public static String COMPOSE_VIDEO;
  public static final Pattern EMAIL_ADDRESS_PATTERN;
  public static final int MAX_BITMAP_SAMPLE = 32;
  public static final int MIN_BITMAP_SAMPLE = 1;
  private static final String REGEX_ALL_DIGITAL = "[0-9]*";
  public static final String TAG = CommUtils.class.getSimpleName();
  
  static
  {
    EMAIL_ADDRESS_PATTERN = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    COMPOSE_CACHE = "CachePhoto";
    COMPOSE_MIME = "mime";
    COMPOSE_VIDEO = "videos";
    COMPOSE_THUMBNAIL = "thumbnail";
  }
  
  @TargetApi(11)
  public static void addPrimaryClipChangedListener(ClipboardManager.OnPrimaryClipChangedListener paramOnPrimaryClipChangedListener)
  {
    ((android.content.ClipboardManager)QMApplicationContext.sharedInstance().getSystemService("clipboard")).addPrimaryClipChangedListener(paramOnPrimaryClipChangedListener);
  }
  
  public static boolean checkMailAddress(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.equals(""))) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = paramString.split("@").length - 1;
    } while (i == 0);
    if (i > 1) {
      return false;
    }
    return EMAIL_ADDRESS_PATTERN.matcher(paramString).matches();
  }
  
  public static void clearAndReplaceMeidaText()
  {
    try
    {
      android.text.ClipboardManager localClipboardManager = (android.text.ClipboardManager)QMApplicationContext.sharedInstance().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        String str = "";
        if (localClipboardManager.getText() != null) {
          str = localClipboardManager.getText().toString();
        }
        localClipboardManager.setText(str.replaceAll("([image|audio]):.*?;", "$1"));
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "algerclipboard", "msg" + Log.getStackTraceString(localException));
    }
  }
  
  public static String contentUri2Path(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if (paramUri == null) {}
    do
    {
      return null;
      if ((Build.VERSION.SDK_INT < 19) || (!DocumentsContract.isDocumentUri(paramContext, paramUri))) {
        break label252;
      }
      if (!"com.android.externalstorage.documents".equals(paramUri.getAuthority())) {
        break;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
    } while (!"primary".equalsIgnoreCase(paramContext[0]));
    return Environment.getExternalStorageDirectory() + "/" + paramContext[1];
    if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
    {
      paramUri = DocumentsContract.getDocumentId(paramUri);
      return getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
    }
    if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
    {
      String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
      String str = arrayOfString[0];
      if ("image".equals(str)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return getDataColumn(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
        if ("video".equals(str))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = localObject;
          if ("audio".equals(str)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
    }
    QMLog.log(6, TAG, "contentUri2Path unknow Authority: " + paramUri.getAuthority());
    return null;
    label252:
    if ("content".equalsIgnoreCase(paramUri.getScheme())) {
      return getDataColumn(paramContext, paramUri, null, null);
    }
    if ("file".equalsIgnoreCase(paramUri.getScheme())) {
      return paramUri.getPath();
    }
    QMLog.log(6, TAG, "contentUri2Path unknow scheme: " + paramUri.getScheme());
    return null;
  }
  
  private static void copyContent(String paramString)
  {
    android.text.ClipboardManager localClipboardManager = (android.text.ClipboardManager)QMApplicationContext.sharedInstance().getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setText(paramString);
    }
  }
  
  public static void copyText(String paramString)
  {
    if (Build.VERSION.SDK_INT > 11)
    {
      setPrimaryClip(paramString);
      return;
    }
    copyContent(paramString);
  }
  
  /* Error */
  private static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: iconst_2
    //   6: anewarray 96	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 288
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: ldc_w 290
    //   20: aastore
    //   21: aload_2
    //   22: aload_3
    //   23: aconst_null
    //   24: invokestatic 296	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +292 -> 321
    //   32: aload_2
    //   33: astore_3
    //   34: aload_2
    //   35: ldc_w 290
    //   38: invokeinterface 302 2 0
    //   43: istore 4
    //   45: aload_2
    //   46: astore_3
    //   47: aload_2
    //   48: ldc_w 288
    //   51: invokeinterface 302 2 0
    //   56: istore 5
    //   58: aload_2
    //   59: astore_3
    //   60: aload_2
    //   61: invokeinterface 305 1 0
    //   66: pop
    //   67: iload 5
    //   69: iconst_m1
    //   70: if_icmpeq +70 -> 140
    //   73: aload_2
    //   74: astore_3
    //   75: aload_2
    //   76: iload 5
    //   78: invokeinterface 309 2 0
    //   83: astore_0
    //   84: aload_2
    //   85: astore_3
    //   86: iconst_4
    //   87: getstatic 34	com/tencent/qqmail/utilities/common/CommUtils:TAG	Ljava/lang/String;
    //   90: new 146	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 311
    //   100: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 166	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: ifnull +22 -> 138
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: invokeinterface 314 1 0
    //   127: ifne +11 -> 138
    //   130: aload_2
    //   131: invokeinterface 317 1 0
    //   136: aload_0
    //   137: astore_1
    //   138: aload_1
    //   139: areturn
    //   140: aload_2
    //   141: astore_3
    //   142: aload_2
    //   143: iload 4
    //   145: invokeinterface 309 2 0
    //   150: astore 6
    //   152: aload_2
    //   153: astore_3
    //   154: invokestatic 322	com/tencent/qqmail/utilities/fileextention/FileUtil:getExternalQQMailCacheDirPath	()Ljava/lang/String;
    //   157: aload 6
    //   159: invokestatic 325	com/tencent/qqmail/utilities/fileextention/FileUtil:rename	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 6
    //   164: aload_2
    //   165: astore_3
    //   166: new 146	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   173: invokestatic 322	com/tencent/qqmail/utilities/fileextention/FileUtil:getExternalQQMailCacheDirPath	()Ljava/lang/String;
    //   176: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 6
    //   181: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 6
    //   189: aload_2
    //   190: astore_3
    //   191: aload_0
    //   192: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   195: aload_1
    //   196: ldc_w 327
    //   199: invokevirtual 333	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   202: aload 6
    //   204: invokestatic 337	com/tencent/qqmail/utilities/fileextention/FileUtil:copyFile	(Landroid/os/ParcelFileDescriptor;Ljava/lang/String;)V
    //   207: aload 6
    //   209: astore_0
    //   210: goto -126 -> 84
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_2
    //   219: astore_3
    //   220: bipush 6
    //   222: getstatic 34	com/tencent/qqmail/utilities/common/CommUtils:TAG	Ljava/lang/String;
    //   225: new 146	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 339
    //   235: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokestatic 159	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   242: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 166	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: astore_1
    //   253: aload_2
    //   254: ifnull -116 -> 138
    //   257: aload_0
    //   258: astore_1
    //   259: aload_2
    //   260: invokeinterface 314 1 0
    //   265: ifne -127 -> 138
    //   268: aload_2
    //   269: invokeinterface 317 1 0
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_3
    //   280: ifnull +18 -> 298
    //   283: aload_3
    //   284: invokeinterface 314 1 0
    //   289: ifne +9 -> 298
    //   292: aload_3
    //   293: invokeinterface 317 1 0
    //   298: aload_0
    //   299: athrow
    //   300: astore_0
    //   301: goto -22 -> 279
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_0
    //   307: goto -89 -> 218
    //   310: astore_1
    //   311: aload 6
    //   313: astore_0
    //   314: goto -96 -> 218
    //   317: astore_1
    //   318: goto -100 -> 218
    //   321: aconst_null
    //   322: astore_0
    //   323: goto -239 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   0	326	1	paramUri	Uri
    //   0	326	2	paramString	String
    //   0	326	3	paramArrayOfString	String[]
    //   43	101	4	i	int
    //   56	21	5	j	int
    //   150	162	6	str	String
    // Exception table:
    //   from	to	target	type
    //   0	28	213	java/lang/Exception
    //   0	28	276	finally
    //   34	45	300	finally
    //   47	58	300	finally
    //   60	67	300	finally
    //   75	84	300	finally
    //   86	113	300	finally
    //   142	152	300	finally
    //   154	164	300	finally
    //   166	189	300	finally
    //   191	207	300	finally
    //   220	251	300	finally
    //   34	45	304	java/lang/Exception
    //   47	58	304	java/lang/Exception
    //   60	67	304	java/lang/Exception
    //   75	84	304	java/lang/Exception
    //   142	152	304	java/lang/Exception
    //   154	164	304	java/lang/Exception
    //   166	189	304	java/lang/Exception
    //   191	207	310	java/lang/Exception
    //   86	113	317	java/lang/Exception
  }
  
  public static int getFixAngel(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 8: 
      return 270;
    case 3: 
      return 180;
    }
    return 90;
  }
  
  public static String getTopActivityName(Context paramContext)
  {
    return ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
  }
  
  public static boolean isNullorBlankorNotEquals(String paramString1, String paramString2)
  {
    return (paramString1 == null) || (paramString1.equals("")) || (!paramString1.equals(paramString2));
  }
  
  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("^(-?\\d+)(\\.\\d+)?$").matcher(paramString).matches();
  }
  
  public static boolean isOnAlbum(Context paramContext)
  {
    paramContext = getTopActivityName(paramContext);
    return (paramContext.equals(MediaFolderSelectActivity.class.getName())) || (paramContext.equals(MediaBucketGridActivity.class.getName())) || (paramContext.equals(MeidaBigBucketSelectActivity.class.getName()));
  }
  
  public static boolean isOnCompose(Context paramContext)
  {
    return getTopActivityName(paramContext).equals(ComposeMailActivity.class.getName());
  }
  
  public static boolean isOnScanFile(Context paramContext)
  {
    return false;
  }
  
  public static boolean isPureNumber(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  @TargetApi(11)
  public static void removePrimaryClipChangedListener(ClipboardManager.OnPrimaryClipChangedListener paramOnPrimaryClipChangedListener)
  {
    ((android.content.ClipboardManager)QMApplicationContext.sharedInstance().getSystemService("clipboard")).removePrimaryClipChangedListener(paramOnPrimaryClipChangedListener);
  }
  
  @TargetApi(11)
  private static void setPrimaryClip(String paramString)
  {
    android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)QMApplicationContext.sharedInstance().getSystemService("clipboard");
    paramString = ClipData.newPlainText("", paramString);
    alkw.a(localClipboardManager, paramString);
    localClipboardManager.setPrimaryClip(paramString);
  }
  
  public static abstract interface Callback
  {
    public abstract void call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.common.CommUtils
 * JD-Core Version:    0.7.0.1
 */