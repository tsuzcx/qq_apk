package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.ProvisionCommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.ProvisionStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class PolicyKeyResponse
  extends ActiveSyncResponse
{
  private String policyKey;
  private ProvisionCommonStatus provisionCommonStatus;
  private ProvisionStatus provisionStatus;
  
  public PolicyKeyResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public int getErrorCode()
  {
    if (this.provisionStatus != null) {
      return this.provisionStatus.getStatus();
    }
    if (this.provisionCommonStatus != null) {
      return this.provisionCommonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.provisionStatus != null) {
      return this.provisionStatus.getStatusMsg();
    }
    if (this.provisionCommonStatus != null) {
      return this.provisionCommonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public String getPolicyKey()
  {
    return this.policyKey;
  }
  
  public ProvisionCommonStatus getProvisionCommonStatus()
  {
    return this.provisionCommonStatus;
  }
  
  public ProvisionStatus getProvisionStatus()
  {
    return this.provisionStatus;
  }
  
  public boolean isOk()
  {
    if (this.provisionCommonStatus == null) {}
    while ((this.provisionStatus == null) || (!this.provisionCommonStatus.isStatusOk()) || (!this.provisionStatus.isStatusOk())) {
      return false;
    }
    return true;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    do
    {
      Object localObject;
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
                do
                {
                  do
                  {
                    return false;
                  } while ((!this.httpResponse.isOk()) || (this.httpResponse.getContent() == null) || (this.httpResponse.getContent().length == 0));
                  localObject = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
                } while (localObject == null);
                localObject = XmlDocumentHelper.getChildNode((Node)localObject, "Provision");
              } while (localObject == null);
              this.provisionCommonStatus = new ProvisionCommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject, "Status"));
            } while (!this.provisionCommonStatus.isStatusOk());
            localObject = XmlDocumentHelper.getChildNode((Node)localObject, "Policies");
          } while (localObject == null);
          localObject = XmlDocumentHelper.getChildNode((Node)localObject, "Policy");
        } while (localObject == null);
        this.provisionStatus = new ProvisionStatus(XmlDocumentHelper.getChildIntContent((Node)localObject, "Status"));
      } while (!this.provisionStatus.isStatusOk());
      this.policyKey = XmlDocumentHelper.getChildText((Node)localObject, "PolicyKey");
    } while (this.policyKey == null);
    return true;
  }
  
  public void setPolicyKey(String paramString)
  {
    this.policyKey = paramString;
  }
  
  public void setProvisionCommonStatus(ProvisionCommonStatus paramProvisionCommonStatus)
  {
    this.provisionCommonStatus = paramProvisionCommonStatus;
  }
  
  public void setProvisionStatus(ProvisionStatus paramProvisionStatus)
  {
    this.provisionStatus = paramProvisionStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.PolicyKeyResponse
 * JD-Core Version:    0.7.0.1
 */