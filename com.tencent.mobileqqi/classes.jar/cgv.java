import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;

public class cgv
  implements View.OnClickListener
{
  public cgv(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    String str = AppConstants.an + ChatBackgroundSettingActivity.a(this.a) + "/" + "custom_background/";
    str = str + System.currentTimeMillis() + ".jpg";
    Rect localRect = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    PhotoUtils.a(paramView, this.a, ChatBackgroundSettingActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgv
 * JD-Core Version:    0.7.0.1
 */