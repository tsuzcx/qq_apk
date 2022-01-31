import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;

class gen
  implements HttpDownloadUtil.HttpDownloadListener
{
  gen(gem paramgem) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, String.format("Resource Zip start download, url : %s, position : %s, cardId : %s ", new Object[] { paramString, Integer.valueOf(this.a.jdField_a_of_type_Int), Long.valueOf(this.a.jdField_a_of_type_Long) }));
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)(360.0D * paramLong2 / paramLong1);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity.a(this.a.jdField_a_of_type_Int, i);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, String.format("Resource Zip end download, url : %s, resultCode : %d ", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gen
 * JD-Core Version:    0.7.0.1
 */