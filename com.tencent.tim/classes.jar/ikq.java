import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class ikq
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        long l1;
        int i;
        long l2;
        boolean bool;
        do
        {
          do
          {
            do
            {
              return false;
            } while (ikp.access$000() == null);
            ikp.reportMemory();
            ikp.r(24, ikp.getDuration());
            try
            {
              ikp.access$000().sendEmptyMessageDelayed(1, 5000L);
              return false;
            }
            catch (NullPointerException paramMessage)
            {
              paramMessage.printStackTrace();
              return false;
            }
            l1 = localBundle.getLong("roomId");
            i = localBundle.getInt("node");
            l2 = localBundle.getLong("value");
            bool = localBundle.getBoolean("isNode");
            ikp.A(i, true);
          } while (ikp.a(i, true, bool));
          if ((bool) && (ikp.g(33, true)))
          {
            igd.aI("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + iko.aJ(i));
            return false;
          }
          ikp.l(i + "", l2 + "", bool);
          ikp.e(i, l2, true);
          igd.aI("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + iko.aJ(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          ikp.A(i, false);
        } while (ikp.a(i, false, bool));
        if ((bool) && (ikp.g(33, false)))
        {
          igd.aI("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + iko.aJ(i));
          return false;
        }
        if (ikp.access$200(i)) {
          igd.aH("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + iko.aJ(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        ikp.m(i + "", l2 + "", bool);
        ikp.e(i, l2, false);
        return false;
        paramMessage = ikp.access$400();
        if (!TextUtils.isEmpty(paramMessage))
        {
          igd.aH("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          annx.o(null, "dc03209", paramMessage);
          ikp.anv();
        }
      } while ((ikp.access$500() == null) || (ikp.access$500().size() == 0));
      ikp.anA();
      return false;
      paramMessage = ikp.access$600();
      igd.aI("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    annx.o(null, "dc03209", paramMessage);
    ikp.anw();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikq
 * JD-Core Version:    0.7.0.1
 */