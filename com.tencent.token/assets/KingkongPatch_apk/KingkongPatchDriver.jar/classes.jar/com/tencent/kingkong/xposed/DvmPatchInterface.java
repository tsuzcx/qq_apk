package com.tencent.kingkong.xposed;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.kingkong.Common;

public class DvmPatchInterface
{
  protected int index = 0;
  protected String patchName = "";
  protected String patchType = "";
  protected String patchVersion = "";
  
  public DvmPatchInterface(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.index = paramInt;
    this.patchName = paramString1;
    this.patchType = paramString2;
    this.patchVersion = paramString3;
  }
  
  public void onLoad(Context paramContext) {}
  
  protected void report(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      Common.reportDoPatch(paramInt, paramString1, paramString2, paramString3, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.xposed.DvmPatchInterface
 * JD-Core Version:    0.7.0.1
 */