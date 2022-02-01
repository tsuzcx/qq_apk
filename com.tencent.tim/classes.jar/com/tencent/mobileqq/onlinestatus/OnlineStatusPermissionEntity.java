package com.tencent.mobileqq.onlinestatus;

import androidx.annotation.NonNull;
import aoyb;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPermissionEntity
  extends Entity
{
  public static final String TAG = "OnlineStatusPermissionEntity";
  @defaultValue(defaultInteger=1)
  public boolean allHasPermission = true;
  @notColumn
  public List<Long> hasPermissionList = new ArrayList(0);
  public long onlineStateType;
  public byte[] permissionList;
  
  public void postRead()
  {
    super.postRead();
    if (this.permissionList == null) {
      this.hasPermissionList = new ArrayList(0);
    }
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = aoyb.deserialize(this.permissionList);
      } while (localObject == null);
      try
      {
        this.hasPermissionList = ((List)localObject);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("OnlineStatusPermissionEntity", 2, "postRead: failed. ", localException);
  }
  
  public void prewrite()
  {
    super.prewrite();
    if ((this.hasPermissionList != null) && (this.hasPermissionList.size() > 0))
    {
      this.permissionList = aoyb.d(this.hasPermissionList);
      return;
    }
    this.permissionList = null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" onlineStateType=").append(this.onlineStateType).append(" allHasPermission=").append(this.allHasPermission).append(" hasPermissionList");
    if (this.hasPermissionList == null) {}
    for (Object localObject = "";; localObject = this.hasPermissionList.toArray())
    {
      localStringBuilder2.append(localObject);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionEntity
 * JD-Core Version:    0.7.0.1
 */