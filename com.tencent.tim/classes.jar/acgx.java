import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mqq.manager.Manager;

public class acgx
  implements Manager
{
  boolean Hf;
  long PQ = -1L;
  LikeRankingInfo b;
  boolean bHX = true;
  boolean bHY = true;
  int cwi;
  QQAppInterface mApp;
  String mUin;
  List<LikeRankingInfo> xB;
  
  public acgx(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = new LikeRankingInfo();
    this.mUin = this.mApp.getCurrentAccountUin();
    if (!TextUtils.isEmpty(this.mUin)) {
      this.b.uin = Long.valueOf(this.mUin).longValue();
    }
    paramQQAppInterface = this.mApp.getPreferences();
    this.bHX = paramQQAppInterface.getBoolean("notify_on_like_ranking_list", true);
    this.b.totalLikeCount = paramQQAppInterface.getInt("like_ranking_list_total_like_count", -1);
    this.b.likeCountOfToday = paramQQAppInterface.getInt("like_ranking_list_today_like_count", -1);
    this.b.rankingNum = paramQQAppInterface.getInt("like_ranking_list_ranking_num", 0);
    this.bHY = paramQQAppInterface.getBoolean("partake__like_ranking_list", true);
  }
  
  public void Fb(boolean paramBoolean)
  {
    if (this.bHX == paramBoolean) {
      return;
    }
    this.bHX = paramBoolean;
    PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit().putBoolean("notify_on_like_ranking_list" + this.mUin, this.bHX).commit();
  }
  
  public void Fc(boolean paramBoolean)
  {
    if (this.bHY == paramBoolean) {
      return;
    }
    this.bHY = paramBoolean;
    PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit().putBoolean("partake__like_ranking_list" + this.mUin, this.bHY).commit();
    akka.K(this.mApp, paramBoolean);
  }
  
  public LikeRankingInfo a()
  {
    return this.b;
  }
  
  public void aE(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.b.likeCountOfToday) || (paramInt3 != this.b.totalLikeCount) || (paramInt2 != this.b.rankingNum))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LikeRankingListManager", 2, String.format("updateMyRank todayVoteCount:%d rank:%d total:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      this.b.totalLikeCount = paramInt3;
      this.b.likeCountOfToday = paramInt1;
      this.b.rankingNum = paramInt2;
      SharedPreferences.Editor localEditor = this.mApp.getPreferences().edit();
      localEditor.putInt("like_ranking_list_total_like_count", paramInt3);
      localEditor.putInt("like_ranking_list_today_like_count", paramInt1);
      localEditor.putInt("like_ranking_list_ranking_num", paramInt2);
      localEditor.commit();
    }
  }
  
  public boolean aaw()
  {
    return this.bHX;
  }
  
  public boolean aax()
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).getBoolean("notify_on_like_ranking_list" + this.mUin, true);
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListManager", 2, "getNotificationSwitch=" + bool);
    }
    return bool;
  }
  
  public boolean aay()
  {
    this.bHY = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).getBoolean("partake__like_ranking_list" + this.mUin, true);
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListManager", 2, "getPartakeRankingEnabled=" + this.bHY);
    }
    return this.bHY;
  }
  
  public boolean aaz()
  {
    boolean bool2 = false;
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l);
    int i = localCalendar1.get(11);
    boolean bool1 = bool2;
    if (i >= 22)
    {
      bool1 = bool2;
      if (i < 24)
      {
        if (this.PQ < 0L) {
          this.PQ = this.mApp.getPreferences().getLong("like_ranking_list_animation_time", 0L);
        }
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.PQ);
        if (localCalendar2.get(1) == localCalendar1.get(1))
        {
          bool1 = bool2;
          if (localCalendar2.get(6) == localCalendar1.get(6)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e(List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean)
  {
    this.xB = new ArrayList(paramList);
    this.cwi = paramInt;
    this.Hf = paramBoolean;
  }
  
  public List<LikeRankingInfo> ea()
  {
    if (this.xB == null) {
      return null;
    }
    return new ArrayList(this.xB);
  }
  
  public void hz(long paramLong)
  {
    this.PQ = paramLong;
    SharedPreferences.Editor localEditor = this.mApp.getPreferences().edit();
    localEditor.putLong("like_ranking_list_animation_time", paramLong);
    localEditor.commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgx
 * JD-Core Version:    0.7.0.1
 */