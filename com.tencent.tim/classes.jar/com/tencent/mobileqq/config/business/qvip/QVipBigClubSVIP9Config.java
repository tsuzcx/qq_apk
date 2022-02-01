package com.tencent.mobileqq.config.business.qvip;

import java.io.Serializable;

public class QVipBigClubSVIP9Config
  implements Serializable
{
  public String mAPngIconUrl = "https://imgcache.qq.com/club/mobile/privilege/clubicons2019v4/icon/%d/%d/%d.png";
  public String mAPngIconUrlNew_Gray = "https://imgcache.qq.com/club/mobile/privilege/clubicons2019v4/icon/%d/%d/%d_grey.png";
  public boolean mIsEnable = true;
  public String mVipIconSettingsUrl = "https://h5.qzone.qq.com/bigVip/vipset?_proxy=1";
  
  public String getVipIconSettingsUrl(String paramString)
  {
    return this.mVipIconSettingsUrl + "&from=" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config
 * JD-Core Version:    0.7.0.1
 */