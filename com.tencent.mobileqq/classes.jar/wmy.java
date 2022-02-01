import com.tencent.qphone.base.util.BaseApplication;

public class wmy
  implements zqq
{
  private wmz jdField_a_of_type_Wmz;
  
  public wmy(wmx paramwmx, wmz paramwmz)
  {
    this.jdField_a_of_type_Wmz = paramwmz;
  }
  
  public void onFailure(String paramString)
  {
    yuk.e(wmx.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    wmx.a(this.jdField_a_of_type_Wmx);
    if (wmx.b(this.jdField_a_of_type_Wmx) == 0)
    {
      yuk.b(wmx.a, "all ffmpeg commands have already finished. start clearing cache.");
      wmx.a(this.jdField_a_of_type_Wmx);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    yuk.b(wmx.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (zom.a(BaseApplication.getContext(), this.jdField_a_of_type_Wmz.d, this.jdField_a_of_type_Wmz.e))
    {
      yuk.b(wmx.a, "save video to album success.");
      yup.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    yuk.e(wmx.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmy
 * JD-Core Version:    0.7.0.1
 */