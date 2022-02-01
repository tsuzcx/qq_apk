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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class wqa
  extends wrd<CommentEntry>
  implements IEventReceiver
{
  public int a;
  public Activity a;
  public TextView a;
  public CommentLikeFeedItem a;
  public InnerListView a;
  public List<CommentEntry> a;
  public wpm a;
  public wpu a;
  public wpw a;
  public wqe a;
  protected wqf a;
  private wql jdField_a_of_type_Wql;
  protected wse a;
  protected wst a;
  private ygg jdField_a_of_type_Ygg;
  private yhx jdField_a_of_type_Yhx;
  private boolean jdField_a_of_type_Boolean;
  public List<CommentEntry> b = new ArrayList();
  public List<StoryVideoItem> c;
  
  public wqa(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wse = ((wse)wth.a(17));
    this.jdField_a_of_type_Wst = ((wst)wth.a(15));
    this.jdField_a_of_type_Yhx = new yhx();
    this.jdField_a_of_type_Ygg = new ygg(paramActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, true);
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
    paramString = new wqm(a(paramInt1), paramString, paramInt2);
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      paramString.c = paramInt3;
    }
    wjj.a().dispatch(paramString);
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, boolean paramBoolean, int paramInt, wpz paramwpz)
  {
    b(paramCommentLikeFeedItem, paramCommentEntry, paramInt, paramwpz, true, paramBoolean);
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
      paramwpz = "1";
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
      yup.a("home_page", "send_comment", i, paramInt, new String[] { paramwpz, paramCommentEntry, wrc.a().a, paramCommentLikeFeedItem.feedId });
      return;
      paramInt = 1;
      break;
      i = yup.a(paramCommentLikeFeedItem);
      break label27;
      paramwpz = "2";
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
      if (begd.a.get(k, -1) < 0) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, wpz paramwpz, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    wpm.b(paramCommentEntry, new wqc(paramwpz, paramCommentEntry, (wse)wth.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public wre a()
  {
    this.jdField_a_of_type_Wpm = new wpm(this);
    return this.jdField_a_of_type_Wpm;
  }
  
  public wrf a()
  {
    this.jdField_a_of_type_Wpu = new wpu(this);
    return this.jdField_a_of_type_Wpu;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Wqf != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Wqf);
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
      QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131703294), 0).a();
      this.jdField_a_of_type_Wse.d(localCommentEntry);
      wqw.a().a();
      a(this.jdField_a_of_type_Int, 2, localCommentEntry.feedId, localCommentEntry.commentId);
      return;
    }
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703300), 0).a();
      yuk.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    localCommentEntry.status = 1;
    e();
    wpm.a(localCommentEntry, new wqd(this, paramInt, localCommentEntry));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364835));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOverScrollMode(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371345));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Wqf = new wqf(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Wqf);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    if (this.jdField_a_of_type_Wpu != null) {
      this.jdField_a_of_type_Wpu.a(paramCommentLikeFeedItem);
    }
    this.jdField_a_of_type_Ygg.a(paramCommentLikeFeedItem);
    this.c = paramList;
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (behh.a(paramString))
    {
      localCommentEntry.content = bcsa.a(paramString);
      label31:
      localCommentEntry.replyTime = System.currentTimeMillis();
      if (paramCommentEntry != null)
      {
        localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
        localCommentEntry.replierName = paramCommentEntry.authorName;
        localCommentEntry.replierRole = paramCommentEntry.authorRole;
      }
      localCommentEntry.authorUin = QQStoryContext.a().c();
      localCommentEntry.authorUnionId = QQStoryContext.a().b();
      localCommentEntry.status = 1;
      localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
      localCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
      if (((Integer)((wta)wth.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
        localCommentEntry.authorRole = 2;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment != 1) {
        break label247;
      }
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703293), 0).a();
      localCommentEntry.status = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      e();
      this.jdField_a_of_type_Wse.b(localCommentEntry);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedCommentLego", 2, "AddComment: " + localCommentEntry.toString());
      return;
      localCommentEntry.content = paramString;
      break label31;
      label247:
      wrc.a().a = "";
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, localCommentEntry, false, this.jdField_a_of_type_Int, new wqb(this));
    }
  }
  
  public void a(List<CommentEntry> paramList)
  {
    a(paramList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemClickListener(this.jdField_a_of_type_Wpu);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemLongClickListener(this.jdField_a_of_type_Wpu);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Wpu);
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
    if (this.jdField_a_of_type_Wqe == null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.a(2131561724, 2);
      this.jdField_a_of_type_Wqe = new wqe(this, 2131561724, this.jdField_a_of_type_JavaUtilList, true);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wqe);
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
  
  public void a(wpw paramwpw)
  {
    this.jdField_a_of_type_Wpw = paramwpw;
  }
  
  public void a(wql paramwql)
  {
    this.jdField_a_of_type_Wql = paramwql;
  }
  
  public void a(wrf paramwrf)
  {
    super.a(paramwrf);
    this.jdField_a_of_type_Wpu = ((wpu)paramwrf);
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    wqg localwqg = (wqg)a();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean) {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    }
    for (localCommentLikeFeedItem.mCommentCount += 1;; localCommentLikeFeedItem.mCommentCount -= 1)
    {
      localwqg.a(null);
      if (paramCommentEntry != null) {
        localwqg.a.a(paramCommentEntry);
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
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703287), 0).a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wqe = new wqe(this, 2131561724, this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wqe);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Wqe = new wqe(this, 2131561724, this.jdField_a_of_type_JavaUtilList, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_Wqe);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqa
 * JD-Core Version:    0.7.0.1
 */