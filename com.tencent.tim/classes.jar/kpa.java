import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import mqq.app.AppRuntime;

public class kpa
{
  private View bu;
  
  public kpa(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (kxm.getAppRuntime() != null)
    {
      paramArkAppMessage = kxm.getAppRuntime().getApplication();
      if (paramArkAppMessage != null) {}
    }
    else
    {
      return;
    }
    this.bu = new View(paramArkAppMessage);
    this.bu.setVisibility(8);
  }
  
  public View S()
  {
    return this.bu;
  }
  
  public void a(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void aFE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpa
 * JD-Core Version:    0.7.0.1
 */