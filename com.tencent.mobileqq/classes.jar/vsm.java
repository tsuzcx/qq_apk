import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class vsm
  extends vrl
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public vsm(vrr paramvrr, ShareGroupItem paramShareGroupItem)
  {
    super(paramvrr);
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
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_Vrr.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbjnw.c(amtj.a(2131713038));
        localbjnw.a(amtj.a(2131713032), 3);
      }
    }
    for (;;)
    {
      localbjnw.d(amtj.a(2131713014));
      localbjnw.a(new vro(this, localbjnw, paramCommentEntry, paramInt));
      localbjnw.show();
      return;
      localbjnw.c(amtj.a(2131713015));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbjnw.c(amtj.a(2131713026));
        localbjnw.a(amtj.a(2131713035), 3);
        localbjnw.c(amtj.a(2131713042));
      }
      else
      {
        localbjnw.c(amtj.a(2131713025));
        localbjnw.c(amtj.a(2131713033));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsm
 * JD-Core Version:    0.7.0.1
 */