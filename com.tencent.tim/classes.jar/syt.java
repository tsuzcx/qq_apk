import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.ProductInfo;

public final class syt
  implements Parcelable.Creator<ProductInfo>
{
  public ProductInfo a(Parcel paramParcel)
  {
    ProductInfo localProductInfo = new ProductInfo();
    localProductInfo.productId = paramParcel.readInt();
    localProductInfo.deviceType = paramParcel.readInt();
    localProductInfo.bindType = paramParcel.readInt();
    localProductInfo.supportMainMsgType = paramParcel.readInt();
    localProductInfo.supportFuncMsgType = paramParcel.readInt();
    localProductInfo.deviceName = paramParcel.readString();
    localProductInfo.uConnectType = paramParcel.readInt();
    localProductInfo.deviceOSType = paramParcel.readInt();
    localProductInfo.regType = paramParcel.readInt();
    localProductInfo.linkStateDesc = paramParcel.readString();
    localProductInfo.linkStepDesc = paramParcel.readString();
    localProductInfo.linkDescImg = paramParcel.readString();
    return localProductInfo;
  }
  
  public ProductInfo[] a(int paramInt)
  {
    return new ProductInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     syt
 * JD-Core Version:    0.7.0.1
 */