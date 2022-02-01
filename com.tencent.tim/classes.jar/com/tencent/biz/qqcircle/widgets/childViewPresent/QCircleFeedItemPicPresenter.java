package com.tencent.biz.qqcircle.widgets.childViewPresent;

import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import oum;
import ovd;
import pcp;
import pcr;
import pdf;
import phl;
import phy;
import phz;
import pia;
import rwv;
import rwx;

public class QCircleFeedItemPicPresenter
  extends phl
  implements rwx
{
  private MultiPicAdapter a;
  private FrameLayout aC;
  private ViewPager h;
  private int mImageHeight;
  private int mPicPosition;
  private int mScreenWidth = ImmersiveUtils.getScreenWidth();
  private TextView sn;
  
  private void b(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      this.mImageHeight = ((int)(Math.max(Math.min(paramStImage.height.get() / paramStImage.width.get(), 1.333333F), 0.5625F) * this.mScreenWidth));
      ble();
    }
  }
  
  private void ble()
  {
    if ((this.h != null) && (this.h.getLayoutParams() != null))
    {
      this.h.getLayoutParams().height = this.mImageHeight;
      this.h.requestLayout();
    }
  }
  
  private void qK(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.aC != null) && (this.aC.getVisibility() != 0)) {
        this.aC.setVisibility(0);
      }
      if (this.sn != null) {
        this.sn.setText(paramString);
      }
    }
    while (this.aC == null) {
      return;
    }
    this.aC.setVisibility(8);
  }
  
  private void vD(int paramInt)
  {
    if (this.a != null)
    {
      int i = this.a.getDataCount();
      if (i > 1) {
        qK(paramInt % i + 1 + "/" + i);
      }
    }
    else
    {
      return;
    }
    qK("");
  }
  
  private void vE(int paramInt)
  {
    if (!(this.mData instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mData;
    int[] arrayOfInt = pdf.a(localStFeed);
    String str;
    ArrayList localArrayList;
    if (localStFeed.images.size() > paramInt)
    {
      str = ((FeedCloudMeta.StImage)localStFeed.images.get(paramInt)).picId.get() + "";
      localArrayList = new ArrayList();
      localArrayList.add(pcr.a("ext1", "1"));
      if (paramInt >= this.mPicPosition) {
        break label191;
      }
      localArrayList.add(pcr.a("ext2", "1"));
    }
    for (;;)
    {
      localArrayList.add(pcr.a("ext3", localStFeed.images.size() + ""));
      pcp.a(2, 1, arrayOfInt[0], arrayOfInt[1], localStFeed, 1, this.mPos, str, localArrayList);
      this.mPicPosition = paramInt;
      return;
      str = "";
      break;
      label191:
      if (paramInt > this.mPicPosition) {
        localArrayList.add(pcr.a("ext2", "2"));
      }
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.aC = ((FrameLayout)this.mContainer.findViewById(2131374579));
      this.sn = ((TextView)this.mContainer.findViewById(2131374580));
      this.h = ((ViewPager)this.mContainer.findViewById(2131374557));
      this.a = new MultiPicAdapter();
      this.h.setAdapter(this.a);
      this.h.setOnPageChangeListener(new phy(this));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    FeedCloudMeta.StFeed localStFeed1;
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      this.b.mDataPosition = this.mPos;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      localStFeed1 = (FeedCloudMeta.StFeed)this.mData;
      FeedCloudMeta.StFeed localStFeed2 = oum.a(localStFeed1.id.get());
      paramObject = localStFeed1.images.get();
      if (localStFeed2 == null) {
        break label178;
      }
      paramObject = localStFeed2.images.get();
    }
    label178:
    for (;;)
    {
      if (paramObject.size() > 0)
      {
        b((FeedCloudMeta.StImage)paramObject.get(0));
        this.a.cS(paramObject);
        this.h.setCurrentItem(0);
        vD(0);
      }
      if (localStFeed1.images.get().size() > 1)
      {
        this.aC.setVisibility(0);
        return;
      }
      this.aC.setVisibility(8);
      return;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedPicPositionEvent.class);
    return localArrayList;
  }
  
  public void onDetachedFromWindow()
  {
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedPicPositionEvent)) && (this.h != null) && ((this.mData instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.mData).id.get().equals(((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mFeedId)) && (this.a != null) && (this.a.getCount() > ((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mPicPosition)) {
      this.h.setCurrentItem(((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mPicPosition);
    }
  }
  
  public class MultiPicAdapter
    extends PagerAdapter
  {
    private final ArrayList<FeedCloudMeta.StImage> mDataList = new ArrayList();
    private final LinkedList<View> y = new LinkedList();
    
    public MultiPicAdapter() {}
    
    private View a(View paramView, FeedCloudMeta.StImage paramStImage, int paramInt)
    {
      String str = paramStImage.picUrl.get();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847483);
      localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844853);
      Object localObject;
      if (QCircleFeedItemPicPresenter.a(QCircleFeedItemPicPresenter.this) != 0) {
        if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
        {
          localObject = ovd.a((FeedCloudMeta.StFeed)QCircleFeedItemPicPresenter.this.mData, paramStImage.width.get(), paramStImage.height.get());
          ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
          localLayoutParams.width = ((Integer)((Pair)localObject).first).intValue();
          localLayoutParams.height = ((Integer)((Pair)localObject).second).intValue();
          localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
          localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
        }
      }
      for (;;)
      {
        localObject = "";
        if ((paramView.getTag(2131374557) instanceof String)) {
          localObject = (String)paramView.getTag(2131374557);
        }
        paramView.setTag(2131374557, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new QCircleFeedPicLoader.b().a(str).a((URLImageView)paramView).b(false).a(true).b(localURLDrawableOptions.mRequestWidth).a(localURLDrawableOptions.mRequestHeight);
          QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject, new phz(this));
        }
        paramView.setOnClickListener(new pia(this, paramInt, paramView, paramStImage));
        return paramView;
        if (paramView.getLayoutParams() != null)
        {
          localURLDrawableOptions.mRequestWidth = paramView.getLayoutParams().width;
          localURLDrawableOptions.mRequestHeight = paramView.getLayoutParams().height;
        }
      }
    }
    
    private View g(ViewGroup paramViewGroup)
    {
      paramViewGroup = new URLImageView(paramViewGroup.getContext());
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (QCircleFeedItemPicPresenter.a(QCircleFeedItemPicPresenter.this) == 0) {}
      for (int i = -1;; i = QCircleFeedItemPicPresenter.a(QCircleFeedItemPicPresenter.this))
      {
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        return paramViewGroup;
      }
    }
    
    public View b(ViewGroup paramViewGroup, int paramInt)
    {
      FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)this.mDataList.get(paramInt);
      if (this.y.size() > 0) {}
      for (View localView = (View)this.y.removeFirst();; localView = g(paramViewGroup))
      {
        paramViewGroup.addView(localView);
        return a(localView, localStImage, paramInt);
      }
    }
    
    public void cS(List<FeedCloudMeta.StImage> paramList)
    {
      this.mDataList.clear();
      notifyDataSetChanged();
      if (paramList != null)
      {
        this.mDataList.addAll(paramList);
        notifyDataSetChanged();
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramObject = (View)paramObject;
      paramViewGroup.removeView(paramObject);
      this.y.add(paramObject);
    }
    
    public int getCount()
    {
      return this.mDataList.size();
    }
    
    public int getDataCount()
    {
      return this.mDataList.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      if (getCount() == 0) {
        return -2;
      }
      return super.getItemPosition(paramObject);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter
 * JD-Core Version:    0.7.0.1
 */