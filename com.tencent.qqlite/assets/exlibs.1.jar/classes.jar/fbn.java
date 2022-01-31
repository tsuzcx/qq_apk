import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.FriendListOpenFrame.ViewHolder;

public class fbn
  extends Handler
{
  public fbn(FriendListOpenFrame paramFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      String str = paramMessage.getData().getString("url");
      paramMessage = (Bitmap)paramMessage.obj;
      int j = this.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        FriendListOpenFrame.ViewHolder localViewHolder = (FriendListOpenFrame.ViewHolder)this.a.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (str.equals(localViewHolder.b)))
        {
          localViewHolder.c.setImageBitmap(paramMessage);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbn
 * JD-Core Version:    0.7.0.1
 */