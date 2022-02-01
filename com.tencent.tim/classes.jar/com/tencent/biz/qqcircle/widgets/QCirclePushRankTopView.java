package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import ous;
import pco;
import pgp;
import pgq;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCirclePushRankTopView
  extends BaseWidgetView<QQCircleDitto.StCircleDittoDataNew>
{
  private QCircleMultiPicViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager;
  private QCirclePushRankIndicator jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator;
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankTopView$a;
  private LinearLayout eO;
  private List<QQCircleDitto.StItemContainer> lG;
  private int mCurrentPosition;
  ImageView mk;
  public TextView wD;
  TextView wE;
  
  public QCirclePushRankTopView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return null;
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131560944, null);
    int i = (int)(ImmersiveUtils.getScreenWidth() / 3 * 1.63F);
    QCirclePushRankItemView localQCirclePushRankItemView = (QCirclePushRankItemView)localView.findViewById(2131375363);
    Object localObject1 = (URLImageView)localView.findViewById(2131381224);
    ((URLImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-2, i));
    Object localObject2 = ous.b((URLImageView)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getResources().getDrawable(2130851770);
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)(i * 1.21F));
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    ous.a("https://sola.gtimg.cn/aoi/sola/20200420155146_yymB24gjPe.png", (URLImageView)localObject1, (URLDrawable.URLDrawableOptions)localObject2, false);
    localObject1 = (QCirclePushRankItemView)localView.findViewById(2131375361);
    localObject2 = (QCirclePushRankItemView)localView.findViewById(2131375362);
    if (paramStItemContainer != null)
    {
      if ((paramStItemContainer.items.size() > 0) && (localObject1 != null))
      {
        ((QCirclePushRankItemView)localObject1).setRank(1);
        ((QCirclePushRankItemView)localObject1).setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 1) && (localQCirclePushRankItemView != null))
      {
        localQCirclePushRankItemView.setRank(2);
        localQCirclePushRankItemView.setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 2) && (localObject2 != null))
      {
        ((QCirclePushRankItemView)localObject2).setRank(3);
        ((QCirclePushRankItemView)localObject2).setData(paramStItemContainer);
      }
    }
    return localView;
  }
  
  private void b(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return;
    }
    this.wE.setText(paramStItemContainer.title.get());
    switch (paramStItemContainer.containerType.get())
    {
    }
    for (;;)
    {
      this.wD.setOnClickListener(new pgq(this));
      pco.a("", 9, 1L, 0L, paramStItemContainer.containerType + "", "", "", "", "");
      return;
      this.mk.setImageResource(2130844905);
      continue;
      this.mk.setImageResource(2130844902);
      continue;
      this.mk.setImageResource(2130844903);
    }
  }
  
  public void S(Context paramContext, int paramInt)
  {
    super.S(paramContext, paramInt);
  }
  
  protected void a(QQCircleDitto.StCircleDittoDataNew paramStCircleDittoDataNew)
  {
    if ((paramStCircleDittoDataNew != null) && (paramStCircleDittoDataNew.multiItemContainter != null))
    {
      this.lG = paramStCircleDittoDataNew.multiItemContainter.get();
      if ((this.lG != null) && (this.lG.size() > 0))
      {
        paramStCircleDittoDataNew = new ArrayList();
        int i = 0;
        while (i < this.lG.size())
        {
          if (this.lG.get(i) != null) {
            paramStCircleDittoDataNew.add(a((QQCircleDitto.StItemContainer)this.lG.get(i)));
          }
          i += 1;
        }
        this.mCurrentPosition = 0;
        b((QQCircleDitto.StItemContainer)this.lG.get(0));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankTopView$a = new a(getContext(), paramStCircleDittoDataNew);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankTopView$a);
        this.eO.removeAllViews();
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator = new QCirclePushRankIndicator(getContext(), paramStCircleDittoDataNew.size());
        this.eO.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setOnPageChangeListener(new pgp(this));
      }
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager = ((QCircleMultiPicViewPager)paramView.findViewById(2131373898));
    this.eO = ((LinearLayout)paramView.findViewById(2131373896));
    this.wD = ((TextView)paramView.findViewById(2131380861));
    this.wE = ((TextView)paramView.findViewById(2131369853));
    this.mk = ((ImageView)paramView.findViewById(2131369852));
  }
  
  public int getLayoutId()
  {
    return 2131560945;
  }
  
  class a
    extends PagerAdapter
  {
    Context context;
    private List<View> lH;
    
    public a(List<View> paramList)
    {
      this.context = paramList;
      Object localObject;
      this.lH = localObject;
    }
    
    public View b(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup.addView((View)this.lH.get(paramInt));
      return (View)this.lH.get(paramInt);
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)this.lH.get(paramInt));
    }
    
    public int getCount()
    {
      return this.lH.size();
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView
 * JD-Core Version:    0.7.0.1
 */