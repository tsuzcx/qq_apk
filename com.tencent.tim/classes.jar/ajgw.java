import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ajgw
  implements ajlt, AdapterView.OnItemClickListener
{
  public static String bRl = acbn.SDCARD_PATH + "TempMail" + File.separator;
  private static String bRm = acfp.m(2131702286);
  public static String bRn = "0X8007F0A ";
  public static String bRo = "0X8007F0B ";
  public static String bRp = "0X8007F0C ";
  public static String bRq = "0X8007F0D ";
  public static String bRr = "0X8007F0E ";
  public static String bRs = "0X8007F0F ";
  public static String bRt = "0X8007F10 ";
  public static String bRu = "0X800A77E";
  WXShareHelper.a a;
  protected ShareActionSheetBuilder b;
  private boolean coz;
  private BaseChatPie f;
  private Activity mActivity;
  QQAppInterface mApp;
  private Context mContext;
  protected MqqHandler uiHandler;
  
  public ajgw(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mActivity = paramActivity;
    this.f = paramBaseChatPie;
    this.uiHandler = paramMqqHandler;
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    URL localURL = aoop.a(paramMessageForPic, 131075);
    if (aoiz.getFile(localURL.toString()) != null) {
      return aoiz.getFilePath(localURL.toString());
    }
    localURL = aoop.a(paramMessageForPic, 1);
    if (aoiz.getFile(localURL.toString()) != null) {
      return aoiz.getFilePath(localURL.toString());
    }
    paramMessageForPic = aoop.a(paramMessageForPic, 65537);
    if (aoiz.getFile(paramMessageForPic.toString()) != null) {
      return aoiz.getFilePath(paramMessageForPic.toString());
    }
    return null;
  }
  
  public static String a(MessageForPic paramMessageForPic, List<String> paramList1, List<String> paramList2)
  {
    String str1 = a(paramMessageForPic);
    if (str1 == null)
    {
      QLog.e("AIOShareActionSheet", 1, new Object[] { "getPicMsgPath null, ", paramMessageForPic.getUserLogString() });
      return null;
    }
    paramList1.add(str1);
    String str2 = new File(str1).getName();
    paramMessageForPic = "";
    if (str2.indexOf(".") == -1) {
      paramMessageForPic = aqhq.estimateFileType(str1);
    }
    paramMessageForPic = acfp.m(2131702290) + paramList1.size() + "." + paramMessageForPic;
    paramList1 = paramMessageForPic + acfp.m(2131702285);
    paramList2.add(paramMessageForPic);
    return paramList1;
  }
  
  public boolean M(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (acei.W(paramChatMessage))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      if ((localMessageForStructing.structingMsg != null) && ("viewMultiMsg".equals(localMessageForStructing.structingMsg.mMsgAction))) {
        return true;
      }
    }
    else if (((paramChatMessage instanceof MessageForPic)) && (ykm.d((MessageForPic)paramChatMessage)))
    {
      return false;
    }
    return acrb.ac(paramChatMessage);
  }
  
  public boolean N(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (acei.W(paramChatMessage))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForPic)) && (ykm.d((MessageForPic)paramChatMessage))) {
      return false;
    }
    return acrb.ac(paramChatMessage);
  }
  
  public Uri a(String paramString)
  {
    paramString = new File(bRl + paramString);
    if (Build.VERSION.SDK_INT >= 24) {
      return FileProvider.getUriForFile(this.mContext, "com.tencent.tim.fileprovider", paramString);
    }
    return Uri.fromFile(paramString);
  }
  
  public void a(ajlq paramajlq) {}
  
  public void a(ajlq paramajlq, int paramInt) {}
  
  /* Error */
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokevirtual 273	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5: checkcast 275	com/tencent/mobileqq/data/ChatMessage
    //   8: astore 6
    //   10: ldc 173
    //   12: astore 5
    //   14: aload 6
    //   16: getfield 278	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   19: ifne +725 -> 744
    //   22: aload_0
    //   23: getfield 112	ajgw:mContext	Landroid/content/Context;
    //   26: ldc_w 279
    //   29: invokevirtual 284	android/content/Context:getString	(I)Ljava/lang/String;
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 110	ajgw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload 6
    //   44: getfield 287	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   47: invokestatic 293	aqgv:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 110	ajgw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: aload 6
    //   59: getfield 296	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   62: invokestatic 293	aqgv:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 300	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: astore 5
    //   71: aload_3
    //   72: ldc_w 302
    //   75: aload 5
    //   77: invokevirtual 308	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   84: iconst_1
    //   85: invokestatic 312	aqhq:delete	(Ljava/lang/String;Z)V
    //   88: new 55	java/io/File
    //   91: dup
    //   92: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   95: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 316	java/io/File:isDirectory	()Z
    //   105: ifeq +17 -> 122
    //   108: aload 7
    //   110: invokevirtual 319	java/io/File:exists	()Z
    //   113: ifne +9 -> 122
    //   116: aload 7
    //   118: invokevirtual 322	java/io/File:mkdirs	()Z
    //   121: pop
    //   122: new 269	java/util/ArrayList
    //   125: dup
    //   126: invokespecial 323	java/util/ArrayList:<init>	()V
    //   129: astore 12
    //   131: new 269	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 323	java/util/ArrayList:<init>	()V
    //   138: astore 10
    //   140: new 269	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 323	java/util/ArrayList:<init>	()V
    //   147: astore 13
    //   149: new 269	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 323	java/util/ArrayList:<init>	()V
    //   156: astore 11
    //   158: new 39	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   165: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   168: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 73	ajgw:bRm	Ljava/lang/String;
    //   174: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 326	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   183: pop
    //   184: new 328	java/io/BufferedWriter
    //   187: dup
    //   188: new 330	java/io/FileWriter
    //   191: dup
    //   192: new 39	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   199: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   202: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: getstatic 73	ajgw:bRm	Ljava/lang/String;
    //   208: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 331	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 334	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   220: astore 8
    //   222: new 39	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   229: astore 14
    //   231: aload 14
    //   233: ldc_w 336
    //   236: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 14
    //   242: ldc_w 338
    //   245: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 5
    //   250: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 340
    //   256: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 8
    //   262: new 39	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   269: aload 5
    //   271: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 342
    //   277: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   286: new 347	java/text/SimpleDateFormat
    //   289: dup
    //   290: ldc 173
    //   292: getstatic 353	java/util/Locale:SIMPLIFIED_CHINESE	Ljava/util/Locale;
    //   295: invokespecial 356	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   298: astore 15
    //   300: aload 15
    //   302: ldc_w 358
    //   305: invokevirtual 361	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   308: aload 15
    //   310: aload 6
    //   312: getfield 365	com/tencent/mobileqq/data/ChatMessage:time	J
    //   315: ldc2_w 366
    //   318: lmul
    //   319: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: invokevirtual 376	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: astore 6
    //   327: aload 14
    //   329: ldc_w 378
    //   332: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 6
    //   337: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 380
    //   343: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 8
    //   349: new 39	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 382
    //   359: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 6
    //   364: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 384
    //   370: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   379: iconst_0
    //   380: istore 4
    //   382: iload 4
    //   384: aload_2
    //   385: invokevirtual 385	java/util/ArrayList:size	()I
    //   388: if_icmpge +840 -> 1228
    //   391: aload_2
    //   392: iload 4
    //   394: invokevirtual 273	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   397: checkcast 275	com/tencent/mobileqq/data/ChatMessage
    //   400: astore 16
    //   402: aconst_null
    //   403: astore 5
    //   405: aload 16
    //   407: instanceof 387
    //   410: ifeq +445 -> 855
    //   413: aload 16
    //   415: checkcast 387	com/tencent/mobileqq/data/MessageForText
    //   418: astore 5
    //   420: aload 5
    //   422: getfield 391	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   425: ifnull +420 -> 845
    //   428: aload 5
    //   430: getfield 391	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   433: invokeinterface 394 1 0
    //   438: astore 5
    //   440: aload 5
    //   442: astore 7
    //   444: aload 5
    //   446: invokestatic 399	aofy:Z	(Ljava/lang/String;)Z
    //   449: ifeq +1188 -> 1637
    //   452: aload 5
    //   454: invokestatic 401	aofy:M	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 7
    //   459: goto +1178 -> 1637
    //   462: aload 6
    //   464: astore 7
    //   466: aload 5
    //   468: ifnull +259 -> 727
    //   471: aload 15
    //   473: ldc_w 358
    //   476: invokevirtual 361	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   479: aload 15
    //   481: aload 16
    //   483: getfield 365	com/tencent/mobileqq/data/ChatMessage:time	J
    //   486: ldc2_w 366
    //   489: lmul
    //   490: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: invokevirtual 376	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   496: astore 9
    //   498: aload 6
    //   500: astore 7
    //   502: aload 9
    //   504: aload 6
    //   506: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   509: ifne +59 -> 568
    //   512: aload 14
    //   514: ldc_w 378
    //   517: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 9
    //   522: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 380
    //   528: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 8
    //   534: new 39	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 382
    //   544: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 9
    //   549: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 384
    //   555: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokevirtual 345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   564: aload 9
    //   566: astore 7
    //   568: aload 15
    //   570: ldc_w 403
    //   573: invokevirtual 361	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   576: aload 15
    //   578: aload 16
    //   580: getfield 365	com/tencent/mobileqq/data/ChatMessage:time	J
    //   583: ldc2_w 366
    //   586: lmul
    //   587: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   590: invokevirtual 376	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   593: astore 6
    //   595: aload 14
    //   597: ldc_w 405
    //   600: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: aload 16
    //   606: getfield 408	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   609: invokeinterface 413 2 0
    //   614: checkcast 177	java/lang/String
    //   617: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: ldc_w 415
    //   623: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload 6
    //   628: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc_w 417
    //   634: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 14
    //   640: aload 5
    //   642: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: ldc_w 419
    //   648: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 8
    //   654: new 39	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   661: aload_1
    //   662: aload 16
    //   664: getfield 408	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   667: invokeinterface 413 2 0
    //   672: checkcast 177	java/lang/String
    //   675: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc_w 421
    //   681: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 6
    //   686: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 423
    //   692: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokevirtual 345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   701: aload 8
    //   703: new 39	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   710: aload 5
    //   712: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc_w 425
    //   718: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   727: aload 7
    //   729: astore 5
    //   731: iload 4
    //   733: iconst_1
    //   734: iadd
    //   735: istore 4
    //   737: aload 5
    //   739: astore 6
    //   741: goto -359 -> 382
    //   744: aload 6
    //   746: getfield 278	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   749: iconst_1
    //   750: if_icmpne +40 -> 790
    //   753: aload_0
    //   754: getfield 112	ajgw:mContext	Landroid/content/Context;
    //   757: ldc_w 426
    //   760: invokevirtual 284	android/content/Context:getString	(I)Ljava/lang/String;
    //   763: iconst_1
    //   764: anewarray 4	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: aload_0
    //   770: getfield 110	ajgw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   773: aload 6
    //   775: getfield 296	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   778: invokestatic 429	aqgv:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   781: aastore
    //   782: invokestatic 300	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   785: astore 5
    //   787: goto -716 -> 71
    //   790: aload 6
    //   792: getfield 278	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   795: sipush 3000
    //   798: if_icmpne -727 -> 71
    //   801: aload_0
    //   802: getfield 112	ajgw:mContext	Landroid/content/Context;
    //   805: ldc_w 426
    //   808: invokevirtual 284	android/content/Context:getString	(I)Ljava/lang/String;
    //   811: iconst_1
    //   812: anewarray 4	java/lang/Object
    //   815: dup
    //   816: iconst_0
    //   817: aload_0
    //   818: getfield 110	ajgw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   821: aload_0
    //   822: getfield 110	ajgw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   825: invokevirtual 435	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   828: aload 6
    //   830: getfield 296	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   833: invokestatic 438	aqgv:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   836: aastore
    //   837: invokestatic 300	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   840: astore 5
    //   842: goto -771 -> 71
    //   845: aload 5
    //   847: getfield 441	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   850: astore 5
    //   852: goto -412 -> 440
    //   855: aload 16
    //   857: instanceof 150
    //   860: ifeq +20 -> 880
    //   863: aload 16
    //   865: checkcast 150	com/tencent/mobileqq/data/MessageForPic
    //   868: aload 12
    //   870: aload 13
    //   872: invokestatic 443	ajgw:a	(Lcom/tencent/mobileqq/data/MessageForPic;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   875: astore 5
    //   877: goto -415 -> 462
    //   880: aload 16
    //   882: instanceof 445
    //   885: ifeq +135 -> 1020
    //   888: aload 16
    //   890: checkcast 445	com/tencent/mobileqq/data/MessageForShortVideo
    //   893: invokestatic 450	com/tencent/mobileqq/shortvideo/ShortVideoUtils:e	(Lcom/tencent/mobileqq/data/MessageForShortVideo;)Ljava/lang/String;
    //   896: astore 5
    //   898: aload 5
    //   900: ifnonnull +34 -> 934
    //   903: ldc 146
    //   905: iconst_1
    //   906: iconst_2
    //   907: anewarray 4	java/lang/Object
    //   910: dup
    //   911: iconst_0
    //   912: ldc_w 452
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload 16
    //   920: invokevirtual 453	com/tencent/mobileqq/data/ChatMessage:getUserLogString	()Ljava/lang/String;
    //   923: aastore
    //   924: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   927: aload 6
    //   929: astore 5
    //   931: goto -200 -> 731
    //   934: aload 10
    //   936: aload 5
    //   938: invokeinterface 165 2 0
    //   943: pop
    //   944: new 39	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 454
    //   954: invokestatic 71	acfp:m	(I)Ljava/lang/String;
    //   957: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 10
    //   962: invokeinterface 191 1 0
    //   967: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: ldc_w 456
    //   973: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: astore 7
    //   981: new 39	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   988: aload 7
    //   990: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 457
    //   996: invokestatic 71	acfp:m	(I)Ljava/lang/String;
    //   999: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: astore 5
    //   1007: aload 11
    //   1009: aload 7
    //   1011: invokeinterface 165 2 0
    //   1016: pop
    //   1017: goto -555 -> 462
    //   1020: aload 16
    //   1022: instanceof 459
    //   1025: ifne +11 -> 1036
    //   1028: aload 16
    //   1030: instanceof 461
    //   1033: ifeq +22 -> 1055
    //   1036: aload 16
    //   1038: aload 12
    //   1040: aload 13
    //   1042: invokestatic 465	com/tencent/mobileqq/data/MessageForMixedMsg:getTextFromMixedMsgForMail	(Lcom/tencent/mobileqq/data/ChatMessage;Ljava/util/List;Ljava/util/List;)Ljava/lang/CharSequence;
    //   1045: invokeinterface 394 1 0
    //   1050: astore 5
    //   1052: goto -590 -> 462
    //   1055: aload 16
    //   1057: instanceof 213
    //   1060: ifeq -598 -> 462
    //   1063: aload 16
    //   1065: checkcast 213	com/tencent/mobileqq/data/MessageForStructing
    //   1068: astore 7
    //   1070: aload 7
    //   1072: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1075: ifnull +556 -> 1631
    //   1078: aload 7
    //   1080: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1083: instanceof 467
    //   1086: ifeq +36 -> 1122
    //   1089: aload 7
    //   1091: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1094: checkcast 467	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   1097: iconst_0
    //   1098: invokevirtual 471	com/tencent/mobileqq/structmsg/StructMsgForHypertext:getSpannableString	(Z)Landroid/text/SpannableStringBuilder;
    //   1101: invokevirtual 474	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   1104: astore 5
    //   1106: aload 5
    //   1108: ifnonnull +517 -> 1625
    //   1111: ldc_w 475
    //   1114: invokestatic 71	acfp:m	(I)Ljava/lang/String;
    //   1117: astore 5
    //   1119: goto -657 -> 462
    //   1122: ldc 219
    //   1124: aload 7
    //   1126: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1129: getfield 224	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgAction	Ljava/lang/String;
    //   1132: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1135: ifeq +14 -> 1149
    //   1138: ldc_w 476
    //   1141: invokestatic 71	acfp:m	(I)Ljava/lang/String;
    //   1144: astore 5
    //   1146: goto -40 -> 1106
    //   1149: aload 7
    //   1151: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1154: getfield 479	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1157: bipush 32
    //   1159: if_icmpne +14 -> 1173
    //   1162: aload_0
    //   1163: aload 7
    //   1165: invokevirtual 483	ajgw:g	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   1168: astore 5
    //   1170: goto -64 -> 1106
    //   1173: aload 7
    //   1175: invokevirtual 486	com/tencent/mobileqq/data/MessageForStructing:getSummaryMsg	()Ljava/lang/String;
    //   1178: astore 5
    //   1180: aload 7
    //   1182: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1185: getfield 489	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1188: ifnull +440 -> 1628
    //   1191: new 39	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1198: aload 5
    //   1200: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: ldc_w 423
    //   1206: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload 7
    //   1211: getfield 217	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1214: getfield 489	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1217: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: astore 5
    //   1225: goto -119 -> 1106
    //   1228: aload 14
    //   1230: ldc_w 491
    //   1233: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: pop
    //   1237: aload_3
    //   1238: ldc_w 493
    //   1241: aload 14
    //   1243: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokestatic 499	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   1249: invokevirtual 502	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   1252: pop
    //   1253: aload 8
    //   1255: invokevirtual 505	java/io/BufferedWriter:flush	()V
    //   1258: aload 8
    //   1260: ifnull +8 -> 1268
    //   1263: aload 8
    //   1265: invokevirtual 508	java/io/BufferedWriter:close	()V
    //   1268: new 269	java/util/ArrayList
    //   1271: dup
    //   1272: invokespecial 323	java/util/ArrayList:<init>	()V
    //   1275: astore_1
    //   1276: aload_1
    //   1277: aload_0
    //   1278: getstatic 73	ajgw:bRm	Ljava/lang/String;
    //   1281: invokevirtual 510	ajgw:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1284: invokevirtual 511	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1287: pop
    //   1288: aload 12
    //   1290: invokeinterface 514 1 0
    //   1295: ifne +169 -> 1464
    //   1298: aload 12
    //   1300: invokeinterface 518 1 0
    //   1305: astore_2
    //   1306: aload_2
    //   1307: invokeinterface 523 1 0
    //   1312: ifeq +152 -> 1464
    //   1315: aload_2
    //   1316: invokeinterface 527 1 0
    //   1321: checkcast 177	java/lang/String
    //   1324: astore 5
    //   1326: aload 5
    //   1328: new 39	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1335: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   1338: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: aload 13
    //   1343: aload 12
    //   1345: aload 5
    //   1347: invokeinterface 530 2 0
    //   1352: invokeinterface 531 2 0
    //   1357: checkcast 177	java/lang/String
    //   1360: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 535	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1369: ifeq -63 -> 1306
    //   1372: aload_1
    //   1373: aload_0
    //   1374: aload 13
    //   1376: aload 12
    //   1378: aload 5
    //   1380: invokeinterface 530 2 0
    //   1385: invokeinterface 531 2 0
    //   1390: checkcast 177	java/lang/String
    //   1393: invokevirtual 510	ajgw:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1396: invokevirtual 511	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1399: pop
    //   1400: goto -94 -> 1306
    //   1403: astore_1
    //   1404: aload_1
    //   1405: invokevirtual 538	java/io/IOException:printStackTrace	()V
    //   1408: goto -140 -> 1268
    //   1411: astore_2
    //   1412: aconst_null
    //   1413: astore_1
    //   1414: ldc 146
    //   1416: iconst_1
    //   1417: ldc_w 540
    //   1420: aload_2
    //   1421: invokestatic 543	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1424: aload_1
    //   1425: ifnull -157 -> 1268
    //   1428: aload_1
    //   1429: invokevirtual 508	java/io/BufferedWriter:close	()V
    //   1432: goto -164 -> 1268
    //   1435: astore_1
    //   1436: aload_1
    //   1437: invokevirtual 538	java/io/IOException:printStackTrace	()V
    //   1440: goto -172 -> 1268
    //   1443: astore_1
    //   1444: aconst_null
    //   1445: astore_2
    //   1446: aload_2
    //   1447: ifnull +7 -> 1454
    //   1450: aload_2
    //   1451: invokevirtual 508	java/io/BufferedWriter:close	()V
    //   1454: aload_1
    //   1455: athrow
    //   1456: astore_2
    //   1457: aload_2
    //   1458: invokevirtual 538	java/io/IOException:printStackTrace	()V
    //   1461: goto -7 -> 1454
    //   1464: aload 10
    //   1466: invokeinterface 514 1 0
    //   1471: ifne +108 -> 1579
    //   1474: aload 10
    //   1476: invokeinterface 518 1 0
    //   1481: astore_2
    //   1482: aload_2
    //   1483: invokeinterface 523 1 0
    //   1488: ifeq +91 -> 1579
    //   1491: aload_2
    //   1492: invokeinterface 527 1 0
    //   1497: checkcast 177	java/lang/String
    //   1500: astore 5
    //   1502: aload 5
    //   1504: new 39	java/lang/StringBuilder
    //   1507: dup
    //   1508: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1511: getstatic 64	ajgw:bRl	Ljava/lang/String;
    //   1514: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: aload 11
    //   1519: aload 10
    //   1521: aload 5
    //   1523: invokeinterface 530 2 0
    //   1528: invokeinterface 531 2 0
    //   1533: checkcast 177	java/lang/String
    //   1536: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 535	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1545: ifeq -63 -> 1482
    //   1548: aload_1
    //   1549: aload_0
    //   1550: aload 11
    //   1552: aload 10
    //   1554: aload 5
    //   1556: invokeinterface 530 2 0
    //   1561: invokeinterface 531 2 0
    //   1566: checkcast 177	java/lang/String
    //   1569: invokevirtual 510	ajgw:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1572: invokevirtual 511	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1575: pop
    //   1576: goto -94 -> 1482
    //   1579: aload_3
    //   1580: ldc_w 545
    //   1583: aload_1
    //   1584: invokevirtual 549	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1587: pop
    //   1588: getstatic 246	android/os/Build$VERSION:SDK_INT	I
    //   1591: bipush 24
    //   1593: if_icmplt +9 -> 1602
    //   1596: aload_3
    //   1597: iconst_1
    //   1598: invokevirtual 553	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1601: pop
    //   1602: return
    //   1603: astore_1
    //   1604: aload 8
    //   1606: astore_2
    //   1607: goto -161 -> 1446
    //   1610: astore_3
    //   1611: aload_1
    //   1612: astore_2
    //   1613: aload_3
    //   1614: astore_1
    //   1615: goto -169 -> 1446
    //   1618: astore_2
    //   1619: aload 8
    //   1621: astore_1
    //   1622: goto -208 -> 1414
    //   1625: goto -1163 -> 462
    //   1628: goto -522 -> 1106
    //   1631: aconst_null
    //   1632: astore 5
    //   1634: goto -528 -> 1106
    //   1637: aload 7
    //   1639: astore 5
    //   1641: goto -1179 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1644	0	this	ajgw
    //   0	1644	1	paramMap	Map<String, String>
    //   0	1644	2	paramArrayList	ArrayList<ChatMessage>
    //   0	1644	3	paramIntent	Intent
    //   380	356	4	i	int
    //   12	1628	5	localObject1	Object
    //   8	920	6	localObject2	Object
    //   98	1540	7	localObject3	Object
    //   220	1400	8	localBufferedWriter	java.io.BufferedWriter
    //   496	69	9	str	String
    //   138	1415	10	localArrayList1	ArrayList
    //   156	1395	11	localArrayList2	ArrayList
    //   129	1248	12	localArrayList3	ArrayList
    //   147	1228	13	localArrayList4	ArrayList
    //   229	1013	14	localStringBuilder	StringBuilder
    //   298	279	15	localSimpleDateFormat	SimpleDateFormat
    //   400	664	16	localChatMessage	ChatMessage
    // Exception table:
    //   from	to	target	type
    //   1263	1268	1403	java/io/IOException
    //   158	222	1411	java/lang/Throwable
    //   1428	1432	1435	java/io/IOException
    //   158	222	1443	finally
    //   1450	1454	1456	java/io/IOException
    //   222	379	1603	finally
    //   382	402	1603	finally
    //   405	440	1603	finally
    //   444	459	1603	finally
    //   471	498	1603	finally
    //   502	564	1603	finally
    //   568	727	1603	finally
    //   845	852	1603	finally
    //   855	877	1603	finally
    //   880	898	1603	finally
    //   903	927	1603	finally
    //   934	1017	1603	finally
    //   1020	1036	1603	finally
    //   1036	1052	1603	finally
    //   1055	1106	1603	finally
    //   1111	1119	1603	finally
    //   1122	1146	1603	finally
    //   1149	1170	1603	finally
    //   1173	1225	1603	finally
    //   1228	1258	1603	finally
    //   1414	1424	1610	finally
    //   222	379	1618	java/lang/Throwable
    //   382	402	1618	java/lang/Throwable
    //   405	440	1618	java/lang/Throwable
    //   444	459	1618	java/lang/Throwable
    //   471	498	1618	java/lang/Throwable
    //   502	564	1618	java/lang/Throwable
    //   568	727	1618	java/lang/Throwable
    //   845	852	1618	java/lang/Throwable
    //   855	877	1618	java/lang/Throwable
    //   880	898	1618	java/lang/Throwable
    //   903	927	1618	java/lang/Throwable
    //   934	1017	1618	java/lang/Throwable
    //   1020	1036	1618	java/lang/Throwable
    //   1036	1052	1618	java/lang/Throwable
    //   1055	1106	1618	java/lang/Throwable
    //   1111	1119	1618	java/lang/Throwable
    //   1122	1146	1618	java/lang/Throwable
    //   1149	1170	1618	java/lang/Throwable
    //   1173	1225	1618	java/lang/Throwable
    //   1228	1258	1618	java/lang/Throwable
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (wja.eU(2) == 0)
    {
      i = 1;
      if (wja.eU(3) != 0) {
        break label471;
      }
    }
    label471:
    for (int j = 1;; j = 0)
    {
      Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131698652);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839256;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
      localArrayList.add(localObject);
      localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131698636);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839544;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 25;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
      localArrayList.add(localObject);
      localObject = new ArrayList();
      if (i != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.label = paramContext.getString(2131698638);
        localActionSheetItem.icon = 2130839582;
        localActionSheetItem.iconNeedBg = true;
        localActionSheetItem.action = 26;
        localActionSheetItem.argus = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      if (ykf.gI(this.f.sessionInfo.cZ))
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.label = paramContext.getString(2131690254);
        localActionSheetItem.icon = 2130838047;
        localActionSheetItem.iconNeedBg = true;
        localActionSheetItem.action = 139;
        localActionSheetItem.argus = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      if (j != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.label = paramContext.getString(2131698655);
        localActionSheetItem.icon = 2130839732;
        localActionSheetItem.iconNeedBg = true;
        localActionSheetItem.action = 27;
        localActionSheetItem.argus = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131698634);
      localActionSheetItem.icon = 2130839246;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 28;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131698629);
      localActionSheetItem.icon = 2130840413;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 47;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
      return (List[])new ArrayList[] { localArrayList, localObject };
      i = 0;
      break;
    }
  }
  
  public void aAL()
  {
    Iterator localIterator = ajlc.a().fH().iterator();
    ChatMessage localChatMessage;
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localChatMessage = (ChatMessage)localIterator.next();
      i = xeh.a(this.mApp, localChatMessage);
    } while ((!(localChatMessage instanceof MessageForPic)) || (i != 1) || (aqiu.a(this.mApp, (MessageForPic)localChatMessage, false)));
    for (boolean bool = true;; bool = false)
    {
      if ((this.b == null) || (this.coz != bool))
      {
        this.coz = bool;
        this.b = new ShareActionSheetBuilder(this.mActivity);
        i = DisplayUtil.dip2px(this.mContext, 4.0F);
        int j = this.b.getIconMarginLeftRight();
        this.b.setIconMarginLeftRight(Math.max(i, j));
        this.b.setActionSheetTitle(this.mContext.getString(2131720177));
        this.b.setActionSheetItems(a(this.mContext));
        this.b.setItemClickListener(this);
      }
      try
      {
        this.b.show();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
        return;
      }
    }
  }
  
  public boolean aqE()
  {
    Iterator localIterator = ajlc.a().lC.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= acei.W((MessageRecord)localObject);
        if (acrb.b(this.mApp, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        do
        {
          return false;
          bool1 = bool2;
          if (!(localObject instanceof MessageForTroopFile)) {
            break;
          }
          localObject = (MessageForTroopFile)localObject;
          localObject = apsv.a(this.mApp, (MessageForTroopFile)localObject);
        } while (localObject == null);
        bool1 = bool2;
        if (((apcy)localObject).Status == 8) {
          break;
        }
        bool1 = bool2;
        if (((apcy)localObject).Status == 9) {
          break;
        }
        bool1 = bool2;
        if (((apcy)localObject).Status == 6) {
          break;
        }
        bool1 = bool2;
        if (((apcy)localObject).Status == 7) {
          break;
        }
        if (((apcy)localObject).Status == 11)
        {
          bool1 = bool2;
          if (ahbj.isFileExists(((apcy)localObject).LocalFile)) {
            break;
          }
        }
      } while (((apcy)localObject).Status != 10);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean aqF()
  {
    Iterator localIterator = ajlc.a().lC.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= acei.W((MessageRecord)localObject);
        if (acrb.a(this.mApp, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        return false;
        bool1 = bool2;
        if (!(localObject instanceof MessageForTroopFile)) {
          break;
        }
        localObject = (MessageForTroopFile)localObject;
      } while (apsv.a(this.mApp, (MessageForTroopFile)localObject) == null);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean aqG()
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(this.mApp.getApp(), 2131693404, 0).show(this.f.getTitleBarHeight());
      return false;
    }
    Object localObject1 = ajlc.a().fH();
    if (((List)localObject1).size() == 0)
    {
      QQToast.a(this.mApp.getApp(), 2131700602, 0).show(this.f.getTitleBarHeight());
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (ChatMessage)((List)localObject1).get(i);
      if ((localObject2 instanceof MessageForTroopFile)) {
        localArrayList1.add((MessageForTroopFile)localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject2 instanceof MessageForFile)) {
          localArrayList2.add((MessageForFile)localObject2);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      localObject1 = localArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForTroopFile)((Iterator)localObject1).next();
        apsv.c(this.mContext, this.mApp, (ChatMessage)localObject2);
      }
    }
    MessageForFile localMessageForFile;
    FileManagerEntity localFileManagerEntity;
    if (localArrayList2.size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject2).next();
        localFileManagerEntity = ahav.a(this.mApp, localMessageForFile);
        if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.cloudType != 2)) {
          ((ArrayList)localObject1).add(localMessageForFile);
        }
      }
      if (((ArrayList)localObject1).size() == 0)
      {
        ahao.OS(2131693820);
        return false;
      }
      if (((ArrayList)localObject1).size() != 1) {
        break label416;
      }
      localObject1 = (MessageForFile)((ArrayList)localObject1).get(0);
      localObject2 = ahav.a(this.mApp, (MessageForFile)localObject1);
      if (localObject2 == null)
      {
        ahao.OS(2131693820);
        return false;
      }
      if (((FileManagerEntity)localObject2).status == 16)
      {
        ahao.OS(2131694128);
        return false;
      }
      ahav.a(this.mApp, (ChatMessage)localObject1, BaseActivity.sTopActivity);
    }
    while ((localArrayList1.size() == 0) && (localArrayList2.size() == 0))
    {
      ahao.OS(2131693821);
      return false;
      label416:
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject1).next();
        localFileManagerEntity = ahav.a(this.mApp, localMessageForFile);
        if ((localFileManagerEntity != null) && (localFileManagerEntity.status != 16)) {
          ((List)localObject2).add(localMessageForFile);
        }
      }
      if (((List)localObject2).size() == 0)
      {
        ahao.OS(2131693820);
        return false;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForFile)((Iterator)localObject1).next();
        ahav.a(this.mApp, (ChatMessage)localObject2, BaseActivity.sTopActivity);
      }
    }
    return true;
  }
  
  public boolean aqH()
  {
    Iterator localIterator = ajlc.a().lC.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!M((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean aqI()
  {
    List localList = ajlc.a().fH();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!M(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.a(this.mApp.getApp(), 2131696119, 0).show(this.f.getTitleBarHeight());
      return false;
    }
    ((wwb)this.f.a(1)).I(localList, 3);
    return true;
  }
  
  public boolean aqJ()
  {
    Iterator localIterator = ajlc.a().lC.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!N((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean aqK()
  {
    List localList = ajlc.a().fH();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!N(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.a(this.mApp.getApp(), 2131696124, 0).show(this.f.getTitleBarHeight());
      return false;
    }
    ((wwb)this.f.a(1)).I(localList, 4);
    return true;
  }
  
  public void b(ajlq paramajlq) {}
  
  public void bKe() {}
  
  public void c(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {}
    Intent localIntent;
    label302:
    do
    {
      for (;;)
      {
        return;
        localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_ac");
        localIntent.setType("message/rfc822");
        a(paramMap, paramArrayList, localIntent);
        for (;;)
        {
          Object localObject;
          try
          {
            paramArrayList = this.mContext.getPackageManager().queryIntentActivities(localIntent, 0);
            if (paramArrayList.isEmpty()) {
              break;
            }
            paramMap = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (!paramArrayList.hasNext()) {
              break label302;
            }
            localObject = (ResolveInfo)paramArrayList.next();
            if ((!((ResolveInfo)localObject).activityInfo.packageName.toLowerCase().contains("mail")) && (!((ResolveInfo)localObject).activityInfo.name.toLowerCase().contains("mail"))) {
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.equals("com.tencent.androidqqmail"))
            {
              if (((ResolveInfo)localObject).activityInfo.name.contains("LaunchComposeNote")) {
                continue;
              }
              localObject = new ComponentName(((ResolveInfo)localObject).activityInfo.applicationInfo.packageName, ((ResolveInfo)localObject).activityInfo.name);
              localIntent.setPackage(null);
              localIntent.setComponent((ComponentName)localObject);
              paramMap.add((Intent)localIntent.clone());
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.contains("bluetooth")) {
              continue;
            }
          }
          catch (Exception paramMap)
          {
            QLog.e("AIOShareActionSheet", 1, "realSendToMail error_2, ", paramMap);
            return;
          }
          if (!((ResolveInfo)localObject).activityInfo.name.contains("bluetooth"))
          {
            localIntent.setComponent(null);
            localIntent.setPackage(((ResolveInfo)localObject).activityInfo.packageName);
          }
        }
        try
        {
          paramArrayList = Intent.createChooser((Intent)paramMap.remove(0), acfp.m(2131702284));
          if (paramArrayList != null)
          {
            paramArrayList.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramMap.toArray(new Parcelable[0]));
            paramArrayList.putExtra("big_brother_source_key", "biz_src_jc_ac");
            this.mContext.startActivity(paramArrayList);
            return;
          }
        }
        catch (Exception paramMap)
        {
          QLog.e("AIOShareActionSheet", 1, "realSendToMail error_1, ", paramMap);
        }
      }
    } while (!(paramMap instanceof ClassCastException));
    paramMap = new ArrayList();
    paramMap.add(localIntent.getCharSequenceExtra("android.intent.extra.TEXT"));
    localIntent.removeExtra("android.intent.extra.TEXT");
    localIntent.putCharSequenceArrayListExtra("android.intent.extra.TEXT", paramMap);
    this.mContext.startActivity(Intent.createChooser(localIntent, acfp.m(2131702282)));
  }
  
  public void d(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    ChatMessage localChatMessage;
    Object localObject1;
    Object localObject2;
    if (i < paramArrayList.size())
    {
      localChatMessage = (ChatMessage)paramArrayList.get(i);
      if ((localChatMessage instanceof MessageForText))
      {
        localObject1 = (MessageForText)localChatMessage;
        if (((MessageForText)localObject1).sb != null)
        {
          localObject2 = ((MessageForText)localObject1).sb.toString();
          label64:
          localObject1 = localObject2;
          if (aofy.Z((String)localObject2)) {
            localObject1 = aofy.M((String)localObject2);
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
          ((SimpleDateFormat)localObject2).applyPattern("HH:mm:ss");
          localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(localChatMessage.time * 1000L));
          localStringBuilder.append((String)paramMap.get(localChatMessage.senderuin)).append(" ").append((String)localObject2).append("\n").append((String)localObject1).append("\n");
          if (i != paramArrayList.size() - 1) {
            localStringBuilder.append("\n");
          }
        }
        i += 1;
        break;
        localObject2 = ((MessageForText)localObject1).msg;
        break label64;
        if ((localChatMessage instanceof MessageForPic))
        {
          localObject1 = acfp.m(2131702283);
        }
        else if ((localChatMessage instanceof MessageForShortVideo))
        {
          localObject1 = acfp.m(2131702287);
        }
        else
        {
          if ((!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForLongMsg))) {
            break label282;
          }
          localObject1 = MessageForMixedMsg.getTextFromMixedMsg(localChatMessage).toString();
        }
      }
      label282:
      if ((localChatMessage instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)localChatMessage;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label529;
        }
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForHypertext)) {
          localObject2 = ((StructMsgForHypertext)((MessageForStructing)localObject1).structingMsg).getSpannableString(false).toString();
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = acfp.m(2131702289);
      break;
      if (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 32)
      {
        localObject2 = g((MessageForStructing)localObject1);
      }
      else
      {
        localObject2 = ((MessageForStructing)localObject1).getSummaryMsg();
        if (((MessageForStructing)localObject1).structingMsg.mMsgUrl != null)
        {
          localObject2 = (String)localObject2 + "\n" + ((MessageForStructing)localObject1).structingMsg.mMsgUrl;
          continue;
          if (((localChatMessage instanceof MessageForArkFlashChat)) && (localChatMessage.msg != null))
          {
            localObject1 = localChatMessage.msg;
            break;
            paramMap = (ClipboardManager)this.mContext.getSystemService("clipboard");
            paramArrayList = ClipData.newPlainText("simple text", localStringBuilder.toString());
            alkw.a(paramMap, paramArrayList);
            paramMap.setPrimaryClip(paramArrayList);
            QQToast.a(this.mApp.getApp(), 2131696125, 0).show(this.f.getTitleBarHeight());
            return;
          }
          localObject1 = null;
          break;
        }
        continue;
        label529:
        localObject2 = null;
      }
    }
  }
  
  public void destroy()
  {
    if (this.b != null)
    {
      this.b.setItemClickListener(null);
      this.b.dismiss();
    }
    if (this.a != null) {
      WXShareHelper.a().b(this.a);
    }
  }
  
  public void dxA()
  {
    List localList = ajlc.a().fH();
    ((yju)this.f.a(59)).b(localList, System.currentTimeMillis() + 60000L, 2);
  }
  
  public String g(MessageForStructing paramMessageForStructing)
  {
    String str = paramMessageForStructing.getSummaryMsg();
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      Object localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
      Object localObject1 = paramMessageForStructing;
      if (paramMessageForStructing == null)
      {
        localObject1 = paramMessageForStructing;
        if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
          for (;;)
          {
            localObject1 = paramMessageForStructing;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            Object localObject3 = (anqu)((Iterator)localObject2).next();
            localObject1 = paramMessageForStructing;
            if ((localObject3 instanceof antd))
            {
              localObject3 = (antd)localObject3;
              localObject1 = paramMessageForStructing;
              if (((antd)localObject3).rz != null)
              {
                localObject3 = ((antd)localObject3).rz.iterator();
                for (;;)
                {
                  localObject1 = paramMessageForStructing;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = (anqu)((Iterator)localObject3).next();
                  if ((localObject1 instanceof anux)) {
                    paramMessageForStructing = ((anux)localObject1).text;
                  }
                }
              }
            }
            paramMessageForStructing = (MessageForStructing)localObject1;
          }
        }
      }
      if (localObject1 != null) {
        return str + (String)localObject1;
      }
    }
    return str;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.b.dismiss();
      switch (((ShareActionSheetBuilder.b)localObject1).b.action)
      {
      default: 
        break;
      case 9: 
        anot.a(this.mApp, "CliOper", "", "", bRq, bRq, 0, 0, "", "", "", "");
        i = -1;
        if (!WXShareHelper.a().isWXinstalled()) {
          i = 2131696070;
        }
        for (;;)
        {
          if (i == -1) {
            break label216;
          }
          QQToast.a(this.mApp.getApp(), this.mContext.getString(i), 0).show();
          break;
          if (!WXShareHelper.a().isWXsupportApi()) {
            i = 2131721936;
          }
        }
        if (this.a != null) {
          this.a = new ajgx(this);
        }
        WXShareHelper.a().a(this.a);
        ((wwb)this.f.a(1)).a(this.f.a, true);
        break;
      case 25: 
        label216:
        anot.a(this.mApp, "CliOper", "", "", bRr, bRr, 0, 0, "", "", "", "");
        if (!aqH()) {
          aqha.a(this.mContext, 230).setMessage(this.mContext.getString(2131696117)).setPositiveButton(17039370, new ajhb(this)).setNegativeButton(17039360, new ajha(this)).show();
        } else if ((!ajlc.a().fH().isEmpty()) && (aqI())) {
          this.f.a(false, null, false);
        }
        break;
      }
    }
    anot.a(this.mApp, "CliOper", "", "", bRu, bRu, 0, 0, "", "", "", "");
    Object localObject2 = ajlc.a().fH();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    label457:
    Object localObject3;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      j = xeh.a(this.mApp, (ChatMessage)localObject3);
      if (((localObject3 instanceof MessageForPic)) && (j == 1))
      {
        if (aqiu.a(this.mApp, (MessageForPic)localObject3, false)) {
          break label1336;
        }
        ((List)localObject1).add((MessageForPic)((ChatMessage)localObject3).deepCopyByReflect());
      }
    }
    label1336:
    for (;;)
    {
      break label457;
      i = 1;
      continue;
      if (((List)localObject1).isEmpty())
      {
        QQToast.a(this.mContext, this.mContext.getString(2131718944), 0).show();
        break;
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject3 = this.f.sessionInfo.troopUin;
      Object localObject4 = this.f.sessionInfo.aTl;
      j = this.f.sessionInfo.cZ;
      if (i != 0) {
        QQToast.a(this.mContext, this.mContext.getString(2131718944), 0).show();
      }
      amdf.a(this.mActivity, (String)localObject2, (String)localObject3, (String)localObject4, j, (List)localObject1, 102);
      break;
      if (!aqF())
      {
        aqha.a(this.mContext, 230).setMessage(this.mContext.getString(2131696128)).setPositiveButton(17039370, new ajhd(this)).setNegativeButton(17039360, new ajhc(this)).show();
        break;
      }
      anot.a(this.mApp, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
      if (!aqG()) {
        break;
      }
      this.f.a(false, null, false);
      break;
      anot.a(this.mApp, "CliOper", "", "", bRs, bRs, 0, 0, "", "", "", "");
      if (!aqE())
      {
        aqha.a(this.mContext, 230).setMessage(this.mContext.getString(2131696126)).setPositiveButton(17039370, new ajhf(this)).setNegativeButton(17039360, new ajhe(this)).show();
        break;
      }
      if (!awpd.a(this.mApp, this.mActivity, this.f.getTitleBarHeight(), this.uiHandler)) {
        break;
      }
      this.f.a(false, null, false);
      break;
      anot.a(this.mApp, "CliOper", "", "", bRt, bRt, 0, 0, "", "", "", "");
      if (!aqJ())
      {
        aqha.a(this.mContext, 230).setMessage(this.mContext.getString(2131696123)).setPositiveButton(17039370, new ajhh(this)).setNegativeButton(17039360, new ajhg(this)).show();
        break;
      }
      if ((ajlc.a().fH().isEmpty()) || (!aqK())) {
        break;
      }
      this.f.a(false, null, false);
      break;
      localObject1 = new ajlm(this.mActivity);
      localObject2 = (ajlu)this.mApp.getManager(324);
      if ((localObject2 == null) || (this.f == null) || (this.f.a == null)) {
        break;
      }
      localObject3 = new ArrayList();
      localObject4 = ajlc.a().lC.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          ((List)localObject3).add(localEntry.getKey());
        }
      }
      localObject3 = ajlp.a(this.mApp, (List)localObject3, this.f.a.a, this);
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        QQToast.a(this.mContext, this.mContext.getString(2131718937), 0).show();
        break;
      }
      if (!CheckPermission.isHasStoragePermission(this.mActivity))
      {
        CheckPermission.requestStorePermission(this.mActivity, null);
        break;
      }
      ((ajlu)localObject2).a(new ajgy(this, (ajlm)localObject1, (ajlu)localObject2, (List)localObject3));
      ((ajlu)localObject2).at((List)localObject3, true);
      if ((this.f == null) || (this.f.sessionInfo == null)) {
        break;
      }
      ((ajlu)localObject2).d((List)localObject3, 1, this.f.sessionInfo.cZ);
      break;
      dxA();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgw
 * JD-Core Version:    0.7.0.1
 */