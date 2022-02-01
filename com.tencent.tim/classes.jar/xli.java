import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xli
  implements View.OnClickListener
{
  long iu = 0L;
  
  xli(xlh paramxlh) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu < 50L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.iu = l;
      MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((BaseBubbleBuilder.e)wja.a(paramView)).mMessage;
      if (rnw.fy(localMessageForQQStoryComment.vid))
      {
        qgg.b(this.a.mContext, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id", 1004);
        rar.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      }
      else
      {
        qgg.c((Activity)this.a.mContext, localMessageForQQStoryComment.vid, "CommentItemBuilder_Feed_Id_NOT_GS", 7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xli
 * JD-Core Version:    0.7.0.1
 */