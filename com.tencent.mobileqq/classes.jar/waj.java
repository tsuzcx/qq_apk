import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class waj
  implements wfk<wue, wvp>
{
  waj(wah paramwah) {}
  
  public void a(wue arg1, wvp paramwvp, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.jdField_b_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_Wal = paramwvp.jdField_a_of_type_Wal;
        this.a.jdField_a_of_type_Wal.a();
        ykq.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_Wal);
        this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        paramwvp = finally;
        throw paramwvp;
        ykq.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */