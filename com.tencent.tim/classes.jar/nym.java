import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class nym
  extends adai.a
{
  nym(nyj paramnyj, nyi paramnyi) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.b.mUin + ", success:" + String.valueOf(paramBoolean));
    }
    if ((nyj.a(this.this$0) != null) && (nyj.a(this.this$0).isResume())) {
      nyj.a(this.this$0).showProgressBar(false);
    }
  }
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 5;
  }
  
  public void onSuccess(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    nyj.b(this.this$0, this.b);
    StructLongMessageDownloadProcessor.aP(nyj.a(this.this$0), this.b.mUin);
    ((apsa)nyj.a(this.this$0).getManager(132)).TL(this.b.mUin);
  }
  
  public void p(Object paramObject)
  {
    nyj.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nym
 * JD-Core Version:    0.7.0.1
 */