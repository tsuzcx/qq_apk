package com.tencent.mobileqq.nearby.now.view;

import ajzg;
import ajzo;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoPlayerPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public QQAppInterface app;
  public StoryPlayController b;
  private StuffContainerView.b b;
  public boolean cqR;
  private boolean cqS = true;
  private boolean cqT;
  public SparseArray<a> da = new SparseArray();
  public SparseArray<View> db = new SparseArray();
  public int dlI;
  public List<VideoData> jG = new ArrayList();
  protected LayoutInflater mInflater;
  
  public VideoPlayerPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.cqR = paramBoolean;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  private void x(ImageView paramImageView)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null) && ((paramImageView.getDrawable() instanceof URLDrawable)) && (((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() != null) && ((((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() instanceof RegionDrawable)) && (((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap() != null))
    {
      ((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap().recycle();
      if (((URLDrawable)paramImageView.getDrawable()).getURL() != null) {
        URLDrawable.removeMemoryCacheByUrl(((URLDrawable)paramImageView.getDrawable()).getURL().toString() + "#now");
      }
      paramImageView.setImageBitmap(null);
      paramImageView.setImageDrawable(null);
    }
  }
  
  public void RE(int paramInt)
  {
    HashMap localHashMap = this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.lV;
    Object localObject = new ArrayList();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    localObject = ((List)localObject).toArray();
    Arrays.sort((Object[])localObject);
    int i = localObject.length - 1;
    while (i >= 0)
    {
      int j = ((Integer)localObject[i]).intValue();
      localHashMap.put(Integer.valueOf(j + paramInt), (ajzo)localHashMap.get(Integer.valueOf(j)));
      localHashMap.remove(Integer.valueOf(j));
      i -= 1;
    }
  }
  
  public void V(int paramInt, List<VideoData> paramList)
  {
    if (paramInt == 0)
    {
      i = paramList.size();
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
      ((StoryPlayController)localObject1).mCurrentIndex += i;
      RE(i);
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.da.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.da.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      while (paramInt >= 0)
      {
        j = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (a)this.da.get(j);
        ((a)localObject2).position += i;
        this.da.put(((a)this.da.get(j)).position, this.da.get(j));
        this.da.delete(j);
        paramInt -= 1;
      }
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.db.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.db.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      while (paramInt >= 0)
      {
        j = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (View)this.db.get(j);
        this.db.put(j + i, localObject2);
        this.db.remove(j);
        paramInt -= 1;
      }
      this.dlI += i;
      this.jG.addAll(0, paramList);
    }
    while (paramInt != 1)
    {
      int i;
      Object localObject1;
      int j;
      Object localObject2;
      return;
    }
    this.jG.addAll(paramList);
  }
  
  public VideoData a(int paramInt)
  {
    if ((this.jG != null) && (paramInt >= 0) && (paramInt < this.jG.size())) {
      return (VideoData)this.jG.get(paramInt);
    }
    return null;
  }
  
  public a a(int paramInt)
  {
    return (a)this.da.get(paramInt);
  }
  
  public void a(StoryPlayController paramStoryPlayController, Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController = paramStoryPlayController;
    this.cqS = false;
  }
  
  public void destroy()
  {
    int i = 0;
    while (i < this.da.size())
    {
      a locala = (a)this.da.get(this.da.keyAt(i));
      if ((locala != null) && (locala.a != null)) {
        locala.a.destroy();
      }
      i += 1;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
      } while ((a)((View)paramObject).getTag() == null);
      View localView = (View)paramObject;
      ((a)((View)paramObject).getTag()).a.destroy();
      paramViewGroup.removeView(localView);
    } while (((ShortVideoCommentsView)paramObject).EZ == null);
    x((ImageView)((ShortVideoCommentsView)paramObject).EZ.findViewById(2131369717));
    x((ImageView)((ShortVideoCommentsView)paramObject).EZ.findViewById(2131366039));
  }
  
  public int getCount()
  {
    return 100;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (paramObject == null) {
      return -2;
    }
    paramObject = (a)((View)paramObject).getTag();
    if (paramObject == null) {
      return -2;
    }
    if (paramObject.position == this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex)
    {
      if (this.cqT)
      {
        this.cqT = false;
        return -2;
      }
      return paramObject.position + 50 - this.dlI;
    }
    return paramObject.position + 50 - this.dlI;
  }
  
  public View getView(int paramInt)
  {
    return (View)this.db.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = true;
    paramInt = paramInt - 50 + this.dlI;
    if ((paramInt < 0) || (paramInt >= this.jG.size()))
    {
      QLog.i("VideoPlayerPagerAdapter", 1, "position =" + paramInt + " ! realIndex is:" + this.dlI);
      if ((paramInt == -1) || (paramInt == this.jG.size())) {
        return new View(paramViewGroup.getContext());
      }
      return null;
    }
    VideoData localVideoData = (VideoData)this.jG.get(paramInt);
    a locala = new a();
    ShortVideoCommentsView localShortVideoCommentsView = new ShortVideoCommentsView(paramViewGroup.getContext());
    localShortVideoCommentsView.app = this.app;
    localShortVideoCommentsView.a(locala, localVideoData);
    locala.a.setOnCloseListener(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b);
    locala.a.setOnCommentClickListener(new ajzg(this, localShortVideoCommentsView));
    locala.c = localVideoData;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(this.mInflater, this, locala);
    }
    locala.position = paramInt;
    this.da.put(paramInt, locala);
    this.db.put(paramInt, localShortVideoCommentsView);
    localShortVideoCommentsView.setTag(locala);
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null)
    {
      StoryPlayController localStoryPlayController = this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
      if (paramInt == this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.dlk) {}
      for (;;)
      {
        localStoryPlayController.a(locala, localVideoData, bool, localShortVideoCommentsView);
        if (paramInt == this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex) {
          this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.Rv(paramInt);
        }
        paramViewGroup.addView(localShortVideoCommentsView, -1, -1);
        return localShortVideoCommentsView;
        bool = false;
      }
    }
    throw new InvalidParameterException("VideoPlayerPagerAdapter not set mStoryPlayerController");
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.hk(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnCloseListener(StuffContainerView.b paramb)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b = paramb;
  }
  
  public class a
  {
    public OperationView a;
    public ImageDisplayView a;
    public VideoData c;
    public QQStoryVideoPlayerErrorView c;
    public View eX;
    public ViewGroup ej;
    public RelativeLayout ld;
    public int position;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */