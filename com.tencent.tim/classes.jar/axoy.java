import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.ArrayList;
import java.util.List;

public class axoy
  extends BaseAdapter
{
  int bnZ;
  int eCJ;
  private Context mContext;
  List<QIMFilterCategoryItem> mData = new ArrayList();
  int mGridWidth;
  int mItemHeight;
  
  public axoy(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.eCJ = paramInt;
  }
  
  private View cL()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    Object localObject1 = new RelativeLayout(this.mContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = aqnm.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.mContext);
    ((URLImageView)localObject2).setId(2131368698);
    ((URLImageView)localObject2).setImageResource(2130845419);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject2).setId(2131369428);
    ((RelativeLayout)localObject2).setBackgroundResource(2130845415);
    ((RelativeLayout)localObject2).setVisibility(8);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = aqnm.dpToPx(16.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.mContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.mContext.getResources().getDrawable(2130845416), null);
    ((TextView)localObject3).setCompoundDrawablePadding(aqnm.dpToPx(4.0F));
    ((TextView)localObject3).setText(acfp.m(2131706322));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.mContext.getResources().getColor(2131167654));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131367090);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167654));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    ((TextView)localObject2).setBackgroundResource(2130845418);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-1, aqnm.dpToPx(31.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setId(2131369118);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setImageResource(2130845417);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new QIMCommonLoadingView(this.mContext);
    ((QIMCommonLoadingView)localObject2).setId(2131367093);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131365459);
    ((ImageView)localObject1).setImageResource(2130846849);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131382330);
    ((ImageView)localObject1).setImageResource(2130846856);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.mGridWidth <= 0) && (paramViewGroup != null))
    {
      this.mGridWidth = paramViewGroup.getMeasuredWidth();
      this.mItemHeight = ((int)((this.mGridWidth - FilterProviderPagerAdapter.dyo * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
      this.bnZ = (this.mItemHeight * 12 / 160);
    }
    if (paramView == null) {
      paramView = cL();
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131367090);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131369118);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368698);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365459);
      QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131367093);
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.mData.get(paramInt);
      Object localObject1 = ayva.a().d(this.eCJ);
      boolean bool = false;
      if (localObject1 != null) {
        bool = TextUtils.equals(((QIMFilterCategoryItem)localObject1).id, localQIMFilterCategoryItem.id);
      }
      if (!bool) {
        if (((localObject1 == null) || (((QIMFilterCategoryItem)localObject1).auG())) && (localQIMFilterCategoryItem.auG())) {
          bool = true;
        }
      }
      for (;;)
      {
        paramView.setTag(localQIMFilterCategoryItem);
        Object localObject2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new AbsListView.LayoutParams(-1, -1);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        ((AbsListView.LayoutParams)localObject1).height = this.mItemHeight;
        if (localQIMFilterCategoryItem.auG())
        {
          localImageView3.setVisibility(8);
          if (bool)
          {
            localImageView3.setVisibility(0);
            localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130845420));
            label302:
            localImageView2.setVisibility(8);
            localTextView.setText(acfp.m(2131706323));
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          bool = false;
          break;
          localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130845420));
          break label302;
          localObject1 = ((axpr)axov.a(5)).a(localQIMFilterCategoryItem);
          if (bool)
          {
            localImageView3.setVisibility(0);
            localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
            label409:
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130845414);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130845414);
            localQIMCommonLoadingView.setMax(10000);
            if (((axqf)localObject1).outState != 1) {
              break label599;
            }
            localQIMCommonLoadingView.setVisibility(0);
            label473:
            localObject2 = URLDrawable.getDrawable(localQIMFilterCategoryItem.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
            if (((URLDrawable)localObject2).getStatus() == 2) {
              ((URLDrawable)localObject2).restartDownload();
            }
            localImageView1.setImageDrawable((Drawable)localObject2);
            localTextView.setText(localQIMFilterCategoryItem.name);
            if (!localQIMFilterCategoryItem.isWsBanner()) {
              break label619;
            }
            localImageView2.setVisibility(8);
            localObject1 = (ImageView)paramView.findViewById(2131382330);
            if (!localQIMFilterCategoryItem.isDovItem()) {
              break label609;
            }
            ((ImageView)localObject1).setImageResource(2130846843);
          }
          for (;;)
          {
            ((ImageView)localObject1).setVisibility(0);
            break;
            localImageView3.setVisibility(8);
            localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
            break label409;
            label599:
            localQIMCommonLoadingView.setVisibility(8);
            break label473;
            label609:
            ((ImageView)localObject1).setImageResource(2130846856);
          }
          label619:
          ayva.a();
          bool = ayva.needShowRedDot(3, localQIMFilterCategoryItem.categoryId, localQIMFilterCategoryItem.id);
          int i = ((axqf)localObject1).Rs();
          localQIMCommonLoadingView.setVisibility(0);
          localQIMCommonLoadingView.setBgCorner(this.bnZ);
          localQIMCommonLoadingView.a(axxj.a(localObject1));
          localImageView2.setVisibility(0);
          if (bool) {
            localImageView2.setImageResource(2130846850);
          } else {
            switch (i)
            {
            default: 
              break;
            case 1: 
            case 3: 
              localImageView2.setVisibility(8);
              break;
            case 2: 
              localImageView2.setImageResource(2130846849);
            }
          }
        }
      }
    }
  }
  
  public void setData(List<QIMFilterCategoryItem> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    if (!ayva.a().aRg()) {
      ayva.oW(this.mData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoy
 * JD-Core Version:    0.7.0.1
 */