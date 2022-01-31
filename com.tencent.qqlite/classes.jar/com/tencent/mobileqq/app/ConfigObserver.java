package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigObserver
  implements BusinessObserver
{
  protected void a(String paramString, int paramInt, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  protected void b(boolean paramBoolean, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      a(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
      return;
      a(paramBoolean, (GetResourceRespInfo)paramObject);
      return;
      a(paramBoolean, (String)paramObject);
      return;
      a(paramBoolean, (UpgradeDetailWrapper)paramObject);
      return;
      a(paramBoolean, (AppShareID)paramObject);
      return;
      b(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
      return;
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    } while ((paramObject == null) || (!(paramObject instanceof OperateVoipTipsInfo)));
    paramObject = (OperateVoipTipsInfo)paramObject;
    a(paramObject.uin, paramObject.uinType, paramObject.taskList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigObserver
 * JD-Core Version:    0.7.0.1
 */