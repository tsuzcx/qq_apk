import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class ayjs
  extends aykd
{
  private boolean aHC;
  private boolean aHD;
  private Paint aY;
  private Paint aZ;
  private ayoo b;
  public int bqQ;
  public int bqR;
  public int bqS;
  public int bqT;
  int bqU = 0;
  int bqV = 0;
  private PointF centerPoint;
  private float mR = 45.0F;
  private int maxLength;
  private Path path;
  
  public ayjs(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
  }
  
  private void init()
  {
    this.aY = new Paint();
    this.aY.setAntiAlias(true);
    this.aY.setColor(Color.parseColor("#12B7F5"));
    this.aY.setStyle(Paint.Style.STROKE);
    this.aY.setStrokeWidth(2.0F);
    this.aZ = new Paint();
    this.aZ.setAntiAlias(true);
    this.aZ.setColor(Color.parseColor("#12B7F5"));
    this.aZ.setStyle(Paint.Style.STROKE);
    this.aZ.setStrokeWidth(2.0F);
    this.aZ.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F, 5.0F, 5.0F }, 1.0F));
    this.path = new Path();
    DisplayMetrics localDisplayMetrics = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getResources().getDisplayMetrics();
    this.bqQ = 0;
    this.bqR = localDisplayMetrics.widthPixels;
    this.bqS = 0;
    this.bqT = localDisplayMetrics.heightPixels;
    if (ayxa.isLiuHaiUseValid()) {
      this.bqT = (localDisplayMetrics.heightPixels - ayxa.eMW - ayxa.sNotchHeight);
    }
    double d = Math.pow(localDisplayMetrics.heightPixels, 2.0D);
    this.maxLength = ((int)Math.sqrt(Math.pow(localDisplayMetrics.widthPixels, 2.0D) + d));
    this.centerPoint = new PointF(this.bqR / 2, this.bqT / 2);
    this.jdField_b_of_type_Ayoo = new ayoo();
    this.jdField_b_of_type_Ayoo.tP(true);
    this.jdField_b_of_type_Ayoo.setMaxScale(18.0F);
    this.jdField_b_of_type_Ayoo.setMinScale(0.5F);
  }
  
  protected boolean H(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuideLineLayer", 2, "GuideLineLayer refreshed, entrance : " + paramInt3);
    }
    this.aHD = paramBoolean1;
    ac(paramFloat);
    xk(paramInt1);
    xl(paramInt2);
    b(paramPointF);
    this.aHC = paramBoolean2;
    notifyChange();
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  public void ac(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    this.mR = paramFloat;
  }
  
  protected void an(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (QLog.isColorLevel()) {
      QLog.d("GuideLineLayer", 2, "onLayerDraw  showGuideLine : " + this.aHD + " currentDegree : " + this.mR + " centerPoint.x " + this.centerPoint.x + " centerPoint.y : " + this.centerPoint.y + " isDualFinger : " + this.aHC + " transX : " + this.bqU + " transY : " + this.bqV + " maxLength : " + this.maxLength);
    }
    if ((this.aHD) && (this.aHC) && (Math.abs((int)this.mR % 45) < 3))
    {
      paramCanvas.translate(this.centerPoint.x, this.centerPoint.y);
      paramCanvas.translate(this.bqU, this.bqV);
      int i = Math.round(this.mR / 45.0F) * 45;
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "currentDegree : " + this.mR + "   guideLine Angle : " + i);
      }
      paramCanvas.rotate(i);
      this.path.reset();
      this.path.moveTo(-this.maxLength, 0.0F);
      this.path.lineTo(this.maxLength, 0.0F);
      paramCanvas.drawPath(this.path, this.aZ);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw angle guide line");
      }
    }
    paramCanvas.restore();
    paramCanvas.save();
    if ((this.aHD) && (Math.abs(this.centerPoint.x + this.bqU - (this.bqQ + this.bqR) / 2) < 4.0F))
    {
      this.path.reset();
      this.path.moveTo((this.bqQ + this.bqR) / 2, 0.0F);
      this.path.lineTo((this.bqQ + this.bqR) / 2, this.bqT);
      paramCanvas.drawPath(this.path, this.aY);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw X guide line");
      }
    }
    if ((this.aHD) && (Math.abs(this.centerPoint.y + this.bqV - (this.bqS + this.bqT) / 2) < 4.0F))
    {
      this.path.reset();
      this.path.moveTo(this.bqQ, (this.bqS + this.bqT) / 2);
      this.path.lineTo(this.bqR, (this.bqS + this.bqT) / 2);
      paramCanvas.drawPath(this.path, this.aY);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw Y guide line");
      }
    }
    paramCanvas.restore();
  }
  
  public void ao(Canvas paramCanvas) {}
  
  public void b(PointF paramPointF)
  {
    if (paramPointF == null) {
      return;
    }
    this.centerPoint.set(paramPointF);
  }
  
  public void clear() {}
  
  public String getTag()
  {
    return "GuideLineLayer";
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public void xk(int paramInt)
  {
    this.bqU = paramInt;
  }
  
  public void xl(int paramInt)
  {
    this.bqV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjs
 * JD-Core Version:    0.7.0.1
 */