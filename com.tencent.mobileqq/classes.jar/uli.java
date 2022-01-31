import com.tencent.qphone.base.util.BaseApplication;

public class uli
  implements xpb
{
  private ulj jdField_a_of_type_Ulj;
  
  public uli(ulh paramulh, ulj paramulj)
  {
    this.jdField_a_of_type_Ulj = paramulj;
  }
  
  public void onFailure(String paramString)
  {
    wsv.e(ulh.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    ulh.a(this.jdField_a_of_type_Ulh);
    if (ulh.b(this.jdField_a_of_type_Ulh) == 0)
    {
      wsv.b(ulh.a, "all ffmpeg commands have already finished. start clearing cache.");
      ulh.a(this.jdField_a_of_type_Ulh);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    wsv.b(ulh.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (xmx.a(BaseApplication.getContext(), this.jdField_a_of_type_Ulj.d, this.jdField_a_of_type_Ulj.e))
    {
      wsv.b(ulh.a, "save video to album success.");
      wta.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    wsv.e(ulh.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uli
 * JD-Core Version:    0.7.0.1
 */