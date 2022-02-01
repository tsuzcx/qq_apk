import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView.b;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class ksm
  extends kte
  implements ReadInJoyCommentListView.b
{
  public static int aLx = 0;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ksm.a jdField_a_of_type_Ksm$a;
  private ksz.b jdField_a_of_type_Ksz$b;
  private ktr.c jdField_a_of_type_Ktr$c;
  private int aLA = -1;
  public int aLy;
  private int aLz = -1;
  private LayoutInflater inflater;
  private int mContentSrc;
  
  public ksm(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.inflater = LayoutInflater.from(paramFragmentActivity);
    this.mActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_Ksz$b = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.mContentSrc = paramInt;
    aLx = paramInt;
    this.jdField_a_of_type_Kry = new kry();
    this.jdField_a_of_type_Kry.b(getVafContext());
    this.jdField_b_of_type_Ksk = new ksk(paramReadInJoyCommentListView, this.gv, this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher = new CommentItemShowDispatcher();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.a(this.jdField_b_of_type_Ksk);
    this.jdField_b_of_type_Kmh = new kmh(paramFragmentActivity, null);
    this.jdField_a_of_type_Jzh = new jzh(paramFragmentActivity, paramReadInJoyCommentListView);
    paramReadInJoyCommentListView.setOnScrollListener(this.c);
    kmt.a(paramReadInJoyCommentListView);
  }
  
  public ksm(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.inflater = LayoutInflater.from(paramFastWebActivity);
    this.mActivity = paramFastWebActivity;
    this.jdField_a_of_type_Ksz$b = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.mContentSrc = paramInt;
    aLx = paramInt;
    this.jdField_a_of_type_Kry = new kry();
    this.jdField_a_of_type_Kry.b(getVafContext());
    this.jdField_b_of_type_Ksk = new ksk(paramReadInJoyCommentListView, this.gv, this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher = new CommentItemShowDispatcher();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.a(this.jdField_b_of_type_Ksk);
    this.jdField_b_of_type_Kmh = new kmh(paramFastWebActivity, null);
    this.jdField_a_of_type_Jzh = new jzh(paramFastWebActivity, paramReadInJoyCommentListView);
    paramReadInJoyCommentListView.setOnScrollListener(this.c);
    kmt.a(paramReadInJoyCommentListView);
  }
  
  private void bW(List<ktm> paramList)
  {
    if (this.jdField_a_of_type_Ktr.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Ktr.a();
      if ((((ktr.b)localObject).ahV) && (((ktr.b)localObject).acs != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ktm)paramList.next();
          if ((localObject != null) && (((ktm)localObject).a != null) && (((ktm)localObject).a.isAnchor)) {
            ((ktm)localObject).a.isAnchor = false;
          }
        }
      }
    }
  }
  
  private boolean dl(int paramInt)
  {
    if ((this.aLM == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5))) {
      this.aLM = paramInt;
    }
    while (this.aLM == paramInt) {
      return true;
    }
    return false;
  }
  
  private boolean dm(int paramInt)
  {
    if ((paramInt == 2) && ((this.aLM == 2) || (this.aLM == 3))) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
    }
    while (this.aLM == paramInt) {
      return true;
    }
    return false;
  }
  
  private void mF(boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if ((paramBoolean) && (a() != null))
    {
      this.aLz = a().getFirstVisiblePosition();
      localView = a().getChildAt(0);
      if (localView != null) {
        break label43;
      }
    }
    for (;;)
    {
      this.aLA = i;
      return;
      label43:
      i = localView.getTop();
    }
  }
  
  private void pA(int paramInt)
  {
    if (this.jdField_a_of_type_Ksz$b != null) {
      this.jdField_a_of_type_Ksz$b.pC(paramInt);
    }
  }
  
  LayoutInflater a()
  {
    return this.inflater;
  }
  
  ksz.a a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public ktm a(int paramInt)
  {
    if ((this.gv != null) && (!this.gv.isEmpty()) && (paramInt >= 0) && (paramInt < this.gv.size())) {
      return (ktm)this.gv.get(paramInt);
    }
    return null;
  }
  
  public ktr a()
  {
    return this.jdField_a_of_type_Ktr;
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    QLog.d("ReadInJoyCommentListAdapter", 2, "initArticleCommentInfoModule | articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + "; contentSrc : " + paramInt + " reqFeedsType Default 5 currentFeedsType " + this.aLM);
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentListAdapter", 1, "initArticleCommentInfoModule | reqFeedsType " + paramInt1 + " ; currentFeedsType " + this.aLM + " ; articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + ";feedsType ：" + paramInt1 + "; contentSrc : " + paramInt2);
    this.ahm = paramBoolean;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.aLM = paramInt1;
    this.jdField_a_of_type_Ktr = ktr.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_Ktr != null)
    {
      this.jdField_a_of_type_Ktr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.Aw())) {
        this.jdField_a_of_type_Ktr.R(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.Ax(), paramInt1);
      }
      this.jdField_a_of_type_Ksx = new ksx(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_Ktr.c(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.acb)))
      {
        paramArticleInfo = paramAnchorData.acb;
        str = paramAnchorData.acd;
        if (paramAnchorData.ahJ) {
          break label265;
        }
      }
    }
    label265:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new ktr.b(paramArticleInfo, str, paramBoolean, paramAnchorData.ahJ);
      this.jdField_a_of_type_Ktr.a(paramArticleInfo);
      this.jdField_a_of_type_Ktr.cz(paramInt1, 1);
      this.gv.clear();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ksm.a parama)
  {
    this.jdField_a_of_type_Ksm$a = parama;
  }
  
  public void a(ktm paramktm)
  {
    super.a(paramktm);
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.a(1, paramktm);
    }
  }
  
  public void a(ktm paramktm, SubCommentData paramSubCommentData)
  {
    if ((this.jdField_a_of_type_Ksz$b != null) && (paramktm != null) && (paramktm.articleInfo != null) && (paramktm.a != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_Ksz$b.g(true, paramktm.a.commentId, str);
      if (this.jdField_a_of_type_Ksx != null) {
        this.jdField_a_of_type_Ksx.b(paramktm, paramSubCommentData);
      }
    }
  }
  
  public void a(ktr.c paramc)
  {
    this.jdField_a_of_type_Ktr$c = paramc;
  }
  
  public void aGs()
  {
    if (this.jdField_a_of_type_Ktr != null)
    {
      this.jdField_a_of_type_Ktr.cz(this.aLM, 1);
      QLog.d("ReadInJoyCommentListAdapter", 2, "reloadData | feedsType " + this.aLM);
    }
  }
  
  public void aGt()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.aGt();
    }
  }
  
  public void aGu()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.aGu();
    }
  }
  
  public void aGv()
  {
    aGy();
  }
  
  public void aGw()
  {
    aGy();
  }
  
  public void aGx()
  {
    if ((a() != null) && (this.aLz > -1)) {
      a().setSelectionFromTop(this.aLz, this.aLA);
    }
  }
  
  public void aGy()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    int j = nE();
    if (this.mContentSrc != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPosition(j);
      QLog.d("ReadInJoyCommentListAdapter", 2, "scrollToComment | contentSrc " + this.mContentSrc + "; titlePos " + j);
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof auts)) {
      localObject = ((auts)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof nlc))
    {
      localObject = ((nlc)localObject).bh().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof nle));
    }
    for (int i = localListAdapter.getCount();; i = -1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "scrollToComment | articleItemCnt: " + i + " titlePos : " + j);
      if (i != -1) {
        i += j;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(i, 0);
        return;
        i = j;
      }
    }
  }
  
  public void d(ListView paramListView)
  {
    if (this.jdField_a_of_type_Ktr != null)
    {
      this.jdField_a_of_type_Ktr.pN(this.aLM);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.aLM);
    }
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.aGT();
    }
  }
  
  public int getCount()
  {
    if (this.gv != null) {
      return this.gv.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public VafContext getVafContext()
  {
    if (this.mVafContext == null)
    {
      this.mVafContext = new luh();
      this.mVafContext.setCurActivity(this.mActivity);
      this.mVafContext.setContext(this.mActivity);
      kvx.a(this.mVafContext, "comment_feeds");
    }
    return this.mVafContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.mVafContext = getVafContext();
    int i = getItemViewType(paramInt);
    View localView;
    Object localObject;
    if (i == 6)
    {
      localView = this.jdField_a_of_type_Ktr.a().a(paramViewGroup, paramView, this.mActivity, a(paramInt));
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    if (kry.b(a(paramInt)))
    {
      localObject = this.jdField_a_of_type_Kry.a(a(paramInt));
      if (paramView != null) {
        break label313;
      }
      paramView = this.mVafContext.getViewFactory().inflate(this.mVafContext, (TemplateBean)localObject);
    }
    label313:
    for (;;)
    {
      kry.a(this.mVafContext, (Container)paramView, (TemplateBean)localObject, this, paramInt, i, true);
      kmt.a(this, a(paramInt), paramInt, paramView);
      if (this.jdField_a_of_type_Ksx != null) {
        this.jdField_a_of_type_Ksx.pI(paramInt);
      }
      if (this.jdField_a_of_type_Kte$a != null) {
        this.jdField_a_of_type_Kte$a.i(paramInt, paramView);
      }
      if (paramView == null) {
        QLog.d("ReadInJoyCommentListAdapter", 2, "comment convertview is null position " + paramInt + " viewtype " + i + "\n commentItem: " + a(paramInt).a);
      }
      localObject = paramView;
      localView = paramView;
      break;
      localObject = kqy.a(this.mVafContext, a(paramInt), i, true, this);
      if (paramView == null)
      {
        auvk.traceBegin("ReadInJoyCommentAdapter.create convertView");
        paramView = this.mVafContext.getViewFactory().inflate(this.mVafContext, (TemplateBean)localObject);
        auvk.traceEnd();
      }
      for (;;)
      {
        kqy.a(this.mVafContext, (Container)paramView, (TemplateBean)localObject, this, paramInt, i, true);
        break;
      }
    }
  }
  
  public int nE()
  {
    int j;
    if ((this.gv == null) || (this.gv.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.gv.size()) {
        break label79;
      }
      ktm localktm = (ktm)this.gv.get(i);
      j = i;
      if (localktm.type == 2) {
        break;
      }
      j = i;
      if (localktm.type == 1) {
        break;
      }
      i += 1;
    }
    label79:
    return -1;
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentCreate(boolean paramBoolean, ktm paramktm, List<ktm> paramList, int paramInt)
  {
    if (!dm(paramInt)) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.aLM + ", feedsType " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      if (kqc.Al()) {}
      pA(4);
      if ((paramList != null) && (paramList.size() > 0))
      {
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentCreate commentViewItemList size " + paramList.size());
        if (this.gv != null)
        {
          this.gv.clear();
          this.gv.addAll(paramList);
          notifyDataSetChanged();
          aGv();
        }
      }
      if (this.jdField_a_of_type_Ksm$a != null) {
        this.jdField_a_of_type_Ksm$a.ch(this.jdField_a_of_type_Ktr.r(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramktm.a;
    paramktm = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramktm = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    lcc.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramktm);
  }
  
  public void onCommentCreate(boolean paramBoolean1, ktm paramktm, boolean paramBoolean2, List<ktm> paramList, int paramInt)
  {
    if (!dm(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.aLM + ", feedsType " + paramInt);
      return;
    }
    mF(paramBoolean2);
    onCommentCreate(paramBoolean1, paramktm, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, ktm paramktm, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Ktr == null)) {
      return;
    }
    if (!dn(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.aLM + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramktm = this.jdField_a_of_type_Ktr.o(paramInt2);
      if ((paramktm != null) && (this.gv != null))
      {
        this.gv.clear();
        this.gv.addAll(paramktm);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        pA(2);
      }
      if (this.jdField_a_of_type_Ksm$a == null) {
        break;
      }
      this.jdField_a_of_type_Ksm$a.ch(this.jdField_a_of_type_Ktr.r(paramInt2));
      return;
      if ((paramInt1 == 2) && (this.gv != null))
      {
        paramInt1 = 0;
        if (paramInt1 < this.gv.size())
        {
          ktm localktm = (ktm)this.gv.get(paramInt1);
          if ((localktm == null) || (localktm.type != 0)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((paramktm != null) && (paramktm.a != null) && (localktm.a != null) && (TextUtils.equals(localktm.a.commentId, ((SubCommentData)paramktm.a).parentCommentId))) {
              localktm.aHk();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!dl(paramInt3))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad | wrong feedstype , currentFeedsType " + this.aLM + ", feedsType " + paramInt3);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("onCommentListLoad first comments ").append(paramBoolean1).append(" feedsType : ").append(paramInt2).append("\n commentDataListSize ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, i);
      if (paramBoolean1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aAc();
      }
      pA(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(paramBoolean2);
    }
    if ((this.gv != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.gv.clear();
      this.gv.addAll(paramList);
      pA(4);
      bW(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ktr$c != null) {
        this.jdField_a_of_type_Ktr$c.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Ksm$a != null)
      {
        long l = this.jdField_a_of_type_Ktr.r(this.aLM);
        this.jdField_a_of_type_Ksm$a.ch(l);
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.aLM + " count : " + l);
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher == null) {
        break;
      }
      kmt.a(a().app, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher, 0, paramList);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
      return;
      pA(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!dn(paramInt2))
          {
            QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentLoadMore | wrong feedstype , currentFeedsType " + this.aLM + ", feedsType " + paramInt2);
            return;
          }
          if (!paramBoolean1) {
            break;
          }
        } while ((this.gv == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
        paramInt1 = this.gv.size();
        this.gv.addAll(paramList);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(paramBoolean2);
        notifyDataSetChanged();
      } while (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher == null);
      kmt.a(a().app, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher, paramInt1, paramList);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(paramBoolean2);
  }
  
  public void onCommentReply(boolean paramBoolean, ktm paramktm)
  {
    if (paramktm == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      if (this.gv != null)
      {
        int i = 0;
        if (i < this.gv.size())
        {
          localObject = (ktm)this.gv.get(i);
          if ((localObject == null) || (((ktm)localObject).type != 0) || (((ktm)localObject).a == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((ktm)localObject).a.commentId, ((SubCommentData)paramktm.a).parentCommentId)) {
              ((ktm)localObject).aHk();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ksm$a != null) {
        this.jdField_a_of_type_Ksm$a.ch(this.jdField_a_of_type_Ktr.r(this.aLM));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramktm.a;
    paramktm = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramktm = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    lcc.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramktm);
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Ktr$c != null) {
      this.jdField_a_of_type_Ktr$c.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
  }
  
  public void onDestroy()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.ck();
    }
    if (this.jdField_a_of_type_Ktr != null) {
      this.jdField_a_of_type_Ktr.a(this);
    }
    if ((this.jdField_a_of_type_Ksx != null) && (aLx != 1)) {
      this.jdField_a_of_type_Ksx.W(l, 2);
    }
    this.inflater = null;
    this.mActivity = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    if (this.mVafContext != null)
    {
      this.mVafContext.setCurActivity(null);
      this.mVafContext = null;
    }
    kmt.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.aZs();
    }
    if (this.jdField_b_of_type_Kmh != null) {
      this.jdField_b_of_type_Kmh.destroy();
    }
    if (this.jdField_a_of_type_Jzh != null) {
      this.jdField_a_of_type_Jzh.doOnDestory();
    }
  }
  
  public static abstract interface a
  {
    public abstract void ch(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksm
 * JD-Core Version:    0.7.0.1
 */