import java.io.File;

final class rqr
  extends rpz
{
  rqr(rpz paramrpz, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    rar.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.a.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.a.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    rar.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.Cp) });
    if (axvu.dwO) {
      axvu.g.ay(1, System.currentTimeMillis() - this.Cq);
    }
    this.a.onSuccess(paramString);
    ram.i("Q.qqstory.ffmpeg.FFmpegCmd", "[vs_publish_flow]   recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqr
 * JD-Core Version:    0.7.0.1
 */