package com.tencent.tim.teamwork;

import atiu;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public class PadInfo
  extends Entity
  implements atiu
{
  public static final int TYPE_DOC = 1;
  public static final int TYPE_FORM = 3;
  public static final int TYPE_LIST_ALL = 4;
  public static final int TYPE_LIST_BROWSE = 2;
  public static final int TYPE_LIST_CREATE = 1;
  public static final int TYPE_LIST_SHARED = 3;
  public static final int TYPE_PIN_LIST_IN_LIST_ALL = 5;
  public static final int TYPE_PPT = 4;
  public static final int TYPE_SHEET = 2;
  public long createTime;
  public String creatorNick;
  public long creatorUin;
  public long currentUserBrowseTime;
  public int domainId;
  @notColumn
  public long iCloudFileCreateTime;
  @notColumn
  public boolean isCloudFile;
  public boolean isHighlight;
  public boolean itemDeleteFlag;
  public long itemLateDeleteTime;
  public long lastEditTime;
  public String lastEditorNick;
  public long lastEditorUin;
  public long lastPinnedTime;
  public long lastPinnedTimeInAllList;
  public long lastUnPinnedTime;
  public long lastViewTime;
  public String lastViewerNick;
  public long lastViewerUin;
  public long lastshardTime;
  @notColumn
  public boolean mClickable = true;
  @notColumn
  public boolean mSelectable;
  @notColumn
  public List<TimDocSSOMsg.UinRightInfo> mUins = new ArrayList();
  public String padId;
  @unique
  public String pad_url;
  public boolean pinInAllList;
  public boolean pinedFlag;
  public int policy = 2;
  public String shardNick;
  public long shardUin;
  public String thumbUrl;
  public String title;
  public int type;
  public int type_list;
  
  public void copyFrom(PadInfo paramPadInfo)
  {
    this.domainId = paramPadInfo.domainId;
    this.padId = paramPadInfo.padId;
    this.lastUnPinnedTime = paramPadInfo.lastUnPinnedTime;
    this.itemDeleteFlag = paramPadInfo.itemDeleteFlag;
    this.itemLateDeleteTime = paramPadInfo.itemLateDeleteTime;
    this.thumbUrl = paramPadInfo.thumbUrl;
    this.pad_url = paramPadInfo.pad_url;
    this.type_list = paramPadInfo.type_list;
    this.type = paramPadInfo.type;
    this.title = paramPadInfo.title;
    this.createTime = paramPadInfo.createTime;
    this.creatorUin = paramPadInfo.creatorUin;
    this.creatorNick = paramPadInfo.creatorNick;
    this.lastEditorUin = paramPadInfo.lastEditorUin;
    this.lastEditorNick = paramPadInfo.lastEditorNick;
    this.lastEditTime = paramPadInfo.lastEditTime;
    this.pinedFlag = paramPadInfo.pinedFlag;
    this.lastViewerUin = paramPadInfo.lastViewerUin;
    this.lastViewerNick = paramPadInfo.lastViewerNick;
    this.lastViewTime = paramPadInfo.lastViewTime;
    this.lastPinnedTime = paramPadInfo.lastPinnedTime;
    this.currentUserBrowseTime = paramPadInfo.currentUserBrowseTime;
    this.shardUin = paramPadInfo.shardUin;
    this.shardNick = paramPadInfo.shardNick;
    this.lastshardTime = paramPadInfo.lastshardTime;
    this.policy = paramPadInfo.policy;
    this.mUins.addAll(paramPadInfo.mUins);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof com.tencent.mobileqq.teamwork.PadInfo)) {
      return (this.pad_url != null) && (this.pad_url.equalsIgnoreCase(((com.tencent.mobileqq.teamwork.PadInfo)paramObject).pad_url));
    }
    return super.equals(paramObject);
  }
  
  public int getCloudFileType()
  {
    return 2;
  }
  
  public online_docs.DocId getDocId()
  {
    online_docs.DocId localDocId = new online_docs.DocId();
    localDocId.pad_id.set(ByteStringMicro.copyFromUtf8(this.padId));
    localDocId.domain_id.set(this.domainId);
    return localDocId;
  }
  
  public List<TimDocSSOMsg.UinRightInfo> getRightList()
  {
    return this.mUins;
  }
  
  public long getSortSeq()
  {
    return 0L;
  }
  
  public long getSortTime()
  {
    if (this.type_list == 3) {
      return this.lastshardTime;
    }
    return Math.max(this.lastEditTime, this.currentUserBrowseTime);
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public boolean isSelectable()
  {
    return this.mSelectable;
  }
  
  public void setRightsList(List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.mUins = paramList;
  }
  
  public void setmClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setmSelectable(boolean paramBoolean)
  {
    this.mSelectable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == padInfo == \n");
    localStringBuilder.append("domainId: ").append(this.domainId).append(",padId: ").append(this.padId).append(",lastUnPinnedTime: ").append(this.lastUnPinnedTime).append(",itemDeleteFlag: ").append(this.itemDeleteFlag).append(",itemLateDeleteTime: ").append(this.itemLateDeleteTime).append(",thumbUrl: ").append(this.thumbUrl).append(",pad_url: ").append(this.pad_url).append(",type: ").append(this.type).append(",title: ").append(this.title).append(",createTime: ").append(this.createTime).append(",creatorUin: ").append(this.creatorUin).append(",creatorNick: ").append(this.creatorNick).append(",lastEditorUin: ").append(this.lastEditorUin).append(",lastEditorNick: ").append(this.lastEditorNick).append(",lastEditTime: ").append(this.lastEditTime).append(",pinedFlag: ").append(this.pinedFlag).append(",policy: ").append(this.policy);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.PadInfo
 * JD-Core Version:    0.7.0.1
 */