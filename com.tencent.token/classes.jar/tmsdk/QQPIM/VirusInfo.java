package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VirusInfo
  extends JceStruct
{
  static ArrayList dP;
  static ArrayList fk;
  static ArrayList fl;
  static ArrayList fm;
  static ArrayList fn;
  public int ad_action1 = 0;
  public int ad_action2 = 0;
  public ArrayList ad_ip_list = null;
  public ArrayList ad_url_list = null;
  public int advice = 0;
  public int category = 0;
  public ArrayList classify = null;
  public ArrayList descIds = null;
  public String description = "";
  public ArrayList features = null;
  public int id = 0;
  public String label = "";
  public int level = 0;
  public int method = 0;
  public String name = "";
  public int optype = 0;
  public byte ostype = 0;
  public int pkgnum = 0;
  public int product = 0;
  public int safelevel = 0;
  public int safetype = 0;
  public int scantype = 0;
  public int timestamp = 0;
  public String url = "";
  
  public VirusInfo() {}
  
  public VirusInfo(int paramInt1, String paramString1, int paramInt2, byte paramByte, String paramString2, ArrayList paramArrayList1, int paramInt3, int paramInt4, String paramString3, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString4, int paramInt9, int paramInt10, ArrayList paramArrayList2, int paramInt11, int paramInt12, int paramInt13, ArrayList paramArrayList3, ArrayList paramArrayList4, ArrayList paramArrayList5, int paramInt14)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.timestamp = paramInt2;
    this.ostype = paramByte;
    this.description = paramString2;
    this.features = paramArrayList1;
    this.safetype = paramInt3;
    this.advice = paramInt4;
    this.label = paramString3;
    this.optype = paramInt5;
    this.scantype = paramInt6;
    this.level = paramInt7;
    this.method = paramInt8;
    this.url = paramString4;
    this.pkgnum = paramInt9;
    this.safelevel = paramInt10;
    this.classify = paramArrayList2;
    this.product = paramInt11;
    this.ad_action1 = paramInt12;
    this.ad_action2 = paramInt13;
    this.ad_url_list = paramArrayList3;
    this.ad_ip_list = paramArrayList4;
    this.descIds = paramArrayList5;
    this.category = paramInt14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, true);
    this.ostype = paramJceInputStream.read(this.ostype, 3, true);
    this.description = paramJceInputStream.readString(4, true);
    Object localObject;
    if (fk == null)
    {
      fk = new ArrayList();
      localObject = new VirusFeature();
      fk.add(localObject);
    }
    this.features = ((ArrayList)paramJceInputStream.read(fk, 5, true));
    this.safetype = paramJceInputStream.read(this.safetype, 6, false);
    this.advice = paramJceInputStream.read(this.advice, 7, false);
    this.label = paramJceInputStream.readString(8, false);
    this.optype = paramJceInputStream.read(this.optype, 9, false);
    this.scantype = paramJceInputStream.read(this.scantype, 10, false);
    this.level = paramJceInputStream.read(this.level, 11, false);
    this.method = paramJceInputStream.read(this.method, 12, false);
    this.url = paramJceInputStream.readString(13, false);
    this.pkgnum = paramJceInputStream.read(this.pkgnum, 14, false);
    this.safelevel = paramJceInputStream.read(this.safelevel, 15, false);
    if (fl == null)
    {
      fl = new ArrayList();
      localObject = new ClassifyFeature();
      fl.add(localObject);
    }
    this.classify = ((ArrayList)paramJceInputStream.read(fl, 16, false));
    this.product = paramJceInputStream.read(this.product, 17, false);
    this.ad_action1 = paramJceInputStream.read(this.ad_action1, 18, false);
    this.ad_action2 = paramJceInputStream.read(this.ad_action2, 19, false);
    if (fm == null)
    {
      fm = new ArrayList();
      fm.add("");
    }
    this.ad_url_list = ((ArrayList)paramJceInputStream.read(fm, 20, false));
    if (fn == null)
    {
      fn = new ArrayList();
      fn.add("");
    }
    this.ad_ip_list = ((ArrayList)paramJceInputStream.read(fn, 21, false));
    if (dP == null)
    {
      dP = new ArrayList();
      dP.add(Integer.valueOf(0));
    }
    this.descIds = ((ArrayList)paramJceInputStream.read(dP, 22, false));
    this.category = paramJceInputStream.read(this.category, 23, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.ostype, 3);
    paramJceOutputStream.write(this.description, 4);
    paramJceOutputStream.write(this.features, 5);
    paramJceOutputStream.write(this.safetype, 6);
    paramJceOutputStream.write(this.advice, 7);
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 8);
    }
    paramJceOutputStream.write(this.optype, 9);
    paramJceOutputStream.write(this.scantype, 10);
    paramJceOutputStream.write(this.level, 11);
    paramJceOutputStream.write(this.method, 12);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 13);
    }
    paramJceOutputStream.write(this.pkgnum, 14);
    paramJceOutputStream.write(this.safelevel, 15);
    if (this.classify != null) {
      paramJceOutputStream.write(this.classify, 16);
    }
    paramJceOutputStream.write(this.product, 17);
    paramJceOutputStream.write(this.ad_action1, 18);
    paramJceOutputStream.write(this.ad_action2, 19);
    if (this.ad_url_list != null) {
      paramJceOutputStream.write(this.ad_url_list, 20);
    }
    if (this.ad_ip_list != null) {
      paramJceOutputStream.write(this.ad_ip_list, 21);
    }
    if (this.descIds != null) {
      paramJceOutputStream.write(this.descIds, 22);
    }
    paramJceOutputStream.write(this.category, 23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.VirusInfo
 * JD-Core Version:    0.7.0.1
 */