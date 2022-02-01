import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameUsrAvatarClickLis.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.net.URLEncoder;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class xzk
  extends BaseChatPie
{
  public static final String TAG = ahtj.bLH + "GameMsgChatPie";
  public static String aWX = "285982074";
  protected achq a;
  private ahsz jdField_a_of_type_Ahsz;
  private ahta jdField_a_of_type_Ahta;
  private ahtj jdField_a_of_type_Ahtj;
  private ahtk jdField_a_of_type_Ahtk = new xzl(this);
  private xzk.a jdField_a_of_type_Xzk$a;
  private ahsz jdField_b_of_type_Ahsz;
  private xzk.a jdField_b_of_type_Xzk$a;
  
  public xzk(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Achq = new xzo(this);
  }
  
  private boolean Tf()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    ahtc.a(this.mActivity, a());
    return true;
  }
  
  private boolean Tg()
  {
    if (this.jdField_a_of_type_Ahsz == null)
    {
      QLog.w(TAG, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Ahsz.mName;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(TAG, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(acfp.m(2131694211), new Object[] { str });
    aqha.a(this.mActivity, 230, acfp.m(2131694212), str, acfp.m(2131721058), acfp.m(2131694210), new xzm(this), new xzn(this)).show();
    return true;
  }
  
  private String a(ahsz paramahsz)
  {
    if (paramahsz == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramahsz.mName).append(paramahsz.mOnLineDesc).append("-").append(paramahsz.mPartitioName);
    return localStringBuilder.toString();
  }
  
  private void a(ahsz paramahsz)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[setTitleInfo]");
    }
    if (paramahsz == null) {}
    try
    {
      QLog.w(TAG, 1, "detail info is null.");
      this.gn.setVisibility(4);
      this.mTitleText.setText(acfp.m(2131694203));
      return;
    }
    catch (Throwable paramahsz)
    {
      Object localObject;
      QLog.e(TAG, 1, paramahsz.getMessage());
      return;
    }
    paramahsz.print();
    if (!TextUtils.isEmpty(paramahsz.mNickInGame))
    {
      this.mTitleText.setText(paramahsz.mNickInGame);
      localObject = a(paramahsz);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        vU(true);
        this.Cu.setText((CharSequence)localObject);
      }
      if (paramahsz.mSex > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
        }
        this.mTitleIcon.setVisibility(8);
        if (paramahsz.mSex != 1) {
          break label315;
        }
      }
    }
    label315:
    for (int i = 2130840542;; i = 2130840541)
    {
      this.pt.setVisibility(0);
      this.pt.setImageDrawable(a().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramahsz.mLevelPic))
      {
        localObject = (LinearLayout.LayoutParams)this.pu.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = wja.dp2px(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = wja.dp2px(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramahsz.mLevelPic);
        this.pu.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramahsz.mIconUrl)) {
        return;
      }
      this.gn.setVisibility(0);
      this.pp.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramahsz = URLDrawable.getDrawable(paramahsz.mIconUrl);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramahsz);
      return;
      this.mTitleText.setText(acfp.m(2131694203));
      break;
    }
  }
  
  private void initData()
  {
    Object localObject = this.mActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    localObject = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    QLog.i(TAG, 1, "friRoleId:" + str1 + ",myRoleId:" + (String)localObject);
    this.jdField_a_of_type_Xzk$a = new xzk.a(this.app, (String)localObject, true, this.mActivity);
    this.jdField_b_of_type_Xzk$a = new xzk.a(this.app, str1, false, this.mActivity);
    this.sessionInfo.xw(str1);
    this.sessionInfo.xx((String)localObject);
    this.jdField_a_of_type_Ahsz = this.jdField_a_of_type_Ahta.a(str1);
    this.jdField_b_of_type_Ahsz = this.jdField_a_of_type_Ahta.a((String)localObject);
    String str2;
    if (this.jdField_a_of_type_Ahsz != null)
    {
      localObject = awot.a();
      str2 = this.jdField_a_of_type_Ahsz.mAppId;
      if (this.jdField_a_of_type_Ahsz.mSwitchInGame != 0) {
        break label206;
      }
    }
    label206:
    for (str1 = "1";; str1 = "0")
    {
      ((awot)localObject).c(str2, "1", "145", "920", "92005", "206350", "", str1, "8", "0");
      return;
    }
  }
  
  public boolean OI()
  {
    return this.aey;
  }
  
  public ahsz a()
  {
    return this.jdField_a_of_type_Ahsz;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.c = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559281, null));
      this.c.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.c;
      if ((isFullScreenMode()) || (this.aSM)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.bYY = bool;
        if (isFullScreenMode()) {
          this.c.setHideAllSettingTabs(true);
        }
        this.c.bZc = this.aSM;
        this.c.bYZ = this.aSM;
        this.c.setOnlySysEmotionEnable(true);
        this.c.setSysEmotionOrder(ahtc.kW);
        this.c.a(this.app, this.sessionInfo.cZ, this.mContext, getTitleBarHeight(), this.aLB, this.bED, this);
        this.c.setEmoSettingVisibility(8);
        this.c.daq();
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        return this.c;
      }
    }
    return super.a(paramInt);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return super.a(paramQQAppInterface, paramBoolean);
  }
  
  public xzk.a a()
  {
    return this.jdField_a_of_type_Xzk$a;
  }
  
  public void aH(QQAppInterface paramQQAppInterface)
  {
    super.aH(paramQQAppInterface);
  }
  
  public void aIH()
  {
    super.aIH();
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahta = ((ahta)this.app.getManager(358));
    this.jdField_a_of_type_Ahtj = ((ahtj)this.app.getBusinessHandler(175));
    initData();
    QLog.i(TAG, 1, "[doOnCreate]");
    return super.af(paramBoolean);
  }
  
  public xzk.a b()
  {
    return this.jdField_b_of_type_Xzk$a;
  }
  
  public void bGR()
  {
    a(this.jdField_a_of_type_Ahsz);
  }
  
  public void bGZ()
  {
    super.bGZ();
  }
  
  public void bHD()
  {
    super.bHD();
  }
  
  public void bHE()
  {
    super.bHE();
    a(this.jdField_a_of_type_Ahsz);
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addObserver(this.jdField_a_of_type_Ahtk);
    this.app.addDefaultObservers(this.jdField_a_of_type_Achq);
  }
  
  public void bHt()
  {
    super.bHt();
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.v(this.Cr);
    }
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_a_of_type_Ahtk);
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bn(Intent paramIntent)
  {
    super.bn(paramIntent);
    a(this.jdField_a_of_type_Ahsz);
  }
  
  public void bo(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Ahsz);
  }
  
  public void bt(Intent paramIntent)
  {
    super.bt(paramIntent);
  }
  
  public List<ChatMessage> cF()
  {
    return super.cF();
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.l(i());
    }
    if (this.jdField_a_of_type_Ahta != null) {
      this.jdField_a_of_type_Ahta.KI(this.sessionInfo.aTl);
    }
  }
  
  public List<ChatMessage> n(boolean paramBoolean)
  {
    return super.n(paramBoolean);
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    super.o(paramInt1, paramInt2);
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.o(paramInt1, paramInt2);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Ahsz == null) {
            break;
          }
          if (this.jdField_a_of_type_Ahsz != null) {
            awot.a().c(this.jdField_a_of_type_Ahsz.mAppId, "1", "145", "920", "92005", "206356", "", "", "20", "0");
          }
          if (this.jdField_a_of_type_Ahsz.mSwitchInGame == 0)
          {
            if (!Tg()) {
              break;
            }
            continue;
          }
          try
          {
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length <= this.jdField_a_of_type_Ahsz.mMsgMaxLen) {
              break;
            }
            ChatActivityUtils.h(this.mContext, 2131694207, 1);
          }
          catch (Throwable localThrowable) {}
        }
        break;
        if (this.jdField_a_of_type_Ahsz != null) {
          awot.a().c(this.jdField_a_of_type_Ahsz.mAppId, "1", "145", "920", "92005", "206357", "", "", "20", "0");
        }
        if (!Tf()) {
          break;
        }
      }
      if (this.jdField_a_of_type_Ahsz != null) {
        awot.a().c(this.jdField_a_of_type_Ahsz.mAppId, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.l(i());
    }
  }
  
  public void showBottomBar()
  {
    super.showBottomBar();
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.cct();
    }
  }
  
  public int vk()
  {
    return super.vk();
  }
  
  public void zL(int paramInt)
  {
    super.zL(paramInt);
    wvl localwvl = (wvl)a(56);
    if (localwvl != null) {
      localwvl.ccG();
    }
  }
  
  public void zZ(int paramInt)
  {
    super.zZ(paramInt);
  }
  
  public static class a
    implements View.OnClickListener
  {
    private boolean bkR;
    WeakReference<Context> mActivityRef;
    private QQAppInterface mApp;
    private boolean mIsSend;
    private String mRoleId;
    
    public a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, Context paramContext)
    {
      this.mRoleId = paramString;
      this.mApp = paramQQAppInterface;
      this.bkR = false;
      this.mIsSend = paramBoolean;
      this.mActivityRef = new WeakReference(paramContext);
    }
    
    private void cgm()
    {
      try
      {
        String str = ((ahta)this.mApp.getManager(358)).wF();
        Context localContext = (Context)this.mActivityRef.get();
        if ((!TextUtils.isEmpty(str)) && (localContext != null) && (!TextUtils.isEmpty(this.mRoleId)))
        {
          if (str.contains("?")) {}
          for (str = str + "&roleId=" + URLEncoder.encode(this.mRoleId, "utf-8");; str = str + "?roleId=" + URLEncoder.encode(this.mRoleId, "utf-8"))
          {
            Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
            localIntent.putExtra("url", str);
            localContext.startActivity(localIntent);
            return;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(xzk.TAG, 1, localThrowable, new Object[0]);
      }
    }
    
    private void yt(String paramString)
    {
      if (this.mApp == null) {}
      boolean bool;
      do
      {
        return;
        GameUserInfo localGameUserInfo = ((ahta)this.mApp.getManager(358)).a(paramString);
        if (localGameUserInfo == null)
        {
          QLog.w(xzk.TAG, 1, "GameUsrAvatarClickLis, usrInfo is null, roleId:" + paramString);
          return;
        }
        if (TextUtils.isEmpty(localGameUserInfo.mFaceUrl))
        {
          QLog.w(xzk.TAG, 1, "GameUsrAvatarClickLis, faceurl is null, roleId:" + paramString);
          return;
        }
        paramString = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130840645);
        paramString.mFailedDrawable = localDrawable;
        paramString.mLoadingDrawable = localDrawable;
        paramString.mRequestWidth = wja.dp2px(60.0F, BaseApplicationImpl.getContext().getResources());
        paramString.mRequestHeight = wja.dp2px(60.0F, BaseApplicationImpl.getContext().getResources());
        URLDrawable.removeMemoryCacheByUrl(localGameUserInfo.mFaceUrl, paramString);
        bool = aqhq.deleteFile(aoiz.getFilePath(localGameUserInfo.mFaceUrl));
      } while (!QLog.isColorLevel());
      QLog.d(xzk.TAG, 2, "GameUsrAvatarClickLis del ret:" + bool);
    }
    
    public void onClick(View paramView)
    {
      ThreadManager.getSubThreadHandler().post(new GameMsgChatPie.GameUsrAvatarClickLis.1(this));
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzk
 * JD-Core Version:    0.7.0.1
 */