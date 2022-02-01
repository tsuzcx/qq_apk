import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class zdd
  implements ViewPager.OnPageChangeListener
{
  zdd(zdc paramzdc) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = zdc.a(this.b).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      zdc.a(this.b, localEmoticonFromGroupEntity);
      zdc.b(this.b, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdd
 * JD-Core Version:    0.7.0.1
 */