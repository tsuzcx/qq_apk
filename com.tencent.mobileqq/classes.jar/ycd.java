import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;

public final class ycd
  extends ycg
{
  int jdField_a_of_type_Int;
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  final String jdField_a_of_type_JavaLangString = "...";
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int d;
  
  public ycd(ycc paramycc, @NonNull Drawable paramDrawable, @NonNull yck paramyck, String paramString1, String paramString2)
  {
    super(paramycc, paramDrawable, paramyck, paramString1, paramString2);
    this.jdField_a_of_type_Int = paramyck.jdField_d_of_type_Int;
    this.jdField_b_of_type_Int = paramyck.jdField_c_of_type_Int;
    a(paramyck.jdField_a_of_type_JavaLangString);
    this.e = UIUtils.dip2px(BaseApplicationImpl.getContext(), 7.5F);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new yce(this));
    localValueAnimator.addListener(new ycf(this));
    localValueAnimator.start();
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Ycc.jdField_a_of_type_Ygv.a(this));
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, 10.0F);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ycc.d.setAlpha(this.jdField_d_of_type_Int);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_Ycc.d);
    }
    paramCanvas.restore();
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.n, 6);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_d_of_type_Boolean) {
      DisplayUtil.drawEditRect(paramCanvas, this.jdField_a_of_type_Ycc.jdField_a_of_type_Ygv, this, 0, 2130844512, 2130844519);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    float f2 = this.n;
    float f1 = this.o;
    if (f2 * this.j < 200.0F) {
      f2 = 200.0F / this.j;
    }
    if (this.j * f1 < 200.0F) {
      f1 = 200.0F / this.j;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidGraphicsRectF.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Ycc.d.setAlpha(this.jdField_d_of_type_Int);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_Ycc.d);
      }
      paramCanvas.restore();
    }
    paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)this.n, 6);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      xvv.e("FaceLayer", "text is empty.");
      str = "";
    }
    xvv.b("FaceLayer", "text:" + str);
    this.jdField_c_of_type_JavaLangString = str;
    this.jdField_b_of_type_JavaLangString = str;
    int j = (int)(this.n - 12.0F);
    this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2)
    {
      int i = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(1);
      paramString = this.jdField_c_of_type_JavaLangString.substring(0, i);
      xvv.b("FaceLayer", "subString : " + this.jdField_c_of_type_JavaLangString + " -> " + paramString);
      this.jdField_c_of_type_JavaLangString = paramString;
      i = this.jdField_c_of_type_JavaLangString.length();
      this.jdField_c_of_type_JavaLangString += "...";
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      i -= 1;
      while ((i > 0) && (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2))
      {
        paramString = this.jdField_c_of_type_JavaLangString.substring(0, i) + "...";
        xvv.b("FaceLayer", "delete last char : " + this.jdField_c_of_type_JavaLangString + " -> " + paramString);
        this.jdField_c_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Ycc.jdField_a_of_type_AndroidTextTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        i -= 1;
      }
      if (i == 0) {
        xvv.e("FaceLayer", "text size is too large :" + this.jdField_a_of_type_Int);
      }
    }
    xvv.b("FaceLayer", "final text : " + this.jdField_c_of_type_JavaLangString + " , original text : " + this.jdField_b_of_type_JavaLangString);
    paramString = new Rect();
    this.jdField_a_of_type_AndroidTextStaticLayout.getLineBounds(0, paramString);
    this.jdField_c_of_type_Int = paramString.height();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, this.n, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycd
 * JD-Core Version:    0.7.0.1
 */