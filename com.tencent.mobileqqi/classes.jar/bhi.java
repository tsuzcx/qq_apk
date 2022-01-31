import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.report.AVReport;

@SuppressLint({"HandlerLeak"})
public class bhi
  extends Handler
{
  public bhi(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    byte[] arrayOfByte1;
    long l;
    String str;
    for (;;)
    {
      byte[] arrayOfByte2;
      try
      {
        i = paramMessage.what;
        paramMessage = (bhj)paramMessage.obj;
        if (paramMessage == null) {
          return;
        }
        arrayOfByte1 = paramMessage.jdField_a_of_type_ArrayOfByte;
        l = paramMessage.jdField_a_of_type_Long;
        str = String.valueOf(paramMessage.jdField_b_of_type_Long);
        arrayOfByte2 = paramMessage.jdField_b_of_type_ArrayOfByte;
        switch (i)
        {
        case 17: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$000(this.a, i, paramMessage);
          break;
        case 3: 
          this.a.mEventListener.g(str);
        }
      }
      finally {}
      continue;
      if (l == 1L)
      {
        VcControllerImpl.access$102(this.a, true);
        label389:
        if (l <= 1000L) {
          break label471;
        }
        this.a.mfAudio2VideoFlag = true;
        if (l - 1000L != 1L) {
          break label459;
        }
        VcControllerImpl.access$102(this.a, true);
      }
      for (;;)
      {
        this.a.mEventListener.h(str);
        break;
        if (l != 0L) {
          break label389;
        }
        VcControllerImpl.access$102(this.a, false);
        break label389;
        label459:
        VcControllerImpl.access$102(this.a, false);
        continue;
        label471:
        this.a.mfAudio2VideoFlag = false;
      }
      if (!VcControllerImpl.access$200(this.a))
      {
        this.a.mEventListener.a(str, arrayOfByte1, (int)l, VcControllerImpl.access$300(this.a), VcControllerImpl.access$400(this.a), VcControllerImpl.access$500(this.a));
        continue;
        if (l == 1L) {
          this.a.mEventListener.a(str, arrayOfByte2, 1L);
        } else {
          this.a.mEventListener.a(str, arrayOfByte1, 0L);
        }
      }
    }
    for (;;)
    {
      this.a.mEventListener.a(str, i, paramMessage.c);
      break;
      this.a.mEventListener.n(str);
      break;
      this.a.mEventListener.a(str, 12, 0L);
      break;
      this.a.mEventListener.i(str);
      break;
      this.a.mEventListener.j(str);
      break;
      this.a.mEventListener.k(str);
      break;
      this.a.mEventListener.l(str);
      break;
      this.a.mEventListener.o(str);
      break;
      this.a.mEventListener.p(str);
      break;
      this.a.mEventListener.q(str);
      break;
      this.a.mEventListener.a(i - 19, str);
      break;
      this.a.mEventListener.a(str, true);
      break;
      this.a.mEventListener.a(str, false);
      break;
      this.a.mEventListener.c(true);
      break;
      this.a.mEventListener.c(false);
      break;
      if (AVReport.a().a) {
        AVReport.a().k = SystemClock.elapsedRealtime();
      }
      for (;;)
      {
        this.a.mEventListener.d(true);
        break;
        AVReport.a().z = SystemClock.elapsedRealtime();
      }
      this.a.mEventListener.d(arrayOfByte1, l);
      break;
      this.a.mEventListener.n();
      break;
      this.a.mEventListener.e(str, (int)l);
      break;
      this.a.mEventListener.b(str, arrayOfByte1, l);
      break;
      this.a.mEventListener.c(str, arrayOfByte1, l);
      break;
      break;
      i = (int)l;
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhi
 * JD-Core Version:    0.7.0.1
 */