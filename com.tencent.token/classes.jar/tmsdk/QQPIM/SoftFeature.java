package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SoftFeature
  extends JceStruct
{
  static FeatureKey dB;
  static ArrayList<FeatureItem> eX;
  static ArrayList<Integer> eY;
  public int appid = 0;
  public int category = 0;
  public String dexSha1 = "";
  public int engineVersion = 0;
  public FeatureKey featureKey = null;
  public boolean isBuildIn = false;
  public int localSafeType = 0;
  public int localVirusID = 0;
  public String localVirusName = "";
  public ArrayList<Integer> pluginIds = null;
  public int position = 0;
  public int requestType = 0;
  public int softDescTimestamp = 0;
  public ArrayList<FeatureItem> vecFeatureItem = null;
  public int virusDescTimestamp = 0;
  public int virusVersion = 0;
  
  public SoftFeature() {}
  
  public SoftFeature(FeatureKey paramFeatureKey, int paramInt1, int paramInt2, ArrayList<FeatureItem> paramArrayList, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, int paramInt10, String paramString2, ArrayList<Integer> paramArrayList1)
  {
    this.featureKey = paramFeatureKey;
    this.softDescTimestamp = paramInt1;
    this.virusDescTimestamp = paramInt2;
    this.vecFeatureItem = paramArrayList;
    this.requestType = paramInt3;
    this.isBuildIn = paramBoolean;
    this.category = paramInt4;
    this.position = paramInt5;
    this.engineVersion = paramInt6;
    this.localSafeType = paramInt7;
    this.localVirusName = paramString1;
    this.localVirusID = paramInt8;
    this.appid = paramInt9;
    this.virusVersion = paramInt10;
    this.dexSha1 = paramString2;
    this.pluginIds = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dB == null) {
      dB = new FeatureKey();
    }
    this.featureKey = ((FeatureKey)paramJceInputStream.read(dB, 0, true));
    this.softDescTimestamp = paramJceInputStream.read(this.softDescTimestamp, 1, true);
    this.virusDescTimestamp = paramJceInputStream.read(this.virusDescTimestamp, 2, true);
    if (eX == null)
    {
      eX = new ArrayList();
      FeatureItem localFeatureItem = new FeatureItem();
      eX.add(localFeatureItem);
    }
    this.vecFeatureItem = ((ArrayList)paramJceInputStream.read(eX, 3, false));
    this.requestType = paramJceInputStream.read(this.requestType, 4, false);
    this.isBuildIn = paramJceInputStream.read(this.isBuildIn, 5, false);
    this.category = paramJceInputStream.read(this.category, 6, false);
    this.position = paramJceInputStream.read(this.position, 7, false);
    this.engineVersion = paramJceInputStream.read(this.engineVersion, 8, false);
    this.localSafeType = paramJceInputStream.read(this.localSafeType, 9, false);
    this.localVirusName = paramJceInputStream.readString(10, false);
    this.localVirusID = paramJceInputStream.read(this.localVirusID, 11, false);
    this.appid = paramJceInputStream.read(this.appid, 12, false);
    this.virusVersion = paramJceInputStream.read(this.virusVersion, 13, false);
    this.dexSha1 = paramJceInputStream.readString(14, false);
    if (eY == null)
    {
      eY = new ArrayList();
      eY.add(Integer.valueOf(0));
    }
    this.pluginIds = ((ArrayList)paramJceInputStream.read(eY, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.featureKey, 0);
    paramJceOutputStream.write(this.softDescTimestamp, 1);
    paramJceOutputStream.write(this.virusDescTimestamp, 2);
    if (this.vecFeatureItem != null) {
      paramJceOutputStream.write(this.vecFeatureItem, 3);
    }
    paramJceOutputStream.write(this.requestType, 4);
    paramJceOutputStream.write(this.isBuildIn, 5);
    paramJceOutputStream.write(this.category, 6);
    paramJceOutputStream.write(this.position, 7);
    paramJceOutputStream.write(this.engineVersion, 8);
    paramJceOutputStream.write(this.localSafeType, 9);
    if (this.localVirusName != null) {
      paramJceOutputStream.write(this.localVirusName, 10);
    }
    paramJceOutputStream.write(this.localVirusID, 11);
    paramJceOutputStream.write(this.appid, 12);
    paramJceOutputStream.write(this.virusVersion, 13);
    if (this.dexSha1 != null) {
      paramJceOutputStream.write(this.dexSha1, 14);
    }
    if (this.pluginIds != null) {
      paramJceOutputStream.write(this.pluginIds, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftFeature
 * JD-Core Version:    0.7.0.1
 */