import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class wmj
  extends zpj<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public wmj(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, ynb paramynb)
  {
    if (paramCommentEntry == null) {
      yqp.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramynb.a(2131364758);
        paramynb = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = wnh.a().a(paramynb);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(bdnt.a);
          ((TextView)localObject2).setOnTouchListener(wmf.a(this.jdField_a_of_type_Wmf));
          return;
        }
        localObject1 = yci.a(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wmf.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, wmf.a(this.jdField_a_of_type_Wmf));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Wmf.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(bdnt.a);
        ((TextView)localObject2).setOnTouchListener(wmf.a(this.jdField_a_of_type_Wmf));
        wpy localwpy = (wpy)wpm.a(2);
        localObject2 = localwpy.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localwpy.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      wnh.a().a(paramynb, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    wnh.a().a(paramynb, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmj
 * JD-Core Version:    0.7.0.1
 */