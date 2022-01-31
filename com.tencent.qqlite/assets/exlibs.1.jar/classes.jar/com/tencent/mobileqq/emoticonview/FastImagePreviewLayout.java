package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dfg;
import dfh;

public class FastImagePreviewLayout
  extends LinearLayout
{
  public static final long a = 2000L;
  public static String a;
  float a;
  public Context a;
  public Handler a;
  public URLDrawable a;
  final String b = "/tencent/zebra/cache/";
  
  static
  {
    jdField_a_of_type_JavaLangString = FastImagePreviewLayout.class.getSimpleName();
  }
  
  public FastImagePreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showFastImage called");
    }
    Object localObject = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903063, null);
    ((ImageView)((View)localObject).findViewById(2131296547)).setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    addView((View)localObject);
    setVisibility(0);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    setAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeFastImage called");
    }
    setVisibility(8);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      setAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new dfg(this));
      return;
    }
    removeAllViews();
  }
  
  public void b()
  {
    ThreadManager.b().post(new dfh(this));
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout
 * JD-Core Version:    0.7.0.1
 */