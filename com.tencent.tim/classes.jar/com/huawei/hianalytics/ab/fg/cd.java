package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.ab.ef;
import java.util.LinkedHashMap;

public class cd
{
  public ef ab;
  private String bc;
  
  public cd(String paramString)
  {
    this.bc = paramString;
    this.ab = new ef(paramString);
    com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().ab(this.bc, this.ab);
  }
  
  private com.huawei.hianalytics.ab.bc.cd.ab.cd bc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.ab.bc();
    case 3: 
      return this.ab.de();
    case 1: 
      return this.ab.ab();
    }
    return this.ab.cd();
  }
  
  private boolean cd(int paramInt)
  {
    if (paramInt == 2)
    {
      if (!"_default_config_tag".equals(this.bc))
      {
        com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "verifyURL(): type: preins. Only default config can report Pre-install data.");
        return false;
      }
      return true;
    }
    com.huawei.hianalytics.ab.bc.cd.ab.cd localcd = bc(paramInt);
    if ((localcd == null) || (TextUtils.isEmpty(localcd.hi())))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "verifyURL(): URL check failed. type: " + paramInt);
      return false;
    }
    return true;
  }
  
  public void ab(int paramInt)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    bc.ab().ab(this.bc, paramInt);
  }
  
  public void ab(int paramInt, com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd)
  {
    Object localObject = null;
    if (paramcd == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstanceImpl.refresh(). Parameter config is null.TAG : %s , TYPE : %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    }
    for (paramcd = localObject;; paramcd = new com.huawei.hianalytics.ab.bc.cd.ab.cd(paramcd))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstanceImpl.refresh() is executed.TAG : %s , TYPE : %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
      switch (paramInt)
      {
      default: 
        com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.");
        return;
      }
    }
    cd(paramcd);
    com.huawei.hianalytics.ab.bc.hi.ab.ab().ab(this.bc);
    return;
    ab(paramcd);
    return;
    bc(paramcd);
    return;
    de(paramcd);
  }
  
  public void ab(int paramInt, String paramString)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setUpid() is executed.TAG : " + this.bc);
    com.huawei.hianalytics.ab.bc.cd.ab.cd localcd = bc(paramInt);
    if (localcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "setUpid(): No related config found.type : " + paramInt);
      return;
    }
    String str = paramString;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("upid", paramString, 4096)) {
      str = "";
    }
    localcd.fg(str);
  }
  
  public void ab(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    if ((com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString)) || (!cd(paramInt)))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.bc + ", TYPE: " + paramInt);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.bc + ", TYPE: " + paramInt);
      localLinkedHashMap = null;
    }
    bc.ab().ab(this.bc, paramInt, paramString, localLinkedHashMap);
  }
  
  public void ab(int paramInt, boolean paramBoolean)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstanceImpl.setOAIDTrackingFlag() is executed.TAG : %s , TYPE : %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    com.huawei.hianalytics.ab.bc.cd.ab.cd localcd = bc(paramInt);
    if (localcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "setOAIDTrackingFlag(): No related config found.type : " + paramInt);
      return;
    }
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localcd.de(str);
      return;
    }
  }
  
  public void ab(Context paramContext)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onPause() is execute.TAG: " + this.bc);
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onPause! Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    bc.ab().ab(this.bc, paramContext);
  }
  
  public void ab(Context paramContext, int paramInt)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstance.onReport(Context context) is execute.TAG: %s,TYPE: %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onReport!");
      return;
    }
    bc.ab().ab(this.bc, paramInt);
  }
  
  public void ab(Context paramContext, String paramString1, String paramString2)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : " + this.bc);
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onevent ");
      return;
    }
    if ((com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString1)) || (!cd(0)))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    String str = paramString2;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("value", paramString2, 65536))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.bc);
      str = "";
    }
    bc.ab().ab(this.bc, paramContext, paramString1, str);
  }
  
  public void ab(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onPause(context,map) is execute.TAG: " + this.bc);
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onPause! Nothing will be recorded.");
      return;
    }
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onPause() parameter mapValue will be cleared.TAG: " + this.bc);
      localLinkedHashMap = null;
    }
    bc.ab().ab(this.bc, paramContext, localLinkedHashMap);
  }
  
  public void ab(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.bc);
    if (paramcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
      this.ab.ab(null);
      return;
    }
    this.ab.ab(paramcd);
  }
  
  public void ab(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onPause(viewName,map) is execute.TAG: " + this.bc);
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onPause() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!com.huawei.hianalytics.ab.bc.kl.cd.ab("viewName", paramString, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onPause() parameter viewName verify failed. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onPause() parameter mapValue will be cleared.TAG: " + this.bc);
      localLinkedHashMap = null;
    }
    bc.ab().ab(this.bc, paramString, localLinkedHashMap);
  }
  
  public void bc(int paramInt, String paramString)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setStrOAID() is executed.TAG : " + this.bc);
    com.huawei.hianalytics.ab.bc.cd.ab.cd localcd = bc(paramInt);
    if (localcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "setOAID(): No related config found.type : " + paramInt);
      return;
    }
    String str = paramString;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("oaid", paramString, 4096)) {
      str = "";
    }
    localcd.cd(str);
  }
  
  public void bc(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "HiAnalyticsInstance.onStreamEvent() is execute.TAG: %s,TYPE: %d", new Object[] { this.bc, Integer.valueOf(paramInt) });
    if ((com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString)) || (!cd(paramInt)))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.bc + ", TYPE: " + paramInt);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.bc + ", TYPE: " + paramInt);
      localLinkedHashMap = null;
    }
    bc.ab().bc(this.bc, paramInt, paramString, localLinkedHashMap);
  }
  
  public void bc(Context paramContext)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onResume() is execute.TAG: " + this.bc);
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onResume! Nothing will be recorded.");
      return;
    }
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    bc.ab().bc(this.bc, paramContext);
  }
  
  public void bc(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onResume(context,map) is execute.TAG: " + this.bc);
    if (paramContext == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "context is null in onResume! Nothing will be recorded.");
      return;
    }
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() parameter mapValue will be cleared.TAG: " + this.bc);
      localLinkedHashMap = null;
    }
    bc.ab().bc(this.bc, paramContext, localLinkedHashMap);
  }
  
  public void bc(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf() is executed.TAG : " + this.bc);
    if (paramcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf(): config for diffPrivacy is null!");
      this.ab.de(null);
      return;
    }
    this.ab.de(paramcd);
  }
  
  public void bc(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstance.onResume(viewname,map) is execute.TAG: " + this.bc);
    if (!cd(0))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!com.huawei.hianalytics.ab.bc.kl.cd.ab("viewName", paramString, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() parameter viewName verify failed. Nothing will be recorded.TAG: " + this.bc);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "onResume() parameter mapValue will be cleared.TAG: " + this.bc);
      localLinkedHashMap = null;
    }
    bc.ab().bc(this.bc, paramString, localLinkedHashMap);
  }
  
  public void cd(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.bc);
    if (paramcd == null)
    {
      this.ab.bc(null);
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
      return;
    }
    this.ab.bc(paramcd);
  }
  
  public void de(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf() is executed.TAG: " + this.bc);
    if (paramcd == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf(): config for PRE-INSTALL is null!");
      this.ab.cd(null);
      return;
    }
    this.ab.cd(paramcd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.fg.cd
 * JD-Core Version:    0.7.0.1
 */