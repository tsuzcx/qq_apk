package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import gwz;
import gxc;
import gxd;
import java.util.ArrayList;

public class TroopBarPublishBarSelectActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  protected static final int a = 1001;
  public static final String a = "key_selected_item";
  public long a;
  protected Drawable a;
  public Handler a;
  protected View a;
  public TextView a;
  public TroopBarPublishBarSelectActivity.MyBarListAdapter a;
  public final HttpWebCgiAsyncTask.Callback a;
  protected TroopBarUtils.MyBar a;
  protected PullRefreshHeader a;
  public XListView a;
  public ArrayList a;
  protected boolean a;
  public int b;
  protected View b;
  
  public TroopBarPublishBarSelectActivity()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new gxc(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new gxd(this);
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
  
  public final void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
    TroopBarUtils.a(paramBaseActivity, new Bundle(), "http://xiaoqu.qq.com/cgi-bin/bar/mybarlist", 5, new Bundle(), paramCallback);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 1) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = ((TroopBarUtils.MyBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar);
    setResult(-1, paramAdapterView);
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232081);
    if (paramBoolean)
    {
      localTextView.setText(getString(2131559301));
      return;
    }
    localTextView.setText(2131563139);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if ((this.l != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837854);
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
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903323, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new gwz(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8355712);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837729);
    int i = paramBundle.getDimensionPixelSize(2131427568);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    i = paramBundle.getDimensionPixelSize(2131427567);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903323, null);
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232080);
    TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232081);
    TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232082);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131231066);
    localTextView1.setTextColor(-8355712);
    localTextView1.setText(2131563139);
    localTextView2.setVisibility(8);
    localImageView.setVisibility(8);
    localProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837850);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    d();
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter = new TroopBarPublishBarSelectActivity.MyBarListAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = ((TroopBarUtils.MyBar)getIntent().getParcelableExtra("key_selected_item"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle.getString(2131560721, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
    setTitle(2131560738);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
    for (paramBundle = "0";; paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "exp_tribe", paramBundle, "0", "", "");
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity
 * JD-Core Version:    0.7.0.1
 */