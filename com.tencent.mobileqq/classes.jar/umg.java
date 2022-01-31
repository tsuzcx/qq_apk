import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class umg
  extends uuw
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public umk a;
  public final Object b;
  public AtomicBoolean b;
  
  public umg()
  {
    this.jdField_a_of_type_Umk = new umk();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new umj(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Umk.b()) {
      d();
    }
    return this.jdField_a_of_type_Umk.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      wxe.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    wxe.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Umk);
    vgm localvgm = new vgm();
    urp.a().a(localvgm, new umi(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return bdhe.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new umh(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Umk.a;
    }
    d();
    wxe.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        wxe.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Umk;
        if (((umk)???).a()) {
          return ((umk)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          wxe.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    wxe.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((umk)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Umk.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Umk.a;
      if (arrayOfByte != null) {
        return bdhe.a(arrayOfByte);
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
 * Qualified Name:     umg
 * JD-Core Version:    0.7.0.1
 */