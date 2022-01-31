package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ble;
import blf;
import com.tencent.av.VideoController;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class VideoInviteLock
  extends VideoInviteActivity
{
  public static String g = "VideoInviteLock";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public Rect a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new blf(this);
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public RelativeLayout a;
  public ShimmerTextView a;
  public Rect b;
  public ImageView b;
  public Rect c;
  public ImageView c;
  public ImageView d;
  int i;
  public int j = 0;
  int k = 0;
  public int l = 0;
  public int m = 0;
  
  public VideoInviteLock()
  {
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232235: 
      this.jdField_d_of_type_Boolean = false;
      b();
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8004202", "0X8004202", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004206", "0X8004206", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    c();
    ReportController.b(null, "CliOper", "", "", "0X8004207", "", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
  }
  
  protected void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131232266);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131232272));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232237));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232238));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232273));
    this.l = super.getApplicationContext().getResources().getDimensionPixelSize(2131427678);
    this.m = super.getApplicationContext().getResources().getDimensionPixelSize(2131427679);
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)super.findViewById(2131232239));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232240));
    Drawable localDrawable = BitmapTools.a(getApplicationContext(), 2130838263);
    if (localDrawable != null)
    {
      localRelativeLayout.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232269));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232270));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232267));
      if (!this.jdField_b_of_type_Boolean) {
        break label253;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560237);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838276);
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, getResources().getString(2131560237));
    }
    for (;;)
    {
      g();
      return;
      localRelativeLayout.setBackgroundResource(2130838263);
      break;
      label253:
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, getResources().getString(2131560129));
    }
  }
  
  public void i()
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
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onCreate");
    }
    AVReport.a().s = SystemClock.elapsedRealtime();
    super.onCreate(paramBundle);
    this.i = UITools.b(super.getApplicationContext());
    super.setContentView(2130903355);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    if (!this.jdField_c_of_type_Boolean) {
      super.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ble(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a();
    paramBundle = (TextView)findViewById(2131232271);
    if (!NetworkUtil.g(getApplicationContext()))
    {
      if (NetworkUtil.c(getApplicationContext()))
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560239);
      }
      if (NetworkUtil.d(getApplicationContext()))
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560238);
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X800439D", "0X800439D", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle.setVisibility(0);
        paramBundle.setText(2131560220);
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X80043FC", "0X80043FC", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "onDestroy");
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
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
      if (this.jdField_b_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_d_of_type_Int), Integer.toString(this.f), "", "");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AVReport.a().t = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteLock
 * JD-Core Version:    0.7.0.1
 */