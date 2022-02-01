import android.app.Activity;
import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.net.LocationHandler.3;
import com.tencent.mobileqq.location.net.LocationHandler.7;
import com.tencent.mobileqq.location.net.LocationHandler.8;
import com.tencent.mobileqq.location.net.LocationHandler.9;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public class aiqs
  extends accg
  implements acek.a
{
  private static Handler da = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng h;
  private acfd jdField_a_of_type_Acfd;
  private aiqr jdField_a_of_type_Aiqr;
  private volatile aiqs.a jdField_a_of_type_Aiqs$a;
  private aiqs.b jdField_a_of_type_Aiqs$b;
  private aiqy jdField_a_of_type_Aiqy;
  public aira a;
  public airb a;
  public airc a;
  private aire jdField_a_of_type_Aire;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private acnd jdField_b_of_type_Acnd;
  private TencentLocationListener jdField_b_of_type_ComTencentMapGeolocationTencentLocationListener;
  private LocationRoom.b jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private double cL = 0.0D;
  private volatile boolean clC;
  private volatile boolean clD;
  private LatLng i;
  private int mFrom = -1;
  
  public aiqs(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    dtO();
    dtU();
  }
  
  private void Lu(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Aiqs$a != null) {
        this.jdField_a_of_type_Aiqs$a.a(this.i, Double.valueOf(this.cL), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static aiqs a(QQAppInterface paramQQAppInterface)
  {
    return (aiqs)paramQQAppInterface.getBusinessHandler(164);
  }
  
  static int dt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return 1;
    }
    return 2;
  }
  
  private void dtO()
  {
    this.jdField_a_of_type_Airb = new airb(this.app, this);
    this.jdField_a_of_type_Aira = new aira(this.app);
    this.jdField_a_of_type_Airc = new airc(this.app);
    this.jdField_a_of_type_Aire = new aire(this.app);
    this.jdField_a_of_type_Aiqy = new aiqy(this.app, this);
    dtP();
    dtQ();
    dtT();
    this.jdField_a_of_type_Aiqr = new aiqr(this.app.getCurrentUin());
  }
  
  private void dtP()
  {
    this.jdField_b_of_type_Acnd = new aiqt(this);
  }
  
  private void dtQ()
  {
    this.jdField_a_of_type_Acfd = new aiqu(this);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void dtS()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.getClass().getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager);
      Field localField = localObject.getClass().getDeclaredField("b");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = localObject.getClass().getDeclaredField("g");
      localField.setAccessible(true);
      localField.set(localObject, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  private void dtT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "addRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.addObserver(this.jdField_b_of_type_Acnd);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void dtU()
  {
    this.app.addObserver(this.jdField_a_of_type_Aiqy);
  }
  
  private void dtV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_b_of_type_Acnd);
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void dtW()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aiqy);
  }
  
  public void Lt(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(paramBoolean) });
    }
    this.clC = paramBoolean;
  }
  
  public LocationRoom a(LocationRoom.b paramb)
  {
    return this.jdField_a_of_type_Aiqr.a(paramb);
  }
  
  public void a(aiqr.a parama)
  {
    this.jdField_a_of_type_Aiqr.a(parama);
  }
  
  public void a(aiqs.a parama)
  {
    try
    {
      this.jdField_a_of_type_Aiqs$a = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (apB()) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramLocationRoom.a();
    Object localObject = acek.a();
    if (!((acek)localObject).dT().contains(this)) {
      ((acek)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Aira.b(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b);
    if (bool) {
      dk(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType(), this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_b_of_type_ComTencentMapGeolocationTencentLocationListener = new aiqv(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new aiqw(this);
      paramLocationRoom = aeie.a(BaseApplicationImpl.getApplication());
      int j = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLocationRoom.fv()), this.jdField_b_of_type_ComTencentMapGeolocationTencentLocationListener);
      if (j != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + j);
        QQToast.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).show();
        if (paramActivity != null) {
          paramActivity.finish();
        }
      }
      j = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (j == 0) {
        break;
      }
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + j);
      QQToast.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).show();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed((Runnable)localObject, 15000L);
    }
  }
  
  void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Aiqs$b != null)
    {
      Pair localPair = this.jdField_a_of_type_Aiqs$b.p();
      if ((localPair != null) && (paramb.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Aiqs$b.b(paramb, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Aiqs$b = null;
      }
    }
  }
  
  public void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, aiqs.b paramb1)
  {
    if ((paramb == null) || (paramVenue == null))
    {
      paramb1.b(paramb, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Aiqs$b = paramb1;
    this.jdField_a_of_type_Aire.a(paramb, paramVenue);
  }
  
  void a(LocationRoom.b paramb, String paramString)
  {
    if ((a(paramb).apz()) && (!this.app.getCurrentUin().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131695492, 0).show();
    }
  }
  
  public void a(LocationRoom.b paramb, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramb != null) && (!paramb.equals(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramb, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramb);
      }
      this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b = null;
      acek.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_b_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        dtS();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Aira.destroy();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramb = aivd.a(this.app);
        if (paramb != null)
        {
          paramb.Ql(-1);
          return;
        }
      }
      catch (Throwable paramb)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramb);
      }
    }
  }
  
  boolean apA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.clC) });
    }
    return this.clC;
  }
  
  public boolean apB()
  {
    return this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b != null;
  }
  
  LatLng b()
  {
    if (this.i == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
    }
    return this.i;
  }
  
  public void b(aiqr.a parama)
  {
    this.jdField_a_of_type_Aiqr.b(parama);
  }
  
  public void b(aiqs.a parama)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + parama + " mLocationListener: " + this.jdField_a_of_type_Aiqs$a);
      }
      if (parama == this.jdField_a_of_type_Aiqs$a) {
        this.jdField_a_of_type_Aiqs$a = null;
      }
      return;
    }
    finally {}
  }
  
  void b(LocationRoom.b paramb, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aiqr.b(paramb, paramInt1, paramInt2);
  }
  
  public void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, aiqs.b paramb1)
  {
    if ((paramb == null) || (paramVenue == null))
    {
      paramb1.b(paramb, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Aiqs$b = paramb1;
    this.jdField_a_of_type_Aire.b(paramb, paramVenue);
  }
  
  void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    this.jdField_a_of_type_Aiqr.b(paramb, paramVenue, paramList);
  }
  
  void c(LocationRoom.b paramb)
  {
    if (a(paramb).apz()) {
      QQToast.a(this.app.getApp(), 2131695494, 0).show();
    }
  }
  
  public void c(LocationRoom.b paramb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramb + " reason: " + paramInt);
    }
    a(paramb, false);
    this.jdField_a_of_type_Aiqr.c(paramb, paramInt);
  }
  
  void d(LocationRoom.b paramb)
  {
    if (a(paramb).apz()) {
      QQToast.a(this.app.getApp(), 2131695493, 0).show();
    }
  }
  
  void d(LocationRoom.b paramb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramb + " clientType: " + paramInt);
    }
    a(paramb, true);
    this.jdField_a_of_type_Aiqr.d(paramb, paramInt);
  }
  
  public void dj(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aiqr.dj(paramInt, paramString);
  }
  
  public void dk(int paramInt, String paramString)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] createOrJoinRoom: invoked.");
    }
    if (paramInt == 0) {
      if (!aiuq.H(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Airb.G(j, paramInt, paramString);
      return;
      j = 1;
      continue;
      if (paramInt == 1)
      {
        if (!aiuq.I(this.app, paramString)) {
          j = 1;
        }
      }
      else
      {
        QLog.d("LocationHandler", 1, new Object[] { "createOrJoinRoom: invoked. (进入已关闭的房间，需要兜底逻辑[弹窗、刷新本地标志等]) ", " operateType: ", Integer.valueOf(0), " mLocationShareFragment.sessionUinType: ", Integer.valueOf(paramInt) });
        j = 0;
      }
    }
  }
  
  public void dl(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aira.a(paramString, new aiqx(this, paramInt, paramString));
  }
  
  public void dtR()
  {
    this.mFrom = -1;
  }
  
  public void e(LocationRoom.b paramb)
  {
    LocationRoom.b localb = new LocationRoom.b(this.jdField_a_of_type_Aira.FV(), this.jdField_a_of_type_Aira.xd());
    if (!localb.equals(paramb))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramb + " org roomKey: " + localb);
      }
      this.jdField_a_of_type_Aiqr.b(localb);
    }
  }
  
  public void f(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (aiuq.g(this.app, paramInt1, paramString))
    {
      anot.a(null, "CliOper", "", "", "0X800A76C", "0X800A76C", dt(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public int getFrom()
  {
    return this.mFrom;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aiqz.class;
  }
  
  public void onAppBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
    }
    Object localObject = aeie.a(BaseApplicationImpl.getApplication());
    this.clD = false;
    da.postDelayed(new LocationHandler.8(this), ((aemk)localObject).fw());
    if ((((aemk)localObject).fw() <= 0L) || (!apB())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131696478)).setWhen(System.currentTimeMillis()).setSmallIcon(2130842268).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    da.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void onAppForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
    }
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    this.clD = true;
    da.removeCallbacksAndMessages(null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$b, true);
    dtV();
    dtW();
    this.jdField_a_of_type_Airc.destroy();
    this.jdField_a_of_type_Aira.destroy();
    this.jdField_a_of_type_Aiqr.clear();
    wvv.ccy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Airb.jR(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Aira.jQ(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Airc.jS(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Aire.jT(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void setFrom(int paramInt)
  {
    this.mFrom = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(LatLng paramLatLng, Double paramDouble, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2);
    
    public abstract Pair<LocationRoom.b, LocationRoom.Venue> p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqs
 * JD-Core Version:    0.7.0.1
 */