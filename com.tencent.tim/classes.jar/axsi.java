import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.part.QIMTemplateItem;

public final class axsi
  implements Parcelable.Creator<QIMTemplateItem>
{
  public QIMTemplateItem a(Parcel paramParcel)
  {
    return new QIMTemplateItem(paramParcel);
  }
  
  public QIMTemplateItem[] a(int paramInt)
  {
    return new QIMTemplateItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsi
 * JD-Core Version:    0.7.0.1
 */