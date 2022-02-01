package dov.com.qq.im.capture.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class EditTextPreView
  extends ImageView
{
  private DynamicTextItem jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
  private a jdField_a_of_type_DovComQqImCaptureTextEditTextPreView$a;
  private Paint mPaint;
  
  public EditTextPreView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setFilterBitmap(true);
    setScaleType(ImageView.ScaleType.CENTER);
    setClickable(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (isClickable())) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      return true;
    } while ((this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView$a == null) || (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null));
    int i = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramMotionEvent, getWidth(), getHeight(), null, null);
    if (i > -1)
    {
      setText(i, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.getText(i));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.cz(i, true);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.setText(i, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.getText(i));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.aeK(i);
    }
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView$a.a(this, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem, i);
    return true;
  }
  
  @Deprecated
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    throw new UnsupportedOperationException("unSupport normal click listener, use EditTextPreView.OnClickListener instead");
  }
  
  public void setOnClickListener(@Nullable a parama)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView$a = parama;
  }
  
  public void setPreViewDrawer(DynamicTextItem paramDynamicTextItem)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
    invalidate();
  }
  
  public void setText(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (!paramString.equals(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.getText(paramInt))))
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.setText(paramInt, paramString);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.YZ(false);
    }
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, DynamicTextItem paramDynamicTextItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.EditTextPreView
 * JD-Core Version:    0.7.0.1
 */