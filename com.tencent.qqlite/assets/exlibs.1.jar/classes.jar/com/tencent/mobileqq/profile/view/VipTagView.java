package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.Draggable;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DropTarget;
import eai;
import eaj;

public final class VipTagView
  extends TextView
  implements DragAndDropDetector.Draggable
{
  public static final int a = 99;
  public static final String a = "99+";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131493082, 2131493083, 2131493084, 2131493085, 2131493086 };
  public static final String b = "+1";
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ShakeEffectGenerator jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator;
  private ValueAnimation jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  public VipTagView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode()) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843087 });
    }
    try
    {
      paramAttributeSet = paramContext.getString(0);
      paramContext.recycle();
      if (paramAttributeSet != null) {
        setLabelText(paramAttributeSet);
      }
      b();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(int paramInt)
  {
    setBackgroundResource(2130839028);
    if ((paramInt > 0) && (paramInt <= 5))
    {
      Object localObject = getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        Resources localResources = getResources();
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).mutate();
        paramInt = localResources.getDimensionPixelSize(jdField_a_of_type_ArrayOfInt[(paramInt - 1)]);
        ((GradientDrawable)localObject).setSize(paramInt, paramInt);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int i = getHeight();
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      float f1 = this.jdField_a_of_type_Float;
      paramCanvas.save();
      float f2 = getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      float f3 = i;
      float f4 = j;
      paramCanvas.translate(f2, -(i * 0.8F + j) * this.jdField_a_of_type_Float + (f3 * 0.8F + f4));
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F - this.jdField_a_of_type_Float * 200.0F));
      paramCanvas.scale(f1, f1);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  private void b()
  {
    setClickable(true);
    Resources localResources = getResources();
    setTextSize(0, localResources.getDimensionPixelSize(2131493087));
    int i = localResources.getDimensionPixelSize(2131493088);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText("+1"), i, Bitmap.Config.ARGB_4444);
    new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawText("+1", 0.0F, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator = new ShakeEffectGenerator(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(1.0F), new eai(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setDuration(800L);
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation.setAnimationListener(new eaj(this));
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Int <= 99) {}
    for (String str1 = String.valueOf(this.jdField_b_of_type_Int);; str1 = "99+")
    {
      String str2 = (String)getText();
      str2 = str2.substring(0, str2.indexOf('('));
      setText(str2 + "(" + str1 + ")");
      return;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    startAnimation(this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation);
    c();
  }
  
  public void a(DragAndDropDetector.DragSource paramDragSource, float paramFloat1, float paramFloat2) {}
  
  public void a(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.DropTarget paramDropTarget, float paramFloat1, float paramFloat2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator.a();
  }
  
  public boolean a(DragAndDropDetector.DragSource paramDragSource, float paramFloat1, float paramFloat2)
  {
    bringToFront();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator.b();
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setLabelAndPraise(String paramString, int paramInt)
  {
    setLabelText(paramString);
    this.jdField_b_of_type_Int = paramInt;
    c();
  }
  
  public void setLabelText(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (paramString.length() > 5) {
      str = paramString.substring(0, 5);
    }
    paramString = str.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < paramString.length)
    {
      localStringBuilder.append(paramString[i]);
      if ((str.length() > 3) && (i == 1)) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    localStringBuilder.append("\n(0)");
    setText(localStringBuilder);
    a(str.length());
  }
  
  public void setShakingState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperShakeEffectGenerator.b();
  }
  
  public void setTagColor(int paramInt1, int paramInt2)
  {
    Object localObject = getBackground();
    if ((localObject instanceof GradientDrawable))
    {
      localObject = (GradientDrawable)localObject;
      ((GradientDrawable)localObject).setColor(paramInt2);
      ((GradientDrawable)localObject).setStroke(2, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipTagView
 * JD-Core Version:    0.7.0.1
 */