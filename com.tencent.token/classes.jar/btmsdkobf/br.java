package btmsdkobf;

import android.content.Context;
import java.io.File;

public class br
{
  public int gA;
  public int gB;
  public bt gz;
  
  public String Z()
  {
    return this.gz.gH + "_" + this.gz.gI + "_" + this.gz.gJ + ".dat";
  }
  
  public String aa()
  {
    return bc.n().getFilesDir().getAbsolutePath() + File.separator + this.gz.gH + "_" + this.gz.gI + "_" + this.gz.gJ;
  }
  
  public String ab()
  {
    return bc.n().getDir(new String(new byte[] { 100, 101, 120 }), 0).getAbsolutePath();
  }
  
  public String toString()
  {
    String str2 = "op:[" + this.gA + "]status:[" + this.gB + "]";
    String str1 = str2;
    if (this.gz != null) {
      str1 = str2 + "id:[" + this.gz.gH + "]ver:[" + this.gz.gI + "]ver_nest:[" + this.gz.gJ + "]runtype:[" + this.gz.gK + "]size:[" + this.gz.gM + "]md5:[" + this.gz.gN + "]url:[" + this.gz.gO + "]";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.br
 * JD-Core Version:    0.7.0.1
 */