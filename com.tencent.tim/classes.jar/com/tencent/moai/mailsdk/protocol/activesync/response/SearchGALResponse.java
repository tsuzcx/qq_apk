package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SearchGALStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class SearchGALResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private ArrayList<Contact> contactList = new ArrayList();
  private SearchGALStatus searchGALStatus;
  
  public SearchGALResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public ArrayList<Contact> getContactList()
  {
    return this.contactList;
  }
  
  public int getErrorCode()
  {
    if (this.searchGALStatus != null) {
      return this.searchGALStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.searchGALStatus != null) {
      return this.searchGALStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public SearchGALStatus getSearchGALStatus()
  {
    return this.searchGALStatus;
  }
  
  public boolean isOk()
  {
    if (this.searchGALStatus != null) {
      return this.searchGALStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    Object localObject2;
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
        } while ((!this.commonStatus.isStatusOk()) || (XmlDocumentHelper.getChildNode((Node)localObject1, "Responses") == null));
        localObject2 = XmlDocumentHelper.getChildNode((Node)localObject1, "Store");
      } while (localObject2 == null);
      this.searchGALStatus = new SearchGALStatus(XmlDocumentHelper.getChildIntContent((Node)localObject2, "Status"));
    } while (!this.searchGALStatus.isStatusOk());
    Object localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Result");
    int j = ((ArrayList)localObject1).size();
    int i = 0;
    if (i < j)
    {
      Object localObject3 = XmlDocumentHelper.getChildNode((Node)((ArrayList)localObject1).get(i), "Properties");
      localObject2 = XmlDocumentHelper.getChildText((Node)localObject3, "EmailAddress");
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject3 = XmlDocumentHelper.getChildText((Node)localObject3, "DisplayName");
        if (localObject3 != null) {
          this.contactList.add(new Contact((String)localObject2, (String)localObject3));
        }
      }
    }
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setContactList(ArrayList<Contact> paramArrayList)
  {
    this.contactList = paramArrayList;
  }
  
  public void setSearchGALStatus(SearchGALStatus paramSearchGALStatus)
  {
    this.searchGALStatus = paramSearchGALStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SearchGALResponse
 * JD-Core Version:    0.7.0.1
 */