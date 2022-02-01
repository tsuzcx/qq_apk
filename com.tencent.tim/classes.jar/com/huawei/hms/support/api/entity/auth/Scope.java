package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

public class Scope
  implements Parcelable, IMessageEntity
{
  public static final Parcelable.Creator<Scope> CREATOR = new Scope.1();
  private String mScopeUri;
  
  public Scope()
  {
    this.mScopeUri = null;
  }
  
  protected Scope(Parcel paramParcel)
  {
    this.mScopeUri = paramParcel.readString();
  }
  
  public Scope(String paramString)
  {
    this.mScopeUri = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    paramObject = (Scope)paramObject;
    return Objects.equal(this.mScopeUri, paramObject.mScopeUri);
  }
  
  @Deprecated
  public boolean equeals(Object paramObject)
  {
    return equals(paramObject);
  }
  
  public String getScopeUri()
  {
    return this.mScopeUri;
  }
  
  public final int hashCode()
  {
    if (this.mScopeUri == null) {
      return super.hashCode();
    }
    return this.mScopeUri.hashCode();
  }
  
  public final String toString()
  {
    return this.mScopeUri;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mScopeUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.Scope
 * JD-Core Version:    0.7.0.1
 */