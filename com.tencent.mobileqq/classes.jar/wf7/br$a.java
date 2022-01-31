package wf7;

import android.net.wifi.WifiManager;
import java.util.Arrays;

class br$a
  implements Comparable<a>
{
  public int gd;
  public byte[] gg;
  public int gh;
  
  public br$a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.gg = paramArrayOfByte;
    this.gd = paramInt1;
    this.gh = paramInt2;
  }
  
  public int a(a parama)
  {
    if (parama == null) {
      return -1;
    }
    return WifiManager.compareSignalLevel(this.gd, parama.gd);
  }
  
  public String toString()
  {
    return "Ap [mBssid=" + Arrays.toString(this.gg) + ", mRssi=" + this.gd + ", mFrequency=" + this.gh + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.br.a
 * JD-Core Version:    0.7.0.1
 */