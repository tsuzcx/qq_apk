import android.content.Context;
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
import android.widget.Toast;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.qphone.base.util.QLog;

public class fgm
  extends View
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public final Rect a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
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
  
  public fgm(ScreenShot paramScreenShot, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    setOnLongClickListener(new fgn(this, paramScreenShot));
  }
  
  public void a(boolean paramBoolean)
  {
    Rect localRect;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label206;
      }
      localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    }
    label174:
    label206:
    for (int m = localRect.top;; m = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null)
      {
        if (!this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity()) {
          break label174;
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, m, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
        {
          this.jdField_a_of_type_AndroidGraphicsRect.left = getLeft();
          this.jdField_a_of_type_AndroidGraphicsRect.right = getRight();
          this.jdField_a_of_type_AndroidGraphicsRect.top = getTop();
          this.jdField_a_of_type_AndroidGraphicsRect.bottom = getBottom();
        }
        if ((this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) && (this.jdField_a_of_type_AndroidGraphicsRect.height() > 0))
        {
          this.jdField_a_of_type_Boolean = true;
          invalidate();
        }
        return;
        this.jdField_a_of_type_AndroidGraphicsRect.set(m, 0, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject;
    float f1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      localObject = getResources().getDisplayMetrics();
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      if ((((DisplayMetrics)localObject).heightPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth()) && (((DisplayMetrics)localObject).widthPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight()))
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if ((this.k == 0) || (this.k == this.f)) {
        break label833;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      m = this.e + 1;
      this.e = m;
      f1 = m;
      ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f1));
      invalidate();
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
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap == null)) {
        break label948;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    label833:
    do
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.ARGB_8888);
          localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
          this.jdField_b_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_a_of_type_AndroidGraphicsMatrix);
          this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
          if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
            ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            break label936;
          }
          Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext, 2131562817, 1).show();
          return;
          m = getWidth();
          n = getHeight();
          if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap == null) && (m > 0) && (n > 0)) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
            if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap != null)
            {
              localObject = new Canvas(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap);
              this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().draw((Canvas)localObject);
              this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap;
            }
            this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
            if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() == m)) {
              break;
            }
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
            this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "", localThrowable1);
              }
            }
          }
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
        this.e = 0;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          QLog.w("ScreenShot", 2, this.jdField_a_of_type_AndroidGraphicsRect.width() + ":" + this.jdField_a_of_type_AndroidGraphicsRect.height(), localIllegalArgumentException);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShot", 2, "", localThrowable2);
          }
        }
        new fgo(this).start();
        return;
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
        m = getWidth() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
        n = getHeight() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
        i1 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i2 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + n;
        f1 = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, n, i1 + m, i2);
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(20.0F * getResources().getDisplayMetrics().scaledDensity);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(2.0F, 0.0F, 2.0F * f1, -2147483648);
        paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext.getString(2131561991), getWidth() / 2, i2 + 26.0F * f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    } while ((this.k == this.f) || (this.k == 0));
    label936:
    label948:
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    int m = this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int n = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + m;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2 + i1, n);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    i1 = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    i2 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + i1;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2, n);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    m = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
    n = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + m;
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2, n);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    i1 = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
    i2 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, m, i2 + i1, n);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
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
            ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
            continue;
            this.k = this.f;
            ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsRect.width() < 5) {
          this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
        }
        if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
        {
          this.k = this.g;
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, true);
        }
        else
        {
          this.k = 0;
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
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
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.d.setVisibility(8);
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
            break label820;
          }
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = (n + localRect.top);
          this.jdField_a_of_type_AndroidGraphicsRect.top = Math.max(this.jdField_a_of_type_AndroidGraphicsRect.top, 0);
          break;
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = (m + localRect.right);
          this.jdField_a_of_type_AndroidGraphicsRect.right = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.right, getWidth());
        }
        label820:
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.bottom = (n + localRect.bottom);
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = Math.min(this.jdField_a_of_type_AndroidGraphicsRect.bottom, getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgm
 * JD-Core Version:    0.7.0.1
 */