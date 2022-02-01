import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

public class fus
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Thread jdField_a_of_type_JavaLangThread = null;
  private boolean jdField_a_of_type_Boolean = false;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = true;
  
  private fus(OnlineFileSessionCenter paramOnlineFileSessionCenter) {}
  
  public void a()
  {
    if (!a())
    {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make pump thread is  running!!!");
      return;
    }
    a(false);
    this.jdField_a_of_type_JavaLangThread = new Thread(new fut(this));
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  void a(boolean paramBoolean)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      b(true);
      this.jdField_a_of_type_JavaLangThread = null;
    }
  }
  
  void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  boolean b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fus
 * JD-Core Version:    0.7.0.1
 */