import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class uor
  extends apas
{
  uor(uoo paramuoo, uon paramuon) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    uoo.b(this.jdField_a_of_type_Uoo, this.jdField_a_of_type_Uon);
    StructLongMessageDownloadProcessor.deleteTask(uoo.a(this.jdField_a_of_type_Uoo), this.jdField_a_of_type_Uon.a);
    ((bgiy)uoo.a(this.jdField_a_of_type_Uoo).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_Uon.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Uon.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((uoo.a(this.jdField_a_of_type_Uoo) != null) && (uoo.a(this.jdField_a_of_type_Uoo).isResume())) {
      uoo.a(this.jdField_a_of_type_Uoo).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    uoo.a(this.jdField_a_of_type_Uoo);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uor
 * JD-Core Version:    0.7.0.1
 */