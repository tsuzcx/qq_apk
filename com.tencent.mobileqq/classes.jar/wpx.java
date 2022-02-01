import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;

public class wpx
  implements bliz
{
  private final int jdField_a_of_type_Int;
  private final blir jdField_a_of_type_Blir;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public wpx(wpu paramwpu, blir paramblir, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Blir = paramblir;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Blir.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (anzj.a(2131703325).equals(paramView))
    {
      this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Wpu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Wpu.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        yup.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Wpu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (anzj.a(2131703314).equals(paramView))
        {
          this.jdField_a_of_type_Wpu.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (anzj.a(2131703306).equals(paramView))
        {
          xiz.a(this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          yup.a("play_video", "report_reply", yup.a(this.jdField_a_of_type_Wpu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", yup.a(this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.jdField_a_of_type_Int), "", this.jdField_a_of_type_Wpu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!anzj.a(2131703329).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          wrc.a().jdField_a_of_type_JavaLangString = "";
          wqa.a(this.jdField_a_of_type_Wpu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.jdField_a_of_type_Int, new wpy(this));
        }
      }
    } while (!anzj.a(2131703301).equals(paramView));
    label407:
    label487:
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        if (!behh.a(paramView)) {
          break label487;
        }
        paramView = bcsa.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Wpu.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
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
 * Qualified Name:     wpx
 * JD-Core Version:    0.7.0.1
 */