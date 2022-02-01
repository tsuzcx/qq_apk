import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.1;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.14;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.15;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.16;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.17;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.18;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.19;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.2;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.20;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.21;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.22;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.23;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.a;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ocp
{
  private static Object LOCK = new Object();
  private static String apJ;
  public static boolean awm;
  private static volatile int bel = -1;
  private static WeakReference<Handler> cG;
  static aqju j;
  public static MqqHandler l;
  
  static
  {
    apJ = "tag_delete_oldkandian_flag";
  }
  
  public static long F(long paramLong)
  {
    long l1 = -1L;
    if ((0x200 & paramLong) != 0L) {
      l1 = -8L;
    }
    while ((0x100000 & paramLong) == 0L) {
      return l1;
    }
    return -10L;
  }
  
  public static boolean GB()
  {
    return false;
  }
  
  public static boolean GC()
  {
    if ((BaseActivity.sTopActivity == null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        } while (localObject == null);
        localObject = (Conversation)((FrameHelperActivity)localObject).a(Conversation.class);
      } while (localObject == null);
      localObject = ((Conversation)localObject).a();
    } while (localObject == null);
    if (((pvz)localObject).getMode() != 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void K(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static AccountDetail a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.find(AccountDetail.class, paramString);
    paramQQAppInterface.close();
    return paramString;
  }
  
  private static MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)anbi.d(-2011);
    localMessageForStructing.structingMsg = anre.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.selfuin = paramQQAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = acbn.blw;
    localMessageForStructing.senderuin = acbn.blw;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static MessageForStructing a(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing == null) || (!(paramMessageForStructing instanceof MessageForStructing)) || (!paramMessageForStructing.isread)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)anbi.d(paramMessageForStructing.msgtype);
    localMessageForStructing.copyStructingMsg(paramMessageForStructing);
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, ReadInJoyUserInfoModule.a parama)
  {
    Object localObject2 = null;
    if (paramArticleInfo == null)
    {
      QLog.d("PublicAccountUtil", 2, "create msg brief for fail, article info is null");
      return "";
    }
    QLog.d("PublicAccountUtil", 2, "createStructingMsgBrief article : " + paramArticleInfo + ", briefPrefix : " + paramArticleInfo.msgBoxBriefPreFix + ", briefContent : " + paramArticleInfo.msgBoxBriefContent);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefPreFix))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType > 0)
      {
        if (paramArticleInfo.msgBoxBriefPreFixType != 1) {
          break label145;
        }
        localObject1 = paramArticleInfo.msgBoxBriefPreFix + ": ";
      }
    }
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefContent))
    {
      paramArticleInfo = paramArticleInfo.msgBoxBriefContent;
      label133:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label245;
      }
    }
    for (;;)
    {
      return anbk.nn(paramArticleInfo);
      label145:
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType != 2) {
        break;
      }
      localObject1 = localObject2;
      if (!TextUtils.isDigitsOnly(paramArticleInfo.msgBoxBriefPreFix)) {
        break;
      }
      parama = ReadInJoyUserInfoModule.a(Long.valueOf(paramArticleInfo.msgBoxBriefPreFix).longValue(), parama);
      if (parama == null)
      {
        localObject1 = ReadInJoyUserInfoModule.getDefaultNickName() + ": ";
        break;
      }
      localObject1 = parama.nick + ": ";
      break;
      paramArticleInfo = paramArticleInfo.mTitle;
      break label133;
      label245:
      paramArticleInfo = (String)localObject1 + paramArticleInfo;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = b(paramQQAppInterface, paramBaseArticleInfo);
      paramBaseArticleInfo = q(paramBaseArticleInfo);
      paramQQAppInterface = paramBaseArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseArticleInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (paramBaseVideoArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = paramBaseVideoArticleInfo.subscribeName;
      paramBaseVideoArticleInfo = paramBaseVideoArticleInfo.title;
      paramQQAppInterface = paramBaseVideoArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseVideoArticleInfo;
  }
  
  /* Error */
  public static NewIntent a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 305	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 210
    //   8: iconst_2
    //   9: new 221	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 307
    //   19: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_3
    //   23: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: ldc 2
    //   34: monitorenter
    //   35: aload_2
    //   36: ifnull +7 -> 43
    //   39: aload_2
    //   40: putstatic 309	ocp:l	Lmqq/os/MqqHandler;
    //   43: ldc 2
    //   45: monitorexit
    //   46: new 311	mqq/app/NewIntent
    //   49: dup
    //   50: aload_1
    //   51: ldc_w 313
    //   54: invokespecial 316	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 318
    //   62: ldc_w 320
    //   65: invokevirtual 324	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   68: pop
    //   69: new 326	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   72: dup
    //   73: invokespecial 327	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: getfield 331	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: iconst_0
    //   82: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   85: aload_2
    //   86: getfield 340	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: iconst_1
    //   90: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   93: aload_2
    //   94: getfield 344	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   97: ldc_w 346
    //   100: invokevirtual 351	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   103: aload_2
    //   104: getfield 354	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_3
    //   108: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   111: l2i
    //   112: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   115: aload_1
    //   116: ldc_w 356
    //   119: aload_2
    //   120: invokevirtual 360	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   123: invokevirtual 363	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   126: pop
    //   127: aload_1
    //   128: new 365	ocq
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 368	ocq:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   136: invokevirtual 372	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   139: aload_0
    //   140: aload_1
    //   141: invokevirtual 376	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   144: invokestatic 305	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 210
    //   152: iconst_2
    //   153: ldc_w 378
    //   156: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_1
    //   160: areturn
    //   161: astore_0
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_0
    //   166: athrow
    //   167: astore_3
    //   168: goto -53 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramQQAppInterface	QQAppInterface
    //   0	171	1	paramContext	Context
    //   0	171	2	paramMqqHandler	MqqHandler
    //   0	171	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   39	43	161	finally
    //   43	46	161	finally
    //   162	165	161	finally
    //   103	115	167	java/lang/Exception
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a;
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).mOpenId)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).apc))) {
      b(paramActivity, paramQQAppInterface, paramProfileParams);
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).apc))
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
        if (!((ProfileParams.CurLoginUsr)localObject).apc.equals(str))
        {
          c(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
        b(paramActivity, paramQQAppInterface, paramProfileParams);
        return;
      }
      localObject = new ocr(paramActivity, paramQQAppInterface, paramProfileParams);
      localObject = avqq.a(paramQQAppInterface, paramProfileParams.la(), (acci)localObject);
      if (localObject != null)
      {
        if (!a(paramActivity, (OpenID)localObject, paramQQAppInterface, paramProfileParams)) {}
        for (int i = 1; i != 0; i = 0)
        {
          b(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
      }
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    switch (b(paramQQAppInterface, paramString, paramInt))
    {
    default: 
      b(paramIntent, paramContext, paramString);
    case -6: 
      return;
    }
    jqs.a(paramContext, paramIntent, paramString, false, -1, true, -1);
  }
  
  private static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
  }
  
  private static void a(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramContext.startActivity(paramIntent);
      return;
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfileForResult app: " + paramQQAppInterface + " | activity: " + paramActivity + " | uin: " + paramString + " | accountFlag: " + paramInt1 + " | requestCode: " + paramInt2 + " | source: " + paramInt3);
    }
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      switch (b(paramQQAppInterface, paramString, paramInt1))
      {
      default: 
        a(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3, paramBoolean);
        return;
      }
    } while (!jou.z(paramActivity, paramString));
    a(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
    return;
    jqs.a(paramActivity, paramIntent, paramString, false, 5, true, paramInt2);
  }
  
  private static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = kwt.acJ + aqgo.encodeToString(paramString.getBytes(), 0);
      paramIntent = new Intent(paramActivity, PublicAccountBrowser.class);
      paramIntent.putExtra("url", str);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
    }
    switch (paramInt2)
    {
    default: 
      return;
      if (paramIntent == null) {
        paramIntent = new Intent(paramActivity, AccountDetailActivity.class);
      }
      for (;;)
      {
        paramIntent.putExtra("uin", paramString);
        paramIntent.putExtra("source", 5);
        paramIntent.addFlags(67108864);
        break;
        paramIntent.setClassName(paramActivity, AccountDetailActivity.class.getName());
      }
    }
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfile app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (acbn.blO.equals(paramString))
    {
      KandianSubscribeManager.P(paramContext, 3);
      return;
    }
    paramInt = b(paramQQAppInterface, paramString, paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4))
    {
      if (paramIntent != null) {
        break label237;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("source", 105);
    }
    label237:
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        b(paramIntent, paramContext, paramString);
        return;
        if ((paramInt == -1) && (paramIntent == null))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("source", 104);
        }
        break;
      case -6: 
        if (!jou.z(paramContext, paramString)) {
          break;
        }
        a(paramIntent, paramContext, paramString);
        return;
      case -7: 
        jqs.a(paramContext, paramIntent, paramString, false, -1, true, -1);
        return;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    a(paramAppInterface, paramContext, paramString, -1);
  }
  
  private static void a(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, kbs.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label91:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new odb(paramContext, paramAppInterface, paramInt, paramString));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, acje paramacje)
  {
    a(paramAppInterface, paramContext, paramString, paramacje, true, 0);
  }
  
  @Deprecated
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, acje paramacje, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
    localQQAppInterface.addObserver(new adai(new oda(paramacje, paramString, paramAppInterface, paramContext), localQQAppInterface));
    adam.a(localQQAppInterface, true, paramString, 0);
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    }
    for (;;)
    {
      kbp.g(paramAppInterface, paramString, 0);
      return;
      paramAppInterface = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface))) {
        paramAppInterface = (QQAppInterface)paramAppInterface;
      } else {
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, acje paramacje, boolean paramBoolean)
  {
    a(paramAppInterface, paramContext, paramString, paramacje, paramBoolean, 0);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, acje paramacje, boolean paramBoolean, int paramInt)
  {
    a(paramAppInterface, paramContext, paramString, paramacje, paramBoolean, paramInt, false);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, acje paramacje, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = BaseApplicationImpl.getContext();
    if (paramBoolean2) {
      paramBoolean2 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "followUin() uin: " + paramString + "  useNewProtocol: " + paramBoolean2);
      }
      Object localObject;
      if ((!(paramAppInterface instanceof QQAppInterface)) || (paramBoolean2))
      {
        paramacje = new adai(new ocw(paramacje, paramString, paramAppInterface, paramContext, paramInt, paramBoolean1));
        paramContext = new PublicAccountIntent(paramContext.getApplicationContext(), adaj.class);
        paramContext.a(paramacje);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", paramString);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", true);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", paramInt);
        paramAppInterface.startServlet(paramContext);
        return;
        localObject = (acja)paramAppInterface.getManager(56);
        if (localObject != null)
        {
          localObject = ((acja)localObject).a(paramString);
          if ((localObject == null) || (getAccountType(((AccountDetail)localObject).accountFlag) == -4))
          {
            paramBoolean2 = false;
            continue;
          }
          paramBoolean2 = true;
        }
      }
      else
      {
        localObject = new NewIntent(paramContext.getApplicationContext(), kbs.class);
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.ext.set("" + paramInt);
        try
        {
          localFollowRequest.uin.set((int)Long.parseLong(paramString));
          ((NewIntent)localObject).setObserver(new ocx(paramacje, paramString, paramBoolean1, paramContext, paramAppInterface, paramInt));
          ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
          paramAppInterface.startServlet((NewIntent)localObject);
          return;
        }
        catch (NumberFormatException paramAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
        return;
      }
      paramBoolean2 = false;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramQQAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    new ljc(paramQQAppInterface, null, null, lun.a(), null).cA(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    paramRecentUser = new Intent();
    if (paramRecentBaseData != null) {
      paramRecentUser.putExtra("serviceUnReadNumber", paramRecentBaseData.mUnreadNum);
    }
    rzd.a(paramActivity, 9004, paramRecentUser);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
    }
    if (paramRecentBaseData == null) {}
    for (paramInt = -1;; paramInt = paramRecentBaseData.mPosition)
    {
      ThreadManager.executeOnSubThread(new PublicAccountUtil.23(paramQQAppInterface, paramInt));
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    ausj localausj = (ausj)auss.a(paramContext, null);
    localausj.setMainTitle(paramContext.getResources().getString(2131698325));
    localausj.addButton(2131692505, 3);
    if (paramString.equals("2010741172")) {
      localausj.addButton(2131697397);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new ocv(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localausj));
    localausj.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, acje paramacje)
  {
    a(paramQQAppInterface, paramContext, paramString, paramBoolean, paramacje, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, acje paramacje, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramContext = null;
    NewIntent localNewIntent = null;
    Object localObject3 = (acja)paramQQAppInterface.getManager(56);
    Object localObject1 = localNewIntent;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((acja)localObject3).a(paramString);
      ((acja)localObject3).b(paramString);
      paramContext = (Context)localObject2;
      localObject1 = localNewIntent;
      if (localObject2 == null)
      {
        localObject3 = (aced)paramQQAppInterface.getManager(69);
        paramContext = (Context)localObject2;
        localObject1 = localNewIntent;
        if (localObject3 != null)
        {
          localObject1 = ((aced)localObject3).a(paramString);
          paramContext = (Context)localObject2;
        }
      }
    }
    boolean bool;
    if ((paramBoolean2) || (paramContext == null) || (getAccountType(paramContext.accountFlag) != -4))
    {
      bool = true;
      label131:
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "unFollowUin() uin: " + paramString + "  useNewProtocol: " + bool);
      }
      if ((!paramBoolean2) && (paramContext != null) && (getAccountType(paramContext.accountFlag) == -4))
      {
        localNewIntent = new NewIntent(paramQQAppInterface.getApp().getApplicationContext(), kbs.class);
        localNewIntent.putExtra("cmd", "unfollow");
        localObject2 = new mobileqq_mp.UnFollowRequest();
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramString));
          if (localObject1 != null) {
            break label337;
          }
          paramContext = new ocy(paramacje, paramString, paramBoolean1, localBaseApplication, localObject1, paramQQAppInterface);
          localNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
          localNewIntent.setObserver(paramContext);
          paramQQAppInterface.startServlet(localNewIntent);
          return;
        }
        catch (NumberFormatException paramQQAppInterface) {}
        bool = false;
        break label131;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Unfollow Request got wrong uin:" + paramString);
        return;
        label337:
        localObject1 = paramContext;
      }
    }
    if (localObject1 == null) {}
    for (;;)
    {
      paramContext = new adai(new ocz(localObject1, paramQQAppInterface, paramString, paramacje, paramBoolean1, localBaseApplication), paramQQAppInterface);
      paramContext.cF(paramQQAppInterface);
      paramQQAppInterface.removeObserver(paramContext);
      paramQQAppInterface.addObserver(paramContext);
      adam.a(paramQQAppInterface, false, paramString, 0);
      return;
      localObject1 = paramContext;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {
      return;
    }
    String str = "";
    if (paramChatMessage.mExJsonObject != null) {
      str = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
    }
    adak.a(paramQQAppInterface, paramChatMessage.senderuin, 0, 6, paramChatMessage.msgId, str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int k;
    int i;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      k = localObject.length;
      i = 0;
      for (;;)
      {
        if (i < k)
        {
          String str1 = localObject[i];
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      k = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i < k)
        {
          String str2 = arrayOfString[i];
          try
          {
            ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = e(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing == null) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramMessageForStructing.getString("id"));
        if ((l1 == -1L) || (localArrayList.size() <= 0) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        a(paramQQAppInterface, l1, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
      }
      long l1 = -1L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (awit.cA(paramQQAppInterface))
    {
      localObject = (KandianMergeManager)paramQQAppInterface.getManager(162);
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramString3)) {
        paramQQAppInterface = paramString3 + ": " + paramString1;
      }
      ((KandianMergeManager)localObject).a(paramQQAppInterface, paramString2, paramInt, paramBoolean);
    }
    do
    {
      return;
      localObject = paramQQAppInterface.b();
    } while (localObject == null);
    ThreadManager.post(new PublicAccountUtil.18((QQMessageFacade)localObject, paramString3, paramString1, paramString2, paramQQAppInterface), 10, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, 0, paramBoolean);
  }
  
  public static void a(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramMessageRecord.istroop == 1)
        {
          paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
          Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(52);
          if (localObject != null)
          {
            localObject = ((TroopManager)localObject).b(paramMessageRecord.frienduin);
            if (localObject != null) {
              paramIntent.putExtra("isAdmin", ((TroopInfo)localObject).isAdmin());
            }
          }
        }
        if (paramMessageRecord.istroop == 3000) {
          paramIntent.putExtra("dicussgroup_uin", paramMessageRecord.frienduin);
        }
        paramIntent.putExtra("friend_uin", paramMessageRecord.frienduin);
        paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
        paramIntent.putExtra("uinType", paramMessageRecord.istroop);
        paramIntent.putExtra("is_send", paramMessageRecord.isSend());
        paramIntent.putExtra("fromAio", true);
        paramMessageRecord = paramIntent.getComponent();
        if (paramMessageRecord == null) {
          break;
        }
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        i = paramString.indexOf("?");
        if (i == -1) {
          break;
        }
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i >= paramString.length) {
          break;
        }
        if (paramString[i].startsWith("_webviewtype="))
        {
          paramString = paramString[i].split("=");
          if (paramString.length != 2) {
            break;
          }
          boolean bool = TextUtils.isEmpty(paramString[1]);
          if (bool) {
            break;
          }
          try
          {
            switch (Integer.parseInt(paramString[1]))
            {
            case 1: 
              paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
              return;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            return;
          }
        }
        if (paramString[i].startsWith("url="))
        {
          paramMessageRecord = paramString[i].split("=");
          if ((paramMessageRecord.length != 2) || (TextUtils.isEmpty(paramMessageRecord[1]))) {
            break;
          }
          f(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      i += 1;
    }
    return;
  }
  
  public static boolean a(Activity paramActivity, OpenID paramOpenID, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)))
    {
      if (!paramOpenID.openID.equals(paramProfileParams.a().mOpenId)) {}
      for (int i = 1; i != 0; i = 0)
      {
        c(paramActivity, paramQQAppInterface, paramProfileParams);
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a == null) || (TextUtils.isEmpty(paramProfileParams.la()));
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.aTl != null)) {
      return "2711679534".equals(paramSessionInfo.aTl);
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    Object localObject2;
    ArrayList localArrayList;
    oidb_cmd0xcf8.ConfigInfo localConfigInfo;
    mobileqq_mp.ConfigInfo localConfigInfo1;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramArrayOfByte);
        int i = -1;
        if (paramArrayOfByte.uint32_result.has())
        {
          int k = paramArrayOfByte.uint32_result.get();
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.i("PublicAccountUtil", 2, "handle OidbSvc.0xcf8|OIDBSSOPke.result=" + k);
            i = k;
          }
        }
        if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
        {
          paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
          if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
          {
            paramArrayOfByte = new mobileqq_mp.RetInfo();
            paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
            paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
            paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
          }
          paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
          paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
          paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
          paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
          paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
          paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
          if (!paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
            break label660;
          }
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
          localArrayList = new ArrayList();
          localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
            localConfigInfo1 = new mobileqq_mp.ConfigInfo();
            localConfigInfo1.type.set(localConfigInfo.type.get());
            localConfigInfo1.title.set(localConfigInfo.title.get());
            localConfigInfo1.content.set(localConfigInfo.content.get());
            localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
            localConfigInfo1.url.set(localConfigInfo.url.get());
            localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
            localConfigInfo1.state.set(localConfigInfo.state.get());
            localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
            localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
            localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
            localArrayList.add(localConfigInfo1);
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      localObject2 = new mobileqq_mp.ConfigGroupInfo();
      ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
      paramArrayOfByte.add(localObject2);
    }
    paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
    label660:
    paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
    paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
    paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
    paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
    paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
    paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
    paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
    {
      paramArrayOfByte = new ArrayList();
      localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
        localArrayList = new ArrayList();
        localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
          localConfigInfo1 = new mobileqq_mp.ConfigInfo();
          localConfigInfo1.type.set(localConfigInfo.type.get());
          localConfigInfo1.title.set(localConfigInfo.title.get());
          localConfigInfo1.content.set(localConfigInfo.content.get());
          localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
          localConfigInfo1.url.set(localConfigInfo.url.get());
          localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
          localConfigInfo1.state.set(localConfigInfo.state.get());
          localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
          localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
          localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
          localArrayList.add(localConfigInfo1);
        }
        localObject2 = new mobileqq_mp.ConfigGroupInfo();
        ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
        paramArrayOfByte.add(localObject2);
      }
      paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
    paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
    return true;
  }
  
  public static int aS(String paramString)
  {
    Object localObject1 = aajt.a().fl;
    int k;
    if (localObject1 == null)
    {
      k = 2147483647;
      return k;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
        ((Iterator)localObject2).remove();
      } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (nyn.f((QQAppInterface)kxm.getAppRuntime(), localRecentUserBaseData.mUser.uin))) {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= ((List)localObject1).size()) {
        break label185;
      }
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
      {
        k = i;
        if (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString)) {
          break;
        }
      }
      i += 1;
    }
    label185:
    return -1;
  }
  
  public static int aT(String paramString)
  {
    int i = 0;
    int m = 0;
    Object localObject1 = aajt.a().fl;
    if (localObject1 == null) {}
    int k;
    do
    {
      return m;
      localObject1 = new ArrayList((Collection)localObject1);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
        if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
          ((Iterator)localObject2).remove();
        } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (nyn.f((QQAppInterface)kxm.getAppRuntime(), localRecentUserBaseData.mUser.uin))) {
          ((Iterator)localObject2).remove();
        }
      }
      k = 0;
      m = i;
    } while (k >= ((List)localObject1).size());
    Object localObject2 = (RecentUserBaseData)((List)localObject1).get(k);
    if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
    {
      m = i;
      if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString))
      {
        if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, acbn.bkz)) {
          break label215;
        }
        m = i;
      }
    }
    for (;;)
    {
      k += 1;
      i = m;
      break;
      label215:
      m = i;
      if (((RecentUserBaseData)localObject2).wU() > 0) {
        m = i + ((RecentUserBaseData)localObject2).wU();
      }
    }
  }
  
  private static int b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int k = d(paramQQAppInterface, paramString);
    int i = k;
    if (k == -1) {
      i = getAccountType(paramInt);
    }
    return i;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramBaseArticleInfo.mFeedType == 17) || (paramBaseArticleInfo.mFeedType == 16) || (paramBaseArticleInfo.mFeedType == 19) || (paramBaseArticleInfo.mFeedType == 18)) {}
    for (;;)
    {
      return localStringBuilder.toString();
      if ((paramBaseArticleInfo.mFeedType == 4) || (paramBaseArticleInfo.mFeedType == 5))
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountUtil", 2, "articleInfo.mTitle is null");
          }
        }
        else
        {
          paramQQAppInterface = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.a.uin, null);
          if (paramQQAppInterface != null) {}
          for (paramQQAppInterface = paramQQAppInterface.nick;; paramQQAppInterface = ReadInJoyUserInfoModule.getDefaultNickName())
          {
            localStringBuilder.append(paramQQAppInterface);
            break;
          }
        }
      }
      else
      {
        if (ndi.P((ArticleInfo)paramBaseArticleInfo))
        {
          paramQQAppInterface = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.a.uin, null);
          if (paramQQAppInterface != null) {}
          for (paramQQAppInterface = paramQQAppInterface.nick;; paramQQAppInterface = ReadInJoyUserInfoModule.getDefaultNickName())
          {
            localStringBuilder.append(paramQQAppInterface).append(" Biu了");
            break;
          }
        }
        if (paramBaseArticleInfo.mFeedType == 28)
        {
          if (paramBaseArticleInfo.hotWordInfo.iN != null)
          {
            int i = 0;
            while (i < paramBaseArticleInfo.hotWordInfo.iN.size())
            {
              localStringBuilder.append(i + 1).append(".").append(((mhj)paramBaseArticleInfo.hotWordInfo.iN.get(i)).hotWord).append("  ");
              i += 1;
            }
          }
        }
        else {
          localStringBuilder.append(paramBaseArticleInfo.mSubscribeName);
        }
      }
    }
  }
  
  public static void b(int paramInt1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.21(paramList, paramInt1, paramInt2));
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    d(paramActivity, paramQQAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = ((Boolean)aqmj.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_is_web", Boolean.valueOf(false))).booleanValue();
    String str = (String)aqmj.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_url", "https://m.q.qq.com/a/p/1109953074?s=pages%2Fnotification%2Findex%3FenterType%3DqqMiniHelper");
    if ((!bool) && (MiniAppLauncher.isMiniAppUrl(str))) {
      MiniAppLauncher.startMiniApp(paramContext, str, 1043, null);
    }
    for (;;)
    {
      paramQQAppInterface.b().a(acbn.blS, 1008, true, true);
      return;
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void b(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, AccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772004, 2130772005);
      }
      return;
      paramIntent.setClassName(paramContext, AccountDetailActivity.class.getName());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PublicAccountUtil.1(paramQQAppInterface, paramContext, paramString));
  }
  
  public static void bdB()
  {
    try
    {
      l = null;
      return;
    }
    finally {}
  }
  
  public static void bdC()
  {
    synchronized (LOCK)
    {
      bel = -1;
      return;
    }
  }
  
  public static void c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          i = Integer.parseInt(paramString2);
          paramString2 = Uri.parse(paramString1);
          if (paramString2 == null) {
            continue;
          }
          String str = paramString2.getHost();
          if ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str)))) {
            continue;
          }
          ThreadManager.post(new PublicAccountUtil.17(paramString2, i, paramString3, paramString4, paramInt, paramString1), 5, null, false);
          return;
        }
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  protected static final void c(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (j != null)
    {
      j.dismiss();
      j = null;
    }
    paramQQAppInterface = new ocs(paramActivity, paramProfileParams, paramQQAppInterface);
    paramProfileParams = new oct(paramActivity, paramProfileParams);
    j = aqha.a(paramActivity, 230);
    j.setMessage(2131697425);
    j.setTitle(2131693317);
    j.setNegativeButton(2131721058, paramQQAppInterface);
    j.setPositiveButton(2131720034, paramQQAppInterface);
    j.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      j.show();
      return;
    }
    catch (Exception paramActivity) {}
    j.dismiss();
    j = null;
    return;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label40:
    label301:
    label307:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i < paramString.length) {
          if (!paramString[i].startsWith("url=")) {}
        }
        for (paramString = URLDecoder.decode(paramString[i].split("=")[1]);; paramString = "")
        {
          if (TextUtils.isEmpty(paramString)) {
            break label307;
          }
          i = paramString.indexOf("?");
          if (i == -1) {
            break;
          }
          paramString = paramString.substring(i + 1).split("&");
          paramQQAppInterface.getCurrentAccountUin();
          i = 0;
          label114:
          if (i < paramString.length) {
            if (!paramString[i].startsWith("mailid=")) {}
          }
          for (paramString = paramString[i].split("=")[1];; paramString = "")
          {
            if (TextUtils.isEmpty(paramString)) {
              break label301;
            }
            paramQQAppInterface = String.format("https://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramQQAppInterface.getCurrentAccountUin() });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).response;
              i = k;
              if (paramQQAppInterface.getStatusLine().getStatusCode() == 200)
              {
                paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
                i = k;
                if (paramQQAppInterface.has("ret"))
                {
                  int m = paramQQAppInterface.getInt("ret");
                  i = k;
                  if (m == 0) {
                    i = 1;
                  }
                }
              }
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i = k;
              }
            }
            if (i != 0) {
              break;
            }
            ThreadManager.getUIHandler().post(new PublicAccountUtil.2(paramContext));
            return;
            i += 1;
            break label40;
            i += 1;
            break label114;
          }
          break;
        }
      }
    }
  }
  
  public static boolean c(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramAppInterface = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    if ((PublicAccountInfo)paramAppInterface.find(PublicAccountInfo.class, paramString) != null)
    {
      paramAppInterface.close();
      return true;
    }
    paramString = (AccountDetail)paramAppInterface.find(AccountDetail.class, paramString);
    paramAppInterface.close();
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      if (i == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static boolean c(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      paramString1 = Uri.parse(paramString1);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getHost())) || ((!"article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))));
    ThreadManager.post(new PublicAccountUtil.14(paramString1, paramInt, paramString2), 5, null, false);
    return true;
  }
  
  public static int d(QQAppInterface paramQQAppInterface, String paramString)
  {
    int k = -1;
    int m = k;
    if (paramQQAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label22;
      }
      m = k;
    }
    label22:
    do
    {
      int i;
      do
      {
        do
        {
          return m;
          localObject = (acja)paramQQAppInterface.getManager(56);
          m = k;
        } while (localObject == null);
        Object localObject = ((acja)localObject).b(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return -7;
          }
          return getAccountType(((PublicAccountInfo)localObject).accountFlag);
        }
        localObject = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
        i = k;
        if (localObject != null)
        {
          i = k;
          if (((TroopInfo)localObject).associatePubAccount != 0L) {
            i = -4;
          }
        }
        paramQQAppInterface = (aced)paramQQAppInterface.getManager(69);
        m = i;
      } while (paramQQAppInterface == null);
      m = i;
    } while (paramQQAppInterface.a(paramString) == null);
    return -7;
  }
  
  public static void d(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, AccountDetailActivity.class);
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramQQAppInterface, paramProfileParams.getUin(), paramProfileParams.re(), localIntent);
  }
  
  public static int e(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.extendType == 2) {
          return 1024;
        }
        return 1008;
      }
    }
    return 1008;
  }
  
  public static JSONObject e(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "videoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      f(paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    localObject = new Intent("readInJoy_video_play_real_time_report");
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  public static boolean eA(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("kandian.qq.com".equalsIgnoreCase(paramString)) || ("sqimg.qq.com".equalsIgnoreCase(paramString)));
  }
  
  public static boolean eB(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://www.urlshare.cn")))
    {
      String str = Uri.parse(paramString).getQueryParameter("url");
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        paramString = URLDecoder.decode(str);
      }
      return (!TextUtils.isEmpty(paramString)) && (ez(paramString));
    }
    return false;
  }
  
  public static boolean eC(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("kandian.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("act.kandian.qq.com".equalsIgnoreCase(paramString)) || ("node.kandian.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean ew(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equals("2711679534")) && (!paramString.equals("1770946116")) && (!paramString.equals("2241957680")) && (!paramString.equals("2639330369")) && (!paramString.equals("2054857116")))
      {
        bool1 = bool2;
        if (!paramString.equals("2054857116")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean ex(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public static boolean ey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean ez(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null) {
        return eA(paramString.getHost());
      }
    }
    return false;
  }
  
  public static void f(Intent paramIntent, String paramString)
  {
    a(null, paramIntent, paramString);
  }
  
  public static void f(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    ThreadManager.post(new PublicAccountUtil.19(paramString2, paramString1, paramInt1, paramInt2), 5, null, true);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (awit.cD(paramQQAppInterface)) {
      if ((paramInt == -2000) || (paramInt == -1000)) {
        bool = true;
      }
    }
    while ((!n(paramQQAppInterface, paramString)) && (paramInt != -2000) && (paramInt != -1000)) {
      return bool;
    }
    return true;
  }
  
  public static String fp(String paramString)
  {
    SkinData localSkinData = null;
    Object localObject1 = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject1 = aqmj.ai(BaseApplicationImpl.getApplication(), str);
      if (localObject1 == null) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          localSkinData = new SkinData((JSONObject)localObject1);
        }
        localObject1 = paramString;
        if (localSkinData != null)
        {
          paramString = jpa.r(paramString, "_kdSkinID=" + localSkinData.id);
          if (aqmj.aJ(BaseApplicationImpl.getApplication(), str)) {
            localObject1 = jpa.r(paramString, "_kdSkinVoice=1");
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      return jpa.r(paramString, "_kdSkinVoice=0");
      label123:
      Object localObject2 = null;
    }
  }
  
  public static String fq(String paramString)
  {
    String str = "biz_src_gzh";
    if ("2105640434".equals(paramString)) {
      str = "biz_src_gzh_bodong";
    }
    do
    {
      return str;
      if ("2747277822".equals(paramString)) {
        return "biz_src_gzh_games";
      }
      if ("2080578142".equals(paramString)) {
        return "biz_src_gwh";
      }
      if ("3046055438".equals(paramString)) {
        return "biz_src_gzh_qqgw";
      }
      if ("2993250418".equals(paramString)) {
        return "biz_src_gzh_qqmusic";
      }
      if ("2909288299".equals(paramString)) {
        return "biz_src_gzh_news";
      }
      if ("2711679534".equals(paramString)) {
        return "biz_src_gzh_qianbao";
      }
      if ("2632129500".equals(paramString)) {
        return "biz_src_gzh_chwl";
      }
      if ("1816533856".equals(paramString)) {
        return "biz_src_gzh_qqzb";
      }
      if ("3288261892".equals(paramString)) {
        return "biz_src_gzh_ketang";
      }
      if ("3383393803".equals(paramString)) {
        return "biz_src_gzh_fudao";
      }
      if ("3026775809".equals(paramString)) {
        return "biz_src_gzh_sport";
      }
    } while (!"2658655094".equals(paramString));
    return "biz_src_gzh_weather";
  }
  
  public static int getAccountType(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if ((0x200000 & paramInt) != 0) {
      return -2;
    }
    if ((0x4000000 & paramInt) != 0) {
      return -3;
    }
    if ((0x2000000 & paramInt) != 0) {
      return -4;
    }
    if ((0x800000 & paramInt) != 0) {
      return -5;
    }
    if ((0x8000000 & paramInt) != 0) {
      return -6;
    }
    if ((0x80000000 & paramInt) != 0) {
      return -9;
    }
    return -1;
  }
  
  public static String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
      str = paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        str = paramString;
        if (paramQQAppInterface != null) {
          str = paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public static String getVersionInfo()
  {
    return "3.4.4,3,3058";
  }
  
  public static void k(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      synchronized (LOCK)
      {
        if (bel == -1) {
          bel = ((SharedPreferences)localObject2).getInt(apJ + paramQQAppInterface.getCurrentAccountUin(), 0);
        }
        boolean bool;
        if (bel == 0)
        {
          bool = true;
          break label296;
          bel = i;
          ((SharedPreferences)localObject2).edit().putInt(apJ + paramQQAppInterface.getCurrentAccountUin(), bel).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = paramQQAppInterface.a().a();
            if (??? != null)
            {
              localObject2 = ((acxw)???).b(acbn.blv, 1008);
              if (localObject2 != null)
              {
                ((acxw)???).f((RecentUser)localObject2);
                ??? = paramQQAppInterface.getHandler(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (acja)paramQQAppInterface.getManager(56);
            if (??? != null)
            {
              ((acja)???).EA(acbn.blv);
              paramQQAppInterface = paramQQAppInterface.getHandler(PublicAccountFragment.class);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountUtil", 2, "updateDeleteOldKandian notDeleteState = " + bool + ", isDelete = " + paramBoolean);
          }
        }
        else
        {
          bool = false;
          break label296;
          i = 0;
        }
      }
      label296:
      if (!paramBoolean) {}
    }
  }
  
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtil.16(localUri, paramInt2, paramInt1, paramString), 5, null, false);
  }
  
  public static String li()
  {
    String str = aczc.getCityCode();
    Object localObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject1 = kxm.iT();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        localException.printStackTrace();
        continue;
      }
      ((JSONObject)localObject2).put("adcode", str);
      ((JSONObject)localObject2).put("deviceCode", localObject1);
      ((JSONObject)localObject2).put("macAddress", "");
      lcf.U((JSONObject)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "constructAttributeL,adCode:" + str + ",deviceID:" + (String)localObject1 + ",macAddress:" + "");
      }
      localObject1 = ((JSONObject)localObject2).toString().getBytes();
      localObject2 = new byte[localObject1.length];
      i = 0;
      if (i < localObject1.length)
      {
        localObject2[i] = ((byte)(localObject1[i] ^ 0xB6));
        i += 1;
        continue;
        localObject1 = "";
      }
      else
      {
        return aqgo.encodeToString((byte[])localObject2, 2);
      }
      if ("" == null) {}
    }
  }
  
  public static boolean m(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = d(paramQQAppInterface, paramString);
    if ((i == -3) || (i == -4)) {
      bool = true;
    }
    return bool;
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.getBusinessHandler(11);
    if ((localPublicAccountHandler.xO != null) && (localPublicAccountHandler.xO.contains(paramString))) {
      localPublicAccountHandler.xO.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.remove(paramString);
    paramQQAppInterface.close();
  }
  
  public static boolean n(QQAppInterface paramQQAppInterface, String paramString)
  {
    return d(paramQQAppInterface, paramString) == -2;
  }
  
  public static boolean p(int paramInt, long paramLong)
  {
    paramInt = getAccountType(paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4)) {}
    while (F(paramLong) == -8L) {
      return true;
    }
    return false;
  }
  
  public static void pk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtil.15(localUri, paramString), 5, null, false);
  }
  
  public static void pl(String paramString)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.22(paramString));
  }
  
  public static void pm(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {}
    MessageRecord localMessageRecord;
    String str;
    do
    {
      do
      {
        return;
        localMessageRecord = localQQAppInterface.b().d(paramString, 1008);
      } while ((localMessageRecord == null) || (localMessageRecord.isread));
      str = localMessageRecord.getExtInfoFromExtStr("has_report");
    } while ((!TextUtils.isEmpty(str)) && ("1".equals(str)));
    localMessageRecord.saveExtInfoToExtStr("has_report", "1");
    localQQAppInterface.b().a(localMessageRecord.frienduin, 1008, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
    kbp.a(null, "CliOper", "", "", "0X8009A7C", "0X8009A7C", 0, 0, paramString, "", "", "", false);
  }
  
  public static String q(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if (paramBaseArticleInfo == null)
    {
      localObject = "";
      return localObject;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19) && (paramBaseArticleInfo.mFeedType != 18)) {
            break label215;
          }
          String str2 = "";
          String str3 = "";
          String str1 = str3;
          localObject = str2;
          if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
          {
            str1 = str3;
            localObject = str2;
            if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld != null)
            {
              str1 = str3;
              localObject = str2;
              if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.size() > 0)
              {
                localObject = ((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessNamePrefix;
                str1 = ((mih.b)paramBaseArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessName;
              }
            }
          }
          paramBaseArticleInfo = (String)localObject + str1 + (String)localObject + " " + paramBaseArticleInfo.mTitle;
          localObject = paramBaseArticleInfo;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountUtil", 2, new Object[] { "createStructingMsgBriefSuffix suffix = ", paramBaseArticleInfo });
            return paramBaseArticleInfo;
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        label215:
        paramBaseArticleInfo = "";
        continue;
      }
      localThrowable1.printStackTrace();
      QLog.d("PublicAccountUtil", 1, "createStructingMsgBriefSuffix throw Throwable, create failed.");
      return paramBaseArticleInfo;
      if ((TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) && (paramBaseArticleInfo.isSocialFeed())) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.ahL;
      } else {
        paramBaseArticleInfo = paramBaseArticleInfo.mTitle;
      }
    }
  }
  
  public static void s(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      try
      {
        cG = new WeakReference(paramHandler);
        return;
      }
      finally {}
      cG = null;
    }
  }
  
  public static boolean s(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean t(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    synchronized (LOCK)
    {
      if (bel == -1) {
        bel = localSharedPreferences.getInt(apJ + paramQQAppInterface.getCurrentAccountUin(), 0);
      }
      if (bel != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static void y(int paramInt, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtil.20(paramList, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocp
 * JD-Core Version:    0.7.0.1
 */