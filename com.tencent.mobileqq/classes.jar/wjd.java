import com.tencent.qphone.base.util.BaseApplication;

public class wjd
  implements zmv
{
  private wje jdField_a_of_type_Wje;
  
  public wjd(wjc paramwjc, wje paramwje)
  {
    this.jdField_a_of_type_Wje = paramwje;
  }
  
  public void onFailure(String paramString)
  {
    yqp.e(wjc.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    wjc.a(this.jdField_a_of_type_Wjc);
    if (wjc.b(this.jdField_a_of_type_Wjc) == 0)
    {
      yqp.b(wjc.a, "all ffmpeg commands have already finished. start clearing cache.");
      wjc.a(this.jdField_a_of_type_Wjc);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    yqp.b(wjc.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (zkr.a(BaseApplication.getContext(), this.jdField_a_of_type_Wje.d, this.jdField_a_of_type_Wje.e))
    {
      yqp.b(wjc.a, "save video to album success.");
      yqu.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    yqp.e(wjc.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjd
 * JD-Core Version:    0.7.0.1
 */