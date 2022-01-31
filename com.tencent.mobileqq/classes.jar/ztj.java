import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.ProductNetLinkInfo;

public final class ztj
  implements Parcelable.Creator<ProductNetLinkInfo>
{
  public ProductNetLinkInfo a(Parcel paramParcel)
  {
    ProductNetLinkInfo localProductNetLinkInfo = new ProductNetLinkInfo();
    localProductNetLinkInfo.productId = paramParcel.readInt();
    localProductNetLinkInfo.linkResetVoiceDesc = paramParcel.readString();
    localProductNetLinkInfo.volumeUpTitleDesc = paramParcel.readString();
    localProductNetLinkInfo.volumeUpContentDesc = paramParcel.readString();
    localProductNetLinkInfo.volumeUpDescImg = paramParcel.readString();
    localProductNetLinkInfo.volumeUpVoiceDesc = paramParcel.readString();
    localProductNetLinkInfo.stopSoundWaveDesc1 = paramParcel.readString();
    localProductNetLinkInfo.stopSoundWaveDesc2 = paramParcel.readString();
    return localProductNetLinkInfo;
  }
  
  public ProductNetLinkInfo[] a(int paramInt)
  {
    return new ProductNetLinkInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ztj
 * JD-Core Version:    0.7.0.1
 */