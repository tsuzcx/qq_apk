import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class iwd
{
  private static volatile iwd jdField_a_of_type_Iwd;
  iwe jdField_a_of_type_Iwe = null;
  iwg jdField_a_of_type_Iwg = null;
  
  public static iwd a()
  {
    if (jdField_a_of_type_Iwd == null) {}
    try
    {
      if (jdField_a_of_type_Iwd == null)
      {
        iwd localiwd = new iwd();
        localiwd.init();
        jdField_a_of_type_Iwd = localiwd;
      }
      return jdField_a_of_type_Iwd;
    }
    finally {}
  }
  
  public static void aop()
  {
    iwd localiwd = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("onDownloadRequest, mStatusSo[%s]", new Object[] { Integer.valueOf(localiwd.jdField_a_of_type_Iwg.auQ) }));
    }
    iwe.cu();
  }
  
  private void init()
  {
    this.jdField_a_of_type_Iwg = new iwg();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Iwe = new iwe();
    }
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_Iwg.a();
  }
  
  public boolean ug()
  {
    return this.jdField_a_of_type_Iwg.ug();
  }
  
  public boolean uh()
  {
    return this.jdField_a_of_type_Iwg.uh();
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwd
 * JD-Core Version:    0.7.0.1
 */