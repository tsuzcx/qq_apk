package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OpenTroopInfo
  extends Entity
{
  public boolean isNeedDelete = false;
  public String troopAIOSkinUrl;
  public String troopActImageUrl;
  public String troopActInfoSummary;
  public String troopActInfoTitle;
  public String troopActInfoUrl;
  public String troopAdminList;
  public String troopBoardSkinUrl;
  public int troopClass;
  @unique
  public String troopCode;
  public long troopCoverSkinTimestamp;
  public String troopCoverSkinUrl;
  public int troopDistance;
  public int troopFace;
  public String troopIntro;
  public String troopLocation;
  public int troopMemberNum;
  public String troopName;
  public String troopUin;
  
  public void CopyFrom(OpenTroopInfo paramOpenTroopInfo)
  {
    this.troopUin = paramOpenTroopInfo.troopUin;
    this.troopCode = paramOpenTroopInfo.troopCode;
    this.troopName = paramOpenTroopInfo.troopName;
    this.troopFace = paramOpenTroopInfo.troopFace;
    this.troopIntro = paramOpenTroopInfo.troopIntro;
    this.troopMemberNum = paramOpenTroopInfo.troopMemberNum;
    this.troopAdminList = paramOpenTroopInfo.troopAdminList;
    this.troopClass = paramOpenTroopInfo.troopClass;
    this.troopLocation = paramOpenTroopInfo.troopLocation;
    this.troopDistance = paramOpenTroopInfo.troopDistance;
    this.isNeedDelete = paramOpenTroopInfo.isNeedDelete;
    this.troopActInfoTitle = paramOpenTroopInfo.troopActInfoTitle;
    this.troopActInfoSummary = paramOpenTroopInfo.troopActInfoSummary;
    this.troopActInfoUrl = paramOpenTroopInfo.troopActInfoUrl;
    this.troopActImageUrl = paramOpenTroopInfo.troopActImageUrl;
    this.troopAIOSkinUrl = paramOpenTroopInfo.troopAIOSkinUrl;
    this.troopBoardSkinUrl = paramOpenTroopInfo.troopBoardSkinUrl;
    this.troopCoverSkinUrl = paramOpenTroopInfo.troopCoverSkinUrl;
    this.troopCoverSkinTimestamp = paramOpenTroopInfo.troopCoverSkinTimestamp;
  }
  
  public boolean hasActInfo()
  {
    if (TextUtils.isEmpty(this.troopActInfoTitle)) {}
    while ((TextUtils.isEmpty(this.troopActInfoSummary)) || (TextUtils.isEmpty(this.troopActInfoUrl)) || (TextUtils.isEmpty(this.troopActImageUrl))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.OpenTroopInfo
 * JD-Core Version:    0.7.0.1
 */