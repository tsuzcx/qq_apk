package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import aygx;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new aygx();
  public EditSource a;
  public final long aCQ;
  public int asi;
  public int eKf;
  public int eKg;
  public int entryType = -1;
  public final Bundle mExtra;
  public int mFrom;
  public int mMode;
  
  public EditVideoParams(int paramInt, long paramLong, EditSource paramEditSource, Bundle paramBundle)
  {
    this.asi = paramInt;
    this.aCQ = paramLong;
    this.a = paramEditSource;
    this.mExtra = paramBundle;
  }
  
  public EditVideoParams(Parcel paramParcel)
  {
    this.asi = paramParcel.readInt();
    this.aCQ = paramParcel.readLong();
    this.a = ((EditSource)paramParcel.readParcelable(EditSource.class.getClassLoader()));
    this.mExtra = paramParcel.readBundle(getClass().getClassLoader());
    this.eKf = paramParcel.readInt();
    this.eKg = paramParcel.readInt();
    this.mMode = paramParcel.readInt();
    this.mFrom = paramParcel.readInt();
    this.entryType = paramParcel.readInt();
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
    case 102: 
    case 10009: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 102);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 103);
    return localBundle;
  }
  
  public static boolean oA(int paramInt)
  {
    return (paramInt == 126) || (paramInt == 127) || (paramInt == 128) || (paramInt == 129) || (paramInt == 130);
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
  
  public int RL()
  {
    int j = 0;
    int i = j;
    if (this.mExtra != null)
    {
      i = j;
      if (this.asi == 2)
      {
        j = this.mExtra.getInt("qq_sub_business_id");
        i = j;
        if (j == 0) {
          i = this.mExtra.getInt("sub_business_id");
        }
      }
    }
    return i;
  }
  
  public boolean aQA()
  {
    return (this.mExtra != null) && (this.mExtra.getBoolean("extra_photo_list_to_edit"));
  }
  
  public boolean aQz()
  {
    return (this.mExtra != null) && (this.mExtra.getBoolean("key_multi_edit_pic"));
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
  
  public <T extends Parcelable> T getParcelable(String paramString)
  {
    if (this.mExtra != null) {
      return this.mExtra.getParcelable(paramString);
    }
    return null;
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
    case 10: 
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
  
  public int tg()
  {
    int j = this.asi;
    int i = j;
    if (this.mExtra != null)
    {
      i = j;
      if (j == 2)
      {
        j = this.mExtra.getInt("qq_sub_business_id");
        i = j;
        if (j == 0) {
          return 2;
        }
      }
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
    return "EditVideoParams{mBusinessId=" + this.asi + ", mEnableMasks=" + this.aCQ + ", mEditSource=" + this.a + ", entranceType=" + th() + ", mExtra=" + this.mExtra + ", mFrom=" + this.mFrom + ", entryType=" + this.entryType + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.asi);
    paramParcel.writeLong(this.aCQ);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeBundle(this.mExtra);
    paramParcel.writeInt(this.eKf);
    paramParcel.writeInt(this.eKg);
    paramParcel.writeInt(this.mMode);
    paramParcel.writeInt(this.mFrom);
    paramParcel.writeInt(this.entryType);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */