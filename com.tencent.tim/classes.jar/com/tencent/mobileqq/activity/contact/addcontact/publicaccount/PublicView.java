package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import abeg;
import abeg.a;
import acja;
import acje;
import amxk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import aqho;
import aqiw;
import auuo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FormMultiLineItem;
import com.tencent.widget.ListView;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import ocp;
import yqq;
import yqr;
import yqs;

public class PublicView
  extends ContactBaseView
  implements View.OnClickListener, auuo
{
  private TextView Lv;
  private ProgressBar T;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$b = new b(this);
  private boolean bof;
  private acje d = new yqr(this);
  private PullRefreshHeader g;
  private XListView mListView;
  private ArrayList<PublicRecommendAccountInfo> rf = new ArrayList();
  private long startTime;
  
  public PublicView(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  private void AA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.rf != null) && (this.rf.size() > 0)) {}
      this.rf = ((acja)this.app.getManager(56)).cz();
    }
    if ((this.rf == null) || ((this.rf != null) && (this.rf.size() == 0))) {
      showLoading();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a = new a(this.mContext, this.app, this.mListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a.notifyDataSetChanged();
      return;
      long l1 = System.currentTimeMillis();
      long l2 = this.startTime;
      if (QLog.isColorLevel()) {
        QLog.i("PublicView", 2, "PublicView onCreate used(milliseconds):" + (l1 - l2));
      }
      hideLoading();
    }
  }
  
  private boolean Ug()
  {
    if (aqiw.isNetworkAvailable(this.mContext))
    {
      bcI();
      return true;
    }
    ba(1, 2131696272);
    return false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      paramString2 = new Intent();
      paramString2.putExtra("source", paramInt3);
      ocp.a(paramString2, paramQQAppInterface, paramContext, paramString1, -7);
      return;
    }
    paramString1 = new Intent();
    paramString1.putExtra("uinname", paramString3);
    paramString1.putExtra("source", paramInt3);
    ocp.a(paramString1, paramQQAppInterface, paramContext, paramString2, paramInt2);
  }
  
  private void b(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ((PublicAccountHandler)this.app.getBusinessHandler(11)).a(paramSosoLbsInfo);
  }
  
  private void ba(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.mContext).isResume()) {
      QQToast.a(this.mContext, paramInt1, getResources().getString(paramInt2), 0).show(((BaseActivity)this.mContext).getTitleBarHeight());
    }
  }
  
  private void bcI()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        AppActivity localAppActivity = (AppActivity)this.mContext;
        localAppActivity.requestPermissions(new yqs(this, localAppActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      ckO();
      return;
    }
    ckO();
  }
  
  private void ckO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): BEGIN");
    }
    SosoInterface.a(new yqq(this, 1, true, true, 0L, false, false, "PublicView"));
    this.bof = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$b.sendEmptyMessageDelayed(4, 3000L);
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): END");
    }
  }
  
  private void ckP()
  {
    if (!this.bof) {
      b(null);
    }
  }
  
  private void hideLoading()
  {
    this.T.setVisibility(8);
  }
  
  private void initView()
  {
    this.T = ((ProgressBar)findViewById(2131377037));
    this.mListView = ((XListView)findViewById(2131373792));
    this.mListView.setContentBackground(2130838900);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    View localView = localLayoutInflater.inflate(2131561162, this.mListView, false);
    this.Lv = ((TextView)localView.findViewById(2131362232));
    this.Lv.setPadding(getResources().getDimensionPixelSize(2131298644), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130851338);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Lv.setCompoundDrawables(localDrawable, null, null, null);
    this.Lv.setFocusable(false);
    this.Lv.setCursorVisible(false);
    this.Lv.setOnClickListener(this);
    this.mListView.addHeaderView(localView, null, false);
    this.g = ((PullRefreshHeader)localLayoutInflater.inflate(2131559847, this.mListView, false));
    this.mListView.setOverScrollHeader(this.g);
    this.mListView.setOverScrollListener(this);
  }
  
  private void showLoading()
  {
    this.T.setVisibility(0);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.g.Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.g.S(0L);
    if (!Ug()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$b.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.g.R(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("PublicView", 1, "User requestPermissions denied, use default lbs info ...");
    ckP();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("PublicView", 1, "User requestPermissions grant...");
    ckO();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.cjO();
      amxk.d("add_page", "search", "active_frame", 3, 0, new String[] { "" });
      anot.a(this.app, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 3, 0, "", "", "", "");
      continue;
      c localc = (c)paramView.getTag();
      a(this.app, this.mContext, localc.a.mSource, localc.a.mEqqNameAccount, String.valueOf(localc.a.mPublicuin), localc.a.accountflag, localc.a.mPublicname, 3);
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      this.startTime = System.currentTimeMillis();
    }
    super.onCreate();
    setContentView(2131561161);
    initView();
    ((BaseActivity)this.mContext).addObserver(this.d);
    AA(true);
    bcI();
  }
  
  public void onDestroy()
  {
    ((BaseActivity)this.mContext).removeObserver(this.d);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$a.destroy();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public int xg()
  {
    return getResources().getDimensionPixelSize(2131298554);
  }
  
  class a
    extends abeg
  {
    public a(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
    {
      super(paramQQAppInterface, paramXListView, 1, true);
      paramXListView.setAdapter(this);
    }
    
    public PublicRecommendAccountInfo a(int paramInt)
    {
      if ((PublicView.a(PublicView.this) != null) && (paramInt >= 0) && (paramInt < PublicView.a(PublicView.this).size())) {
        return (PublicRecommendAccountInfo)PublicView.a(PublicView.this).get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      if ((PublicView.a(PublicView.this) != null) && (PublicView.a(PublicView.this).size() > 0)) {
        return PublicView.a(PublicView.this).size();
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (paramView == null)
      {
        localObject1 = new FormMultiLineItem(PublicView.this.mContext);
        ((View)localObject1).setId(2131374739);
        paramView = new PublicView.c();
        paramView.pQ = ((FormMultiLineItem)localObject1).G();
        paramView.rc = ((FormMultiLineItem)localObject1).a(0);
        paramView.rd = ((FormMultiLineItem)localObject1).a(1);
        ((View)localObject1).setTag(paramView);
        ((View)localObject1).setOnClickListener(PublicView.this);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = a(paramInt);
        if (localObject2 != null) {
          break;
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (PublicView.c)paramView.getTag();
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      if (((PublicRecommendAccountInfo)localObject2).mSource == 1)
      {
        paramView.uin = ((PublicRecommendAccountInfo)localObject2).mEqqNameAccount;
        label154:
        paramView.a = ((PublicRecommendAccountInfo)localObject2);
        paramView.rc.setVisibility(0);
        paramView.rd.setVisibility(0);
        paramView.pQ.setImageBitmap(a(1, paramView.uin));
        if (((PublicRecommendAccountInfo)localObject2).mSource != 1) {
          break label404;
        }
        paramView.rc.setText(((PublicRecommendAccountInfo)localObject2).mEqqCs);
        paramView.rd.setText(((PublicRecommendAccountInfo)localObject2).mEqqSi);
      }
      for (;;)
      {
        if ((((PublicRecommendAccountInfo)localObject2).mIsVerified != null) && (((PublicRecommendAccountInfo)localObject2).mIsVerified.equalsIgnoreCase("1")))
        {
          localObject2 = PublicView.this.getResources().getDrawable(2130842599);
          int i = (int)aqho.convertDpToPixel(PublicView.this.mContext, 15.0F);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          ((MultiImageTextView)paramView.rc).bl(6.0F);
          ((MultiImageTextView)paramView.rc).a((Drawable)localObject2, i, i);
          ((MultiImageTextView)paramView.rc).exh();
        }
        if (AppSetting.enableTalkBack)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramView.rc.getText().toString());
          ((StringBuilder)localObject2).append(paramView.rd.getText().toString());
          ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
        break;
        paramView.uin = String.valueOf(((PublicRecommendAccountInfo)localObject2).mPublicuin);
        break label154;
        label404:
        paramView.rc.setText(((PublicRecommendAccountInfo)localObject2).mPublicname);
        paramView.rd.setText(((PublicRecommendAccountInfo)localObject2).mPublicdesc);
      }
    }
  }
  
  public static class b
    extends Handler
  {
    private WeakReference<PublicView> eB;
    
    public b(PublicView paramPublicView)
    {
      this.eB = new WeakReference(paramPublicView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      PublicView localPublicView = (PublicView)this.eB.get();
      if (localPublicView == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        PublicView.a(localPublicView).springBackOverScrollHeaderView();
        return;
      case 2: 
        PublicView.a(localPublicView).springBackOverScrollHeaderView();
        PublicView.a(localPublicView, 1, 2131720480);
        return;
      case 3: 
        PublicView.a(localPublicView, true);
        return;
      }
      PublicView.b(localPublicView);
    }
  }
  
  static class c
    extends abeg.a
  {
    public PublicRecommendAccountInfo a;
    public TextView rc;
    public TextView rd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView
 * JD-Core Version:    0.7.0.1
 */