package com.tencent.tmassistant.appinfo.aidl;

import android.os.IInterface;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

public abstract interface IGetAppInfoCallback
  extends IInterface
{
  public abstract void onGetAppInfoResponse(int paramInt1, int paramInt2, List<AppDetail> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback
 * JD-Core Version:    0.7.0.1
 */