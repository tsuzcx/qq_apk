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

public class upc
  extends upn<LikeEntry>
{
  private int jdField_a_of_type_Int;
  public Activity a;
  public TextView a;
  public CommentLikeFeedItem a;
  public List<LikeEntry> a;
  public urd a;
  private wer jdField_a_of_type_Wer;
  private wgi jdField_a_of_type_Wgi;
  public wkp a;
  public boolean a;
  
  public upc(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wer = new wer(paramActivity, paramCommentLikeFeedItem, paramInt, false);
    this.jdField_a_of_type_Wgi = new wgi();
  }
  
  public static upc a(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    paramContext = new upc(paramContext, paramActivity, paramView, paramCommentLikeFeedItem, paramInt);
    paramContext.jdField_a_of_type_Boolean = false;
    return paramContext;
  }
  
  public upo a()
  {
    return new uox(this, this.jdField_a_of_type_Boolean);
  }
  
  public upp a()
  {
    return new upd(this);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369421));
    this.jdField_a_of_type_Urd = ((urd)urr.a(15));
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Upp);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(List<LikeEntry> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isFriend();
    if (!bool)
    {
      if ((j == 0) && (k == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramList = weo.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wer);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      if (j == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
    label158:
    if (!bool) {
      if ((j == 0) && (k > 0)) {
        paramList.append(String.format("%s次赞", new Object[] { xod.a(k) }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_Wgi);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FeedLikeLego", 2, "id:" + paramList.toString() + " isFriend:" + bool + "  likeSize:" + j + "  likeCount" + k);
      return;
      if ((j < k) && (k > 0))
      {
        paramList.append(String.format("等%s人赞了", new Object[] { xod.a(k) }));
      }
      else
      {
        paramList.append("赞了");
        continue;
        paramList.append("赞了");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = QQStoryContext.a().b();
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
        ((LikeEntry)localObject).uin = QQStoryContext.a().c();
        ((LikeEntry)localObject).unionId = str;
        ((LikeEntry)localObject).feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
        ThreadManager.post(new FeedLikeLego.2(this, (usd)urr.a(2), str, (LikeEntry)localObject), 5, null, true);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = 0;
    ThreadManager.post(new FeedLikeLego.3(this, str), 5, null, true);
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upc
 * JD-Core Version:    0.7.0.1
 */