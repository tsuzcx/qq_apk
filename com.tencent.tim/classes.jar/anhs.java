import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anhs
{
  private static volatile anhs jdField_a_of_type_Anhs;
  anht jdField_a_of_type_Anht = null;
  anhv jdField_a_of_type_Anhv = null;
  
  public static anhs a()
  {
    if (jdField_a_of_type_Anhs == null) {}
    try
    {
      if (jdField_a_of_type_Anhs == null)
      {
        anhs localanhs = new anhs();
        localanhs.init();
        jdField_a_of_type_Anhs = localanhs;
      }
      return jdField_a_of_type_Anhs;
    }
    finally {}
  }
  
  public static void aop()
  {
    anhs localanhs = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localanhs.jdField_a_of_type_Anhv.dGj) }));
    }
    anht.cu();
  }
  
  private void init()
  {
    this.jdField_a_of_type_Anhv = new anhv();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Anht = new anht();
    }
  }
  
  public void a(boolean paramBoolean, anhs.a parama)
  {
    this.jdField_a_of_type_Anhv.a(paramBoolean, parama);
  }
  
  public boolean axd()
  {
    return this.jdField_a_of_type_Anhv.axd();
  }
  
  public boolean isGestureEnable()
  {
    return this.jdField_a_of_type_Anhv.dGj == 1;
  }
  
  public boolean isGestureGameEnable()
  {
    return this.jdField_a_of_type_Anhv.axe();
  }
  
  public boolean ug()
  {
    return this.jdField_a_of_type_Anhv.ug();
  }
  
  public boolean uh()
  {
    return this.jdField_a_of_type_Anhv.uh();
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhs
 * JD-Core Version:    0.7.0.1
 */