package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.w3c.dom.Node;

public class FindFolderResponse
  extends ExchangeResponse
{
  private ArrayList<Folder> folderList;
  
  public FindFolderResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public ArrayList<Folder> filterFolder(ArrayList<Folder> paramArrayList, HashMap<String, String> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Folder localFolder = (Folder)paramArrayList.next();
      String str = localFolder.getRemoteId();
      if (str != null)
      {
        str = (String)paramHashMap.get(str);
        if (str == null)
        {
          localFolder.setType(6);
          localArrayList.add(localFolder);
        }
        else
        {
          label144:
          int i;
          switch (str.hashCode())
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            case 0: 
            default: 
              break;
            case 1: 
              localFolder.setType(3);
              localArrayList.add(localFolder);
              break;
              if (!str.equals("outbox")) {
                break label144;
              }
              i = 0;
              continue;
              if (!str.equals("deleteditems")) {
                break label144;
              }
              i = 1;
              continue;
              if (!str.equals("drafts")) {
                break label144;
              }
              i = 2;
              continue;
              if (!str.equals("inbox")) {
                break label144;
              }
              i = 3;
              continue;
              if (!str.equals("junkemail")) {
                break label144;
              }
              i = 4;
              continue;
              if (!str.equals("sentitems")) {
                break label144;
              }
              i = 5;
            }
          }
          localFolder.setType(2);
          localArrayList.add(localFolder);
          continue;
          localFolder.setType(1);
          localArrayList.add(localFolder);
          continue;
          localFolder.setType(5);
          localArrayList.add(localFolder);
          continue;
          localFolder.setType(4);
          localArrayList.add(localFolder);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Folder> getFolderList()
  {
    return this.folderList;
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
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return false;
                      } while (this.httpResponse.getContent() == null);
                      localObject1 = XmlDocumentHelper.bytesToXmlDoc(this.httpResponse.getContent());
                    } while (localObject1 == null);
                    localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Envelope");
                  } while (localObject1 == null);
                  localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Body");
                } while (localObject1 == null);
                localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "FindFolderResponse");
                if (localObject2 == null)
                {
                  localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Fault");
                  this.responseCode = XmlDocumentHelper.getChildTextByLocalName(XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "detail"), "ResponseCode");
                  localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "faultstring");
                  if (localObject1 != null)
                  {
                    ((Node)localObject1).getTextContent();
                    return false;
                  }
                  return false;
                }
                localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject2, "ResponseMessages");
              } while (localObject1 == null);
              localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "FindFolderResponseMessage");
            } while (localObject1 == null);
            this.responseCode = XmlDocumentHelper.getChildText((Node)localObject1, "m:ResponseCode");
          } while ((this.responseCode == null) || (!"NoError".equalsIgnoreCase(this.responseCode)));
          localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "RootFolder");
        } while (localObject1 == null);
        localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Folders");
      } while (localObject1 == null);
      localObject1 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "Folder");
    } while (localObject1 == null);
    this.folderList = new ArrayList();
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ExchangeXmlParser.getFolder((Node)((Iterator)localObject1).next());
      if ((localObject2 != null) && (((Folder)localObject2).getRemoteId() != null)) {
        this.folderList.add(localObject2);
      }
    }
    return true;
  }
  
  public void setFolderList(ArrayList<Folder> paramArrayList)
  {
    this.folderList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.FindFolderResponse
 * JD-Core Version:    0.7.0.1
 */