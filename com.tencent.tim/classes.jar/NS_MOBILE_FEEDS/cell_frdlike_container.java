package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_frdlike_container
  extends JceStruct
{
  public int blank_actiontype;
  public String right_desc = "";
  public int right_desc_actiontype;
  
  public cell_frdlike_container() {}
  
  public cell_frdlike_container(int paramInt1, String paramString, int paramInt2)
  {
    this.blank_actiontype = paramInt1;
    this.right_desc = paramString;
    this.right_desc_actiontype = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.blank_actiontype = paramJceInputStream.read(this.blank_actiontype, 0, false);
    this.right_desc = paramJceInputStream.readString(1, false);
    this.right_desc_actiontype = paramJceInputStream.read(this.right_desc_actiontype, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.blank_actiontype, 0);
    if (this.right_desc != null) {
      paramJceOutputStream.write(this.right_desc, 1);
    }
    paramJceOutputStream.write(this.right_desc_actiontype, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_frdlike_container
 * JD-Core Version:    0.7.0.1
 */