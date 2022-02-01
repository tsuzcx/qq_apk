import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;

public class wmc
  implements bkhw
{
  private final int jdField_a_of_type_Int;
  private final bkho jdField_a_of_type_Bkho;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public wmc(wlz paramwlz, bkho parambkho, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Bkho = parambkho;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bkho.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (anni.a(2131703218).equals(paramView))
    {
      this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Wlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Wlz.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        yqu.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Wlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bkho.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (anni.a(2131703207).equals(paramView))
        {
          this.jdField_a_of_type_Wlz.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (anni.a(2131703199).equals(paramView))
        {
          xfe.a(this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          yqu.a("play_video", "report_reply", yqu.a(this.jdField_a_of_type_Wlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", yqu.a(this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.jdField_a_of_type_Int), "", this.jdField_a_of_type_Wlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!anni.a(2131703222).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          wnh.a().jdField_a_of_type_JavaLangString = "";
          wmf.a(this.jdField_a_of_type_Wlz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.jdField_a_of_type_Int, new wmd(this));
        }
      }
    } while (!anni.a(2131703194).equals(paramView));
    label407:
    label487:
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        if (!bdol.a(paramView)) {
          break label487;
        }
        paramView = bbzj.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Wlz.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
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
 * Qualified Name:     wmc
 * JD-Core Version:    0.7.0.1
 */