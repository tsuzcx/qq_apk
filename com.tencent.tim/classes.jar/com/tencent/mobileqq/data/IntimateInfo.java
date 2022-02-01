package com.tencent.mobileqq.data;

import acff;
import aezl;
import ajnu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScoreCard;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.OneGroupInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.SpecialWordInfo;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c.RspBody;
import tencent.im.oidb.recheck_flag_info.recheck_flag_info.RecheckFlagInfo;

public class IntimateInfo
  extends Entity
{
  public int addFriendSource = -1;
  public int addFriendSubSource = -1;
  public String addFriendWording;
  public int beFriendDays = -2;
  @notColumn
  public List<oidb_0xcf4.CommonBody> commonBodies;
  @notColumn
  public List<CommonBody> commonBodyList;
  public String commonBodyListStr;
  @notColumn
  public List<CommonTroopInfo> commonTroopInfoList;
  public String commonTroopInfoListJsonStr;
  public String commonTroopTips;
  public int currentScore;
  @notColumn
  public List<DNAInfo> dnaInfoList;
  public String dnaInfoListJonStr;
  public FriendGiftInfo friendGiftInfo;
  @unique
  public String friendUin;
  public boolean isFriend = true;
  @notColumn
  public boolean isShowRedPoint;
  public int lastAnimAfterFriendDays;
  public int lastAnimAfterScore;
  @notColumn
  public int mCanRecheckCount;
  @notColumn
  public List<MutualMarkInfo> markInfoList;
  public String markInfoListJsonStr;
  public int maskDays;
  public int maskLevel;
  public int maskType;
  @notColumn
  public List<MemoryDayInfo> memoryDayInfoList;
  public String memoryDayListJsonStr;
  @notColumn
  public List<PrefetchMutualMarkInfo> prefetchMutualMarkInfoList;
  public String prefetchMutualMarkInfoListJsonStr;
  @notColumn
  public CommonTroopInfo recentChatTroopInfo;
  public String recentChatTroopInfoJsonStr;
  @notColumn
  public IntimateScoreCardInfo scoreCardInfo;
  public String scoreCardInfoJsonStr;
  public long updateTimeMills;
  public boolean useNewType;
  
  public static int convert0xcf4Type2MutualMaskType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return 0;
    case 1: 
      return 6;
    case 2: 
      return 5;
    case 3: 
      return 12;
    case 4: 
      return 8;
    case 5: 
      return 7;
    case 9: 
      return 4;
    case 20: 
      return 2;
    case 21: 
      return 3;
    }
    return 1;
  }
  
  public static String convertUinKeyForGroupCard(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public static IntimateInfo copyFrom(QQAppInterface paramQQAppInterface, oidb_0xcf4.RspBody paramRspBody)
  {
    int k = 0;
    int j = -1;
    if ((paramRspBody == null) || (paramQQAppInterface == null)) {
      return null;
    }
    IntimateInfo localIntimateInfo = new IntimateInfo();
    int i;
    if (paramRspBody.uint64_to_uin.has())
    {
      localObject1 = String.valueOf(paramRspBody.uint64_to_uin.get());
      localIntimateInfo.friendUin = ((String)localObject1);
      localIntimateInfo.useNewType = true;
      if (paramRspBody.msg_cur_mutual_mark_info.has())
      {
        localObject1 = (oidb_0xcf4.MutualMarkInfo)paramRspBody.msg_cur_mutual_mark_info.get();
        if (localObject1 != null)
        {
          if (!((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.has()) {
            break label473;
          }
          i = ((oidb_0xcf4.MutualMarkInfo)localObject1).eMutualMarkNewType.get();
          label106:
          localIntimateInfo.maskType = i;
          if (!((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.has()) {
            break label478;
          }
          i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_level.get();
          label132:
          localIntimateInfo.maskLevel = i;
          i = k;
          if (((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.has()) {
            i = ((oidb_0xcf4.MutualMarkInfo)localObject1).uint32_days.get();
          }
          localIntimateInfo.maskDays = i;
        }
      }
      if (paramRspBody.msg_friend_info.has())
      {
        localObject1 = (oidb_0xcf4.FriendInfo)paramRspBody.msg_friend_info.get();
        if (localObject1 != null)
        {
          if (!((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_days.has()) {
            break label483;
          }
          i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_days.get();
          label214:
          localIntimateInfo.beFriendDays = i;
          if (!((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_source.has()) {
            break label488;
          }
          i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_source.get();
          label240:
          localIntimateInfo.addFriendSource = i;
          i = j;
          if (((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_sub_source.has()) {
            i = ((oidb_0xcf4.FriendInfo)localObject1).uint32_add_frd_sub_source.get();
          }
          localIntimateInfo.addFriendSubSource = i;
          if (!((oidb_0xcf4.FriendInfo)localObject1).bytes_add_frd_wording.has()) {
            break label493;
          }
        }
      }
    }
    Object localObject2;
    Object localObject3;
    label473:
    label478:
    label483:
    label488:
    label493:
    for (Object localObject1 = ((oidb_0xcf4.FriendInfo)localObject1).bytes_add_frd_wording.get().toStringUtf8();; localObject1 = "")
    {
      localIntimateInfo.addFriendWording = ((String)localObject1);
      if (!paramRspBody.msg_common_group_chat_info.has()) {
        break label528;
      }
      localObject1 = (oidb_0xcf4.CommonGroupChatInfo)paramRspBody.msg_common_group_chat_info.get();
      if (localObject1 == null) {
        break label528;
      }
      if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.has()) {
        localIntimateInfo.recentChatTroopInfo = CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((oidb_0xcf4.CommonGroupChatInfo)localObject1).msg_one_group_info.get());
      }
      if (!((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.has()) {
        break label501;
      }
      localObject2 = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).rpt_msg_one_group_info.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label501;
      }
      localIntimateInfo.commonTroopInfoList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = CommonTroopInfo.copyFrom((oidb_0xcf4.OneGroupInfo)((Iterator)localObject2).next());
        if (localObject3 != null) {
          localIntimateInfo.commonTroopInfoList.add(localObject3);
        }
      }
      localObject1 = "";
      break;
      i = 0;
      break label106;
      i = 0;
      break label132;
      i = -1;
      break label214;
      i = -1;
      break label240;
    }
    label501:
    if (((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.has()) {
      localIntimateInfo.commonTroopTips = ((oidb_0xcf4.CommonGroupChatInfo)localObject1).bytes_wording.get().toStringUtf8();
    }
    label528:
    if (paramRspBody.rpt_msg_mutual_mark_info.has())
    {
      localObject1 = paramRspBody.rpt_msg_mutual_mark_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localIntimateInfo.markInfoList = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = MutualMarkInfo.copyFrom((oidb_0xcf4.MutualMarkInfo)((Iterator)localObject1).next());
          if ((localObject2 != null) && (ajnu.co(((MutualMarkInfo)localObject2).type))) {
            localIntimateInfo.markInfoList.add(localObject2);
          }
        }
      }
    }
    if (paramRspBody.rpt_msg_prefetch_mutual_mark_info.has())
    {
      localObject1 = paramRspBody.rpt_msg_prefetch_mutual_mark_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localIntimateInfo.prefetchMutualMarkInfoList = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = PrefetchMutualMarkInfo.copyFrom((oidb_0xcf4.PrefetchMutualMarkInfo)((Iterator)localObject1).next());
          if ((localObject2 != null) && (ajnu.co(((PrefetchMutualMarkInfo)localObject2).type))) {
            localIntimateInfo.prefetchMutualMarkInfoList.add(localObject2);
          }
        }
      }
    }
    if (paramRspBody.rpt_msg_dna_info.has())
    {
      localIntimateInfo.dnaInfoList = new ArrayList();
      localObject1 = paramRspBody.rpt_msg_dna_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = DNAInfo.copyFrom((oidb_0xcf4.DnaInfo)((Iterator)localObject1).next());
          if (localObject2 != null) {
            localIntimateInfo.dnaInfoList.add(localObject2);
          }
        }
      }
    }
    if (paramRspBody.rpt_msg_data_tips.has())
    {
      localIntimateInfo.memoryDayInfoList = new ArrayList();
      localObject1 = paramRspBody.rpt_msg_data_tips.get();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = MemoryDayInfo.copyFrom((oidb_0xcf4.DateTips)((Iterator)localObject1).next());
          if (localObject2 != null) {
            localIntimateInfo.memoryDayInfoList.add(localObject2);
          }
        }
      }
    }
    if (paramRspBody.rpt_msg_common_rspbody.has())
    {
      localIntimateInfo.commonBodyList = new ArrayList();
      localObject1 = paramRspBody.rpt_msg_common_rspbody.get();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (oidb_0xcf4.CommonBody)((Iterator)localObject1).next();
          localObject3 = CommonBody.copyFrom((oidb_0xcf4.CommonBody)localObject2);
          if (localObject3 != null)
          {
            localIntimateInfo.commonBodyList.add(localObject3);
            if (((CommonBody)localObject3).cmd == 3436)
            {
              localIntimateInfo.friendGiftInfo = FriendGiftInfo.copyFrom((CommonBody)localObject3);
            }
            else if (((CommonBody)localObject3).cmd == 3399)
            {
              localObject2 = ((oidb_0xcf4.CommonBody)localObject2).string_oidb_body.get().toByteArray();
              try
              {
                localObject3 = new recheck_flag_info.RecheckFlagInfo();
                ((recheck_flag_info.RecheckFlagInfo)localObject3).mergeFrom((byte[])localObject2);
                localIntimateInfo.isShowRedPoint = ((recheck_flag_info.RecheckFlagInfo)localObject3).bool_has_redtouch.get();
                localIntimateInfo.mCanRecheckCount = ((recheck_flag_info.RecheckFlagInfo)localObject3).uint32_recheck_num.get();
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel()) {
                QLog.w("intimate_relationship", 2, "parse 0xd47 body exception:" + localException.getStackTrace());
              }
            }
          }
        }
      }
    }
    if (paramRspBody.rpt_msg_mutual_score_card.has())
    {
      localIntimateInfo.scoreCardInfo = IntimateScoreCardInfo.copyFrom((oidb_0xcf4.MutualScoreCard)paramRspBody.rpt_msg_mutual_score_card.get());
      if (localIntimateInfo.scoreCardInfo != null) {
        localIntimateInfo.currentScore = localIntimateInfo.scoreCardInfo.score;
      }
    }
    localIntimateInfo.updateTimeMills = NetConnInfoCenter.getServerTimeMillis();
    localIntimateInfo.isFriend = ((acff)paramQQAppInterface.getManager(51)).isFriend(localIntimateInfo.friendUin);
    localIntimateInfo.commonBodies = paramRspBody.rpt_msg_common_rspbody.get();
    return localIntimateInfo;
  }
  
  public static String getUinFromGroupCardKey(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("_");
      str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length >= 2) {
          str = arrayOfString[1];
        }
      }
    }
    return str;
  }
  
  public void postRead()
  {
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(this.commonTroopInfoListJsonStr)) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.commonTroopInfoListJsonStr);
        i = 0;
        while (i < localJSONArray1.length())
        {
          localObject = CommonTroopInfo.copyFromJson(localJSONArray1.getJSONObject(i));
          if (localObject != null)
          {
            if (this.commonTroopInfoList == null) {
              this.commonTroopInfoList = new ArrayList();
            }
            this.commonTroopInfoList.add(localObject);
          }
          i += 1;
        }
        if (TextUtils.isEmpty(this.recentChatTroopInfoJsonStr)) {}
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    for (;;)
    {
      try
      {
        this.recentChatTroopInfo = CommonTroopInfo.copyFromJson(new JSONObject(this.recentChatTroopInfoJsonStr));
        if (TextUtils.isEmpty(this.markInfoListJsonStr)) {
          break label305;
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          JSONArray localJSONArray2 = new JSONArray(this.markInfoListJsonStr);
          i = 0;
          if (i >= localJSONArray2.length()) {
            break;
          }
          localObject = MutualMarkInfo.copyFromJson(localJSONArray2.getJSONObject(i));
          if (localObject != null)
          {
            if (this.markInfoList == null) {
              this.markInfoList = new ArrayList();
            }
            this.markInfoList.add(localObject);
          }
          i += 1;
          continue;
          this.commonTroopInfoList = null;
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
        }
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
        continue;
      }
      this.recentChatTroopInfo = null;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.prefetchMutualMarkInfoListJsonStr)) {
        try
        {
          JSONArray localJSONArray3 = new JSONArray(this.prefetchMutualMarkInfoListJsonStr);
          i = 0;
          while (i < localJSONArray3.length())
          {
            localObject = PrefetchMutualMarkInfo.copyFromJson(localJSONArray3.getJSONObject(i));
            if (localObject != null)
            {
              if (this.prefetchMutualMarkInfoList == null) {
                this.prefetchMutualMarkInfoList = new ArrayList();
              }
              this.prefetchMutualMarkInfoList.add(localObject);
            }
            i += 1;
            continue;
            label305:
            this.markInfoList = null;
          }
        }
        catch (JSONException localJSONException4)
        {
          localJSONException4.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.dnaInfoListJonStr)) {
        try
        {
          JSONArray localJSONArray4 = new JSONArray(this.dnaInfoListJonStr);
          i = 0;
          while (i < localJSONArray4.length())
          {
            localObject = DNAInfo.copyFromJson(localJSONArray4.getJSONObject(i));
            if (localObject != null)
            {
              if (this.dnaInfoList == null) {
                this.dnaInfoList = new ArrayList();
              }
              this.dnaInfoList.add(localObject);
            }
            i += 1;
            continue;
            this.prefetchMutualMarkInfoList = null;
          }
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.memoryDayListJsonStr)) {
        try
        {
          JSONArray localJSONArray5 = new JSONArray(this.memoryDayListJsonStr);
          i = 0;
          while (i < localJSONArray5.length())
          {
            localObject = MemoryDayInfo.copyFromJson(localJSONArray5.getJSONObject(i));
            if (localObject != null)
            {
              if (this.memoryDayInfoList == null) {
                this.memoryDayInfoList = new ArrayList();
              }
              this.memoryDayInfoList.add(localObject);
            }
            i += 1;
            continue;
            this.dnaInfoList = null;
          }
        }
        catch (JSONException localJSONException6)
        {
          localJSONException6.printStackTrace();
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.commonBodyListStr)) {
        try
        {
          JSONArray localJSONArray6 = new JSONArray(this.commonBodyListStr);
          i = 0;
          while (i < localJSONArray6.length())
          {
            localObject = CommonBody.copyFromJson(localJSONArray6.getJSONObject(i));
            if (localObject != null)
            {
              if (this.commonBodyList == null) {
                this.commonBodyList = new ArrayList();
              }
              this.commonBodyList.add(localObject);
              if ((((CommonBody)localObject).cmd == 3436) && (((CommonBody)localObject).rspBodyContent != null)) {
                this.friendGiftInfo = FriendGiftInfo.copyFrom((CommonBody)localObject);
              }
            }
            i += 1;
            continue;
            this.memoryDayInfoList = null;
          }
        }
        catch (JSONException localJSONException7)
        {
          localJSONException7.printStackTrace();
        }
      }
    }
    while (!this.useNewType)
    {
      this.useNewType = true;
      this.maskType = convert0xcf4Type2MutualMaskType(this.maskType);
      Iterator localIterator;
      if (this.markInfoList != null)
      {
        localIterator = this.markInfoList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (MutualMarkInfo)localIterator.next();
            ((MutualMarkInfo)localObject).type = convert0xcf4Type2MutualMaskType(((MutualMarkInfo)localObject).type);
            continue;
            this.commonBodyList = null;
            break;
          }
        }
      }
      if (this.prefetchMutualMarkInfoList != null)
      {
        localIterator = this.prefetchMutualMarkInfoList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (PrefetchMutualMarkInfo)localIterator.next();
          ((PrefetchMutualMarkInfo)localObject).type = convert0xcf4Type2MutualMaskType(((PrefetchMutualMarkInfo)localObject).type);
        }
      }
    }
    if (!TextUtils.isEmpty(this.scoreCardInfoJsonStr)) {
      try
      {
        this.scoreCardInfo = IntimateScoreCardInfo.copyFromJson(new JSONObject(this.scoreCardInfoJsonStr));
        return;
      }
      catch (JSONException localJSONException8)
      {
        localJSONException8.printStackTrace();
        return;
      }
    }
    this.scoreCardInfo = null;
  }
  
  public void prewrite()
  {
    Object localObject;
    Iterator localIterator;
    if ((this.commonTroopInfoList != null) && (this.commonTroopInfoList.size() > 0))
    {
      localObject = new JSONArray();
      localIterator = this.commonTroopInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((CommonTroopInfo)localIterator.next()).getJSONObject());
      }
    }
    for (this.commonTroopInfoListJsonStr = ((JSONArray)localObject).toString();; this.commonTroopInfoListJsonStr = "")
    {
      if (this.recentChatTroopInfo != null)
      {
        localObject = this.recentChatTroopInfo.getJSONObject();
        if (localObject != null) {
          this.recentChatTroopInfoJsonStr = ((JSONObject)localObject).toString();
        }
      }
      if ((this.markInfoList == null) || (this.markInfoList.size() <= 0)) {
        break label251;
      }
      localObject = new JSONArray();
      localIterator = this.markInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((MutualMarkInfo)localIterator.next()).getJSONObject());
      }
    }
    label251:
    for (this.markInfoListJsonStr = ((JSONArray)localObject).toString();; this.markInfoListJsonStr = "")
    {
      if ((this.prefetchMutualMarkInfoList == null) || (this.prefetchMutualMarkInfoList.size() <= 0)) {
        break label335;
      }
      localObject = new JSONArray();
      localIterator = this.prefetchMutualMarkInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((PrefetchMutualMarkInfo)localIterator.next()).getJSONObject());
      }
    }
    label335:
    for (this.prefetchMutualMarkInfoListJsonStr = ((JSONArray)localObject).toString();; this.prefetchMutualMarkInfoListJsonStr = "")
    {
      if ((this.dnaInfoList == null) || (this.dnaInfoList.size() <= 0)) {
        break label407;
      }
      localObject = new JSONArray();
      localIterator = this.dnaInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((DNAInfo)localIterator.next()).getJSONObject());
      }
    }
    label407:
    for (this.dnaInfoListJonStr = ((JSONArray)localObject).toString();; this.dnaInfoListJonStr = "")
    {
      if (this.memoryDayInfoList == null) {
        break label491;
      }
      localObject = new JSONArray();
      localIterator = this.memoryDayInfoList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((MemoryDayInfo)localIterator.next()).getJSONObject());
      }
    }
    label491:
    for (this.memoryDayListJsonStr = ((JSONArray)localObject).toString();; this.memoryDayListJsonStr = "")
    {
      if ((this.commonBodyList == null) || (this.commonBodyList.size() <= 0)) {
        break label531;
      }
      localObject = new JSONArray();
      localIterator = this.commonBodyList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(((CommonBody)localIterator.next()).getJSONObject());
      }
    }
    label531:
    for (this.commonBodyListStr = ((JSONArray)localObject).toString(); this.scoreCardInfo != null; this.commonBodyListStr = "")
    {
      this.scoreCardInfoJsonStr = this.scoreCardInfo.getJSONObject().toString();
      return;
    }
    this.scoreCardInfoJsonStr = "";
  }
  
  public String toString()
  {
    return "IntimateInfo{friendUin='" + this.friendUin + '\'' + ", maskType=" + this.maskType + ", maskLevel=" + this.maskLevel + ", maskDays=" + this.maskDays + ", useNewType=" + this.useNewType + ", beFriendDays=" + this.beFriendDays + ", lastAnimAfterFriendDays=" + this.lastAnimAfterFriendDays + ", currentScore=" + this.currentScore + ", lastAnimAfterScore=" + this.lastAnimAfterScore + ", addFriendSource=" + this.addFriendSource + ", addFriendSubSource=" + this.addFriendSubSource + ", addFriendWording=" + this.addFriendWording + ", commonTroopInfoList=" + this.commonTroopInfoList + ", recentChatTroopInfo=" + this.recentChatTroopInfo + ", commonTroopTips=" + this.commonTroopTips + ", dnaInfoList=" + this.dnaInfoList + ", memoryDayInfoList=" + this.memoryDayInfoList + ", isFriend=" + this.isFriend + ", updateTimeMills=" + this.updateTimeMills + ", scoreCardInfo=" + this.scoreCardInfo + '}';
  }
  
  public static class CommonBody
  {
    public int cmd;
    public byte[] rspBodyContent;
    
    public static CommonBody copyFrom(oidb_0xcf4.CommonBody paramCommonBody)
    {
      if (paramCommonBody == null) {
        return null;
      }
      CommonBody localCommonBody = new CommonBody();
      int i;
      if (paramCommonBody.uint32_oidb_cmd.has())
      {
        i = paramCommonBody.uint32_oidb_cmd.get();
        localCommonBody.cmd = i;
        if (!paramCommonBody.string_oidb_body.has()) {
          break label70;
        }
      }
      label70:
      for (paramCommonBody = paramCommonBody.string_oidb_body.get().toByteArray();; paramCommonBody = null)
      {
        localCommonBody.rspBodyContent = paramCommonBody;
        return localCommonBody;
        i = 0;
        break;
      }
    }
    
    public static CommonBody copyFromJson(JSONObject paramJSONObject)
    {
      CommonBody localCommonBody = new CommonBody();
      localCommonBody.cmd = paramJSONObject.optInt("cmd");
      localCommonBody.rspBodyContent = Base64.decode(paramJSONObject.optString("rspBodyContent"), 0);
      return localCommonBody;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("cmd", this.cmd);
        localJSONObject.put("rspBodyContent", Base64.encodeToString(this.rspBodyContent, 0));
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "CommonBody{cmd=" + this.cmd + ", rspBodyContent=" + this.rspBodyContent.toString();
    }
  }
  
  public static class CommonTroopInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<CommonTroopInfo> CREATOR = new aezl();
    public long recentMsgTime;
    public String troopCode;
    public String troopName;
    public String troopUin;
    
    public CommonTroopInfo() {}
    
    public CommonTroopInfo(Parcel paramParcel)
    {
      this.troopUin = paramParcel.readString();
      this.troopCode = paramParcel.readString();
      this.troopName = paramParcel.readString();
      this.recentMsgTime = paramParcel.readLong();
    }
    
    public static CommonTroopInfo copyFrom(oidb_0xcf4.OneGroupInfo paramOneGroupInfo)
    {
      if (paramOneGroupInfo == null) {
        return null;
      }
      CommonTroopInfo localCommonTroopInfo = new CommonTroopInfo();
      String str;
      if (paramOneGroupInfo.uint64_group_uin.has())
      {
        str = String.valueOf(paramOneGroupInfo.uint64_group_uin.get());
        localCommonTroopInfo.troopUin = str;
        if (!paramOneGroupInfo.uint64_group_code.has()) {
          break label130;
        }
        str = String.valueOf(paramOneGroupInfo.uint64_group_code.get());
        label63:
        localCommonTroopInfo.troopCode = str;
        if (!paramOneGroupInfo.string_group_name.has()) {
          break label136;
        }
        str = paramOneGroupInfo.string_group_name.get().toStringUtf8();
        label90:
        localCommonTroopInfo.troopName = str;
        if (!paramOneGroupInfo.uint32_cmduin_last_msg_time.has()) {
          break label142;
        }
      }
      label130:
      label136:
      label142:
      for (long l = paramOneGroupInfo.uint32_cmduin_last_msg_time.get();; l = 0L)
      {
        localCommonTroopInfo.recentMsgTime = l;
        return localCommonTroopInfo;
        str = "";
        break;
        str = "";
        break label63;
        str = "";
        break label90;
      }
    }
    
    public static CommonTroopInfo copyFromJson(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return null;
      }
      CommonTroopInfo localCommonTroopInfo = new CommonTroopInfo();
      localCommonTroopInfo.troopUin = paramJSONObject.optString("troopUin", "");
      localCommonTroopInfo.troopCode = paramJSONObject.optString("troopCode", "");
      localCommonTroopInfo.troopName = paramJSONObject.optString("troopName", "");
      localCommonTroopInfo.recentMsgTime = paramJSONObject.optLong("recentMsgTime", 0L);
      return localCommonTroopInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(this.troopUin)) {
          localJSONObject.put("troopUin", this.troopUin);
        }
        if (!TextUtils.isEmpty(this.troopCode)) {
          localJSONObject.put("troopCode", this.troopCode);
        }
        if (!TextUtils.isEmpty(this.troopName)) {
          localJSONObject.put("troopName", this.troopName);
        }
        localJSONObject.put("recentMsgTime", this.recentMsgTime);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "CommonTroopInfo{troopUin='" + this.troopUin + '\'' + ", troopCode='" + this.troopCode + '\'' + ", troopName='" + this.troopName + '\'' + ", recentMsgTime=" + this.recentMsgTime + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.troopUin);
      paramParcel.writeString(this.troopCode);
      paramParcel.writeString(this.troopName);
      paramParcel.writeLong(this.recentMsgTime);
    }
  }
  
  public static class DNAInfo
  {
    public String iconUrl;
    public String linkColor;
    public String linkUrl;
    public String linkWording;
    public int type;
    public String viceTitle;
    public String wording;
    
    public static DNAInfo copyFrom(oidb_0xcf4.DnaInfo paramDnaInfo)
    {
      if (paramDnaInfo == null) {
        return null;
      }
      DNAInfo localDNAInfo = new DNAInfo();
      int i;
      String str;
      if (paramDnaInfo.eDnaType.has())
      {
        i = paramDnaInfo.eDnaType.get();
        localDNAInfo.type = i;
        if (!paramDnaInfo.bytes_icon_url.has()) {
          break label200;
        }
        str = paramDnaInfo.bytes_icon_url.get().toStringUtf8();
        label58:
        localDNAInfo.iconUrl = str;
        if (!paramDnaInfo.bytes_wording.has()) {
          break label206;
        }
        str = paramDnaInfo.bytes_wording.get().toStringUtf8();
        label84:
        localDNAInfo.wording = str;
        if (!paramDnaInfo.bytes_vice_title.has()) {
          break label212;
        }
        str = paramDnaInfo.bytes_vice_title.get().toStringUtf8();
        label110:
        localDNAInfo.viceTitle = str;
        if (!paramDnaInfo.bytes_link_url.has()) {
          break label218;
        }
        str = paramDnaInfo.bytes_link_url.get().toStringUtf8();
        label136:
        localDNAInfo.linkUrl = str;
        if (!paramDnaInfo.bytes_link_wording.has()) {
          break label224;
        }
        str = paramDnaInfo.bytes_link_wording.get().toStringUtf8();
        label162:
        localDNAInfo.linkWording = str;
        if (!paramDnaInfo.bytes_link_colour.has()) {
          break label230;
        }
      }
      label200:
      label206:
      label212:
      label218:
      label224:
      label230:
      for (paramDnaInfo = paramDnaInfo.bytes_link_colour.get().toStringUtf8();; paramDnaInfo = "")
      {
        localDNAInfo.linkColor = paramDnaInfo;
        return localDNAInfo;
        i = 0;
        break;
        str = "";
        break label58;
        str = "";
        break label84;
        str = "";
        break label110;
        str = "";
        break label136;
        str = "";
        break label162;
      }
    }
    
    public static DNAInfo copyFromJson(JSONObject paramJSONObject)
    {
      DNAInfo localDNAInfo = new DNAInfo();
      localDNAInfo.type = paramJSONObject.optInt("type");
      localDNAInfo.iconUrl = paramJSONObject.optString("iconUrl");
      localDNAInfo.wording = paramJSONObject.optString("wording");
      localDNAInfo.viceTitle = paramJSONObject.optString("viceTitle");
      localDNAInfo.linkUrl = paramJSONObject.optString("linkUrl");
      localDNAInfo.linkWording = paramJSONObject.optString("linkWording");
      localDNAInfo.linkColor = paramJSONObject.optString("linkColor");
      return localDNAInfo;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", this.type);
        localJSONObject.put("iconUrl", this.iconUrl);
        localJSONObject.put("wording", this.wording);
        localJSONObject.put("viceTitle", this.viceTitle);
        localJSONObject.put("linkUrl", this.linkUrl);
        localJSONObject.put("linkWording", this.linkWording);
        localJSONObject.put("linkColor", this.linkColor);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "DNAInfo{type=" + this.type + ", iconUrl='" + this.iconUrl + '\'' + ", wording='" + this.wording + '\'' + ", viceTitle='" + this.viceTitle + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", linkWording='" + this.linkWording + '\'' + ", linkColor='" + this.linkColor + '\'' + '}';
    }
  }
  
  public static class FriendGiftInfo
  {
    public String str_custom_url;
    public String str_desc;
    public List<String> str_gift_url;
    public int str_send_times;
    
    public static FriendGiftInfo copyFrom(IntimateInfo.CommonBody paramCommonBody)
    {
      if (paramCommonBody == null) {
        return null;
      }
      FriendGiftInfo localFriendGiftInfo = new FriendGiftInfo();
      oidb_0xd6c.RspBody localRspBody = new oidb_0xd6c.RspBody();
      for (;;)
      {
        try
        {
          localRspBody = (oidb_0xd6c.RspBody)localRspBody.mergeFrom(paramCommonBody.rspBodyContent);
          if (localRspBody.str_gift_url.has())
          {
            paramCommonBody = localRspBody.str_gift_url.get();
            localFriendGiftInfo.str_gift_url = paramCommonBody;
            if (!localRspBody.str_custom_url.has()) {
              break label147;
            }
            paramCommonBody = localRspBody.str_custom_url.get();
            localFriendGiftInfo.str_custom_url = paramCommonBody;
            if (localRspBody.str_desc.has())
            {
              paramCommonBody = localRspBody.str_desc.get();
              localFriendGiftInfo.str_desc = paramCommonBody;
              if (localRspBody.str_send_times.has())
              {
                i = localRspBody.str_send_times.get();
                localFriendGiftInfo.str_send_times = i;
                return localFriendGiftInfo;
              }
            }
            else
            {
              paramCommonBody = "";
              continue;
            }
            int i = 0;
            continue;
          }
          paramCommonBody = null;
        }
        catch (Exception paramCommonBody)
        {
          return null;
        }
        continue;
        label147:
        paramCommonBody = "";
      }
    }
    
    public String toString()
    {
      return "FriendGiftInfo{str_gift_url=" + this.str_gift_url + "str_send_times=" + this.str_send_times + "str_desc=" + this.str_desc + "str_custom_url=" + this.str_custom_url + '}';
    }
  }
  
  public static class IntimateScoreCardInfo
  {
    public String buttonDescribe;
    public String buttonUrl;
    public int days;
    public int level;
    public String levelDescribe;
    public int score;
    public String title;
    public long type;
    public String typeDescribe;
    
    public static IntimateScoreCardInfo copyFrom(oidb_0xcf4.MutualScoreCard paramMutualScoreCard)
    {
      Object localObject;
      if (paramMutualScoreCard == null) {
        localObject = null;
      }
      IntimateScoreCardInfo localIntimateScoreCardInfo;
      do
      {
        return localObject;
        localIntimateScoreCardInfo = new IntimateScoreCardInfo();
        localIntimateScoreCardInfo.type = paramMutualScoreCard.eMutualMarkNewType.get();
        localIntimateScoreCardInfo.level = paramMutualScoreCard.uint32_level.get();
        localIntimateScoreCardInfo.days = paramMutualScoreCard.uint32_days.get();
        if (paramMutualScoreCard.bytes_title.has()) {
          localIntimateScoreCardInfo.title = paramMutualScoreCard.bytes_title.get().toStringUtf8();
        }
        localIntimateScoreCardInfo.score = paramMutualScoreCard.uint32_score.get();
        if (paramMutualScoreCard.bytes_type_describe.has()) {
          localIntimateScoreCardInfo.typeDescribe = paramMutualScoreCard.bytes_type_describe.get().toStringUtf8();
        }
        if (paramMutualScoreCard.bytes_level_describe.has()) {
          localIntimateScoreCardInfo.levelDescribe = paramMutualScoreCard.bytes_level_describe.get().toStringUtf8();
        }
        if (paramMutualScoreCard.bytes_button_describe.has()) {
          localIntimateScoreCardInfo.buttonDescribe = paramMutualScoreCard.bytes_button_describe.get().toStringUtf8();
        }
        localObject = localIntimateScoreCardInfo;
      } while (!paramMutualScoreCard.bytes_button_url.has());
      localIntimateScoreCardInfo.buttonUrl = paramMutualScoreCard.bytes_button_url.get().toStringUtf8();
      return localIntimateScoreCardInfo;
    }
    
    public static IntimateScoreCardInfo copyFromJson(JSONObject paramJSONObject)
    {
      IntimateScoreCardInfo localIntimateScoreCardInfo = new IntimateScoreCardInfo();
      localIntimateScoreCardInfo.type = paramJSONObject.optLong("type");
      localIntimateScoreCardInfo.level = paramJSONObject.optInt("level");
      localIntimateScoreCardInfo.days = paramJSONObject.optInt("days");
      localIntimateScoreCardInfo.title = paramJSONObject.optString("title");
      localIntimateScoreCardInfo.score = paramJSONObject.optInt("score");
      localIntimateScoreCardInfo.typeDescribe = paramJSONObject.optString("typeDescribe");
      localIntimateScoreCardInfo.levelDescribe = paramJSONObject.optString("levelDescribe");
      localIntimateScoreCardInfo.buttonDescribe = paramJSONObject.optString("buttonDescribe");
      localIntimateScoreCardInfo.buttonUrl = paramJSONObject.optString("buttonUrl");
      return localIntimateScoreCardInfo;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", this.type);
        localJSONObject.put("level", this.level);
        localJSONObject.put("days", this.days);
        localJSONObject.put("title", this.title);
        localJSONObject.put("score", this.score);
        localJSONObject.put("typeDescribe", this.typeDescribe);
        localJSONObject.put("levelDescribe", this.levelDescribe);
        localJSONObject.put("buttonDescribe", this.buttonDescribe);
        localJSONObject.put("buttonUrl", this.buttonUrl);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "IntimateScoreCardInfo{type=" + this.type + ", level='" + this.level + '\'' + ", days='" + this.days + '\'' + ", title='" + this.title + '\'' + ", score='" + this.score + '\'' + ", typeDescribe='" + this.typeDescribe + '\'' + ", levelDescribe='" + this.levelDescribe + '\'' + ", buttonDescribe='" + this.buttonDescribe + '\'' + ", buttonUrl='" + this.buttonUrl + '\'' + '}';
    }
  }
  
  public static class MemoryDayInfo
  {
    public long date;
    public int dateType;
    public String iconUrl;
    public int jumpType;
    public String linkColor;
    public String linkUrl;
    public String linkWording;
    public String wording;
    
    public static MemoryDayInfo copyFrom(oidb_0xcf4.DateTips paramDateTips)
    {
      Object localObject2 = null;
      if (paramDateTips == null) {
        return null;
      }
      MemoryDayInfo localMemoryDayInfo = new MemoryDayInfo();
      localMemoryDayInfo.date = NetConnInfoCenter.getServerTimeMillis();
      localMemoryDayInfo.dateType = paramDateTips.eDateType.get();
      if (paramDateTips.bytes_icon_url.has())
      {
        localObject1 = paramDateTips.bytes_icon_url.get().toStringUtf8();
        localMemoryDayInfo.iconUrl = ((String)localObject1);
        if (!paramDateTips.bytes_wording.has()) {
          break label184;
        }
        localObject1 = paramDateTips.bytes_wording.get().toStringUtf8();
        label81:
        localMemoryDayInfo.wording = ((String)localObject1);
        if (!paramDateTips.bytes_link_url.has()) {
          break label189;
        }
        localObject1 = paramDateTips.bytes_link_url.get().toStringUtf8();
        label107:
        localMemoryDayInfo.linkUrl = ((String)localObject1);
        if (!paramDateTips.bytes_link_wording.has()) {
          break label194;
        }
      }
      label184:
      label189:
      label194:
      for (Object localObject1 = paramDateTips.bytes_link_wording.get().toStringUtf8();; localObject1 = null)
      {
        localMemoryDayInfo.linkWording = ((String)localObject1);
        localObject1 = localObject2;
        if (paramDateTips.bytes_link_colour.has()) {
          localObject1 = paramDateTips.bytes_link_colour.get().toStringUtf8();
        }
        localMemoryDayInfo.linkColor = ((String)localObject1);
        localMemoryDayInfo.jumpType = paramDateTips.eJumpType.get();
        return localMemoryDayInfo;
        localObject1 = null;
        break;
        localObject1 = null;
        break label81;
        localObject1 = null;
        break label107;
      }
    }
    
    public static MemoryDayInfo copyFromJson(JSONObject paramJSONObject)
    {
      MemoryDayInfo localMemoryDayInfo = new MemoryDayInfo();
      localMemoryDayInfo.date = paramJSONObject.optInt("date");
      localMemoryDayInfo.dateType = paramJSONObject.optInt("dateType");
      localMemoryDayInfo.iconUrl = paramJSONObject.optString("iconUrl");
      localMemoryDayInfo.wording = paramJSONObject.optString("wording");
      localMemoryDayInfo.linkUrl = paramJSONObject.optString("linkUrl");
      localMemoryDayInfo.linkWording = paramJSONObject.optString("linkWording");
      localMemoryDayInfo.linkColor = paramJSONObject.optString("linkColor");
      localMemoryDayInfo.jumpType = paramJSONObject.optInt("jumpType");
      return localMemoryDayInfo;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("date", this.date);
        localJSONObject.put("dateType", this.dateType);
        localJSONObject.put("iconUrl", this.iconUrl);
        localJSONObject.put("wording", this.wording);
        localJSONObject.put("linkUrl", this.linkUrl);
        localJSONObject.put("linkWording", this.linkWording);
        localJSONObject.put("linkColor", this.linkColor);
        localJSONObject.put("jumpType", this.jumpType);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "MemoryDayInfo{date=" + this.date + ", dateType='" + this.dateType + '\'' + ", wording='" + this.wording + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", linkWording='" + this.linkWording + '\'' + ", linkColor='" + this.linkColor + '\'' + ", jumpType='" + this.jumpType + '\'' + '}';
    }
  }
  
  public static class MutualMarkInfo
  {
    public int days;
    public String icon_static_url = "";
    public int level;
    public int type;
    
    public static MutualMarkInfo copyFrom(oidb_0xcf4.MutualMarkInfo paramMutualMarkInfo)
    {
      int j = 0;
      if (paramMutualMarkInfo == null) {
        return null;
      }
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      if (paramMutualMarkInfo.eMutualMarkNewType.has())
      {
        i = paramMutualMarkInfo.eMutualMarkNewType.get();
        localMutualMarkInfo.type = i;
        if (!paramMutualMarkInfo.uint32_level.has()) {
          break label146;
        }
      }
      label146:
      for (int i = paramMutualMarkInfo.uint32_level.get();; i = 0)
      {
        localMutualMarkInfo.level = i;
        i = j;
        if (paramMutualMarkInfo.uint32_days.has()) {
          i = paramMutualMarkInfo.uint32_days.get();
        }
        localMutualMarkInfo.days = i;
        if ((paramMutualMarkInfo.msg_special_word_info.has()) && (((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.has())) {
          localMutualMarkInfo.icon_static_url = ((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.get().toStringUtf8();
        }
        return localMutualMarkInfo;
        i = 0;
        break;
      }
    }
    
    public static MutualMarkInfo copyFromJson(JSONObject paramJSONObject)
    {
      MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
      localMutualMarkInfo.type = paramJSONObject.optInt("type");
      localMutualMarkInfo.level = paramJSONObject.optInt("level");
      localMutualMarkInfo.days = paramJSONObject.optInt("days");
      localMutualMarkInfo.icon_static_url = paramJSONObject.optString("icon_static_url");
      return localMutualMarkInfo;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", this.type);
        localJSONObject.put("level", this.level);
        localJSONObject.put("days", this.days);
        localJSONObject.put("icon_static_url", this.icon_static_url);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", icon_static_url=" + this.icon_static_url + '}';
    }
  }
  
  public static class PrefetchMutualMarkInfo
    extends IntimateInfo.MutualMarkInfo
  {
    public int currentDays;
    
    public static PrefetchMutualMarkInfo copyFrom(oidb_0xcf4.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
    {
      int j = 0;
      if (paramPrefetchMutualMarkInfo == null) {
        return null;
      }
      PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
      if (paramPrefetchMutualMarkInfo.eMutualMarkNewType.has())
      {
        i = paramPrefetchMutualMarkInfo.eMutualMarkNewType.get();
        localPrefetchMutualMarkInfo.type = i;
        if (!paramPrefetchMutualMarkInfo.uint32_level.has()) {
          break label117;
        }
        i = paramPrefetchMutualMarkInfo.uint32_level.get();
        label57:
        localPrefetchMutualMarkInfo.level = i;
        if (!paramPrefetchMutualMarkInfo.uint32_days.has()) {
          break label122;
        }
      }
      label117:
      label122:
      for (int i = paramPrefetchMutualMarkInfo.uint32_days.get();; i = 0)
      {
        localPrefetchMutualMarkInfo.days = i;
        i = j;
        if (paramPrefetchMutualMarkInfo.uint32_current_days.has()) {
          i = paramPrefetchMutualMarkInfo.uint32_current_days.get();
        }
        localPrefetchMutualMarkInfo.currentDays = i;
        return localPrefetchMutualMarkInfo;
        i = 0;
        break;
        i = 0;
        break label57;
      }
    }
    
    public static PrefetchMutualMarkInfo copyFromJson(JSONObject paramJSONObject)
    {
      PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
      localPrefetchMutualMarkInfo.type = paramJSONObject.optInt("type");
      localPrefetchMutualMarkInfo.level = paramJSONObject.optInt("level");
      localPrefetchMutualMarkInfo.days = paramJSONObject.optInt("days");
      localPrefetchMutualMarkInfo.currentDays = paramJSONObject.optInt("currentDays");
      return localPrefetchMutualMarkInfo;
    }
    
    public JSONObject getJSONObject()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", this.type);
        localJSONObject.put("level", this.level);
        localJSONObject.put("days", this.days);
        localJSONObject.put("currentDays", this.currentDays);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", currentDays=" + this.currentDays + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo
 * JD-Core Version:    0.7.0.1
 */