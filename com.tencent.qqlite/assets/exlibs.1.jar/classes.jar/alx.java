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

public class alx
  implements URLDrawable.URLDrawableListener
{
  public alx(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmosmDetailActivity.a(this.a.app, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_ep_download", 0);
    if (EmosmDetailActivity.e != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3)
      {
        int i = paramURLDrawable.getIntrinsicWidth();
        int j = paramURLDrawable.getIntrinsicHeight();
        this.a.f = ((i * this.a.i + (this.a.h >> 1)) / this.a.h);
        this.a.g = ((j * this.a.i + (this.a.h >> 1)) / this.a.h);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)EmosmDetailActivity.e.getLayoutParams();
        localLayoutParams.height = this.a.g;
        localLayoutParams.width = this.a.f;
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
      if (!this.a.app.d()) {
        break label287;
      }
      QQToast.a(this.a.app.a(), 2131363150, 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
    }
    for (;;)
    {
      this.a.b = true;
      if (this.a.c == true) {
        this.a.d();
      }
      return;
      label287:
      MediaPlayerManager.a(this.a.app).a(MarketFaceItemBuilder.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alx
 * JD-Core Version:    0.7.0.1
 */