import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class fqm
  implements IIconListener
{
  public fqm(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Int == 0)
      {
        int i = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof fqo)))
          {
            paramBitmap = (fqo)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              SearchResultActivity.a(this.a, paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fqm
 * JD-Core Version:    0.7.0.1
 */