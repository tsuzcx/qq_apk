package com.tencent.biz.qqstory.shareGroup.model;

import acfp;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupBasicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupExtInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import plu;
import ptq;
import ram;
import rom;

public class ShareGroupItem
  extends BaseUIItem
  implements plu, ptq
{
  public static final int OWNER_TYPE_CREATOR = 1;
  public static final int OWNER_TYPE_PARTICIPATOR = 2;
  public static final int OWNER_TYPE_RECOMMEND = 3;
  public static final int TYPE_SHARE_GROUP = 2;
  public static final int TYPE_USER_GROUP = 1;
  public int allowStrangerVisitAndPost = -1;
  public String backgroundUrl;
  public int followCount = -1;
  public long groupUin = -1L;
  public List<String> headerUnionIdList = new ArrayList(0);
  public int isDisband = -1;
  public int isSubscribed = -1;
  public int memberCount = -1;
  public String name = acfp.m(2131714374);
  public int ownerType = 1;
  public String ownerUnionId;
  public String shareGroupId;
  public int type = 2;
  public int videoCount = -1;
  
  public ShareGroupItem() {}
  
  public ShareGroupItem(ShareGroupEntry paramShareGroupEntry)
  {
    this.id = paramShareGroupEntry.getId();
    this.shareGroupId = paramShareGroupEntry.shareGroupId;
    this.name = paramShareGroupEntry.name;
    this.allowStrangerVisitAndPost = paramShareGroupEntry.allowStrangerVisitAndPost;
    this.memberCount = paramShareGroupEntry.memberCount;
    this.followCount = paramShareGroupEntry.followCount;
    this.videoCount = paramShareGroupEntry.videoCount;
    this.ownerType = paramShareGroupEntry.ownerType;
    this.headerUnionIdList = paramShareGroupEntry.getHeaderUnionIdListBytes();
    this.isSubscribed = paramShareGroupEntry.isSubscribed;
    this.isDisband = paramShareGroupEntry.isDisband;
    this.ownerUnionId = paramShareGroupEntry.ownerUnionId;
    this.type = paramShareGroupEntry.type;
    this.groupUin = paramShareGroupEntry.groupUin;
    this.backgroundUrl = paramShareGroupEntry.backgroundUrl;
    assertItem();
  }
  
  public void assertItem()
  {
    rom.sF(this.shareGroupId);
    if (this.type == 2) {
      ram.w("Q.qqstory.shareGroup", "share group Item owner union id is null %s", new Object[] { this });
    }
  }
  
  public void convertFrom(qqstory_struct.ShareGroupBasicInfo paramShareGroupBasicInfo)
  {
    this.shareGroupId = paramShareGroupBasicInfo.shared_group_id.get();
    this.name = paramShareGroupBasicInfo.name.get();
    this.allowStrangerVisitAndPost = paramShareGroupBasicInfo.allow_stranger_visit_and_post.get();
    if (paramShareGroupBasicInfo.type.has()) {
      this.type = paramShareGroupBasicInfo.type.get();
    }
    if (paramShareGroupBasicInfo.owner.has()) {
      this.ownerUnionId = paramShareGroupBasicInfo.owner.get();
    }
    if (paramShareGroupBasicInfo.header_unionid_list.has()) {
      this.headerUnionIdList = paramShareGroupBasicInfo.header_unionid_list.get();
    }
    if (paramShareGroupBasicInfo.background_url.has()) {
      this.backgroundUrl = paramShareGroupBasicInfo.background_url.get();
    }
    if (paramShareGroupBasicInfo.group_code.has()) {
      this.groupUin = paramShareGroupBasicInfo.group_code.get();
    }
    if (paramShareGroupBasicInfo.has_disband.has()) {
      this.isDisband = paramShareGroupBasicInfo.has_disband.get();
    }
    assertItem();
  }
  
  public void convertFrom(qqstory_struct.ShareGroupInfo paramShareGroupInfo)
  {
    convertFrom(paramShareGroupInfo.basic_info);
    qqstory_struct.ShareGroupExtInfo localShareGroupExtInfo;
    if (paramShareGroupInfo.ext_info.has())
    {
      localShareGroupExtInfo = (qqstory_struct.ShareGroupExtInfo)paramShareGroupInfo.ext_info.get();
      if (localShareGroupExtInfo.total_members.has()) {
        this.memberCount = localShareGroupExtInfo.total_members.get();
      }
      if (localShareGroupExtInfo.total_videos.has()) {
        this.videoCount = localShareGroupExtInfo.total_videos.get();
      }
      if (!localShareGroupExtInfo.has_join.has()) {
        break label120;
      }
    }
    label120:
    for (this.isSubscribed = localShareGroupExtInfo.has_join.get();; this.isSubscribed = 0)
    {
      if (paramShareGroupInfo.ext_info.owner_type.has()) {
        this.ownerType = paramShareGroupInfo.ext_info.owner_type.get();
      }
      return;
    }
  }
  
  public ShareGroupEntry convertTo()
  {
    ShareGroupEntry localShareGroupEntry = new ShareGroupEntry();
    localShareGroupEntry.shareGroupId = this.shareGroupId;
    localShareGroupEntry.name = this.name;
    localShareGroupEntry.allowStrangerVisitAndPost = this.allowStrangerVisitAndPost;
    localShareGroupEntry.memberCount = this.memberCount;
    localShareGroupEntry.followCount = this.followCount;
    localShareGroupEntry.videoCount = this.videoCount;
    localShareGroupEntry.ownerType = this.ownerType;
    localShareGroupEntry.setHeaderUnionIdListBytes(this.headerUnionIdList);
    localShareGroupEntry.isSubscribed = this.isSubscribed;
    localShareGroupEntry.isDisband = this.isDisband;
    localShareGroupEntry.ownerUnionId = this.ownerUnionId;
    localShareGroupEntry.type = this.type;
    localShareGroupEntry.groupUin = this.groupUin;
    localShareGroupEntry.backgroundUrl = this.backgroundUrl;
    return localShareGroupEntry;
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (ShareGroupItem)paramObject;
    this.shareGroupId = paramObject.shareGroupId;
    this.name = paramObject.name;
    this.type = paramObject.type;
    if (paramObject.groupUin != -1L) {
      this.groupUin = paramObject.groupUin;
    }
    if (paramObject.allowStrangerVisitAndPost != -1) {
      this.allowStrangerVisitAndPost = paramObject.allowStrangerVisitAndPost;
    }
    if (paramObject.memberCount != -1) {
      this.memberCount = paramObject.memberCount;
    }
    if (paramObject.followCount != -1) {
      this.followCount = paramObject.followCount;
    }
    if (paramObject.videoCount != -1) {
      this.videoCount = paramObject.videoCount;
    }
    if (paramObject.ownerType != -1) {
      this.ownerType = paramObject.ownerType;
    }
    if (paramObject.headerUnionIdList != null) {
      this.headerUnionIdList = paramObject.headerUnionIdList;
    }
    if (paramObject.ownerUnionId != null) {
      this.ownerUnionId = paramObject.ownerUnionId;
    }
    if (paramObject.isSubscribed != -1) {
      this.isSubscribed = paramObject.isSubscribed;
    }
    if (paramObject.isDisband != -1) {
      this.isDisband = paramObject.isDisband;
    }
    if (paramObject.backgroundUrl != null) {
      this.backgroundUrl = paramObject.backgroundUrl;
    }
    assertItem();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getRelationType()
  {
    if (this.type == 1) {
      return 2;
    }
    if (this.type == 2) {
      return 1;
    }
    return 1;
  }
  
  public int getReportGroupProp()
  {
    int i = 1;
    if (this.type == 1) {
      i = 3;
    }
    while (!isPublic()) {
      return i;
    }
    return 2;
  }
  
  public String getReportUserType()
  {
    return getReportUserTypeInt() + "";
  }
  
  public int getReportUserTypeInt()
  {
    if (isOwner()) {
      return 1;
    }
    if (isSubscribe()) {
      return 2;
    }
    return 3;
  }
  
  public String getUnionId()
  {
    return this.shareGroupId;
  }
  
  public boolean isFriend()
  {
    return false;
  }
  
  public boolean isInvalid()
  {
    if (this.type == 1) {}
    while ((this.isDisband != 1) && (this.videoCount != 0) && (this.memberCount != 0)) {
      return false;
    }
    return true;
  }
  
  public boolean isMe()
  {
    return false;
  }
  
  public boolean isOwner()
  {
    return QQStoryContext.a().eU(this.ownerUnionId);
  }
  
  public boolean isPublic()
  {
    return this.allowStrangerVisitAndPost == 1;
  }
  
  public boolean isSubscribe()
  {
    return this.isSubscribed == 1;
  }
  
  public boolean isSubscribeButNoFriend()
  {
    return false;
  }
  
  public boolean isVip()
  {
    return false;
  }
  
  public boolean isVipButNoFriend()
  {
    return false;
  }
  
  public String toString()
  {
    return "ShareGroupItem{shareGroupId='" + this.shareGroupId + '\'' + ", name='" + this.name + '\'' + ", allowStrangerVisitAndPost=" + this.allowStrangerVisitAndPost + ", memberCount=" + this.memberCount + ", followCount=" + this.followCount + ", videoCount=" + this.videoCount + ", ownerType=" + this.ownerType + ", headerUnionIdList=" + this.headerUnionIdList + ", isSubscribed=" + this.isSubscribed + ", isDisband=" + this.isDisband + ", ownerUnionId='" + this.ownerUnionId + '\'' + ", backgroundUrl='" + this.backgroundUrl + '\'' + ", type=" + this.type + ", groupUin=" + this.groupUin + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem
 * JD-Core Version:    0.7.0.1
 */