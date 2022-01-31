package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.Iterator;
import java.util.List;

public class AccountDetail
  extends Entity
{
  public byte[] accountData = null;
  public int accountFlag = 0;
  public int certifiedGrade = 0;
  public String displayNumber = "";
  public int followType = 0;
  public int groupId = 0;
  public List groupInfoList;
  public boolean isAgreeSyncLbs = false;
  public boolean isConfirmed = false;
  public boolean isRecvMsg = false;
  public boolean isRecvPush = false;
  public boolean isShowFollowButton = false;
  public boolean isShowShareButton = false;
  public boolean isSyncLbs = false;
  public int mShowMsgFlag = -1;
  public String name = "公众帐号";
  public int seqno = 0;
  public int showFlag = 0;
  public String summary = "挺好的";
  @unique
  public String uin;
  
  public AccountDetail() {}
  
  public AccountDetail(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    this.uin = ("" + (paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.mShowMsgFlag = -1;
    int i;
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has())
    {
      paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
      if ((paramGetPublicAccountDetailInfoResponse != null) && (paramGetPublicAccountDetailInfoResponse.size() > 0))
      {
        paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
        i = 0;
        if (paramGetPublicAccountDetailInfoResponse.hasNext())
        {
          Object localObject = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
            break label446;
          }
          localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
              if (localConfigInfo.state_id.get() == 5) {
                if (localConfigInfo.state.get() == 1)
                {
                  i = 1;
                  label426:
                  this.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label446:
    for (;;)
    {
      if (i != 0)
      {
        return;
        i = 0;
        break label426;
      }
      break;
    }
  }
  
  public void clone(AccountDetail paramAccountDetail)
  {
    this.uin = paramAccountDetail.uin;
    this.seqno = paramAccountDetail.seqno;
    this.name = paramAccountDetail.name;
    this.summary = paramAccountDetail.summary;
    this.isRecvMsg = paramAccountDetail.isRecvMsg;
    this.followType = paramAccountDetail.followType;
    this.isShowFollowButton = paramAccountDetail.isShowFollowButton;
    this.accountData = paramAccountDetail.accountData;
    this.groupInfoList = paramAccountDetail.groupInfoList;
    this.displayNumber = paramAccountDetail.displayNumber;
    this.groupId = paramAccountDetail.groupId;
    this.isRecvPush = paramAccountDetail.isRecvPush;
    this.isSyncLbs = paramAccountDetail.isSyncLbs;
    this.certifiedGrade = paramAccountDetail.certifiedGrade;
    this.showFlag = paramAccountDetail.showFlag;
    this.accountFlag = paramAccountDetail.accountFlag;
    this.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.AccountDetail
 * JD-Core Version:    0.7.0.1
 */