import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

public class akhp
{
  public String bTr;
  public String bTs;
  public String bTt;
  AsyncTask<Integer, Void, Bundle> d;
  NewIntent i;
  WeakReference<NearbyPeopleProfileActivity> mActivity;
  Handler mUiHandler;
  String params;
  
  public void RP(int paramInt)
  {
    if ((this.mActivity == null) || (this.mActivity.get() == null)) {}
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity;
    do
    {
      do
      {
        return;
        localNearbyPeopleProfileActivity = (NearbyPeopleProfileActivity)this.mActivity.get();
      } while (localNearbyPeopleProfileActivity == null);
      if (paramInt == 2) {
        this.mUiHandler.sendEmptyMessage(1);
      }
      if (!TextUtils.isEmpty(this.bTt)) {
        break;
      }
    } while (this.d != null);
    this.d = new akhq(this);
    this.d.execute(new Integer[] { Integer.valueOf(paramInt) });
    return;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, this.bTs);
    localBundle.putString(aryv.PARAM_URL, this.bTt);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, this.bTr);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, paramInt);
    localBundle.putString(aryv.PARAM_VIA, "ANDROIDQQ.MSG.QIQI");
    localBundle.putString(aryv.PARAM_APPNAME, "");
    localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, true);
    localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, false);
    aryr.d(localNearbyPeopleProfileActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  /* Error */
  public void a(com.tencent.common.app.AppInterface paramAppInterface, android.content.Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 10
    //   3: new 137	akhr
    //   6: dup
    //   7: aload_0
    //   8: aload 4
    //   10: aload_2
    //   11: iload 6
    //   13: invokespecial 140	akhr:<init>	(Lakhp;Ljava/lang/String;Landroid/content/Context;I)V
    //   16: astore 14
    //   18: aload_0
    //   19: getfield 142	akhp:i	Lmqq/app/NewIntent;
    //   22: ifnonnull +17 -> 39
    //   25: aload_0
    //   26: new 144	mqq/app/NewIntent
    //   29: dup
    //   30: aload_2
    //   31: ldc 146
    //   33: invokespecial 149	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: putfield 142	akhp:i	Lmqq/app/NewIntent;
    //   39: new 151	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest
    //   42: dup
    //   43: invokespecial 152	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:<init>	()V
    //   46: astore 15
    //   48: aload_1
    //   49: invokevirtual 158	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   52: invokestatic 164	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   55: lstore 8
    //   57: aload 15
    //   59: getfield 168	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:uin	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   62: lload 8
    //   64: invokevirtual 174	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   67: aload_3
    //   68: invokestatic 164	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: lstore 8
    //   73: aload 15
    //   75: getfield 177	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:client_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   78: lload 8
    //   80: invokevirtual 174	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   83: aload 15
    //   85: getfield 181	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:pf	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: ldc 108
    //   90: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   93: aload_2
    //   94: invokestatic 192	arxn:bI	(Landroid/content/Context;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload 15
    //   100: getfield 195	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:qqv	Lcom/tencent/mobileqq/pb/PBStringField;
    //   103: aload_3
    //   104: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   107: aload 15
    //   109: getfield 198	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sdkp	Lcom/tencent/mobileqq/pb/PBStringField;
    //   112: ldc 199
    //   114: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   117: getstatic 204	android/os/Build:DISPLAY	Ljava/lang/String;
    //   120: astore_3
    //   121: aload 15
    //   123: getfield 207	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:os	Lcom/tencent/mobileqq/pb/PBStringField;
    //   126: aload_3
    //   127: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   130: aload 15
    //   132: getfield 210	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:skey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   135: aload 5
    //   137: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   140: ldc 108
    //   142: astore_3
    //   143: aload_1
    //   144: instanceof 212
    //   147: ifeq +11 -> 158
    //   150: aload_1
    //   151: checkcast 212	com/tencent/mobileqq/app/QQAppInterface
    //   154: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:rK	()Ljava/lang/String;
    //   157: astore_3
    //   158: aload 15
    //   160: getfield 218	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:vkey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   163: aload_3
    //   164: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 220	akhp:params	Ljava/lang/String;
    //   171: invokestatic 226	anan:ea	(Ljava/lang/String;)I
    //   174: istore 7
    //   176: iload 7
    //   178: ifne +28 -> 206
    //   181: aload_2
    //   182: aload 4
    //   184: aload_0
    //   185: getfield 220	akhp:params	Ljava/lang/String;
    //   188: invokestatic 230	anan:f	(Ljava/lang/String;)Landroid/os/Bundle;
    //   191: iload 6
    //   193: invokestatic 233	arxn:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   196: pop
    //   197: return
    //   198: astore 12
    //   200: lconst_0
    //   201: lstore 8
    //   203: goto -146 -> 57
    //   206: aload 15
    //   208: getfield 237	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:flags	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   211: iload 7
    //   213: invokevirtual 241	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   216: ldc 108
    //   218: astore 5
    //   220: aload 5
    //   222: astore_3
    //   223: aload_2
    //   224: invokevirtual 247	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   227: aload 4
    //   229: bipush 64
    //   231: invokevirtual 253	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   234: getfield 259	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   237: astore 16
    //   239: aload 5
    //   241: astore_3
    //   242: aload 16
    //   244: ifnull +78 -> 322
    //   247: aload 5
    //   249: astore 12
    //   251: aload 5
    //   253: astore_3
    //   254: ldc_w 261
    //   257: invokestatic 267	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   260: astore 13
    //   262: aload 5
    //   264: astore 12
    //   266: aload 5
    //   268: astore_3
    //   269: aload 13
    //   271: aload 16
    //   273: iconst_0
    //   274: aaload
    //   275: invokevirtual 273	android/content/pm/Signature:toByteArray	()[B
    //   278: invokevirtual 277	java/security/MessageDigest:update	([B)V
    //   281: aload 5
    //   283: astore 12
    //   285: aload 5
    //   287: astore_3
    //   288: aload 13
    //   290: invokevirtual 280	java/security/MessageDigest:digest	()[B
    //   293: invokestatic 286	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   296: astore 5
    //   298: aload 5
    //   300: invokevirtual 291	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   303: astore_3
    //   304: aload_3
    //   305: astore 5
    //   307: aload 5
    //   309: astore 12
    //   311: aload 5
    //   313: astore_3
    //   314: aload 13
    //   316: invokevirtual 294	java/security/MessageDigest:reset	()V
    //   319: aload 5
    //   321: astore_3
    //   322: aload_3
    //   323: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +65 -> 391
    //   329: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +17 -> 349
    //   335: aload_0
    //   336: invokevirtual 304	java/lang/Object:getClass	()Ljava/lang/Class;
    //   339: invokevirtual 309	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   342: iconst_2
    //   343: ldc_w 311
    //   346: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_2
    //   350: aload 4
    //   352: aload_0
    //   353: getfield 220	akhp:params	Ljava/lang/String;
    //   356: invokestatic 230	anan:f	(Ljava/lang/String;)Landroid/os/Bundle;
    //   359: iload 6
    //   361: invokestatic 233	arxn:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   364: pop
    //   365: return
    //   366: astore 13
    //   368: aload 12
    //   370: astore 5
    //   372: aload 5
    //   374: astore_3
    //   375: aload 13
    //   377: invokevirtual 317	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   380: aload 5
    //   382: astore_3
    //   383: goto -61 -> 322
    //   386: astore 5
    //   388: goto -66 -> 322
    //   391: aload 15
    //   393: getfield 320	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:apk_sign	Lcom/tencent/mobileqq/pb/PBStringField;
    //   396: aload_3
    //   397: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 142	akhp:i	Lmqq/app/NewIntent;
    //   404: ldc_w 322
    //   407: ldc_w 324
    //   410: invokevirtual 328	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   413: pop
    //   414: aload_0
    //   415: getfield 142	akhp:i	Lmqq/app/NewIntent;
    //   418: ldc_w 330
    //   421: aload 15
    //   423: invokevirtual 331	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:toByteArray	()[B
    //   426: invokevirtual 334	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   429: pop
    //   430: aload_0
    //   431: getfield 142	akhp:i	Lmqq/app/NewIntent;
    //   434: aload 14
    //   436: invokevirtual 338	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   439: aload_1
    //   440: aload_0
    //   441: getfield 142	akhp:i	Lmqq/app/NewIntent;
    //   444: invokevirtual 342	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   447: aload_0
    //   448: getfield 33	akhp:mUiHandler	Landroid/os/Handler;
    //   451: bipush 6
    //   453: ldc2_w 343
    //   456: invokevirtual 348	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   459: pop
    //   460: return
    //   461: astore_1
    //   462: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq -268 -> 197
    //   468: aload_0
    //   469: invokevirtual 304	java/lang/Object:getClass	()Ljava/lang/Class;
    //   472: invokevirtual 309	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   475: iconst_2
    //   476: aload_1
    //   477: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   480: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: return
    //   484: astore_3
    //   485: lload 10
    //   487: lstore 8
    //   489: goto -416 -> 73
    //   492: astore_3
    //   493: aload 5
    //   495: astore_3
    //   496: goto -174 -> 322
    //   499: astore 13
    //   501: goto -129 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	akhp
    //   0	504	1	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	504	2	paramContext	android.content.Context
    //   0	504	3	paramString1	String
    //   0	504	4	paramString2	String
    //   0	504	5	paramString3	String
    //   0	504	6	paramInt	int
    //   174	38	7	j	int
    //   55	433	8	l1	long
    //   1	485	10	l2	long
    //   198	1	12	localException	java.lang.Exception
    //   249	120	12	str	String
    //   260	55	13	localMessageDigest	java.security.MessageDigest
    //   366	10	13	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   499	1	13	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   16	419	14	localakhr	akhr
    //   46	376	15	localAuthorizeRequest	com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest
    //   237	35	16	arrayOfSignature	android.content.pm.Signature[]
    // Exception table:
    //   from	to	target	type
    //   48	57	198	java/lang/Exception
    //   254	262	366	java/security/NoSuchAlgorithmException
    //   269	281	366	java/security/NoSuchAlgorithmException
    //   288	298	366	java/security/NoSuchAlgorithmException
    //   314	319	366	java/security/NoSuchAlgorithmException
    //   223	239	386	java/lang/Exception
    //   254	262	386	java/lang/Exception
    //   269	281	386	java/lang/Exception
    //   288	298	386	java/lang/Exception
    //   314	319	386	java/lang/Exception
    //   375	380	386	java/lang/Exception
    //   414	430	461	java/lang/Exception
    //   67	73	484	java/lang/Exception
    //   298	304	492	java/lang/Exception
    //   298	304	499	java/security/NoSuchAlgorithmException
  }
  
  public void dBr()
  {
    if ((this.mActivity == null) || (this.mActivity.get() == null)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.mActivity.get();
    } while (localActivity == null);
    if (this.i != null)
    {
      this.i.setObserver(null);
      this.i = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
    }
    arxn.a(localActivity, "com.guagua.qiqi", anan.f("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$"), 335544320);
  }
  
  public void kr(long paramLong)
  {
    if ((this.mActivity == null) || (this.mActivity.get() == null) || (paramLong == 0L)) {}
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity;
    do
    {
      return;
      localNearbyPeopleProfileActivity = (NearbyPeopleProfileActivity)this.mActivity.get();
    } while (localNearbyPeopleProfileActivity == null);
    QQAppInterface localQQAppInterface = localNearbyPeopleProfileActivity.app;
    String str = ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getAccount());
    this.params = ("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$&roomid=" + paramLong);
    a(localQQAppInterface, localNearbyPeopleProfileActivity, "1101674847", "com.guagua.qiqi", str, 335544320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhp
 * JD-Core Version:    0.7.0.1
 */