import android.view.View;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class adzj
  implements AdapterView.c
{
  public adzj(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.isFinishing())
    {
      this.a.overridePendingTransition(0, 2130772440);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzj
 * JD-Core Version:    0.7.0.1
 */