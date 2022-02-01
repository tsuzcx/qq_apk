import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;

public class aiqk
  extends aiqd
{
  public aiqk(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public static aiqk a(BaseChatPie paramBaseChatPie)
  {
    return (aiqk)paramBaseChatPie.a(33);
  }
  
  public void Lq(boolean paramBoolean)
  {
    this.clv = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel_Troop", 2, "onShowTroopType hasAnythingDiglog2Show:" + paramBoolean);
    }
  }
  
  public boolean apk()
  {
    if (this.mActivity.app.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_Aiqd$b.baZ)) {
      return true;
    }
    return isAdmin();
  }
  
  public void ccU()
  {
    if ((this.mBaseChatPie instanceof TroopChatPie)) {
      ((TroopChatPie)this.mBaseChatPie).ccU();
    }
  }
  
  protected void dtI()
  {
    if (!this.zR) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Aiqd$b.mCurType == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aiqd$b.mCurUin)) && (this.jdField_a_of_type_Aiqd$b.a != null) && (this.jdField_a_of_type_Aiqd$b.a.ckM) && (this.jdField_a_of_type_Aiqd$b.status != 3)) {
        if (this.jdField_a_of_type_Aiqd$b.isAdmin) {
          try
          {
            if (aiob.a(this.mBaseChatPie.app, "listen_together_allow_start_admin_guide", false, false)) {
              continue;
            }
            aiob.a(this.mBaseChatPie.app, "listen_together_allow_start_admin_guide", true, false);
            aqju localaqju = aqha.a(this.mActivity, 230);
            localaqju.setMessage("一起听歌允许群成员开启，你可以在一起听歌-设置 中关闭此权限。").setTitle("一起听歌功能更新").setPositiveButton("知道了", new aiql(this, localaqju));
            localaqju.show();
            return;
          }
          catch (Exception localException1)
          {
            aiob.a(this.mBaseChatPie.app, "listen_together_allow_start_admin_guide", true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", localException1);
            return;
          }
        } else {
          try
          {
            Object localObject = aiob.H(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
            if (!aiob.a(this.mBaseChatPie.app, (String)localObject, false, false))
            {
              aiob.a(this.mBaseChatPie.app, (String)localObject, true, false);
              localObject = aqha.a(this.mActivity, 230);
              ((aqju)localObject).setMessage("本群支持群成员开启一起听歌功能").setTitle("一起听歌功能更新").setPositiveButton("知道了", new aiqm(this, (aqju)localObject));
              ((aqju)localObject).show();
              return;
            }
          }
          catch (Exception localException2)
          {
            String str = aiob.H(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
            aiob.a(this.mBaseChatPie.app, str, true, false);
            QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", localException2);
          }
        }
      }
    }
  }
  
  public boolean isAdmin()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mActivity.app.getManager(52)).c(this.jdField_a_of_type_Aiqd$b.mCurUin);
    boolean bool = false;
    if (localTroopInfo != null) {
      bool = localTroopInfo.isAdmin();
    }
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aiqd$b.mCurType = 1;
    this.jdField_a_of_type_Aiqd$b.mCurUin = this.mBaseChatPie.oL();
    if (this.jdField_a_of_type_Aiqd$b.mCurUin == null) {
      this.jdField_a_of_type_Aiqd$b.mCurUin = "";
    }
    String str = this.mBaseChatPie.app.getCurrentUin();
    this.jdField_a_of_type_Aiqd$a = new aiqd.a();
    this.jdField_a_of_type_Aiqd$a.mainAction = "Grp_AIO";
    int i = aiob.M(str, this.jdField_a_of_type_Aiqd$b.mCurUin);
    this.jdField_a_of_type_Aiqd$a.deQ = i;
    this.jdField_a_of_type_Aiqd$a.bPt = this.jdField_a_of_type_Aiqd$b.mCurUin;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.clv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqk
 * JD-Core Version:    0.7.0.1
 */