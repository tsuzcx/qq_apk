package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import rda;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new rda();
  public EditSource a;
  public int asi;
  public final int bqp;
  public final Bundle mExtra;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditSource paramEditSource, Bundle paramBundle)
  {
    this.asi = paramInt1;
    this.bqp = paramInt2;
    this.a = paramEditSource;
    if (paramBundle == null)
    {
      this.mExtra = new Bundle();
      return;
    }
    this.mExtra = paramBundle;
  }
  
  public EditVideoParams(Parcel paramParcel)
  {
    this.asi = paramParcel.readInt();
    this.bqp = paramParcel.readInt();
    this.a = ((EditSource)paramParcel.readParcelable(EditSource.class.getClassLoader()));
    this.mExtra = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public static Bundle c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
    case 10004: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 101);
      return localBundle;
    case 104: 
    case 10010: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 104);
      return localBundle;
    case 102: 
    case 10009: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 102);
      return localBundle;
    case 103: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 103);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 11);
    return localBundle;
  }
  
  public boolean La()
  {
    return ((this.a instanceof EditTakePhotoSource)) || ((this.a instanceof EditLocalPhotoSource));
  }
  
  public boolean Lb()
  {
    return ((this.a instanceof EditRecordVideoSource)) || ((this.a instanceof EditLocalVideoSource)) || ((this.a instanceof EditTakeVideoSource));
  }
  
  public boolean Lc()
  {
    return ((this.a instanceof EditRecordVideoSource)) || ((this.a instanceof EditTakePhotoSource)) || ((this.a instanceof EditTakeVideoSource));
  }
  
  public boolean Ld()
  {
    return ((this.a instanceof EditLocalVideoSource)) || ((this.a instanceof EditLocalPhotoSource));
  }
  
  public boolean Le()
  {
    return this.a instanceof EditLocalGifSource;
  }
  
  public boolean Lf()
  {
    return this.a instanceof EditTakeGifSource;
  }
  
  public boolean Lg()
  {
    if (this.mExtra == null) {
      return false;
    }
    return this.mExtra.getBoolean("enable_hw_encode");
  }
  
  public boolean Lh()
  {
    if (this.mExtra == null) {
      return true;
    }
    return this.mExtra.getBoolean("extra_enable_revert", true);
  }
  
  public boolean Li()
  {
    if (this.mExtra == null) {
      return true;
    }
    return this.mExtra.getBoolean("extra_enable_slow", true);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.mExtra != null) {
      bool = this.mExtra.getBoolean(paramString, paramBoolean);
    }
    return bool;
  }
  
  public double getDoubleExtra(String paramString, double paramDouble)
  {
    double d = paramDouble;
    if (this.mExtra != null) {
      d = this.mExtra.getDouble(paramString, paramDouble);
    }
    return d;
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    int i = paramInt;
    if (this.mExtra != null) {
      i = this.mExtra.getInt(paramString, paramInt);
    }
    return i;
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    long l = paramLong;
    if (this.mExtra != null) {
      l = this.mExtra.getLong(paramString, paramLong);
    }
    return l;
  }
  
  public String getStringExtra(String paramString)
  {
    if (this.mExtra != null) {
      return this.mExtra.getString(paramString);
    }
    return null;
  }
  
  public String mT()
  {
    Object localObject;
    switch (this.asi)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = "Unknown Business id " + this.asi;
    }
    String str;
    do
    {
      return localObject;
      if (this.a == null) {
        return "Can not find edit source";
      }
      str = this.a.mR();
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public byte[] o(String paramString)
  {
    if (this.mExtra != null) {
      return this.mExtra.getByteArray(paramString);
    }
    return null;
  }
  
  public int tg()
  {
    int j = 6;
    int k = this.asi;
    int i = k;
    if (this.mExtra != null)
    {
      if (k == 2) {
        i = this.mExtra.getInt("qq_sub_business_id");
      }
      do
      {
        return i;
        i = k;
        if (k != 6) {
          break;
        }
        k = this.mExtra.getInt("qq_sub_business_id", -999);
        i = j;
      } while (k == -999);
      i = k;
    }
    return i;
  }
  
  public int th()
  {
    if (this.mExtra == null) {
      return 99;
    }
    return this.mExtra.getInt("entrance_type", 99);
  }
  
  public int ti()
  {
    if (this.mExtra == null) {
      return 1;
    }
    return this.mExtra.getInt("expect_fragment_count", 1);
  }
  
  public String toString()
  {
    return "EditVideoParams{mBusinessId=" + this.asi + ", mEnableMasks=" + this.bqp + ", mEditSource=" + this.a + ", entranceType=" + th() + ", mExtra=" + this.mExtra + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.asi);
    paramParcel.writeInt(this.bqp);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeBundle(this.mExtra);
  }
  
  public static abstract interface EditSource
    extends Parcelable
  {
    public abstract int getHeight();
    
    @NonNull
    public abstract String getSourcePath();
    
    public abstract int getWidth();
    
    public abstract String mR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */