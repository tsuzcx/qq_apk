import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class yup
  extends yuf
{
  public static final int a;
  public float a;
  public Paint a;
  yub a;
  public yuo a;
  public float b;
  public int b;
  public Paint b;
  public int c = AIOUtils.dp2px(6.0F, BaseApplicationImpl.getContext().getResources());
  
  static
  {
    jdField_a_of_type_Int = zbu.a[8];
  }
  
  public yup(yub paramyub)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Yub = paramyub;
  }
  
  private void a(Paint paramPaint, yuo paramyuo)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramyuo.jdField_b_of_type_Int);
    paramPaint.setStrokeWidth(paramyuo.c);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, yuc paramyuc, Paint paramPaint)
  {
    if ((paramyuc instanceof yuo))
    {
      paramyuc = (yuo)paramyuc;
      a(paramPaint, paramyuc);
      paramCanvas.drawPath(paramyuc.a, paramPaint);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Yuo = new yuo(new Path(), 101, this.jdField_a_of_type_AndroidGraphicsPaint.getColor(), this.c);
      if (this.jdField_a_of_type_Yub != null) {
        this.jdField_a_of_type_Yub.a(this.jdField_a_of_type_Yuo);
      }
      DoodleLayout.a("use_graffiti");
      this.jdField_a_of_type_Yuo.a.reset();
      this.jdField_a_of_type_Yuo.a.moveTo(f1, f2);
      this.jdField_a_of_type_Yuo.a.lineTo(f1 + 1.0F, f2 + 1.0F);
      continue;
      if ((this.jdField_a_of_type_Yuo != null) && (this.jdField_a_of_type_Yuo.a != null)) {
        this.jdField_a_of_type_Yuo.a.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, (this.jdField_a_of_type_Float + f1) / 2.0F, (this.jdField_b_of_type_Float + f2) / 2.0F);
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
  }
  
  public Paint b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Yuo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yup
 * JD-Core Version:    0.7.0.1
 */