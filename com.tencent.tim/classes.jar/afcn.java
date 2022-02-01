import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CountDownProgressBar;
import java.io.File;

public class afcn
  implements Handler.Callback
{
  public afcn(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "handleMessage,msg:" + paramMessage.what);
    }
    Object localObject;
    switch (paramMessage.what)
    {
    case 6: 
    default: 
    case 1: 
    case 0: 
    case 2: 
    case 3: 
      do
      {
        int i;
        do
        {
          return false;
          HotChatFlashPicActivity.a(this.this$0).setVisibility(0);
          HotChatFlashPicActivity.a(this.this$0).setOnTouchListener(this.this$0);
          HotChatFlashPicActivity.b(this.this$0).setVisibility(0);
          HotChatFlashPicActivity.a(this.this$0).setImageResource(2130843393);
          if (HotChatFlashPicActivity.b(this.this$0)) {
            HotChatFlashPicActivity.a(this.this$0).setText(2131694702);
          }
          while (HotChatFlashPicActivity.a(this.this$0).isShow())
          {
            HotChatFlashPicActivity.a(this.this$0).hide();
            return false;
            HotChatFlashPicActivity.a(this.this$0).setText(2131691845);
          }
          localObject = (String)paramMessage.obj;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramMessage = new File((String)localObject);
            if ((!((String)localObject).endsWith(HotChatFlashPicActivity.a(this.this$0).aVY)) && (HotChatFlashPicActivity.a(this.this$0).bjc))
            {
              if (!HotChatFlashPicActivity.a(this.this$0).bim)
              {
                HotChatFlashPicActivity.a(this.this$0, true);
                HotChatFlashPicActivity.a(this.this$0).downloadMedia(HotChatFlashPicActivity.a(this.this$0).id, HotChatFlashPicActivity.a(this.this$0).subId, 2);
                return false;
              }
              HotChatFlashPicActivity.a(this.this$0).sendEmptyMessage(1);
              return false;
            }
            localObject = URLDrawable.URLDrawableOptions.obtain();
            DisplayMetrics localDisplayMetrics = this.this$0.getResources().getDisplayMetrics();
            ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = localDisplayMetrics.widthPixels;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = localDisplayMetrics.heightPixels;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
            ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = true;
            ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
            paramMessage = URLDrawable.getDrawable(paramMessage, (URLDrawable.URLDrawableOptions)localObject);
            HotChatFlashPicActivity.a(this.this$0).setTag(paramMessage);
            HotChatFlashPicActivity.a(this.this$0).setVisibility(0);
            HotChatFlashPicActivity.a(this.this$0).setOnTouchListener(this.this$0);
            if (HotChatFlashPicActivity.c(this.this$0)) {
              HotChatFlashPicActivity.b(this.this$0).setVisibility(0);
            }
            HotChatFlashPicActivity.c(this.this$0, true);
            HotChatFlashPicActivity.a(this.this$0).setImageResource(2130843395);
            if (HotChatFlashPicActivity.b(this.this$0)) {
              HotChatFlashPicActivity.a(this.this$0).setText(2131694706);
            }
            while (HotChatFlashPicActivity.a(this.this$0).isShow())
            {
              HotChatFlashPicActivity.a(this.this$0).hide();
              return false;
              HotChatFlashPicActivity.a(this.this$0).setText(2131691855);
            }
          }
          HotChatFlashPicActivity.a(this.this$0).sendEmptyMessage(1);
          return false;
          i = paramMessage.arg1;
        } while ((!HotChatFlashPicActivity.a(this.this$0).isShow()) || (HotChatFlashPicActivity.a(this.this$0).bjc));
        HotChatFlashPicActivity.a(this.this$0).start(i);
        return false;
      } while (HotChatFlashPicActivity.d(this.this$0));
      HotChatFlashPicActivity.d(this.this$0, true);
      HotChatFlashPicActivity.b(this.this$0).setVisibility(8);
      if (HotChatFlashPicActivity.a(this.this$0).getTag() != null)
      {
        HotChatFlashPicActivity.a(this.this$0).setVisibility(0);
        HotChatFlashPicActivity.a(this.this$0).setImageDrawable((URLDrawable)HotChatFlashPicActivity.a(this.this$0).getTag());
      }
      HotChatFlashPicActivity.a(this.this$0).setVisibility(0);
      HotChatFlashPicActivity.a(this.this$0).start();
      HotChatFlashPicActivity.a(this.this$0).gd(HotChatFlashPicActivity.a(this.this$0));
      return false;
    case 4: 
      if (HotChatFlashPicActivity.b(this.this$0)) {
        if (HotChatFlashPicActivity.a(this.this$0) >= 2) {
          paramMessage = this.this$0.getString(2131694705);
        }
      }
      break;
    }
    for (;;)
    {
      HotChatFlashPicActivity.a(this.this$0, aqha.a(this.this$0, paramMessage, 0, 2131720227, null, new afco(this)));
      if (this.this$0.isFinishing()) {
        break;
      }
      HotChatFlashPicActivity.d(this.this$0, false);
      HotChatFlashPicActivity.a(this.this$0).setVisibility(8);
      HotChatFlashPicActivity.a(this.this$0).setVisibility(8);
      HotChatFlashPicActivity.a(this.this$0).setVisibility(8);
      HotChatFlashPicActivity.a(this.this$0).show();
      return false;
      paramMessage = this.this$0.getString(2131694704);
      continue;
      if (HotChatFlashPicActivity.a(this.this$0) == 2)
      {
        paramMessage = this.this$0.getString(2131691853);
        localObject = paramMessage;
        if (!HotChatFlashPicActivity.e(this.this$0))
        {
          if (HotChatFlashPicActivity.b(this.this$0) == 0)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A3", "0X80069A3", 0, 0, "", "", "", "");
            continue;
          }
          if (HotChatFlashPicActivity.b(this.this$0) == 3000)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A4", "0X80069A4", 0, 0, "", "", "", "");
            continue;
          }
          localObject = paramMessage;
          if (HotChatFlashPicActivity.b(this.this$0) == 1) {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A5", "0X80069A5", 0, 0, "", "", "", "");
          }
        }
      }
      else if (HotChatFlashPicActivity.a(this.this$0) < 2)
      {
        paramMessage = this.this$0.getString(2131691847);
        localObject = paramMessage;
        if (!HotChatFlashPicActivity.e(this.this$0))
        {
          if (HotChatFlashPicActivity.b(this.this$0) == 0)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A0", "0X80069A0", 0, 0, "", "", "", "");
            continue;
          }
          if (HotChatFlashPicActivity.b(this.this$0) == 3000)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A1", "0X80069A1", 0, 0, "", "", "", "");
            continue;
          }
          localObject = paramMessage;
          if (HotChatFlashPicActivity.b(this.this$0) == 1) {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80069A2", "0X80069A2", 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        paramMessage = HotChatFlashPicActivity.e(this.this$0);
        continue;
        HotChatFlashPicActivity.a(this.this$0, (Bitmap)paramMessage.obj);
        return false;
        if ((HotChatFlashPicActivity.a(this.this$0).isShow()) || (HotChatFlashPicActivity.c(this.this$0))) {
          break;
        }
        HotChatFlashPicActivity.a(this.this$0).show();
        HotChatFlashPicActivity.a(this.this$0).start(HotChatFlashPicActivity.c(this.this$0));
        return false;
        if ((HotChatFlashPicActivity.a(this.this$0) == null) || (HotChatFlashPicActivity.a(this.this$0).getBitmap() == null)) {
          break;
        }
        HotChatFlashPicActivity.a(this.this$0).getBitmap().recycle();
        HotChatFlashPicActivity.a(this.this$0, null);
        return false;
      }
      paramMessage = (Message)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcn
 * JD-Core Version:    0.7.0.1
 */