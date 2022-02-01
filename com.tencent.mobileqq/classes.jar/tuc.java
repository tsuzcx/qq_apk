import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class tuc
  extends aoqo
{
  tuc(ttz paramttz, tty paramtty) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    ttz.b(this.jdField_a_of_type_Ttz, this.jdField_a_of_type_Tty);
    StructLongMessageDownloadProcessor.a(ttz.a(this.jdField_a_of_type_Ttz), this.jdField_a_of_type_Tty.a);
    ((bfrd)ttz.a(this.jdField_a_of_type_Ttz).getManager(132)).a(this.jdField_a_of_type_Tty.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Tty.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((ttz.a(this.jdField_a_of_type_Ttz) != null) && (ttz.a(this.jdField_a_of_type_Ttz).isResume())) {
      ttz.a(this.jdField_a_of_type_Ttz).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    ttz.a(this.jdField_a_of_type_Ttz);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */