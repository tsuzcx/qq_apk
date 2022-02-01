import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.CaptureAsyncAutomator;
import dov.com.qq.im.capture.control.CaptureAsyncStepFactory;

public class axpk
  implements anho
{
  public static boolean cAr;
  public static String cVE = "{1001,1004,1003,1005,1006,1007}";
  public static String cVF;
  public static boolean dvO = true;
  public static boolean dvP = true;
  public static boolean dvQ = true;
  public static boolean dvR;
  public CaptureAsyncAutomator b = new CaptureAsyncAutomator(null);
  
  public static boolean bR(boolean paramBoolean)
  {
    if (!dvQ) {}
    return false;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    cAr = true;
    if (!(paramVarArgs[0] instanceof String)) {}
    for (boolean bool = true;; bool = false)
    {
      dvR = bool;
      if (!dvR) {
        cVF = (String)paramVarArgs[0];
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CaptureAsyncControl", 2, new Object[] { "pre open camera, result: ", Boolean.valueOf(dvR) });
      return;
    }
  }
  
  public void adh(String paramString)
  {
    this.b.a(CaptureAsyncStepFactory.a(this.b, paramString));
  }
  
  public void aeC(int paramInt)
  {
    this.b.a(CaptureAsyncStepFactory.a(this.b, String.valueOf(paramInt)));
  }
  
  public void onDestroy()
  {
    this.b.onDestroy();
  }
  
  public void y(String paramString, Object[] paramArrayOfObject)
  {
    paramString = CaptureAsyncStepFactory.a(this.b, paramString);
    paramString.mParams = paramArrayOfObject;
    this.b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpk
 * JD-Core Version:    0.7.0.1
 */