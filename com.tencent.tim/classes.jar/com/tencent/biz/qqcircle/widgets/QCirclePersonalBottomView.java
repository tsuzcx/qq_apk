package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import java.util.ArrayList;
import java.util.List;
import pgd;
import pge;
import rxn.b;
import rxq;

public class QCirclePersonalBottomView
  extends BaseWidgetView<rxn.b>
{
  private QCircleFolderTabViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager;
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonalBottomView$a;
  private rxq jdField_a_of_type_Rxq;
  private QCirclePersonalDynamicFragment jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment;
  private QCirclePersonalPushFragment jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment;
  private RadioGroup f;
  private RadioButton g;
  private RadioButton h;
  private List<QCirclePersonalBaseBottomFragment> jk;
  
  public QCirclePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomView(Context paramContext, rxq paramrxq)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Rxq = paramrxq;
    setInteractor(paramrxq.getInteractor());
    initData();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonalBottomView$a = new a(((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonalBottomView$a);
    sF();
  }
  
  private void initData()
  {
    this.jk = new ArrayList();
    this.jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment = new QCirclePersonalDynamicFragment();
    this.jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment = new QCirclePersonalPushFragment();
    this.jk.add(this.jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment);
    this.jk.add(this.jdField_b_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment);
  }
  
  private void sF()
  {
    this.f.setOnCheckedChangeListener(new pgd(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.addOnPageChangeListener(new pge(this));
  }
  
  public void a(rxn.b paramb) {}
  
  public void e(Context paramContext, View paramView)
  {
    this.f = ((RadioGroup)paramView.findViewById(2131377250));
    this.g = ((RadioButton)paramView.findViewById(2131366162));
    this.h = ((RadioButton)paramView.findViewById(2131373860));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager = ((QCircleFolderTabViewPager)paramView.findViewById(2131373013));
  }
  
  public int getLayoutId()
  {
    return 2131560927;
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
      return QCirclePersonalBottomView.a(QCirclePersonalBottomView.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      if (paramInt < QCirclePersonalBottomView.a(QCirclePersonalBottomView.this).size()) {
        return (Fragment)QCirclePersonalBottomView.a(QCirclePersonalBottomView.this).get(paramInt);
      }
      return null;
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */