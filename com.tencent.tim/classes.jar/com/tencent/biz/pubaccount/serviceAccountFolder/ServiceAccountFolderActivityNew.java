package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import nyc;
import nyd;
import nye;
import nyg;
import nyh;
import rwv;
import rwx;
import ryx;
import rze;
import sqn;

public class ServiceAccountFolderActivityNew
  extends FragmentActivity
  implements rwx
{
  public static boolean avz;
  private int Ac;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private String aoK;
  private boolean avA;
  private boolean avB;
  private SquareImageView b;
  private ArrayList<FolderBaseTabFragment> cg = new ArrayList();
  private RadioButton jdField_e_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_e_of_type_AndroidWidgetRadioGroup;
  private ViewPager jdField_f_of_type_AndroidSupportV4ViewViewPager;
  private RadioButton jdField_f_of_type_AndroidWidgetRadioButton;
  private ImageView lg;
  private ImageView lh;
  private ImageView li;
  private ImageView lj;
  private View mContainer;
  private String mCurrentUin;
  private ExtraTypeInfo mExtraTypeInfo;
  private long mStartTime;
  private View nj;
  
  static
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqsubscribe", "DefaultSelectExplorePage", 0) > 0) {
      bool = true;
    }
    avz = bool;
  }
  
  private COMM.StCommonExt a()
  {
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("user_info");
    localEntry.value.set("1");
    localStCommonExt.mapInfo.get().add(localEntry);
    return localStCommonExt;
  }
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramStGetMainPageRsp.messStatus.get() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0) instanceof FolderFollowTabFragment))) {
      ((FolderFollowTabFragment)this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0)).us(paramStGetMainPageRsp.messStatus.noticeCount.get());
    }
  }
  
  private void aC()
  {
    this.lj = ((ImageView)findViewById(2131380028));
    this.lg = ((ImageView)findViewById(2131369793));
    this.lg.setOnClickListener(new nyd(this));
    this.lh = ((ImageView)findViewById(2131370949));
    this.b = ((SquareImageView)findViewById(2131370950));
    if (this.avA)
    {
      this.lg.setImageDrawable(getResources().getDrawable(2130842447));
      this.lh.setImageDrawable(getResources().getDrawable(2130839130));
      this.b.setFilterColor(1711276032);
    }
    this.lh.setVisibility(8);
    this.b.setVisibility(0);
    bcz();
  }
  
  private void bcy()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (rze.bi(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get())))
    {
      this.li.setVisibility(0);
      sqn.b(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      this.li.setOnClickListener(new nyc(this));
      return;
    }
    this.li.setVisibility(8);
  }
  
  private void bcz()
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.mCurrentUin, a());
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, new nye(this));
  }
  
  private void initData()
  {
    this.mExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    Object localObject = new FolderFollowTabFragment();
    this.cg.add(localObject);
    localObject = new FolderRecommendTabFragment();
    this.cg.add(localObject);
    this.mCurrentUin = this.app.getAccount();
  }
  
  private void initView()
  {
    this.mContainer = findViewById(2131378058);
    this.nj = findViewById(2131377497);
    this.jdField_e_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131377250));
    this.jdField_e_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376637));
    this.jdField_f_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376638));
    this.jdField_f_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131382094));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter = new FolderTabFragmentAdapter(getSupportFragmentManager());
    this.jdField_f_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter);
    this.jdField_f_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.li = ((ImageView)findViewById(2131369850));
    if (this.avA)
    {
      this.nj.setBackgroundColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165541));
      this.jdField_e_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839214));
      this.jdField_f_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165541));
      this.jdField_f_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839214));
      this.li.setImageDrawable(getResources().getDrawable(2130839188));
      this.li.setColorFilter(1308622848);
    }
    aC();
    sF();
  }
  
  private void sF()
  {
    this.jdField_e_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new nyg(this));
    this.jdField_f_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new nyh(this));
    if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType == 7004)) {
      this.jdField_f_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
    }
    for (;;)
    {
      this.Ac = this.jdField_f_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      this.mStartTime = System.currentTimeMillis();
      return;
      this.jdField_f_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    }
  }
  
  public boolean Gp()
  {
    return this.lj.getVisibility() == 0;
  }
  
  public void L(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderActivityNew", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559844);
    this.avA = rze.Mp();
    initData();
    initView();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mContainer.setFitsSystemWindows(true);
      this.mContainer.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    rwv.a().a(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    rwv.a().b(this);
    ryx.clearMemoryCache();
    long l1;
    long l2;
    if (this.mStartTime > 0L)
    {
      l1 = System.currentTimeMillis();
      l2 = this.mStartTime;
      if (this.Ac != FolderBaseTabFragment.bdd) {
        break label85;
      }
    }
    label85:
    for (String str = "auth_follow";; str = "auth_discover")
    {
      sqn.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      this.mStartTime = 0L;
      VSNetworkHelper.a().cK(BaseApplicationImpl.getContext());
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(UserStateUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof UserStateUpdateEvent)) {
      bcz();
    }
  }
  
  public void uq(int paramInt)
  {
    if (((paramInt == 0) && (this.jdField_f_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() != 0)) || (paramInt == 8)) {
      this.lj.setVisibility(paramInt);
    }
  }
  
  public class FolderTabFragmentAdapter
    extends FragmentPagerAdapter
  {
    public FolderTabFragmentAdapter(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return ServiceAccountFolderActivityNew.a(ServiceAccountFolderActivityNew.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)ServiceAccountFolderActivityNew.a(ServiceAccountFolderActivityNew.this).get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew
 * JD-Core Version:    0.7.0.1
 */