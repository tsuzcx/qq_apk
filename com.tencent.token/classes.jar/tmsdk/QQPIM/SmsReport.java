package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SmsReport
  extends JceStruct
  implements Cloneable
{
  static ArrayList eV;
  static ArrayList eW;
  public String comment = "";
  public int matchTime = 0;
  public int product = 0;
  public String sender = "";
  public String sms = "";
  public int smsType = 0;
  public int ucAction = 0;
  public int ucActionReason = 0;
  public int ucContentType = 0;
  public int ucMinusMark = 0;
  public ArrayList vecHitRule = null;
  public ArrayList vecUserAction = null;
  
  static
  {
    if (!SmsReport.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SmsReport()
  {
    setSender(this.sender);
    setSms(this.sms);
    setMatchTime(this.matchTime);
    setUcAction(this.ucAction);
    setUcActionReason(this.ucActionReason);
    setUcContentType(this.ucContentType);
    setVecHitRule(this.vecHitRule);
    setUcMinusMark(this.ucMinusMark);
    setVecUserAction(this.vecUserAction);
    setComment(this.comment);
    setSmsType(this.smsType);
    setProduct(this.product);
  }
  
  public SmsReport(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList paramArrayList1, int paramInt5, ArrayList paramArrayList2, String paramString3, int paramInt6, int paramInt7)
  {
    setSender(paramString1);
    setSms(paramString2);
    setMatchTime(paramInt1);
    setUcAction(paramInt2);
    setUcActionReason(paramInt3);
    setUcContentType(paramInt4);
    setVecHitRule(paramArrayList1);
    setUcMinusMark(paramInt5);
    setVecUserAction(paramArrayList2);
    setComment(paramString3);
    setSmsType(paramInt6);
    setProduct(paramInt7);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SmsReport";
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
      paramObject = (SmsReport)paramObject;
    } while ((!JceUtil.equals(this.sender, paramObject.sender)) || (!JceUtil.equals(this.sms, paramObject.sms)) || (!JceUtil.equals(this.matchTime, paramObject.matchTime)) || (!JceUtil.equals(this.ucAction, paramObject.ucAction)) || (!JceUtil.equals(this.ucActionReason, paramObject.ucActionReason)) || (!JceUtil.equals(this.ucContentType, paramObject.ucContentType)) || (!JceUtil.equals(this.vecHitRule, paramObject.vecHitRule)) || (!JceUtil.equals(this.ucMinusMark, paramObject.ucMinusMark)) || (!JceUtil.equals(this.vecUserAction, paramObject.vecUserAction)) || (!JceUtil.equals(this.comment, paramObject.comment)) || (!JceUtil.equals(this.smsType, paramObject.smsType)) || (!JceUtil.equals(this.product, paramObject.product)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SmsReport";
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public int getMatchTime()
  {
    return this.matchTime;
  }
  
  public int getProduct()
  {
    return this.product;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public String getSms()
  {
    return this.sms;
  }
  
  public int getSmsType()
  {
    return this.smsType;
  }
  
  public int getUcAction()
  {
    return this.ucAction;
  }
  
  public int getUcActionReason()
  {
    return this.ucActionReason;
  }
  
  public int getUcContentType()
  {
    return this.ucContentType;
  }
  
  public int getUcMinusMark()
  {
    return this.ucMinusMark;
  }
  
  public ArrayList getVecHitRule()
  {
    return this.vecHitRule;
  }
  
  public ArrayList getVecUserAction()
  {
    return this.vecUserAction;
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
    setSender(paramJceInputStream.readString(0, true));
    setSms(paramJceInputStream.readString(1, true));
    setMatchTime(paramJceInputStream.read(this.matchTime, 2, true));
    setUcAction(paramJceInputStream.read(this.ucAction, 3, true));
    setUcActionReason(paramJceInputStream.read(this.ucActionReason, 4, true));
    setUcContentType(paramJceInputStream.read(this.ucContentType, 5, false));
    Object localObject;
    if (eV == null)
    {
      eV = new ArrayList();
      localObject = new RuleTypeID();
      eV.add(localObject);
    }
    setVecHitRule((ArrayList)paramJceInputStream.read(eV, 6, false));
    setUcMinusMark(paramJceInputStream.read(this.ucMinusMark, 7, false));
    if (eW == null)
    {
      eW = new ArrayList();
      localObject = new UserActionTime();
      eW.add(localObject);
    }
    setVecUserAction((ArrayList)paramJceInputStream.read(eW, 8, false));
    setComment(paramJceInputStream.readString(9, false));
    setSmsType(paramJceInputStream.read(this.smsType, 10, false));
    setProduct(paramJceInputStream.read(this.product, 11, false));
  }
  
  public void setComment(String paramString)
  {
    this.comment = paramString;
  }
  
  public void setMatchTime(int paramInt)
  {
    this.matchTime = paramInt;
  }
  
  public void setProduct(int paramInt)
  {
    this.product = paramInt;
  }
  
  public void setSender(String paramString)
  {
    this.sender = paramString;
  }
  
  public void setSms(String paramString)
  {
    this.sms = paramString;
  }
  
  public void setSmsType(int paramInt)
  {
    this.smsType = paramInt;
  }
  
  public void setUcAction(int paramInt)
  {
    this.ucAction = paramInt;
  }
  
  public void setUcActionReason(int paramInt)
  {
    this.ucActionReason = paramInt;
  }
  
  public void setUcContentType(int paramInt)
  {
    this.ucContentType = paramInt;
  }
  
  public void setUcMinusMark(int paramInt)
  {
    this.ucMinusMark = paramInt;
  }
  
  public void setVecHitRule(ArrayList paramArrayList)
  {
    this.vecHitRule = paramArrayList;
  }
  
  public void setVecUserAction(ArrayList paramArrayList)
  {
    this.vecUserAction = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sender, 0);
    paramJceOutputStream.write(this.sms, 1);
    paramJceOutputStream.write(this.matchTime, 2);
    paramJceOutputStream.write(this.ucAction, 3);
    paramJceOutputStream.write(this.ucActionReason, 4);
    paramJceOutputStream.write(this.ucContentType, 5);
    if (this.vecHitRule != null) {
      paramJceOutputStream.write(this.vecHitRule, 6);
    }
    paramJceOutputStream.write(this.ucMinusMark, 7);
    if (this.vecUserAction != null) {
      paramJceOutputStream.write(this.vecUserAction, 8);
    }
    if (this.comment != null) {
      paramJceOutputStream.write(this.comment, 9);
    }
    paramJceOutputStream.write(this.smsType, 10);
    paramJceOutputStream.write(this.product, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SmsReport
 * JD-Core Version:    0.7.0.1
 */