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

public class wgq
  extends zhi<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public wgq(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, yhc paramyhc)
  {
    if (paramCommentEntry == null) {
      ykq.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramyhc.a(2131364922);
        paramyhc = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = who.a().a(paramyhc);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
          ((TextView)localObject2).setOnTouchListener(wgm.a(this.jdField_a_of_type_Wgm));
          return;
        }
        localObject1 = xwj.a(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wgm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, wgm.a(this.jdField_a_of_type_Wgm));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Wgm.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
        ((TextView)localObject2).setOnTouchListener(wgm.a(this.jdField_a_of_type_Wgm));
        wke localwke = (wke)wjs.a(2);
        localObject2 = localwke.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localwke.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      who.a().a(paramyhc, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    who.a().a(paramyhc, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgq
 * JD-Core Version:    0.7.0.1
 */