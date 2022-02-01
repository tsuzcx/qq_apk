package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class IMAPArgument
{
  private ArrayList<Object> itemList = new ArrayList();
  
  private void astring(byte[] paramArrayOfByte, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    nastring(paramArrayOfByte, paramDataOutputStream, false);
  }
  
  private void nastring(byte[] paramArrayOfByte, DataOutputStream paramDataOutputStream, boolean paramBoolean)
    throws IOException
  {
    int m = paramArrayOfByte.length;
    if (m == 0) {
      paramBoolean = true;
    }
    int i = 0;
    int j = 0;
    label60:
    int k;
    if (i < m)
    {
      int n = paramArrayOfByte[i];
      if ((n == 0) || (n == 13) || (n == 10) || ((n & 0xFF) > 127)) {
        return;
      }
      if ((n != 42) && (n != 37) && (n != 40) && (n != 41) && (n != 123) && (n != 34) && (n != 92))
      {
        k = j;
        if ((n & 0xFF) > 32) {}
      }
      else
      {
        if ((n != 34) && (n != 92)) {
          break label317;
        }
        k = 1;
        paramBoolean = true;
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      boolean bool = paramBoolean;
      if (!paramBoolean)
      {
        bool = paramBoolean;
        if (paramArrayOfByte.length == 3) {
          if (paramArrayOfByte[0] != 78)
          {
            bool = paramBoolean;
            if (paramArrayOfByte[0] != 110) {}
          }
          else if (paramArrayOfByte[1] != 73)
          {
            bool = paramBoolean;
            if (paramArrayOfByte[1] != 105) {}
          }
          else if (paramArrayOfByte[2] != 76)
          {
            bool = paramBoolean;
            if (paramArrayOfByte[2] != 108) {}
          }
          else
          {
            bool = true;
          }
        }
      }
      if (bool) {
        paramDataOutputStream.write(34);
      }
      if (j != 0)
      {
        i = 0;
        while (i < m)
        {
          j = paramArrayOfByte[i];
          if ((j == 34) || (j == 92)) {
            paramDataOutputStream.write(92);
          }
          paramDataOutputStream.write(j);
          i += 1;
        }
      }
      paramDataOutputStream.write(paramArrayOfByte);
      if (!bool) {
        break label60;
      }
      paramDataOutputStream.write(34);
      return;
      label317:
      paramBoolean = true;
      k = j;
    }
  }
  
  private void nstring(byte[] paramArrayOfByte, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    if (paramArrayOfByte == null)
    {
      paramDataOutputStream.writeBytes("NIL");
      return;
    }
    nastring(paramArrayOfByte, paramDataOutputStream, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.itemList.size())
    {
      if (i > 0) {
        localStringBuilder.append(' ');
      }
      Object localObject = this.itemList.get(i);
      if ((localObject instanceof Atom)) {
        localStringBuilder.append(((Atom)localObject).string);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof String))
        {
          localStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof Number))
        {
          localStringBuilder.append(((Number)localObject).toString());
        }
        else if ((localObject instanceof AString))
        {
          localStringBuilder.append(new String(((AString)localObject).bytes));
        }
        else if ((localObject instanceof NString))
        {
          localStringBuilder.append(new String(((NString)localObject).bytes));
        }
        else if ((localObject instanceof IMAPArgument))
        {
          localStringBuilder.append('(');
          localStringBuilder.append(((IMAPArgument)localObject).toString());
          localStringBuilder.append(')');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      paramOutputStream = new DataOutputStream(paramOutputStream);
      int i = 0;
      if (i < this.itemList.size())
      {
        if (i > 0) {
          paramOutputStream.write(32);
        }
        Object localObject = this.itemList.get(i);
        if ((localObject instanceof Atom)) {
          paramOutputStream.writeBytes(((Atom)localObject).string);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof String))
          {
            paramOutputStream.write(ASCIIUtility.getBytes((String)localObject));
          }
          else if ((localObject instanceof Number))
          {
            paramOutputStream.writeBytes(((Number)localObject).toString());
          }
          else if ((localObject instanceof AString))
          {
            astring(((AString)localObject).bytes, paramOutputStream);
          }
          else if ((localObject instanceof NString))
          {
            nstring(((NString)localObject).bytes, paramOutputStream);
          }
          else if ((localObject instanceof IMAPArgument))
          {
            paramOutputStream.write(40);
            ((IMAPArgument)localObject).write(paramOutputStream);
            paramOutputStream.write(41);
          }
        }
      }
    }
  }
  
  public IMAPArgument writeArgument(IMAPArgument paramIMAPArgument)
  {
    this.itemList.add(paramIMAPArgument);
    return this;
  }
  
  public void writeAtom(String paramString)
  {
    this.itemList.add(new Atom(paramString));
  }
  
  public void writeAtomString(String paramString)
  {
    this.itemList.add(paramString);
  }
  
  public void writeString(String paramString)
  {
    this.itemList.add(new AString(ASCIIUtility.getBytes(paramString)));
  }
  
  class AString
  {
    byte[] bytes;
    
    AString(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
  }
  
  class Atom
  {
    String string;
    
    Atom(String paramString)
    {
      this.string = paramString;
    }
  }
  
  class NString
  {
    byte[] bytes;
    
    NString(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPArgument
 * JD-Core Version:    0.7.0.1
 */