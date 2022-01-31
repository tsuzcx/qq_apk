package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class HornAnimationView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final int c = 0;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 2000L;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  View jdField_a_of_type_AndroidViewView;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  NearHornHandler jdField_a_of_type_ComTencentMobileqqAppNearHornHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  HornAnimationView.OnHornItemClickObserver jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView$OnHornItemClickObserver;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  View c;
  View d;
  
  public HornAnimationView(Context paramContext, QQAppInterface paramQQAppInterface, List paramList, HornAnimationView.OnHornItemClickObserver paramOnHornItemClickObserver)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView$OnHornItemClickObserver = paramOnHornItemClickObserver;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = ((NearHornHandler)paramQQAppInterface.a(31));
    a(paramList);
  }
  
  private void b(View paramView)
  {
    paramView.setOnClickListener(this);
    ((ImageView)paramView.findViewById(2131230940)).setOnClickListener(this);
  }
  
  private void c(View paramView)
  {
    paramView.setOnClickListener(null);
    ((ImageView)paramView.findViewById(2131230940)).setOnClickListener(null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.g * 1000);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidViewView.getTag() != null) && (paramString.equals(((HornDetail)this.jdField_a_of_type_AndroidViewView.getTag()).uin))) {
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131230940)).setImageBitmap(paramBitmap);
      }
    } while ((this.jdField_b_of_type_AndroidViewView.getTag() == null) || (!paramString.equals(((HornDetail)this.jdField_b_of_type_AndroidViewView.getTag()).uin)));
    ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131230940)).setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1) {
      i = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        this.jdField_a_of_type_Int = 0;
      }
      HornDetail localHornDetail = (HornDetail)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131230940);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131231980);
      TextView localTextView = (TextView)paramView.findViewById(2131230989);
      AnimationTextView localAnimationTextView = (AnimationTextView)paramView.findViewById(2131233355);
      localAnimationTextView.setSpannableFactory(QQText.a);
      a(localHornDetail.uin, 0, localImageView1);
      localTextView.setText(localHornDetail.nickName);
      localAnimationTextView.setText(localHornDetail.content);
      localImageView2.setVisibility(0);
      localImageView2.setVisibility(8);
      localImageView1.setTag(localHornDetail);
      paramView.setTag(localHornDetail);
      return;
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
    }
  }
  
  protected void a(String paramString, int paramInt, ImageView paramImageView)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false, (byte)1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
      }
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  public void a(List paramList)
  {
    setDataSet(paramList);
    this.jdField_a_of_type_Int = -1;
    paramList = LayoutInflater.from(getContext());
    this.c = paramList.inflate(2130903671, null);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = this.c;
    this.d = paramList.inflate(2130903671, null);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = this.d;
    a(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    addView(this.c);
    addView(this.d);
    b(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    if ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      d();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_Int = -1;
    setDataSet(paramList);
    b();
    a(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_b_of_type_AndroidViewView);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = null;
  }
  
  public void d()
  {
    if (this.c == this.jdField_a_of_type_AndroidViewView)
    {
      this.jdField_b_of_type_AndroidViewView = this.c;
      this.jdField_a_of_type_AndroidViewView = this.d;
      return;
    }
    this.jdField_b_of_type_AndroidViewView = this.d;
    this.jdField_a_of_type_AndroidViewView = this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) && (this.jdField_a_of_type_AndroidViewView.getAnimation() != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_Int += 1;
    }
    if ((paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) && (this.jdField_b_of_type_AndroidViewView.getAnimation() != null)) {
      this.jdField_b_of_type_Int += 1;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      d();
      a(this.jdField_b_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.g * 1000);
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      c(this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView$OnHornItemClickObserver.a(paramView);
  }
  
  public void setDataSet(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.HornAnimationView
 * JD-Core Version:    0.7.0.1
 */