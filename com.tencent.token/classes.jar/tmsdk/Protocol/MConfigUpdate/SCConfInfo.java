package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import tmsdk.Protocol.MCommon.TimeCtrl;
import tmsdk.Protocol.MCommon.TipsInfo;

public final class SCConfInfo
  extends JceStruct
{
  static TimeCtrl bA = new TimeCtrl();
  static TipsInfo bB = new TipsInfo();
  static TipsInfo bC = new TipsInfo();
  static ArrayList<ServerConfInfo> bD = new ArrayList();
  public TipsInfo extTips = null;
  public String taskId = "";
  public TimeCtrl timeCtrl = null;
  public TipsInfo tips = null;
  public ArrayList<ServerConfInfo> vecConfInfo = null;
  
  static
  {
    ServerConfInfo localServerConfInfo = new ServerConfInfo();
    bD.add(localServerConfInfo);
  }
  
  public JceStruct newInit()
  {
    return new SCConfInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.taskId = paramJceInputStream.readString(0, true);
    this.timeCtrl = ((TimeCtrl)paramJceInputStream.read(bA, 1, false));
    this.tips = ((TipsInfo)paramJceInputStream.read(bB, 2, false));
    this.extTips = ((TipsInfo)paramJceInputStream.read(bC, 3, false));
    this.vecConfInfo = ((ArrayList)paramJceInputStream.read(bD, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.taskId, 0);
    Object localObject = this.timeCtrl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.tips;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.extTips;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.vecConfInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.SCConfInfo
 * JD-Core Version:    0.7.0.1
 */