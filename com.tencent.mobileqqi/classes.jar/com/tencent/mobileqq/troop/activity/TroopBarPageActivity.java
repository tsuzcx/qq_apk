package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.TroopBarPostAdapter;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import gry;
import grz;
import gsa;
import gsb;
import gse;
import gsf;
import gsg;
import java.util.List;
import mqq.util.WeakReference;

public class TroopBarPageActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static final int a = 1001;
  public static final String a = "post_type";
  public static boolean a = false;
  protected static final int b = 2001;
  public static final String b = "change_post_type";
  protected static final int c = 1;
  public static final String c = "refresh_page";
  public static final String d = "sub_action";
  public static final String e = "show_loading";
  public static final String f = "hide_loading";
  public static final String g = "follow";
  public static final String h = "sign_in";
  public static final String i = "broadcast_data";
  public static final String j = "isend";
  protected static final String k = "start_post_index";
  protected static final String l = "clear_data";
  public static final String m = "troop_bar_native";
  public static final String n = "bid";
  public static final String o = "id=?";
  public static final String p = "bid=? and type = ?";
  public static final String q = "bid=? and type = ? and id = ?";
  public long a;
  protected BroadcastReceiver a;
  protected Drawable a;
  public Handler a;
  public SparseArray a;
  protected View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TroopBarPageEntity a;
  final HttpWebCgiAsyncTask.Callback jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new gsf(this);
  public TroopBarPostAdapter a;
  protected PullRefreshHeader a;
  public XListView a;
  private LinearLayout b;
  public boolean b;
  public boolean c = false;
  public String r = null;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public TroopBarPageActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new gse(this);
  }
  
  private void h()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131560688, 5);
    localActionSheet.a(2131560689, 5);
    localActionSheet.d(2131561746);
    localActionSheet.a(new gsa(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "jumpToRecentListToShare");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {
      return;
    }
    String str1 = getString(2131560698) + "-" + this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.name;
    String str2 = getString(2131560699);
    String str3 = String.format("http://xiaoqu.qq.com/cgi-bin/bar/jump?bid=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.id });
    ShareMsgHelper.a(this, 1001, 1, "web_share", "", this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.pic, str1, str2, getString(2131560698), str3, "web", null, null, null, "web", null, null, null, null, getString(2131560690), "http://xiaoqu.qq.com/cgi-bin/bar/jump?target=hot&_wv=1031");
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public void a(TroopBarPageEntity.TypeListEntity paramTypeListEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter != null)
    {
      paramTypeListEntity = TroopBarUtils.a(TroopBarPostEntity.class, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "bid=? and type = ?", new String[] { this.r, String.valueOf(paramTypeListEntity.type) }, String.valueOf(20));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(paramTypeListEntity);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
    c(false);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("bid", paramString);
    switch (paramInt)
    {
    default: 
      paramString = "http://xiaoqu.qq.com/cgi-bin/bar/get_category_post_by_page";
      localBundle1.putString("category", String.valueOf(paramInt));
      localBundle1.putString("barlevel", "1");
      localBundle1.putString("startindex", String.valueOf(paramLong));
    }
    for (;;)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putLong("start_post_index", paramLong);
      localBundle2.putBoolean("clear_data", paramBoolean1);
      TroopBarUtils.a(this, localBundle1, paramString, paramInt, localBundle2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
      return;
      paramString = "http://xiaoqu.qq.com/cgi-bin/bar/get_post_by_page";
      localBundle1.putString("start", String.valueOf(paramLong));
      localBundle1.putString("barlevel", "1");
      localBundle1.putString("num", String.valueOf(20));
      continue;
      paramString = "http://xiaoqu.qq.com/cgi-bin/bar/get_best_post_by_page";
      localBundle1.putString("start", String.valueOf(paramLong));
      localBundle1.putString("barlevel", "1");
      localBundle1.putString("num", String.valueOf(20));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", String.valueOf(paramString));
    paramString = new Bundle();
    paramString.putBoolean("requestPageOnly", paramBoolean1);
    TroopBarUtils.a(this, localBundle, "http://xiaoqu.qq.com/cgi-bin/bar/page", 0, paramString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    TroopBarPageEntity localTroopBarPageEntity;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null)
    {
      localObject = TroopBarUtils.a;
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = ((TroopBarPageEntity)TroopBarUtils.a(TroopBarPageEntity.class, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, new String[] { this.r }));
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity != null)
        {
          localTroopBarPageEntity = this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity;
          if (localObject != null) {
            break label167;
          }
          localObject = TroopBarUtils.a;
        }
      }
    }
    label167:
    for (;;)
    {
      localTroopBarPageEntity.curType = ((TroopBarPageEntity.TypeListEntity)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
      localObject = TroopBarUtils.a(TroopBarPostEntity.class, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "bid=? and type = ?", new String[] { this.r, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType.type) }, String.valueOf(20));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
      a(this.r, false, false);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType;
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if ((this.l != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837856);
        this.l.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    while ((this.l == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.l.setCompoundDrawables(null, null, null, null);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232083);
    if (paramBoolean)
    {
      localTextView.setText(getString(2131559300));
      return;
    }
    localTextView.setText(2131563139);
  }
  
  @TargetApi(11)
  protected void d()
  {
    TextView localTextView = (TextView)findViewById(2131230976);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new gry(this, localTextView));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903404);
    this.r = getIntent().getStringExtra("bid");
    TroopBarUtils.a("visit", this.r, "");
    if (this.r == null)
    {
      finish();
      return false;
    }
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    e();
    f();
    d();
    a(true);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gsg(this);
    paramBundle = new IntentFilter("change_post_type");
    paramBundle.addAction("refresh_page");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  protected void doOnStart()
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    a(this.r, true, false);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231460));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838011);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131560705));
  }
  
  protected void f()
  {
    setTitle(2131560691);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232487));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    g();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903325, null);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232082);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232083);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232084);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131231066);
    localTextView1.setTextColor(-8355712);
    localTextView1.setText(2131563139);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(getLayoutInflater().inflate(2130903216, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter = new TroopBarPostAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new grz(this));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232488));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903325, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new gsb(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      h();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null);
    TroopBarUtils.a(this, "publish", new String[] { "&bid=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.id, "&flag=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.flag });
    TroopBarUtils.a("Clk_pub", this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.id, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPageActivity
 * JD-Core Version:    0.7.0.1
 */