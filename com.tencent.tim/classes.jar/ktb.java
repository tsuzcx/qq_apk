import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView.b;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ktb
  extends kte
  implements ReadInJoyCommentListView.b
{
  private final String TAG = "ReadInJoySecondCommentListAdapter";
  private ksm.a jdField_a_of_type_Ksm$a;
  private ktr.c jdField_a_of_type_Ktr$c;
  private int aLx = 0;
  private String abZ;
  private ReadInJoySecondCommentListFragment b;
  private LayoutInflater inflater;
  private int mContentSrc;
  
  public ktb(FragmentActivity paramFragmentActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.inflater = LayoutInflater.from(paramFragmentActivity);
    this.mActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = paramReadInJoySecondCommentListFragment;
    this.aLx = paramInt;
    this.jdField_a_of_type_Kry = new kry();
    this.jdField_a_of_type_Kry.b(getVafContext());
    this.jdField_b_of_type_Ksk = new ksk(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.gv, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.c);
  }
  
  private void bX(List<ktm> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ktm localktm = (ktm)paramList.next();
        if ((localktm.a instanceof CommentData)) {
          localktm.a.isAnchor = false;
        }
      }
    }
  }
  
  LayoutInflater a()
  {
    return this.inflater;
  }
  
  ksz.a a()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    return null;
  }
  
  public ktm a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.gv.size())) {
      return (ktm)this.gv.get(paramInt);
    }
    return null;
  }
  
  public ktr a()
  {
    return this.jdField_a_of_type_Ktr;
  }
  
  public void a(String paramString1, String paramString2, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.abZ = paramString1;
    this.mContentSrc = paramInt;
    this.jdField_a_of_type_Ktr = ktr.a(paramArticleInfo);
    this.jdField_a_of_type_Ksx = new ksx(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    if (this.jdField_a_of_type_Ktr != null)
    {
      this.jdField_a_of_type_Ktr.c(this);
      this.gv.clear();
      paramArticleInfo = this.jdField_a_of_type_Ktr.z(paramString1);
      bX(paramArticleInfo);
      this.gv.addAll(paramArticleInfo);
      this.jdField_a_of_type_Ktr.bw(paramString1, paramString2);
      notifyDataSetChanged();
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
      this.jdField_a_of_type_Ksx.a(2, paramktm);
    }
  }
  
  public void a(ktr.c paramc)
  {
    this.jdField_a_of_type_Ktr$c = paramc;
  }
  
  public void d(ListView paramListView)
  {
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.aGV();
    }
    if (this.jdField_a_of_type_Ktr != null) {
      this.jdField_a_of_type_Ktr.mx(this.abZ);
    }
  }
  
  public boolean dn(int paramInt)
  {
    return true;
  }
  
  public int getCount()
  {
    return this.gv.size();
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
    if (this.mVafContext == null)
    {
      this.mVafContext = new luh();
      this.mVafContext.setContext(this.mActivity);
      kvx.a(this.mVafContext, "comment_feeds");
    }
    int i = getItemViewType(paramInt);
    Object localObject;
    switch (i)
    {
    case 1: 
    case 2: 
    default: 
      if (this.jdField_a_of_type_Ksx != null) {
        this.jdField_a_of_type_Ksx.pJ(paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    case 3: 
      if (paramView == null)
      {
        localObject = new ktk.a();
        paramView = ((ktk.a)localObject).a(this, paramInt, paramView, paramViewGroup);
      }
      for (;;)
      {
        ((ktk.a)localObject).a(this, paramInt);
        break;
        localObject = (ktk.a)paramView.getTag();
      }
    }
    if (kry.b(a(paramInt)))
    {
      localObject = this.jdField_a_of_type_Kry.a(a(paramInt));
      if ((paramView != null) && ((paramView instanceof Container))) {
        break label304;
      }
      paramView = this.mVafContext.getViewFactory().inflate(this.mVafContext, (TemplateBean)localObject);
    }
    label304:
    for (;;)
    {
      kry.a(this.mVafContext, (Container)paramView, (TemplateBean)localObject, this, paramInt, i, true);
      break;
      localObject = kqy.a(this.mVafContext, a(paramInt), i, false, this);
      if ((paramView == null) || (!(paramView instanceof Container))) {
        paramView = this.mVafContext.getViewFactory().inflate(this.mVafContext, (TemplateBean)localObject);
      }
      for (;;)
      {
        kqy.a(this.mVafContext, (Container)paramView, (TemplateBean)localObject, this, paramInt, i, false);
        break;
      }
    }
  }
  
  public String iH()
  {
    return this.abZ;
  }
  
  public void onCommentCreate(boolean paramBoolean, ktm paramktm, List<ktm> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, ktm paramktm, boolean paramBoolean2, List<ktm> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, ktm paramktm, int paramInt2)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (!dn(paramInt2))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentDelete | wrong firstFeedsType");
        return;
      }
      if (paramInt1 == 1) {
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.aHh();
        }
      }
      while (this.jdField_a_of_type_Ksm$a != null)
      {
        this.jdField_a_of_type_Ksm$a.ch(this.jdField_a_of_type_Ktr.cm());
        return;
        if (this.jdField_a_of_type_Ktr != null)
        {
          paramktm = this.jdField_a_of_type_Ktr.A(this.abZ);
          if (!paramktm.isEmpty())
          {
            this.gv.clear();
            this.gv.addAll(paramktm);
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 2) {}
    do
    {
      return;
      QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad sub comments " + paramBoolean1 + " flowType : " + paramInt2);
      if (!dn(paramInt3))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad | wrong firstFeedsType");
        return;
      }
    } while ((!paramBoolean1) || (this.gv == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
    bX(paramList);
    this.gv.clear();
    this.gv.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(paramBoolean2);
    notifyDataSetChanged();
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 2) {}
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore sub comments " + paramBoolean1);
        if (!dn(paramInt2))
        {
          QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore | wrong firstFeedsType");
          return;
        }
        if (!paramBoolean1) {
          break;
        }
      } while ((this.gv == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
      this.gv.addAll(paramList);
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(paramBoolean2);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aAc();
  }
  
  public void onCommentReply(boolean paramBoolean, ktm paramktm)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Ktr == null) {
        break label118;
      }
    }
    label118:
    for (paramktm = this.jdField_a_of_type_Ktr.A(this.abZ);; paramktm = new ArrayList())
    {
      if ((!paramktm.isEmpty()) && (this.gv != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null))
      {
        this.gv.clear();
        this.gv.addAll(paramktm);
        notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
      }
      if ((this.jdField_a_of_type_Ksm$a != null) && (this.jdField_a_of_type_Ktr != null)) {
        this.jdField_a_of_type_Ksm$a.ch(this.jdField_a_of_type_Ktr.cm());
      }
      return;
    }
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
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.en(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.cl());
    }
    this.inflater = null;
    this.mActivity = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    this.jdField_a_of_type_Ksx = null;
    this.jdField_a_of_type_Ktr = null;
    this.jdField_a_of_type_Ksm$a = null;
    this.jdField_a_of_type_Ktr$c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktb
 * JD-Core Version:    0.7.0.1
 */