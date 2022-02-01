package com.tencent.moai.mailsdk.util.aswbxml;

import java.util.HashMap;
import java.util.Map;

public class ASWBXMLCodePage
{
  private String codePageNamespace = "";
  private String codePageXmlns = "";
  private Map<String, Byte> tagLookup = new HashMap();
  private Map<Byte, String> tokenLookup = new HashMap();
  
  public void addToken(byte paramByte, String paramString)
    throws Exception
  {
    this.tokenLookup.put(Byte.valueOf(paramByte), paramString);
    this.tagLookup.put(paramString, Byte.valueOf(paramByte));
  }
  
  public String getNamespace()
    throws Exception
  {
    return this.codePageNamespace;
  }
  
  public String getTag(byte paramByte)
    throws Exception
  {
    if (this.tokenLookup.containsKey(Byte.valueOf(paramByte))) {
      return (String)this.tokenLookup.get(Byte.valueOf(paramByte));
    }
    return null;
  }
  
  public byte getToken(String paramString)
    throws Exception
  {
    if (this.tagLookup.containsKey(paramString)) {
      return ((Byte)this.tagLookup.get(paramString)).byteValue();
    }
    return -1;
  }
  
  public String getXmlns()
    throws Exception
  {
    return this.codePageXmlns;
  }
  
  public void setNamespace(String paramString)
    throws Exception
  {
    this.codePageNamespace = paramString;
  }
  
  public void setXmlns(String paramString)
    throws Exception
  {
    this.codePageXmlns = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.aswbxml.ASWBXMLCodePage
 * JD-Core Version:    0.7.0.1
 */