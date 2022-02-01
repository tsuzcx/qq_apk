import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzm
  implements View.OnClickListener
{
  public adzm(CardPicGalleryActivity paramCardPicGalleryActivity, ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    if (2 == this.a.mMode)
    {
      localQQAppInterface = this.a.app;
      if (!this.a.bSv) {
        break label70;
      }
    }
    label70:
    for (String str = "1";; str = "2")
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", 4, 0, str, "", "", "");
      this.val$actionSheet.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzm
 * JD-Core Version:    0.7.0.1
 */