package com.tencent.moai.mailsdk.protocol.mime;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.util.HeaderTokenizer;
import com.tencent.moai.mailsdk.util.HeaderTokenizer.Token;
import com.tencent.moai.mailsdk.util.ParamUtility;
import java.util.HashMap;

public class ContentDisposition
{
  private String disposition;
  private HashMap<String, String> param = new HashMap();
  
  public ContentDisposition(String paramString)
    throws MessageException
  {
    Object localObject = new HeaderTokenizer(paramString, "()<>@,;:\\\"\t []/?=");
    HeaderTokenizer.Token localToken = ((HeaderTokenizer)localObject).next();
    if (localToken.getType() != -1) {
      throw new MessageException(2, "Expected disposition, got " + localToken.getValue());
    }
    this.disposition = localToken.getValue();
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
  
  public String getDisposition()
  {
    return this.disposition;
  }
  
  public String getParam(String paramString)
  {
    if (this.param == null) {
      return null;
    }
    return (String)this.param.get(paramString);
  }
  
  public void setDisposition(String paramString)
  {
    this.disposition = paramString;
  }
  
  public void setParam(String paramString1, String paramString2)
  {
    if (this.param == null) {
      this.param = new HashMap();
    }
    this.param.put(paramString1, paramString2);
  }
  
  public String toString()
  {
    if (this.disposition == null) {
      return "";
    }
    if (this.param == null) {
      return this.disposition;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.disposition);
    if ((this.param != null) && (this.param.size() > 0)) {
      localStringBuilder.append(ParamUtility.paramToString(this.param, localStringBuilder.length() + 21));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.ContentDisposition
 * JD-Core Version:    0.7.0.1
 */