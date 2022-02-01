import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;

public class aymy
  extends ayml
{
  public static final int brD = aytl.ek[1];
  public aymx a;
  public int awc = wja.dp2px(6.0F, BaseApplicationImpl.getContext().getResources());
  public Paint be;
  aymi c;
  public int mCurrentColor = brD;
  public float mLastX;
  public float mLastY;
  public Paint mLinePaint = new Paint();
  
  public aymy(aymi paramaymi)
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
    this.c = paramaymi;
  }
  
  private void a(Paint paramPaint, aymx paramaymx)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramaymx.color);
    paramPaint.setStrokeWidth(paramaymx.lineWidth);
    paramPaint.setShader(null);
  }
  
  public void a(Canvas paramCanvas, aymj paramaymj, Paint paramPaint)
  {
    if ((paramaymj instanceof aymx))
    {
      paramaymj = (aymx)paramaymj;
      if (paramaymj.path != null)
      {
        a(paramPaint, paramaymj);
        paramCanvas.drawPath(paramaymj.path, paramPaint);
      }
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
      this.a = new aymx(new Path(), 101, this.mLinePaint.getColor(), this.awc);
      if (this.c != null) {
        this.c.a(this.a);
      }
      DoodleLayout.sx("use_graffiti");
      this.a.path.reset();
      this.a.path.moveTo(f1, f2);
      this.a.path.lineTo(f1 + 1.0F, f2 + 1.0F);
      this.a.Gp.add(new aymw(aymw.eKC, f1, f2));
      this.a.Gp.add(new aymw(aymw.eKD, f1 + 1.0F, f2 + 1.0F));
      continue;
      float f3 = (this.mLastX + f1) / 2.0F;
      float f4 = (this.mLastY + f2) / 2.0F;
      if (this.a != null)
      {
        this.a.path.quadTo(this.mLastX, this.mLastY, f3, f4);
        this.a.Gp.add(new aymw(aymw.eKE, this.mLastX, this.mLastY, f3, f4));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymy
 * JD-Core Version:    0.7.0.1
 */