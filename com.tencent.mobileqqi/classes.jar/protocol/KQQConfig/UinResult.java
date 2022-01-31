package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UinResult
  extends JceStruct
{
  static ArrayList cache_values;
  public int iresult = 0;
  public ArrayList values = null;
  
  public UinResult() {}
  
  public UinResult(int paramInt, ArrayList paramArrayList)
  {
    this.iresult = paramInt;
    this.values = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iresult = paramJceInputStream.read(this.iresult, 1, true);
    if (cache_values == null)
    {
      cache_values = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_values.add(arrayOfByte);
    }
    this.values = ((ArrayList)paramJceInputStream.read(cache_values, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iresult, 1);
    paramJceOutputStream.write(this.values, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.UinResult
 * JD-Core Version:    0.7.0.1
 */