import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.comment.DanmuItemBean;

public final class aeet
  implements Parcelable.Creator<DanmuItemBean>
{
  public DanmuItemBean a(Parcel paramParcel)
  {
    boolean bool = true;
    DanmuItemBean localDanmuItemBean = new DanmuItemBean();
    localDanmuItemBean.VS = paramParcel.readLong();
    localDanmuItemBean.VT = paramParcel.readLong();
    localDanmuItemBean.createTime = paramParcel.readLong();
    localDanmuItemBean.VU = paramParcel.readLong();
    localDanmuItemBean.content = paramParcel.readString();
    localDanmuItemBean.nickName = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localDanmuItemBean.bTv = bool;
      localDanmuItemBean.bwD = paramParcel.readString();
      localDanmuItemBean.cMq = paramParcel.readInt();
      return localDanmuItemBean;
      bool = false;
    }
  }
  
  public DanmuItemBean[] a(int paramInt)
  {
    return new DanmuItemBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeet
 * JD-Core Version:    0.7.0.1
 */