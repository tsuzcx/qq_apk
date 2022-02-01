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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

public class wgg
  extends whr
  implements View.OnClickListener, zhg, zhh
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private wgh a;
  protected wgm a;
  
  public wgg(wgm paramwgm)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Wgm = paramwgm;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Wgm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Wgh = new wgh(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Wgm.jdField_a_of_type_Wgi != null) {
      this.jdField_a_of_type_Wgm.jdField_a_of_type_Wgi.a(this.jdField_a_of_type_Wgm, this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Wgh.jdField_a_of_type_Int, paramCommentEntry);
    }
    wgs localwgs = (wgs)this.jdField_a_of_type_Wgm.a();
    paramInt = ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      ykv.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, ykv.a(localwgs.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbkzi.c(anvx.a(2131703903));
        localbkzi.a(anvx.a(2131703871), 3);
      }
    }
    for (;;)
    {
      localbkzi.d(anvx.a(2131703876));
      localbkzi.a(new wgj(this, localbkzi, paramCommentEntry, paramInt));
      localbkzi.show();
      return;
      localbkzi.c(anvx.a(2131703891));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbkzi.a(anvx.a(2131703901), 3);
        }
        localbkzi.c(anvx.a(2131703900));
        localbkzi.c(anvx.a(2131703898));
      }
      else
      {
        localbkzi.c(anvx.a(2131703872));
        localbkzi.c(anvx.a(2131703890));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      xbp.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      ykv.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    xbp.b(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bkzi.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bkzi)localObject).c(anvx.a(2131703905));
      }
      for (;;)
      {
        ((bkzi)localObject).a(anvx.a(2131703908), 3);
        ((bkzi)localObject).d(anvx.a(2131703886));
        ((bkzi)localObject).a(new wgj(this, (bkzi)localObject, paramCommentEntry, paramInt));
        ((bkzi)localObject).show();
        return;
        ((bkzi)localObject).c(anvx.a(2131703892));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      ykv.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, ykv.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wgm.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wgh.jdField_a_of_type_Int = paramInt;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131703880), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Wgm.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wgh.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wgh.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wgm.jdField_a_of_type_JavaUtilList.get(i);
      bkzi localbkzi = bkzi.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidAppActivity);
      localbkzi.c(anvx.a(2131703883));
      localbkzi.a(anvx.a(2131703869), 3);
      localbkzi.c(2131690697);
      localbkzi.a(new wgj(this, localbkzi, localCommentEntry, i));
      localbkzi.show();
      continue;
      this.jdField_a_of_type_Wgm.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgg
 * JD-Core Version:    0.7.0.1
 */