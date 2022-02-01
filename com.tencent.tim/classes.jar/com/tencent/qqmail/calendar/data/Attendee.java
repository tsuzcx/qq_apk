package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;
import java.util.ArrayList;

public class Attendee
{
  private String email;
  private String name;
  private int status;
  private int type;
  
  public static ArrayList<Attendee> generateAttendees(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      paramString = paramString.split("&&");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString = paramString[i].split(":");
          if ((arrayOfString != null) && (arrayOfString.length == 4))
          {
            Attendee localAttendee = new Attendee();
            localAttendee.setEmail(arrayOfString[0]);
            localAttendee.setName(arrayOfString[1]);
            localAttendee.setStatus(Integer.valueOf(arrayOfString[2]).intValue());
            localAttendee.setType(Integer.valueOf(arrayOfString[3]).intValue());
            localArrayList.add(localAttendee);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static long generateId(Attendee paramAttendee, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append("^");
    localStringBuilder.append(paramAttendee.getEmail());
    localStringBuilder.append("^");
    localStringBuilder.append(paramAttendee.getName());
    localStringBuilder.append("^");
    return QMMath.hashLong(localStringBuilder.toString());
  }
  
  public static String genertateAttendeeToString(ArrayList<Attendee> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Attendee localAttendee = (Attendee)paramArrayList.get(0);
      localStringBuilder.append(localAttendee.getEmail()).append(":").append(localAttendee.getName()).append(":").append(localAttendee.getStatus()).append(":").append(localAttendee.getType());
      int i = 1;
      while (i < paramArrayList.size())
      {
        localAttendee = (Attendee)paramArrayList.get(i);
        localStringBuilder.append("&&").append(localAttendee.getEmail()).append(":").append(localAttendee.getName()).append(":").append(localAttendee.getStatus()).append(":").append(localAttendee.getType());
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.Attendee
 * JD-Core Version:    0.7.0.1
 */