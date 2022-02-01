import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.QZoneMsgFragment;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;

public class avtl
  extends BroadcastReceiver
{
  public avtl(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j;
    int k;
    boolean bool;
    int i;
    if (paramIntent.getAction() == "com.qzone.sync_comment_like")
    {
      j = paramIntent.getIntExtra("sync_comment_commentnum", 0);
      paramContext = paramIntent.getStringExtra("sync_comment_likekey");
      k = paramIntent.getIntExtra("sync_comment_likenum", 0);
      bool = paramIntent.getBooleanExtra("sync_comment_haslike", false);
      if ((this.this$0.a != null) && (!TextUtils.isEmpty(paramContext))) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.this$0.a.getCount())
      {
        paramIntent = (MQMsg)this.this$0.a.getItem(i);
        if ((paramIntent.msgInteractData != null) && (paramIntent.msgInteractData.likeCell != null) && (paramIntent.msgInteractData.likeCell.likeKey.equals(paramContext)))
        {
          paramIntent.msgInteractData.likeCell.totalLike = k;
          paramIntent.msgInteractData.totalComment = j;
          paramIntent.msgInteractData.likeCell.liked = bool;
          ((avto)this.this$0.app.getManager(293)).c(paramIntent);
        }
      }
      else
      {
        this.this$0.a.notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtl
 * JD-Core Version:    0.7.0.1
 */