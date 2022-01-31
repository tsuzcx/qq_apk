package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
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
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
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
  public String adminNameShow;
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
  public String ownerNameShow;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public int troopLat = 0;
  public String troopLevelMap;
  public int troopLon = 0;
  public long troopPrivilegeFlag = 0L;
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
  
  public static final boolean isTroopMember(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(44);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString) != null;
    }
    return false;
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
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
    this.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
    this.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
    this.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
    this.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
    this.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
    this.dwAdditionalFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("dwAdditionalFlag")));
    this.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
    this.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
    this.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
    this.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
    this.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
    this.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
    this.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
    this.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
    this.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
    this.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
    this.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
    this.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
    this.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
    this.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("mMemberInvitingFlag")) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.mMemberInvitingFlag = bool;
      this.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      this.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      this.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
      this.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
      this.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
      this.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      this.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
      this.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      this.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      this.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      this.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      this.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      this.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      this.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      this.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
      this.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      this.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      this.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      this.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      this.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      this.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      this.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      this.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      this.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      this.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      this.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      this.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
      try
      {
        this.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        this.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        return true;
      }
      catch (Exception paramCursor) {}
    }
    return true;
  }
  
  public String getAdminShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.adminNameShow)) {
      return paramContext.getString(2131362893);
    }
    return this.adminNameShow;
  }
  
  public String getOwnerOrAdminString(String paramString, Context paramContext)
  {
    if ((paramString != null) && (paramString.equals(this.troopowneruin))) {
      return getOwnerShow(paramContext);
    }
    if (this.Administrator != null)
    {
      String[] arrayOfString = this.Administrator.split("\\|");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if ((paramString != null) && (paramString.equals(arrayOfString[i]))) {
            return getAdminShow(paramContext);
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public String getOwnerShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.ownerNameShow)) {
      return paramContext.getString(2131362892);
    }
    return this.ownerNameShow;
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
  
  public boolean isAdmin()
  {
    return ((this.dwAdditionalFlag & 1L) == 1L) || ((this.dwCmdUinUinFlag & 1L) == 1L);
  }
  
  public boolean isTroopAdmin(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int i;
    if (this.Administrator != null)
    {
      arrayOfString = this.Administrator.split("\\|");
      bool1 = bool2;
      if (arrayOfString != null)
      {
        bool1 = bool2;
        if (arrayOfString.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < arrayOfString.length)
      {
        if ((paramString != null) && (paramString.equals(arrayOfString[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isTroopOwner(String paramString)
  {
    return (paramString != null) && (paramString.equals(this.troopowneruin));
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
  
  public void setTroopLevelMap787(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramList.size() - 1)
      {
        oidb_0x787.LevelName localLevelName = (oidb_0x787.LevelName)paramList.get(i);
        localStringBuilder.append(localLevelName.uint32_level.get()).append("").append(localLevelName.str_name.get().toStringUtf8()).append("\001");
        i += 1;
      }
      paramList = (oidb_0x787.LevelName)paramList.get(paramList.size() - 1);
      localStringBuilder.append(paramList.uint32_level.get()).append("").append(paramList.str_name.get().toStringUtf8());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopInfo
 * JD-Core Version:    0.7.0.1
 */