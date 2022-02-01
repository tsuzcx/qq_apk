import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import java.io.IOException;
import java.util.ArrayList;

class rqe
  extends rpz
{
  rqe(rqa paramrqa, rqi paramrqi, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    ram.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.c.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.ca == null) {
      this.c.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.this$0.cu(this.nK);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.c.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.c.onFailure(localIOException.getMessage());
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.c.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.c.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.c.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqe
 * JD-Core Version:    0.7.0.1
 */