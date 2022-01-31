import java.io.IOException;

class vog
{
  Process a(String[] paramArrayOfString)
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramArrayOfString);
      return localProcess;
    }
    catch (IOException localIOException)
    {
      urk.c("Q.qqstory.ffmpeg.FFmpeg", "Exception while trying to run: " + paramArrayOfString, localIOException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */