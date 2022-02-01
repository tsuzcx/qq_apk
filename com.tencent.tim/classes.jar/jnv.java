import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager.3;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager.4;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceExtendConfig;
import tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceWordCornerRedDot;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class jnv
  implements Manager
{
  public static final String TC = String.valueOf(System.currentTimeMillis());
  final String TA = "TroopRedTouchManager2_";
  public final String TAG = jnv.class.getSimpleName();
  final String TB = "TroopRedTouchManager2_All";
  oidb_0x791.GetRedDotRes a;
  public int aCp;
  boolean aaP = false;
  private BroadcastReceiver ad = new jnw(this);
  Map<Long, oidb_0x791.RedDotInfo> dn = null;
  public QQAppInterface mAppInterface;
  
  public jnv(QQAppInterface paramQQAppInterface)
  {
    this(paramQQAppInterface, null);
  }
  
  public jnv(QQAppInterface paramQQAppInterface, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.mAppInterface = paramQQAppInterface;
    if (paramGetRedDotRes != null) {
      this.a = paramGetRedDotRes;
    }
    ayA();
  }
  
  private void C(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "saveLocalFileList, size =" + paramMap.size());
        }
        ThreadManager.post(new TroopRedTouchManager.4(this, f(paramMap)), 5, null, false);
      }
      finally {}
    }
  }
  
  public static String a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("redDotInfo2String, oidb_0x791.RedDotInfo:");
    localStringBuilder.append("uint32_appid:").append(paramRedDotInfo.uint32_appid.get()).append("|redDotInfo.bool_display_reddot:").append(paramRedDotInfo.bool_display_reddot.get()).append("|uint32_number:").append(paramRedDotInfo.uint32_number.get()).append("|uint32_reason:").append(paramRedDotInfo.uint32_reason.get()).append("|uint32_last_time:").append(paramRedDotInfo.uint32_last_time.get()).append("|uint64_cmd_uin:").append(paramRedDotInfo.uint64_cmd_uin.get()).append("|uint32_cmd_uin_type:").append(paramRedDotInfo.uint32_cmd_uin_type.get()).append("|str_face_url:").append(paramRedDotInfo.str_face_url.get().toStringUtf8()).append("|str_custom_buffer:").append(paramRedDotInfo.str_custom_buffer.get().toStringUtf8()).append("|uint32_expire_time:").append(paramRedDotInfo.uint32_expire_time.get());
    return localStringBuilder.toString();
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 236	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 77	jnv:mAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   13: invokevirtual 248	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   16: new 92	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   23: ldc 50
    //   25: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 77	jnv:mAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: invokevirtual 251	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   35: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 254	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: invokestatic 260	aqhq:fileToBytes	(Ljava/io/File;)[B
    //   47: astore_3
    //   48: new 262	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   51: dup
    //   52: invokespecial 263	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull +11 -> 70
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 267	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   81: aload_1
    //   82: astore_2
    //   83: goto -13 -> 70
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 271	java/lang/NullPointerException:printStackTrace	()V
    //   98: aload_1
    //   99: astore_2
    //   100: goto -30 -> 70
    //   103: astore_2
    //   104: goto -10 -> 94
    //   107: astore_2
    //   108: goto -31 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	jnv
    //   55	27	1	localGetRedDotRes1	oidb_0x791.GetRedDotRes
    //   86	4	1	localObject1	Object
    //   93	6	1	localObject2	Object
    //   57	16	2	localGetRedDotRes2	oidb_0x791.GetRedDotRes
    //   74	4	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   82	1	2	localGetRedDotRes3	oidb_0x791.GetRedDotRes
    //   91	4	2	localNullPointerException1	java.lang.NullPointerException
    //   99	1	2	localObject3	Object
    //   103	1	2	localNullPointerException2	java.lang.NullPointerException
    //   107	1	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   47	17	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	56	74	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2	56	86	finally
    //   62	68	86	finally
    //   77	81	86	finally
    //   94	98	86	finally
    //   2	56	91	java/lang/NullPointerException
    //   62	68	103	java/lang/NullPointerException
    //   62	68	107	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {}
    for (;;)
    {
      return;
      try
      {
        ThreadManager.post(new TroopRedTouchManager.3(this, paramGetRedDotRes), 5, null, false);
      }
      finally {}
    }
  }
  
  private void ayA()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
    this.mAppInterface.getApp().registerReceiver(this.ad, localIntentFilter);
  }
  
  private void ayB()
  {
    this.mAppInterface.getApp().unregisterReceiver(this.ad);
  }
  
  private void b(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo.str_custom_buffer.has()) {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    }
    try
    {
      paramRedDotInfo = new JSONObject(paramRedDotInfo);
      if (paramRedDotInfo.optInt("is_web_care") == 1)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.mobileqq.NearbyJsInterface");
        localIntent.putExtra("command_type", 2);
        localIntent.putExtra("data", paramRedDotInfo.optString("web_red_dot_data"));
        this.mAppInterface.getApp().sendBroadcast(localIntent);
      }
      return;
    }
    catch (Exception paramRedDotInfo)
    {
      QLog.e("nearby.redpoint", 1, "get push for web: " + paramRedDotInfo.getMessage());
    }
  }
  
  private void c(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.msg_nearby_entrance_extend_config.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.has()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.bool_has_hintWord.get()) && (paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.has())) {
      ajrb.c(this.mAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_assist_text", paramRedDotInfo.msg_nearby_entrance_extend_config.str_hintWord.get().toStringUtf8());
    }
    if ((paramRedDotInfo.msg_word_corner_red_dot.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_enable.get()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.has()) && (paramRedDotInfo.msg_word_corner_red_dot.bool_switch_to_word_corner.get()) && (paramRedDotInfo.msg_word_corner_red_dot.str_hintText.has())) {
      ajrb.c(this.mAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_corner_text", paramRedDotInfo.msg_word_corner_red_dot.str_hintText.get().toStringUtf8());
    }
  }
  
  private void d(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.uint32_appid.get() == 60) && (paramRedDotInfo.str_custom_buffer.has())) {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    }
    try
    {
      paramRedDotInfo = new JSONObject(paramRedDotInfo);
      if (paramRedDotInfo.optInt("is_c2c") == 1) {
        ajrb.c(this.mAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_say_hello_msg_type", Integer.valueOf(paramRedDotInfo.optInt("say_hello_red_dot_type")));
      }
      return;
    }
    catch (Exception paramRedDotInfo)
    {
      QLog.e("nearby.redpoint", 1, "get msgBoxSayHelloType error: " + paramRedDotInfo.getMessage());
    }
  }
  
  private void e(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if ((paramRedDotInfo.uint32_appid.get() == 60) && (paramRedDotInfo.str_custom_buffer.has())) {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    }
    try
    {
      paramRedDotInfo = new JSONObject(paramRedDotInfo);
      if (paramRedDotInfo.optInt("is_comment") == 1) {
        ajrb.c(this.mAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", Integer.valueOf(paramRedDotInfo.optInt("comment_red_dot_type")));
      }
      return;
    }
    catch (Exception paramRedDotInfo)
    {
      QLog.e("nearby.redpoint", 1, "get msgBoxCommentZan error: " + paramRedDotInfo.getMessage());
    }
  }
  
  private String f(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong != null) && (paramMap.get(localLong) != null))
        {
          byte[] arrayOfByte = ((oidb_0x791.RedDotInfo)paramMap.get(localLong)).toByteArray();
          localJSONObject.put(String.valueOf(localLong), aqgo.encodeToString(arrayOfByte, 0));
        }
      }
      paramMap = localJSONObject.toString();
    }
    catch (JSONException paramMap)
    {
      PlayerUtils.log(6, this.TAG, "convertHashMapToJSONString: JSONException when convert HashMap data - " + paramMap.getMessage());
      return "";
    }
    return paramMap;
  }
  
  private String hA()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.a.rpt_msg_reddot_info.size())
    {
      Object localObject = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
      if (((oidb_0x791.RedDotInfo)localObject).str_custom_buffer.has()) {}
      try
      {
        localObject = new JSONObject(((oidb_0x791.RedDotInfo)localObject).str_custom_buffer.get().toStringUtf8());
        if (((JSONObject)localObject).optInt("is_web_care") == 1) {
          localJSONArray.put(((JSONObject)localObject).optString("web_red_dot_data"));
        }
        i += 1;
      }
      catch (Exception localException)
      {
        QLog.e("nearby.redpoint", 1, "get webCareRedDotInfo error: " + localException.getMessage());
        return "";
      }
    }
    return localException.toString();
  }
  
  /* Error */
  private Map<Long, oidb_0x791.RedDotInfo> w()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 495	java/util/HashMap
    //   5: dup
    //   6: invokespecial 496	java/util/HashMap:<init>	()V
    //   9: astore_1
    //   10: new 309	org/json/JSONObject
    //   13: dup
    //   14: new 34	java/lang/String
    //   17: dup
    //   18: new 236	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: getfield 77	jnv:mAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 248	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   32: new 92	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   39: ldc 54
    //   41: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 77	jnv:mAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   48: invokevirtual 251	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   51: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 254	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: invokestatic 260	aqhq:fileToBytes	(Ljava/io/File;)[B
    //   63: iconst_0
    //   64: invokestatic 500	aqgo:decode	([BI)[B
    //   67: invokespecial 503	java/lang/String:<init>	([B)V
    //   70: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 506	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   78: astore_3
    //   79: aload_3
    //   80: invokeinterface 435 1 0
    //   85: ifeq +72 -> 157
    //   88: aload_3
    //   89: invokeinterface 439 1 0
    //   94: checkcast 34	java/lang/String
    //   97: astore 4
    //   99: new 148	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   102: dup
    //   103: invokespecial 507	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:<init>	()V
    //   106: astore 5
    //   108: aload 5
    //   110: aload_2
    //   111: aload 4
    //   113: invokevirtual 510	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   116: checkcast 34	java/lang/String
    //   119: iconst_0
    //   120: invokestatic 513	aqgo:decode	(Ljava/lang/String;I)[B
    //   123: invokevirtual 514	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload 5
    //   129: ifnull -50 -> 79
    //   132: aload_1
    //   133: aload 4
    //   135: invokestatic 518	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   138: invokestatic 521	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aload 5
    //   143: invokeinterface 524 3 0
    //   148: pop
    //   149: goto -70 -> 79
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 525	java/lang/Exception:printStackTrace	()V
    //   157: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +36 -> 196
    //   163: aload_0
    //   164: getfield 64	jnv:TAG	Ljava/lang/String;
    //   167: iconst_2
    //   168: new 92	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 527
    //   178: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokeinterface 105 1 0
    //   187: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: areturn
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	jnv
    //   9	190	1	localHashMap	java.util.HashMap
    //   200	4	1	localObject	Object
    //   73	38	2	localJSONObject	JSONObject
    //   152	2	2	localException	Exception
    //   78	11	3	localIterator	Iterator
    //   97	37	4	str	String
    //   106	36	5	localRedDotInfo	oidb_0x791.RedDotInfo
    // Exception table:
    //   from	to	target	type
    //   10	79	152	java/lang/Exception
    //   79	127	152	java/lang/Exception
    //   132	149	152	java/lang/Exception
    //   2	10	200	finally
    //   10	79	200	finally
    //   79	127	200	finally
    //   132	149	200	finally
    //   153	157	200	finally
    //   157	196	200	finally
  }
  
  public void B(Map<Long, oidb_0x791.RedDotInfo> paramMap)
  {
    for (;;)
    {
      try
      {
        if (this.dn == null) {
          this.dn = w();
        }
        Object localObject = this.dn;
        if ((localObject == null) || (paramMap == null)) {
          return;
        }
        paramMap = paramMap.entrySet().iterator();
        if (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          this.dn.put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
        }
        else
        {
          C(this.dn);
        }
      }
      finally {}
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int m = 0;
    if (this.a == null) {
      this.a = a();
    }
    if ((this.a == null) || (paramQQAppInterface == null)) {
      return 0;
    }
    boolean bool3 = ajpm.j(paramQQAppInterface);
    boolean bool4 = ye();
    boolean bool1;
    boolean bool2;
    label66:
    int k;
    if (!paramQQAppInterface.bJe)
    {
      bool1 = true;
      if ((!bool1) || (!bool4)) {
        break label158;
      }
      bool2 = true;
      paramQQAppInterface = a(bool2);
      if (paramQQAppInterface.bHY == -1) {
        break label338;
      }
      k = paramQQAppInterface.dmX;
      bool2 = true;
    }
    for (;;)
    {
      paramQQAppInterface = new StringBuilder();
      int i = 0;
      label100:
      if (m < this.a.rpt_msg_reddot_info.size())
      {
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(m);
        if (!localRedDotInfo.bool_display_reddot.get()) {}
        for (;;)
        {
          m += 1;
          break label100;
          bool1 = false;
          break;
          bool2 = false;
          break label66;
          int n = localRedDotInfo.uint32_appid.get();
          int j;
          if ((2 != n) && (3 != n) && (4 != n) && (5 != n))
          {
            j = i;
            if (jno.a(localRedDotInfo))
            {
              j = i;
              if (!yf()) {}
            }
          }
          else
          {
            j = i + 1;
            paramQQAppInterface.append(n);
            paramQQAppInterface.append(",");
          }
          i = j;
        }
      }
      label158:
      QLog.d("nearby.redpoint", 1, "getLebaRedPoint, needShow=" + bool4 + ", isNewTab=" + bool3 + ", redType=" + k + ", isNearbyRedPoint=" + bool2 + ", isNearbyEntryShow=" + bool1 + ", redPointNums=" + i + ", appId=" + paramQQAppInterface.toString());
      return i;
      label338:
      bool2 = false;
      k = 0;
    }
  }
  
  public akjt a(boolean paramBoolean)
  {
    try
    {
      akjt localakjt = a(paramBoolean, true);
      return localakjt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public akjt a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject1;
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1;
      akjt localakjt;
      int k;
      Object localObject2;
      Object localObject3;
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4;
      int m;
      try
      {
        QQAppInterface localQQAppInterface = this.mAppInterface;
        localObject1 = (jnv)localQQAppInterface.getManager(70);
        localRedTypeInfo1 = ((jnv)localObject1).a();
        localakjt = new akjt();
        if (!paramBoolean1) {
          break label939;
        }
        k = 1;
        if (!ajpm.j(localQQAppInterface)) {
          break label881;
        }
        localObject2 = (String)ajrb.c(localQQAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_corner_text", "");
        localObject3 = (String)ajrb.c(localQQAppInterface.getCurrentAccountUin(), "key_nearby_red_dot_assist_text", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localakjt.RX(11);
          localakjt.bTF = ((String)localObject2);
          localakjt.bTG = ((String)localObject3);
          return localakjt;
        }
        localObject2 = ((jnv)localObject1).b();
        localObject3 = ((jnv)localObject1).i();
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = ((jnv)localObject1).k();
        localRedTypeInfo3 = ((jnv)localObject1).j();
        ArrayList localArrayList1 = ((jnv)localObject1).aY();
        ArrayList localArrayList2 = ((jnv)localObject1).aX();
        d();
        ((jnv)localObject1).e();
        f();
        localRedTypeInfo4 = ((jnv)localObject1).g();
        localObject1 = ((jnv)localObject1).h();
        if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
          break label957;
        }
        localakjt.RX(5);
        localakjt.RY(localArrayList1.size());
        i = 56;
        j = i;
        if (localArrayList2 != null)
        {
          j = i;
          if (localArrayList2.size() > 0)
          {
            j = i;
            if (ajpm.k(localQQAppInterface))
            {
              localakjt.RX(5);
              localakjt.RY(localArrayList2.size());
              j = 61;
            }
          }
        }
        i = k;
        if (!ajpm.k(localQQAppInterface)) {
          break label954;
        }
        if (QLog.isColorLevel()) {
          QLog.d("nearby.redpoint", 2, "in memory nearbyMsgBoxUnReadNum=" + this.aCp);
        }
        if (paramBoolean2)
        {
          ThreadManager.post(new TroopRedTouchManager.2(this, localQQAppInterface), 8, null, false);
          m = this.aCp;
          i = k;
          if (m <= 0) {
            break label954;
          }
          localakjt.RX(5);
          localakjt.RY(m);
          QLog.d("nearby.redpoint", 1, "addRedNum:" + m + ", total=" + localakjt.bHZ + ", type=" + 60);
          i = 2;
          if (j != 0) {
            break label954;
          }
          j = 60;
          i = 2;
          k = i;
          m = j;
          if (localObject3 != null)
          {
            k = i;
            m = j;
            if (ajpm.a(localQQAppInterface, 1))
            {
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.get() != 0) {
                break label663;
              }
              localakjt.RX(0);
              break label962;
            }
          }
          if ((localRedTypeInfo2 != null) && (localRedTypeInfo2.red_type.get() == 5))
          {
            localakjt.RX(5);
            localakjt.Nw(localRedTypeInfo2.red_content.get());
            aqmj.fB(this.mAppInterface.getApp().getApplicationContext());
          }
          j = k;
          i = m;
          if (m != 0) {
            break label984;
          }
          if (this.aCp != -1) {
            break label758;
          }
          localakjt.RX(0);
          j = 2;
          i = 60;
          break label984;
          localakjt.dmW = j;
          QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, needShow, isNewTab=" + paramBoolean1 + ", redType=" + i + ", redInfo=" + localakjt);
          localakjt.dmX = i;
        }
        else
        {
          this.aCp = MsgBoxListActivity.f(localQQAppInterface, acbn.bkF, true);
          continue;
        }
        if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.get() != 5) {
          break label962;
        }
      }
      finally {}
      label663:
      localakjt.RX(5);
      localakjt.Nw(((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.get());
      int i = 2;
      QLog.d("nearby.redpoint", 1, "addRedNum:" + ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.get() + ", total=" + localakjt.bHZ + ", type=" + 38);
      label758:
      if ((localRedTypeInfo1 != null) && (ajpm.a(localAppInterface, 2)))
      {
        localakjt.RX(0);
        i = 25;
        j = k;
      }
      else if ((localObject2 != null) && (ajpm.a(localAppInterface, 3)))
      {
        i = 23;
        localakjt.RX(0);
        j = k;
      }
      else if (localRedTypeInfo3 != null)
      {
        localakjt.RX(0);
        i = 42;
        j = k;
      }
      else if (localRedTypeInfo4 != null)
      {
        localakjt.RX(0);
        i = 53;
        j = k;
      }
      else
      {
        if (localObject1 == null) {
          break label989;
        }
        localakjt.RX(0);
        i = 54;
        j = k;
        break label984;
        if (((jnv)localObject1).c() != null)
        {
          localakjt.RX(0);
          i = 24;
          paramBoolean1 = false;
          j = 1;
          continue;
        }
        if ((localRedTypeInfo1 == null) || (!ajpm.m(localAppInterface, 1001))) {
          break label998;
        }
        i = 25;
        localakjt.RX(0);
        paramBoolean1 = false;
        j = 1;
        continue;
        QLog.d("nearby.redpoint", 1, "getNearbyRedPoint, don't needShow");
        i = 0;
        continue;
        continue;
        i = 0;
        continue;
        k = i;
        m = j;
        if (j != 0) {
          continue;
        }
        m = 38;
        k = i;
        continue;
      }
      for (;;)
      {
        label881:
        paramBoolean1 = true;
        label939:
        label954:
        label957:
        label962:
        label984:
        break;
        label989:
        j = 0;
        i = m;
      }
      label998:
      paramBoolean1 = false;
      int j = 0;
      i = 0;
    }
  }
  
  public akju a()
  {
    label192:
    label197:
    label215:
    for (;;)
    {
      int i;
      try
      {
        akju localakju = new akju();
        if (this.dn == null) {
          this.dn = w();
        }
        i = this.dn.size();
        if (i <= 0) {
          return localakju;
        }
        Iterator localIterator = this.dn.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label215;
        }
        Object localObject2 = (oidb_0x791.RedDotInfo)((Map.Entry)localIterator.next()).getValue();
        String str = ((oidb_0x791.RedDotInfo)localObject2).str_custom_buffer.get().toStringUtf8();
        try
        {
          localakju.num = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();
          localObject2 = new JSONObject(str);
          if (((JSONObject)localObject2).optInt("official_topic") != 1) {
            break label192;
          }
          i = 1;
          if (i != 0) {
            localakju.dmY += 1;
          }
          i = ((JSONObject)localObject2).optInt("red_content_type");
          if (i != 1) {
            break label197;
          }
          localakju.dmZ += 1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        i = 0;
      }
      finally {}
      continue;
      if (i == 2) {
        localObject1.dna += 1;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    if (a(25) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public String a(String paramString, long paramLong, akjs paramakjs)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("faceUrl", paramString);
      localJSONObject.put("uin", paramLong);
      localJSONObject.put("isOfficialNotify", paramakjs.cst);
      localJSONObject.put("redContentType", paramakjs.content_type);
      localJSONObject.put("redContentMsg", paramakjs.bTB);
      localJSONObject.put("topicId", paramakjs.bTC);
      localJSONObject.put("msgId", paramakjs.bTD);
      localJSONObject.put("userType", paramakjs.user_type);
      return localJSONObject.toString();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public oidb_0x791.RedDotInfo a()
  {
    label287:
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      oidb_0x791.RedDotInfo localRedDotInfo2;
      int i;
      try
      {
        if (this.a == null) {
          this.a = a();
        }
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.a;
        if (localGetRedDotRes == null) {
          return null;
        }
        bool1 = ((puz)this.mAppInterface.getManager(252)).aBT;
        bool2 = this.mAppInterface.a().abu;
        Iterator localIterator = this.a.rpt_msg_reddot_info.get().iterator();
        localGetRedDotRes = null;
        if (!localIterator.hasNext()) {
          break label247;
        }
        localRedDotInfo2 = (oidb_0x791.RedDotInfo)localIterator.next();
        if (!localRedDotInfo2.bool_display_reddot.get()) {
          continue;
        }
        i = localRedDotInfo2.uint32_appid.get();
        if (!jno.cL(i)) {
          continue;
        }
        if ((i == 37) && (localRedDotInfo2.uint32_expire_time.get() < NetConnInfoCenter.getServerTime()))
        {
          ram.w(this.TAG, "%d red dot time out", new Object[] { Integer.valueOf(i) });
          continue;
        }
        if (i != 37) {}
      }
      finally {}
      if ((!bool2) && (i != 48) && ((bool1) || (i != 28)) && ((i != rpj.k(this.mAppInterface)) || (localRedDotInfo2.uint32_number.get() > 0))) {
        if (jno.a(localRedDotInfo2, localRedDotInfo1) > 0)
        {
          Object localObject = localRedDotInfo2;
          break label287;
          label247:
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.redPoint", 2, "return:" + a(localObject));
          }
        }
      }
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          this.a = a();
        }
        oidb_0x791.RedDotInfo localRedDotInfo = null;
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.a;
        if (localGetRedDotRes == null) {
          return localRedDotInfo;
        }
        int i = 0;
        if (i < this.a.rpt_msg_reddot_info.size())
        {
          localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
          if (paramInt == localRedDotInfo.uint32_appid.get())
          {
            boolean bool = localRedDotInfo.bool_display_reddot.get();
            if (bool) {}
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = a();
    }
    if (this.a == null) {
      return null;
    }
    int i = 0;
    oidb_0x791.RedDotInfo localRedDotInfo2;
    if (i < this.a.rpt_msg_reddot_info.size())
    {
      localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
      if (paramInt == localRedDotInfo2.uint32_appid.get())
      {
        localRedDotInfo1 = localRedDotInfo2;
        if (paramBoolean) {
          if (!localRedDotInfo2.bool_display_reddot.get()) {
            break label94;
          }
        }
      }
    }
    for (oidb_0x791.RedDotInfo localRedDotInfo1 = localRedDotInfo2;; localRedDotInfo1 = null)
    {
      return localRedDotInfo1;
      label94:
      i += 1;
      break;
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    Object localObject2 = null;
    int i;
    String str;
    if ((paramRedDotInfo1 != null) && (paramRedDotInfo1.uint32_last_time.has()))
    {
      i = paramRedDotInfo1.uint32_last_time.get();
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "TENCENT_DOCS_ASSISTANT  show redDot" + paramRedDotInfo2.bool_display_reddot.get());
      }
      if (!paramRedDotInfo2.bool_display_reddot.get())
      {
        str = "";
        if (paramRedDotInfo1 == null) {
          break label334;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!paramRedDotInfo1.str_custom_buffer.has()) {
          break label334;
        }
        paramRedDotInfo1 = paramRedDotInfo1.str_custom_buffer.get().toStringUtf8();
        Object localObject1 = str;
        if (!TextUtils.isEmpty(paramRedDotInfo1))
        {
          JSONObject localJSONObject = new JSONObject(paramRedDotInfo1);
          if (localJSONObject.has("lastMsg"))
          {
            paramRedDotInfo1 = localJSONObject.getString("lastMsg");
            localObject1 = paramRedDotInfo1;
            if (!localJSONObject.has("lastTime")) {
              break label322;
            }
            i = localJSONObject.getInt("lastTime");
            localObject1 = localObject2;
            if (paramRedDotInfo2.str_custom_buffer.has()) {
              localObject1 = paramRedDotInfo2.str_custom_buffer.get().toStringUtf8();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = new JSONObject((String)localObject1);
              ((JSONObject)localObject1).put("lastMsg", paramRedDotInfo1);
              ((JSONObject)localObject1).put("lastTime", i);
              paramRedDotInfo1 = ((JSONObject)localObject1).toString();
              paramRedDotInfo2.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramRedDotInfo1));
            }
          }
          else
          {
            paramRedDotInfo1 = str;
            if (!localJSONObject.has("msg")) {
              continue;
            }
            paramRedDotInfo1 = localJSONObject.getString("msg");
            continue;
          }
          localObject1 = new JSONObject();
          continue;
        }
        paramRedDotInfo1 = (oidb_0x791.RedDotInfo)localObject1;
      }
      catch (Exception paramRedDotInfo1)
      {
        QLog.e(this.TAG, 1, "parse tencentDocs redDot info error" + paramRedDotInfo1.getMessage());
        return;
      }
      label322:
      continue;
      return;
      i = 0;
      break;
      label334:
      paramRedDotInfo1 = null;
    }
  }
  
  public boolean a(List<Integer> paramList, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    int m = 0;
    for (;;)
    {
      int j;
      try
      {
        int n = paramGetRedDotRes.rpt_msg_reddot_info.size();
        j = 0;
        bool = false;
        if (j < n)
        {
          oidb_0x791.RedDotInfo localRedDotInfo1 = (oidb_0x791.RedDotInfo)paramGetRedDotRes.rpt_msg_reddot_info.get(j);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.redpoint", 2, "setAllRedDot：appId=" + localRedDotInfo1.uint32_appid.get() + ", uin=" + localRedDotInfo1.uint64_cmd_uin.get() + ", hasRed=" + localRedDotInfo1.bool_display_reddot.get());
          }
          paramList.remove(Integer.valueOf(localRedDotInfo1.uint32_appid.get()));
          if (jno.cM(localRedDotInfo1.uint32_appid.get())) {
            break label779;
          }
          k = this.a.rpt_msg_reddot_info.size();
          i = 0;
          if (i >= k) {
            break label771;
          }
          oidb_0x791.RedDotInfo localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
          if (localRedDotInfo2.uint32_appid.get() != localRedDotInfo1.uint32_appid.get()) {
            break label825;
          }
          k = localRedDotInfo1.uint32_appid.get();
          if (jno.cL(k)) {
            break label788;
          }
          if (jno.cM(k))
          {
            break label788;
            label234:
            if (localRedDotInfo2.uint64_cmd_uin.get() != localRedDotInfo1.uint64_cmd_uin.get()) {
              break label766;
            }
            if (localRedDotInfo1.uint32_last_time.get() <= localRedDotInfo2.uint32_last_time.get()) {
              break label763;
            }
            this.a.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            ls(true);
            if (!QLog.isColorLevel()) {
              break label805;
            }
            QLog.d("nearby.redpoint", 2, "APPID_NEARBY_CONCERN_UPDATE, setAllRedDot：has same uin reddot, uin=" + localRedDotInfo1.uint64_cmd_uin.get());
            break label805;
            label334:
            this.a.rpt_msg_reddot_info.add(localRedDotInfo1);
            bool = true;
            break label779;
            label352:
            if (localRedDotInfo1.uint32_last_time.get() <= localRedDotInfo2.uint32_last_time.get()) {
              break label758;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG + "Q.qqstory.redPoint", 2, "网络红点比本地红点新，netRedPoint：" + a(localRedDotInfo1) + "|localRedPoint:" + a(localRedDotInfo2));
            }
            this.a.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            if (!jno.cM(k)) {
              break label750;
            }
            ls(true);
            i = 0;
            bool = true;
            break label810;
          }
          if (k == 46)
          {
            a(localRedDotInfo2, localRedDotInfo1);
            this.a.rpt_msg_reddot_info.set(i, localRedDotInfo1);
            i = 0;
            bool = true;
            break label810;
          }
          this.a.rpt_msg_reddot_info.set(i, localRedDotInfo1);
          i = 0;
          bool = true;
          break label810;
        }
        j = this.a.rpt_msg_reddot_info.size();
        i = m;
        if (i < j)
        {
          paramGetRedDotRes = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
          if (paramList.contains(Integer.valueOf(paramGetRedDotRes.uint32_appid.get())))
          {
            paramGetRedDotRes.bool_display_reddot.set(false);
            paramGetRedDotRes.uint32_number.set(0);
            paramGetRedDotRes.uint32_reason.set(0);
            paramGetRedDotRes.uint64_cmd_uin.set(0L);
            paramGetRedDotRes.str_face_url.set(ByteStringMicro.EMPTY);
            paramGetRedDotRes.str_custom_buffer.set(ByteStringMicro.EMPTY);
            paramGetRedDotRes.uint32_expire_time.set(0);
            paramGetRedDotRes.uint32_cmd_uin_type.set(0);
            paramGetRedDotRes.uint32_report_type.set(0);
            bool = true;
            break label832;
          }
        }
        else
        {
          if (bool) {
            a(this.a);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG + "Q.qqstory.redPoint", 2, "setAll==>拉回来的红点数据与本地的做对比，对比uint32_last_time, reult:" + bool);
          }
          return bool;
        }
      }
      finally {}
      break label832;
      label750:
      int i = 0;
      boolean bool = true;
      break label810;
      label758:
      i = 0;
      break label810;
      label763:
      break label808;
      label766:
      i = 1;
      break label810;
      label771:
      i = 0;
      int k = 1;
      label779:
      label788:
      label805:
      label808:
      label810:
      do
      {
        j += 1;
        break;
        if (k == 56) {
          break label234;
        }
        if (k != 61) {
          break label352;
        }
        break label234;
        bool = true;
        i = 0;
        k = 0;
        if (k != 0) {
          break label334;
        }
      } while (i == 0);
      continue;
      label825:
      i += 1;
      continue;
      label832:
      i += 1;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        localRedDotInfo1 = a(paramInt3);
        if (localRedDotInfo1 != null) {
          continue;
        }
        paramBoolean = bool;
      }
      finally
      {
        try
        {
          oidb_0x791.RedDotInfo localRedDotInfo1;
          oidb_0x791.RedDotInfo localRedDotInfo2;
          localRedDotInfo2.mergeFrom(localRedDotInfo1.toByteArray());
          if (localRedDotInfo2.uint32_last_time.get() > paramInt2)
          {
            paramBoolean = bool;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.TAG + "Q.qqstory.redPoint", 2, "result is out of date, current:" + paramInt2 + ", last:" + localRedDotInfo2.uint32_last_time.get());
            paramBoolean = bool;
            continue;
          }
          localRedDotInfo2.bool_display_reddot.set(paramBoolean);
          localRedDotInfo2.uint32_number.set(paramInt1);
          localRedDotInfo2.uint64_cmd_uin.set(paramLong);
          localRedDotInfo2.uint32_last_time.set(paramInt2);
          f(localRedDotInfo2);
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG + "Q.qqstory.redPoint", 2, "updateStoryMessageRedPoint==>" + a(localRedDotInfo2));
          }
          paramBoolean = true;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          paramBoolean = bool;
        }
        localObject = finally;
      }
      return paramBoolean;
      localRedDotInfo2 = new oidb_0x791.RedDotInfo();
    }
  }
  
  /* Error */
  public ArrayList<oidb_0x791.RedDotInfo> aX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 547	jnv:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: new 655	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 957	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   47: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 482	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   53: if_icmpge +98 -> 151
    //   56: aload_0
    //   57: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   60: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: iload_1
    //   64: invokevirtual 485	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 148	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   70: astore 4
    //   72: aload 4
    //   74: getfield 175	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: pop
    //   81: aload 4
    //   83: getfield 163	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   86: invokevirtual 167	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   89: istore_2
    //   90: aload 4
    //   92: getfield 191	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   95: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   98: pop2
    //   99: aload 4
    //   101: getfield 209	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 214	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   110: astore 5
    //   112: bipush 61
    //   114: aload 4
    //   116: getfield 152	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: if_icmpne +22 -> 144
    //   125: iload_2
    //   126: ifeq +18 -> 144
    //   129: aload 5
    //   131: invokestatic 614	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +10 -> 144
    //   137: aload_3
    //   138: aload 4
    //   140: invokevirtual 959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -106 -> 42
    //   151: goto -123 -> 28
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	jnv
    //   41	107	1	i	int
    //   89	37	2	bool	boolean
    //   21	117	3	localObject1	Object
    //   154	4	3	localObject2	Object
    //   70	69	4	localRedDotInfo	oidb_0x791.RedDotInfo
    //   110	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	154	finally
    //   17	22	154	finally
    //   32	40	154	finally
    //   42	125	154	finally
    //   129	144	154	finally
  }
  
  /* Error */
  public ArrayList<oidb_0x791.RedDotInfo> aY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 547	jnv:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: new 655	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 957	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   47: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 482	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   53: if_icmpge +98 -> 151
    //   56: aload_0
    //   57: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   60: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: iload_1
    //   64: invokevirtual 485	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 148	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   70: astore 4
    //   72: aload 4
    //   74: getfield 175	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: pop
    //   81: aload 4
    //   83: getfield 163	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   86: invokevirtual 167	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   89: istore_2
    //   90: aload 4
    //   92: getfield 191	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   95: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   98: pop2
    //   99: aload 4
    //   101: getfield 209	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 214	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   110: astore 5
    //   112: bipush 56
    //   114: aload 4
    //   116: getfield 152	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: if_icmpne +22 -> 144
    //   125: iload_2
    //   126: ifeq +18 -> 144
    //   129: aload 5
    //   131: invokestatic 614	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +10 -> 144
    //   137: aload_3
    //   138: aload 4
    //   140: invokevirtual 959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -106 -> 42
    //   151: goto -123 -> 28
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	jnv
    //   41	107	1	i	int
    //   89	37	2	bool	boolean
    //   21	117	3	localObject1	Object
    //   154	4	3	localObject2	Object
    //   70	69	4	localRedDotInfo	oidb_0x791.RedDotInfo
    //   110	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	154	finally
    //   17	22	154	finally
    //   32	40	154	finally
    //   42	125	154	finally
    //   129	144	154	finally
  }
  
  public void ayC()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.a == null) {
          this.a = a();
        }
        Object localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new StringBuilder("clearStoryWeakRedPoint==>");
        i = this.a.rpt_msg_reddot_info.size() - 1;
        if (i >= 0)
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
          if ((!localRedDotInfo.bool_display_reddot.get()) || (!jno.cK(localRedDotInfo.uint32_appid.get()))) {
            break label209;
          }
          this.a.rpt_msg_reddot_info.remove(i);
          jnp.a(this.mAppInterface, localRedDotInfo);
          ((StringBuilder)localObject1).append(a(localRedDotInfo)).append("|");
        }
      }
      finally {}
      a(this.a);
      if (!this.mAppInterface.a().abu) {
        zjq.cdv |= 0x2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG + "Q.qqstory.redPoint", 2, localObject2.toString());
        continue;
        label209:
        i -= 1;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    Object localObject = a(23);
    oidb_0x791.RedDotInfo localRedDotInfo = a(26);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c()
  {
    Object localObject = a(24);
    oidb_0x791.RedDotInfo localRedDotInfo = a(27);
    if (((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).bool_display_reddot.get())) || ((localRedDotInfo != null) && (localRedDotInfo.bool_display_reddot.get())))
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      return localObject;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo d()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a(59);
    if (localRedDotInfo != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo e()
  {
    if (a(65) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo f()
  {
    if (a(60) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public void f(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          this.a = a();
        }
        Object localObject = this.a;
        if ((localObject == null) || (paramRedDotInfo == null)) {
          return;
        }
        int j = paramRedDotInfo.uint32_appid.get();
        if (QLog.isColorLevel()) {
          QLog.d("nearby.redpoint", 2, "set：appId=" + j + ", uin=" + paramRedDotInfo.uint64_cmd_uin.get() + ", hasRed=" + paramRedDotInfo.bool_display_reddot.get());
        }
        c(paramRedDotInfo);
        d(paramRedDotInfo);
        e(paramRedDotInfo);
        b(paramRedDotInfo);
        i = 0;
        if (i >= this.a.rpt_msg_reddot_info.size()) {
          break label312;
        }
        localObject = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
        if (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get() != j) {
          break label305;
        }
        if ((j != 56) && (j != 61)) {
          break label288;
        }
        if (((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() != paramRedDotInfo.uint64_cmd_uin.get()) {
          break label305;
        }
        this.a.rpt_msg_reddot_info.set(i, paramRedDotInfo);
        if (!QLog.isColorLevel()) {
          break label317;
        }
        QLog.d("nearby.redpoint", 2, "APPID_NEARBY_CONCERN_UPDATE, onPush：has same uin reddot, uin=" + paramRedDotInfo.uint64_cmd_uin.get());
      }
      finally {}
      if (i == 0) {
        this.a.rpt_msg_reddot_info.add(paramRedDotInfo);
      }
      a(this.a);
      continue;
      label288:
      this.a.rpt_msg_reddot_info.set(i, paramRedDotInfo);
      int i = 1;
      continue;
      label305:
      i += 1;
      continue;
      label312:
      i = 0;
      continue;
      label317:
      i = 1;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo g()
  {
    if (a(53) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public int getAppId()
  {
    if (this.a == null) {
      this.a = a();
    }
    if (this.a == null) {
      return 0;
    }
    int m = 0;
    int i = 0;
    int k;
    if (m < this.a.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(m);
      int j;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        j = i;
      }
      label134:
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            i = j;
            break;
            k = localRedDotInfo.uint32_appid.get();
            if ((6 == k) && (i == 0))
            {
              j = k;
            }
            else
            {
              if ((2 != k) && (3 != k) && (4 != k) && (5 != k)) {
                break label134;
              }
              j = k;
            }
          }
          j = i;
        } while (localRedDotInfo.uint32_number.get() <= 0);
        j = i;
      } while (7 != localRedDotInfo.uint32_appid.get());
    }
    for (;;)
    {
      return k;
      k = i;
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo h()
  {
    if (a(54) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  /* Error */
  public BusinessInfoCheckUpdate.RedTypeInfo i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 547	jnv:a	()Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   14: putfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   17: aload_0
    //   18: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   21: astore 12
    //   23: aload 12
    //   25: ifnonnull +11 -> 36
    //   28: aconst_null
    //   29: astore 15
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 15
    //   35: areturn
    //   36: iconst_0
    //   37: istore 4
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore 5
    //   45: lconst_0
    //   46: lstore 7
    //   48: aconst_null
    //   49: astore 16
    //   51: aconst_null
    //   52: astore 15
    //   54: aconst_null
    //   55: astore 14
    //   57: iconst_0
    //   58: istore_3
    //   59: ldc 139
    //   61: astore 12
    //   63: iconst_0
    //   64: istore 9
    //   66: iconst_0
    //   67: istore_1
    //   68: iload_3
    //   69: aload_0
    //   70: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   73: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   76: invokevirtual 482	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   79: if_icmpge +494 -> 573
    //   82: aload_0
    //   83: getfield 79	jnv:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   86: getfield 479	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   89: iload_3
    //   90: invokevirtual 485	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 148	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   96: astore 12
    //   98: aload 12
    //   100: getfield 175	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   106: istore_2
    //   107: aload 12
    //   109: getfield 163	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   112: invokevirtual 167	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   115: istore 9
    //   117: aload 12
    //   119: getfield 191	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint64_cmd_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   122: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   125: lstore 7
    //   127: aload 12
    //   129: getfield 209	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_face_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   132: invokevirtual 214	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   135: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   138: astore 13
    //   140: bipush 38
    //   142: aload 12
    //   144: getfield 152	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   147: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   150: if_icmpne +482 -> 632
    //   153: iload 9
    //   155: ifne +7 -> 162
    //   158: iload_2
    //   159: ifle +473 -> 632
    //   162: aload 12
    //   164: getfield 224	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 307	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   170: ifeq +432 -> 602
    //   173: aload 12
    //   175: getfield 224	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   178: invokevirtual 214	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   181: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   184: astore 14
    //   186: new 309	org/json/JSONObject
    //   189: dup
    //   190: aload 14
    //   192: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   195: ldc_w 745
    //   198: invokevirtual 316	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   201: istore_3
    //   202: aload 15
    //   204: astore 14
    //   206: iload 6
    //   208: istore_1
    //   209: iload_3
    //   210: iconst_1
    //   211: if_icmpne +407 -> 618
    //   214: iload 4
    //   216: istore_1
    //   217: aload 12
    //   219: getfield 175	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_number	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   222: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   225: istore_3
    //   226: iload_3
    //   227: istore_1
    //   228: aload 12
    //   230: getfield 163	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:bool_display_reddot	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   233: invokevirtual 167	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   236: istore 11
    //   238: iload_3
    //   239: istore_1
    //   240: aload 12
    //   242: astore 14
    //   244: aload 12
    //   246: astore 15
    //   248: iload 9
    //   250: istore 10
    //   252: iload 11
    //   254: istore 9
    //   256: aload 14
    //   258: astore 12
    //   260: aload 15
    //   262: astore 14
    //   264: aload 12
    //   266: ifnull +292 -> 558
    //   269: new 684	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   272: dup
    //   273: invokespecial 760	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   276: astore 16
    //   278: new 780	akjs
    //   281: dup
    //   282: invokespecial 994	akjs:<init>	()V
    //   285: astore 17
    //   287: aload 17
    //   289: aload 12
    //   291: invokevirtual 996	akjs:h	(Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;)V
    //   294: iload 10
    //   296: ifne +12 -> 308
    //   299: aload 16
    //   301: astore 15
    //   303: iload 9
    //   305: ifeq -274 -> 31
    //   308: iload_2
    //   309: ifle +119 -> 428
    //   312: aload 16
    //   314: getfield 687	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   317: iconst_5
    //   318: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   321: aload 16
    //   323: getfield 691	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   326: iload_2
    //   327: invokestatic 999	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   330: invokevirtual 765	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   333: aload 12
    //   335: getfield 224	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   338: invokevirtual 307	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   341: istore 9
    //   343: iload 9
    //   345: ifeq +20 -> 365
    //   348: aload 17
    //   350: getfield 1002	akjs:css	Z
    //   353: ifne +12 -> 365
    //   356: aload 16
    //   358: getfield 687	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   361: iconst_0
    //   362: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   365: aload_0
    //   366: aload 13
    //   368: lload 7
    //   370: aload 17
    //   372: invokevirtual 1004	jnv:a	(Ljava/lang/String;JLakjs;)Ljava/lang/String;
    //   375: astore 12
    //   377: aload 16
    //   379: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   382: aload 12
    //   384: invokevirtual 765	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   387: aload 16
    //   389: astore 15
    //   391: goto -360 -> 31
    //   394: astore 12
    //   396: aload_0
    //   397: monitorexit
    //   398: aload 12
    //   400: athrow
    //   401: astore 15
    //   403: iload 5
    //   405: istore_1
    //   406: aload 16
    //   408: astore 14
    //   410: aload 15
    //   412: invokevirtual 525	java/lang/Exception:printStackTrace	()V
    //   415: goto +203 -> 618
    //   418: astore 12
    //   420: aload 12
    //   422: invokevirtual 525	java/lang/Exception:printStackTrace	()V
    //   425: goto -60 -> 365
    //   428: aload 14
    //   430: ifnull +92 -> 522
    //   433: aload 14
    //   435: getfield 224	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   438: invokevirtual 214	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   441: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   444: astore 12
    //   446: aload 16
    //   448: getfield 691	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   451: iload_1
    //   452: invokestatic 999	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   455: invokevirtual 765	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   458: new 309	org/json/JSONObject
    //   461: dup
    //   462: aload 12
    //   464: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   467: ldc_w 1005
    //   470: invokevirtual 316	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   473: ifeq +33 -> 506
    //   476: aload 16
    //   478: getfield 687	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: iconst_0
    //   482: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   485: aload 16
    //   487: astore 15
    //   489: goto -458 -> 31
    //   492: astore 12
    //   494: aload 12
    //   496: invokevirtual 525	java/lang/Exception:printStackTrace	()V
    //   499: aload 16
    //   501: astore 15
    //   503: goto -472 -> 31
    //   506: aload 16
    //   508: getfield 687	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   511: iconst_5
    //   512: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   515: aload 16
    //   517: astore 15
    //   519: goto -488 -> 31
    //   522: aload 16
    //   524: getfield 687	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   527: iconst_0
    //   528: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   531: aload 16
    //   533: getfield 691	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   536: ldc 139
    //   538: invokevirtual 765	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   541: aload 16
    //   543: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   546: ldc 139
    //   548: invokevirtual 765	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   551: aload 16
    //   553: astore 15
    //   555: goto -524 -> 31
    //   558: aconst_null
    //   559: astore 15
    //   561: goto -530 -> 31
    //   564: astore 15
    //   566: aload 12
    //   568: astore 14
    //   570: goto -160 -> 410
    //   573: iload_1
    //   574: istore_2
    //   575: iconst_0
    //   576: istore_1
    //   577: aconst_null
    //   578: astore 15
    //   580: aload 12
    //   582: astore 13
    //   584: iconst_0
    //   585: istore 11
    //   587: iload 9
    //   589: istore 10
    //   591: aload 15
    //   593: astore 12
    //   595: iload 11
    //   597: istore 9
    //   599: goto -335 -> 264
    //   602: iconst_0
    //   603: istore 11
    //   605: iload 9
    //   607: istore 10
    //   609: iconst_0
    //   610: istore_1
    //   611: iload 11
    //   613: istore 9
    //   615: goto -351 -> 264
    //   618: iconst_0
    //   619: istore 11
    //   621: iload 9
    //   623: istore 10
    //   625: iload 11
    //   627: istore 9
    //   629: goto -365 -> 264
    //   632: iload_3
    //   633: iconst_1
    //   634: iadd
    //   635: istore_3
    //   636: aload 13
    //   638: astore 12
    //   640: iload_2
    //   641: istore_1
    //   642: goto -574 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	jnv
    //   67	575	1	i	int
    //   106	535	2	j	int
    //   58	578	3	k	int
    //   37	178	4	m	int
    //   43	361	5	n	int
    //   40	167	6	i1	int
    //   46	323	7	l	long
    //   64	564	9	bool1	boolean
    //   250	374	10	bool2	boolean
    //   236	390	11	bool3	boolean
    //   21	362	12	localObject1	Object
    //   394	5	12	localObject2	Object
    //   418	3	12	localException1	Exception
    //   444	19	12	str	String
    //   492	89	12	localException2	Exception
    //   593	46	12	localObject3	Object
    //   138	499	13	localObject4	Object
    //   55	514	14	localObject5	Object
    //   29	361	15	localObject6	Object
    //   401	10	15	localException3	Exception
    //   487	73	15	localObject7	Object
    //   564	1	15	localException4	Exception
    //   578	14	15	localObject8	Object
    //   49	503	16	localRedTypeInfo	BusinessInfoCheckUpdate.RedTypeInfo
    //   285	86	17	localakjs	akjs
    // Exception table:
    //   from	to	target	type
    //   2	17	394	finally
    //   17	23	394	finally
    //   68	153	394	finally
    //   162	186	394	finally
    //   186	202	394	finally
    //   217	226	394	finally
    //   228	238	394	finally
    //   269	294	394	finally
    //   312	343	394	finally
    //   348	365	394	finally
    //   365	387	394	finally
    //   410	415	394	finally
    //   420	425	394	finally
    //   433	458	394	finally
    //   458	485	394	finally
    //   494	499	394	finally
    //   506	515	394	finally
    //   522	551	394	finally
    //   186	202	401	java/lang/Exception
    //   348	365	418	java/lang/Exception
    //   458	485	492	java/lang/Exception
    //   506	515	492	java/lang/Exception
    //   217	226	564	java/lang/Exception
    //   228	238	564	java/lang/Exception
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo j()
  {
    if (a(42) != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      return localRedTypeInfo;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo k()
  {
    for (;;)
    {
      long l1;
      int i;
      boolean bool1;
      Object localObject6;
      try
      {
        if (this.a == null) {
          this.a = a();
        }
        Object localObject1 = this.a;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        l1 = 0L;
        int j = 0;
        i = 0;
        localObject1 = "";
        bool1 = false;
        if (j >= this.a.rpt_msg_reddot_info.size()) {
          break label367;
        }
        oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(j);
        i = localRedDotInfo.uint32_number.get();
        bool1 = localRedDotInfo.bool_display_reddot.get();
        l1 = localRedDotInfo.uint64_cmd_uin.get();
        localObject6 = localRedDotInfo.str_face_url.get().toStringUtf8();
        if (63 == localRedDotInfo.uint32_appid.get())
        {
          localObject1 = localRedDotInfo;
          l2 = l1;
          localObject5 = localObject6;
          bool2 = bool1;
          k = i;
          if (!bool1)
          {
            if ((!bool1) && (i > 0))
            {
              k = i;
              bool2 = bool1;
              localObject5 = localObject6;
              l2 = l1;
              localObject1 = localRedDotInfo;
            }
          }
          else
          {
            if (localObject1 == null) {
              break label361;
            }
            localObject6 = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject1 = localObject6;
            if (!bool2) {
              continue;
            }
            if (k <= 0) {
              break label325;
            }
            if (k <= 99) {
              break label322;
            }
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_type.set(5);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_content.set(String.valueOf(k));
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("faceUrl", localObject5);
              ((JSONObject)localObject1).put("uin", l2);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_desc.set(((JSONObject)localObject1).toString());
              localObject1 = localObject6;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              Object localObject2 = localObject6;
            }
            continue;
          }
        }
        j += 1;
      }
      finally {}
      Object localObject4 = localObject6;
      continue;
      label322:
      continue;
      label325:
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_content.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject6).red_desc.set("");
      localObject4 = localObject6;
      continue;
      label361:
      localObject4 = null;
      continue;
      label367:
      Object localObject5 = localObject4;
      localObject4 = null;
      long l2 = l1;
      boolean bool2 = bool1;
      int k = i;
    }
  }
  
  public void ls(boolean paramBoolean)
  {
    QLog.d("nearby.redpoint", 1, "setNearbyRedState, show=" + paramBoolean);
    String str = this.mAppInterface.getCurrentAccountUin();
    if (!paramBoolean) {
      ajrb.MO(str);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.mAppInterface.getApp()).edit();
    localEditor.putBoolean("troop_nearby_red_point_state_" + str, paramBoolean);
    localEditor.commit();
  }
  
  public int mN()
  {
    if (this.a == null) {
      this.a = a();
    }
    if (this.a == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    if (i < this.a.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
      int k;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        boolean bool = aqmj.au(BaseApplicationImpl.getApplication(), this.mAppInterface.getCurrentAccountUin());
        k = j;
        if (localRedDotInfo.uint32_number.get() > 0)
        {
          k = j;
          if (7 == localRedDotInfo.uint32_appid.get())
          {
            k = j;
            if (bool) {
              k = j + localRedDotInfo.uint32_number.get();
            }
          }
        }
      }
    }
    return j;
  }
  
  public int mO()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 35: 
      return 2;
    case 52: 
      return 3;
    case 11: 
      return 4;
    }
    return 8;
  }
  
  public int mP()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    return localRedDotInfo.uint32_report_type.get();
  }
  
  public void nY(int paramInt)
  {
    StringBuilder localStringBuilder;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.redpoint", 2, "clearStoryRedPointByAppId：appId=" + paramInt);
      }
      if (this.a == null) {
        this.a = a();
      }
      localObject = this.a;
      if (localObject == null) {
        return;
      }
      localStringBuilder = new StringBuilder("clearStoryRedPointByAppId==>[");
      if (paramInt != 38) {
        break label366;
      }
      if (this.dn == null) {
        this.dn = w();
      }
      if (this.dn != null) {
        this.dn.clear();
      }
      C(this.dn);
    }
    finally {}
    Object localObject = null;
    int i = this.a.rpt_msg_reddot_info.size() - 1;
    label137:
    if (i >= 0)
    {
      oidb_0x791.RedDotInfo localRedDotInfo3 = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
      if (localRedDotInfo3.uint32_appid.get() == paramInt)
      {
        this.a.rpt_msg_reddot_info.remove(i);
        localStringBuilder.append(a(localRedDotInfo3)).append("] [");
        localObject = localRedDotInfo3;
      }
    }
    else if (localRedDotInfo1 != null)
    {
      jnp.a(this.mAppInterface, localRedDotInfo1);
    }
    label393:
    for (;;)
    {
      label223:
      a(this.a);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG + "Q.qqstory.redPoint", 2, localStringBuilder.toString());
      break;
      label272:
      i = this.a.rpt_msg_reddot_info.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label393;
        }
        oidb_0x791.RedDotInfo localRedDotInfo2 = (oidb_0x791.RedDotInfo)this.a.rpt_msg_reddot_info.get(i);
        if ((localRedDotInfo2.bool_display_reddot.get()) && (localRedDotInfo2.uint32_appid.get() == paramInt))
        {
          this.a.rpt_msg_reddot_info.remove(i);
          jnp.a(this.mAppInterface, localRedDotInfo2);
          localStringBuilder.append(a(localRedDotInfo2)).append("]");
          break label223;
          label366:
          if (paramInt == 56) {
            break;
          }
          if (paramInt != 61) {
            break label272;
          }
          break;
          i -= 1;
          break label137;
        }
        i -= 1;
      }
    }
  }
  
  public void onDestroy()
  {
    a(this.a);
    ayB();
  }
  
  public boolean ye()
  {
    String str = this.mAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(this.mAppInterface.getApp()).getBoolean("troop_nearby_red_point_state_" + str, true);
  }
  
  public boolean yf()
  {
    if ((this.mAppInterface.a().abu) || (!this.mAppInterface.a().yn())) {}
    oidb_0x791.RedDotInfo localRedDotInfo;
    do
    {
      return false;
      localRedDotInfo = a();
    } while ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() == 37));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnv
 * JD-Core Version:    0.7.0.1
 */