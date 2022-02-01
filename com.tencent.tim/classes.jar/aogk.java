import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.4;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aogk
  extends aogr
{
  private static aogk jdField_a_of_type_Aogk;
  private aqqq jdField_a_of_type_Aqqq = new aogm(this);
  private ChatFragment jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
  private long aoZ;
  private int bgJ;
  private boolean cLA;
  private boolean cLB;
  private boolean cLz;
  private int dOx;
  private int dOy;
  private BubblePopupWindow h;
  private Runnable hG = new AIOMusicSkin.5(this);
  private ConcurrentHashMap<Integer, String> iA = new ConcurrentHashMap();
  private boolean isFirstShow = aiob.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", true, false);
  private String mCurrentUin = "";
  
  private void P(View paramView, boolean paramBoolean)
  {
    int j = 8;
    if (paramView == null) {}
    label187:
    label322:
    label461:
    label466:
    label471:
    do
    {
      do
      {
        return;
        paramView = paramView.getRootView();
        B(paramView, 2131377361, 2130851105);
        f(paramView, 2131369967, 2130851119, 2130851123);
        f(paramView, 2131369579, 2130851119, 2130851123);
        Object localObject = paramView.findViewById(2131377361);
        if (localObject != null) {
          e((View)localObject, 2131369594, 2130851136, 2130851137);
        }
        View localView1;
        if (azB())
        {
          e(paramView, 2131374780, 2130850952, 2130850953);
          e(paramView, 2131374770, 2130850909, 2130850910);
          e(paramView, 2131374783, 2130850958, 2130850959);
          e(paramView, 2131374762, 2130850890, 2130850891);
          e(paramView, 2131374752, 2130850880, 2130850881);
          e(paramView, 2131374775, 2130850929, 2130850930);
          e(paramView, 2131374759, 2130838217, 2130838218);
          e(paramView, 2131374763, 2130838251, 2130838253);
          e(paramView, 2131374773, 2130838265, 2130838266);
          e(paramView, 2131374746, 2130850860, 2130850861);
          localObject = paramView.findViewById(2131369276);
          if (localObject != null) {
            a((View)localObject, h(((View)localObject).getContext(), 2130850843));
          }
          if (((TextView)paramView.findViewById(2131367817) != null) && (!anlm.ayn())) {}
          localView1 = paramView.findViewById(2131369277);
          if (localObject != null) {
            a(localView1, h(((View)localObject).getContext(), 2130850842));
          }
          B(paramView, 2131372847, 2130850892);
          A(paramView, 2131369276, 2131167399);
          A(paramView, 2131379769, 2131167301);
          A(paramView, 2131369619, 2131167301);
          localView1 = paramView.findViewById(2131363575);
          if (localView1 != null)
          {
            if (!azB()) {
              break label461;
            }
            i = 8;
            localView1.setVisibility(i);
          }
          localView1 = paramView.findViewById(2131381443);
          View localView2 = paramView.findViewById(2131369277);
          if ((localView1 != null) && (localView2 != null) && (localView2.getVisibility() == 0)) {
            if (!azB()) {
              break label466;
            }
          }
        }
        for (int i = j;; i = 0)
        {
          localView1.setVisibility(i);
          if (paramBoolean) {
            fk(paramView.getContext());
          }
          if (!azB()) {
            break label471;
          }
          localObject = i(((View)localObject).getContext(), 2130851035);
          paramView = paramView.findViewById(2131362332);
          if (paramView == null) {
            break;
          }
          paramView.setBackgroundDrawable((Drawable)localObject);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() == null)) {
            break label187;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a().b.ces();
          break label187;
          i = 0;
          break label322;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
    } while (paramView == null);
    paramView.bHw();
  }
  
  public static aogk a()
  {
    if (jdField_a_of_type_Aogk == null) {}
    try
    {
      if (jdField_a_of_type_Aogk == null) {
        jdField_a_of_type_Aogk = new aogk();
      }
      return jdField_a_of_type_Aogk;
    }
    finally {}
  }
  
  private void hN(View paramView)
  {
    P(paramView, true);
  }
  
  private static boolean lO(int paramInt)
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject == null)
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: context is null");
      return false;
    }
    aqsq localaqsq = aqsq.a;
    localObject = localaqsq.getDir((Context)localObject, localaqsq.getScid(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: path empty, id=" + paramInt);
      return false;
    }
    int i = ThemeUtil.getFileNumInFile(new File((String)localObject));
    QLog.e("AIOMusicSkin", 1, "isThemeExists: fileNum = " + i + ", id=" + paramInt);
    if (i > 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void QO(boolean paramBoolean)
  {
    this.cLA = paramBoolean;
  }
  
  public void QP(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.4(this, paramBoolean));
  }
  
  public void VL(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null))
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null root");
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131372125);
    if (localImageView == null)
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null view");
      return;
    }
    if ((!azB()) || (!this.cLz) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.bgJ)))
    {
      localImageView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOMusicSkin", 2, "updateAnim: last=" + this.dOx + " cur=" + paramInt);
    }
    if (this.dOx != paramInt) {}
    aqpd localaqpd1;
    for (int i = 1;; i = 0)
    {
      this.dOx = paramInt;
      localImageView.setVisibility(0);
      aqpd localaqpd2 = (aqpd)localImageView.getTag();
      localaqpd1 = localaqpd2;
      if (localaqpd2 == null)
      {
        localaqpd1 = new aqpd(localImageView);
        localImageView.setTag(localaqpd1);
      }
      switch (paramInt)
      {
      default: 
        localaqpd1.clear();
        return;
      }
    }
    if (i != 0) {
      localaqpd1.gq(om("play.png"), 1);
    }
    localaqpd1.gq(om("playing.png"), 0);
    return;
    if (i != 0) {
      localaqpd1.gq(om("pause.png"), 1);
    }
    localaqpd1.gq(om("pausing.png"), 0);
  }
  
  public void a(ChatFragment paramChatFragment, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = paramChatFragment;
    if ((paramInt == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() instanceof xwn)) && (((xwn)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a()).SW())) {
      return;
    }
    gc(paramString, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.cLD)) {
      fk(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.getActivity());
    }
    this.aoZ = System.currentTimeMillis();
  }
  
  public boolean a(ChatFragment paramChatFragment, int paramInt)
  {
    if (paramChatFragment == null) {
      return true;
    }
    if ((paramInt == 1) && ((paramChatFragment.a() instanceof xwn)))
    {
      if ((((xwn)paramChatFragment.a()).SW()) || (anlm.ayn())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return anlm.ayn();
  }
  
  public boolean azA()
  {
    return this.dOy > 0;
  }
  
  public void cY(String paramString, boolean paramBoolean)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).edit().putBoolean("music_skin_enabled", paramBoolean).commit();
    QLog.d("AIOMusicSkin", 1, "setEnabled old: " + this.mEnable + " new: " + paramBoolean);
    this.mEnable = paramBoolean;
    if (!paramBoolean) {
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BC", 0, 0, "", "", "", "");
    }
    refresh();
  }
  
  public void dUz()
  {
    this.iA.clear();
  }
  
  public void fj(Context paramContext)
  {
    View localView;
    if ((this.isFirstShow) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      this.isFirstShow = false;
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131372105);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    this.h = new BubblePopupWindow(-2, -2);
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(20, 0, 20, 0);
    this.h.setContentView(localTextView);
    localTextView.setText(paramContext.getResources().getString(2131695332));
    this.h.setAnimationStyle(2131756487);
    this.h.setSoftInputMode(1);
    this.h.setInputMethodMode(2);
    paramContext = new int[2];
    localView.getLocationOnScreen(paramContext);
    this.h.We(true);
    this.h.d(localView, paramContext[0] + localView.getWidth() / 2, paramContext[1] + localView.getHeight());
    this.h.getContentView().setOnClickListener(new aogl(this));
    aiob.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", false, false);
    anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5B9", 1, 0, "", "", "", "");
  }
  
  public void fk(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.bgJ))) {
      return;
    }
    if (!azB())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.bJu();
      return;
    }
    this.cLB = true;
    paramContext = a(paramContext, 2131167361);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramContext.getDefaultColor());
  }
  
  public void gc(String paramString, int paramInt)
  {
    this.mCurrentUin = paramString;
    this.bgJ = paramInt;
    if (paramInt == 1)
    {
      this.mEnable = pY(paramString);
      paramString = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(paramInt, paramString);
      if ((paramString == null) || (paramString.themeId <= 0) || (paramString.status == 3) || (paramString.deR != 2) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.bgJ))) {
        break label236;
      }
      this.cLD = true;
      if ((paramString.themeId != this.dOy) || (TextUtils.isEmpty(this.ckF)))
      {
        RP(null);
        this.dOy = paramString.themeId;
        anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 1, 0, "", "", "", "");
      }
      refresh();
      label154:
      if (paramString != null) {
        if (!azA()) {
          break label309;
        }
      }
    }
    label309:
    for (paramInt = 1;; paramInt = 2)
    {
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BE", paramInt, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("AIOMusicSkin", 2, "updateState, session:" + paramString);
      }
      return;
      this.mEnable = true;
      break;
      label236:
      if ((paramString != null) && (paramString.themeId == 0)) {
        anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 2, 0, "", "", "", "");
      }
      if (!this.cLD) {
        break label154;
      }
      RP(null);
      this.cLD = false;
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.2(this));
      break label154;
    }
  }
  
  public void gd(String paramString, int paramInt)
  {
    this.dOy = paramInt;
    BaseApplicationImpl.sImageCache.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      RP(paramString);
      this.cLD = false;
    }
    for (;;)
    {
      refresh();
      return;
      RP(paramString);
      this.cLD = true;
      this.cLz = true;
    }
  }
  
  public boolean isAdmin()
  {
    return this.cLA;
  }
  
  public void leave()
  {
    this.cLB = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = null;
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "leave uin:" + this.mCurrentUin + "  type:" + this.bgJ);
    }
    QLog.i("AIOMusicSkin", 1, "leave");
    if (this.h != null)
    {
      this.h.dismiss();
      this.h = null;
    }
    anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BF", 0, 0, String.valueOf((System.currentTimeMillis() - this.aoZ) / 1000L), "", "", "");
  }
  
  public void p(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setMusicBarSkin uin:" + this.mCurrentUin + "  type:" + this.bgJ + " mIsUserSkin:" + this.cLD);
    }
    QLog.i("AIOMusicSkin", 1, "setMusicBarSkin mIsUserSkin:" + this.cLD + " mIsShowSkin:" + this.cLz);
    if (paramView == null) {
      return;
    }
    paramContext = paramView.getRootView();
    f(paramContext, 2131370582, 2130851290, 2130851291);
    e(paramContext, 2131375399, 2130845707, 2130845708);
    e(paramContext, 2131372105, 2130845701, 2130845702);
    A(paramContext, 2131372123, 2131167288);
    A(paramContext, 2131372126, 2131167286);
    A(paramContext, 2131372122, 2131167288);
    paramView = (CircleProgress)paramContext.findViewById(2131372120);
    if (paramView != null)
    {
      ColorStateList localColorStateList = a(paramContext.getContext(), 2131167287);
      paramView.setBgAndProgressColor(100, a(paramContext.getContext(), 2131167289).getDefaultColor(), 100, localColorStateList.getDefaultColor());
    }
    paramContext = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(this.bgJ, this.mCurrentUin);
    if (paramContext != null)
    {
      VL(paramContext.status);
      return;
    }
    VL(3);
  }
  
  public boolean pY(String paramString)
  {
    if (this.cLA) {
      return true;
    }
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).getBoolean("music_skin_enabled", true);
  }
  
  public void q(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setAIOSkin uin:" + this.mCurrentUin + "  type:" + this.bgJ + " mIsUserSkin:" + this.cLD + " mIsShowSkin:" + this.cLz + " enable:" + this.mEnable);
    }
    QLog.i("AIOMusicSkin", 1, "setAIOSkin mIsUserSkin:" + this.cLD + " mIsShowSkin:" + this.cLz);
    if ((!this.cLz) || (!azB()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.bgJ)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (!paramContext.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.mContext)))) {}
    do
    {
      return;
      hN(paramView);
    } while ((!this.cLz) || (!azB()) || (TextUtils.isEmpty(this.ckF)));
    fj(paramContext);
  }
  
  public void refresh()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.bgJ)) {
      return;
    }
    if ((this.iA.get(Integer.valueOf(this.dOy)) != null) && (azB()))
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        this.cLz = true;
        RP((String)this.iA.get(Integer.valueOf(this.dOy)));
        hN(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        p(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        return;
      }
      ThreadManager.getSubThreadHandler().post(this.hG);
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.hG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogk
 * JD-Core Version:    0.7.0.1
 */