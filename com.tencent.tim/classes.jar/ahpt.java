import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.3.1;
import com.tencent.widget.ThemeImageView;

public final class ahpt
  implements aqdf.a
{
  public ahpt(aqdf paramaqdf, ThemeImageView paramThemeImageView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.b.destory();
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new IntimatePlayTogetherMiniGameCardView.3.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpt
 * JD-Core Version:    0.7.0.1
 */