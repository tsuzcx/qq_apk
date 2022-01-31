package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.persistence.Entity;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class QCallRecord
  extends Entity
{
  private static final int Kilo = 1000;
  public static int TYPE_DATE = 0;
  public static int TYPE_REALRECORD = 1;
  public static final int VERSION_CODE = 1;
  public String friendUin;
  public int isVideo;
  public int issend = 1;
  public byte[] msgData;
  public String senderuin;
  public int state;
  public String talkTime;
  public long time;
  public String troopUin;
  public int type = TYPE_REALRECORD;
  public int uinType;
  public long uniseq;
  public int versionCode = 1;
  
  public QCallRecord()
  {
    this(TYPE_REALRECORD);
  }
  
  public QCallRecord(int paramInt)
  {
    this.type = paramInt;
    if (paramInt == TYPE_REALRECORD) {
      createMessageUniseq();
    }
  }
  
  public static String getTableName(String paramString, int paramInt)
  {
    return "qc_" + paramInt + "_" + MsgProxyUtils.a(paramString);
  }
  
  public void createMessageUniseq()
  {
    this.uniseq = ((int)this.time);
    if (this.uniseq == 0L) {
      this.uniseq = ((int)(System.currentTimeMillis() / 1000L));
    }
    this.uniseq = (this.uniseq << 32 | Math.abs(new Random().nextInt()));
  }
  
  public int getDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.time * 1000L);
    return localCalendar.get(5);
  }
  
  public String getDateString()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(this.time * 1000L);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return BaseApplicationImpl.getContext().getString(2131559233);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return BaseApplicationImpl.getContext().getString(2131559234);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {}
    switch (localCalendar1.get(7))
    {
    default: 
      return new SimpleDateFormat("yy-MM-dd").format(localDate);
    case 1: 
      return BaseApplicationImpl.getContext().getString(2131559235);
    case 2: 
      return BaseApplicationImpl.getContext().getString(2131559236);
    case 3: 
      return BaseApplicationImpl.getContext().getString(2131559237);
    case 4: 
      return BaseApplicationImpl.getContext().getString(2131559238);
    case 5: 
      return BaseApplicationImpl.getContext().getString(2131559239);
    case 6: 
      return BaseApplicationImpl.getContext().getString(2131559240);
    }
    return BaseApplicationImpl.getContext().getString(2131559241);
  }
  
  public String getTableName()
  {
    return getTableName(this.friendUin, this.uinType);
  }
  
  public String getTalkTimeMinute()
  {
    int j = 0;
    Object localObject;
    int i;
    int k;
    if (this.uinType == 3000)
    {
      long l = Long.parseLong(this.talkTime);
      localObject = new GregorianCalendar();
      ((GregorianCalendar)localObject).setTimeInMillis(l * 1000L);
      i = ((GregorianCalendar)localObject).get(10);
      j = ((GregorianCalendar)localObject).get(12);
      k = ((GregorianCalendar)localObject).get(13);
      localObject = new StringBuffer();
      if (i != 0) {
        ((StringBuffer)localObject).append(i).append(BaseApplicationImpl.getContext().getString(2131559242));
      }
      if (i != 0) {
        ((StringBuffer)localObject).append(j).append(BaseApplicationImpl.getContext().getString(2131559243));
      }
      if (i != 0) {
        ((StringBuffer)localObject).append(k).append(BaseApplicationImpl.getContext().getString(2131559244));
      }
      return ((StringBuffer)localObject).toString();
    }
    if ((this.talkTime != null) && (!this.talkTime.equals("")) && (this.talkTime.split(":").length >= 2))
    {
      localObject = this.talkTime.split(":");
      if (localObject.length == 2)
      {
        j = Integer.parseInt(localObject[0]);
        i = Integer.parseInt(localObject[1]);
        k = 0;
      }
    }
    for (;;)
    {
      if (k != 0) {}
      for (localObject = "" + k + BaseApplicationImpl.getContext().getString(2131559245);; localObject = "")
      {
        if (j != 0) {
          localObject = (String)localObject + j + BaseApplicationImpl.getContext().getString(2131559246);
        }
        for (;;)
        {
          return (String)localObject + i + BaseApplicationImpl.getContext().getString(2131559247);
          if (localObject.length != 3) {
            break label365;
          }
          k = Integer.parseInt(localObject[0]);
          j = Integer.parseInt(localObject[1]);
          i = Integer.parseInt(localObject[2]);
          break;
          return "";
        }
      }
      label365:
      i = 0;
      k = 0;
    }
  }
  
  public String getTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.time * 1000L);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    return localDecimalFormat.format(localCalendar.get(11)) + ":" + localDecimalFormat.format(localCalendar.get(12));
  }
  
  public boolean isMissCall()
  {
    if (this.uinType != 3000)
    {
      if ((this.issend != 0) || ((12 != this.state) && (1 != this.state))) {}
    }
    else {
      while ((this.issend == 0) && (this.state == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isSender()
  {
    return this.issend == 1;
  }
  
  public boolean isVideo()
  {
    return this.isVideo == 1;
  }
  
  public String toString()
  {
    return "QCallRecord [state=" + this.state + ", time=" + this.time + ", talkTime=" + this.talkTime + ", type=" + this.type + ", friendUin=" + this.friendUin + ", troopUin=" + this.troopUin + ", uinType=" + this.uinType + ", uniseq=" + this.uniseq + ", issend=" + this.issend + ", msgData=" + Arrays.toString(this.msgData) + ", senderuin=" + this.senderuin + ", isVideo=" + this.isVideo + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecord
 * JD-Core Version:    0.7.0.1
 */