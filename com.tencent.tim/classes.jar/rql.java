import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class rql
  extends rpz
{
  rql(rpz paramrpz, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    rar.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.a.onFailure(paramString);
    if ((this.a instanceof pog.c)) {
      ((pog.c)this.a).setErrorCode(941007);
    }
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combineVideoAndAudio failed msg：" + paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalMixAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalNoneAudioVideoPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.aBK);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.a.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combineVideoAndAudio start");
  }
  
  public void onSuccess(String paramString)
  {
    String str = String.valueOf(System.currentTimeMillis() - this.Cp);
    rar.a("music_composite", "video_music_composite", 0, 0, new String[] { str });
    if (axvu.dwO) {
      axvu.g.ay(1, System.currentTimeMillis() - this.Cq);
    }
    this.a.onSuccess(paramString);
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combineVideoAndAudio end cost time：" + str);
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " mergeMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rql
 * JD-Core Version:    0.7.0.1
 */