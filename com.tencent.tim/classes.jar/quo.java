import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryChallengeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryGradeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMedalInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryOfficialInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPhotoTogetherInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPublishInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVoteInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class quo
{
  public long Bn;
  public long Bo;
  public long Bp;
  public boolean Zm = true;
  public boolean aFA;
  public boolean aFB;
  public boolean aFC;
  public boolean aFD;
  public String axW;
  public String ayI;
  public String ayJ;
  public String ayK;
  public String ayL;
  public String ayM;
  public String ayN;
  private String ayO;
  private String ayP;
  public String ayQ;
  public String ayR;
  public String ayS;
  public String ayT;
  public StoryVideoItem.a b;
  public int boh;
  public int boi;
  public int boj;
  public int bok;
  public StoryVideoItem.b c;
  public int category;
  public String commentContent;
  public int commentId = -1;
  public String content;
  private String coverUrl;
  public int dV;
  public boolean deleted;
  public String feedId;
  public boolean isVip;
  public String jump_url;
  public String mFeedId;
  public String nickPostfix;
  public String ownerUnionId;
  public int type;
  public int url_type;
  public String vid;
  
  public quo(qqstory_710_message.StoryMessage paramStoryMessage)
  {
    Object localObject;
    if (paramStoryMessage.like_info.has())
    {
      localObject = (qqstory_710_message.StoryLikeInfo)paramStoryMessage.like_info.get();
      this.ayI = ((qqstory_710_message.StoryLikeInfo)localObject).union_id.get().toStringUtf8();
      this.Bn = (((qqstory_710_message.StoryLikeInfo)localObject).like_time.get() * 1000L);
      if (((qqstory_710_message.StoryLikeInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.isVip = bool1;
      this.type = 1;
      this.category = ((qqstory_710_message.StoryLikeInfo)localObject).type.get();
      this.axW = ((qqstory_710_message.StoryLikeInfo)localObject).share_name.get().toStringUtf8();
      this.ayN = ((qqstory_710_message.StoryLikeInfo)localObject).share_union_id.get().toStringUtf8();
      this.boj = ((qqstory_710_message.StoryLikeInfo)localObject).share_type.get();
    }
    for (;;)
    {
      if (paramStoryMessage.video_info.has())
      {
        this.coverUrl = paramStoryMessage.video_info.cover_url.get().toStringUtf8();
        this.vid = paramStoryMessage.video_info.vid.get().toStringUtf8();
        this.ownerUnionId = paramStoryMessage.video_info.union_id.get().toStringUtf8();
        this.ayK = paramStoryMessage.video_info.vote_attr.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.ayK)) {
          this.c = StoryVideoItem.b.a(this.ayK);
        }
        if (!TextUtils.isEmpty(this.ayL)) {
          this.b = StoryVideoItem.a.a(this.ayL);
        }
      }
      this.mFeedId = paramStoryMessage.feed_id.get().toStringUtf8();
      this.boh = paramStoryMessage.message_id.get();
      this.dV = paramStoryMessage.src_type.get();
      this.Bo = paramStoryMessage.src_uid.get();
      return;
      if (paramStoryMessage.comment_info.has())
      {
        localObject = (qqstory_710_message.StoryCommentInfo)paramStoryMessage.comment_info.get();
        this.ayI = ((qqstory_710_message.StoryCommentInfo)localObject).union_id.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryCommentInfo)localObject).comment_time.get() * 1000L);
        if (((qqstory_710_message.StoryCommentInfo)localObject).is_bigv.get() == 1)
        {
          bool1 = true;
          label410:
          this.isVip = bool1;
          if (((qqstory_710_message.StoryCommentInfo)localObject).comment_del.get() != 1) {
            break label584;
          }
          bool1 = true;
          label429:
          this.deleted = bool1;
          this.commentContent = ((qqstory_710_message.StoryCommentInfo)localObject).content.get().toStringUtf8();
          this.commentId = ((qqstory_710_message.StoryCommentInfo)localObject).comment_id.get();
          if ((!((qqstory_710_message.StoryCommentInfo)localObject).reply_uid.has()) && (!((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.has())) {
            break label594;
          }
          this.ayJ = ((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.get().toStringUtf8();
          if (((qqstory_710_message.StoryCommentInfo)localObject).reply_is_bigv.get() != 1) {
            break label589;
          }
          bool1 = bool2;
          label512:
          this.aFA = bool1;
        }
        label584:
        label589:
        label594:
        for (this.type = 3;; this.type = 2)
        {
          this.category = ((qqstory_710_message.StoryCommentInfo)localObject).type.get();
          this.axW = ((qqstory_710_message.StoryCommentInfo)localObject).share_name.get().toStringUtf8();
          this.ayN = ((qqstory_710_message.StoryCommentInfo)localObject).share_union_id.get().toStringUtf8();
          this.boj = ((qqstory_710_message.StoryCommentInfo)localObject).share_type.get();
          break;
          bool1 = false;
          break label410;
          bool1 = false;
          break label429;
          bool1 = false;
          break label512;
        }
      }
      if (paramStoryMessage.publish_info.has())
      {
        localObject = (qqstory_710_message.StoryPublishInfo)paramStoryMessage.publish_info.get();
        this.ayI = ((qqstory_710_message.StoryPublishInfo)localObject).union_id.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryPublishInfo)localObject).publish_time.get() * 1000L);
        if (((qqstory_710_message.StoryPublishInfo)localObject).is_bigv.get() == 1)
        {
          bool1 = true;
          label670:
          this.isVip = bool1;
          this.type = 4;
          if ((!((qqstory_710_message.StoryPublishInfo)localObject).video_del.has()) || (((qqstory_710_message.StoryPublishInfo)localObject).video_del.get() != 1)) {
            break label761;
          }
        }
        label761:
        for (bool1 = bool6;; bool1 = false)
        {
          this.deleted = bool1;
          this.axW = ((qqstory_710_message.StoryPublishInfo)localObject).share_name.get().toStringUtf8();
          this.ayN = ((qqstory_710_message.StoryPublishInfo)localObject).share_union_id.get().toStringUtf8();
          this.boj = ((qqstory_710_message.StoryPublishInfo)localObject).share_type.get();
          break;
          bool1 = false;
          break label670;
        }
      }
      if (paramStoryMessage.official_info.has())
      {
        localObject = (qqstory_710_message.StoryOfficialInfo)paramStoryMessage.official_info.get();
        this.Bp = ((qqstory_710_message.StoryOfficialInfo)localObject).official_uin.get();
        this.ayI = ((qqstory_710_message.StoryOfficialInfo)localObject).union_id.get().toStringUtf8();
        this.jump_url = ((qqstory_710_message.StoryOfficialInfo)localObject).jump_url.get().toStringUtf8();
        this.url_type = ((qqstory_710_message.StoryOfficialInfo)localObject).url_type.get();
        this.content = ((qqstory_710_message.StoryOfficialInfo)localObject).content.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryOfficialInfo)localObject).push_time.get() * 1000L);
        if (((qqstory_710_message.StoryOfficialInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = bool8;; bool1 = false)
        {
          this.isVip = bool1;
          this.coverUrl = paramStoryMessage.official_info.cover_url.get().toStringUtf8();
          this.type = 5;
          break;
        }
      }
      if (paramStoryMessage.share_info.has())
      {
        localObject = (qqstory_710_message.ShareGroupInfo)paramStoryMessage.share_info.get();
        this.ayI = ((qqstory_710_message.ShareGroupInfo)localObject).union_id.get().toStringUtf8();
        this.axW = ((qqstory_710_message.ShareGroupInfo)localObject).share_name.get().toStringUtf8();
        switch (((qqstory_710_message.ShareGroupInfo)localObject).oper_type.get())
        {
        default: 
          label1020:
          this.Bn = (((qqstory_710_message.ShareGroupInfo)localObject).push_time.get() * 1000L);
          if (((qqstory_710_message.ShareGroupInfo)localObject).is_bigv.get() != 1) {
            break;
          }
        }
        for (bool1 = bool9;; bool1 = false)
        {
          this.isVip = bool1;
          this.ayN = ((qqstory_710_message.ShareGroupInfo)localObject).share_union_id.get().toStringUtf8();
          this.boj = ((qqstory_710_message.ShareGroupInfo)localObject).share_type.get();
          break;
          this.type = 6;
          this.commentContent = ppf.getString(2131701945, new Object[] { this.axW });
          break label1020;
          this.type = 7;
          this.ayM = ((qqstory_710_message.ShareGroupInfo)localObject).share_new_name.get().toStringUtf8();
          this.commentContent = ppf.getString(2131701946, new Object[] { this.ayM });
          break label1020;
          this.type = 8;
          break label1020;
          this.type = 9;
          this.commentContent = ppf.getString(2131701951, new Object[] { this.axW });
          break label1020;
          this.type = 11;
          this.commentContent = acfp.m(2131708138);
          break label1020;
        }
      }
      if (paramStoryMessage.medal_info.has())
      {
        localObject = (qqstory_710_message.StoryMedalInfo)paramStoryMessage.medal_info.get();
        this.ayI = ((qqstory_710_message.StoryMedalInfo)localObject).union_id.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryMedalInfo)localObject).push_time.get() * 1000L);
        this.commentContent = ((qqstory_710_message.StoryMedalInfo)localObject).content.get().toStringUtf8();
        if (((qqstory_710_message.StoryMedalInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = bool10;; bool1 = false)
        {
          this.isVip = bool1;
          this.coverUrl = ((qqstory_710_message.StoryMedalInfo)localObject).cover_url.get().toStringUtf8();
          this.type = 10;
          break;
        }
      }
      if (paramStoryMessage.vote_info.has())
      {
        localObject = (qqstory_710_message.StoryVoteInfo)paramStoryMessage.vote_info.get();
        this.ayI = ((qqstory_710_message.StoryVoteInfo)localObject).union_id.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryVoteInfo)localObject).vote_time.get() * 1000L);
        if (((qqstory_710_message.StoryVoteInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          this.isVip = bool1;
          bool1 = bool4;
          if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.has())
          {
            bool1 = bool4;
            if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.get() == 1) {
              bool1 = true;
            }
          }
          this.deleted = bool1;
          this.ayQ = ((qqstory_710_message.StoryVoteInfo)localObject).vote_question.get().toStringUtf8();
          this.ayR = ((qqstory_710_message.StoryVoteInfo)localObject).vote_answer.get().toStringUtf8();
          this.nickPostfix = ((qqstory_710_message.StoryVoteInfo)localObject).nick_postfix.get().toStringUtf8();
          if (((qqstory_710_message.StoryVoteInfo)localObject).vote_type.get() != 1) {
            break label1523;
          }
          this.type = 12;
          break;
        }
        label1523:
        if (((qqstory_710_message.StoryVoteInfo)localObject).is_my_vote.get() == 1) {
          this.type = 13;
        } else {
          this.type = 14;
        }
      }
      else if (paramStoryMessage.grade_info.has())
      {
        localObject = (qqstory_710_message.StoryGradeInfo)paramStoryMessage.grade_info.get();
        this.ayI = ((qqstory_710_message.StoryGradeInfo)localObject).union_id.get().toStringUtf8();
        this.Bn = (((qqstory_710_message.StoryGradeInfo)localObject).grade_time.get() * 1000L);
        if (((qqstory_710_message.StoryGradeInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          this.isVip = bool1;
          bool1 = bool5;
          if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.has())
          {
            bool1 = bool5;
            if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.get() == 1) {
              bool1 = true;
            }
          }
          this.deleted = bool1;
          this.ayS = ((qqstory_710_message.StoryGradeInfo)localObject).grade_question.get().toStringUtf8();
          this.bok = ((qqstory_710_message.StoryGradeInfo)localObject).grade_option.get();
          this.nickPostfix = ((qqstory_710_message.StoryGradeInfo)localObject).nick_postfix.get().toStringUtf8();
          if (((qqstory_710_message.StoryGradeInfo)localObject).grade_type.get() != 1) {
            break label1730;
          }
          this.type = 15;
          break;
        }
        label1730:
        if (((qqstory_710_message.StoryGradeInfo)localObject).is_my_grade.get() == 1) {
          this.type = 16;
        } else {
          this.type = 17;
        }
      }
      else
      {
        if (paramStoryMessage.photo_info.has())
        {
          localObject = (qqstory_710_message.StoryPhotoTogetherInfo)paramStoryMessage.photo_info.get();
          this.ayI = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).union_id.get().toStringUtf8();
          this.Bn = (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_time.get() * 1000L);
          if (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).is_bigv.get() == 1)
          {
            bool1 = true;
            label1828:
            this.isVip = bool1;
            if ((!((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.has()) || (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.get() != 1)) {
              break label1935;
            }
            bool1 = true;
            label1858:
            this.deleted = bool1;
            if ((!((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.has()) || (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.get() != 1)) {
              break label1940;
            }
          }
          label1935:
          label1940:
          for (bool1 = bool3;; bool1 = false)
          {
            this.aFB = bool1;
            this.feedId = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_feed_id.get().toStringUtf8();
            this.boi = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).at_video_ts.get();
            this.type = 18;
            break;
            bool1 = false;
            break label1828;
            bool1 = false;
            break label1858;
          }
        }
        if (paramStoryMessage.chall_info.has())
        {
          localObject = (qqstory_710_message.StoryChallengeInfo)paramStoryMessage.chall_info.get();
          this.commentId = ((qqstory_710_message.StoryChallengeInfo)localObject).comment_id.get();
          this.Bn = (((qqstory_710_message.StoryChallengeInfo)localObject).challenge_time.get() * 1000L);
          this.commentContent = ((qqstory_710_message.StoryChallengeInfo)localObject).content.get().toStringUtf8();
          if (((qqstory_710_message.StoryChallengeInfo)localObject).comment_del.get() == 1)
          {
            bool1 = true;
            label2025:
            this.aFC = bool1;
            if (((qqstory_710_message.StoryChallengeInfo)localObject).video_del.get() != 1) {
              break label2094;
            }
          }
          label2094:
          for (bool1 = bool7;; bool1 = false)
          {
            this.aFD = bool1;
            this.ayI = ((qqstory_710_message.StoryChallengeInfo)localObject).union_id.get().toStringUtf8();
            this.ayT = ((qqstory_710_message.StoryChallengeInfo)localObject).challenge_feed_id.get().toStringUtf8();
            this.type = 19;
            break;
            bool1 = false;
            break label2025;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("MessageData", 2, "Story message item wrong data, no info in response.");
        }
        this.Zm = false;
      }
    }
  }
  
  public String getTime()
  {
    if (this.ayO == null) {
      this.ayO = qwq.aF(this.Bn);
    }
    return this.ayO;
  }
  
  public String mN()
  {
    if (this.ayP == null) {
      this.ayP = rpn.gm(this.coverUrl);
    }
    return this.ayP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quo
 * JD-Core Version:    0.7.0.1
 */