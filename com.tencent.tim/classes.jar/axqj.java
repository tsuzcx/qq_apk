import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public final class axqj
  implements Parcelable.Creator<QIMFilterCategoryItem>
{
  public QIMFilterCategoryItem a(Parcel paramParcel)
  {
    return new QIMFilterCategoryItem(paramParcel);
  }
  
  public QIMFilterCategoryItem[] a(int paramInt)
  {
    return new QIMFilterCategoryItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqj
 * JD-Core Version:    0.7.0.1
 */