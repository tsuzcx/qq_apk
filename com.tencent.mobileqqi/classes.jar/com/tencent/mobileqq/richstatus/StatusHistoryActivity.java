package com.tencent.mobileqq.richstatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import glz;
import gma;
import gmb;
import gmc;
import gmd;
import gme;
import java.util.ArrayList;
import java.util.Arrays;

public class StatusHistoryActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, IIconListener, IStatusListener, ClickableColorSpanTextView.SpanClickListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  protected static final int a = 1;
  private static final long jdField_a_of_type_Long = 1000L;
  private static final String jdField_a_of_type_JavaLangString = "Q.richstatus.history";
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = null;
  private static final int jdField_c_of_type_Int = 23;
  private static final int jdField_d_of_type_Int = 24;
  private static final String jdField_d_of_type_JavaLangString = "key_profile_entry_type";
  private static final String jdField_e_of_type_JavaLangString = "key_allinone_pa";
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 3;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gmc(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = new gmb(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private gmd jdField_a_of_type_Gmd;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private int f = 24;
  private int o = 0;
  private int s = 0;
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131559280));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840228);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131559281));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131559282));
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, StatusHistoryActivity.class);
    localIntent.putExtra(jdField_b_of_type_JavaLangString, paramString);
    localIntent.putExtra("key_profile_entry_type", paramInt);
    localIntent.putExtra("key_allinone_pa", paramAllInOne);
    paramActivity.startActivity(localIntent);
  }
  
  private void b(boolean paramBoolean)
  {
    e();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(1, 2131562097);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(d());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 200) || (this.s != 0)) {}
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount();
      paramInt2 = 0;
      while (paramInt2 < i1)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(paramInt2).getTag();
        if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder)))
        {
          localObject = (StatusHistoryActivity.ItemViewHolder)localObject;
          if (((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b == paramInt1)
          {
            ((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.history", 2, "onGetIcon.actionid=" + paramInt1);
            }
          }
        }
        paramInt2 += 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    this.m.setEnabled(true);
    if (paramInt == 100) {
      a(true, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (Arrays.equals(((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a())))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        a(3);
        this.jdField_a_of_type_Gmd.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = paramClickableColorSpanTextView.getTag();
    if ((paramClickableColorSpanTextView instanceof StatusHistoryActivity.ItemViewHolder))
    {
      paramClickableColorSpanTextView = (StatusHistoryActivity.ItemViewHolder)paramClickableColorSpanTextView;
      if ((paramClickableColorSpanTextView != null) && (paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this, this.jdField_c_of_type_JavaLangString, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.c, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.d);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.s != paramInt)
    {
      this.s = paramInt;
      if (this.s == 0) {
        this.jdField_a_of_type_Gmd.notifyDataSetChanged();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1;
    if (NetworkUtil.e(this)) {
      if (paramBoolean1)
      {
        l1 = 2147483647L;
        int i1 = (int)l1;
        StatusServlet.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, 0, i1);
        label33:
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          a(1);
        }
        if (!paramBoolean2) {
          break label124;
        }
        e();
      }
    }
    label124:
    while (!paramBoolean1)
    {
      return;
      l1 = ((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a - 1L;
      break;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      if (paramBoolean1) {
        break label33;
      }
      this.o = 3;
      break label33;
    }
    d();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    a(true, true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e(2130903988);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra(jdField_b_of_type_JavaLangString);
    this.e = getIntent().getIntExtra("key_profile_entry_type", 999);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("key_allinone_pa"));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new gme(this, null);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    setTitle(getString(2131559276));
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_c_of_type_JavaLangString))
    {
      this.m.setVisibility(0);
      this.m.setText(getString(2131559277));
      this.m.setContentDescription("撰写个性签名入口");
      this.m.setOnClickListener(this);
      this.f = 23;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Modify_signature", "Clk_signature_list", this.f, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131234528));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837729);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903986, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231656));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231655));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837860);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903323, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollListener(this);
    this.jdField_a_of_type_Gmd = new gmd(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Gmd);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new glz(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.jdField_b_of_type_AndroidOsHandler = new gma(this, Looper.myLooper());
    a(true, false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    TextView localTextView = this.m;
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      super.doOnResume();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      e();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
    } while (paramMessage.arg1 != 1);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      a(2);
    }
    a(1, 2131562097);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.m)
    {
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("k_source", 4);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Modify_signature", "Modify_signature_list", ProfileActivity.a(this.e), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      startActivity(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.d();
      }
    }
    while ((!(paramView.getTag() instanceof StatusHistoryActivity.MoreViewHolder)) || (this.o != 3)) {
      return;
    }
    this.o = 1;
    this.jdField_a_of_type_Gmd.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusHistoryActivity
 * JD-Core Version:    0.7.0.1
 */