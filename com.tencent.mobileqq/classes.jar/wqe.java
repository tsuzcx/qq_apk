import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class wqe
  extends zte<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public wqe(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, yqw paramyqw)
  {
    if (paramCommentEntry == null) {
      yuk.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramyqw.a(2131364805);
        paramyqw = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = wrc.a().a(paramyqw);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(begp.a);
          ((TextView)localObject2).setOnTouchListener(wqa.a(this.jdField_a_of_type_Wqa));
          return;
        }
        localObject1 = ygd.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wqa.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, wqa.a(this.jdField_a_of_type_Wqa));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Wqa.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(begp.a);
        ((TextView)localObject2).setOnTouchListener(wqa.a(this.jdField_a_of_type_Wqa));
        wtt localwtt = (wtt)wth.a(2);
        localObject2 = localwtt.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localwtt.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      wrc.a().a(paramyqw, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    wrc.a().a(paramyqw, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */