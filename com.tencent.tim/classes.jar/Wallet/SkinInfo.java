package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SkinInfo
  extends JceStruct
{
  static PopDialog cache_pop_dialog = new PopDialog();
  public PopDialog pop_dialog;
  public int skin_id;
  public String skin_name = "";
  public long skin_permission_state;
  
  public SkinInfo() {}
  
  public SkinInfo(int paramInt, long paramLong, String paramString, PopDialog paramPopDialog)
  {
    this.skin_id = paramInt;
    this.skin_permission_state = paramLong;
    this.skin_name = paramString;
    this.pop_dialog = paramPopDialog;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.skin_id = paramJceInputStream.read(this.skin_id, 0, true);
    this.skin_permission_state = paramJceInputStream.read(this.skin_permission_state, 1, true);
    this.skin_name = paramJceInputStream.readString(2, true);
    this.pop_dialog = ((PopDialog)paramJceInputStream.read(cache_pop_dialog, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.skin_id, 0);
    paramJceOutputStream.write(this.skin_permission_state, 1);
    paramJceOutputStream.write(this.skin_name, 2);
    if (this.pop_dialog != null) {
      paramJceOutputStream.write(this.pop_dialog, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.SkinInfo
 * JD-Core Version:    0.7.0.1
 */