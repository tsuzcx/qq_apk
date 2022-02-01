import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.ark.ark;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class adta
{
  protected static final ark.ApplicationCallback a = new adtl();
  
  public static void GI(boolean paramBoolean)
  {
    Object localObject1 = ArkEnvironmentManager.getInstance();
    if (!ArkAppCenter.bQl) {}
    try
    {
      if (!ArkAppCenter.bQl)
      {
        ((ArkEnvironmentManager)localObject1).setThreadCreator(new adtb());
        ((ArkEnvironmentManager)localObject1).setLogCallback(new adtc());
        ((ArkEnvironmentManager)localObject1).setLibraryLoader(new adtd());
        ((ArkEnvironmentManager)localObject1).setDebugFlag(false);
        ((ArkEnvironmentManager)localObject1).setProfilingLogFlag(true);
        ((ArkEnvironmentManager)localObject1).setDataReport(new adte());
        ArkAppCenter.bQl = true;
      }
      if ((paramBoolean) && (!ArkAppCenter.bQm))
      {
        ((ArkEnvironmentManager)localObject1).loadLibrary();
        if (ArkAppCenter.bQm)
        {
          if (BaseApplicationImpl.getContext() != null)
          {
            localObject1 = adqr.m;
            ark.arkSetScreenSize(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density, ((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
          }
          ArkEnvironmentManager.getInstance().setSingleThreadMode(true);
          ArkEnvironmentManager.getInstance().setThreadMode();
          QLog.i("ArkApp.ArkMultiProcUtil", 1, "setupArkEnvironment, https=true, multithreads=true");
        }
      }
      return;
    }
    finally {}
  }
  
  public static void cUm()
  {
    String str3 = adqw.a().getRootDirectory();
    String str1 = "";
    Object localObject = str1;
    String str2 = str3;
    if (1 != BaseApplicationImpl.sProcessId)
    {
      str2 = MobileQQ.getMobileQQ().getQQProcessName();
      localObject = str1;
      if (str2 != null)
      {
        int i = str2.lastIndexOf(':');
        localObject = str1;
        if (i > -1) {
          localObject = "_" + str2.substring(i + 1);
        }
      }
      str2 = str3 + (String)localObject;
    }
    ArkDelegateManager.getInstance().init(str2, (String)localObject, "3.4.4", BaseApplicationImpl.getContext());
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    ArkEnvironmentManager.getInstance().setCurrentUin(((AppRuntime)localObject).getAccount());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (adqw.a() != null)
    {
      bool1 = bool2;
      if (adqw.a().BT() == 1) {
        bool1 = true;
      }
    }
    ArkEnvironmentManager.getInstance().setEnv(bool1);
    ArkDelegateManager.getInstance().setSetupDelegate(new adtf());
    ArkDelegateManager.getInstance().setNetDelegate(new adtg());
    ArkDelegateManager.getInstance().setInputCallback(new adta.a(null));
    ArkDelegateManager.getInstance().setApplicationCallback(a);
  }
  
  static class a
    implements ArkViewImplement.InputCallback
  {
    private ViewGroup dn;
    private BubblePopupWindow j;
    private ImageView sO;
    private ImageView sP;
    private ImageView sQ;
    
    private void fi(View paramView)
    {
      if (paramView != null)
      {
        paramView.clearAnimation();
        paramView.setVisibility(8);
      }
    }
    
    private void r(View paramView, int paramInt1, int paramInt2)
    {
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.animate().x(paramInt1).y(paramInt2).setDuration(0L).start();
      }
    }
    
    public void onFocusChanged(View paramView, boolean paramBoolean)
    {
      ArkView localArkView = (ArkView)paramView;
      paramView = (ViewGroup)paramView.getParent();
      if (this.dn != null) {
        paramView = this.dn;
      }
      if (paramView == null) {
        return;
      }
      if (paramBoolean)
      {
        Object localObject2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838745);
        Object localObject1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838744);
        localArkView.setInputSetSelectHolderSize(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        localArkView.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        if (this.sO == null)
        {
          this.sO = new ImageView(localArkView.getContext());
          this.sO.setBackgroundDrawable((Drawable)localObject2);
          this.sO.setScaleX(-1.0F);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addView(this.sO, localLayoutParams);
          this.sO.setVisibility(8);
          this.sO.setOnTouchListener(localArkView);
        }
        if (this.sP == null)
        {
          this.sP = new ImageView(localArkView.getContext());
          this.sP.setBackgroundDrawable((Drawable)localObject2);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addView(this.sP, (ViewGroup.LayoutParams)localObject2);
          this.sP.setVisibility(8);
          this.sO.setOnTouchListener(localArkView);
        }
        if (this.sQ == null)
        {
          this.sQ = new ImageView(localArkView.getContext());
          this.sQ.setBackgroundDrawable((Drawable)localObject1);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addView(this.sQ, (ViewGroup.LayoutParams)localObject1);
          this.sQ.setVisibility(8);
          this.sQ.setOnTouchListener(localArkView);
        }
      }
      fi(this.sO);
      fi(this.sP);
      fi(this.sQ);
    }
    
    public void onHideMenu(View paramView)
    {
      if (this.j != null)
      {
        this.j.dismiss();
        this.j = null;
      }
    }
    
    public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ArkView localArkView = (ArkView)paramView;
      paramView = (ViewGroup)paramView.getParent();
      if (this.dn != null) {
        paramView = this.dn;
      }
      if (paramView == null) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
      {
        int k = this.sO.getWidth();
        int i = k;
        if (k <= 0) {
          i = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838745).getIntrinsicWidth();
        }
        r(this.sO, localArkView.getLeft() + paramInt1 - i, localArkView.getTop() + paramInt2);
        if ((paramInt3 <= 0) || (paramInt4 <= 0) || ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4))) {
          break label245;
        }
        r(this.sP, localArkView.getLeft() + paramInt3, localArkView.getTop() + paramInt4);
      }
      for (;;)
      {
        if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
          break label256;
        }
        paramInt2 = this.sQ.getWidth();
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838744).getIntrinsicWidth();
        }
        r(this.sQ, localArkView.getLeft() + paramInt3 - paramInt1 / 2, localArkView.getTop() + paramInt4);
        return;
        fi(this.sO);
        break;
        label245:
        fi(this.sP);
      }
      label256:
      fi(this.sQ);
    }
    
    public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.j != null)
      {
        this.j.dismiss();
        this.j = null;
      }
      aqoa localaqoa = new aqoa();
      if (paramInt4 == 2)
      {
        localaqoa.dV(0, acfp.m(2131702845));
        localaqoa.dV(1, acfp.m(2131702840));
        localaqoa.dV(2, acfp.m(2131702846));
      }
      for (;;)
      {
        this.j = aqgq.a(paramView, paramInt1, paramInt2, paramInt3 + BaseApplicationImpl.getApplication().getResources().getDrawable(2130838744).getIntrinsicHeight(), localaqoa, new adtm(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
        return;
        if (paramInt4 == 1)
        {
          localaqoa.dV(0, acfp.m(2131702839));
          localaqoa.dV(1, acfp.m(2131702841));
          localaqoa.dV(2, acfp.m(2131702842));
        }
        else
        {
          localaqoa.dV(0, acfp.m(2131702844));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adta
 * JD-Core Version:    0.7.0.1
 */