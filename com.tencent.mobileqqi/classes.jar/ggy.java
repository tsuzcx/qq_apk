import android.graphics.Bitmap;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;

public class ggy
  implements IIconListener
{
  public ggy(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((EditActivity.a(this.a).b == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      EditActivity.a(this.a, false);
    }
    for (;;)
    {
      return;
      if ((paramBitmap != null) && (paramInt2 == 201) && (EditActivity.a(this.a)))
      {
        int i = EditActivity.a(this.a).getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          View localView = EditActivity.a(this.a).getChildAt(paramInt2);
          if (paramInt1 == ((Integer)localView.getTag()).intValue()) {
            ((ImageView)localView.findViewById(2131232969)).setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), paramBitmap, false, false));
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ggy
 * JD-Core Version:    0.7.0.1
 */