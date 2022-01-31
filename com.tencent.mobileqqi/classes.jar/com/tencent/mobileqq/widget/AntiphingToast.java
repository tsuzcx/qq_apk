package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import hfd;
import hfe;
import hff;
import java.util.Timer;

public class AntiphingToast
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 700;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView = null;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  private String jdField_a_of_type_JavaLangString = "AntiPhing";
  private boolean jdField_a_of_type_Boolean = true;
  private int g = 0;
  
  public AntiphingToast()
  {
    this.jdField_a_of_type_AndroidOsHandler = new hfd(this);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 2130839099;
  }
  
  public static void a() {}
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setStartOffset(20L);
    if (paramBoolean == true) {
      localTranslateAnimation.setAnimationListener(new hfe(this));
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localTranslateAnimation);
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, FrameLayout paramFrameLayout)
  {
    a(paramFrameLayout);
    b(paramInt1);
    c(paramInt2);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidContentResResources = paramFrameLayout.getContext().getResources();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903659, null);
    if (localView != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131233295);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    paramContext = new Toast(paramContext.getApplicationContext());
    paramContext.setGravity(55, 0, paramInt);
    paramContext.setView(localView);
    paramContext.setDuration(1);
    paramContext.show();
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViewsInLayout();
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903659, null);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233295);
        if ((localTextView != null) && (paramString != null)) {
          localTextView.setText(paramString);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
    a(-80.0F, 0.0F, false);
    new Timer().schedule(new hff(this), this.g + 700);
    return true;
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast
 * JD-Core Version:    0.7.0.1
 */