import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import java.util.Comparator;

public class alzv
  implements Comparator<alzg>
{
  public alzv(Mp4FlowReEncoder paramMp4FlowReEncoder) {}
  
  public int a(alzg paramalzg1, alzg paramalzg2)
  {
    if (paramalzg2.gH() > paramalzg1.gH()) {
      return -1;
    }
    if (paramalzg2.gH() == paramalzg1.gH()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzv
 * JD-Core Version:    0.7.0.1
 */