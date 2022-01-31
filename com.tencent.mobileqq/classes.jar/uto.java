import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class uto
  extends usn
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public uto(ust paramust, ShareGroupItem paramShareGroupItem)
  {
    super(paramust);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isOwner();
    this.b = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic();
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      super.a(paramView, paramCommentEntry, paramInt);
    }
    paramView = QQStoryContext.a().b();
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_Ust.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbhuf.c(alud.a(2131714327));
        localbhuf.a(alud.a(2131714321), 3);
      }
    }
    for (;;)
    {
      localbhuf.d(alud.a(2131714303));
      localbhuf.a(new usq(this, localbhuf, paramCommentEntry, paramInt));
      localbhuf.show();
      return;
      localbhuf.c(alud.a(2131714304));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbhuf.c(alud.a(2131714315));
        localbhuf.a(alud.a(2131714324), 3);
        localbhuf.c(alud.a(2131714331));
      }
      else
      {
        localbhuf.c(alud.a(2131714314));
        localbhuf.c(alud.a(2131714322));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uto
 * JD-Core Version:    0.7.0.1
 */