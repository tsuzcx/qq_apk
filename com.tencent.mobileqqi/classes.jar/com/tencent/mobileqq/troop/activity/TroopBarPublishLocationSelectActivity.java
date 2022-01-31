package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import gsx;
import gsy;
import gtb;
import gtc;
import java.util.ArrayList;

public class TroopBarPublishLocationSelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected static final int a = 1001;
  protected static final String a = "current_location_list";
  protected static final String b = "key_current_poi";
  protected static final String c = "key_selected_poi";
  protected static final String d = "refresh_all_poi";
  public long a;
  protected Drawable a;
  public Handler a;
  protected View a;
  protected TroopBarPublishLocationSelectActivity.LocListener a;
  public TroopBarPublishLocationSelectActivity.LocationAdapter a;
  final HttpWebCgiAsyncTask.Callback a;
  public final TroopBarUtils.MyLBSApiPOI a;
  protected PullRefreshHeader a;
  public XListView a;
  public ArrayList a;
  public TroopBarUtils.MyLBSApiPOI b = null;
  protected TroopBarUtils.MyLBSApiPOI c = null;
  
  public TroopBarPublishLocationSelectActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = new TroopBarUtils.MyLBSApiPOI("-1", "", "不显示", 0, "", 0, "");
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocListener = null;
    this.jdField_a_of_type_AndroidOsHandler = new gtb(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new gtc(this);
  }
  
  protected static final void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("lat", String.valueOf(paramInt1));
    localBundle1.putString("lon", String.valueOf(paramInt2));
    localBundle1.putString("num", String.valueOf(50));
    localBundle1.putString("start", String.valueOf(paramInt3));
    Bundle localBundle2 = new Bundle();
    if (paramBoolean) {
      localBundle2.putBoolean("refresh_all_poi", paramBoolean);
    }
    TroopBarUtils.a(paramBaseActivity, localBundle1, "http://xiaoqu.qq.com/cgi-bin/bar/user/poilist", 3, localBundle2, paramCallback);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.a = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(true);
    if (this.b != null)
    {
      a(this, this.b.b, this.b.a, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
      return;
    }
    e();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.c = ((TroopBarUtils.MyLBSApiPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232084);
    if (paramBoolean)
    {
      localTextView.setText(getString(2131559302));
      return;
    }
    localTextView.setText(2131563139);
  }
  
  public void b(boolean paramBoolean)
  {
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
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.equals(this.c)) {}
    for (Object localObject = null;; localObject = this.c)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_selected_poi", (Parcelable)localObject);
      setResult(-1, localIntent);
      return super.b();
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903325, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new gsy(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837852);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(2131560737);
    this.p.setImageResource(2130838429);
    this.p.setVisibility(0);
    this.p.setOnClickListener(this);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("current_location_list");
    this.c = ((TroopBarUtils.MyLBSApiPOI)paramBundle.getParcelableExtra("key_selected_poi"));
    if (this.c == null) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label346;
      }
    }
    label346:
    for (paramBundle = null;; paramBundle = (TroopBarUtils.MyLBSApiPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0))
    {
      this.b = paramBundle;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903325, null);
      d();
      paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232083);
      TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232084);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232085);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131231066);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131563139);
      localTextView2.setVisibility(8);
      paramBundle.setVisibility(8);
      localProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new gsx(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter = new TroopBarPublishLocationSelectActivity.LocationAdapter(this, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      a(0, true);
      return true;
    }
  }
  
  protected void e()
  {
    if (SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocListener = new TroopBarPublishLocationSelectActivity.LocListener(this, 1, 1, 4, 1);
      }
      SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocListener);
    }
  }
  
  public void onBackPressed()
  {
    b();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */