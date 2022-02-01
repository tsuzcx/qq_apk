import java.io.IOException;

class rqw
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
      ram.e("Q.qqstory.ffmpeg.FFmpeg", "Exception while trying to run: " + paramArrayOfString, localIOException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqw
 * JD-Core Version:    0.7.0.1
 */