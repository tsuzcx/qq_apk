import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.qidian.QidianProfileCardActivity;

public class ashk
  implements ausj.a
{
  public ashk(QidianProfileCardActivity paramQidianProfileCardActivity, ausj paramausj, URLDrawable paramURLDrawable, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null) {
      this.val$actionSheet.dismiss();
    }
    do
    {
      return;
      paramView = this.val$actionSheet.getContent(paramInt);
      if (TextUtils.isEmpty(paramView))
      {
        this.val$actionSheet.dismiss();
        return;
      }
      if (paramView.equals(this.this$0.getString(2131694752)))
      {
        QidianProfileCardActivity.a(this.this$0, this.x);
        return;
      }
      if (paramView.equals(this.this$0.getString(2131694762)))
      {
        QidianProfileCardActivity.b(this.this$0, this.x);
        return;
      }
    } while (!paramView.equals(this.this$0.getString(2131700357)));
    QidianProfileCardActivity.c(this.this$0, this.cEO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashk
 * JD-Core Version:    0.7.0.1
 */