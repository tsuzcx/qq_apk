import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.14.1;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.a;
import java.util.ArrayList;

public class ajum
  implements InterestTagItemView.a
{
  public ajum(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public boolean b(InterestTagInfo paramInterestTagInfo)
  {
    return ChooseInterestTagActivity.a(this.this$0, paramInterestTagInfo);
  }
  
  public void d(InterestTagInfo paramInterestTagInfo)
  {
    ChooseInterestTagActivity.a(this.this$0, 0);
    aurd.hide(ChooseInterestTagActivity.a(this.this$0));
    boolean bool;
    if (!TextUtils.isEmpty(ChooseInterestTagActivity.a(this.this$0)))
    {
      ChooseInterestTagActivity.a(this.this$0).aw(ChooseInterestTagActivity.a(this.this$0), true);
      ChooseInterestTagActivity localChooseInterestTagActivity = this.this$0;
      if (ChooseInterestTagActivity.b(this.this$0) != -1)
      {
        bool = true;
        ChooseInterestTagActivity.a(localChooseInterestTagActivity, false, bool);
        ChooseInterestTagActivity.a(this.this$0).setText("");
        ChooseInterestTagActivity.a(this.this$0, "");
      }
    }
    else
    {
      if (!ChooseInterestTagActivity.a(this.this$0, paramInterestTagInfo)) {
        break label132;
      }
      ChooseInterestTagActivity.a(this.this$0).remove(paramInterestTagInfo);
      ChooseInterestTagActivity.a(this.this$0, paramInterestTagInfo);
    }
    label132:
    do
    {
      return;
      bool = false;
      break;
      if (ChooseInterestTagActivity.a(this.this$0).size() < 8) {
        break label198;
      }
    } while (ChooseInterestTagActivity.d(this.this$0));
    ChooseInterestTagActivity.a(this.this$0, "最多只能添加8个标签哦");
    ChooseInterestTagActivity.b(this.this$0, true);
    ChooseInterestTagActivity.a(this.this$0).postDelayed(new ChooseInterestTagActivity.14.1(this), 2800L);
    return;
    label198:
    ChooseInterestTagActivity.a(this.this$0).add(paramInterestTagInfo);
    ChooseInterestTagActivity.c(this.this$0, paramInterestTagInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajum
 * JD-Core Version:    0.7.0.1
 */