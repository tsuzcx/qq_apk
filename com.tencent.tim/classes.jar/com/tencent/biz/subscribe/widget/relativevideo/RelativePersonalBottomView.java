package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.a;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import rwv;
import rwx;
import rxn;
import rxn.b;
import rxq;
import shg;
import sjk;
import sjl;
import sqn;

public class RelativePersonalBottomView
  extends BaseWidgetView<rxn.b>
  implements rwx
{
  private SubscribePersonalBottomDraftsFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment;
  private a jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$a;
  private rxq jdField_a_of_type_Rxq;
  private SubscribePersonalBottomOpusFragment jdField_b_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment;
  private rxn.b jdField_b_of_type_Rxn$b;
  private RadioGroup f;
  private RadioButton i;
  private RadioButton j;
  private List<SubscribeBaseBottomPersonalFragment> jk;
  private String mUin;
  private ViewPager mViewPager;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, rxq paramrxq)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Rxq = paramrxq;
    rwv.a().a(this);
  }
  
  private void byZ()
  {
    if ((this.jdField_b_of_type_Rxn$b != null) && ((this.jdField_b_of_type_Rxn$b.by instanceof SubscribeBaseBottomPersonalFragment.a)))
    {
      Object localObject = (SubscribeBaseBottomPersonalFragment.a)this.jdField_b_of_type_Rxn$b.by;
      if (((((SubscribeBaseBottomPersonalFragment.a)localObject).lb == null) || (((SubscribeBaseBottomPersonalFragment.a)localObject).lb.size() == 0)) && (this.jk != null) && (!this.jk.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)) && (this.jdField_a_of_type_Rxq != null))
      {
        localObject = this.jdField_a_of_type_Rxq.getBlockMerger().getBlockContainer().a().getChildAt(0);
        ThreadManager.getUIHandler().post(new RelativePersonalBottomView.4(this, (View)localObject));
      }
    }
    while ((getLayoutParams() == null) || (getLayoutParams().height == -1)) {
      return;
    }
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.5(this));
  }
  
  private void initData()
  {
    this.jk = new ArrayList();
    this.jdField_b_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment = new SubscribePersonalBottomOpusFragment();
    this.jk.add(this.jdField_b_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment);
    if ((getContext() instanceof PublicFragmentActivity)) {
      this.mUin = ((PublicFragmentActivity)getContext()).app.getAccount();
    }
  }
  
  private void onDataChange()
  {
    if (shg.a().fV(this.mUin))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        if ((this.jdField_b_of_type_Rxn$b != null) && ((this.jdField_b_of_type_Rxn$b.by instanceof SubscribeBaseBottomPersonalFragment.a)))
        {
          SubscribeBaseBottomPersonalFragment.a locala = (SubscribeBaseBottomPersonalFragment.a)this.jdField_b_of_type_Rxn$b.by;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(locala.key, locala);
        }
      }
      if (!this.jk.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        sqn.c(this.mUin, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jk.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.j.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$a.notifyDataSetChanged();
      }
      this.i.setBackgroundDrawable(getResources().getDrawable(2130839124));
    }
    for (;;)
    {
      byZ();
      return;
      this.mViewPager.setCurrentItem(0);
      if (this.jk.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        this.jk.remove(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.j.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$a.notifyDataSetChanged();
        this.i.setBackgroundDrawable(null);
      }
    }
  }
  
  private void sF()
  {
    this.f.setOnCheckedChangeListener(new sjk(this));
    this.mViewPager.setOnPageChangeListener(new sjl(this));
  }
  
  public void a(rxn.b paramb)
  {
    if ((paramb != null) && ((paramb.by instanceof SubscribeBaseBottomPersonalFragment.a)))
    {
      this.jdField_b_of_type_Rxn$b = paramb;
      paramb = (SubscribeBaseBottomPersonalFragment.a)paramb.by;
      Iterator localIterator = this.jk.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramb.key, paramb);
      }
      byZ();
      if (paramb.aLa) {
        onDataChange();
      }
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.f = ((RadioGroup)paramView.findViewById(2131377250));
    this.i = ((RadioButton)paramView.findViewById(2131372731));
    this.j = ((RadioButton)paramView.findViewById(2131366116));
    this.j.setVisibility(8);
    this.mViewPager = ((ViewPager)paramView.findViewById(2131373013));
    this.mViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$a = new a(((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    initData();
    this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$a);
    sF();
  }
  
  public int getCurrentIndex()
  {
    if (this.mViewPager != null) {
      return this.mViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    localArrayList.add(SubscribeFeedsEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131558849;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.3(this, paramSimpleBaseEvent));
  }
  
  class a
    extends FragmentPagerAdapter
  {
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return RelativePersonalBottomView.a(RelativePersonalBottomView.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      if (paramInt < RelativePersonalBottomView.a(RelativePersonalBottomView.this).size()) {
        return (Fragment)RelativePersonalBottomView.a(RelativePersonalBottomView.this).get(paramInt);
      }
      return null;
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */