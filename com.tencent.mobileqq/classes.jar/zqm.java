import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class zqm
  extends zqh
{
  zqm(zqi paramzqi, zqq paramzqq, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    yuk.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.jdField_a_of_type_Zqq.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_Zqq.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Zqi.a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.jdField_a_of_type_Zqq.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      yuk.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_Zqq.onFailure(localIOException.getMessage());
      yuk.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Zqq.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Zqq.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Zqq.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqm
 * JD-Core Version:    0.7.0.1
 */