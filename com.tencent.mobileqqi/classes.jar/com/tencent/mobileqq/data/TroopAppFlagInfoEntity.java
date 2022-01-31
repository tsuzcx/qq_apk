package com.tencent.mobileqq.data;

public class TroopAppFlagInfoEntity
  extends TroopAppUpdateTimeEntity
{
  public boolean isNeedToShow = false;
  public boolean isUpdated = false;
  public boolean showRedDot = false;
  public String showTag = " ";
  
  public void copyFrom(TroopAppFlagInfoEntity paramTroopAppFlagInfoEntity)
  {
    this.troopCode = paramTroopAppFlagInfoEntity.troopCode;
    this.showRedDot = paramTroopAppFlagInfoEntity.showRedDot;
    this.showTag = paramTroopAppFlagInfoEntity.showTag;
    this.timestamp = paramTroopAppFlagInfoEntity.timestamp;
    this.isUpdated = paramTroopAppFlagInfoEntity.isUpdated;
    this.isNeedToShow = paramTroopAppFlagInfoEntity.isNeedToShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopAppFlagInfoEntity
 * JD-Core Version:    0.7.0.1
 */