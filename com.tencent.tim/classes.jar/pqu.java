import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.FeedLikeLego.2;
import com.tencent.biz.qqstory.comment.FeedLikeLego.3;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pqu
  extends prf<LikeEntry>
{
  public CommentLikeFeedItem a;
  public psm a;
  public qvf a;
  public boolean aBj;
  private qrx.b jdField_b_of_type_Qrx$b;
  private qss.b jdField_b_of_type_Qss$b;
  private int mFeedType;
  public List<LikeEntry> mx = new ArrayList();
  public TextView wZ;
  public Activity y;
  
  public pqu(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.mFeedType = paramInt;
    this.y = paramActivity;
    this.jdField_b_of_type_Qrx$b = new qrx.b(paramActivity, paramCommentLikeFeedItem, paramInt, false);
    this.jdField_b_of_type_Qss$b = new qss.b();
  }
  
  public static pqu a(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    paramContext = new pqu(paramContext, paramActivity, paramView, paramCommentLikeFeedItem, paramInt);
    paramContext.aBj = false;
    return paramContext;
  }
  
  public prg a()
  {
    return new pqt(this, this.aBj);
  }
  
  public prh a()
  {
    return new pqv(this);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void dX(List<LikeEntry> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mx = paramList;
    int j = this.mx.size();
    int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isFriend();
    if (!bool)
    {
      if ((j == 0) && (k == 0))
      {
        this.wZ.setVisibility(8);
        return;
      }
      this.wZ.setVisibility(0);
      paramList = qrx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.mx, this.jdField_b_of_type_Qrx$b);
      if ((bool) || (j != 0) || (k <= 0)) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if ((paramList.length() != 0) || (i != 0)) {
        break label158;
      }
      this.wZ.setVisibility(8);
      return;
      if (j == 0)
      {
        this.wZ.setVisibility(8);
        return;
      }
      this.wZ.setVisibility(0);
      break;
    }
    label158:
    if (!bool) {
      if ((j == 0) && (k > 0)) {
        paramList.append(String.format("%s次赞", new Object[] { rpq.aL(k) }));
      }
    }
    for (;;)
    {
      this.wZ.setVisibility(0);
      this.wZ.setText(paramList);
      this.wZ.setOnTouchListener(this.jdField_b_of_type_Qss$b);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedLikeLego", 2, "id:" + paramList.toString() + " isFriend:" + bool + "  likeSize:" + j + "  likeCount" + k);
      return;
      if ((j < k) && (k > 0))
      {
        paramList.append(String.format("等%s人赞了", new Object[] { rpq.aL(k) }));
      }
      else
      {
        paramList.append("赞了");
        continue;
        paramList.append("赞了");
      }
    }
  }
  
  public void g(Context paramContext, View paramView)
  {
    this.wZ = ((TextView)paramView.findViewById(2131370446));
    this.jdField_a_of_type_Psm = ((psm)psx.a(15));
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
    this.wZ.setOnClickListener(this.jdField_a_of_type_Prh);
  }
  
  public void sc(boolean paramBoolean)
  {
    String str = QQStoryContext.a().getCurrentUid();
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = 1;
      Object localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount != -1) {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      }
      for (((CommentLikeFeedItem)localObject).mLikeCount += 1;; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = 1)
      {
        localObject = new LikeEntry();
        ((LikeEntry)localObject).likeTime = System.currentTimeMillis();
        ((LikeEntry)localObject).uin = QQStoryContext.a().getCurrentUin();
        ((LikeEntry)localObject).unionId = str;
        ((LikeEntry)localObject).feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
        ThreadManager.post(new FeedLikeLego.2(this, (ptf)psx.a(2), str, (LikeEntry)localObject), 5, null, true);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = 0;
    ThreadManager.post(new FeedLikeLego.3(this, str), 5, null, true);
  }
  
  public void showError() {}
  
  public void showLoading() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqu
 * JD-Core Version:    0.7.0.1
 */