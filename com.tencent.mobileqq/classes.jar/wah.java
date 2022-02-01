import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class wah
  extends wio
{
  public long a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public wal a;
  public final Object b;
  public AtomicBoolean b;
  
  public wah()
  {
    this.jdField_a_of_type_Wal = new wal();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new wak(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Wal.b()) {
      d();
    }
    return this.jdField_a_of_type_Wal.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      ykq.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    ykq.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_Wal);
    wue localwue = new wue();
    wfi.a().a(localwue, new waj(this));
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
    Bosses.get().postJob(new wai(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_Wal.a;
    }
    d();
    ykq.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        ykq.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_Wal;
        if (((wal)???).a()) {
          return ((wal)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ykq.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    ykq.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((wal)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_Wal.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_Wal.a;
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
 * Qualified Name:     wah
 * JD-Core Version:    0.7.0.1
 */