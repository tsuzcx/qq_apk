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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

public class wlz
  extends wnk
  implements View.OnClickListener, zph, zpi
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private wma a;
  protected wmf a;
  
  public wlz(wmf paramwmf)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Wmf = paramwmf;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Wmf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Wma = new wma(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Wmf.jdField_a_of_type_Wmb != null) {
      this.jdField_a_of_type_Wmf.jdField_a_of_type_Wmb.a(this.jdField_a_of_type_Wmf, this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Wma.jdField_a_of_type_Int, paramCommentEntry);
    }
    wml localwml = (wml)this.jdField_a_of_type_Wmf.a();
    paramInt = yqu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yqu.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, yqu.a(localwml.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bkho localbkho = bkho.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbkho.c(anni.a(2131703215));
        localbkho.a(anni.a(2131703183), 3);
      }
    }
    for (;;)
    {
      localbkho.d(anni.a(2131703188));
      localbkho.a(new wmc(this, localbkho, paramCommentEntry, paramInt));
      localbkho.show();
      return;
      localbkho.c(anni.a(2131703203));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbkho.a(anni.a(2131703213), 3);
        }
        localbkho.c(anni.a(2131703212));
        localbkho.c(anni.a(2131703210));
      }
      else
      {
        localbkho.c(anni.a(2131703184));
        localbkho.c(anni.a(2131703202));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      xho.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      yqu.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    xho.b(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bkho.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bkho)localObject).c(anni.a(2131703217));
      }
      for (;;)
      {
        ((bkho)localObject).a(anni.a(2131703220), 3);
        ((bkho)localObject).d(anni.a(2131703198));
        ((bkho)localObject).a(new wmc(this, (bkho)localObject, paramCommentEntry, paramInt));
        ((bkho)localObject).show();
        return;
        ((bkho)localObject).c(anni.a(2131703204));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = yqu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yqu.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, yqu.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wmf.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wma.jdField_a_of_type_Int = paramInt;
    if (!bgnt.d(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anni.a(2131703192), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Wmf.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wma.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wma.jdField_a_of_type_Int = paramInt;
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
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wmf.jdField_a_of_type_JavaUtilList.get(i);
      bkho localbkho = bkho.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidAppActivity);
      localbkho.c(anni.a(2131703195));
      localbkho.a(anni.a(2131703181), 3);
      localbkho.c(2131690582);
      localbkho.a(new wmc(this, localbkho, localCommentEntry, i));
      localbkho.show();
      continue;
      this.jdField_a_of_type_Wmf.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlz
 * JD-Core Version:    0.7.0.1
 */