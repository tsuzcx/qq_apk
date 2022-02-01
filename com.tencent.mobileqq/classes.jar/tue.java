import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class tue
  extends apee
{
  tue(tub paramtub, tua paramtua) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    tub.b(this.jdField_a_of_type_Tub, this.jdField_a_of_type_Tua);
    StructLongMessageDownloadProcessor.a(tub.a(this.jdField_a_of_type_Tub), this.jdField_a_of_type_Tua.a);
    ((bgre)tub.a(this.jdField_a_of_type_Tub).getManager(132)).a(this.jdField_a_of_type_Tua.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Tua.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((tub.a(this.jdField_a_of_type_Tub) != null) && (tub.a(this.jdField_a_of_type_Tub).isResume())) {
      tub.a(this.jdField_a_of_type_Tub).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    tub.a(this.jdField_a_of_type_Tub);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tue
 * JD-Core Version:    0.7.0.1
 */