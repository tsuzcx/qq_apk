package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleMetaReply
  extends JceStruct
{
  static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
  static stSimpleMetaPerson cache_receiver = new stSimpleMetaPerson();
  public String beReplyReplyId = "";
  public int createtime;
  public String id = "";
  public int mask;
  public stSimpleMetaPerson poster;
  public stSimpleMetaPerson receiver;
  public int robotMode;
  public String wording = "";
  
  public stSimpleMetaReply() {}
  
  public stSimpleMetaReply(String paramString1, String paramString2, stSimpleMetaPerson paramstSimpleMetaPerson1, stSimpleMetaPerson paramstSimpleMetaPerson2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.poster = paramstSimpleMetaPerson1;
    this.receiver = paramstSimpleMetaPerson2;
    this.createtime = paramInt1;
    this.mask = paramInt2;
    this.robotMode = paramInt3;
    this.beReplyReplyId = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.poster = ((stSimpleMetaPerson)paramJceInputStream.read(cache_poster, 2, false));
    this.receiver = ((stSimpleMetaPerson)paramJceInputStream.read(cache_receiver, 3, false));
    this.createtime = paramJceInputStream.read(this.createtime, 4, false);
    this.mask = paramJceInputStream.read(this.mask, 5, false);
    this.robotMode = paramJceInputStream.read(this.robotMode, 6, false);
    this.beReplyReplyId = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.wording != null) {
      paramJceOutputStream.write(this.wording, 1);
    }
    if (this.poster != null) {
      paramJceOutputStream.write(this.poster, 2);
    }
    if (this.receiver != null) {
      paramJceOutputStream.write(this.receiver, 3);
    }
    paramJceOutputStream.write(this.createtime, 4);
    paramJceOutputStream.write(this.mask, 5);
    paramJceOutputStream.write(this.robotMode, 6);
    if (this.beReplyReplyId != null) {
      paramJceOutputStream.write(this.beReplyReplyId, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleMetaReply
 * JD-Core Version:    0.7.0.1
 */