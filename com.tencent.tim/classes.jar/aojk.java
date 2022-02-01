import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class aojk
  extends aojr
  implements ambj.a, Handler.Callback
{
  protected akwt.a a;
  Handler handler = new auru(Looper.getMainLooper(), this);
  
  public aojk(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.a = akwt.a(paramaool.F, paramaool);
  }
  
  private void dUX()
  {
    if (azO())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "handleQuickSendFailed:" + b());
      }
      aoop.a(b(), 65537, null, null).downloadImediatly();
    }
  }
  
  protected int KJ()
  {
    switch (this.h.mBusiType)
    {
    default: 
      return 0;
    case 1008: 
      return 2;
    case 1007: 
      return 3;
    case 1009: 
    case 1031: 
      return 4;
    case 1006: 
      return 5;
    case 1027: 
      return 6;
    case 1034: 
      return 7;
    case 1037: 
      return 8;
    }
    return 9;
  }
  
  public void O(boolean paramBoolean, long paramLong) {}
  
  protected void QU(boolean paramBoolean)
  {
    HashMap localHashMap;
    if ((this.a != null) && (!this.a.cuK))
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label90;
      }
    }
    label90:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      if (this.h.mBusiType == 1042) {
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, aojn.a parama)
  {
    super.a(paramInt, paramString1, paramString2, parama);
    aopa.a(this.h.F, paramInt, paramString1, paramString2);
  }
  
  protected void a(aoql.a.i parami)
  {
    if ((this.a != null) && (!this.a.cuK))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "changeRequest,file Size:" + parami.fileSize + " md5:" + parami.md5 + " busiType:" + this.h.mBusiType + " quickSendObject:" + this.a);
      }
      parami.fileSize = this.a.aex;
      parami.md5 = aqhs.hexStr2Bytes(this.a.bUA);
      if (this.h.mBusiType == 1042) {
        parami.dRm = 1;
      }
    }
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.handler.removeMessages(-255);
  }
  
  public int[] ad()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)this.mFileSize);
    arrayOfInt[1] = avfp.fR(this.h.dQ);
    arrayOfInt[2] = this.mWidth;
    arrayOfInt[3] = this.mHeight;
    arrayOfInt[4] = 0;
    int i = aqhu.fg(this.h.dQ);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.mHeight;
      arrayOfInt[3] = this.mWidth;
    }
    com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 1, "rotateDegree : " + i + ", params[2] : " + arrayOfInt[2] + " params[3] : " + arrayOfInt[3]);
    return arrayOfInt;
  }
  
  public void au(MessageRecord paramMessageRecord)
  {
    VR(1003);
  }
  
  protected boolean azN()
  {
    if (this.h.cNC)
    {
      dN(9333, "Server MD5 fast forward missed");
      onError();
      return false;
    }
    if ((this.a != null) && (!this.a.cuK))
    {
      this.a.cuK = true;
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
      }
      sendRequest();
      return false;
    }
    return true;
  }
  
  protected boolean azO()
  {
    MessageForPic localMessageForPic = b();
    return (localMessageForPic != null) && (localMessageForPic.imageType == 2000);
  }
  
  protected MessageForPic b()
  {
    Object localObject = this.h.F;
    if ((localObject instanceof MessageForPic)) {
      localObject = (MessageForPic)localObject;
    }
    MessageForPic localMessageForPic;
    do
    {
      return localObject;
      if (!(localObject instanceof MessageForStructing)) {
        break;
      }
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break;
      }
      localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
      if (localObject == null) {
        break;
      }
      localMessageForPic = ((ansu)localObject).j;
      localObject = localMessageForPic;
    } while (localMessageForPic != null);
    return null;
  }
  
  protected boolean bt(boolean paramBoolean)
  {
    if ((this.bL == null) && (!azT()))
    {
      dN(9041, "No Local MD5");
      onError();
      return false;
    }
    if ((paramBoolean) && ((this.mHeight == 0) || (this.mWidth == 0)))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      aqhu.d(this.h.dQ, localOptions);
      this.mHeight = localOptions.outHeight;
      this.mWidth = localOptions.outWidth;
      Object localObject = this.h.en;
      if ((localObject != null) && ((localObject instanceof aool.d)) && (((aool.d)localObject).cNJ) && (aonc.qi(this.h.dQ)))
      {
        this.mHeight = localOptions.outWidth;
        this.mWidth = localOptions.outHeight;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          hM("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mWidth = " + this.mWidth + ",mHeight = " + this.mHeight);
        }
      }
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.h.dQ, "r");
        if (this.mRaf == null)
        {
          dN(9303, "read file error");
          onError();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    if (((this.h.F instanceof MessageForPic)) && ((this.mHeight > 30000) || (this.mWidth > 30000) || (this.mWidth * this.mHeight > 200000000)))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "checkFileStandard fail，mHeight:" + this.mHeight + " mWidth:" + this.mWidth);
      }
      dN(90632, "PicOverStandard");
      onError();
      return false;
    }
    return true;
  }
  
  protected int c(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (xkl.a(paramMessageForPic)) {
      i = 5;
    }
    for (;;)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "getPicSourceReport:" + this.h.mBusiType + " source:" + i);
      }
      return i;
      switch (this.h.mBusiType)
      {
      default: 
        break;
      case 1009: 
      case 1031: 
      case 1048: 
        i = 4;
        break;
      case 1052: 
        i = 2;
        break;
      case 1050: 
        i = 1;
        break;
      case 1051: 
        i = 3;
        break;
      case 1053: 
        i = 7;
      }
    }
  }
  
  public int cancel()
  {
    if (this.a != null) {
      dUX();
    }
    return super.cancel();
  }
  
  protected void dUV()
  {
    if ((this.a != null) && (!this.a.cuK))
    {
      this.mFileSize = this.a.aex;
      this.clf = this.a.bUA;
      this.bL = aqhs.hexStr2Bytes(this.clf);
      if (getClass().equals(aokv.class)) {
        this.mFileName = (this.clf + "." + this.clg);
      }
    }
  }
  
  protected void dUW()
  {
    try
    {
      if ((!ahwy.a().aoj()) && (!ahwy.a().aol()) && (!ahwy.a().aok()))
      {
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "a , s close !");
        }
      }
      else if ((this.h != null) && (this.h.F != null) && ((this.h.F instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = ahwo.a(this.h.dQ);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.h.F).msgCtrl = localMsgCtrl;
          this.mM.put("param_amc", "1");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    super.doReport(paramBoolean);
    if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {}
    while (ConfigManager.mUseHardCodeIp != 1) {
      return;
    }
    anow.report("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.mM.get("serverip"));
    ConfigManager.mUseHardCodeIp = 0;
  }
  
  protected void f(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.mFileName;
    if (this.mResid == null) {}
    for (String str1 = this.mUuid;; str1 = this.mResid)
    {
      a("actRichMediaNetMonitor_picUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.b.status < 1002) {
      VR(1002);
    }
    return true;
  }
  
  void onError()
  {
    super.onError();
    if ((this.a != null) && (this.a.cuK)) {
      dUX();
    }
    this.handler.removeMessages(-255);
    if (this.h != null)
    {
      if (!ajdg.aH(this.h.F)) {
        break label67;
      }
      ajdg.fc(String.valueOf(this.errCode), 3);
    }
    label67:
    while (!ajdg.aG(this.h.F)) {
      return;
    }
    ajdg.fc(String.valueOf(this.errCode), 2);
  }
  
  void onSuccess()
  {
    Object localObject2 = null;
    super.onSuccess();
    this.handler.removeMessages(-255);
    if (this.a != null)
    {
      localObject1 = this.a.bUA;
      if (this.a.cuK) {
        break label235;
      }
      if (localObject1 != null)
      {
        localObject1 = aoop.b((String)localObject1, 65537);
        if (localObject1 == null) {
          break label262;
        }
      }
    }
    label262:
    for (Object localObject1 = ((URL)localObject1).toString();; localObject1 = null)
    {
      if (!aoiz.hasFile((String)localObject1))
      {
        String str = aoiz.getFilePath((String)localObject1);
        if (!azO()) {
          break label182;
        }
        localObject1 = this.h.dQ;
        boolean bool = aqhq.copyFile((String)localObject1, str);
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "quick send copy file:" + this.h.dQ + " to:" + str + " ret:" + bool);
        }
      }
      label155:
      if (this.h != null)
      {
        if (!ajdg.aH(this.h.F)) {
          break label242;
        }
        ajdg.fc("0", 3);
      }
      label182:
      label235:
      label242:
      while (!ajdg.aG(this.h.F))
      {
        return;
        URL localURL = aoop.b(this.a.bUA, 65537);
        localObject1 = localObject2;
        if (localURL != null) {
          localObject1 = localURL.toString();
        }
        if (aoiz.hasFile((String)localObject1))
        {
          localObject1 = aoiz.getFilePath((String)localObject1);
          break;
        }
        localObject1 = this.h.dQ;
        break;
        dUX();
        break label155;
      }
      ajdg.fc("0", 2);
      return;
    }
  }
  
  public void pause()
  {
    this.handler.removeMessages(-255);
  }
  
  protected void sendRequest() {}
  
  public void start()
  {
    super.start();
    this.handler.sendEmptyMessageDelayed(-255, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojk
 * JD-Core Version:    0.7.0.1
 */