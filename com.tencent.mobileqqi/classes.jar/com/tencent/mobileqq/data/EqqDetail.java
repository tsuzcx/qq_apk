package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EqqDetail
  extends Entity
{
  public byte[] accountData = null;
  public String address = "";
  public int certifiedGrade = 0;
  public String displayNumber = "";
  public int followType = 0;
  public List groupInfoList;
  public boolean isConfirmed = false;
  public boolean isRecvMsg = false;
  public String latitude = "";
  public String longitude = "";
  public boolean mIsAgreeSyncLbs = false;
  public boolean mIsSyncLbs = false;
  public boolean mIsSyncLbsSelected = false;
  public int mShowMsgFlag = -1;
  public String name = "公众帐号";
  public String phoneNumber = "";
  public int seqno = 0;
  public String summary = "挺好的";
  @unique
  public String uin;
  
  public EqqDetail() {}
  
  public EqqDetail(mobileqq_mp.GetEqqAccountDetailInfoResponse paramGetEqqAccountDetailInfoResponse)
  {
    Object localObject = (mobileqq_mp.EqqAccountInfo)paramGetEqqAccountDetailInfoResponse.accountInfo.get();
    this.uin = ("" + (((mobileqq_mp.EqqAccountInfo)localObject).uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetEqqAccountDetailInfoResponse.seqno.get();
    this.name = ((mobileqq_mp.EqqAccountInfo)localObject).name.get();
    this.summary = ((mobileqq_mp.EqqAccountInfo)localObject).summary.get();
    this.isRecvMsg = paramGetEqqAccountDetailInfoResponse.is_recv_msg.get();
    this.groupInfoList = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetEqqAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = ((mobileqq_mp.EqqAccountInfo)localObject).display_number.get();
    this.phoneNumber = paramGetEqqAccountDetailInfoResponse.phone_number.get();
    this.certifiedGrade = ((mobileqq_mp.EqqAccountInfo)localObject).certified_grade.get();
    this.latitude = paramGetEqqAccountDetailInfoResponse.lat.get();
    this.longitude = paramGetEqqAccountDetailInfoResponse.lng.get();
    this.address = paramGetEqqAccountDetailInfoResponse.address.get();
    this.accountData = paramGetEqqAccountDetailInfoResponse.toByteArray();
    this.mShowMsgFlag = -1;
    int i;
    int j;
    int n;
    int k;
    if ((paramGetEqqAccountDetailInfoResponse.config_group_info.has()) && (!paramGetEqqAccountDetailInfoResponse.config_group_info.isEmpty()))
    {
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
      if ((paramGetEqqAccountDetailInfoResponse != null) && (paramGetEqqAccountDetailInfoResponse.size() > 0))
      {
        paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.iterator();
        i = 0;
        j = 0;
        if (paramGetEqqAccountDetailInfoResponse.hasNext())
        {
          localObject = (mobileqq_mp.ConfigGroupInfo)paramGetEqqAccountDetailInfoResponse.next();
          n = i;
          k = j;
          if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
          {
            n = i;
            k = j;
            if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty())
            {
              localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
              int m = j;
              j = i;
              label477:
              label628:
              do
              {
                do
                {
                  n = j;
                  k = m;
                  if (!((Iterator)localObject).hasNext()) {
                    break label723;
                  }
                  mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
                  k = m;
                  if (localConfigInfo.state_id.get() == 5)
                  {
                    if (localConfigInfo.state.get() != 1) {
                      break;
                    }
                    i = 1;
                    this.mShowMsgFlag = i;
                    k = 1;
                  }
                  i = j;
                  if (localConfigInfo.type.has())
                  {
                    i = j;
                    if (localConfigInfo.type.get() == 2)
                    {
                      i = j;
                      if (localConfigInfo.state_id.has())
                      {
                        i = j;
                        if (localConfigInfo.state_id.get() == 3)
                        {
                          this.mIsSyncLbs = true;
                          if (!localConfigInfo.state.has()) {}
                        }
                      }
                    }
                  }
                  switch (localConfigInfo.state.get())
                  {
                  default: 
                    if (QLog.isColorLevel()) {
                      QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localConfigInfo.state.get());
                    }
                    i = 1;
                    j = i;
                    m = k;
                  }
                } while (k == 0);
                j = i;
                m = k;
              } while (i == 0);
              j = k;
              label652:
              if ((j == 0) || (i == 0)) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.mIsSyncLbs = false;
      }
      return;
      i = 0;
      break label477;
      this.mIsSyncLbsSelected = false;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label628;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = true;
      i = 1;
      break label628;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label628;
      break;
      label723:
      i = n;
      j = k;
      break label652;
      continue;
      i = 0;
    }
  }
  
  public void clone(EqqDetail paramEqqDetail)
  {
    this.uin = paramEqqDetail.uin;
    this.seqno = paramEqqDetail.seqno;
    this.name = paramEqqDetail.name;
    this.summary = paramEqqDetail.summary;
    this.isRecvMsg = paramEqqDetail.isRecvMsg;
    this.followType = paramEqqDetail.followType;
    this.latitude = paramEqqDetail.latitude;
    this.longitude = paramEqqDetail.longitude;
    this.accountData = paramEqqDetail.accountData;
    this.groupInfoList = paramEqqDetail.groupInfoList;
    this.displayNumber = paramEqqDetail.displayNumber;
    this.certifiedGrade = paramEqqDetail.certifiedGrade;
    this.address = paramEqqDetail.address;
    this.phoneNumber = paramEqqDetail.phoneNumber;
    this.mShowMsgFlag = paramEqqDetail.mShowMsgFlag;
    this.mIsSyncLbs = paramEqqDetail.mIsSyncLbs;
    this.mIsAgreeSyncLbs = paramEqqDetail.mIsAgreeSyncLbs;
    this.mIsSyncLbsSelected = paramEqqDetail.mIsSyncLbsSelected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.EqqDetail
 * JD-Core Version:    0.7.0.1
 */