import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;

public class aoso
  implements ausj.a
{
  public aoso(MediaPreviewActivity paramMediaPreviewActivity, ausj paramausj, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.this$0.a.a(this.this$0.mSelectedIndex);
    String str = this.val$actionSheet.getContent(paramInt);
    if ((this.this$0.getString(2131694752).equals(str)) && (paramView != null)) {
      this.this$0.e(this.x, paramView.imageUrl);
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (this.this$0.getString(2131694762).equals(str)) {
        this.this$0.u(this.x);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoso
 * JD-Core Version:    0.7.0.1
 */