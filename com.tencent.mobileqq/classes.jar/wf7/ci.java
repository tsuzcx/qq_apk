package wf7;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ci
{
  public int hi = -1;
  public String hj = "";
  public int hk = -1;
  public String hl = "";
  public String hm = "";
  public int hn = -1;
  public String ho = null;
  public String hp = null;
  public String hq = null;
  public boolean hr;
  public String hs = "";
  public String ht = "";
  public boolean hu = false;
  public int mID = -1;
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    if ((!this.hu) || (TextUtils.isEmpty(paramString1)) || (paramInt != 0)) {
      return false;
    }
    boolean bool1;
    if (!TextUtils.isEmpty(this.hl)) {
      bool1 = Pattern.compile(this.hl).matcher(paramString1).matches();
    }
    for (paramInt = 1;; paramInt = 0)
    {
      boolean bool2;
      if (!TextUtils.isEmpty(this.hm)) {
        bool2 = Pattern.compile(this.hm).matcher(paramString2).matches();
      }
      for (int i = 1; ((paramInt == 0) || ((paramInt != 0) && (bool1))) && ((i == 0) || ((i != 0) && (bool2))); i = 0)
      {
        return true;
        bool2 = false;
      }
      break;
      bool1 = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mID:");
    localStringBuilder.append(this.mID);
    localStringBuilder.append(" mWiFiType:");
    localStringBuilder.append(this.hi);
    localStringBuilder.append(" mWiFiName:");
    localStringBuilder.append(this.hj);
    localStringBuilder.append(" mMiniVerReq:");
    localStringBuilder.append(this.hk);
    localStringBuilder.append(" mSsidRegularExpression:");
    localStringBuilder.append(this.hl);
    localStringBuilder.append(" mBssidRegularExpression:");
    localStringBuilder.append(this.hm);
    localStringBuilder.append(" mAuthType:");
    localStringBuilder.append(this.hn);
    localStringBuilder.append(" mAuthUrl:");
    localStringBuilder.append(this.ho);
    localStringBuilder.append(" mAppkey:");
    localStringBuilder.append(this.hp);
    localStringBuilder.append(" mAppsecret:");
    localStringBuilder.append(this.hq);
    localStringBuilder.append(" mNotifyIconUrl:");
    localStringBuilder.append(this.hs);
    localStringBuilder.append(" mWiFiBgImgUrl:");
    localStringBuilder.append(this.ht);
    localStringBuilder.append(" mParseSuccess:");
    localStringBuilder.append(this.hu);
    localStringBuilder.append(" mIsLiteSecureReq:");
    localStringBuilder.append(this.hr);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ci
 * JD-Core Version:    0.7.0.1
 */