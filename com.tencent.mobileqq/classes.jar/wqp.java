import MyCarrier.Carrier;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

public class wqp
  implements View.OnClickListener
{
  public wqp(ContactListView paramContactListView) {}
  
  private void a()
  {
    Context localContext = this.a.getContext();
    Object localObject = ((MyBusinessManager)this.a.a.getManager(48)).a();
    if ((localObject == null) || (TextUtils.isEmpty(((Carrier)localObject).carrierURL))) {
      return;
    }
    localObject = ((Carrier)localObject).carrierURL;
    Intent localIntent = new Intent(localContext, MyBusinessActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("uin", this.a.a.getCurrentAccountUin());
    localIntent.putExtra("title", localContext.getString(2131437105));
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hideRightButton", true);
    this.a.a(localIntent, 1000);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131369897: 
    default: 
      return;
    case 2131369898: 
      ContactListView.a(this.a, true);
      ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_close_bluebar", "close_bluebar");
      return;
    }
    ContactListView.a(this.a, true);
    ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_clk_bluebar", "clk_bluebar");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */