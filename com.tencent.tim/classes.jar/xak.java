import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

class xak
  implements ausj.a
{
  xak(xah paramxah, MessageForPic paramMessageForPic, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    label144:
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramView = this.this$0.app.a().a(this.d.frienduin, this.d.uniseq);
      if ((paramView != null) && ((paramView instanceof aojn)))
      {
        paramView = (aojn)paramView;
        if ((paramView.azP()) && (paramView.isPause()))
        {
          paramInt = 1;
          this.this$0.app.a().bL(this.d.frienduin, String.valueOf(this.d.uniseq));
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label144;
        }
        this.this$0.g(this.d);
        break;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xak
 * JD-Core Version:    0.7.0.1
 */