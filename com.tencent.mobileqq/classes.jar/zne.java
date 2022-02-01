import java.io.File;

final class zne
  extends zmm
{
  zne(zmm paramzmm, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    yqu.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.jdField_a_of_type_Zmm.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.jdField_a_of_type_Zmm.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Zmm.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    yqu.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.b) });
    if (bosd.c) {
      bosd.g.a(1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Zmm.onSuccess(paramString);
    yqp.c("Q.qqstory.ffmpeg.FFmpegCmd", "[vs_publish_flow]   recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zne
 * JD-Core Version:    0.7.0.1
 */