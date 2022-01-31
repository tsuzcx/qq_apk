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

public final class amb
  implements EmosmHandler.EmosmHandlerListener
{
  public amb(EmosmHandler paramEmosmHandler, int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    if ((paramInt == 6) || (paramInt == 7) || (paramInt == 107))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      if (paramBoolean != true) {
        break label100;
      }
      paramInt = paramEmosmResp.delEpId;
      if ((paramEmosmResp.keySeq != null) && (!paramEmosmResp.keySeq.equals(""))) {
        break label92;
      }
      paramEmosmResp = "你暂时没有此表情的权限。";
    }
    for (;;)
    {
      EmosmDetailActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_AndroidWidgetImageView, paramInt, paramEmosmResp, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
      label92:
      paramEmosmResp = paramEmosmResp.keySeq;
      continue;
      label100:
      paramInt = -404;
      paramEmosmResp = "服务器忙，请稍后再试";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     amb
 * JD-Core Version:    0.7.0.1
 */