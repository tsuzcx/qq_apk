package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class IMAPResponse
{
  private static String ASTRING_CHAR_DELIM = " (){%*\"\\";
  private static String ATOM_CHAR_DELIM = " (){%*\"\\]";
  public static final int BAD = 12;
  public static final int BYE = 16;
  public static final int CONTINUATION = 1;
  public static final int NO = 8;
  public static final int OK = 4;
  public static final int SYNTHETIC = 32;
  public static final int TAGGED = 2;
  public static final int TAG_MASK = 3;
  public static final int TYPE_MASK = 28;
  public static final int UNTAGGED = 3;
  protected byte[] buffer = null;
  protected String content;
  protected int index;
  protected int indexParse;
  protected InputStream inputStream;
  protected String key = null;
  protected int number;
  protected int size;
  protected String tag = null;
  protected int type = 0;
  
  public IMAPResponse(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
  }
  
  public IMAPResponse(String paramString)
  {
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      this.content = paramString;
      this.buffer = ASCIIUtility.getBytes(paramString);
      this.size = this.buffer.length;
      parse();
    }
  }
  
  private void parse()
  {
    this.index = 0;
    if (this.size == 0) {
      return;
    }
    if (this.buffer[this.index] == 43)
    {
      this.type |= 0x1;
      this.index += 1;
      return;
    }
    if (this.buffer[this.index] == 42)
    {
      this.type |= 0x3;
      this.index += 1;
    }
    for (;;)
    {
      int i = this.index;
      String str2 = readAtom();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (str1.equalsIgnoreCase("OK"))
      {
        this.type |= 0x4;
        label120:
        if ((isUnTagged()) && (!isOK()) && (!isNO()) && (!isBAD()) && (!isBYE())) {
          this.key = readAtom();
        }
      }
      try
      {
        this.number = Integer.parseInt(this.key);
        this.key = readAtom();
        label182:
        this.indexParse = this.index;
        return;
        if (this.buffer[this.index] != 65) {
          continue;
        }
        this.type |= 0x2;
        this.tag = readAtom();
        if (this.tag != null) {
          continue;
        }
        this.tag = "";
        continue;
        if (str1.equalsIgnoreCase("NO"))
        {
          this.type |= 0x8;
          break label120;
        }
        if (str1.equalsIgnoreCase("BAD"))
        {
          this.type |= 0xC;
          break label120;
        }
        if (str1.equalsIgnoreCase("BYE"))
        {
          this.type |= 0x10;
          break label120;
        }
        this.index = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label182;
      }
    }
  }
  
  private Object parseString(boolean paramBoolean1, boolean paramBoolean2)
  {
    skipSpaces();
    int i = this.buffer[this.index];
    int j;
    Object localObject;
    if (i == 34)
    {
      this.index += 1;
      j = this.index;
      i = this.index;
      while (this.index < this.size)
      {
        int k = this.buffer[this.index];
        if (k == 34) {
          break;
        }
        if (k == 92) {
          this.index += 1;
        }
        if (this.index != i) {
          this.buffer[i] = this.buffer[this.index];
        }
        i += 1;
        this.index += 1;
      }
      if (this.index >= this.size) {
        localObject = null;
      }
    }
    do
    {
      return localObject;
      this.index += 1;
      if (paramBoolean2) {
        return ASCIIUtility.toString(this.buffer, j, i);
      }
      return new ByteArray(this.buffer, j, i - j);
      if (i == 123)
      {
        i = this.index + 1;
        for (this.index = i; this.buffer[this.index] != 125; this.index += 1) {}
        try
        {
          i = ASCIIUtility.parseInt(this.buffer, i, this.index);
          this.index += 1;
          if (this.buffer[this.index] == 13) {
            this.index += 1;
          }
          if (this.buffer[this.index] == 10) {
            this.index += 1;
          }
          j = this.index;
          this.index = (j + i);
          if (paramBoolean2) {
            return ASCIIUtility.toString(this.buffer, j, i + j);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          return null;
        }
        return new ByteArray(this.buffer, j, i);
      }
      if (!paramBoolean1) {
        break;
      }
      i = this.index;
      String str = readDelimString(ASTRING_CHAR_DELIM);
    } while (paramBoolean2);
    return new ByteArray(this.buffer, i, this.index);
    if ((i == 78) || (i == 110))
    {
      this.index += 3;
      return null;
    }
    return null;
  }
  
  private String readDelimString(String paramString)
  {
    skipSpaces();
    if (this.index >= this.size) {
      return null;
    }
    int i = this.index;
    while (this.index < this.size)
    {
      int j = this.buffer[this.index];
      if ((j <= 32) || (paramString.indexOf((char)j) >= 0) || (j < 32) || (j == 127)) {
        break;
      }
      this.index += 1;
    }
    return ASCIIUtility.toString(this.buffer, i, this.index);
  }
  
  private ArrayList<String> readStringList(boolean paramBoolean)
  {
    skipSpaces();
    if (this.buffer[this.index] != 40) {
      return null;
    }
    this.index += 1;
    ArrayList localArrayList = new ArrayList();
    skipSpaces();
    Object localObject;
    if (peekByte() != 41)
    {
      int i;
      do
      {
        if (!paramBoolean) {
          break label107;
        }
        localObject = readAtomString();
        localArrayList.add(localObject);
        if (this.index >= this.size) {
          break;
        }
        localObject = this.buffer;
        i = this.index;
        this.index = (i + 1);
      } while (localObject[i] != 41);
    }
    for (;;)
    {
      return localArrayList;
      label107:
      localObject = readString();
      break;
      this.index += 1;
    }
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public InputStream getInputStream()
  {
    return this.inputStream;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public String getRest()
  {
    skipSpaces();
    return ASCIIUtility.toString(this.buffer, this.index, this.size);
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean isBAD()
  {
    return (this.type & 0x1C) == 12;
  }
  
  public boolean isBYE()
  {
    return (this.type & 0x1C) == 16;
  }
  
  public boolean isContinuation()
  {
    return (this.type & 0x3) == 1;
  }
  
  public boolean isNO()
  {
    return (this.type & 0x1C) == 8;
  }
  
  public boolean isOK()
  {
    return (this.type & 0x1C) == 4;
  }
  
  public boolean isTagged()
  {
    return (this.type & 0x3) == 2;
  }
  
  public boolean isUnTagged()
  {
    return (this.type & 0x3) == 3;
  }
  
  public boolean keyEquals(String paramString)
  {
    return (this.key != null) && (this.key.equalsIgnoreCase(paramString));
  }
  
  public byte peekByte()
  {
    if (this.index < this.size) {
      return this.buffer[this.index];
    }
    return 0;
  }
  
  public byte peekByte(int paramInt)
  {
    if (paramInt < this.size) {
      return this.buffer[paramInt];
    }
    return 0;
  }
  
  public String readAtom()
  {
    return readDelimString(ATOM_CHAR_DELIM);
  }
  
  public String readAtomString()
  {
    return (String)parseString(true, true);
  }
  
  public ArrayList<String> readAtomStringList()
  {
    return readStringList(true);
  }
  
  public byte readByte()
  {
    if (this.index < this.size)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.index;
      this.index = (i + 1);
      return arrayOfByte[i];
    }
    return 0;
  }
  
  public ByteArray readByteArray()
  {
    if (isContinuation())
    {
      skipSpaces();
      return new ByteArray(this.buffer, this.index, this.size - this.index);
    }
    return (ByteArray)parseString(false, false);
  }
  
  public ByteArrayInputStream readBytes()
  {
    ByteArray localByteArray = readByteArray();
    if (localByteArray != null) {
      return localByteArray.toByteArrayInputStream();
    }
    return null;
  }
  
  public long readLong()
  {
    skipSpaces();
    int i = this.index;
    while ((this.index < this.size) && (Character.isDigit((char)this.buffer[this.index]))) {
      this.index += 1;
    }
    if (this.index > i) {
      try
      {
        long l = ASCIIUtility.parseLong(this.buffer, i, this.index);
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return -1L;
  }
  
  public int readNumber()
  {
    skipSpaces();
    int i = this.index;
    while ((this.index < this.size) && (Character.isDigit((char)this.buffer[this.index]))) {
      this.index += 1;
    }
    if (this.index > i) {
      try
      {
        i = ASCIIUtility.parseInt(this.buffer, i, this.index);
        return i;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return -1;
  }
  
  public ArrayList<String> readSimpleList()
  {
    skipSpaces();
    if (this.buffer[this.index] != 40) {
      return null;
    }
    this.index += 1;
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = this.index; this.buffer[this.index] != 41; i = j)
    {
      j = i;
      if (this.buffer[this.index] == 32)
      {
        localArrayList.add(ASCIIUtility.toString(this.buffer, i, this.index));
        j = this.index + 1;
      }
      this.index += 1;
    }
    if (this.index > i) {
      localArrayList.add(ASCIIUtility.toString(this.buffer, i, this.index));
    }
    this.index += 1;
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public String readString()
  {
    return (String)parseString(false, true);
  }
  
  public String readString(char paramChar)
  {
    skipSpaces();
    if (this.index >= this.size) {
      return null;
    }
    int i = this.index;
    while ((this.index < this.size) && (this.buffer[this.index] != paramChar)) {
      this.index += 1;
    }
    return ASCIIUtility.toString(this.buffer, i, this.index);
  }
  
  public ArrayList<String> readStringList()
  {
    return readStringList(false);
  }
  
  public void reset()
  {
    this.index = this.indexParse;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void skip(int paramInt)
  {
    this.index += paramInt;
  }
  
  public void skipSpaces()
  {
    while ((this.index < this.size) && (this.buffer[this.index] == 32)) {
      this.index += 1;
    }
  }
  
  public void skipToken()
  {
    while ((this.index < this.size) && (this.buffer[this.index] != 32)) {
      this.index += 1;
    }
  }
  
  public String toString()
  {
    return ASCIIUtility.toString(this.buffer, 0, this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPResponse
 * JD-Core Version:    0.7.0.1
 */