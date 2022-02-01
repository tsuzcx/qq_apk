import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class pqx
  extends pqh
{
  ShareGroupItem a;
  boolean mIsOpen = false;
  boolean ni = false;
  
  public pqx(pqj parampqj, ShareGroupItem paramShareGroupItem)
  {
    super(parampqj);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    this.ni = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isOwner();
    this.mIsOpen = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic();
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      super.a(paramView, paramCommentEntry, paramInt);
    }
    paramView = QQStoryContext.a().getCurrentUid();
    ausj localausj = ausj.b(this.jdField_a_of_type_Pqj.mContext);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localausj.addButton(acfp.m(2131714390));
        localausj.addButton(acfp.m(2131714384), 3);
      }
    }
    for (;;)
    {
      localausj.addCancelButton(acfp.m(2131714366));
      localausj.a(new pqh.c(this, localausj, paramCommentEntry, paramInt));
      localausj.show();
      return;
      localausj.addButton(acfp.m(2131714367));
      break;
      if ((this.mIsOpen) && (this.ni))
      {
        localausj.addButton(acfp.m(2131714378));
        localausj.addButton(acfp.m(2131714387), 3);
        localausj.addButton(acfp.m(2131714394));
      }
      else
      {
        localausj.addButton(acfp.m(2131714377));
        localausj.addButton(acfp.m(2131714385));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqx
 * JD-Core Version:    0.7.0.1
 */