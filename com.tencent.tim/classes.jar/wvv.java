import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class wvv
  implements wvs
{
  private static Map<Pair<Integer, String>, Boolean> hG = new ConcurrentHashMap();
  private aiqr.a jdField_a_of_type_Aiqr$a = new wvw(this);
  private aiqs jdField_a_of_type_Aiqs;
  private aivk jdField_a_of_type_Aivk = new wvx(this);
  private volatile LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private yiu b;
  private volatile BaseChatPie c;
  
  wvv(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.jdField_a_of_type_Aiqs = aiqs.a(paramBaseChatPie.app);
  }
  
  private String a(LocationRoom.b paramb, String paramString)
  {
    String str = aqgv.d(this.c.app, paramString, 0);
    if (paramb.getSessionType() == 0) {
      str = ((acff)this.c.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    while (paramb.getSessionType() != 1) {
      return str;
    }
    return aqgv.h(this.c.app, paramb.xc(), paramString);
  }
  
  private void ccv()
  {
    this.b = this.c.a();
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = new LocationRoom.b(this.c.sessionInfo.cZ, this.c.sessionInfo.aTl);
    if (aiuq.g(this.c.app, this.c.sessionInfo.cZ, this.c.sessionInfo.aTl))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc());
      }
      this.jdField_a_of_type_Aiqs.a.dn(this.c.sessionInfo.cZ, this.c.sessionInfo.aTl);
    }
  }
  
  private void ccw()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b != null) && (!aiuq.g(this.c.app, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc())) && (this.b == this.c.a().a())) {
      this.c.a().ciA();
    }
  }
  
  private void ccx()
  {
    if ((this.c != null) && (this.c.sessionInfo != null))
    {
      i = this.c.sessionInfo.cZ;
      str = this.c.sessionInfo.aTl;
      if (TextUtils.isEmpty(str)) {
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. empty uin, ignored. ", " friendUin: ", str });
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      boolean bool;
      do
      {
        int i;
        Pair localPair;
        do
        {
          return;
          localPair = new Pair(Integer.valueOf(i), str);
        } while (hG.containsKey(localPair));
        bool = aiuq.g(this.c.app, i, str);
        aiup.a(this.c.app, i, str, bool);
        hG.put(localPair, Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. ", "[处理漫游消息，登录后首次进该会话aio，用资料位刷新消息字段] sessionSharingLocation: ", Boolean.valueOf(bool), " friendUin: ", str });
      return;
    }
    QLog.e("LocationShareHelper", 2, new Object[] { "processRoamMessage: failed. ", "empty session. " });
  }
  
  public static void ccy()
  {
    hG.clear();
  }
  
  private boolean k(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] null ");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] sessionType: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType() + " [mRoomKey] sessionUin: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc());
    }
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.K(paramInt, paramString);
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 8, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_Aiqs.b(this.jdField_a_of_type_Aiqr$a);
        aivd.a(this.c.app).a().a(this.jdField_a_of_type_Aivk);
        LocationShareHelper.3 local3 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post(local3);
        continue;
      }
      finally {}
      ccw();
      continue;
      ccv();
      continue;
      this.jdField_a_of_type_Aiqs.a(this.jdField_a_of_type_Aiqr$a);
      aivd.a(this.c.app).a().b(this.jdField_a_of_type_Aivk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvv
 * JD-Core Version:    0.7.0.1
 */