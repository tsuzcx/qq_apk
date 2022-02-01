import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.App;

public class aotc
  implements View.OnClickListener
{
  private Long N;
  protected GridView a;
  protected aotc.a a;
  protected acnd b;
  protected acms c;
  private boolean cOA = true;
  protected AdapterView.OnItemClickListener j = new aotg(this);
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Context mContext;
  private View mRootView;
  public SessionInfo mSessionInfo;
  private long mTroopUin;
  
  public aotc(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    try
    {
      this.mTroopUin = Long.valueOf(paramString).longValue();
      this.mRootView = LayoutInflater.from(paramContext).inflate(2131560057, null);
      paramQQAppInterface = (RelativeLayout)this.mRootView.findViewById(2131377565);
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (bool) {
        paramQQAppInterface.setBackgroundDrawable(paramFragmentActivity.getResources().getDrawable(2130841188));
      }
      paramQQAppInterface = this.mRootView.findViewById(2131379873);
      paramFragmentActivity = (TextView)this.mRootView.findViewById(2131363226);
      paramSessionInfo = (TextView)this.mRootView.findViewById(2131380984);
      if (bool) {
        paramSessionInfo.setTextColor(Color.parseColor("#ffffff"));
      }
      paramFragmentActivity.setOnClickListener(this);
      paramFragmentActivity.setOnTouchListener(new aotd(this));
      paramSessionInfo = (ImageView)this.mRootView.findViewById(2131371314);
      paramSessionInfo.setOnClickListener(this);
      paramSessionInfo.setOnTouchListener(new aote(this));
      if (bool) {
        paramSessionInfo.setColorFilter(2013265919, PorterDuff.Mode.SRC_ATOP);
      }
      if (AppSetting.enableTalkBack)
      {
        paramFragmentActivity.setContentDescription(acfp.m(2131708571));
        paramSessionInfo.setContentDescription(paramContext.getString(2131701857));
      }
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramFragmentActivity = (RelativeLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
        int k = ImmersiveUtils.getStatusBarHeight(paramContext);
        int i = k;
        if (isInBlackList()) {
          i = k - wja.dp2px(10.0F, paramQQAppInterface.getResources());
        }
        paramFragmentActivity.setMargins(0, i, 0, 0);
        paramQQAppInterface.setLayoutParams(paramFragmentActivity);
      }
      if (!bool)
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramFragmentActivity = new ColorDrawable();
        paramFragmentActivity.setColor(Color.parseColor("#EBEDF5"));
        paramQQAppInterface.mRequestWidth = aqnm.getScreenWidth();
        paramQQAppInterface.mRequestHeight = aqnm.getScreenHeight();
        paramQQAppInterface.mFailedDrawable = paramFragmentActivity;
        paramQQAppInterface.mLoadingDrawable = paramFragmentActivity;
        paramQQAppInterface = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200324170329_vqFCVSqE3E.png", paramQQAppInterface);
        if (paramQQAppInterface.getStatus() == 2) {
          paramQQAppInterface.restartDownload();
        }
        paramQQAppInterface.setDecodeHandler(aqbn.y);
        this.mRootView.setBackgroundDrawable(paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        this.mTroopUin = 0L;
        QLog.d("TroopAppShortcutContainer", 2, "TroopAppShortcutContainer troopuinerror:" + paramString);
      }
    }
  }
  
  private void Wg(int paramInt)
  {
    long l2;
    Object localObject;
    long l1;
    int i;
    if (aAz())
    {
      l2 = 0L;
      localObject = (TroopManager)this.mApp.getManager(52);
      l1 = l2;
      if (localObject == null) {
        break label294;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(this.mTroopUin));
      l1 = l2;
      if (localObject == null) {
        break label294;
      }
      l2 = ((TroopInfo)localObject).dwGroupClassExt;
      if (!((TroopInfo)localObject).isTroopOwner(this.mApp.getCurrentUin())) {
        break label223;
      }
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      localObject = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://qun.qq.com/slidepanel/manage?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$".replace("$GCODE$", Long.toString(this.mTroopUin)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)));
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.mActivity.startActivityForResult((Intent)localObject, 20006);
      if (paramInt == 2) {
        anot.a(null, "dc00898", "", "", "0X800AD0B", "0X800AD0B", 0, 0, Integer.toString(i), Long.toString(this.mTroopUin), Long.toString(l1), "");
      }
      label223:
      while (paramInt != 1)
      {
        return;
        l1 = l2;
        if (!((TroopInfo)localObject).isTroopAdmin(this.mApp.getCurrentUin())) {
          break label294;
        }
        i = 2;
        l1 = l2;
        break;
      }
      anot.a(null, "dc00898", "", "", "0X800AD0A", "0X800AD0A", 0, 0, Integer.toString(i), Long.toString(this.mTroopUin), Long.toString(l1), "");
      return;
      label294:
      i = 0;
    }
  }
  
  protected static Drawable a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = aqnm.dpToPx(24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130844521);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130844521);
    label124:
    do
    {
      try
      {
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        float f;
        if (paramInt > 0) {
          f = paramInt;
        }
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          paramContext.setTag(aqbn.d(i, i, aqnm.dpToPx(f)));
          paramContext.setDecodeHandler(aqbn.a);
          localObject = paramContext;
          if (paramContext.getStatus() == 2)
          {
            paramContext.restartDownload();
            localObject = paramContext;
          }
          return localObject;
        }
        catch (Exception localException2)
        {
          Context localContext;
          break label124;
        }
        localException1 = localException1;
        paramContext = null;
      }
      localContext = paramContext;
    } while (!QLog.isColorLevel());
    QLog.e("TroopAppShortcutContainer", 2, "getIcon url: " + paramString);
    return paramContext;
  }
  
  private List<aotc.c> a(aprp paramaprp, List<aotc.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aotc.c localc = (aotc.c)paramList.next();
      if (paramaprp.cP(localc.aqz)) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  private boolean aAz()
  {
    return (apuh.g(this.mApp, Long.toString(this.mTroopUin), this.mApp.getCurrentUin())) || (apuh.f(this.mApp, Long.toString(this.mTroopUin), this.mApp.getCurrentUin()));
  }
  
  private void b(boolean paramBoolean, long paramLong, List paramList, int paramInt)
  {
    if (paramLong != this.mTroopUin) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramList instanceof ArrayList))
      {
        Object localObject = (ArrayList)paramList;
        paramList = new ArrayList();
        paramInt = 0;
        if (paramInt < ((ArrayList)localObject).size())
        {
          oidb_0xe2e.App localApp = (oidb_0xe2e.App)((ArrayList)localObject).get(paramInt);
          if ((localApp.appid.has()) && (localApp.icon.has()) && (localApp.name.has()) && (localApp.url.has()))
          {
            aotc.c localc = new aotc.c();
            localc.aqz = localApp.appid.get();
            localc.app_name = localApp.name.get();
            localc.cmX = localApp.url.get();
            localc.app_icon = localApp.icon.get();
            if (localApp.removable.has()) {
              localc.dRI = localApp.removable.get();
            }
            if (localApp.source.has()) {
              localc.dRJ = localApp.source.get();
            }
            localc.app_type = 0;
            paramList.add(localc);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopAppShortcutContainer", 2, "pbInfo:" + localApp.toString());
            }
            paramInt += 1;
            break;
            QLog.e("TroopAppShortcutContainer", 2, "get appinfo error:" + localApp.toString());
          }
        }
        localObject = (aotc.d)this.mApp.getManager(357);
        if (localObject != null) {
          ((aotc.d)localObject).o(this.mTroopUin, paramList);
        }
        updateUI();
      }
      paramList = (aotc.d)this.mApp.getManager(357);
      if (paramList == null) {
        break label585;
      }
    }
    label585:
    for (paramList = paramList.p(this.mTroopUin);; paramList = null)
    {
      if (paramList != null) {}
      for (paramInt = paramList.size();; paramInt = 0)
      {
        paramList = (TroopManager)this.mApp.getManager(52);
        if (paramList != null)
        {
          paramList = paramList.b(String.valueOf(this.mTroopUin));
          if (paramList == null) {}
        }
        for (paramLong = paramList.dwGroupClassExt;; paramLong = 0L)
        {
          anot.a(null, "dc00898", "", "", "0X800AD08", "0X800AD08", 0, 0, "", Long.toString(this.mTroopUin), Long.toString(paramLong), Integer.toString(paramInt));
          return;
          QLog.e("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps faild troopUin:" + this.mTroopUin + " errCode:" + paramInt);
          if (paramInt == 1002)
          {
            QQToast.a(this.mActivity, this.mContext.getString(2131701858), 0).show();
            break;
          }
          QQToast.a(this.mActivity, this.mContext.getString(2131701859), 0).show();
          break;
        }
      }
    }
  }
  
  private boolean isInBlackList()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  private void updateUI()
  {
    if (this.mRootView != null)
    {
      localObject = (ImageView)this.mRootView.findViewById(2131371314);
      if (aAz()) {
        ((ImageView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = (aotc.d)this.mApp.getManager(357);
      if (localObject == null) {
        break label155;
      }
    }
    label155:
    for (Object localObject = ((aotc.d)localObject).p(this.mTroopUin);; localObject = null)
    {
      if ((localObject != null) && (this.jdField_a_of_type_Aotc$a != null))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        if ((localArrayList.size() < 16) && (aAz()))
        {
          localObject = new aotc.c();
          ((aotc.c)localObject).app_type = 1;
          localArrayList.add(localObject);
        }
        localObject = a((aprp)this.mApp.getManager(109), localArrayList);
        this.jdField_a_of_type_Aotc$a.mG((List)localObject);
      }
      return;
      ((ImageView)localObject).setVisibility(8);
      break;
    }
  }
  
  public void dWO()
  {
    this.cOA = true;
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20006)
    {
      paramIntent = (TroopManager)this.mApp.getManager(52);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.b(String.valueOf(this.mTroopUin));
        if ((paramIntent != null) && (this.c != null)) {
          this.c.aB(this.mTroopUin, (int)paramIntent.dwGroupClassExt);
        }
      }
    }
  }
  
  public void initData()
  {
    this.c = ((acms)this.mApp.getBusinessHandler(20));
    Object localObject = (TroopManager)this.mApp.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(String.valueOf(this.mTroopUin));
      if (localObject == null) {
        break label145;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps troopuin:" + this.mTroopUin + " dwGroupClassExt" + ((TroopInfo)localObject).dwGroupClassExt);
      }
      this.c.aB(this.mTroopUin, (int)((TroopInfo)localObject).dwGroupClassExt);
      if (this.b == null)
      {
        this.b = new aotf(this);
        this.mApp.addObserver(this.b);
      }
    }
    return;
    label145:
    QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
  }
  
  public void initUI()
  {
    if (this.cOA)
    {
      updateUI();
      initData();
    }
    this.cOA = false;
    if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.mRootView.findViewById(2131380224));
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.j);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(4);
    int i = (((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight() - wja.dp2px(11.0F, this.mActivity.getResources()) * 3) / 4;
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(i);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    this.jdField_a_of_type_Aotc$a = new aotc.a(this.mContext, i, bool);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aotc$a);
    updateUI();
  }
  
  public boolean onBackEvent()
  {
    yZ(true);
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.N != null) && (l - this.N.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.N = Long.valueOf(l);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363226: 
        yZ(true);
        break;
      case 2131371314: 
        Wg(2);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "onDestroy");
    }
    if ((this.b != null) && (this.mApp != null))
    {
      this.mApp.removeObserver(this.b);
      this.b = null;
    }
    this.mApp = null;
    this.mActivity = null;
    this.mContext = null;
    this.mRootView = null;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_Aotc$a = null;
    this.mTroopUin = 0L;
  }
  
  public void yZ(boolean paramBoolean) {}
  
  public static class a
    extends BaseAdapter
  {
    private boolean cOB;
    private int dRH;
    private LayoutInflater inflater;
    private List<aotc.c> items = new ArrayList();
    private Context mContext;
    
    public a(Context paramContext, int paramInt, boolean paramBoolean)
    {
      this.mContext = paramContext;
      this.inflater = LayoutInflater.from(paramContext);
      this.dRH = paramInt;
      this.cOB = paramBoolean;
    }
    
    public aotc.c a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.items.size())) {
        return null;
      }
      return (aotc.c)this.items.get(paramInt);
    }
    
    public int getCount()
    {
      return this.items.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      aotc.c localc = a(paramInt);
      if (localc != null) {
        return localc.app_type;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      Object localObject2;
      if (paramView == null) {
        if (i == 0)
        {
          paramView = this.inflater.inflate(2131560058, paramViewGroup, false);
          localObject1 = new aotc.b();
          ((aotc.b)localObject1).bP = ((URLImageView)paramView.findViewById(2131380222));
          ((aotc.b)localObject1).titleTv = ((TextView)paramView.findViewById(2131380223));
          paramView.setTag(localObject1);
          localObject2 = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).height = this.dRH;
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if (!this.cOB) {
            break label241;
          }
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(12.0F);
          ((GradientDrawable)localObject2).setColor(-14934754);
          paramView.setBackgroundDrawable((Drawable)localObject2);
        }
      }
      for (;;)
      {
        localObject2 = a(paramInt);
        if (localObject2 != null) {
          break label284;
        }
        QLog.e("TroopAppShortcutContainer", 2, "getItem() == null position:" + paramInt);
        for (localObject1 = paramView;; localObject1 = null)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
          if (i == 1)
          {
            paramView = this.inflater.inflate(2131560059, paramViewGroup, false);
            localObject1 = new aotc.b();
            ((aotc.b)localObject1).bP = ((URLImageView)paramView.findViewById(2131380222));
            paramView.setTag(localObject1);
            break;
          }
        }
        label241:
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(12.0F);
        ((GradientDrawable)localObject2).setColor(-1);
        paramView.setBackgroundDrawable((Drawable)localObject2);
        continue;
        localObject1 = (aotc.b)paramView.getTag();
      }
      label284:
      ((aotc.b)localObject1).a = ((aotc.c)localObject2);
      if (i == 0)
      {
        ((aotc.b)localObject1).titleTv.setText(((aotc.c)localObject2).app_name);
        if (this.cOB) {
          ((aotc.b)localObject1).titleTv.setTextColor(Color.parseColor("#ffffff"));
        }
      }
      if (this.cOB) {
        ((aotc.b)localObject1).bP.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
      if (((aotc.c)localObject2).app_type == 1)
      {
        ((aotc.b)localObject1).bP.setImageDrawable(this.mContext.getResources().getDrawable(2130851840));
        ((aotc.b)localObject1).bP.setOnTouchListener(new aoth(this));
        label394:
        if (AppSetting.enableTalkBack) {
          if (((aotc.c)localObject2).app_name == null) {
            break label564;
          }
        }
      }
      label516:
      label540:
      label564:
      for (Object localObject1 = ((aotc.c)localObject2).app_name;; localObject1 = "")
      {
        for (;;)
        {
          paramView.setContentDescription((CharSequence)localObject1);
          localObject1 = paramView;
          break;
          ((aotc.b)localObject1).bP.setOnTouchListener(null);
          if (((aotc.c)localObject2).app_icon == null) {
            break label540;
          }
          try
          {
            if (!MiniAppLauncher.isMiniAppUrl(((aotc.c)localObject2).cmX)) {
              break label516;
            }
            ((aotc.b)localObject1).bP.setImageDrawable(aotc.a(this.mContext, ((aotc.c)localObject2).app_icon, 4));
          }
          catch (Exception localException)
          {
            QLog.e("TroopAppShortcutContainer", 1, "fetchDrawable: failed. ", localException);
            ((aotc.b)localObject1).bP.setImageDrawable(this.mContext.getResources().getDrawable(2130844521));
          }
        }
        break label394;
        ((aotc.b)localObject1).bP.setImageDrawable(aotc.a(this.mContext, ((aotc.c)localObject2).app_icon, 0));
        break label394;
        ((aotc.b)localObject1).bP.setImageDrawable(this.mContext.getResources().getDrawable(2130844521));
        break label394;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void mG(List<aotc.c> paramList)
    {
      if (paramList != null)
      {
        this.items.clear();
        this.items.addAll(paramList);
        notifyDataSetChanged();
      }
    }
  }
  
  public static class b
  {
    public aotc.c a;
    public URLImageView bP;
    public TextView titleTv;
  }
  
  public static class c
  {
    public String app_icon = "";
    public String app_name = "";
    public int app_type = 0;
    public long aqz = 0L;
    public String cmX = "";
    public int dRI = 0;
    public int dRJ = 0;
    
    public String toString()
    {
      return "TroopAppInfo{app_type='" + this.app_type + '\'' + ", app_appid='" + this.aqz + '\'' + ", app_removable='" + this.dRI + '\'' + ", app_source='" + this.dRJ + '\'' + ", app_name='" + this.app_name + '\'' + ", app_icon='" + this.app_icon + '\'' + ", app_url='" + this.cmX + '\'' + "}";
    }
  }
  
  public static class d
    implements Manager
  {
    private HashMap<Long, ArrayList<aotc.c>> nZ = new HashMap();
    
    public void o(long paramLong, ArrayList<aotc.c> paramArrayList)
    {
      this.nZ.put(Long.valueOf(paramLong), paramArrayList);
    }
    
    public void onDestroy()
    {
      this.nZ.clear();
    }
    
    public ArrayList<aotc.c> p(long paramLong)
    {
      return (ArrayList)this.nZ.get(Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotc
 * JD-Core Version:    0.7.0.1
 */