import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGame.GameResultItem;

public final class aygj
  implements Parcelable.Creator<EditVideoGame.GameResultItem>
{
  public EditVideoGame.GameResultItem a(Parcel paramParcel)
  {
    return new EditVideoGame.GameResultItem(paramParcel);
  }
  
  public EditVideoGame.GameResultItem[] a(int paramInt)
  {
    return new EditVideoGame.GameResultItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygj
 * JD-Core Version:    0.7.0.1
 */