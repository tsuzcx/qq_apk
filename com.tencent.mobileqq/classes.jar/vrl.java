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

public class vrl
  extends vsw
  implements View.OnClickListener, ysn, yso
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private vrm a;
  protected vrr a;
  
  public vrl(vrr paramvrr)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Vrr = paramvrr;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Vrr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Vrm = new vrm(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Vrr.jdField_a_of_type_Vrn != null) {
      this.jdField_a_of_type_Vrr.jdField_a_of_type_Vrn.a(this.jdField_a_of_type_Vrr, this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Vrm.jdField_a_of_type_Int, paramCommentEntry);
    }
    vrx localvrx = (vrx)this.jdField_a_of_type_Vrr.a();
    paramInt = xwa.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      xwa.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, xwa.a(localvrx.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbjnw.c(amtj.a(2131703552));
        localbjnw.a(amtj.a(2131703520), 3);
      }
    }
    for (;;)
    {
      localbjnw.d(amtj.a(2131703525));
      localbjnw.a(new vro(this, localbjnw, paramCommentEntry, paramInt));
      localbjnw.show();
      return;
      localbjnw.c(amtj.a(2131703540));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbjnw.a(amtj.a(2131703550), 3);
        }
        localbjnw.c(amtj.a(2131703549));
        localbjnw.c(amtj.a(2131703547));
      }
      else
      {
        localbjnw.c(amtj.a(2131703521));
        localbjnw.c(amtj.a(2131703539));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      wmu.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      xwa.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    wmu.b(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bjnw.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bjnw)localObject).c(amtj.a(2131703554));
      }
      for (;;)
      {
        ((bjnw)localObject).a(amtj.a(2131703557), 3);
        ((bjnw)localObject).d(amtj.a(2131703535));
        ((bjnw)localObject).a(new vro(this, (bjnw)localObject, paramCommentEntry, paramInt));
        ((bjnw)localObject).show();
        return;
        ((bjnw)localObject).c(amtj.a(2131703541));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = xwa.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      xwa.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, xwa.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Vrr.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Vrm.jdField_a_of_type_Int = paramInt;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131703529), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Vrr.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Vrm.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Vrm.jdField_a_of_type_Int = paramInt;
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
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Vrr.jdField_a_of_type_JavaUtilList.get(i);
      bjnw localbjnw = bjnw.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidAppActivity);
      localbjnw.c(amtj.a(2131703532));
      localbjnw.a(amtj.a(2131703518), 3);
      localbjnw.c(2131690620);
      localbjnw.a(new vro(this, localbjnw, localCommentEntry, i));
      localbjnw.show();
      continue;
      this.jdField_a_of_type_Vrr.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrl
 * JD-Core Version:    0.7.0.1
 */