import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class uhz
  implements uni<vcd, vdo>
{
  uhz(uhx paramuhx) {}
  
  public void a(vcd arg1, vdo paramvdo, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.jdField_b_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_Uib = paramvdo.jdField_a_of_type_Uib;
        this.a.jdField_a_of_type_Uib.a();
        wsv.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_Uib);
        this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        paramvdo = finally;
        throw paramvdo;
        wsv.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhz
 * JD-Core Version:    0.7.0.1
 */