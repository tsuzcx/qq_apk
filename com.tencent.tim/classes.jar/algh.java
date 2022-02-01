import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping.StylePagerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.Reference;
import java.util.List;

public class algh
  implements View.OnClickListener
{
  public algh(PhotoViewForShopping.StylePagerAdapter paramStylePagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (PhotoViewForShopping.a(this.a.this$0).get() != null)
    {
      Intent localIntent = new Intent((Context)PhotoViewForShopping.a(this.a.this$0).get(), QQBrowserActivity.class);
      localIntent.putExtra("url", ((alde)this.a.this$0.cE.get(i)).bVR);
      ((Activity)PhotoViewForShopping.a(this.a.this$0).get()).startActivity(localIntent);
      if (!PhotoViewForShopping.a(this.a.this$0).e.uin.equals(this.a.this$0.app.getCurrentAccountUin())) {
        break label172;
      }
      anot.a(this.a.this$0.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Mtemplatewindowclk", "0X8005B94", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label172:
      anot.a(this.a.this$0.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplatewindowclk", "0X8005B98", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algh
 * JD-Core Version:    0.7.0.1
 */