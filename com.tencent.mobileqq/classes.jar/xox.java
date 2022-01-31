import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class xox
  extends xos
{
  xox(xot paramxot, xpb paramxpb, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    wsv.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.jdField_a_of_type_Xpb.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_Xpb.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Xot.a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.jdField_a_of_type_Xpb.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      wsv.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_Xpb.onFailure(localIOException.getMessage());
      wsv.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.jdField_a_of_type_Xpb.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.jdField_a_of_type_Xpb.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.jdField_a_of_type_Xpb.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */