import android.graphics.Bitmap;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;

public class ebm
  implements IIconListener
{
  public ebm(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((EditActivity.a(this.a).b == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      EditActivity.a(this.a, false);
    }
    for (;;)
    {
      return;
      if ((paramBitmap != null) && (paramInt2 == 201) && (EditActivity.a(this.a) != null))
      {
        int i = EditActivity.a(this.a).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          View localView = EditActivity.a(this.a).getChildAt(paramInt2);
          if (paramInt1 == ((Integer)localView.getTag()).intValue()) {
            ((ImageView)localView.findViewById(2131298235)).setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), paramBitmap, false, false));
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebm
 * JD-Core Version:    0.7.0.1
 */