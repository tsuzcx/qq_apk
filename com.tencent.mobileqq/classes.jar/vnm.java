import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class vnm
  extends vnh
{
  vnm(vni paramvni, vnq paramvnq, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    urk.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.jdField_a_of_type_Vnq.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_Vnq.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Vni.a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.jdField_a_of_type_Vnq.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      urk.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_Vnq.onFailure(localIOException.getMessage());
      urk.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Vnq.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Vnq.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Vnq.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnm
 * JD-Core Version:    0.7.0.1
 */