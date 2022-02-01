import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anwg
  extends aehv<anwg.b>
{
  public static final anwg.a a = new anwg.a(null);
  
  @NotNull
  public anwg.b a(int paramInt)
  {
    return new anwg.b();
  }
  
  @Nullable
  public anwg.b a(@Nullable aeic[] paramArrayOfaeic)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeSwitchDialogConfigProcessor", 2, "onParsed");
    }
    anwg.b localb = new anwg.b();
    if (paramArrayOfaeic != null)
    {
      if (paramArrayOfaeic.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfaeic = paramArrayOfaeic[0].content;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaeic, "confFiles[0].content");
        localb.parse(paramArrayOfaeic);
      }
      return localb;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable anwg.b paramb) {}
  
  @NotNull
  public Class<anwg.b> clazz()
  {
    return anwg.b.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 619;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "shouldShowStudyModeSwitchDialog", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public final boolean azg()
    {
      Object localObject = aeif.a().o(619);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
      return ((anwg.b)localObject).azf();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "", "()V", "showStudyModeSwitchDialog", "", "getShowStudyModeSwitchDialog", "()Z", "setShowStudyModeSwitchDialog", "(Z)V", "parse", "", "configText", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    private boolean cKo;
    
    public final boolean azf()
    {
      return this.cKo;
    }
    
    public final void parse(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "configText");
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeSwitchDialogConfigProcessor", 2, paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)paramString)) {}
      try
      {
        if (new JSONObject(paramString).optInt("ConfigEnableStudyModeGuide", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          this.cKo = bool;
          return;
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("StudyModeSwitchDialogConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwg
 * JD-Core Version:    0.7.0.1
 */