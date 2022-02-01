import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class wqv
  extends wpu
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public wqv(wqa paramwqa, ShareGroupItem paramShareGroupItem)
  {
    super(paramwqa);
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
    blir localblir = blir.a(this.jdField_a_of_type_Wqa.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localblir.c(anzj.a(2131712806));
        localblir.a(anzj.a(2131712800), 3);
      }
    }
    for (;;)
    {
      localblir.d(anzj.a(2131712782));
      localblir.a(new wpx(this, localblir, paramCommentEntry, paramInt));
      localblir.show();
      return;
      localblir.c(anzj.a(2131712783));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localblir.c(anzj.a(2131712794));
        localblir.a(anzj.a(2131712803), 3);
        localblir.c(anzj.a(2131712810));
      }
      else
      {
        localblir.c(anzj.a(2131712793));
        localblir.c(anzj.a(2131712801));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqv
 * JD-Core Version:    0.7.0.1
 */