import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class uoo
  extends xrp<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public uoo(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, wph paramwph)
  {
    if (paramCommentEntry == null) {
      wsv.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramwph.a(2131364540);
        paramwph = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = upm.a().a(paramwph);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(baig.a);
          ((TextView)localObject2).setOnTouchListener(uok.a(this.jdField_a_of_type_Uok));
          return;
        }
        localObject1 = weo.a(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uok.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, uok.a(this.jdField_a_of_type_Uok));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Uok.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(baig.a);
        ((TextView)localObject2).setOnTouchListener(uok.a(this.jdField_a_of_type_Uok));
        usd localusd = (usd)urr.a(2);
        localObject2 = localusd.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localusd.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      upm.a().a(paramwph, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    upm.a().a(paramwph, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoo
 * JD-Core Version:    0.7.0.1
 */