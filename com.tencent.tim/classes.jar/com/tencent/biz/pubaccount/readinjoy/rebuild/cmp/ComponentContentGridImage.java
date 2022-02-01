package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import apmj;
import auvk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.f;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import maz;
import ndi;
import wja;

public class ComponentContentGridImage
  extends GridView
  implements lwl
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a;
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$c;
  private d jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$d;
  private mas jdField_a_of_type_Mas;
  private int aKD;
  public Object aO;
  public int aQm = wja.dp2px(12.0F, getResources());
  public int aQn = wja.dp2px(12.0F, getResources());
  private boolean alS;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public static int Q(int paramInt1, int paramInt2)
  {
    int j = 9;
    int i = paramInt2;
    if (paramInt2 == 9)
    {
      paramInt2 = j;
      if (paramInt1 < 9) {
        i = 3;
      }
    }
    else
    {
      if ((i != 3) || (paramInt1 < 3)) {
        break label35;
      }
      paramInt2 = 3;
    }
    return paramInt2;
    label35:
    return 1;
  }
  
  public static b a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.iterator();
    SocializeFeedsInfo.s locals;
    if (paramArticleInfo.hasNext()) {
      locals = (SocializeFeedsInfo.s)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new ComponentContentGridImage.b.a().a(localArrayList1).b(localArrayList2).a();
        }
        i = locals.pic_width;
        int j = locals.pic_height;
        URL localURL = new URL(locals.aii);
        if (locals.aSX != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new SquareCornerTextImageView.a(i, j, localURL, bool));
        localArrayList2.add(new URL(locals.pic_url));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ComponentContentGridImage", 2, "Malformed URL: " + localMalformedURLException.getMessage());
      break;
      label207:
      boolean bool = false;
    }
  }
  
  public static b a(Object paramObject, int paramInt)
  {
    ComponentContentGridImage.b.a locala = new ComponentContentGridImage.b.a();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    int j;
    if ((paramObject instanceof lie))
    {
      localArticleInfo = ((lie)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY;
        i = localArrayList3.size();
        bool2 = false;
        if ((paramInt != 62) && (paramInt != 63) && (paramInt != 64))
        {
          bool1 = bool2;
          if (paramInt != 65) {
            break label694;
          }
        }
        bool1 = bool2;
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a == null) {
          break label694;
        }
        bool1 = true;
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vN;
        if (i <= 0) {
          break label694;
        }
        i = Q(i, localArticleInfo.mSocialFeedInfo.aSG);
        bool1 = true;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < i) {}
      for (;;)
      {
        try
        {
          int k = localArrayList2.size();
          if (k >= 9)
          {
            locala.b(localArrayList1);
            locala.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                locala.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih))) {
                break label669;
              }
              locala.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
            }
            locala.a(paramInt);
            return locala.a();
          }
          SocializeFeedsInfo.n localn = (SocializeFeedsInfo.n)localArrayList3.get(j);
          if ((localn.pic_url == null) && (localn.aii == null)) {
            break;
          }
          auvk.traceBegin("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localn.pic_url != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localn.pic_url);
            }
            if (localn.aii != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localn.aii);
            }
          }
          auvk.traceEnd();
          auvk.traceBegin("ComponentContentGridImage.setImageUrl");
          if (localn.pic_url != null)
          {
            paramObject = localn.pic_url;
            URL localURL = new URL(paramObject);
            if (localn.aii != null)
            {
              paramObject = localn.aii;
              paramObject = new URL(paramObject);
              auvk.traceEnd();
              localArrayList1.add(localURL);
              auvk.traceBegin("ComponentContentGridImage.PicInfo");
              k = localn.pic_width;
              int m = localn.pic_height;
              if (localn.aSX != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new SquareCornerTextImageView.a(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1)) {
                paramObject.pK(bool1);
              }
              auvk.traceEnd();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localn.aii;
            continue;
          }
          paramObject = localn.pic_url;
          continue;
          bool2 = false;
          continue;
          QLog.d("Q.readinjoy.ui", 2, "url error");
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        break;
        label669:
        if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
          locala.b(localArticleInfo.mTitle);
        }
      }
      label694:
      break;
      j += 1;
    }
  }
  
  private void cP(int paramInt1, int paramInt2)
  {
    if ((this.aO instanceof lie))
    {
      ArticleInfo localArticleInfo = ((lie)this.aO).a();
      if (localArticleInfo != null)
      {
        ndi.b(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Mas != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Mas.a != null) {
            paramInt1 = this.jdField_a_of_type_Mas.a.nh();
          }
        }
        ndi.h(localArticleInfo, paramInt1);
      }
    }
    else
    {
      return;
    }
    QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
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
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a.jA();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a.jB();
    ArticleInfo localArticleInfo = null;
    if ((this.aO instanceof lie)) {
      localArticleInfo = ((lie)this.aO).a();
    }
    if (kxm.s(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiq;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.ain;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.click_area = oK();
      kxm.b(this.jdField_a_of_type_Mas.a.b().getVafContext().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      apmj.a((Activity)getContext(), paramInt, n(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
      if (paramList != null) {
        cP(paramInt, paramList.size());
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.e("ComponentContentGridImage", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
  
  public void P(Object paramObject)
  {
    if (!(paramObject instanceof b))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.aKD = ((b)paramObject).oS();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a = new a((b)paramObject);
      setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a);
    }
    for (;;)
    {
      aNf();
      if ((this.jdField_a_of_type_Mas == null) || (!(this.aO instanceof lie))) {
        break;
      }
      this.jdField_a_of_type_Mas.setModel((lie)this.aO);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a.a((b)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$a.notifyDataSetChanged();
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void aHq()
  {
    setOnItemClickListener(new maz(this));
  }
  
  public void aNf()
  {
    int i = getCount();
    if (i == 1) {
      setNumColumns(1);
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams2 = getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
      }
      setLayoutParams(localLayoutParams1);
      return;
      if ((i == 2) || (i == 4)) {
        setNumColumns(2);
      } else {
        setNumColumns(3);
      }
    }
  }
  
  protected void cH(View paramView)
  {
    ((SquareCornerTextImageView)paramView).asB = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) != -1) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.alS = bool;
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.alS) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$d != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$d.aMN();
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void init(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(wja.dp2px(1.0F, paramContext.getResources()));
    setHorizontalSpacing(wja.dp2px(1.0F, paramContext.getResources()));
    setSelector(17170445);
    aHq();
    this.jdField_a_of_type_Mas = new mas();
  }
  
  protected int oK()
  {
    return 9;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGalleryClickListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$c = paramc;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.aO = paramObject;
  }
  
  public void setOnNoItemClickListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$d = paramd;
  }
  
  public class a
    extends BaseAdapter
  {
    String articleTitle;
    String articleUrl;
    List<URL> imageList;
    List<SquareCornerTextImageView.a> ip;
    
    public a(ComponentContentGridImage.b paramb)
    {
      a(paramb);
    }
    
    private void aNU()
    {
      this.imageList = d(this.imageList, 3);
      this.ip = d(this.ip, 3);
    }
    
    private <T> List<T> d(List<T> paramList, int paramInt)
    {
      if ((paramList == null) || (paramList.size() <= 0)) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      int i = Math.min(paramList.size(), paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        localArrayList.add(paramList.get(paramInt));
        paramInt += 1;
      }
      return localArrayList;
    }
    
    private int oQ()
    {
      int i = wja.dp2px(82.0F, ComponentContentGridImage.this.getResources());
      int j = getCount();
      if ((j == 2) || (j == 4)) {
        i = wja.dp2px(116.0F, ComponentContentGridImage.this.getResources());
      }
      return i;
    }
    
    private int oR()
    {
      int i = wja.dp2px(116.0F, ComponentContentGridImage.this.getResources());
      int j = getCount();
      if ((j == 2) || (j == 4)) {
        i = wja.dp2px(175.0F, ComponentContentGridImage.this.getResources());
      }
      return i;
    }
    
    public void a(ComponentContentGridImage.b paramb)
    {
      this.ip = paramb.aT();
      this.imageList = paramb.aU();
      this.articleUrl = paramb.jA();
      this.articleTitle = paramb.jB();
      aNU();
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
      if (paramView == null) {
        paramView = new SquareCornerTextImageView(localContext);
      }
      for (;;)
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, oQ()));
        ((SquareCornerTextImageView)paramView).a((SquareCornerTextImageView.a)this.ip.get(paramInt), ((URL)this.imageList.get(paramInt)).toString(), oR(), oQ());
        ComponentContentGridImage.this.cH(paramView);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public String jA()
    {
      return this.articleUrl;
    }
    
    public String jB()
    {
      return this.articleTitle;
    }
  }
  
  public static class b
  {
    private int aKD;
    private String articleTitle = "";
    private String articleUrl = "";
    private List<SquareCornerTextImageView.a> ip = new ArrayList();
    private List<URL> iq = new ArrayList();
    
    private b(a parama)
    {
      this.iq = a.a(parama);
      this.articleUrl = a.a(parama);
      this.articleTitle = a.b(parama);
      this.ip = a.b(parama);
      this.aKD = a.a(parama);
    }
    
    public List<SquareCornerTextImageView.a> aT()
    {
      return this.ip;
    }
    
    public List<URL> aU()
    {
      return this.iq;
    }
    
    public String jA()
    {
      return this.articleUrl;
    }
    
    public String jB()
    {
      return this.articleTitle;
    }
    
    public int oS()
    {
      return this.aKD;
    }
    
    public static final class a
    {
      private int aKD;
      private String articleTitle = "";
      private String articleUrl = "";
      private List<SquareCornerTextImageView.a> ip = new ArrayList();
      private List<URL> iq = new ArrayList();
      
      public a a(int paramInt)
      {
        this.aKD = paramInt;
        return this;
      }
      
      public a a(@NonNull String paramString)
      {
        this.articleUrl = paramString;
        return this;
      }
      
      public a a(@NonNull List<SquareCornerTextImageView.a> paramList)
      {
        if ((this.ip != null) && (this.ip.size() == 1)) {
          ((SquareCornerTextImageView.a)this.ip.get(0)).pJ(true);
        }
        this.ip = paramList;
        return this;
      }
      
      public ComponentContentGridImage.b a()
      {
        return new ComponentContentGridImage.b(this, null);
      }
      
      public a b(@NonNull String paramString)
      {
        this.articleTitle = paramString;
        return this;
      }
      
      public a b(@NonNull List<URL> paramList)
      {
        this.iq = paramList;
        return this;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void rr(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void aMN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */