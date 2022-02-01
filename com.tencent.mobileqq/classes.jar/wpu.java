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

public class wpu
  extends wrf
  implements View.OnClickListener, ztc, ztd
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private wpv a;
  protected wqa a;
  
  public wpu(wqa paramwqa)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Wqa = paramwqa;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Wqa.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Wpv = new wpv(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Wqa.jdField_a_of_type_Wpw != null) {
      this.jdField_a_of_type_Wqa.jdField_a_of_type_Wpw.a(this.jdField_a_of_type_Wqa, this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Wpv.jdField_a_of_type_Int, paramCommentEntry);
    }
    wqg localwqg = (wqg)this.jdField_a_of_type_Wqa.a();
    paramInt = yup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yup.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, yup.a(localwqg.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    blir localblir = blir.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localblir.c(anzj.a(2131703322));
        localblir.a(anzj.a(2131703290), 3);
      }
    }
    for (;;)
    {
      localblir.d(anzj.a(2131703295));
      localblir.a(new wpx(this, localblir, paramCommentEntry, paramInt));
      localblir.show();
      return;
      localblir.c(anzj.a(2131703310));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localblir.a(anzj.a(2131703320), 3);
        }
        localblir.c(anzj.a(2131703319));
        localblir.c(anzj.a(2131703317));
      }
      else
      {
        localblir.c(anzj.a(2131703291));
        localblir.c(anzj.a(2131703309));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      xlj.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      yup.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    xlj.b(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = blir.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((blir)localObject).c(anzj.a(2131703324));
      }
      for (;;)
      {
        ((blir)localObject).a(anzj.a(2131703327), 3);
        ((blir)localObject).d(anzj.a(2131703305));
        ((blir)localObject).a(new wpx(this, (blir)localObject, paramCommentEntry, paramInt));
        ((blir)localObject).show();
        return;
        ((blir)localObject).c(anzj.a(2131703311));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = yup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yup.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, yup.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wqa.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wpv.jdField_a_of_type_Int = paramInt;
    if (!bhnv.d(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703299), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Wqa.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Wpv.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Wpv.jdField_a_of_type_Int = paramInt;
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
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wqa.jdField_a_of_type_JavaUtilList.get(i);
      blir localblir = blir.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidAppActivity);
      localblir.c(anzj.a(2131703302));
      localblir.a(anzj.a(2131703288), 3);
      localblir.c(2131690580);
      localblir.a(new wpx(this, localblir, localCommentEntry, i));
      localblir.show();
      continue;
      this.jdField_a_of_type_Wqa.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpu
 * JD-Core Version:    0.7.0.1
 */