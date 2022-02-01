package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.GetItemEstimateStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class GetItemEstimateResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private int estimate;
  private GetItemEstimateStatus getItemEstimateStatus;
  
  public GetItemEstimateResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.getItemEstimateStatus != null) {
      return this.getItemEstimateStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.getItemEstimateStatus != null) {
      return this.getItemEstimateStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public int getEstimate()
  {
    return this.estimate;
  }
  
  public GetItemEstimateStatus getGetItemEstimateStatus()
  {
    return this.getItemEstimateStatus;
  }
  
  public boolean isOk()
  {
    if (this.getItemEstimateStatus != null) {
      return this.getItemEstimateStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
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
            } while (!this.httpResponse.isOk());
            if (this.httpResponse.getContent() == null) {
              return true;
            }
            if (this.httpResponse.getContent().length == 0) {
              return true;
            }
            localObject = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
          } while (localObject == null);
          localObject = XmlDocumentHelper.getChildNode((Node)localObject, "GetItemEstimate");
        } while (localObject == null);
        this.commonStatus = new CommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject, "Status"));
      } while (!this.commonStatus.isStatusOk());
      Node localNode = XmlDocumentHelper.getChildNode((Node)localObject, "Response");
      if (localNode == null) {
        return true;
      }
      this.getItemEstimateStatus = new GetItemEstimateStatus(XmlDocumentHelper.getChildIntContent(localNode, "Status"));
    } while (!this.getItemEstimateStatus.isStatusOk());
    Object localObject = XmlDocumentHelper.getChildNode((Node)localObject, "Collection");
    if (localObject == null) {
      return true;
    }
    this.estimate = XmlDocumentHelper.getChildIntContent((Node)localObject, "Estimate");
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setEstimate(int paramInt)
  {
    this.estimate = paramInt;
  }
  
  public void setGetItemEstimateStatus(GetItemEstimateStatus paramGetItemEstimateStatus)
  {
    this.getItemEstimateStatus = paramGetItemEstimateStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.GetItemEstimateResponse
 * JD-Core Version:    0.7.0.1
 */