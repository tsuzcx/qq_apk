import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class rqp
  extends rpz
{
  rqp(rpz paramrpz, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.a.onFailure(paramString);
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combine mix music and original failed " + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combine mix music and original start");
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.Cp;
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.c.fakeVid + " combine mix music and original：" + String.valueOf(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqp
 * JD-Core Version:    0.7.0.1
 */