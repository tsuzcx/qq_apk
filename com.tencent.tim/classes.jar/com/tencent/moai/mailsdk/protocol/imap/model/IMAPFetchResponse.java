package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import java.util.ArrayList;

public class IMAPFetchResponse
  extends IMAPResponse
{
  private ArrayList<IMAPFetchItem> items = new ArrayList();
  private int msgNum;
  
  public IMAPFetchResponse(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    super(paramIMAPResponse.getContent());
    parse();
  }
  
  private boolean match(String paramString)
  {
    int k = paramString.length();
    int i = this.index;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Character.toUpperCase((char)this.buffer[i]) != paramString.charAt(j)) {
          return false;
        }
      }
      else
      {
        this.index += k;
        return true;
      }
      j += 1;
      i += 1;
    }
  }
  
  private boolean match(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    int i = this.index;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        if (Character.toUpperCase((char)this.buffer[i]) != paramArrayOfChar[j]) {
          return false;
        }
      }
      else
      {
        this.index += k;
        return true;
      }
      j += 1;
      i += 1;
    }
  }
  
  private void parse()
    throws MessageException
  {
    this.msgNum = getNumber();
    skipSpaces();
    getKey();
    skipSpaces();
    if (this.buffer[this.index] != 40) {
      throw new MessageException(2, "error in FETCH parsing, missing '(':" + getContent());
    }
    do
    {
      this.index += 1;
      IMAPFetchItem localIMAPFetchItem = parseFetchItem();
      if (localIMAPFetchItem != null) {
        this.items.add(localIMAPFetchItem);
      }
    } while ((this.buffer[this.index] != 41) && (this.index + 1 < this.size));
    this.index += 1;
  }
  
  private IMAPFetchItem parseFetchItem()
    throws MessageException
  {
    switch (this.buffer[this.index])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!match(IMAPEnvelop.name));
            return new IMAPEnvelop(this);
          } while (!match(IMAPFlags.name));
          return new IMAPFlags(this);
          if (match(IMAPBodyStructure.name)) {
            return new IMAPBodyStructure(this, null);
          }
        } while (!match(IMAPBody.name));
        if (this.buffer[this.index] == 91) {
          return new IMAPBody(this);
        }
        return new IMAPBodyStructure(this, null);
      } while (!match(IMAPRFC822Size.name));
      return new IMAPRFC822Size(this);
    } while (!match(IMAPUid.name));
    return new IMAPUid(this);
  }
  
  public <T extends IMAPFetchItem> T getItem(Class<T> paramClass)
  {
    int i = 0;
    while (i < this.items.size())
    {
      if (paramClass.isInstance(this.items.get(i))) {
        return (IMAPFetchItem)paramClass.cast(this.items.get(i));
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPFetchResponse
 * JD-Core Version:    0.7.0.1
 */