import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class wai
  extends wad
{
  wai(wae paramwae, wam paramwam, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    veg.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.jdField_a_of_type_Wam.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_Wam.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Wae.a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.jdField_a_of_type_Wam.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      veg.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_Wam.onFailure(localIOException.getMessage());
      veg.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Wam.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Wam.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Wam.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wai
 * JD-Core Version:    0.7.0.1
 */