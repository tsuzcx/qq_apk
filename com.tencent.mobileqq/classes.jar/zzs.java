import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class zzs
  extends Handler
{
  public zzs(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.jdField_a_of_type_Bbms.a(this.a.getString(2131625248));
        this.a.jdField_a_of_type_Bbms.d(2130848385);
        this.a.jdField_a_of_type_Bbms.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bbms == null) || (!this.a.jdField_a_of_type_Bbms.isShowing()));
    this.a.jdField_a_of_type_Bbms.cancel();
    this.a.jdField_a_of_type_Bbms.a(this.a.getString(2131625250));
    this.a.jdField_a_of_type_Bbms.c(true);
    this.a.jdField_a_of_type_Bbms.a(false);
    this.a.jdField_a_of_type_Bbms.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zzs
 * JD-Core Version:    0.7.0.1
 */