package com.tencent.moai.mailsdk.protocol.imap.model;

import android.util.Log;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;

public class IMAPBodyStructure
  implements IMAPFetchItem
{
  private static final String TAG = "IMAPBodyStructure";
  static final char[] name = { 66, 79, 68, 89, 83, 84, 82, 85, 67, 84, 85, 82, 69 };
  private ArrayList<IMAPBodyStructure> bodies = new ArrayList();
  private String bodyId;
  private String contentId;
  private String contentParam;
  private String contentSubtype;
  private String contentType;
  private String description;
  private String disposition;
  private String dispositionParam;
  private String encoding;
  private IMAPEnvelop envelope;
  private ArrayList<String> language = new ArrayList();
  private int lines = -1;
  private String md5;
  private long size = -1L;
  
  public IMAPBodyStructure() {}
  
  public IMAPBodyStructure(IMAPResponse paramIMAPResponse, String paramString)
    throws MessageException
  {
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.readByte() != 40) {
      throw new MessageException(2, "parse bodyStructure error missing (:" + paramIMAPResponse.getContent());
    }
    int i;
    label106:
    ArrayList localArrayList;
    if (StringUtility.isNullOrEmpty(paramString))
    {
      setBodyId("0");
      if (paramIMAPResponse.peekByte() != 40) {
        break label221;
      }
      i = 1;
      localArrayList = getBodies();
      if (!getBodyId().equals("0")) {
        break label191;
      }
    }
    label191:
    for (paramString = i + "";; paramString = getBodyId() + "." + i)
    {
      localArrayList.add(new IMAPBodyStructure(paramIMAPResponse, paramString));
      i += 1;
      paramIMAPResponse.skipSpaces();
      if (paramIMAPResponse.peekByte() == 40) {
        break label106;
      }
      parseMultiPart(paramIMAPResponse, null);
      return;
      setBodyId(paramString);
      break;
    }
    label221:
    if (paramIMAPResponse.peekByte() == 41) {
      throw new MessageException(2, "parse bodyStructure error:" + paramIMAPResponse.getContent());
    }
    paramString = paramIMAPResponse.readString();
    if (paramString.equalsIgnoreCase(MimeDefine.MULTIPART))
    {
      parseMultiPart(paramIMAPResponse, null);
      return;
    }
    if (isMultiSubType(paramString))
    {
      parseMultiPart(paramIMAPResponse, paramString);
      return;
    }
    parseSinglePart(paramIMAPResponse, paramString);
  }
  
  public IMAPBodyStructure(String paramString1, String paramString2, IMAPResponse paramIMAPResponse)
  {
    setBodyId(paramString2);
    try
    {
      parseMultiPart(paramIMAPResponse, paramString1);
      return;
    }
    catch (MessageException paramString1)
    {
      Logger.log(6, "IMAPBodyStructure", "parse message multiPart error:" + Log.getStackTraceString(paramString1));
    }
  }
  
  private boolean isMultiSubType(String paramString)
  {
    return (!StringUtility.isNullOrEmpty(paramString)) && ((paramString.equalsIgnoreCase(MimeDefine.MIXED)) || (paramString.equalsIgnoreCase(MimeDefine.RELATED)) || (paramString.equalsIgnoreCase(MimeDefine.DIGEST)) || (paramString.equalsIgnoreCase(MimeDefine.ALTERNATIVE)));
  }
  
  private void parseBodyExtension(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if (i == 40)
    {
      paramIMAPResponse.skip(1);
      do
      {
        parseBodyExtension(paramIMAPResponse);
      } while (paramIMAPResponse.readByte() != 41);
      return;
    }
    if (Character.isDigit((char)i))
    {
      paramIMAPResponse.readNumber();
      return;
    }
    paramIMAPResponse.readString();
  }
  
  private void parseDescription(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if ((i == 34) || (i == 78) || (i == 110)) {
      setDescription(paramIMAPResponse.readString());
    }
    do
    {
      return;
      if (i != 123) {
        break;
      }
      paramIMAPResponse.skip(1);
      i = paramIMAPResponse.readNumber();
    } while ((paramIMAPResponse.peekByte() != 125) || (i <= 0));
    paramIMAPResponse.skip(1);
    if (paramIMAPResponse.peekByte() == 13)
    {
      paramIMAPResponse.skip(1);
      if (paramIMAPResponse.peekByte() == 10) {
        paramIMAPResponse.skip(1);
      }
    }
    int j = paramIMAPResponse.getIndex();
    setDescription(paramIMAPResponse.getContent().substring(j, j + i));
    paramIMAPResponse.setIndex(i + j);
    return;
    setDescription(paramIMAPResponse.readAtom());
  }
  
  private void parseDisposition(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    String str = paramIMAPResponse.readString();
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.peekByte() == 40)
    {
      setDisposition(str);
      setDispositionParam(parseParams(paramIMAPResponse));
      if (paramIMAPResponse.readByte() != 41) {
        throw new MessageException(2, "parse bodyStructure error missing ) at end of disposition:" + paramIMAPResponse.getContent());
      }
    }
    else
    {
      if (str != null) {
        break label102;
      }
    }
    label102:
    for (int i = 3;; i = str.length() + 2)
    {
      paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() - 1 - i - 1);
      setDispositionParam(parseParams(paramIMAPResponse));
      return;
    }
  }
  
  private void parseEncoding(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if ((i == 34) || (i == 78) || (i == 110))
    {
      setEncoding(paramIMAPResponse.readString());
      if ((getEncoding() != null) && (getEncoding().equalsIgnoreCase("NIL"))) {
        setEncoding(null);
      }
      return;
    }
    setEncoding(paramIMAPResponse.readAtom());
  }
  
  private void parseLine(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if ((i == 110) || (i == 78))
    {
      setLines(0);
      paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() + 3);
      return;
    }
    setLines(paramIMAPResponse.readNumber());
  }
  
  private void parseMessageRfcBodies(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if ((i == 78) || (i == 110))
    {
      paramIMAPResponse.skip(3);
      return;
    }
    if (i == 40)
    {
      if (paramIMAPResponse.getContent().charAt(paramIMAPResponse.getIndex() + 1) == ')')
      {
        paramIMAPResponse.skip(2);
        return;
      }
      getBodies().add(new IMAPBodyStructure(paramIMAPResponse, getBodyId()));
      return;
    }
    if (i == 34)
    {
      String str = paramIMAPResponse.readString();
      if (isMultiSubType(str))
      {
        getBodies().add(new IMAPBodyStructure(str, getBodyId(), paramIMAPResponse));
        return;
      }
      Logger.log(6, "IMAPBodyStructure", "unknown message string:" + paramIMAPResponse.content);
      return;
    }
    Logger.log(6, "IMAPBodyStructure", "unknown message char:" + paramIMAPResponse.content);
  }
  
  private void parseMultiPart(IMAPResponse paramIMAPResponse, String paramString)
    throws MessageException
  {
    setContentType(MimeDefine.MULTIPART);
    String str = paramString;
    if (paramString == null) {
      str = paramIMAPResponse.readString();
    }
    setContentSubtype(str);
    if (paramIMAPResponse.readByte() == 41) {}
    for (;;)
    {
      return;
      setContentParam(parseParams(paramIMAPResponse));
      if (paramIMAPResponse.readByte() != 41)
      {
        int i = paramIMAPResponse.readByte();
        if (i == 40) {
          parseDisposition(paramIMAPResponse);
        }
        for (;;)
        {
          i = paramIMAPResponse.readByte();
          if (i == 41) {
            break;
          }
          if (i == 32) {
            break label216;
          }
          throw new MessageException(2, "parse bodyStructure error missing space after disposition:" + paramIMAPResponse.getContent());
          if ((i == 78) || (i == 110))
          {
            paramIMAPResponse.skip(2);
          }
          else if (i == 34)
          {
            paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() - 1);
            setDescription(paramIMAPResponse.readString());
          }
          else
          {
            paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() - 1);
            setDescription(paramIMAPResponse.readAtom());
            Logger.log(4, "IMAPBodyStructure", "make sure it is multi atom string:" + paramIMAPResponse.getContent());
          }
        }
        label216:
        if (paramIMAPResponse.peekByte() == 40) {
          setLanguage(paramIMAPResponse.readStringList());
        }
        while (paramIMAPResponse.readByte() == 32)
        {
          parseBodyExtension(paramIMAPResponse);
          continue;
          paramString = paramIMAPResponse.readString();
          if (paramString != null) {
            getLanguage().add(paramString);
          }
        }
      }
    }
  }
  
  private String parseParams(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.readByte();
    if (i == 40)
    {
      int j = 0;
      int k = paramIMAPResponse.getIndex();
      i = 1;
      while (i > 0)
      {
        int m = paramIMAPResponse.readByte();
        if (m == 34)
        {
          if (j > 0) {
            j -= 1;
          } else {
            j += 1;
          }
        }
        else if ((m == 40) && (j == 0))
        {
          i += 1;
        }
        else if ((m == 41) && (j == 0))
        {
          i -= 1;
        }
        else if ((m == 32) && (paramIMAPResponse.peekByte() == 123) && (j == 0))
        {
          paramIMAPResponse.skip(1);
          m = paramIMAPResponse.readNumber();
          if ((paramIMAPResponse.peekByte() == 125) && (m > 0))
          {
            paramIMAPResponse.skip(1);
            if (paramIMAPResponse.peekByte() == 13)
            {
              paramIMAPResponse.skip(1);
              if (paramIMAPResponse.peekByte() == 10) {
                paramIMAPResponse.skip(1);
              }
            }
            paramIMAPResponse.setIndex(m + paramIMAPResponse.getIndex());
          }
        }
        else if ((m != 92) || (paramIMAPResponse.readByte() != 34)) {}
      }
      if (paramIMAPResponse.getIndex() - 1 > k) {
        return paramIMAPResponse.getContent().substring(k, paramIMAPResponse.getIndex() - 1);
      }
    }
    else if ((i == 110) || (i == 78))
    {
      paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() + 2);
    }
    return "";
  }
  
  private void parseSinglePart(IMAPResponse paramIMAPResponse, String paramString)
    throws MessageException
  {
    setContentType(paramString);
    setContentSubtype(paramIMAPResponse.readString());
    if (getContentType() == null)
    {
      setContentType(MimeDefine.APPLICATION);
      setContentSubtype(MimeDefine.OCTET_STREAM);
    }
    setContentParam(parseParams(paramIMAPResponse));
    String str = paramIMAPResponse.readString();
    paramString = str;
    if (str != null) {
      paramString = str.trim();
    }
    setContentId(paramString);
    parseDescription(paramIMAPResponse);
    parseEncoding(paramIMAPResponse);
    parseSize(paramIMAPResponse);
    if (getSize() < 0L) {
      throw new MessageException(2, "parse bodyStructure error bad size element:" + paramIMAPResponse.getContent());
    }
    if ((getContentType().equalsIgnoreCase(MimeDefine.TEXT)) && ((getContentSubtype().equalsIgnoreCase(MimeDefine.PLAIN)) || (getContentSubtype().equalsIgnoreCase(MimeDefine.HTML))))
    {
      parseLine(paramIMAPResponse);
      if (getLines() < 0) {
        throw new MessageException(2, "parse bodyStructure error bad lines element:" + paramIMAPResponse.getContent());
      }
    }
    else
    {
      if ((!getContentType().equalsIgnoreCase(MimeDefine.MESSAGE)) || (!getContentSubtype().equalsIgnoreCase(MimeDefine.RFC))) {
        break label350;
      }
      paramIMAPResponse.skipSpaces();
      if (paramIMAPResponse.peekByte() == 40)
      {
        setEnvelope(new IMAPEnvelop(paramIMAPResponse));
        parseMessageRfcBodies(paramIMAPResponse);
        if (paramIMAPResponse.peekByte() != 41)
        {
          parseLine(paramIMAPResponse);
          if (getLines() < 0) {
            throw new MessageException(2, "parse bodyStructure error bad lines element:" + paramIMAPResponse.getContent());
          }
        }
      }
      else if (Character.isDigit((char)paramIMAPResponse.peekByte()))
      {
        setLines(paramIMAPResponse.readNumber());
      }
    }
    if (paramIMAPResponse.peekByte() == 41) {
      paramIMAPResponse.readByte();
    }
    label419:
    label557:
    label559:
    label578:
    for (;;)
    {
      return;
      label350:
      paramIMAPResponse.skipSpaces();
      if (!Character.isDigit((char)paramIMAPResponse.peekByte())) {
        break;
      }
      setLines(paramIMAPResponse.readNumber());
      break;
      setMd5(paramIMAPResponse.readString());
      if (paramIMAPResponse.peekByte() == 41)
      {
        paramIMAPResponse.readByte();
        return;
      }
      paramIMAPResponse.skipSpaces();
      int i = paramIMAPResponse.readByte();
      if (i == 40)
      {
        parseDisposition(paramIMAPResponse);
        if (paramIMAPResponse.readByte() == 41) {
          break label557;
        }
        if (paramIMAPResponse.peekByte() != 40) {
          break label559;
        }
        setLanguage(paramIMAPResponse.readStringList());
      }
      for (;;)
      {
        if (paramIMAPResponse.readByte() != 32) {
          break label578;
        }
        parseBodyExtension(paramIMAPResponse);
        continue;
        if ((i == 78) || (i == 110))
        {
          paramIMAPResponse.skip(2);
          break label419;
        }
        if (i == 34)
        {
          paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() - 1);
          setDescription(paramIMAPResponse.readString());
          break label419;
        }
        paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() - 1);
        setDescription(paramIMAPResponse.readAtom());
        Logger.log(4, "IMAPBodyStructure", "make sure it is single atom string:" + paramIMAPResponse.getContent());
        break label419;
        break;
        paramString = paramIMAPResponse.readString();
        if (paramString != null) {
          getLanguage().add(paramString);
        }
      }
    }
  }
  
  private void parseSize(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    int i = paramIMAPResponse.peekByte();
    if ((i == 110) || (i == 78))
    {
      setSize(0L);
      paramIMAPResponse.setIndex(paramIMAPResponse.getIndex() + 3);
      return;
    }
    setSize(paramIMAPResponse.readNumber());
  }
  
  public ArrayList<IMAPBodyStructure> getBodies()
  {
    return this.bodies;
  }
  
  public String getBodyId()
  {
    return this.bodyId;
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  public String getContentParam()
  {
    return this.contentParam;
  }
  
  public String getContentSubtype()
  {
    return this.contentSubtype;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getDisposition()
  {
    return this.disposition;
  }
  
  public String getDispositionParam()
  {
    return this.dispositionParam;
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public IMAPEnvelop getEnvelope()
  {
    return this.envelope;
  }
  
  public ArrayList<String> getLanguage()
  {
    return this.language;
  }
  
  public int getLines()
  {
    return this.lines;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public boolean isMessageRfc()
  {
    return (!StringUtility.isNullOrEmpty(this.contentType)) && (!StringUtility.isNullOrEmpty(this.contentSubtype)) && (this.contentType.equalsIgnoreCase(MimeDefine.MESSAGE)) && (this.contentSubtype.equalsIgnoreCase(MimeDefine.RFC));
  }
  
  public void setBodies(ArrayList<IMAPBodyStructure> paramArrayList)
  {
    this.bodies = paramArrayList;
  }
  
  public void setBodyId(String paramString)
  {
    this.bodyId = paramString;
  }
  
  public void setContentId(String paramString)
  {
    this.contentId = paramString;
  }
  
  public void setContentParam(String paramString)
  {
    this.contentParam = paramString;
  }
  
  public void setContentSubtype(String paramString)
  {
    this.contentSubtype = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setDisposition(String paramString)
  {
    this.disposition = paramString;
  }
  
  public void setDispositionParam(String paramString)
  {
    this.dispositionParam = paramString;
  }
  
  public void setEncoding(String paramString)
  {
    this.encoding = paramString;
  }
  
  public void setEnvelope(IMAPEnvelop paramIMAPEnvelop)
  {
    this.envelope = paramIMAPEnvelop;
  }
  
  public void setLanguage(ArrayList<String> paramArrayList)
  {
    this.language = paramArrayList;
  }
  
  public void setLines(int paramInt)
  {
    this.lines = paramInt;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public String toString()
  {
    return "{bodyId:" + this.bodyId + ";contentType:" + this.contentType + ";contentSubType:" + this.contentSubtype + ";encoding:" + this.encoding + ";lines:" + this.lines + ";size:" + this.size + ";contentId:" + this.contentId + ";md5:" + this.md5 + ";description:" + this.description + ";disposition:" + this.disposition + ";contentParam:" + this.contentParam + ";dispositionParam:" + this.dispositionParam + ";children size:" + this.bodies.size() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure
 * JD-Core Version:    0.7.0.1
 */