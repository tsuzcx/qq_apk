import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class zms
  extends BroadcastReceiver
{
  zms(zmn paramzmn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Zmu != null) && (!this.a.jdField_a_of_type_Zmu.a()))
      {
        this.a.b = true;
        yqp.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Zmt == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Zmt.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = anni.a(2131703273);
      this.a.jdField_a_of_type_Zmt.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Zmt.a.onFinish(true);
      yqp.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = anni.a(2131703272);
      this.a.jdField_a_of_type_Zmt.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Zmt.a.onFinish(false);
      yqp.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zms
 * JD-Core Version:    0.7.0.1
 */