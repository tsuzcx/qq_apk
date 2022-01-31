import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class xoy
  extends BroadcastReceiver
{
  xoy(xot paramxot) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Xpa != null) && (!this.a.jdField_a_of_type_Xpa.a()))
      {
        this.a.b = true;
        wsv.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Xoz == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Xoz.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = alpo.a(2131704864);
      this.a.jdField_a_of_type_Xoz.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Xoz.a.onFinish(true);
      wsv.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = alpo.a(2131704863);
      this.a.jdField_a_of_type_Xoz.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Xoz.a.onFinish(false);
      wsv.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoy
 * JD-Core Version:    0.7.0.1
 */