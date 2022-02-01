package cooperation.qwallet.plugin.ipc;

import acdu;
import acfd;
import acff;
import akuv.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import aqdf;
import aqgv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jnl;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CorpReq
  extends BaseReq
{
  public static final int CORPREQ_TYPE_AVATAR = 12;
  public static final int CORPREQ_TYPE_DELETEOB = 6;
  public static final int CORPREQ_TYPE_FACEFILEPATH = 1;
  public static final int CORPREQ_TYPE_GET_ENCRYPTION = 8;
  public static final int CORPREQ_TYPE_INVOKE_FORWARD = 9;
  public static final int CORPREQ_TYPE_INVOKE_SENDHB = 13;
  public static final int CORPREQ_TYPE_ISFRIEND = 2;
  public static final int CORPREQ_TYPE_OPEN_AIO = 10;
  public static final int CORPREQ_TYPE_PUT_ENCRYPTION = 7;
  public static final int CORPREQ_TYPE_TENWATCH = 4;
  public static final int CORPREQ_TYPE_TROOP_MEM_NICK = 5;
  public static final int CORPREQ_TYPE_TROOP_NICKNAME = 11;
  public static final int CORPREQ_TYPE_USERNICK = 3;
  static final String TAG = "CorpReq";
  public static int corpReqType;
  public static Bundle encryptionData;
  public int channel;
  public Bundle data;
  public int faceType;
  public String groupId;
  public String memUin;
  public ArrayList<String> memUinArrayList;
  public int subType;
  public String troopUin;
  public String uin;
  
  private void onTroopMemNick()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    localCorpResp.troopUin = this.troopUin;
    if (TextUtils.isEmpty(this.troopUin)) {
      QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:TextUtils.isEmpty(troopUin), troopUin" + this.troopUin);
    }
    for (;;)
    {
      return;
      Object localObject1 = QWalletHelper.getAppInterface();
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (!TextUtils.isEmpty(this.memUin))
      {
        localObject2 = aqgv.r((QQAppInterface)localObject1, this.troopUin, this.memUin);
        if (aqgv.bS((String)localObject2, this.memUin))
        {
          localCorpResp.memUin = this.memUin;
          localCorpResp.memNick = ((String)localObject2);
          label134:
          if ((i != 0) && ((short)localArrayList.size() > 500)) {
            continue;
          }
        }
      }
      try
      {
        long l = Long.parseLong(this.troopUin);
        localObject2 = new oidb_0x787.ReqBody();
        ((oidb_0x787.ReqBody)localObject2).uint64_group_code.set(l);
        ((oidb_0x787.ReqBody)localObject2).uint64_begin_uin.set(0L);
        ((oidb_0x787.ReqBody)localObject2).uint64_data_time.set(0L);
        Object localObject3 = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            try
            {
              l = Long.parseLong(str);
              ((oidb_0x787.ReqBody)localObject2).rpt_uin_list.add(Long.valueOf(l));
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "getTroopCardDefaultNickBatch parseLong err uin=" + str, localException2);
              continue;
              i = 1;
              localArrayList.add(this.memUin);
              break label134;
              if ((this.memUinArrayList == null) || (this.memUinArrayList.isEmpty()))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:TextUtils.isEmpty(troopUin) || memUinArrayList == null || memUinArrayList.isEmpty(), troopUin" + this.troopUin);
                return;
              }
              int k = this.memUinArrayList.size();
              localObject2 = new JSONArray();
              int j = 0;
              i = 0;
              if (j < k)
              {
                localObject3 = (String)this.memUinArrayList.get(j);
                str = aqgv.r((QQAppInterface)localObject1, this.troopUin, (String)localObject3);
                JSONObject localJSONObject;
                if (aqgv.bS(str, (String)localObject3)) {
                  localJSONObject = new JSONObject();
                }
                for (;;)
                {
                  try
                  {
                    localJSONObject.put("memUin", localObject3);
                    localJSONObject.put("memNick", str);
                    ((JSONArray)localObject2).put(localJSONObject);
                    j += 1;
                  }
                  catch (JSONException localJSONException)
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:JSONException， memUinTemp：" + (String)localObject3);
                    continue;
                  }
                  localArrayList.add(localObject3);
                  i = 1;
                }
              }
              localCorpResp.troopMemNickJson = ((JSONArray)localObject2).toString();
              break label134;
            }
          }
        }
        localObject3 = new oidb_0x787.Filter();
        ((oidb_0x787.Filter)localObject3).uint32_member_level_info_uin.set(1);
        ((oidb_0x787.Filter)localObject3).uint32_member_level_info_name.set(1);
        ((oidb_0x787.Filter)localObject3).uint32_nick_name.set(1);
        ((oidb_0x787.ReqBody)localObject2).opt_filter.set((MessageMicro)localObject3);
        localObject3 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1927);
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject2).toByteArray()));
        if ((localObject1 != null) && (((QQAppInterface)localObject1).getApp() != null))
        {
          localObject2 = new NewIntent(((QQAppInterface)localObject1).getApp(), jnl.class);
          ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x787_1");
          ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
          ((NewIntent)localObject2).setObserver(new CorpReq.2(this, localCorpResp, (QQAppInterface)localObject1, localArrayList));
          ((QQAppInterface)localObject1).startServlet((NewIntent)localObject2);
          return;
        }
      }
      catch (Exception localException1) {}
    }
    localObject1 = new Bundle();
    localCorpResp.toBundle((Bundle)localObject1);
    doCallback((Bundle)localObject1);
    return;
  }
  
  public void callForwardPage()
  {
    int i = 0;
    if (this.data == null) {
      return;
    }
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    localCorpResp.encryptionData = encryptionData;
    if (this.fromReceiver == null) {
      localCorpResp.callForwardRet = -1;
    }
    for (;;)
    {
      Object localObject1 = new Bundle();
      localCorpResp.toBundle((Bundle)localObject1);
      doCallback((Bundle)localObject1);
      return;
      localObject1 = "";
      if (this.data != null)
      {
        i = this.data.getInt("forward_type", 0);
        localObject1 = this.data.getString("forward_title");
      }
      Object localObject3 = BaseActivity.sTopActivity;
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = BaseApplicationImpl.sApplication;
      }
      if (localObject2 != null) {
        try
        {
          localObject3 = new Intent((Context)localObject2, ForwardRecentActivity.class);
          ((Intent)localObject3).putExtra("forward_text", (String)localObject1);
          ((Intent)localObject3).putExtra("forward_type", i);
          ((Intent)localObject3).putExtra("choose_friend_callback", this.fromReceiver);
          ((Intent)localObject3).addFlags(268435456);
          ((Context)localObject2).startActivity((Intent)localObject3);
          localCorpResp.callForwardRet = 0;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  public void callSendHbPage()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 337	cooperation/qwallet/plugin/ipc/CorpReq:data	Landroid/os/Bundle;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 68	cooperation/qwallet/plugin/ipc/CorpResp
    //   11: dup
    //   12: invokespecial 69	cooperation/qwallet/plugin/ipc/CorpResp:<init>	()V
    //   15: astore 4
    //   17: aload 4
    //   19: getstatic 71	cooperation/qwallet/plugin/ipc/CorpReq:corpReqType	I
    //   22: putfield 72	cooperation/qwallet/plugin/ipc/CorpResp:corpReqType	I
    //   25: aload 4
    //   27: getstatic 339	cooperation/qwallet/plugin/ipc/CorpReq:encryptionData	Landroid/os/Bundle;
    //   30: putfield 340	cooperation/qwallet/plugin/ipc/CorpResp:encryptionData	Landroid/os/Bundle;
    //   33: aload_0
    //   34: getfield 344	cooperation/qwallet/plugin/ipc/CorpReq:fromReceiver	Landroid/os/ResultReceiver;
    //   37: ifnonnull +30 -> 67
    //   40: aload 4
    //   42: iconst_m1
    //   43: putfield 347	cooperation/qwallet/plugin/ipc/CorpResp:callForwardRet	I
    //   46: new 325	android/os/Bundle
    //   49: dup
    //   50: invokespecial 326	android/os/Bundle:<init>	()V
    //   53: astore_1
    //   54: aload 4
    //   56: aload_1
    //   57: invokevirtual 330	cooperation/qwallet/plugin/ipc/CorpResp:toBundle	(Landroid/os/Bundle;)V
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 334	cooperation/qwallet/plugin/ipc/CorpReq:doCallback	(Landroid/os/Bundle;)Z
    //   65: pop
    //   66: return
    //   67: getstatic 367	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnonnull +166 -> 238
    //   75: getstatic 373	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull -34 -> 46
    //   83: ldc_w 349
    //   86: astore_3
    //   87: ldc_w 349
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 337	cooperation/qwallet/plugin/ipc/CorpReq:data	Landroid/os/Bundle;
    //   95: ifnull +25 -> 120
    //   98: aload_0
    //   99: getfield 337	cooperation/qwallet/plugin/ipc/CorpReq:data	Landroid/os/Bundle;
    //   102: ldc_w 405
    //   105: invokevirtual 361	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: aload_0
    //   110: getfield 337	cooperation/qwallet/plugin/ipc/CorpReq:data	Landroid/os/Bundle;
    //   113: ldc_w 407
    //   116: invokevirtual 361	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: new 375	android/content/Intent
    //   123: dup
    //   124: aload_1
    //   125: ldc_w 409
    //   128: invokespecial 378	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   131: astore 5
    //   133: new 212	org/json/JSONObject
    //   136: dup
    //   137: invokespecial 213	org/json/JSONObject:<init>	()V
    //   140: astore 6
    //   142: aload 6
    //   144: ldc_w 405
    //   147: aload_3
    //   148: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc_w 407
    //   157: aload_2
    //   158: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 5
    //   164: ldc_w 411
    //   167: aload 6
    //   169: invokevirtual 412	org/json/JSONObject:toString	()Ljava/lang/String;
    //   172: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   175: pop
    //   176: aload 5
    //   178: ldc_w 414
    //   181: iconst_2
    //   182: invokevirtual 384	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   185: pop
    //   186: aload 5
    //   188: ldc_w 416
    //   191: ldc_w 418
    //   194: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   197: pop
    //   198: aload 5
    //   200: ldc_w 419
    //   203: invokevirtual 394	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   206: pop
    //   207: aload_1
    //   208: aload 5
    //   210: invokevirtual 400	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   213: aload 4
    //   215: iconst_0
    //   216: putfield 347	cooperation/qwallet/plugin/ipc/CorpResp:callForwardRet	I
    //   219: goto -173 -> 46
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 403	java/lang/Exception:printStackTrace	()V
    //   227: goto -181 -> 46
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 403	java/lang/Exception:printStackTrace	()V
    //   235: goto -73 -> 162
    //   238: goto -159 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	CorpReq
    //   53	155	1	localObject	Object
    //   222	2	1	localException1	Exception
    //   90	68	2	str1	String
    //   230	2	2	localException2	Exception
    //   86	62	3	str2	String
    //   15	199	4	localCorpResp	CorpResp
    //   131	78	5	localIntent	Intent
    //   140	28	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   91	120	222	java/lang/Exception
    //   120	142	222	java/lang/Exception
    //   162	219	222	java/lang/Exception
    //   231	235	222	java/lang/Exception
    //   142	162	230	java/lang/Exception
  }
  
  public void deleteUserNickOB()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
    TenpayFriendListObserver localTenpayFriendListObserver = TenpayFriendListObserver.getInstance();
    if ((localQQAppInterface != null) && (localTenpayFriendListObserver != null))
    {
      localQQAppInterface.removeObserver(localTenpayFriendListObserver);
      localTenpayFriendListObserver.destroy();
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    corpReqType = paramBundle.getInt("_qwallet_ipc_CorpReq_corpReqType");
    this.faceType = paramBundle.getInt("_qwallet_ipc_CorpReq_faceType");
    this.uin = paramBundle.getString("_qwallet_ipc_CorpReq_uin");
    this.subType = paramBundle.getInt("_qwallet_ipc_CorpReq_subType");
    this.groupId = paramBundle.getString("_qwallet_ipc_CorpReq_groupId");
    this.channel = paramBundle.getInt("_qwallet_ipc_CorpReq_channel");
    this.troopUin = paramBundle.getString("_qwallet_ipc_CorpReq_troopUin");
    this.memUin = paramBundle.getString("_qwallet_ipc_CorpReq_memUin");
    this.memUinArrayList = paramBundle.getStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList");
    this.data = paramBundle.getBundle("_qwallet_ipc_CorpReq_data");
    if (corpReqType == 7) {
      encryptionData = paramBundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
    }
  }
  
  public void getAvatar()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    String str;
    int i;
    Object localObject1;
    if (this.data != null)
    {
      QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
      str = this.data.getString("req_uin");
      i = this.data.getInt("req_type", 1);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = BaseActivity.sTopActivity;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = BaseApplicationImpl.sApplication;
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(str)) && (localQQAppInterface != null))
        {
          localObject1 = new aqdf((Context)localObject1, localQQAppInterface);
          ((aqdf)localObject1).a(new CorpReq.3(this, localQQAppInterface, str, localCorpResp));
          if (((aqdf)localObject1).b(i, str) == null) {
            break label170;
          }
          localObject1 = localQQAppInterface.getCustomFaceFilePath(i, str, 0);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("avatar_path", (String)localObject1);
          localCorpResp.toBundle((Bundle)localObject2);
          doCallback((Bundle)localObject2);
        }
      }
    }
    return;
    label170:
    ((aqdf)localObject1).i(str, i, false);
  }
  
  public void getGroupNickname()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    Bundle localBundle = new Bundle();
    String str;
    int i;
    QQAppInterface localQQAppInterface;
    if (this.data != null)
    {
      str = this.data.getString("req_uin");
      i = this.data.getInt("req_type", 1);
      if (TextUtils.isEmpty(str))
      {
        localCorpResp.userNick = "";
        localCorpResp.toBundle(localBundle);
        doCallback(localBundle);
        return;
      }
      localQQAppInterface = QWalletHelper.getAppInterface();
      if ((localQQAppInterface != null) && (i != 0)) {
        break label128;
      }
    }
    try
    {
      localCorpResp.userNick = new TroopManager(localQQAppInterface).c(str).troopname;
      for (;;)
      {
        localCorpResp.toBundle(localBundle);
        doCallback(localBundle);
        return;
        label128:
        if (i == 1) {
          localCorpResp.userNick = new acdu(localQQAppInterface).a(str).discussionName;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localCorpResp.userNick = "";
        localException.printStackTrace();
      }
    }
  }
  
  public void onGetEncryption()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    localCorpResp.encryptionData = encryptionData;
    Bundle localBundle = new Bundle();
    localCorpResp.toBundle(localBundle);
    doCallback(localBundle);
  }
  
  public void onGetFaceFilePath()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    Object localObject = QWalletHelper.getAppInterface();
    if (localObject != null)
    {
      localCorpResp.faceFilePath = ((QQAppInterface)localObject).getCustomFaceFilePath(this.faceType, this.uin, this.subType);
      localCorpResp.memUin = this.uin;
    }
    localObject = new Bundle();
    localCorpResp.toBundle((Bundle)localObject);
    doCallback((Bundle)localObject);
  }
  
  public void onIsFriend()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    Object localObject = QWalletHelper.getAppInterface();
    if (localObject != null) {
      if (!((QQAppInterface)localObject).getCurrentAccountUin().equals(this.uin)) {
        break label62;
      }
    }
    label62:
    for (localCorpResp.isFriend = false;; localCorpResp.isFriend = ((acff)((QQAppInterface)localObject).getManager(51)).isFriend(this.uin))
    {
      localObject = new Bundle();
      localCorpResp.toBundle((Bundle)localObject);
      doCallback((Bundle)localObject);
      return;
    }
  }
  
  public void onReceive()
  {
    if (corpReqType == 4)
    {
      onTenWatch();
      return;
    }
    if (corpReqType == 8)
    {
      onGetEncryption();
      return;
    }
    if (corpReqType == 8)
    {
      onGetEncryption();
      return;
    }
    if (corpReqType == 9)
    {
      callForwardPage();
      return;
    }
    if (corpReqType == 10)
    {
      openAio();
      return;
    }
    if (corpReqType == 11)
    {
      getGroupNickname();
      return;
    }
    if (corpReqType == 12)
    {
      getAvatar();
      return;
    }
    if (corpReqType == 13)
    {
      callSendHbPage();
      return;
    }
    ThreadManager.getFileThreadHandler().post(new CorpReq.1(this));
  }
  
  public void onTenWatch()
  {
    if (this.data == null) {
      return;
    }
    akuv.b localb = new akuv.b(this.data.getInt("businessType"), 0, this.data.getString("retData"));
    OpenApiManager.getInstance().onPayMsgRsp(localb);
  }
  
  public void onUserNcik()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    if (TextUtils.isEmpty(this.uin))
    {
      localCorpResp.userNick = this.uin;
      return;
    }
    Object localObject2 = QWalletHelper.getAppInterface();
    Object localObject3;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject3 = (acff)((QQAppInterface)localObject2).getManager(51);
      if (((this.channel == 5) || ((this.channel & 0x10) != 0)) && ((!((acff)localObject3).isFriend(this.uin)) || (((QQAppInterface)localObject2).getCurrentAccountUin().equals(this.uin)))) {
        break label357;
      }
      if (TextUtils.isEmpty(this.groupId)) {
        break label320;
      }
      localObject1 = (TroopManager)((QQAppInterface)localObject2).getManager(52);
      localObject3 = ((acff)localObject3).e(this.uin);
      localObject1 = ((TroopManager)localObject1).b(this.groupId, this.uin);
      if ((localObject3 == null) || (TextUtils.isEmpty(((Friends)localObject3).remark))) {
        break label224;
      }
      localObject1 = ((Friends)localObject3).remark;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((QQAppInterface)localObject2).addObserver(TenpayFriendListObserver.getInstance());
        TenpayFriendListObserver.getInstance().add(this.uin, this.fromReceiver);
        localCorpResp.userNick = aqgv.b((QQAppInterface)localObject2, this.uin, true);
      }
      for (;;)
      {
        localObject1 = new Bundle();
        localCorpResp.toBundle((Bundle)localObject1);
        doCallback((Bundle)localObject1);
        return;
        label224:
        if ((localObject1 != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)))
        {
          localObject1 = ((TroopMemberInfo)localObject1).troopnick;
          break;
        }
        if (localObject3 != null)
        {
          localObject1 = ((Friends)localObject3).name;
          break;
        }
        if (localObject1 == null) {
          break label388;
        }
        if (this.uin.equals(((QQAppInterface)localObject2).getCurrentAccountUin()))
        {
          localObject1 = ((TroopMemberInfo)localObject1).friendnick;
          break;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark))
        {
          localObject1 = ((TroopMemberInfo)localObject1).autoremark;
          break;
        }
        localObject1 = ((TroopMemberInfo)localObject1).friendnick;
        break;
        localCorpResp.userNick = ((String)localObject1);
        continue;
        label320:
        ((QQAppInterface)localObject2).addObserver(TenpayFriendListObserver.getInstance());
        TenpayFriendListObserver.getInstance().add(this.uin, this.fromReceiver);
        localCorpResp.userNick = aqgv.b((QQAppInterface)localObject2, this.uin, true);
        continue;
        label357:
        localObject2 = aqgv.G((QQAppInterface)localObject2, this.uin);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.uin;
        }
        localCorpResp.userNick = ((String)localObject1);
      }
      label388:
      localObject1 = null;
    }
  }
  
  public void openAio()
  {
    if (this.data == null) {
      return;
    }
    String str3 = this.data.getString("send_uin");
    int i = this.data.getInt("send_type", 0);
    String str1 = "c2c";
    if (i == 1) {
      str1 = "discuss";
    }
    for (;;)
    {
      Object localObject2 = BaseActivity.sTopActivity;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BaseApplicationImpl.sApplication;
      }
      if ((localObject1 == null) || (TextUtils.isEmpty(str3))) {
        break;
      }
      try
      {
        localObject2 = new Intent((Context)localObject1, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse("mqqapi://im/chat?src_type=web&uin=" + str3 + "&attach_content=&version=1&chat_type=" + str1));
        ((Intent)localObject2).addFlags(268435456);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (i == 2) {
        String str2 = "group";
      }
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpReq_corpReqType", corpReqType);
    paramBundle.putInt("_qwallet_ipc_CorpReq_faceType", this.faceType);
    paramBundle.putString("_qwallet_ipc_CorpReq_uin", this.uin);
    paramBundle.putInt("_qwallet_ipc_CorpReq_subType", this.subType);
    paramBundle.putString("_qwallet_ipc_CorpReq_groupId", this.groupId);
    paramBundle.putInt("_qwallet_ipc_CorpReq_channel", this.channel);
    paramBundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
    paramBundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
    paramBundle.putStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList", this.memUinArrayList);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_data", this.data);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", encryptionData);
  }
  
  static class TenpayFriendListObserver
    extends acfd
  {
    private static TenpayFriendListObserver _self;
    private HashMap<String, ResultReceiver> mRecieverMap = new HashMap();
    
    public static TenpayFriendListObserver getInstance()
    {
      if (_self == null) {
        _self = new TenpayFriendListObserver();
      }
      return _self;
    }
    
    public void add(String paramString, ResultReceiver paramResultReceiver)
    {
      this.mRecieverMap.put(paramString, paramResultReceiver);
    }
    
    void destroy()
    {
      _self = null;
      this.mRecieverMap.clear();
    }
    
    public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
    {
      Object localObject = QWalletHelper.getAppInterface();
      if ((!paramBoolean) || (paramString == null) || (localObject == null)) {}
      do
      {
        return;
        CorpResp localCorpResp = new CorpResp();
        localCorpResp.corpReqType = CorpReq.corpReqType;
        localCorpResp.userNick = aqgv.c((QQAppInterface)localObject, paramString, false);
        localObject = new Bundle();
        localCorpResp.toBundle((Bundle)localObject);
        paramString = (ResultReceiver)this.mRecieverMap.remove(paramString);
      } while ((localObject == null) || (paramString == null));
      paramString.send(0, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq
 * JD-Core Version:    0.7.0.1
 */