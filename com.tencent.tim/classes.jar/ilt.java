import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.chatroom.ChatRoomInfo;

public final class ilt
  implements Parcelable.Creator<ChatRoomInfo>
{
  public ChatRoomInfo a(Parcel paramParcel)
  {
    return new ChatRoomInfo(paramParcel);
  }
  
  public ChatRoomInfo[] a(int paramInt)
  {
    return new ChatRoomInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilt
 * JD-Core Version:    0.7.0.1
 */