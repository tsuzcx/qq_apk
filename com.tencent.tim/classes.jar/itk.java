import com.tencent.qphone.base.util.QLog;

final class itk
  extends jjx.a
{
  itk(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void onPostExecute(String paramString)
  {
    itj.a(null);
    if (QLog.isColorLevel()) {
      QLog.d("AVPushReport", 2, "onAvReportPush SimpleHttpPostTask rsp = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itk
 * JD-Core Version:    0.7.0.1
 */