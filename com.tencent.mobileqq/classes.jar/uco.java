import com.tencent.qphone.base.util.QLog;

public class uco
  extends amyh
{
  ucj jdField_a_of_type_Ucj = null;
  
  public uco(uci paramuci, ucj paramucj)
  {
    this.jdField_a_of_type_Ucj = paramucj;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Ucj);
    }
    if (this.jdField_a_of_type_Ucj != null)
    {
      paramString = this.jdField_a_of_type_Ucj;
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
 * Qualified Name:     uco
 * JD-Core Version:    0.7.0.1
 */