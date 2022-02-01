import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.a;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;
import java.util.ArrayList;
import java.util.List;

public abstract class kte
  extends BaseAdapter
  implements ReadInJoyCommentLikeView.a, ktr.d
{
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected jzh a;
  protected kry a;
  protected ksx a;
  protected kte.a a;
  protected ktr a;
  protected int aLM = -1;
  protected boolean ahm = true;
  protected ArticleInfo b;
  protected CommentItemShowDispatcher b;
  protected kmh b;
  protected ksk.a b;
  protected ksk b;
  protected AbsListView.e c = new ktf(this);
  protected List<ktm> gv = new ArrayList();
  BaseActivity mActivity;
  protected VafContext mVafContext;
  
  private void aO(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "readToBiuActivity   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  private int da(int paramInt)
  {
    if (this.jdField_b_of_type_Ksk == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_b_of_type_Ksk.getHeight(j);
        j += 1;
        i = k + i;
      }
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "calculateScrollYOffsetHeight | firstVisiblePos " + paramInt + " totalHeight " + i);
      return i;
    }
  }
  
  abstract LayoutInflater a();
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public BaseActivity a()
  {
    return this.mActivity;
  }
  
  public ksx a()
  {
    return this.jdField_a_of_type_Ksx;
  }
  
  abstract ksz.a a();
  
  abstract ktr a();
  
  public void a(Activity paramActivity, View paramView, ktm paramktm, BubblePopupWindow.b paramb)
  {
    if ((paramActivity == null) || (paramView == null) || (paramktm == null) || (paramktm.a == null)) {
      return;
    }
    boolean bool = paramktm.a.isMyself();
    paramktm.a.isDisliked();
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    View localView = LayoutInflater.from(paramActivity).inflate(2131560283, null);
    Object localObject = (TextView)localView.findViewById(2131380581);
    if ((localObject != null) && (paramktm.a.mediaDataList != null) && (paramktm.a.mediaDataList.size() > 0))
    {
      if (((BaseCommentData.a)paramktm.a.mediaDataList.get(0)).medalType <= 0) {
        break label319;
      }
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      if ((localObject != null) && (!this.ahm)) {
        ((TextView)localObject).setVisibility(8);
      }
      try
      {
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM) && (localObject != null)) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          TextView localTextView;
          localNullPointerException.printStackTrace();
          continue;
          String str = "举报";
        }
      }
      localTextView = (TextView)localView.findViewById(2131380897);
      if (!bool) {
        break;
      }
      localObject = "删除";
      localTextView.setText((CharSequence)localObject);
      localObject = (TextView)localView.findViewById(2131380661);
      localBubblePopupWindow.setContentView(localView);
      localBubblePopupWindow.setOutsideTouchable(true);
      localBubblePopupWindow.showAsDropDown(paramView);
      localBubblePopupWindow.setFocusable(true);
      localBubblePopupWindow.a(paramb);
      if ((paramActivity instanceof FastWebActivity)) {
        ((FastWebActivity)paramActivity).a(localBubblePopupWindow);
      }
      paramActivity = new kth(this, paramktm, bool, paramActivity, localBubblePopupWindow);
      localView.findViewById(2131380632).setOnClickListener(paramActivity);
      localView.findViewById(2131380581).setOnClickListener(paramActivity);
      localTextView.setOnClickListener(paramActivity);
      ((TextView)localObject).setOnClickListener(paramActivity);
      return;
      label319:
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  public void a(Context paramContext, ksz.f paramf)
  {
    int i = 0;
    if (paramContext == null) {
      return;
    }
    paramf = ausj.b(paramContext);
    int[] arrayOfInt = new int[0];
    while (i < arrayOfInt.length)
    {
      paramf.addButton(arrayOfInt[i]);
      i += 1;
    }
    paramf.addCancelButton(2131721058);
    if (!paramf.isShowing()) {
      paramf.show();
    }
    paramf.a(new ktj(this, paramf, arrayOfInt, paramContext));
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ksk.a parama)
  {
    this.jdField_b_of_type_Ksk$a = parama;
  }
  
  public void a(kte.a parama)
  {
    this.jdField_a_of_type_Kte$a = parama;
  }
  
  public void a(ktm paramktm)
  {
    BaseCommentData localBaseCommentData = paramktm.a;
    int j = 4;
    int i;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label83;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      if (!TextUtils.isEmpty(localBaseCommentData.nickName)) {
        break label187;
      }
    }
    label187:
    for (paramktm = "";; paramktm = localBaseCommentData.nickName)
    {
      ksz.a(this.mActivity, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramktm, null, false, a(), -1, this.ahm);
      return;
      label83:
      if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 5)) || (kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  public void aHj()
  {
    int i = 2;
    if (this.aLM == 2) {
      i = 3;
    }
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onChangeCommentTypeClick | curType " + this.aLM + "; changeToType " + i);
    this.aLM = i;
    if (this.jdField_a_of_type_Ktr != null)
    {
      if (this.gv != null)
      {
        this.gv.clear();
        this.gv.addAll(this.jdField_a_of_type_Ktr.o(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Ktr.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.pH(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGR();
    }
    if ((i == 3) && ((this instanceof ksm))) {
      ((ksm)this).aGx();
    }
  }
  
  public jzh b()
  {
    return this.jdField_a_of_type_Jzh;
  }
  
  public boolean dn(int paramInt)
  {
    return paramInt == this.aLM;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.gv == null) || (paramInt >= this.gv.size())) {
      return -1;
    }
    ktm localktm = (ktm)this.gv.get(paramInt);
    if (localktm == null) {
      return -1;
    }
    if (kry.b(localktm)) {
      return this.jdField_a_of_type_Kry.a(localktm);
    }
    return ((ktm)this.gv.get(paramInt)).type;
  }
  
  public VafContext getVafContext()
  {
    return this.mVafContext;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Kry != null) {}
    for (int i = this.jdField_a_of_type_Kry.nD();; i = 0) {
      return i + 8;
    }
  }
  
  public void m(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    ksx localksx;
    if (this.jdField_a_of_type_Ktr != null)
    {
      this.jdField_a_of_type_Ktr.az(paramString, paramInt1);
      paramString = this.jdField_a_of_type_Ktr.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ksx != null)
      {
        localksx = this.jdField_a_of_type_Ksx;
        if (!(this instanceof ksm)) {
          break label109;
        }
      }
    }
    label109:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localksx.a(paramInt1, paramString);
      kmt.a(paramString);
      return;
    }
  }
  
  public void m(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    for (;;)
    {
      return;
      if ((paramktm.a.isAuthorReply()) && (!TextUtils.isEmpty(paramktm.a.ksHomePage))) {
        ksz.g(paramktm.a.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Ksx != null)
      {
        this.jdField_a_of_type_Ksx.c(paramktm);
        return;
        ksz.f(paramktm.a.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public void n(ktm paramktm)
  {
    ausj localausj = ausj.b(this.mActivity);
    localausj.addCancelButton(2131721058);
    if (!localausj.isShowing()) {
      localausj.show();
    }
    localausj.a(new ktg(this, paramktm, localausj));
    if (this.jdField_a_of_type_Ksx != null) {
      this.jdField_a_of_type_Ksx.b(paramktm);
    }
  }
  
  public int nI()
  {
    return this.aLM;
  }
  
  protected void o(ktm paramktm)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramktm == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramktm.a;
    int i = 4;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() != -1))
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    for (;;)
    {
      String str1 = ((BaseCommentData)localObject).commentContent;
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = kxm.a(new Intent(this.mActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      aO((Intent)localObject);
      this.mActivity.startActivity((Intent)localObject);
      this.mActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Ksx == null) {
        break;
      }
      this.jdField_a_of_type_Ksx.d(paramktm);
      return;
      if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 5)) || (kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null))
        {
          if (ReadInJoyDeliverBiuActivity.dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa)) {
            i = 9;
          }
        }
        else if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGallery != 0)
        {
          j = 10;
          i = 17;
          continue;
        }
        j = 19;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void p(ktm paramktm)
  {
    int j = 1;
    if (paramktm == null) {}
    do
    {
      return;
      localObject = paramktm.a;
      ktr localktr = a();
      String str = ((BaseCommentData)localObject).commentId;
      if (!((BaseCommentData)localObject).isDisliked()) {
        break;
      }
      i = 0;
      localktr.ay(str, i);
    } while (this.jdField_a_of_type_Ksx == null);
    Object localObject = this.jdField_a_of_type_Ksx;
    if ((this instanceof ksm)) {}
    for (int i = j;; i = 2)
    {
      ((ksx)localObject).b(i, paramktm);
      return;
      i = 1;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void i(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kte
 * JD-Core Version:    0.7.0.1
 */