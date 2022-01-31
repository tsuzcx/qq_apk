package com.tencent.mobileqq.data;

import android.net.Uri;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PhoneContact
  extends Entity
  implements Cloneable
{
  public int ability;
  public List allPhoneNumber;
  public long bindingDate;
  public int contactID;
  public String faceUrl;
  public int isRecommend;
  public boolean isUploaded = false;
  public long lastScanTime;
  public String lookupID;
  public String mobileCode;
  @unique
  public String mobileNo;
  public String name;
  public String nationCode;
  public String nickName;
  public long originBinder;
  public Uri photoUri;
  public String pinyinAll;
  @notColumn
  public String pinyinFirst;
  public String pinyinInitial;
  public String remark;
  public String uin;
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("PhoneContactManager", 2, "PhoneContact clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PhoneContact
 * JD-Core Version:    0.7.0.1
 */