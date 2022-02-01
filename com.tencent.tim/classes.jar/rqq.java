import com.tencent.qphone.base.util.QLog;

final class rqq
  extends rpz
{
  rqq(rpz paramrpz) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.a.onFailure(paramString);
    rar.a("music_composite", "music_clip", 0, 1, new String[0]);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(System.currentTimeMillis() - this.Cp);
    rar.a("music_composite", "music_clip", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "音乐截取成功耗时：" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqq
 * JD-Core Version:    0.7.0.1
 */