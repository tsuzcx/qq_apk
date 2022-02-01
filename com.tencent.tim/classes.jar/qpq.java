import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class qpq
  implements ausj.a
{
  public qpq(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (rpq.isFastDoubleClick()) {}
    do
    {
      return;
      this.val$actionSheet.superDismiss();
      paramView = this.val$actionSheet.getContent(paramInt);
    } while (!acfp.m(2131712442).equals(paramView));
    paramView = TroopInfoActivity.c(this.this$0.axZ, 0);
    paramView.putInt("extra_last_open_from", this.this$0.mFrom);
    apuh.a(this.this$0, paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpq
 * JD-Core Version:    0.7.0.1
 */