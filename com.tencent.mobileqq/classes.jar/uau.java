import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class uau
  extends anxq
{
  uau(uar paramuar, uaq paramuaq) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    uar.b(this.jdField_a_of_type_Uar, this.jdField_a_of_type_Uaq);
    StructLongMessageDownloadProcessor.deleteTask(uar.a(this.jdField_a_of_type_Uar), this.jdField_a_of_type_Uaq.a);
    ((bfas)uar.a(this.jdField_a_of_type_Uar).getManager(132)).a(this.jdField_a_of_type_Uaq.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Uaq.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((uar.a(this.jdField_a_of_type_Uar) != null) && (uar.a(this.jdField_a_of_type_Uar).isResume())) {
      uar.a(this.jdField_a_of_type_Uar).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    uar.a(this.jdField_a_of_type_Uar);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uau
 * JD-Core Version:    0.7.0.1
 */