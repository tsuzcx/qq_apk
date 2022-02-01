import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class wfs
  extends woi
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public wfw a;
  public final Object b;
  public AtomicBoolean b;
  
  public wfs()
  {
    this.jdField_a_of_type_Wfw = new wfw();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new wfv(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Wfw.b()) {
      d();
    }
    return this.jdField_a_of_type_Wfw.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      yqp.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    yqp.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Wfw);
    wzy localwzy = new wzy();
    wlb.a().a(localwzy, new wfu(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bgmj.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new wft(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Wfw.a;
    }
    d();
    yqp.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        yqp.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Wfw;
        if (((wfw)???).a()) {
          return ((wfw)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          yqp.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    yqp.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((wfw)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Wfw.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Wfw.a;
      if (arrayOfByte != null) {
        return bgmj.a(arrayOfByte);
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
 * Qualified Name:     wfs
 * JD-Core Version:    0.7.0.1
 */