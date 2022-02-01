import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.FriendListOpenFrame.b;

public class arqv
  extends Handler
{
  public arqv(FriendListOpenFrame paramFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      this.a.gW.setPadding(0, 0, 40, 0);
      return;
      this.a.gW.setPadding(0, 0, 0, 0);
      return;
      String str = paramMessage.getData().getString("url");
      paramMessage = (Bitmap)paramMessage.obj;
      int j = this.a.g.getChildCount();
      int i = 0;
      while (i < j)
      {
        FriendListOpenFrame.b localb = (FriendListOpenFrame.b)this.a.g.getChildAt(i).getTag();
        if ((localb != null) && (str.equals(localb.avatar)))
        {
          localb.pQ.setImageBitmap(paramMessage);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqv
 * JD-Core Version:    0.7.0.1
 */