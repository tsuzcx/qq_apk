package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class tAdvAppInfo
  extends JceStruct
{
  public int app_id;
  public String app_key = "";
  public int i_debug_adv_id;
  public int i_need_adv_cnt;
  
  public tAdvAppInfo() {}
  
  public tAdvAppInfo(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.app_id = paramInt1;
    this.app_key = paramString;
    this.i_need_adv_cnt = paramInt2;
    this.i_debug_adv_id = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.app_id = paramJceInputStream.read(this.app_id, 0, true);
    this.app_key = paramJceInputStream.readString(1, true);
    this.i_need_adv_cnt = paramJceInputStream.read(this.i_need_adv_cnt, 2, false);
    this.i_debug_adv_id = paramJceInputStream.read(this.i_debug_adv_id, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.app_id, 0);
    paramJceOutputStream.write(this.app_key, 1);
    paramJceOutputStream.write(this.i_need_adv_cnt, 2);
    paramJceOutputStream.write(this.i_debug_adv_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     BOSSStrategyCenter.tAdvAppInfo
 * JD-Core Version:    0.7.0.1
 */