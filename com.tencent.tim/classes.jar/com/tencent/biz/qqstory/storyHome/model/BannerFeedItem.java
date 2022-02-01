package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.BannerFeed;
import com.tencent.biz.qqstory.base.SerializationPB.CommentLikeFeed;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerShareInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import psx;
import ptf;
import quw;
import rom;

public class BannerFeedItem
  extends CommentLikeFeedItem<quw, QQUserUIItem>
{
  public String blurb;
  public String content;
  public int coverHeight = -1;
  public String coverUrl;
  public int coverWidth = -1;
  private QQUserUIItem mOwner = new QQUserUIItem();
  public long recommendId = -1L;
  public String recommendTitle = "";
  public String schema;
  public a shareInfo = new a();
  
  protected int assignType()
  {
    return 5;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (BannerFeedItem)paramObject;
    if (paramObject.content != null) {
      this.content = paramObject.content;
    }
    if (paramObject.coverUrl != null) {
      this.coverUrl = paramObject.coverUrl;
    }
    if (paramObject.schema != null) {
      this.schema = paramObject.schema;
    }
    if (paramObject.blurb != null) {
      this.blurb = paramObject.blurb;
    }
    if (paramObject.coverHeight != -1) {
      this.coverHeight = paramObject.coverHeight;
    }
    if (paramObject.coverWidth != -1) {
      this.coverWidth = paramObject.coverWidth;
    }
    if (paramObject.recommendId != -1L) {
      this.recommendId = paramObject.recommendId;
    }
    if (!TextUtils.isEmpty(paramObject.recommendTitle)) {
      this.recommendTitle = paramObject.recommendTitle;
    }
    this.mOwner.copy(paramObject.mOwner);
    this.shareInfo.a(paramObject.shareInfo);
  }
  
  public void covertFrom(String paramString, qqstory_struct.BannerFeed paramBannerFeed)
  {
    this.feedId = paramString;
    paramString = new QQUserUIItem();
    paramString.convertFrom((qqstory_struct.UserInfo)paramBannerFeed.user.get());
    this.mOwner = ((ptf)psx.a(2)).a(paramString);
    rom.checkNotNull(this.mOwner);
    this.ownerId = this.mOwner.getUnionId();
    this.date = String.valueOf(paramBannerFeed.date.get());
    super.setDate(this.date);
    this.blurb = paramBannerFeed.blurb.get().toStringUtf8();
    this.schema = paramBannerFeed.schema.get().toStringUtf8();
    this.content = paramBannerFeed.content.get().toStringUtf8();
    this.coverUrl = paramBannerFeed.cover_url.get().toStringUtf8();
    this.recommendTitle = paramBannerFeed.title_wording.get().toStringUtf8();
    this.coverWidth = paramBannerFeed.width.get();
    this.coverHeight = paramBannerFeed.height.get();
    this.recommendId = paramBannerFeed.recommend_id.get();
    this.shareInfo.reset();
    this.shareInfo.title = paramBannerFeed.share_info.title.get().toStringUtf8();
    this.shareInfo.iconUrl = paramBannerFeed.share_info.icon.get().toStringUtf8();
    this.shareInfo.content = paramBannerFeed.share_info.content.get().toStringUtf8();
    this.shareInfo.jumpUrl = paramBannerFeed.share_info.jump_url.get().toStringUtf8();
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.BannerFeed localBannerFeed = new SerializationPB.BannerFeed();
    localBannerFeed.commet_like_feed.set(super.writeCommentLikeFeedlocalPB());
    PBStringField localPBStringField = localBannerFeed.share_info_title;
    if (TextUtils.isEmpty(this.shareInfo.title))
    {
      str = "";
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.share_info_icon;
      if (!TextUtils.isEmpty(this.shareInfo.iconUrl)) {
        break label288;
      }
      str = "";
      label66:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.share_info_content;
      if (!TextUtils.isEmpty(this.shareInfo.content)) {
        break label299;
      }
      str = "";
      label92:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.share_info_jump_url;
      if (!TextUtils.isEmpty(this.shareInfo.jumpUrl)) {
        break label310;
      }
      str = "";
      label118:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.blurb;
      if (!TextUtils.isEmpty(this.blurb)) {
        break label321;
      }
      str = "";
      label141:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.schema;
      if (!TextUtils.isEmpty(this.schema)) {
        break label329;
      }
      str = "";
      label164:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.content;
      if (!TextUtils.isEmpty(this.content)) {
        break label337;
      }
      str = "";
      label187:
      localPBStringField.set(str);
      localPBStringField = localBannerFeed.cover_url;
      if (!TextUtils.isEmpty(this.coverUrl)) {
        break label345;
      }
    }
    label288:
    label299:
    label310:
    label321:
    label329:
    label337:
    label345:
    for (String str = "";; str = this.coverUrl)
    {
      localPBStringField.set(str);
      localBannerFeed.height.set(this.coverHeight);
      localBannerFeed.width.set(this.coverWidth);
      localBannerFeed.recommend_id.set(this.recommendId);
      if (!TextUtils.isEmpty(this.recommendTitle)) {
        localBannerFeed.title_wording.set(ByteStringMicro.copyFromUtf8(this.recommendTitle));
      }
      return localBannerFeed.toByteArray();
      str = this.shareInfo.title;
      break;
      str = this.shareInfo.iconUrl;
      break label66;
      str = this.shareInfo.content;
      break label92;
      str = this.shareInfo.jumpUrl;
      break label118;
      str = this.blurb;
      break label141;
      str = this.schema;
      break label164;
      str = this.content;
      break label187;
    }
  }
  
  @NonNull
  public quw generateHomeFeed()
  {
    return new quw(this);
  }
  
  public int getCommentLikeType()
  {
    return 0;
  }
  
  @NonNull
  public QQUserUIItem getOwner()
  {
    if (this.mOwner == null) {
      this.mOwner = new QQUserUIItem();
    }
    return this.mOwner;
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    this.mOwner = ((ptf)psx.a(2)).a(this.ownerId);
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    SerializationPB.BannerFeed localBannerFeed = new SerializationPB.BannerFeed();
    localBannerFeed.mergeFrom(paramArrayOfByte);
    super.readCommentLikeFeedLocalPB(localBannerFeed.commet_like_feed);
    this.shareInfo.title = localBannerFeed.share_info_title.get();
    this.shareInfo.iconUrl = localBannerFeed.share_info_icon.get();
    this.shareInfo.content = localBannerFeed.share_info_content.get();
    this.shareInfo.jumpUrl = localBannerFeed.share_info_jump_url.get();
    this.blurb = localBannerFeed.blurb.get();
    this.schema = localBannerFeed.schema.get();
    this.content = localBannerFeed.content.get();
    this.coverWidth = localBannerFeed.width.get();
    this.coverHeight = localBannerFeed.height.get();
    this.coverUrl = localBannerFeed.cover_url.get();
    this.recommendId = localBannerFeed.recommend_id.get();
    this.recommendTitle = localBannerFeed.title_wording.get().toStringUtf8();
  }
  
  public static class a
  {
    public String content;
    public String iconUrl;
    public String jumpUrl;
    public String title;
    
    public void a(a parama)
    {
      if (parama.title != null) {
        this.title = parama.title;
      }
      if (parama.content != null) {
        this.content = parama.content;
      }
      if (parama.iconUrl != null) {
        this.iconUrl = parama.iconUrl;
      }
      if (parama.jumpUrl != null) {
        this.jumpUrl = parama.jumpUrl;
      }
    }
    
    public void reset()
    {
      this.title = null;
      this.content = null;
      this.iconUrl = null;
      this.jumpUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.BannerFeedItem
 * JD-Core Version:    0.7.0.1
 */