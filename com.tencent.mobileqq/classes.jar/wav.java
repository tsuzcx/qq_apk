import java.io.File;

final class wav
  extends wad
{
  wav(wad paramwad, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    vel.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.jdField_a_of_type_Wad.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.jdField_a_of_type_Wad.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Wad.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    vel.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.b) });
    if (bjil.c) {
      bjil.g.a(1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Wad.onSuccess(paramString);
    veg.c("Q.qqstory.ffmpeg.FFmpegCmd", "[vs_publish_flow]   recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wav
 * JD-Core Version:    0.7.0.1
 */