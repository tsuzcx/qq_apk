import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class rqf
  extends BroadcastReceiver
{
  rqf(rqa paramrqa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      if ((this.this$0.jdField_a_of_type_Rqh != null) && (!this.this$0.jdField_a_of_type_Rqh.LU()))
      {
        this.this$0.aJm = true;
        ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("android.intent.action.SCREEN_ON")) || (!this.this$0.aJm));
      this.this$0.aJm = false;
    } while ((this.this$0.jdField_a_of_type_Rqg == null) || (this.this$0.bub == -9999) || (this.this$0.jdField_a_of_type_Rqg.d == null));
    if (this.this$0.bub == 1)
    {
      paramContext = acfp.m(2131706203);
      this.this$0.jdField_a_of_type_Rqg.d.onSuccess(paramContext);
      this.this$0.jdField_a_of_type_Rqg.d.onFinish(true);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
    for (;;)
    {
      this.this$0.bub = -9999;
      return;
      paramContext = acfp.m(2131706202);
      this.this$0.jdField_a_of_type_Rqg.d.onFailure(paramContext);
      this.this$0.jdField_a_of_type_Rqg.d.onFinish(false);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqf
 * JD-Core Version:    0.7.0.1
 */