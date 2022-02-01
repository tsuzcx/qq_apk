package com.tencent.tim.teamworkforgroup;

import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.List;

public class GPadInfo
  extends PadInfo
{
  public String creatorCard;
  public long creatorUid;
  public long groupCode;
  public String lastModifyCard;
  public long lastModifyUid;
  public String ownerCard;
  public long ownerUin;
  public long owneruid;
  @notColumn
  public List<String> searchKeyWordList = new ArrayList();
  
  public void convertFrom(PadInfo paramPadInfo)
  {
    if (paramPadInfo == null) {
      return;
    }
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
  
  public void copyFrom(PadInfo paramPadInfo)
  {
    paramPadInfo = (GPadInfo)paramPadInfo;
    super.copyFrom(paramPadInfo);
    this.groupCode = paramPadInfo.groupCode;
    this.creatorCard = paramPadInfo.creatorCard;
    this.ownerUin = paramPadInfo.ownerUin;
    this.ownerCard = paramPadInfo.ownerCard;
    this.lastModifyCard = paramPadInfo.lastModifyCard;
    this.owneruid = paramPadInfo.owneruid;
    this.lastModifyUid = paramPadInfo.lastModifyUid;
    this.creatorUid = paramPadInfo.creatorUid;
    this.searchKeyWordList.addAll(paramPadInfo.searchKeyWordList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == padInfo == \n");
    localStringBuilder.append("domainId: ").append(this.domainId).append(",padId: ").append(this.padId).append(",lastUnPinnedTime: ").append(this.lastUnPinnedTime).append(",itemDeleteFlag: ").append(this.itemDeleteFlag).append(",itemLateDeleteTime: ").append(this.itemLateDeleteTime).append(",thumbUrl: ").append(this.thumbUrl).append(",pad_url: ").append(this.pad_url).append(",type: ").append(this.type).append(",title: ").append(this.title).append(",createTime: ").append(this.createTime).append(",creatorUin: ").append(this.creatorUin).append(",creatorNick: ").append(this.creatorNick).append(",lastEditorUin: ").append(this.lastEditorUin).append(",lastEditorNick: ").append(this.lastEditorNick).append(",lastEditTime: ").append(this.lastEditTime).append(",pinedFlag: ").append(this.pinedFlag).append(",policy: ").append(this.policy).append(",group code: ").append(this.groupCode).append(",creator card: ").append(this.creatorCard).append(",owner uin: ").append(this.ownerUin).append(", owner card ").append(this.ownerCard).append(", lastModifyCard: ").append(this.lastModifyCard).append(", creator uid: ").append(this.creatorUid).append(" , last modify uid: ").append(this.lastModifyUid).append(", owner uid").append(this.owneruid);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GPadInfo
 * JD-Core Version:    0.7.0.1
 */