import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class wag
  extends BroadcastReceiver
{
  wag(wab paramwab) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Wai != null) && (!this.a.jdField_a_of_type_Wai.a()))
      {
        this.a.b = true;
        ved.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Wah == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Wah.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = ajya.a(2131704492);
      this.a.jdField_a_of_type_Wah.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Wah.a.onFinish(true);
      ved.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = ajya.a(2131704491);
      this.a.jdField_a_of_type_Wah.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Wah.a.onFinish(false);
      ved.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wag
 * JD-Core Version:    0.7.0.1
 */