package com.tencent.moai.mailsdk.protocol.mime;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.util.HeaderTokenizer;
import com.tencent.moai.mailsdk.util.HeaderTokenizer.Token;
import com.tencent.moai.mailsdk.util.ParamUtility;
import java.util.HashMap;

public class ContentType
{
  private HashMap<String, String> param = new HashMap();
  private String primaryType = "";
  private String subType = "";
  
  public ContentType(String paramString)
    throws MessageException
  {
    Object localObject = new HeaderTokenizer(paramString, "()<>@,;:\\\"\t []/?=");
    HeaderTokenizer.Token localToken = ((HeaderTokenizer)localObject).next();
    if (localToken.getType() != -1) {
      throw new MessageException(2, "In Content-Type string <" + paramString + ">, expected MIME type, got " + localToken.getValue());
    }
    this.primaryType = localToken.getValue();
    localToken = ((HeaderTokenizer)localObject).next();
    if ((char)localToken.getType() != '/') {
      throw new MessageException(2, "In Content-Type string <" + paramString + ">, expected '/', got " + localToken.getValue());
    }
    localToken = ((HeaderTokenizer)localObject).next();
    if (localToken.getType() != -1) {
      throw new MessageException(2, "In Content-Type string <" + paramString + ">, expected MIME subtype, got " + localToken.getValue());
    }
    this.subType = localToken.getValue();
    localObject = ((HeaderTokenizer)localObject).getRemainder();
    if (localObject != null) {}
    try
    {
      ParamUtility.parseParams(this.param, (String)localObject);
      return;
    }
    catch (MessageException localMessageException)
    {
      throw new MessageException(2, localMessageException.getDetailMessage() + ", content: " + paramString);
    }
  }
  
  public String getParam(String paramString)
  {
    if (this.param == null) {
      return null;
    }
    return (String)this.param.get(paramString);
  }
  
  public String getPrimaryType()
  {
    return this.primaryType;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
  
  public String getType()
  {
    return this.primaryType + "/" + this.subType;
  }
  
  public void setParam(String paramString1, String paramString2)
  {
    if (this.param == null) {
      this.param = new HashMap();
    }
    this.param.put(paramString1, paramString2);
  }
  
  public void setPrimaryType(String paramString)
  {
    this.primaryType = paramString;
  }
  
  public void setSubType(String paramString)
  {
    this.subType = paramString;
  }
  
  public String toString()
  {
    if ((this.primaryType == null) || (this.subType == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.primaryType).append("/").append(this.subType);
    if ((this.param != null) && (this.param.size() > 0)) {
      localStringBuilder.append(ParamUtility.paramToString(this.param, localStringBuilder.length() + 14));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.ContentType
 * JD-Core Version:    0.7.0.1
 */