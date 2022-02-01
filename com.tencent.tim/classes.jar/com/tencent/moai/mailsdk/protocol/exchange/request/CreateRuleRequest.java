package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule.Actions;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule.Conditions;
import com.tencent.moai.mailsdk.util.StringUtility;
import java.util.ArrayList;
import java.util.Iterator;

public class CreateRuleRequest
  extends ExchangeRequest
{
  private ArrayList<ExchangeRule> exchangeRuleList;
  
  public CreateRuleRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "UpdateInboxRules");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:UpdateInboxRules>");
    localStringBuilder.append("<m:RemoveOutlookRuleBlob>true</m:RemoveOutlookRuleBlob>");
    localStringBuilder.append("<m:Operations>");
    Iterator localIterator = this.exchangeRuleList.iterator();
    if (localIterator.hasNext())
    {
      ExchangeRule localExchangeRule = (ExchangeRule)localIterator.next();
      localStringBuilder.append("<t:CreateRuleOperation>");
      localStringBuilder.append("<t:Rule>");
      localStringBuilder.append("<t:DisplayName>").append(localExchangeRule.getDisplayName()).append("</t:DisplayName>");
      localStringBuilder.append("<t:Priority>").append(localExchangeRule.getPriority()).append("</t:Priority>");
      localStringBuilder.append("<t:IsEnabled>").append(localExchangeRule.isEnabled()).append("</t:IsEnabled>");
      localStringBuilder.append("<t:IsInError>false</t:IsInError>");
      if (localExchangeRule.getConditions() != null)
      {
        localStringBuilder.append("<t:Conditions>");
        if (!StringUtility.isNullOrEmpty(localExchangeRule.getConditions().getSender()))
        {
          if (!localExchangeRule.getConditions().getSender().contains("@")) {
            break label575;
          }
          localStringBuilder.append("<t:FromAddresses>");
          localStringBuilder.append("<t:Address>");
          localStringBuilder.append("<t:EmailAddress>").append(localExchangeRule.getConditions().getSender()).append("</t:EmailAddress>");
          localStringBuilder.append("</t:Address>");
          localStringBuilder.append("</t:FromAddresses>");
        }
        label271:
        if (!StringUtility.isNullOrEmpty(localExchangeRule.getConditions().getTo()))
        {
          if (!localExchangeRule.getConditions().getSender().contains("@")) {
            break label614;
          }
          localStringBuilder.append("<t:SentToAddresses>");
          localStringBuilder.append("<t:Address>");
          localStringBuilder.append("<t:EmailAddress>").append(localExchangeRule.getConditions().getTo()).append("</t:EmailAddress>");
          localStringBuilder.append("</t:Address>");
          localStringBuilder.append("</t:SentToAddresses>");
        }
      }
      for (;;)
      {
        if (!StringUtility.isNullOrEmpty(localExchangeRule.getConditions().getSubject()))
        {
          localStringBuilder.append("<t:ContainsSubjectStrings>");
          localStringBuilder.append("<t:String>").append(localExchangeRule.getConditions().getSubject()).append("</t:String>");
          localStringBuilder.append("</t:ContainsSubjectStrings>");
        }
        localStringBuilder.append("</t:Conditions>");
        if (localExchangeRule.getActions() != null)
        {
          localStringBuilder.append("<t:Actions>");
          localStringBuilder.append("<t:MoveToFolder>");
          localStringBuilder.append("<t:FolderId Id=\"").append(localExchangeRule.getActions().getDesFolderId_()).append("\"/>");
          localStringBuilder.append("</t:MoveToFolder>");
          if (localExchangeRule.getActions().isStopSubsequentRules()) {
            localStringBuilder.append("<t:StopProcessingRules>").append(localExchangeRule.getActions().isStopSubsequentRules()).append("</t:StopProcessingRules>");
          }
          if (localExchangeRule.getActions().isMarkAsRead()) {
            localStringBuilder.append("<t:MarkAsRead>").append(localExchangeRule.getActions().isMarkAsRead()).append("</t:MarkAsRead>");
          }
          if (localExchangeRule.getActions().isSoftDeleteMail()) {
            localStringBuilder.append("<t:Delete>").append(localExchangeRule.getActions().isSoftDeleteMail()).append("</t:Delete>");
          }
          localStringBuilder.append("</t:Actions>");
        }
        localStringBuilder.append("</t:Rule>");
        localStringBuilder.append("</t:CreateRuleOperation>");
        break;
        label575:
        localStringBuilder.append("<t:ContainsSenderStrings>");
        localStringBuilder.append("<t:String>").append(localExchangeRule.getConditions().getSender()).append("</t:String>");
        localStringBuilder.append("</t:ContainsSenderStrings>");
        break label271;
        label614:
        localStringBuilder.append("<t:ContainsRecipientStrings>");
        localStringBuilder.append("<t:String>").append(localExchangeRule.getConditions().getTo()).append("</t:String>");
        localStringBuilder.append("</t:ContainsRecipientStrings>");
      }
    }
    localStringBuilder.append("</m:Operations>");
    localStringBuilder.append("</m:UpdateInboxRules>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public void setExchangeRules(ArrayList<ExchangeRule> paramArrayList)
  {
    this.exchangeRuleList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.CreateRuleRequest
 * JD-Core Version:    0.7.0.1
 */