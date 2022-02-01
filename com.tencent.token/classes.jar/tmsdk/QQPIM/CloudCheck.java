package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CloudCheck
  extends JceStruct
{
  static ArrayList<AdPlugin> dO;
  static ArrayList<Integer> dP;
  public String advice = "";
  public int category = 0;
  public ArrayList<Integer> descIds = null;
  public String descritpion = "";
  public int handleAdvice = 0;
  public String handleUrl = "";
  public String officialCertMd5 = "";
  public String officialPackName = "";
  public ArrayList<AdPlugin> plugins = null;
  public int product = 0;
  public int safeLevel = 0;
  public int safeType = 0;
  public String short_desc = "";
  public int virusDescTimestamp = 0;
  public int virusID = 0;
  public String virusName = "";
  
  public CloudCheck() {}
  
  public CloudCheck(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, int paramInt6, ArrayList<AdPlugin> paramArrayList, ArrayList<Integer> paramArrayList1, int paramInt7, String paramString6, String paramString7)
  {
    this.safeType = paramInt1;
    this.virusName = paramString1;
    this.descritpion = paramString2;
    this.virusDescTimestamp = paramInt2;
    this.short_desc = paramString3;
    this.advice = paramString4;
    this.handleAdvice = paramInt3;
    this.virusID = paramInt4;
    this.handleUrl = paramString5;
    this.safeLevel = paramInt5;
    this.product = paramInt6;
    this.plugins = paramArrayList;
    this.descIds = paramArrayList1;
    this.category = paramInt7;
    this.officialPackName = paramString6;
    this.officialCertMd5 = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.safeType = paramJceInputStream.read(this.safeType, 0, true);
    this.virusName = paramJceInputStream.readString(1, false);
    this.descritpion = paramJceInputStream.readString(2, false);
    this.virusDescTimestamp = paramJceInputStream.read(this.virusDescTimestamp, 3, false);
    this.short_desc = paramJceInputStream.readString(4, false);
    this.advice = paramJceInputStream.readString(5, false);
    this.handleAdvice = paramJceInputStream.read(this.handleAdvice, 6, false);
    this.virusID = paramJceInputStream.read(this.virusID, 7, false);
    this.handleUrl = paramJceInputStream.readString(8, false);
    this.safeLevel = paramJceInputStream.read(this.safeLevel, 9, false);
    this.product = paramJceInputStream.read(this.product, 10, false);
    if (dO == null)
    {
      dO = new ArrayList();
      AdPlugin localAdPlugin = new AdPlugin();
      dO.add(localAdPlugin);
    }
    this.plugins = ((ArrayList)paramJceInputStream.read(dO, 11, false));
    if (dP == null)
    {
      dP = new ArrayList();
      dP.add(Integer.valueOf(0));
    }
    this.descIds = ((ArrayList)paramJceInputStream.read(dP, 12, false));
    this.category = paramJceInputStream.read(this.category, 13, false);
    this.officialPackName = paramJceInputStream.readString(14, false);
    this.officialCertMd5 = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.safeType, 0);
    Object localObject = this.virusName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.descritpion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.virusDescTimestamp, 3);
    localObject = this.short_desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.advice;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.handleAdvice, 6);
    paramJceOutputStream.write(this.virusID, 7);
    localObject = this.handleUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.safeLevel, 9);
    paramJceOutputStream.write(this.product, 10);
    localObject = this.plugins;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 11);
    }
    localObject = this.descIds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    paramJceOutputStream.write(this.category, 13);
    localObject = this.officialPackName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.officialCertMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudCheck
 * JD-Core Version:    0.7.0.1
 */