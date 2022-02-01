package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import ayey;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;

public class EditTakeGifSource
  extends EditLocalGifSource
{
  public static final Parcelable.Creator<EditTakeGifSource> CREATOR = new ayey();
  
  public EditTakeGifSource(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public EditTakeGifSource(String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    super(paramString, paramArrayList, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditTakeGifSource
 * JD-Core Version:    0.7.0.1
 */