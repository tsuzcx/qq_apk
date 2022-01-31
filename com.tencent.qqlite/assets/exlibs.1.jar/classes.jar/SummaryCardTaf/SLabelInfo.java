package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SLabelInfo
  extends JceStruct
{
  public long likeit = 0L;
  public String name = "";
  public boolean valid = true;
  
  public SLabelInfo() {}
  
  public SLabelInfo(long paramLong, String paramString, boolean paramBoolean)
  {
    this.likeit = paramLong;
    this.name = paramString;
    this.valid = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.likeit = paramJceInputStream.read(this.likeit, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.valid = paramJceInputStream.read(this.valid, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.likeit, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.valid, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCardTaf.SLabelInfo
 * JD-Core Version:    0.7.0.1
 */