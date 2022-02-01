import android.view.MotionEvent;
import com.tencent.av.ui.chatroom.VideoChatRoomListView.a;

class jge
  implements VideoChatRoomListView.a
{
  jge(jfz paramjfz) {}
  
  public boolean b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a.xh()) {
        break label23;
      }
      this.a.avY();
    }
    for (;;)
    {
      return false;
      label23:
      if (this.a.xg()) {
        this.a.avV();
      } else if (jfz.a(this.a) != null) {
        jfz.a(this.a).z(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jge
 * JD-Core Version:    0.7.0.1
 */