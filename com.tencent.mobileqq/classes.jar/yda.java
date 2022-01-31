import android.os.Handler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.richmedia.conn.HostInfo;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class yda
{
  public int a;
  public long a;
  public Handler a;
  public INetInfoHandler a;
  public HostInfo a;
  public Thread a;
  public WeakReference a;
  public HashMap a;
  public ycd a;
  public boolean a;
  public int b = 0;
  public long b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public int e;
  
  public yda()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    ((PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0)).b();
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    if (this.jdField_a_of_type_Ycd != null)
    {
      this.jdField_a_of_type_Ycd.a();
      this.jdField_a_of_type_Ycd = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yda
 * JD-Core Version:    0.7.0.1
 */