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

public class vro
  implements bjoe
{
  private final int jdField_a_of_type_Int;
  private final bjnw jdField_a_of_type_Bjnw;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public vro(vrl paramvrl, bjnw parambjnw, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Bjnw = parambjnw;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bjnw.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (amtj.a(2131703555).equals(paramView))
    {
      this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Vrl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Vrl.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        xwa.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Vrl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bjnw.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (amtj.a(2131703544).equals(paramView))
        {
          this.jdField_a_of_type_Vrl.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (amtj.a(2131703536).equals(paramView))
        {
          wkp.a(this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          xwa.a("play_video", "report_reply", xwa.a(this.jdField_a_of_type_Vrl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", xwa.a(this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.jdField_a_of_type_Int), "", this.jdField_a_of_type_Vrl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!amtj.a(2131703559).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          vst.a().jdField_a_of_type_JavaLangString = "";
          vrr.a(this.jdField_a_of_type_Vrl.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.jdField_a_of_type_Int, new vrp(this));
        }
      }
    } while (!amtj.a(2131703531).equals(paramView));
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
        paramView = bblk.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Vrl.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
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
 * Qualified Name:     vro
 * JD-Core Version:    0.7.0.1
 */