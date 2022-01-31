import java.util.HashMap;
import java.util.Observable;

public class zqt
  extends Observable
{
  private static zqt a;
  public HashMap<String, String> a;
  
  public static zqt a()
  {
    if (jdField_a_of_type_Zqt == null) {}
    try
    {
      if (jdField_a_of_type_Zqt == null) {
        jdField_a_of_type_Zqt = new zqt();
      }
      return jdField_a_of_type_Zqt;
    }
    finally {}
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqt
 * JD-Core Version:    0.7.0.1
 */