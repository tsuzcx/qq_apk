import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class rij
  extends rhz
{
  public static final int brD = rnj.ek[8];
  public rii a;
  public int awc = wja.dp2px(6.0F, BaseApplicationImpl.getContext().getResources());
  public Paint be;
  rhw c;
  public int mCurrentColor = brD;
  public float mLastX;
  public float mLastY;
  public Paint mLinePaint = new Paint();
  
  public rij(rhw paramrhw)
  {
    this.mLinePaint.setAntiAlias(true);
    this.mLinePaint.setStyle(Paint.Style.STROKE);
    this.mLinePaint.setStrokeJoin(Paint.Join.ROUND);
    this.mLinePaint.setStrokeCap(Paint.Cap.ROUND);
    this.mLinePaint.setStrokeWidth(this.awc);
    this.mLinePaint.setColor(brD);
    this.be = new Paint();
    this.be.setAntiAlias(true);
    this.be.setStyle(Paint.Style.STROKE);
    this.be.setStrokeJoin(Paint.Join.ROUND);
    this.be.setStrokeCap(Paint.Cap.ROUND);
    this.be.setColor(brD);
    this.c = paramrhw;
  }
  
  private void a(Paint paramPaint, rii paramrii)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramrii.color);
    paramPaint.setStrokeWidth(paramrii.lineWidth);
    paramPaint.setShader(null);
  }
  
  public void a(Canvas paramCanvas, rhx paramrhx, Paint paramPaint)
  {
    if ((paramrhx instanceof rii))
    {
      paramrhx = (rii)paramrhx;
      a(paramPaint, paramrhx);
      paramCanvas.drawPath(paramrhx.path, paramPaint);
    }
  }
  
  public void apk()
  {
    this.mCurrentColor = brD;
    this.mLinePaint.setColor(brD);
    this.a = null;
  }
  
  public void btP()
  {
    this.mLinePaint.setXfermode(null);
    this.mLinePaint.setColor(this.mCurrentColor);
    this.mLinePaint.setStrokeWidth(this.awc);
  }
  
  public Paint h()
  {
    return this.be;
  }
  
  public Paint i()
  {
    return this.mLinePaint;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.mLastX = f1;
      this.mLastY = f2;
      this.a = new rii(new Path(), 101, this.mLinePaint.getColor(), this.awc);
      if (this.c != null) {
        this.c.a(this.a);
      }
      DoodleLayout.sx("use_graffiti");
      this.a.path.reset();
      this.a.path.moveTo(f1, f2);
      this.a.path.lineTo(f1 + 1.0F, f2 + 1.0F);
      continue;
      if ((this.a != null) && (this.a.path != null)) {
        this.a.path.quadTo(this.mLastX, this.mLastY, (this.mLastX + f1) / 2.0F, (this.mLastY + f2) / 2.0F);
      }
      this.mLastX = f1;
      this.mLastY = f2;
    }
  }
  
  public void setLineColor(int paramInt)
  {
    this.mLinePaint.setColor(paramInt);
    this.mCurrentColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rij
 * JD-Core Version:    0.7.0.1
 */