import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView.a;
import com.tencent.mobileqq.app.QQAppInterface;

public class acaw
  implements ApolloPanelGuideView.a
{
  public acaw(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    ApolloPanel.e(this.this$0);
    if (!ApolloPanel.a(this.this$0, "sp_key_apollo_show_guide_tip"))
    {
      ApolloPanel.a(this.this$0, "sp_key_apollo_show_guide_tip");
      ApolloPanel.a(this.this$0, ApolloPanel.a(this.this$0), 49, this.this$0.getResources().getString(2131690373), 5, null);
    }
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    ApolloPanel.e(this.this$0);
    paramApolloPanelGuideView = (aqrb)this.this$0.mBaseChatPie.app.getBusinessHandler(71);
    paramApolloPanelGuideView.a(new acax(this, paramApolloPanelGuideView));
    paramApolloPanelGuideView.gs("guide_page", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acaw
 * JD-Core Version:    0.7.0.1
 */