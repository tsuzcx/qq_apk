import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;

public class vop
  implements FFmpegExecuteResponseCallback
{
  private voq jdField_a_of_type_Voq;
  
  public vop(voo paramvoo, voq paramvoq)
  {
    this.jdField_a_of_type_Voq = paramvoq;
  }
  
  public void onFailure(String paramString)
  {
    xvv.e(voo.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    voo.a(this.jdField_a_of_type_Voo);
    if (voo.b(this.jdField_a_of_type_Voo) == 0)
    {
      xvv.b(voo.a, "all ffmpeg commands have already finished. start clearing cache.");
      voo.a(this.jdField_a_of_type_Voo);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    xvv.b(voo.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (ypi.a(BaseApplication.getContext(), this.jdField_a_of_type_Voq.d, this.jdField_a_of_type_Voq.e))
    {
      xvv.b(voo.a, "save video to album success.");
      xwa.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    xvv.e(voo.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vop
 * JD-Core Version:    0.7.0.1
 */