package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.MoveItemStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class MoveMailResponse
  extends ActiveSyncResponse
{
  private ArrayList<String> destinationServerIdList = new ArrayList();
  private ArrayList<MoveItemStatus> moveItemStatusList = new ArrayList();
  private ArrayList<String> sourceServerIdList = new ArrayList();
  
  public MoveMailResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public ArrayList<String> getDestinationServerIdList()
  {
    return this.destinationServerIdList;
  }
  
  public int getErrorCode()
  {
    if (this.moveItemStatusList.size() > 0)
    {
      Iterator localIterator = this.moveItemStatusList.iterator();
      while (localIterator.hasNext())
      {
        MoveItemStatus localMoveItemStatus = (MoveItemStatus)localIterator.next();
        if (!localMoveItemStatus.isStatusOk()) {
          return localMoveItemStatus.getStatus();
        }
      }
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.moveItemStatusList.size() > 0)
    {
      Iterator localIterator = this.moveItemStatusList.iterator();
      while (localIterator.hasNext())
      {
        MoveItemStatus localMoveItemStatus = (MoveItemStatus)localIterator.next();
        if (!localMoveItemStatus.isStatusOk()) {
          return localMoveItemStatus.getStatusMsg();
        }
      }
    }
    return super.getErrorMsg();
  }
  
  public ArrayList<String> getSourceServerIdList()
  {
    return this.sourceServerIdList;
  }
  
  public boolean isOk()
  {
    if (this.moveItemStatusList.size() > 0)
    {
      Iterator localIterator = this.moveItemStatusList.iterator();
      while (localIterator.hasNext()) {
        if (!((MoveItemStatus)localIterator.next()).isStatusOk()) {
          return false;
        }
      }
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
      localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "MoveMail");
    } while (localObject1 == null);
    Object localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Response");
    int j = ((ArrayList)localObject1).size();
    int i = 0;
    if (i < j)
    {
      Object localObject2 = (Node)((ArrayList)localObject1).get(i);
      Object localObject3 = new MoveItemStatus(XmlDocumentHelper.getChildIntContent((Node)localObject2, "Status"));
      this.moveItemStatusList.add(localObject3);
      if (!((MoveItemStatus)localObject3).isStatusOk()) {}
      for (;;)
      {
        i += 1;
        break;
        localObject3 = XmlDocumentHelper.getChildText((Node)localObject2, "SrcMsgId");
        if (localObject3 != null)
        {
          localObject2 = XmlDocumentHelper.getChildText((Node)localObject2, "DstMsgId");
          if (localObject2 != null)
          {
            this.sourceServerIdList.add(localObject3);
            this.destinationServerIdList.add(localObject2);
          }
        }
      }
    }
    return true;
  }
  
  public void setDestinationServerIdList(ArrayList<String> paramArrayList)
  {
    this.destinationServerIdList = paramArrayList;
  }
  
  public void setSourceServerIdList(ArrayList<String> paramArrayList)
  {
    this.sourceServerIdList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.MoveMailResponse
 * JD-Core Version:    0.7.0.1
 */