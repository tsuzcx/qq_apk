import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class aebv
  extends BroadcastReceiver
{
  aebv(aebu paramaebu) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          int j;
          for (;;)
          {
            return;
            ??? = paramIntent.getAction();
            if (!TextUtils.isEmpty(???))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ColorNoteQIPCModule", 1, "action receive: " + ???);
              }
              if (???.equals("key_float_window_position"))
              {
                i = paramIntent.getIntExtra("key_float_window_position_x", 0);
                j = paramIntent.getIntExtra("key_float_window_position_y", 0);
                synchronized (aebu.access$000())
                {
                  aebu.a(this.b).set(i, j);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("ColorNoteQIPCModule", 1, "KEY_FLOAT_WINDOW_POSITION receive: " + i + ", " + j);
                    return;
                  }
                }
              }
            }
          }
          if (!???.equals("key_delete_item_call")) {
            break;
          }
          aebu.a(this.b, paramIntent.getBooleanExtra("extra_can_add_colornote", true));
          ??? = paramIntent.getStringArrayExtra("key_color_note_servicetype_list");
          paramIntent = paramIntent.getStringArrayExtra("key_color_note_suptype_list");
          if ((aebu.a(this.b) != null) && (??? != null) && (paramIntent != null) && (???.length == paramIntent.length))
          {
            i = 0;
            for (;;)
            {
              if ((paramIntent != null) && (i < paramIntent.length)) {
                try
                {
                  j = Integer.valueOf(???[i]).intValue();
                  if (j != -1)
                  {
                    aeaz.b localb = (aeaz.b)aebu.a(this.b).get();
                    if (localb != null) {
                      localb.onDeleteColorNote(j, paramIntent[i], false);
                    }
                  }
                  i += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    QLog.e("ColorNoteQIPCModule", 2, "integer cast error", localException);
                    j = -1;
                  }
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        aebs.fv("ColorNoteQIPCModule", "[onReceive->ACTION_DELETE_ITEM_CALL]\n[mCanAddColorNote]: " + aebu.a(this.b) + "\n");
        return;
      } while ((!???.equals("key_after_sync_msg")) || (aebu.b(this.b) == null));
      ??? = (aeeg)aebu.b(this.b).get();
    } while (??? == null);
    boolean bool = paramIntent.getBooleanExtra("extra_after_sync_msg", true);
    ???.onServiceSyncSucc(bool);
    this.b.Hg(bool);
    QLog.d("ColorNoteQIPCModule", 1, "invoke listener: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebv
 * JD-Core Version:    0.7.0.1
 */