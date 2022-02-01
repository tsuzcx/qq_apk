import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.QQRecorder.b;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;

public class aagm
  implements QQRecorder.a, QQRecorder.b
{
  private static aagm jdField_b_of_type_Aagm;
  QQRecorder jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String bcW = "";
  boolean bvu;
  public boolean bvv;
  boolean bvw;
  ByteArrayOutputStream byteArrayOutputStream;
  int cgE = -1;
  int clientTryTime;
  public byte[] cy;
  public WeakReference<aagm.b> eS = new WeakReference(null);
  public HashMap<MessageForPtt, MessageForQQWalletMsg> hT = new HashMap();
  public Map<MessageForPtt, aagm.d> iA = new HashMap();
  public int identify;
  public boolean isCancel;
  public int serverTryTime;
  SessionInfo sessionInfo;
  
  private void Am(String paramString)
  {
    onError(2, paramString);
  }
  
  public static boolean S(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        bool1 = bool2;
        if (paramMessageRecord.voiceRedPacketFlag != 0)
        {
          bool1 = bool2;
          if (!paramMessageRecord.isResend) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "isNeedInterceptSend:" + bool1);
    }
    return bool1;
  }
  
  private aagm.c a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    aagm.c localc = new aagm.c();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return localc;
    }
    aagl.a().Wj();
    if (aagl.a().recognize(paramArrayOfByte, paramArrayOfByte.length) == 1) {}
    for (;;)
    {
      localc.bvx = bool;
      localc.ro = aagl.a().getResultCfd();
      localc.bcY = b(localc.ro);
      aagl.a().Wk();
      this.clientTryTime += 1;
      return localc;
      bool = false;
    }
  }
  
  private aagm.c a(byte[] paramArrayOfByte, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    long l1 = System.currentTimeMillis();
    paramArrayOfByte = a(paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "checkInPhone:" + paramArrayOfByte);
    }
    if (paramArrayOfByte.bvx) {}
    for (int i = 1;; i = 0)
    {
      a(i, l2 - l1, 0, paramMessageForQQWalletMsg, paramArrayOfByte.ro);
      return paramArrayOfByte;
    }
  }
  
  public static aagm a()
  {
    try
    {
      if (jdField_b_of_type_Aagm == null) {
        jdField_b_of_type_Aagm = new aagm();
      }
      aagm localaagm = jdField_b_of_type_Aagm;
      return localaagm;
    }
    finally {}
  }
  
  public static ByteStringMicro a(MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageForPtt != null) {}
    try
    {
      paramMessageForPtt = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessageForPtt)) {
        localObject1 = ByteStringMicro.copyFromUtf8(paramMessageForPtt);
      }
      return localObject1;
    }
    catch (Throwable paramMessageForPtt)
    {
      paramMessageForPtt.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    a(paramInt1, paramLong, paramInt2, paramMessageForQQWalletMsg, 0.0F);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, MessageForQQWalletMsg paramMessageForQQWalletMsg, float paramFloat)
  {
    if (paramMessageForQQWalletMsg == null) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramInt1);
    localStringBuilder1.append("|").append(paramLong);
    localStringBuilder1.append("|").append(paramInt2);
    localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("|");
    if (localQQAppInterface == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localStringBuilder2.append(paramInt1);
      localStringBuilder1.append("|").append(paramMessageForQQWalletMsg.istroop);
      localStringBuilder1.append("|").append(paramFloat);
      VACDReportUtil.a(localStringBuilder1.toString(), "QWalletStat", "voiceRedPackMatch", null, null, 0, null);
      return;
      if (aagl.a().c(localQQAppInterface)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "uploadKSongMixRecord is call");
    }
    paramMessageRecord = (MessageForPtt)paramMessageRecord;
    try
    {
      MessageForPtt localMessageForPtt = ujt.a(aagd.getQQAppInterface(), paramMessageRecord.getLocalFilePath(), this.sessionInfo, -2, paramMessageRecord.voiceType);
      if (localMessageForPtt != null)
      {
        this.iA.put(localMessageForPtt, new aagm.d(paramMessageRecord, paramLong, paramArrayOfByte, paramString));
        paramArrayOfByte = new QQRecorder.RecorderParam(aqlv.dZR, 16000, 1);
        if (a(this.cy, this.bcW, paramMessageRecord.getLocalFilePath(), paramArrayOfByte))
        {
          paramString = aagd.getQQAppInterface();
          if ((paramString != null) && (this.sessionInfo != null) && (localMessageForPtt != null))
          {
            c(2, localMessageForPtt);
            localMessageForPtt.voiceRedPacketFlag = 3;
            localMessageForPtt.serial();
            Bundle localBundle = new Bundle();
            localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
            ujt.a(paramString, this.sessionInfo.cZ, this.sessionInfo.aTl, paramMessageRecord.getLocalFilePath(), localMessageForPtt.uniseq, false, paramMessageRecord.voiceLength, paramArrayOfByte.mAudioType, true, 0, 5, true, localMessageForPtt.vipSubBubbleId, localBundle, null, null, false, localMessageForPtt, 0);
            paramArrayOfByte = (aagm.b)this.eS.get();
            if (paramArrayOfByte != null) {
              this.identify = paramArrayOfByte.hashCode();
            }
            paramArrayOfByte = (MessageForQQWalletMsg)this.hT.get(paramMessageRecord);
            this.hT.put(localMessageForPtt, paramArrayOfByte);
            this.hT.remove(paramMessageRecord);
          }
        }
        else
        {
          onError("Mix song error!");
          return;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public static void a(String paramString, MessageForPtt paramMessageForPtt, aojr paramaojr)
  {
    d(paramString, paramMessageForPtt);
    if (paramaojr != null)
    {
      if (!(paramaojr instanceof aojz)) {
        break label38;
      }
      paramString = ((aojz)paramaojr).b();
      if ((paramString != null) && (paramMessageForPtt != null)) {
        paramMessageForPtt.richText = paramString;
      }
    }
    label38:
    do
    {
      do
      {
        do
        {
          return;
          if (!(paramaojr instanceof aokv)) {
            break;
          }
          paramString = ((aokv)paramaojr).a(paramMessageForPtt);
        } while ((paramString == null) || (paramMessageForPtt == null));
        paramMessageForPtt.richText = paramString;
        return;
      } while (!(paramaojr instanceof aokz));
      paramString = ((aokz)paramaojr).a(paramMessageForPtt);
    } while ((paramString == null) || (paramMessageForPtt == null));
    paramMessageForPtt.richText = paramString;
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, QQRecorder.RecorderParam paramRecorderParam)
  {
    long l;
    int i;
    int j;
    int k;
    label453:
    for (;;)
    {
      try
      {
        String str = paramString1 + "m";
        Object localObject = new File(str);
        jgm localjgm;
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin convert mp3 to pcm");
          }
          localjgm = new jgm(paramRecorderParam.mSampleRate, 16, 1);
          localjgm.a(new aagn(this));
          l = System.currentTimeMillis();
        }
        try
        {
          localjgm.bh(paramString1, str);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mp3 to pcm time:" + (System.currentTimeMillis() - l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "begin mix pcm :" + ((File)localObject).exists());
          }
          if (!((File)localObject).exists()) {
            break;
          }
          localObject = aqhq.fileToBytes((File)localObject);
          i = Math.min(paramArrayOfByte.length, localObject.length);
          paramString1 = new byte[i];
          l = System.currentTimeMillis();
          aagd.a(paramString1, paramArrayOfByte, (byte[])localObject, i);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "mix pcm time:" + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          paramArrayOfByte = new aliy();
          localObject = new WechatNsWrapper(BaseApplicationImpl.getContext());
          if (WechatNsWrapper.soLoaded) {
            paramArrayOfByte.a((aliv)localObject);
          }
          paramArrayOfByte.a((aliv)localObject);
          paramArrayOfByte.init(paramRecorderParam.mSampleRate, paramRecorderParam.mBitRate, paramRecorderParam.mAudioType);
          alid.nY(paramString2);
          paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
          alid.a(paramString2, paramRecorderParam, paramRecorderParam.length);
          i = paramString1.length;
          paramRecorderParam = new byte[800];
          j = 0;
          break label511;
          i -= k;
          System.arraycopy(paramString1, j, paramRecorderParam, 0, k);
          localObject = paramArrayOfByte.a(paramRecorderParam, 0, k);
          if (localObject == null) {
            break label531;
          }
          alid.a(paramString2, ((aliv.a)localObject).data, ((aliv.a)localObject).size);
        }
        catch (Throwable paramString1)
        {
          QLog.e("VoiceRedPacketHelper", 1, "convertMp3ToPcm decode exception:" + paramString1, paramString1);
          continue;
        }
        k = 800;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
    label531:
    label539:
    for (;;)
    {
      alid.nZ(paramString2);
      paramArrayOfByte.release();
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "pcm 2 silk time:" + (System.currentTimeMillis() - l));
      }
      return true;
      return false;
      for (;;)
      {
        label511:
        if (i <= 0) {
          break label539;
        }
        if (i >= 800) {
          break label453;
        }
        k = i;
        break;
        j = k + j;
      }
    }
  }
  
  public static int b(MessageForPtt paramMessageForPtt)
  {
    int i = 1;
    if (paramMessageForPtt != null)
    {
      switch (paramMessageForPtt.voiceRedPacketFlag)
      {
      default: 
        i = 0;
      case 1: 
      case 2: 
        return i;
      }
      return 3;
    }
    return 0;
  }
  
  public static boolean b(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.voiceRedPacketFlag == 1) || (paramMessageForPtt.voiceRedPacketFlag == 2) || (paramMessageForPtt.voiceRedPacketFlag == 3);
  }
  
  public static void c(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_redpacket_voice_type", paramInt + "");
    }
  }
  
  public static void c(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("ksong_feeds_id", paramString);
    }
  }
  
  public static void d(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString))) {
      paramMessageRecord.saveExtInfoToExtStr("voice_score_id", paramString);
    }
  }
  
  public static int i(MessageRecord paramMessageRecord)
  {
    try
    {
      int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("ksong_redpacket_voice_type"));
      return i;
    }
    catch (Throwable paramMessageRecord) {}
    return 0;
  }
  
  private static String ih(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  public static String m(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("ksong_feeds_id");
    }
    return str;
  }
  
  public static String n(MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("voice_score_id");
    }
    return str;
  }
  
  private void onError(int paramInt, String paramString)
  {
    aagm.b localb = (aagm.b)this.eS.get();
    if ((localb != null) && (!localb.isFinish())) {
      localb.bC(paramInt, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, paramString);
    }
  }
  
  public void Al(String paramString)
  {
    this.bcW = paramString;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onBeginReceiveData() is called");
    }
    paramString = (aagm.b)this.eS.get();
    if (paramString != null) {
      return paramString.yu();
    }
    return 0;
  }
  
  public void a(aagm.a parama)
  {
    Object localObject = aagd.getQQAppInterface();
    if ((localObject == null) || (parama == null)) {}
    do
    {
      return;
      localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).GetSkey(((QQAppInterface)localObject).getCurrentAccountUin(), 16L, new aags(this, parama));
    } while ((localObject == null) || (((Ticket)localObject)._sig == null) || (((Ticket)localObject)._sig.length == 0));
    parama.zP(new String(((Ticket)localObject)._sig));
  }
  
  public void a(aagm.b paramb)
  {
    this.eS = new WeakReference(paramb);
  }
  
  public void a(aliv paramaliv, aliv.a parama) {}
  
  public void a(SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    int i;
    String str1;
    QQRecorder.RecorderParam localRecorderParam;
    try
    {
      localQQAppInterface = aagd.getQQAppInterface();
      this.sessionInfo = paramSessionInfo;
      i = xvz.fm(paramMessageForQQWalletMsg.messageType);
      str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
      }
      if ((localQQAppInterface == null) || (paramSessionInfo == null)) {
        break label687;
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      this.bvu = paramBoolean;
      localRecorderParam = new QQRecorder.RecorderParam(aqlv.dZR, 16000, 1);
      if (!aqhq.aCJ())
      {
        showToast(2131696377);
        onError("no sdcard");
        return;
      }
    }
    catch (Exception paramSessionInfo)
    {
      onError(paramSessionInfo.toString());
      paramSessionInfo.printStackTrace();
      return;
    }
    if (!QQRecorder.aES())
    {
      showToast(2131719248);
      onError("sdcard full");
      return;
    }
    if (!QQRecorder.mw(localRecorderParam.mAudioType))
    {
      showToast(2131695039);
      onError("internal storage full");
      return;
    }
    if (localQQAppInterface.bF())
    {
      showToast(2131697385);
      onError("ppt play error on video chatting");
      return;
    }
    if (i == 2)
    {
      this.bvv = true;
      if (!aagl.a().c(localQQAppInterface)) {
        this.bvv = false;
      }
      if (!aagl.a().update(ih(str1))) {
        this.bvv = false;
      }
    }
    boolean bool2 = true;
    long l1 = zyn.getLong(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      bool1 = bool2;
      if (l1 > l2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "startRecord() is checkInPhone:" + paramBoolean + ",isInitSuccess:" + this.bvv + ",isServerAvailable:" + bool1 + ",redpkgType:" + i);
    }
    if ((!this.bvv) && (!bool1)) {
      onError(2, zyn.getString(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", BaseApplicationImpl.getContext().getResources().getString(2131697521)));
    }
    if (paramBoolean)
    {
      if (!this.bvv) {
        this.bvu = false;
      }
      this.bvw = false;
      if ((i != 2) || (!this.bvv)) {
        break label688;
      }
    }
    for (;;)
    {
      this.bvw = true;
      label687:
      label688:
      do
      {
        str1 = aojs.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
        String str2 = MessageForPtt.getLocalFilePath(localRecorderParam.mAudioType, str1);
        paramString = str1;
        if (str1 != null)
        {
          paramString = str1;
          if (!str1.equals(str2))
          {
            new File(str1).deleteOnExit();
            paramString = str2;
          }
        }
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(BaseApplication.getContext());
        }
        paramSessionInfo = ujt.a(localQQAppInterface, paramString, paramSessionInfo, -2, localRecorderParam.mAudioType);
        if (paramSessionInfo == null)
        {
          onError("messageRecord create is null");
          return;
          if (bool1) {
            break;
          }
          this.bvu = true;
          break;
        }
        if (i == 8)
        {
          c(1, paramSessionInfo);
          paramSessionInfo.voiceRedPacketFlag = 3;
          this.hT.put(paramSessionInfo, paramMessageForQQWalletMsg);
          localRecorderParam.mUserData = paramSessionInfo;
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.b(localRecorderParam);
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.start(paramString, true);
          paramSessionInfo = MediaPlayerManager.a(localQQAppInterface);
          if (paramSessionInfo != null) {
            paramSessionInfo.stop(true);
          }
          this.isCancel = false;
          this.cgE = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "startRecord() is called");
          }
        }
        else
        {
          if (this.bvu) {}
          for (i = 1;; i = 2)
          {
            paramSessionInfo.voiceRedPacketFlag = i;
            break;
          }
        }
        return;
      } while (i != 8);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, achq paramachq, long paramLong, byte[] paramArrayOfByte, String paramString, aojr paramaojr)
  {
    QQAppInterface localQQAppInterface;
    Object localObject1;
    Object localObject2;
    try
    {
      localQQAppInterface = aagd.getQQAppInterface();
      localObject1 = (aagm.b)this.eS.get();
      i = 0;
      if (localObject1 != null) {
        i = localObject1.hashCode();
      }
      if ((localQQAppInterface == null) || (paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForPtt)) || (localObject1 == null) || (((aagm.b)localObject1).isFinish()) || (this.isCancel) || (i != this.identify)) {
        return;
      }
      localObject2 = (MessageForPtt)paramMessageRecord;
      i = ((MessageForPtt)localObject2).voiceRedPacketFlag;
      localObject1 = (MessageForQQWalletMsg)this.hT.get(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "checkAndSend MessagemessageForPtt flag:" + i);
      }
      if (i == 1)
      {
        paramMessageRecord = (aagm.b)this.eS.get();
        if ((paramMessageRecord != null) && (!paramMessageRecord.isFinish())) {
          paramMessageRecord.ap(true, ((MessageForPtt)localObject2).getExtInfoFromExtStr("voice_score_id"));
        }
        d(n((MessageRecord)localObject2), (MessageRecord)localObject1);
        localQQAppInterface.b().a((MessageRecord)localObject2, paramachq);
        return;
      }
      if (i != 2) {
        break label307;
      }
      if ((localObject1 == null) || (((MessageForQQWalletMsg)localObject1).mQQWalletRedPacketMsg == null))
      {
        onError("MessageForQQWalletMsg is null");
        return;
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      onError(paramMessageRecord.toString());
      return;
    }
    int i = 0;
    if (((MessageForQQWalletMsg)localObject1).istroop == 1) {
      i = 1;
    }
    for (;;)
    {
      a(new aago(this, localQQAppInterface, (MessageForQQWalletMsg)localObject1, i, paramLong, paramArrayOfByte, paramString, (MessageForPtt)localObject2, paramaojr, paramachq));
      return;
      if (((MessageForQQWalletMsg)localObject1).istroop == 3000) {
        i = 2;
      }
    }
    label307:
    if (i == 3)
    {
      if (i(paramMessageRecord) == 1)
      {
        a(paramMessageRecord, paramLong, paramArrayOfByte, paramString);
        return;
      }
      if (i(paramMessageRecord) == 2)
      {
        paramMessageRecord = (MessageForPtt)paramMessageRecord;
        localObject2 = (aagm.d)this.iA.get(paramMessageRecord);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)this.hT.get(paramMessageRecord);
        if ((localMessageForQQWalletMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null))
        {
          onError("MessageForQQWalletMsg is null");
          return;
        }
        i = 0;
        if (localMessageForQQWalletMsg.istroop == 1) {
          i = 1;
        }
        for (;;)
        {
          a(new aagq(this, localMessageForQQWalletMsg, localQQAppInterface, i, (aagm.d)localObject2, paramLong, paramArrayOfByte, paramString, (MessageForQQWalletMsg)localObject1, paramMessageRecord, paramaojr, paramachq));
          return;
          int j = localMessageForQQWalletMsg.istroop;
          if (j == 3000) {
            i = 2;
          }
        }
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderPrepare() is called :" + this.bvw);
    }
    aqge.ce(2131230758, false);
    byte[] arrayOfByte = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    alid.nY(paramString);
    alid.a(paramString, arrayOfByte, arrayOfByte.length);
    paramString = (MessageForPtt)paramRecorderParam.mUserData;
    if (this.bvw)
    {
      this.byteArrayOutputStream = new ByteArrayOutputStream();
      if (paramString.voiceRedPacketFlag == 3)
      {
        paramString = new byte[QQRecorder.bytesInSecond(paramRecorderParam.mSampleRate, 2, 2) / 1000 * 200];
        Arrays.fill(paramString, (byte)0);
        this.byteArrayOutputStream.write(paramString, 0, paramString.length);
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderEnd() is called, isCancel:" + this.isCancel + "|" + this.cgE);
    }
    try
    {
      if (this.isCancel)
      {
        alid.Of(paramString);
        return;
      }
      localObject1 = (aagm.b)this.eS.get();
      if (localObject1 != null) {
        ((aagm.b)localObject1).csO();
      }
      alid.nZ(paramString);
      if (paramDouble < 500.0D)
      {
        showToast(2131690277);
        onError("record time too short");
        return;
      }
    }
    catch (Exception paramString)
    {
      onError(paramString.toString());
      paramString.printStackTrace();
      return;
    }
    if ((this.bvw) && (this.byteArrayOutputStream != null))
    {
      this.byteArrayOutputStream.flush();
      this.cy = this.byteArrayOutputStream.toByteArray();
      this.byteArrayOutputStream.reset();
    }
    Object localObject1 = (MessageForPtt)paramRecorderParam.mUserData;
    Object localObject2;
    boolean bool;
    int j;
    if (this.bvu)
    {
      localObject2 = (MessageForQQWalletMsg)this.hT.get(localObject1);
      localObject2 = a(this.cy, (MessageForQQWalletMsg)localObject2);
      bool = ((aagm.c)localObject2).bvx;
      if (bool) {
        d(((aagm.c)localObject2).bcY, (MessageRecord)localObject1);
      }
      localObject2 = (aagm.b)this.eS.get();
      if ((localObject2 == null) || (((aagm.b)localObject2).isFinish()) || (bool)) {
        break label679;
      }
      ((aagm.b)localObject2).ap(false, "");
      break label679;
      localObject2 = (MessageForQQWalletMsg)this.hT.get(localObject1);
      if (localObject2 == null)
      {
        onError("messageForQQWalletMsg is null!");
        return;
      }
      j = xvz.fm(((MessageForQQWalletMsg)localObject2).messageType);
      if (j == 8) {
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 0) {
          if (this.cgE == -1) {
            if (!aagd.aQ(BaseApplicationImpl.getContext())) {
              break label682;
            }
          }
        }
      }
    }
    label679:
    label682:
    for (int i = 1;; i = 0)
    {
      this.cgE = i;
      if ((this.cgE == 1) && (Build.VERSION.SDK_INT >= 18) && (!a(this.cy, this.bcW, paramString, paramRecorderParam)))
      {
        onError("mix song error!");
        return;
      }
      c(2, (MessageRecord)localObject1);
      for (;;)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = 3;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "isCheckInPhone:" + this.bvu + ",isRecognizedInPhone:" + bool + ",redpkgType:" + j + "songFlag:" + ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag);
        }
        if ((!bool) && (this.bvu)) {
          break;
        }
        localObject2 = aagd.getQQAppInterface();
        if ((localObject2 == null) || (this.sessionInfo == null) || (localObject1 == null)) {
          break;
        }
        ((MessageForPtt)localObject1).serial();
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", ((MessageForPtt)localObject1).vipBubbleDiyTextId);
        ujt.a((QQAppInterface)localObject2, this.sessionInfo.cZ, this.sessionInfo.aTl, paramString, ((MessageForPtt)localObject1).uniseq, false, (int)paramDouble, paramRecorderParam.mAudioType, true, 0, 5, true, ((MessageForPtt)localObject1).vipSubBubbleId, localBundle, null, null, false, (MessageRecord)localObject1, 0);
        paramString = (aagm.b)this.eS.get();
        if (paramString == null) {
          break;
        }
        this.identify = paramString.hashCode();
        return;
        if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.elem.songFlag == 1) {
          c(1, (MessageRecord)localObject1);
        }
      }
      if (this.bvu) {}
      for (i = 1;; i = 2)
      {
        ((MessageForPtt)localObject1).voiceRedPacketFlag = i;
        break;
      }
      bool = false;
      break;
      return;
      break;
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    onError("onRecorderError");
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    alid.a(paramString, paramArrayOfByte, paramInt1);
    paramString = (aagm.b)this.eS.get();
    if ((paramString != null) && (!paramString.isFinish())) {
      paramString.FH(AudioPanel.fc(paramInt2));
    }
  }
  
  public void as(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderNotReady() is called");
    }
  }
  
  public String b(float paramFloat)
  {
    int k = (int)(100.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cfdToScoreId:" + paramFloat + "|" + k);
    }
    Object localObject1 = aagd.getQQAppInterface();
    if (localObject1 != null)
    {
      localObject1 = (aaai)((QQAppInterface)localObject1).getManager(245);
      if (localObject1 != null)
      {
        localObject1 = ((aaai)localObject1).a("voice_pwd", new String[] { "scoreIdMap" });
        if (localObject1 == null) {}
      }
    }
    int i;
    int j;
    label313:
    label361:
    do
    {
      try
      {
        if (((JSONObject)localObject1).length() > 0)
        {
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator != null) {
            for (;;)
            {
              if (localIterator.hasNext())
              {
                String str2 = (String)localIterator.next();
                String str1 = ((JSONObject)localObject1).getString(str2);
                if (!str2.contains("-")) {
                  continue;
                }
                Object localObject2 = str2.split("-");
                if ((localObject2 == null) || (localObject2.length <= 0) || (localObject2.length > 2)) {
                  continue;
                }
                boolean bool = TextUtils.isEmpty(str1);
                if (bool) {
                  continue;
                }
                i = -2147483648;
                j = 2147483647;
                try
                {
                  if (localObject2.length == 1)
                  {
                    i = Integer.parseInt(localObject2[0].trim());
                    break label361;
                  }
                  if (localObject2.length == 2)
                  {
                    str2 = localObject2[0].trim();
                    localObject2 = localObject2[1].trim();
                    if (TextUtils.isEmpty(str2)) {}
                    for (;;)
                    {
                      j = Integer.parseInt((String)localObject2);
                      break;
                      i = Integer.parseInt(str2);
                    }
                  }
                }
                catch (Throwable localThrowable2)
                {
                  localThrowable2.printStackTrace();
                }
              }
            }
          }
        }
        if (k >= 65) {
          break label313;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      return "c";
      if (k < 70) {
        return "b";
      }
      if (k < 75) {
        return "a";
      }
      if (k < 80) {
        return "s";
      }
      if (k < 90) {
        return "ss";
      }
      return "sss";
    } while ((k < i) || (k > j));
    return localThrowable2;
  }
  
  public void b(aliv paramaliv, aliv.a parama)
  {
    if (((paramaliv instanceof WechatNsWrapper)) && (this.byteArrayOutputStream != null) && (parama != null) && (this.bvw)) {
      this.byteArrayOutputStream.write(parama.data, 0, parama.size);
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    onError(3, "onRecorderAbnormal");
  }
  
  public int bz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onRecorderStart() is called");
    }
    aagm.b localb = (aagm.b)this.eS.get();
    if (localb != null) {
      localb.csN();
    }
    return 250;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    onError(3, "onInitFailed");
  }
  
  public void cuf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "cancelRecord() is called");
    }
    this.isCancel = true;
    stopRecord();
  }
  
  public void cug()
  {
    this.clientTryTime = 0;
    this.serverTryTime = 0;
  }
  
  public void hB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "onInitSuccess() is called");
    }
  }
  
  public void onError(String paramString)
  {
    onError(1, paramString);
  }
  
  public void showToast(int paramInt)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    localQQAppInterface.runOnUiThread(new VoiceRedPacketHelper.1(this, localBaseApplication, paramInt, localBaseApplication.getResources().getDimensionPixelSize(2131299627)));
  }
  
  public void stopRecord()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceRedPacketHelper", 2, "stopRecord() is called");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.isStop())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.stop();
    }
  }
  
  public static abstract interface a
  {
    public abstract void zP(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void FH(int paramInt);
    
    public abstract void ap(boolean paramBoolean, String paramString);
    
    public abstract void bC(int paramInt, String paramString);
    
    public abstract void csN();
    
    public abstract void csO();
    
    public abstract boolean isFinish();
    
    public abstract int yu();
  }
  
  public static class c
  {
    public String bcY = "";
    public boolean bvx = false;
    float ro = 0.0F;
    
    public String toString()
    {
      return "RecogResult{isRecog=" + this.bvx + ", cfd=" + this.ro + ", scoreId='" + this.bcY + '\'' + '}';
    }
  }
  
  public static class d
  {
    public long fileId;
    public byte[] md5;
    public MessageRecord q;
    public String uuid;
    
    public d(MessageRecord paramMessageRecord, long paramLong, byte[] paramArrayOfByte, String paramString)
    {
      this.q = paramMessageRecord;
      this.fileId = paramLong;
      this.md5 = paramArrayOfByte;
      this.uuid = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagm
 * JD-Core Version:    0.7.0.1
 */