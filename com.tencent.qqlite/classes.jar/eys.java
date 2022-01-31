import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

public class eys
  extends Handler
{
  public static final int b = 0;
  public static final int c = 1;
  public int a;
  public HttpMsg a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean();
  
  public eys(HttpCommunicator paramHttpCommunicator, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, "requeustInterupt", "msgId:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ae + " thread id:" + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b.set(true);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.jdField_a_of_type_JavaNetHttpURLConnection != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
          getLooper().getThread().interrupt();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a(9361, 0, "preempted by higher msg");
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a().b(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    sendMessage(obtainMessage(0, paramHttpMsg));
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what == 0) {
      if ((???.obj != null) && ((???.obj instanceof HttpMsg)))
      {
        localHttpMsg = (HttpMsg)???.obj;
        if (localHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label179;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localHttpMsg, this, false);
        if (localHttpMsg.jdField_a_of_type_JavaLangObject != null) {
          localHttpMsg.c.set(true);
        }
      }
    }
    label179:
    while (???.what != 1)
    {
      synchronized (localHttpMsg.jdField_a_of_type_JavaLangObject)
      {
        HttpMsg localHttpMsg;
        localHttpMsg.jdField_a_of_type_JavaLangObject.notify();
        if (this.b.get())
        {
          getLooper().quit();
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      ???.obj = null;
      synchronized (HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator))
      {
        HttpCommunicator.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator);
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a("handleMsgFin thread index:" + this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      ???.obj = null;
      return;
    }
    getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eys
 * JD-Core Version:    0.7.0.1
 */