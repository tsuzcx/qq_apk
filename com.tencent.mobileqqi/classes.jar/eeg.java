import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.LocationItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.data.MessageForText;

public class eeg
  implements View.OnClickListener
{
  public eeg(LocationItemBuilder paramLocationItemBuilder) {}
  
  public void onClick(View paramView)
  {
    localMessageForText = (MessageForText)AIOUtils.a(paramView);
    try
    {
      if (((ChatActivity)LocationItemBuilder.a(this.a)).a == null) {
        ((ChatActivity)LocationItemBuilder.b(this.a)).a = new QQMapActivityProxy(LocationItemBuilder.a(this.a).getAccount());
      }
      paramView = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", localMessageForText.latitude).putExtra("lon", localMessageForText.longitude).putExtra("url", localMessageForText.url).putExtra("loc", localMessageForText.location).putExtra("uin", LocationItemBuilder.b(this.a).getAccount());
      ((ChatActivity)LocationItemBuilder.c(this.a)).startActivityForResult(paramView, 18);
      i = 1;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        try
        {
          ((Activity)LocationItemBuilder.d(this.a)).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(localMessageForText.url)), 0);
          i = 1;
        }
        catch (Exception paramView)
        {
          int i = 0;
        }
      }
    }
    if ((i != 0) && ((LocationItemBuilder.e(this.a) instanceof ChatActivity))) {
      ((ChatActivity)LocationItemBuilder.f(this.a)).e(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eeg
 * JD-Core Version:    0.7.0.1
 */