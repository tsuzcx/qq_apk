package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncMailParser;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SearchMailStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class SearchMailResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private ArrayList<Mail> searchMailList = new ArrayList();
  private SearchMailStatus searchMailStatus;
  private int totalCount;
  
  public SearchMailResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.searchMailStatus != null) {
      return this.searchMailStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.searchMailStatus != null) {
      return this.searchMailStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public ArrayList<Mail> getSearchMailList()
  {
    return this.searchMailList;
  }
  
  public SearchMailStatus getSearchMailStatus()
  {
    return this.searchMailStatus;
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public boolean isOk()
  {
    if (this.searchMailStatus != null) {
      return this.searchMailStatus.isStatusOk();
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
                localObject1 = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
              } while (localObject1 == null);
              localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Search");
            } while (localObject1 == null);
            this.commonStatus = new CommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject1, "Status"));
          } while (!this.commonStatus.isStatusOk());
          localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Response");
        } while (localObject1 == null);
        localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Store");
      } while (localObject1 == null);
      this.searchMailStatus = new SearchMailStatus(XmlDocumentHelper.getChildIntContent((Node)localObject1, "Status"));
    } while (!this.searchMailStatus.isStatusOk());
    this.totalCount = XmlDocumentHelper.getChildIntContent((Node)localObject1, "Total");
    Object localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Result");
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      Object localObject2 = (Node)((ArrayList)localObject1).get(i);
      String str = XmlDocumentHelper.getChildText((Node)localObject2, "LongId");
      localObject2 = ActiveSyncMailParser.getMail(XmlDocumentHelper.getChildNode((Node)localObject2, "Properties"));
      ((Mail)localObject2).setRemoteId(str);
      this.searchMailList.add(localObject2);
      i += 1;
    }
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setSearchMailList(ArrayList<Mail> paramArrayList)
  {
    this.searchMailList = paramArrayList;
  }
  
  public void setSearchMailStatus(SearchMailStatus paramSearchMailStatus)
  {
    this.searchMailStatus = paramSearchMailStatus;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.totalCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SearchMailResponse
 * JD-Core Version:    0.7.0.1
 */