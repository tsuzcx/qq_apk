package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import dve;
import dvf;
import dvg;
import dvk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements FaceDecoder.DecodeTaskCompletionListener, AdapterView.OnItemClickListener, OverScrollViewListener
{
  protected static final int a = 0;
  protected static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "visitors_last_refresh_time";
  protected static final int c = 3;
  protected static final int d = 4;
  protected static final int e = 5;
  static final long jdField_e_of_type_Long = 800L;
  protected static int f = 0;
  static final int h = 1;
  static final int i = 2;
  static final int j = 3;
  static final int k = 800;
  static final int l = 1000;
  static final int m = 0;
  static final int n = 1;
  static final int o = 2;
  static final int p = 2;
  static final int q = 3;
  static final int r = 4;
  public long a;
  public SharedPreferences a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new dve(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dvf(this);
  View jdField_a_of_type_AndroidViewView;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dvg(this);
  protected FriendManager a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public GridListView a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public dvk a;
  protected String a;
  public ArrayList a;
  public HashMap a;
  public boolean a;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  private boolean d;
  private boolean jdField_e_of_type_Boolean;
  protected int g = 0;
  private int s;
  
  public VisitorsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = null;
    this.e = false;
    this.jdField_d_of_type_Long = 0L;
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt - 1) * 6 + 14)) / paramInt;
  }
  
  private long a()
  {
    return a().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void a(long paramLong)
  {
    a().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", paramLong).commit();
  }
  
  private void a(Configuration paramConfiguration)
  {
    if (getResources().getConfiguration().orientation == 2) {}
    for (int i1 = 6;; i1 = 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(i1);
      this.g = a(i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(this.g);
      i1 = (int)(getResources().getDisplayMetrics().density * 6.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(i1, i1);
      return;
    }
  }
  
  private void a(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.getLEctID()), 41);
    localAllInOne.g = paramCardProfile.getStrNick();
    localAllInOne.b = paramCardProfile.getBAge();
    localAllInOne.jdField_a_of_type_Byte = paramCardProfile.getBSex();
    localAllInOne.jdField_a_of_type_Short = paramCardProfile.getWFace();
    if (paramCardProfile.getVIntroContent() != null) {}
    try
    {
      new String(paramCardProfile.getVIntroContent(), "utf-8");
      paramCardProfile = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(localAllInOne.jdField_a_of_type_JavaLangString);
      if ((paramCardProfile != null) && (paramCardProfile.isFriend())) {
        localAllInOne.jdField_a_of_type_Int = 1;
      }
      ProfileActivity.a(this, localAllInOne);
      return;
    }
    catch (UnsupportedEncodingException paramCardProfile)
    {
      for (;;)
      {
        paramCardProfile.printStackTrace();
      }
    }
    catch (NullPointerException paramCardProfile)
    {
      for (;;)
      {
        paramCardProfile.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(System.currentTimeMillis());
    if (!e())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131562097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131234659));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Dvk);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("visitor_grid", false);
    GridListView localGridListView = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localGridListView.setMode(i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollListener(this);
      return;
    }
  }
  
  private void g()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    for (this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b();; this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a())
    {
      this.jdField_a_of_type_Dvk = new dvk(this, this.jdField_a_of_type_JavaUtilArrayList);
      d();
      if (!a(true)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      }
      return;
    }
  }
  
  private void h()
  {
    if (!a(false))
    {
      a(1, getString(2131562097));
      return;
    }
    this.jdField_a_of_type_Dvk.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Dvk.notifyDataSetChanged();
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130904049, null);
  }
  
  protected View a()
  {
    super.a();
    TextView localTextView = this.m;
    if (this.jdField_d_of_type_Boolean) {
      this.m.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
        {
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        }
        if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("visitor_grid", false)) {
          continue;
        }
        i1 = 2131562286;
        localTextView.setText(i1);
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
        continue;
      }
      return this.m;
      this.m.setVisibility(8);
      continue;
      i1 = 2131562177;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis() - this.jdField_d_of_type_Long;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if ((paramInt1 == 0) || (l1 >= 800L))
    {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Dvk.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l1);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(this.s);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (this.jdField_a_of_type_Dvk.getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
    case 2: 
      a((CardProfile)this.jdField_a_of_type_Dvk.getItem(paramInt));
      return;
    }
    h();
  }
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false);
      localBitmap1 = a();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    TextView localTextView = this.m;
    if (paramArrayList.size() > 0) {
      localTextView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_a_of_type_Dvk.a(paramArrayList);
      this.jdField_a_of_type_Dvk.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      if (paramLong == 0L) {
        a(true);
      }
      this.jdField_a_of_type_Dvk.notifyDataSetChanged();
      return;
      localTextView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!e()) && (!a(true))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.e(this)) {
      return false;
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, 0L, 30);
      continue;
      if (this.jdField_b_of_type_Long > -1L) {
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long, 30);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, 30);
        }
      }
    }
  }
  
  protected View a_()
  {
    super.a_();
    TextView localTextView = this.l;
    if (this.jdField_c_of_type_Boolean) {}
    for (int i1 = 2131563212;; i1 = 2131563299)
    {
      localTextView.setText(i1);
      if (getSupportActionBar() != null) {
        getSupportActionBar().setTitle(this.l.getText());
      }
      return this.l;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    }
    QQToast.a(this, 1, 2131562097, 0).b(d());
    a(false);
    if (this.jdField_a_of_type_Dvk.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Dvk.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Dvk.notifyDataSetChanged();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    a(paramConfiguration);
    if (this.jdField_a_of_type_Dvk.getCount() <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_JavaLangString = String.valueOf(getIntent().getLongExtra("toUin", 0L));
    if ((this.jdField_a_of_type_JavaLangString != null) && (!paramBundle.equals(this.jdField_a_of_type_JavaLangString))) {}
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("votersOnly", false);
    this.jdField_b_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    this.jdField_c_of_type_Long = getIntent().getLongExtra("nextMidVisitor", -1L);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("hasVoters", true);
    this.e = getIntent().getBooleanExtra("isStartedByProfileCard", false);
    setContentView(2130904050);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    f = CardHandler.a(this);
    this.s = (getResources().getDimensionPixelSize(2131427376) - (int)DisplayUtils.a(a(), 5.0F));
    i();
    g();
    f();
    a(getResources().getConfiguration());
    e();
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903216, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity
 * JD-Core Version:    0.7.0.1
 */