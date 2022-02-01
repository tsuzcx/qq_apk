import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.ArrayList;

public class ajuk
  implements ajuy.a
{
  public ajuk(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void km(long paramLong)
  {
    int i = 0;
    while (i < ChooseInterestTagActivity.a(this.this$0).getChildCount())
    {
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)ChooseInterestTagActivity.a(this.this$0).getChildAt(i).getTag();
      if ((localInterestTagInfo != null) && (paramLong == localInterestTagInfo.tagId))
      {
        ChooseInterestTagActivity.a(this.this$0).remove(localInterestTagInfo);
        ChooseInterestTagActivity.a(this.this$0, localInterestTagInfo);
        ChooseInterestTagActivity.b(this.this$0, localInterestTagInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuk
 * JD-Core Version:    0.7.0.1
 */