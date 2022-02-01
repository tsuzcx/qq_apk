import com.tencent.qphone.base.util.QLog;

public class tvy
  extends aoeg
{
  tvt jdField_a_of_type_Tvt = null;
  
  public tvy(tvs paramtvs, tvt paramtvt)
  {
    this.jdField_a_of_type_Tvt = paramtvt;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Tvt);
    }
    if (this.jdField_a_of_type_Tvt != null)
    {
      paramString = this.jdField_a_of_type_Tvt;
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
 * Qualified Name:     tvy
 * JD-Core Version:    0.7.0.1
 */