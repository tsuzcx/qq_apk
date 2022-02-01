import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class myl
  implements nbo.b
{
  public myl(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void aUa()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.access$300(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.this$0) + " SUCCESS");
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.this$0, true), 5, null, true);
  }
  
  public void aUb()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.access$300(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.this$0));
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.this$0, false), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myl
 * JD-Core Version:    0.7.0.1
 */