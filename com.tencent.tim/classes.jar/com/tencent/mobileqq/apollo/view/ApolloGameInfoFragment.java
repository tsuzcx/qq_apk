package com.tencent.mobileqq.apollo.view;

import abzj;
import abzk;
import abzl;
import abzm;
import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdf;
import aqdf.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import wja;

public class ApolloGameInfoFragment
  extends PublicBaseFragment
  implements aqdf.a
{
  private aqdf jdField_a_of_type_Aqdf;
  private ItemView jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView;
  public ApolloGameData b;
  public RelativeLayout contentView;
  private int ctT = 1;
  private int ctU = 2;
  private int ctV = 3;
  private int ctW = 4;
  private int ctX = 5;
  private int ctY = 6;
  public int enter;
  public CmGameStartChecker.StartCheckParam j;
  public BaseActivity mContext;
  
  public void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131379881);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramView.setFitsSystemWindows(true);
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (NavBarCommon)paramView.findViewById(2131377361);
    ((TextView)paramLayoutInflater.findViewById(2131369579)).setText(acfp.m(2131702491));
    paramLayoutInflater.setOnItemSelectListener(new abzj(this));
    this.contentView = new RelativeLayout(this.mContext);
    paramLayoutInflater = new ImageView(this.mContext);
    paramLayoutInflater.setBackgroundColor(-7829368);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131377361);
    paramLayoutInflater.setId(this.ctT);
    this.contentView.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    paramLayoutInflater = new URLImageView(this.mContext);
    localObject1 = new RelativeLayout.LayoutParams(wja.dp2px(90.0F, getResources()), wja.dp2px(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = wja.dp2px(45.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.ctT);
    paramLayoutInflater.setBackgroundResource(2130839602);
    paramLayoutInflater.setId(this.ctU);
    this.contentView.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setImageResource(2130838597);
    Object localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(90.0F, getResources()), wja.dp2px(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, this.ctU);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, this.ctU);
    this.contentView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(this.mContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText(acfp.m(2131702508));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(20.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.ctU);
    ((TextView)localObject1).setId(this.ctV);
    ((TextView)localObject1).setTextColor(-16777216);
    this.contentView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ItemView(this.mContext, acfp.m(2131702532));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.ctV);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = wja.dp2px(40.0F, getResources());
    ((ItemView)localObject2).setId(this.ctW);
    ((ItemView)localObject2).Dh(acfp.m(2131702500));
    this.contentView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView = new ItemView(this.mContext, acfp.m(2131702531));
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.ctW);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.setId(this.ctX);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = -1;
    this.contentView.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ItemView(this.mContext, acfp.m(2131702507));
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, this.ctX);
    ((ItemView)localObject3).setId(this.ctY);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = -1;
    this.contentView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.contentView.setBackgroundColor(-1);
    localObject4 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131377361);
    paramView.addView(this.contentView, (ViewGroup.LayoutParams)localObject4);
    if (this.b != null) {
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = getResources();
        paramView.mLoadingDrawable = ((Resources)localObject4).getDrawable(2130838600);
        paramView.mFailedDrawable = ((Resources)localObject4).getDrawable(2130838600);
        paramView.mRequestWidth = wja.dp2px(90.0F, getResources());
        paramView.mRequestHeight = paramView.mRequestWidth;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(this.b.logoUrl, paramView));
        ((TextView)localObject1).setText(this.b.name);
        ((ItemView)localObject2).Dh(this.b.developerName);
        ((ItemView)localObject3).bY(this.b.gameId, this.j.openId);
        paramView = this.jdField_a_of_type_Aqdf.a(1, String.valueOf(this.b.officialAccountUin), 0, (byte)2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "logoUrl is null:" + this.b.officialAccountUin);
          }
          this.jdField_a_of_type_Aqdf.a(this.b.officialAccountUin, 200, false, 1, true, (byte)0, 2);
        }
        if ((TextUtils.isEmpty(this.b.officialAccountUin)) || ("0".equals(this.b.officialAccountUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.setVisibility(8);
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramLayoutInflater.setImageResource(2130838600);
          QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, paramView, new Object[0]);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.c(paramView, this.b.officialAccountUin);
        return;
      }
    }
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[initView] gameData is null");
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    this.j = ((CmGameStartChecker.StartCheckParam)getActivity().getIntent().getSerializableExtra("extra_startcheckparam"));
    if (this.j != null)
    {
      this.b = this.j.game;
      this.enter = this.j.enter;
      return;
    }
    this.enter = -1;
    this.b = null;
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[onCreate] startCheckParam is null");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559121, paramViewGroup, false);
    this.jdField_a_of_type_Aqdf = new aqdf(getActivity().app);
    this.jdField_a_of_type_Aqdf.a(this);
    a(paramViewGroup, paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)) && (paramString.equals(this.b.officialAccountUin)) && (paramBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.c(paramBitmap, this.b.officialAccountUin);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "[onDestory] destory");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public class ItemView
    extends RelativeLayout
  {
    TextView Qm;
    URLImageView aP;
    private ImageView bd;
    private String bkh;
    int ctT = 1;
    int ctZ = 2;
    int cua = 3;
    TextView title;
    
    public ItemView(Context paramContext)
    {
      super();
    }
    
    public ItemView(Context paramContext, String paramString)
    {
      super();
      ws(paramString);
    }
    
    public void Dh(String paramString)
    {
      if (this.Qm != null)
      {
        this.Qm.setVisibility(0);
        this.Qm.setText(paramString);
        if (this.bd != null) {
          this.bd.setVisibility(8);
        }
      }
    }
    
    public void bY(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, new Object[] { "[setGameId] gameId:", Integer.valueOf(paramInt) });
      }
      if (paramInt > 0)
      {
        this.Qm.setVisibility(4);
        this.aP.setVisibility(4);
      }
      setOnClickListener(new abzm(this, paramString, paramInt));
    }
    
    public void c(Bitmap paramBitmap, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, new Object[] { "[setPubAccountInfo] uin:", paramString });
      }
      this.Qm.setVisibility(4);
      this.aP.setVisibility(0);
      if (paramBitmap != null) {
        this.aP.setImageBitmap(paramBitmap);
      }
      for (;;)
      {
        this.bkh = paramString;
        setOnClickListener(new abzl(this));
        return;
        this.aP.setImageResource(2130838600);
        QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setPubAccountInfo] logoUrl is null");
      }
    }
    
    public void ws(String paramString)
    {
      int i = Color.parseColor("#FFDEDFE0");
      Object localObject = new ImageView(getContext());
      ((ImageView)localObject).setBackgroundColor(i);
      ((ImageView)localObject).setId(this.ctT);
      addView((View)localObject, new RelativeLayout.LayoutParams(-1, 1));
      this.title = new TextView(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      this.title.setTextSize(18.0F);
      this.title.setTextColor(-16777216);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ctT);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).setMargins(wja.dp2px(12.0F, getResources()), wja.dp2px(17.0F, getResources()), 100, wja.dp2px(20.0F, getResources()));
      this.title.setId(this.ctZ);
      this.title.setText(paramString);
      addView(this.title, (ViewGroup.LayoutParams)localObject);
      paramString = new ImageView(getContext());
      paramString.setBackgroundColor(i);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.ctZ);
      addView(paramString, (ViewGroup.LayoutParams)localObject);
      this.bd = new ImageView(getContext());
      this.bd.setImageResource(2130850446);
      paramString = new RelativeLayout.LayoutParams(wja.dp2px(9.0F, getResources()), wja.dp2px(18.0F, getResources()));
      paramString.addRule(11);
      paramString.addRule(15);
      paramString.rightMargin = wja.dp2px(27.0F, getResources());
      this.bd.setId(this.cua);
      addView(this.bd, paramString);
      this.Qm = new TextView(getContext());
      this.Qm.setTextSize(16.0F);
      this.Qm.setTextColor(-7829368);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.rightMargin = wja.dp2px(11.0F, getResources());
      paramString.addRule(11);
      paramString.rightMargin = wja.dp2px(27.0F, getResources());
      paramString.addRule(15);
      this.Qm.setVisibility(4);
      addView(this.Qm, paramString);
      this.aP = new URLImageView(getContext());
      this.aP.setVisibility(4);
      paramString = new RelativeLayout.LayoutParams(wja.dp2px(25.0F, getResources()), wja.dp2px(25.0F, getResources()));
      paramString.rightMargin = wja.dp2px(11.0F, getResources());
      paramString.addRule(0, this.cua);
      paramString.addRule(15);
      setBackgroundResource(2130839601);
      addView(this.aP, paramString);
      setOnClickListener(new abzk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment
 * JD-Core Version:    0.7.0.1
 */