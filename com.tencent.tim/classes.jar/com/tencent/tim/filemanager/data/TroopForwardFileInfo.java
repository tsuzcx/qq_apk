package com.tencent.tim.filemanager.data;

import agkf;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import atwi;
import atyn;
import atzy;
import auau;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class TroopForwardFileInfo
  extends ForwardFileInfo
{
  public static final Parcelable.Creator<TroopForwardFileInfo> CREATOR = new atwi();
  
  public TroopForwardFileInfo() {}
  
  public TroopForwardFileInfo(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public atzy a(Activity paramActivity)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.a().c(fR());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(atyn.b(localQQAppInterface, localFileManagerEntity));
    return new auau(paramActivity, localArrayList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.data.TroopForwardFileInfo
 * JD-Core Version:    0.7.0.1
 */