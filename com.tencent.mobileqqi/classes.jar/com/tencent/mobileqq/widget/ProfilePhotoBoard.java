package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class ProfilePhotoBoard
  extends PhotoBoard
{
  protected static final int C = 1;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 5;
  protected int A = 235;
  public int B = 1;
  private int D;
  protected Paint a;
  private Drawable a;
  public View a;
  protected Scroller a;
  protected String a;
  protected boolean b;
  private boolean c;
  protected int x = 38;
  protected int y = 235;
  protected int z = 235;
  
  public ProfilePhotoBoard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfilePhotoBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfilePhotoBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new LinearInterpolator());
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839042);
      paramInt = getResources().getDimensionPixelSize(2131427497);
      if (paramInt <= 0)
      {
        this.x = ((int)(this.x * this.jdField_b_of_type_Float));
        paramInt = getResources().getDimensionPixelSize(2131427498);
        if (paramInt > 0) {
          break label251;
        }
        this.y = ((int)(this.y * this.jdField_b_of_type_Float));
        paramInt = getResources().getDimensionPixelSize(2131427499);
        if (paramInt > 0) {
          break label259;
        }
        this.z = ((int)(this.z * this.jdField_b_of_type_Float));
        paramInt = getResources().getDimensionPixelSize(2131427500);
        if (paramInt > 0) {
          break label267;
        }
        this.A = ((int)(this.A * this.jdField_b_of_type_Float));
      }
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall.Bg", 2, paramContext.toString());
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.PhotoWall.Bg", 2, paramContext.toString());
          continue;
          this.x = paramInt;
          continue;
          label251:
          this.y = paramInt;
          continue;
          label259:
          this.z = paramInt;
        }
      }
      label267:
      this.A = paramInt;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.B == paramInt) {
      label8:
      return;
    }
    int i = this.x;
    if (paramInt == 0)
    {
      i = this.x;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    for (;;)
    {
      for (;;)
      {
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 4))) {}
        try
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839042);
          if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
            this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
          }
          this.c = false;
          this.k = i;
          Log.i("ProfilePhotoBoard", "updatePhotoWallBackground|height =  " + this.k);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
          if (localLayoutParams.height != i)
          {
            if ((this.jdField_a_of_type_Boolean) || (paramInt == 0))
            {
              localLayoutParams.height = i;
              setLayoutParams(localLayoutParams);
            }
          }
          else
          {
            this.B = paramInt;
            if (this.jdField_a_of_type_AndroidViewView != null) {}
            switch (this.B)
            {
            default: 
              this.jdField_a_of_type_AndroidViewView.setVisibility(0);
              if (this.B == 1) {
                break label8;
              }
              this.jdField_b_of_type_Boolean = false;
              return;
              if (paramInt == 1) {
                i = this.y;
              } else if ((paramInt == 2) || (paramInt == 5)) {
                i = this.z;
              } else if ((paramInt == 3) || (paramInt == 4)) {
                i = this.A;
              }
              break;
            }
          }
        }
        catch (Error localError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.PhotoWall.Bg", 2, localError.toString());
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("Q.profilecard.PhotoWall.Bg", 2, localException.toString());
              continue;
              int j = localException.height;
              this.c = true;
              this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, i - j, (int)(Math.abs(i - j) * 3.5D));
              this.D = 0;
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10L);
              continue;
              this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void b()
  {
    super.b();
  }
  
  protected void c(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      float f = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
      int i = this.k / 2;
      int j = (this.j - (int)f) / 2;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, j, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    if (paramMessage.what == 1)
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
        break label102;
      }
      int i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      int j = this.D;
      this.D = i;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.height = (i - j + localLayoutParams.height);
      setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10L);
    }
    for (bool1 = true;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.handleMessage(paramMessage);
      }
      return bool2;
      label102:
      this.c = false;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.j, this.k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    if (this.c) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setDrawCoverBgIconFlag(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        float f = this.jdField_b_of_type_Float;
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#4CFFFFFF"));
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(14.0F * f);
      }
      this.jdField_a_of_type_JavaLangString = getResources().getString(2131561838);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
  }
  
  public void setPhotoBoardStyle(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall.Bg", 2, "setPhotoBoardStyle|nStyle = " + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.setPhotoBoardStyle(paramInt);
      return;
      b(0);
      continue;
      b(1);
      continue;
      b(2);
      continue;
      b(3);
      continue;
      b(4);
      continue;
      b(4);
      continue;
      b(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfilePhotoBoard
 * JD-Core Version:    0.7.0.1
 */