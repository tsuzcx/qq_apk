import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AppShortcutBarAIOHelper.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.c;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class wur
  implements wvs
{
  private achq jdField_a_of_type_Achq;
  private apox jdField_a_of_type_Apox;
  private apoz jdField_a_of_type_Apoz;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AppShortcutBarScrollView a;
  private DrawerFrame.c jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c;
  private appa b;
  private int bRH;
  private boolean bgc;
  public boolean bgd;
  private boolean bge;
  protected View.OnClickListener dh;
  ArrayList<Pair<URLDrawable, URLImageView>> pT;
  private ArrayList<Long> qt;
  
  public int[] C()
  {
    return new int[] { 3, 5, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      cci();
      return;
    case 5: 
      ccj();
      return;
    }
    bZD();
  }
  
  public boolean RW()
  {
    boolean bool = this.bge;
    this.bge = false;
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "triggerSyncOnce() syncOnce = " + bool);
    }
    return bool;
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131372041) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131372041);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131377764);
  }
  
  void a(apou paramapou, View paramView)
  {
    paramView.setTag(paramapou);
    paramView.setOnClickListener(this.dh);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app);
    Object localObject = (TextView)paramView.findViewById(2131378265);
    ((TextView)localObject).setText(paramapou.getAppName());
    if (bool)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131378262);
      if (!bool) {
        break label254;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getDrawable(2130838720));
      label93:
      localObject = (TextView)paramView.findViewById(2131378264);
      if (paramapou.LA() == 0) {
        break label277;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130838050, 0, 0, 0);
      label140:
      paramView = (URLImageView)paramView.findViewById(2131378263);
      if (bool) {
        paramView.setColorFilter(1996488704);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (paramapou.Bv() == null) {
        break label327;
      }
      paramapou = URLDrawable.getDrawable(paramapou.Bv(), (URLDrawable.URLDrawableOptions)localObject);
      if (paramapou.getStatus() != 1) {
        break label286;
      }
      paramapou = paramapou.getCurrDrawable();
      if ((paramapou instanceof RegionDrawable))
      {
        paramView.setImageBitmap(((RegionDrawable)paramapou).getBitmap());
        paramView.setVisibility(0);
      }
    }
    label254:
    do
    {
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getDrawable(2130838719));
      break label93;
      ((TextView)localObject).setVisibility(4);
      break label140;
      this.pT.add(new Pair(paramapou, paramView));
      paramapou.setURLDrawableListener(new wuv(this));
    } while (paramapou.isDownloadStarted());
    label277:
    label286:
    paramapou.startDownload();
    return;
    label327:
    paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getDrawable(2130844521));
  }
  
  void a(apoy paramapoy)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    LinearLayout localLinearLayout;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          if (paramapoy != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. info is null.");
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372836);
        if (localLinearLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. appShortcutPanel is null.");
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. troopInfo is null.");
    return;
    Object localObject1 = (apov)aeif.a().o(590);
    int i;
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && ((((apov)localObject1).md((int)localTroopInfo.dwGroupClassExt)) || (((apov)localObject1).me((int)localTroopInfo.dwGroupClassExt))))
    {
      localLinearLayout.removeAllViews();
      this.pT.clear();
      if ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentAccountUin()))) {}
      for (i = 1; ((paramapoy.LC() == 1) && (i == 0)) || (paramapoy.LD() == 1); i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. Switch is off.");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        bIf();
        return;
      }
      paramapoy = paramapoy.dU();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. applist size: " + paramapoy.size());
      }
      paramapoy = paramapoy.iterator();
      i = 1;
      bool = false;
      if (paramapoy.hasNext())
      {
        localObject2 = (apou)paramapoy.next();
        if (((apou)localObject2).Lz() != 0) {
          break label750;
        }
      }
    }
    label750:
    for (;;)
    {
      try
      {
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, 2131561757, null);
        a((apou)localObject2, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        int j = i;
        if (i != 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).setMargins(wja.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i().getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          j = 0;
        }
        i = j;
        bool = true;
      }
      catch (OutOfMemoryError paramapoy)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + paramapoy.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramapoy)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + paramapoy.getMessage());
        }
        System.gc();
        return;
      }
      if (bool) {}
      try
      {
        paramapoy = apou.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getString(2131698435), "https://pub.idqqimg.com/pc/misc/files/20200114/manager.png");
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, 2131561757, null);
        a(paramapoy, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        this.bgd = bool;
        if (bool)
        {
          bIe();
          if (!this.bgc)
          {
            this.bgc = true;
            anot.a(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, String.valueOf(localTroopInfo.dwGroupClassExt), "");
          }
          ThreadManager.getUIHandler().postDelayed(new AppShortcutBarAIOHelper.5(this), 200L);
          return;
        }
      }
      catch (OutOfMemoryError paramapoy)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + paramapoy.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException paramapoy)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + paramapoy.getMessage());
        }
        System.gc();
        return;
      }
      bIf();
      return;
      this.bgd = false;
      bIf();
      return;
    }
  }
  
  public void bIe()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
      } while (!this.bgd);
      localObject = (wxk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localObject == null) || (!((wxk)localObject).Ss())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377764);
    if ((ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundDrawable(localDrawable);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369277);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
      if (i > 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getBottom() - i + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight();
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() update list. setListViewPaddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingBottom() + " to " + i);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingRight(), i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin.Hl(2131377764);
      }
      zc(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundResource(0);
    }
  }
  
  public void bIf()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "hideAppShortcutBar");
      }
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131369277);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
      if (i > 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getBottom() - i;
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "setListViewPaddingBottom , new :" + i);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.getPaddingRight(), i);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Abin.Hl(2131369277);
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.isShown();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(8);
    } while (!bool);
    zc(true);
  }
  
  void bZD()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onChatPieDestroy. null check return. ");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onChatPieDestroy. ");
      }
      this.qt.clear();
      this.bgc = false;
      bIf();
      this.bgd = false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      }
      if (this.b != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.removeObserver(this.b);
      }
      if (this.jdField_a_of_type_Achq != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.removeObserver(this.jdField_a_of_type_Achq);
      }
      this.pT.clear();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c);
  }
  
  void cci()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c);
    }
  }
  
  void ccj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      localObject = (apov)aeif.a().o(590);
    } while ((localObject == null) || (localTroopInfo == null) || ((!((apov)localObject).md((int)localTroopInfo.dwGroupClassExt)) && (!((apov)localObject).me((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Apoz.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)));
        if (localObject == null) {
          break;
        }
        if (anwa.aze())
        {
          i = 1;
          if ((((apoy)localObject).hx() < System.currentTimeMillis()) || ((anwa.aze()) && (this.bRH != i)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
            }
            this.bRH = i;
            this.jdField_a_of_type_Apox.aV(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl), (int)localTroopInfo.dwGroupClassExt);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarAIOHelper", 2, "onShow. updateAppShortcutPanel. ");
          }
          a((apoy)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarAIOHelper", 1, localException.getMessage());
        return;
      }
      int i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
    }
    this.jdField_a_of_type_Apox.aV(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl), (int)localException.dwGroupClassExt);
  }
  
  public void cck()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) {}
    LinearLayout localLinearLayout;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131372836);
      } while (localLinearLayout == null);
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
    } while (localTroopInfo == null);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
    int i = 0;
    label83:
    long l;
    if (i < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof apou))
        {
          localObject = (apou)localObject;
          if (localObject != null)
          {
            l = ((apou)localObject).hw();
            localObject = this.qt.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (((Long)((Iterator)localObject).next()).longValue() != l);
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        this.qt.add(Long.valueOf(l));
        anot.a(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label83;
      break;
    }
  }
  
  public void initData()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView != null)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, 2131558633, null));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new wus(this));
            if (QLog.isColorLevel()) {
              QLog.d("AppShortcutBarAIOHelper", 2, "initData.");
            }
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(2, 2131369277);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
            this.jdField_a_of_type_Apox = ((apox)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getBusinessHandler(171));
            this.jdField_a_of_type_Apoz = ((apoz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(355));
            this.b = new wut(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app);
            this.jdField_a_of_type_Achq = new wuu(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.addObserver(this.b);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.addObserver(this.jdField_a_of_type_Achq);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got OOM, e:" + localOutOfMemoryError.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got InflateException, e:" + localInflateException.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
        }
      }
    }
  }
  
  public void r(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131372041);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131377764);
  }
  
  public void zc(boolean paramBoolean)
  {
    this.bge = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wur
 * JD-Core Version:    0.7.0.1
 */