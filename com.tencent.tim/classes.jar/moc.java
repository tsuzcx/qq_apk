import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;

class moc
  implements mns
{
  moc(mnw parammnw, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = this.c.getProgress();
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, "uploadCallback: taskType = " + paramInt + ",isSuccess = " + paramBoolean1 + "isFinish = " + paramBoolean2 + "errorMsg = " + paramString + "progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moc
 * JD-Core Version:    0.7.0.1
 */