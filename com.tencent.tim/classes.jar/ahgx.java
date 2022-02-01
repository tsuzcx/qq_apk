import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class ahgx
  implements View.OnClickListener
{
  ahgx(ahgq paramahgq, String paramString, ahgq.a parama) {}
  
  private void doc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from other");
    }
    String str = this.this$0.bf.getString("forward_filepath");
    if (str != null) {
      ahgq.a(this.this$0, str, this.val$uin);
    }
    do
    {
      return;
      if (this.this$0.mIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
        }
        this.this$0.bf.putBoolean("FORWARD_IS_QZONE_SHARE", true);
        ahgq.a(this.this$0, this.this$0.bKv, this.val$uin);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
  }
  
  private void f(AIOImageData paramAIOImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from AIOImageData");
    }
    if ((paramAIOImageData.gF(4)) && (paramAIOImageData.c(4) != null)) {
      ahgq.a(this.this$0, paramAIOImageData, this.val$uin);
    }
    do
    {
      return;
      if ((paramAIOImageData.gF(2)) && (paramAIOImageData.c(2) != null))
      {
        ahgq.a(this.this$0, paramAIOImageData, this.val$uin);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
  }
  
  private void n(MessageForPic paramMessageForPic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from MessageForPic");
    }
    File localFile = new File(paramMessageForPic.path);
    if (((localFile == null) || (!localFile.exists()) || (localFile.length() != paramMessageForPic.size)) || (paramMessageForPic != null)) {
      ahgq.a(this.this$0, paramMessageForPic, this.val$uin);
    }
  }
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    Parcelable localParcelable = this.this$0.bf.getParcelable("FORWARD_MSG_FOR_PIC");
    if ((localParcelable instanceof MessageForPic)) {
      n((MessageForPic)localParcelable);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localParcelable instanceof AIOImageData)) {
        f((AIOImageData)localParcelable);
      } else {
        doc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgx
 * JD-Core Version:    0.7.0.1
 */