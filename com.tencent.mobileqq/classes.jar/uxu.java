import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.qphone.base.util.QLog;

public class uxu
  extends oam
{
  public uxu(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, uyc paramuyc, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(true, this.jdField_a_of_type_Long);
      if (paramuyc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramuyc.a);
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(paramuyc, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b(paramuyc);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(false, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */