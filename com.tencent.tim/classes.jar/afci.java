import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class afci
  implements Manager
{
  private afdb jdField_a_of_type_Afdb;
  private afde jdField_a_of_type_Afde;
  private QQAppInterface app;
  private Object dy = new Object();
  private Object dz = new Object();
  
  public afci(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public afdb a()
  {
    if (this.jdField_a_of_type_Afdb != null) {
      return this.jdField_a_of_type_Afdb;
    }
    synchronized (this.dz)
    {
      if (this.jdField_a_of_type_Afdb == null) {
        this.jdField_a_of_type_Afdb = new afdb(this.app);
      }
      afdb localafdb = this.jdField_a_of_type_Afdb;
      return localafdb;
    }
  }
  
  public afde a()
  {
    if (this.jdField_a_of_type_Afde != null) {
      return this.jdField_a_of_type_Afde;
    }
    synchronized (this.dy)
    {
      if (this.jdField_a_of_type_Afde == null) {
        this.jdField_a_of_type_Afde = new afde(this.app);
      }
      afde localafde = this.jdField_a_of_type_Afde;
      return localafde;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Afde != null) {
      this.jdField_a_of_type_Afde.onDestroy();
    }
    this.jdField_a_of_type_Afde = null;
    if (this.jdField_a_of_type_Afdb != null)
    {
      this.jdField_a_of_type_Afdb.onDestroy();
      this.jdField_a_of_type_Afdb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afci
 * JD-Core Version:    0.7.0.1
 */