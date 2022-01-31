import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;

public class vur
  implements Runnable
{
  public vur(PhotoListPanel.MyAdapter paramMyAdapter, View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    localRect.left -= this.jdField_a_of_type_Int;
    localRect.top -= this.jdField_b_of_type_Int;
    localRect.right += this.c;
    localRect.bottom += this.d;
    this.jdField_b_of_type_AndroidViewView.setTouchDelegate(new TouchDelegate(localRect, this.jdField_a_of_type_AndroidViewView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vur
 * JD-Core Version:    0.7.0.1
 */