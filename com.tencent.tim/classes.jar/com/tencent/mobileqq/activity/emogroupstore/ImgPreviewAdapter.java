package com.tencent.mobileqq.activity.emogroupstore;

import afhl;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;
import ankt;
import aqrc;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import java.util.LinkedList;
import java.util.List;
import zda;

public class ImgPreviewAdapter
  extends PagerAdapter
{
  private LinkedList<URLImageView> E;
  private afhl a;
  private Context mContext;
  private List<EmoticonFromGroupEntity> mData;
  private View.OnClickListener mOnClickListener = new zda(this);
  private ViewPager mViewPager;
  
  public ImgPreviewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ViewPager paramViewPager)
  {
    this.mContext = paramContext;
    this.mViewPager = paramViewPager;
    this.E = new LinkedList();
    this.a = ((aqrc)paramQQAppInterface.getManager(235)).c;
  }
  
  public EmoticonFromGroupEntity a(int paramInt)
  {
    if (this.mData == null) {
      return null;
    }
    return (EmoticonFromGroupEntity)this.mData.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (URLImageView)paramObject;
    paramViewGroup.removeView(paramObject);
    this.E.add(paramObject);
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    URLImageView localURLImageView;
    if (this.E.size() > 0) {
      localURLImageView = (URLImageView)this.E.removeFirst();
    }
    for (;;)
    {
      localURLImageView.setImageDrawable((URLDrawable)this.a.a((EmoticonFromGroupEntity)this.mData.get(paramInt), 1, -1, null));
      localURLImageView.setOnClickListener(this.mOnClickListener);
      paramViewGroup.addView(localURLImageView);
      return localURLImageView;
      localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setLayoutParams(new Gallery.LayoutParams(ankt.dip2px(166.0F), ankt.dip2px(166.0F)));
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localURLImageView.setBackgroundColor(this.mContext.getResources().getColor(2131165571));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setData(List<EmoticonFromGroupEntity> paramList)
  {
    this.mData = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */