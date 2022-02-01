package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.moai.nativepages.AdLandingPagesLayoutHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroup;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroupList;
import com.tencent.moai.nativepages.model.AdLandingPageComponentH5Info;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentStreamVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentTextInfo;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.util.UIUtil;
import com.tencent.moai.nativepages.view.AdLandingControlView;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class AdLandingPageGroupList
  extends AdLandingPageBaseComp
{
  private int currentPosition = 0;
  private boolean firstExpouse = true;
  private AdLandingControlView pageControlView;
  private TurnPagerAdapter turnPagerAdapter;
  private ViewPager viewPager;
  
  public AdLandingPageGroupList(Context paramContext, AdLandingPageComponentGroupList paramAdLandingPageComponentGroupList, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentGroupList, paramViewGroup);
    this.pageControlView = new AdLandingControlView(paramContext);
  }
  
  public View createView()
  {
    View localView = this.contentView;
    this.viewPager = ((ViewPager)localView.findViewById(2131378538));
    this.pageControlView = ((AdLandingControlView)localView.findViewById(2131378526));
    return localView;
  }
  
  protected void fillItem()
  {
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int k = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    TurnPagerAdapter localTurnPagerAdapter = new TurnPagerAdapter(this.context, (LayoutInflater)localObject1, getInfo(), this.backgroundColor);
    this.viewPager.setOnPageChangeListener(new AdLandingPageGroupList.1(this, localTurnPagerAdapter));
    this.viewPager.setAdapter(localTurnPagerAdapter);
    this.pageControlView.bindPage(getInfo().adLandingPageComponentInfos.size(), 0);
    if (getInfo().isFullScreen) {
      this.viewPager.setLayoutParams(new RelativeLayout.LayoutParams(j, k));
    }
    while (getInfo().adLandingPageComponentInfos.size() <= 0)
    {
      this.turnPagerAdapter = localTurnPagerAdapter;
      return;
    }
    Object localObject2 = (AdLandingPageComponentGroup)getInfo().adLandingPageComponentInfos.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((AdLandingPageComponentGroup)localObject2).adLandingPageComponentInfos.iterator();
    label211:
    AdLandingPageComponentInfo localAdLandingPageComponentInfo;
    Object localObject3;
    int m;
    int n;
    if (((Iterator)localObject2).hasNext())
    {
      localAdLandingPageComponentInfo = (AdLandingPageComponentInfo)((Iterator)localObject2).next();
      i = (int)(i + localAdLandingPageComponentInfo.paddingTop);
      if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentTextInfo))
      {
        localObject3 = (AdLandingPageComponentTextInfo)localAdLandingPageComponentInfo;
        View localView = ((LayoutInflater)localObject1).inflate(2131563098, null);
        localView.setBackgroundColor(this.backgroundColor);
        ((TextView)localView.findViewById(2131378525)).setText(((AdLandingPageComponentTextInfo)localObject3).wordingTitle);
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
        n = View.MeasureSpec.makeMeasureSpec(0, 0);
        ((TextView)localView.findViewById(2131378525)).measure(m, n);
        m = ((TextView)localView.findViewById(2131378525)).getPaddingTop();
        n = ((TextView)localView.findViewById(2131378525)).getHeight();
        i = ((TextView)localView.findViewById(2131378525)).getPaddingBottom() + (i + m + n);
      }
    }
    for (;;)
    {
      float f1 = i;
      i = (int)(localAdLandingPageComponentInfo.paddingBottom + f1);
      break label211;
      if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentBtnInfo))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(2131563088, null).findViewById(2131378530);
        ((Button)localObject3).setText(((AdLandingPageComponentBtnInfo)localAdLandingPageComponentInfo).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        m = ((Button)localObject3).getPaddingTop();
        n = ((Button)localObject3).getHeight();
        i = ((Button)localObject3).getPaddingBottom() + (m + i + n);
      }
      else
      {
        if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentPureImageInfo))
        {
          float f2 = 0.0F;
          f1 = 0.0F;
          float f3 = localAdLandingPageComponentInfo.paddingTop;
          float f4 = localAdLandingPageComponentInfo.paddingBottom;
          if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentPureImageInfo))
          {
            localObject3 = (AdLandingPageComponentPureImageInfo)localAdLandingPageComponentInfo;
            f2 = ((AdLandingPageComponentPureImageInfo)localObject3).height;
            f1 = ((AdLandingPageComponentPureImageInfo)localObject3).width;
          }
          if (((int)f2 != 0) && ((int)f1 != 0))
          {
            float f5 = i;
            i = (int)(f2 * j / f1 + f5);
          }
          for (;;)
          {
            i = (int)((int)(i + f3) + f4);
            break;
            i += k;
          }
        }
        if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentPanoramaImageInfo))
        {
          i += k;
        }
        else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentSightVideoInfo))
        {
          localObject3 = (AdLandingPageComponentSightVideoInfo)localAdLandingPageComponentInfo;
          if (((AdLandingPageComponentSightVideoInfo)localObject3).sightVideoDisplayType == 1)
          {
            i += k;
          }
          else if ((int)((AdLandingPageComponentSightVideoInfo)localObject3).width > 0)
          {
            i = (int)((AdLandingPageComponentSightVideoInfo)localObject3).height * j / (int)((AdLandingPageComponentSightVideoInfo)localObject3).width + i;
          }
          else
          {
            f1 = i;
            i = (int)(((AdLandingPageComponentSightVideoInfo)localObject3).height + f1);
          }
        }
        else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentStreamVideoInfo))
        {
          localObject3 = (AdLandingPageComponentStreamVideoInfo)localAdLandingPageComponentInfo;
          if (((AdLandingPageComponentStreamVideoInfo)localObject3).streamVideoDisplayType == 1)
          {
            if ((int)((AdLandingPageComponentStreamVideoInfo)localObject3).width > 0)
            {
              i = (int)((AdLandingPageComponentStreamVideoInfo)localObject3).height * j / (int)((AdLandingPageComponentStreamVideoInfo)localObject3).width + i;
            }
            else
            {
              f1 = i;
              i = (int)(((AdLandingPageComponentStreamVideoInfo)localObject3).height + f1);
            }
          }
          else {
            i += k;
          }
        }
        else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentH5Info))
        {
          i += k;
          continue;
          this.viewPager.setLayoutParams(new RelativeLayout.LayoutParams(j, i));
          break;
        }
      }
    }
  }
  
  public AdLandingPageComponentGroupList getInfo()
  {
    return (AdLandingPageComponentGroupList)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563091;
  }
  
  public void viewWillAppear()
  {
    int i = this.viewPager.getCurrentItem();
    this.turnPagerAdapter.startRightIconAnimation(i);
    if (this.firstExpouse)
    {
      this.turnPagerAdapter.didToPage(0);
      this.firstExpouse = false;
    }
    for (;;)
    {
      super.viewWillAppear();
      if (this.appearFlag) {
        DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Scroll_Group_Show_Count", 1L);
      }
      this.appearFlag = false;
      return;
      this.turnPagerAdapter.didToPage(this.currentPosition);
    }
  }
  
  public void viewWillDisappear()
  {
    this.turnPagerAdapter.didToPage(-1);
    super.viewWillDisappear();
    if (!this.appearFlag)
    {
      long l = getStayTime();
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Scroll_Group_Show_Time", l);
    }
    this.appearFlag = true;
  }
  
  static class TurnPagerAdapter
    extends PagerAdapter
  {
    private static final float interpolator = 1.2F;
    private int backgroundColor;
    private int downIconFirstAnimationDuration = 600;
    private int downIconSecondAnimationDuration = 700;
    private int downIconThirdAnimationDuration = 250;
    HashMap<String, View> itemViewMapping = new HashMap();
    private AdLandingPageComponentGroupList list;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    HashMap<String, AdLandingPageComponents> pageComponentsHashMap = new HashMap();
    
    public TurnPagerAdapter(Context paramContext, LayoutInflater paramLayoutInflater, AdLandingPageComponentGroupList paramAdLandingPageComponentGroupList, int paramInt)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.list = paramAdLandingPageComponentGroupList;
      this.backgroundColor = paramInt;
    }
    
    private void startRightIconAnimation(ImageView paramImageView)
    {
      if ((paramImageView.getTag() != null) && ((paramImageView.getTag() instanceof String)) && (new BigInteger((String)paramImageView.getTag()).longValue() >= 1L)) {
        return;
      }
      paramImageView.setTag("1");
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
      localAlphaAnimation.setDuration(this.downIconFirstAnimationDuration);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      localAlphaAnimation.setAnimationListener(new AdLandingPageGroupList.TurnPagerAdapter.2(this, paramImageView));
      paramImageView.startAnimation(localAlphaAnimation);
    }
    
    private void startRightSecondAnimation(ImageView paramImageView)
    {
      AnimationSet localAnimationSet = new AnimationSet(true);
      Object localObject = new TranslateAnimation(0.0F, -5.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
      ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new AlphaAnimation(0.8F, 0.3F);
      ((AlphaAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
      ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new AdLandingPageGroupList.TurnPagerAdapter.1(this, paramImageView));
      paramImageView.startAnimation(localAnimationSet);
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public void didToPage(int paramInt)
    {
      Iterator localIterator = this.pageComponentsHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        AdLandingPageComponents localAdLandingPageComponents = (AdLandingPageComponents)this.pageComponentsHashMap.get(localObject);
        if ((localAdLandingPageComponents != null) && (localAdLandingPageComponents.components.size() != 0))
        {
          int i;
          if (((String)localObject).equals(paramInt + ""))
          {
            i = 0;
            while (i < localAdLandingPageComponents.components.size())
            {
              localObject = (AdLandingPageBaseComp)localAdLandingPageComponents.components.get(i);
              if (!((AdLandingPageBaseComp)localObject).getViewAppeared()) {
                ((AdLandingPageBaseComp)localObject).viewWillAppear();
              }
              i += 1;
            }
          }
          else
          {
            i = 0;
            while (i < localAdLandingPageComponents.components.size())
            {
              localObject = (AdLandingPageBaseComp)localAdLandingPageComponents.components.get(i);
              if (((AdLandingPageBaseComp)localObject).getViewAppeared()) {
                ((AdLandingPageBaseComp)localObject).viewWillDisappear();
              }
              i += 1;
            }
          }
        }
      }
    }
    
    public int getCount()
    {
      return this.list.adLandingPageComponentInfos.size();
    }
    
    @RequiresApi(api=21)
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = this.mLayoutInflater.inflate(2131563090, paramViewGroup, false);
      Object localObject1 = (WindowManager)this.mContext.getSystemService("window");
      int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
      int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
      localObject1 = (LinearLayout)localView.findViewById(2131378533);
      ((LinearLayout)localObject1).setBackgroundColor(this.backgroundColor);
      Object localObject2 = (AdLandingPageComponents)this.pageComponentsHashMap.get(paramInt + "");
      Object localObject3;
      if ((localObject2 == null) || (((AdLandingPageComponents)localObject2).components.size() == 0))
      {
        localObject2 = new AdLandingPageComponents();
        localObject3 = ((AdLandingPageComponentGroup)this.list.adLandingPageComponentInfos.get(paramInt)).adLandingPageComponentInfos.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (AdLandingPageComponentInfo)((Iterator)localObject3).next();
          localObject4 = AdLandingPagesLayoutHelper.LayoutBaseComponent(this.mContext, (AdLandingPageComponentInfo)localObject4, (ViewGroup)localObject1, this.mLayoutInflater, i, j, this.backgroundColor);
          ((AdLandingPageComponents)localObject2).components.add(localObject4);
          ((LinearLayout)localObject1).addView(((AdLandingPageBaseComp)localObject4).getView());
        }
        this.pageComponentsHashMap.put(paramInt + "", localObject2);
        localObject2 = (ImageView)localView.findViewById(2131378535);
        localObject3 = (TextView)localView.findViewById(2131378534);
        if (this.backgroundColor + 16777216 > -1 - this.backgroundColor) {
          break label495;
        }
        ((ImageView)localObject2).setImageDrawable(UIUtil.getDrawable(this.mContext, 2130842308));
      }
      for (;;)
      {
        if (this.list.adPageGroupListCtrType != 1) {
          break label513;
        }
        ((ImageView)localObject2).setVisibility(8);
        ((TextView)localObject3).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(i, ((LinearLayout)localObject1).getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.itemViewMapping.put(paramInt + "", localView);
        return localView;
        localObject2 = ((AdLandingPageComponents)localObject2).components.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AdLandingPageBaseComp)((Iterator)localObject2).next();
          if ((((AdLandingPageBaseComp)localObject3).getView().getParent() != null) && ((((AdLandingPageBaseComp)localObject3).getView().getParent() instanceof ViewGroup))) {
            ((ViewGroup)((AdLandingPageBaseComp)localObject3).getView().getParent()).removeView(((AdLandingPageBaseComp)localObject3).getView());
          }
          ((LinearLayout)localObject1).addView(((AdLandingPageBaseComp)localObject3).getView());
        }
        break;
        label495:
        ((ImageView)localObject2).setImageDrawable(UIUtil.getDrawable(this.mContext, 2130842307));
      }
      label513:
      if (paramInt == this.list.adLandingPageComponentInfos.size() - 1) {
        ((ImageView)localObject2).setVisibility(8);
      }
      for (;;)
      {
        ((TextView)localObject3).setText(paramInt + 1 + "/" + this.list.adLandingPageComponentInfos.size());
        break;
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (View)paramObject;
    }
    
    public void startRightIconAnimation(int paramInt)
    {
      Object localObject = (View)this.itemViewMapping.get(paramInt + "");
      if (localObject == null) {}
      do
      {
        return;
        localObject = (ImageView)((View)localObject).findViewById(2131378535);
      } while ((localObject == null) || (((ImageView)localObject).getVisibility() != 0));
      startRightIconAnimation((ImageView)localObject);
    }
    
    public class AdLandingPageComponents
    {
      public LinkedList<AdLandingPageBaseComp> components = new LinkedList();
      
      public AdLandingPageComponents() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageGroupList
 * JD-Core Version:    0.7.0.1
 */