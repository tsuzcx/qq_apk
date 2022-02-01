package com.tencent.moai.mailsdk.protocol.exchange.request;

import android.util.Base64OutputStream;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ItemCreateRequest
  extends ExchangeRequest
{
  private String itemId;
  private MimeMessage mimeMessage;
  private String tmpFilePath;
  
  public ItemCreateRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "CreateItem");
  }
  
  public File buildCmdDataFile()
  {
    try
    {
      Object localObject1 = new FileOutputStream(new File(this.tmpFilePath));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      ((StringBuilder)localObject2).append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
      ((StringBuilder)localObject2).append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
      ((StringBuilder)localObject2).append("<s:Body>");
      ((StringBuilder)localObject2).append("<m:CreateItem MessageDisposition=\"SendAndSaveCopy\">");
      ((StringBuilder)localObject2).append("<m:SavedItemFolderId>");
      ((StringBuilder)localObject2).append("<t:DistinguishedFolderId Id=\"sentitems\"/>");
      ((StringBuilder)localObject2).append("</m:SavedItemFolderId>");
      ((StringBuilder)localObject2).append("<m:Items>");
      ((StringBuilder)localObject2).append("<m:ItemId>").append(this.itemId).append("</m:ItemId>");
      ((StringBuilder)localObject2).append("<t:Message>");
      ((StringBuilder)localObject2).append("<t:ItemClass>IPM.Note</t:ItemClass>");
      ((StringBuilder)localObject2).append("<t:MimeContent><![CDATA[");
      ((OutputStream)localObject1).write(((StringBuilder)localObject2).toString().getBytes());
      ((OutputStream)localObject1).flush();
      localObject2 = new Base64OutputStream((OutputStream)localObject1, 4);
      this.mimeMessage.write((OutputStream)localObject2, null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("]]></t:MimeContent>");
      ((StringBuilder)localObject2).append("</t:Message>");
      ((StringBuilder)localObject2).append("</m:Items>");
      ((StringBuilder)localObject2).append("</m:CreateItem>");
      ((StringBuilder)localObject2).append("</s:Body>");
      ((StringBuilder)localObject2).append("</s:Envelope>");
      ((OutputStream)localObject1).write(((StringBuilder)localObject2).toString().getBytes());
      ((OutputStream)localObject1).flush();
      ((OutputStream)localObject1).close();
      localObject1 = new File(this.tmpFilePath);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String getItemId()
  {
    return this.itemId;
  }
  
  public MimeMessage getMimeMessage()
  {
    return this.mimeMessage;
  }
  
  public String getTmpFilePath()
  {
    return this.tmpFilePath;
  }
  
  public void setItemId(String paramString)
  {
    this.itemId = paramString;
  }
  
  public void setMimeMessage(MimeMessage paramMimeMessage)
  {
    this.mimeMessage = paramMimeMessage;
  }
  
  public void setTmpFilePath(String paramString)
  {
    this.tmpFilePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.ItemCreateRequest
 * JD-Core Version:    0.7.0.1
 */