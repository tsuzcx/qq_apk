import com.tencent.qphone.base.util.QLog;

public class uql
  extends aoav
{
  uqg jdField_a_of_type_Uqg = null;
  
  public uql(uqf paramuqf, uqg paramuqg)
  {
    this.jdField_a_of_type_Uqg = paramuqg;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Uqg);
    }
    if (this.jdField_a_of_type_Uqg != null)
    {
      paramString = this.jdField_a_of_type_Uqg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */