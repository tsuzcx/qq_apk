package com.tencent.qqmail.attachment.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMOpenFileActivity;
import com.tencent.qqmail.utilities.ui.QMOpenFileDialogHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public abstract class QMSpreadAPPInfo
{
  public static final int APP_DOWNLOAD = 1;
  public static final int APP_DOWNLOADING = 2;
  public static final int APP_INSTALL = 3;
  public static final int DOWNLOAD_BY_GOOGLE_PLAY = 1;
  public static final int DOWNLOAD_BY_SYSTEM = 2;
  private static final String TAG = "SpreadAppInfo";
  public static List<Long> downloadIdList = new ArrayList();
  public static final String from = "com.tencent.androidqqmail";
  private static SharedPreferences spreadPreferences;
  private String action;
  private Context context;
  private String packageName;
  private final String[][] supportTypes;
  
  public QMSpreadAPPInfo(Context paramContext, String paramString1, String paramString2, String[][] paramArrayOfString)
  {
    this.context = paramContext;
    this.packageName = paramString1;
    this.action = paramString2;
    this.supportTypes = paramArrayOfString;
    spreadPreferences = paramContext.getSharedPreferences("spread", 0);
  }
  
  private static boolean appContainsX5CoreIsInstalled()
  {
    return (SharedPreferenceUtil.getX5CoreInitFinished()) && ((DeviceUtil.isWeChatInstalled()) || (DeviceUtil.isQQInstalled()));
  }
  
  public static boolean canDisplayBySpreadAPPs(Context paramContext, String paramString)
  {
    paramContext = new QMqqBrowserInfo(paramContext, QMqqBrowserInfo.qqBrowserSupportTypes);
    String str = paramContext.checkSupportType("." + paramString.toLowerCase(Locale.getDefault()));
    QMLog.log(4, "SpreadAppInfo", "suffix:" + paramString + " type:" + str);
    if (!StringUtils.isBlank(str)) {}
    for (boolean bool = true; paramContext.isShowDownload(bool); bool = false) {
      return true;
    }
    return false;
  }
  
  public static boolean canOpenByQQBrowser(Context paramContext, String paramString)
  {
    return (!StringUtils.isBlank(new QMqqBrowserInfo(paramContext, QMqqBrowserInfo.qqBrowserSupportTypes).checkSupportType("." + paramString.toLowerCase(Locale.getDefault())))) && (DeviceUtil.isQQBrowserInstalled());
  }
  
  public static boolean canOpenByX5Core(Context paramContext, String paramString)
  {
    paramContext = new QMqqBrowserInfo(paramContext, QMqqBrowserInfo.x5SupportTypes).checkSupportType("." + paramString.toLowerCase(Locale.getDefault()));
    return (appContainsX5CoreIsInstalled()) && (!StringUtils.isBlank(paramContext));
  }
  
  public static SharedPreferences getSpreadPreferences()
  {
    return spreadPreferences;
  }
  
  public static void registerDownLoadReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    DownloadReceiver localDownloadReceiver = new DownloadReceiver();
    QMApplicationContext.sharedInstance().registerReceiver(localDownloadReceiver, localIntentFilter);
  }
  
  public static void resetSpreadCount()
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("spread", 0).edit();
    QMLog.log(4, "SpreadAppInfo", "upgrade for clear spread count");
    localEditor.putInt("com.tencent.mtt_spreadCount", 1);
    localEditor.putInt("com.tencent.mtt_webivew_spreadCount", 1);
    localEditor.commit();
  }
  
  public boolean checkHasDownload(String paramString)
  {
    String str = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS;
    if (FileUtil.hasSdcard())
    {
      FileUtil.tryMkdirs(new File(str));
      paramString = new File(str + File.separator + paramString);
      if (paramString.exists())
      {
        paramString = StringExtention.fileMD5(paramString);
        str = getSpreadPreferences().getString("com.tencent.mtt_md5", "");
        QMLog.log(4, "SpreadAppInfo", "exist QQBrowser APK's md5:" + paramString);
        if (paramString.equals(str)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String checkSupportType(String paramString)
  {
    paramString = paramString.toLowerCase(Locale.getDefault());
    if (paramString.equals("")) {
      return "";
    }
    int i = 0;
    if (i < this.supportTypes.length) {
      if (!paramString.equals(this.supportTypes[i][0])) {}
    }
    for (paramString = this.supportTypes[i][1];; paramString = "")
    {
      return paramString;
      i += 1;
      break;
    }
  }
  
  public int downloadOrInstall(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (ChannelDefine.isGooglePlay())
    {
      IntentUtil.intentToMarket(paramContext, getPackageName());
      return 1;
    }
    if (paramInt == 1)
    {
      long l = QMAttachUtils.goToDownload(paramContext, getUrl(paramString2), 2, paramString1, null);
      if (l != -1L) {
        downloadIdList.add(Long.valueOf(l));
      }
      return 2;
    }
    if (paramInt == 3)
    {
      paramString2 = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS;
      if (FileUtil.hasSdcard())
      {
        FileUtil.tryMkdirs(new File(paramString2));
        paramString1 = new File(paramString2 + File.separator + paramString1);
        if (paramString1.exists())
        {
          paramString2 = new Intent();
          paramString2.addFlags(268435456);
          paramString2.setAction("android.intent.action.VIEW");
          paramString2.setDataAndType(Uri.fromFile(paramString1), "application/vnd.android.package-archive");
          paramContext.startActivity(paramString2);
          return 3;
        }
      }
    }
    return -1;
  }
  
  /* Error */
  public int getAPPAction(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 43	com/tencent/qqmail/attachment/model/QMSpreadAPPInfo:downloadIdList	Ljava/util/List;
    //   3: ifnull +298 -> 301
    //   6: getstatic 43	com/tencent/qqmail/attachment/model/QMSpreadAPPInfo:downloadIdList	Ljava/util/List;
    //   9: invokeinterface 321 1 0
    //   14: ifle +287 -> 301
    //   17: getstatic 43	com/tencent/qqmail/attachment/model/QMSpreadAPPInfo:downloadIdList	Ljava/util/List;
    //   20: invokeinterface 325 1 0
    //   25: astore 11
    //   27: aload 11
    //   29: invokeinterface 330 1 0
    //   34: ifeq +267 -> 301
    //   37: aload 11
    //   39: invokeinterface 334 1 0
    //   44: checkcast 274	java/lang/Long
    //   47: invokevirtual 338	java/lang/Long:longValue	()J
    //   50: lstore 7
    //   52: aload_1
    //   53: ldc_w 340
    //   56: invokevirtual 344	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   59: checkcast 346	android/app/DownloadManager
    //   62: astore 10
    //   64: new 348	android/app/DownloadManager$Query
    //   67: dup
    //   68: invokespecial 349	android/app/DownloadManager$Query:<init>	()V
    //   71: astore 12
    //   73: aload 12
    //   75: iconst_1
    //   76: newarray long
    //   78: dup
    //   79: iconst_0
    //   80: lload 7
    //   82: lastore
    //   83: invokevirtual 353	android/app/DownloadManager$Query:setFilterById	([J)Landroid/app/DownloadManager$Query;
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: aload 10
    //   92: aload 12
    //   94: invokevirtual 357	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   97: astore 10
    //   99: aload 10
    //   101: astore 9
    //   103: aload 9
    //   105: ifnull +146 -> 251
    //   108: aload 9
    //   110: invokeinterface 362 1 0
    //   115: ifeq +136 -> 251
    //   118: aload 9
    //   120: aload 9
    //   122: ldc_w 364
    //   125: invokeinterface 368 2 0
    //   130: invokeinterface 372 2 0
    //   135: istore 4
    //   137: aload 9
    //   139: aload 9
    //   141: ldc_w 374
    //   144: invokeinterface 368 2 0
    //   149: invokeinterface 377 2 0
    //   154: astore 10
    //   156: aload_2
    //   157: ldc_w 379
    //   160: invokevirtual 382	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   163: istore 5
    //   165: iload 5
    //   167: iconst_m1
    //   168: if_icmpeq +83 -> 251
    //   171: aload_2
    //   172: iconst_0
    //   173: iload 5
    //   175: invokevirtual 386	java/lang/String:substring	(II)Ljava/lang/String;
    //   178: astore 12
    //   180: new 91	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   187: aload 12
    //   189: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 388
    //   195: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 394	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   204: aload 10
    //   206: invokevirtual 398	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   209: invokevirtual 403	java/util/regex/Matcher:find	()Z
    //   212: istore 6
    //   214: iload 6
    //   216: ifeq +35 -> 251
    //   219: iload 4
    //   221: iconst_2
    //   222: if_icmpeq +15 -> 237
    //   225: iload 4
    //   227: iconst_4
    //   228: if_icmpeq +9 -> 237
    //   231: iload 4
    //   233: iconst_1
    //   234: if_icmpne +17 -> 251
    //   237: aload 9
    //   239: ifnull +10 -> 249
    //   242: aload 9
    //   244: invokeinterface 406 1 0
    //   249: iconst_2
    //   250: ireturn
    //   251: aload 9
    //   253: ifnull -226 -> 27
    //   256: aload 9
    //   258: invokeinterface 406 1 0
    //   263: goto -236 -> 27
    //   266: astore 9
    //   268: aconst_null
    //   269: astore 9
    //   271: aload 9
    //   273: ifnull -246 -> 27
    //   276: aload 9
    //   278: invokeinterface 406 1 0
    //   283: goto -256 -> 27
    //   286: astore_1
    //   287: aload 9
    //   289: ifnull +10 -> 299
    //   292: aload 9
    //   294: invokeinterface 406 1 0
    //   299: aload_1
    //   300: athrow
    //   301: iload_3
    //   302: ifeq +5 -> 307
    //   305: iconst_3
    //   306: ireturn
    //   307: iconst_1
    //   308: ireturn
    //   309: astore_1
    //   310: goto -23 -> 287
    //   313: astore 10
    //   315: goto -44 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	QMSpreadAPPInfo
    //   0	318	1	paramContext	Context
    //   0	318	2	paramString	String
    //   0	318	3	paramBoolean	boolean
    //   135	100	4	i	int
    //   163	11	5	j	int
    //   212	3	6	bool	boolean
    //   50	31	7	l	long
    //   88	169	9	localObject1	Object
    //   266	1	9	localException1	Exception
    //   269	24	9	localObject2	Object
    //   62	143	10	localObject3	Object
    //   313	1	10	localException2	Exception
    //   25	13	11	localIterator	Iterator
    //   71	117	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   90	99	266	java/lang/Exception
    //   90	99	286	finally
    //   108	165	309	finally
    //   171	214	309	finally
    //   108	165	313	java/lang/Exception
    //   171	214	313	java/lang/Exception
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getUrl(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http")) {
      if (!paramString.contains("http"))
      {
        str = paramString;
        if (!paramString.contains("https")) {}
      }
      else
      {
        int i = paramString.indexOf("http");
        str = "" + paramString.substring(i);
      }
    }
    return str;
  }
  
  public abstract boolean isSupportToOpen(File paramFile, String paramString);
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public static class DownloadReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      for (;;)
      {
        long l2;
        int i;
        try
        {
          if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
          {
            long l1 = paramIntent.getLongExtra("extra_download_id", -1L);
            if ((QMSpreadAPPInfo.downloadIdList != null) && (QMSpreadAPPInfo.downloadIdList.size() > 0))
            {
              paramIntent = QMSpreadAPPInfo.downloadIdList.iterator();
              if (paramIntent.hasNext())
              {
                l2 = ((Long)paramIntent.next()).longValue();
                if (l1 != l2) {
                  continue;
                }
                QMLog.log(4, "SpreadAppInfo", "download complete");
                Cursor localCursor = ((DownloadManager)paramContext.getSystemService("download")).query(new DownloadManager.Query().setFilterById(new long[] { l2 }));
                if (localCursor == null) {
                  continue;
                }
                if (localCursor.moveToFirst())
                {
                  Object localObject1 = localCursor.getString(localCursor.getColumnIndex("local_uri"));
                  i = localCursor.getInt(localCursor.getColumnIndex("status"));
                  if ((localObject1 == null) || (i != 8)) {
                    break label357;
                  }
                  QMSpreadAPPInfo.downloadIdList.remove(Long.valueOf(l2));
                  if (QMOpenFileActivity.openFileDialog != null) {
                    QMOpenFileActivity.openFileDialog.dismiss();
                  }
                  localObject1 = Uri.parse((String)localObject1);
                  Object localObject2 = new File(((Uri)localObject1).getPath());
                  if (((File)localObject2).exists())
                  {
                    localObject2 = StringExtention.fileMD5((File)localObject2);
                    SharedPreferences.Editor localEditor = QMSpreadAPPInfo.getSpreadPreferences().edit();
                    localEditor.putString("com.tencent.mtt_md5", (String)localObject2);
                    localEditor.commit();
                    QMLog.log(4, "SpreadAppInfo", "md5 of QQBrowser APK from download:" + (String)localObject2);
                  }
                  localObject2 = new Intent("android.intent.action.VIEW");
                  ((Intent)localObject2).setDataAndType((Uri)localObject1, "application/vnd.android.package-archive");
                  ((Intent)localObject2).addFlags(268435456);
                  paramContext.startActivity((Intent)localObject2);
                }
                localCursor.close();
                continue;
              }
            }
          }
          return;
        }
        catch (Exception paramContext)
        {
          QMLog.log(6, "SpreadAppInfo", Log.getStackTraceString(paramContext));
        }
        label357:
        if (i == 16) {
          QMSpreadAPPInfo.downloadIdList.remove(Long.valueOf(l2));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.QMSpreadAPPInfo
 * JD-Core Version:    0.7.0.1
 */