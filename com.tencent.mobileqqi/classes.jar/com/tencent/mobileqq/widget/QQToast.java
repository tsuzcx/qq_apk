package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import hhh;

public class QQToast
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  private int e = 0;
  
  public QQToast(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 2130837803;
    }
    return 2130839721;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt2);
    paramContext.c(paramInt3);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.a(paramCharSequence);
    paramContext.c(paramInt2);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  public static boolean a()
  {
    return Build.BOARD.contains("mx2");
  }
  
  public int a()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public Toast a(int paramInt)
  {
    hhh localhhh = new hhh(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903298, null);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((ImageView)localView.findViewById(2131232009)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        ((TextView)localView.findViewById(2131232010)).setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      localhhh.setGravity(55, 0, paramInt);
      localhhh.setView(localView);
      localhhh.setDuration(this.e);
      return localhhh;
      ImageView localImageView = (ImageView)localView.findViewById(2131232009);
    }
  }
  
  public void a()
  {
    if (a())
    {
      a(a()).show();
      return;
    }
    a(0).show();
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public Toast b(int paramInt)
  {
    Toast localToast = a(paramInt);
    localToast.show();
    return localToast;
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast
 * JD-Core Version:    0.7.0.1
 */