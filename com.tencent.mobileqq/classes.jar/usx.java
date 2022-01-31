import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class usx
  extends xvy<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public usx(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, wtq paramwtq)
  {
    if (paramCommentEntry == null) {
      wxe.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramwtq.a(2131364542);
        paramwtq = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = utv.a().a(paramwtq);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(bamp.a);
          ((TextView)localObject2).setOnTouchListener(ust.a(this.jdField_a_of_type_Ust));
          return;
        }
        localObject1 = wix.a(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, ust.a(this.jdField_a_of_type_Ust));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Ust.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(bamp.a);
        ((TextView)localObject2).setOnTouchListener(ust.a(this.jdField_a_of_type_Ust));
        uwm localuwm = (uwm)uwa.a(2);
        localObject2 = localuwm.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localuwm.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      utv.a().a(paramwtq, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    utv.a().a(paramwtq, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usx
 * JD-Core Version:    0.7.0.1
 */