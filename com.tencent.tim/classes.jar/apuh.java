import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils.2;
import com.tencent.mobileqq.troop.utils.TroopUtils.3;
import com.tencent.mobileqq.troop.utils.TroopUtils.4;
import com.tencent.mobileqq.troop.utils.TroopUtils.5;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import cooperation.troop.TroopFileProxyActivity;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.HighlightTitle;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.AppInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.ExtraInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.TabInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class apuh
{
  private static boolean cSp = true;
  public static String crA;
  protected static String cry = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
  protected static String crz = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
  public static int dWD;
  
  static
  {
    crA = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
  }
  
  public static int LG()
  {
    if (dWD == 1) {
      return 1;
    }
    return 2;
  }
  
  public static void R(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (!paramQQAppInterface.aFT());
      paramQQAppInterface.egu();
    } while (!QLog.isColorLevel());
    QLog.d("TroopUtils", 2, "start preloadWebProcess");
  }
  
  public static int U(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static boolean Y(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).a();
    if ("newJoin".equals(paramString)) {
      if (paramQQAppInterface.dxE == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "checkSwitch scene = " + paramString + ",result = " + bool + ",config.switchOn = " + paramQQAppInterface.dxE + ",config.au_switchOn = " + paramQQAppInterface.dxL + ",config.hfi_switchOn = " + paramQQAppInterface.dxP + ",config.nm_switchOn = " + paramQQAppInterface.dxS + ",config.aor_switchOn = " + paramQQAppInterface.dxU);
      }
      return bool;
      bool = false;
      continue;
      if ("activeUser".equals(paramString))
      {
        if (paramQQAppInterface.dxL != 1) {
          bool = false;
        }
      }
      else if ("highFreqInteract".equals(paramString))
      {
        if (paramQQAppInterface.dxP != 1) {
          bool = false;
        }
      }
      else if ("newMember".equals(paramString))
      {
        if (paramQQAppInterface.dxS != 1) {
          bool = false;
        }
      }
      else if ("atMeOrReplyMe".equals(paramString))
      {
        if (paramQQAppInterface.dxU != 1) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  private static char a(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
          paramQQAppInterface = paramQQAppInterface.getReadableDatabase();
        } while (paramQQAppInterface == null);
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype ");
        localStringBuilder.append(top.ox());
        localStringBuilder.append(" and isValid=1 ");
        paramString = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
      } while (paramString == null);
      paramQQAppInterface = paramQQAppInterface.rawQuery(paramString.toString(), null);
    } while (paramQQAppInterface == null);
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      paramInt = paramQQAppInterface.getColumnIndex("shmsgseq");
    }
    try
    {
      if (!paramQQAppInterface.isNull(paramInt))
      {
        l = paramQQAppInterface.getLong(paramInt);
        if (l > 0L) {
          paramStringBuilder.append(String.valueOf(l));
        }
        paramInt = paramQQAppInterface.getCount();
        paramQQAppInterface.close();
        return paramInt;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("TroopUtils", 1, "lastMessage error:", paramString);
        long l = 0L;
      }
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (paramResources = paramDrawable.getConstantState().newDrawable(paramResources);; paramResources = paramDrawable.getConstantState().newDrawable(paramResources).mutate())
    {
      paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramResources.setAlpha(paramInt >>> 24);
      return paramResources;
    }
  }
  
  public static Bundle a(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.lCode));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.lUin));
    localBundle.putString("troop_info_name", paramGroupInfo.strName);
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.iFaceId);
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.strIntro);
    localBundle.putString("troop_info_loca", paramGroupInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwCertType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.iMemberCnt);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", (int)paramGroupInfo.dwGroupActiveGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("authSig", paramGroupInfo.strJoinSig);
    if (!TextUtils.isEmpty(paramGroupInfo.strJoinAuth)) {
      localBundle.putString("authKey", paramGroupInfo.strJoinAuth);
    }
    return localBundle;
  }
  
  public static Pair<String, ArrayList<MessageForText.AtTroopMemberInfo>> a(Editable paramEditable)
  {
    int j = -1;
    ArrayList localArrayList = new ArrayList();
    paramEditable = appb.a(paramEditable, localArrayList);
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo2;
    if (!localArrayList.isEmpty())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo1 = (MessageForText.AtTroopMemberInfo)localArrayList.get(0);
      localAtTroopMemberInfo2 = (MessageForText.AtTroopMemberInfo)localArrayList.get(localArrayList.size() - 1);
      if ((localAtTroopMemberInfo1 == null) || (localAtTroopMemberInfo2 == null)) {
        break label109;
      }
      j = localAtTroopMemberInfo1.startPos;
    }
    label109:
    for (int i = localAtTroopMemberInfo2.startPos + localAtTroopMemberInfo2.textLen;; i = -1)
    {
      if ((j >= 0) && (i >= 0) && (j < i)) {
        paramEditable = paramEditable.substring(j, i);
      }
      for (;;)
      {
        return new Pair(paramEditable, localArrayList);
      }
    }
  }
  
  public static apzg a(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramTroopInfoData == null) || (paramQQAppInterface == null)) {
      return null;
    }
    paramBaseActivity = new apzg(paramBaseActivity, paramTroopInfoData, new apui(paramTroopInfoData));
    paramBaseActivity.a(paramTroopInfoData);
    anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_share", 0, 0, paramTroopInfoData.troopUin, "", "", "");
    if (paramTroopInfoData.isMember) {
      aqfr.b("Grp_set_new", "grpData_admin", "clk_share", 0, 0, new String[] { paramTroopInfoData.troopUin, aqfr.a(paramTroopInfoData) });
    }
    return paramBaseActivity;
  }
  
  public static TroopInfo a(QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Context paramContext)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(paramTroopInfoData.troopUin);
      if (localObject != null)
      {
        paramTroopInfoData.isMember = true;
        paramTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
      }
      return localObject;
    }
    return null;
  }
  
  public static EntryModel a(TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {
      return null;
    }
    EntryModel localEntryModel = new EntryModel(1, Long.parseLong(paramTroopInfo.troopuin), paramTroopInfo.troopname, paramTroopInfo.isAdmin());
    localEntryModel.reportData = ("groupid=" + paramString);
    localEntryModel.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
    return localEntryModel;
  }
  
  public static TroopInfoData a(Bundle paramBundle, Context paramContext)
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    if (paramBundle == null) {}
    for (;;)
    {
      return localTroopInfoData;
      localTroopInfoData.troopUin = paramBundle.getString("troop_uin");
      localTroopInfoData.troopCode = paramBundle.getString("troop_code");
      try
      {
        long l = Long.parseLong(localTroopInfoData.troopUin);
        if (l > 0L)
        {
          localTroopInfoData.pa = paramBundle.getInt("troop_info_from");
          localTroopInfoData.nStatOption = paramBundle.getInt("troop_info_from_ex");
          localTroopInfoData.remark = paramBundle.getString("param_return_addr");
          localTroopInfoData.isMember = paramBundle.getBoolean("troop_info_is_member");
          localTroopInfoData.troopface = paramBundle.getShort("troop_info_faceid");
          localTroopInfoData.troopName = paramBundle.getString("troop_info_name");
          localTroopInfoData.newTroopName = localTroopInfoData.troopName;
          localTroopInfoData.troopowneruin = paramBundle.getString("troop_info_owner");
          localTroopInfoData.dwGroupClassExt = paramBundle.getLong("troop_info_classext");
          localTroopInfoData.troopLocation = paramBundle.getString("troop_info_loca");
          localTroopInfoData.mRichFingerMemo = paramBundle.getString("troop_info_fingermemo");
          if (!TextUtils.isEmpty(localTroopInfoData.mRichFingerMemo))
          {
            localTroopInfoData.mRichFingerMemo = jqc.dS(localTroopInfoData.mRichFingerMemo);
            localTroopInfoData.mRichFingerMemo = jqc.dR(localTroopInfoData.mRichFingerMemo);
          }
          localTroopInfoData.cGroupOption = ((short)paramBundle.getByte("troop_info_opt"));
          localTroopInfoData.mStrJoinQuestion = aqfs.K(paramContext, localTroopInfoData.troopUin);
          localTroopInfoData.nTroopGrade = paramBundle.getInt("TROOP_INFO_TROOP_GRADE");
          localTroopInfoData.mStrJoinAnswer = aqfs.L(paramContext, localTroopInfoData.troopUin);
          localTroopInfoData.dwGroupFlagExt = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
          localTroopInfoData.dwAuthGroupType = paramBundle.getLong("TROOP_INFO_AUTH_TYPE");
          localTroopInfoData.troopTags = TroopInfo.getTags(paramBundle.getString("TROOP_INFO_TAGS_EXT"));
          return localTroopInfoData;
        }
      }
      catch (NumberFormatException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    return localTroopInfoData;
  }
  
  public static String a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      return null;
    }
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    Object localObject;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localObject = new JSONObject();
      Iterator localIterator = paramBundle1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject).put(str, wrap(paramBundle1.get(str)));
        continue;
        return paramBundle1;
      }
    }
    catch (JSONException paramBundle1)
    {
      paramBundle1.printStackTrace();
      paramBundle1 = null;
    }
    for (;;)
    {
      localJSONObject2.put("param", localObject);
      if (paramBundle2 != null)
      {
        paramBundle1 = paramBundle2.keySet().iterator();
        while (paramBundle1.hasNext())
        {
          localObject = (String)paramBundle1.next();
          localJSONObject2.put((String)localObject, wrap(paramBundle2.get((String)localObject)));
        }
      }
      localJSONObject1.put("key", localJSONObject2);
      paramBundle1 = localJSONObject1.toString();
    }
  }
  
  /* Error */
  public static String a(View paramView, oidb_0xea4.TabInfo paramTabInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 655	tencent/im/oidb/cmd0xea4/oidb_0xea4$TabInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4: invokevirtual 659	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   7: invokestatic 665	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   10: astore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: aload 4
    //   16: ifnull +151 -> 167
    //   19: aload 4
    //   21: ldc_w 667
    //   24: invokevirtual 670	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload 4
    //   30: ldc_w 645
    //   33: invokevirtual 670	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: ifnull +21 -> 60
    //   42: aload_1
    //   43: invokestatic 675	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: iload_3
    //   48: istore_2
    //   49: aload_0
    //   50: ldc_w 676
    //   53: iload_2
    //   54: invokestatic 679	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokevirtual 685	android/view/View:setTag	(ILjava/lang/Object;)V
    //   60: aload 4
    //   62: ifnull +105 -> 167
    //   65: aload_0
    //   66: ldc_w 686
    //   69: aload 4
    //   71: invokevirtual 685	android/view/View:setTag	(ILjava/lang/Object;)V
    //   74: new 611	org/json/JSONObject
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 687	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   83: astore_0
    //   84: aload_0
    //   85: ldc_w 689
    //   88: invokevirtual 692	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   91: ifeq +76 -> 167
    //   94: aload_0
    //   95: ldc_w 689
    //   98: invokevirtual 695	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: ldc 57
    //   107: iconst_1
    //   108: ldc_w 697
    //   111: aload_1
    //   112: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aconst_null
    //   116: astore 4
    //   118: goto -106 -> 12
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_1
    //   125: ldc 57
    //   127: iconst_1
    //   128: ldc_w 699
    //   131: aload 4
    //   133: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aconst_null
    //   137: astore 4
    //   139: goto -101 -> 38
    //   142: astore_1
    //   143: ldc 57
    //   145: iconst_1
    //   146: ldc_w 701
    //   149: aload_1
    //   150: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -104 -> 49
    //   156: astore_0
    //   157: ldc 57
    //   159: iconst_1
    //   160: ldc_w 703
    //   163: aload_0
    //   164: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aconst_null
    //   168: areturn
    //   169: astore 4
    //   171: goto -46 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramView	View
    //   0	174	1	paramTabInfo	oidb_0xea4.TabInfo
    //   13	41	2	i	int
    //   46	2	3	j	int
    //   10	107	4	localObject1	Object
    //   121	11	4	localException1	Exception
    //   137	1	4	localObject2	Object
    //   169	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	104	java/lang/Exception
    //   19	28	121	java/lang/Exception
    //   42	47	142	java/lang/Exception
    //   74	102	156	java/lang/Exception
    //   28	38	169	java/lang/Exception
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<oidb_0x899.memberlist> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < j)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
      if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
      for (;;)
      {
        i += 1;
        break;
        long l = localmemberlist.uint64_member_uin.get();
        if (l != 0L) {
          localStringBuilder.append(String.valueOf(l) + "|");
        }
      }
    }
    paramTroopInfo.Administrator = localStringBuilder.toString();
    if (paramBoolean) {
      ((TroopManager)paramQQAppInterface.getManager(52)).i(paramTroopInfo);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramArrayList = TroopInfo.convertMemberUinListToString(paramArrayList, 10);
      if (!TextUtils.equals(paramTroopInfo.memberListToShow, paramArrayList))
      {
        a(paramTroopInfo, paramQQAppInterface, paramBoolean);
        return paramArrayList;
      }
    }
    return null;
  }
  
  public static String a(String paramString, long paramLong, int paramInt, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfoData.bOwner)
    {
      str = "0";
      paramQQAppInterface = paramString.replace("$GCODE$", paramTroopInfoData.troopUin).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label169;
      }
    }
    label169:
    for (paramString = "1";; paramString = "2")
    {
      paramQQAppInterface = paramQQAppInterface.replace("$ENTERSOURCE$", paramString).replace("$GUIN$", paramTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
      paramString = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
        paramString = paramQQAppInterface.replace("$GNAME$", paramTroopInfoData.newTroopName);
      }
      return paramString;
      if (paramTroopInfoData.bAdmin)
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        paramString = null;
      }
    }
    do
    {
      return paramString;
      str = paramString.replace("%req_uin%", str);
      paramString = str;
      if (str.contains("%action_uin%"))
      {
        paramString = paramStructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramString = str.replace("%action_uin%", paramString);
      }
      str = paramString;
      if (paramString.contains("%actor_uin%"))
      {
        str = paramStructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = paramString.replace("%actor_uin%", str);
      }
      paramString = str;
    } while (!str.contains("%group_name%"));
    paramStructMsg = paramStructMsg.msg.group_name.get();
    if (TextUtils.isEmpty(paramStructMsg)) {
      return null;
    }
    return str.replace("%group_name%", paramStructMsg);
  }
  
  public static JSONArray a(Object paramObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    if (!paramObject.getClass().isArray()) {
      throw new JSONException("Not a primitive array: " + paramObject.getClass());
    }
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(wrap(Array.get(paramObject, i)));
      i += 1;
    }
    return localJSONArray;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, aqqj.o(paramActivity, "background", ""), 33554432L, localIntent, true, paramInt);
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        if (paramInt != -1) {
          continue;
        }
        TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(52);
        if (localTroopManager == null) {
          continue;
        }
        if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
          break label162;
        }
        bool1 = true;
        paramInt = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label161;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt);
      if (b(paramInt, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        paramContext.startActivity(localIntent);
        return;
      }
      PublicFragmentActivity.start(paramContext, localIntent, VisitorTroopCardFragment.class);
      return;
      label161:
      return;
      label162:
      boolean bool1 = false;
      paramInt = 2;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        bool2 = paramBundle.getBoolean("troop_info_from_troopsetting", false);
        if (paramInt1 != -1) {
          continue;
        }
        TroopManager localTroopManager = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(52);
        if (localTroopManager == null) {
          continue;
        }
        if (localTroopManager.b(paramBundle.getString("troop_uin")) == null) {
          break label173;
        }
        bool1 = true;
        paramInt1 = 1;
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        boolean bool2;
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.i("TroopUtils", 2, paramContext.toString());
        return;
        bool1 = false;
        continue;
      }
      localIntent.putExtra("vistor_type", paramInt1);
      if (b(paramInt1, bool1, bool2))
      {
        localIntent.setClass(paramContext, ChatSettingForTroop.class);
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
        return;
      }
      PublicFragmentActivity.startForResult((Activity)paramContext, localIntent, VisitorTroopCardFragment.class, paramInt2);
      return;
      label172:
      return;
      label173:
      boolean bool1 = false;
      paramInt1 = 2;
    }
  }
  
  public static void a(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt)
  {
    paramRecommendTroopItem = paramRecommendTroopItem.getJumpUrl(paramInt);
    Intent localIntent = new Intent(paramContext, JoinGroupTransitActivity.class);
    localIntent.putExtra("source_scheme", paramRecommendTroopItem);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, RecommendTroopItem paramRecommendTroopItem, int paramInt1, int paramInt2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    for (;;)
    {
      try
      {
        localGroupInfo.lCode = Long.valueOf(paramRecommendTroopItem.uin).longValue();
        localGroupInfo.strName = paramRecommendTroopItem.name;
        if (TextUtils.isEmpty(paramRecommendTroopItem.recommendReason))
        {
          localGroupInfo.strIntro = paramRecommendTroopItem.intro;
          localGroupInfo.iMemberCnt = paramRecommendTroopItem.memberNum;
          ArrayList localArrayList = joa.a(paramRecommendTroopItem);
          if (localArrayList != null) {
            localGroupInfo.labels = localArrayList;
          }
          localGroupInfo.strJoinSig = paramRecommendTroopItem.authSig;
          a(paramContext, a(paramInt1, localGroupInfo, paramInt2, false), 2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("TroopUtils", 1, "cast string2long error");
        return;
      }
      localGroupInfo.strIntro = paramRecommendTroopItem.recommendReason;
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean, String paramString1, String paramString2, aldh.a parama)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363620);
    paramView = (TextView)paramView.findViewById(2131377275);
    if (TextUtils.isEmpty(paramCharSequence1)) {
      if (TextUtils.isEmpty(paramCharSequence3)) {
        paramView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence3);
      continue;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1);
      if (paramBoolean) {
        aldh.a(paramView, paramString1, paramString2, parama);
      }
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  public static void a(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramTroopInfoData == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i;
    if (paramBaseActivity.getIntent().getIntExtra("t_s_f", -1) == 1002) {
      i = 20014;
    }
    for (;;)
    {
      String str1 = paramTroopInfoData.troopUin;
      if (!paramTroopInfoData.isMember) {
        break;
      }
      aqfr.b("Grp_set_new", "grpData_admin", "clk_report", 0, 0, new String[] { paramTroopInfoData.troopUin, aqfr.a(paramTroopInfoData) });
      paramTroopInfoData = stj.b(str1, 1);
      stj.a(paramBaseActivity, str1, null, null, str1, paramQQAppInterface.getAccount(), i, null, paramTroopInfoData);
      return;
      if (paramTroopInfoData.isMember) {
        i = 22000;
      } else {
        i = 22003;
      }
    }
    String str2 = paramTroopInfoData.troopUin;
    if (paramTroopInfoData.isMember) {}
    for (paramTroopInfoData = "1";; paramTroopInfoData = "0")
    {
      aqfr.b("Grp_set_new", "grpData_visitor", "clk_report", 0, 0, new String[] { str2, paramTroopInfoData });
      paramTroopInfoData = null;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (aprp)paramQQAppInterface.getManager(109);
    if (paramString2 != null) {
      if (!((TroopManager)paramQQAppInterface.getManager(52)).c(paramString1).isHomeworkTroop()) {
        break label172;
      }
    }
    label172:
    for (int i = 32;; i = 0)
    {
      paramString2 = paramString2.b(1104864064, i);
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.url))) {}
      for (paramString2 = paramString2.url.replace("$GCODE$", paramString1);; paramString2 = null)
      {
        String str = paramString2;
        if (paramString2 == null) {
          str = cry + paramString1;
        }
        localIntent.putExtra("url", str);
        paramActivity.startActivityForResult(localIntent, 12001);
        anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    avpw.d locald;
    if (paramInt != 0)
    {
      bool = true;
      locald = avpw.d.a();
      locald.cMP = paramQQAppInterface.getCurrentAccountUin();
      locald.nickname = paramQQAppInterface.getCurrentNickname();
      acms localacms = (acms)paramQQAppInterface.getBusinessHandler(20);
      if (!TextUtils.isEmpty(paramString1)) {
        localacms.bM(paramString1, true);
      }
      if (aqgx.m(paramQQAppInterface.getCurrentAccountUin(), "troop_photo_message", paramString1) <= 0) {
        break label123;
      }
      avpw.d(paramActivity, locald, paramString1, 7);
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, paramString1, "", "", "");
      jpp.a(paramQQAppInterface, 66);
      return;
      bool = false;
      break;
      label123:
      avpw.a(paramActivity, locald, paramString1, paramString2, bool, 7);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, aprb.a parama)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramIntent == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("o");
    Object localObject2;
    String str3;
    String str2;
    if (str1.length() < 10)
    {
      int i = 0;
      while (i < 10 - str1.length())
      {
        ((StringBuilder)localObject1).append("0");
        i += 1;
      }
      ((StringBuilder)localObject1).append(str1);
      localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
      localBundle.putString("Cookie", "uin=" + localObject1 + "; skey=" + ((TicketManager)localObject2).getSkey(str1));
      localBundle.putString("Host", "info.gamecenter.qq.com");
      str3 = paramIntent.getStringExtra("appid");
      str2 = paramIntent.getStringExtra("is_from_game");
      str1 = "";
      localObject1 = "";
      localObject2 = "";
      if ((!"true".equals(str2)) || (TextUtils.isEmpty(str3))) {
        break label502;
      }
      a(paramQQAppInterface, paramContext, str3, parama, 0, null);
      localObject1 = paramIntent.getStringExtra("guild_id");
      str1 = paramIntent.getStringExtra("zone_id");
      paramQQAppInterface = paramIntent.getStringExtra("role_id");
      localObject2 = paramIntent.getStringExtra("gc");
      paramIntent = paramQQAppInterface;
      paramQQAppInterface = (QQAppInterface)localObject2;
    }
    for (;;)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appid", str3);
      ((Bundle)localObject2).putString("guild_id", (String)localObject1);
      ((Bundle)localObject2).putString("zone_id", str1);
      ((Bundle)localObject2).putString("gc", paramQQAppInterface);
      ((Bundle)localObject2).putString("platid", "2");
      ((Bundle)localObject2).putString("roleid", paramIntent);
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("module", "gc_bind_group_svr");
      paramQQAppInterface.putString("method", "join_group");
      paramQQAppInterface = a((Bundle)localObject2, paramQQAppInterface);
      localBundle.putString("param", paramQQAppInterface);
      localBundle.putString("signature", encrypt(paramQQAppInterface + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("BUNDLE", localBundle);
      paramQQAppInterface.put("CONTEXT", paramContext);
      new aprc(localStringBuilder.toString(), "GET", parama, 1, null).J(paramQQAppInterface);
      return;
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(str1);
      break;
      label502:
      str2 = "";
      paramQQAppInterface = (QQAppInterface)localObject2;
      paramIntent = (Intent)localObject1;
      localObject1 = str2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", crz + str);
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramMessageRecord == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troopUin", paramString1);
    int i;
    int j;
    try
    {
      paramString2 = paramString2.split("_");
      Object localObject;
      if ((paramString2 != null) && (paramString2.length > 2))
      {
        i = Integer.parseInt(paramString2[0]);
        localIntent.putExtra("grayType", i);
        j = Integer.parseInt(paramString2[1]);
        localIntent.putExtra("grayTypeSubId", j);
        if ((paramMessageRecord instanceof MessageForUniteGrayTip))
        {
          localObject = (MessageForUniteGrayTip)paramMessageRecord;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.xg != null))
          {
            paramMessageRecord = new ArrayList(5);
            localObject = ((MessageForUniteGrayTip)localObject).tipParam.xg.iterator();
          }
        }
      }
      else
      {
        while (((Iterator)localObject).hasNext())
        {
          MessageForGrayTips.HightlightItem localHightlightItem = (MessageForGrayTips.HightlightItem)((Iterator)localObject).next();
          if (localHightlightItem.actionType == 52)
          {
            paramMessageRecord.add(Long.valueOf(Long.parseLong(localHightlightItem.mMsg_A_ActionData)));
            continue;
            TroopRecommendFriendFragment.s(paramContext, localIntent);
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtils", 2, "openTroopRecommendMemberList " + paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      localIntent.putExtra("grayUinList", paramMessageRecord);
      long l = Long.parseLong(paramString2[2]);
      ((acms)paramQQAppInterface.getBusinessHandler(20)).af(paramString1, 2, i);
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(j), "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, FriendProfileCardActivity.class);
      localIntent.putExtra("troopUin", paramString2);
      localIntent.putExtra("memberUin", paramString1);
      aldj.a(paramContext, paramQQAppInterface, localIntent, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aprb.a parama, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(crA);
    String str = paramQQAppInterface.getAccount();
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = ((TicketManager)localObject).getSkey(str);
    localObject = ((TicketManager)localObject).getPskey(str, "connect.qq.com");
    localBundle.putString("Referer", "https://cgi.connect.qq.com/");
    localBundle.putString("Cookie", "p_skey=" + (String)localObject + ";p_uin=" + str + ";skey=" + paramQQAppInterface + ";uin=" + str);
    localStringBuilder.append("?");
    localStringBuilder.append("appid=" + paramString);
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put("BUNDLE", localBundle);
    paramQQAppInterface.put("CONTEXT", paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkApiState params = " + localBundle);
    }
    new aprc(localStringBuilder.toString(), "GET", parama, paramInt, paramBundle).J(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, long paramLong)
  {
    paramQQAppInterface = (ajdr)paramQQAppInterface.getManager(37);
    Object localObject = paramQQAppInterface.r(paramTroopInfoData.troopUin);
    if (localObject != null) {
      try
      {
        localRspBody = new oidb_0xea4.RspBody();
        localRspBody.mergeFrom((byte[])localObject);
        localObject = localRspBody.extra_info.tab_infos.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localTabInfo = (oidb_0xea4.TabInfo)((Iterator)localObject).next();
          if (localTabInfo.appid.get() == paramLong)
          {
            localTabInfo.red_point.set(0);
            if (paramLong == 1106837471L)
            {
              localTabInfo.desc.set("");
              localTabInfo.pic.set("");
              continue;
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopUtils.troop.troop_app", 2, "init, cached troopAppListData exception");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      oidb_0xea4.RspBody localRspBody;
      oidb_0xea4.TabInfo localTabInfo;
      paramQQAppInterface.h(paramTroopInfoData.troopUin, localRspBody.toByteArray());
      return;
    }
    QLog.d("TroopUtils.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString + " " + paramInt + " " + paramBoolean);
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putBoolean("red_tag_" + paramInt, paramBoolean).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, List<oidb_0xe3b.HighlightTitle> paramList, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "addTroopRecommendGrayTips " + paramString2 + " " + paramInt1 + " " + paramList + " " + paramInt2 + " " + paramLong);
    }
    ahwa localahwa;
    label172:
    int k;
    Bundle localBundle;
    if ((paramQQAppInterface != null) && (paramString1 != null) && (paramString2 != null))
    {
      localahwa = new ahwa(paramString1, paramString1, paramString2, 1, -5020, 131088, anaz.gQ());
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          oidb_0xe3b.HighlightTitle localHighlightTitle = (oidb_0xe3b.HighlightTitle)localIterator.next();
          if (localHighlightTitle.bytes_highlight_title.has())
          {
            paramList = localHighlightTitle.bytes_highlight_title.get().toStringUtf8();
            k = localHighlightTitle.enum_title_type.get();
            if (QLog.isColorLevel()) {
              QLog.i("TroopUtils", 2, "addTroopRecommendGrayTips highlight " + paramList + " " + k);
            }
            if (TextUtils.isEmpty(paramList)) {
              break label500;
            }
            int j = paramString2.indexOf(paramList, i);
            if (j == -1) {
              break label500;
            }
            localBundle = new Bundle();
            if (k != 0) {
              break label367;
            }
            localBundle.putInt("key_action", 52);
            localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
            localBundle.putString("key_a_action_DATA", String.valueOf(localHighlightTitle.uint64_uin.get()));
            label337:
            i = j + paramList.length();
            localahwa.addHightlightItem(j, i, localBundle);
          }
        }
      }
    }
    label367:
    label500:
    for (;;)
    {
      break;
      paramList = null;
      break label172;
      if (k != 1) {
        break label337;
      }
      localBundle.putInt("key_action", 53);
      localBundle.putString("key_action_DATA", paramInt1 + "_" + paramInt2 + "_" + paramLong);
      break label337;
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, localahwa);
      paramString2.saveExtInfoToExtStr("subIdAndGroupClass", paramInt2 + "_" + paramLong);
      paramQQAppInterface.b().b(paramString2, paramQQAppInterface.getCurrentAccountUin());
      m(paramQQAppInterface, paramString1, paramString2.time);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<ChatMessage> paramList)
  {
    long l = ((TroopManager)paramQQAppInterface.getManager(52)).ac(paramString);
    Object localObject1 = null;
    int i;
    ChatMessage localChatMessage;
    Object localObject2;
    if (l > 0L)
    {
      i = 0;
      for (;;)
      {
        if (i < paramList.size())
        {
          localChatMessage = (ChatMessage)paramList.get(i);
          if ((!(localChatMessage instanceof MessageForGrayTips)) && ((!(localChatMessage instanceof MessageForUniteGrayTip)) || (localChatMessage.time == l)))
          {
            if ((localChatMessage instanceof MessageForNewGrayTips))
            {
              localObject2 = localObject1;
              localObject1 = localObject2;
              i += 1;
              continue;
            }
            if ((localChatMessage instanceof MessageForSplitLineTips))
            {
              localObject2 = (MessageForSplitLineTips)localChatMessage;
              ((MessageForSplitLineTips)localObject2).parse();
              if (!acfp.m(2131716163).equalsIgnoreCase(((MessageForSplitLineTips)localObject2).msgContent)) {
                break;
              }
            }
          }
        }
      }
    }
    label265:
    for (;;)
    {
      return;
      localObject2 = localChatMessage;
      if (localChatMessage.time < l) {
        break;
      }
      for (;;)
      {
        if ((i <= 0) || (localObject1 == null)) {
          break label265;
        }
        localObject2 = (MessageForSplitLineTips)anbi.d(-4012);
        ((MessageForSplitLineTips)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), acfp.m(2131716168), l, -4012, 1, l);
        ((MessageForSplitLineTips)localObject2).shmsgseq = localObject1.shmsgseq;
        ((MessageForSplitLineTips)localObject2).isread = true;
        ((MessageForSplitLineTips)localObject2).mNeedTimeStamp = false;
        ((MessageForSplitLineTips)localObject2).msgContent = acfp.m(2131716169);
        ((MessageForSplitLineTips)localObject2).subType = 1;
        paramList.add(i, localObject2);
        return;
        localObject2 = localObject1;
        break;
        continue;
        i = 0;
        localObject1 = null;
      }
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 57
    //   8: iconst_2
    //   9: new 93	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1562
    //   19: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: ifnull +91 -> 124
    //   36: aload_1
    //   37: ifnull +87 -> 124
    //   40: aload_2
    //   41: ifnull +83 -> 124
    //   44: new 93	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: invokevirtual 1566	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 1572	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   58: invokevirtual 1576	android/content/Context:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 1581	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 1584	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 1586
    //   76: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_0
    //   87: new 1588	java/io/FileOutputStream
    //   90: dup
    //   91: new 1578	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 1589	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokespecial 1592	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokevirtual 1596	java/io/FileOutputStream:write	([B)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_1
    //   113: invokevirtual 1599	java/io/FileOutputStream:flush	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 1600	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -5 -> 124
    //   132: ldc 57
    //   134: iconst_2
    //   135: new 93	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1602
    //   145: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: return
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: astore_0
    //   164: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +31 -> 198
    //   170: aload_1
    //   171: astore_0
    //   172: ldc 57
    //   174: iconst_2
    //   175: new 93	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 1604
    //   185: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_1
    //   199: ifnull -75 -> 124
    //   202: aload_1
    //   203: invokevirtual 1600	java/io/FileOutputStream:close	()V
    //   206: return
    //   207: astore_0
    //   208: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -87 -> 124
    //   214: ldc 57
    //   216: iconst_2
    //   217: new 93	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 1602
    //   227: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: return
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 1600	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_0
    //   255: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -6 -> 252
    //   261: ldc 57
    //   263: iconst_2
    //   264: new 93	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 1602
    //   274: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: goto -35 -> 252
    //   290: astore_1
    //   291: goto -47 -> 244
    //   294: astore_2
    //   295: goto -133 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramQQAppInterface	QQAppInterface
    //   0	298	1	paramString	String
    //   0	298	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   120	124	125	java/lang/Exception
    //   87	103	159	java/lang/Exception
    //   202	206	207	java/lang/Exception
    //   87	103	241	finally
    //   248	252	254	java/lang/Exception
    //   105	110	290	finally
    //   112	116	290	finally
    //   164	170	290	finally
    //   172	198	290	finally
    //   105	110	294	java/lang/Exception
    //   112	116	294	java/lang/Exception
  }
  
  public static void a(TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramTroopInfo != null) && (paramBoolean)) {
      ThreadManager.post(new TroopUtils.2(paramQQAppInterface, paramTroopInfo), 5, null, false);
    }
  }
  
  public static void a(TroopInfoData paramTroopInfoData, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTroopInfoData.pa == 19)
    {
      anot.a(null, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 18)
    {
      anot.a(null, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 24)
    {
      anot.a(null, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
      return;
    }
    if (paramTroopInfoData.pa == 17)
    {
      anot.a(null, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, paramTroopInfoData.troopUin, "", "", "");
      return;
    }
    int i = -1;
    int j;
    switch (paramTroopInfoData.pa)
    {
    default: 
      j = i;
      if (i == -1)
      {
        if (paramTroopInfoData.nStatOption != 7) {
          break label464;
        }
        j = 3;
      }
      break;
    }
    for (;;)
    {
      i = paramTroopInfoData.getStatOption();
      anot.a(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", "" + i, paramInt2 + "");
      anot.a(null, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", j, 0, paramTroopInfoData.troopUin, paramInt1 + "", paramInt3 + "", "");
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 6;
      break;
      i = 7;
      break;
      i = 11;
      break;
      label464:
      if (paramTroopInfoData.nStatOption == 8)
      {
        j = 4;
      }
      else
      {
        j = i;
        if (paramTroopInfoData.nStatOption == 10002) {
          j = 10;
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = aqha.a(paramActivity, 230);
    paramActivity.setTitle(acfp.m(2131716164)).setMessage(acfp.m(2131716162)).setPositiveButton(acfp.m(2131716170), paramOnClickListener);
    paramActivity.show();
    aqfr.b("Grp_manage_new", "gainUin_msgBox", "exp", 0, 0, new String[] { String.valueOf(paramTroopInfo.troopuin), "", aqfr.a(paramTroopInfo, paramAppRuntime) });
  }
  
  public static void a(oidb_0xea4.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    if (paramAppInfo == null) {
      return;
    }
    Object localObject = new MiniAppInfo();
    ((MiniAppInfo)localObject).appId = String.valueOf(paramAppInfo.appid.get());
    ((MiniAppInfo)localObject).name = paramAppInfo.name.get();
    localObject = new MiniAppConfig((MiniAppInfo)localObject);
    ((MiniAppConfig)localObject).launchParam.scene = 2010;
    ((MiniAppConfig)localObject).config.via = "2010_3";
    ((MiniAppConfig)localObject).launchParam.reportData = ("groupid=" + paramString2 + "&category_tag=" + paramAppInfo.trace.get());
    MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "page_view", paramString1, null, null);
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, ProfileActivity.AllInOne paramAllInOne)
  {
    String str2 = null;
    if ((paramStructMsg == null) || (paramStructMsg.msg == null) || (paramAllInOne == null)) {
      return;
    }
    long l1 = paramStructMsg.msg.group_code.get();
    long l2 = paramStructMsg.msg.action_uin.get();
    int i = paramStructMsg.msg.group_msg_type.get();
    if (l1 != 0L) {}
    for (String str1 = String.valueOf(l1);; str1 = null)
    {
      if (l2 != 0L) {
        str2 = String.valueOf(l2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("troop_uin", str1);
      localBundle.putInt("flc_notify_type", i);
      if ((i == 2) || (i == 22)) {
        localBundle.putString("flc_recommend_uin", str2);
      }
      paramAllInOne.data.putBundle("flc_extra_param", localBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("addFriendTag", 2, String.format("prepareTroopNotifyData [uin:%s, group_code:%s, msg_type:%s, sub_type:%s, req_uin:%s, action_uin:%s, actor_uin:%s]", new Object[] { paramAllInOne.uin, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(paramStructMsg.msg.sub_type.get()), Long.valueOf(paramStructMsg.req_uin.get()), Long.valueOf(l2), Long.valueOf(paramStructMsg.msg.actor_uin.get()) }));
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, TextView paramTextView)
  {
    if ((e(paramBoolean1, paramString)) || (paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "isShowRedPoint:" + paramBoolean1);
      }
      c(paramBoolean1, paramTextView);
      return;
    }
  }
  
  public static boolean a(View paramView, oidb_0xea4.TabInfo paramTabInfo)
  {
    if ((paramTabInfo != null) && (paramTabInfo.appid.get() == 1106837471L) && ((paramView.getTag(2131379232) instanceof Integer))) {
      return ((Integer)paramView.getTag(2131379232)).intValue() == 1;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramLong + "");
    return (paramQQAppInterface != null) && (((paramQQAppInterface.troopowneruin != null) && (paramString.equals(paramQQAppInterface.troopowneruin))) || ((paramQQAppInterface.Administrator != null) && (paramQQAppInterface.Administrator.contains(paramString))));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return false;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<TroopAppInfo> paramArrayList)
  {
    paramQQAppInterface = (ajdr)paramQQAppInterface.getManager(37);
    paramQQAppInterface = paramQQAppInterface.aj(paramQQAppInterface.P(paramString));
    return (paramQQAppInterface != null) && (paramQQAppInterface.size() > 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramArrayOfInt != null)
        {
          bool1 = bool2;
          if (paramArrayOfBoolean != null)
          {
            bool1 = bool2;
            if (paramArrayOfInt.length == paramArrayOfBoolean.length)
            {
              paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0);
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayOfInt.length) {
        if (paramArrayOfBoolean[i] == 0) {
          break label152;
        }
      }
      label152:
      for (bool1 = paramQQAppInterface.getBoolean("red_tag_" + paramArrayOfInt[i], true); bool1; bool1 = false)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean aBA()
  {
    Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(52);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).cE();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        return true;
      }
    }
    return false;
  }
  
  public static long aS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    int j = 0;
    int m = 0;
    int k = 0;
    int n;
    if (j < paramString.length())
    {
      i = paramString.charAt(j);
      if ((i >= 48) && (i <= 57))
      {
        arrayOfInt[k] = (arrayOfInt[k] * 10 + (i - 48));
        i = 1;
        n = k;
      }
    }
    for (;;)
    {
      j += 1;
      m = i;
      k = n;
      break;
      if ((m != 0) && ((k == 3) || (i == 46)))
      {
        n = k + 1;
        if (n >= arrayOfInt.length)
        {
          long l = arrayOfInt[3] % 10000 + arrayOfInt[2] % 1000 * 10000 + arrayOfInt[1] % 1000 * 10000000 + arrayOfInt[0] % 1000 * 10000000000L;
          if (QLog.isColorLevel()) {
            QLog.i("TroopUtils", 2, String.format("convertQQFullVersion2Long [%s, %s]", new Object[] { Long.valueOf(l), paramString }));
          }
          return l;
        }
        i = 0;
      }
      else
      {
        i = m;
        n = k;
        if (m != 0)
        {
          arrayOfInt[k] = 0;
          i = 0;
          n = k;
        }
      }
    }
  }
  
  public static byte[] ad(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static boolean ai(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = paramContext.getSharedPreferences("UserGuide", 0);
          paramContext = ((SharedPreferences)localObject).getString("qq_version_pre", null);
          localObject = ((SharedPreferences)localObject).getString("qq_version_full_pre", null);
          if (!TextUtils.isEmpty(paramContext)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre[%s, %s]", new Object[] { paramContext, localObject }));
        return false;
        if (!TextUtils.equals("3058", paramContext)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { "3058", paramContext }));
      return false;
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = "8.0.0";
      }
      localObject = AppSetting.nT();
      if (!TextUtils.equals(paramContext, (CharSequence)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion pre: %s, cur: %s", new Object[] { localObject, paramContext }));
    return false;
    long l1 = aS(paramString);
    long l2 = aS(paramContext);
    if (Math.abs(l2) < Math.abs(l1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUtils", 2, String.format("isUpdateBeforeSomeVersion some: %s, pre: %s, ret: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public static boolean aw(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() < 1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if (aqgx.m(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aqgx.v(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString, 0);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.cjr, paramString);
      localIntent.putExtra("param_from", 3000);
      TroopFileProxyActivity.b(paramActivity, localIntent, 14, paramQQAppInterface.getCurrentAccountUin());
      anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, paramString, "0", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + paramString);
      }
      jpp.a(paramQQAppInterface, 67);
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    paramContext = new apto();
    paramContext.action = 1;
    paramContext.cSm = true;
    try
    {
      paramContext.asb = Long.parseLong(paramString2);
      paramQQAppInterface.b().as(paramContext);
      anot.a(null, "dc00898", "", "", "0X800ADF1", "0X800ADF1", 0, 1, "", "", "", "");
      return;
    }
    catch (NumberFormatException paramMessageRecord)
    {
      for (;;)
      {
        QLog.e("TroopUtils", 1, paramMessageRecord, new Object[0]);
        paramContext.asb = 0L;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface != null) && (paramMessageForUniteGrayTip != null))
    {
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("subIdAndGroupClass");
      if (paramMessageForUniteGrayTip == null) {}
    }
    try
    {
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.split("_");
      if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.length > 1))
      {
        int i = Integer.parseInt(paramMessageForUniteGrayTip[0]);
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AD4E", "0X800AD4E", (int)Long.parseLong(paramMessageForUniteGrayTip[1]), 0, String.valueOf(i), "", "", "");
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, "reportTroopRecommendGrayTipsExpose " + paramQQAppInterface);
    }
  }
  
  private static boolean b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramInt == 1) || ((paramBoolean1) && (!paramBoolean2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (TextUtils.equals(paramMessageRecord.senderuin, paramString)) {
        return true;
      }
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramMessageRecord.frienduin);
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramQQAppInterface.isTroopOwner(paramString)) {
        return true;
      }
      if ((paramQQAppInterface.isTroopAdmin(paramString)) && (!paramQQAppInterface.isTroopOwner(paramMessageRecord.senderuin)) && (!paramQQAppInterface.isTroopAdmin(paramMessageRecord.senderuin))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] b(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: aload_0
    //   12: ifnull +113 -> 125
    //   15: aload 5
    //   17: astore_2
    //   18: aload_1
    //   19: ifnull +106 -> 125
    //   22: new 93	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: invokevirtual 1566	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 1572	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   36: invokevirtual 1576	android/content/Context:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 1581	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 1584	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 1586
    //   54: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_0
    //   65: new 1578	java/io/File
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 1589	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 1954	java/io/File:exists	()Z
    //   78: ifeq +241 -> 319
    //   81: new 1956	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 1957	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: aload_0
    //   93: invokevirtual 1960	java/io/FileInputStream:available	()I
    //   96: newarray byte
    //   98: astore_1
    //   99: aload_0
    //   100: astore_2
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 1964	java/io/FileInputStream:read	([B)I
    //   106: pop
    //   107: aload_1
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: ifnull +9 -> 125
    //   119: aload_1
    //   120: invokevirtual 1965	java/io/FileInputStream:close	()V
    //   123: aload_0
    //   124: astore_2
    //   125: aload_2
    //   126: areturn
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -8 -> 125
    //   136: ldc 57
    //   138: iconst_2
    //   139: new 93	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 1967
    //   149: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: areturn
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_0
    //   167: aload 4
    //   169: astore_1
    //   170: aload_0
    //   171: astore_2
    //   172: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +31 -> 206
    //   178: aload_0
    //   179: astore_2
    //   180: ldc 57
    //   182: iconst_2
    //   183: new 93	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 1967
    //   193: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_1
    //   207: astore_2
    //   208: aload_0
    //   209: ifnull -84 -> 125
    //   212: aload_0
    //   213: invokevirtual 1965	java/io/FileInputStream:close	()V
    //   216: aload_1
    //   217: areturn
    //   218: astore_0
    //   219: aload_1
    //   220: astore_2
    //   221: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq -99 -> 125
    //   227: ldc 57
    //   229: iconst_2
    //   230: new 93	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 1967
    //   240: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_1
    //   254: areturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 1965	java/io/FileInputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_1
    //   269: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -6 -> 266
    //   275: ldc 57
    //   277: iconst_2
    //   278: new 93	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 1967
    //   288: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_1
    //   292: invokevirtual 842	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 960	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: goto -35 -> 266
    //   304: astore_0
    //   305: goto -47 -> 258
    //   308: astore_3
    //   309: aload 4
    //   311: astore_1
    //   312: goto -142 -> 170
    //   315: astore_3
    //   316: goto -146 -> 170
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_3
    //   322: astore_0
    //   323: goto -210 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramQQAppInterface	QQAppInterface
    //   0	326	1	paramString	String
    //   10	253	2	localObject1	Object
    //   7	1	3	localObject2	Object
    //   164	33	3	localException1	Exception
    //   308	1	3	localException2	Exception
    //   315	7	3	localException3	Exception
    //   4	306	4	localObject3	Object
    //   1	15	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	123	127	java/lang/Exception
    //   65	90	164	java/lang/Exception
    //   212	216	218	java/lang/Exception
    //   65	90	255	finally
    //   262	266	268	java/lang/Exception
    //   92	99	304	finally
    //   101	107	304	finally
    //   172	178	304	finally
    //   180	206	304	finally
    //   92	99	308	java/lang/Exception
    //   101	107	315	java/lang/Exception
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    new arie(paramContext).V(paramInt2, paramInt1, 0, paramInt3);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopInfoEditRedShow " + paramString2 + " " + paramBoolean);
    }
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null)) {
      paramContext.getSharedPreferences("sp_troop_info_edit_red_show_" + paramString1 + "_" + paramString2, 0).edit().putBoolean("manage_red", paramBoolean).commit();
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      ThreadManager.getSubThreadHandler().post(new TroopUtils.5(paramQQAppInterface, paramString1, paramString2, paramString3, paramContext));
    }
  }
  
  public static void c(boolean paramBoolean, TextView paramTextView)
  {
    if (paramBoolean)
    {
      paramTextView.setVisibility(0);
      paramTextView.setBackgroundResource(0);
      paramTextView.setCompoundDrawablePadding(wja.dp2px(10.0F, BaseApplicationImpl.getApplication().getResources()));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842212, 0);
      return;
    }
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramMessageRecord.frienduin);
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((paramQQAppInterface.isTroopOwner(paramString)) || (paramQQAppInterface.isTroopAdmin(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean cS(long paramLong)
  {
    return (paramLong != 10009L) && (paramLong != 10010L) && (paramLong != 10011L) && (paramLong != 32L);
  }
  
  public static void d(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("be_admin_in_the_troop", paramBoolean);
    PublicFragmentActivity.start(paramActivity, localIntent, TroopRobotFragment.class);
    if (QLog.isColorLevel()) {
      QLog.d("TroopUtils", 2, "jumpRobotPage");
    }
  }
  
  public static long e(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("report_timestamp", -1L);
      }
    }
    return l1;
  }
  
  public static void e(boolean paramBoolean, View paramView)
  {
    if (QSecFramework.a().c(1001).booleanValue())
    {
      if (paramBoolean) {
        QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(2), paramView }, null);
      }
    }
    else {
      return;
    }
    QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
  }
  
  public static boolean e(boolean paramBoolean, String paramString)
  {
    boolean bool3 = false;
    if (paramBoolean) {}
    for (boolean bool1 = hu(paramString);; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, String.format("isShowRedPoint [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
      }
      boolean bool2 = bool3;
      if (paramBoolean)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public static int eU(String paramString)
  {
    int i = 0;
    if (aqmr.isEmpty(paramString)) {
      return 0;
    }
    int j = 5381;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static String encrypt(String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(ad(paramString));
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = paramString;
      if (arrayOfByte != null)
      {
        localObject = new StringBuilder();
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          ((StringBuilder)localObject).append(a(k >>> 4));
          ((StringBuilder)localObject).append(a(k));
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      do
      {
        Object localObject = paramString;
      } while (!QLog.isColorLevel());
      QLog.e("TroopUtils", 2, "encrypt has exception: " + localNoSuchAlgorithmException.getMessage());
    }
    return localObject;
    return paramString;
  }
  
  public static long f(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static Bitmap f(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    int i;
    if (j > 0)
    {
      i = k;
      if (k > 0) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "drawable width or height is 0, and use default drawable");
      }
      paramDrawable = aqdj.g(1, 1);
      j = paramDrawable.getIntrinsicWidth();
      k = paramDrawable.getIntrinsicHeight();
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "the default drawable width or height is 0");
        }
        return null;
      }
    }
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(j, i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, j, i);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = aqgv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, false);
    Intent localIntent = wja.a(new Intent((Context)localObject, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramContext);
    localIntent.putExtra("isBack2Root", true);
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
    ((Context)localObject).startActivity(localIntent);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopOwner(paramString2);
  }
  
  public static boolean f(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (hu(paramString));
  }
  
  public static long g(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getLong("old_last_add_time", 0L);
      }
    }
    return l1;
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.isTroopAdmin(paramString2);
  }
  
  public static boolean hu(String paramString)
  {
    String str = aqfe.get(BaseApplicationImpl.getApplication(), paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, String.format("isEmptyRedPointSP [%s, %s]", new Object[] { paramString, str }));
    }
    return TextUtils.isEmpty(str);
  }
  
  public static void j(long paramLong1, String paramString, long paramLong2)
  {
    String str = Long.toString(paramLong1);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = (TroopManager)localQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(str);
    if (localTroopInfo != null) {
      if (TextUtils.equals(paramString, localTroopInfo.oldTroopName)) {
        break label190;
      }
    }
    label190:
    for (int i = 1;; i = 0)
    {
      localTroopInfo.troopname = paramString;
      localTroopInfo.oldTroopName = paramString;
      localTroopInfo.hasSetNewTroopName = true;
      ((TroopManager)localObject).i(localTroopInfo);
      localObject = (acms)localQQAppInterface.getBusinessHandler(20);
      ((acms)localObject).notifyUI(2, false, null);
      ((accc)localQQAppInterface.getBusinessHandler(22)).notifyUI(43, true, new Object[] { str, paramString, null });
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopUtils", 2, "TroopUtils handleModifyName :" + localTroopInfo.troopname);
        }
        ((acms)localObject).av(str, String.valueOf(paramLong2), paramString);
      }
      return;
    }
  }
  
  public static int jO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    }
    return 1;
  }
  
  public static int jP(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return -1;
  }
  
  public static Drawable k(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, paramResources.getDrawable(2130850705));
  }
  
  public static String k(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static String l(Context paramContext, long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = paramContext.getResources().getString(2131698360) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  public static void l(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "shareGroup:" + paramString);
    }
    TroopInfoData localTroopInfoData = new TroopInfoData();
    localTroopInfoData.troopUin = paramString;
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null)
      {
        localTroopInfoData.updateForTroopChatSetting(paramString, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
        localTroopInfoData.isMember = true;
        if ((paramContext instanceof BaseActivity))
        {
          paramQQAppInterface = new apzg((BaseActivity)paramContext, localTroopInfoData);
          paramQQAppInterface.St(true);
          if (Looper.myLooper() == Looper.getMainLooper()) {
            break label141;
          }
          ThreadManager.getUIHandler().post(new TroopUtils.3(paramQQAppInterface, localTroopInfoData));
        }
      }
    }
    return;
    label141:
    paramQQAppInterface.a(localTroopInfoData);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setTroopRecommendGrayTipsReportTimestamp " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("report_timestamp", paramLong).commit();
    }
  }
  
  public static void m(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "openTroopInfoActivityFromAIO." + paramString);
    }
    if (paramContext == null) {}
    TroopInfoData localTroopInfoData;
    Object localObject;
    do
    {
      do
      {
        return;
        localTroopInfoData = new TroopInfoData();
        localTroopInfoData.troopUin = paramString;
        localObject = (TroopManager)paramQQAppInterface.getManager(52);
      } while (localObject == null);
      localObject = ((TroopManager)localObject).b(paramString);
    } while (localObject == null);
    if (((TroopInfo)localObject).isAdmin())
    {
      localTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject, paramContext.getResources(), paramQQAppInterface.getCurrentAccountUin());
      localTroopInfoData.isMember = true;
      paramQQAppInterface = TroopInfoActivity.a(paramString, 115, localTroopInfoData.troopLat, localTroopInfoData.troopLon, localTroopInfoData.cityId, localTroopInfoData.troopLocation);
      paramQQAppInterface.putInt("troop_type_ex", localTroopInfoData.troopTypeExt);
      paramQQAppInterface.putInt("PARAM_EXIT_ANIMATION", 2);
      TroopInfoActivity.i(paramContext, paramQQAppInterface);
      return;
    }
    ThreadManager.getUIHandler().post(new TroopUtils.4(paramContext));
  }
  
  public static void m(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("last_add_time", paramLong).commit();
    }
  }
  
  public static void mT(List<String> paramList)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      aptw localaptw = (aptw)((QQAppInterface)localObject).getManager(203);
      localObject = null;
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!localaptw.gM(str)) {
          break label88;
        }
        localObject = str;
      }
    }
    label88:
    for (;;)
    {
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.remove(localObject);
      }
      return;
    }
  }
  
  public static int n(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 3;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return 0;
      }
      if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentAccountUin())) {
        return 1;
      }
      if (TroopInfo.isTroopMember(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin())) {
        return 2;
      }
    }
    return 3;
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "setOldRecommendGrayTipsLastInsertTime " + paramString + " " + paramLong);
    }
    if ((paramQQAppInterface != null) && (paramString != null)) {
      paramQQAppInterface.getApp().getBaseContext().getSharedPreferences("sp_troop_recommend_graytips_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).edit().putLong("old_last_add_time", paramLong).commit();
    }
  }
  
  public static final int o(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
      if (paramString != null)
      {
        if (paramString.isTroopOwner(paramQQAppInterface.getCurrentUin())) {
          return 0;
        }
        if (paramString.isTroopAdmin(paramQQAppInterface.getCurrentUin())) {
          return 1;
        }
        return 2;
      }
    }
    return 2;
  }
  
  public static boolean o(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString2 != null) {
          bool1 = paramContext.getSharedPreferences("sp_troop_info_edit_red_show_" + paramString1 + "_" + paramString2, 0).getBoolean("manage_red", true);
        }
      }
    }
    return bool1;
  }
  
  public static void q(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "AIO_TROOP_MINI_APP_ENTRANCE", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static boolean ra(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52);
    paramString = localTroopManager.d(paramString);
    if (paramString != null) {
      return paramString.hasSetTroopHead();
    }
    return (acms.bJx) && (localTroopManager.abL());
  }
  
  public static void t(Activity paramActivity, int paramInt)
  {
    arie localarie = new arie(paramActivity);
    int i = paramActivity.getResources().getDimensionPixelSize(2131299627);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    default: 
      localarie.V(2131695144, i, 0, 1);
      return;
    case 2: 
      localarie.p(acfp.m(2131716171), i, 0, 1);
      return;
    case 3: 
      localarie.p(acfp.m(2131716160), i, 0, 1);
      return;
    case 4: 
      localarie.p(acfp.m(2131716166), i, 0, 1);
      return;
    case 5: 
      localarie.p(acfp.m(2131716161), i, 0, 1);
      return;
    }
    localarie.V(2131721389, i, 0, 1);
  }
  
  public static boolean t(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramQQAppInterface.getApplication().getSharedPreferences("sp_troop_info_edit_red_show_" + paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0).getBoolean("red_tag_" + paramInt, true);
      }
    }
    return bool1;
  }
  
  public static void wM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!hu(paramString));
      aqfe.J(BaseApplicationImpl.getApplication(), paramString, paramString);
    } while (!QLog.isColorLevel());
    QLog.i("TroopUtils", 2, String.format("setRedPointSP [%s, %s]", new Object[] { paramString, paramString }));
  }
  
  public static Object wrap(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = JSONObject.NULL;
    }
    for (;;)
    {
      return localObject;
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!(paramObject instanceof JSONObject))
        {
          localObject = paramObject;
          if (!paramObject.equals(JSONObject.NULL)) {
            try
            {
              if ((paramObject instanceof Collection)) {
                return new JSONArray((Collection)paramObject);
              }
              if (paramObject.getClass().isArray()) {
                return a(paramObject);
              }
              if ((paramObject instanceof Map)) {
                return new JSONObject((Map)paramObject);
              }
              localObject = paramObject;
              if (!(paramObject instanceof Boolean))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Byte))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Character))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Double))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Float))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Integer))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Long))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof Short))
                            {
                              localObject = paramObject;
                              if (!(paramObject instanceof String)) {
                                if (paramObject.getClass().getPackage().getName().startsWith("java."))
                                {
                                  paramObject = paramObject.toString();
                                  return paramObject;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramObject) {}
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuh
 * JD-Core Version:    0.7.0.1
 */