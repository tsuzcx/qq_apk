package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AnalyseInfo
  extends JceStruct
  implements Cloneable
{
  static FeatureKey dB;
  static SoftInfo dC;
  static CloudCheck dD;
  static UploadFileInfo dE;
  public int actionID = 0;
  public int actionLevel = 0;
  public CloudCheck cloudCheck = null;
  public FeatureKey featureKey = null;
  public int report_feature = 0;
  public SoftInfo softInfo = null;
  public int softState = 0;
  public UploadFileInfo uploadFileInfo = null;
  
  static
  {
    if (!AnalyseInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AnalyseInfo()
  {
    setFeatureKey(this.featureKey);
    setSoftInfo(this.softInfo);
    setCloudCheck(this.cloudCheck);
    setReport_feature(this.report_feature);
    setUploadFileInfo(this.uploadFileInfo);
    setSoftState(this.softState);
    setActionLevel(this.actionLevel);
    setActionID(this.actionID);
  }
  
  public AnalyseInfo(FeatureKey paramFeatureKey, SoftInfo paramSoftInfo, CloudCheck paramCloudCheck, int paramInt1, UploadFileInfo paramUploadFileInfo, int paramInt2, int paramInt3, int paramInt4)
  {
    setFeatureKey(paramFeatureKey);
    setSoftInfo(paramSoftInfo);
    setCloudCheck(paramCloudCheck);
    setReport_feature(paramInt1);
    setUploadFileInfo(paramUploadFileInfo);
    setSoftState(paramInt2);
    setActionLevel(paramInt3);
    setActionID(paramInt4);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.AnalyseInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (AnalyseInfo)paramObject;
    } while ((!JceUtil.equals(this.featureKey, paramObject.featureKey)) || (!JceUtil.equals(this.softInfo, paramObject.softInfo)) || (!JceUtil.equals(this.cloudCheck, paramObject.cloudCheck)) || (!JceUtil.equals(this.report_feature, paramObject.report_feature)) || (!JceUtil.equals(this.uploadFileInfo, paramObject.uploadFileInfo)) || (!JceUtil.equals(this.softState, paramObject.softState)) || (!JceUtil.equals(this.actionLevel, paramObject.actionLevel)) || (!JceUtil.equals(this.actionID, paramObject.actionID)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.AnalyseInfo";
  }
  
  public int getActionID()
  {
    return this.actionID;
  }
  
  public int getActionLevel()
  {
    return this.actionLevel;
  }
  
  public CloudCheck getCloudCheck()
  {
    return this.cloudCheck;
  }
  
  public FeatureKey getFeatureKey()
  {
    return this.featureKey;
  }
  
  public int getReport_feature()
  {
    return this.report_feature;
  }
  
  public SoftInfo getSoftInfo()
  {
    return this.softInfo;
  }
  
  public int getSoftState()
  {
    return this.softState;
  }
  
  public UploadFileInfo getUploadFileInfo()
  {
    return this.uploadFileInfo;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dB == null) {
      dB = new FeatureKey();
    }
    setFeatureKey((FeatureKey)paramJceInputStream.read(dB, 0, true));
    if (dC == null) {
      dC = new SoftInfo();
    }
    setSoftInfo((SoftInfo)paramJceInputStream.read(dC, 1, true));
    if (dD == null) {
      dD = new CloudCheck();
    }
    setCloudCheck((CloudCheck)paramJceInputStream.read(dD, 2, true));
    setReport_feature(paramJceInputStream.read(this.report_feature, 3, true));
    if (dE == null) {
      dE = new UploadFileInfo();
    }
    setUploadFileInfo((UploadFileInfo)paramJceInputStream.read(dE, 4, false));
    setSoftState(paramJceInputStream.read(this.softState, 5, false));
    setActionLevel(paramJceInputStream.read(this.actionLevel, 6, false));
    setActionID(paramJceInputStream.read(this.actionID, 7, false));
  }
  
  public void setActionID(int paramInt)
  {
    this.actionID = paramInt;
  }
  
  public void setActionLevel(int paramInt)
  {
    this.actionLevel = paramInt;
  }
  
  public void setCloudCheck(CloudCheck paramCloudCheck)
  {
    this.cloudCheck = paramCloudCheck;
  }
  
  public void setFeatureKey(FeatureKey paramFeatureKey)
  {
    this.featureKey = paramFeatureKey;
  }
  
  public void setReport_feature(int paramInt)
  {
    this.report_feature = paramInt;
  }
  
  public void setSoftInfo(SoftInfo paramSoftInfo)
  {
    this.softInfo = paramSoftInfo;
  }
  
  public void setSoftState(int paramInt)
  {
    this.softState = paramInt;
  }
  
  public void setUploadFileInfo(UploadFileInfo paramUploadFileInfo)
  {
    this.uploadFileInfo = paramUploadFileInfo;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.featureKey, 0);
    paramJceOutputStream.write(this.softInfo, 1);
    paramJceOutputStream.write(this.cloudCheck, 2);
    paramJceOutputStream.write(this.report_feature, 3);
    if (this.uploadFileInfo != null) {
      paramJceOutputStream.write(this.uploadFileInfo, 4);
    }
    paramJceOutputStream.write(this.softState, 5);
    paramJceOutputStream.write(this.actionLevel, 6);
    paramJceOutputStream.write(this.actionID, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.AnalyseInfo
 * JD-Core Version:    0.7.0.1
 */