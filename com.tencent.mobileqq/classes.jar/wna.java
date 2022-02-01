import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class wna
  extends wlz
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public wna(wmf paramwmf, ShareGroupItem paramShareGroupItem)
  {
    super(paramwmf);
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
    bkho localbkho = bkho.a(this.jdField_a_of_type_Wmf.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbkho.c(anni.a(2131712697));
        localbkho.a(anni.a(2131712691), 3);
      }
    }
    for (;;)
    {
      localbkho.d(anni.a(2131712673));
      localbkho.a(new wmc(this, localbkho, paramCommentEntry, paramInt));
      localbkho.show();
      return;
      localbkho.c(anni.a(2131712674));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbkho.c(anni.a(2131712685));
        localbkho.a(anni.a(2131712694), 3);
        localbkho.c(anni.a(2131712701));
      }
      else
      {
        localbkho.c(anni.a(2131712684));
        localbkho.c(anni.a(2131712692));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wna
 * JD-Core Version:    0.7.0.1
 */