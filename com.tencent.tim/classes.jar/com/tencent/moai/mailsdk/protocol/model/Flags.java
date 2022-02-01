package com.tencent.moai.mailsdk.protocol.model;

import androidx.annotation.NonNull;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

public class Flags
{
  private static final int ANSWERED_BIT = 1;
  private static final int DELETED_BIT = 2;
  private static final int DRAFT_BIT = 4;
  private static final int FLAGGED_BIT = 8;
  private static final int RECENT_BIT = 16;
  private static final int SEEN_BIT = 32;
  private static final int USER_BIT = -2147483648;
  private int system_flags = 0;
  private Hashtable<String, String> user_flags = new Hashtable();
  
  public Flags() {}
  
  public Flags(Flags paramFlags)
  {
    this.system_flags = paramFlags.system_flags;
    if (paramFlags.user_flags != null) {
      this.user_flags = ((Hashtable)paramFlags.user_flags.clone());
    }
  }
  
  public void add(Flag paramFlag)
  {
    this.system_flags |= paramFlag.bit;
  }
  
  public void add(String paramString)
  {
    this.user_flags.put(paramString.toLowerCase(Locale.ENGLISH), paramString);
  }
  
  public boolean contain(Flag paramFlag)
  {
    return (this.system_flags & paramFlag.bit) != 0;
  }
  
  public boolean contain(String paramString)
  {
    return this.user_flags.containsKey(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  @NonNull
  public Flag[] getSystemFlags()
  {
    Vector localVector = new Vector();
    if ((this.system_flags & 0x1) != 0) {
      localVector.addElement(Flag.ANSWERED);
    }
    if ((this.system_flags & 0x2) != 0) {
      localVector.addElement(Flag.DELETED);
    }
    if ((this.system_flags & 0x4) != 0) {
      localVector.addElement(Flag.DRAFT);
    }
    if ((this.system_flags & 0x8) != 0) {
      localVector.addElement(Flag.FLAGGED);
    }
    if ((this.system_flags & 0x10) != 0) {
      localVector.addElement(Flag.RECENT);
    }
    if ((this.system_flags & 0x20) != 0) {
      localVector.addElement(Flag.SEEN);
    }
    if ((this.system_flags & 0x80000000) != 0) {
      localVector.addElement(Flag.USER);
    }
    Flag[] arrayOfFlag = new Flag[localVector.size()];
    localVector.copyInto(arrayOfFlag);
    return arrayOfFlag;
  }
  
  public String[] getUserFlags()
  {
    Vector localVector = new Vector();
    if (this.user_flags != null)
    {
      localObject = this.user_flags.elements();
      while (((Enumeration)localObject).hasMoreElements()) {
        localVector.addElement(((Enumeration)localObject).nextElement());
      }
    }
    Object localObject = new String[localVector.size()];
    localVector.copyInto((Object[])localObject);
    return localObject;
  }
  
  public void remove(Flag paramFlag)
  {
    this.system_flags &= (paramFlag.bit ^ 0xFFFFFFFF);
  }
  
  public void remove(String paramString)
  {
    this.user_flags.remove(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(");
    Flag[] arrayOfFlag = getSystemFlags();
    int i = 1;
    int j = 0;
    if (j < arrayOfFlag.length)
    {
      localObject = arrayOfFlag[j];
      if (localObject == Flag.ANSWERED)
      {
        localObject = "\\Answered";
        label52:
        if (i == 0) {
          break label154;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuffer.append((String)localObject);
        k = i;
        do
        {
          j += 1;
          i = k;
          break;
          if (localObject == Flag.DELETED)
          {
            localObject = "\\Deleted";
            break label52;
          }
          if (localObject == Flag.DRAFT)
          {
            localObject = "\\Draft";
            break label52;
          }
          if (localObject == Flag.FLAGGED)
          {
            localObject = "\\Flagged";
            break label52;
          }
          if (localObject == Flag.RECENT)
          {
            localObject = "\\Recent";
            break label52;
          }
          k = i;
        } while (localObject != Flag.SEEN);
        localObject = "\\Seen";
        break label52;
        label154:
        localStringBuffer.append(' ');
      }
    }
    Object localObject = getUserFlags();
    int k = 0;
    j = i;
    i = k;
    if (i < localObject.length)
    {
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        localStringBuffer.append(localObject[i]);
        i += 1;
        break;
        localStringBuffer.append(' ');
      }
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
  
  public static final class Flag
  {
    public static final Flag ANSWERED = new Flag(1);
    public static final Flag DELETED = new Flag(2);
    public static final Flag DRAFT = new Flag(4);
    public static final Flag FLAGGED = new Flag(8);
    public static final Flag RECENT = new Flag(16);
    public static final Flag SEEN = new Flag(32);
    public static final Flag USER = new Flag(-2147483648);
    private int bit;
    
    private Flag(int paramInt)
    {
      this.bit = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.Flags
 * JD-Core Version:    0.7.0.1
 */