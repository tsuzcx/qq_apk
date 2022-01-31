package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class NearbyPeopleCard
  extends Entity
{
  public int age;
  public byte bVoted;
  public int birthday;
  public String busiEntry;
  public String college;
  public String company;
  public byte constellation;
  public byte[] dateInfo;
  public String distance;
  public long feedPreviewTime;
  public byte gender;
  public String hometownCity;
  public String hometownCountry;
  public String hometownDistrict;
  public String hometownProvice;
  public boolean isPhotoUseCache;
  public int job;
  public long lastUpdateNickTime;
  public int likeCount;
  public byte maritalStatus;
  public String nickname;
  public int oldPhotoCount;
  public byte[] photoInfoes;
  public String qzoneFeed;
  public String qzoneName;
  public String qzonePicUrl_1;
  public String qzonePicUrl_2;
  public String qzonePicUrl_3;
  public boolean switchHobby;
  public boolean switchQzone;
  public String timeDiff;
  public long tinyId = 0L;
  public long uiShowControl;
  public String uin;
  public long userFlag;
  public byte[] vCookies;
  public byte[] vSeed;
  public byte[] xuanYan;
  
  public List getQZonePhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.qzonePicUrl_1)) {
      localArrayList.add(this.qzonePicUrl_1);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_2)) {
      localArrayList.add(this.qzonePicUrl_2);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_3)) {
      localArrayList.add(this.qzonePicUrl_3);
    }
    return localArrayList;
  }
  
  public boolean hasQzonePhotoUrl()
  {
    return (!StringUtil.b(this.qzonePicUrl_1)) || (!StringUtil.b(this.qzonePicUrl_2)) || (!StringUtil.b(this.qzonePicUrl_3));
  }
  
  public boolean isAuthUser()
  {
    return (this.userFlag & 0x20) != 0L;
  }
  
  public boolean isPhotoUseCache()
  {
    return this.isPhotoUseCache;
  }
  
  public void setPhotoUseCache(long paramLong)
  {
    if ((1L & paramLong) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPhotoUseCache = bool;
      return;
    }
  }
  
  public boolean shouldShowHobby()
  {
    return (this.uiShowControl & 0x20) == 0L;
  }
  
  public boolean shouldShowLikeBtn()
  {
    return (this.uiShowControl & 0x4) != 0L;
  }
  
  public boolean shouldShowQzoneFeed()
  {
    return (this.uiShowControl & 1L) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.NearbyPeopleCard
 * JD-Core Version:    0.7.0.1
 */