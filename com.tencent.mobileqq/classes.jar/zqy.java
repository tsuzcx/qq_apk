import com.tencent.qphone.base.util.QLog;

final class zqy
  extends zqh
{
  zqy(zqh paramzqh) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.a.onFailure(paramString);
    yup.a("music_composite", "music_clip", 0, 1, new String[0]);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(System.currentTimeMillis() - this.b);
    yup.a("music_composite", "music_clip", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "音乐截取成功耗时：" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqy
 * JD-Core Version:    0.7.0.1
 */