package com.tencent.biz.qqstory.storyHome.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.CommentLikeFeed;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import ptp;
import ptq;
import qwa;

public abstract class CommentLikeFeedItem<T extends qwa, E extends ptq>
  extends FeedItem<T, E>
{
  public static final int COMMENT_LIKE_TYPE_FANS = 1;
  public static final int COMMENT_LIKE_TYPE_FRIEND = 0;
  public int mCommentCount = -1;
  public int mCommentIsEnd = -1;
  public String mCommentLastCookie = "";
  public int mDenyComment = -1;
  public int mFanCommentCount = -1;
  public int mFanLikeCount = -1;
  public int mFriendCommentCount = -1;
  public int mFriendLikeCount = -1;
  public int mHadLike = -1;
  public int mLikeCount = -1;
  public long mViewTotalTime = -1L;
  
  public static int getCommentLikeType(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return 1;
      bool1 = paramQQUserUIItem.isVipButNoFriend();
      bool2 = paramQQUserUIItem.isSubscribeButNoFriend();
      if (paramQQUserUIItem.isMe()) {
        return 0;
      }
    } while ((bool1) || (bool2));
    return 0;
  }
  
  public void convertFromFeedFeature(ptp paramptp)
  {
    int j = 1;
    this.feedId = paramptp.feedId;
    this.mLikeCount = paramptp.totalLikeCount;
    this.mCommentCount = paramptp.bkl;
    this.mViewTotalTime = paramptp.bkm;
    if (paramptp.aBB)
    {
      i = 1;
      this.mDenyComment = i;
      if (!paramptp.aBC) {
        break label69;
      }
    }
    label69:
    for (int i = j;; i = 0)
    {
      this.mHadLike = i;
      return;
      i = 0;
      break;
    }
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (CommentLikeFeedItem)paramObject;
    if (paramObject.mCommentCount != -1) {
      this.mCommentCount = paramObject.mCommentCount;
    }
    if (paramObject.mFriendCommentCount != -1) {
      this.mFriendCommentCount = paramObject.mFriendCommentCount;
    }
    if (paramObject.mFanCommentCount != -1) {
      this.mFanCommentCount = paramObject.mFanCommentCount;
    }
    if (paramObject.mCommentIsEnd != -1) {
      this.mCommentIsEnd = paramObject.mCommentIsEnd;
    }
    if (paramObject.mDenyComment != -1) {
      this.mDenyComment = paramObject.mDenyComment;
    }
    if (paramObject.mLikeCount != -1) {
      this.mLikeCount = paramObject.mLikeCount;
    }
    if (paramObject.mFriendLikeCount != -1) {
      this.mFriendLikeCount = paramObject.mFriendLikeCount;
    }
    if (paramObject.mFanLikeCount != -1) {
      this.mFanLikeCount = paramObject.mFanLikeCount;
    }
    if (paramObject.mHadLike != -1) {
      this.mHadLike = paramObject.mHadLike;
    }
    if (paramObject.mViewTotalTime != -1L) {
      this.mViewTotalTime = paramObject.mViewTotalTime;
    }
  }
  
  public abstract int getCommentLikeType();
  
  public boolean isFakeFeedItem()
  {
    return false;
  }
  
  protected void readCommentLikeFeedLocalPB(SerializationPB.CommentLikeFeed paramCommentLikeFeed)
  {
    this.mCommentCount = paramCommentLikeFeed.comment_count.get();
    this.mFriendCommentCount = paramCommentLikeFeed.freind_commnet_count.get();
    this.mFanCommentCount = paramCommentLikeFeed.fan_comment_count.get();
    this.mCommentIsEnd = paramCommentLikeFeed.comment_is_end.get();
    this.mDenyComment = paramCommentLikeFeed.deny_comment.get();
    this.mCommentLastCookie = paramCommentLikeFeed.comment_last_cookie.get();
    this.mLikeCount = paramCommentLikeFeed.like_count.get();
    this.mFriendLikeCount = paramCommentLikeFeed.friend_like_count.get();
    this.mFanLikeCount = paramCommentLikeFeed.fan_like_count.get();
    this.mHadLike = paramCommentLikeFeed.had_like.get();
    this.mViewTotalTime = paramCommentLikeFeed.view_total_time.get();
  }
  
  public void reset()
  {
    this.mLikeCount = 0;
    this.mHadLike = 0;
    this.mLikeCount = 0;
    this.mCommentCount = -1;
    this.mCommentIsEnd = 0;
    this.mCommentLastCookie = "";
    this.mLikeCount = -1;
    this.mHadLike = -1;
    this.mViewTotalTime = -1L;
    this.mLikeCount = 0;
  }
  
  protected SerializationPB.CommentLikeFeed writeCommentLikeFeedlocalPB()
  {
    SerializationPB.CommentLikeFeed localCommentLikeFeed = new SerializationPB.CommentLikeFeed();
    localCommentLikeFeed.comment_count.set(this.mCommentCount);
    localCommentLikeFeed.freind_commnet_count.set(this.mFriendCommentCount);
    localCommentLikeFeed.fan_comment_count.set(this.mFanCommentCount);
    localCommentLikeFeed.comment_is_end.set(this.mCommentIsEnd);
    localCommentLikeFeed.deny_comment.set(this.mDenyComment);
    PBStringField localPBStringField = localCommentLikeFeed.comment_last_cookie;
    if (TextUtils.isEmpty(this.mCommentLastCookie)) {}
    for (String str = "";; str = this.mCommentLastCookie)
    {
      localPBStringField.set(str);
      localCommentLikeFeed.like_count.set(this.mLikeCount);
      localCommentLikeFeed.friend_like_count.set(this.mFriendLikeCount);
      localCommentLikeFeed.fan_like_count.set(this.mFanLikeCount);
      localCommentLikeFeed.had_like.set(this.mHadLike);
      localCommentLikeFeed.view_total_time.set(this.mViewTotalTime);
      return localCommentLikeFeed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem
 * JD-Core Version:    0.7.0.1
 */