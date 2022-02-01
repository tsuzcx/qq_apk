import com.tencent.ttpic.video.AECoderFactory.AEDecoderFactory;
import com.tencent.ttpic.video.AEDecoder;

final class awtk
  implements AECoderFactory.AEDecoderFactory
{
  public AEDecoder createDecoder(String paramString)
  {
    return new alyw(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtk
 * JD-Core Version:    0.7.0.1
 */