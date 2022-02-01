package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import apmj;
import aqgz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lrr;
import lti;
import ndi;
import wja;

public class NativeGridImageView
  extends GridView
  implements IView
{
  private a a;
  private ArticleInfo b;
  
  public NativeGridImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void cP(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      QLog.d("Proteus.NativeGridImageView", 1, "reportData, but articleInfo is null.");
    }
    if (this.b != null)
    {
      ndi.b(this.b, paramInt1, paramInt2);
      paramInt1 = (int)this.b.mChannelID;
      ndi.h(this.b, paramInt1);
      return;
    }
    QLog.d("Proteus.NativeGridImageView", 1, "reportData failed, articleInfo is null!");
  }
  
  private ArrayList<String> n(List<URL> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((URL)localIterator.next()).toString();
      paramList = str;
      if (str.contains("https")) {
        paramList = str.replaceFirst("https", "http");
      }
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  private void w(int paramInt, List<URL> paramList)
  {
    if ((this.b == null) || (paramList == null)) {
      QLog.d("Proteus.NativeGridImageView", 1, "showPicture failed, mArticleInfo is null.");
    }
    for (;;)
    {
      return;
      String str1 = this.b.mArticleContentUrl;
      String str2 = this.b.mTitle;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
        }
        apmj.a((Activity)getContext(), paramInt, n(paramList), null, null, false, false, "4", 100, null, str1, str2, this.b, "");
      }
      while (paramList != null)
      {
        cP(paramInt, paramList.size());
        return;
        apmj.a((Activity)getContext(), paramInt, n(paramList), null, null, false, false, "4", 100, null, this.b, "");
      }
    }
  }
  
  public void a(lrr paramlrr)
  {
    if (this.a != null) {
      this.a.notifyDataSetChanged();
    }
    b(paramlrr);
  }
  
  public void aHq()
  {
    setOnItemClickListener(new lti(this));
  }
  
  public void b(lrr paramlrr)
  {
    int i = getCount();
    Layout.Params localParams;
    if (i == 1)
    {
      setNumColumns(1);
      localParams = paramlrr.getComLayoutParams();
      if (i != 4) {
        break label170;
      }
      if (localParams != null)
      {
        i = (int)aqgz.hM() - wja.dp2px(24.0F, getResources());
        localParams.mLayoutWidth = ((i - wja.dp2px(6.0F, getResources())) * 2 / 3 + wja.dp2px(3.0F, getResources()));
        if (localParams.mLayoutWidth > 0) {
          paramlrr.setComLayoutParams(localParams);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(aqgz.hM()) });
        }
      }
    }
    label170:
    do
    {
      do
      {
        return;
        if ((i == 2) || (i == 4))
        {
          setNumColumns(2);
          break;
        }
        setNumColumns(3);
        break;
      } while (localParams == null);
      i = (int)aqgz.hM() - wja.dp2px(24.0F, getResources());
      localParams.mLayoutWidth = i;
      if (localParams.mLayoutWidth > 0) {
        paramlrr.setComLayoutParams(localParams);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(aqgz.hM()) });
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void init(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(wja.dp2px(3.0F, paramContext.getResources()));
    setHorizontalSpacing(wja.dp2px(3.0F, paramContext.getResources()));
    setSelector(17170445);
    aHq();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void u(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      if (this.a != null) {
        break label53;
      }
      this.a = new a();
      this.a.a(new b(paramArticleInfo));
      setAdapter(this.a);
    }
    for (;;)
    {
      this.b = paramArticleInfo;
      return;
      label53:
      this.a.a(new b(paramArticleInfo));
    }
  }
  
  public class a
    extends BaseAdapter
  {
    List<URL> imageList = new ArrayList();
    List<SquareCornerTextImageView.a> ip = new ArrayList();
    
    public a() {}
    
    public void a(NativeGridImageView.b paramb)
    {
      this.ip = paramb.aT();
      this.imageList = paramb.aU();
    }
    
    public int getCount()
    {
      return this.ip.size();
    }
    
    public List<URL> getImageList()
    {
      return this.imageList;
    }
    
    public Object getItem(int paramInt)
    {
      return this.ip.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramView = new SquareCornerTextImageView(localContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      }
      for (;;)
      {
        ((SquareCornerTextImageView)paramView).a((SquareCornerTextImageView.a)this.ip.get(paramInt));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  class b
  {
    private List<SquareCornerTextImageView.a> ip = new ArrayList();
    private List<URL> iq = new ArrayList();
    
    public b(ArticleInfo paramArticleInfo)
    {
      int i;
      if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.kY != null) && (paramArticleInfo.mSocialFeedInfo.a.kY.size() > 0))
      {
        paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a.kY;
        i = 0;
      }
      for (;;)
      {
        if (i < paramArticleInfo.size()) {}
        try
        {
          int j = this.ip.size();
          if (j >= 9)
          {
            if (this.ip.size() == 1) {
              ((SquareCornerTextImageView.a)this.ip.get(0)).pJ(true);
            }
            return;
          }
          if ((((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_url != null) || (((SocializeFeedsInfo.n)paramArticleInfo.get(i)).aii != null))
          {
            Object localObject;
            label255:
            int k;
            if (((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_url != null)
            {
              this$1 = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_url;
              localObject = new URL(NativeGridImageView.this);
              if (((SocializeFeedsInfo.n)paramArticleInfo.get(i)).aii == null) {
                break label374;
              }
              this$1 = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).aii;
              this$1 = new URL(NativeGridImageView.this);
              this.iq.add(localObject);
              localObject = this.ip;
              j = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_width;
              k = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_height;
              if (((SocializeFeedsInfo.n)paramArticleInfo.get(i)).aSX != 1) {
                break label391;
              }
            }
            label391:
            for (boolean bool = true;; bool = false)
            {
              ((List)localObject).add(new SquareCornerTextImageView.a(j, k, NativeGridImageView.this, bool));
              break label410;
              this$1 = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).aii;
              break;
              label374:
              this$1 = ((SocializeFeedsInfo.n)paramArticleInfo.get(i)).pic_url;
              break label255;
            }
          }
        }
        catch (Exception this$1)
        {
          NativeGridImageView.this.printStackTrace();
          QLog.d("Proteus.NativeGridImageView", 1, "GridImageModel exception.");
          label410:
          i += 1;
        }
      }
    }
    
    public List<SquareCornerTextImageView.a> aT()
    {
      return this.ip;
    }
    
    public List<URL> aU()
    {
      return this.iq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView
 * JD-Core Version:    0.7.0.1
 */