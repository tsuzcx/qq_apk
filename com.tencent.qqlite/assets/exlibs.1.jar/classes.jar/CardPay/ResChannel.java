package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResChannel
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecChannel;
  public String msg = "";
  public int ret = 0;
  public int subCmd = 0;
  public ArrayList vecChannel = null;
  
  public ResChannel() {}
  
  public ResChannel(int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList)
  {
    this.subCmd = paramInt1;
    this.ret = paramInt2;
    this.msg = paramString;
    this.vecChannel = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.ret = paramJceInputStream.read(this.ret, 1, true);
    this.msg = paramJceInputStream.readString(2, true);
    if (cache_vecChannel == null)
    {
      cache_vecChannel = new ArrayList();
      Channel localChannel = new Channel();
      cache_vecChannel.add(localChannel);
    }
    this.vecChannel = ((ArrayList)paramJceInputStream.read(cache_vecChannel, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.ret, 1);
    paramJceOutputStream.write(this.msg, 2);
    paramJceOutputStream.write(this.vecChannel, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     CardPay.ResChannel
 * JD-Core Version:    0.7.0.1
 */