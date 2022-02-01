import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ztk
  extends ztj
{
  TextView Nm;
  private final String TAG = "VideoPlayControllerForAIO";
  protected ztk.a a;
  private AtomicBoolean bS = new AtomicBoolean(false);
  protected int entrance = -1;
  private ImageView mCenterPlayBtn;
  private ImageView mCover;
  private LinearLayout mErrLayout;
  
  public void BW(boolean paramBoolean)
  {
    if (this.bS != null) {
      this.bS.set(paramBoolean);
    }
  }
  
  public void Fy(int paramInt)
  {
    if (this.mCover != null) {
      this.mCover.setVisibility(paramInt);
    }
  }
  
  public void Fz(int paramInt)
  {
    if (this.mCenterPlayBtn != null)
    {
      if ((this.mErrLayout != null) && (this.mErrLayout.getVisibility() == 0)) {
        this.mCenterPlayBtn.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.mCenterPlayBtn.setVisibility(paramInt);
  }
  
  public boolean T(MotionEvent paramMotionEvent)
  {
    if (this.mCenterPlayBtn == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is null.");
      }
    }
    do
    {
      do
      {
        return false;
        if (this.mCenterPlayBtn.getVisibility() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.mCenterPlayBtn.getLeft() + " , top = " + this.mCenterPlayBtn.getTop() + " , right = " + this.mCenterPlayBtn.getRight() + ", bottom = " + this.mCenterPlayBtn.getBottom());
        }
      } while (!new Rect(this.mCenterPlayBtn.getLeft(), this.mCenterPlayBtn.getTop(), this.mCenterPlayBtn.getRight(), this.mCenterPlayBtn.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, playbtn contains event");
      }
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
  }
  
  public boolean VN()
  {
    if (this.bS != null) {
      return this.bS.get();
    }
    return false;
  }
  
  public void b(ztk.a parama)
  {
    this.a = parama;
  }
  
  public void bB(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      Fz(8);
    }
    if (this.mErrLayout != null)
    {
      this.mErrLayout.setVisibility(paramInt);
      if (this.Nm == null) {
        this.Nm = ((TextView)this.mErrLayout.findViewById(2131366519));
      }
      this.Nm.setText(paramString);
    }
  }
  
  public void initUI(View paramView)
  {
    this.mCover = ((ImageView)paramView.findViewById(2131373580));
    this.mCenterPlayBtn = ((ImageView)paramView.findViewById(2131373579));
    this.mErrLayout = ((LinearLayout)paramView.findViewById(2131373581));
  }
  
  public void resetUI()
  {
    this.mCover = null;
    this.mCenterPlayBtn = null;
    this.mErrLayout = null;
  }
  
  public void setEntrance(int paramInt)
  {
    this.entrance = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztk
 * JD-Core Version:    0.7.0.1
 */