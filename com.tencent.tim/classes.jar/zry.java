import android.os.Handler;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class zry
  implements View.OnLayoutChangeListener
{
  public zry(PhotoCropActivity paramPhotoCropActivity) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) && (this.b.handler != null)) {
      this.b.handler.sendEmptyMessage(1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zry
 * JD-Core Version:    0.7.0.1
 */