import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class wan
  extends waa
{
  wan(waa paramwaa, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.jdField_a_of_type_Waa.onFailure(paramString);
    if ((this.jdField_a_of_type_Waa instanceof swh)) {
      ((swh)this.jdField_a_of_type_Waa).a(941006);
    }
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " getVideoFromMp4 failed msg：" + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " getVideoFromMp4 start");
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " getVideoFromMp4 success cost：" + String.valueOf(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wan
 * JD-Core Version:    0.7.0.1
 */