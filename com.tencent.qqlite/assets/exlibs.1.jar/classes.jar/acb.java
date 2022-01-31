import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;

public class acb
  implements View.OnClickListener
{
  public acb(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    String str = AppConstants.as + this.a.c + "/" + "custom_background/";
    str = str + System.currentTimeMillis() + ".jpg";
    Rect localRect = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    PhotoUtils.a(paramView, this.a, ChatBackgroundSettingActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acb
 * JD-Core Version:    0.7.0.1
 */