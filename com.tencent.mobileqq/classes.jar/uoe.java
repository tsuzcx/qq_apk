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

public class uoe
  extends upp
  implements View.OnClickListener, xrn, xro
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private uof a;
  protected uok a;
  
  public uoe(uok paramuok)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Uok = paramuok;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Uok.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Uof = new uof(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Uok.jdField_a_of_type_Uog != null) {
      this.jdField_a_of_type_Uok.jdField_a_of_type_Uog.a(this.jdField_a_of_type_Uok, this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Uof.jdField_a_of_type_Int, paramCommentEntry);
    }
    uoq localuoq = (uoq)this.jdField_a_of_type_Uok.a();
    paramInt = wta.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wta.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, wta.a(localuoq.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbhpy.c(alpo.a(2131704806));
        localbhpy.a(alpo.a(2131704774), 3);
      }
    }
    for (;;)
    {
      localbhpy.d(alpo.a(2131704779));
      localbhpy.a(new uoh(this, localbhpy, paramCommentEntry, paramInt));
      localbhpy.show();
      return;
      localbhpy.c(alpo.a(2131704794));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbhpy.a(alpo.a(2131704804), 3);
        }
        localbhpy.c(alpo.a(2131704803));
        localbhpy.c(alpo.a(2131704801));
      }
      else
      {
        localbhpy.c(alpo.a(2131704775));
        localbhpy.c(alpo.a(2131704793));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      vju.a(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      wta.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    vju.b(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bhpy.a(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bhpy)localObject).c(alpo.a(2131704808));
      }
      for (;;)
      {
        ((bhpy)localObject).a(alpo.a(2131704811), 3);
        ((bhpy)localObject).d(alpo.a(2131704789));
        ((bhpy)localObject).a(new uoh(this, (bhpy)localObject, paramCommentEntry, paramInt));
        ((bhpy)localObject).show();
        return;
        ((bhpy)localObject).c(alpo.a(2131704795));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = wta.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wta.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, wta.a(this.jdField_a_of_type_Uok.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Uok.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uof.jdField_a_of_type_Int = paramInt;
    if (!bdee.d(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704783), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Uok.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Uof.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Uof.jdField_a_of_type_Int = paramInt;
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
      paramView = (CommentEntry)this.jdField_a_of_type_Uok.jdField_a_of_type_JavaUtilList.get(i);
      bhpy localbhpy = bhpy.a(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidAppActivity);
      localbhpy.c(alpo.a(2131704786));
      localbhpy.a(alpo.a(2131704772), 3);
      localbhpy.c(2131690648);
      localbhpy.a(new uoh(this, localbhpy, paramView, i));
      localbhpy.show();
      return;
      this.jdField_a_of_type_Uok.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoe
 * JD-Core Version:    0.7.0.1
 */