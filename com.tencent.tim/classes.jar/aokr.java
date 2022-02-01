import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.1;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class aokr
  extends aojn
  implements ahhg
{
  private aokr.a jdField_a_of_type_Aokr$a;
  private aokr.e jdField_a_of_type_Aokr$e;
  private aool.a jdField_a_of_type_Aool$a;
  private long apP;
  public QQAppInterface app = (QQAppInterface)this.app;
  private aokr.a b;
  private int bPd;
  private boolean cMz;
  private String clI;
  private String clJ;
  private String clK;
  private int dPv;
  private AtomicBoolean dV = new AtomicBoolean(false);
  private AtomicBoolean dW = new AtomicBoolean(false);
  private AtomicBoolean dX = new AtomicBoolean(false);
  public Context mAppContext = this.app.getApp().getApplicationContext();
  private long mAppId;
  private String mAudioUrl;
  private String mPkgName;
  private int mRetryCount;
  private int mServiceType;
  long mStartTime = 0L;
  private HashMap<String, String> nQ = new HashMap();
  private String ov;
  private String zc;
  private String zd;
  
  public aokr(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    if ((this.h.en instanceof aool.f))
    {
      paramaojm = (aool.f)this.h.en;
      this.bPd = paramaojm.forwardType;
      this.mServiceType = paramaojm.serviceType;
      this.clI = paramaojm.targetUrl;
      this.zc = paramaojm.title;
      this.zd = paramaojm.summary;
      this.mAudioUrl = paramaojm.audioUrl;
      this.mAppId = paramaojm.appId;
      this.mPkgName = paramaojm.pkgName;
      this.jdField_a_of_type_Aool$a = paramaojm.b;
      if (paramaojm.dQQ == 2)
      {
        this.clJ = paramaojm.imageUrl;
        QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + paramaojm.dQQ + ",mRemoteImgUrl=" + this.clK);
        paramaool = this.dV;
        if ((paramaojm.dQQ != 1) && (paramaojm.dQQ != 3)) {
          break label319;
        }
        bool1 = true;
        label261:
        paramaool.set(bool1);
        paramaool = this.dW;
        if (paramaojm.dQQ != 1) {
          break label324;
        }
        bool1 = true;
        label281:
        paramaool.set(bool1);
        paramaool = this.dX;
        if (paramaojm.dQR != 1) {
          break label329;
        }
      }
      label319:
      label324:
      label329:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramaool.set(bool1);
        return;
        this.clK = paramaojm.imageUrl;
        break;
        bool1 = false;
        break label261;
        bool1 = false;
        break label281;
      }
    }
    QLog.i("BaseTransProcessor", 1, "mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo : false");
  }
  
  public static aool a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    aool.f localf = new aool.f();
    localf.forwardType = paramAbsShareMsg.forwardType;
    localf.serviceType = paramAbsShareMsg.mMsgServiceID;
    localf.appId = paramAbsShareMsg.mSourceAppid;
    localf.pkgName = paramAbsShareMsg.shareData.pkgName;
    localf.targetUrl = paramAbsShareMsg.mMsgUrl;
    localf.title = paramAbsShareMsg.mContentTitle;
    localf.summary = paramAbsShareMsg.mContentSummary;
    localf.imageUrl = paramAbsShareMsg.mContentCover;
    localf.audioUrl = paramAbsShareMsg.mContentSrc;
    localf.dQQ = paramAbsShareMsg.shareData.imageUrlStatus;
    localf.dQR = paramAbsShareMsg.shareData.shortUrlStatus;
    localf.b = new aool.a();
    localf.b.sourceName = paramAbsShareMsg.mSourceName;
    localf.b.cmr = paramAbsShareMsg.mSourceIcon;
    localf.b.sourceIconBig = paramAbsShareMsg.shareData.sourceIconBig;
    localf.b.sourceUrl = paramAbsShareMsg.mSourceUrl;
    localf.b.packName = paramAbsShareMsg.mSource_A_ActionData;
    localf.b.status = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new aool();
    paramAbsShareMsg.mSelfUin = paramMessageRecord.selfuin;
    paramAbsShareMsg.mPeerUin = paramMessageRecord.frienduin;
    paramAbsShareMsg.mUinType = paramMessageRecord.istroop;
    paramAbsShareMsg.mFileType = 52;
    paramAbsShareMsg.mUniseq = paramMessageRecord.uniseq;
    paramAbsShareMsg.cNy = true;
    paramAbsShareMsg.mBusiType = 11;
    paramAbsShareMsg.cMb = false;
    paramAbsShareMsg.en = localf;
    return paramAbsShareMsg;
  }
  
  public static aool a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, akyf paramakyf)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.b = paramakyf;
    return paramMessageRecord;
  }
  
  public static aool a(MessageRecord paramMessageRecord, JSONObject paramJSONObject, akyf paramakyf)
  {
    aool.f localf = new aool.f();
    localf.forwardType = paramJSONObject.optInt("forward_type");
    localf.serviceType = paramJSONObject.optInt("serviceType");
    localf.appId = paramJSONObject.optLong("appId");
    localf.pkgName = paramJSONObject.optString("pkg_name");
    localf.targetUrl = paramJSONObject.optString("targetUrl");
    localf.title = paramJSONObject.optString("title");
    localf.summary = paramJSONObject.optString("summary");
    localf.imageUrl = paramJSONObject.optString("image_url");
    localf.audioUrl = paramJSONObject.optString("audio_url");
    localf.dQQ = paramJSONObject.optInt("imageUrlStatus");
    localf.dQR = paramJSONObject.optInt("shortUrlStatus");
    localf.b = new aool.a();
    localf.b.sourceName = paramJSONObject.optString("appInfo_sourceName");
    localf.b.cmr = paramJSONObject.optString("appInfo_sourceIconSmall");
    localf.b.sourceIconBig = paramJSONObject.optString("appInfo_sourceIconBig");
    localf.b.sourceUrl = paramJSONObject.optString("appInfo_sourceUrl");
    localf.b.packName = paramJSONObject.optString("appInfo_packName");
    localf.b.status = paramJSONObject.optInt("appInfo_status");
    paramJSONObject = new aool();
    paramJSONObject.mSelfUin = paramMessageRecord.selfuin;
    paramJSONObject.mPeerUin = paramMessageRecord.frienduin;
    paramJSONObject.mUinType = paramMessageRecord.istroop;
    paramJSONObject.mFileType = 52;
    paramJSONObject.mUniseq = paramMessageRecord.uniseq;
    paramJSONObject.cNy = true;
    paramJSONObject.mBusiType = 11;
    paramJSONObject.cMb = false;
    paramJSONObject.en = localf;
    paramJSONObject.b = paramakyf;
    return paramJSONObject;
  }
  
  private void dVz()
  {
    if (this.mIsCancel) {
      return;
    }
    if (this.jdField_a_of_type_Aokr$a != null) {
      this.jdField_a_of_type_Aokr$a.cancel();
    }
    if (this.b != null) {
      this.b.cancel();
    }
    this.jdField_a_of_type_Aojm.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int EN()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "resume");
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      start();
    }
    return 0;
  }
  
  public int KH()
  {
    if (!(this.h.en instanceof aool.f))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "SdkShareInfo null");
      dN(9302, f(new Exception("SdkShareInfo null")));
      onError();
      return -1;
    }
    if (TextUtils.isEmpty(this.clI))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "share targetUrl null");
      dN(9302, f(new Exception("share targetUrl null")));
      onError();
      return -1;
    }
    if (this.jdField_a_of_type_Aool$a == null)
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "mAppInfo null");
      dN(9302, f(new Exception("mAppInfo null")));
      onError();
      return -1;
    }
    if (!ForwardUtils.au(this.bPd, this.mServiceType))
    {
      String str = "err forwardType=" + this.bPd + ",serviceType=" + this.mServiceType;
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + str);
      dN(9302, f(new Exception(str)));
      onError();
      return -1;
    }
    return 0;
  }
  
  public boolean azV()
  {
    return this.bPd == 11;
  }
  
  public int cancel()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.cancel();
    if (this.jdField_a_of_type_Aokr$a != null) {
      this.jdField_a_of_type_Aokr$a.cancel();
    }
    if (this.b != null) {
      this.b.cancel();
    }
    this.app.b().b(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq, 32768, 9037);
    VR(1004);
    return 0;
  }
  
  void onError()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.errCode + ", cost=" + l);
    super.onError();
    if (this.jdField_a_of_type_Aokr$a != null) {
      this.jdField_a_of_type_Aokr$a.cancel();
    }
    if (this.b != null) {
      this.b.cancel();
    }
    akyf.a locala = new akyf.a();
    locala.result = -1;
    Object localObject;
    if ((this.h != null) && (this.h.b != null))
    {
      if ((azV()) && (this.errCode == 9402) && (!ForwardUtils.aL(this.mAppContext)))
      {
        String str1 = (String)this.nQ.get("audioUrl");
        String str2 = this.clK;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.mAudioUrl;
        }
        locala.data = new String[] { str2, localObject };
        locala.errCode = this.errCode;
      }
      this.h.b.b(locala);
    }
    if (azV()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "56");
      ((Bundle)localObject).putString("intext_1", "" + this.errCode);
      ((Bundle)localObject).putString("intext_5", "" + l);
      arts.a().a((Bundle)localObject, "" + this.mAppId, this.app.getCurrentUin(), false, azV());
      return;
      this.app.b().b(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq, 32768, this.errCode);
      VR(1005);
    }
  }
  
  void onSuccess()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "OnSuccess, cost=" + l);
    Object localObject = this.app.b().b(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.app.b().c(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq, ((AbsShareMsg)localObject).getBytes());
    }
    super.onSuccess();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l);
    arts.a().a((Bundle)localObject, "" + this.mAppId, this.app.getCurrentUin(), false, azV());
  }
  
  public void pause()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "pause");
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (this.jdField_a_of_type_Aokr$a != null) {
        this.jdField_a_of_type_Aokr$a.cancel();
      }
      if (this.b != null) {
        this.b.cancel();
      }
    }
  }
  
  public void start()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "start");
    this.jdField_a_of_type_Aokr$a = new aokr.g();
    this.b = new aokr.f();
    aokr.h localh = new aokr.h();
    aokr.c localc;
    aokr.b localb;
    aokr.d locald;
    if (azV())
    {
      this.b.a(new aokr.a[] { localh });
      localc = new aokr.c();
      localb = new aokr.b();
      locald = new aokr.d();
      if ((localh.isFinished()) || (!locald.isFinished())) {
        break label164;
      }
      localh.a(new aokr.a[] { localb, localc });
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      if (!azV()) {
        break label216;
      }
      this.b.dVA();
      return;
      this.jdField_a_of_type_Aokr$a.a(new aokr.a[] { localh });
      break;
      label164:
      localh.a(new aokr.a[] { localb, locald });
      this.jdField_a_of_type_Aokr$e = new aokr.e();
      locald.a(new aokr.a[] { this.jdField_a_of_type_Aokr$e, localc });
    }
    label216:
    this.jdField_a_of_type_Aokr$a.dVA();
    VR(1001);
    aq(1002, MessageHandler.cwM);
  }
  
  public abstract class a
  {
    private a[] a;
    protected long beginTime;
    private a c;
    protected String clL = "ForwardStep";
    public AtomicBoolean dY = new AtomicBoolean(false);
    protected AtomicBoolean isRunning = new AtomicBoolean(false);
    
    a() {}
    
    void a(a[] paramArrayOfa)
    {
      this.a = paramArrayOfa;
      if ((this.a != null) && (this.a.length > 0))
      {
        paramArrayOfa = this.a;
        int j = paramArrayOfa.length;
        int i = 0;
        while (i < j)
        {
          paramArrayOfa[i].c = this;
          i += 1;
        }
      }
    }
    
    protected void cancel()
    {
      if (isFinished()) {}
      for (;;)
      {
        return;
        this.dY.set(true);
        if ((this.a != null) && (this.a.length > 0))
        {
          a[] arrayOfa = this.a;
          int j = arrayOfa.length;
          int i = 0;
          while (i < j)
          {
            arrayOfa[i].cancel();
            i += 1;
          }
        }
      }
    }
    
    public void dVA()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.clL + "|doStep");
      if ((this.a != null) && (this.a.length > 0))
      {
        a[] arrayOfa = this.a;
        int m = arrayOfa.length;
        int j = 0;
        int i = 1;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          a locala = arrayOfa[j];
          QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { locala.clL, "|finished=", Boolean.valueOf(locala.isFinished()), ", processing=", Boolean.valueOf(locala.isProcessing()) });
          if (!locala.isFinished())
          {
            if (!locala.isProcessing()) {
              locala.dVA();
            }
            i = 0;
          }
          j += 1;
        }
      }
      int k = 1;
      if ((k != 0) && (!isFinished()) && (!isProcessing()))
      {
        this.isRunning.set(true);
        this.beginTime = System.currentTimeMillis();
        process();
      }
    }
    
    public void dVB()
    {
      long l = 0L;
      this.isRunning.set(false);
      if (this.beginTime != 0L) {
        l = System.currentTimeMillis() - this.beginTime;
      }
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.clL + "|finished,cost=" + l);
      ahlw.ao(this.clL, l);
      if ((this.c != null) && (!this.dY.get())) {
        aokr.this.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
      }
    }
    
    public void dVC()
    {
      long l = 0L;
      this.isRunning.set(false);
      if (this.beginTime != 0L) {
        l = System.currentTimeMillis() - this.beginTime;
      }
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.clL + "|doError,cost=" + l);
      aokr.this.onError();
    }
    
    public void doCancel()
    {
      long l = 0L;
      this.isRunning.set(false);
      if (this.beginTime != 0L) {
        l = System.currentTimeMillis() - this.beginTime;
      }
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.clL + "|doCancel,cost=" + l);
    }
    
    protected boolean isFinished()
    {
      return false;
    }
    
    protected boolean isProcessing()
    {
      return this.isRunning.get();
    }
    
    protected abstract void process();
  }
  
  class b
    extends aokr.a
  {
    private AtomicBoolean dZ = new AtomicBoolean(false);
    private BusinessObserver i = new aoks(this);
    private int retryCount;
    
    b()
    {
      super();
      this.clL = "GetAppInfoStep";
      AtomicBoolean localAtomicBoolean = this.dZ;
      if (aokr.a(aokr.this).status == 1) {}
      for (;;)
      {
        localAtomicBoolean.set(bool);
        return;
        bool = false;
      }
    }
    
    private void dVD()
    {
      Object localObject = aokr.this.app.b().b(aokr.this.h.mPeerUin, aokr.this.h.mUinType, aokr.this.h.mUniseq);
      if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        ((AbsShareMsg)localObject).mSource_A_ActionData = aokr.a(aokr.this).packName;
        ((AbsShareMsg)localObject).mSourceName = aokr.a(aokr.this).sourceName;
        ((AbsShareMsg)localObject).mSourceIcon = aokr.a(aokr.this).cmr;
        ((AbsShareMsg)localObject).mSourceUrl = aokr.a(aokr.this).sourceUrl;
        ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
        aokr.this.app.b().c(aokr.this.h.mPeerUin, aokr.this.h.mUinType, aokr.this.h.mUniseq, ((AbsShareMsg)localObject).getBytes());
        aokr.this.VR(1002);
      }
    }
    
    void a(ahgf paramahgf)
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - aokr.b(aokr.this)));
      aokr.a(aokr.this).cmr = paramahgf.wk();
      aokr.a(aokr.this).sourceIconBig = paramahgf.wl();
      if (paramahgf.ani())
      {
        if (!TextUtils.isEmpty(paramahgf.getPkgName())) {
          aokr.a(aokr.this).packName = paramahgf.getPkgName();
        }
        if (!TextUtils.isEmpty(paramahgf.getAppName())) {
          aokr.a(aokr.this).sourceName = paramahgf.getAppName();
        }
        if ((!TextUtils.isEmpty(paramahgf.getSourceUrl())) && (aokr.a(aokr.this) != Long.parseLong("1103584836"))) {
          aokr.a(aokr.this).sourceUrl = paramahgf.getSourceUrl();
        }
      }
      aokr.a(aokr.this).status = 1;
      dVD();
      this.dZ.set(true);
      dVB();
    }
    
    protected boolean isFinished()
    {
      return this.dZ.get();
    }
    
    protected void process()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|process|appId=" + aokr.a(aokr.this) + ",pkgName=" + aokr.g(aokr.this) + ",retry=" + this.retryCount);
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      aokr.a(aokr.this, System.currentTimeMillis());
      switch (aokr.b(aokr.this))
      {
      default: 
        return;
      case 2: 
        svi.a(aokr.this.app, aokr.this.mAppContext, aokr.this.app.getCurrentAccountUin(), aokr.a(aokr.this), 0L, this.i, aokr.g(aokr.this));
        return;
      }
      Object localObject = ((ahlc)aokr.this.app.getManager(350)).a().a(aokr.a(aokr.this));
      if (localObject != null)
      {
        a((ahgf)localObject);
        return;
      }
      long l = aokr.b(aokr.this) / 1000L;
      localObject = AgentActivity.q(aokr.this.mAppContext, aokr.g(aokr.this), l + "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
      }
      svi.a(aokr.this.app, aokr.this.mAppContext, aokr.this.app.getCurrentAccountUin(), aokr.a(aokr.this), (String)localObject, l, this.i, aokr.g(aokr.this));
    }
  }
  
  class c
    extends aokr.a
  {
    private SSOAccountObserver b = new aokt(this);
    private AtomicBoolean ea = new AtomicBoolean(false);
    
    c()
    {
      super();
      this.clL = "GetSKeyStep";
    }
    
    protected boolean isFinished()
    {
      return (this.ea.get()) && (!TextUtils.isEmpty(aokr.f(aokr.this)));
    }
    
    protected void process()
    {
      String str = aokr.this.app.getCurrentAccountUin();
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|process|account=" + artw.qx(str) + ",refresh=" + aokr.a(aokr.this));
      if (this.dY.get()) {
        doCancel();
      }
      for (;;)
      {
        return;
        if (!aokr.this.azQ())
        {
          QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + aokr.this.app);
          aokr.this.dN(9366, "illegal app");
          dVC();
          return;
        }
        int i;
        if (!aokr.a(aokr.this))
        {
          str = ((TicketManager)aokr.this.app.getManager(2)).getSkey(str);
          if (!TextUtils.isEmpty(str))
          {
            i = 0;
            aokr.d(aokr.this, str);
            this.ea.set(true);
            dVB();
          }
        }
        while (i != 0)
        {
          if (aokr.this.azV()) {
            ahlw.Kj("KEY_SSO_GET_TICKET_NO_PASSWD");
          }
          aokr.this.app.ssoGetTicketNoPasswd(aokr.this.app.getCurrentAccountUin(), 4096, this.b);
          return;
          i = 1;
        }
      }
    }
  }
  
  public class d
    extends aokr.a
  {
    private int retryCount;
    
    d()
    {
      super();
      this.clL = "ImageUploadStep";
    }
    
    private Pair<Integer, String> a(String paramString, long paramLong)
    {
      String str = aokr.this.app.getCurrentUin();
      paramString = new CompressInfo(paramString, 0);
      paramString.picType = 0;
      ahlw.Kj("compress_local_image");
      ahlw.N("compress_local_image", str, akyj.c(paramString));
      if (!TextUtils.isEmpty(paramString.destPath)) {
        aokr.e(aokr.this, paramString.destPath);
      }
      paramString = new File(aokr.b(aokr.this));
      long l;
      Object localObject2;
      if (paramString.exists())
      {
        l = paramString.length();
        paramString = aqhq.px(aokr.b(aokr.this));
        if ((l <= 0L) || (TextUtils.isEmpty(paramString))) {
          break label546;
        }
        paramString = String.format("https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { paramString, Long.valueOf(l) });
        ahlw.Kj("query_image");
        paramString = jqc.a(jqi.x(paramString, 1007), str, aokr.f(aokr.this));
        localObject2 = new HashMap();
        if (paramString != null) {
          break label442;
        }
        ((HashMap)localObject2).put("param_ret_code", "-1");
        ((HashMap)localObject2).put("param_need_upload", "0");
        ahlw.a("query_image", str, (HashMap)localObject2, false);
      }
      for (;;)
      {
        paramLong = System.currentTimeMillis() - paramLong;
        if (paramString == null) {
          paramString = new Pair(Integer.valueOf(-1), "");
        }
        for (;;)
        {
          QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|queryImage|ret=" + paramString.first + ",cost=" + paramLong + ",url=" + (String)paramString.second);
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "16");
          ((Bundle)localObject1).putString("intext_1", "" + paramString.first);
          localObject2 = new StringBuilder().append("");
          if (((Integer)paramString.first).intValue() == -1) {}
          for (int i = 0;; i = ((Integer)paramString.first).intValue())
          {
            ((Bundle)localObject1).putString("intext_2", i);
            ((Bundle)localObject1).putString("intext_5", "" + paramLong);
            arts.a().a((Bundle)localObject1, "", str, false, aokr.this.azV());
            return paramString;
            l = 0L;
            break;
            label442:
            ((HashMap)localObject2).put("param_ret_code", String.valueOf(paramString.first));
            if (TextUtils.isEmpty((CharSequence)paramString.second))
            {
              localObject1 = "0";
              label474:
              ((HashMap)localObject2).put("param_need_upload", localObject1);
              if (TextUtils.isEmpty((CharSequence)paramString.second)) {
                break label522;
              }
            }
            label522:
            for (boolean bool = true;; bool = false)
            {
              ahlw.a("query_image", str, (HashMap)localObject2, bool);
              break;
              localObject1 = "1";
              break label474;
            }
          }
        }
        label546:
        paramString = null;
      }
    }
    
    private Pair<Integer, Boolean> b(long paramLong)
    {
      String str = aokr.this.app.getCurrentUin();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("Connection", "keep-alive");
      localHashMap2.put("Referer", "http://www.qq.com");
      localHashMap2.put("Host", "cgi.connect.qq.com");
      Object localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str, "cgi.connect.qq.com");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localHashMap2.put("Cookie", "p_uin=" + str + ";p_skey=" + (String)localObject1);
      }
      HashMap localHashMap3 = new HashMap();
      localHashMap3.put("share_image", aokr.b(aokr.this));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "51");
      ((Bundle)localObject1).putString("intext_3", "0");
      ((Bundle)localObject1).putString("stringext_1", aokr.e(aokr.this));
      arts.a().a((Bundle)localObject1, "", str, false, aokr.this.azV());
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("param_is_ip_direct", "1");
      ahlw.Kj("upload_local_thumb_image");
      Object localObject2 = jqc.a(jqi.x("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str, aokr.f(aokr.this), null, localHashMap3, localHashMap2, false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ahlw.a("upload_local_thumb_image", str, localHashMap1, false);
        ahlw.Kj("upload_local_thumb_image");
        localObject1 = jqc.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str, aokr.f(aokr.this), null, localHashMap3, localHashMap2, true);
        localHashMap1.put("param_is_ip_direct", "0");
      }
      int j = 0;
      int k = 0;
      boolean bool2 = false;
      int i;
      if (localObject1 != null) {
        i = k;
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          i = k;
          j = ((JSONObject)localObject1).getInt("retcode");
          bool1 = bool2;
          if (j == 0)
          {
            bool1 = bool2;
            i = j;
            if (((JSONObject)localObject1).has("result"))
            {
              i = j;
              localObject1 = ((JSONObject)localObject1).getJSONObject("result");
              i = j;
              aokr.c(aokr.this, ((JSONObject)localObject1).getString("url"));
              i = j;
              aokr.a(aokr.this).set(true);
              bool1 = true;
            }
          }
          i = j;
          localHashMap1.put("param_ret_code", Integer.toString(i));
          ahlw.N("upload_local_thumb_image", str, bool1);
          paramLong = System.currentTimeMillis() - paramLong;
          if (QLog.isColorLevel())
          {
            localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + paramLong + ",localImgUrl=" + aokr.b(aokr.this) + ",targetUrl=" + aokr.e(aokr.this);
            if ((bool1) && (paramLong <= 5000L)) {
              break label879;
            }
            QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
          }
          if (!bool1) {
            QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + this.retryCount);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "11");
          localObject2 = new StringBuilder().append("");
          if (!bool1) {
            break label890;
          }
          j = 0;
          ((Bundle)localObject1).putString("intext_1", j);
          ((Bundle)localObject1).putString("intext_2", "" + i);
          ((Bundle)localObject1).putString("intext_3", "0");
          ((Bundle)localObject1).putString("intext_5", "" + paramLong);
          if (!bool1)
          {
            ((Bundle)localObject1).putString("stringext_2", aokr.b(aokr.this));
            ((Bundle)localObject1).putString("stringext_1", aokr.e(aokr.this));
          }
          arts.a().a((Bundle)localObject1, "", str, false, aokr.this.azV());
          return new Pair(Integer.valueOf(i), Boolean.valueOf(bool1));
        }
        catch (JSONException localJSONException)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException.getMessage());
            j = i;
          }
        }
        boolean bool1 = false;
        i = j;
        continue;
        label879:
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException);
        continue;
        label890:
        j = 1;
      }
    }
    
    protected boolean isFinished()
    {
      return aokr.b(aokr.this).get();
    }
    
    protected void process()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|process|ready=" + aokr.b(aokr.this) + ",remoteUrl=" + aokr.a(aokr.this) + " ,localUrl=" + aokr.b(aokr.this));
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      if (aokr.b(aokr.this).get())
      {
        dVB();
        return;
      }
      ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
    }
  }
  
  public class e
    extends aokr.a
  {
    public boolean cMA = false;
    private AtomicInteger cd = new AtomicInteger(0);
    private AtomicBoolean eb = new AtomicBoolean(false);
    
    e()
    {
      super();
      this.clL = "RichStep";
      reset();
    }
    
    /* Error */
    private int KM()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 55	aokr$e:dVE	()V
      //   4: invokestatic 61	java/lang/System:currentTimeMillis	()J
      //   7: lstore 6
      //   9: iconst_m1
      //   10: istore_2
      //   11: aload_0
      //   12: getfield 19	aokr$e:this$0	Laokr;
      //   15: invokestatic 65	aokr:a	(Laokr;)I
      //   18: istore 5
      //   20: iload_2
      //   21: istore_1
      //   22: aload_0
      //   23: getfield 19	aokr$e:this$0	Laokr;
      //   26: getfield 69	aokr:mAppContext	Landroid/content/Context;
      //   29: aload_0
      //   30: getfield 19	aokr$e:this$0	Laokr;
      //   33: invokestatic 72	aokr:e	(Laokr;)Ljava/lang/String;
      //   36: aload_0
      //   37: getfield 19	aokr$e:this$0	Laokr;
      //   40: getfield 76	aokr:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   43: invokevirtual 82	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
      //   46: invokestatic 87	arww:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;
      //   49: astore 11
      //   51: iload_2
      //   52: istore_1
      //   53: aload 11
      //   55: iconst_0
      //   56: aaload
      //   57: checkcast 89	java/lang/Integer
      //   60: invokevirtual 92	java/lang/Integer:intValue	()I
      //   63: istore_2
      //   64: iload_2
      //   65: ifne +599 -> 664
      //   68: iload_2
      //   69: istore_1
      //   70: aload 11
      //   72: iconst_1
      //   73: aaload
      //   74: checkcast 94	java/lang/String
      //   77: astore 9
      //   79: iload_2
      //   80: istore_1
      //   81: aload 11
      //   83: iconst_2
      //   84: aaload
      //   85: checkcast 94	java/lang/String
      //   88: astore 10
      //   90: iload_2
      //   91: istore_1
      //   92: aload 11
      //   94: iconst_3
      //   95: aaload
      //   96: checkcast 94	java/lang/String
      //   99: astore 11
      //   101: iload_2
      //   102: istore_1
      //   103: aload 9
      //   105: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   108: istore 8
      //   110: iload 8
      //   112: ifne +546 -> 658
      //   115: aload_0
      //   116: getfield 19	aokr$e:this$0	Laokr;
      //   119: invokestatic 103	aokr:d	(Laokr;)Ljava/lang/String;
      //   122: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   125: ifeq +31 -> 156
      //   128: aload_0
      //   129: getfield 19	aokr$e:this$0	Laokr;
      //   132: aload_0
      //   133: getfield 19	aokr$e:this$0	Laokr;
      //   136: invokestatic 65	aokr:a	(Laokr;)I
      //   139: bipush 251
      //   141: iand
      //   142: invokestatic 106	aokr:a	(Laokr;I)I
      //   145: pop
      //   146: aload_0
      //   147: getfield 19	aokr$e:this$0	Laokr;
      //   150: aload 9
      //   152: invokestatic 109	aokr:a	(Laokr;Ljava/lang/String;)Ljava/lang/String;
      //   155: pop
      //   156: iconst_4
      //   157: istore 4
      //   159: iload 4
      //   161: istore_3
      //   162: iload 4
      //   164: istore_1
      //   165: aload 10
      //   167: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   170: ifne +65 -> 235
      //   173: iload 4
      //   175: iconst_2
      //   176: ior
      //   177: istore 4
      //   179: iload 4
      //   181: istore_3
      //   182: iload 4
      //   184: istore_1
      //   185: aload_0
      //   186: getfield 19	aokr$e:this$0	Laokr;
      //   189: invokestatic 112	aokr:c	(Laokr;)Ljava/lang/String;
      //   192: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   195: ifeq +40 -> 235
      //   198: iload 4
      //   200: istore_1
      //   201: aload_0
      //   202: getfield 19	aokr$e:this$0	Laokr;
      //   205: aload_0
      //   206: getfield 19	aokr$e:this$0	Laokr;
      //   209: invokestatic 65	aokr:a	(Laokr;)I
      //   212: bipush 253
      //   214: iand
      //   215: invokestatic 106	aokr:a	(Laokr;I)I
      //   218: pop
      //   219: iload 4
      //   221: istore_1
      //   222: aload_0
      //   223: getfield 19	aokr$e:this$0	Laokr;
      //   226: aload 10
      //   228: invokestatic 115	aokr:b	(Laokr;Ljava/lang/String;)Ljava/lang/String;
      //   231: pop
      //   232: iload 4
      //   234: istore_3
      //   235: iload_3
      //   236: istore 4
      //   238: iload_3
      //   239: istore_1
      //   240: aload 11
      //   242: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   245: ifne +78 -> 323
      //   248: iload_3
      //   249: iconst_1
      //   250: ior
      //   251: istore_3
      //   252: iload_3
      //   253: istore 4
      //   255: iload_3
      //   256: istore_1
      //   257: aload_0
      //   258: getfield 19	aokr$e:this$0	Laokr;
      //   261: invokestatic 117	aokr:a	(Laokr;)Ljava/lang/String;
      //   264: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   267: ifeq +56 -> 323
      //   270: iload_3
      //   271: istore 4
      //   273: iload_3
      //   274: istore_1
      //   275: aload_0
      //   276: getfield 19	aokr$e:this$0	Laokr;
      //   279: invokestatic 119	aokr:b	(Laokr;)Ljava/lang/String;
      //   282: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   285: ifeq +38 -> 323
      //   288: iload_3
      //   289: istore_1
      //   290: aload_0
      //   291: getfield 19	aokr$e:this$0	Laokr;
      //   294: aload_0
      //   295: getfield 19	aokr$e:this$0	Laokr;
      //   298: invokestatic 65	aokr:a	(Laokr;)I
      //   301: bipush 254
      //   303: iand
      //   304: invokestatic 106	aokr:a	(Laokr;I)I
      //   307: pop
      //   308: iload_3
      //   309: istore_1
      //   310: aload_0
      //   311: getfield 19	aokr$e:this$0	Laokr;
      //   314: aload 11
      //   316: invokestatic 121	aokr:c	(Laokr;Ljava/lang/String;)Ljava/lang/String;
      //   319: pop
      //   320: iload_3
      //   321: istore 4
      //   323: iload 4
      //   325: istore_1
      //   326: aload_0
      //   327: getfield 28	aokr$e:eb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   330: iconst_0
      //   331: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   334: iload 4
      //   336: istore_1
      //   337: aload_0
      //   338: getfield 19	aokr$e:this$0	Laokr;
      //   341: getfield 76	aokr:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   344: invokevirtual 127	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   347: aload_0
      //   348: getfield 19	aokr$e:this$0	Laokr;
      //   351: getfield 131	aokr:h	Laool;
      //   354: getfield 136	aool:mPeerUin	Ljava/lang/String;
      //   357: aload_0
      //   358: getfield 19	aokr$e:this$0	Laokr;
      //   361: getfield 131	aokr:h	Laool;
      //   364: getfield 140	aool:mUinType	I
      //   367: aload_0
      //   368: getfield 19	aokr$e:this$0	Laokr;
      //   371: getfield 131	aokr:h	Laool;
      //   374: getfield 144	aool:mUniseq	J
      //   377: invokevirtual 149	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
      //   380: astore 9
      //   382: iload 4
      //   384: istore_1
      //   385: aload 9
      //   387: instanceof 151
      //   390: ifeq +185 -> 575
      //   393: iload 4
      //   395: istore_1
      //   396: aload 9
      //   398: checkcast 151	com/tencent/mobileqq/data/MessageForStructing
      //   401: getfield 155	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
      //   404: instanceof 157
      //   407: ifeq +168 -> 575
      //   410: iload 4
      //   412: istore_1
      //   413: aload 9
      //   415: checkcast 151	com/tencent/mobileqq/data/MessageForStructing
      //   418: getfield 155	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
      //   421: checkcast 157	com/tencent/mobileqq/structmsg/AbsShareMsg
      //   424: astore 9
      //   426: iload 4
      //   428: istore_1
      //   429: aload_0
      //   430: getfield 19	aokr$e:this$0	Laokr;
      //   433: invokestatic 103	aokr:d	(Laokr;)Ljava/lang/String;
      //   436: ifnull +18 -> 454
      //   439: iload 4
      //   441: istore_1
      //   442: aload_0
      //   443: getfield 19	aokr$e:this$0	Laokr;
      //   446: invokestatic 103	aokr:d	(Laokr;)Ljava/lang/String;
      //   449: iconst_0
      //   450: invokestatic 163	anbk:w	(Ljava/lang/String;Z)Ljava/lang/String;
      //   453: pop
      //   454: iload 4
      //   456: istore_1
      //   457: aload_0
      //   458: getfield 19	aokr$e:this$0	Laokr;
      //   461: invokestatic 112	aokr:c	(Laokr;)Ljava/lang/String;
      //   464: ifnull +18 -> 482
      //   467: iload 4
      //   469: istore_1
      //   470: aload_0
      //   471: getfield 19	aokr$e:this$0	Laokr;
      //   474: invokestatic 112	aokr:c	(Laokr;)Ljava/lang/String;
      //   477: iconst_0
      //   478: invokestatic 163	anbk:w	(Ljava/lang/String;Z)Ljava/lang/String;
      //   481: pop
      //   482: iload 4
      //   484: istore_1
      //   485: aload 9
      //   487: aload_0
      //   488: getfield 19	aokr$e:this$0	Laokr;
      //   491: invokestatic 103	aokr:d	(Laokr;)Ljava/lang/String;
      //   494: aload_0
      //   495: getfield 19	aokr$e:this$0	Laokr;
      //   498: invokestatic 112	aokr:c	(Laokr;)Ljava/lang/String;
      //   501: aload_0
      //   502: getfield 19	aokr$e:this$0	Laokr;
      //   505: invokestatic 117	aokr:a	(Laokr;)Ljava/lang/String;
      //   508: invokevirtual 167	com/tencent/mobileqq/structmsg/AbsShareMsg:updateTitleSummaryAndCover	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   511: iload 4
      //   513: istore_1
      //   514: aload_0
      //   515: getfield 19	aokr$e:this$0	Laokr;
      //   518: getfield 76	aokr:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   521: invokevirtual 127	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
      //   524: aload_0
      //   525: getfield 19	aokr$e:this$0	Laokr;
      //   528: getfield 131	aokr:h	Laool;
      //   531: getfield 136	aool:mPeerUin	Ljava/lang/String;
      //   534: aload_0
      //   535: getfield 19	aokr$e:this$0	Laokr;
      //   538: getfield 131	aokr:h	Laool;
      //   541: getfield 140	aool:mUinType	I
      //   544: aload_0
      //   545: getfield 19	aokr$e:this$0	Laokr;
      //   548: getfield 131	aokr:h	Laool;
      //   551: getfield 144	aool:mUniseq	J
      //   554: aload 9
      //   556: invokevirtual 171	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
      //   559: invokevirtual 174	com/tencent/imcore/message/QQMessageFacade:c	(Ljava/lang/String;IJ[B)V
      //   562: iload 4
      //   564: istore_1
      //   565: aload_0
      //   566: getfield 19	aokr$e:this$0	Laokr;
      //   569: sipush 1002
      //   572: invokevirtual 177	aokr:VR	(I)V
      //   575: iload 4
      //   577: istore_1
      //   578: iload_1
      //   579: istore_3
      //   580: iload_2
      //   581: istore 4
      //   583: aload_0
      //   584: iload 4
      //   586: invokestatic 61	java/lang/System:currentTimeMillis	()J
      //   589: lload 6
      //   591: lsub
      //   592: iload 5
      //   594: iload_3
      //   595: invokespecial 180	aokr$e:d	(IJII)V
      //   598: iload 4
      //   600: ireturn
      //   601: astore 9
      //   603: iconst_0
      //   604: istore_2
      //   605: iload_1
      //   606: istore 4
      //   608: iload_2
      //   609: istore_3
      //   610: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   613: ifeq -30 -> 583
      //   616: ldc 188
      //   618: iconst_4
      //   619: aload 9
      //   621: iconst_0
      //   622: anewarray 190	java/lang/Object
      //   625: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   628: iload_1
      //   629: istore 4
      //   631: iload_2
      //   632: istore_3
      //   633: goto -50 -> 583
      //   636: astore 9
      //   638: iconst_4
      //   639: istore_3
      //   640: iload_2
      //   641: istore_1
      //   642: iload_3
      //   643: istore_2
      //   644: goto -39 -> 605
      //   647: astore 9
      //   649: iload_1
      //   650: istore_3
      //   651: iload_2
      //   652: istore_1
      //   653: iload_3
      //   654: istore_2
      //   655: goto -50 -> 605
      //   658: iconst_0
      //   659: istore 4
      //   661: goto -502 -> 159
      //   664: iconst_0
      //   665: istore_1
      //   666: goto -88 -> 578
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	669	0	this	e
      //   21	645	1	i	int
      //   10	645	2	j	int
      //   161	493	3	k	int
      //   157	503	4	m	int
      //   18	575	5	n	int
      //   7	583	6	l	long
      //   108	3	8	bool	boolean
      //   77	478	9	localObject1	Object
      //   601	19	9	localException1	Exception
      //   636	1	9	localException2	Exception
      //   647	1	9	localException3	Exception
      //   88	139	10	str	String
      //   49	266	11	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   22	51	601	java/lang/Exception
      //   53	64	601	java/lang/Exception
      //   70	79	601	java/lang/Exception
      //   81	90	601	java/lang/Exception
      //   92	101	601	java/lang/Exception
      //   103	110	601	java/lang/Exception
      //   115	156	636	java/lang/Exception
      //   165	173	647	java/lang/Exception
      //   185	198	647	java/lang/Exception
      //   201	219	647	java/lang/Exception
      //   222	232	647	java/lang/Exception
      //   240	248	647	java/lang/Exception
      //   257	270	647	java/lang/Exception
      //   275	288	647	java/lang/Exception
      //   290	308	647	java/lang/Exception
      //   310	320	647	java/lang/Exception
      //   326	334	647	java/lang/Exception
      //   337	382	647	java/lang/Exception
      //   385	393	647	java/lang/Exception
      //   396	410	647	java/lang/Exception
      //   413	426	647	java/lang/Exception
      //   429	439	647	java/lang/Exception
      //   442	454	647	java/lang/Exception
      //   457	467	647	java/lang/Exception
      //   470	482	647	java/lang/Exception
      //   485	511	647	java/lang/Exception
      //   514	562	647	java/lang/Exception
      //   565	575	647	java/lang/Exception
    }
    
    private void d(int paramInt1, long paramLong, int paramInt2, int paramInt3)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "13");
      ((Bundle)localObject).putString("intext_3", "0");
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (paramInt1 != 0) {}
      for (int i = 1;; i = 0)
      {
        ((Bundle)localObject).putString("intext_1", i);
        ((Bundle)localObject).putString("stringext_2", "" + paramInt1);
        ((Bundle)localObject).putString("stringext_3", "1");
        ((Bundle)localObject).putString("intext_5", "" + paramLong);
        ((Bundle)localObject).putString("intext_2", "" + paramInt2);
        ((Bundle)localObject).putString("intext_4", "" + paramInt3);
        if (paramInt1 != 0) {
          ((Bundle)localObject).putString("stringext_1", aokr.e(aokr.this));
        }
        arts.a().a((Bundle)localObject, "", aokr.this.app.getCurrentAccountUin(), false, aokr.this.azV());
        if (QLog.isColorLevel())
        {
          localObject = "RichStep|run|ret=" + paramInt1 + ",lack=" + aokr.a(aokr.this) + ",cost=" + paramLong;
          if ((paramInt1 == 0) && (paramLong <= 3000L)) {
            break;
          }
          QLog.e("BaseTransProcessor", 2, (String)localObject);
        }
        return;
      }
      QLog.d("BaseTransProcessor", 2, (String)localObject);
    }
    
    private void dVE()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "53");
      localBundle.putString("intext_4", "1");
      localBundle.putString("intext_3", "0");
      localBundle.putString("intext_2", "" + aokr.a(aokr.this));
      localBundle.putString("stringext_1", aokr.e(aokr.this));
      arts.a().a(localBundle, "", aokr.this.app.getCurrentAccountUin(), false, aokr.this.azV());
    }
    
    protected boolean isFinished()
    {
      return (!this.eb.get()) || (this.cd.get() >= 2);
    }
    
    protected void process()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|process|neeRich=" + this.eb + ",lack=" + aokr.a(aokr.this));
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      if (this.eb.get())
      {
        this.cd.set(0);
        ThreadManager.post(new ForwardSdkShareProcessor.RichStep.1(this), 5, null, true);
        return;
      }
      dVB();
    }
    
    void reset()
    {
      this.cd.set(0);
      this.eb.set(false);
      if ((TextUtils.isEmpty(aokr.a(aokr.this))) && (TextUtils.isEmpty(aokr.b(aokr.this)))) {
        aokr.a(aokr.this, aokr.a(aokr.this) | 0x1);
      }
      if (TextUtils.isEmpty(aokr.c(aokr.this))) {
        aokr.a(aokr.this, aokr.a(aokr.this) | 0x2);
      }
      if (TextUtils.isEmpty(aokr.d(aokr.this))) {
        aokr.a(aokr.this, aokr.a(aokr.this) | 0x4);
      }
      if (aokr.a(aokr.this) > 0) {
        this.eb.set(true);
      }
      if (aokr.this.azV()) {
        this.eb.set(false);
      }
    }
  }
  
  class f
    extends aokr.a
  {
    private boolean isFinished;
    
    f()
    {
      super();
      this.clL = "SendMsgByServerStep";
    }
    
    protected boolean isFinished()
    {
      return this.isFinished;
    }
    
    protected void process()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|process");
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      if (!jqi.isNetworkAvailable(aokr.this.mAppContext))
      {
        QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
        if ((aokr.a(aokr.this) > 0) || (!aokr.b(aokr.this).get()) || (!aokr.c(aokr.this).get()) || (aokr.a(aokr.this).status != 1))
        {
          aokr.this.dN(9004, "no network");
          dVC();
          return;
        }
      }
      if ((aokr.this.h != null) && (aokr.this.h.b != null))
      {
        akyf.a locala = new akyf.a();
        String str2 = (String)aokr.a(aokr.this).get("audioUrl");
        String str3 = aokr.a(aokr.this);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = aokr.h(aokr.this);
        }
        locala.data = new String[] { str3, str1 };
        locala.result = 0;
        aokr.this.h.b.b(locala);
      }
      this.isFinished = true;
      dVB();
      aokr.this.onSuccess();
    }
  }
  
  class g
    extends aokr.a
  {
    private boolean isFinished;
    
    g()
    {
      super();
      this.clL = "SendMsgStep";
    }
    
    protected boolean isFinished()
    {
      return this.isFinished;
    }
    
    protected void process()
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|process");
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      if (!jqi.isNetworkAvailable(aokr.this.mAppContext))
      {
        QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
        if ((aokr.a(aokr.this) > 0) || (!aokr.b(aokr.this).get()) || (!aokr.c(aokr.this).get()) || (aokr.a(aokr.this).status != 1))
        {
          aokr.this.dN(9004, "no network");
          dVC();
          return;
        }
      }
      Object localObject = aokr.this.app.b().b(aokr.this.h.mPeerUin, aokr.this.h.mUinType, aokr.this.h.mUniseq);
      if (localObject != null) {
        aokr.this.app.b().b((MessageRecord)localObject, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "14");
      ((Bundle)localObject).putString("intext_2", "" + aokr.a(aokr.this));
      ((Bundle)localObject).putString("stringext_1", "" + aokr.e(aokr.this));
      ((Bundle)localObject).putString("intext_3", "0");
      arts.a().a((Bundle)localObject, "", aokr.this.app.getCurrentAccountUin(), false, aokr.this.azV());
      this.isFinished = true;
      dVB();
      aokr.this.onSuccess();
    }
  }
  
  public class h
    extends aokr.a
  {
    private AtomicInteger cd = new AtomicInteger(0);
    private AtomicInteger ce = new AtomicInteger(-1);
    
    h()
    {
      super();
      this.clL = "UrlExchangeStep";
    }
    
    public void RX(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, paramString);
      }
    }
    
    protected Runnable g()
    {
      return new ForwardSdkShareProcessor.UrlExchangeStep.1(this);
    }
    
    protected boolean isFinished()
    {
      return (aokr.c(aokr.this).get()) || (this.ce.get() != -1) || (this.cd.get() >= 2);
    }
    
    protected void process()
    {
      if (this.dY.get())
      {
        doCancel();
        return;
      }
      if (aokr.this.azV())
      {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
        aokr.c(aokr.this).set(true);
        dVB();
        return;
      }
      if ((!TextUtils.isEmpty(aokr.e(aokr.this))) && (aokr.e(aokr.this).length() > 150)) {
        aokr.a(aokr.this).put("targetUrl", aokr.e(aokr.this));
      }
      if (!TextUtils.isEmpty(aokr.a(aokr.this).sourceUrl)) {
        aokr.a(aokr.this).put("sourceUrl", aokr.a(aokr.this).sourceUrl);
      }
      if (!TextUtils.isEmpty(aokr.a(aokr.this).cmr)) {
        aokr.a(aokr.this).put("sourceIcon", aokr.a(aokr.this).cmr);
      }
      if ((aokr.e(aokr.this) == 2) && (jqc.isValidUrl(aokr.h(aokr.this)))) {
        aokr.a(aokr.this).put("audioUrl", aokr.h(aokr.this));
      }
      Bundle localBundle;
      if (TextUtils.isEmpty(aokr.a(aokr.this)))
      {
        aokr.c(aokr.this, aokr.a(aokr.this).sourceIconBig);
        aokr.a(aokr.this).set(false);
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + aokr.a(aokr.this));
        localBundle = new Bundle();
        localBundle.putString("report_type", "102");
        localBundle.putString("act_type", "18");
        if (!TextUtils.isEmpty(aokr.a(aokr.this))) {
          break label497;
        }
      }
      label497:
      for (String str = "1";; str = "0")
      {
        localBundle.putString("intext_1", str);
        arts.a().a(localBundle, "" + aokr.a(aokr.this), aokr.this.app.getCurrentUin(), false, aokr.this.azV());
        if ((!aokr.a(aokr.this).get()) && (jqc.isValidUrl(aokr.a(aokr.this)))) {
          aokr.a(aokr.this).put("imageUrl", aokr.a(aokr.this));
        }
        RX("UrlExchangeStep|process|url=" + aokr.a(aokr.this).toString());
        if (!aokr.a(aokr.this).isEmpty()) {
          break;
        }
        aokr.c(aokr.this).set(true);
        dVB();
        return;
      }
      ThreadManager.post(g(), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokr
 * JD-Core Version:    0.7.0.1
 */