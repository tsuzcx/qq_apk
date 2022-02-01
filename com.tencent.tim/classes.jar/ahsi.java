import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"NewApi"})
public class ahsi
  extends ViewOutlineProvider
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOutlineProvider", 1, "----->getOutline");
    }
    paramView.getGlobalVisibleRect(new Rect());
    paramOutline.setRoundRect(new Rect(this.left, this.top, this.right, this.bottom), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsi
 * JD-Core Version:    0.7.0.1
 */