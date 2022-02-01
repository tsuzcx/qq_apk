import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alhg
  implements View.OnClickListener
{
  private long Gh;
  
  public alhg(QzonePhotoView paramQzonePhotoView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.Gh) < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.Gh = l;
      if ((paramView != null) && ((paramView.getTag() instanceof albb)))
      {
        Object localObject = (albb)paramView.getTag();
        if (localObject != null)
        {
          int i = ((albb)localObject).nType;
          localObject = QzonePhotoView.a(this.this$0).e.uin;
          switch (i)
          {
          default: 
            break;
          case 25: 
            anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "2", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
            }
            QzonePhotoView.a(this.this$0, QzonePhotoView.a(this.this$0));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhg
 * JD-Core Version:    0.7.0.1
 */