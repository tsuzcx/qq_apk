import android.content.Context;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;

public class qle
{
  private qle.a a = new qle.a();
  @NonNull
  private final Context mContext;
  
  public qle(@NonNull Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      this.mContext = paramContext.getApplicationContext();
      boP();
      return;
    }
  }
  
  private void boP() {}
  
  public void destroy() {}
  
  public static class a
    implements Cloneable
  {
    public long AW;
    public long audioBitRate;
    public String audioCodec;
    public String axK;
    public long duration;
    public long fileSize;
    public boolean isLocal;
    public ArrayList<Integer> lw = new ArrayList();
    public String vid;
    public long videoBitRate;
    public String videoCodec;
    public int videoHeight;
    public int videoWidth;
    
    public a() {}
    
    public a(a parama)
    {
      this.lw.addAll(parama.lw);
      this.vid = parama.vid;
      this.isLocal = parama.isLocal;
      this.fileSize = parama.fileSize;
      this.videoCodec = parama.videoCodec;
      this.videoWidth = parama.videoWidth;
      this.videoHeight = parama.videoHeight;
      this.videoBitRate = parama.videoBitRate;
      this.audioCodec = parama.audioCodec;
      this.audioBitRate = parama.audioBitRate;
      this.axK = parama.axK;
    }
    
    public long df()
    {
      if (this.lw.size() < 3) {
        return -1L;
      }
      int k = Math.min(this.lw.size(), 10);
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((Integer)this.lw.get(i)).intValue();
        i += 1;
      }
      return j / k;
    }
    
    public long dg()
    {
      if (this.lw.size() >= 3) {
        return ((Integer)Collections.min(this.lw)).intValue();
      }
      return -1L;
    }
    
    public long dh()
    {
      if (this.lw.size() >= 3) {
        return ((Integer)Collections.max(this.lw)).intValue();
      }
      return -1L;
    }
    
    public String toString()
    {
      return " " + this.vid + " " + this.fileSize + " " + this.videoWidth + " " + this.videoHeight + " " + this.videoBitRate + " " + this.isLocal + " " + df() + " " + dg() + " " + dh() + " " + this.videoCodec + " " + this.audioCodec + " " + this.audioBitRate + " " + this.axK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qle
 * JD-Core Version:    0.7.0.1
 */