import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class adyt
  implements ausj.a
{
  public adyt(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      if ((this.bwr != null) && (this.bwr.length() > 0))
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.bwr));
        this.this$0.getActivity().startActivity(paramView);
        this.this$0.app.a().Oq(this.bwr);
      }
      else
      {
        this.this$0.cf(2131694849, 1);
        continue;
        if ((this.bwr != null) && (this.bwr.length() > 0))
        {
          paramView = new Intent();
          paramView.setAction("android.intent.action.SENDTO");
          paramView.setData(Uri.parse("smsto:" + this.bwr));
          this.this$0.getActivity().startActivity(paramView);
        }
        else
        {
          this.this$0.cf(2131694849, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyt
 * JD-Core Version:    0.7.0.1
 */