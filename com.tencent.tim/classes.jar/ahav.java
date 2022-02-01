import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.mpfile.MpfileTaskInfo;
import com.qq.taf.jce.HexUtil;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.1;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.10;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.12;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.15;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.16;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.17;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.20;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.3;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.8;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;

public class ahav
{
  private static final String UU;
  private static Drawable eR;
  private static final char[] i = { '…' };
  private static HashMap<String, String> kP;
  private static HashMap<String, Integer> kQ;
  private static HashMap<Integer, String> kR = new HashMap();
  private static ArrayList<Long> wM;
  private static ArrayList<Long> wN;
  
  static
  {
    UU = new String(i);
    wN = new ArrayList();
  }
  
  /* Error */
  public static byte[] A(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 73	ahav:getFileSizes	(Ljava/lang/String;)J
    //   4: lstore 7
    //   6: lload 7
    //   8: ldc2_w 74
    //   11: lcmp
    //   12: ifge +9 -> 21
    //   15: aconst_null
    //   16: astore 20
    //   18: aload 20
    //   20: areturn
    //   21: ldc2_w 76
    //   24: lconst_1
    //   25: lsub
    //   26: lstore 17
    //   28: lload 7
    //   30: ldc2_w 78
    //   33: ldiv
    //   34: ldc2_w 76
    //   37: ldc2_w 78
    //   40: ldiv
    //   41: lsub
    //   42: lstore 13
    //   44: lload 7
    //   46: ldc2_w 78
    //   49: ldiv
    //   50: ldc2_w 76
    //   53: ldc2_w 78
    //   56: ldiv
    //   57: ladd
    //   58: lconst_1
    //   59: lsub
    //   60: lstore 15
    //   62: lload 7
    //   64: ldc2_w 76
    //   67: lsub
    //   68: lstore 9
    //   70: lload 7
    //   72: lconst_1
    //   73: lsub
    //   74: lstore 11
    //   76: ldc 81
    //   78: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   81: astore 20
    //   83: new 89	java/io/BufferedInputStream
    //   86: dup
    //   87: new 91	java/io/FileInputStream
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   95: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore 19
    //   100: lconst_0
    //   101: lstore_3
    //   102: iconst_0
    //   103: istore_1
    //   104: aload 19
    //   106: astore_0
    //   107: lload 17
    //   109: lload_3
    //   110: lsub
    //   111: lconst_1
    //   112: ladd
    //   113: ldc2_w 98
    //   116: invokestatic 105	java/lang/Math:min	(JJ)J
    //   119: l2i
    //   120: newarray byte
    //   122: astore 21
    //   124: aload 19
    //   126: astore_0
    //   127: aload 19
    //   129: aload 21
    //   131: invokevirtual 111	java/io/InputStream:read	([B)I
    //   134: istore_2
    //   135: aload 19
    //   137: astore_0
    //   138: aload 20
    //   140: aload 21
    //   142: iconst_0
    //   143: iload_2
    //   144: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   147: lload_3
    //   148: iload_2
    //   149: i2l
    //   150: ladd
    //   151: lstore 5
    //   153: iload_1
    //   154: iload_2
    //   155: iadd
    //   156: istore_2
    //   157: iload_2
    //   158: istore_1
    //   159: lload 5
    //   161: lstore_3
    //   162: lload 5
    //   164: lload 17
    //   166: lconst_0
    //   167: lsub
    //   168: lconst_1
    //   169: ladd
    //   170: lcmp
    //   171: iflt -67 -> 104
    //   174: aload 19
    //   176: astore_0
    //   177: aload 19
    //   179: lload 13
    //   181: lload 17
    //   183: lsub
    //   184: lconst_1
    //   185: lsub
    //   186: invokevirtual 119	java/io/InputStream:skip	(J)J
    //   189: pop2
    //   190: lconst_0
    //   191: lstore_3
    //   192: iload_2
    //   193: istore_1
    //   194: aload 19
    //   196: astore_0
    //   197: lload 15
    //   199: lload 13
    //   201: lsub
    //   202: lload_3
    //   203: lsub
    //   204: lconst_1
    //   205: ladd
    //   206: ldc2_w 98
    //   209: invokestatic 105	java/lang/Math:min	(JJ)J
    //   212: l2i
    //   213: newarray byte
    //   215: astore 21
    //   217: aload 19
    //   219: astore_0
    //   220: aload 19
    //   222: aload 21
    //   224: invokevirtual 111	java/io/InputStream:read	([B)I
    //   227: istore_2
    //   228: aload 19
    //   230: astore_0
    //   231: aload 20
    //   233: aload 21
    //   235: iconst_0
    //   236: iload_2
    //   237: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   240: lload_3
    //   241: iload_2
    //   242: i2l
    //   243: ladd
    //   244: lstore 5
    //   246: iload_1
    //   247: iload_2
    //   248: iadd
    //   249: istore_2
    //   250: iload_2
    //   251: istore_1
    //   252: lload 5
    //   254: lstore_3
    //   255: lload 5
    //   257: lload 15
    //   259: lload 13
    //   261: lsub
    //   262: lconst_1
    //   263: ladd
    //   264: lcmp
    //   265: iflt -71 -> 194
    //   268: aload 19
    //   270: astore_0
    //   271: aload 19
    //   273: lload 9
    //   275: lload 15
    //   277: lsub
    //   278: lconst_1
    //   279: lsub
    //   280: invokevirtual 119	java/io/InputStream:skip	(J)J
    //   283: pop2
    //   284: lconst_0
    //   285: lstore_3
    //   286: iload_2
    //   287: istore_1
    //   288: aload 19
    //   290: astore_0
    //   291: lload 11
    //   293: lload 9
    //   295: lsub
    //   296: lload_3
    //   297: lsub
    //   298: lconst_1
    //   299: ladd
    //   300: ldc2_w 98
    //   303: invokestatic 105	java/lang/Math:min	(JJ)J
    //   306: l2i
    //   307: newarray byte
    //   309: astore 21
    //   311: aload 19
    //   313: astore_0
    //   314: aload 19
    //   316: aload 21
    //   318: invokevirtual 111	java/io/InputStream:read	([B)I
    //   321: istore_2
    //   322: iload_2
    //   323: ifgt +17 -> 340
    //   326: aload 19
    //   328: astore_0
    //   329: bipush 8
    //   331: newarray byte
    //   333: astore 21
    //   335: iconst_0
    //   336: istore_2
    //   337: goto +192 -> 529
    //   340: aload 19
    //   342: astore_0
    //   343: aload 20
    //   345: aload 21
    //   347: iconst_0
    //   348: iload_2
    //   349: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   352: lload_3
    //   353: iload_2
    //   354: i2l
    //   355: ladd
    //   356: lstore 5
    //   358: iload_1
    //   359: iload_2
    //   360: iadd
    //   361: istore_2
    //   362: iload_2
    //   363: istore_1
    //   364: lload 5
    //   366: lstore_3
    //   367: lload 5
    //   369: lload 11
    //   371: lload 9
    //   373: lsub
    //   374: lconst_1
    //   375: ladd
    //   376: lcmp
    //   377: iflt -89 -> 288
    //   380: iload_2
    //   381: istore_1
    //   382: goto -56 -> 326
    //   385: aload 19
    //   387: astore_0
    //   388: aload 20
    //   390: aload 21
    //   392: iconst_0
    //   393: bipush 8
    //   395: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   398: aload 19
    //   400: astore_0
    //   401: ldc 121
    //   403: iconst_1
    //   404: new 123	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   411: ldc 126
    //   413: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: iload_1
    //   417: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload 19
    //   428: astore_0
    //   429: aload 20
    //   431: invokevirtual 146	java/security/MessageDigest:digest	()[B
    //   434: astore 20
    //   436: aload 20
    //   438: astore_0
    //   439: aload_0
    //   440: astore 20
    //   442: aload 19
    //   444: ifnull -426 -> 18
    //   447: aload 19
    //   449: invokevirtual 149	java/io/InputStream:close	()V
    //   452: aload_0
    //   453: areturn
    //   454: astore 19
    //   456: aload 19
    //   458: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   461: aload_0
    //   462: areturn
    //   463: astore 20
    //   465: aconst_null
    //   466: astore 19
    //   468: aload 19
    //   470: astore_0
    //   471: aload 20
    //   473: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   476: aload 19
    //   478: ifnull +8 -> 486
    //   481: aload 19
    //   483: invokevirtual 149	java/io/InputStream:close	()V
    //   486: aconst_null
    //   487: areturn
    //   488: astore_0
    //   489: aload_0
    //   490: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   493: goto -7 -> 486
    //   496: astore 19
    //   498: aconst_null
    //   499: astore_0
    //   500: aload_0
    //   501: ifnull +7 -> 508
    //   504: aload_0
    //   505: invokevirtual 149	java/io/InputStream:close	()V
    //   508: aload 19
    //   510: athrow
    //   511: astore_0
    //   512: aload_0
    //   513: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   516: goto -8 -> 508
    //   519: astore 19
    //   521: goto -21 -> 500
    //   524: astore 20
    //   526: goto -58 -> 468
    //   529: iload_2
    //   530: bipush 8
    //   532: if_icmpge -147 -> 385
    //   535: aload 21
    //   537: bipush 8
    //   539: iload_2
    //   540: isub
    //   541: iconst_1
    //   542: isub
    //   543: lload 7
    //   545: bipush 64
    //   547: iload_2
    //   548: iconst_1
    //   549: iadd
    //   550: bipush 8
    //   552: imul
    //   553: isub
    //   554: lshr
    //   555: ldc2_w 154
    //   558: land
    //   559: l2i
    //   560: i2b
    //   561: bastore
    //   562: iload_2
    //   563: iconst_1
    //   564: iadd
    //   565: istore_2
    //   566: goto -37 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	paramString	String
    //   103	314	1	j	int
    //   134	432	2	k	int
    //   101	266	3	l1	long
    //   151	217	5	l2	long
    //   4	540	7	l3	long
    //   68	304	9	l4	long
    //   74	296	11	l5	long
    //   42	218	13	l6	long
    //   60	216	15	l7	long
    //   26	156	17	l8	long
    //   98	350	19	localBufferedInputStream	java.io.BufferedInputStream
    //   454	3	19	localIOException	IOException
    //   466	16	19	localObject1	Object
    //   496	13	19	localObject2	Object
    //   519	1	19	localObject3	Object
    //   16	425	20	localObject4	Object
    //   463	9	20	localException1	Exception
    //   524	1	20	localException2	Exception
    //   122	414	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   447	452	454	java/io/IOException
    //   28	62	463	java/lang/Exception
    //   76	100	463	java/lang/Exception
    //   481	486	488	java/io/IOException
    //   28	62	496	finally
    //   76	100	496	finally
    //   504	508	511	java/io/IOException
    //   107	124	519	finally
    //   127	135	519	finally
    //   138	147	519	finally
    //   177	190	519	finally
    //   197	217	519	finally
    //   220	228	519	finally
    //   231	240	519	finally
    //   271	284	519	finally
    //   291	311	519	finally
    //   314	322	519	finally
    //   329	335	519	finally
    //   343	352	519	finally
    //   388	398	519	finally
    //   401	426	519	finally
    //   429	436	519	finally
    //   471	476	519	finally
    //   107	124	524	java/lang/Exception
    //   127	135	524	java/lang/Exception
    //   138	147	524	java/lang/Exception
    //   177	190	524	java/lang/Exception
    //   197	217	524	java/lang/Exception
    //   220	228	524	java/lang/Exception
    //   231	240	524	java/lang/Exception
    //   271	284	524	java/lang/Exception
    //   291	311	524	java/lang/Exception
    //   314	322	524	java/lang/Exception
    //   329	335	524	java/lang/Exception
    //   343	352	524	java/lang/Exception
    //   388	398	524	java/lang/Exception
    //   401	426	524	java/lang/Exception
    //   429	436	524	java/lang/Exception
  }
  
