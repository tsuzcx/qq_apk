import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class jkq
{
  public static int a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString))) {
      return paramVideoAppInterface.aj(paramString);
    }
    return VideoController.a(paramInt1, false, paramInt2);
  }
  
  public static String a(ihk.a parama)
  {
    long l = parama.la;
    switch (parama.amc)
    {
    default: 
      return String.valueOf(l);
    }
    return parama.MD + parama.MC;
  }
  
  public static void a(Intent paramIntent, iiv paramiiv)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramiiv.senderUin);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    paramIntent.putExtra("uinType", paramiiv.uinType);
    paramIntent.putExtra("peerUin", paramiiv.senderUin);
    paramIntent.putExtra("friendUin", l1);
    paramIntent.putExtra("relationType", paramiiv.relationType);
    paramIntent.putExtra("MultiAVType", paramiiv.anb);
    paramIntent.putExtra("discussId", paramiiv.ll);
    paramIntent.putExtra("memberList", paramiiv.f);
  }
  
  public static void a(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface, ihk.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "showInviteNotification videoPacket[" + parama + "], session[" + paramString2 + "], from[" + paramString1 + "]");
    }
    paramString1 = String.valueOf(parama.kY);
    int i = a(paramVideoAppInterface, parama.amc, paramString1, 0);
    String str = a(parama);
    boolean bool;
    int j;
    if (parama.amb == 1)
    {
      bool = true;
      j = parama.ama;
    }
    for (;;)
    {
      try
      {
        if (paramVideoAppInterface.b().a(i, paramString1, str, null, bool, null, 0, j)) {
          break label145;
        }
        QLog.w("CompatModeTag", 1, "showNotification() return ! isRequestVideo = false");
        return;
      }
      catch (Exception paramString1)
      {
        QLog.w("CompatModeTag", 1, "showNotification() return ! Exception = ", paramString1);
        return;
      }
      bool = false;
      break;
      label145:
      Object localObject = jko.a(paramVideoAppInterface);
      Bitmap localBitmap = paramVideoAppInterface.a(i, paramString1, str, true, true);
      paramVideoAppInterface = paramVideoAppInterface.getDisplayName(i, paramString1, str);
      if (jjc.xA()) {
        if (bool) {
          ((jko)localObject).a(true, paramString2, paramVideoAppInterface, localBitmap, null, 45, i, 1, null);
        }
      }
      while (QLog.isColorLevel())
      {
        localObject = new StringBuilder(200);
        ((StringBuilder)localObject).append("showNotification, isAudioMode=").append(bool).append(", sessionId=").append(paramString2).append(", uinType=").append(i).append(", peerUin=").append(paramString1).append(", extraUin=").append(str).append(", face=").append(localBitmap).append(", peerName=").append(paramVideoAppInterface).append(", videoPacket=").append(parama);
        QLog.i("CompatModeTag", 2, ((StringBuilder)localObject).toString());
        return;
        ((jko)localObject).a(true, paramString2, paramVideoAppInterface, localBitmap, null, 40, i, 2, null);
        continue;
        if (bool) {
          ((jko)localObject).a(false, paramString2, paramVideoAppInterface, localBitmap, null, 45, i, 1);
        } else {
          ((jko)localObject).a(false, paramString2, paramVideoAppInterface, localBitmap, null, 40, i, 2);
        }
      }
    }
  }
  
  public static void b(Intent paramIntent, iiv paramiiv)
  {
    paramIntent.putExtra("uinType", paramiiv.uinType);
    paramIntent.putExtra("relationType", jll.cL(paramiiv.uinType));
    paramIntent.putExtra("peerUin", paramiiv.peerUin);
    paramIntent.putExtra("extraUin", paramiiv.MP);
    paramIntent.putExtra("isAudioMode", paramiiv.QE);
    paramIntent.putExtra("isDoubleVideoMeeting", paramiiv.Qw);
    paramIntent.putExtra("bindType", paramiiv.bindType);
  }
  
  public static Intent c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = igv.a().c(paramString);
    } while (paramString == null);
    try
    {
      paramContext = new Intent(paramContext, GaInviteLockActivity.class);
      paramContext.addFlags(268435456);
      a(paramContext, paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.i("QAVNotificationUtil", 1, "getGroupInviteIntent error", paramContext);
        paramContext = null;
      }
    }
  }
  
  public static Intent d(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, MultiIncomingCallsActivity.class);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramContext;
      paramString = igv.a().c(paramString);
    } while (paramString == null);
    paramContext.putExtra("sessionType", paramString.amI);
    if (jjc.co(paramString.uinType))
    {
      a(paramContext, paramString);
      return paramContext;
    }
    b(paramContext, paramString);
    return paramContext;
  }
  
  public static boolean o(Intent paramIntent)
  {
    boolean bool2 = false;
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("Fromwhere");
    }
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (str.compareTo("AVNotification") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkq
 * JD-Core Version:    0.7.0.1
 */