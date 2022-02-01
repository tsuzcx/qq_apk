import android.graphics.Canvas;
import com.tencent.av.doodle.MySurfaceView;
import com.tencent.common.app.BaseApplicationImpl;

public class imv
  extends imu
{
  private imw a = new imw();
  
  public imv(int paramInt)
  {
    la(paramInt);
  }
  
  private void la(int paramInt)
  {
    this.a.d(BaseApplicationImpl.getApplication(), 2131230748, paramInt);
    this.a.a(this.mPathMeasure);
  }
  
  public void aom() {}
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.a.draw(paramCanvas);
  }
  
  public void ch(long paramLong)
  {
    this.a.update((float)paramLong / 1000.0F);
  }
  
  public void s(float paramFloat1, float paramFloat2)
  {
    super.s(paramFloat1, paramFloat2);
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imv
 * JD-Core Version:    0.7.0.1
 */