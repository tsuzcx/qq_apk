import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;

public class ahsz
{
  public static final String TAG = ahtj.bLH + "GameDetailInfo";
  public String mAppId;
  public String mFaceUrl;
  public String mIconUrl;
  public String mLevelPic;
  public String mLevelText;
  public int mMsgMaxLen;
  public String mName;
  public String mNickInGame;
  public String mOnLineDesc;
  public int mOnlineType;
  public String mPartitioName;
  public String mRoleId;
  public int mSex;
  public String mStartGameUrl;
  public int mSwitchInGame;
  
  public static ahsz a(GameBasicInfo paramGameBasicInfo, GameUserInfo paramGameUserInfo)
  {
    ahsz localahsz = new ahsz();
    if ((paramGameBasicInfo == null) || (paramGameUserInfo == null)) {
      return localahsz;
    }
    if ((TextUtils.isEmpty(paramGameBasicInfo.mAppId)) || (TextUtils.isEmpty(paramGameUserInfo.mAppId)))
    {
      com.tencent.qphone.base.util.QLog.w(TAG, 1, "appId is empty.");
      return localahsz;
    }
    if (!paramGameBasicInfo.mAppId.equals(paramGameUserInfo.mAppId))
    {
      com.tencent.qphone.base.util.QLog.w(TAG, 1, "warning! appId should be the same!");
      return localahsz;
    }
    localahsz.mRoleId = paramGameUserInfo.mRoleId;
    localahsz.mAppId = paramGameUserInfo.mAppId;
    localahsz.mFaceUrl = paramGameUserInfo.mFaceUrl;
    localahsz.mSex = paramGameUserInfo.mSex;
    localahsz.mLevelPic = paramGameUserInfo.mLevelPic;
    localahsz.mLevelText = paramGameUserInfo.mLevelText;
    localahsz.mNickInGame = paramGameUserInfo.mNickInGame;
    localahsz.mPartitioName = paramGameUserInfo.mPartitioName;
    localahsz.mOnlineType = paramGameUserInfo.mOnlineType;
    localahsz.mSwitchInGame = paramGameUserInfo.mSwitchInGame;
    localahsz.mOnLineDesc = paramGameUserInfo.mOnLineDesc;
    localahsz.mName = paramGameBasicInfo.mName;
    localahsz.mIconUrl = paramGameBasicInfo.mIconUrl;
    localahsz.mStartGameUrl = paramGameBasicInfo.mStartGameUrl;
    localahsz.mMsgMaxLen = paramGameBasicInfo.mMsgMaxLen;
    return localahsz;
  }
  
  public void print()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(600);
      localStringBuilder.append(" roleId:").append(this.mRoleId).append(",appid:").append(this.mAppId).append(",mSwitchInGame:").append(this.mSwitchInGame).append(",onlineType:").append(this.mOnlineType).append(",mOnLineDesc:").append(this.mOnLineDesc).append(",partName:").append(this.mPartitioName).append(",mMsgMaxLen:").append(this.mMsgMaxLen).append(",levelText:").append(this.mLevelText).append(",gameName:").append(this.mName).append(",sex:").append(this.mSex).append(",nick:").append(this.mNickInGame).append(",levelPic:").append(this.mLevelPic).append(",iconUrl:").append(this.mIconUrl).append(",faceUrl:").append(this.mFaceUrl).append(",startGameUrl:").append(this.mStartGameUrl);
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d(TAG, 0, localStringBuilder.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.qphone.base.util.QLog.w(TAG, 1, localThrowable.getMessage());
    }
  }
  
  public String toString()
  {
    return "GameDetailInfo{mRoleId='" + this.mRoleId + '\'' + ", mAppId='" + this.mAppId + '\'' + ", mFaceUrl='" + this.mFaceUrl + '\'' + ", mNickInGame='" + this.mNickInGame + '\'' + ", mPartitioName='" + this.mPartitioName + '\'' + ", mLevelPic='" + this.mLevelPic + '\'' + ", mLevelText='" + this.mLevelText + '\'' + ", mSex=" + this.mSex + ", mOnlineType=" + this.mOnlineType + ", mName='" + this.mName + '\'' + ", mIconUrl='" + this.mIconUrl + '\'' + ", mSwitchInGame=" + this.mSwitchInGame + ", mOnLineDesc='" + this.mOnLineDesc + '\'' + ", mStartGameUrl='" + this.mStartGameUrl + '\'' + ", mMsgMaxLen=" + this.mMsgMaxLen + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsz
 * JD-Core Version:    0.7.0.1
 */