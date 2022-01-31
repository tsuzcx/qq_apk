package com.tencent.av.gaudio;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhu;
import bhv;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  public static String b;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Rect a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bhu(this);
  public RelativeLayout a;
  public ShimmerTextView a;
  public Rect b;
  public ImageView b;
  public int c;
  public Rect c;
  public ImageView c;
  public int d;
  public ImageView d;
  TextView d;
  public int e = 0;
  
  static
  {
    jdField_b_of_type_JavaLangString = "GaInviteLockActivity";
  }
  
  public GaInviteLockActivity()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800420D", "0X800420D", 0, 0, "", "", "", "");
    g();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232224));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232225));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232233));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131232234));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232238));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BitmapTools.a(super.getApplicationContext(), 2130838263);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232237));
    this.jdField_d_of_type_Int = super.getApplicationContext().getResources().getDimensionPixelSize(2131427678);
    this.e = super.getApplicationContext().getResources().getDimensionPixelSize(2131427679);
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)super.findViewById(2131232239));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232240));
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131232231);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232228));
      if ((!NetworkUtil.g(super.getApplicationContext())) && ((NetworkUtil.d(super.getApplicationContext())) || (NetworkUtil.c(super.getApplicationContext()))))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131560238);
      }
      super.a();
      return;
      localRelativeLayout.setBackgroundResource(2130838263);
    }
  }
  
  public void g()
  {
    super.c();
  }
  
  public void h()
  {
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect.top = this.jdField_b_of_type_AndroidWidgetImageView.getTop();
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.jdField_b_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_b_of_type_AndroidGraphicsRect.left = this.jdField_b_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_b_of_type_AndroidGraphicsRect.right = this.jdField_b_of_type_AndroidWidgetImageView.getRight();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_b_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_b_of_type_AndroidWidgetImageView.getRight();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_AndroidGraphicsRect.top = this.jdField_d_of_type_AndroidWidgetImageView.getTop();
    this.jdField_c_of_type_AndroidGraphicsRect.bottom = this.jdField_d_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_c_of_type_AndroidGraphicsRect.left = this.jdField_d_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_c_of_type_AndroidGraphicsRect.right = this.jdField_d_of_type_AndroidWidgetImageView.getRight();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    this.jdField_a_of_type_Int = UITools.a(getApplicationContext());
    this.jdField_b_of_type_Int = UITools.b(getApplicationContext());
    super.onCreate(paramBundle);
    super.setContentView(2130903350);
    a();
    f();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bhv(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ReportController.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */