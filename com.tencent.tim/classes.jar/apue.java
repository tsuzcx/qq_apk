import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apue
{
  public static final void M(int paramInt1, int paramInt2, String paramString)
  {
    int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
    m("gfile", "gfile_upload_result", "" + paramInt1, "" + paramInt2, "" + i, paramString);
  }
  
  public static final void N(int paramInt1, int paramInt2, String paramString)
  {
    int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
    m("gfile", "gfile_download_result", "" + paramInt1, "" + paramInt2, "" + i, paramString);
  }
  
  public static final void ebQ()
  {
    m("gfile", "gfile_upload", "", "", "", "");
  }
  
  public static final void ebR()
  {
    m("gfile", "gfile_download", "", "", "", "");
  }
  
  public static final void jY(int paramInt1, int paramInt2)
  {
    int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
    m("gfile", "gfile_upload_result", "" + paramInt1, "" + paramInt2, "" + i, "");
  }
  
  public static final void jZ(int paramInt1, int paramInt2)
  {
    N(paramInt1, paramInt2, "");
  }
  
  public static final void m(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      anot.a((QQAppInterface)localObject, "dc00899", "Grp_tech_report", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("ReportTech", 2, "opType=" + paramString1 + ", opName=" + paramString2 + ", r1=" + paramString3 + ", r2=" + paramString4 + ",r3=" + paramString5 + ", r4" + paramString6);
      }
      return;
    }
  }
  
  public static final void m(String paramString, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ((paramVarArgs != null) && (paramVarArgs.length <= 4))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i];
        i += 1;
      }
    }
    m("page_exp", paramString, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
  }
  
  public static class a
  {
    public static int RESULT_SUCCESS;
    public static int dVY = 1;
    public static int dVZ = 2;
    public static int dWA = -36;
    public static int dWa = 3;
    public static int dWb = 1;
    public static int dWc = 2;
    public static int dWd = 3;
    public static int dWe = 4;
    public static int dWf = 5;
    public static int dWg = 6;
    public static int dWh = 7;
    public static int dWi = 8;
    public static int dWj = 101;
    public static int dWk = 102;
    public static int dWl = 103;
    public static int dWm = 104;
    public static int dWn = 105;
    public static int dWo = 106;
    public static int dWp = 107;
    public static int dWq = 108;
    public static int dWr = 109;
    public static int dWs = 111;
    public static int dWt = 112;
    public static int dWu = 113;
    public static int dWv = 114;
    public static int dWw = 100;
    public static int dWx = -99;
    public static int dWy = -98;
    public static int dWz = -97;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apue
 * JD-Core Version:    0.7.0.1
 */