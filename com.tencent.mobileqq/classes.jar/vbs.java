import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vbs
  extends URLImageView
{
  public vbs(MarketFaceItemBuilder paramMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (MarketFaceItemBuilder.Holder)AIOUtils.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.b) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramURLDrawable = localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(paramURLDrawable instanceof MessageForMarketFace)) {
        break label516;
      }
      paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
      if (paramURLDrawable == null) {
        break label516;
      }
    }
    label514:
    label516:
    for (int i = paramURLDrawable.dwTabID;; i = -1)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
      for (;;)
      {
        return;
        if ((!EmoticonUtils.a()) || (2 != localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.e(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) || (!MagicfaceViewController.a()) || (EmoticonUtils.c()))
        {
          float f = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
          if ((f < 0.0F) || (1.0F == f))
          {
            localHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
            if (QLog.isColorLevel()) {
              QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
            }
          }
        }
        this.a.a(localHolder, paramURLDrawable);
        if ((2 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (MagicfaceViewController.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.e(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
        {
          if (PngFrameUtil.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue) == 1) {
            localHolder.f.setVisibility(8);
          }
        }
        else
        {
          if ((4 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, true, true)))
          {
            localHolder.f.setImageResource(2130837576);
            localHolder.f.setVisibility(0);
          }
          if ((MarketFaceItemBuilder.c != 0L) && (MarketFaceItemBuilder.c == localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
          {
            if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
              break label494;
            }
            QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433788, 0).b(this.a.b.getResources().getDimensionPixelSize(2131558448));
          }
        }
        for (;;)
        {
          if (!AppSetting.b) {
            break label514;
          }
          localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
          return;
          localHolder.f.setImageResource(2130837576);
          localHolder.f.setVisibility(0);
          break;
          label494:
          MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbs
 * JD-Core Version:    0.7.0.1
 */