import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.b;
import com.tencent.widget.XListView;

public class yon
  implements amfh
{
  public yon(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if ((this.b.mScrollState == 0) && (this.b.mListView != null))
      {
        int i = this.b.mListView.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.b.mListView.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof SearchBaseFragment.b)))
          {
            paramBitmap = (SearchBaseFragment.b)paramBitmap;
            if (paramBitmap.actionId == paramInt1) {
              this.b.a(paramBitmap, paramBitmap.richStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */