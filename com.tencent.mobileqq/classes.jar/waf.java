import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class waf
  extends waa
{
  waf(wab paramwab, waj paramwaj, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    ved.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.jdField_a_of_type_Waj.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_Waj.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Wab.a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.jdField_a_of_type_Waj.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      ved.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_Waj.onFailure(localIOException.getMessage());
      ved.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Waj.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Waj.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Waj.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     waf
 * JD-Core Version:    0.7.0.1
 */