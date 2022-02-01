package com.tencent.mobileqq.activity.aio;

import acfp;
import afem;
import affc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import anot;
import aqhu;
import aqrd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView.a;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import ujt;
import wmt;
import wmu;
import wmv;
import xkr;
import xks;

public class PokePanel
  extends RelativeLayout
  implements View.OnClickListener, ClickedWaveView.a, AbsListView.e
{
  public static boolean bem;
  long HZ = 0L;
  long Ia = 0L;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private wmv jdField_a_of_type_Wmv;
  private String aTh;
  MqqHandler b;
  public int bPr = -1;
  private boolean bek;
  private boolean bel;
  BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  VasQuickUpdateManager.CallBacker jdField_c_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new wmt(this);
  aqrd d = new wmu(this);
  private final int[] hf = { 2131721955, 2130839343, 3 };
  private final int[] hg = { 2131697032, 2130839304, 1 };
  private final int[] hh = { 2131694367, 2130839302, 2 };
  private final int[] hi = { 2131694585, 2130839341, 4 };
  private final int[] hj = { 2131694593, 2130839342, 5 };
  private final int[] hk = { 2131694501, 2130839305, 6 };
  private QQAppInterface mApp;
  public boolean mDestroy;
  public boolean mPaused;
  public int pay_type = 1;
  private ArrayList<int[]> qf;
  private SessionInfo sessionInfo;
  HandlerThread u;
  
  public PokePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PokePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void aS(QQAppInterface paramQQAppInterface)
  {
    if (!bem) {
      ThreadManager.excute(new PokePanel.1(paramQQAppInterface), 64, null, true);
    }
  }
  
  private void by(Bundle paramBundle)
  {
    int i = paramBundle.getInt("type");
    int j = paramBundle.getInt("id");
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("minVersion");
    int k = paramBundle.getInt("feeType");
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, new Object[] { "panel sendPokeMsg type:" + this.sessionInfo, Integer.valueOf(1) });
    }
    switch (j)
    {
    default: 
      if (126 == i)
      {
        if (!paramBundle.getBoolean("isShowLoading")) {
          break label589;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.PokePanel", 2, "poke item is downloading, do nothing");
        }
      }
      break;
    }
    label173:
    label589:
    do
    {
      return;
      ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 1, "", "");
      anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 1, 0, "", "", "", "");
      break;
      ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 2, "", "");
      anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 2, 0, "", "", "", "");
      break;
      ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 4, "", "");
      anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 4, 0, "", "", "", "");
      break;
      ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 3, "", "");
      anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 3, 0, "", "", "", "");
      break;
      if (this.HZ == 0L) {}
      for (this.HZ = SystemClock.currentThreadTimeMillis();; this.HZ = SystemClock.currentThreadTimeMillis())
      {
        this.HZ = SystemClock.currentThreadTimeMillis();
        ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 5, "", "");
        anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 5, 0, "", "", "", "");
        break;
        if (SystemClock.currentThreadTimeMillis() - this.HZ < 500L) {
          break label173;
        }
      }
      if (this.Ia == 0L) {}
      for (this.Ia = SystemClock.currentThreadTimeMillis();; this.Ia = SystemClock.currentThreadTimeMillis())
      {
        ujt.a(this.mApp, BaseApplicationImpl.getContext(), this.sessionInfo, 6, "", "");
        anot.a(this.mApp, "CliOper", "", this.sessionInfo.aTl, "0X8007F22", "0X8007F22", 6, 0, "", "", "", "");
        break;
        if (SystemClock.currentThreadTimeMillis() - this.Ia < 500L) {
          break label173;
        }
      }
      if (paramBundle.getBoolean("isShowDownload"))
      {
        this.jdField_a_of_type_Wmv.c("poke.item.res.", j, true, false);
        paramBundle = (VasQuickUpdateManager)this.mApp.getManager(184);
        if (!xks.G("effect.gif", j)) {
          paramBundle.downloadItem(21L, "poke.item.effect." + j, "clickDownload");
        }
        paramBundle.downloadItem(21L, "poke.item.res." + j, "clickDownload");
        paramBundle.addCallBacker(this.jdField_c_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        return;
      }
    } while (xks.bhd);
    xks.bhd = true;
    xks.a(this.mApp, j, str1, k, str2, 0);
  }
  
  private void cX(ArrayList<a> paramArrayList)
  {
    int i = 0;
    if (i < this.qf.size())
    {
      int[] arrayOfInt = (int[])this.qf.get(i);
      a locala = new a();
      if ((arrayOfInt[2] == 1) && (!xks.gx(arrayOfInt[2]))) {
        locala.drawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838254);
      }
      for (;;)
      {
        locala.bPs = arrayOfInt[2];
        locala.resId = arrayOfInt[1];
        locala.name = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
        locala.contentDescription = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + acfp.m(2131709800));
        locala.beo = false;
        paramArrayList.add(locala);
        i += 1;
        break;
        if ((arrayOfInt[2] != 0) && (xks.gx(arrayOfInt[2])))
        {
          String str;
          Object localObject;
          int j;
          switch (arrayOfInt[2])
          {
          default: 
            str = xkr.aVf + "/chuo_icon/chuo_icon_";
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inSampleSize = 1;
            ((BitmapFactory.Options)localObject).inMutable = true;
            localObject = aqhu.d(str + "01.png", (BitmapFactory.Options)localObject);
            localObject = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject, this.b);
            j = 0;
            label320:
            if (j >= 22) {
              break label582;
            }
            if (j + 1 < 10) {
              ((CustomFrameAnimationDrawable)localObject).u(j, 40, str + "0" + (j + 1) + ".png");
            }
            break;
          }
          for (;;)
          {
            j += 1;
            break label320;
            str = xkr.aVf + "/chuo_icon/chuo_icon_";
            break;
            str = xkr.aVf + "/bixin_icon/bixin_icon_";
            break;
            str = xkr.aVf + "/zan_icon/zan_icon_";
            break;
            str = xkr.aVf + "/xinsui_icon/xinsui_icon_";
            break;
            str = xkr.aVf + "/dazhao_icon/dazhao_icon_";
            break;
            str = xkr.aVf + "/666_icon/666_icon_";
            break;
            ((CustomFrameAnimationDrawable)localObject).u(j, 40, str + (j + 1) + ".png");
          }
          label582:
          locala.drawable = ((Drawable)localObject);
        }
        else
        {
          locala.drawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
        }
      }
    }
  }
  
  public static boolean x(QQAppInterface paramQQAppInterface)
  {
    if (bem) {
      return true;
    }
    if ((xks.gx(2)) && (xks.gx(3)) && (xks.gx(4)) && (xks.gx(5)) && (xks.gx(6)) && (PokeBigResHandler.adj()))
    {
      xks.a(paramQQAppInterface, null);
      bem = true;
      return true;
    }
    Object localObject = (afem)paramQQAppInterface.getManager(77);
    if (localObject != null)
    {
      localObject = (affc)((afem)localObject).a("qq.android.poke.res_0625");
      paramQQAppInterface = (PokeBigResHandler)paramQQAppInterface.getBusinessHandler(117);
      if (localObject != null) {
        ((affc)localObject).HL(true);
      }
      if ((paramQQAppInterface != null) && (!PokeBigResHandler.adj())) {
        paramQQAppInterface.FO(true);
      }
    }
    bem = false;
    return false;
  }
  
  private void xv(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      switch (paramString.charAt(i))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.qf.add(this.hg);
        continue;
        this.qf.add(this.hh);
        continue;
        this.qf.add(this.hf);
        continue;
        this.qf.add(this.hi);
        continue;
        this.qf.add(this.hj);
        continue;
        this.qf.add(this.hk);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, String paramString)
  {
    this.sessionInfo = paramSessionInfo;
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mApp = paramBaseChatPie.getApp();
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131368731));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().addObserver(this.d);
    paramBaseChatPie = getResources().getDrawable(2130851275);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      ((BitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
    }
    for (;;)
    {
      this.aTh = paramString;
      return;
      if ((paramBaseChatPie instanceof SkinnableBitmapDrawable))
      {
        ((SkinnableBitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        ((SkinnableBitmapDrawable)paramBaseChatPie).setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
    }
  }
  
  public void bZJ()
  {
    this.bek = true;
  }
  
  public void bx(Bundle paramBundle)
  {
    if (!this.bel) {
      by(paramBundle);
    }
    this.bel = false;
  }
  
  public void clear()
  {
    if (this.qf != null) {
      this.qf.clear();
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    if (this.mDestroy) {
      return;
    }
    this.mDestroy = true;
    try
    {
      this.b.removeCallbacksAndMessages(null);
      this.u.quit();
      this.u = null;
      Object localObject = this.jdField_a_of_type_Wmv.bG();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if ((locala.drawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)locala.drawable).clear();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("Q.aio.PokePanel", 1, "ondestroy err " + localException);
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeObserver(this.d);
      ((VasQuickUpdateManager)this.mApp.getManager(184)).removeCallBacker(this.jdField_c_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    onDestroy();
  }
  
  public void onHide()
  {
    if ((!this.mPaused) && (this.jdField_a_of_type_Wmv != null))
    {
      this.mPaused = true;
      Object localObject = this.jdField_a_of_type_Wmv.bG();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if ((locala.drawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)locala.drawable).onHide();
          }
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (this.bek))
    {
      this.bel = true;
      return;
    }
    this.bel = false;
  }
  
  public void onShow()
  {
    if (this.mPaused)
    {
      this.mPaused = false;
      Object localObject = this.jdField_a_of_type_Wmv.bG();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if ((locala.drawable instanceof CustomFrameAnimationDrawable)) {
            ((CustomFrameAnimationDrawable)locala.drawable).onShow();
          }
        }
      }
    }
    ((PokeBigResHandler)this.mApp.getBusinessHandler(117)).FO(false);
  }
  
  public void reload(String paramString)
  {
    if (this.qf == null) {
      this.qf = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.u == null)
      {
        this.u = ThreadManager.newFreeHandlerThread("PokePanelAnimThread", 0);
        this.u.start();
        this.b = new MqqHandler(this.u.getLooper());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.PokePanel", 2, "[pokepanel]reload()");
      }
      this.jdField_a_of_type_Wmv = new wmv(BaseApplication.getContext());
      this.jdField_a_of_type_Wmv.w(this);
      this.jdField_a_of_type_Wmv.a(this);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Wmv);
      ThreadManager.getFileThreadHandler().post(new PokePanel.2(this, paramString, localArrayList));
      return;
      this.qf.clear();
    }
  }
  
  public static class a
  {
    public int bPs;
    public boolean beg;
    public boolean beo;
    public boolean bep;
    public String contentDescription;
    public Drawable drawable;
    public int feeType;
    public String minVersion;
    public String name;
    public int resId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel
 * JD-Core Version:    0.7.0.1
 */