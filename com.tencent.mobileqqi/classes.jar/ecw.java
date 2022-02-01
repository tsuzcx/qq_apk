import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class ecw
  implements IIconListener
{
  public ecw(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 201)) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Int == 0)
      {
        int i = CircleMemberListActivity.a(this.a).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramBitmap = CircleMemberListActivity.a(this.a).getChildAt(paramInt2).getTag();
          if ((paramBitmap != null) && ((paramBitmap instanceof ede)))
          {
            paramBitmap = (ede)paramBitmap;
            if (paramBitmap.jdField_a_of_type_Int == paramInt1) {
              this.a.a(paramBitmap, paramBitmap.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ecw
 * JD-Core Version:    0.7.0.1
 */