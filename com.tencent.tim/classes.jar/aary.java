import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class aary
{
  public static int cjn;
  private static int cjp;
  public static boolean mMirror = false;
  private Matrix E = new Matrix();
  private Matrix F = new Matrix();
  private int cjo = 90;
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private static int yV()
  {
    if (cjp == 0)
    {
      cjp = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131298478);
      return cjp;
    }
    return cjp;
  }
  
  public void G(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.F = new Matrix();
    aeah.a(this.F, mMirror, this.cjo, paramInt3, paramInt4, paramInt1, paramInt2);
    this.F.invert(this.E);
  }
  
  public Rect a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    int i = Float.valueOf(yV() * paramFloat3).intValue();
    paramInt1 = clamp((int)paramFloat1 - i / 2, 0, paramInt1 - i);
    paramInt2 = clamp((int)paramFloat2 - i / 2, 0, paramInt2 - i);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
    this.E.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      cjn = (paramInt + 45) / 90 * 90;
    } while ((cjn >= 0) || (!QLog.isColorLevel()));
    QLog.i("NewFlowCameraOperator", 2, "[onOrientationChanged] origi: " + paramInt + " new:" + cjn);
  }
  
  public void setMirror(boolean paramBoolean)
  {
    mMirror = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aary
 * JD-Core Version:    0.7.0.1
 */