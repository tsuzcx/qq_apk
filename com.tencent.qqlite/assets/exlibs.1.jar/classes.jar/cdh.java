import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.ItemViewHolder;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class cdh
  implements IIconListener
{
  public cdh(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.g == 0)
      {
        int i = this.a.a.getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = this.a.a.getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof SearchBaseActivity.ItemViewHolder)))
          {
            paramBitmap = (SearchBaseActivity.ItemViewHolder)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              this.a.a(paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdh
 * JD-Core Version:    0.7.0.1
 */