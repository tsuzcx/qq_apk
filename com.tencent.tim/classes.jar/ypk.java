import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ypk
{
  public String AI;
  public int friendType;
  public String friendUin;
  
  public boolean Ue()
  {
    return this.friendType != 1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ypk))
    {
      paramObject = (ypk)paramObject;
      return this.friendUin.equals(paramObject.friendUin);
    }
    return super.equals(paramObject);
  }
  
  @NonNull
  public String toString()
  {
    return "Face2FaceFriendInfo uin:" + this.friendUin + " nick:" + this.AI + " type:" + this.friendType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypk
 * JD-Core Version:    0.7.0.1
 */