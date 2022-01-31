package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import friendlist.stLevelRankPair;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x8fd.Oidb_0x8fd.LevelName;

public class TroopInfo
  extends Entity
{
  public static final int DEL_PIC_REQ = 2;
  public static final int MODIFY_ORDER = 0;
  public static final int SET_DEFAULT_PIC = 1;
  public String Administrator;
  public byte cAlbumResult = 0;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag = 0;
  public byte cGroupRankUserFlag = 0;
  public long dwAdditionalFlag;
  public long dwAuthGroupType = 0L;
  public long dwCmdUinUinFlag;
  public long dwGagTimeStamp;
  public long dwGagTimeStamp_me;
  public long dwGroupClassExt;
  public long dwGroupFlag;
  public long dwGroupFlagExt = 0L;
  public long dwGroupInfoSeq = 0L;
  public long dwGroupLevelSeq;
  public long dwTimeStamp = 0L;
  public String fingertroopmemo;
  public int isShowInNearbyTroops = -1;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  public int mComparePartInt;
  public String mCompareSpell;
  public String mGroupClassExtText;
  public boolean mMemberInvitingFlag;
  public int mQZonePhotoNum = 0;
  public String mRichFingerMemo;
  public String mSomeMemberUins;
  public String mTags;
  public int mTroopAvatarId;
  public List mTroopPicList;
  public int maxAdminNum;
  public int nTroopGrade;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public int troopLat = 0;
  public String troopLevelMap;
  public int troopLon = 0;
  public int troopTypeExt = -1;
  public String troopcode;
  public short troopface;
  public int troopmask = -1;
  public String troopmemo;
  public String troopname;
  public String troopowneruin;
  public int trooptype;
  @unique
  public String troopuin;
  public String uin;
  public int wMemberMax;
  public int wMemberNum;
  public int wSpecialClass;
  
  public static List getTags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\n");
      int i = 0;
      while (i < paramString.length)
      {
        localArrayList.add(paramString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List setAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    if (paramGroupHeadPortrait.uint32_pic_cnt.get() != paramGroupHeadPortrait.rpt_msg_info.size()) {}
    ArrayList localArrayList = new ArrayList();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localArrayList.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localArrayList;
  }
  
  public static String setTags(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (oidb_0x88d.TagRecord)localIterator.next();
          if (!paramList.bytes_tag_value.has()) {
            continue;
          }
          paramList = paramList.bytes_tag_value.get().toStringUtf8();
          try
          {
            paramList = new String(paramList.getBytes("utf-8"));
            localStringBuffer.append(paramList + "\n");
          }
          catch (UnsupportedEncodingException paramList)
          {
            for (;;)
            {
              paramList.printStackTrace();
              paramList = "";
            }
          }
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public String getPercentage()
  {
    return "66";
  }
  
  public ArrayList getQZonePhotoUrls()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.strQZonePhotoUrls != null)
    {
      String[] arrayOfString = this.strQZonePhotoUrls.split(";");
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0)
        {
          localObject1 = new ArrayList();
          int i = 0;
          while (i < arrayOfString.length)
          {
            if ((arrayOfString[i] != null) && (arrayOfString[i].length() > 0)) {
              ((ArrayList)localObject1).add(arrayOfString[i]);
            }
            i += 1;
          }
        }
      }
    }
    return localObject1;
  }
  
  public List getSomeMemberUins()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mSomeMemberUins != null) && (this.mSomeMemberUins.length() > 0))
    {
      int j = 0;
      int i = this.mSomeMemberUins.indexOf('|', 0);
      int k = this.mSomeMemberUins.length();
      String str2;
      String str1;
      while ((i >= j) && (i < k))
      {
        if (j < i)
        {
          str2 = this.mSomeMemberUins.substring(j, i);
          str1 = str2;
          if (str2 != null) {
            str1 = str2.trim();
          }
          if ((str1 != null) && (str1.length() > 0)) {
            localArrayList.add(str1);
          }
        }
        j = i + 1;
        i = this.mSomeMemberUins.indexOf('|', j);
      }
      if (j < k)
      {
        str2 = this.mSomeMemberUins.substring(j, k);
        str1 = str2;
        if (str2 != null) {
          str1 = str2.trim();
        }
        if ((str1 != null) && (str1.length() > 0)) {
          localArrayList.add(str1);
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public HashMap getTroopLevelMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.troopLevelMap != null)
    {
      String[] arrayOfString1 = this.troopLevelMap.split("\001");
      if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < arrayOfString1.length)
          {
            String[] arrayOfString2 = arrayOfString1[i].split("");
            if (arrayOfString2.length == 2) {}
            try
            {
              localHashMap.put(Integer.valueOf(Integer.parseInt(arrayOfString2[0])), arrayOfString2[1]);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopInfo", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                }
              }
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void setTroopLevelMap(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramList.size() - 1)
      {
        stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
        localStringBuilder.append(localstLevelRankPair.dwLevel).append("").append(localstLevelRankPair.strRank).append("\001");
        i += 1;
      }
      paramList = (stLevelRankPair)paramList.get(paramList.size() - 1);
      localStringBuilder.append(paramList.dwLevel).append("").append(paramList.strRank);
      this.troopLevelMap = localStringBuilder.toString();
    }
  }
  
  public void setTroopLevelMap2(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramList.size() - 1)
      {
        Oidb_0x8fd.LevelName localLevelName = (Oidb_0x8fd.LevelName)paramList.get(i);
        localStringBuilder.append(localLevelName.uint32_level.get()).append("").append(localLevelName.str_name.get()).append("\001");
        i += 1;
      }
      paramList = (Oidb_0x8fd.LevelName)paramList.get(paramList.size() - 1);
      localStringBuilder.append(paramList.uint32_level.get()).append("").append(paramList.str_name.get());
      this.troopLevelMap = localStringBuilder.toString();
    }
  }
  
  public void updateQZonePhotoUrls(ArrayList paramArrayList)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    }
    while (j < i)
    {
      String str = (String)paramArrayList.get(j);
      if ((str != null) && (str.length() > 0)) {
        localStringBuilder.append(str).append(";");
      }
      j += 1;
      continue;
      i = 0;
    }
    this.strQZonePhotoUrls = localStringBuilder.toString();
  }
  
  public void updateSomeMemberUins(List paramList)
  {
    int j = 0;
    int i;
    StringBuilder localStringBuilder;
    label22:
    oidb_0x899.memberlist localmemberlist;
    if (paramList != null)
    {
      i = paramList.size();
      localStringBuilder = new StringBuilder();
      if (j >= i) {
        break label89;
      }
      localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
        break label67;
      }
    }
    for (;;)
    {
      j += 1;
      break label22;
      i = 0;
      break;
      label67:
      localStringBuilder.append(localmemberlist.uint64_member_uin.get()).append('|');
    }
    label89:
    this.mSomeMemberUins = localStringBuilder.toString();
    if ((i < 6) && (i > 0)) {
      this.wMemberNum = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopInfo
 * JD-Core Version:    0.7.0.1
 */