import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class avjt
  extends amtl
{
  private BitmapFactory.Options e = new BitmapFactory.Options();
  
  public avjt(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    paramamxy.getTitleView().setMaxWidth(800);
    avjs localavjs = (avjs)paramampx;
    ImageView localImageView = paramamxy.w();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localavjs.exg) || (localavjs.playable))
    {
      localImageView.setImageResource(2130845026);
      if (localavjs.cLr == null) {
        break label186;
      }
      paramampx = URLDrawable.URLDrawableOptions.obtain();
      paramampx.mRequestHeight = paramamxy.w().getHeight();
      paramampx.mRequestWidth = paramamxy.w().getWidth();
      if ((5 != localavjs.exg) && (!localavjs.playable)) {
        break label136;
      }
      localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localavjs.cLr, paramampx));
    }
    label136:
    do
    {
      return;
      localImageView.setImageDrawable(null);
      localImageView.setBackgroundDrawable(null);
      break;
      try
      {
        localImageView.setImageDrawable(URLDrawable.getDrawable(localavjs.cLr, paramampx));
        return;
      }
      catch (Exception paramampx) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavoriteSearchResultPresenter", 2, "bindFace exception = " + paramampx.toString());
    return;
    label186:
    if (localavjs.exe != 0)
    {
      if ((5 == localavjs.exg) || (localavjs.playable))
      {
        localImageView.setBackgroundResource(localavjs.exe);
        return;
      }
      localImageView.setImageResource(localavjs.exe);
      return;
    }
    if (localavjs.hX != null)
    {
      this.e.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localavjs.hX, 0, localavjs.hX.length, this.e);
      this.e.inJustDecodeBounds = false;
      this.e.inSampleSize = (this.e.outWidth / paramamxy.w().getMeasuredWidth());
      try
      {
        paramampx = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localavjs.hX, 0, localavjs.hX.length, this.e));
        if ((5 == localavjs.exg) || (localavjs.playable))
        {
          localImageView.setBackgroundDrawable(paramampx);
          return;
        }
      }
      catch (OutOfMemoryError paramampx)
      {
        for (;;)
        {
          paramampx = null;
        }
        localImageView.setImageDrawable(paramampx);
        return;
      }
    }
    super.a(paramampx, paramamxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjt
 * JD-Core Version:    0.7.0.1
 */