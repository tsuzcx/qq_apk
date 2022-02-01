import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class pmb
  implements Manager, ppe
{
  public static final String atA = ppf.fQ("StorySvc.video_get_user_mask_states");
  public static final String atB = ppf.fQ("StorySvc.video_show_video_list");
  public static final String atw = ppf.fQ("StorySvc.video_config_get");
  public static final String atx = ppf.fQ("StorySvc.video_config_set");
  public static final String aty = ppf.fQ("StorySvc.video_get_user_mask_list");
  public static final String atz = ppf.fQ("StorySvc.video_set_user_mask");
  public QQStoryContext a;
  public prt a;
  protected boolean aAA = true;
  protected boolean aAB;
  protected boolean aAC;
  protected boolean aAD = true;
  protected boolean aAE;
  protected boolean aAF;
  public boolean aAG;
  public boolean aAH = true;
  public boolean aAx;
  public boolean aAy;
  protected boolean aAz = true;
  AppInterface app;
  public ConcurrentHashMap<String, SoftReference<Bitmap>> bF = new ConcurrentHashMap();
  public ConcurrentHashMap<String, QQStoryUserInfo> bR = new ConcurrentHashMap();
  protected int bjn = 10;
  public Drawable cZ;
  public EntityManager em;
  public SoftReference<View> h = new SoftReference(null);
  public List<QQStoryUserInfo> mi = new ArrayList();
  public List<QQStoryUserInfo> mj = new ArrayList();
  SharedPreferences sp = null;
  
  public pmb(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    this.sp = paramAppInterface.getApp().getSharedPreferences("QQStory_Config_SP_" + paramAppInterface.getAccount(), 4);
    this.em = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.onCreate();
    init();
  }
  
  public static boolean Ir()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static String mj()
  {
    return acfp.m(2131712335);
  }
  
  public static void showToast(String paramString) {}
  
  public boolean Ij()
  {
    return this.aAz;
  }
  
  public boolean Ik()
  {
    return this.aAA;
  }
  
  public boolean Il()
  {
    return this.aAC;
  }
  
  public boolean Im()
  {
    return this.aAB;
  }
  
  public boolean In()
  {
    return this.sp.getBoolean("sp_key_open_myvideo", false);
  }
  
  public boolean Io()
  {
    return this.sp.getBoolean("sp_key_user_show_msg_tab_story_node", false);
  }
  
  public boolean Ip()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_pgc_v_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  public boolean Iq()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_pgc_media_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  public QQStoryUserInfo a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    QQStoryUserInfo localQQStoryUserInfo;
    do
    {
      do
      {
        return localObject;
        localQQStoryUserInfo = (QQStoryUserInfo)this.bR.get(paramString);
        localObject = localQQStoryUserInfo;
      } while (localQQStoryUserInfo != null);
      localQQStoryUserInfo = (QQStoryUserInfo)this.em.find(QQStoryUserInfo.class, paramString);
      localObject = localQQStoryUserInfo;
    } while (localQQStoryUserInfo == null);
    this.bR.put(paramString, localQQStoryUserInfo);
    return localQQStoryUserInfo;
  }
  
  public void blP()
  {
    this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_pgc_media_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void blQ()
  {
    this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_pgc_v_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public long dF()
  {
    return this.sp.getLong("sp_key_msg_tab_active_next_check_time", 0L);
  }
  
  public List<QQStoryUserInfo> e(boolean paramBoolean)
  {
    List localList = null;
    if (paramBoolean) {
      if (this.mj.size() != 0) {
        localList = this.mj;
      }
    }
    while (localList != null)
    {
      Bosses.get().postJob(new pmc(this, "QQStoryManager", paramBoolean));
      return localList;
      if (this.mi.size() != 0) {
        localList = this.mi;
      }
    }
    return f(paramBoolean);
  }
  
  public List<QQStoryUserInfo> f(boolean paramBoolean)
  {
    Object localObject;
    List localList;
    if (paramBoolean)
    {
      localObject = " isAllowed=? ";
      localList = this.em.query(QQStoryUserInfo.class, true, (String)localObject, new String[] { "1" }, null, null, null, null);
      if (!paramBoolean) {
        break label122;
      }
      this.mj = new ArrayList();
      localObject = this.mj;
    }
    for (;;)
    {
      label54:
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)localIterator.next();
            ((List)localObject).add(localQQStoryUserInfo);
            this.bR.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
            continue;
            localObject = " isInterested=? ";
            break;
            label122:
            this.mi = new ArrayList();
            localObject = this.mi;
            break label54;
          }
        }
        return localList;
      }
    }
    return new ArrayList();
  }
  
  public void fe(long paramLong)
  {
    this.sp.edit().putLong("sp_key_msg_tab_active_next_check_time", paramLong).commit();
  }
  
  public void init()
  {
    this.aAz = this.sp.getBoolean("sp_key_my_notification", true);
    this.aAA = this.sp.getBoolean("sp_key_special_notification", true);
    this.aAB = this.sp.getBoolean("sp_key_show_allow_stranger_visit_mystory", false);
    this.aAC = this.sp.getBoolean("sp_key_allow_stranger_visit_mystory", false);
    this.bjn = this.sp.getInt("sp_key_allow_stranger_day_num", 10);
    this.aAD = this.sp.getBoolean("sp_key_show_auto_post2discovery", true);
    this.aAE = this.sp.getBoolean("sp_key_auto_post2discovery", false);
    this.aAF = this.sp.getBoolean("sp_key_show_video_info", false);
    qR(aqmj.Y(this.app.getApp(), this.app.getCurrentAccountUin()));
    this.jdField_a_of_type_Prt = new prt(this.app.getApp(), this.app.getCurrentAccountUin());
  }
  
  public void onDestroy()
  {
    this.em.close();
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.blI();
    }
    psx.a().destroy();
  }
  
  public void qQ(String paramString)
  {
    boolean bool2 = true;
    this.aAx = false;
    this.aAy = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("isHideQZone") != 1) {
          break label85;
        }
        bool1 = true;
        this.aAx = bool1;
        if (paramString.getInt("isHideStory") != 1) {
          break label90;
        }
        bool1 = bool2;
        this.aAy = bool1;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
      return;
      label85:
      boolean bool1 = false;
      continue;
      label90:
      bool1 = false;
    }
  }
  
  public void qR(String paramString)
  {
    boolean bool2 = true;
    this.aAG = false;
    this.aAH = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("story_PGC_steaming") != 1) {
          break label85;
        }
        bool1 = true;
        this.aAG = bool1;
        if (paramString.getInt("story_friend_steaming") != 1) {
          break label90;
        }
        bool1 = bool2;
        this.aAH = bool1;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readStoryPlayerProxyConfig", 2, paramString.getMessage());
      return;
      label85:
      boolean bool1 = false;
      continue;
      label90:
      bool1 = false;
    }
  }
  
  public void rH(boolean paramBoolean)
  {
    this.aAz = paramBoolean;
    this.sp.edit().putBoolean("sp_key_my_notification", paramBoolean).commit();
  }
  
  public void rI(boolean paramBoolean)
  {
    this.aAA = paramBoolean;
    this.sp.edit().putBoolean("sp_key_special_notification", paramBoolean).commit();
  }
  
  public void rJ(boolean paramBoolean)
  {
    this.aAC = paramBoolean;
    this.sp.edit().putBoolean("sp_key_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public void rK(boolean paramBoolean)
  {
    this.aAB = paramBoolean;
    this.sp.edit().putBoolean("sp_key_show_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public void rL(boolean paramBoolean)
  {
    this.aAD = paramBoolean;
    this.sp.edit().putBoolean("sp_key_show_auto_post2discovery", paramBoolean).commit();
  }
  
  public void rM(boolean paramBoolean)
  {
    this.aAE = paramBoolean;
    this.sp.edit().putBoolean("sp_key_auto_post2discovery", paramBoolean).commit();
  }
  
  public void rN(boolean paramBoolean)
  {
    this.aAF = paramBoolean;
    this.sp.edit().putBoolean("sp_key_show_video_info", paramBoolean).commit();
  }
  
  public void rO(boolean paramBoolean)
  {
    this.sp.edit().putBoolean("sp_key_open_myvideo", paramBoolean).commit();
  }
  
  public void rP(boolean paramBoolean)
  {
    this.sp.edit().putBoolean("sp_key_user_show_msg_tab_story_node", paramBoolean).commit();
  }
  
  public int sl()
  {
    return this.sp.getInt("sp_key_auto_play_type", 1001);
  }
  
  public int sm()
  {
    return this.bjn;
  }
  
  public void vK(int paramInt)
  {
    this.sp.edit().putInt("sp_key_net_type", paramInt).commit();
  }
  
  public void vL(int paramInt)
  {
    this.sp.edit().putInt("sp_key_auto_play_type", paramInt).commit();
  }
  
  public void vM(int paramInt)
  {
    this.bjn = paramInt;
    this.sp.edit().putInt("sp_key_allow_stranger_day_num", paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmb
 * JD-Core Version:    0.7.0.1
 */