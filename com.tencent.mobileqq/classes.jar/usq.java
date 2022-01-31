import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;

public class usq
  implements bhuk
{
  private final int jdField_a_of_type_Int;
  private final bhuf jdField_a_of_type_Bhuf;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public usq(usn paramusn, bhuf parambhuf, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Bhuf = parambhuf;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (alud.a(2131704821).equals(paramView))
    {
      this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Usn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Usn.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        wxj.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Usn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bhuf.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (alud.a(2131704810).equals(paramView))
        {
          this.jdField_a_of_type_Usn.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (alud.a(2131704802).equals(paramView))
        {
          vls.a(this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          wxj.a("play_video", "report_reply", wxj.a(this.jdField_a_of_type_Usn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", wxj.a(this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.jdField_a_of_type_Int), "", this.jdField_a_of_type_Usn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!alud.a(2131704825).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          utv.a().jdField_a_of_type_JavaLangString = "";
          ust.a(this.jdField_a_of_type_Usn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.jdField_a_of_type_Int, new usr(this));
        }
      }
    } while (!alud.a(2131704797).equals(paramView));
    label407:
    label487:
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        if (!banh.a(paramView)) {
          break label487;
        }
        paramView = azah.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Usn.jdField_a_of_type_Ust.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usq
 * JD-Core Version:    0.7.0.1
 */