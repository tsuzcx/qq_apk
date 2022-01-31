import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class crh
  implements URLDrawable.URLDrawableListener
{
  public crh(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmosmDetailActivity.a(this.a.b, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_ep_download", 0);
    if (EmosmDetailActivity.e != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3)
      {
        int i = paramURLDrawable.getIntrinsicWidth();
        int j = paramURLDrawable.getIntrinsicHeight();
        EmosmDetailActivity.a(this.a, (i * EmosmDetailActivity.a(this.a) + (EmosmDetailActivity.b(this.a) >> 1)) / EmosmDetailActivity.b(this.a));
        EmosmDetailActivity.b(this.a, (j * EmosmDetailActivity.a(this.a) + (EmosmDetailActivity.b(this.a) >> 1)) / EmosmDetailActivity.b(this.a));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)EmosmDetailActivity.e.getLayoutParams();
        localLayoutParams.height = EmosmDetailActivity.c(this.a);
        localLayoutParams.width = EmosmDetailActivity.d(this.a);
        localLayoutParams.addRule(14, -1);
        EmosmDetailActivity.e.setLayoutParams(localLayoutParams);
      }
      EmosmDetailActivity.e.setImageDrawable(paramURLDrawable);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.EmosmDetailActivity", 2, "bigImage load successed");
    }
    this.a.a(false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound)
    {
      if (!this.a.b.c()) {
        break label290;
      }
      QQToast.a(this.a.b.a(), 2131561724, 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
    }
    for (;;)
    {
      EmosmDetailActivity.a(this.a, true);
      if (EmosmDetailActivity.a(this.a) == true) {
        this.a.d();
      }
      return;
      label290:
      MediaPlayerManager.a(this.a.b).a(MarketFaceItemBuilder.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crh
 * JD-Core Version:    0.7.0.1
 */