  public static boolean B(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 2: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 3: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 4: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694128));
      return true;
    case 5: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 6: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 7: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 9: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 10: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 11: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        ti();
      }
      ahao.OS(2131694154);
      return true;
    case 16: 
      ahao.OS(2131694119);
      return true;
    case 13: 
      ahao.JD(kY(paramString) + BaseApplicationImpl.getContext().getString(2131694157));
      return true;
    }
    ahao.OS(2131696564);
    return true;
  }
  
  public static byte[] B(String paramString)
  {
    return A(paramString);
  }
  
  public static void F(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!ahbj.isFileExists(paramString)))
    {
      ahao.OS(2131694128);
      return;
    }
    if (getFileType(paramString) == 5)
    {
      installApkFile(paramActivity, paramString);
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800AE42", "0X800AE42", 0, 0, "", "", "", "");
    ahau.JH("0X8007152");
    WeakReference localWeakReference = new WeakReference(paramActivity);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("ChannelId", "biz_src_jc_file");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if ((localWXShareHelper.isWXinstalled()) && (localWXShareHelper.aGT()))
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("name", "send_to_wx");
      localBundle2.putInt("resource_id", 2130845251);
      localBundle2.putString("value", "发送到微信");
      Bundle localBundle3 = new Bundle();
      localBundle3.putBundle("weixin", localBundle2);
      localBundle1.putBundle("extraMenu", localBundle3);
    }
    QbSdk.openFileReaderListWithQBDownload(paramActivity, paramString, localBundle1, new ahbc(localWeakReference, paramString, localWXShareHelper));
  }
  
  public static long H(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 10002: 
      return 127L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static String H(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static void H(TextView paramTextView)
  {
    if ((paramTextView != null) && (eR != null))
    {
      ((Animatable)eR).stop();
      eR = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void H(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "entity null!");
    }
    String str;
    do
    {
      do
      {
        return;
        if (!paramFileManagerEntity.isCheckPrivateDir)
        {
          paramFileManagerEntity.isCheckPrivateDir = true;
          str = paramFileManagerEntity.getFilePath();
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.setFilePath(aqul.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
          }
          str = paramFileManagerEntity.strThumbPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strThumbPath = aqul.getSDKPrivatePath(paramFileManagerEntity.strThumbPath);
          }
          str = paramFileManagerEntity.strMiddleThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strMiddleThumPath = aqul.getSDKPrivatePath(paramFileManagerEntity.strMiddleThumPath);
          }
          str = paramFileManagerEntity.strLargeThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strLargeThumPath = aqul.getSDKPrivatePath(paramFileManagerEntity.strLargeThumPath);
          }
        }
      } while ((paramFileManagerEntity.nFileType != -1) && (paramFileManagerEntity.nFileType != 5));
      str = paramFileManagerEntity.getFilePath();
      if (str == null) {
        break;
      }
      paramFileManagerEntity.nFileType = getFileType(str);
    } while (!str.startsWith(acbn.SDCARD_PATH + "/Android/data/com.tencent.mobileqq"));
    paramFileManagerEntity.setFilePath(aqul.getSDKPrivatePath(paramFileManagerEntity.getFilePath()));
    return;
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = getFileType(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = getFileType(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = getFileType(paramFileManagerEntity.fileName);
  }
  
  public static void I(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        boolean bool;
        do
        {
          return;
          bool = ahbj.isFileExists(paramFileManagerEntity.getFilePath());
          if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 5) || (paramFileManagerEntity.nOpType == -1)))
          {
            paramFileManagerEntity.cloudType = 3;
            paramFileManagerEntity.status = 1;
            return;
          }
        } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))));
        if (paramFileManagerEntity.nFileType == 5) {
          ahap.G(paramFileManagerEntity);
        }
      } while (paramFileManagerEntity.status != 1);
      paramFileManagerEntity.status = 16;
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
    } while (TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId));
    paramFileManagerEntity.setCloudType(2);
    paramFileManagerEntity.status = -1;
  }
  
  public static void J(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0) {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        ahbh.d(paramFileManagerEntity.getFilePath(), (BitmapFactory.Options)localObject);
        if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
          break label277;
        }
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outHeight;
        int j = aoop.eI(paramFileManagerEntity.getFilePath());
        if ((j == 90) || (j == 270))
        {
          paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outHeight;
          paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outWidth;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + paramFileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    label277:
    do
    {
      do
      {
        for (;;)
        {
          localObject = ahbh.a(paramFileManagerEntity);
          if (localObject != null) {
            aoop.getDrawable((URL)localObject).downloadImediatly();
          }
          if ((ahwy.a().aom()) && (mI(paramFileManagerEntity.strMiddleThumPath)))
          {
            localObject = new File(paramFileManagerEntity.strMiddleThumPath);
            localObject = ahwo.a(BaseApplicationImpl.getContext(), (File)localObject);
            if (localObject == null) {
              break;
            }
            paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
            if (QLog.isDevelopLevel()) {
              QLog.i("IMG_FILE_QR", 1, "createMediThumbnail success:" + paramFileManagerEntity.strQRUrl);
            }
          }
          return;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
          }
        }
        if (ahwo.ciI)
        {
          paramFileManagerEntity.strQRUrl = null;
          return;
        }
        paramFileManagerEntity.strQRUrl = "";
        return;
      } while (paramFileManagerEntity.nFileType != 2);
      localObject = a(paramFileManagerEntity.getFilePath());
    } while (((ahav.e)localObject).retCode == -1);
    paramFileManagerEntity.strLargeThumPath = ((ahav.e)localObject).bN;
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + paramFileManagerEntity.nSessionId + "] create thumb success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      return;
      paramFileManagerEntity.imgWidth = ((ahav.e)localObject).mThumbWidth;
      paramFileManagerEntity.imgHeight = ((ahav.e)localObject).gP;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]get local video,(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
  }
  
  public static void JI(String paramString)
  {
    ahao.JD(paramString);
  }
  
  public static void JJ(String paramString)
  {
    try
    {
      BaseApplicationImpl.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void K(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    int j;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          localStringBuilder.append("entity is nll,stack:" + ti());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        j = paramFileManagerEntity.nFileType;
        if ((j != 2) && (j != 0))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          continue;
        }
        if (paramFileManagerEntity.imgHeight <= 0) {
          break;
        }
      }
      finally {}
      if (paramFileManagerEntity.imgWidth <= 0) {
        break;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("] OK, return!");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    Object localObject1 = paramFileManagerEntity.getFilePath();
    if (ahbj.fileExistsAndNotEmpty((String)localObject1))
    {
      if (j == 2) {
        bool1 = false;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is local, use local calc size!");
    }
    Object localObject2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label422;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      localObject1 = paramFileManagerEntity.strLargeThumPath;
      if (ahbj.fileExistsAndNotEmpty((String)localObject1))
      {
        localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloude , use largThumb calc size!");
        bool1 = bool2;
      }
      else
      {
        localObject1 = paramFileManagerEntity.strMiddleThumPath;
        if (ahbj.fileExistsAndNotEmpty((String)localObject1))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (j == 2)
          {
            localObject2 = paramFileManagerEntity.strThumbPath;
            bool1 = bool2;
            localObject1 = localObject2;
            if (ahbj.fileExistsAndNotEmpty((String)localObject2))
            {
              localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] video is cloud , use thumb calc size!");
              bool1 = bool2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label422:
    if (bool1)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      ahbh.d((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
      j = aoop.eI((String)localObject1);
      if ((j == 90) || (j == 270))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
      }
    }
    for (;;)
    {
      localStringBuilder.append(" calc size over size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("]");
      localStringBuilder.append(" useImageCreateThumb:").append(bool1);
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      if (j == 2) {
        J(paramFileManagerEntity);
      }
    }
  }
  
  public static void L(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static boolean L(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!ahbr.ay(paramChatMessage))) {}
    do
    {
      return false;
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    } while ((!TextUtils.isEmpty(paramChatMessage)) && (Integer.parseInt(paramChatMessage) != 1));
    return true;
  }
  
  public static long N(long paramLong)
  {
    return 2863315899L << 31 | paramLong;
  }
  
  public static boolean S(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return aqlr.hasShortCut(paramContext, new String[] { paramString });
    }
    return isShortcutCreated_O(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  public static void U(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localObject = (MessageForFile)paramChatMessage;
      ((MessageForFile)localObject).uniseq = 0L;
      ((MessageForFile)localObject).msgseq = 0L;
      ((MessageForFile)localObject).fileName = "";
      ((MessageForFile)localObject).fileSize = 0L;
    }
    for (;;)
    {
      paramChatMessage.extStr = null;
      return;
      if ((paramChatMessage instanceof MessageForTroopFile))
      {
        localObject = (MessageForTroopFile)paramChatMessage;
        ((MessageForTroopFile)localObject).uniseq = 0L;
        ((MessageForTroopFile)localObject).msgseq = 0L;
        ((MessageForTroopFile)localObject).url = "";
        ((MessageForTroopFile)localObject).uuid = "";
        ((MessageForTroopFile)localObject).bisID = 0;
        ((MessageForTroopFile)localObject).fileName = "";
        ((MessageForTroopFile)localObject).fileSize = 0L;
        ((MessageForTroopFile)localObject).width = 0;
        ((MessageForTroopFile)localObject).height = 0;
        ((MessageForTroopFile)localObject).duration = 0;
      }
    }
  }
  
  private static long a(long paramLong, TimeZone paramTimeZone)
  {
    return (paramTimeZone.getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  /* Error */
  public static ahav.e a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 731	ahav:t	(Ljava/lang/String;)[B
    //   6: invokestatic 737	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   9: astore_1
    //   10: new 123	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   17: invokestatic 742	ahaf:a	()Lahaf;
    //   20: invokevirtual 745	ahaf:wb	()Ljava/lang/String;
    //   23: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 747
    //   29: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: new 18	ahav$e
    //   44: dup
    //   45: invokespecial 748	ahav$e:<init>	()V
    //   48: astore 5
    //   50: aload 5
    //   52: iconst_0
    //   53: putfield 535	ahav$e:retCode	I
    //   56: aload 5
    //   58: aload_1
    //   59: putfield 751	ahav$e:mVideoMd5	Ljava/lang/String;
    //   62: aload 4
    //   64: invokestatic 582	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   67: ifeq +51 -> 118
    //   70: new 438	android/graphics/BitmapFactory$Options
    //   73: dup
    //   74: invokespecial 439	android/graphics/BitmapFactory$Options:<init>	()V
    //   77: astore_0
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 442	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   83: aload 4
    //   85: aload_0
    //   86: invokestatic 447	ahbh:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: pop
    //   90: aload 5
    //   92: aload_0
    //   93: getfield 456	android/graphics/BitmapFactory$Options:outWidth	I
    //   96: putfield 545	ahav$e:mThumbWidth	I
    //   99: aload 5
    //   101: aload_0
    //   102: getfield 459	android/graphics/BitmapFactory$Options:outHeight	I
    //   105: putfield 548	ahav$e:gP	I
    //   108: aload 5
    //   110: aload 4
    //   112: putfield 538	ahav$e:bN	Ljava/lang/String;
    //   115: aload 5
    //   117: areturn
    //   118: aload_0
    //   119: iconst_1
    //   120: invokestatic 757	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   123: astore_0
    //   124: aload_0
    //   125: astore_2
    //   126: aload_0
    //   127: ifnonnull +21 -> 148
    //   130: aload 5
    //   132: iconst_m1
    //   133: putfield 535	ahav$e:retCode	I
    //   136: aload 5
    //   138: areturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   146: aload_0
    //   147: astore_2
    //   148: new 123	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   155: invokestatic 742	ahaf:a	()Lahaf;
    //   158: invokevirtual 745	ahaf:wb	()Ljava/lang/String;
    //   161: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokestatic 763	java/lang/System:currentTimeMillis	()J
    //   167: invokevirtual 472	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: ldc_w 765
    //   173: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 6
    //   181: new 123	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   188: invokestatic 742	ahaf:a	()Lahaf;
    //   191: invokevirtual 745	ahaf:wb	()Ljava/lang/String;
    //   194: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 767
    //   200: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 770	aqhq:UD	(Ljava/lang/String;)V
    //   209: new 772	com/tencent/mm/vfs/VFSFile
    //   212: dup
    //   213: aload 6
    //   215: invokespecial 773	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   218: astore 7
    //   220: aload 7
    //   222: invokevirtual 776	com/tencent/mm/vfs/VFSFile:getParent	()Ljava/lang/String;
    //   225: astore_0
    //   226: aload_0
    //   227: ifnonnull +6 -> 233
    //   230: aload 5
    //   232: areturn
    //   233: new 772	com/tencent/mm/vfs/VFSFile
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 773	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 779	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   246: ifeq +10 -> 256
    //   249: aload_0
    //   250: invokevirtual 782	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   253: ifne +8 -> 261
    //   256: aload_0
    //   257: invokevirtual 785	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   260: pop
    //   261: aload 7
    //   263: invokevirtual 779	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   266: ifeq +11 -> 277
    //   269: aload 7
    //   271: invokevirtual 788	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   274: ifne +9 -> 283
    //   277: aload 7
    //   279: invokevirtual 791	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   282: pop
    //   283: new 793	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 795	com/tencent/mm/vfs/VFSFileOutputStream
    //   290: dup
    //   291: aload 7
    //   293: invokespecial 798	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   296: invokespecial 801	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: astore_0
    //   300: aload_2
    //   301: ifnull +85 -> 386
    //   304: aload_0
    //   305: astore_1
    //   306: aload_2
    //   307: getstatic 807	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   310: bipush 80
    //   312: aload_0
    //   313: invokevirtual 813	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   316: pop
    //   317: aload_0
    //   318: astore_1
    //   319: aload_0
    //   320: invokevirtual 816	java/io/BufferedOutputStream:flush	()V
    //   323: aload_0
    //   324: ifnull +7 -> 331
    //   327: aload_0
    //   328: invokevirtual 817	java/io/BufferedOutputStream:close	()V
    //   331: aload 7
    //   333: invokevirtual 779	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   336: ifeq +220 -> 556
    //   339: aload 6
    //   341: aload 4
    //   343: invokestatic 821	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   346: pop
    //   347: aload 6
    //   349: invokestatic 824	ahbj:deleteFile	(Ljava/lang/String;)Z
    //   352: pop
    //   353: aload_2
    //   354: ifnull +21 -> 375
    //   357: aload 5
    //   359: aload_2
    //   360: invokevirtual 827	android/graphics/Bitmap:getWidth	()I
    //   363: putfield 545	ahav$e:mThumbWidth	I
    //   366: aload 5
    //   368: aload_2
    //   369: invokevirtual 830	android/graphics/Bitmap:getHeight	()I
    //   372: putfield 548	ahav$e:gP	I
    //   375: aload 5
    //   377: areturn
    //   378: astore_0
    //   379: aload_0
    //   380: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   383: goto -100 -> 283
    //   386: aload_0
    //   387: astore_1
    //   388: aload 5
    //   390: iconst_m1
    //   391: putfield 535	ahav$e:retCode	I
    //   394: goto -71 -> 323
    //   397: astore_1
    //   398: aload 5
    //   400: bipush 254
    //   402: putfield 535	ahav$e:retCode	I
    //   405: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +43 -> 451
    //   411: ldc 121
    //   413: iconst_2
    //   414: new 123	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 832
    //   424: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 6
    //   429: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 834
    //   435: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 837	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_0
    //   452: ifnull -121 -> 331
    //   455: aload_0
    //   456: invokevirtual 817	java/io/BufferedOutputStream:close	()V
    //   459: goto -128 -> 331
    //   462: astore_0
    //   463: goto -132 -> 331
    //   466: astore_3
    //   467: aconst_null
    //   468: astore_0
    //   469: aload_0
    //   470: astore_1
    //   471: aload 5
    //   473: bipush 254
    //   475: putfield 535	ahav$e:retCode	I
    //   478: aload_0
    //   479: astore_1
    //   480: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +45 -> 528
    //   486: aload_0
    //   487: astore_1
    //   488: ldc 121
    //   490: iconst_2
    //   491: new 123	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 832
    //   501: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 6
    //   506: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 839
    //   512: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_3
    //   516: invokevirtual 840	java/io/IOException:getMessage	()Ljava/lang/String;
    //   519: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: aload_0
    //   529: ifnull -198 -> 331
    //   532: aload_0
    //   533: invokevirtual 817	java/io/BufferedOutputStream:close	()V
    //   536: goto -205 -> 331
    //   539: astore_0
    //   540: goto -209 -> 331
    //   543: astore_0
    //   544: aconst_null
    //   545: astore_1
    //   546: aload_1
    //   547: ifnull +7 -> 554
    //   550: aload_1
    //   551: invokevirtual 817	java/io/BufferedOutputStream:close	()V
    //   554: aload_0
    //   555: athrow
    //   556: aload 5
    //   558: iconst_m1
    //   559: putfield 535	ahav$e:retCode	I
    //   562: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq -190 -> 375
    //   568: ldc 121
    //   570: iconst_2
    //   571: ldc_w 842
    //   574: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: goto -202 -> 375
    //   580: astore_0
    //   581: goto -250 -> 331
    //   584: astore_1
    //   585: goto -31 -> 554
    //   588: astore_0
    //   589: goto -43 -> 546
    //   592: astore_2
    //   593: aload_0
    //   594: astore_1
    //   595: aload_2
    //   596: astore_0
    //   597: goto -51 -> 546
    //   600: astore_3
    //   601: goto -132 -> 469
    //   604: astore_1
    //   605: aload_3
    //   606: astore_0
    //   607: goto -209 -> 398
    //   610: astore_1
    //   611: goto -469 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	614	0	paramString	String
    //   9	50	1	str1	String
    //   139	4	1	localException1	Exception
    //   305	83	1	str2	String
    //   397	42	1	localFileNotFoundException1	FileNotFoundException
    //   470	81	1	str3	String
    //   584	1	1	localIOException1	IOException
    //   594	1	1	str4	String
    //   604	1	1	localFileNotFoundException2	FileNotFoundException
    //   610	1	1	localException2	Exception
    //   125	244	2	str5	String
    //   592	4	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   466	50	3	localIOException2	IOException
    //   600	6	3	localIOException3	IOException
    //   39	303	4	str6	String
    //   48	509	5	locale	ahav.e
    //   179	326	6	str7	String
    //   218	114	7	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   118	124	139	java/lang/Exception
    //   277	283	378	java/io/IOException
    //   306	317	397	java/io/FileNotFoundException
    //   319	323	397	java/io/FileNotFoundException
    //   388	394	397	java/io/FileNotFoundException
    //   455	459	462	java/io/IOException
    //   283	300	466	java/io/IOException
    //   532	536	539	java/io/IOException
    //   283	300	543	finally
    //   327	331	580	java/io/IOException
    //   550	554	584	java/io/IOException
    //   306	317	588	finally
    //   319	323	588	finally
    //   388	394	588	finally
    //   471	478	588	finally
    //   480	486	588	finally
    //   488	528	588	finally
    //   398	451	592	finally
    //   306	317	600	java/io/IOException
    //   319	323	600	java/io/IOException
    //   388	394	600	java/io/IOException
    //   283	300	604	java/io/FileNotFoundException
    //   130	136	610	java/lang/Exception
  }
  
  public static ahbm a(QQAppInterface paramQQAppInterface)
  {
    return new ahak(paramQQAppInterface);
  }
  
  public static ahbm a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new ahax(paramQQAppInterface, paramInt);
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      localObject = null;
    }
    Intent localIntent;
    Bundle localBundle;
    do
    {
      return localObject;
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        paramMessageRecord = (MessageForFile)paramMessageRecord;
        localBundle.putParcelable("fileinfo", ahhq.a(a(paramQQAppInterface, paramMessageRecord), paramMessageRecord));
        localIntent.putExtras(localBundle);
        return localIntent;
      }
      localObject = localIntent;
    } while (!(paramMessageRecord instanceof MessageForTroopFile));
    paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
    paramQQAppInterface = apsv.a(paramQQAppInterface, paramMessageRecord);
    Object localObject = a(paramQQAppInterface);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.setType(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.setLocalPath(paramQQAppInterface.LocalFile);
    }
    localForwardFileInfo.setFileName(paramQQAppInterface.FileName);
    localForwardFileInfo.setFileSize(paramQQAppInterface.ProgressTotal);
    localForwardFileInfo.jA(Long.parseLong(paramMessageRecord.frienduin));
    if (paramQQAppInterface.Id != null) {
      localForwardFileInfo.Ja(paramQQAppInterface.Id.toString());
    }
    localForwardFileInfo.Oj(1);
    localForwardFileInfo.Oh(1);
    localBundle.putParcelable("fileinfo", localForwardFileInfo);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_from_troop_file", true);
    return localIntent;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = paramContext.getResources().getDisplayMetrics().density;
        int i3 = wja.dp2px(paramInt, paramContext.getResources());
        k = (int)(paramBitmap.getWidth() * f);
        m = (int)(f * paramBitmap.getHeight());
        paramInt = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (paramInt > j)
        {
          k = (paramInt - j) / 2;
          n = m;
          paramInt = j;
          i2 = 0;
          i1 = m;
          m = k;
          k = i2;
          paramContext = Bitmap.createBitmap(i1, n, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(paramContext);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(m, k, j + m, paramInt + k);
          Rect localRect2 = new Rect(0, 0, i1, n);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, i3, i3, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return paramContext;
        }
        if (j > paramInt)
        {
          m = (j - paramInt) / 2;
          n = k;
          i1 = k;
          i2 = 0;
          j = paramInt;
          k = m;
          m = i2;
          continue;
        }
        int n = m;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      int i1 = k;
      int i2 = 0;
      int m = 0;
      int k = paramInt;
      paramInt = j;
      int j = k;
      k = i2;
    }
  }
  
  private static Bitmap a(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int k = paramBitmap.getWidth() - paramInt1;
    int j = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((k < 0) || (j < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        k = Math.max(0, k / 2);
        j = Math.max(0, j / 2);
        localObject2 = new Rect(k, j, Math.min(paramInt1, paramBitmap.getWidth()) + k, Math.min(paramInt2, paramBitmap.getHeight()) + j);
        j = (paramInt1 - ((Rect)localObject2).width()) / 2;
        k = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(j, k, paramInt1 - j, paramInt2 - k), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label224:
        if (paramMatrix == null) {
          break label376;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          j = Math.max(0, paramMatrix.getWidth() - paramInt1);
          k = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, j / 2, k / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label376:
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label224;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label224;
      }
      paramMatrix = null;
      break label224;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, ahav.d paramd)
  {
    int j = paramString1.indexOf(paramString2);
    int k = paramString2.length() + j;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new ahbe(paramd);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(-14782465), j, k, 33);
      paramString1.setSpan(paramString2, j, k, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static aona.d.a a()
  {
    boolean bool = false;
    Object localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    int j = -1;
    int m;
    int k;
    if (localObject != null)
    {
      m = ((NetworkInfo)localObject).getType();
      if (m == 1)
      {
        j = 1;
        k = j;
        j = m;
      }
    }
    for (;;)
    {
      int n = BaseApplicationImpl.sApplication.getMsfConnectedNetType();
      if (n == 2) {}
      for (m = 1;; m = 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getNetworkInfo,systemType:").append(j).append(" msfType:").append(n).append(" isSameNet:");
          if (k == m) {
            bool = true;
          }
          QLog.i("FileManagerUtil<FileAssistant>.NetDebug", 1, bool);
        }
        if (k == m) {
          break label199;
        }
        localObject = new aona.d.a();
        ((aona.d.a)localObject).dQf = 20000;
        ((aona.d.a)localObject).dQg = 15000;
        ((aona.d.a)localObject).dQh = 10000;
        ((aona.d.a)localObject).dQi = 10000;
        ((aona.d.a)localObject).dQj = 5000;
        ((aona.d.a)localObject).dQk = 5000;
        return localObject;
        j = 0;
        break;
      }
      label199:
      return null;
      k = 0;
    }
  }
  
  public static atkw a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    Object localObject3 = null;
    Object localObject1;
    switch (paramCloudHistoryInfo.sourceType)
    {
    case 7: 
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((atkw)localObject1).a(paramCloudHistoryInfo, paramObject))
        {
          ((atkw)localObject1).fileName = paramCloudHistoryInfo.fileName;
          ((atkw)localObject1).fileSize = paramCloudHistoryInfo.fileSize;
          ((atkw)localObject1).lastTime = paramCloudHistoryInfo.operateTime;
          ((atkw)localObject1).relatedType = paramCloudHistoryInfo.sourceType;
          ((atkw)localObject1).operateType = paramCloudHistoryInfo.operateType;
          ((atkw)localObject1).cGT = paramCloudHistoryInfo.localPath;
          ((atkw)localObject1).jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo = paramCloudHistoryInfo;
          if (paramCloudHistoryInfo.fileExtInfo == null) {}
        }
      }
      try
      {
        paramObject = new history_file_extension.FileExtension();
        paramObject.mergeFrom(paramCloudHistoryInfo.fileExtInfo);
        ((atkw)localObject1).jdField_a_of_type_TencentCloudHistory_file_extensionHistory_file_extension$FileExtension = paramObject;
        localObject2 = localObject1;
        return localObject2;
      }
      catch (InvalidProtocolBufferMicroException paramCloudHistoryInfo)
      {
        paramCloudHistoryInfo.printStackTrace();
      }
      localObject1 = new atkq();
      continue;
      localObject1 = new atks();
      continue;
      localObject1 = new atld();
      continue;
      localObject1 = new atkz();
      continue;
      localObject1 = new atla();
      continue;
      localObject1 = new atkx();
      continue;
      localObject1 = new atkv();
    }
    return null;
  }
  
  public static FileManagerEntity a(Bundle paramBundle)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.WeiYunFileId = ((String)paramBundle.get("file_id"));
    localFileManagerEntity.fileName = ((String)paramBundle.get("filename"));
    localFileManagerEntity.WeiYunDirKey = ((String)paramBundle.get("pdir_key"));
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(apcy paramapcy)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramapcy.FileName;
    if (ahbj.isFileExists(paramapcy.LocalFile)) {
      localFileManagerEntity.setFilePath(paramapcy.LocalFile);
    }
    if (ahbj.isFileExists(paramapcy.ThumbnailFile_Large)) {
      localFileManagerEntity.strLargeThumPath = paramapcy.ThumbnailFile_Large;
    }
    if (ahbj.isFileExists(paramapcy.ThumbnailFile_Small))
    {
      localFileManagerEntity.strThumbPath = paramapcy.ThumbnailFile_Small;
      localFileManagerEntity.fileSize = paramapcy.ProgressTotal;
      localFileManagerEntity.fProgress = ((float)paramapcy.ProgressValue / (float)paramapcy.ProgressTotal);
      localFileManagerEntity.nFileType = getFileType(paramapcy.FileName);
      if ((6 <= paramapcy.Status) && (13 != paramapcy.Status)) {
        break label353;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramapcy.Id != null) {
        localFileManagerEntity.strTroopFileID = paramapcy.Id.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramapcy.FilePath;
      localFileManagerEntity.strTroopFileSha1 = paramapcy.sha1;
      localFileManagerEntity.busId = paramapcy.BusId;
      localFileManagerEntity.TroopUin = paramapcy.TroopUin;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
      localFileManagerEntity.uniseq = paramapcy.uniseq;
      localFileManagerEntity.yybApkPackageName = paramapcy.yybApkPackageName;
      localFileManagerEntity.yybApkName = paramapcy.yybApkName;
      localFileManagerEntity.yybApkIconUrl = paramapcy.yybApkIconUrl;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramapcy.FileName + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(localFileManagerEntity);
      return localFileManagerEntity;
      if (!ahbj.isFileExists(paramapcy.coc)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramapcy.coc;
      break;
      label353:
      if (12 == paramapcy.Status) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    Object localObject;
    if (paramMpfileTaskInfo.status == MpfileTaskInfo.dC)
    {
      localFileManagerEntity.status = -1;
      localFileManagerEntity.fileName = paramMpfileTaskInfo.fileName;
      localFileManagerEntity.setFilePath(paramMpfileTaskInfo.filePath);
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.totalSize;
      localFileManagerEntity.nFileType = getFileType(paramMpfileTaskInfo.fileName);
      if (localFileManagerEntity.nFileType == 0)
      {
        localObject = (acde)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(8);
        if (((acde)localObject).a().a() != null) {
          break label353;
        }
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
    }
    for (;;)
    {
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.currentSize / (float)paramMpfileTaskInfo.totalSize);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.taskId;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.fileId;
      localFileManagerEntity.peerDin = paramLong;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramMpfileTaskInfo.fileName + "] by mpfile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)localObject).a().v(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.status == MpfileTaskInfo.dF)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
        break;
      }
      if ((paramMpfileTaskInfo.status == MpfileTaskInfo.dG) || (paramMpfileTaskInfo.status == MpfileTaskInfo.dH))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.currentSize / (float)paramMpfileTaskInfo.totalSize);
        break;
      }
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.currentSize / (float)paramMpfileTaskInfo.totalSize);
      break;
      label353:
      localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { ((acde)localObject).a().ah(), paramMpfileTaskInfo.fileName });
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramLong, paramString, paramInt);
    if (localFileManagerEntity == null) {}
    paramString = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      paramString = a(paramQQAppInterface, paramChatMessage);
    }
    return paramString;
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!ahbr.ay(paramChatMessage))) {}
    for (;;)
    {
      return null;
      Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (int j = Integer.parseInt((String)localObject); (j == 1) || (j == 2); j = -1)
      {
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = d().longValue();
        ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
        ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
        ((FileManagerEntity)localObject).isReaded = false;
        ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ahbr.a(paramQQAppInterface, (FileManagerEntity)localObject, paramChatMessage);
        ((FileManagerEntity)localObject).peerNick = a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
        ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
        ((FileManagerEntity)localObject).fileIdCrc = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
        ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(str)) {
          ((FileManagerEntity)localObject).fileSize = Long.parseLong(str);
        }
        str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
        {
          if (!((FileManagerEntity)localObject).selfUin.equals(str)) {
            break label368;
          }
          ((FileManagerEntity)localObject).nOpType = 0;
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).status = -1;
          str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
          {
            if (((FileManagerEntity)localObject).selfUin.equals(str)) {
              ((FileManagerEntity)localObject).bSend = false;
            }
          }
          else
          {
            label252:
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
            if (!aqhq.fileExistsAndNotEmpty(str)) {
              break label384;
            }
            ((FileManagerEntity)localObject).setFilePath(str);
            ((FileManagerEntity)localObject).setCloudType(3);
            ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
            ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
          }
          try
          {
            ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(str);
            label320:
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
            try
            {
              ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(str);
              label338:
              a(paramQQAppInterface, (FileManagerEntity)localObject);
              paramQQAppInterface.a().v((FileManagerEntity)localObject);
              if (L(paramChatMessage)) {
                paramQQAppInterface.a().s((FileManagerEntity)localObject);
              }
              return localObject;
              label368:
              ((FileManagerEntity)localObject).nOpType = 1;
              continue;
              ((FileManagerEntity)localObject).bSend = true;
              break label252;
              label384:
              ((FileManagerEntity)localObject).setCloudType(1);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              break label338;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            break label320;
          }
        }
      }
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + kZ(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = paramQQAppInterface.a().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).close();
      localFileManagerEntity.status = hM(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label442;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label430;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label492;
        }
        localObject = new String(localTransFileInfo.uuid);
        label277:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label498;
      }
    }
    label430:
    label442:
    label492:
    label498:
    for (int j = 0;; j = 1)
    {
      localFileManagerEntity.nOpType = j;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.fProgress = ((float)paramQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.a().v(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label277;
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().b(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity1 = new FileManagerEntity();
      localFileManagerEntity1.nSessionId = d().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity1.nSessionId;
      localFileManagerEntity1.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2 = localFileManagerEntity1;
      if (paramDataLineMsgRecord.nOpType == 31)
      {
        localFileManagerEntity1.strTroopFilePath = paramDataLineMsgRecord.fileUuid;
        localFileManagerEntity2 = localFileManagerEntity1;
      }
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    localFileManagerEntity2.status = -1;
    if (paramDataLineMsgRecord.fileMsgStatus == 0L)
    {
      localFileManagerEntity2.status = 1;
      if (!paramDataLineMsgRecord.issuc)
      {
        localFileManagerEntity2.status = 0;
        if (paramDataLineMsgRecord.nOpType == 1) {
          localFileManagerEntity2.bSend = false;
        }
        localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
          localFileManagerEntity2.setFilePath(paramDataLineMsgRecord.path);
        }
        localFileManagerEntity2.Uuid = paramDataLineMsgRecord.serverPath;
        if ((localFileManagerEntity2.Uuid == null) && ((paramDataLineMsgRecord.nOpType == 31) || (paramDataLineMsgRecord.nOpType == 29))) {
          localFileManagerEntity2.Uuid = paramDataLineMsgRecord.fileUuid;
        }
        localFileManagerEntity2.peerType = 6000;
        localFileManagerEntity2.peerUin = acbn.bkw;
        if (1 == DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid))
        {
          localFileManagerEntity2.peerType = 6003;
          localFileManagerEntity2.peerUin = acbn.bkx;
        }
        localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
        localFileManagerEntity2.strFileMd5 = aqhs.bytes2HexStr(paramDataLineMsgRecord.md5);
        localFileManagerEntity2.nFileType = getFileType(paramDataLineMsgRecord.filename);
        if (localFileManagerEntity2.nFileType != 0) {
          break label569;
        }
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
        localFileManagerEntity2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      if (paramDataLineMsgRecord.strMoloKey != null)
      {
        localFileManagerEntity2.nFileType = getFileType(paramDataLineMsgRecord.path);
        localFileManagerEntity2.isFromrMolo = true;
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      if ((localFileManagerEntity2.fProgress == 1.0D) && ((localFileManagerEntity2.status == 3) || (localFileManagerEntity2.status == -1))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      if ((paramDataLineMsgRecord.nOpType == 1) && (Float.compare(paramDataLineMsgRecord.progress, 1.0F) == 0) && (!ahbf.fileExistsAndNotEmpty(paramDataLineMsgRecord.path))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2.nOpType = paramDataLineMsgRecord.nOpType;
      localFileManagerEntity2.srvTime = (paramDataLineMsgRecord.time * 1000L);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramDataLineMsgRecord.filename + "] by dataline size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().v(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress == 1.0F) {
        break;
      }
      localFileManagerEntity2.status = 2;
      break;
      if (paramDataLineMsgRecord.fileMsgStatus != 2L) {
        break;
      }
      localFileManagerEntity2.status = 3;
      if (paramDataLineMsgRecord.progress != 0.0F) {
        break;
      }
      localFileManagerEntity2.status = 0;
      break;
      label569:
      if ((localFileManagerEntity2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == -2000)) {
        localFileManagerEntity2.nFileType = 0;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().d(paramMessageForDeviceFile.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = d().longValue();
      paramMessageForDeviceFile.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceFile.isSendFromLocal();
    localFileManagerEntity2.nOpType = 1;
    if (localFileManagerEntity2.bSend) {
      localFileManagerEntity2.nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus == 3) || (paramMessageForDeviceFile.nFileStatus == 1) || (paramMessageForDeviceFile.nFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = getFileName(paramMessageForDeviceFile.filePath);
      if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceFile.filePath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceFile.fileSize;
      localFileManagerEntity2.nFileType = getFileType(paramMessageForDeviceFile.filePath);
      if ((localFileManagerEntity2.nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(szy.aIl))) {
        localFileManagerEntity2.nFileType = 0;
      }
      localFileManagerEntity2.fProgress = paramMessageForDeviceFile.progress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceFile.uSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceFile.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceFile.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceFile.uniseq;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramMessageForDeviceFile.srcFileName + "] by devices size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().v(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        localFileManagerEntity2.status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        localFileManagerEntity2.status = -1;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().d(paramMessageForDeviceSingleStruct.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = d().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus == 3) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 1) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
      localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
      localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
      localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
      if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
      localFileManagerEntity2.nFileType = getFileType(paramMessageForDeviceSingleStruct.strMediaFileName);
      localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
      localQQAppInterface.a().v(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int j = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (j >= 0) {}
    for (localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(j + 1);; localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename)
    {
      VFSFile localVFSFile = new VFSFile(localFileManagerEntity.getFilePath());
      if (localVFSFile.exists()) {
        localFileManagerEntity.fileSize = localVFSFile.length();
      }
      localFileManagerEntity.nFileType = getFileType(paramPrinterItemMsgRecord.filename);
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramPrinterItemMsgRecord.filename + "] by print size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.getName();
    localFileManagerEntity.setFilePath(paramFileInfo.getPath());
    localFileManagerEntity.fileSize = paramFileInfo.getSize();
    if (paramFileInfo.getType() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = getFileType(paramFileInfo.getName()))
    {
      localFileManagerEntity.status = -1;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramFileInfo.getName() + "]by local size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      localQQAppInterface.a().v(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.bHK;
    localFileManagerEntity.fileIdCrc = paramOfflineFileInfo.bHL;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.bIz;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.uFriendUin);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.strFileName;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.nFileSize;
    localFileManagerEntity.nFileType = getFileType(paramOfflineFileInfo.strFileName);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.Zm;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.Zn;
    localFileManagerEntity.bSend = paramOfflineFileInfo.bSend;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramOfflineFileInfo.strFileName + "] by offlinefile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
    localQQAppInterface.a().v(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.strFavFileId = paramString2;
    localFileManagerEntity.strFavId = paramString1;
    localFileManagerEntity.fileName = paramString4;
    localFileManagerEntity.fileSize = paramLong;
    localFileManagerEntity.nFileType = getFileType(paramString4);
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.setFilePath(paramString3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.strFileMd5 = paramString5;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString6;
    if (paramInt == 1) {
      localFileManagerEntity.nOpType = 36;
    }
    for (;;)
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().v(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramInt == 0) {
        localFileManagerEntity.nOpType = 37;
      } else if (paramInt == 7) {
        localFileManagerEntity.nOpType = 38;
      }
    }
  }
  
  public static String a(TextView paramTextView, int paramInt, String paramString1, String paramString2)
  {
    int k = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    float f = localTextPaint.measureText(paramString1);
    if (f < k) {}
    while (f <= paramInt * k - 50) {
      return paramString2;
    }
    int j = 0;
    for (;;)
    {
      int m = paramString2.length() - j - 1;
      if (m < 1) {}
      for (;;)
      {
        return paramString1;
        paramTextView = paramString2.substring(0, m) + UU;
        paramString1 = paramString1.replace(paramString2, paramTextView);
        if (localTextPaint.measureText(paramString1) >= paramInt * k - 50) {
          break;
        }
        paramString1 = paramTextView;
      }
      j += 1;
      paramString2 = paramTextView;
    }
  }
  
  public static String a(TextView paramTextView, String paramString)
  {
    int n = paramTextView.getWidth();
    StringBuilder localStringBuilder = new StringBuilder();
    paramTextView = paramTextView.getPaint();
    if (paramTextView.measureText(paramString) < n) {
      return paramString;
    }
    int k = 0;
    int j = 1;
    while (j < paramString.length())
    {
      int m = j + 1;
      j = m;
      if (paramTextView.measureText(paramString, k, m) >= n - 30)
      {
        localStringBuilder.append(paramString, k, m);
        localStringBuilder.append('\n');
        k = m;
        j = m;
      }
    }
    localStringBuilder.append(paramString, k, j);
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = getFileType(paramQQAppInterface.getFilePath());
    }
    paramMessage = ek(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + paramQQAppInterface.fileName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = ek(getFileType(paramDataLineMsgRecord.path));
    return "[" + paramQQAppInterface + "]" + paramDataLineMsgRecord.filename;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (acbn.bkw.equalsIgnoreCase(paramString1)) {
      return acfp.m(2131696154);
    }
    if (acbn.bkx.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (acbn.bks.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return aqgv.e(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null) || (paramInt1 <= 0))
    {
      localObject = "";
      return localObject;
    }
    int k;
    char[] arrayOfChar;
    int m;
    label53:
    int i1;
    int n;
    if (paramInt2 > 1)
    {
      k = paramInt2;
      arrayOfChar = paramString.toCharArray();
      localObject = new StringBuilder();
      j = 0;
      m = 0;
      if (j >= arrayOfChar.length) {
        break label398;
      }
      ((StringBuilder)localObject).append(arrayOfChar[j]);
      i1 = j;
      n = m;
      if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) <= paramInt1) {
        break label272;
      }
      i1 = j - 1;
      j = m + 1;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      n = j;
      if (j < k) {
        break label272;
      }
    }
    label392:
    label398:
    for (int j = 1;; j = 0)
    {
      localObject = paramString;
      if (j == 0) {
        break;
      }
      if (paramBoolean)
      {
        k = 6;
        label149:
        if (paramString.length() >= k) {
          break label292;
        }
        localObject = paramString;
        label161:
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        n = 0;
        m = 0;
        j = 0;
        label181:
        if (n >= arrayOfChar.length - k) {
          break label392;
        }
        localStringBuilder.append(arrayOfChar[n]);
        if (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt1 * paramInt2) {
          break label312;
        }
      }
      for (paramInt1 = n - 2;; paramInt1 = j)
      {
        if (paramInt1 > 0) {}
        for (;;)
        {
          if (m != 0) {
            break label367;
          }
          return paramString.substring(0, paramInt1) + UU + (String)localObject;
          k = 1;
          break;
          label272:
          j = i1 + 1;
          m = n;
          break label53;
          k = 15;
          break label149;
          label292:
          localObject = paramString.substring(paramString.length() - k, paramString.length());
          break label161;
          label312:
          if (paramString.substring(n, n + 1).equals(UU)) {
            m = 1;
          }
          if (n == arrayOfChar.length - k - 1) {
            j = n - 2;
          }
          n += 1;
          break label181;
          paramInt1 = 0;
        }
        label367:
        return paramString.substring(0, paramInt1) + (String)localObject;
      }
    }
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    Object localObject2 = new VFSFile(wc()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (j < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[j];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        j += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (ahbj.isFileExists((String)localObject2))
          {
            localObject2 = new VFSFile((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).setName(((VFSFile)localObject2).getName());
            ((FileInfo)localObject3).setDirectory(((VFSFile)localObject2).isDirectory());
            ((FileInfo)localObject3).setPath(((VFSFile)localObject2).getPath());
            ((FileInfo)localObject3).setSize(((VFSFile)localObject2).length());
            ((FileInfo)localObject3).setDate(((VFSFile)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label291;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new ahbj.a());
    for (;;)
    {
      return localArrayList;
      label291:
      Collections.sort(localArrayList, new ahat());
    }
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int j = 0;
    if (j < paramString.length)
    {
      localObject = paramString[j].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        j += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  private static void a(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (B(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      JI(paramString);
      return;
    }
    JI(kY(paramFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131694100));
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 20);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2130771991, 2130771992);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    agzy.a(paramFileManagerEntity).a(paramBoolean, paramContext, new ahbb(paramFileManagerEntity, paramQQAppInterface));
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nFileType == 13)
    {
      Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130845244);
      try
      {
        if (paramFileManagerEntity.strThumbPath == null)
        {
          paramImageView.setImageDrawable(localDrawable);
          return;
        }
        paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramFileManagerEntity.strThumbPath), localDrawable, localDrawable));
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
    }
    paramFileManagerEntity = ahbj.getExtension(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity == null)
    {
      paramImageView.setImageResource(2130845244);
      return;
    }
    paramImageView.setImageResource(r(paramFileManagerEntity));
  }
  
  private static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    String str2 = ahcb.bu(paramFileManagerEntity.srvTime);
    String str6 = e(paramFileManagerEntity);
    String str3 = ahbj.g(paramFileManagerEntity.fileSize);
    String str4 = f(paramFileManagerEntity);
    String str5 = BaseApplicationImpl.getContext().getString(2131693588);
    int k = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    String str1;
    float f;
    if (paramFileManagerEntity.nFileType == 13)
    {
      str1 = str2 + " " + str6 + " " + BaseApplicationImpl.getContext().getString(2131693542);
      f = localTextPaint.measureText(str1) + 30.0F;
      if (f >= k) {
        break label186;
      }
      paramTextView.setText(str1);
    }
    for (;;)
    {
      return;
      str1 = str2 + " " + str6 + str5 + str3 + str5 + str4;
      break;
      label186:
      if (f > k * 2)
      {
        j = 1;
        int m = str6.length();
        while (m - j > 0)
        {
          str1 = str6.substring(0, m - j);
          if (localTextPaint.measureText(str2 + str5 + str1 + UU + str5 + str3 + str5 + str4) + 30.0F < k * 2)
          {
            paramTextView.setVisibility(0);
            if (paramFileManagerEntity.nFileType == 13)
            {
              paramTextView.setText(str2 + " " + str6 + UU + " " + BaseApplicationImpl.getContext().getString(2131693542));
              return;
            }
            paramTextView.setText(str2 + str5 + str1 + UU + str5 + str3 + str5 + str4);
            return;
          }
          j += 1;
        }
        if (paramFileManagerEntity.nFileType == 13)
        {
          paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131693542));
          return;
        }
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
        return;
      }
      if (localTextPaint.measureText(str2 + str5 + str6) + 30.0F <= k) {
        break label801;
      }
      int j = 4;
      while (j <= str6.length())
      {
        str1 = str6.substring(0, j);
        if (localTextPaint.measureText(str2 + str5 + str1) + 30.0F > k)
        {
          str1 = str6.substring(0, j - 1);
          str6 = str6.replace(str1, "");
          if (paramFileManagerEntity.nFileType == 13) {
            paramTextView.setText(str2 + " " + str1 + "\n" + str6 + str5 + BaseApplicationImpl.getContext().getString(2131693542));
          }
          for (;;)
          {
            paramTextView.setVisibility(0);
            return;
            paramTextView.setText(str2 + str5 + str1 + "\n" + str6 + str5 + str3 + str5 + str4);
          }
        }
        j += 1;
      }
    }
    label801:
    if (localTextPaint.measureText(str2 + str5 + str6 + str5 + str3) + 30.0F > k)
    {
      if (paramFileManagerEntity.nFileType == 13) {
        paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131693542));
      }
      for (;;)
      {
        paramTextView.setVisibility(0);
        return;
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
      }
    }
    if (paramFileManagerEntity.nFileType == 13) {
      paramTextView.setText(str2 + " " + str6 + BaseApplicationImpl.getContext().getString(2131693542));
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      return;
      paramTextView.setText(str2 + str5 + str6 + str5 + str3 + str5 + str4);
    }
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = ahbj.getExtension(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130845244);
      label21:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (getFileType(str3) == 0)
    {
      if (!aqhq.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath)) {
        break label104;
      }
      str1 = paramDataLineMsgRecord.thumbPath;
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(r(str3));
      switch (getFileType(str3))
      {
      default: 
        int j = r(str3);
        if (j == 0) {
          break label21;
        }
        paramAsyncImageView.setImageResource(j);
        return;
        label104:
        str1 = str2;
        if (aqhq.fileExistsAndNotEmpty(paramDataLineMsgRecord.path)) {
          str1 = paramDataLineMsgRecord.path;
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(str1);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (eR == null))
    {
      eR = paramBaseActivity.getResources().getDrawable(2130839649);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(eR, null, null, null);
      ((Animatable)eR).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1;
          float f;
          int k;
          int j;
          int i2;
          int i3;
          continue;
          int m = 0;
          int n = 0;
          continue;
          long l2 = 0L;
          continue;
          long l1 = paramLong2;
        }
      }
      i1 = ahbr.getIPStackType();
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      localHashMap.put("param_ipStackType", String.valueOf(i1));
      localHashMap.put("param_realTransferType", String.valueOf(0));
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("param_transferTime", -1L);
        if (l1 >= 0L) {
          if ((l1 > 0L) && (paramLong3 >= 1024L))
          {
            f = (float)l1 / 1000.0F;
            l2 = ((float)paramLong3 / f);
            localHashMap.put("param_speed", String.valueOf(l2));
            k = 0;
            j = 0;
            i2 = ahbr.EL();
            i3 = ahbr.EM();
            if (paramBundle != null)
            {
              n = paramBundle.getInt("param_fromType", 0);
              k = paramBundle.getInt("param_V6SelectType", 0);
              j = paramBundle.getInt("param_ipAddrType", 0);
              m = paramBundle.getInt("param_ishttps", 0);
              localHashMap.put("param_fromType", String.valueOf(n));
              localHashMap.put("param_V6SelectType", String.valueOf(k));
              localHashMap.put("param_ipAddrType", String.valueOf(j));
              localHashMap.put("param_stackType", String.valueOf(i2));
              localHashMap.put("param_loginType", String.valueOf(i3));
              localHashMap.put("param_ishttps", String.valueOf(m));
              anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
              if (QLog.isColorLevel()) {
                QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "], ipStackType[" + String.valueOf(i1) + "] realTransferType[" + String.valueOf(0) + "] speed[" + String.valueOf(l2) + "] fromType[" + String.valueOf(n) + "] transferTime[" + String.valueOf(l1) + "] isHttps[" + String.valueOf(m) + "]");
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    long l1 = paramLong2;
    if (paramLong2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    if (l1 < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int k = 0;
          int j = k;
          if (paramString9 != null)
          {
            j = k;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label1033;
              }
              j = 1;
            }
          }
          for (;;)
          {
            if (aqiw.isNetSupport(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (j == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            int i1 = ahbr.getIPStackType();
            paramString2 = new HashMap();
            paramString2.put("serverip", String.valueOf(str1));
            paramString2.put("param_Server", String.valueOf(str1));
            paramString2.put("param_ftnIP", String.valueOf(str1));
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.getCurrentAccountUin() + "]"));
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            paramString2.put("param_ipStackType", String.valueOf(i1));
            paramString2.put("param_realTransferType", String.valueOf(0));
            if (paramBundle == null) {
              break label1095;
            }
            l2 = paramBundle.getLong("param_transferTime", -1L);
            if (l2 < 0L) {
              break label1095;
            }
            if ((l2 <= 0L) || (paramLong4 < 1024L)) {
              break label1089;
            }
            float f = (float)l2 / 1000.0F;
            l3 = ((float)paramLong4 / f);
            paramString2.put("param_speed", String.valueOf(l3));
            k = 0;
            j = 0;
            int i2 = ahbr.EL();
            int i3 = ahbr.EM();
            if (paramBundle == null) {
              break label1080;
            }
            n = paramBundle.getInt("param_fromType", 0);
            k = paramBundle.getInt("param_V6SelectType", 0);
            j = paramBundle.getInt("param_ipAddrType", 0);
            m = paramBundle.getInt("param_ishttps", 0);
            paramString2.put("param_fromType", String.valueOf(n));
            paramString2.put("param_V6SelectType", String.valueOf(k));
            paramString2.put("param_ipAddrType", String.valueOf(j));
            paramString2.put("param_stackType", String.valueOf(i2));
            paramString2.put("param_loginType", String.valueOf(i3));
            paramString2.put("param_ishttps", String.valueOf(m));
            anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "], ipStackType[" + String.valueOf(i1) + "] realTransferType[" + String.valueOf(0) + "] speed[" + String.valueOf(l3) + "], errMsg[" + String.valueOf(paramString9) + "] fromType[" + String.valueOf(n) + "] transferTime[" + String.valueOf(l2) + "] isHttps[" + String.valueOf(m) + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l1;
            break;
            label1033:
            if (paramString9.indexOf("No route to host") > 0)
            {
              j = 1;
            }
            else
            {
              j = k;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                j = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
          continue;
          label1080:
          int m = 0;
          int n = 0;
          continue;
          label1089:
          long l3 = 0L;
          continue;
          label1095:
          long l2 = paramLong2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {}
    while (!(paramChatMessage instanceof MessageForFile)) {
      return;
    }
    ahbr.a(paramQQAppInterface, paramContext, a(paramQQAppInterface, (MessageForFile)paramChatMessage));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label312:
    label314:
    label324:
    label466:
    do
    {
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                acff localacff = (acff)paramQQAppInterface.getManager(51);
                Object localObject = paramFileManagerEntity.peerUin;
                if (paramFileManagerEntity.peerType == 3000) {
                  localObject = paramFileManagerEntity.selfUin;
                }
                localObject = localacff.e((String)localObject);
                int j = -1;
                if (localObject != null) {
                  j = ((Friends)localObject).iTermType;
                }
                k = getFileType(paramFileManagerEntity.fileName);
                if (k == 0) {
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] PicFile, from device[" + j + "] size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
                for (;;)
                {
                  if ((!agmx.alL()) && (amK())) {
                    break label312;
                  }
                  if (k != 0) {
                    break label466;
                  }
                  if (!ahbh.u(paramFileManagerEntity)) {
                    break label324;
                  }
                  paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
                  return;
                  if (k != 2) {
                    break label314;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] VideoFile, from device[" + j + "] Preload VideoThumb size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
              }
              QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
              return;
              paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 5);
              if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] Preload 384 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
              }
            } while (amK());
            paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
          } while (!QLog.isColorLevel());
          QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
          return;
        } while (k != 2);
        if (paramFileManagerEntity.peerType != 3000) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(paramFileManagerEntity);
      } while (paramQQAppInterface == null);
      paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
      return;
      paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity);
    } while (paramQQAppInterface == null);
    paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, ti());
      }
      return;
    }
    int j = (int)H(paramFileManagerEntity.peerType);
    QLog.i("FileManagerUtil<FileAssistant>", 2, "=_= Id[" + paramFileManagerEntity.nSessionId + "],setTempParam[" + j + "]");
    paramFileManagerEntity.tmpSessionType = j;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, j);
    switch (j)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    paramMessageForFile.uniseq = paramChatMessage.uniseq;
    paramMessageForFile.msgseq = paramChatMessage.msgseq;
    paramMessageForFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    String str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForTroopFile paramMessageForTroopFile)
  {
    paramMessageForTroopFile.uniseq = paramChatMessage.uniseq;
    paramMessageForTroopFile.msgseq = paramChatMessage.msgseq;
    paramMessageForTroopFile.url = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
    paramMessageForTroopFile.uuid = UUID.nameUUIDFromBytes(paramMessageForTroopFile.url.getBytes()).toString();
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.bisID = Integer.parseInt(str1);
    }
    paramMessageForTroopFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    String str2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      paramMessageForTroopFile.width = Integer.parseInt(str1);
      paramMessageForTroopFile.height = Integer.parseInt(str2);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.duration = Integer.parseInt(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = c();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.Oj(3);
    localForwardFileInfo.setType(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.akM());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, ahav.f paramf)
  {
    ahav.a.getExecutor().execute(new FileManagerUtil.20(paramFileManagerEntity, paramf, paramQQAppInterface));
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = d().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.a().v(localFileManagerEntity);
    paramQQAppInterface = ahhq.a(localFileManagerEntity);
    paramQQAppInterface.setType(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", 0);
    paramFileManagerEntity.putParcelable("fileinfo", paramQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtras(paramFileManagerEntity);
    paramQQAppInterface.putExtra("destroy_last_activity", true);
    paramQQAppInterface.putExtra("forward_type", 0);
    paramQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramQQAppInterface.putExtra("forward_text", acfp.m(2131706260) + kY(localFileManagerEntity.fileName) + acfp.m(2131706253) + ahbj.g(localFileManagerEntity.fileSize) + "。");
    paramQQAppInterface.putExtra("k_favorites", q(localFileManagerEntity));
    if (((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramQQAppInterface.putExtra("forward_type", 1);
    }
    ahgq.f(paramActivity, paramQQAppInterface, 103);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    H(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new FileManagerUtil.1(paramFileManagerEntity));
        continue;
        if (paramFileManagerEntity.nFileType == 2)
        {
          if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
            str = paramFileManagerEntity.strLargeThumPath;
          } else if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
            str = paramFileManagerEntity.strMiddleThumPath;
          } else {
            str = null;
          }
        }
        else if (paramFileManagerEntity.nFileType == 13) {
          str = aobw.nW(paramFileManagerEntity.Uuid);
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramAsyncImageView.setDefaultImage(hL(paramInt));
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130845173);
          paramAsyncImageView.setAsyncImage(paramString);
          return;
          paramAsyncImageView.setDefaultImage(2130845117);
        } while (!ahbj.fileExistsAndNotEmpty(paramString));
        paramAsyncImageView.setApkIconAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130845245);
      } while (!ahbj.fileExistsAndNotEmpty(paramString));
      try
      {
        paramAsyncImageView.setAsyncImage(paramString);
        return;
      }
      catch (Exception paramAsyncImageView)
      {
        paramAsyncImageView.printStackTrace();
        return;
      }
    }
    paramAsyncImageView.setDefaultImage(2130845244);
    paramAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = ahbj.getExtension(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130845244);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(r(paramString));
    } while (!paramBoolean);
    switch (getFileType(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130845173);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130845245);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ahav.b paramb)
  {
    ThreadManager.post(new FileManagerUtil.12(paramString, paramInt3, paramBoolean, paramb, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, ahal.a parama, int paramInt)
  {
    int k = 2131693832;
    int m = 2;
    if (!aqiw.bW(BaseApplicationImpl.getContext())) {
      ahao.OS(2131694663);
    }
    Object localObject;
    int j;
    boolean bool1;
    label92:
    do
    {
      return;
      if (!amK())
      {
        parama.aD();
        return;
      }
      localObject = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      j = 3;
      boolean bool2 = aqux.a((Activity)localObject, j, new ahaz(parama), "");
      bool1 = bool2;
      if (bool2)
      {
        localObject = (Activity)paramContext;
        if (!paramBoolean) {
          break label185;
        }
        j = m;
        bool1 = armm.a((Activity)localObject, j, new ahba(parama));
      }
    } while (!bool1);
    if ((paramInt == 0) && (aequ.d().a.enable) && (!aqvn.a().pz()))
    {
      if (paramBoolean) {}
      for (paramInt = 2131693832;; paramInt = 2131693828)
      {
        localObject = paramContext.getString(paramInt);
        ahal.a(paramContext, paramContext.getString(2131693826), aequ.d().a.a(paramContext, (CharSequence)localObject), parama);
        return;
        j = 2;
        break;
        label185:
        j = 1;
        break label92;
      }
    }
    if (paramBoolean) {}
    for (paramInt = k;; paramInt = 2131693828)
    {
      ahal.a(paramContext, 2131693826, paramInt, parama);
      return;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1, paramTimeZone) == a(paramLong2, paramTimeZone));
  }
  
  public static boolean a(agsd paramagsd)
  {
    int j = paramagsd.getCloudType();
    int k = paramagsd.bF();
    String str = paramagsd.getUuid();
    paramagsd = paramagsd.getFileId();
    return (j == 3) && (k == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramagsd)));
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return (bm(paramContext)) && ((paramFileManagerEntity.fileSize > d(((BaseFileAssistantActivity)paramContext).app, paramFileManagerEntity.fileName)) || (!aZ(paramFileManagerEntity.fileName, ((BaseFileAssistantActivity)paramContext).bGo)) || ((!agmz.b(paramFileManagerEntity)) && (agmz.db().size() != 0)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, agsd paramagsd, boolean paramBoolean)
  {
    paramQQAppInterface = agmx.j(paramQQAppInterface.getApplication().getBaseContext(), paramagsd.getFileName(), "PreviewMode");
    int k = -1;
    int j = k;
    if (paramQQAppInterface != null)
    {
      j = k;
      if (paramQQAppInterface.length() > 0)
      {
        j = k;
        try
        {
          k = Integer.parseInt(paramQQAppInterface);
          j = k;
          int m = paramagsd.bF();
          j = k;
          if (m == 16) {
            return false;
          }
        }
        catch (NumberFormatException paramQQAppInterface) {}
      }
    }
    boolean bool = jP(j);
    if (paramBoolean)
    {
      if ((bool) && (aqiw.isNetSupport(BaseApplicationImpl.getContext()))) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a(paramQQAppInterface, paramChatMessage, paramContext, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {
      return false;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return false;
    }
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = a(paramQQAppInterface, localMessageForFile);
    switch (localFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      return false;
    case 1: 
      if (paramChatMessage.isSend()) {}
      for (paramChatMessage = paramQQAppInterface.getCurrentAccountUin();; paramChatMessage = localMessageForFile.frienduin)
      {
        if (!paramBoolean) {
          ahao.JG(paramContext.getString(2131694101));
        }
        paramQQAppInterface.a().a(localFileManagerEntity, paramChatMessage);
        paramQQAppInterface.a().u(localFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] No reInit,Show Juhua");
        }
        paramChatMessage = new ahau.a();
        paramChatMessage.bJE = "file_to_weiyun";
        paramChatMessage.cYX = 9;
        paramChatMessage.nFileSize = localFileManagerEntity.fileSize;
        paramChatMessage.bJF = ahbj.getExtension(localFileManagerEntity.fileName);
        ahau.a(paramQQAppInterface.getCurrentAccountUin(), paramChatMessage);
        return true;
      }
    case 2: 
      return false;
    }
    if (!paramBoolean) {
      ahao.JG(paramContext.getString(2131694101));
    }
    awou.eEJ();
    paramQQAppInterface.a().a(localFileManagerEntity.getFilePath(), null, paramQQAppInterface.getAccount(), 0, false);
    paramQQAppInterface.a().u(localFileManagerEntity);
    if (QLog.isColorLevel()) {
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] reInit");
    }
    return true;
  }
  
  public static boolean a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      return false;
    }
    String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 4))
    {
      QQToast.a(paramContext, 2131693837, 0).show();
      return false;
    }
    paramChatMessage = ajlg.c(paramQQAppInterface, paramChatMessage);
    if ((paramChatMessage != null) && (paramChatMessage.extraflag == 32768))
    {
      QQToast.a(paramContext, 2131693836, 0).show();
      return false;
    }
    return true;
  }
  
  private static boolean a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if ((paramFileManagerEntity1.Uuid != null) && (paramFileManagerEntity1.Uuid.equals(paramFileManagerEntity2.Uuid))) {}
    while (((paramFileManagerEntity2.strFileSHA != null) && (paramFileManagerEntity2.strFileSHA.equals(paramFileManagerEntity1.strFileSHA))) || ((paramFileManagerEntity2.strFileMd5 != null) && ((paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.strFileMd5)) || (paramFileManagerEntity2.strFileMd5.equals(paramFileManagerEntity1.str10Md5)))) || ((paramFileManagerEntity2.strTroopFileSha1 != null) && (paramFileManagerEntity2.strTroopFileSha1.equals(paramFileManagerEntity1.strTroopFileSha1))) || ((paramFileManagerEntity2.strFileSha3 != null) && (paramFileManagerEntity2.strFileSha3.equals(paramFileManagerEntity1.strFileSha3))) || ((paramFileManagerEntity2.str10Md5 != null) && (paramFileManagerEntity2.str10Md5.equals(paramFileManagerEntity1.str10Md5)))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L; paramArrayList.hasNext(); l += l) {
      if (agzy.a((FileManagerEntity)paramArrayList.next()).bd(paramBoolean)) {
        return true;
      }
    }
    return l > agmx.fJ();
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().T(paramString);
    case 127: 
      return paramQQAppInterface.a().R(paramString);
    case 102: 
      return paramQQAppInterface.a().M(paramString);
    case 109: 
      return paramQQAppInterface.a().W(paramString);
    }
    return paramQQAppInterface.a().K(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 91	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 2760
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 2766	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 2767	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 2760
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   58: ldc 121
    //   60: iconst_1
    //   61: new 123	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 2769
    //   71: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: invokevirtual 2770	java/io/IOException:toString	()Ljava/lang/String;
    //   78: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_3
    //   95: ldc 121
    //   97: iconst_1
    //   98: new 123	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 2772
    //   108: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 5
    //   113: invokevirtual 2770	java/io/IOException:toString	()Ljava/lang/String;
    //   116: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 6
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull -85 -> 44
    //   132: aload_0
    //   133: invokevirtual 2767	java/io/FileInputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   143: ldc 121
    //   145: iconst_1
    //   146: new 123	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2769
    //   156: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 2770	java/io/IOException:toString	()Ljava/lang/String;
    //   163: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 2767	java/io/FileInputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_3
    //   188: aload_3
    //   189: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   192: ldc 121
    //   194: iconst_1
    //   195: new 123	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 2769
    //   205: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_3
    //   209: invokevirtual 2770	java/io/IOException:toString	()Ljava/lang/String;
    //   212: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto -36 -> 185
    //   224: astore_0
    //   225: goto -48 -> 177
    //   228: astore 5
    //   230: aload 4
    //   232: astore_0
    //   233: goto -140 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   0	236	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	22	3	localIOException1	IOException
    //   94	88	3	localObject2	Object
    //   187	22	3	localIOException2	IOException
    //   11	220	4	localFileInputStream	java.io.FileInputStream
    //   89	23	5	localIOException3	IOException
    //   228	1	5	localIOException4	IOException
    //   1	125	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	89	java/io/IOException
    //   132	136	138	java/io/IOException
    //   3	13	174	finally
    //   181	185	187	java/io/IOException
    //   24	30	224	finally
    //   95	125	224	finally
    //   24	30	228	java/io/IOException
  }
  
  /* Error */
  private static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 89	java/io/BufferedInputStream
    //   5: dup
    //   6: new 91	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_1
    //   26: invokestatic 87	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_1
    //   30: aload_0
    //   31: aload 4
    //   33: invokevirtual 111	java/io/InputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: ifle +39 -> 77
    //   41: aload_1
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   49: goto -19 -> 30
    //   52: astore_1
    //   53: aload_3
    //   54: astore_1
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokevirtual 149	java/io/InputStream:close	()V
    //   63: aload_3
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 2776	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -44 -> 30
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 149	java/io/InputStream:close	()V
    //   85: aload_1
    //   86: ifnull +25 -> 111
    //   89: aload_1
    //   90: invokevirtual 146	java/security/MessageDigest:digest	()[B
    //   93: astore_1
    //   94: aload_1
    //   95: astore_3
    //   96: aload_3
    //   97: astore_1
    //   98: aload_0
    //   99: ifnull -34 -> 65
    //   102: aload_0
    //   103: invokevirtual 149	java/io/InputStream:close	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore_0
    //   109: aload_3
    //   110: areturn
    //   111: aload_3
    //   112: astore_1
    //   113: aload_0
    //   114: ifnull -49 -> 65
    //   117: aload_0
    //   118: invokevirtual 149	java/io/InputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: aload_0
    //   132: ifnull -67 -> 65
    //   135: aload_0
    //   136: invokevirtual 149	java/io/InputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 149	java/io/InputStream:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore 4
    //   159: goto -74 -> 85
    //   162: astore_0
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: goto -11 -> 155
    //   169: astore_1
    //   170: goto -23 -> 147
    //   173: astore_1
    //   174: goto -45 -> 129
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_0
    //   180: goto -127 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString1	String
    //   0	183	1	paramString2	String
    //   36	10	2	j	int
    //   1	129	3	str	String
    //   23	20	4	arrayOfByte	byte[]
    //   157	1	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	52	java/io/FileNotFoundException
    //   25	30	52	java/io/FileNotFoundException
    //   30	37	52	java/io/FileNotFoundException
    //   41	49	52	java/io/FileNotFoundException
    //   68	72	52	java/io/FileNotFoundException
    //   81	85	52	java/io/FileNotFoundException
    //   89	94	52	java/io/FileNotFoundException
    //   25	30	67	java/security/NoSuchAlgorithmException
    //   102	106	108	java/io/IOException
    //   117	121	123	java/io/IOException
    //   2	18	126	java/io/IOException
    //   135	139	141	java/io/IOException
    //   2	18	144	finally
    //   81	85	157	java/io/IOException
    //   59	63	162	java/io/IOException
    //   151	155	165	java/io/IOException
    //   18	25	169	finally
    //   25	30	169	finally
    //   30	37	169	finally
    //   41	49	169	finally
    //   68	72	169	finally
    //   81	85	169	finally
    //   89	94	169	finally
    //   18	25	173	java/io/IOException
    //   25	30	173	java/io/IOException
    //   30	37	173	java/io/IOException
    //   41	49	173	java/io/IOException
    //   68	72	173	java/io/IOException
    //   89	94	173	java/io/IOException
    //   2	18	177	java/io/FileNotFoundException
  }
  
  public static int aC(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 11: 
    case 13: 
    default: 
      return 2130845244;
    case 2: 
      return 2130845245;
    case 0: 
      return 2130845173;
    case 1: 
      return 2130845188;
    case 3: 
      return 2130845138;
    case 4: 
      return 2130845256;
    case 6: 
      return 2130845255;
    case 5: 
      return 2130845117;
    case 7: 
      return 2130845203;
    case 8: 
      return 2130845146;
    case 9: 
      return 2130845201;
    case 10: 
      return 2130845233;
    case 12: 
      return 2130845210;
    case 14: 
      return 2130845115;
    case 15: 
      return 2130845144;
    case 16: 
      return 2130845164;
    case 17: 
      return 2130845174;
    case 18: 
      return 2130845197;
    case 19: 
      return 2130845198;
    case 20: 
      return 2130845199;
    }
    return 2130845218;
  }
  
  private static String aW(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public static boolean aZ(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return false;
      } while ((paramString2 == null) || (TextUtils.isEmpty(paramString2)));
      paramString1 = ahbj.getExtension(paramString1);
    } while ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.indexOf(paramString1.toLowerCase()) < 0));
    return true;
  }
  
  public static String al(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.getBytes().length < paramInt)) {
      return "";
    }
    int k = paramInt / 2;
    int j = paramInt / 4;
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfChar.length)
    {
      localStringBuilder1.append(arrayOfChar[paramInt]);
      if (localStringBuilder1.toString().getBytes().length <= k) {}
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      k = arrayOfChar.length;
      paramInt = arrayOfChar.length - 1;
      label93:
      if (paramInt <= 0) {
        break label167;
      }
      localStringBuilder2.append(arrayOfChar[paramInt]);
      if (localStringBuilder2.toString().getBytes().length <= j) {
        break label160;
      }
    }
    for (;;)
    {
      return localStringBuilder1.toString() + UU + paramString.substring(paramInt);
      paramInt += 1;
      break;
      label160:
      paramInt -= 1;
      break label93;
      label167:
      paramInt = k - 1;
    }
  }
  
  public static boolean amK()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean ax(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile)) {}
    while ((paramMessageRecord instanceof MessageForTroopFile)) {
      return true;
    }
    return false;
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    int m = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = m;
      if (paramFileManagerEntity.bSend)
      {
        k = m;
        if (8 != paramFileManagerEntity.nOpType)
        {
          k = m;
          if (5 != paramFileManagerEntity.nOpType)
          {
            k = m;
            if (1 != paramFileManagerEntity.nOpType) {
              k = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((k != 0) && ((k == 0) || (j == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (k != 0) && (j == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  public static int b(List<FileInfo> paramList, long paramLong)
  {
    int j = 0;
    int k = paramList.size() - 1;
    int m = j;
    if (j <= k)
    {
      m = j + k >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(m);
      if (localFileInfo.getDate() > paramLong)
      {
        m += 1;
        j = k;
        k = m;
      }
      for (;;)
      {
        m = k;
        k = j;
        j = m;
        break;
        if (localFileInfo.getDate() >= paramLong) {
          break label103;
        }
        m -= 1;
        k = j;
        j = m;
      }
    }
    label103:
    return m;
  }
  
  public static ahbm b(QQAppInterface paramQQAppInterface)
  {
    return new ahay(paramQQAppInterface);
  }
  
  public static FileManagerEntity b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity1 = new FileManagerEntity();
    localFileManagerEntity1.nSessionId = d().longValue();
    localFileManagerEntity1.WeiYunFileId = paramWeiYunFileInfo.bIk;
    localFileManagerEntity1.fileName = paramWeiYunFileInfo.strFileName;
    localFileManagerEntity1.fileSize = paramWeiYunFileInfo.nFileSize;
    localFileManagerEntity1.nFileType = getFileType(paramWeiYunFileInfo.strFileName);
    localFileManagerEntity1.strThumbPath = paramWeiYunFileInfo.bIz;
    localFileManagerEntity1.setCloudType(2);
    localFileManagerEntity1.nWeiYunSrcType = paramWeiYunFileInfo.cYi;
    if (localFileManagerEntity1.nWeiYunSrcType == 2) {
      localFileManagerEntity1.strLargeThumPath = paramWeiYunFileInfo.encodeUrl;
    }
    localFileManagerEntity1.lastTime = paramWeiYunFileInfo.mtime;
    localFileManagerEntity1.bSend = false;
    localFileManagerEntity1.status = -1;
    localFileManagerEntity1.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity1.strFileMd5 = paramWeiYunFileInfo.md5;
    localFileManagerEntity1.WeiYunDirKey = paramWeiYunFileInfo.dirKey;
    localFileManagerEntity1.strFileSHA = paramWeiYunFileInfo.sha;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity2 = localQQAppInterface.a().d(paramWeiYunFileInfo.bIk);
    if (localFileManagerEntity2 != null)
    {
      localFileManagerEntity1.imgWidth = localFileManagerEntity2.imgWidth;
      localFileManagerEntity1.imgHeight = localFileManagerEntity2.imgHeight;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity1.nSessionId + "] fileName[" + paramWeiYunFileInfo.strFileName + "] by WeiYun size(" + localFileManagerEntity1.imgHeight + ":" + localFileManagerEntity1.imgWidth + ")");
    localQQAppInterface.a().v(localFileManagerEntity1);
    return localFileManagerEntity1;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = getFileType(paramQQAppInterface.getFilePath());
    }
    paramMessageRecord = ek(paramQQAppInterface.nFileType);
    return "[" + paramMessageRecord + "]" + paramQQAppInterface.fileName;
  }
  
  public static void b(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramTextView.getMeasuredWidth() == 0)
    {
      paramTextView.post(new FileManagerUtil.8(paramTextView, paramFileManagerEntity));
      return;
    }
    a(paramTextView, paramFileManagerEntity);
  }
  
  public static void b(@NonNull QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.17(paramContext, paramInt, paramString1, paramQQAppInterface, paramString2), 2, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    int j = anpb.g(paramContext, paramString, "Stop_download_2-1_3-1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "1", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Stop_download_2-1_3-0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "1", "0", null, null);
    }
    j = anpb.g(paramContext, paramString, "Stop_download_2-2_3-1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "2", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Stop_download_2-2_3-0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "2", "0", null, null);
    }
    j = anpb.g(paramContext, paramString, "Start_download_2-0_3-1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, j, 0, "0", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Start_download_2-0_3-0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, j, 0, "0", "0", null, null);
    }
    j = anpb.g(paramContext, paramString, "Start_download_2-3_3-1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, j, 0, "3", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Start_download_2-3_3-0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, j, 0, "3", "0", null, null);
    }
    j = anpb.g(paramContext, paramString, "Complete_download_2_1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, j, 0, "0", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Stop_download_2-0_3-1");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "0", "1", null, null);
    }
    j = anpb.g(paramContext, paramString, "Complete_download_2_0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, j, 0, "0", null, null, null);
    }
    j = anpb.g(paramContext, paramString, "Stop_download_2-0_3-0");
    if (j > 0) {
      anot.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, j, 0, "0", "0", null, null);
    }
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    H(paramFileManagerEntity);
    if (paramFileManagerEntity.nFileType == 0)
    {
      String str2 = paramFileManagerEntity.strLargeThumPath;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = g(paramFileManagerEntity);
      }
      if (aqhq.fileExistsAndNotEmpty(str1))
      {
        paramFileManagerEntity.strLargeThumPath = str1;
        paramAsyncImageView.setDefaultImage(2130845173);
        paramAsyncImageView.setAsyncImage(str1);
        return;
      }
    }
    b(paramAsyncImageView, paramFileManagerEntity.fileName);
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    int j = getFileType(paramString);
    try
    {
      paramAsyncImageView.setImageResource(hL(j));
      return;
    }
    catch (Exception paramAsyncImageView)
    {
      paramAsyncImageView.printStackTrace();
    }
  }
  
  public static void b(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      long l1 = 0L;
      do
      {
        l2 = l1;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (FileManagerEntity)paramList.next();
      } while (((FileManagerEntity)localObject).sendCloudUnsuccessful());
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(10001);
      localForwardFileInfo.Oj(((FileManagerEntity)localObject).getCloudType());
      localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.setFileName(((FileManagerEntity)localObject).fileName);
      localForwardFileInfo.jB(((FileManagerEntity)localObject).uniseq);
      localForwardFileInfo.setFileId(((FileManagerEntity)localObject).WeiYunFileId);
      localForwardFileInfo.setFileSize(((FileManagerEntity)localObject).fileSize);
      localForwardFileInfo.setLocalPath(((FileManagerEntity)localObject).getFilePath());
      localForwardFileInfo.setUuid(((FileManagerEntity)localObject).Uuid);
      localForwardFileInfo.forwardID = wte.a().we();
      if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
      }
      for (;;)
      {
        l2 = localForwardFileInfo.getFileSize();
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        localArrayList2.add(Uri.parse(""));
      }
    }
    long l2 = 0L;
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", 0);
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", 0);
    paramList = acfp.m(2131706274);
    if (localArrayList1.size() == 1) {
      paramList = acfp.m(2131706255) + kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + acfp.m(2131706265) + ahbj.g(((ForwardFileInfo)localArrayList1.get(0)).getFileSize()) + "。";
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("forward_text", paramList);
      ((Intent)localObject).putExtra("k_favorites", false);
      ahgq.f(paramActivity, (Intent)localObject, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramList = acfp.m(2131706249) + kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + acfp.m(2131706262) + localArrayList1.size() + acfp.m(2131706266) + ahbj.g(l2) + "。";
      }
    }
  }
  
  public static void b(boolean paramBoolean, Context paramContext, ahal.a parama)
  {
    a(paramBoolean, paramContext, parama, -1);
  }
  
  public static boolean b(agsd paramagsd)
  {
    int j = paramagsd.getCloudType();
    int k = paramagsd.bF();
    return (j == 3) && (k == 1);
  }
  
  public static boolean b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = agmx.j(paramContext, paramString, "FileMaxSize");
    if (paramContext == null) {}
    while (Integer.parseInt(paramContext) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean b(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    boolean bool1 = true;
    if (paramVFSFile2.exists()) {
      bool1 = paramVFSFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramVFSFile1.renameTo(paramVFSFile2);
    }
    return bool2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, agsd paramagsd, boolean paramBoolean)
  {
    boolean bool = true;
    FileManagerEntity localFileManagerEntity = paramagsd.b();
    if (localFileManagerEntity == null) {
      return false;
    }
    int j;
    int k;
    label63:
    int m;
    label100:
    int n;
    label112:
    int i1;
    if ((a(paramQQAppInterface, paramagsd, paramBoolean)) && (!localFileManagerEntity.isZipInnerFile))
    {
      j = 1;
      if ((paramagsd.DW() == 6000) || (paramagsd.getCloudType() == 7)) {
        break label159;
      }
      k = 1;
      if ((paramagsd.getCloudType() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null)) {
        break label165;
      }
      m = 1;
      if (paramagsd.getCloudType() == 0) {
        break label171;
      }
      n = 1;
      if (paramagsd.getCloudType() == 5) {
        break label177;
      }
      i1 = 1;
      label125:
      if ((j == 0) || (k == 0) || (m == 0) || (n == 0) || (i1 == 0)) {
        break label183;
      }
    }
    label159:
    label165:
    label171:
    label177:
    label183:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      j = 0;
      break;
      k = 0;
      break label63;
      m = 0;
      break label100;
      n = 0;
      break label112;
      i1 = 0;
      break label125;
    }
  }
  
  public static long bA()
  {
    int j = amzo.seq;
    amzo.seq = j + 1;
    return (short)(int)((int)(j & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static boolean ba(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static List<MessageRecord> bg(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (ax(localMessageRecord)) {
        localArrayList.add(e((ChatMessage)localMessageRecord));
      } else {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public static boolean bm(Context paramContext)
  {
    return (paramContext != null) && ((paramContext instanceof BaseFileAssistantActivity)) && (((BaseFileAssistantActivity)paramContext).ccF);
  }
  
  public static void by(Context paramContext, String paramString)
  {
    if (!new VFSFile(paramString).exists())
    {
      ahao.h(paramContext, 0, 2131694147);
      return;
    }
    ThreadManager.post(new FileManagerUtil.2(paramString, paramContext), 8, null, true);
  }
  
  public static void bz(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    String str = aobw.bD("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("url", str);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!TeamWorkDocEditBrowserActivity.g(paramContext, str, localIntent.getStringExtra("tdsourcetag"))) {
      wgv.c(paramContext, localIntent, paramString);
    }
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static FileManagerEntity c()
  {
    Object localObject3 = agmz.db();
    Object localObject2 = agmz.D();
    Object localObject1 = agmz.dd();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).getType() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (getFileType(((WeiYunFileInfo)localObject2).strFileName) == 0) {
          return b((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {}
    while ((TextUtils.isEmpty(paramChatMessage.senderuin)) || (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    return true;
  }
  
  @TargetApi(9)
  public static int cZ(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      j = -1;
    }
    Object localObject;
    do
    {
      return j;
      localObject = ahbj.getFileDirectoryOf(paramString);
    } while (wc().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static int d(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static long d(QQAppInterface paramQQAppInterface, String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return 0L;
        }
        paramQQAppInterface = lb(paramString);
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label162;
        }
        l = 20971520L;
        if ("txt".equals(paramQQAppInterface.toLowerCase())) {
          l = 102400L;
        }
        paramString = aeuc.a().uc();
        if (TextUtils.isEmpty(paramString)) {
          return l;
        }
        paramString = paramString.split("#");
        if (paramString.length != 0) {
          break label164;
        }
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        long l;
        String[] arrayOfString;
        QLog.e("FileManagerUtil<FileAssistant>", 1, " get docs import file max size exception =" + paramQQAppInterface.toString());
      }
      if (j < paramString.length)
      {
        arrayOfString = paramString[j].split("_");
        if ((arrayOfString[0].contains(paramQQAppInterface)) || (arrayOfString[0].contains(paramQQAppInterface.toLowerCase())))
        {
          l = Long.parseLong(arrayOfString[1]);
          return l;
        }
        j += 1;
      }
      else
      {
        label162:
        return 0L;
        label164:
        j = 0;
      }
    }
  }
  
  public static Long d()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.uniseq));
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.fProgress);
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgSeq));
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgUid));
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgTime));
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(kZ(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(kZ(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], WeiYunDirKey[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("], bOnceSuccess[");
        localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
        localStringBuilder.append("], imgHeight[");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("], imgWidth[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  public static int da(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      j = -1;
    }
    Object localObject;
    do
    {
      return j;
      localObject = ahbj.getFileDirectoryOf(paramString);
    } while (wc().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  private static int db(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 4;
      if (paramString.equalsIgnoreCase("com.tencent.mtt")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("send_to_wx")) {
        return 2;
      }
    } while (!paramString.equalsIgnoreCase("cn.wps.moffice_eng"));
    return 3;
  }
  
  public static int dc(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static void dkT()
  {
    ThreadManager.post(new FileManagerUtil.3(), 8, null, false);
  }
  
  public static void dkU()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = localQQAppInterface.a().eU();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        localQQAppInterface.a().b(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc, localFileManagerEntity.bSend);
      }
    }
    localQQAppInterface.a().dis();
  }
  
  public static int e(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        int j = getFileType(paramChatMessage);
        if ((j == 2) || (j == 0)) {
          return j;
        }
      }
    }
    return -1;
  }
  
  public static ChatMessage e(ChatMessage paramChatMessage)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    if (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((ahbr.ay(paramChatMessage)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int k = Integer.parseInt((String)localObject2);
        if (k == 3)
        {
          localObject1 = (ChatMessage)anbi.d(-2017);
          ((ChatMessage)localObject1).isMultiMsg = paramChatMessage.isMultiMsg;
          ((ChatMessage)localObject1).isReplySource = paramChatMessage.isReplySource;
          ((ChatMessage)localObject1).selfuin = paramChatMessage.selfuin;
          ((ChatMessage)localObject1).shmsgseq = paramChatMessage.shmsgseq;
          ((ChatMessage)localObject1).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          ((ChatMessage)localObject1).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          a(paramChatMessage, (MessageForTroopFile)localObject1);
          ((MessageForTroopFile)localObject1).istroop = 1;
        }
        for (;;)
        {
          paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
          if (!TextUtils.isEmpty(paramChatMessage)) {
            ((ChatMessage)localObject1).saveExtInfoToExtStr("_m_ForwardFileStatus", paramChatMessage);
          }
          return localObject1;
          if ((k == 1) || (k == 2))
          {
            if (k == 1) {}
            for (int j = -2005;; j = -2014)
            {
              localObject2 = (ChatMessage)anbi.d(j);
              ((ChatMessage)localObject2).isMultiMsg = paramChatMessage.isMultiMsg;
              ((ChatMessage)localObject2).isReplySource = paramChatMessage.isReplySource;
              ((ChatMessage)localObject2).selfuin = paramChatMessage.selfuin;
              ((ChatMessage)localObject2).shmsgseq = paramChatMessage.shmsgseq;
              ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
              ((ChatMessage)localObject2).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
              a(paramChatMessage, (MessageForFile)localObject2);
              if (localObject1 == null) {
                break label286;
              }
              ahbr.a((QQAppInterface)localObject1, (MessageRecord)localObject2, paramChatMessage);
              localObject1 = localObject2;
              break;
            }
            label286:
            if (k == 1)
            {
              ((ChatMessage)localObject2).istroop = 0;
              ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              if (k == 2)
              {
                ((ChatMessage)localObject2).istroop = 3000;
                localObject1 = localObject2;
              }
            }
          }
          else
          {
            localObject1 = paramChatMessage;
          }
        }
      }
      return paramChatMessage;
    }
  }
  
  /* Error */
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: invokestatic 179	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 5
    //   5: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   8: invokevirtual 3308	java/util/HashMap:size	()I
    //   11: ifne +479 -> 490
    //   14: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   17: iconst_1
    //   18: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aload 5
    //   23: ldc_w 3312
    //   26: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   29: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   36: bipush 9
    //   38: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aload 5
    //   43: ldc_w 3312
    //   46: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   49: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   56: bipush 10
    //   58: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aload 5
    //   63: ldc_w 3312
    //   66: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   69: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   76: bipush 11
    //   78: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aload 5
    //   83: ldc_w 3312
    //   86: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   89: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   96: bipush 12
    //   98: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aload 5
    //   103: ldc_w 3312
    //   106: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   109: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   116: bipush 13
    //   118: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aload 5
    //   123: ldc_w 3312
    //   126: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   129: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   136: bipush 6
    //   138: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aload 5
    //   143: ldc_w 3313
    //   146: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   149: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   156: iconst_4
    //   157: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aload 5
    //   162: ldc_w 3313
    //   165: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   168: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   175: bipush 20
    //   177: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aload 5
    //   182: ldc_w 3313
    //   185: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   188: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   195: bipush 22
    //   197: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aload 5
    //   202: ldc_w 3314
    //   205: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   208: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   215: bipush 21
    //   217: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aload 5
    //   222: ldc_w 3314
    //   225: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   228: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   235: iconst_0
    //   236: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aload 5
    //   241: ldc_w 3314
    //   244: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   247: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   254: bipush 7
    //   256: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aload 5
    //   261: ldc_w 3314
    //   264: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   267: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   274: iconst_3
    //   275: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aload 5
    //   280: ldc_w 3314
    //   283: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   286: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   293: bipush 24
    //   295: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: aload 5
    //   300: ldc_w 3314
    //   303: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   306: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   313: iconst_5
    //   314: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aload 5
    //   319: ldc_w 3315
    //   322: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   325: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   332: bipush 14
    //   334: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: aload 5
    //   339: ldc_w 3316
    //   342: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   345: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: pop
    //   349: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   352: bipush 15
    //   354: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aload 5
    //   359: ldc_w 3317
    //   362: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   365: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   372: bipush 16
    //   374: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aload 5
    //   379: ldc_w 3318
    //   382: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   385: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   388: pop
    //   389: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   392: bipush 17
    //   394: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aload 5
    //   399: ldc_w 3319
    //   402: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   405: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   408: pop
    //   409: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   412: bipush 18
    //   414: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   417: aload 5
    //   419: ldc_w 3320
    //   422: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   425: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   432: bipush 19
    //   434: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   437: aload 5
    //   439: ldc_w 3321
    //   442: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   445: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: pop
    //   449: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   452: sipush 190
    //   455: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aload 5
    //   460: ldc_w 3322
    //   463: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   466: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   469: pop
    //   470: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   473: bipush 40
    //   475: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   478: aload 5
    //   480: ldc_w 3323
    //   483: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   486: invokevirtual 2141	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: pop
    //   490: getstatic 62	ahav:kR	Ljava/util/HashMap;
    //   493: aload_0
    //   494: getfield 402	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   497: invokestatic 3311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: invokevirtual 3326	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast 45	java/lang/String
    //   506: astore_1
    //   507: aload_0
    //   508: getfield 402	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   511: lookupswitch	default:+73->584, -1:+636->1147, 0:+589->1100, 3:+589->1100, 7:+589->1100, 8:+636->1147, 21:+589->1100, 22:+589->1100, 24:+589->1100
    //   585: invokevirtual 390	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   588: ifne +12 -> 600
    //   591: aload 5
    //   593: ldc_w 3312
    //   596: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   599: astore_1
    //   600: aload_0
    //   601: invokevirtual 390	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   604: iconst_5
    //   605: if_icmpne +757 -> 1362
    //   608: aload 5
    //   610: ldc_w 3312
    //   613: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   616: astore_1
    //   617: aload_0
    //   618: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   621: ifeq +12 -> 633
    //   624: aload 5
    //   626: ldc_w 3314
    //   629: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   632: astore_1
    //   633: aload_0
    //   634: getfield 1441	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerNick	Ljava/lang/String;
    //   637: astore_3
    //   638: aload_1
    //   639: astore_2
    //   640: aload_3
    //   641: astore_1
    //   642: aload_2
    //   643: ifnull +714 -> 1357
    //   646: aload_2
    //   647: aload 5
    //   649: ldc_w 3313
    //   652: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   655: invokevirtual 1458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   658: ifne +699 -> 1357
    //   661: aload_2
    //   662: aload 5
    //   664: ldc_w 3315
    //   667: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   670: invokevirtual 1458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   673: ifne +684 -> 1357
    //   676: aload_0
    //   677: getfield 1441	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerNick	Ljava/lang/String;
    //   680: astore_3
    //   681: aload_2
    //   682: astore_1
    //   683: aload_0
    //   684: getfield 402	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   687: iconst_1
    //   688: if_icmpne +21 -> 709
    //   691: aload_2
    //   692: astore_1
    //   693: aload_0
    //   694: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   697: ifeq +12 -> 709
    //   700: aload 5
    //   702: ldc_w 3314
    //   705: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   708: astore_1
    //   709: aload_3
    //   710: astore_2
    //   711: invokestatic 1322	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   714: invokevirtual 1326	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   717: checkcast 1328	com/tencent/mobileqq/app/QQAppInterface
    //   720: astore 6
    //   722: aload_3
    //   723: astore_2
    //   724: aload 6
    //   726: aload_0
    //   727: getfield 1296	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   730: ldc 226
    //   732: aload_0
    //   733: getfield 416	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   736: invokestatic 1438	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   739: astore_3
    //   740: aload_0
    //   741: getfield 1290	com/tencent/mobileqq/filemanager/data/FileManagerEntity:TroopUin	J
    //   744: lconst_0
    //   745: lcmp
    //   746: ifeq +604 -> 1350
    //   749: aload 6
    //   751: bipush 52
    //   753: invokevirtual 2295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   756: checkcast 3328	com/tencent/mobileqq/app/TroopManager
    //   759: aload_0
    //   760: getfield 1290	com/tencent/mobileqq/filemanager/data/FileManagerEntity:TroopUin	J
    //   763: invokestatic 1293	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   766: invokevirtual 3331	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   769: astore_2
    //   770: aload_2
    //   771: ifnull +10 -> 781
    //   774: aload_2
    //   775: invokevirtual 3336	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   778: ifnonnull +397 -> 1175
    //   781: ldc 226
    //   783: astore_3
    //   784: aload_3
    //   785: astore_2
    //   786: new 123	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   793: aload 5
    //   795: ldc_w 3337
    //   798: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   801: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_3
    //   805: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: astore 4
    //   813: aload 4
    //   815: astore_3
    //   816: aload 4
    //   818: astore_2
    //   819: aload_0
    //   820: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   823: ifeq +33 -> 856
    //   826: aload 4
    //   828: astore_2
    //   829: new 123	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   836: aload 5
    //   838: ldc_w 3338
    //   841: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   844: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload 4
    //   849: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: astore_3
    //   856: aconst_null
    //   857: astore_2
    //   858: aload_3
    //   859: astore_1
    //   860: aload_1
    //   861: astore_3
    //   862: aload_2
    //   863: ifnull +22 -> 885
    //   866: aload_1
    //   867: astore_3
    //   868: aload_2
    //   869: aload 5
    //   871: ldc_w 3313
    //   874: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   877: invokevirtual 1458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   880: ifeq +5 -> 885
    //   883: aconst_null
    //   884: astore_3
    //   885: aload_3
    //   886: astore_1
    //   887: aload_0
    //   888: getfield 416	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   891: sipush 3000
    //   894: if_icmpne +451 -> 1345
    //   897: aload_2
    //   898: ifnull +20 -> 918
    //   901: aload_3
    //   902: astore_1
    //   903: aload_2
    //   904: aload 5
    //   906: ldc_w 3313
    //   909: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   912: invokevirtual 1458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   915: ifeq +14 -> 929
    //   918: aload_3
    //   919: astore_1
    //   920: aload_0
    //   921: getfield 402	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   924: bipush 28
    //   926: if_icmpne +419 -> 1345
    //   929: aload_3
    //   930: astore_1
    //   931: aload 6
    //   933: bipush 53
    //   935: invokevirtual 2295	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   938: checkcast 3340	acdu
    //   941: aload_0
    //   942: getfield 1296	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   945: invokestatic 1550	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   948: invokevirtual 3343	acdu:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   951: astore 4
    //   953: aload 4
    //   955: ifnull +414 -> 1369
    //   958: aload_3
    //   959: astore_1
    //   960: aload 4
    //   962: getfield 3348	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   965: ifnonnull +253 -> 1218
    //   968: goto +401 -> 1369
    //   971: aload_3
    //   972: astore_1
    //   973: new 123	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   980: aload 5
    //   982: ldc_w 3349
    //   985: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   988: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_3
    //   992: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: astore_3
    //   999: aload_3
    //   1000: astore_1
    //   1001: aload_1
    //   1002: astore_3
    //   1003: aload_0
    //   1004: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1007: ifeq +29 -> 1036
    //   1010: new 123	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1017: aload 5
    //   1019: ldc_w 3350
    //   1022: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1025: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload_1
    //   1029: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: astore_3
    //   1036: aconst_null
    //   1037: astore_1
    //   1038: aload_1
    //   1039: astore_2
    //   1040: aload_2
    //   1041: ifnull +241 -> 1282
    //   1044: aload_2
    //   1045: aload 5
    //   1047: ldc_w 3315
    //   1050: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1053: invokevirtual 1845	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1056: ifeq +226 -> 1282
    //   1059: aload_0
    //   1060: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1063: ifeq +219 -> 1282
    //   1066: new 123	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1073: aload 5
    //   1075: ldc_w 3314
    //   1078: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1081: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 2095
    //   1087: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload_3
    //   1091: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: astore_0
    //   1098: aload_0
    //   1099: areturn
    //   1100: aload_0
    //   1101: getfield 376	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   1104: bipush 13
    //   1106: if_icmpne +29 -> 1135
    //   1109: aload_0
    //   1110: getfield 1427	com/tencent/mobileqq/filemanager/data/FileManagerEntity:selfUin	Ljava/lang/String;
    //   1113: aload_0
    //   1114: getfield 1296	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   1117: invokevirtual 1458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1120: ifeq +15 -> 1135
    //   1123: aload 5
    //   1125: ldc_w 3351
    //   1128: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1131: astore_1
    //   1132: goto -548 -> 584
    //   1135: aload 5
    //   1137: ldc_w 3314
    //   1140: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1143: astore_1
    //   1144: goto -560 -> 584
    //   1147: aload 5
    //   1149: ldc_w 3312
    //   1152: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1155: astore_1
    //   1156: aload_0
    //   1157: getfield 1343	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1160: ifeq -576 -> 584
    //   1163: aload 5
    //   1165: ldc_w 3314
    //   1168: invokevirtual 2093	android/content/Context:getString	(I)Ljava/lang/String;
    //   1171: astore_1
    //   1172: goto -588 -> 584
    //   1175: aload_2
    //   1176: ifnull +32 -> 1208
    //   1179: aload_2
    //   1180: invokevirtual 3336	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1183: ifnull +25 -> 1208
    //   1186: aload_2
    //   1187: invokevirtual 3336	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1190: invokevirtual 399	java/lang/String:length	()I
    //   1193: bipush 14
    //   1195: if_icmple +13 -> 1208
    //   1198: aload_2
    //   1199: invokevirtual 3336	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1202: astore_2
    //   1203: aload_2
    //   1204: astore_3
    //   1205: goto -421 -> 784
    //   1208: aload_2
    //   1209: invokevirtual 3336	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1212: astore_2
    //   1213: aload_2
    //   1214: astore_3
    //   1215: goto -431 -> 784
    //   1218: aload 4
    //   1220: ifnull +39 -> 1259
    //   1223: aload_3
    //   1224: astore_1
    //   1225: aload 4
    //   1227: getfield 3348	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   1230: ifnull +29 -> 1259
    //   1233: aload_3
    //   1234: astore_1
    //   1235: aload 4
    //   1237: getfield 3348	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   1240: invokevirtual 399	java/lang/String:length	()I
    //   1243: bipush 14
    //   1245: if_icmple +14 -> 1259
    //   1248: aload_3
    //   1249: astore_1
    //   1250: aload 4
    //   1252: getfield 3348	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   1255: astore_3
    //   1256: goto -285 -> 971
    //   1259: aload_3
    //   1260: astore_1
    //   1261: aload 4
    //   1263: getfield 3348	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   1266: astore_3
    //   1267: goto -296 -> 971
    //   1270: astore_3
    //   1271: aload_1
    //   1272: astore_3
    //   1273: aload_2
    //   1274: astore_1
    //   1275: aload_3
    //   1276: astore_2
    //   1277: aload_1
    //   1278: astore_3
    //   1279: goto -239 -> 1040
    //   1282: aload_2
    //   1283: ifnull +32 -> 1315
    //   1286: aload_3
    //   1287: ifnull +28 -> 1315
    //   1290: new 123	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1297: aload_2
    //   1298: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: ldc_w 2095
    //   1304: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_3
    //   1308: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: areturn
    //   1315: aload_2
    //   1316: astore_0
    //   1317: aload_2
    //   1318: ifnonnull -220 -> 1098
    //   1321: aload_3
    //   1322: areturn
    //   1323: astore_2
    //   1324: aload_1
    //   1325: astore_2
    //   1326: aload_3
    //   1327: astore_1
    //   1328: aload_2
    //   1329: astore_3
    //   1330: goto -55 -> 1275
    //   1333: astore_3
    //   1334: aload_2
    //   1335: astore_3
    //   1336: goto -61 -> 1275
    //   1339: astore_3
    //   1340: aload_2
    //   1341: astore_3
    //   1342: goto -67 -> 1275
    //   1345: aload_2
    //   1346: astore_1
    //   1347: goto -309 -> 1038
    //   1350: aload_1
    //   1351: astore_2
    //   1352: aload_3
    //   1353: astore_1
    //   1354: goto -494 -> 860
    //   1357: aload_1
    //   1358: astore_3
    //   1359: goto -678 -> 681
    //   1362: aload_1
    //   1363: astore_2
    //   1364: aconst_null
    //   1365: astore_1
    //   1366: goto -724 -> 642
    //   1369: ldc 226
    //   1371: astore_3
    //   1372: goto -401 -> 971
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1375	0	paramFileManagerEntity	FileManagerEntity
    //   506	860	1	localObject1	Object
    //   639	679	2	localObject2	Object
    //   1323	1	2	localException1	Exception
    //   1325	39	2	localObject3	Object
    //   637	630	3	localObject4	Object
    //   1270	1	3	localException2	Exception
    //   1272	58	3	localObject5	Object
    //   1333	1	3	localException3	Exception
    //   1335	1	3	localObject6	Object
    //   1339	1	3	localException4	Exception
    //   1341	31	3	localObject7	Object
    //   811	451	4	localObject8	Object
    //   3	1161	5	localBaseApplication	BaseApplication
    //   720	212	6	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   711	722	1270	java/lang/Exception
    //   724	740	1270	java/lang/Exception
    //   786	813	1270	java/lang/Exception
    //   819	826	1270	java/lang/Exception
    //   829	856	1270	java/lang/Exception
    //   740	770	1323	java/lang/Exception
    //   774	781	1323	java/lang/Exception
    //   1179	1203	1323	java/lang/Exception
    //   1208	1213	1323	java/lang/Exception
    //   868	883	1333	java/lang/Exception
    //   887	897	1333	java/lang/Exception
    //   903	918	1333	java/lang/Exception
    //   920	929	1333	java/lang/Exception
    //   931	953	1333	java/lang/Exception
    //   960	968	1333	java/lang/Exception
    //   973	999	1333	java/lang/Exception
    //   1225	1233	1333	java/lang/Exception
    //   1235	1248	1333	java/lang/Exception
    //   1250	1256	1333	java/lang/Exception
    //   1261	1267	1333	java/lang/Exception
    //   1003	1036	1339	java/lang/Exception
  }
  
  public static String e(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = 0;
    while (j < paramByteStringMicro.length)
    {
      int k = paramByteStringMicro[j];
      localStringBuffer.append(arrayOfChar[(k >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(k & 0xF)]);
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ShortcutManager localShortcutManager;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
      if ((localShortcutManager != null) && (!isShortcutCreated_O(paramString2, localShortcutManager))) {
        break label35;
      }
    }
    label35:
    while (!localShortcutManager.isRequestPinShortcutSupported()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtra(paramString1, true);
    localIntent.setClassName(paramContext, JumpActivity.class.getName());
    localIntent.setFlags(337641472);
    String str = "my-shortcut";
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = str;
      if (paramString2.equals(paramContext.getString(2131695446))) {
        paramString1 = "my-dataline-shortcut";
      }
    }
    localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, paramString1).setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
  }
  
  public static void eI(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static String ek(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return acfp.m(2131706248);
    case 1: 
      return acfp.m(2131706242);
    case 0: 
      return acfp.m(2131706258);
    case 2: 
      return acfp.m(2131706264);
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return acfp.m(2131706251);
    }
    return acfp.m(2131706272);
  }
  
  public static String el(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static void en(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "[QFILE] QQ - startQFile failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), acfp.m(2131706271), 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, FileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "FileAssistant");
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void eo(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  public static String f(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject = BaseApplicationImpl.getContext();
    String str2 = ((Context)localObject).getString(2131693588);
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      if (localObject != null) {
        label62:
        if ((paramFileManagerEntity.getCloudType() != 2) || (3 != paramFileManagerEntity.nOpType)) {
          break label162;
        }
      }
      break;
    }
    label162:
    while ((paramFileManagerEntity.getCloudType() == 5) || (paramFileManagerEntity.TroopUin != 0L))
    {
      return localObject;
      localObject = ((Context)localObject).getString(2131693540);
      str1 = i(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType);
      break;
      localObject = ((Context)localObject).getString(2131693614);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = ((Context)localObject).getString(2131700496);
      break;
      localObject = "" + aW(str2, str1);
      break label62;
    }
    if (str1 != null) {
      return str1;
    }
    return "";
  }
  
  public static String g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      paramChatMessage = "";
    }
    String str1;
    String str2;
    do
    {
      return paramChatMessage;
      str1 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_750_");
      str2 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_384_");
      if (TextUtils.isEmpty(str1)) {
        break;
      }
      paramChatMessage = str1;
    } while (aqhq.fileExistsAndNotEmpty(str1));
    if ((!TextUtils.isEmpty(str1)) && (aqhq.fileExistsAndNotEmpty(str2))) {
      return str2;
    }
    return "";
  }
  
  public static String g(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      String str = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      paramFileManagerEntity = atad.toMD5(paramFileManagerEntity + str);
      return ahaf.a().wb() + "x-zip-" + paramFileManagerEntity;
    }
    return "";
  }
  
  public static long ge()
  {
    return anbk.I(anbk.Ji());
  }
  
  public static String getFileName(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      ti();
      localObject = "";
      return localObject;
    }
    int m = paramString.length();
    int j = paramString.lastIndexOf('/');
    int k = paramString.lastIndexOf('\\');
    if (k > j) {
      j = k;
    }
    for (;;)
    {
      if (j < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
        }
        j = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(j, m);
        if ((QLog.isColorLevel()) && (str2 != null) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; (str1 != null) && (str1.startsWith(".")); str1 = str1.replaceFirst(".", "")) {}
        j += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static long getFileSizes(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    VFSFile localVFSFile = new VFSFile(paramString);
    if (!localVFSFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localVFSFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static int getFileType(String paramString)
  {
    label1489:
    for (;;)
    {
      try
      {
        String str1 = ahbj.getExtension(paramString);
        int j;
        if (str1 != null)
        {
          j = str1.length();
          if (j != 0) {}
        }
        else
        {
          j = -1;
          return j;
        }
        str1 = str1.toLowerCase();
        if (kQ == null)
        {
          kQ = new HashMap();
          j = Build.VERSION.SDK_INT;
          if (j >= 16)
          {
            try
            {
              int m = MediaCodecList.getCodecCount();
              j = 0;
              if (j < m)
              {
                Object localObject = MediaCodecList.getCodecInfoAt(j);
                if (!((MediaCodecInfo)localObject).isEncoder()) {
                  break label1489;
                }
                localObject = ((MediaCodecInfo)localObject).getSupportedTypes();
                int k = 0;
                if (k >= localObject.length) {
                  break label1489;
                }
                String str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(localObject[k]);
                if (!TextUtils.isEmpty(str2)) {
                  kQ.put("." + str2, Integer.valueOf(1));
                }
                k += 1;
                continue;
              }
              kQ.put(".mp3", Integer.valueOf(1));
            }
            catch (Exception localException)
            {
              QLog.i("<QFile>", 1, "GetFileType error, try to get support type failed.");
            }
          }
          else
          {
            kQ.put(".flac", Integer.valueOf(1));
            kQ.put(".ogg", Integer.valueOf(1));
            kQ.put(".wav", Integer.valueOf(1));
            kQ.put(".m4a", Integer.valueOf(1));
            kQ.remove(".flv");
            kQ.remove(".m");
            kQ.remove(".webp");
            kQ.remove(".vcf");
            kQ.put(".bmp", Integer.valueOf(0));
            kQ.put(".jpg", Integer.valueOf(0));
            kQ.put(".jpeg", Integer.valueOf(0));
            kQ.put(".png", Integer.valueOf(0));
            kQ.put(".gif", Integer.valueOf(0));
            kQ.put(".webp", Integer.valueOf(0));
            kQ.put(".psd", Integer.valueOf(12));
            kQ.put(".swf", Integer.valueOf(2));
            kQ.put(".mov", Integer.valueOf(2));
            kQ.put(".mp4", Integer.valueOf(2));
            kQ.put(".3gp", Integer.valueOf(2));
            kQ.put(".avi", Integer.valueOf(2));
            kQ.put(".rmvb", Integer.valueOf(2));
            kQ.put(".mpg", Integer.valueOf(2));
            kQ.put(".rm", Integer.valueOf(2));
            kQ.put(".asf", Integer.valueOf(2));
            kQ.put(".mpeg", Integer.valueOf(2));
            kQ.put(".mkv", Integer.valueOf(2));
            kQ.put(".wmv", Integer.valueOf(2));
            kQ.put(".flv", Integer.valueOf(2));
            kQ.put(".f4v", Integer.valueOf(2));
            kQ.put(".webm", Integer.valueOf(2));
            kQ.put(".mod", Integer.valueOf(2));
            kQ.put(".mpe", Integer.valueOf(2));
            kQ.put(".fla", Integer.valueOf(2));
            kQ.put(".m4r", Integer.valueOf(2));
            kQ.put(".m4u", Integer.valueOf(2));
            kQ.put(".m4v", Integer.valueOf(2));
            kQ.put(".vob", Integer.valueOf(2));
            kQ.put(".doc", Integer.valueOf(3));
            kQ.put(".docx", Integer.valueOf(3));
            kQ.put(".wps", Integer.valueOf(3));
            kQ.put(".pages", Integer.valueOf(3));
            kQ.put(".zip", Integer.valueOf(4));
            kQ.put(".rar", Integer.valueOf(4));
            kQ.put(".7z", Integer.valueOf(4));
            kQ.put(".tar", Integer.valueOf(4));
            kQ.put(".iso", Integer.valueOf(4));
            kQ.put("gz", Integer.valueOf(4));
            kQ.put(".apk", Integer.valueOf(5));
            kQ.put(".apk.rename", Integer.valueOf(5));
            kQ.put(".xls", Integer.valueOf(6));
            kQ.put(".xlsx", Integer.valueOf(6));
            kQ.put(".csv", Integer.valueOf(6));
            kQ.put(".numbers", Integer.valueOf(6));
            kQ.put(".et", Integer.valueOf(6));
            kQ.put(".ppt", Integer.valueOf(7));
            kQ.put(".pptx", Integer.valueOf(7));
            kQ.put(".pps", Integer.valueOf(7));
            kQ.put(".dps", Integer.valueOf(7));
            kQ.put(".keynotes", Integer.valueOf(7));
            kQ.put(".htm", Integer.valueOf(8));
            kQ.put(".html", Integer.valueOf(8));
            kQ.put(".php", Integer.valueOf(8));
            kQ.put(".pdf", Integer.valueOf(9));
            kQ.put(".txt", Integer.valueOf(10));
            kQ.put(".epub", Integer.valueOf(10));
            kQ.put(".rtf", Integer.valueOf(10));
            kQ.put(".c", Integer.valueOf(10));
            kQ.put(".conf", Integer.valueOf(10));
            kQ.put(".cpp", Integer.valueOf(10));
            kQ.put(".h", Integer.valueOf(10));
            kQ.put(".java", Integer.valueOf(10));
            kQ.put(".log", Integer.valueOf(10));
            kQ.put(".prop", Integer.valueOf(10));
            kQ.put(".rc", Integer.valueOf(10));
            kQ.put(".sh", Integer.valueOf(10));
            kQ.put(".csv", Integer.valueOf(10));
            kQ.put(".xml", Integer.valueOf(10));
            kQ.put(".ai", Integer.valueOf(14));
            kQ.put(".font", Integer.valueOf(15));
            kQ.put(".ipa", Integer.valueOf(16));
            kQ.put(".keynote", Integer.valueOf(17));
            kQ.put(".note", Integer.valueOf(18));
            kQ.put(".numbers", Integer.valueOf(19));
            kQ.put(".pages", Integer.valueOf(20));
            kQ.put(".sketch", Integer.valueOf(21));
          }
        }
        else
        {
          if (kQ.containsKey(str1.toLowerCase()))
          {
            j = ((Integer)kQ.get(str1.toLowerCase())).intValue();
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.w("FileManagerUtil<FileAssistant>", 2, "Unknow file Type[" + paramString + "]");
          }
          j = 11;
          continue;
        }
        j += 1;
      }
      finally {}
    }
  }
  
  public static String h(FileManagerEntity paramFileManagerEntity)
  {
    if (!ahwy.a().aom())
    {
      paramFileManagerEntity.strQRUrl = "";
      return "";
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strQRUrl))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl:" + paramFileManagerEntity.strQRUrl);
      }
      return paramFileManagerEntity.strQRUrl;
    }
    Object localObject;
    if (rox.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
      localObject = new File(paramFileManagerEntity.strMiddleThumPath);
    }
    for (String str = "mid";; str = "larg")
    {
      localObject = ahwo.a(BaseApplicationImpl.getContext(), (File)localObject);
      if (localObject == null) {
        break label203;
      }
      paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl success:" + paramFileManagerEntity.strQRUrl + " use:" + str);
      }
      return paramFileManagerEntity.strQRUrl;
      if (!rox.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
        break;
      }
      localObject = new File(paramFileManagerEntity.strLargeThumPath);
    }
    return null;
    label203:
    return "";
  }
  
  public static String h(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int j;
    Object localObject2;
    do
    {
      return null;
      localObject1 = new VFSFile(ahaf.a().wb());
      if (!((VFSFile)localObject1).exists()) {
        ((VFSFile)localObject1).mkdirs();
      }
      localObject1 = ahaf.a().wb() + getFileName(paramString) + ".JPG";
      if (ahbj.fileExistsAndNotEmpty((String)localObject1)) {
        return localObject1;
      }
      j = getFileType(paramString);
      if (j != 0) {
        break label277;
      }
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread()) {
        break;
      }
      localObject2 = dz.a(paramString, paramInt1, paramInt2);
    } while (localObject2 == null);
    for (;;)
    {
      try
      {
        ahbj.f((Bitmap)localObject2, (String)localObject1);
        ((Bitmap)localObject2).recycle();
        dz.e((String)localObject1, dz.l(paramString));
        return localObject1;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
        return null;
      }
      ahav.a.getExecutor().execute(new FileManagerUtil.10((String)localObject1, paramString, paramInt1, paramInt2));
      continue;
      label277:
      if (j != 2) {
        break;
      }
      a(paramString, true, paramInt1, paramInt2, 3, new ahaw((String)localObject1, paramString));
    }
  }
  
  public static void h(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    avhc.c(paramActivity, 1, paramString1);
  }
  
  public static void h(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2130772004, 2130772005);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    b(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramContext);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    localFile = new File(paramQQAppInterface.getApplication().getFilesDir(), "FileOnlinePreviewConfigV2");
    for (;;)
    {
      try
      {
        if (!HttpDownloadUtil.a(paramQQAppInterface, paramString, localFile)) {
          continue;
        }
        paramString = new ahav.c();
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide download xml failed: " + paramString);
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(localFile, paramString);
        new agmx(paramQQAppInterface, paramString, paramLong);
        localFile.delete();
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
      }
    }
  }
  
  public static int hL(int paramInt)
  {
    return aC(paramInt, 2);
  }
  
  public static int hM(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static int hN(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 5;
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 4;
    }
    return 6;
  }
  
  public static String i(long paramLong, int paramInt)
  {
    long l2 = 604800000L;
    long l1 = l2;
    switch (paramInt)
    {
    }
    for (l1 = l2;; l1 = 2592000000L)
    {
      Date localDate1 = new Date(l1 + paramLong);
      Date localDate2 = new Date(anaz.gQ() * 1000L);
      paramInt = (int)((localDate1.getTime() - localDate2.getTime()) / 86400000L);
      if (paramInt >= 0) {
        break;
      }
      return acfp.m(2131706244);
    }
    if (paramInt == 0) {
      return acfp.m(2131706250);
    }
    return paramInt + acfp.m(2131706247);
  }
  
  public static void i(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    avhc.c(paramActivity, 3, paramString1);
  }
  
  public static int[] i(String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {
      return new int[] { 0, 0 };
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int j = aoop.eI(paramString);
    int k;
    if ((j == 90) || (j == 270))
    {
      j = localOptions.outWidth;
      k = localOptions.outHeight;
    }
    for (;;)
    {
      return new int[] { k, j };
      k = localOptions.outWidth;
      j = localOptions.outHeight;
    }
  }
  
  public static void installApkFile(Context paramContext, String paramString)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      ahao.OS(2131694128);
      return;
    }
    paramString = FileProvider7Helper.openApkIntent(paramContext, paramString);
    paramString.putExtra("big_brother_source_key", "biz_src_jc_file");
    List localList = paramContext.getPackageManager().queryIntentActivities(paramString, 65536);
    if ((localList.size() == 1) && (((ResolveInfo)localList.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int j = 1;; j = 0)
    {
      if ((localList.size() > 0) && (j == 0)) {
        try
        {
          paramContext.startActivity(paramString);
          return;
        }
        catch (ActivityNotFoundException paramContext)
        {
          ahao.OS(2131695388);
          return;
        }
      }
      ahao.OS(2131695388);
      return;
    }
  }
  
  public static boolean isLocalFile(String paramString)
  {
    return ahbj.fileExistsAndNotEmpty(paramString);
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
      do
      {
        if (!paramShortcutManager.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getShortLabel()));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.16(paramString2, paramQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static boolean jP(int paramInt)
  {
    return paramInt == agmy.cXS;
  }
  
  public static void jQ(long paramLong)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).a().b(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      switch (localFileManagerEntity.nOpType)
      {
      case -1: 
      case 0: 
      case 3: 
      case 7: 
      case 2: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      case 1: 
      case 5: 
      case 8: 
        localObject = kY(localFileManagerEntity.fileName);
        ahao.JF((String)localObject + BaseApplicationImpl.getContext().getString(2131693561) + ahaf.a().vZ());
        return;
      }
      if (localFileManagerEntity.nOpType == 6)
      {
        if (BaseActivity.sTopActivity != null)
        {
          awpl.b((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
          return;
        }
        ahao.JF(BaseApplicationImpl.getContext().getString(2131699597));
        return;
      }
    } while (!awou.nP(0));
    if (BaseActivity.sTopActivity != null)
    {
      awpl.b((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
    }
    ahao.JF(BaseApplicationImpl.getContext().getString(2131699597));
  }
  
  /* Error */
  public static void jR(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 53	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 55	java/util/ArrayList:<init>	()V
    //   16: putstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   19: getstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 3166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 4004	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 3166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1887	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 1372
    //   58: iconst_2
    //   59: new 123	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 4006
    //   69: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 1293	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 4008
    //   82: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_3
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   29	2	2	bool	boolean
    //   94	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  /* Error */
  public static void jS(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 4002	ahav:wM	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 3166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 4011	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 1372
    //   35: iconst_2
    //   36: new 123	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 4006
    //   46: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 1293	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 4013
    //   59: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto -57 -> 11
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   71	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   15	68	71	finally
  }
  
  /* Error */
  @TargetApi(9)
  public static Map<String, File> k(Context paramContext)
  {
    // Byte code:
    //   0: new 59	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 4024	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 4026
    //   16: invokestatic 4031	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokeinterface 4032 3 0
    //   24: pop
    //   25: aload_0
    //   26: ldc_w 4034
    //   29: invokevirtual 4035	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 4037	android/os/storage/StorageManager
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 4041	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: ldc_w 4043
    //   45: aconst_null
    //   46: invokevirtual 4047	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: aload 5
    //   51: aconst_null
    //   52: invokevirtual 4053	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 4055	[Ljava/lang/String;
    //   58: checkcast 4055	[Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: iload_3
    //   71: if_icmpge +165 -> 236
    //   74: aload 5
    //   76: iload_1
    //   77: aaload
    //   78: astore 6
    //   80: new 503	java/io/File
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 504	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 7
    //   91: getstatic 658	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 9
    //   96: if_icmple +352 -> 448
    //   99: aload 7
    //   101: invokevirtual 4058	java/io/File:getUsableSpace	()J
    //   104: lconst_0
    //   105: lcmp
    //   106: ifgt +6 -> 112
    //   109: goto +339 -> 448
    //   112: aload 4
    //   114: invokeinterface 4060 1 0
    //   119: ifne +64 -> 183
    //   122: aload 4
    //   124: invokeinterface 4063 1 0
    //   129: invokeinterface 3109 1 0
    //   134: astore 8
    //   136: aload 8
    //   138: invokeinterface 1914 1 0
    //   143: ifeq +300 -> 443
    //   146: aload 4
    //   148: aload 8
    //   150: invokeinterface 1918 1 0
    //   155: checkcast 45	java/lang/String
    //   158: invokeinterface 4064 2 0
    //   163: checkcast 503	java/io/File
    //   166: invokevirtual 4065	java/io/File:getPath	()Ljava/lang/String;
    //   169: aload 6
    //   171: invokevirtual 1845	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: iconst_1
    //   175: if_icmpne -39 -> 136
    //   178: iconst_1
    //   179: istore_2
    //   180: goto +275 -> 455
    //   183: ldc 121
    //   185: iconst_1
    //   186: new 123	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 4067
    //   196: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 7
    //   201: invokevirtual 4065	java/io/File:getPath	()Ljava/lang/String;
    //   204: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 4
    //   215: ldc_w 4069
    //   218: aload 7
    //   220: invokeinterface 4032 3 0
    //   225: pop
    //   226: goto +222 -> 448
    //   229: astore 5
    //   231: aload 5
    //   233: invokevirtual 4070	java/lang/IllegalArgumentException:printStackTrace	()V
    //   236: aload 4
    //   238: ldc_w 4069
    //   241: invokeinterface 4071 2 0
    //   246: ifne +109 -> 355
    //   249: aload_0
    //   250: aconst_null
    //   251: invokevirtual 4075	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +142 -> 398
    //   259: ldc 121
    //   261: iconst_1
    //   262: new 123	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 4077
    //   272: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 4065	java/io/File:getPath	()Ljava/lang/String;
    //   279: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: invokevirtual 4080	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   292: aload 4
    //   294: ldc_w 4026
    //   297: invokeinterface 4064 2 0
    //   302: checkcast 503	java/io/File
    //   305: invokevirtual 4080	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   311: ifne +44 -> 355
    //   314: ldc 121
    //   316: iconst_1
    //   317: new 123	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 4082
    //   327: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: invokevirtual 4065	java/io/File:getPath	()Ljava/lang/String;
    //   334: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload 4
    //   345: ldc_w 4069
    //   348: aload_0
    //   349: invokeinterface 4032 3 0
    //   354: pop
    //   355: aload 4
    //   357: areturn
    //   358: astore 5
    //   360: aload 5
    //   362: invokevirtual 4083	java/lang/IllegalAccessException:printStackTrace	()V
    //   365: goto -129 -> 236
    //   368: astore 5
    //   370: aload 5
    //   372: invokevirtual 4084	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   375: goto -139 -> 236
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 4085	java/lang/NoSuchMethodException:printStackTrace	()V
    //   385: goto -149 -> 236
    //   388: astore 5
    //   390: aload 5
    //   392: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   395: goto -159 -> 236
    //   398: ldc 121
    //   400: iconst_1
    //   401: ldc_w 4087
    //   404: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 4
    //   409: areturn
    //   410: astore_0
    //   411: ldc 121
    //   413: iconst_1
    //   414: new 123	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 4089
    //   424: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokevirtual 3154	java/lang/Exception:toString	()Ljava/lang/String;
    //   431: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload 4
    //   442: areturn
    //   443: iconst_0
    //   444: istore_2
    //   445: goto +10 -> 455
    //   448: iload_1
    //   449: iconst_1
    //   450: iadd
    //   451: istore_1
    //   452: goto -383 -> 69
    //   455: iload_2
    //   456: iconst_1
    //   457: if_icmpeq -9 -> 448
    //   460: goto -277 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	paramContext	Context
    //   68	384	1	j	int
    //   179	279	2	k	int
    //   66	6	3	m	int
    //   9	432	4	localHashMap	HashMap
    //   35	40	5	localObject	Object
    //   229	3	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   358	3	5	localIllegalAccessException	java.lang.IllegalAccessException
    //   368	3	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   378	3	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   388	3	5	localException	Exception
    //   78	92	6	str	String
    //   89	130	7	localFile	File
    //   134	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   11	67	229	java/lang/IllegalArgumentException
    //   80	109	229	java/lang/IllegalArgumentException
    //   112	136	229	java/lang/IllegalArgumentException
    //   136	178	229	java/lang/IllegalArgumentException
    //   183	226	229	java/lang/IllegalArgumentException
    //   11	67	358	java/lang/IllegalAccessException
    //   80	109	358	java/lang/IllegalAccessException
    //   112	136	358	java/lang/IllegalAccessException
    //   136	178	358	java/lang/IllegalAccessException
    //   183	226	358	java/lang/IllegalAccessException
    //   11	67	368	java/lang/reflect/InvocationTargetException
    //   80	109	368	java/lang/reflect/InvocationTargetException
    //   112	136	368	java/lang/reflect/InvocationTargetException
    //   136	178	368	java/lang/reflect/InvocationTargetException
    //   183	226	368	java/lang/reflect/InvocationTargetException
    //   11	67	378	java/lang/NoSuchMethodException
    //   80	109	378	java/lang/NoSuchMethodException
    //   112	136	378	java/lang/NoSuchMethodException
    //   136	178	378	java/lang/NoSuchMethodException
    //   183	226	378	java/lang/NoSuchMethodException
    //   11	67	388	java/lang/Exception
    //   80	109	388	java/lang/Exception
    //   112	136	388	java/lang/Exception
    //   136	178	388	java/lang/Exception
    //   183	226	388	java/lang/Exception
    //   249	255	410	java/lang/Exception
    //   259	355	410	java/lang/Exception
    //   398	407	410	java/lang/Exception
  }
  
  public static void k(ImageView paramImageView, String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130845244);
      return;
    }
    paramImageView.setImageResource(r(paramString));
  }
  
  public static String kW(String paramString)
  {
    int j = paramString.lastIndexOf("/");
    int k = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (j > 0)
    {
      if ((k <= 0) || (k <= j)) {
        break label158;
      }
      localObject1 = paramString.substring(j, k);
    }
    for (str1 = paramString.substring(k);; str1 = str2)
    {
      str2 = paramString.substring(0, j);
      localObject2 = localObject1;
      localObject1 = str2;
      VFSFile localVFSFile = new VFSFile(paramString);
      j = 1;
      str2 = paramString;
      paramString = localVFSFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + j + ")" + str1;
        paramString = new VFSFile(str2);
        j += 1;
      }
      label158:
      localObject1 = paramString.substring(j);
    }
    return str2;
  }
  
  public static String kX(String paramString)
  {
    if (kP == null)
    {
      kP = new HashMap();
      kP.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      kP.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      kP.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      kP.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      kP.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      kP.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      kP.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      kP.put("OnlinePreViewdocFileMaxSize", "10");
      kP.put("OnlinePreViewdocFileType", "1");
      kP.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewdocPreviewMode", "0");
      kP.put("OnlinePreViewdocxFileMaxSize", "10");
      kP.put("OnlinePreViewdocxFileType", "2");
      kP.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewdocxPreviewMode", "0");
      kP.put("OnlinePreViewrtfFileMaxSize", "10");
      kP.put("OnlinePreViewrtfFileType", "7");
      kP.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      kP.put("OnlinePreViewrtfPreviewMode", "0");
      kP.put("OnlinePreViewpptFileMaxSize", "10");
      kP.put("OnlinePreViewpptFileType", "5");
      kP.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      kP.put("OnlinePreViewpptPreviewMode", "4");
      kP.put("OnlinePreViewpptxFileMaxSize", "10");
      kP.put("OnlinePreViewpptxFileType", "6");
      kP.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      kP.put("OnlinePreViewpptxPreviewMode", "5");
      kP.put("OnlinePreViewpdfFileMaxSize", "10");
      kP.put("OnlinePreViewpdfFileType", "8");
      kP.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      kP.put("OnlinePreViewpdfPreviewMode", "3");
      kP.put("OnlinePreViewzipFileMaxSize", "100");
      kP.put("OnlinePreViewzipFileType", "13");
      kP.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreViewzipPreviewMode", "1");
      kP.put("OnlinePreViewrarFileMaxSize", "100");
      kP.put("OnlinePreViewrarFileType", "14");
      kP.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreViewrarPreviewMode", "1");
      kP.put("OnlinePreView7zFileMaxSize", "100");
      kP.put("OnlinePreView7zFileType", "15");
      kP.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      kP.put("OnlinePreView7zPreviewMode", "1");
      kP.put("OnlinePreViewtxtFileMaxSize", "10");
      kP.put("OnlinePreViewtxtFileType", "16");
      kP.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      kP.put("OnlinePreViewtxtPreviewMode", "2");
      kP.put("OfflineConfigFlowSize", "1024");
      kP.put("OfflineConfigFlowTime", "30");
      kP.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)kP.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  public static String kY(String paramString)
  {
    int j = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = mH(paramString);
    if (acej.aV() >= 20.0F) {
      if (bool) {
        j = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - j) {
        break;
      }
      int k = paramString.length();
      str = paramString.substring(0, (16 - j) / 2);
      paramString = paramString.substring(k - (16 - j) / 2);
      return str + "..." + paramString;
      if (acej.aV() >= 18.0F)
      {
        if (bool) {
          j = 5;
        } else {
          j = 2;
        }
      }
      else if (acej.aV() >= 17.0F)
      {
        if (!bool) {
          j = 1;
        }
      }
      else {
        j = 0;
      }
    }
  }
  
  public static String kZ(String paramString)
  {
    int j = 0;
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    label179:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int k = 0;
          if (k < paramString.length())
          {
            if (j <= "AnDrDQ_Fm_String".length() - 1) {
              break label179;
            }
            j %= "AnDrDQ_Fm_String".length();
            int n = paramString.codePointAt(k) + "AnDrDQ_Fm_String".codePointAt(j);
            int m = n;
            if (n > 65535) {
              m = n % 65535;
            }
            localByteArrayBuffer.append(m);
            k += 1;
            j += 1;
            continue;
          }
        }
        paramString = HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int m = agmx.Es();
    if (m == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
      }
    }
    FileManagerEntity localFileManagerEntity;
    long l;
    do
    {
      String str;
      int j;
      SharedPreferences.Editor localEditor;
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  str = "showTime_" + paramQQAppInterface.getCurrentAccountUin();
                  localFileManagerEntity = paramQQAppInterface.a().c(paramLong);
                  if (localFileManagerEntity != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
                return;
                int k = getFileType(localFileManagerEntity.fileName);
                if (k != -1)
                {
                  j = k;
                  if (k != 11) {}
                }
                else
                {
                  j = getFileType(localFileManagerEntity.getFilePath());
                }
                if ((j == 3) || (j == 6)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
              return;
              if ((localFileManagerEntity.peerType == 0) || (localFileManagerEntity.peerType == 3000)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "aio[" + localFileManagerEntity.peerType + "] not buddy or disc, return!");
            return;
            localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
            localEditor = localSharedPreferences.edit();
            j = localSharedPreferences.getInt("AIOshowTime_Total", 0);
            if (j < m) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
          return;
          paramLong = localSharedPreferences.getLong(str, 0L);
          l = anaz.gQ();
          if (l - paramLong >= 86400000L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
        return;
        if (!aqiz.isAppInstalled(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
      return;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new FileManagerUtil.15(paramQQAppInterface, localFileManagerEntity), 1000L);
      localEditor.putLong(str, l);
      localEditor.putInt("AIOshowTime_Total", j + 1);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "lastShowTime[" + l + "],[" + kZ(localFileManagerEntity.peerUin) + "]add new aiograyTips!");
  }
  
  private static String la(String paramString)
  {
    String str = null;
    if (paramString.equalsIgnoreCase("userClickOnceEvent")) {
      str = "0X800AE45";
    }
    do
    {
      return str;
      if (paramString.equalsIgnoreCase("userClickAlwaysEvent")) {
        return "0X800AE44";
      }
    } while (!paramString.equalsIgnoreCase("userMenuClickEvent"));
    return "0X800AE43";
  }
  
  public static String lb(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = paramString.lastIndexOf(".");
    if ((j > 0) && (j < paramString.length() - 1)) {
      return paramString.substring(j + 1).toUpperCase();
    }
    return "";
  }
  
  public static String lc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    return paramString + "size=750&";
  }
  
  public static boolean mH(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static boolean mI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new VFSFile(paramString).exists();
  }
  
  public static String mapToJson(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static void n(long paramLong, int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (localFileManagerEntity.nOpType)
                {
                case 2: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                default: 
                  return;
                }
              } while (B(paramInt, localFileManagerEntity.fileName));
              if (TextUtils.isEmpty(paramString)) {
                break;
              }
              JI(paramString);
              return;
              if (!TextUtils.isEmpty(paramString))
              {
                JI(paramString);
                return;
              }
            } while (B(paramInt, localFileManagerEntity.fileName));
            B(13, localFileManagerEntity.fileName);
            return;
            if (localFileManagerEntity.nOpType != 4) {
              break;
            }
          } while (!awou.nP(paramInt));
          if (awou.aNo())
          {
            awou.eZ(localQQAppInterface);
            return;
          }
          a(paramInt, paramString, localFileManagerEntity);
          return;
          a(paramInt, paramString, localFileManagerEntity);
          return;
        } while (!awou.nP(paramInt));
        if (awou.aNo())
        {
          awou.eZ(localQQAppInterface);
          return;
        }
      } while (B(paramInt, localFileManagerEntity.fileName));
      if (!TextUtils.isEmpty(paramString))
      {
        JI(paramString);
        return;
      }
      B(11, localFileManagerEntity.fileName);
      return;
    } while (B(paramInt, localFileManagerEntity.fileName));
    if (!TextUtils.isEmpty(paramString))
    {
      JI(paramString);
      return;
    }
    B(11, localFileManagerEntity.fileName);
    return;
    if (!TextUtils.isEmpty(paramString))
    {
      JI(paramString);
      return;
    }
    B(13, localFileManagerEntity.fileName);
    return;
    B(13, localFileManagerEntity.fileName);
    return;
    B(paramInt, null);
  }
  
  public static boolean o(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    }
    for (l1 = l2; l1 + l3 <= anaz.gQ() * 1000L; l1 = 2592000000L) {
      return true;
    }
    return false;
  }
  
  public static void openUrl(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    wgv.c(paramContext, localIntent, paramString);
  }
  
  public static boolean p(FileManagerEntity paramFileManagerEntity)
  {
    return !ahbj.getExtension(paramFileManagerEntity.getFilePath()).equalsIgnoreCase(".mov");
  }
  
  public static boolean q(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        return false;
      } while (paramFileManagerEntity.isZipInnerFile);
      switch (b(paramFileManagerEntity))
      {
      case 5: 
      default: 
        return false;
      case 1: 
      case 2: 
      case 4: 
        return true;
      }
    } while (paramFileManagerEntity.nFileType != 0);
    return true;
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int r(String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if (paramString == null) {
      return 2130845244;
    }
    return hL(getFileType(paramString));
  }
  
  public static boolean r(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
      return false;
    }
    return true;
  }
  
  public static boolean s(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) {
      return true;
    }
    if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath)) {
      return true;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] no Thumb!");
    return false;
  }
  
  public static HashMap<String, String> t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = 0;
      while (j < paramString.length)
      {
        String[] arrayOfString = paramString[j].split("_");
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        j += 1;
      }
    }
    return localHashMap;
  }
  
  public static byte[] t(String paramString)
  {
    return a(paramString, getFileSizes(paramString));
  }
  
  /* Error */
  public static String ti()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 226
    //   5: astore_2
    //   6: aload_2
    //   7: astore_3
    //   8: invokestatic 4406	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   11: invokestatic 3801	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: invokeinterface 4064 2 0
    //   19: checkcast 4408	[Ljava/lang/StackTraceElement;
    //   22: astore 4
    //   24: aload_2
    //   25: astore_3
    //   26: aload 4
    //   28: arraylength
    //   29: istore_1
    //   30: iconst_0
    //   31: istore_0
    //   32: iload_0
    //   33: iload_1
    //   34: if_icmpge +69 -> 103
    //   37: aload 4
    //   39: iload_0
    //   40: aaload
    //   41: astore 5
    //   43: aload_2
    //   44: astore_3
    //   45: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +17 -> 65
    //   51: aload_2
    //   52: astore_3
    //   53: ldc_w 3547
    //   56: iconst_1
    //   57: aload 5
    //   59: invokevirtual 4411	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   62: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_2
    //   66: astore_3
    //   67: new 123	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   74: aload_2
    //   75: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 5
    //   80: invokevirtual 4411	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   83: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 2105
    //   89: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_2
    //   96: iload_0
    //   97: iconst_1
    //   98: iadd
    //   99: istore_0
    //   100: goto -68 -> 32
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_2
    //   107: areturn
    //   108: astore_2
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_2
    //   113: athrow
    //   114: astore_2
    //   115: aload_3
    //   116: astore_2
    //   117: goto -14 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	69	0	j	int
    //   29	6	1	k	int
    //   5	102	2	str1	String
    //   108	5	2	localObject1	Object
    //   114	1	2	localException	Exception
    //   116	1	2	localObject2	Object
    //   7	109	3	str2	String
    //   22	16	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   41	38	5	localStackTraceElement	java.lang.StackTraceElement
    // Exception table:
    //   from	to	target	type
    //   8	24	108	finally
    //   26	30	108	finally
    //   45	51	108	finally
    //   53	65	108	finally
    //   67	96	108	finally
    //   8	24	114	java/lang/Exception
    //   26	30	114	java/lang/Exception
    //   45	51	114	java/lang/Exception
    //   53	65	114	java/lang/Exception
    //   67	96	114	java/lang/Exception
  }
  
  public static String wc()
  {
    return ahaf.a().vZ();
  }
  
  public static byte[] x(String paramString)
  {
    return a(paramString, "SHA-1");
  }
  
  public static byte[] y(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public static class a
  {
    static Executor executor;
    
    static
    {
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "fileassistant_pool";
      localThreadPoolParams.corePoolsize = 2;
      localThreadPoolParams.maxPooolSize = 2;
      localThreadPoolParams.priority = 8;
      localThreadPoolParams.queue = new LinkedBlockingQueue();
      localThreadPoolParams.keepAliveTime = 10;
      executor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
    
    public static Executor getExecutor()
    {
      return executor;
    }
  }
  
  public static abstract interface b
  {
    public abstract void p(Bitmap paramBitmap);
  }
  
  public static class c
    extends DefaultHandler
  {
    private boolean isRootElement;
    private String key;
    private boolean keyElementBegin;
    private Object root;
    Stack<Object> stack = new Stack();
    private boolean valueElementBegin;
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {
      System.out.println("characters:");
      if (paramInt2 > 0)
      {
        if (this.keyElementBegin)
        {
          this.key = new String(paramArrayOfChar, paramInt1, paramInt2);
          System.out.println("key:" + this.key);
        }
        if (this.valueElementBegin)
        {
          if (!HashMap.class.equals(this.stack.peek().getClass())) {
            break label157;
          }
          HashMap localHashMap = (HashMap)this.stack.peek();
          String str = new String(paramArrayOfChar, paramInt1, paramInt2);
          localHashMap.put(this.key, str);
        }
      }
      for (;;)
      {
        System.out.println("value:" + new String(paramArrayOfChar, paramInt1, paramInt2));
        return;
        label157:
        if (ArrayList.class.equals(this.stack.peek().getClass())) {
          ((ArrayList)this.stack.peek()).add(new String(paramArrayOfChar, paramInt1, paramInt2));
        }
      }
    }
    
    public void endDocument()
      throws SAXException
    {
      System.out.println(acfp.m(2131706270));
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      if ((!"plist".equals(paramString3)) || ("key".equals(paramString3))) {
        this.keyElementBegin = false;
      }
      if ("string".equals(paramString3)) {
        this.valueElementBegin = false;
      }
      if ("integer".equals(paramString3)) {
        this.valueElementBegin = false;
      }
      if ("array".equals(paramString3)) {
        this.root = this.stack.pop();
      }
      if ("dict".equals(paramString3)) {
        this.root = this.stack.pop();
      }
    }
    
    public HashMap<String, Object> getMapResult()
    {
      return (HashMap)this.root;
    }
    
    public void startDocument()
      throws SAXException
    {
      System.out.println(acfp.m(2131706259));
    }
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
      throws SAXException
    {
      boolean bool2 = false;
      if ("plist".equals(paramString3)) {
        this.isRootElement = true;
      }
      boolean bool1;
      if ("dict".equals(paramString3))
      {
        if (!this.isRootElement) {
          break label228;
        }
        this.stack.push(new HashMap());
        if (!this.isRootElement)
        {
          bool1 = true;
          this.isRootElement = bool1;
        }
      }
      else
      {
        if ("key".equals(paramString3)) {
          this.keyElementBegin = true;
        }
        if ("true".equals(paramString3)) {
          ((HashMap)this.stack.peek()).put(this.key, Boolean.valueOf(true));
        }
        if ("false".equals(paramString3)) {
          ((HashMap)this.stack.peek()).put(this.key, Boolean.valueOf(false));
        }
        if ("array".equals(paramString3))
        {
          if (!this.isRootElement) {
            break label295;
          }
          paramString1 = new ArrayList();
          this.stack.push(paramString1);
          bool1 = bool2;
          if (!this.isRootElement) {
            bool1 = true;
          }
          this.isRootElement = bool1;
        }
      }
      for (;;)
      {
        if ("string".equals(paramString3)) {
          this.valueElementBegin = true;
        }
        if ("integer".equals(paramString3)) {
          this.valueElementBegin = true;
        }
        return;
        bool1 = false;
        break;
        label228:
        paramString1 = this.stack.peek();
        paramString2 = new HashMap();
        if ((paramString1 instanceof ArrayList)) {
          ((ArrayList)paramString1).add(paramString2);
        }
        for (;;)
        {
          this.stack.push(paramString2);
          break;
          if ((paramString1 instanceof HashMap)) {
            ((HashMap)paramString1).put(this.key, paramString2);
          }
        }
        label295:
        paramString1 = (HashMap)this.stack.peek();
        paramString2 = new ArrayList();
        this.stack.push(paramString2);
        paramString1.put(this.key, paramString2);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void onClick(View paramView);
  }
  
  public static class e
  {
    public String bN;
    public int gP;
    public int mThumbWidth;
    public String mVideoMd5;
    public int retCode;
  }
  
  public static abstract interface f
  {
    public abstract void JC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahav
 * JD-Core Version:    0.7.0.1
 */