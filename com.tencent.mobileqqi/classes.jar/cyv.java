import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class cyv
  implements IIconListener
{
  public cyv(PeopleAroundBaseActivity paramPeopleAroundBaseActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      int i = this.a.a.getChildCount();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramBitmap = this.a.a.getChildAt(paramInt2).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof PeopleAroundAdapter.ViewHolder)))
        {
          paramBitmap = (PeopleAroundAdapter.ViewHolder)paramBitmap;
          if ((paramBitmap.a == paramInt1) && (paramBitmap.c != null)) {
            PeopleAroundBaseActivity.a(this.a, paramBitmap.c, paramInt1);
          }
        }
        paramInt2 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyv
 * JD-Core Version:    0.7.0.1
 */