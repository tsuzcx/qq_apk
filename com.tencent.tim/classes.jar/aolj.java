import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpInterfaceForTVK;
import com.tencent.qphone.base.util.BaseApplication;
import java.security.InvalidParameterException;
import java.util.HashMap;

public class aolj
  extends HttpInterfaceForTVK
{
  private aolj.a a = new aolj.a(null);
  private boolean cMF;
  public String clO;
  public int dPy;
  private int errorCode;
  private Object obj = new Object();
  private int result;
  
  public int aa(String arg1, String paramString2)
  {
    this.cMF = false;
    if ((??? == null) || (paramString2 == null)) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpInterfaceForTVKImp", 0, "downLoadSync, url = " + ??? + ", filePath = " + paramString2);
    }
    aoll localaoll;
    try
    {
      localaoll = new aoll();
      localaoll.f = this.a;
      localaoll.bZ = ???;
      localaoll.mHttpMethod = 0;
      localaoll.atY = paramString2;
      localaoll.mMsgId = String.valueOf(System.currentTimeMillis());
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (!(??? instanceof QQAppInterface)) {
        throw new InvalidParameterException("can't get AppInterface");
      }
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 1", ???);
      }
    }
    for (;;)
    {
      synchronized (this.obj)
      {
        try
        {
          if (!this.cMF)
          {
            this.obj.wait(600000L);
            continue;
          }
          ???.put("param_isSuccess", "1");
        }
        catch (InterruptedException paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 2", paramString2);
          }
          ??? = new HashMap();
          if (this.result != 0) {
            break label289;
          }
        }
        ???.put("param_ErrorCode", String.valueOf(this.errorCode));
        ???.put("param_ErrDesc", this.clO);
        ???.put("param_HttpCode", String.valueOf(this.dPy));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "HttpInterfaceForTVKImp", true, 0L, 0L, ???, "");
        return this.result;
        ((QQAppInterface)???).getNetEngine(0).a(localaoll);
      }
      label289:
      ???.put("param_isSuccess", "0");
    }
  }
  
  class a
    implements aolm.b
  {
    private a() {}
    
    public void onResp(aomh paramaomh)
    {
      synchronized (aolj.a(aolj.this))
      {
        aolj.a(aolj.this, paramaomh.mResult);
        aolj.b(aolj.this, paramaomh.mErrCode);
        aolj.this.clO = paramaomh.clO;
        aolj.this.dPy = paramaomh.dPy;
        aolj.a(aolj.this, true);
        if (QLog.isColorLevel()) {
          QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + aolj.a(aolj.this) + " , errorCode = " + aolj.b(aolj.this) + " , mErrDesc = " + aolj.this.clO + " , mHttpCode = " + aolj.this.dPy);
        }
        aolj.a(aolj.this).notify();
        return;
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolj
 * JD-Core Version:    0.7.0.1
 */