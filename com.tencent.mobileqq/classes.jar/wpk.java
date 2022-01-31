import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

public class wpk
  implements ViewPager.OnPageChangeListener
{
  public wpk(PicSelectAdapter paramPicSelectAdapter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = PicSelectAdapter.a(this.a).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      PicSelectAdapter.a(this.a, localEmoticonFromGroupEntity);
      PicSelectAdapter.b(this.a, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpk
 * JD-Core Version:    0.7.0.1
 */