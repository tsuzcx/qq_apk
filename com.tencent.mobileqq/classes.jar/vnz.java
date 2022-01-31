import java.io.File;

final class vnz
  extends vnh
{
  vnz(vnh paramvnh, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    urp.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.jdField_a_of_type_Vnh.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.jdField_a_of_type_Vnh.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Vnh.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    urp.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.b) });
    if (bhnt.c) {
      bhnt.g.a(1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Vnh.onSuccess(paramString);
    urk.c("Q.qqstory.ffmpeg.FFmpegCmd", "[vs_publish_flow]   recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnz
 * JD-Core Version:    0.7.0.1
 */