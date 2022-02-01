package com.tencent.biz.pubaccount;

import albb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.List;
import jzs.a;
import jzt;
import org.json.JSONArray;

@TargetApi(9)
public class PhotoWallViewForAccountDetail
  extends LinearLayout
{
  public int Cl = -1;
  public PhotoHorizontalScrollView a;
  public b a;
  private AdapterView.c a;
  public int aGK = -1;
  public int aGL = -1;
  QQAppInterface app;
  public GridView e;
  public List<jzs.a> fS;
  private ImageView hL;
  private View jo;
  private Activity mActivity;
  View mContentView;
  
  public PhotoWallViewForAccountDetail(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new jzt(this);
  }
  
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new jzt(this);
  }
  
  @TargetApi(11)
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$c = new jzt(this);
  }
  
  public void a(BaseActivity paramBaseActivity, List<jzs.a> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
    }
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    if ((paramList != null) && (paramList.size() > 20)) {}
    for (this.fS = paramList.subList(0, 20);; this.fS = paramList)
    {
      this.mContentView = LayoutInflater.from(this.app.getApplication()).inflate(2131559762, this, true);
      this.e = ((GridView)this.mContentView.findViewById(2131373194));
      this.e.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.mContentView.findViewById(2131373195));
      this.hL = ((ImageView)this.mContentView.findViewById(2131373655));
      this.jo = this.mContentView.findViewById(2131375573);
      this.aGL = getResources().getDimensionPixelSize(2131296350);
      this.Cl = getResources().getDimensionPixelSize(2131296352);
      this.aGK = getResources().getDimensionPixelSize(2131296351);
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView.setOverScrollMode(2);
      }
      aBw();
      return;
    }
  }
  
  public void aBw()
  {
    if ((QLog.isColorLevel()) && (this.fS != null)) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "updatePhotoView urlList size=" + this.fS.size());
    }
    if (this.fS != null) {}
    for (int i = this.fS.size();; i = 0)
    {
      if (i > 0)
      {
        this.e.setColumnWidth(this.Cl);
        this.e.setStretchMode(0);
        this.e.setHorizontalSpacing(this.aGL);
        a locala = new a(this.mActivity);
        locala.bF(this.fS);
        i = this.fS.size();
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
    this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$b = paramb;
  }
  
  public class a
    extends BaseAdapter
  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    List<jzs.a> mList;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(this.mContext);
    }
    
    public void bF(List<jzs.a> paramList)
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
      try
      {
        Object localObject1 = new JSONArray(((jzs.a)this.mList.get(paramInt)).pic_url);
        if (((JSONArray)localObject1).length() > 0)
        {
          localObject1 = ((JSONArray)localObject1).optString(0);
          if (paramView == null)
          {
            paramView = new a();
            localView = this.mLayoutInflater.inflate(2131559764, null);
            localView.setLayoutParams(new AbsListView.LayoutParams(PhotoWallViewForAccountDetail.this.Cl, PhotoWallViewForAccountDetail.this.aGK));
            paramView.e = ((URLImageView)localView.findViewById(2131373206));
            localView.setTag(paramView);
            paramView.e.setTag(new albb(25, Integer.valueOf(paramInt)));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label212;
            }
            paramView.e.setImageResource(2130840068);
            EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
            return localView;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
          }
          localException.printStackTrace();
          Object localObject2 = null;
          continue;
          a locala = (a)paramView.getTag();
          View localView = paramView;
          paramView = locala;
          continue;
          label212:
          localObject2 = URLDrawable.getDrawable((String)localObject2);
          paramView.e.setImageDrawable((Drawable)localObject2);
          continue;
          localObject2 = null;
        }
      }
    }
    
    class a
    {
      URLImageView e;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void d(jzs.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail
 * JD-Core Version:    0.7.0.1
 */