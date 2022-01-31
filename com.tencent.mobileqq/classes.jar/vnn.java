import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class vnn
  extends BroadcastReceiver
{
  vnn(vni paramvni) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.a.jdField_a_of_type_Vnp != null) && (!this.a.jdField_a_of_type_Vnp.a()))
      {
        this.a.b = true;
        urk.d("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.a.b));
      this.a.b = false;
    } while ((this.a.jdField_a_of_type_Vno == null) || (this.a.jdField_a_of_type_Int == -9999) || (this.a.jdField_a_of_type_Vno.a == null));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramContext = ajjy.a(2131638696);
      this.a.jdField_a_of_type_Vno.a.onSuccess(paramContext);
      this.a.jdField_a_of_type_Vno.a.onFinish(true);
      urk.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -9999;
      return;
      paramContext = ajjy.a(2131638695);
      this.a.jdField_a_of_type_Vno.a.onFailure(paramContext);
      this.a.jdField_a_of_type_Vno.a.onFinish(false);
      urk.d("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */