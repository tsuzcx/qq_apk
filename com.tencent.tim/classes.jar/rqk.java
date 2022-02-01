import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class rqk
  extends rpz
{
  rqk(rpz paramrpz, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 1, paramString);
    this.a.onFailure(paramString);
    rar.a("music_composite", "music_clip", 0, 1, new String[0]);
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " clip audio failed  msg：" + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " clip audio start");
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(System.currentTimeMillis() - this.Cp);
    rar.a("music_composite", "music_clip", 0, 0, new String[] { paramString });
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " clip audio end cost：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqk
 * JD-Core Version:    0.7.0.1
 */