import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aond
  extends aoji
{
  private ArrayList<String> Br;
  private int dQn;
  private int dQo;
  MessageForScribble e;
  String url = "";
  
  public aond(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  private void dWc()
  {
    if (this.e == null) {
      return;
    }
    String str = amjg.calcMD5(this.h.clR);
    if (str.equalsIgnoreCase(this.e.combineFileMd5))
    {
      if (this.e != null) {
        this.e.mExistInfo.mCombineFileExist = true;
      }
      int i = amjb.d(this.e);
      if (i == amjb.RESULT_SUCCESS)
      {
        if (this.e != null)
        {
          this.e.mExistInfo.mDataFileExist = true;
          this.e.mExistInfo.mInit = true;
        }
        onSuccess();
        return;
      }
      if (this.e != null)
      {
        this.e.mExistInfo.mDataFileExist = false;
        this.e.mExistInfo.mInit = true;
      }
      dN(9303, f(new Exception("SpliteCombineFile illegal result: " + i)));
      onError();
      return;
    }
    if (this.e != null)
    {
      this.e.mExistInfo.mDataFileExist = false;
      this.e.mExistInfo.mCombineFileExist = false;
      this.e.mExistInfo.mInit = true;
    }
    dN(9041, f(new Exception("SpliteCombineFile illegal md5String: " + str + "  msg.combineFileMd5:  " + this.e.combineFileMd5)));
    onError();
  }
  
  private void f(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.app.b().c(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribblePicDownloadProcessor", 2, "resume()");
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      this.errCode = 0;
      this.errDesc = "";
      this.jdField_a_of_type_Aojm.a.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int KH()
  {
    super.KH();
    hM("uiParam", this.h.toString());
    if ((this.h.F != null) && ((this.h.F instanceof MessageForScribble)))
    {
      this.e = ((MessageForScribble)this.h.F);
      this.url = this.e.combineFileUrl;
    }
    if ((this.e == null) || (this.e.combineFileUrl.equals("")) || (!this.e.combineFileUrl.startsWith("http")))
    {
      dN(9302, f(new Exception("combineFileUrl illegal " + this.url)));
      onError();
      return -1;
    }
    this.h.clR = amjb.a(this.e);
    if (TextUtils.isEmpty(this.h.clR))
    {
      dN(9302, f(new Exception("combineFileMd5 illegal " + this.e.combineFileMd5)));
      onError();
      return -1;
    }
    return 0;
  }
  
  public void dVr()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.b.dVf();
    String str1 = this.url;
    VR(2001);
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = str1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = this.h.clR;
    localaoll.mMsgId = String.valueOf(this.h.mUniseq);
    localaoll.dPG = this.h.mUinType;
    localaoll.mFileType = this.h.mFileType;
    localaoll.apS = 0L;
    localaoll.cMU = true;
    localaoll.cMV = true;
    String str2;
    if ((this.Br != null) && (!this.Br.isEmpty()) && (this.dQn < this.Br.size()))
    {
      str2 = (String)this.Br.get(this.dQn);
      str2 = aopd.bK(localaoll.bZ, str2);
      if ((str2 != null) && (!str2.equals(localaoll.bZ))) {
        localaoll.bZ = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        anot.a(this.app, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = aonc.ow(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localaoll.bZ + " uuid:" + this.h.cmo + " downOffset:" + localaoll.apS);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.dQn + str1);
        if (azR()) {
          break;
        }
        return;
        anot.a(this.app, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Aomg = localaoll;
      dVe();
      this.c.a(localaoll);
      return;
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.e != null) {
      this.e.fileDownloadStatus = 2;
    }
    f(this.e);
    VR(2005);
    amja localamja = this.app.a();
    if (localamja != null)
    {
      if (this.e == null) {
        break label93;
      }
      localamja.a(this.e);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label93:
      localamja.a(null);
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    super.onResp(paramaomh);
    this.jdField_a_of_type_Aomg = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramaomh.mResult == 0)
    {
      bool = true;
      hM("onHttpResp", bool);
      localObject = this.b;
      if (paramaomh.mResult != 0) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      a((aojn.a)localObject, paramaomh, bool);
      this.apq = paramaomh.apU;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + paramaomh.mResult);
      if (paramaomh.mResult != 0) {
        break label184;
      }
      if (this.e != null) {
        this.e.mExistInfo.mCombineFileExist = true;
      }
      dWc();
      return;
      bool = false;
      break;
    }
    label184:
    if (this.e != null)
    {
      this.e.mExistInfo.mCombineFileExist = false;
      this.e.mExistInfo.mDataFileExist = false;
      this.e.mExistInfo.mInit = true;
    }
    if (this.dQo < 5)
    {
      this.dQo += 1;
      if ((this.Br != null) && (!this.Br.isEmpty()) && (this.dQn < this.Br.size()))
      {
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry by changeIp");
        dVd();
        paramaomh = aopd.getHostFromUrl(this.url);
        aopd.a().X(paramaomh, (String)this.Br.get(this.dQn), 1018);
        this.dQn += 1;
        dVr();
        return;
      }
      if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
      {
        hM("[netChg]", "failed.but net change detect.so retry");
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry");
        this.dOY += 1;
        dVd();
        dVr();
        return;
      }
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.e != null) {
      this.e.fileDownloadStatus = 1;
    }
    f(this.e);
    VR(2003);
    amja localamja = this.app.a();
    if (localamja != null)
    {
      if (this.e == null) {
        break label93;
      }
      localamja.a(this.e);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label93:
      localamja.a(null);
    }
  }
  
  public void start()
  {
    super.start();
    if (this.e != null) {
      this.e.fileDownloadStatus = 3;
    }
    String str;
    if ((this.url != null) && (!this.url.startsWith("https")))
    {
      str = aopd.getHostFromUrl(this.url);
      this.Br = aopd.a().a(str, 1018);
    }
    if ((this.Br != null) && (!this.Br.isEmpty()))
    {
      str = "ipListFromInnerDns : ";
      int i = 0;
      while (i < this.Br.size())
      {
        str = str + " " + (String)this.Br.get(i);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScribblePicDownloadProcessor", 2, str);
      }
    }
    anot.a(this.app, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
    dVr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aond
 * JD-Core Version:    0.7.0.1
 */