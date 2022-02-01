import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class yiz
  implements View.OnClickListener, yjf
{
  private yiz.a jdField_a_of_type_Yiz$a;
  private yjh jdField_a_of_type_Yjh;
  private QQAppInterface app;
  private BaseChatPie f;
  private SessionInfo sessionInfo;
  private MqqHandler uiHandler;
  
  public yiz(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, yjh paramyjh, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Yjh = paramyjh;
    this.f = paramBaseChatPie;
    this.uiHandler = paramMqqHandler;
  }
  
  public static yiz.a a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    if (localSharedPreferences != null)
    {
      paramQQAppInterface = localSharedPreferences.getString("selfuin_" + paramQQAppInterface.getCurrentAccountUin() + "_puin_" + paramString + "_msgdata", null);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = new yiz.a(new JSONObject(paramQQAppInterface));
          return paramQQAppInterface;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PubAccountTips", 2, "getLastPATipsMsg JSONException:", paramQQAppInterface);
          }
        }
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, yiz.a parama, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountTips", 2, "refreshLocalTips. puin:" + paramString1 + " ,pushData:" + paramString2);
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("push_campus_tips", 0);
    if (parama != null)
    {
      paramQQAppInterface.b().d(paramString1, 1008, parama.Ka, true);
      if (QLog.isColorLevel()) {
        QLog.i("PubAccountTips", 2, "removeMsgByUniseq. uniqSeqno:" + parama.Ka);
      }
    }
    parama = localSharedPreferences.edit();
    paramQQAppInterface = "selfuin_" + paramQQAppInterface.getCurrentAccountUin() + "_puin_" + paramString1 + "_msgdata";
    if (paramString2 != null) {
      parama.putString(paramQQAppInterface, paramString2);
    }
    for (;;)
    {
      parama.commit();
      return;
      parama.remove(paramQQAppInterface);
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 160	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody
    //   8: dup
    //   9: invokespecial 161	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 165	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: checkcast 160	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody
    //   21: astore_1
    //   22: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +64 -> 89
    //   28: ldc 102
    //   30: iconst_2
    //   31: new 56	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   38: ldc 167
    //   40: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 171	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   47: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   50: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 182
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 186	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc 196
    //   70: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 200	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   77: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   80: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_1
    //   90: getfield 171	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   96: ifeq -92 -> 4
    //   99: aload_1
    //   100: getfield 186	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 211	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq -102 -> 4
    //   109: aload_1
    //   110: getfield 171	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 177	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: istore_2
    //   117: iload_2
    //   118: iconst_1
    //   119: if_icmpne -115 -> 4
    //   122: new 88	org/json/JSONObject
    //   125: dup
    //   126: new 213	java/lang/String
    //   129: dup
    //   130: aload_1
    //   131: getfield 186	tencent/im/s2c/msgtype0x210/submsgtype0xc3/submsgtype0xc3$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   134: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   137: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   140: ldc 221
    //   142: invokespecial 224	java/lang/String:<init>	([BLjava/lang/String;)V
    //   145: invokespecial 91	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore_1
    //   149: new 10	yiz$a
    //   152: dup
    //   153: aload_1
    //   154: invokespecial 94	yiz$a:<init>	(Lorg/json/JSONObject;)V
    //   157: astore_3
    //   158: aload_3
    //   159: invokevirtual 227	yiz$a:TF	()Z
    //   162: ifeq -158 -> 4
    //   165: aload_3
    //   166: getfield 231	yiz$a:bZl	I
    //   169: iconst_1
    //   170: if_icmpne +145 -> 315
    //   173: sipush -2011
    //   176: invokestatic 236	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   179: checkcast 238	com/tencent/mobileqq/data/MessageForStructing
    //   182: astore 4
    //   184: aload_0
    //   185: invokevirtual 67	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   188: astore 5
    //   190: new 56	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   197: ldc 240
    //   199: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_3
    //   203: getfield 243	yiz$a:puin	J
    //   206: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 7
    //   214: aload_3
    //   215: getfield 247	yiz$a:content	Ljava/lang/String;
    //   218: astore 6
    //   220: aload 4
    //   222: aload 5
    //   224: aload 7
    //   226: aload 7
    //   228: aload 6
    //   230: lconst_0
    //   231: sipush -2011
    //   234: sipush 1008
    //   237: lconst_0
    //   238: invokevirtual 251	com/tencent/mobileqq/data/MessageForStructing:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   241: invokestatic 256	anre:a	()Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;
    //   244: astore 7
    //   246: aload 7
    //   248: aload 6
    //   250: putfield 261	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgBrief	Ljava/lang/String;
    //   253: aload 7
    //   255: aload_3
    //   256: getfield 264	yiz$a:jumpUrl	Ljava/lang/String;
    //   259: putfield 267	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   262: aload 7
    //   264: bipush 85
    //   266: putfield 270	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   269: aload 4
    //   271: aload 7
    //   273: putfield 274	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   276: aload 4
    //   278: ldc_w 276
    //   281: ldc_w 278
    //   284: invokevirtual 282	com/tencent/mobileqq/data/MessageForStructing:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: invokevirtual 121	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   291: aload 4
    //   293: aload 5
    //   295: iconst_1
    //   296: iconst_1
    //   297: iconst_1
    //   298: iconst_0
    //   299: invokevirtual 285	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;ZZZZ)V
    //   302: aload_1
    //   303: ldc_w 287
    //   306: aload 4
    //   308: getfield 290	com/tencent/mobileqq/data/MessageForStructing:uniseq	J
    //   311: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   314: pop
    //   315: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +44 -> 362
    //   321: ldc 102
    //   323: iconst_2
    //   324: new 56	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 296
    //   334: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: getfield 299	yiz$a:type	I
    //   341: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc 182
    //   346: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_1
    //   350: invokevirtual 300	org/json/JSONObject:toString	()Ljava/lang/String;
    //   353: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   366: ldc 48
    //   368: iconst_0
    //   369: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   372: ifnull -368 -> 4
    //   375: aload_0
    //   376: new 56	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   383: ldc 240
    //   385: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_3
    //   389: getfield 243	yiz$a:puin	J
    //   392: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 302	yiz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lyiz$a;
    //   401: astore 4
    //   403: aload_0
    //   404: new 56	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   411: ldc 240
    //   413: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_3
    //   417: getfield 243	yiz$a:puin	J
    //   420: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: aload 4
    //   428: aload_1
    //   429: invokevirtual 300	org/json/JSONObject:toString	()Ljava/lang/String;
    //   432: invokestatic 304	yiz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lyiz$a;Ljava/lang/String;)V
    //   435: aload_0
    //   436: ldc_w 306
    //   439: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   442: astore_0
    //   443: aload_0
    //   444: ifnull -440 -> 4
    //   447: aload_0
    //   448: bipush 38
    //   450: invokevirtual 316	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   453: pop
    //   454: return
    //   455: astore_0
    //   456: aload_0
    //   457: invokevirtual 319	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   460: return
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 320	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   466: return
    //   467: astore_0
    //   468: aload_0
    //   469: invokevirtual 321	org/json/JSONException:printStackTrace	()V
    //   472: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramQQAppInterface	QQAppInterface
    //   0	473	1	paramArrayOfByte	byte[]
    //   116	4	2	i	int
    //   12	405	3	localObject1	Object
    //   182	245	4	localObject2	Object
    //   188	106	5	str1	String
    //   218	31	6	str2	String
    //   212	60	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   122	315	455	java/io/UnsupportedEncodingException
    //   315	362	455	java/io/UnsupportedEncodingException
    //   362	443	455	java/io/UnsupportedEncodingException
    //   447	454	455	java/io/UnsupportedEncodingException
    //   13	89	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	117	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	315	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   315	362	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   362	443	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   447	454	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	460	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   468	472	461	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	315	467	org/json/JSONException
    //   315	362	467	org/json/JSONException
    //   362	443	467	org/json/JSONException
    //   447	454	467	org/json/JSONException
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.f.a()).inflate(2131560177, null);
    ImageView localImageView;
    if (this.jdField_a_of_type_Yiz$a != null)
    {
      if (this.jdField_a_of_type_Yiz$a.type != 1) {
        break label106;
      }
      paramVarArgs.setBackgroundResource(2131166141);
      ((TextView)paramVarArgs.findViewById(2131362555)).setText(this.jdField_a_of_type_Yiz$a.content);
      localImageView = (ImageView)paramVarArgs.findViewById(2131362551);
      String str = this.jdField_a_of_type_Yiz$a.iconUrl;
      if (TextUtils.isEmpty(str)) {
        break label127;
      }
      localImageView.setImageDrawable(aoop.getDrawable(str, null, null));
    }
    for (;;)
    {
      paramVarArgs.setOnClickListener(this);
      return paramVarArgs;
      label106:
      if (this.jdField_a_of_type_Yiz$a.type != 2) {
        break;
      }
      paramVarArgs.setBackgroundResource(2131166142);
      break;
      label127:
      localImageView.setVisibility(8);
    }
  }
  
  public int getType()
  {
    return 7;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        return;
        paramVarArgs = a(this.app, this.sessionInfo.aTl);
      } while ((paramVarArgs == null) || (!paramVarArgs.TF()));
      if ((paramVarArgs.bZn < 0) || (paramVarArgs.bZn >= paramVarArgs.bZm) || (paramVarArgs.isExpired())) {
        break;
      }
      this.jdField_a_of_type_Yiz$a = paramVarArgs;
    } while (!this.jdField_a_of_type_Yjh.a(this, new Object[0]));
    anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.show", 0, 0, "" + paramVarArgs.id, "", "", "");
    return;
    if (QLog.isColorLevel()) {
      QLog.w("PubAccountTips", 2, "onAIOEvent():ON_SHOW tips expired!");
    }
    a(this.app, this.sessionInfo.aTl, paramVarArgs, null);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    if ((this.sessionInfo.cZ == 1008) && (this.jdField_a_of_type_Yiz$a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Yiz$a.jumpUrl)))
    {
      localObject2 = this.app.getApp().getSharedPreferences("push_campus_tips", 0);
      if (localObject2 != null)
      {
        localObject1 = "selfuin_" + this.app.getCurrentAccountUin() + "_puin_" + this.sessionInfo.aTl + "_msgdata";
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountTips", 2, "clickedTimes:" + (this.jdField_a_of_type_Yiz$a.bZn + 1));
        }
        yiz.a locala = this.jdField_a_of_type_Yiz$a;
        int i = locala.bZn + 1;
        locala.bZn = i;
        if (i < this.jdField_a_of_type_Yiz$a.bZm) {
          break label325;
        }
        a(this.app, "" + this.jdField_a_of_type_Yiz$a.puin, this.jdField_a_of_type_Yiz$a, null);
        this.uiHandler.sendEmptyMessageDelayed(28, 2000L);
      }
    }
    for (;;)
    {
      localObject1 = this.f.a();
      localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", this.jdField_a_of_type_Yiz$a.jumpUrl);
      ((Context)localObject1).startActivity((Intent)localObject2);
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "school", "school.aio.tips.click", 0, 0, "" + this.jdField_a_of_type_Yiz$a.id, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label325:
      localObject2 = ((SharedPreferences)localObject2).edit();
      try
      {
        this.jdField_a_of_type_Yiz$a.aW.put("clicked", this.jdField_a_of_type_Yiz$a.bZn);
        ((SharedPreferences.Editor)localObject2).putString((String)localObject1, this.jdField_a_of_type_Yiz$a.aW.toString()).commit();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int wM()
  {
    return 10;
  }
  
  public static class a
  {
    public long Ka;
    JSONObject aW;
    int bZl = 0;
    protected int bZm;
    int bZn = 0;
    long begin;
    String content;
    long end;
    String iconUrl;
    int id = 0;
    String jumpUrl;
    long puin;
    String schoolId;
    int type;
    
    public a(JSONObject paramJSONObject)
    {
      this.aW = paramJSONObject;
      if (paramJSONObject != null)
      {
        this.puin = paramJSONObject.optLong("puin");
        this.type = paramJSONObject.optInt("type");
        this.bZl = paramJSONObject.optInt("show_tab");
        this.content = paramJSONObject.optString("content");
        this.iconUrl = paramJSONObject.optString("icon");
        this.jumpUrl = paramJSONObject.optString("url");
        this.begin = paramJSONObject.optLong("begin");
        this.end = paramJSONObject.optLong("end");
        this.schoolId = paramJSONObject.optString("shool_id");
        this.bZm = paramJSONObject.optInt("times");
        this.Ka = paramJSONObject.optLong("msg_seqno");
        this.Ka = paramJSONObject.optLong("msg_seqno");
        this.id = paramJSONObject.optInt("tid");
        this.bZn = paramJSONObject.optInt("clicked");
      }
    }
    
    boolean TF()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.puin > 0L)
      {
        bool1 = bool2;
        if (this.bZm >= 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isExpired()
    {
      boolean bool2 = true;
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      boolean bool1 = bool2;
      if (l >= this.begin)
      {
        bool1 = bool2;
        if (l <= this.end) {
          bool1 = false;
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiz
 * JD-Core Version:    0.7.0.1
 */