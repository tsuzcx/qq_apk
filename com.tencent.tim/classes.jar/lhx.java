import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.4;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class lhx
{
  private final String TAG = "FollowCoverInfoModule";
  private int aPj = -1;
  private mih b;
  private HashMap<Long, Long> dT = new HashMap();
  private AppInterface mApp;
  
  public lhx(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    aMv();
  }
  
  private void aMv()
  {
    if (this.aPj == -1) {
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.1(this));
    }
  }
  
  public void a(mih parammih)
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        this.b = parammih;
        if (parammih == null)
        {
          i = 0;
          this.aPj = i;
          if (!QLog.isColorLevel()) {
            break label151;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("topic update save info exists ").append(this.aPj).append(" size ");
          if ((parammih == null) || (parammih.ld == null)) {
            break;
          }
          localStringBuilder.append(parammih.ld.size()).append(" ");
          Iterator localIterator = parammih.ld.iterator();
          if (!localIterator.hasNext()) {
            break label141;
          }
          localStringBuilder.append(((mih.b)localIterator.next()).businessId).append(" ");
          continue;
        }
        int i = 1;
      }
      finally {}
    }
    localStringBuilder.append("0");
    label141:
    QLog.d("FollowCoverInfoModule", 2, localStringBuilder.toString());
    label151:
    ThreadManager.executeOnFileThread(new FollowCoverInfoModule.2(this, parammih));
  }
  
  public void aJv()
  {
    try
    {
      this.dT.clear();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCoverInfoModule", 2, "topic update exp clear");
      }
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.3(this));
      return;
    }
    finally {}
  }
  
  public void h(Long paramLong)
  {
    try
    {
      Long localLong = Long.valueOf(System.currentTimeMillis());
      this.dT.put(paramLong, localLong);
      if (QLog.isColorLevel()) {
        QLog.d("FollowCoverInfoModule", 2, "topic update exp set " + paramLong + " " + localLong);
      }
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.4(this, new HashMap(this.dT)));
      return;
    }
    finally {}
  }
  
  public String js()
  {
    SharedPreferences localSharedPreferences = awit.a(this.mApp, true, false);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("follow_tab_last_refresh_cookie", "");
    }
    return "";
  }
  
  public void nA(boolean paramBoolean)
  {
    Object localObject = awit.a(this.mApp, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("follow_tab_user_topic_follow_state", paramBoolean);
        awit.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user follow state : " + paramBoolean);
      }
    }
  }
  
  public void nn(String paramString)
  {
    Object localObject = awit.a(this.mApp, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("follow_tab_last_refresh_cookie", paramString);
        awit.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "updateLastRefreshCookie cookie : " + paramString);
      }
    }
  }
  
  public int oo()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = awit.a(this.mApp, true, false);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("follow_tab_enter_topic_reddot_time", 0);
    }
    return i;
  }
  
  public void rn(int paramInt)
  {
    Object localObject = awit.a(this.mApp, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_user_topic_reddot_update_num", paramInt);
        awit.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user topic reddot update num : " + paramInt);
      }
    }
  }
  
  public HashMap<Long, Long> t()
  {
    try
    {
      HashMap localHashMap = this.dT;
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhx
 * JD-Core Version:    0.7.0.1
 */