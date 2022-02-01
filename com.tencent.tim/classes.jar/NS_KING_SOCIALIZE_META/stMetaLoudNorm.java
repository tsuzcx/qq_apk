package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaLoudNorm
  extends JceStruct
{
  public String input_i = "";
  public String input_lra = "";
  public String input_thresh = "";
  public String input_tp = "";
  public String normalization_type = "";
  public String output_i = "";
  public String output_lra = "";
  public String output_thresh = "";
  public String output_tp = "";
  public String target_offset = "";
  public String weishi_i = "";
  public String weishi_lra = "";
  public String weishi_tp = "";
  
  public stMetaLoudNorm() {}
  
  public stMetaLoudNorm(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this.input_i = paramString1;
    this.input_tp = paramString2;
    this.input_lra = paramString3;
    this.input_thresh = paramString4;
    this.output_i = paramString5;
    this.output_tp = paramString6;
    this.output_lra = paramString7;
    this.output_thresh = paramString8;
    this.normalization_type = paramString9;
    this.target_offset = paramString10;
    this.weishi_i = paramString11;
    this.weishi_tp = paramString12;
    this.weishi_lra = paramString13;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.input_i = paramJceInputStream.readString(0, false);
    this.input_tp = paramJceInputStream.readString(1, false);
    this.input_lra = paramJceInputStream.readString(2, false);
    this.input_thresh = paramJceInputStream.readString(3, false);
    this.output_i = paramJceInputStream.readString(4, false);
    this.output_tp = paramJceInputStream.readString(5, false);
    this.output_lra = paramJceInputStream.readString(6, false);
    this.output_thresh = paramJceInputStream.readString(7, false);
    this.normalization_type = paramJceInputStream.readString(8, false);
    this.target_offset = paramJceInputStream.readString(9, false);
    this.weishi_i = paramJceInputStream.readString(10, false);
    this.weishi_tp = paramJceInputStream.readString(11, false);
    this.weishi_lra = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.input_i != null) {
      paramJceOutputStream.write(this.input_i, 0);
    }
    if (this.input_tp != null) {
      paramJceOutputStream.write(this.input_tp, 1);
    }
    if (this.input_lra != null) {
      paramJceOutputStream.write(this.input_lra, 2);
    }
    if (this.input_thresh != null) {
      paramJceOutputStream.write(this.input_thresh, 3);
    }
    if (this.output_i != null) {
      paramJceOutputStream.write(this.output_i, 4);
    }
    if (this.output_tp != null) {
      paramJceOutputStream.write(this.output_tp, 5);
    }
    if (this.output_lra != null) {
      paramJceOutputStream.write(this.output_lra, 6);
    }
    if (this.output_thresh != null) {
      paramJceOutputStream.write(this.output_thresh, 7);
    }
    if (this.normalization_type != null) {
      paramJceOutputStream.write(this.normalization_type, 8);
    }
    if (this.target_offset != null) {
      paramJceOutputStream.write(this.target_offset, 9);
    }
    if (this.weishi_i != null) {
      paramJceOutputStream.write(this.weishi_i, 10);
    }
    if (this.weishi_tp != null) {
      paramJceOutputStream.write(this.weishi_tp, 11);
    }
    if (this.weishi_lra != null) {
      paramJceOutputStream.write(this.weishi_lra, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaLoudNorm
 * JD-Core Version:    0.7.0.1
 */