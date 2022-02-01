package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.protocol.model.Flags;
import java.util.ArrayList;
import java.util.Iterator;

public class IMAPMailboxInfo
{
  private Flags availableFlags = null;
  private int first = -1;
  private long highestModSeq = -1L;
  private int mode;
  public Flags permanentFlags = null;
  private int recent = -1;
  private int total = -1;
  private long uidNext = -1L;
  private long uidValidity = -1L;
  
  public IMAPMailboxInfo(ArrayList<IMAPResponse> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label427:
    label429:
    do
    {
      return;
      Object localObject = (IMAPResponse)paramArrayList.get(paramArrayList.size() - 1);
      if (((IMAPResponse)localObject).isOK())
      {
        if (((IMAPResponse)localObject).toString().indexOf("READ-ONLY") != -1) {
          this.mode = 1;
        }
      }
      else {
        localObject = paramArrayList.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label429;
        }
        IMAPResponse localIMAPResponse = (IMAPResponse)((Iterator)localObject).next();
        if (localIMAPResponse != null)
        {
          if (localIMAPResponse.keyEquals("EXISTS"))
          {
            this.total = localIMAPResponse.getNumber();
            continue;
            this.mode = 2;
            break;
          }
          if (localIMAPResponse.keyEquals("RECENT"))
          {
            this.recent = localIMAPResponse.getNumber();
          }
          else if (localIMAPResponse.keyEquals("FLAGS"))
          {
            this.availableFlags = new IMAPFlags(localIMAPResponse);
          }
          else if ((localIMAPResponse.keyEquals("VANISHED")) || (localIMAPResponse.keyEquals("FETCH")))
          {
            paramArrayList.add(localIMAPResponse);
          }
          else if ((localIMAPResponse.isUnTagged()) && (localIMAPResponse.isOK()))
          {
            localIMAPResponse.skipSpaces();
            if (localIMAPResponse.peekByte() != 91)
            {
              localIMAPResponse.reset();
            }
            else
            {
              localIMAPResponse.readByte();
              String str = localIMAPResponse.readAtom();
              int i;
              if (str.equalsIgnoreCase("UNSEEN"))
              {
                this.first = localIMAPResponse.readNumber();
                i = 1;
              }
              for (;;)
              {
                if (i != 0) {
                  break label427;
                }
                localIMAPResponse.reset();
                break;
                if (str.equalsIgnoreCase("UIDVALIDITY"))
                {
                  this.uidValidity = localIMAPResponse.readLong();
                  i = 1;
                }
                else if (str.equalsIgnoreCase("PERMANENTFLAGS"))
                {
                  this.permanentFlags = new IMAPFlags(localIMAPResponse);
                  i = 1;
                }
                else if (str.equalsIgnoreCase("UIDNEXT"))
                {
                  this.uidNext = localIMAPResponse.readLong();
                  i = 1;
                }
                else if (str.equalsIgnoreCase("HIGHESTMODSEQ"))
                {
                  this.highestModSeq = localIMAPResponse.readLong();
                  i = 1;
                }
                else
                {
                  i = 0;
                }
              }
            }
          }
        }
      }
    } while (this.permanentFlags != null);
    if (this.availableFlags != null)
    {
      this.permanentFlags = new Flags(this.availableFlags);
      return;
    }
    this.permanentFlags = new Flags();
  }
  
  public Flags getAvailableFlags()
  {
    return this.availableFlags;
  }
  
  public int getFirst()
  {
    return this.first;
  }
  
  public long getHighestModSeq()
  {
    return this.highestModSeq;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public Flags getPermanentFlags()
  {
    return this.permanentFlags;
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
  
  public void setAvailableFlags(Flags paramFlags)
  {
    this.availableFlags = paramFlags;
  }
  
  public void setFirst(int paramInt)
  {
    this.first = paramInt;
  }
  
  public void setHighestModSeq(long paramLong)
  {
    this.highestModSeq = paramLong;
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setPermanentFlags(Flags paramFlags)
  {
    this.permanentFlags = paramFlags;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailboxInfo
 * JD-Core Version:    0.7.0.1
 */