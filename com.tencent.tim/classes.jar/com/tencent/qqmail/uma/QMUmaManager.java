package com.tencent.qqmail.uma;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolInfo.AccountInfo;
import com.tencent.qqmail.protocol.CloudProtocolInfo.QueryConfigUpdateRequest;
import com.tencent.qqmail.protocol.CloudProtocolInfo.UserSettingA;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.AckCardReq;
import com.tencent.qqmail.protocol.UMA.BatchGetCardsReq;
import com.tencent.qqmail.protocol.UMA.CheckUpgradeReq;
import com.tencent.qqmail.protocol.UMA.CmdAddADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdAddAccountReq;
import com.tencent.qqmail.protocol.UMA.CmdCheckPendingTipsReq;
import com.tencent.qqmail.protocol.UMA.CmdClrContactTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdDataReportReq;
import com.tencent.qqmail.protocol.UMA.CmdDelADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdDelAccountReq;
import com.tencent.qqmail.protocol.UMA.CmdDelEMailPhotoReq;
import com.tencent.qqmail.protocol.UMA.CmdGetRsaReq;
import com.tencent.qqmail.protocol.UMA.CmdGetUserSettingReq;
import com.tencent.qqmail.protocol.UMA.CmdLoginReq;
import com.tencent.qqmail.protocol.UMA.CmdLogoutReq;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdLstAccountReq;
import com.tencent.qqmail.protocol.UMA.CmdModAccountReq;
import com.tencent.qqmail.protocol.UMA.CmdOpenMobileAcctReq;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateReq;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateReq.RequestField;
import com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigReq;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeReq.EmailInfo;
import com.tencent.qqmail.protocol.UMA.CmdQuerySecAppReq;
import com.tencent.qqmail.protocol.UMA.CmdRegisterReq;
import com.tencent.qqmail.protocol.UMA.CmdSetContactTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdSetEMailNicknameReq;
import com.tencent.qqmail.protocol.UMA.CmdSetEMailPhotoReq;
import com.tencent.qqmail.protocol.UMA.CmdSetUserSettingReq;
import com.tencent.qqmail.protocol.UMA.CmdSyncEMailNicknameReq;
import com.tencent.qqmail.protocol.UMA.CmdSyncEMailPhotoReq;
import com.tencent.qqmail.protocol.UMA.ContactCreateInfo;
import com.tencent.qqmail.protocol.UMA.ContactCreateReq;
import com.tencent.qqmail.protocol.UMA.ContactDelInfo;
import com.tencent.qqmail.protocol.UMA.ContactDelReq;
import com.tencent.qqmail.protocol.UMA.ContactModifyReq;
import com.tencent.qqmail.protocol.UMA.ContactSyncKeyDomain;
import com.tencent.qqmail.protocol.UMA.ContactSyncListReq;
import com.tencent.qqmail.protocol.UMA.Contacts;
import com.tencent.qqmail.protocol.UMA.ContactsCustomInfo;
import com.tencent.qqmail.protocol.UMA.DataReportArray;
import com.tencent.qqmail.protocol.UMA.DeleteCardReq;
import com.tencent.qqmail.protocol.UMA.EmailAccountInfo;
import com.tencent.qqmail.protocol.UMA.EmailProtocolInfo;
import com.tencent.qqmail.protocol.UMA.GetBirthFriendListReq;
import com.tencent.qqmail.protocol.UMA.GetThanksListReq;
import com.tencent.qqmail.protocol.UMA.PhotoParseReq;
import com.tencent.qqmail.protocol.UMA.PushConfigHandleListReq;
import com.tencent.qqmail.protocol.UMA.RejectAdmailReportReq;
import com.tencent.qqmail.protocol.UMA.ReqBase;
import com.tencent.qqmail.protocol.UMA.SaveCardReq;
import com.tencent.qqmail.protocol.UMA.SyncCardReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.protocol.UMA.TranslationReq;
import com.tencent.qqmail.protocol.UMA.UserSetting;
import com.tencent.qqmail.protocol.UMA.UserSetting.Account;
import com.tencent.qqmail.protocol.UMA.VerifyCodeAnswer;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.stringextention.Hex;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import moai.io.Files;
import moai.rx.TransformerShareTo;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class QMUmaManager
{
  static final int AES_BLOCK_SIZE = 16;
  private static final String TAG = "QMUmaManager";
  private static QMUmaManager _instance = new QMUmaManager(QMApplicationContext.sharedInstance().getSessionKeyPath(), AppConfig.getCodeVersion());
  private static PublicKey publicKey;
  private String globalUmaVersion;
  private OnProtocolListener loginCallback;
  private byte[] sessionKey;
  private String sessionKeyPath;
  
  private QMUmaManager(String paramString1, String paramString2)
  {
    initSession(paramString1);
    this.globalUmaVersion = paramString2;
  }
  
  private byte[] AESDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
  {
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(Arrays.copyOf(paramArrayOfByte2, 16));
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, paramArrayOfByte1, localIvParameterSpec);
    return localCipher.doFinal(Arrays.copyOfRange(paramArrayOfByte2, 16, paramArrayOfByte2.length));
  }
  
  private byte[] AESEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException
  {
    byte[] arrayOfByte = randKey();
    Object localObject = new IvParameterSpec(arrayOfByte);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    paramArrayOfByte1 = Cipher.getInstance("AES/CBC/PKCS7Padding");
    paramArrayOfByte1.init(1, localSecretKeySpec, (AlgorithmParameterSpec)localObject);
    localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(arrayOfByte);
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte1.doFinal(paramArrayOfByte2));
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private Observable<QMUmaResult> call(QMUmaSession paramQMUmaSession)
  {
    return call(paramQMUmaSession, QMSchedulers.network()).doOnError(new QMUmaManager.47(this));
  }
  
  private Observable<QMUmaResult> call(QMUmaSession paramQMUmaSession, Scheduler paramScheduler)
  {
    return Observable.defer(new QMUmaManager.52(this, paramQMUmaSession)).subscribeOn(QMSchedulers.io()).observeOn(paramScheduler).concatMap(new QMUmaManager.51(this)).observeOn(QMSchedulers.io()).concatMap(new QMUmaManager.50(this, paramQMUmaSession)).concatMap(new QMUmaManager.49(this, paramQMUmaSession)).retryWhen(new QMUmaManager.48(this, paramQMUmaSession));
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    Deflater localDeflater = new Deflater(9);
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream, localDeflater);
    localDeflaterOutputStream.write(paramArrayOfByte);
    localDeflaterOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    localDeflater.end();
    return paramArrayOfByte;
  }
  
  private ReqBase createBasePbRequest(QMUmaSession paramQMUmaSession)
  {
    ReqBase localReqBase = new ReqBase();
    localReqBase.app = 1;
    localReqBase.usr = paramQMUmaSession.umaId;
    localReqBase.cmd = paramQMUmaSession.cmdId;
    localReqBase.cli = paramQMUmaSession.clientType;
    localReqBase.ver = ByteString.copyFromUtf8(getVersion());
    return localReqBase;
  }
  
  private QMNetworkRequest createNetworkGetRequest(QMUmaSession paramQMUmaSession, String paramString)
  {
    Object localObject = StringExtention.base64Encode(paramQMUmaSession.reqPkg, paramQMUmaSession.reqPkg.length);
    localObject = new QMNetworkRequest("http://qumas.mail.qq.com:80/cgi-bin/" + paramQMUmaSession.cgiName + "?r=" + (String)localObject + "&vid=" + paramQMUmaSession.umaId + "&skey=" + String.valueOf(Hex.encodeHex(paramQMUmaSession.sessionKey)) + "&sdkplatform=tim", QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    ((QMNetworkRequest)localObject).getRequestHeaders().put("If-Modified-Since", paramString);
    ((QMNetworkRequest)localObject).setRequestCookies(new QMUmaManager.63(this, paramQMUmaSession));
    ((QMNetworkRequest)localObject).setRawResponse(true);
    return localObject;
  }
  
  private QMNetworkRequest createNetworkRequest(QMUmaSession paramQMUmaSession, ReqBase paramReqBase)
    throws IOException
  {
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest("http://qumas.mail.qq.com:80/cgi-bin/" + paramQMUmaSession.cgiName + "?sdkplatform=tim", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    localQMNetworkRequest.setRequestCookies(new QMUmaManager.62(this, paramQMUmaSession));
    paramQMUmaSession = String.valueOf(Hex.encodeHex(paramReqBase.toByteArray()));
    Log.d("terrytan", logThread() + "uma up:" + paramQMUmaSession);
    localQMNetworkRequest.setRequestData(paramReqBase.toByteArray());
    localQMNetworkRequest.setRawResponse(true);
    return localQMNetworkRequest;
  }
  
  private Observable<byte[]> decrypt(QMNetworkResponse paramQMNetworkResponse, byte[] paramArrayOfByte)
  {
    return Observable.create(new QMUmaManager.57(this, paramQMNetworkResponse, paramArrayOfByte));
  }
  
  private Observable<SyncEMailPhotoRspInfo> getPhoto(QMNetworkResponse paramQMNetworkResponse)
  {
    return Observable.create(new QMUmaManager.58(this, paramQMNetworkResponse));
  }
  
  private PublicKey getPublicKey()
    throws Exception
  {
    if (publicKey == null)
    {
      X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDS3WDXxg9heCSD9kvCFPN+0lVeNvrfnSf7CDLOGGthxx+o1p6qvyAeAhUFw+hMKtZhWGQ2ntuxrqEmam98V7qnLqf280r6JkcBQWa5y6sjTknbkrZtQhY1uqtYKERvcgmsavQ891q4nfNVh3Vrebcj5is15Y26kdKzAbK4ft/+PQIDAQAB", 0));
      publicKey = KeyFactory.getInstance("RSA", "BC").generatePublic(localX509EncodedKeySpec);
    }
    return publicKey;
  }
  
  private String getVersion()
  {
    return this.globalUmaVersion;
  }
  
  private void initSession(String paramString)
  {
    this.sessionKeyPath = paramString;
    paramString = Files.readFileByLine(paramString, false);
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      this.sessionKey = Hex.decodeHex(paramString.toCharArray());
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.log(5, "QMUmaManager", "decodeHex sessionKey failed", paramString);
    }
  }
  
  private QMUmaSession justSession(QMUmaSession paramQMUmaSession)
  {
    paramQMUmaSession.sessionKey = this.sessionKey;
    return paramQMUmaSession;
  }
  
  private String logThread()
  {
    return "[" + Thread.currentThread().getName() + "]";
  }
  
  private Observable<QMUmaResult> observeLogin(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.rspKey = randKey();
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    paramOnProtocolListener = new CmdLoginReq();
    if ((paramCloudProtocolInfo.device_id_ == null) || (paramCloudProtocolInfo.device_id_.equals(""))) {
      throw new IllegalArgumentException("不加DCHECK了，但是，Device id是: " + paramCloudProtocolInfo.device_id_ + " 不能登录!!!");
    }
    if (paramCloudProtocolInfo.uma_id_ <= 0L) {
      throw new IllegalArgumentException("不加DCHECK了，但是，UMAID是: " + paramCloudProtocolInfo.uma_id_ + " 不能登录!!!");
    }
    paramOnProtocolListener.device_id = paramCloudProtocolInfo.device_id_;
    paramOnProtocolListener.rsp_key = ByteString.copyFrom(localQMUmaSession.rspKey);
    paramOnProtocolListener.uma_id = paramCloudProtocolInfo.uma_id_;
    paramOnProtocolListener.uma_psw_md5sum = ByteString.copyFrom(Hex.decodeHex(paramCloudProtocolInfo.uma_psw_md5_sum_.toCharArray()));
    String str = QMPushManager.getTokenAndType();
    QMLog.log(4, "QMUmaManager", "uma login token: " + str);
    if (!TextUtils.isEmpty(str)) {
      paramOnProtocolListener.ios_realtoken = ByteString.copyFrom(str.getBytes());
    }
    if ((paramCloudProtocolInfo.verify_code_answer_ != null) && (paramCloudProtocolInfo.verify_code_answer_.text != null) && (!paramCloudProtocolInfo.verify_code_answer_.text.equals("")) && (paramCloudProtocolInfo.verify_code_answer_.id != null) && (!paramCloudProtocolInfo.verify_code_answer_.id.equals("")))
    {
      paramOnProtocolListener.verify_code.text = paramCloudProtocolInfo.verify_code_answer_.text;
      paramOnProtocolListener.verify_code.id = paramCloudProtocolInfo.verify_code_answer_.id;
    }
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 1048578;
    localQMUmaSession.cgiName = "uma_login";
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      return call(localQMUmaSession).compose(new TransformerShareTo("login", "only")).doOnNext(new QMUmaManager.3(this)).doOnError(new QMUmaManager.2(this));
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  private Observable<QMNetworkRequest> prepareNoSessionRequst(QMUmaSession paramQMUmaSession)
  {
    return Observable.create(new QMUmaManager.53(this, paramQMUmaSession));
  }
  
  private Observable<QMUmaSession> prepareSession(QMUmaSession paramQMUmaSession)
  {
    return Observable.defer(new QMUmaManager.54(this, paramQMUmaSession));
  }
  
  private Observable<QMNetworkRequest> prepareSessionRequst(QMUmaSession paramQMUmaSession)
  {
    return prepareSession(paramQMUmaSession).concatMap(new QMUmaManager.55(this));
  }
  
  private byte[] randKey()
  {
    byte[] arrayOfByte = new byte[16];
    new SecureRandom().nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  private Observable<SyncEMailPhotoRspInfo> rawDataCall(QMUmaSession paramQMUmaSession, String paramString)
  {
    return prepareSession(paramQMUmaSession).concatMap(new QMUmaManager.61(this, paramQMUmaSession, paramString)).subscribeOn(Schedulers.io()).observeOn(QMSchedulers.avatar()).concatMap(new QMUmaManager.60(this)).observeOn(QMSchedulers.io()).concatMap(new QMUmaManager.59(this));
  }
  
  private Observable<QMNetworkResponse> sendRequst(QMNetworkRequest paramQMNetworkRequest)
  {
    return Observable.create(new QMUmaManager.56(this, paramQMNetworkRequest));
  }
  
  @NonNull
  public static QMUmaManager sharedInstance()
  {
    return _instance;
  }
  
  public void addADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 33;
    localQMUmaSession.cgiName = "uma_add_adbw_contact";
    paramCloudProtocolInfo = paramCloudProtocolInfo.add_bw_contact_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.25(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void addAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 2;
    localQMUmaSession.cgiName = "uma_add_acct";
    paramOnProtocolListener = new CmdAddAccountReq();
    paramOnProtocolListener.verify_code = new VerifyCodeAnswer();
    if ((paramCloudProtocolInfo.verify_code_answer_ != null) && (StringExtention.isNullOrEmpty(paramCloudProtocolInfo.verify_code_answer_.text)) && (StringExtention.isNullOrEmpty(paramCloudProtocolInfo.verify_code_answer_.id)))
    {
      paramOnProtocolListener.verify_code.text = paramCloudProtocolInfo.verify_code_answer_.text;
      paramOnProtocolListener.verify_code.id = paramCloudProtocolInfo.verify_code_answer_.id;
    }
    paramOnProtocolListener.account_info = new EmailAccountInfo();
    EmailAccountInfo localEmailAccountInfo = paramOnProtocolListener.account_info;
    localEmailAccountInfo.id = paramCloudProtocolInfo.add_account_info_.id_;
    localEmailAccountInfo.email = paramCloudProtocolInfo.add_account_info_.email_;
    localEmailAccountInfo.recv = new EmailProtocolInfo();
    localEmailAccountInfo.send = new EmailProtocolInfo();
    localEmailAccountInfo.recv.type = paramCloudProtocolInfo.add_account_info_.recv_.type;
    localEmailAccountInfo.recv.psw = paramCloudProtocolInfo.add_account_info_.recv_.psw;
    localEmailAccountInfo.recv.host = paramCloudProtocolInfo.add_account_info_.recv_.host;
    localEmailAccountInfo.recv.port = paramCloudProtocolInfo.add_account_info_.recv_.port;
    localEmailAccountInfo.recv.security = paramCloudProtocolInfo.add_account_info_.recv_.security;
    localEmailAccountInfo.recv.psw_type = paramCloudProtocolInfo.add_account_info_.recv_.psw_type;
    localEmailAccountInfo.send.type = paramCloudProtocolInfo.add_account_info_.send_.type;
    localEmailAccountInfo.send.psw = paramCloudProtocolInfo.add_account_info_.send_.psw;
    localEmailAccountInfo.send.host = paramCloudProtocolInfo.add_account_info_.send_.host;
    localEmailAccountInfo.send.port = paramCloudProtocolInfo.add_account_info_.send_.port;
    localEmailAccountInfo.send.security = paramCloudProtocolInfo.add_account_info_.send_.security;
    localEmailAccountInfo.send.psw_type = paramCloudProtocolInfo.add_account_info_.send_.psw_type;
    if (paramCloudProtocolInfo.add_account_info_.recv_.associate_uin != -9223372036854775808L) {
      localEmailAccountInfo.recv.associate_uin = paramCloudProtocolInfo.add_account_info_.recv_.associate_uin;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.6(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void checkPendingTips(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 15;
    localQMUmaSession.cgiName = "uma_check_pending_tips";
    paramOnProtocolListener = new CmdCheckPendingTipsReq();
    paramOnProtocolListener.latest_tip_seq = paramCloudProtocolInfo.latest_tip_seq_;
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.22(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void checkUpgrade(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 82;
    localQMUmaSession.cgiName = "uma_check_upgrade";
    paramOnProtocolListener = new CheckUpgradeReq();
    if (paramCloudProtocolInfo.check_upgrade_req_ != null) {
      paramOnProtocolListener.version = paramCloudProtocolInfo.check_upgrade_req_.version;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.36(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void clearContactType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 37;
    localQMUmaSession.cgiName = "uma_clr_contact_type";
    paramOnProtocolListener = new CmdClrContactTypeReq();
    if (paramCloudProtocolInfo.clr_contact_type_req_ != null)
    {
      Iterator localIterator = paramCloudProtocolInfo.clr_contact_type_req_.email.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramOnProtocolListener.email.add(str);
      }
      if (paramCloudProtocolInfo.clr_contact_type_req_.type != 0) {
        paramOnProtocolListener.type = paramCloudProtocolInfo.clr_contact_type_req_.type;
      }
      if (paramCloudProtocolInfo.clr_contact_type_req_.account_id != -2147483648) {
        paramOnProtocolListener.account_id = paramCloudProtocolInfo.clr_contact_type_req_.account_id;
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.29(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void contactCreateNewContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 74;
    localQMUmaSession.cgiName = "contact_create";
    paramOnProtocolListener = new ContactCreateReq();
    if (paramCloudProtocolInfo.contact_create_req_ != null)
    {
      paramOnProtocolListener.create_info = new ContactCreateInfo();
      paramOnProtocolListener.create_info.account_address = paramCloudProtocolInfo.contact_create_req_.account_address;
      paramCloudProtocolInfo = paramCloudProtocolInfo.contact_create_req_.contact_list.iterator();
      while (paramCloudProtocolInfo.hasNext())
      {
        Object localObject1 = (Contacts)paramCloudProtocolInfo.next();
        Contacts localContacts = new Contacts();
        paramOnProtocolListener.create_info.contact_list.add(localContacts);
        localContacts.cid = ((Contacts)localObject1).cid;
        localContacts.tid = ((Contacts)localObject1).tid;
        localContacts.name = ((Contacts)localObject1).name;
        localContacts.nick = ((Contacts)localObject1).nick;
        localContacts.isvip = ((Contacts)localObject1).isvip;
        localContacts.contact_type = ((Contacts)localObject1).contact_type;
        localContacts.pinyin = ((Contacts)localObject1).pinyin;
        Object localObject2 = ((Contacts)localObject1).mark.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.mark.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).address.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.address.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).phone_number.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.phone_number.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).birthday.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.birthday.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).qq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.qq.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).wechat.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.wechat.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).email_address.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.email_address.add(localObject3);
        }
        localObject1 = ((Contacts)localObject1).custom_infos.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ContactsCustomInfo)((Iterator)localObject1).next();
          localObject3 = new ContactsCustomInfo();
          ((ContactsCustomInfo)localObject3).custom_info_name = ((ContactsCustomInfo)localObject2).custom_info_name;
          ((ContactsCustomInfo)localObject3).custom_info_value = ((ContactsCustomInfo)localObject2).custom_info_value;
          localContacts.custom_infos.add(localObject3);
        }
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.33(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void contactDelContactList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 76;
    localQMUmaSession.cgiName = "contact_del";
    paramOnProtocolListener = new ContactDelReq();
    if (paramCloudProtocolInfo.contact_del_req_ != null)
    {
      paramOnProtocolListener.del_info = new ContactDelInfo();
      paramOnProtocolListener.del_info.account_address = paramCloudProtocolInfo.contact_del_req_.account_address;
      Iterator localIterator = paramCloudProtocolInfo.contact_del_req_.cid.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        paramOnProtocolListener.del_info.cid.add(Integer.valueOf(i));
      }
      paramOnProtocolListener.del_info.account_address = paramCloudProtocolInfo.contact_del_req_.account_address;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.31(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void contactModifyContactInfo(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 77;
    localQMUmaSession.cgiName = "contact_modify";
    paramOnProtocolListener = new ContactModifyReq();
    if (paramCloudProtocolInfo.contact_modify_req_ != null)
    {
      paramOnProtocolListener.create_info = new ContactCreateInfo();
      paramOnProtocolListener.create_info.account_address = paramCloudProtocolInfo.contact_modify_req_.account_address;
      paramCloudProtocolInfo = paramCloudProtocolInfo.contact_modify_req_.contact_list.iterator();
      while (paramCloudProtocolInfo.hasNext())
      {
        Object localObject1 = (Contacts)paramCloudProtocolInfo.next();
        Contacts localContacts = new Contacts();
        paramOnProtocolListener.create_info.contact_list.add(localContacts);
        localContacts.cid = ((Contacts)localObject1).cid;
        localContacts.tid = ((Contacts)localObject1).tid;
        localContacts.name = ((Contacts)localObject1).name;
        localContacts.nick = ((Contacts)localObject1).nick;
        localContacts.isvip = ((Contacts)localObject1).isvip;
        localContacts.contact_type = ((Contacts)localObject1).contact_type;
        localContacts.pinyin = ((Contacts)localObject1).pinyin;
        Object localObject2 = ((Contacts)localObject1).mark.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.mark.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).address.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.address.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).phone_number.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.phone_number.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).birthday.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.birthday.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).qq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.qq.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).wechat.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.wechat.add(localObject3);
        }
        localObject2 = ((Contacts)localObject1).email_address.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ByteString)((Iterator)localObject2).next();
          localContacts.email_address.add(localObject3);
        }
        localObject1 = ((Contacts)localObject1).custom_infos.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ContactsCustomInfo)((Iterator)localObject1).next();
          localObject3 = new ContactsCustomInfo();
          ((ContactsCustomInfo)localObject3).custom_info_name = ((ContactsCustomInfo)localObject2).custom_info_name;
          ((ContactsCustomInfo)localObject3).custom_info_value = ((ContactsCustomInfo)localObject2).custom_info_value;
          localContacts.custom_infos.add(localObject3);
        }
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.32(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void contactSyncContactList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    int i = 0;
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 75;
    localQMUmaSession.cgiName = "contact_sync_list";
    paramOnProtocolListener = new ContactSyncListReq();
    if (paramCloudProtocolInfo.contact_sync_list_req_ != null)
    {
      paramCloudProtocolInfo = paramCloudProtocolInfo.contact_sync_list_req_;
      int j = paramCloudProtocolInfo.length;
      while (i < j)
      {
        Object localObject = paramCloudProtocolInfo[i];
        ContactSyncKeyDomain localContactSyncKeyDomain = new ContactSyncKeyDomain();
        localContactSyncKeyDomain.account_addresses = localObject.account_addresses;
        localContactSyncKeyDomain.sync_key = localObject.sync_key;
        paramOnProtocolListener.contact_synckey_domain.add(localContactSyncKeyDomain);
        i += 1;
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.30(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void dataReport(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 12;
    localQMUmaSession.cgiName = "uma_data_report";
    CmdDataReportReq localCmdDataReportReq = new CmdDataReportReq();
    localCmdDataReportReq.sys_version = paramCloudProtocolInfo.sys_version_;
    localCmdDataReportReq.phone_type = paramCloudProtocolInfo.phone_type_;
    paramOnProtocolListener = new DataReportArray();
    Collections.addAll(paramOnProtocolListener.report, paramCloudProtocolInfo.data_report_list_);
    localCmdDataReportReq.use_gzip = paramCloudProtocolInfo.use_gzip_;
    try
    {
      paramOnProtocolListener = paramOnProtocolListener.toByteArray();
      paramCloudProtocolInfo = paramOnProtocolListener;
      if (localCmdDataReportReq.use_gzip) {
        paramCloudProtocolInfo = compress(paramOnProtocolListener);
      }
      localCmdDataReportReq.report_data = ByteString.copyFrom(paramCloudProtocolInfo);
      localQMUmaSession.reqPkg = localCmdDataReportReq.toByteArray();
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        paramCloudProtocolInfo.printStackTrace();
      }
    }
    call(localQMUmaSession, QMSchedulers.network()).doOnNext(new QMUmaManager.46(this)).subscribe();
  }
  
  public void delADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 34;
    localQMUmaSession.cgiName = "uma_del_adbw_contact";
    paramCloudProtocolInfo = paramCloudProtocolInfo.del_bw_contact_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.26(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void delEmailPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 24;
    localQMUmaSession.cgiName = "uma_email_photo_del";
    paramOnProtocolListener = new CmdDelEMailPhotoReq();
    if (paramCloudProtocolInfo.del_photo_list_ != null) {
      Collections.addAll(paramOnProtocolListener.info, paramCloudProtocolInfo.del_photo_list_);
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.19(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void deleteAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 3;
    localQMUmaSession.cgiName = "uma_del_acct";
    paramOnProtocolListener = new CmdDelAccountReq();
    paramOnProtocolListener.account_id = paramCloudProtocolInfo.account_id_;
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.7(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void deleteGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 87;
    localQMUmaSession.cgiName = "uma_delete_card";
    paramOnProtocolListener = new DeleteCardReq();
    if (paramCloudProtocolInfo.delete_card_req_ != null) {
      paramOnProtocolListener.cardid = ByteString.copyFrom(paramCloudProtocolInfo.delete_card_req_.getBytes());
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.40(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public String encodeStringWithPublickKey(String paramString)
  {
    String str = null;
    try
    {
      paramString = RsaEncryption.encrypt(paramString.getBytes(), getPublicKey());
      if (paramString != null) {
        str = StringExtention.base64Encode(paramString, paramString.length);
      }
      return str;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QMLog.log(6, "QMUmaManager", paramString.toString());
        paramString = null;
      }
    }
  }
  
  public void getBirthFriendList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 86;
    localQMUmaSession.cgiName = "uma_get_birthfriend_list";
    paramCloudProtocolInfo = new GetBirthFriendListReq();
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.39(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public String getEncodeUmaSession()
  {
    String str = null;
    try
    {
      byte[] arrayOfByte = RsaEncryption.encrypt(this.sessionKey, getPublicKey());
      if (arrayOfByte != null) {
        str = StringExtention.base64Encode(arrayOfByte, arrayOfByte.length);
      }
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMUmaManager", localException.toString());
        Object localObject = null;
      }
    }
  }
  
  public void getGreetingCards(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 96;
    localQMUmaSession.cgiName = "uma_batch_get_cards";
    paramOnProtocolListener = new BatchGetCardsReq();
    if (paramCloudProtocolInfo.get_cards_req_ != null) {
      paramOnProtocolListener.cardid = paramCloudProtocolInfo.get_cards_req_.cardid;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.43(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void getParsePhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 104;
    localQMUmaSession.cgiName = "uma_photo_parse";
    paramCloudProtocolInfo = paramCloudProtocolInfo.photo_parse_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.45(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void getRsa(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.rspKey = randKey();
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    paramOnProtocolListener = new CmdGetRsaReq();
    paramOnProtocolListener.rsa = paramCloudProtocolInfo.get_rsa_req_.rsa;
    paramOnProtocolListener.rsp_key = ByteString.copyFrom(localQMUmaSession.rspKey);
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(-10004));
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(-10006));
    localQMUmaSession.cmdId = 1048583;
    localQMUmaSession.cgiName = "uma_get_rsa";
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.5(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void getThankFriendList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 89;
    localQMUmaSession.cgiName = "uma_get_thanks_list";
    paramOnProtocolListener = new GetThanksListReq();
    if (paramCloudProtocolInfo.get_thank_list_req_ != null) {
      paramOnProtocolListener.cardid = paramCloudProtocolInfo.get_thank_list_req_.cardid;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.42(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public String getUmaLoginSessionKey()
  {
    if (this.sessionKey != null) {
      return String.valueOf(Hex.encodeHex(this.sessionKey));
    }
    return null;
  }
  
  public void getUserSetting(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 14;
    localQMUmaSession.cgiName = "uma_get_user_setting";
    paramCloudProtocolInfo = new CmdGetUserSettingReq();
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.11(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void login(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    observeLogin(paramCloudProtocolInfo, paramOnProtocolListener).subscribe();
  }
  
  public void logout(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 1;
    localQMUmaSession.cgiName = "uma_logout";
    try
    {
      localQMUmaSession.reqPkg = new CmdLogoutReq().toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.4(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void lstADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 35;
    localQMUmaSession.cgiName = "uma_lst_adbw_contact";
    paramCloudProtocolInfo = paramCloudProtocolInfo.lst_bw_contact_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.27(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void lstAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 5;
    localQMUmaSession.cgiName = "uma_lst_acct";
    paramCloudProtocolInfo = new CmdLstAccountReq();
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.9(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void modAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 4;
    localQMUmaSession.cgiName = "uma_mod_acct";
    paramOnProtocolListener = new CmdModAccountReq();
    paramOnProtocolListener.verify_code = new VerifyCodeAnswer();
    if ((paramCloudProtocolInfo.verify_code_answer_ != null) && (StringExtention.isNullOrEmpty(paramCloudProtocolInfo.verify_code_answer_.text)) && (StringExtention.isNullOrEmpty(paramCloudProtocolInfo.verify_code_answer_.id)))
    {
      paramOnProtocolListener.verify_code.text = paramCloudProtocolInfo.verify_code_answer_.text;
      paramOnProtocolListener.verify_code.id = paramCloudProtocolInfo.verify_code_answer_.id;
    }
    paramOnProtocolListener.account_info = new EmailAccountInfo();
    EmailAccountInfo localEmailAccountInfo = paramOnProtocolListener.account_info;
    localEmailAccountInfo.id = paramCloudProtocolInfo.add_account_info_.id_;
    localEmailAccountInfo.email = paramCloudProtocolInfo.add_account_info_.email_;
    localEmailAccountInfo.recv = new EmailProtocolInfo();
    localEmailAccountInfo.send = new EmailProtocolInfo();
    localEmailAccountInfo.recv.type = paramCloudProtocolInfo.add_account_info_.recv_.type;
    localEmailAccountInfo.recv.psw = paramCloudProtocolInfo.add_account_info_.recv_.psw;
    localEmailAccountInfo.recv.host = paramCloudProtocolInfo.add_account_info_.recv_.host;
    localEmailAccountInfo.recv.port = paramCloudProtocolInfo.add_account_info_.recv_.port;
    if (paramCloudProtocolInfo.add_account_info_.recv_.security != 0) {
      localEmailAccountInfo.recv.security = paramCloudProtocolInfo.add_account_info_.recv_.security;
    }
    localEmailAccountInfo.recv.psw_type = paramCloudProtocolInfo.add_account_info_.recv_.psw_type;
    localEmailAccountInfo.send.type = paramCloudProtocolInfo.add_account_info_.send_.type;
    localEmailAccountInfo.send.psw = paramCloudProtocolInfo.add_account_info_.send_.psw;
    localEmailAccountInfo.send.host = paramCloudProtocolInfo.add_account_info_.send_.host;
    localEmailAccountInfo.send.port = paramCloudProtocolInfo.add_account_info_.send_.port;
    if (paramCloudProtocolInfo.add_account_info_.send_.security != 0) {
      localEmailAccountInfo.send.security = paramCloudProtocolInfo.add_account_info_.send_.security;
    }
    localEmailAccountInfo.send.psw_type = paramCloudProtocolInfo.add_account_info_.send_.psw_type;
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.8(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void openMobileAcct(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 30;
    localQMUmaSession.cgiName = "uma_open_mobile_acct";
    paramOnProtocolListener = new CmdOpenMobileAcctReq();
    if (paramCloudProtocolInfo.mobilenum_list_ != null) {
      Collections.addAll(paramOnProtocolListener.mobilenum_list, paramCloudProtocolInfo.mobilenum_list_);
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.24(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void pushConfigHandle(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 79;
    localQMUmaSession.cgiName = "uma_pushconfig_handle";
    paramOnProtocolListener = new PushConfigHandleListReq();
    if (paramCloudProtocolInfo.push_config_list_req_ != null) {
      paramOnProtocolListener.push_config_handle_list.addAll(Arrays.asList(paramCloudProtocolInfo.push_config_list_req_));
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.34(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void queryConfigUpdate(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    int i = 0;
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 25;
    localQMUmaSession.cgiName = "uma_query_config_update";
    paramOnProtocolListener = new CmdQueryConfigUpdateReq();
    paramOnProtocolListener.call_scene = paramCloudProtocolInfo.query_config_update_req_.call_scene;
    if (paramCloudProtocolInfo.query_config_update_req_.request_list_ != null)
    {
      LinkedList localLinkedList = new LinkedList();
      paramCloudProtocolInfo = paramCloudProtocolInfo.query_config_update_req_.request_list_;
      int j = paramCloudProtocolInfo.length;
      while (i < j)
      {
        Object localObject = paramCloudProtocolInfo[i];
        CmdQueryConfigUpdateReq.RequestField localRequestField = new CmdQueryConfigUpdateReq.RequestField();
        localRequestField.config_type = localObject.config_type;
        if (!StringExtention.isNullOrEmpty(localObject.cur_config_version)) {
          localRequestField.cur_config_version = localObject.cur_config_version;
        }
        if (localObject.new_config_part_pos != 0) {
          localRequestField.new_config_part_pos = localObject.new_config_part_pos;
        }
        if (localObject.new_config_part_len != 0) {
          localRequestField.new_config_part_len = localObject.new_config_part_len;
        }
        if (localObject.extra_param != null) {
          localRequestField.extra_param = ByteString.copyFrom(localObject.extra_param.getBytes());
        }
        localLinkedList.add(localRequestField);
        i += 1;
      }
      paramOnProtocolListener.request = localLinkedList;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.13(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void queryDomainConfig(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 19;
    localQMUmaSession.cgiName = "uma_query_domain_config";
    paramOnProtocolListener = new CmdQueryDomainConfigReq();
    paramOnProtocolListener.domain = paramCloudProtocolInfo.domain_;
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.12(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void queryEmailType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    int i = 0;
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 29;
    localQMUmaSession.cgiName = "uma_query_email_type";
    paramOnProtocolListener = new CmdQueryEmailTypeReq();
    if (paramCloudProtocolInfo.email_info_list_ != null)
    {
      paramCloudProtocolInfo = paramCloudProtocolInfo.email_info_list_;
      int j = paramCloudProtocolInfo.length;
      while (i < j)
      {
        Object localObject = paramCloudProtocolInfo[i];
        CmdQueryEmailTypeReq.EmailInfo localEmailInfo = new CmdQueryEmailTypeReq.EmailInfo();
        localEmailInfo.from = localObject.from;
        localEmailInfo.id = localObject.id;
        localEmailInfo.ip = localObject.ip;
        localEmailInfo.subject = localObject.subject;
        paramOnProtocolListener.info.add(localEmailInfo);
        i += 1;
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.23(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void querySecApp(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 50;
    localQMUmaSession.cgiName = "uma_query_secapp";
    paramOnProtocolListener = new CmdQuerySecAppReq();
    paramOnProtocolListener.compressed = paramCloudProtocolInfo.cmd_query_sec_app_req_.compressed;
    paramOnProtocolListener.device_info = paramCloudProtocolInfo.cmd_query_sec_app_req_.device_info;
    paramOnProtocolListener.triggered_by_server = paramCloudProtocolInfo.cmd_query_sec_app_req_.triggered_by_server;
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.14(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void register(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.rspKey = randKey();
    localQMUmaSession.callback = paramOnProtocolListener;
    paramOnProtocolListener = new CmdRegisterReq();
    paramOnProtocolListener.device_id = paramCloudProtocolInfo.device_id_;
    paramOnProtocolListener.device_info = paramCloudProtocolInfo.device_info_;
    paramOnProtocolListener.rsp_key = ByteString.copyFrom(localQMUmaSession.rspKey);
    if ((paramCloudProtocolInfo.verify_code_answer_ != null) && (paramCloudProtocolInfo.verify_code_answer_.text != null) && (!paramCloudProtocolInfo.verify_code_answer_.text.equals("")) && (paramCloudProtocolInfo.verify_code_answer_.id != null) && (!paramCloudProtocolInfo.verify_code_answer_.id.equals("")))
    {
      paramOnProtocolListener.verify_code.text = paramCloudProtocolInfo.verify_code_answer_.text;
      paramOnProtocolListener.verify_code.id = paramCloudProtocolInfo.verify_code_answer_.id;
    }
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 1048577;
    localQMUmaSession.cgiName = "uma_register";
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.1(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void reportAdMailDeleteAndUnlike(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMLog.log(4, "QMUmaManager", "reportAdMailDeleteAndUnlike");
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 102;
    localQMUmaSession.cgiName = "uma_reject_admail_report";
    paramOnProtocolListener = new RejectAdmailReportReq();
    if (paramCloudProtocolInfo.rejectAdmailReportReq != null)
    {
      paramOnProtocolListener.type = paramCloudProtocolInfo.rejectAdmailReportReq.type;
      paramOnProtocolListener.svrid = paramCloudProtocolInfo.rejectAdmailReportReq.svrid;
      paramOnProtocolListener.uin = paramCloudProtocolInfo.rejectAdmailReportReq.uin;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.44(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void saveGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 84;
    localQMUmaSession.cgiName = "uma_save_card";
    paramCloudProtocolInfo = paramCloudProtocolInfo.save_card_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.38(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void setCloudProtocolLoginCallback(OnProtocolListener paramOnProtocolListener)
  {
    this.loginCallback = paramOnProtocolListener;
  }
  
  public void setContactType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 36;
    localQMUmaSession.cgiName = "uma_set_contact_type";
    paramOnProtocolListener = new CmdSetContactTypeReq();
    if (paramCloudProtocolInfo.set_contact_type_req_ != null)
    {
      Iterator localIterator = paramCloudProtocolInfo.set_contact_type_req_.email.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramOnProtocolListener.email.add(str);
      }
      if (paramCloudProtocolInfo.set_contact_type_req_.type != 0) {
        paramOnProtocolListener.type = paramCloudProtocolInfo.set_contact_type_req_.type;
      }
      if (paramCloudProtocolInfo.set_contact_type_req_.account_id != -2147483648) {
        paramOnProtocolListener.account_id = paramCloudProtocolInfo.set_contact_type_req_.account_id;
      }
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.28(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void setNick(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 27;
    localQMUmaSession.cgiName = "uma_email_nickname_set";
    paramOnProtocolListener = new CmdSetEMailNicknameReq();
    if (paramCloudProtocolInfo.set_nick_list_ != null) {
      Collections.addAll(paramOnProtocolListener.info, paramCloudProtocolInfo.set_nick_list_);
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.21(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void setPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 23;
    localQMUmaSession.cgiName = "uma_email_photo_set";
    paramOnProtocolListener = new CmdSetEMailPhotoReq();
    if (paramCloudProtocolInfo.set_photo_list_ != null) {
      Collections.addAll(paramOnProtocolListener.info, paramCloudProtocolInfo.set_photo_list_);
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      QMLog.log(4, "QMUmaManager", "SetPhoto call(session)");
      call(localQMUmaSession).doOnNext(new QMUmaManager.18(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void setUserSetting(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    int i = 0;
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 13;
    localQMUmaSession.cgiName = "uma_set_user_setting";
    CmdSetUserSettingReq localCmdSetUserSettingReq = new CmdSetUserSettingReq();
    localCmdSetUserSettingReq.cur_config_version = paramCloudProtocolInfo.user_setting_version_;
    localCmdSetUserSettingReq.setting = new UserSetting();
    if (paramCloudProtocolInfo.user_setting_a_ == null) {}
    for (paramOnProtocolListener = null;; paramOnProtocolListener = paramCloudProtocolInfo.user_setting_a_.global_)
    {
      if (paramOnProtocolListener != null) {
        localCmdSetUserSettingReq.setting.set_global(paramOnProtocolListener);
      }
      if ((paramCloudProtocolInfo.user_setting_a_ == null) || (paramCloudProtocolInfo.user_setting_a_.account_list_ == null)) {
        break label363;
      }
      paramOnProtocolListener = new LinkedList();
      paramCloudProtocolInfo = paramCloudProtocolInfo.user_setting_a_.account_list_;
      int j = paramCloudProtocolInfo.length;
      while (i < j)
      {
        Object localObject = paramCloudProtocolInfo[i];
        UserSetting.Account localAccount = new UserSetting.Account();
        localAccount.set_account_id(localObject.account_id());
        if (localObject.has_only_notify_inbox()) {
          localAccount.set_only_notify_inbox(localObject.only_notify_inbox());
        }
        if (localObject.has_notify_newmail()) {
          localAccount.set_notify_newmail(localObject.notify_newmail());
        }
        if (localObject.has_newmail_push_way()) {
          localAccount.set_newmail_push_way(localObject.newmail_push_way());
        }
        if (localObject.has_notify_calstorage()) {
          localAccount.set_notify_calstorage(localObject.notify_calstorage());
        }
        if (localObject.has_sync_mail_count()) {
          localAccount.set_sync_mail_count(localObject.sync_mail_count());
        }
        if (localObject.has_personal_signature()) {
          localAccount.set_personal_signature(localObject.personal_signature());
        }
        if (localObject.has_get_newmail_freq()) {
          localAccount.set_get_newmail_freq(localObject.get_newmail_freq());
        }
        if (localObject.has_aggregate_bysubject()) {
          localAccount.set_aggregate_bysubject(localObject.aggregate_bysubject());
        }
        paramOnProtocolListener.add(localAccount);
        i += 1;
      }
    }
    localCmdSetUserSettingReq.setting.set_account(paramOnProtocolListener);
    try
    {
      label363:
      localQMUmaSession.reqPkg = localCmdSetUserSettingReq.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.10(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void syncGreetingCardList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 83;
    localQMUmaSession.cgiName = "uma_sync_card";
    paramCloudProtocolInfo = paramCloudProtocolInfo.sync_card_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.37(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void syncNick(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 26;
    localQMUmaSession.cgiName = "uma_email_nickname_sync";
    paramOnProtocolListener = new CmdSyncEMailNicknameReq();
    if (paramCloudProtocolInfo.sync_nick_list_ != null) {
      Collections.addAll(paramOnProtocolListener.info, paramCloudProtocolInfo.sync_nick_list_);
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.20(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void syncPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 22;
    localQMUmaSession.cgiName = "uma_email_photo_sync";
    paramOnProtocolListener = new CmdSyncEMailPhotoReq();
    paramOnProtocolListener.info.addAll(Arrays.asList(paramCloudProtocolInfo.sync_photo_list_));
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.15(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  public void syncPhotoBy302(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 97;
    localQMUmaSession.cgiName = "uma_photo_sync_content";
    paramCloudProtocolInfo = paramCloudProtocolInfo.get_email_photo_req_;
    try
    {
      localQMUmaSession.reqPkg = paramCloudProtocolInfo.toByteArray();
      rawDataCall(localQMUmaSession, paramCloudProtocolInfo.info.lastmodifytime).subscribe(new QMUmaManager.16(this, paramCloudProtocolInfo, localQMUmaSession), new QMUmaManager.17(this, paramCloudProtocolInfo, localQMUmaSession));
      return;
    }
    catch (IOException paramOnProtocolListener)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramOnProtocolListener.getMessage());
      }
    }
  }
  
  public void thankGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 88;
    localQMUmaSession.cgiName = "uma_ack_card";
    paramCloudProtocolInfo = paramCloudProtocolInfo.thank_card_req_;
    paramOnProtocolListener = "" + "cardid=" + paramCloudProtocolInfo.cardid;
    paramOnProtocolListener = paramOnProtocolListener + "&fromPlatform=" + paramCloudProtocolInfo.from;
    paramOnProtocolListener = paramOnProtocolListener + "&code=" + paramCloudProtocolInfo.code;
    paramOnProtocolListener = paramOnProtocolListener + "&uin=" + paramCloudProtocolInfo.uin;
    paramOnProtocolListener = paramOnProtocolListener + "&email=" + paramCloudProtocolInfo.email;
    new StringBuilder().append(paramOnProtocolListener).append("&type=").append(paramCloudProtocolInfo.type).toString();
    call(localQMUmaSession).doOnNext(new QMUmaManager.41(this)).subscribe();
  }
  
  public void translate(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    QMUmaSession localQMUmaSession = new QMUmaSession();
    localQMUmaSession.cmdUid = paramCloudProtocolInfo.cmd_unique_id_;
    localQMUmaSession.callback = paramOnProtocolListener;
    localQMUmaSession.umaId = paramCloudProtocolInfo.uma_id_;
    localQMUmaSession.setRetCodeWithRsp.add(Integer.valueOf(0));
    localQMUmaSession.cmdId = 81;
    localQMUmaSession.cgiName = "cmd_translation";
    paramOnProtocolListener = new TranslationReq();
    if (paramCloudProtocolInfo.translate_req_ != null)
    {
      paramOnProtocolListener.to = paramCloudProtocolInfo.translate_req_.to;
      paramOnProtocolListener.from = paramCloudProtocolInfo.translate_req_.from;
      paramOnProtocolListener.mailcontent = paramCloudProtocolInfo.translate_req_.mailcontent;
      paramOnProtocolListener.subject = paramCloudProtocolInfo.translate_req_.subject;
    }
    try
    {
      localQMUmaSession.reqPkg = paramOnProtocolListener.toByteArray();
      call(localQMUmaSession).doOnNext(new QMUmaManager.35(this)).subscribe();
      return;
    }
    catch (IOException paramCloudProtocolInfo)
    {
      for (;;)
      {
        QMLog.log(5, "QMUmaManager", "request transform to ByteArray error: " + paramCloudProtocolInfo.getMessage());
      }
    }
  }
  
  class QMPUmaException
    extends Exception
  {
    int retCode;
    
    QMPUmaException() {}
  }
  
  class QMUmaResult
  {
    byte[] decryptedPkg;
    QMUmaManager.QMUmaSession session;
    
    QMUmaResult(QMUmaManager.QMUmaSession paramQMUmaSession, byte[] paramArrayOfByte)
    {
      this.session = paramQMUmaSession;
      this.decryptedPkg = paramArrayOfByte;
    }
  }
  
  class QMUmaSession
  {
    OnProtocolListener callback;
    String cgiName;
    int clientType = 1;
    int cmdId = -1;
    String cmdUid = "";
    byte[] reqPkg;
    byte[] rspKey;
    byte[] sessionKey;
    Set<Integer> setRetCodeWithRsp = new HashSet();
    long umaId = 0L;
    String version;
    
    QMUmaSession() {}
  }
  
  class QMUmaSessionTimeoutException
    extends Exception
  {
    QMUmaSessionTimeoutException() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager
 * JD-Core Version:    0.7.0.1
 */