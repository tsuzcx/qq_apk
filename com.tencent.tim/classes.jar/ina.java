import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ina
{
  private static volatile ina jdField_a_of_type_Ina;
  inb jdField_a_of_type_Inb = null;
  ind jdField_a_of_type_Ind = null;
  
  public static ina a()
  {
    if (jdField_a_of_type_Ina == null) {}
    try
    {
      if (jdField_a_of_type_Ina == null)
      {
        ina localina = new ina();
        localina.init();
        jdField_a_of_type_Ina = localina;
      }
      return jdField_a_of_type_Ina;
    }
    finally {}
  }
  
  public static void aop()
  {
    ina localina = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(localina.jdField_a_of_type_Inb.aqm) }));
    }
    ind.cu();
  }
  
  private void init()
  {
    this.jdField_a_of_type_Inb = new inb();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Ind = new ind();
    }
  }
  
  public static boolean uf()
  {
    return jdField_a_of_type_Ina != null;
  }
  
  public boolean ug()
  {
    return this.jdField_a_of_type_Inb.ug();
  }
  
  public boolean uh()
  {
    return this.jdField_a_of_type_Inb.uh();
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ina
 * JD-Core Version:    0.7.0.1
 */