import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class vrv
  extends ysp<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public vrv(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, xsh paramxsh)
  {
    if (paramCommentEntry == null) {
      xvv.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramxsh.a(2131364835);
        paramxsh = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = vst.a().a(paramxsh);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
          ((TextView)localObject2).setOnTouchListener(vrr.a(this.jdField_a_of_type_Vrr));
          return;
        }
        localObject1 = xho.a(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, vrr.a(this.jdField_a_of_type_Vrr));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Vrr.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
        ((TextView)localObject2).setOnTouchListener(vrr.a(this.jdField_a_of_type_Vrr));
        vvj localvvj = (vvj)vux.a(2);
        localObject2 = localvvj.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localvvj.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      vst.a().a(paramxsh, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    vst.a().a(paramxsh, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrv
 * JD-Core Version:    0.7.0.1
 */