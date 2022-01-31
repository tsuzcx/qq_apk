package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PluginInfo
  extends JceStruct
{
  public long Count = 0L;
  public boolean Flag = false;
  public long Id = 0L;
  public String PicUrl = "";
  public boolean RedPoint = false;
  public boolean Tab = true;
  public String Text = "";
  
  public PluginInfo() {}
  
  public PluginInfo(long paramLong1, long paramLong2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.Id = paramLong1;
    this.Count = paramLong2;
    this.Flag = paramBoolean1;
    this.Text = paramString1;
    this.PicUrl = paramString2;
    this.RedPoint = paramBoolean2;
    this.Tab = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Id = paramJceInputStream.read(this.Id, 0, true);
    this.Count = paramJceInputStream.read(this.Count, 1, true);
    this.Flag = paramJceInputStream.read(this.Flag, 2, true);
    this.Text = paramJceInputStream.readString(3, false);
    this.PicUrl = paramJceInputStream.readString(4, false);
    this.RedPoint = paramJceInputStream.read(this.RedPoint, 5, false);
    this.Tab = paramJceInputStream.read(this.Tab, 6, false);
  }
  
  public String toString()
  {
    return "id=" + this.Id + ",count=" + this.Count + ",flag=" + this.Flag + ",text=" + this.Text + ",picurl=" + this.PicUrl + ",redpoint=" + this.RedPoint + ",tab=" + this.Tab;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Id, 0);
    paramJceOutputStream.write(this.Count, 1);
    paramJceOutputStream.write(this.Flag, 2);
    if (this.Text != null) {
      paramJceOutputStream.write(this.Text, 3);
    }
    if (this.PicUrl != null) {
      paramJceOutputStream.write(this.PicUrl, 4);
    }
    paramJceOutputStream.write(this.RedPoint, 5);
    paramJceOutputStream.write(this.Tab, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.PluginInfo
 * JD-Core Version:    0.7.0.1
 */