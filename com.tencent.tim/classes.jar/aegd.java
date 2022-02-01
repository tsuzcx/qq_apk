import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity.b;
import com.tencent.widget.XListView;

public class aegd
  implements amfh
{
  public aegd(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.mScrollState == 0)
      {
        int i = this.a.mListView.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.mListView.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof SearchResultActivity.b)))
          {
            paramBitmap = (SearchResultActivity.b)paramBitmap;
            if (paramBitmap.actionId == paramInt1) {
              SearchResultActivity.a(this.a, paramBitmap, paramBitmap.richStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegd
 * JD-Core Version:    0.7.0.1
 */