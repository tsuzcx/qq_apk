import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.qphone.base.util.QLog;

public class vuk
  extends ojo
{
  public vuk(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, vus paramvus, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(true, this.jdField_a_of_type_Long);
      if (paramvus != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramvus.a);
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(paramvus, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b(paramvus);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(false, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuk
 * JD-Core Version:    0.7.0.1
 */