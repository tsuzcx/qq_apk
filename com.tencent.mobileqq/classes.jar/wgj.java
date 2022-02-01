import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class wgj
  implements bkzq
{
  private final int jdField_a_of_type_Int;
  private final bkzi jdField_a_of_type_Bkzi;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public wgj(wgg paramwgg, bkzi parambkzi, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Bkzi = parambkzi;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (anvx.a(2131703906).equals(paramView))
    {
      this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Wgg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Wgg.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        ykv.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Wgg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bkzi.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (anvx.a(2131703895).equals(paramView))
        {
          this.jdField_a_of_type_Wgg.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (anvx.a(2131703887).equals(paramView))
        {
          wzk.a(this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          ykv.a("play_video", "report_reply", ykv.a(this.jdField_a_of_type_Wgg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", ykv.a(this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.jdField_a_of_type_Int), "", this.jdField_a_of_type_Wgg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!anvx.a(2131703910).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          who.a().jdField_a_of_type_JavaLangString = "";
          wgm.a(this.jdField_a_of_type_Wgg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.jdField_a_of_type_Int, new wgk(this));
        }
      }
    } while (!anvx.a(2131703882).equals(paramView));
    label407:
    label487:
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        if (!TextUtils.hasSysEmotion(paramView)) {
          break label487;
        }
        paramView = bcsc.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Wgg.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
      }
      catch (Exception paramView) {}
      if (!QLog.isColorLevel()) {
        break label171;
      }
      QLog.e("FeedCommentEventHandler", 2, paramView.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgj
 * JD-Core Version:    0.7.0.1
 */