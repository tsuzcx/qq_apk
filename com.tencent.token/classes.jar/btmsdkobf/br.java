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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.gz.gH);
    localStringBuilder.append("_");
    localStringBuilder.append(this.gz.gI);
    localStringBuilder.append("_");
    localStringBuilder.append(this.gz.gJ);
    localStringBuilder.append(".dat");
    return localStringBuilder.toString();
  }
  
  public String aa()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bc.n().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.gz.gH);
    localStringBuilder.append("_");
    localStringBuilder.append(this.gz.gI);
    localStringBuilder.append("_");
    localStringBuilder.append(this.gz.gJ);
    return localStringBuilder.toString();
  }
  
  public String ab()
  {
    return bc.n().getDir(new String(new byte[] { 100, 101, 120 }), 0).getAbsolutePath();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("op:[");
    ((StringBuilder)localObject).append(this.gA);
    ((StringBuilder)localObject).append("]status:[");
    ((StringBuilder)localObject).append(this.gB);
    ((StringBuilder)localObject).append("]");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.gz != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("id:[");
      ((StringBuilder)localObject).append(this.gz.gH);
      ((StringBuilder)localObject).append("]ver:[");
      ((StringBuilder)localObject).append(this.gz.gI);
      ((StringBuilder)localObject).append("]ver_nest:[");
      ((StringBuilder)localObject).append(this.gz.gJ);
      ((StringBuilder)localObject).append("]runtype:[");
      ((StringBuilder)localObject).append(this.gz.gK);
      ((StringBuilder)localObject).append("]size:[");
      ((StringBuilder)localObject).append(this.gz.gM);
      ((StringBuilder)localObject).append("]md5:[");
      ((StringBuilder)localObject).append(this.gz.gN);
      ((StringBuilder)localObject).append("]url:[");
      ((StringBuilder)localObject).append(this.gz.gO);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.br
 * JD-Core Version:    0.7.0.1
 */