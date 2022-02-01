import android.media.MediaCodec.BufferInfo;
import java.util.ArrayList;

public class ambt
{
  private String bZJ;
  private String mBasePath;
  private int mIndex;
  private ArrayList<Long> qC = new ArrayList();
  private ArrayList<Integer> ze = new ArrayList();
  
  public ambt(String paramString, int paramInt)
  {
    this.mBasePath = paramString;
    this.mIndex = paramInt;
    this.bZJ = (this.mBasePath + "segment" + paramInt + ".mp4");
  }
  
  public void b(amag.a parama)
  {
    parama = parama.d;
    this.qC.add(Long.valueOf(parama.presentationTimeUs));
    this.ze.add(Integer.valueOf(parama.flags));
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public long getTimeStamp()
  {
    if (this.qC.size() > 0) {
      return ((Long)this.qC.get(0)).longValue();
    }
    return 0L;
  }
  
  public String toString()
  {
    return "SegmentInfo{mSegmentPath='" + this.bZJ + '\'' + ", mFrames=" + this.qC + ", mFlags=" + this.ze + '}';
  }
  
  public String yL()
  {
    return this.bZJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambt
 * JD-Core Version:    0.7.0.1
 */