package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class SmsReport
  extends JceStruct
  implements Cloneable
{
  static ArrayList<RuleTypeID> eV;
  static ArrayList<UserActionTime> eW;
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
  public ArrayList<RuleTypeID> vecHitRule = null;
  public ArrayList<UserActionTime> vecUserAction = null;
  
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
  
  public SmsReport(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<RuleTypeID> paramArrayList, int paramInt5, ArrayList<UserActionTime> paramArrayList1, String paramString3, int paramInt6, int paramInt7)
  {
    setSender(paramString1);
    setSms(paramString2);
    setMatchTime(paramInt1);
    setUcAction(paramInt2);
    setUcActionReason(paramInt3);
    setUcContentType(paramInt4);
    setVecHitRule(paramArrayList);
    setUcMinusMark(paramInt5);
    setVecUserAction(paramArrayList1);
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
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SmsReport)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.sender, paramObject.sender))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.sms, paramObject.sms))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.matchTime, paramObject.matchTime))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.ucAction, paramObject.ucAction))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.ucActionReason, paramObject.ucActionReason))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.ucContentType, paramObject.ucContentType))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.vecHitRule, paramObject.vecHitRule))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.ucMinusMark, paramObject.ucMinusMark))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.vecUserAction, paramObject.vecUserAction))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.comment, paramObject.comment))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.smsType, paramObject.smsType))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.product, paramObject.product)) {
                            bool1 = true;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
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
  
  public ArrayList<RuleTypeID> getVecHitRule()
  {
    return this.vecHitRule;
  }
  
  public ArrayList<UserActionTime> getVecUserAction()
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
  
  public void setVecHitRule(ArrayList<RuleTypeID> paramArrayList)
  {
    this.vecHitRule = paramArrayList;
  }
  
  public void setVecUserAction(ArrayList<UserActionTime> paramArrayList)
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
    Object localObject = this.vecHitRule;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    paramJceOutputStream.write(this.ucMinusMark, 7);
    localObject = this.vecUserAction;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.comment;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.smsType, 10);
    paramJceOutputStream.write(this.product, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SmsReport
 * JD-Core Version:    0.7.0.1
 */