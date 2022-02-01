import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class pqj
  extends prf<CommentEntry>
  implements IEventReceiver
{
  private boolean Dr;
  public CommentLikeFeedItem a;
  public InnerListView a;
  public pqh.b a;
  public pqj.a a;
  protected pqj.b a;
  private pqn.a jdField_a_of_type_Pqn$a;
  protected psa a;
  protected psm a;
  private qrx.b jdField_a_of_type_Qrx$b;
  private qss.b jdField_a_of_type_Qss$b;
  public pqf b;
  public pqh b;
  public List<CommentEntry> lK = new ArrayList();
  public Activity mActivity;
  public int mFeedType;
  public List<CommentEntry> mv = new ArrayList();
  public List<StoryVideoItem> mw;
  public TextView wX;
  
  public pqj(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.mActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.mFeedType = paramInt;
    this.jdField_a_of_type_Psa = ((psa)psx.a(17));
    this.jdField_a_of_type_Psm = ((psm)psx.a(15));
    this.jdField_a_of_type_Qss$b = new qss.b();
    this.jdField_a_of_type_Qrx$b = new qrx.b(paramActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.mFeedType, true);
    this.mw = paramList;
  }
  
  private static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, pqh.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    pqf.b(paramCommentEntry, new pql(paramd, paramCommentEntry, (psa)psx.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, boolean paramBoolean, int paramInt, pqh.d paramd)
  {
    a(paramCommentLikeFeedItem, paramCommentEntry, paramInt, paramd, true, paramBoolean);
    int i;
    if (paramCommentEntry.isReply())
    {
      paramInt = 2;
      if (!paramBoolean) {
        break label101;
      }
      i = 12;
      label27:
      if (!paramCommentLikeFeedItem.getOwner().isMe()) {
        break label110;
      }
      paramd = "1";
      label43:
      if (!fd(paramCommentEntry.content)) {
        break label117;
      }
    }
    label101:
    label110:
    label117:
    for (paramCommentEntry = "2";; paramCommentEntry = "1")
    {
      rar.a("home_page", "send_comment", i, paramInt, new String[] { paramd, paramCommentEntry, pre.a().auz, paramCommentLikeFeedItem.feedId });
      return;
      paramInt = 1;
      break;
      i = rar.a(paramCommentLikeFeedItem);
      break label27;
      paramd = "2";
      break label43;
    }
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = new pqs(dO(paramInt1), paramString, paramInt2);
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      paramString.commentId = paramInt3;
    }
    pmi.a().dispatch(paramString);
  }
  
  public static int dO(int paramInt)
  {
    int i = 0;
    if (paramInt == 12) {
      i = 3;
    }
    while ((paramInt != 210) && (paramInt != 222) && (paramInt != 23) && (paramInt != 220) && (paramInt != 221) && (paramInt != 211)) {
      return i;
    }
    return 2;
  }
  
  public static boolean fd(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label42;
      }
      int k = paramString.charAt(i);
      if (aoff.ah.get(k, -1) < 0) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  public prg a()
  {
    this.jdField_b_of_type_Pqf = new pqf(this);
    return this.jdField_b_of_type_Pqf;
  }
  
  public prh a()
  {
    this.jdField_b_of_type_Pqh = new pqh(this);
    return this.jdField_b_of_type_Pqh;
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    if (this.jdField_b_of_type_Pqh != null) {
      this.jdField_b_of_type_Pqh.a(paramCommentLikeFeedItem);
    }
    this.jdField_a_of_type_Qrx$b.b(paramCommentLikeFeedItem);
    this.mw = paramList;
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (aofy.Z(paramString))
    {
      localCommentEntry.content = anbk.nm(paramString);
      label31:
      localCommentEntry.replyTime = System.currentTimeMillis();
      if (paramCommentEntry != null)
      {
        localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
        localCommentEntry.replierName = paramCommentEntry.authorName;
        localCommentEntry.replierRole = paramCommentEntry.authorRole;
      }
      localCommentEntry.authorUin = QQStoryContext.a().getCurrentUin();
      localCommentEntry.authorUnionId = QQStoryContext.a().getCurrentUid();
      localCommentEntry.status = 1;
      localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      localCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
      if (((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
        localCommentEntry.authorRole = 2;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment != 1) {
        break label248;
      }
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706124), 0).show();
      localCommentEntry.status = 2;
    }
    for (;;)
    {
      this.lK.add(localCommentEntry);
      notifyDataSetChanged();
      this.jdField_a_of_type_Psa.c(localCommentEntry);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedCommentLego", 2, "AddComment: " + localCommentEntry.toString());
      return;
      localCommentEntry.content = paramString;
      break label31;
      label248:
      pre.a().auz = "";
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, localCommentEntry, false, this.mFeedType, new pqk(this));
    }
  }
  
  public void a(pqh.b paramb)
  {
    this.jdField_a_of_type_Pqh$b = paramb;
  }
  
  public void a(pqn.a parama)
  {
    this.jdField_a_of_type_Pqn$a = parama;
  }
  
  public void a(prh paramprh)
  {
    super.a(paramprh);
    this.jdField_b_of_type_Pqh = ((pqh)paramprh);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    pqn localpqn = (pqn)a();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean) {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    for (localCommentLikeFeedItem.mCommentCount += 1;; localCommentLikeFeedItem.mCommentCount -= 1)
    {
      localpqn.dX(null);
      if (paramCommentEntry != null) {
        localpqn.a.k(paramCommentEntry);
      }
      return;
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
  }
  
  public void bmn()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(0);
    this.wX.setVisibility(8);
  }
  
  public void bmo()
  {
    this.jdField_a_of_type_Pqj$a = new pqj.a(2131561840, this.lK, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Pqj$a);
  }
  
  public void dX(List<CommentEntry> paramList)
  {
    x(paramList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemClickListener(this.jdField_b_of_type_Pqh);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemLongClickListener(this.jdField_b_of_type_Pqh);
    this.wX.setOnClickListener(this.jdField_b_of_type_Pqh);
  }
  
  public void g(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131365030));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOverScrollMode(1);
    this.wX = ((TextView)paramView.findViewById(2131371885));
    this.Dr = true;
    this.jdField_a_of_type_Pqj$b = new pqj.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Pqj$b);
  }
  
  public boolean isValidate()
  {
    return this.Dr;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Pqj$a = new pqj.a(2131561840, this.lK, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Pqj$a);
  }
  
  public void onDestory()
  {
    this.Dr = false;
    if (this.jdField_a_of_type_Pqj$b != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Pqj$b);
    }
  }
  
  public void showError()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(8);
    this.wX.setVisibility(0);
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706118), 0).show();
  }
  
  public void showLoading() {}
  
  public void vT(int paramInt)
  {
    if (paramInt >= this.lK.size())
    {
      QLog.e("FeedCommentLego", 1, "deleteComment but index is : " + paramInt + " and commentlist size is" + this.lK.size());
      return;
    }
    CommentEntry localCommentEntry = (CommentEntry)this.lK.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "deleteCommentData: " + localCommentEntry);
    }
    if (localCommentEntry.status != 0)
    {
      this.lK.remove(paramInt);
      notifyDataSetChanged();
      QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131706125), 0).show();
      this.jdField_a_of_type_Psa.e(localCommentEntry);
      pqy.a().bmw();
      b(this.mFeedType, 2, localCommentEntry.feedId, localCommentEntry.commentId);
      return;
    }
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706131), 0).show();
      ram.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    localCommentEntry.status = 1;
    notifyDataSetChanged();
    pqf.a(localCommentEntry, new pqm(this, paramInt, localCommentEntry));
  }
  
  public void x(List<CommentEntry> paramList, boolean paramBoolean)
  {
    bmn();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "renderCommentList:" + paramList);
    }
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_Pqj$a == null)
    {
      this.lK = paramList;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.ev(2131561840, 2);
      this.jdField_a_of_type_Pqj$a = new pqj.a(2131561840, this.lK, true);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Pqj$a);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (paramBoolean) {
        this.lK = paramList;
      } else {
        this.lK.addAll(paramList);
      }
    }
  }
  
  public class a
    extends rsj<CommentEntry>
  {
    boolean aBi;
    
    public a(List<CommentEntry> paramList, boolean paramBoolean)
    {
      super(paramBoolean);
      boolean bool;
      this.aBi = bool;
    }
    
    public void a(int paramInt, CommentEntry paramCommentEntry, qyd paramqyd)
    {
      if (paramCommentEntry == null) {
        ram.e("FeedCommentLego", "FeedComment getView. data is null.");
      }
      Object localObject2;
      Object localObject1;
      do
      {
        do
        {
          return;
          localObject2 = (TextView)paramqyd.get(2131364999);
          paramqyd = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
          localObject1 = pre.a().a(paramqyd);
          if ((localObject1 != null) && (this.aBi))
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setSpannableFactory(aofk.a);
            ((TextView)localObject2).setOnTouchListener(pqj.a(pqj.this));
            return;
          }
          localObject1 = qrx.a(pqj.this.mContext, pqj.this.a, paramCommentEntry, pqj.a(pqj.this));
          if (QQStoryContext.isNightMode()) {
            ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(pqj.this.mContext.getResources().getColor(2131166761)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(aofk.a);
          ((TextView)localObject2).setOnTouchListener(pqj.a(pqj.this));
          ptf localptf = (ptf)psx.a(2);
          localObject2 = localptf.b(paramCommentEntry.authorUnionId);
          if (!paramCommentEntry.isReply()) {
            break;
          }
          paramCommentEntry = localptf.b(paramCommentEntry.replierUnionId);
        } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
        pre.a().a(paramqyd, (CharSequence)localObject1);
        return;
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
      pre.a().a(paramqyd, (CharSequence)localObject1);
    }
  }
  
  public static class b
    extends QQUIEventReceiver<pqj, pxq.c>
  {
    public b(@NonNull pqj parampqj)
    {
      super();
    }
    
    public void a(@NonNull pqj parampqj, @NonNull pxq.c paramc)
    {
      if (paramc.b.isFail()) {}
      CommentEntry localCommentEntry;
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext()) {
          localIterator = parampqj.lK.iterator();
        }
        localCommentEntry = (CommentEntry)localIterator.next();
      } while ((paramc.fl.get(localCommentEntry.authorUnionId) == null) && (paramc.fl.get(localCommentEntry.replierUnionId) == null));
      parampqj.bmo();
      ram.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
    }
    
    public Class acceptEventClass()
    {
      return pxq.c.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqj
 * JD-Core Version:    0.7.0.1
 */