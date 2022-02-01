import com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory;
import com.tencent.ttpic.video.AEEncoder;

final class awtl
  implements AECoderFactory.AEEncoderFactory
{
  public AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    return new alyx(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtl
 * JD-Core Version:    0.7.0.1
 */