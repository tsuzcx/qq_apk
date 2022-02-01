import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "Lmqq/manager/Manager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "bPref", "", "getBPref", "()I", "setBPref", "(I)V", "isSwitching", "", "()Z", "setSwitching", "(Z)V", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "needCheckShowModeSwitchDialog", "oldType", "getOldType", "setOldType", "onModeChangeResultCallbacks", "", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "simpleUIObserver", "Lcom/tencent/mobileqq/simpleui/SimpleUIObserver;", "studentFlagPullStatus", "studyModePullStatus", "tag", "", "targetType", "getTargetType", "setTargetType", "addCallback", "", "onModeChangeResultCallback", "changeMode", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$SwitchingStatus;", "activity", "Landroid/app/Activity;", "bSwitchElsePref", "checkAndReportStockStudyMode", "doChangeMode", "isSameDayWithLastReport", "onChangeStudyModeComplete", "isSuc", "message", "onColorfulChangeResult", "onDestroy", "onModeChangeResult", "onStudentFlagPullComplete", "isStudent", "onStudyModePullComplete", "isStudy", "onSwitchUICallBackInManager", "bChangeTheme", "statusCode", "releaseDialog", "removeCallback", "showModeSwitchDialog", "Lcom/tencent/mobileqq/app/BaseActivity;", "OnModeChangeResultCallback", "SwitchingStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anvv
  implements Manager
{
  private final List<anvv.a> GL;
  private final anll a;
  private final QQAppInterface app;
  private boolean cKg;
  private boolean cKh;
  private int dMV;
  private int dMX;
  private int dMY;
  private int dMZ;
  private aqju m;
  private final String tag;
  private int targetType;
  
  public anvv(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.tag = "GeneralModeSwitcherManager";
    this.GL = ((List)new ArrayList());
    this.targetType = -1;
    this.dMV = -1;
    this.dMX = -1;
    this.cKh = true;
    this.a = ((anll)new anvy(this));
    this.app.addObserver((acci)this.a);
  }
  
  private final void QA(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = BaseApplicationImpl.getContext().getString(2131695963);
      Intrinsics.checkExpressionValueIsNotNull(str, "BaseApplicationImpl.getC…mode_operation_open_fail)");
      aL(false, str);
      return;
    }
    aL(true, "");
  }
  
  private final void Qz(boolean paramBoolean)
  {
    int i;
    switch (this.targetType)
    {
    default: 
      i = 2131694276;
      str = acfp.m(i);
      if (!paramBoolean) {
        break;
      }
    }
    for (String str = BaseApplicationImpl.getContext().getString(2131695962, new Object[] { str });; str = BaseApplicationImpl.getContext().getString(2131695964, new Object[] { str }))
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "message");
      aL(paramBoolean, str);
      return;
      i = 2131694279;
      break;
      i = 2131694281;
      break;
    }
  }
  
  private final void aL(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = ((Iterable)this.GL).iterator();
    while (localIterator.hasNext()) {
      ((anvv.a)localIterator.next()).a(paramBoolean, this.targetType, this.dMV, paramString);
    }
    if ((paramBoolean) && ((this.targetType == 2) || (this.dMV == 2))) {
      aqmj.a((Context)BaseApplicationImpl.context, this.app.getCurrentAccountUin(), true, "study_mode_has_change", Boolean.valueOf(true));
    }
  }
  
  private final boolean azd()
  {
    Object localObject1 = (String)aqmj.b((Context)BaseApplicationImpl.context, this.app.getCurrentAccountUin(), "study_mode_last_report_time", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject1);
      localObject1 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "calendarLast");
      ((Calendar)localObject1).setTime((Date)localObject2);
      localObject2 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "calendarNow");
      ((Calendar)localObject2).setTime(new Date());
      if ((((Calendar)localObject1).get(0) == ((Calendar)localObject2).get(0)) && (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1)) && (((Calendar)localObject1).get(6) == ((Calendar)localObject2).get(6))) {
        return true;
      }
    }
    return false;
  }
  
  private final void dTF()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "checkAndReportStockStudyMode -> studyModePullStatus : " + this.dMY + ", studentFlagPullStatus : " + this.dMZ);
    }
    if ((this.dMY == 1) && (this.dMZ != 0))
    {
      boolean bool1 = anwa.TK();
      boolean bool2 = azd();
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "checkAndReportStockStudyMode -> configSwitch : " + bool1 + ", isSameDay ： " + bool2);
      }
      if ((bool1) && (!bool2)) {
        if (this.dMZ != 1) {
          break label247;
        }
      }
    }
    label247:
    for (int i = 1;; i = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "checkAndReportStockStudyMode ReportController 0X800AD6C ， identity ： " + i);
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
      aqmj.a((Context)BaseApplicationImpl.context, this.app.getCurrentAccountUin(), true, "study_mode_last_report_time", localSimpleDateFormat.format(new Date()));
      anot.a(this.app, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, i, "", "", "", "");
      return;
    }
  }
  
  private final void i(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.cKg = true;
    Object localObject = this.app.getBusinessHandler(154);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    localObject = (anlk)localObject;
    boolean bool1;
    if (paramInt2 == 1)
    {
      bool1 = true;
      if (paramInt2 != 2) {
        break label162;
      }
    }
    for (;;)
    {
      if (((anlk)localObject).a(bool1, paramInt1, paramBoolean, bool2)) {
        break label168;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "doChangeMode switching");
      }
      QQToast.a((Context)BaseApplication.getContext(), 0, 2131719970, 0).show();
      localObject = ((Iterable)this.GL).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anvv.a)((Iterator)localObject).next()).fg(this.targetType, this.dMV);
      }
      bool1 = false;
      break;
      label162:
      bool2 = false;
    }
    label168:
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doChangeMode switch start");
    }
    this.targetType = paramInt2;
    this.dMV = paramInt3;
    this.dMX = paramInt1;
    localObject = ((Iterable)this.GL).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((anvv.a)((Iterator)localObject).next()).fe(paramInt2, paramInt3);
    }
  }
  
  public final int Kt()
  {
    return this.targetType;
  }
  
  public final int Ku()
  {
    return this.dMX;
  }
  
  public final void QB(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onStudyModePullComplete isStudy : " + paramBoolean);
    }
    if (paramBoolean) {
      i = 1;
    }
    this.dMY = i;
    dTF();
  }
  
  public final void QC(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onStudentFlagPullComplete isStudent : " + paramBoolean);
    }
    if (paramBoolean) {
      i = 1;
    }
    this.dMZ = i;
    dTF();
  }
  
  public final void Qy(boolean paramBoolean)
  {
    this.cKg = paramBoolean;
  }
  
  @NotNull
  public final anvv.b a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "changeMode targetType: " + paramInt1 + ", bPref : " + paramInt2);
    }
    int i = anvt.mk();
    if ((!this.cKg) && ((i != paramInt1) || (paramInt2 != this.dMX)))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.a((Context)BaseApplication.getContext(), 1, 2131696348, 0).show();
        paramActivity = ((Iterable)this.GL).iterator();
        while (paramActivity.hasNext()) {
          ((anvv.a)paramActivity.next()).ff(paramInt1, i);
        }
        return new anvv.b(false, paramInt1, i);
      }
      if (paramInt1 == 1)
      {
        Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)this.app);
        if (((SharedPreferences)localObject).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject = (DialogInterface.OnClickListener)new anvx(this, paramInt2, paramInt1, i, paramBoolean);
          aqju localaqju = this.m;
          if (localaqju != null) {
            localaqju.dismiss();
          }
          this.m = aqha.a(paramActivity, BaseApplicationImpl.getContext().getString(2131719965), 0, 2131719963, (DialogInterface.OnClickListener)localObject, null);
          paramActivity = this.m;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.setOnDismissListener((DialogInterface.OnDismissListener)new anvw(this, paramInt1, i));
          paramActivity = this.m;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.show();
        }
      }
      for (;;)
      {
        return new anvv.b(true, paramInt1, i);
        i(paramInt2, paramInt1, i, paramBoolean);
        continue;
        i(paramInt2, paramInt1, i, paramBoolean);
      }
    }
    return new anvv.b(this.cKg, paramInt1, i);
  }
  
  public final void a(@Nullable anvv.a parama)
  {
    if (parama != null) {
      this.GL.add(parama);
    }
  }
  
  public final boolean azc()
  {
    return this.cKg;
  }
  
  public final void b(@Nullable anvv.a parama)
  {
    if ((parama != null) && (this.GL.contains(parama))) {
      this.GL.remove(parama);
    }
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onSwitchUICallBack targetType : " + this.targetType + ", isSuc : " + paramBoolean1 + " , bChangeTheme : " + paramBoolean2 + ", bSwitchElsePref : " + paramBoolean3 + " , statusCode : " + paramInt);
    }
    if (paramBoolean3)
    {
      Qz(paramBoolean1);
      return;
    }
    QA(paramBoolean1);
  }
  
  public final void dTE()
  {
    aqju localaqju = this.m;
    if (localaqju != null) {
      localaqju.setOnDismissListener(null);
    }
    localaqju = this.m;
    if (localaqju != null) {
      localaqju.dismiss();
    }
    this.m = ((aqju)null);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onDestroy");
    }
    this.app.removeObserver((acci)this.a);
    dTE();
    this.GL.clear();
    this.targetType = -1;
    this.dMV = -1;
    this.cKg = false;
    this.cKh = false;
    this.dMY = 0;
    this.dMZ = 0;
  }
  
  public final void y(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showModeSwitchDialog studyModePullStatus : " + this.dMY + " , studentFlagPullStatus : " + this.dMZ);
    }
    if (this.cKh) {
      if ((this.dMY != 0) && (this.dMZ != 0)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.cKh = bool;
      if ((this.dMY == 2) && (this.dMZ == 1) && (anwa.azf()) && (!((Boolean)aqmj.b((Context)paramBaseActivity, this.app.getCurrentAccountUin(), "study_mode_has_change", Boolean.valueOf(false))).booleanValue()) && (!((Boolean)aqmj.b((Context)paramBaseActivity, this.app.getCurrentAccountUin(), "study_mode_change_dialog_has_show", Boolean.valueOf(false))).booleanValue()))
      {
        new anwc(paramBaseActivity).show();
        aqmj.a((Context)BaseApplicationImpl.context, this.app.getCurrentAccountUin(), true, "study_mode_change_dialog_has_show", Boolean.valueOf(true));
      }
      return;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "", "onIReqGetSimpleUISwitch", "", "isSuccess", "", "bSwitch", "sStudySwitch", "bPref", "", "uin", "", "onISwitchSimpleUICallback", "isSuc", "bChangeTheme", "bSwitchElsePref", "statusCode", "onModeChangeComplete", "targetType", "oldType", "message", "onModeChangeStart", "onModeSwitching", "onSelectModeRecover", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString);
    
    public abstract void fe(int paramInt1, int paramInt2);
    
    public abstract void ff(int paramInt1, int paramInt2);
    
    public abstract void fg(int paramInt1, int paramInt2);
    
    @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
    public static final class a
    {
      public static void a(anvv.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {}
      
      public static void a(anvv.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString) {}
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager$SwitchingStatus;", "", "isSwitching", "", "targetMode", "", "oldMode", "(ZII)V", "()Z", "getOldMode", "()I", "getTargetMode", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    private final boolean cKg;
    private final int dNa;
    private final int dNb;
    
    public b()
    {
      this(false, 0, 0, 7, null);
    }
    
    public b(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.cKg = paramBoolean;
      this.dNa = paramInt1;
      this.dNb = paramInt2;
    }
    
    public final int Kv()
    {
      return this.dNa;
    }
    
    public final int Kw()
    {
      return this.dNb;
    }
    
    public final boolean azc()
    {
      return this.cKg;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.cKg != paramObject.cKg) || (this.dNa != paramObject.dNa) || (this.dNb != paramObject.dNb)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    @NotNull
    public String toString()
    {
      return "SwitchingStatus(isSwitching=" + this.cKg + ", targetMode=" + this.dNa + ", oldMode=" + this.dNb + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */