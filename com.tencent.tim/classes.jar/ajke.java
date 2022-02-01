import android.graphics.Bitmap;
import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;

public class ajke
  implements aqdf.a
{
  public ajke(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (MultiCardRecommendFragment.a(this.a) != null) {
      MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajke
 * JD-Core Version:    0.7.0.1
 */