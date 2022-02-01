import com.tencent.mobileqq.qipc.QIPCModule;

public class anjy
{
  private static volatile anjy jdField_a_of_type_Anjy;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new anjz(this, "Module_VideoPlayIPCServer");
  
  public static anjy a()
  {
    if (jdField_a_of_type_Anjy == null) {}
    try
    {
      if (jdField_a_of_type_Anjy == null) {
        jdField_a_of_type_Anjy = new anjy();
      }
      return jdField_a_of_type_Anjy;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjy
 * JD-Core Version:    0.7.0.1
 */