import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.List;

class avfc
  extends asrs
{
  avfc(avfb paramavfb, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void aP(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle;
    if ((this.b.ja != null) && (this.b.ja.get() != null))
    {
      localBundle = new Bundle();
      if (!paramBoolean) {
        break label70;
      }
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_mic");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
    for (;;)
    {
      ((avfd)this.b.ja.get()).bX(localBundle);
      return;
      label70:
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_mic");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
  }
  
  public void aQ(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle;
    if ((this.b.ja != null) && (this.b.ja.get() != null))
    {
      localBundle = new Bundle();
      if (!paramBoolean) {
        break label70;
      }
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_open_speaker");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
    for (;;)
    {
      ((avfd)this.b.ja.get()).bX(localBundle);
      return;
      label70:
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_close_speaker");
      localBundle.putInt("gmesdk_event_ret", paramInt);
    }
  }
  
  public void bM(int paramInt, String paramString)
  {
    if ((paramInt == 0) || (paramInt == 1003)) {
      aveo.a().f(this.b.cKl, this.dmP, this.dmQ);
    }
    while ((this.b.ja == null) || (this.b.ja.get() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
    localBundle.putInt("gmesdk_event_ret", paramInt);
    localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
    ((avfd)this.b.ja.get()).bX(localBundle);
  }
  
  public void bN(int paramInt, String paramString)
  {
    if ((this.b.ja != null) && (this.b.ja.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_enterroom");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_eterroom_ret_msg", paramString);
      ((avfd)this.b.ja.get()).bX(localBundle);
    }
  }
  
  public void bO(int paramInt, String paramString)
  {
    if ((this.b.ja != null) && (this.b.ja.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_room_disconnect");
      localBundle.putInt("gmesdk_event_ret", paramInt);
      localBundle.putString("gmesdk_event_value_room_disconnect_ret_msg", paramString);
      ((avfd)this.b.ja.get()).bX(localBundle);
    }
  }
  
  public void f(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramInt = 0;
      String str;
      Bundle localBundle;
      while (paramInt < paramArrayOfString.length)
      {
        str = paramArrayOfString[paramInt];
        if ((this.b.ja != null) && (this.b.ja.get() != null))
        {
          localBundle = new Bundle();
          localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
          localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
          localBundle.putString("gmesdk_event_key_member_uin", str);
          ((avfd)this.b.ja.get()).bX(localBundle);
        }
        paramInt += 1;
      }
      continue;
      while (i < paramArrayOfString.length)
      {
        str = paramArrayOfString[i];
        if (!this.b.Ly.contains(str))
        {
          this.b.Ly.add(str);
          if ((this.b.ja != null) && (this.b.ja.get() != null))
          {
            localBundle = new Bundle();
            localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
            localBundle.putBoolean("gmesdk_event_key_member_speaking", true);
            localBundle.putString("gmesdk_event_key_member_uin", str);
            ((avfd)this.b.ja.get()).bX(localBundle);
          }
        }
        i += 1;
      }
      continue;
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        str = paramArrayOfString[paramInt];
        if (this.b.Ly.contains(str))
        {
          this.b.Ly.remove(str);
          if ((this.b.ja != null) && (this.b.ja.get() != null))
          {
            localBundle = new Bundle();
            localBundle.putString("gmesdk_event_key", "gmesdk_event_key_member_info");
            localBundle.putBoolean("gmesdk_event_key_member_speaking", false);
            localBundle.putString("gmesdk_event_key_member_uin", str);
            ((avfd)this.b.ja.get()).bX(localBundle);
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void onExitRoomComplete()
  {
    if ((this.b.ja != null) && (this.b.ja.get() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("gmesdk_event_key", "gmesdk_event_key_exit_room");
      ((avfd)this.b.ja.get()).bX(localBundle);
    }
  }
  
  public void onSemiAutoRecvCameraVideo(String[] paramArrayOfString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfc
 * JD-Core Version:    0.7.0.1
 */