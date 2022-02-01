import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class wjp
  implements woy<xdt, xfe>
{
  wjp(wjn paramwjn) {}
  
  public void a(xdt arg1, xfe paramxfe, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.jdField_b_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_Wjr = paramxfe.jdField_a_of_type_Wjr;
        this.a.jdField_a_of_type_Wjr.a();
        yuk.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_Wjr);
        this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        paramxfe = finally;
        throw paramxfe;
        yuk.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjp
 * JD-Core Version:    0.7.0.1
 */