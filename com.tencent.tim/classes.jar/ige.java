import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class ige
{
  private static aolm jdField_a_of_type_Aolm;
  private static aqoh jdField_a_of_type_Aqoh = new igf();
  
  public static aolm a()
  {
    if (jdField_a_of_type_Aolm == null) {}
    try
    {
      if (jdField_a_of_type_Aolm == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_Aqoh, 128);
        localHttpCommunicator.start();
        jdField_a_of_type_Aolm = new aomj(localHttpCommunicator, true);
      }
      return jdField_a_of_type_Aolm;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ige
 * JD-Core Version:    0.7.0.1
 */