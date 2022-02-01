import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class alvw
  extends BaseAdapter
{
  public String TAG = "FilterProviderGridAdapter";
  boolean czH = true;
  private Context mContext;
  List<FilterCategoryItem> mData = new CopyOnWriteArrayList();
  int mGridWidth;
  int mItemHeight;
  
  public alvw(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.czH = paramBoolean;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.mData.size()) {
      return null;
    }
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
    }
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.mContext).inflate(2131561258, paramViewGroup, false);
    }
    TextView localTextView = (TextView)localView.findViewById(2131367090);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131369118);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368698);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131365459);
    URLImageView localURLImageView = (URLImageView)localView.findViewById(2131362276);
    CaptureCommonLoadingView localCaptureCommonLoadingView = (CaptureCommonLoadingView)localView.findViewById(2131367093);
    FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)this.mData.get(paramInt);
    paramView = alwh.a().a();
    boolean bool = false;
    if (paramView != null) {
      bool = TextUtils.equals(paramView.id, localFilterCategoryItem.id);
    }
    if (!bool) {
      if (((paramView == null) || (paramView.auG())) && (localFilterCategoryItem.auG())) {
        bool = true;
      }
    }
    for (;;)
    {
      localView.setTag(localFilterCategoryItem);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      paramView = localLayoutParams;
      if (localLayoutParams == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        localView.setLayoutParams(paramView);
      }
      paramView.height = this.mItemHeight;
      if (localFilterCategoryItem.auG())
      {
        localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130846848));
        if (bool)
        {
          localImageView3.setVisibility(0);
          label300:
          localImageView2.setVisibility(8);
          localTextView.setText(acfp.m(2131706321));
          localImageView1.setContentDescription(acfp.m(2131706324));
          localTextView.setContentDescription(acfp.m(2131706325));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        bool = false;
        break;
        localImageView3.setVisibility(8);
        break label300;
        if (bool)
        {
          localImageView3.setVisibility(0);
          localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
          label402:
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = this.mContext.getResources().getDrawable(2130846844);
          paramView.mFailedDrawable = this.mContext.getResources().getDrawable(2130846844);
          localCaptureCommonLoadingView.setMax(10000);
          localCaptureCommonLoadingView.setVisibility(8);
          paramView = URLDrawable.getDrawable(localFilterCategoryItem.iconUrl, URLDrawable.URLDrawableOptions.obtain());
          paramView.startDownload();
          localImageView1.setImageDrawable(paramView);
          localTextView.setText(localFilterCategoryItem.name);
          localImageView1.setContentDescription(localFilterCategoryItem.name);
          localTextView.setContentDescription(localFilterCategoryItem.name);
          if (!localFilterCategoryItem.advertisement) {
            break label675;
          }
          localImageView2.setVisibility(8);
          if (!aqmr.isEmpty(localFilterCategoryItem.badgeurl)) {
            break label607;
          }
          localURLImageView.setVisibility(8);
        }
        for (;;)
        {
          anot.a(null, "dc00898", "", "", "0X800859E", "0X800859E", 2, 0, "", "", localFilterCategoryItem.id, "");
          break;
          localImageView3.setVisibility(8);
          localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
          break label402;
          try
          {
            label607:
            localURLImageView.setVisibility(0);
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFilterCategoryItem.badgeurl));
            paramView = localURLImageView.getLayoutParams();
            paramView.height = 42;
            paramView.width = 42;
            localURLImageView.setLayoutParams(paramView);
          }
          catch (Exception paramView)
          {
            QLog.e("PtvTemplateItemView", 1, "PtvTemplateItemView bindData mBadgeImg.setImageDrawable(URLDrawable.getDrawable(info.badgeurl)) catch an Exception.", paramView);
            localURLImageView.setVisibility(8);
          }
        }
        label675:
        bool = alwh.a().needShowRedDot(3, localFilterCategoryItem.categoryId, localFilterCategoryItem.id);
        if (bool)
        {
          localImageView2.setVisibility(0);
          if (bool) {
            localImageView2.setImageResource(2130846850);
          }
        }
        else
        {
          localImageView2.setVisibility(8);
        }
      }
    }
  }
  
  public void setData(List<FilterCategoryItem> paramList)
  {
    this.mData.clear();
    if (this.czH) {
      this.mData.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if ((paramList != null) && (QLog.isColorLevel())) {
        QLog.d("CapturePtvTemplateManager", 2, "FilterProviderGridAdapter setData size = " + paramList.size());
      }
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)localIterator.next();
        if (!localFilterCategoryItem.advertisement) {
          this.mData.add(localFilterCategoryItem);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvw
 * JD-Core Version:    0.7.0.1
 */