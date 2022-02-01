package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import aqcx;
import aqgo;
import aqho;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.d;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kwt;
import kxm;
import lie;
import lis;
import lwj;
import lwk;
import lwm.a;
import mas;
import mhr;
import mhr.a;
import mhr.b;
import mhr.c;
import mhs;
import mih;
import mih.b;
import ndi;
import ndi.b;
import org.json.JSONObject;
import wja;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, HorizontalListView.d, lwk
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$a;
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private int aPI;
  private int aPw;
  private boolean akU;
  private boolean alX;
  private boolean alY;
  private boolean alZ;
  private mas jdField_b_of_type_Mas;
  private Boolean[] jdField_b_of_type_ArrayOfJavaLangBoolean;
  private float iq;
  private float is;
  private Context mContext;
  private List<BaseArticleInfo> mData = new ArrayList();
  
  public ComponentPolymericView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init(paramContext);
  }
  
  private void aNo()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) && (this.alX)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.aNo();
    }
  }
  
  private void aOC()
  {
    ArticleInfo localArticleInfo = this.jdField_b_of_type_Mas.a().a();
    if (localArticleInfo == null) {
      return;
    }
    Object localObject3 = "";
    long l2 = 0L;
    Object localObject1;
    if (this.aPw == 79)
    {
      if ((localArticleInfo.mTopicRecommendFeedsInfo == null) || (localArticleInfo.mTopicRecommendFeedsInfo.ld == null) || (localArticleInfo.mTopicRecommendFeedsInfo.ld.isEmpty()))
      {
        QLog.d("HorizontalListView", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
        return;
      }
      localObject1 = ((mih.b)localArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView TYPE_NEW_POLYMERIC_CONTAINER_TOPIC jump account url =" + (String)localObject1);
        localObject3 = localObject1;
      }
    }
    long l1;
    if ((ndi.K(localArticleInfo)) || (ndi.R(localArticleInfo)) || (this.aPw == 77) || (this.aPw == 78))
    {
      localObject1 = localObject3;
      l1 = l2;
      if (TextUtils.isEmpty(localArticleInfo.mSubscribeID)) {}
    }
    label849:
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(localArticleInfo.mSubscribeID);
        localObject1 = kwt.acJ + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
        if (!QLog.isColorLevel()) {
          break label849;
        }
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView PGC jump account url =" + (String)localObject1 + " uin = " + l1);
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(localArticleInfo.mSubscribeID))) {
          break label611;
        }
        try
        {
          l2 = Long.parseLong(localArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          Object localObject2;
          localNumberFormatException2.printStackTrace();
          continue;
        }
        localObject1 = kwt.acJ + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + (String)localObject1 + " mSubscribeID = " + l1);
          localObject3 = localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break;
        }
        kxm.aJ(this.mContext, (String)localObject3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView jump to person page url =" + (String)localObject3);
        return;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        l1 = 0L;
        continue;
      }
      if (!ndi.ak(localArticleInfo))
      {
        localObject2 = localObject3;
        l1 = l2;
        if (this.aPw != 76) {}
      }
      else
      {
        localObject2 = localObject3;
        l1 = l2;
        if (localArticleInfo.mSocialFeedInfo != null)
        {
          localObject2 = localObject3;
          l1 = l2;
          if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
          {
            l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
            localObject3 = kwt.acF + aqgo.encodeToString(String.valueOf(l2).getBytes(), 2);
            localObject2 = localObject3;
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView UGC jump account url =" + (String)localObject3 + " uin = " + l2);
              localObject2 = localObject3;
              l1 = l2;
              continue;
              label611:
              String str;
              if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null))
              {
                l1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
                str = kwt.acF + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
                localObject3 = str;
                if (QLog.isColorLevel())
                {
                  QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str + " mUGCFeedsInfo.cuin = " + l1);
                  localObject3 = str;
                }
              }
              else
              {
                localObject3 = str;
                if (localArticleInfo.mSocialFeedInfo != null)
                {
                  localObject3 = str;
                  if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null)
                  {
                    l1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
                    str = kwt.acF + aqgo.encodeToString(String.valueOf(l1).getBytes(), 2);
                    localObject3 = str;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str + " mMasterUser.uin = " + l1);
                      localObject3 = str;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean n(lie paramlie)
  {
    return kxm.A(paramlie.a());
  }
  
  private void rt(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) && (this.alX))
    {
      int j = getMeasuredHeight() / 2;
      int i = j;
      if (!this.alY)
      {
        i = j;
        if (!this.alZ) {
          i = j - wja.dp2px(18.0F, getResources());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.d(paramInt, i);
    }
  }
  
  public void P(Object paramObject)
  {
    paramObject = (lie)paramObject;
    this.jdField_b_of_type_Mas.setModel(paramObject);
    ArticleInfo localArticleInfo = paramObject.a();
    this.aPw = ndi.k(localArticleInfo);
    this.alX = kxm.A(localArticleInfo);
    this.alY = kxm.v(localArticleInfo);
    boolean bool;
    List localList;
    if ((kxm.x(localArticleInfo)) || (kxm.y(localArticleInfo)))
    {
      bool = true;
      this.alZ = bool;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView bindData mIsNewPolymeric = " + this.alX);
      }
      localList = localArticleInfo.mGroupSubArticleList;
      if ((localList == null) || ((localList.size() <= 2) && (!kxm.A(paramObject.a())))) {
        break label237;
      }
      setOverScrollMode(0);
    }
    for (;;)
    {
      this.mData = localList;
      if (this.mData != null) {
        this.jdField_b_of_type_ArrayOfJavaLangBoolean = new Boolean[this.mData.size()];
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$a.notifyDataSetChanged();
      resetCurrentX(localArticleInfo.mCurrentX);
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "articleID = " + localArticleInfo.mArticleID + "bindData resetCurrentX currentX = " + localArticleInfo.mCurrentX);
      }
      return;
      bool = false;
      break;
      label237:
      setOverScrollMode(2);
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void cG(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$a = new a(null);
    setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$a);
    setDividerWidth(wja.dp2px(3.0F, this.mContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.akU);
      }
      this.is = f1;
      this.iq = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.akU = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (j == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.akU);
      }
      float f2 = this.is;
      f3 -= this.iq;
      if ((this.akU) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > aqcx.dip2px(getContext(), 5.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        rt(getScrollX() - this.aPI);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      break;
      if ((j == 3) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + j + " mIsPress=" + this.akU);
        }
        this.akU = false;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) {
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.getRadius();
        }
        if ((j == 1) && (this.alX) && (getScrollX() > i + this.aPI))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView before jump to account page");
          }
          aOC();
        }
        aNo();
      }
    }
  }
  
  public View f(Context paramContext)
  {
    return this;
  }
  
  public void init(Context paramContext)
  {
    this.jdField_b_of_type_Mas = new mas();
    cG(f(paramContext));
    this.aPI = ((int)aqho.convertDpToPixel(paramContext, 28.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView init mJumpAccountPageThreshold = " + this.aPI);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.mData.get(paramInt);
    this.jdField_b_of_type_Mas.a.b().a().a(localBaseArticleInfo, paramView, paramInt, paramLong);
    if (!kxm.B(localBaseArticleInfo)) {
      localObject1 = kxm.a(localBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("rowkey", localBaseArticleInfo.innerUniqueID);
        i = 0;
        switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$a.getItemViewType(paramInt))
        {
        }
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        localException2.printStackTrace();
        continue;
        localObject1 = Integer.valueOf(0);
        continue;
        int i = 0;
        continue;
        continue;
      }
      ((JSONObject)localObject1).put("content_type", i);
      kbp.a(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramInt + "", localBaseArticleInfo.mArticleID + "", localBaseArticleInfo.mStrategyId + "", ((JSONObject)localObject1).toString(), false);
      if (this.alZ) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localObject2 = (mhr.a)localBaseArticleInfo.mNewPolymericInfo.iP.get(0);
        localJSONObject.put("channel_id", this.jdField_b_of_type_Mas.a.nh());
        if (((mhr.a)localObject2).jdField_a_of_type_Mhr$b == null) {
          continue;
        }
        localObject1 = ((mhr.a)localObject2).jdField_a_of_type_Mhr$b.rowKey;
        localJSONObject.put("rowkey", localObject1);
        if (((mhr.a)localObject2).jdField_a_of_type_Mhr$c == null) {
          continue;
        }
        i = ((mhr.a)localObject2).jdField_a_of_type_Mhr$c.aSe;
        localJSONObject.put("topicid", i);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        localException1.printStackTrace();
        continue;
        String str = "2";
        continue;
      }
      localObject2 = localBaseArticleInfo.mFeedId + "";
      if (!kxm.x(localBaseArticleInfo)) {
        continue;
      }
      localObject1 = "1";
      kbp.a(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, (String)localObject2, (String)localObject1, localBaseArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView scrollx" + paramInt1);
    }
    if (paramInt1 <= 2)
    {
      aNo();
      return;
    }
    rt(paramInt1 - this.aPI);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      Object localObject = this.jdField_b_of_type_Mas.a();
      if (localObject != null)
      {
        localObject = ((lie)localObject).a();
        paramInt = getCurrentX();
        ((ArticleInfo)localObject).mCurrentX = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "articleID = " + ((ArticleInfo)localObject).mArticleID + "onScrollStateChanged currentX = " + paramInt);
        }
      }
    }
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView = paramBezierSideBarView;
  }
  
  class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (ComponentPolymericView.a(ComponentPolymericView.this) != null) {
        return ComponentPolymericView.a(ComponentPolymericView.this).size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return ComponentPolymericView.a(ComponentPolymericView.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return ((BaseArticleInfo)ComponentPolymericView.a(ComponentPolymericView.this).get(paramInt)).mRecommendSeq;
    }
    
    public int getItemViewType(int paramInt)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)ComponentPolymericView.a(ComponentPolymericView.this).get(paramInt);
      if (kxm.B(localBaseArticleInfo))
      {
        switch (localBaseArticleInfo.mNewPolymericInfo.aRX)
        {
        default: 
          if (kxm.l(localBaseArticleInfo)) {
            return 51;
          }
          break;
        case 9: 
          return 67;
        case 11: 
          return 69;
        case 10: 
          return 68;
        case 12: 
          return 98;
        case 13: 
          return 97;
        }
        if (kxm.n(localBaseArticleInfo)) {
          return 52;
        }
        if (localBaseArticleInfo.mSinglePicture != null) {
          return 50;
        }
      }
      else
      {
        if (localBaseArticleInfo.mPolymericInfo != null) {}
        switch (localBaseArticleInfo.mPolymericInfo.aRX)
        {
        default: 
          if (kxm.j(localBaseArticleInfo)) {
            return 51;
          }
          break;
        case 9: 
          return 67;
        case 11: 
          return 69;
        case 10: 
          return 68;
        }
        if (kxm.n(localBaseArticleInfo)) {
          return 52;
        }
        if (localBaseArticleInfo.mSinglePicture != null) {
          return 50;
        }
      }
      return 50;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)ComponentPolymericView.a(ComponentPolymericView.this).get(paramInt);
      Object localObject1 = ComponentPolymericView.a(ComponentPolymericView.this);
      Object localObject2 = (ArticleInfo)localBaseArticleInfo;
      int j = getItemViewType(paramInt);
      int k = (int)localBaseArticleInfo.mChannelID;
      int i;
      if (localBaseArticleInfo.mChannelID == 3L)
      {
        i = 1;
        localObject2 = new lis((Context)localObject1, (ArticleInfo)localObject2, j, k, i, paramInt, false, getCount(), null, ComponentPolymericView.a(ComponentPolymericView.this).a.b());
        localObject1 = lwj.a(paramInt, localObject2, getItemViewType(paramInt), paramView, ComponentPolymericView.a(ComponentPolymericView.this), ComponentPolymericView.a(ComponentPolymericView.this).a.b(), ComponentPolymericView.a(ComponentPolymericView.this).a.b().a());
        if (localObject1 != null)
        {
          ((View)localObject1).setTag(2131381960, localObject2);
          ComponentPolymericView.a(ComponentPolymericView.this).a.b().a(localBaseArticleInfo, (lie)localObject2, System.currentTimeMillis(), paramInt);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView getView position:" + paramInt + " count:" + getCount());
        }
        if (ComponentPolymericView.a(ComponentPolymericView.this)[paramInt] == null) {
          ComponentPolymericView.a(ComponentPolymericView.this)[paramInt] = Boolean.valueOf(false);
        }
        if (((kxm.x(localBaseArticleInfo)) || (kxm.y(localBaseArticleInfo))) && (!ComponentPolymericView.a(ComponentPolymericView.this)[paramInt].booleanValue())) {
          localObject2 = new JSONObject();
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = (mhr.a)localBaseArticleInfo.mNewPolymericInfo.iP.get(0);
          ((JSONObject)localObject2).put("channel_id", localBaseArticleInfo.mChannelID);
          if (((mhr.a)localObject3).jdField_a_of_type_Mhr$b == null) {
            continue;
          }
          paramView = ((mhr.a)localObject3).jdField_a_of_type_Mhr$b.rowKey;
          ((JSONObject)localObject2).put("rowkey", paramView);
          if (((mhr.a)localObject3).jdField_a_of_type_Mhr$c == null) {
            continue;
          }
          i = ((mhr.a)localObject3).jdField_a_of_type_Mhr$c.aSe;
          ((JSONObject)localObject2).put("topicid", i);
        }
        catch (Exception paramView)
        {
          Object localObject3;
          paramView.printStackTrace();
          continue;
          paramView = "2";
          continue;
        }
        localObject3 = localBaseArticleInfo.mFeedId + "";
        if (!kxm.x(localBaseArticleInfo)) {
          continue;
        }
        paramView = "1";
        kbp.a(null, "CliOper", "", "", "0X8009829", "0X8009829", 0, 0, (String)localObject3, paramView, localBaseArticleInfo.mStrategyId + "", ((JSONObject)localObject2).toString(), false);
        ComponentPolymericView.a(ComponentPolymericView.this)[paramInt] = Boolean.valueOf(true);
        if ((kxm.r(localBaseArticleInfo)) && (localBaseArticleInfo.mPolymericInfo != null)) {
          localBaseArticleInfo.mPolymericInfo.aSh = paramInt;
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        i = 0;
        break;
        paramView = Integer.valueOf(0);
        continue;
        i = 0;
      }
    }
    
    public int getViewTypeCount()
    {
      return 15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */