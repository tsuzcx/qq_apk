import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;

public final class cla
  implements EmosmHandler.EmosmHandlerListener
{
  public cla(EmosmHandler paramEmosmHandler, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    if ((paramInt == 6) || (paramInt == 7) || (paramInt == 107))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      if (paramBoolean != true) {
        break label107;
      }
      paramInt = paramEmosmResp.delEpId;
      if ((paramEmosmResp.keySeq != null) && (!paramEmosmResp.keySeq.equals(""))) {
        break label99;
      }
      paramEmosmResp = this.jdField_a_of_type_AndroidContentContext.getString(2131559061);
    }
    for (;;)
    {
      EmosmDetailActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_AndroidWidgetImageView, paramInt, paramEmosmResp, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
      label99:
      paramEmosmResp = paramEmosmResp.keySeq;
      continue;
      label107:
      paramInt = -404;
      paramEmosmResp = this.jdField_a_of_type_AndroidContentContext.getString(2131559062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cla
 * JD-Core Version:    0.7.0.1
 */