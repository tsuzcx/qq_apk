package com.tencent.qidian;

import albb;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asgw;
import asia;
import com.tencent.biz.pubaccount.PhotoHorizontalScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.List;
import wja;

@TargetApi(9)
public class PhotoWallViewForQiDianProfile
  extends LinearLayout
{
  public int Cl = -1;
  public List<asia> JO;
  public PhotoHorizontalScrollView a;
  public b a;
  private AdapterView.c a;
  public int aGK = -1;
  public int aGL = -1;
  public GridView e;
  private ImageView hL;
  private View jo;
  View mContentView;
  private Context mContext;
  
  public PhotoWallViewForQiDianProfile(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new asgw(this);
  }
  
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new asgw(this);
  }
  
  @TargetApi(11)
  public PhotoWallViewForQiDianProfile(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new asgw(this);
  }
  
  public void aBw()
  {
    if ((QLog.isColorLevel()) && (this.JO != null)) {
      QLog.i("PhotoWallViewForQiDianProfile", 2, "updatePhotoView urlList size=" + this.JO.size());
    }
    if (this.JO != null) {}
    for (int i = this.JO.size();; i = 0)
    {
      if (i > 0)
      {
        this.e.setColumnWidth(this.Cl);
        this.e.setStretchMode(0);
        this.e.setHorizontalSpacing(this.aGL);
        a locala = new a(this.mContext);
        locala.bF(this.JO);
        i = this.JO.size();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.Cl + this.aGL) * i, this.aGK);
        this.e.setLayoutParams(localLayoutParams);
        this.e.setNumColumns(i);
        this.e.setAdapter(locala);
        this.e.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$c);
        this.hL.setVisibility(8);
        this.jo.setVisibility(8);
        this.e.setVisibility(0);
        setVisibility(0);
      }
      return;
    }
  }
  
  public void g(Context paramContext, List<asia> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoWallViewForQiDianProfile", 2, "initView");
    }
    this.mContext = paramContext;
    this.JO = paramList;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131559765, this, true);
    this.e = ((GridView)this.mContentView.findViewById(2131373194));
    this.e.setClickable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.mContentView.findViewById(2131373195));
    this.hL = ((ImageView)this.mContentView.findViewById(2131373655));
    this.jo = this.mContentView.findViewById(2131375573);
    this.aGL = getResources().getDimensionPixelSize(2131298486);
    this.Cl = getResources().getDimensionPixelSize(2131298488);
    this.aGK = getResources().getDimensionPixelSize(2131298487);
    if (VersionUtils.isGingerBread()) {
      this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView.setOverScrollMode(2);
    }
    aBw();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoWallCallback(b paramb)
  {
    this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$b = paramb;
  }
  
  public class a
    extends BaseAdapter
  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    List<asia> mList;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(this.mContext);
    }
    
    public void bF(List<asia> paramList)
    {
      this.mList = paramList;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.mList != null) {
        return this.mList.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.mList != null) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    @TargetApi(16)
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      for (;;)
      {
        try
        {
          localObject1 = ((asia)this.mList.get(paramInt)).cER;
          Object localObject2;
          int i;
          int j;
          if (!QLog.isColorLevel()) {
            break label347;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            localObject4 = ((asia)this.mList.get(paramInt)).title;
            localObject2 = localObject1;
            localObject1 = localObject4;
            if (paramView != null) {
              break label366;
            }
            paramView = new a();
            localObject4 = this.mLayoutInflater.inflate(2131559763, null);
            ((View)localObject4).setLayoutParams(new AbsListView.LayoutParams(PhotoWallViewForQiDianProfile.this.Cl, PhotoWallViewForQiDianProfile.this.aGK));
            paramView.e = ((URLImageView)((View)localObject4).findViewById(2131373206));
            paramView.adn = ((TextView)((View)localObject4).findViewById(2131371171));
            paramView.adn.setMaxLines(2);
            paramView.adn.setTextColor(-1);
            paramView.adn.setTextSize(2, 14.0F);
            paramView.adn.setMaxLines(2);
            localObject5 = this.mContext.getResources();
            paramView.adn.setLineSpacing(wja.dp2px(2.5F, (Resources)localObject5), 1.0F);
            paramView.adn.setGravity(80);
            paramView.adn.setEllipsize(TextUtils.TruncateAt.END);
            paramView.adn.setBackgroundResource(2130842480);
            i = wja.dp2px(11.0F, (Resources)localObject5);
            j = wja.dp2px(14.0F, (Resources)localObject5);
            paramView.adn.setPadding(j, 0, j, i);
            ((View)localObject4).setTag(paramView);
            paramView.e.setTag(new albb(25, Integer.valueOf(paramInt)));
            if (!TextUtils.isEmpty(localObject2)) {
              break label384;
            }
            paramView.e.setImageResource(2130851465);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              paramView.adn.setVisibility(0);
              paramView.adn.setText((CharSequence)localObject1);
            }
            EventCollector.getInstance().onListGetView(paramInt, (View)localObject4, paramViewGroup, getItemId(paramInt));
            return localObject4;
          }
          catch (Exception localException2)
          {
            Object localObject1;
            Object localObject4;
            Object localObject5;
            Object localObject3;
            break label333;
          }
          localException1 = localException1;
          localObject1 = null;
        }
        label333:
        QLog.d("PhotoWallViewForQiDianProfile", 2, "getView url error!");
        label347:
        localException1.printStackTrace();
        localObject4 = null;
        localObject3 = localObject1;
        localObject1 = localObject4;
        continue;
        label366:
        localObject5 = (a)paramView.getTag();
        localObject4 = paramView;
        paramView = (View)localObject5;
        continue;
        label384:
        localObject3 = URLDrawable.getDrawable((String)localObject3);
        paramView.e.setImageDrawable((Drawable)localObject3);
      }
    }
    
    class a
    {
      TextView adn;
      URLImageView e;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(asia paramasia);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.PhotoWallViewForQiDianProfile
 * JD-Core Version:    0.7.0.1
 */