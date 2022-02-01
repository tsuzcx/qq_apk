import android.text.TextUtils;
import android.view.View;

class wlw
  implements ausj.a
{
  wlw(wll paramwll, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    wll.a(this.this$0).dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.aTb))
      {
        wll.a(this.this$0, this.aTb);
        return;
      }
      if (wll.a(this.this$0))
      {
        wll.b(this.this$0);
        return;
      }
      wll.c(this.this$0);
      return;
    } while (TextUtils.isEmpty(this.aTb));
    if (wll.a(this.this$0))
    {
      wll.b(this.this$0);
      return;
    }
    wll.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlw
 * JD-Core Version:    0.7.0.1
 */