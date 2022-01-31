import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class waj
  extends BroadcastReceiver
{
  waj(wae paramwae) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Wal != null) && (!this.a.jdField_a_of_type_Wal.a()))
      {
        this.a.b = true;
        veg.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Wak == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Wak.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = ajyc.a(2131704481);
      this.a.jdField_a_of_type_Wak.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Wak.a.onFinish(true);
      veg.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = ajyc.a(2131704480);
      this.a.jdField_a_of_type_Wak.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Wak.a.onFinish(false);
      veg.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */