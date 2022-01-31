import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class uhx
  extends uqn
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public uib a;
  public final Object b;
  public AtomicBoolean b;
  
  public uhx()
  {
    this.jdField_a_of_type_Uib = new uib();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new uia(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Uib.b()) {
      d();
    }
    return this.jdField_a_of_type_Uib.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      wsv.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    wsv.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Uib);
    vcd localvcd = new vcd();
    ung.a().a(localvcd, new uhz(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bdcv.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new uhy(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Uib.a;
    }
    d();
    wsv.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        wsv.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Uib;
        if (((uib)???).a()) {
          return ((uib)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          wsv.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    wsv.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((uib)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Uib.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Uib.a;
      if (arrayOfByte != null) {
        return bdcv.a(arrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */