import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

public class jlx
  extends QQAVImageFilterGroup
{
  public jlx()
  {
    super(null);
    int i = 0;
    while (i < 3)
    {
      addFilter(new QQAVImageGaussianBlurFilter());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlx
 * JD-Core Version:    0.7.0.1
 */