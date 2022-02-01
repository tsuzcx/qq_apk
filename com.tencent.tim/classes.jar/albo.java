import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class albo
  implements View.OnClickListener
{
  public albo(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.this$0, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
    this.this$0.startActivity((Intent)localObject);
    localObject = PersonalityLabelGalleryActivity.a(this.this$0);
    ((PersonalityLabel)localObject).praiseCount += PersonalityLabelGalleryActivity.a(this.this$0).unreadCount;
    PersonalityLabelGalleryActivity.a(this.this$0).unreadCount = 0;
    PersonalityLabelGalleryActivity.a(this.this$0).postDelayed(new PersonalityLabelGalleryActivity.2.1(this), 500L);
    anot.a(this.this$0.app, "dc00898", "", "", "0X8007FCF", "0X8007FCF", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albo
 * JD-Core Version:    0.7.0.1
 */