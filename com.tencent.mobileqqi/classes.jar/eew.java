import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class eew
  extends URLImageView
{
  public eew(MarketFaceItemBuilder paramMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (eev)AIOUtils.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)paramThrowable.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    this.a.a(paramThrowable, paramURLDrawable);
    paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    eev localeev = (eev)AIOUtils.a(this);
    if (localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3)
    {
      int j = paramURLDrawable.getIntrinsicWidth();
      int i = paramURLDrawable.getIntrinsicHeight();
      j = (j * this.a.o + (this.a.n >> 1)) / this.a.n;
      i = (i * this.a.o + (this.a.n >> 1)) / this.a.n;
      super.setImageDrawable(null);
      super.setLayoutParams(new FrameLayout.LayoutParams(j, i));
      super.setImageDrawable(paramURLDrawable);
      MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localeev.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      i = NetworkUtil.a(this.a.b);
      boolean bool = SettingCloneUtil.readValue(this.a.b, null, this.a.b.getString(2131563423), "qqsetting_auto_receive_magic_face_key", true);
      if (((i != 1) && (i != 3) && (i != 4)) || (2 != localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (EmoticonController.a(MarketFaceItemBuilder.a(this.a)).b(localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) || (!MagicfaceViewController.a()) || (((i == 3) || (i == 4)) && (!bool)))
      {
        float f = EmoticonController.a(MarketFaceItemBuilder.b(this.a)).a(localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if ((f < 0.0F) || (1.0F == f)) {
          localeev.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      this.a.a(localeev, paramURLDrawable);
      if ((2 == localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (EmoticonController.a(MarketFaceItemBuilder.c(this.a)).b(localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        localeev.f.setVisibility(0);
      }
      if ((MarketFaceItemBuilder.a() != 0L) && (localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (MarketFaceItemBuilder.a() == localeev.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localeev.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
      {
        if (!MarketFaceItemBuilder.d(this.a).c()) {
          break label473;
        }
        QQToast.a(MarketFaceItemBuilder.e(this.a).a(), 2131561724, 0).b(this.a.b.getResources().getDimensionPixelSize(2131427376));
      }
    }
    for (;;)
    {
      localeev.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
      return;
      super.setImageDrawable(null);
      super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      break;
      label473:
      MediaPlayerManager.a(MarketFaceItemBuilder.f(this.a)).a(localeev.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eew
 * JD-Core Version:    0.7.0.1
 */