import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.LocationShareController.4;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.MapWidget.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aitg
  implements aqdf.a
{
  private ImageView AX;
  private View DU;
  private View DV;
  private acfd jdField_a_of_type_Acfd;
  private aiqs jdField_a_of_type_Aiqs;
  private aitg.b jdField_a_of_type_Aitg$b;
  private aitg.c jdField_a_of_type_Aitg$c;
  private aqdf.a jdField_a_of_type_Aqdf$a;
  private aqdf jdField_a_of_type_Aqdf;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private acnd jdField_b_of_type_Acnd;
  private aiqr.a jdField_b_of_type_Aiqr$a = new aith(this);
  private airi jdField_b_of_type_Airi;
  private HashMap<String, aitg.a> eA = new HashMap(10);
  private INetInfoHandler f;
  private BaseActivity mActivity;
  private QQAppInterface mAppInterface;
  private View vb;
  
  public aitg(QQAppInterface paramQQAppInterface)
  {
    this.mAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aiqs = aiqs.a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "stopOnErrorSituationByReason: invoked. ", " uin: ", paramString, " reason: ", Integer.valueOf(paramInt2) });
    }
    LocationRoom.b localb = new LocationRoom.b(paramInt1, paramString);
    aiqs localaiqs = aiqs.a(paramQQAppInterface);
    localaiqs.a(localb, false);
    localaiqs.a.destroy();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    aiup.a(paramQQAppInterface, paramInt1, paramString, false);
    localaiqs.c(localb, paramInt2);
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramQQAppInterface = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if ((paramQQAppInterface == null) || (paramQQAppInterface.vn() < 2)) {}
      }
    }
    try
    {
      paramQQAppInterface.refresh(131072);
      anot.a(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private void b(boolean paramBoolean, MapWidget.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramb.ag);
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
      }
      dur();
      return;
    }
    if (paramb.ag != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Aitg$b.a(paramb, localVenue);
      }
    }
    for (;;)
    {
      this.vb.setVisibility(0);
      this.DU.setVisibility(8);
      this.jdField_a_of_type_Aitg$c.hide();
      this.jdField_a_of_type_Aitg$b.show();
      return;
      this.jdField_a_of_type_Aitg$b.a(paramb);
      continue;
      this.jdField_a_of_type_Aitg$b.a(paramb);
      QQToast.a(this.mActivity, 1, "路径规划失败，请稍后重试", 1).show();
    }
  }
  
  private void bX(Activity paramActivity)
  {
    this.AX.setOnClickListener(new aitk(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new aitl(this, paramActivity));
    this.jdField_a_of_type_Aqdf = new aqdf(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  private void c(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.vb.setVisibility(0);
    this.DU.setVisibility(8);
    this.jdField_a_of_type_Aitg$c.d(paramVenue);
    this.jdField_a_of_type_Aitg$b.hide();
    this.jdField_a_of_type_Aitg$c.show();
  }
  
  private void duo()
  {
    this.jdField_a_of_type_Acfd = new aiti(this);
    this.mAppInterface.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void dup()
  {
    this.jdField_b_of_type_Acnd = new aitj(this);
    this.mAppInterface.addObserver(this.jdField_b_of_type_Acnd);
  }
  
  private void dur()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.vb.setVisibility(4);
    this.DU.setVisibility(0);
    this.jdField_a_of_type_Aitg$c.hide();
    this.jdField_a_of_type_Aitg$b.hide();
  }
  
  private void dus()
  {
    c(null);
  }
  
  private void dut()
  {
    this.f = new aito(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f);
  }
  
  private void duu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b != null)
    {
      airk.b(this.mActivity, this.jdField_a_of_type_Aiqs.getFrom(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc());
      a(this.mAppInterface, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc(), 2);
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    a(paramQQAppInterface, paramInt, paramString, -1);
  }
  
  private String getNickName(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = aqgv.d(this.mActivity.app, paramString, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType() == 0) {
      str = ((acff)this.mActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.getSessionType() == 1) {
        str = aqgv.h(this.mActivity.app, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.xc(), paramString);
      }
    }
  }
  
  private void l(Integer paramInteger)
  {
    if (!aqiw.isNetworkAvailable())
    {
      QQToast.a(this.mActivity, 2131695491, 0).show();
      return;
    }
    int i;
    Integer localInteger;
    if (paramInteger == null)
    {
      i = 0;
      localInteger = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.f(i);
      if ((paramInteger == null) && (localInteger != null))
      {
        if (localInteger.intValue() != 3) {
          break label134;
        }
        anot.a(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label171;
      }
      this.vb.setVisibility(0);
      this.DU.setVisibility(8);
      this.jdField_a_of_type_Aitg$b.Qj(localInteger.intValue());
      this.jdField_a_of_type_Aitg$c.hide();
      this.jdField_a_of_type_Aitg$b.show();
      return;
      i = paramInteger.intValue();
      break;
      label134:
      if (localInteger.intValue() == 1) {
        anot.a(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label171:
    paramInteger = new MapWidget.b();
    paramInteger.ag = Integer.valueOf(i);
    b(false, paramInteger);
  }
  
  public Bitmap E(String paramString)
  {
    Object localObject2 = (aitg.a)this.eA.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((aitg.a)localObject2).lastUpdateTime < 4000L) && (((aitg.a)localObject2).fs != null)) {
        return ((aitg.a)localObject2).fs;
      }
      localObject1 = localObject2;
      if (l - ((aitg.a)localObject2).abT < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new aitg.a(null);
      this.eA.put(paramString, localObject1);
    }
    ((aitg.a)localObject1).abT = l;
    localObject2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((aitg.a)localObject1).lastUpdateTime = l;
      ((aitg.a)localObject1).fs = ((Bitmap)localObject2);
    }
  }
  
  public void LV(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.cs(paramString, true);
  }
  
  public void a(aqdf.a parama)
  {
    this.jdField_a_of_type_Aqdf$a = parama;
  }
  
  public void a(BaseActivity paramBaseActivity, LocationRoom.b paramb, MapWidget paramMapWidget, airi paramairi, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_b_of_type_Airi = paramairi;
    this.AX = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramb;
    this.DU = paramView2;
    this.DV = paramView1;
    this.vb = paramView3;
    this.jdField_a_of_type_Aitg$c = new aitg.c(paramView3);
    this.jdField_a_of_type_Aitg$b = new aitg.b(paramView3);
    this.DV.setVisibility(8);
    ayxa.initLiuHaiProperty(paramBaseActivity);
    if (ayxa.sHasNotch) {}
    for (int i = aqcx.dip2px(paramBaseActivity, 112.0F) + ayxa.sNotchHeight;; i = aqcx.dip2px(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Aiqs.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b), null, i, paramView3);
      bX(paramBaseActivity);
      this.jdField_a_of_type_Aiqs.b(this.jdField_b_of_type_Aiqr$a);
      dut();
      dup();
      duo();
      if (auvj.isNightMode())
      {
        this.AX.setBackgroundResource(2130841354);
        paramView3.setBackgroundResource(2130838900);
      }
      return;
    }
  }
  
  boolean apG()
  {
    return this.DV.getVisibility() == 0;
  }
  
  public void dum()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.f);
      this.f = null;
      this.mAppInterface.removeObserver(this.jdField_b_of_type_Acnd);
      this.mAppInterface.removeObserver(this.jdField_a_of_type_Acfd);
      if (this.jdField_a_of_type_Aqdf != null) {
        this.jdField_a_of_type_Aqdf.destory();
      }
      this.jdField_a_of_type_Aiqs.a(this.jdField_b_of_type_Aiqr$a);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
      }
    }
  }
  
  void duq()
  {
    if (!aqiw.isNetworkAvailable())
    {
      QQToast.a(this.mActivity, 2131695491, 0).show();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      QQToast.a(this.mActivity, 1, "移除失败，请稍后重试", 0).show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.DV.setVisibility(0);
    this.jdField_a_of_type_Aiqs.b(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b, localVenue, new aitn(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = aqhu.r(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    aitg.a locala = (aitg.a)this.eA.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = locala;
    if (locala == null)
    {
      paramBitmap = new aitg.a(null);
      this.eA.put(paramString, paramBitmap);
    }
    paramBitmap.lastUpdateTime = l;
    paramBitmap.fs = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.u(paramString, localBitmap);
    if (this.jdField_a_of_type_Aqdf$a != null) {
      this.jdField_a_of_type_Aqdf$a.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
  
  public void setVenue(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!aqiw.isNetworkAvailable()) {
      QQToast.a(this.mActivity, 2131695491, 0).show();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    c(paramVenue);
    this.DV.setVisibility(0);
    this.jdField_a_of_type_Aiqs.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b, paramVenue, new aitm(this, paramVenue));
  }
  
  static class a
  {
    long abT;
    Bitmap fs;
    long lastUpdateTime;
  }
  
  class b
  {
    View DW;
    View DX;
    View DY;
    View DZ;
    TextView EK;
    View Ea;
    View Eb;
    View Ec;
    View Ed;
    View Ee;
    TextView Uq;
    TextView Ur;
    TextView Us;
    TextView Ut;
    TextView Uu;
    int dfg = 0;
    TextView fe;
    
    b(View paramView)
    {
      this.DW = paramView.findViewById(2131377589);
      this.fe = ((TextView)paramView.findViewById(2131377603));
      this.Uq = ((TextView)paramView.findViewById(2131377602));
      this.DX = paramView.findViewById(2131377588);
      this.EK = ((TextView)paramView.findViewById(2131377601));
      this.Ur = ((TextView)paramView.findViewById(2131377590));
      this.DY = paramView.findViewById(2131377593);
      this.DZ = paramView.findViewById(2131377592);
      this.Ea = paramView.findViewById(2131377586);
      this.Eb = paramView.findViewById(2131377600);
      this.Ec = paramView.findViewById(2131377596);
      this.Ed = paramView.findViewById(2131377594);
      this.Ee = paramView.findViewById(2131377598);
      this.Us = ((TextView)paramView.findViewById(2131377597));
      this.Ut = ((TextView)paramView.findViewById(2131377595));
      this.Uu = ((TextView)paramView.findViewById(2131377599));
      if (auvj.isNightMode())
      {
        this.Ec.setBackgroundResource(2130846277);
        this.Us.setTextColor(aitg.a(aitg.this).getResources().getColor(2131165976));
        this.Ed.setBackgroundResource(2130846277);
        this.Ut.setTextColor(aitg.a(aitg.this).getResources().getColor(2131165976));
        this.Ee.setBackgroundResource(2130846277);
        this.Uu.setTextColor(aitg.a(aitg.this).getResources().getColor(2131165976));
        paramView.findViewById(2131365987).setBackgroundColor(Color.parseColor("#282828"));
        paramView.findViewById(2131365988).setBackgroundColor(Color.parseColor("#282828"));
        this.EK.setTextColor(-1);
        this.Ur.setTextColor(-1);
      }
      this.DX.setOnClickListener(new aitp(this, aitg.this));
      this.DY.setOnClickListener(new aitq(this, aitg.this));
      if (auvj.isNightMode())
      {
        this.DY.setBackgroundResource(2130846278);
        this.fe.setTextColor(-1);
        this.Uq.setTextColor(-1);
      }
      this.Ec.setOnClickListener(new aitr(this, aitg.this));
      this.Ed.setOnClickListener(new aits(this, aitg.this));
      this.Ee.setOnClickListener(new aitt(this, aitg.this));
    }
    
    private String xe()
    {
      switch (this.dfg)
      {
      default: 
        return "drive";
      case 2: 
        return "bus";
      }
      return "walk";
    }
    
    void Qj(int paramInt)
    {
      this.DZ.setVisibility(0);
      this.Eb.setVisibility(8);
      this.Ea.setVisibility(8);
      LocationRoom.Venue localVenue = aitg.a(aitg.this).a();
      this.fe.setText(localVenue.name);
      this.Uq.setText(localVenue.address);
      Qk(paramInt);
    }
    
    void Qk(int paramInt)
    {
      this.dfg = paramInt;
      switch (paramInt)
      {
      default: 
        this.dfg = 1;
        gY(this.Ec);
        return;
      case 2: 
        gY(this.Ed);
        return;
      }
      gY(this.Ee);
    }
    
    void a(MapWidget.b paramb)
    {
      this.DZ.setVisibility(8);
      this.Eb.setVisibility(8);
      this.Ea.setVisibility(0);
      LocationRoom.Venue localVenue = aitg.a(aitg.this).a();
      this.fe.setText(localVenue.name);
      this.Uq.setText(localVenue.address);
      if (paramb != null) {}
      for (int i = paramb.ag.intValue();; i = 1)
      {
        Qk(i);
        return;
      }
    }
    
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    void a(MapWidget.b paramb, LocationRoom.Venue paramVenue)
    {
      this.DZ.setVisibility(8);
      this.Eb.setVisibility(0);
      this.Ea.setVisibility(8);
      this.fe.setText(paramVenue.name);
      this.Uq.setText(paramVenue.address);
      this.EK.setText(aitz.d(paramb.duration));
      if (paramb.distance < 1000.0F) {}
      for (paramVenue = String.format(aitg.a(aitg.this).getResources().getString(2131695484), new Object[] { Integer.valueOf(Math.round(paramb.distance)) });; paramVenue = String.format(aitg.a(aitg.this).getResources().getString(2131695483), new Object[] { Double.valueOf(paramb.distance / 1000.0D) }))
      {
        this.Ur.setText(paramVenue);
        Qk(paramb.ag.intValue());
        return;
      }
    }
    
    void gY(View paramView)
    {
      this.Ec.setSelected(false);
      this.Ed.setSelected(false);
      this.Ee.setSelected(false);
      paramView.setSelected(true);
    }
    
    void hide()
    {
      this.DW.setVisibility(8);
    }
    
    void show()
    {
      this.DW.setVisibility(0);
    }
  }
  
  class c
  {
    View DW;
    View Ef;
    View Eg;
    TextView Uq;
    TextView Uv;
    TextView fe;
    
    c(View paramView)
    {
      this.DW = paramView.findViewById(2131381475);
      this.fe = ((TextView)paramView.findViewById(2131381477));
      this.Uq = ((TextView)paramView.findViewById(2131381474));
      this.Uv = ((TextView)paramView.findViewById(2131381479));
      this.Ef = paramView.findViewById(2131381476);
      this.Eg = paramView.findViewById(2131381478);
      if (auvj.isNightMode())
      {
        this.Eg.setBackgroundResource(2130846278);
        this.Ef.setBackgroundResource(2130846276);
        if ((this.Ef instanceof TextView)) {
          ((TextView)this.Ef).setTextColor(-1);
        }
        this.fe.setTextColor(-1);
        this.Uq.setTextColor(-1);
        ((TextView)this.Ef).setTextColor(-1);
      }
    }
    
    void d(LocationRoom.Venue paramVenue)
    {
      LocationRoom.Venue localVenue = paramVenue;
      if (paramVenue == null) {
        localVenue = aitg.a(aitg.this).a();
      }
      this.fe.setText(String.format(aitg.a(aitg.this).getResources().getString(2131695497), new Object[] { localVenue.name }));
      this.Uq.setText(localVenue.address);
      aitz.c(aitg.a(aitg.this, localVenue.authorUin), aitg.a(aitg.this).getResources().getString(2131695498), this.Uv);
      this.Ef.setOnClickListener(new aitu(this));
      this.Eg.setOnClickListener(new aitv(this));
    }
    
    void hide()
    {
      this.DW.setVisibility(8);
    }
    
    void show()
    {
      this.DW.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitg
 * JD-Core Version:    0.7.0.1
 */