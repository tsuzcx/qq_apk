package com.tencent.mobileqq.activity.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import etv;
import etw;
import etx;
import ety;
import eua;
import eub;
import euc;
import eud;
import eue;
import euf;
import eug;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.nearfield_discuss.nearfield_discuss.Cell;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;
import tencent.im.nearfield_discuss.nearfield_discuss.Wifi;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final String a = "CreateFaceToFaceDiscussionActivity";
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  public Handler a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  public GridView a;
  public ImageView a;
  public LinearLayout a;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  public TextView a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private NearFieldDiscussObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver = new eub(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  public euf a;
  public StringBuffer a;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public List a;
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  public nearfield_discuss.UserProfile a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  public TranslateAnimation b;
  public ImageView b;
  public LinearLayout b;
  TableLayout jdField_b_of_type_AndroidWidgetTableLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  final int jdField_c_of_type_Int = 0;
  public View c;
  public ImageView c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  final int jdField_d_of_type_Int = 1;
  public ImageView d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  final int jdField_e_of_type_Int = 50;
  public ImageView e;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  final int jdField_f_of_type_Int = 11;
  public ImageView f;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public ImageView g;
  public ImageView h;
  public ImageView i;
  public ImageView j;
  public ImageView k;
  public ImageView l;
  public ImageView m;
  public ImageView n;
  public ImageView o;
  
  public CreateFaceToFaceDiscussionActivity()
  {
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(4);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = 60000L;
    this.jdField_a_of_type_AndroidOsHandler = new ety(this);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private nearfield_discuss.LBSInfo a()
  {
    long l1 = System.currentTimeMillis();
    nearfield_discuss.LBSInfo localLBSInfo = new nearfield_discuss.LBSInfo();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 == null) {
      return this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
    }
    Object localObject2 = new nearfield_discuss.GPS();
    ((nearfield_discuss.GPS)localObject2).int32_lat.set(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int);
    ((nearfield_discuss.GPS)localObject2).int32_lon.set(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Int);
    ((nearfield_discuss.GPS)localObject2).int32_alt.set(-1);
    ((nearfield_discuss.GPS)localObject2).eType.set(0);
    localLBSInfo.msg_gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        nearfield_discuss.Wifi localWifi = new nearfield_discuss.Wifi();
        localWifi.uint64_mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
        localWifi.int32_rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
        localLBSInfo.rpt_msg_wifis.add(localWifi);
      }
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localObject3 = new nearfield_discuss.Cell();
        ((nearfield_discuss.Cell)localObject3).int32_mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
        ((nearfield_discuss.Cell)localObject3).int32_mnc.set(((SosoInterface.SosoCell)localObject2).jdField_b_of_type_Int);
        ((nearfield_discuss.Cell)localObject3).int32_lac.set(((SosoInterface.SosoCell)localObject2).jdField_c_of_type_Int);
        ((nearfield_discuss.Cell)localObject3).int32_cellid.set(((SosoInterface.SosoCell)localObject2).jdField_d_of_type_Int);
        ((nearfield_discuss.Cell)localObject3).int32_rssi.set(((SosoInterface.SosoCell)localObject2).jdField_e_of_type_Int);
        localLBSInfo.rpt_msg_cells.add((MessageMicro)localObject3);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, "getLBS cost:" + (l2 - l1));
    }
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo = localLBSInfo;
    return localLBSInfo;
  }
  
  private void a(View paramView)
  {
    paramView = (eug)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838763);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    paramView.jdField_a_of_type_JavaLangString = "";
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(null);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    eug localeug = (eug)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localeug.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46));
    }
    if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(str))) {}
    for (paramView = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str);; paramView = paramUserProfile)
    {
      localeug.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localeug.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localeug.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + "头像");
      localeug.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void e()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234431));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234432));
    this.g = ((ImageView)findViewById(2131234433));
    this.h = ((ImageView)findViewById(2131234434));
    this.i = ((ImageView)findViewById(2131234435));
    this.j = ((ImageView)findViewById(2131234436));
    this.k = ((ImageView)findViewById(2131234437));
    this.l = ((ImageView)findViewById(2131234438));
    this.m = ((ImageView)findViewById(2131234439));
    this.n = ((ImageView)findViewById(2131234441));
    this.o = ((ImageView)findViewById(2131234442));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234444));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234445));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234446));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234447));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234449);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837860);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131230974));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234453));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234448));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131562030));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131234430));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131234443));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234450));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131234451);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231457));
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131562264));
    getSupportActionBar().setTitle(2131562264);
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131562264));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131561746);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription("取消，按钮");
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(new etx(this));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233305));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131234452);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(400L);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.start();
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetTextView.getBottom());
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new eua(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void g()
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131427376));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562717);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new euc(this));
      return;
    }
    a(1, getString(2131562488));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_AndroidWidgetGridView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof eug)))
      {
        localObject = (eug)localObject;
        if (((eug)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((eug)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      paramInt1 += 1;
    }
  }
  
  void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  protected void b()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AC", "0X80041AC", 0, 0, "", "", "", "");
  }
  
  String c()
  {
    int i1 = 0;
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    int i2 = this.jdField_a_of_type_JavaLangStringBuffer.length();
    if (i2 > 0) {
      while (i1 < i2)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangStringBuffer.charAt(i1));
        if (i1 < i2 - 1) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(65292);
        }
        i1 += 1;
      }
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  protected void c()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AB", "0X80041AB", 0, 0, "", "", "", "");
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624539);
    super.doOnCreate(paramBundle);
    setContentView(2130903955);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    e();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_b_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Euf = new euf(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131230904));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Euf);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.str_nick.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new etv(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new etw(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.jdField_a_of_type_Boolean) && (NetworkUtil.e(this))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new eue(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      this.jdField_a_of_type_Boolean = false;
      g();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AF", "0X80041AF", 0, 0, String.valueOf(this.jdField_a_of_type_JavaUtilList.size()), "", "", "");
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_JavaLangStringBuffer.length();
    } while (i1 >= 4);
    label144:
    int i2;
    switch (paramView.getId())
    {
    case 2131234440: 
    default: 
      this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(c());
      i2 = this.jdField_a_of_type_JavaLangStringBuffer.length();
      i1 = -1;
      switch (this.jdField_a_of_type_JavaLangStringBuffer.charAt(i2 - 1))
      {
      }
      break;
    }
    for (;;)
    {
      switch (i2)
      {
      default: 
        return;
      case 1: 
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
        return;
        this.jdField_a_of_type_JavaLangStringBuffer.append('1');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('2');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('3');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('4');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('5');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('6');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('7');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('8');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('9');
        break label144;
        this.jdField_a_of_type_JavaLangStringBuffer.append('0');
        break label144;
        if ((i1 > 0) && (i1 < 4)) {
          this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(i1 - 1);
        }
        this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(c());
        switch (i1)
        {
        default: 
          return;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838932);
          return;
        case 2: 
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838932);
          return;
        case 3: 
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838932);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838932);
        return;
        i1 = 2130838779;
        continue;
        i1 = 2130838780;
        continue;
        i1 = 2130838781;
        continue;
        i1 = 2130838782;
        continue;
        i1 = 2130838783;
        continue;
        i1 = 2130838927;
        continue;
        i1 = 2130838928;
        continue;
        i1 = 2130838929;
        continue;
        i1 = 2130838930;
        continue;
        i1 = 2130838931;
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i1);
    return;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i1);
    return;
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i1);
    this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
    this.g.setEnabled(false);
    this.h.setEnabled(false);
    this.i.setEnabled(false);
    this.j.setEnabled(false);
    this.k.setEnabled(false);
    this.l.setEnabled(false);
    this.m.setEnabled(false);
    this.n.setEnabled(false);
    this.o.setEnabled(false);
    if ((this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("1234")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("1111")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("2222")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("3333")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("0000")))
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131562527), 0).a();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new eud(this));
      return;
    }
    a(1, getString(2131562488));
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */