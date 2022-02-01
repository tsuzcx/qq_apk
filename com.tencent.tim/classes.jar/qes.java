import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

final class qes
  implements ausj.a
{
  qes(CommentEntry paramCommentEntry, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(this.e.authorUnionId);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new pxx().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), paramView, this.e.content);
      }
      break;
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      ram.w("Q.qqstory.player.PlayModeUtils", "report comment error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qes
 * JD-Core Version:    0.7.0.1
 */