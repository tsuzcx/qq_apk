import android.app.Activity;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wgm
  extends whp<CommentEntry>
  implements IEventReceiver
{
  public int a;
  public Activity a;
  public TextView a;
  public CommentLikeFeedItem a;
  public InnerListView a;
  public List<CommentEntry> a;
  public wfy a;
  public wgg a;
  public wgi a;
  public wgq a;
  protected wgr a;
  private wgx jdField_a_of_type_Wgx;
  protected wip a;
  protected wje a;
  private xwm jdField_a_of_type_Xwm;
  private xyd jdField_a_of_type_Xyd;
  private boolean jdField_a_of_type_Boolean;
  public List<CommentEntry> b = new ArrayList();
  public List<StoryVideoItem> c;
  
  public wgm(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wip = ((wip)wjs.a(17));
    this.jdField_a_of_type_Wje = ((wje)wjs.a(15));
    this.jdField_a_of_type_Xyd = new xyd();
    this.jdField_a_of_type_Xwm = new xwm(paramActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, true);
    this.c = paramList;
  }
  
  public static int a(int paramInt)
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
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = new wgy(a(paramInt1), paramString, paramInt2);
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      paramString.c = paramInt3;
    }
    wad.a().dispatch(paramString);
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, boolean paramBoolean, int paramInt, wgl paramwgl)
  {
    b(paramCommentLikeFeedItem, paramCommentEntry, paramInt, paramwgl, true, paramBoolean);
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
      paramwgl = "1";
      label43:
      if (!a(paramCommentEntry.content)) {
        break label117;
      }
    }
    label101:
    label110:
    label117:
    for (paramCommentEntry = "2";; paramCommentEntry = "1")
    {
      ykv.a("home_page", "send_comment", i, paramInt, new String[] { paramwgl, paramCommentEntry, who.a().a, paramCommentLikeFeedItem.feedId });
      return;
      paramInt = 1;
      break;
      i = ykv.a(paramCommentLikeFeedItem);
      break label27;
      paramwgl = "2";
      break label43;
    }
  }
  
  public static boolean a(String paramString)
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
      if (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, wgl paramwgl, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    wfy.b(paramCommentEntry, new wgo(paramwgl, paramCommentEntry, (wip)wjs.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public whq a()
  {
    this.jdField_a_of_type_Wfy = new wfy(this);
    return this.jdField_a_of_type_Wfy;
  }
  
  public whr a()
  {
    this.jdField_a_of_type_Wgg = new wgg(this);
    return this.jdField_a_of_type_Wgg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Wgr != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Wgr);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("FeedCommentLego", 1, "deleteComment but index is : " + paramInt + " and commentlist size is" + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "deleteCommentData: " + localCommentEntry);
    }
    if (localCommentEntry.status != 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      e();
      QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131703875), 0).a();
      this.jdField_a_of_type_Wip.d(localCommentEntry);
      whi.a().a();
      a(this.jdField_a_of_type_Int, 2, localCommentEntry.feedId, localCommentEntry.commentId);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703881), 0).a();
      ykq.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    localCommentEntry.status = 1;
    e();
    wfy.a(localCommentEntry, new wgp(this, paramInt, localCommentEntry));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364953));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOverScrollMode(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371499));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Wgr = new wgr(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Wgr);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    if (this.jdField_a_of_type_Wgg != null) {
      this.jdField_a_of_type_Wgg.a(paramCommentLikeFeedItem);
    }
    this.jdField_a_of_type_Xwm.a(paramCommentLikeFeedItem);
    this.c = paramList;
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (TextUtils.hasSysEmotion(paramString))
    {
      localCommentEntry.content = bcsc.a(paramString);
      label31:
      localCommentEntry.replyTime = System.currentTimeMillis();
      if (paramCommentEntry != null)
      {
        localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
        localCommentEntry.replierName = paramCommentEntry.authorName;
        localCommentEntry.replierRole = paramCommentEntry.authorRole;
      }
      localCommentEntry.authorUin = QQStoryContext.a().getCurrentUin();
      localCommentEntry.authorUnionId = QQStoryContext.a().b();
      localCommentEntry.status = 1;
      localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      localCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
      if (((Integer)((wjl)wjs.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
        localCommentEntry.authorRole = 2;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment != 1) {
        break label247;
      }
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703874), 0).a();
      localCommentEntry.status = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      e();
      this.jdField_a_of_type_Wip.b(localCommentEntry);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedCommentLego", 2, "AddComment: " + localCommentEntry.toString());
      return;
      localCommentEntry.content = paramString;
      break label31;
      label247:
      who.a().a = "";
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, localCommentEntry, false, this.jdField_a_of_type_Int, new wgn(this));
    }
  }
  
  public void a(List<CommentEntry> paramList)
  {
    a(paramList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemClickListener(this.jdField_a_of_type_Wgg);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemLongClickListener(this.jdField_a_of_type_Wgg);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Wgg);
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLego", 2, "renderCommentList:" + paramList);
    }
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_Wgq == null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.a(2131561670, 2);
      this.jdField_a_of_type_Wgq = new wgq(this, 2131561670, this.jdField_a_of_type_JavaUtilList, true);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wgq);
    }
    for (;;)
    {
      e();
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilList = paramList;
      } else {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
    }
  }
  
  public void a(wgi paramwgi)
  {
    this.jdField_a_of_type_Wgi = paramwgi;
  }
  
  public void a(wgx paramwgx)
  {
    this.jdField_a_of_type_Wgx = paramwgx;
  }
  
  public void a(whr paramwhr)
  {
    super.a(paramwhr);
    this.jdField_a_of_type_Wgg = ((wgg)paramwhr);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    wgs localwgs = (wgs)a();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean) {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    for (localCommentLikeFeedItem.mCommentCount += 1;; localCommentLikeFeedItem.mCommentCount -= 1)
    {
      localwgs.a(null);
      if (paramCommentEntry != null) {
        localwgs.a.a(paramCommentEntry);
      }
      return;
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703868), 0).a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wgq = new wgq(this, 2131561670, this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wgq);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Wgq = new wgq(this, 2131561670, this.jdField_a_of_type_JavaUtilList, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wgq);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */