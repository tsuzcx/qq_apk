import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.net.MalformedURLException;

public class uej
  extends Handler
{
  public uej(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if ((this.this$0.isFinishing()) || (AddFriendVerifyActivity.a(this.this$0) == null)) {
        continue;
      }
      AddFriendVerifyActivity.a(this.this$0).setVisibility(0);
      ((Animatable)AddFriendVerifyActivity.a(this.this$0).getDrawable()).start();
      return;
      if (this.this$0.isFinishing()) {
        continue;
      }
      if (!TextUtils.isEmpty(AddFriendVerifyActivity.c(this.this$0))) {}
      try
      {
        paramMessage = new File(AddFriendVerifyActivity.d(this.this$0)).toURL();
        AddFriendVerifyActivity.a(this.this$0).setImageDrawable(URLDrawable.getDrawable(paramMessage, 100, 100));
        label142:
        if (AddFriendVerifyActivity.a(this.this$0) == null) {
          continue;
        }
        AddFriendVerifyActivity.a(this.this$0).setVisibility(8);
        return;
        QQToast.a(this.this$0.getApplicationContext(), 1, 2131721599, 0).show(this.this$0.getTitleBarHeight());
        return;
      }
      catch (MalformedURLException paramMessage)
      {
        break label142;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uej
 * JD-Core Version:    0.7.0.1
 */