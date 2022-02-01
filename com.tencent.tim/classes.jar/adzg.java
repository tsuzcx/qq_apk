import android.view.View;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class adzg
  implements AdapterView.e
{
  public adzg(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.mIndex = paramInt;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzg
 * JD-Core Version:    0.7.0.1
 */