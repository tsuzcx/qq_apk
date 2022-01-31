import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kr
  implements ActionSheet.OnButtonClickListener
{
  public kr(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.a != null) && (!TextUtils.isEmpty(this.a.a.mBmqqTelphone))) {
      BmqqProfileCardActivity.c(this.a, this.a.a.mBmqqTelphone);
    }
    BmqqProfileCardActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kr
 * JD-Core Version:    0.7.0.1
 */