import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class vlm
  extends vtt
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public vlq a;
  public final Object b;
  public AtomicBoolean b;
  
  public vlm()
  {
    this.jdField_a_of_type_Vlq = new vlq();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new vlp(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Vlq.b()) {
      d();
    }
    return this.jdField_a_of_type_Vlq.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      xvv.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    xvv.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Vlq);
    wfj localwfj = new wfj();
    vqn.a().a(localwfj, new vlo(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return HexUtil.bytes2HexStr(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new vln(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Vlq.a;
    }
    d();
    xvv.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        xvv.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Vlq;
        if (((vlq)???).a()) {
          return ((vlq)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          xvv.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    xvv.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((vlq)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Vlq.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Vlq.a;
      if (arrayOfByte != null) {
        return HexUtil.bytes2HexStr(arrayOfByte);
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
 * Qualified Name:     vlm
 * JD-Core Version:    0.7.0.1
 */