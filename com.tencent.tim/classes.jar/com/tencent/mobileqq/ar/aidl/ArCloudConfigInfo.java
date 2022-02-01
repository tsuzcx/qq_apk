package com.tencent.mobileqq.ar.aidl;

import adbm;
import adgg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ArCloudConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArCloudConfigInfo> CREATOR = new adgg();
  public static int cFg = 3;
  public adbm a;
  public ARRelationShip a;
  public ArAwardInfo a;
  public ArFeatureInfo a;
  public ArLBSActivity a;
  public ArModelResource a;
  public ArWebInfo a;
  public String bsN;
  public int businessId;
  public int cCF;
  public int cFe;
  public int cFf;
  public int cFh;
  public boolean flag;
  public String picId;
  public int type;
  public ArrayList<ArVideoResourceInfo> uk = new ArrayList();
  
  public ArCloudConfigInfo() {}
  
  public ArCloudConfigInfo(Parcel paramParcel)
  {
    this.flag = true;
    QLog.i("ArCloudConfigInfo", 1, "readParcel  start ");
    this.businessId = paramParcel.readInt();
    this.bsN = paramParcel.readString();
    this.cFe = paramParcel.readInt();
    this.cCF = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.picId = paramParcel.readString();
    this.cFf = paramParcel.readInt();
    try
    {
      this.uk = new ArrayList();
      paramParcel.readList(this.uk, ArVideoResourceInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)paramParcel.readParcelable(ArFeatureInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource = ((ArModelResource)paramParcel.readParcelable(ArModelResource.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo = ((ArAwardInfo)paramParcel.readParcelable(ArAwardInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo = ((ArWebInfo)paramParcel.readParcelable(ArWebInfo.class.getClassLoader()));
    }
    catch (Exception paramParcel)
    {
      try
      {
        if (19 <= cFg)
        {
          this.cFh = paramParcel.readInt();
          this.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip = ((ARRelationShip)paramParcel.readParcelable(ARRelationShip.class.getClassLoader()));
          if (20 <= cFg) {
            this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity = ((ArLBSActivity)paramParcel.readParcelable(ArLBSActivity.class.getClassLoader()));
          }
        }
      }
      catch (Exception paramParcel)
      {
        try
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "readParcel  businessId = " + this.businessId + ",  sDKVersion = " + this.bsN + ",  closeCache = " + this.cFe + ",  trackMode = " + this.cCF + ",  type = " + this.type + ",  picId = " + this.picId + ",  mArFeatureInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo + ",  modelResource = " + this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource + ",  mArWebInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo + ", mArLBSActivity = " + this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
            QLog.i("ArCloudConfigInfo", 1, "readParcel  end flag = " + this.flag + "  VersionCode :" + cFg);
            return;
            localException = localException;
            this.flag = false;
            QLog.i("ArCloudConfigInfo", 1, "ArVideoResourceInfo read fail= " + localException.getMessage());
            continue;
            paramParcel = paramParcel;
            this.flag = false;
            QLog.i("ArCloudConfigInfo", 1, "readParcel failed. msg = " + paramParcel.getMessage());
          }
        }
        catch (Exception paramParcel)
        {
          for (;;)
          {
            this.flag = false;
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + paramParcel.getMessage());
          }
        }
      }
    }
  }
  
  public boolean aef()
  {
    return this.type == 100;
  }
  
  public boolean aeg()
  {
    return (this.cFh == 1) && (this.type == 7);
  }
  
  public boolean aeh()
  {
    return this.type == 8;
  }
  
  public boolean aei()
  {
    return this.cCF == 0;
  }
  
  public boolean aej()
  {
    return this.businessId == 1;
  }
  
  public boolean aek()
  {
    return (this.type != 6) && ((!aej()) || (this.cFf != 0));
  }
  
  public boolean ael()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bOa;
  }
  
  public boolean aem()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {}
    while (((this.businessId != 1) || (this.cFf != 1)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but))) {
      return false;
    }
    return true;
  }
  
  public boolean aen()
  {
    return this.cCF == 2;
  }
  
  public boolean aeo()
  {
    return this.cCF == 1;
  }
  
  public boolean aep()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {
      return false;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but)) && (this.businessId != 1) && (!aei())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArCloudConfigInfo{");
    localStringBuffer.append("mArFeatureInfo='").append(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo).append('\'');
    localStringBuffer.append(", modelResource=").append(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource);
    localStringBuffer.append(", mIsRelationShip=").append(this.cFh);
    localStringBuffer.append(", mArLBSActivity = ").append(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QLog.i("ArCloudConfigInfo", 1, "writeToParcel  start ");
    paramParcel.writeInt(this.businessId);
    paramParcel.writeString(this.bsN);
    paramParcel.writeInt(this.cFe);
    paramParcel.writeInt(this.cCF);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.picId);
    paramParcel.writeInt(this.cFf);
    try
    {
      paramParcel.writeList(this.uk);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo, paramInt);
    }
    catch (Exception paramParcel)
    {
      try
      {
        paramParcel.writeInt(this.cFh);
        paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip, paramInt);
        paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity, paramInt);
      }
      catch (Exception paramParcel)
      {
        try
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel  businessId = " + this.businessId + ",  sDKVersion = " + this.bsN + ",  closeCache = " + this.cFe + ",  trackMode = " + this.cCF + ",  type = " + this.type + ",  picId = " + this.picId + ",  mArFeatureInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo + ",  modelResource = " + this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource + ",  mArWebInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo + ", mArLBSActivity = " + this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel  end VersionCode" + cFg);
            return;
            localException = localException;
            QLog.i("ArCloudConfigInfo", 1, "writeList  fail= " + localException.getMessage());
            continue;
            paramParcel = paramParcel;
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel failed. msg = " + paramParcel.getMessage());
          }
        }
        catch (Exception paramParcel)
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + paramParcel.getMessage());
          }
        }
      }
    }
  }
  
  public static class a
  {
    public int height;
    public float scaleX = 2.0F;
    public float scaleY = 2.0F;
    public float uN = 0.0F;
    public float uO = 0.0F;
    public float uP = 0.0F;
    public int width;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARVideoLayout {width: ").append(this.width).append(", height: ").append(this.height).append(", scaleX: ").append(this.scaleX).append(", scaleY: ").append(this.scaleY).append(", transX: ").append(this.uN).append(", transY: ").append(this.uO).append(", transZ: ").append(this.uP).append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo
 * JD-Core Version:    0.7.0.1
 */