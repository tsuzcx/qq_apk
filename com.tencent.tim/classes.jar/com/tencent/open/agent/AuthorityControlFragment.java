package com.tencent.open.agent;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqju;
import arhz;
import arpj;
import arpk;
import arpl;
import arpm;
import arpn;
import arpo;
import arpp;
import artf;
import asat;
import asau;
import auuo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AuthorityControlFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  View.OnTouchListener D;
  @NonNull
  private ArrayList<AppInfo> Dt = new ArrayList();
  private View JP;
  private XListView Y;
  private arhz jdField_a_of_type_Arhz;
  private artf jdField_a_of_type_Artf;
  private asat jdField_a_of_type_Asat;
  private asau jdField_a_of_type_Asau;
  private TextView acE;
  private QQAppInterface app;
  private auuo d;
  private PullRefreshHeader e;
  private Context mContext;
  private ColorStateList r;
  
  private void Ue(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.e.tT(0);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new AuthorityControlFragment.5(this), 800L);
      return;
      this.e.tT(1);
    }
  }
  
  private void aAz()
  {
    this.d = new arpk(this);
  }
  
  public static void bx(Activity paramActivity)
  {
    PublicFragmentActivity.start(paramActivity, AuthorityControlFragment.class);
  }
  
  private void ekV()
  {
    this.jdField_a_of_type_Asau = new arpm(this);
  }
  
  private void ekW()
  {
    this.Y.setVisibility(8);
    this.acE.setVisibility(8);
    this.JP.setVisibility(0);
    this.rightViewText.setVisibility(8);
    setLeftButton("", null);
    this.mLeftBackIcon.setVisibility(0);
  }
  
  private void ekX()
  {
    this.jdField_a_of_type_Artf.elH();
    setTextWithTalk(this.rightViewText, 2131690650);
    this.rightViewText.setTextColor(getResources().getColorStateList(2131165366));
    this.rightViewText.setOnTouchListener(this.D);
    this.rightViewText.setEnabled(false);
    setLeftButton(2131721058, new arpn(this));
    Object localObject = this.leftViewNotBack.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).setMargins(18, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.leftView.setVisibility(8);
    this.acE.setText(2131718781);
    this.Y.setOverScrollHeader(null);
    Ue(true);
  }
  
  private void ekY()
  {
    Object localObject1 = this.jdField_a_of_type_Artf.gR();
    if (((List)localObject1).size() == 0) {
      return;
    }
    Object localObject2 = new arpo(this, (List)localObject1);
    arpp localarpp = new arpp(this);
    if (((List)localObject1).size() == 1) {
      localObject1 = this.mContext.getResources().getString(2131718780);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_Artf.gR().size();
      String str = String.format(acfp.m(2131702928), new Object[] { Integer.valueOf(i) });
      localObject1 = aqha.a(this.mContext, 230, str, (String)localObject1, 2131721058, 2131721079, (DialogInterface.OnClickListener)localObject2, localarpp);
      try
      {
        ((aqju)localObject1).show();
        label123:
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_Artf.gR().iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(String.valueOf(((AppInfo)((Iterator)localObject2).next()).getId()));
            ((StringBuilder)localObject1).append(" ");
            continue;
            localObject1 = acfp.m(2131702925);
            break;
          }
        }
        anot.a(this.app, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", ((StringBuilder)localObject1).toString(), "");
        return;
      }
      catch (Throwable localThrowable)
      {
        break label123;
      }
    }
  }
  
  private void initViews()
  {
    setTitle(getString(2131690647));
    this.jdField_a_of_type_Artf = new artf(this, this.app);
    this.Y = ((XListView)findViewById(2131370585));
    this.e = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559847, null, false));
    this.Y.setOverScrollHeader(this.e);
    this.Y.setOverScrollListener(this.d);
    View localView = LayoutInflater.from(this.mContext).inflate(2131558760, this.Y, false);
    this.Y.addHeaderView(localView);
    this.JP = findViewById(2131366400);
    this.acE = ((TextView)localView.findViewById(2131363122));
    this.Y.setAdapter(this.jdField_a_of_type_Artf);
    this.jdField_a_of_type_Arhz = new arhz(this.mContext, this.mContext.getResources().getDimensionPixelSize(2131299627));
    this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131702936));
    this.jdField_a_of_type_Arhz.setBackAndSearchFilter(false);
    this.jdField_a_of_type_Arhz.setOnCancelListener(new arpl(this));
  }
  
  private void onInit()
  {
    this.app = getActivity().app;
    this.mContext = getActivity();
    aAz();
    initViews();
    ekV();
    if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication))
    {
      QQToast.a(this.mContext, 2131693404, 0).show();
      ekW();
      return;
    }
    this.jdField_a_of_type_Asat = ((asat)this.app.getBusinessHandler(151));
    this.jdField_a_of_type_Asat.emy();
    try
    {
      this.jdField_a_of_type_Arhz.show();
      label91:
      this.r = this.rightViewText.getTextColors();
      this.D = new arpj(this);
      anot.a(this.app, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label91;
    }
  }
  
  protected final <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public int getContentLayoutId()
  {
    return 2131558477;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 996) && (paramInt2 == -1))
    {
      paramIntent = new AuthorityControlFragment.9(this, (AppInfo)paramIntent.getParcelableExtra("KEY_DELETED_INFO"));
      this.jdField_a_of_type_Artf.nm(paramIntent);
      this.jdField_a_of_type_Artf.elG();
      if (this.jdField_a_of_type_Artf.getCount() == 0) {
        ekW();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.rightViewText.getId() == paramView.getId())
    {
      if (!this.jdField_a_of_type_Artf.aHb()) {
        break label36;
      }
      ekY();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label36:
      ekX();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.Dt != null) && (this.jdField_a_of_type_Artf != null) && (this.Dt.size() == this.jdField_a_of_type_Artf.getCount())) {
      anot.a(this.app, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.app.addObserver(this.jdField_a_of_type_Asau);
  }
  
  public void onStop()
  {
    super.onStop();
    this.app.removeObserver(this.jdField_a_of_type_Asau);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    onInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment
 * JD-Core Version:    0.7.0.1
 */