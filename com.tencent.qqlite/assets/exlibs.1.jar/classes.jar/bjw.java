import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.activity.SnapScreenActivity;

public class bjw
  extends View
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public final Rect a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d;
  int e;
  int f = 100001;
  int g = 100002;
  int h = 100003;
  int i = 100004;
  int j = 100005;
  public int k;
  
  public bjw(SnapScreenActivity paramSnapScreenActivity, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    setOnLongClickListener(new bjx(this, paramSnapScreenActivity));
  }
  
  public void a(boolean paramBoolean)
  {
    Rect localRect;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label134;
      }
      localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    }
    label134:
    for (int m = localRect.top;; m = 0)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, m, this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap.getHeight());
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
      {
        this.jdField_a_of_type_AndroidGraphicsRect.left = getLeft();
        this.jdField_a_of_type_AndroidGraphicsRect.right = getRight();
        this.jdField_a_of_type_AndroidGraphicsRect.top = getTop();
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = getBottom();
      }
      this.jdField_a_of_type_Boolean = true;
      invalidate();
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getResources().getConfiguration().orientation;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if ((m == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap == this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        localObject = new Matrix();
        ((Matrix)localObject).postRotate(-90.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, false);
      }
    }
    label498:
    label760:
    do
    {
      break label498;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      float f1;
      if ((this.k != 0) && (this.k != this.f))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
        localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
        m = this.e + 1;
        this.e = m;
        f1 = m;
        ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f1));
        invalidate();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
        if (this.jdField_a_of_type_AndroidGraphicsRect.left > this.jdField_a_of_type_AndroidGraphicsRect.right)
        {
          m = this.jdField_a_of_type_AndroidGraphicsRect.left;
          this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidGraphicsRect.right;
          this.jdField_a_of_type_AndroidGraphicsRect.right = m;
        }
        if (this.jdField_a_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.bottom)
        {
          m = this.jdField_a_of_type_AndroidGraphicsRect.top;
          this.jdField_a_of_type_AndroidGraphicsRect.top = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = m;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label760;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.ARGB_8888);
        localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        ((Canvas)localObject).translate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap != null) {
          ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        ((Canvas)localObject).translate(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
        new bjy(this).start();
        return;
        if (m != 1) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsBitmap;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
          localObject = new Canvas(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidViewWindow.getDecorView().draw((Canvas)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() == getWidth())) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_Int != m)
        {
          localObject = new Matrix();
          if (m == 2) {
            ((Matrix)localObject).postRotate(-90.0F);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, false);
            break;
            if (m == 1) {
              ((Matrix)localObject).postRotate(90.0F);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsBitmap;
        break;
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
        this.e = 0;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
      {
        m = getWidth() / 2 - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
        n = getHeight() / 2 - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i2 = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + n;
        f1 = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, n, i1 + m, i2);
        this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(20.0F * getResources().getDisplayMetrics().scaledDensity);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(2.0F, 0.0F, 2.0F * f1, -2147483648);
        paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidContentContext.getString(2131363181), getWidth() / 2, i2 + 26.0F * f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    } while ((this.k == this.f) || (this.k == 0));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    m = this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + m;
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2 + i1, n);
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    i1 = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    i2 = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + i1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2, n);
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    m = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    n = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + m;
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2, n);
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    i2 = this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2 + i1, n);
    this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
        this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
        if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
          if (this.jdField_a_of_type_AndroidGraphicsRect.contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int)) {
            this.k = this.i;
          }
        }
        for (;;)
        {
          invalidate();
          break;
          if (new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - 20, this.jdField_a_of_type_AndroidGraphicsRect.top - 20, this.jdField_a_of_type_AndroidGraphicsRect.right + 20, this.jdField_a_of_type_AndroidGraphicsRect.bottom + 20).contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
          {
            this.k = this.j;
            this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
          }
          else
          {
            this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
            this.k = this.f;
            this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
            this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
            this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.a(false);
            continue;
            this.k = this.f;
            this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.a(false);
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsRect.width() < 5) {
          this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
        }
        if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
        {
          this.k = this.g;
          this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.a(true);
        }
        else
        {
          this.k = 0;
        }
      }
    }
    this.c = ((int)paramMotionEvent.getX());
    this.d = ((int)paramMotionEvent.getY());
    int m;
    int n;
    Rect localRect;
    if (this.k == this.i)
    {
      m = this.c - this.jdField_a_of_type_Int;
      n = this.d - this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Int = this.c;
      this.jdField_b_of_type_Int = this.d;
      if ((this.jdField_a_of_type_AndroidGraphicsRect.left + m >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.right + m <= getWidth()))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.left += m;
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.right = (m + localRect.right);
      }
      if ((this.jdField_a_of_type_AndroidGraphicsRect.top + n >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.bottom + n <= getHeight()))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.top += n;
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.bottom = (n + localRect.bottom);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivitySnapScreenActivity.d.setVisibility(8);
      invalidate();
      break;
      if (this.k == this.f)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsRect.top = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsRect.right = this.c;
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = this.d;
      }
      else if (this.k == this.j)
      {
        m = this.c - this.jdField_a_of_type_Int;
        n = this.d - this.jdField_b_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect);
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2)
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left = (m + localRect.left);
          this.jdField_a_of_type_AndroidGraphicsRect.left = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.left, 0);
        }
        for (;;)
        {
          if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 2) {
            break label812;
          }
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = (n + localRect.top);
          this.jdField_a_of_type_AndroidGraphicsRect.top = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.top, 0);
          break;
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = (m + localRect.right);
          this.jdField_a_of_type_AndroidGraphicsRect.right = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.right, getWidth());
        }
        label812:
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.bottom = (n + localRect.bottom);
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.bottom, getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjw
 * JD-Core Version:    0.7.0.1
 */