import android.text.TextUtils;
import android.view.View;

class ameh
  implements ausj.a
{
  ameh(amea paramamea, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    paramView = this.val$actionSheet.getContent(paramInt);
    if (paramView == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.val$actionSheet.dismiss();
      return;
    }
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ameh
 * JD-Core Version:    0.7.0.1
 */