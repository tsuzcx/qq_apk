package com.tencent.mfsdk.config;

import aehv;
import aeic;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;

public class QConfigAPMProcessor
  extends aehv<APMConfRoot>
{
  public static final int CONFIG_ID = 255;
  public static final String TAG = "QAPM.Processor";
  
  public Class<APMConfRoot> clazz()
  {
    return APMConfRoot.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public APMConfRoot migrateOldOrDefaultContent(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAPM.Processor", 2, "migrateOldOrDefaultContent ");
    }
    return new APMConfRoot();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public APMConfRoot onParsed(aeic[] paramArrayOfaeic)
  {
    APMConfRoot localAPMConfRoot = null;
    if (paramArrayOfaeic.length > 0) {
      localAPMConfRoot = (APMConfRoot)new Gson().fromJson(paramArrayOfaeic[0].content, APMConfRoot.class);
    }
    paramArrayOfaeic = localAPMConfRoot;
    if (localAPMConfRoot == null) {
      paramArrayOfaeic = new APMConfRoot();
    }
    return paramArrayOfaeic;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public void onUpdate(APMConfRoot paramAPMConfRoot) {}
  
  public int type()
  {
    return 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.config.QConfigAPMProcessor
 * JD-Core Version:    0.7.0.1
 */