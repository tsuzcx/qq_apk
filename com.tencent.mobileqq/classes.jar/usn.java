import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class usn
  extends uty
  implements View.OnClickListener, xvw, xvx
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private uso a;
  protected ust a;
  
  public usn(ust paramust)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Ust = paramust;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Uso = new uso(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_Usp != null) {
      this.jdField_a_of_type_Ust.jdField_a_of_type_Usp.a(this.jdField_a_of_type_Ust, this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Uso.jdField_a_of_type_Int, paramCommentEntry);
    }
    usz localusz = (usz)this.jdField_a_of_type_Ust.a();
    paramInt = wxj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wxj.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, wxj.a(localusz.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbhuf.c(alud.a(2131704818));
        localbhuf.a(alud.a(2131704786), 3);
      }
    }
    for (;;)
    {
      localbhuf.d(alud.a(2131704791));
      localbhuf.a(new usq(this, localbhuf, paramCommentEntry, paramInt));
      localbhuf.show();
      return;
      localbhuf.c(alud.a(2131704806));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbhuf.a(alud.a(2131704816), 3);
        }
        localbhuf.c(alud.a(2131704815));
        localbhuf.c(alud.a(2131704813));
      }
      else
      {
        localbhuf.c(alud.a(2131704787));
        localbhuf.c(alud.a(2131704805));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      vod.a(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      wxj.a("play_video", "multishoot_icon", 0, 0, new String[0]);
    }
    Object localObject;
    do
    {
      return;
      if (paramCommentEntry.commentType != 4) {
        break;
      }
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramCommentEntry)));
    vod.b(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bhuf.a(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bhuf)localObject).c(alud.a(2131704820));
      }
      for (;;)
      {
        ((bhuf)localObject).a(alud.a(2131704823), 3);
        ((bhuf)localObject).d(alud.a(2131704801));
        ((bhuf)localObject).a(new usq(this, (bhuf)localObject, paramCommentEntry, paramInt));
        ((bhuf)localObject).show();
        return;
        ((bhuf)localObject).c(alud.a(2131704807));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = wxj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wxj.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, wxj.a(this.jdField_a_of_type_Ust.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ust.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uso.jdField_a_of_type_Int = paramInt;
    if (!bdin.d(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131704795), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Ust.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Uso.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uso.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = (CommentEntry)this.jdField_a_of_type_Ust.jdField_a_of_type_JavaUtilList.get(i);
      bhuf localbhuf = bhuf.a(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidAppActivity);
      localbhuf.c(alud.a(2131704798));
      localbhuf.a(alud.a(2131704784), 3);
      localbhuf.c(2131690648);
      localbhuf.a(new usq(this, localbhuf, paramView, i));
      localbhuf.show();
      return;
      this.jdField_a_of_type_Ust.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usn
 * JD-Core Version:    0.7.0.1
 */