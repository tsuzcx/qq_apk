import com.tencent.mobileqq.utils.httputils.HttpCommunicator;

public class awqs
{
  private static aolm jdField_a_of_type_Aolm;
  private static aqoh jdField_a_of_type_Aqoh = new awqt();
  private static aqoh b = new awqu();
  private static aolm i;
  
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
  
  public static aolm d()
  {
    if (i == null) {}
    try
    {
      if (i == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(b, 128);
        localHttpCommunicator.start();
        i = new aomj(localHttpCommunicator, true);
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqs
 * JD-Core Version:    0.7.0.1
 */