import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.widget.MicroPhoneDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class hlc
  implements QQRecorder.OnQQRecorderListener
{
  public hlc(MicroPhoneDialog paramMicroPhoneDialog) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MicroPhoneRecord", 2, "onRecorderStart time=" + System.currentTimeMillis() + " thread[" + Thread.currentThread().getName() + "] path=" + paramString);
    }
    StreamDataManager.a(paramString, 0, (int)(System.currentTimeMillis() / 1000L));
    StreamDataManager.a(paramString, "#!AMR\n".getBytes(), "#!AMR\n".getBytes().length, (short)0);
    this.a.d();
    try
    {
      new VoicePlayer(this.a.jdField_a_of_type_AndroidContentContext, 2131165200).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.MicroPhone", 2, "play ptt_startrecord ok...");
      }
      Thread.sleep(200L);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    this.a.g = 0L;
    this.a.e = System.currentTimeMillis();
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    StreamDataManager.a(paramString, paramArrayOfByte, paramArrayOfByte.length, (short)0);
    Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 2;
    ((Message)localObject).arg1 = this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    long l = System.currentTimeMillis() - this.a.e;
    if (l >= 54940L)
    {
      if (l >= 59450L) {
        this.a.c();
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onRecorderSilceEnd maxAmplitude=").append(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()).append(" time=").append(System.currentTimeMillis()).append(" sliceData.len=");
      if (paramArrayOfByte != null) {
        break label256;
      }
    }
    label256:
    for (paramInt = 0;; paramInt = paramArrayOfByte.length)
    {
      QLog.d("MicroPhoneRecord", 2, paramInt + " path=" + paramString);
      return;
      int i = (int)Math.ceil((60000L - l) / 1000.0D);
      paramInt = i;
      if (i > 5000L) {
        paramInt = 5000;
      }
      if ((this.a.s == paramInt) || (this.a.f == 9223372036854775807L)) {
        break;
      }
      this.a.s = paramInt;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      break;
    }
  }
  
  public void b(String paramString) {}
  
  public void c(String paramString)
  {
    this.a.e();
    this.a.g = (System.currentTimeMillis() - this.a.e);
    if (QLog.isColorLevel()) {
      QLog.d("MicroPhoneRecord", 2, "onRecorderEnd time=" + System.currentTimeMillis() + " len=" + this.a.g + " path=" + paramString);
    }
    if (this.a.c)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
    }
    for (;;)
    {
      StreamDataManager.a(paramString);
      StreamDataManager.a(paramString);
      this.a.e = 9223372036854775807L;
      return;
      if (paramString != null)
      {
        File localFile = StreamDataManager.a(paramString);
        if ((localFile != null) && (localFile.exists()))
        {
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.MicroPhone", 2, "remove amr:" + paramString);
          }
        }
      }
      this.a.g = 0L;
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlc
 * JD-Core Version:    0.7.0.1
 */