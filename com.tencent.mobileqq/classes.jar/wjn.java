import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class wjn
  extends wsd
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public wjr a;
  public final Object b;
  public AtomicBoolean b;
  
  public wjn()
  {
    this.jdField_a_of_type_Wjr = new wjr();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new wjq(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Wjr.b()) {
      d();
    }
    return this.jdField_a_of_type_Wjr.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      yuk.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    yuk.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Wjr);
    xdt localxdt = new xdt();
    wow.a().a(localxdt, new wjp(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bhml.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new wjo(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Wjr.a;
    }
    d();
    yuk.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        yuk.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Wjr;
        if (((wjr)???).a()) {
          return ((wjr)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          yuk.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    yuk.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((wjr)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Wjr.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Wjr.a;
      if (arrayOfByte != null) {
        return bhml.a(arrayOfByte);
      }
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjn
 * JD-Core Version:    0.7.0.1
 */