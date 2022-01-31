import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class upf
  extends uoe
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public upf(uok paramuok, ShareGroupItem paramShareGroupItem)
  {
    super(paramuok);
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
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_Uok.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbhpy.c(alpo.a(2131714315));
        localbhpy.a(alpo.a(2131714309), 3);
      }
    }
    for (;;)
    {
      localbhpy.d(alpo.a(2131714291));
      localbhpy.a(new uoh(this, localbhpy, paramCommentEntry, paramInt));
      localbhpy.show();
      return;
      localbhpy.c(alpo.a(2131714292));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbhpy.c(alpo.a(2131714303));
        localbhpy.a(alpo.a(2131714312), 3);
        localbhpy.c(alpo.a(2131714319));
      }
      else
      {
        localbhpy.c(alpo.a(2131714302));
        localbhpy.c(alpo.a(2131714310));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */