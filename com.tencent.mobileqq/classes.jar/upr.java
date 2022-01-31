import com.tencent.qphone.base.util.BaseApplication;

public class upr
  implements xtk
{
  private ups jdField_a_of_type_Ups;
  
  public upr(upq paramupq, ups paramups)
  {
    this.jdField_a_of_type_Ups = paramups;
  }
  
  public void onFailure(String paramString)
  {
    wxe.e(upq.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    upq.a(this.jdField_a_of_type_Upq);
    if (upq.b(this.jdField_a_of_type_Upq) == 0)
    {
      wxe.b(upq.a, "all ffmpeg commands have already finished. start clearing cache.");
      upq.a(this.jdField_a_of_type_Upq);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    wxe.b(upq.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (xrg.a(BaseApplication.getContext(), this.jdField_a_of_type_Ups.d, this.jdField_a_of_type_Ups.e))
    {
      wxe.b(upq.a, "save video to album success.");
      wxj.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    wxe.e(upq.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */