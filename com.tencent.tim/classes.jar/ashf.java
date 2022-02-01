import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

public class ashf
  extends accn
{
  public ashf(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    this.this$0.aAt();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      this.this$0.jdField_a_of_type_Alcn.d = ((Card)paramObject);
      if (QidianProfileCardActivity.b(this.this$0)) {
        this.this$0.bT(this.this$0.jdField_a_of_type_Alcn.d.vQzoneCoverInfo);
      }
    }
  }
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "onGetAccountType isSuccess: " + paramBoolean + " | type: " + paramBmqqAccountType + " | cardInfo.allinone.uin: " + this.this$0.jdField_a_of_type_Alcn.e.uin);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.e != null) && (paramBmqqAccountType.getUin().equals(this.this$0.jdField_a_of_type_Alcn.e.uin)))
    {
      this.this$0.accountType = paramBmqqAccountType.getAccountType();
      this.this$0.enu();
      if (this.this$0.accountType == 1) {
        this.this$0.jdField_a_of_type_Asgx.b(this.this$0, paramBmqqAccountType);
      }
    }
    else
    {
      return;
    }
    this.this$0.aAt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashf
 * JD-Core Version:    0.7.0.1
 */