import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qidian.QidianProfileCardActivity;

public class ashe
  implements ausj.a
{
  public ashe(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.accountType == 1) {
      if (paramInt == 0) {
        this.this$0.XU(this.val$phone);
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.b(this.this$0).dismiss();
      return;
      if (paramInt == 1)
      {
        if (this.this$0.jdField_a_of_type_Asgx.sK(this.this$0.jdField_a_of_type_Alcn.e.uin)) {
          this.this$0.eny();
        } else {
          this.this$0.XV(this.val$phone);
        }
      }
      else if (paramInt == 2)
      {
        this.this$0.XV(this.val$phone);
        continue;
        if (paramInt == 0) {
          this.this$0.XU(this.val$phone);
        } else if (paramInt == 1) {
          this.this$0.XV(this.val$phone);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashe
 * JD-Core Version:    0.7.0.1
 */