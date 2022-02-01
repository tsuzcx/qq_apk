import android.support.annotation.Nullable;
import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class pxf
{
  public long Az;
  public boolean aCx;
  public boolean aCy;
  protected AtomicBoolean aR = new AtomicBoolean(false);
  public long mStartTime;
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    this.aCx = false;
  }
  
  public void aPh()
  {
    this.aCx = true;
  }
  
  public void aTA()
  {
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void bnx()
  {
    this.Az = System.currentTimeMillis();
  }
  
  public void rw(String paramString)
  {
    long l2 = System.currentTimeMillis();
    long l1 = this.Az - this.mStartTime;
    l2 -= this.Az;
    ram.i(paramString, "page network respond times " + l1);
    ram.i(paramString, "page db times " + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxf
 * JD-Core Version:    0.7.0.1
 */