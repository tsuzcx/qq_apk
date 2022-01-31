import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xth
  extends BroadcastReceiver
{
  xth(xtc paramxtc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Xtj != null) && (!this.a.jdField_a_of_type_Xtj.a()))
      {
        this.a.b = true;
        wxe.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Xti == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Xti.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = alud.a(2131704876);
      this.a.jdField_a_of_type_Xti.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Xti.a.onFinish(true);
      wxe.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = alud.a(2131704875);
      this.a.jdField_a_of_type_Xti.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Xti.a.onFinish(false);
      wxe.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xth
 * JD-Core Version:    0.7.0.1
 */