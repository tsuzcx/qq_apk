import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

final class wzq
  implements bkzq
{
  wzq(CommentEntry paramCommentEntry, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new wro().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), paramView, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      ykq.d("Q.qqstory.player.PlayModeUtils", "report comment error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzq
 * JD-Core Version:    0.7.0.1
 */