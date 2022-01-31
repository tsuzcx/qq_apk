package MyCarrier;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class RspCarrier
  extends JceStruct
{
  static Carrier cache_carrrier;
  static Map cache_mParams;
  static ArrayList cache_vAvailSsids;
  public Carrier carrrier = null;
  public int freeTime = 0;
  public Map mParams = null;
  public String msg = "";
  public String optBuf = "";
  public int refreshTime = 0;
  public int ret = 0;
  public int retWiFi = 0;
  public ArrayList vAvailSsids = null;
  public byte wifiEnable = 0;
  
  public RspCarrier() {}
  
  public RspCarrier(int paramInt1, String paramString1, Carrier paramCarrier, String paramString2, int paramInt2, int paramInt3, byte paramByte, ArrayList paramArrayList, int paramInt4, Map paramMap)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.carrrier = paramCarrier;
    this.optBuf = paramString2;
    this.refreshTime = paramInt2;
    this.retWiFi = paramInt3;
    this.wifiEnable = paramByte;
    this.vAvailSsids = paramArrayList;
    this.freeTime = paramInt4;
    this.mParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    if (cache_carrrier == null) {
      cache_carrrier = new Carrier();
    }
    this.carrrier = ((Carrier)paramJceInputStream.read(cache_carrrier, 2, true));
    this.optBuf = paramJceInputStream.readString(3, true);
    this.refreshTime = paramJceInputStream.read(this.refreshTime, 4, false);
    this.retWiFi = paramJceInputStream.read(this.retWiFi, 5, false);
    this.wifiEnable = paramJceInputStream.read(this.wifiEnable, 6, false);
    if (cache_vAvailSsids == null)
    {
      cache_vAvailSsids = new ArrayList();
      cache_vAvailSsids.add("");
    }
    this.vAvailSsids = ((ArrayList)paramJceInputStream.read(cache_vAvailSsids, 7, false));
    this.freeTime = paramJceInputStream.read(this.freeTime, 8, false);
    if (cache_mParams == null)
    {
      cache_mParams = new HashMap();
      cache_mParams.put("", "");
    }
    this.mParams = ((Map)paramJceInputStream.read(cache_mParams, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.carrrier, 2);
    paramJceOutputStream.write(this.optBuf, 3);
    paramJceOutputStream.write(this.refreshTime, 4);
    paramJceOutputStream.write(this.retWiFi, 5);
    paramJceOutputStream.write(this.wifiEnable, 6);
    if (this.vAvailSsids != null) {
      paramJceOutputStream.write(this.vAvailSsids, 7);
    }
    paramJceOutputStream.write(this.freeTime, 8);
    if (this.mParams != null) {
      paramJceOutputStream.write(this.mParams, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MyCarrier.RspCarrier
 * JD-Core Version:    0.7.0.1
 */