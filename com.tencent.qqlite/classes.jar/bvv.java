import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class bvv
  extends URLImageView
{
  public bvv(MarketFaceItemBuilder paramMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (bvu)AIOUtils.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)paramThrowable.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    this.a.a(paramThrowable, paramURLDrawable);
    paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    bvu localbvu = (bvu)AIOUtils.a(this);
    if (localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3)
    {
      int j = paramURLDrawable.getIntrinsicWidth();
      int i = paramURLDrawable.getIntrinsicHeight();
      j = (j * this.a.o + (this.a.n >> 1)) / this.a.n;
      i = (i * this.a.o + (this.a.n >> 1)) / this.a.n;
      super.setImageDrawable(null);
      super.setLayoutParams(new FrameLayout.LayoutParams(j, i));
      super.setImageDrawable(paramURLDrawable);
      MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localbvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      i = NetworkUtil.a(this.a.b);
      boolean bool = SettingCloneUtil.readValue(this.a.b, null, this.a.b.getString(2131363052), "qqsetting_auto_receive_magic_face_key", true);
      if (((i != 1) && (i != 3) && (i != 4)) || (2 != localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c(localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) || (((i == 3) || (i == 4)) && (!bool)))
      {
        float f = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if ((f < 0.0F) || (1.0F == f)) {
          localbvu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      this.a.a(localbvu, paramURLDrawable);
      if ((2 == localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c(localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        localbvu.f.setVisibility(0);
      }
      if ((MarketFaceItemBuilder.jdField_a_of_type_Long != 0L) && (localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (MarketFaceItemBuilder.jdField_a_of_type_Long == localbvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localbvu.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
      {
        if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break label458;
        }
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363140, 0).b(this.a.b.getResources().getDimensionPixelSize(2131492887));
      }
    }
    for (;;)
    {
      localbvu.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
      return;
      super.setImageDrawable(null);
      super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      break;
      label458:
      MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localbvu.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvv
 * JD-Core Version:    0.7.0.1
 */