import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class kmg
{
  public static void a(VideoInfo paramVideoInfo, ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    Drawable localDrawable = aqhu.c(true);
    if (!TextUtils.isEmpty(paramVideoInfo.WC))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      try
      {
        paramVideoInfo = URLDrawable.getDrawable(new URL(paramVideoInfo.WC), localURLDrawableOptions);
        paramVideoInfo.setDecodeHandler(aqbn.b);
        paramReadInJoyHeadImageView.setImageDrawable(paramVideoInfo);
        return;
      }
      catch (MalformedURLException paramVideoInfo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MultiVideoIconHelper", 2, "initVideoItemContentUI() ERROR e = " + paramVideoInfo.getMessage());
        return;
      }
    }
    if (!TextUtils.isEmpty(paramVideoInfo.hH))
    {
      paramReadInJoyHeadImageView.setImagePlaceHolder(localDrawable);
      paramReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.hH).longValue(), false);
      return;
    }
    paramReadInJoyHeadImageView.setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmg
 * JD-Core Version:    0.7.0.1
 */