import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class whh
  extends wgg
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public whh(wgm paramwgm, ShareGroupItem paramShareGroupItem)
  {
    super(paramwgm);
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
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_Wgm.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbkzi.c(anvx.a(2131713385));
        localbkzi.a(anvx.a(2131713379), 3);
      }
    }
    for (;;)
    {
      localbkzi.d(anvx.a(2131713361));
      localbkzi.a(new wgj(this, localbkzi, paramCommentEntry, paramInt));
      localbkzi.show();
      return;
      localbkzi.c(anvx.a(2131713362));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbkzi.c(anvx.a(2131713373));
        localbkzi.a(anvx.a(2131713382), 3);
        localbkzi.c(anvx.a(2131713389));
      }
      else
      {
        localbkzi.c(anvx.a(2131713372));
        localbkzi.c(anvx.a(2131713380));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whh
 * JD-Core Version:    0.7.0.1
 */