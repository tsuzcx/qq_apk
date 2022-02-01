import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.1;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Timer;
import tencent.im.nearfield_friend.nearfield_friend.GPS;

public class ype
{
  private acfd jdField_a_of_type_Acfd = new ypi(this);
  private nearfield_friend.GPS jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  private ypc jdField_a_of_type_Ypc;
  private ypd jdField_a_of_type_Ypd = new yph(this);
  private ypl jdField_a_of_type_Ypl;
  private int cat = 60000;
  private int cau = 1200000;
  private QQAppInterface mApp;
  private String mSessionId;
  private Timer mTimer;
  
  public ype(Face2FaceAddContactFragment paramFace2FaceAddContactFragment)
  {
    this.jdField_a_of_type_Ypl = paramFace2FaceAddContactFragment;
    this.mApp = paramFace2FaceAddContactFragment.getActivity().app;
    this.mApp.addObserver(this.jdField_a_of_type_Ypd);
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    this.jdField_a_of_type_Ypc = ((ypc)this.mApp.getBusinessHandler(169));
  }
  
  private nearfield_friend.GPS a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      nearfield_friend.GPS localGPS = new nearfield_friend.GPS();
      localGPS.lat.set((int)(paramSosoLbsInfo.a.cd * 1000000.0D));
      localGPS.lng.set((int)(paramSosoLbsInfo.a.ce * 1000000.0D));
      localGPS.type.set(1);
      localStringBuffer.append("generateGPSInfo GPS: ").append(paramSosoLbsInfo.a.cd * 1000000.0D).append(",").append(paramSosoLbsInfo.a.ce * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS = localGPS;
      if (QLog.isColorLevel()) {
        QLog.i("Face2FaceAddContactPresenter", 2, localStringBuffer.toString());
      }
    }
    return this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  }
  
  private void a(FragmentActivity paramFragmentActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        paramFragmentActivity.requestPermissions(new ypf(this, paramBoolean, paramString1, paramString2), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    while (!paramBoolean)
    {
      do
      {
        return;
      } while (!paramBoolean);
      dJ(paramString1, paramString2);
      return;
    }
    dJ(paramString1, paramString2);
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    this.mSessionId = pP();
    nearfield_friend.GPS localGPS = a(paramSosoLbsInfo);
    paramSosoLbsInfo = null;
    if (!TextUtils.isEmpty(paramString2)) {
      paramSosoLbsInfo = paramString2.getBytes();
    }
    this.jdField_a_of_type_Ypc.a(this.mSessionId, paramString1, localGPS, paramSosoLbsInfo);
  }
  
  private void b(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(this.mSessionId, paramString1)) && (this.mApp != null)) {
      if (paramInt2 == 2) {
        if (this.jdField_a_of_type_Ypl != null) {
          this.jdField_a_of_type_Ypl.ckx();
        }
      }
    }
    while (this.jdField_a_of_type_Ypl == null)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt2 != 3) {
                  break;
                }
              } while (this.jdField_a_of_type_Ypl == null);
              this.jdField_a_of_type_Ypl.za(paramString3);
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 0: 
                this.cat = Math.max(paramInt3 * 1000, 10000);
                this.cau = Math.max(paramInt4 * 1000, 10000);
                if (this.jdField_a_of_type_Ypl != null)
                {
                  this.jdField_a_of_type_Ypl.Ep(this.cau);
                  this.jdField_a_of_type_Ypl.Eq(this.cat);
                }
                startTimer();
                return;
              }
            } while (this.jdField_a_of_type_Ypl == null);
            this.jdField_a_of_type_Ypl.ckz();
            return;
          } while (this.jdField_a_of_type_Ypl == null);
          this.jdField_a_of_type_Ypl.cku();
          return;
        } while (this.jdField_a_of_type_Ypl == null);
        this.jdField_a_of_type_Ypl.ckv();
        return;
      } while (this.jdField_a_of_type_Ypl == null);
      this.jdField_a_of_type_Ypl.ckw();
      return;
    }
    this.jdField_a_of_type_Ypl.ckw();
  }
  
  private void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.mSessionId))) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Ypl == null);
        if ((paramList != null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_Ypl.gH(paramList);
        }
        this.jdField_a_of_type_Ypl.Eq(this.cat);
        return;
      } while (this.jdField_a_of_type_Ypl == null);
      this.jdField_a_of_type_Ypl.cku();
      return;
    } while (this.jdField_a_of_type_Ypl == null);
    this.jdField_a_of_type_Ypl.ckv();
  }
  
  private void dJ(String paramString1, String paramString2)
  {
    ThreadManager.post(new Face2FaceAddContactPresenter.3(this, paramString1, paramString2), 8, null, false);
  }
  
  private String pP()
  {
    if (this.mApp != null) {
      return this.mApp.getCurrentAccountUin() + "_" + System.currentTimeMillis() + "_" + (int)Math.floor(Math.random() * 100000.0D) % 100000;
    }
    return "";
  }
  
  private void startTimer()
  {
    stopTimer();
    this.mTimer = new Timer();
    this.mTimer.schedule(new Face2FaceAddContactPresenter.1(this), 300000L);
  }
  
  private void stopTimer()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
  }
  
  public void a(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    a(paramFragmentActivity, true, paramString1, paramString2);
  }
  
  public void b(FragmentActivity paramFragmentActivity)
  {
    a(paramFragmentActivity, false, "", "");
  }
  
  public void ckB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendExitFace2FaceAddContactReq mSessionId:" + this.mSessionId);
    }
    if (!TextUtils.isEmpty(this.mSessionId))
    {
      this.jdField_a_of_type_Ypc.zb(this.mSessionId);
      this.mSessionId = null;
    }
  }
  
  public void gI(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendFace2FaceAddContactHeartBeatReq mSessionId:" + this.mSessionId + " faceFriends:" + paramList);
    }
    if (!TextUtils.isEmpty(this.mSessionId)) {
      this.jdField_a_of_type_Ypc.t(this.mSessionId, paramList);
    }
  }
  
  public void onDestroy()
  {
    if (!TextUtils.isEmpty(this.mSessionId)) {
      ckB();
    }
    stopTimer();
    this.jdField_a_of_type_Ypl = null;
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ypd);
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ype
 * JD-Core Version:    0.7.0.1
 */