package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IMAPMailBoxStatus
{
  public static final String[] standardItems = { "MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY" };
  private long highestModSeq = -1L;
  private Map<String, Long> items;
  private String path = null;
  private int recent = -1;
  private int total = -1;
  private long uidNext = -1L;
  private long uidValidity = -1L;
  private int unSeen = -1;
  
  public IMAPMailBoxStatus(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    this.path = paramIMAPResponse.readAtomString();
    Object localObject = new StringBuffer();
    int i = 1;
    while ((paramIMAPResponse.peekByte() != 40) && (paramIMAPResponse.peekByte() != 0))
    {
      char c = (char)paramIMAPResponse.readByte();
      ((StringBuffer)localObject).append(c);
      if (c != ' ') {
        i = 0;
      }
    }
    if (i == 0) {
      this.path = (this.path + localObject).trim();
    }
    if (paramIMAPResponse.readByte() != 40) {
      throw new MessageException(2, "parse error in STATUS");
    }
    for (;;)
    {
      localObject = paramIMAPResponse.readAtom();
      if (((String)localObject).equalsIgnoreCase("MESSAGES")) {
        this.total = paramIMAPResponse.readNumber();
      }
      while (paramIMAPResponse.readByte() == 41)
      {
        return;
        if (((String)localObject).equalsIgnoreCase("RECENT"))
        {
          this.recent = paramIMAPResponse.readNumber();
        }
        else if (((String)localObject).equalsIgnoreCase("UIDNEXT"))
        {
          this.uidNext = paramIMAPResponse.readLong();
        }
        else if (((String)localObject).equalsIgnoreCase("UIDVALIDITY"))
        {
          this.uidValidity = paramIMAPResponse.readLong();
        }
        else if (((String)localObject).equalsIgnoreCase("UNSEEN"))
        {
          this.unSeen = paramIMAPResponse.readNumber();
        }
        else if (((String)localObject).equalsIgnoreCase("HIGHESTMODSEQ"))
        {
          this.highestModSeq = paramIMAPResponse.readLong();
        }
        else
        {
          if (this.items == null) {
            this.items = new HashMap();
          }
          this.items.put(((String)localObject).toUpperCase(Locale.ENGLISH), Long.valueOf(paramIMAPResponse.readLong()));
        }
      }
    }
  }
  
  public void add(IMAPMailBoxStatus paramIMAPMailBoxStatus)
  {
    if (paramIMAPMailBoxStatus.total != -1) {
      this.total = paramIMAPMailBoxStatus.total;
    }
    if (paramIMAPMailBoxStatus.recent != -1) {
      this.recent = paramIMAPMailBoxStatus.recent;
    }
    if (paramIMAPMailBoxStatus.uidNext != -1L) {
      this.uidNext = paramIMAPMailBoxStatus.uidNext;
    }
    if (paramIMAPMailBoxStatus.uidValidity != -1L) {
      this.uidValidity = paramIMAPMailBoxStatus.uidValidity;
    }
    if (paramIMAPMailBoxStatus.unSeen != -1) {
      this.unSeen = paramIMAPMailBoxStatus.unSeen;
    }
    if (paramIMAPMailBoxStatus.highestModSeq != -1L) {
      this.highestModSeq = paramIMAPMailBoxStatus.highestModSeq;
    }
    if (this.items == null) {
      this.items = paramIMAPMailBoxStatus.items;
    }
    while (paramIMAPMailBoxStatus.items == null) {
      return;
    }
    this.items.putAll(paramIMAPMailBoxStatus.items);
  }
  
  public long getHighestModSeq()
  {
    return this.highestModSeq;
  }
  
  public long getItem(String paramString)
  {
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    if (this.items != null)
    {
      Long localLong = (Long)this.items.get(paramString);
      if (localLong != null) {
        return localLong.longValue();
      }
    }
    if (paramString.equals("MESSAGES")) {
      return this.total;
    }
    if (paramString.equals("RECENT")) {
      return this.recent;
    }
    if (paramString.equals("UIDNEXT")) {
      return this.uidNext;
    }
    if (paramString.equals("UIDVALIDITY")) {
      return this.uidValidity;
    }
    if (paramString.equals("UNSEEN")) {
      return this.unSeen;
    }
    if (paramString.equals("HIGHESTMODSEQ")) {
      return this.highestModSeq;
    }
    return -1L;
  }
  
  public Map<String, Long> getItems()
  {
    return this.items;
  }
  
  public int getRecent()
  {
    return this.recent;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public long getUidNext()
  {
    return this.uidNext;
  }
  
  public long getUidValidity()
  {
    return this.uidValidity;
  }
  
  public int getUnSeen()
  {
    return this.unSeen;
  }
  
  public void setHighestModSeq(long paramLong)
  {
    this.highestModSeq = paramLong;
  }
  
  public void setItems(Map<String, Long> paramMap)
  {
    this.items = paramMap;
  }
  
  public void setRecent(int paramInt)
  {
    this.recent = paramInt;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
  
  public void setUidNext(long paramLong)
  {
    this.uidNext = paramLong;
  }
  
  public void setUidValidity(long paramLong)
  {
    this.uidValidity = paramLong;
  }
  
  public void setUnSeen(int paramInt)
  {
    this.unSeen = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailBoxStatus
 * JD-Core Version:    0.7.0.1
 */