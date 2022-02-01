package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.FolderSyncStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class FolderSyncResponse
  extends ActiveSyncResponse
{
  private ArrayList<Folder> addFolderList = new ArrayList();
  private CommonStatus commonStatus;
  private ArrayList<Folder> deleteFolderList = new ArrayList();
  private FolderSyncStatus folderSyncStatus;
  private String syncKey;
  private ArrayList<Folder> updateFolderList = new ArrayList();
  
  public FolderSyncResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  private boolean filterFolder(Folder paramFolder)
  {
    if (paramFolder.getType() == 1)
    {
      paramFolder.setType(6);
      return true;
    }
    if (paramFolder.getType() == 2)
    {
      paramFolder.setType(1);
      return true;
    }
    if (paramFolder.getType() == 3)
    {
      paramFolder.setType(2);
      return true;
    }
    if (paramFolder.getType() == 4)
    {
      paramFolder.setType(3);
      return true;
    }
    if (paramFolder.getType() == 5)
    {
      paramFolder.setType(4);
      return true;
    }
    if ((paramFolder.getType() == 8) || (paramFolder.getType() == 13))
    {
      paramFolder.setType(7);
      return true;
    }
    if ((paramFolder.getType() == 12) && (!"同步问题".equals(paramFolder.getName())) && (!"冲突".equals(paramFolder.getName())) && (!"本地故障".equals(paramFolder.getName())) && (!"服务器故障".equals(paramFolder.getName())))
    {
      paramFolder.setType(6);
      return true;
    }
    return false;
  }
  
  private Folder parseAddOrUpdateFolder(Node paramNode)
  {
    if (XmlDocumentHelper.getChildNode(paramNode, "Type") == null) {}
    int i;
    String str1;
    String str2;
    do
    {
      return null;
      i = XmlDocumentHelper.getChildIntContent(paramNode, "Type");
      str1 = XmlDocumentHelper.getChildText(paramNode, "ServerId");
      str2 = XmlDocumentHelper.getChildText(paramNode, "ParentId");
      paramNode = XmlDocumentHelper.getChildText(paramNode, "DisplayName");
    } while ((str1 == null) || (str2 == null) || (paramNode == null));
    Folder localFolder = new Folder();
    localFolder.setType(i);
    localFolder.setName(paramNode);
    localFolder.setParentId(str2);
    localFolder.setRemoteId(str1);
    return localFolder;
  }
  
  private Folder parseDeleteFolder(Node paramNode)
  {
    paramNode = XmlDocumentHelper.getChildText(paramNode, "ServerId");
    if (paramNode == null) {
      return null;
    }
    Folder localFolder = new Folder();
    localFolder.setRemoteId(paramNode);
    return localFolder;
  }
  
  public ArrayList<Folder> getAddFolderList()
  {
    return this.addFolderList;
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public ArrayList<Folder> getDeleteFolderList()
  {
    return this.deleteFolderList;
  }
  
  public int getErrorCode()
  {
    if (this.folderSyncStatus != null) {
      return this.folderSyncStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.folderSyncStatus != null) {
      return this.folderSyncStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public FolderSyncStatus getFolderSyncStatus()
  {
    return this.folderSyncStatus;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public ArrayList<Folder> getUpdateFolderList()
  {
    return this.updateFolderList;
  }
  
  public boolean isOk()
  {
    if (this.folderSyncStatus != null) {
      return this.folderSyncStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    int j = 0;
    if (this.httpResponse == null) {
      return false;
    }
    if (!this.httpResponse.isOk()) {
      return false;
    }
    if (this.httpResponse.getContent() == null) {
      return true;
    }
    if (this.httpResponse.getContent().length == 0) {
      return true;
    }
    Object localObject1 = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
    if (localObject1 == null) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "FolderSync");
    if (localObject1 == null) {
      return false;
    }
    int i = XmlDocumentHelper.getChildIntContent((Node)localObject1, "Status");
    this.commonStatus = new CommonStatus(i);
    if (!this.commonStatus.isStatusOk()) {
      return false;
    }
    this.folderSyncStatus = new FolderSyncStatus(i);
    if (!this.folderSyncStatus.isStatusOk()) {
      return false;
    }
    this.syncKey = XmlDocumentHelper.getChildText((Node)localObject1, "SyncKey");
    if (this.syncKey == null) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Changes");
    if (localObject1 == null) {
      return false;
    }
    if (XmlDocumentHelper.getChildIntContent((Node)localObject1, "Count") == 0) {
      return true;
    }
    Object localObject2 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Add");
    int k = ((ArrayList)localObject2).size();
    Folder localFolder;
    if (k > 0)
    {
      i = 0;
      while (i < k)
      {
        localFolder = parseAddOrUpdateFolder((Node)((ArrayList)localObject2).get(i));
        if ((localFolder != null) && (filterFolder(localFolder))) {
          this.addFolderList.add(localFolder);
        }
        i += 1;
      }
    }
    localObject2 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Update");
    k = ((ArrayList)localObject2).size();
    if (k > 0)
    {
      i = 0;
      while (i < k)
      {
        localFolder = parseAddOrUpdateFolder((Node)((ArrayList)localObject2).get(i));
        if ((localFolder != null) && (filterFolder(localFolder))) {
          this.updateFolderList.add(localFolder);
        }
        i += 1;
      }
    }
    localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Delete");
    k = ((ArrayList)localObject1).size();
    if (k > 0)
    {
      i = j;
      while (i < k)
      {
        localObject2 = parseDeleteFolder((Node)((ArrayList)localObject1).get(i));
        if (localObject2 != null) {
          this.deleteFolderList.add(localObject2);
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void setAddFolderList(ArrayList<Folder> paramArrayList)
  {
    this.addFolderList = paramArrayList;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setDeleteFolderList(ArrayList<Folder> paramArrayList)
  {
    this.deleteFolderList = paramArrayList;
  }
  
  public void setFolderSyncStatus(FolderSyncStatus paramFolderSyncStatus)
  {
    this.folderSyncStatus = paramFolderSyncStatus;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setUpdateFolderList(ArrayList<Folder> paramArrayList)
  {
    this.updateFolderList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.FolderSyncResponse
 * JD-Core Version:    0.7.0.1
 */