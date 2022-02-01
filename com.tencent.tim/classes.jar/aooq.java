import java.util.HashMap;

public class aooq
  extends aoji
{
  public aooq(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.apr = ((aool.c)this.h.en).dQO;
  }
  
  void dWv()
  {
    String str = this.h.cmo;
    aoll localaoll = new aoll();
    localaoll.jdField_f_of_type_Aolm$b = this;
    localaoll.bZ = str;
    localaoll.mHttpMethod = 0;
    localaoll.jdField_f_of_type_JavaIoOutputStream = this.h.mOut;
    localaoll.atY = this.h.clR;
    localaoll.mMsgId = String.valueOf(this.h.mUniseq);
    localaoll.dPG = this.h.mUinType;
    localaoll.mFileType = this.h.mFileType;
    localaoll.apS = this.apr;
    localaoll.u.put("Accept-Encoding", "identity");
    localaoll.dPo = this.h.dPo;
    if (this.h.cNB)
    {
      localaoll.u.put("Range", "bytes=" + localaoll.apS + "-");
      localaoll.a = b;
    }
    localaoll.mContinuErrorLimit = 4;
    localaoll.mExcuteTimeLimit = 90000L;
    hM("httpDown", " url:" + str + ",downOffset:" + localaoll.apS);
    this.c.a(localaoll);
  }
  
  void onError()
  {
    super.onError();
    this.a.oy(aooi.a(this.h));
    aoom localaoom = this.h.a;
    if (localaoom != null)
    {
      localaoom.mResult = -1;
      localaoom.aqr = this.errCode;
      localaoom.clO = this.errDesc;
      localaoom.i = this.h;
    }
    try
    {
      hM("notify", "start");
      notifyAll();
      hM("notify", "end");
      return;
    }
    finally {}
  }
  
  public void onResp(aomh paramaomh)
  {
    super.onResp(paramaomh);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramaomh.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      hM("onHttpResp", bool);
      this.apr += paramaomh.apW;
      if (paramaomh.mResult != 0) {
        break;
      }
      onSuccess();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    aoom localaoom = this.h.a;
    this.a.oy(aooi.a(this.h));
    if (localaoom != null)
    {
      localaoom.mResult = 0;
      localaoom.i = this.h;
    }
    try
    {
      hM("notify", "start");
      notifyAll();
      hM("notify", "end");
      return;
    }
    finally {}
  }
  
  public void start()
  {
    dWv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooq
 * JD-Core Version:    0.7.0.1
 */