package com.tencent.moai.nativepages.model;

import java.util.LinkedList;

public class AdLandingPageInfo
{
  public String backgroundColor;
  public String backgroundCoverUrl;
  public LinkedList<AdLandingPageComponentInfo> componetInfos = new LinkedList();
  public int id;
  public boolean ifCondition = true;
  public boolean isNeedBackgroundBlur;
  
  public String toString()
  {
    return "AdLandingPageInfo{backgroundCoverUrl='" + this.backgroundCoverUrl + '\'' + ", backgroundColor='" + this.backgroundColor + '\'' + ", isNeedBackgroundBlur=" + this.isNeedBackgroundBlur + ", componetInfos=" + this.componetInfos + ", ifCondition=" + this.ifCondition + ", id=" + this.id + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.model.AdLandingPageInfo
 * JD-Core Version:    0.7.0.1
 */