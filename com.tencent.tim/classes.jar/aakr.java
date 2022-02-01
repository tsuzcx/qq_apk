import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class aakr
  extends adai.a
{
  aakr(aakp paramaakp, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    aakp.a(this.this$0);
  }
  
  public int dI()
  {
    return 5;
  }
  
  public void onSuccess(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow success");
    }
    aakp.a(this.this$0, this.d, this.val$appInterface);
    StructLongMessageDownloadProcessor.aP(this.val$appInterface, this.d.qx());
    ((apsa)this.val$appInterface.getManager(132)).TL(this.d.qx());
    aakp.b(this.this$0, this.d, this.val$appInterface);
  }
  
  public void p(Object paramObject)
  {
    aakp.a(this.this$0, 2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakr
 * JD-Core Version:    0.7.0.1
 */