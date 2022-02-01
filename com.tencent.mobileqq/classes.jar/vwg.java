import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

final class vwg
  implements aabw
{
  public boolean a(MotionEvent paramMotionEvent, RecyclerView paramRecyclerView)
  {
    return (Build.BRAND.equalsIgnoreCase("HUAWEI")) && (paramMotionEvent.getAction() == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwg
 * JD-Core Version:    0.7.0.1
 */