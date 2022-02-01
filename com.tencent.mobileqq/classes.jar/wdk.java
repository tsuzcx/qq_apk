import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;

public class wdk
  implements FFmpegExecuteResponseCallback
{
  private wdl jdField_a_of_type_Wdl;
  
  public wdk(wdj paramwdj, wdl paramwdl)
  {
    this.jdField_a_of_type_Wdl = paramwdl;
  }
  
  public void onFailure(String paramString)
  {
    ykq.e(wdj.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    wdj.a(this.jdField_a_of_type_Wdj);
    if (wdj.b(this.jdField_a_of_type_Wdj) == 0)
    {
      ykq.b(wdj.a, "all ffmpeg commands have already finished. start clearing cache.");
      wdj.a(this.jdField_a_of_type_Wdj);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    ykq.b(wdj.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (zeb.a(BaseApplication.getContext(), this.jdField_a_of_type_Wdl.d, this.jdField_a_of_type_Wdl.e))
    {
      ykq.b(wdj.a, "save video to album success.");
      ykv.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    ykq.e(wdj.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdk
 * JD-Core Version:    0.7.0.1
 */