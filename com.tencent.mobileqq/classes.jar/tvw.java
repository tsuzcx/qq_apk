import com.tencent.qphone.base.util.QLog;

public class tvw
  extends anry
{
  tvr jdField_a_of_type_Tvr = null;
  
  public tvw(tvq paramtvq, tvr paramtvr)
  {
    this.jdField_a_of_type_Tvr = paramtvr;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Tvr);
    }
    if (this.jdField_a_of_type_Tvr != null)
    {
      paramString = this.jdField_a_of_type_Tvr;
      if (!paramBoolean) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      paramString.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvw
 * JD-Core Version:    0.7.0.1
 */