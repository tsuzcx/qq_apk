import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class wxz
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, wxr
{
  private TextView HU;
  private TextView HV;
  private TextView HW;
  private TextView IF;
  private TextView Ia;
  private TextView Ib;
  private Long N;
  public String QE;
  acfd jdField_a_of_type_Acfd = new wyb(this);
  private ahpj jdField_a_of_type_Ahpj;
  ahpp jdField_a_of_type_Ahpp = new wyd(this);
  ajjl jdField_a_of_type_Ajjl;
  aqdf.a jdField_a_of_type_Aqdf$a = new wyc(this);
  private aqdf jdField_a_of_type_Aqdf;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private String aTa;
  public boolean aqw;
  public boolean bdX;
  private boolean bdY;
  private int bvC = 1;
  private Button dT;
  private BounceScrollView f;
  private arhz g;
  private LinearLayout gV;
  private View hY;
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Context mContext;
  public String mMemberUin;
  private View mRootView;
  private Handler mUIHandler;
  private ImageView sg;
  private ImageView sh;
  private ImageView si;
  private View wf;
  private View wg;
  private View wh;
  private View wk;
  private View wl;
  
  public wxz(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mMemberUin = paramString;
    paramQQAppInterface = LayoutInflater.from(paramContext).inflate(2131559452, null);
    this.mRootView = paramQQAppInterface.findViewById(2131377565);
    this.hY = paramQQAppInterface.findViewById(2131379873);
    this.HU = ((TextView)paramQQAppInterface.findViewById(2131363226));
    this.HV = ((TextView)paramQQAppInterface.findViewById(2131379832));
    this.sg = ((ImageView)paramQQAppInterface.findViewById(2131377976));
    this.sh = ((ImageView)paramQQAppInterface.findViewById(2131367682));
    this.wf = paramQQAppInterface.findViewById(2131365090);
    this.wg = paramQQAppInterface.findViewById(2131365094);
    this.HW = ((TextView)paramQQAppInterface.findViewById(2131365093));
    this.wh = paramQQAppInterface.findViewById(2131376864);
    this.si = ((ImageView)paramQQAppInterface.findViewById(2131376862));
    this.Ia = ((TextView)paramQQAppInterface.findViewById(2131376863));
    this.Ib = ((TextView)paramQQAppInterface.findViewById(2131376865));
    this.wl = paramQQAppInterface.findViewById(2131366251);
    this.wk = paramQQAppInterface.findViewById(2131367668);
    this.gV = ((LinearLayout)paramQQAppInterface.findViewById(2131367666));
    this.dT = ((Button)paramQQAppInterface.findViewById(2131362207));
    this.IF = ((TextView)paramQQAppInterface.findViewById(2131382102));
    this.f = ((BounceScrollView)paramQQAppInterface.findViewById(2131377766));
    this.f.setOverScrollMode(0);
    this.f.setEdgeEffectEnabled(false);
    this.f.setVerticalScrollBarEnabled(false);
    this.HU.setOnClickListener(this);
    this.wg.setOnClickListener(this);
    this.wh.setOnClickListener(this);
    this.wk.setOnClickListener(this);
    this.sg.setOnClickListener(this);
    this.sh.setOnClickListener(this);
    this.wl.setOnClickListener(this);
    this.dT.setOnClickListener(this);
    this.HU.setOnTouchListener(this);
    this.wg.setOnTouchListener(this);
    this.wh.setOnTouchListener(this);
    this.sg.setOnTouchListener(this);
    this.sh.setOnTouchListener(this);
    this.wl.setOnTouchListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.HU.setContentDescription(acfp.m(2131714987));
      this.sh.setContentDescription(acfp.m(2131714985));
      this.sg.setContentDescription(acfp.m(2131714988));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.hY.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.hY.setLayoutParams(paramQQAppInterface);
    }
    setBackgroundDrawable();
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "updateIntimateInfo: " + paramIntimateInfo);
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.bvC = 5;
    cdq();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if ((this.HV != null) && (this.jdField_a_of_type_Ajjl != null))
    {
      localObject3 = this.jdField_a_of_type_Ajjl.nD();
      localObject4 = (TroopManager)this.mApp.getManager(52);
      localObject1 = "";
      localObject2 = this.jdField_a_of_type_Ajjl.a();
      if (localObject2 != null) {
        localObject1 = ((ajjf)localObject2).getNickName();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((TroopManager)localObject4).getTroopMemberName((String)localObject3, this.mMemberUin);
      }
      this.HV.setText((CharSequence)localObject2);
    }
    int i;
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      i = paramIntimateInfo.commonTroopInfoList.size();
      this.wf.setVisibility(0);
      this.HW.setText(String.valueOf(i));
      localObject1 = paramIntimateInfo.recentChatTroopInfo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject1).troopUin)))
      {
        this.si.setVisibility(0);
        this.Ia.setVisibility(0);
        this.Ib.setVisibility(0);
        this.Ia.setText(((IntimateInfo.CommonTroopInfo)localObject1).troopName);
        this.Ib.setText(paramIntimateInfo.commonTroopTips);
        localObject1 = aqdj.a(this.mApp, 4, ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
        this.si.setImageDrawable((Drawable)localObject1);
        if (this.bdX)
        {
          anot.a(null, "dc00898", "", "", "0X800A21B ", "0X800A21B ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21B");
        }
        label340:
        if (this.bdX) {
          cds();
        }
        if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
          break label799;
        }
        this.wk.setVisibility(0);
        if (this.jdField_a_of_type_Ajjl != null) {
          break label730;
        }
        this.gV.removeAllViews();
        label392:
        localObject2 = paramIntimateInfo.dnaInfoList.iterator();
        i = 0;
        label405:
        if (!((Iterator)localObject2).hasNext()) {
          break label808;
        }
        localObject3 = (IntimateInfo.DNAInfo)((Iterator)localObject2).next();
        paramIntimateInfo = null;
        if (this.jdField_a_of_type_Ajjl != null) {
          paramIntimateInfo = this.jdField_a_of_type_Ajjl.cj();
        }
        if (paramIntimateInfo != null) {
          break label819;
        }
        paramIntimateInfo = wxu.i(this.mContext);
      }
    }
    label799:
    label808:
    label819:
    for (;;)
    {
      localObject1 = (TextView)paramIntimateInfo.findViewById(2131379870);
      localObject4 = (TextView)paramIntimateInfo.findViewById(2131379752);
      ((TextView)localObject1).setText(((IntimateInfo.DNAInfo)localObject3).wording);
      int j;
      if (((IntimateInfo.DNAInfo)localObject3).viceTitle != null)
      {
        localObject1 = new SpannableString(((IntimateInfo.DNAInfo)localObject3).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject3).linkWording))
        {
          int m = ((IntimateInfo.DNAInfo)localObject3).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject3).linkWording);
          int k = ((IntimateInfo.DNAInfo)localObject3).linkWording.length() + m;
          j = m;
          if (m < 0)
          {
            String str = ((IntimateInfo.DNAInfo)localObject3).viceTitle + ((IntimateInfo.DNAInfo)localObject3).linkWording;
            localObject1 = new SpannableString(str);
            j = ((IntimateInfo.DNAInfo)localObject3).viceTitle.length();
            k = str.length();
          }
          ((SpannableString)localObject1).setSpan(new wya(this, (IntimateInfo.DNAInfo)localObject3), j, k, 33);
          ((TextView)localObject4).setText((CharSequence)localObject1);
          ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).topMargin = aqnm.dip2px(16.0F);
        this.gV.addView(paramIntimateInfo, (ViewGroup.LayoutParams)localObject1);
        i += 1;
        break label405;
        this.si.setVisibility(8);
        this.Ia.setVisibility(8);
        this.Ib.setVisibility(8);
        break;
        this.wf.setVisibility(8);
        break label340;
        label730:
        j = this.gV.getChildCount();
        if (j <= 0) {
          break label392;
        }
        i = 0;
        while (i < j)
        {
          localObject1 = this.gV.getChildAt(0);
          this.jdField_a_of_type_Ajjl.e(this.gV, (View)localObject1);
          i += 1;
        }
        break label392;
        ((TextView)localObject4).setText((CharSequence)localObject1);
        continue;
        ((TextView)localObject4).setVisibility(8);
      }
      this.wk.setVisibility(8);
      QLog.d("Intimatetest2", 2, "ui ok");
      return;
    }
  }
  
  private void ath()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    try
    {
      this.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cdq()
  {
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn begin");
    acff localacff;
    if ((this.dT != null) && (this.IF != null))
    {
      localacff = (acff)this.mApp.getManager(51);
      if (!localacff.isFriend(this.mMemberUin)) {
        break label77;
      }
      this.dT.setVisibility(8);
      this.IF.setVisibility(8);
    }
    for (;;)
    {
      QLog.d("Intimatetest2", 2, "updateAddFrdBtn end");
      return;
      label77:
      if (!localacff.kd(this.mMemberUin))
      {
        this.dT.setVisibility(0);
        this.IF.setVisibility(8);
        if (this.bdX)
        {
          anot.a(null, "dc00898", "", "", "0X800A218 ", "0X800A218 ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A218");
        }
      }
      else
      {
        this.dT.setVisibility(8);
        this.IF.setVisibility(0);
        if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
          this.IF.setBackgroundResource(2130841174);
        } else {
          this.IF.setBackgroundResource(2130841175);
        }
      }
    }
  }
  
  private void cds()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.iterator();
        while (localIterator.hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localIterator.next()).linkWording))
          {
            anot.a(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  private Bitmap getFaceBitmap(String paramString)
  {
    if (this.jdField_a_of_type_Aqdf == null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(this.mContext, this.mApp);
      this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_Aqdf$a);
    }
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.a(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void setBackgroundDrawable()
  {
    if (ThemeUtil.isNowThemeIsNight(this.mApp, true, null)) {}
    for (String str = ""; (!TextUtils.isEmpty(this.aTa)) && (str.equals(this.aTa)); str = aejx.a().byf) {
      return;
    }
    Object localObject = this.mContext.getResources().getDrawable(2130841189);
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aqnm.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = aqnm.getScreenHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.y);
      this.mRootView.setBackgroundDrawable((Drawable)localObject);
      this.aTa = str;
      return;
    }
    this.mRootView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void xq(String paramString)
  {
    if (this.g == null)
    {
      this.g = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
      this.g.setBackAndSearchFilter(true);
    }
    this.g.setMessage(paramString);
    if ((this.g != null) && (!this.g.isShowing()) && (!this.mActivity.isFinishing())) {
      this.g.show();
    }
  }
  
  public void a(ajjf paramajjf, String paramString)
  {
    if (paramajjf == null) {}
    do
    {
      do
      {
        return;
        this.mMemberUin = paramajjf.getUin();
        this.QE = paramString;
      } while (paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null);
      if (this.mUIHandler == null) {
        this.mUIHandler = new Handler(this);
      }
      if (this.mApp != null)
      {
        this.mApp.addObserver(this.jdField_a_of_type_Ahpp);
        this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      paramString = this.mUIHandler.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramajjf.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      this.mUIHandler.sendMessage(paramString);
    } while (this.f == null);
    this.f.scrollTo(0, 0);
  }
  
  public void a(ajjl paramajjl)
  {
    if (this.jdField_a_of_type_Ajjl != null)
    {
      this.jdField_a_of_type_Ajjl.dxS();
      this.jdField_a_of_type_Ajjl = null;
      if (this.mUIHandler != null) {
        this.mUIHandler.removeCallbacksAndMessages(null);
      }
    }
    if (paramajjl == null) {
      return;
    }
    this.jdField_a_of_type_Ajjl = paramajjl;
    if (this.jdField_a_of_type_Ajjl != null) {
      this.jdField_a_of_type_Ajjl.hi(this.dT);
    }
    this.bdY = true;
  }
  
  public void bZe()
  {
    Bitmap localBitmap = getFaceBitmap(this.mApp.getCurrentAccountUin());
    if (localBitmap != null) {
      this.sg.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.mMemberUin))
    {
      localBitmap = getFaceBitmap(this.mMemberUin);
      if (localBitmap != null) {
        this.sh.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void bZg()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.mMemberUin))
    {
      if (!aqiw.isNetworkAvailable(this.mActivity)) {
        break label148;
      }
      if (this.jdField_a_of_type_Ahpj == null) {
        this.jdField_a_of_type_Ahpj = ((ahpj)this.mApp.getBusinessHandler(153));
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      try
      {
        l2 = Long.valueOf(this.mMemberUin).longValue();
        QLog.e("intimate_relationship", 2, "valueOf string err");
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          l1 = Long.valueOf(this.QE).longValue();
          ((ArrayList)localObject).add(Long.valueOf(l2));
          this.jdField_a_of_type_Ahpj.a(l1, (ArrayList)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.mMemberUin }));
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            long l2;
            long l1 = l2;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
        l1 = 0L;
      }
      l2 = l1;
      l1 = 0L;
      continue;
      label148:
      localObject = this.mUIHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.mContext.getResources().getString(2131720447);
      this.mUIHandler.sendMessage((Message)localObject);
      QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.mMemberUin }));
    }
  }
  
  public void bZi()
  {
    if (this.jdField_a_of_type_Ajjl != null) {
      this.jdField_a_of_type_Ajjl.onBackEvent();
    }
    while (this.mActivity == null) {
      return;
    }
    this.mActivity.finish();
  }
  
  public void bZo() {}
  
  public void cdr()
  {
    cdq();
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a((IntimateInfo)paramMessage.obj);
      return true;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.mActivity, 1, paramMessage, 1).show();
      return true;
    case 2: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.mActivity, 2, paramMessage, 1).show();
      return true;
    case 3: 
      xq((String)paramMessage.obj);
      return true;
    }
    ath();
    return true;
  }
  
  public void initData()
  {
    this.mUIHandler = new Handler(this);
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
    }
    ThreadManager.getSubThreadHandler().post(new StrangerIntimateView.1(this));
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.N != null) && (l - this.N.longValue() < 500L)) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.N = Long.valueOf(l);
        switch (paramView.getId())
        {
        }
      }
      if ((this.jdField_a_of_type_Ajjl != null) && (this.jdField_a_of_type_Ajjl.getMode() == 1)) {
        anot.a(null, "dc00898", "", "", "0X800A214", "0X800A214", 2, 0, "", "", "", "");
      }
      anot.a(null, "dc00898", "", "", "0X800A219 ", "0X800A219 ", 0, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A219");
    } while (this.jdField_a_of_type_Ajjl == null);
    String str = this.jdField_a_of_type_Ajjl.nD();
    Object localObject1 = (TroopManager)this.mApp.getManager(52);
    Object localObject2 = this.jdField_a_of_type_Ajjl.a();
    if (localObject2 != null) {}
    for (localObject1 = ((ajjf)localObject2).getNickName();; localObject1 = ((TroopManager)localObject1).aL(str, this.mMemberUin))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).equals(this.mMemberUin)) {
          localObject2 = "";
        }
      }
      localObject1 = AddFriendLogicActivity.a(this.mContext, 1, this.mMemberUin, str, 3004, 17, (String)localObject2, null, null, this.mContext.getString(2131721053), null);
      this.mContext.startActivity((Intent)localObject1);
      break;
      bZi();
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList == null)) {
        break;
      }
      CommonTroopListActivity.c(this.mActivity, (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.bvC);
      anot.a(null, "dc00898", "", "", "0X800A21A ", "0X800A21A ", this.bvC, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21A");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      localObject2 = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
      ((Intent)localObject2).putExtra("uintype", 1);
      ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
      this.mActivity.startActivity((Intent)localObject2);
      break;
      if (this.mActivity == null) {
        break;
      }
      localObject1 = new Intent(this.mActivity, FriendProfileMoreInfoActivity.class);
      this.mActivity.startActivity((Intent)localObject1);
      break;
      if (this.jdField_a_of_type_Ajjl == null)
      {
        localObject1 = new ProfileActivity.AllInOne(this.mApp.getCurrentAccountUin(), 0);
        ProfileActivity.b(this.mActivity, (ProfileActivity.AllInOne)localObject1);
        break;
      }
      localObject1 = this.jdField_a_of_type_Ajjl.nD();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        aldj.a(this.mApp, this.mContext, (String)localObject1, this.mApp.getCurrentAccountUin(), 0, -1);
        break;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      break;
      if (this.jdField_a_of_type_Ajjl == null)
      {
        localObject1 = new ProfileActivity.AllInOne(this.mMemberUin, 19);
        ProfileActivity.b(this.mActivity, (ProfileActivity.AllInOne)localObject1);
        break;
      }
      localObject1 = this.jdField_a_of_type_Ajjl.nD();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        aldj.a(this.mApp, this.mContext, (String)localObject1, this.mMemberUin, 0, -1);
        break;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      break;
    }
  }
  
  public void onDestroy()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
    }
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void yx(boolean paramBoolean)
  {
    this.aqw = paramBoolean;
  }
  
  public void yy(boolean paramBoolean)
  {
    this.bdX = paramBoolean;
  }
  
  public void yz(boolean paramBoolean)
  {
    if (this.HU != null)
    {
      if (paramBoolean) {
        this.HU.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.HU.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */