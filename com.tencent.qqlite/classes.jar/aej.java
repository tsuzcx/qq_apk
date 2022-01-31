import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class aej
  implements DialogInterface.OnDismissListener, View.OnClickListener, OnLongClickAndTouchListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  
  private aej(ChatHistory paramChatHistory) {}
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131298958)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) {
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.dismiss();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) && (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.isShowing()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131298958, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363086));
    if (localQQCustomMenu.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aek)ChatHistory.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      String str;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText)) {
        if (((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).location != null) {
          str = "地理位置";
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, str, localQQCustomMenu, this, this);
        a(paramView);
        return true;
        str = "消息";
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForFile)) {
          str = "文件";
        } else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)) {
          str = "语音";
        } else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
          str = "图片";
        } else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace)) {
          str = "表情";
        } else {
          str = "消息";
        }
      }
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aej
 * JD-Core Version:    0.7.0.1
 */