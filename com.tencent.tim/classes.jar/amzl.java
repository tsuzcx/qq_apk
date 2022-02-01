import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.search.view.SearchVoiceView;
import com.tencent.mobileqq.search.view.SearchVoiceView.a;
import com.tencent.qphone.base.util.QLog;

public class amzl
  implements Handler.Callback
{
  public amzl(SearchVoiceView paramSearchVoiceView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 3;
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      SearchVoiceView.a(this.a, 0);
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.a(this.a) > 0) {
        SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      }
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.d(this.a) > 0) {
        SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.c(this.a));
      }
      this.a.dEl -= SearchVoiceView.e(this.a) * 3;
      if (this.a.dEl < SearchVoiceView.f(this.a) * 9 / 10) {
        this.a.dEl = (SearchVoiceView.f(this.a) * 9 / 10);
      }
      this.a.invalidate();
      SearchVoiceView.a(this.a).removeMessages(0);
      SearchVoiceView.a(this.a).sendEmptyMessageDelayed(0, 30L);
      continue;
      SearchVoiceView.a(this.a, 1);
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.a(this.a) > 0) {
        SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      }
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.d(this.a) > 0) {
        SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.c(this.a));
      }
      if (this.a.dEl < SearchVoiceView.g(this.a))
      {
        this.a.dEl += SearchVoiceView.e(this.a);
        label438:
        if (this.a.dEl >= SearchVoiceView.f(this.a) / 10) {
          break label567;
        }
        this.a.dEl = (SearchVoiceView.f(this.a) / 10);
      }
      for (;;)
      {
        this.a.invalidate();
        SearchVoiceView.a(this.a).removeMessages(0);
        SearchVoiceView.a(this.a).removeMessages(1);
        SearchVoiceView.a(this.a).sendEmptyMessageDelayed(1, 30L);
        break;
        if (this.a.dEl <= SearchVoiceView.g(this.a)) {
          break label438;
        }
        this.a.dEl -= SearchVoiceView.e(this.a) * 6;
        break label438;
        label567:
        if (this.a.dEl > SearchVoiceView.f(this.a) * 9 / 10) {
          this.a.dEl = (SearchVoiceView.f(this.a) * 9 / 10);
        }
      }
      SearchVoiceView.a(this.a, 2);
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.a(this.a) > 0) {
        SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      }
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) + SearchVoiceView.b(this.a));
      if (SearchVoiceView.d(this.a) > 0) {
        SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.c(this.a));
      }
      this.a.dEl += SearchVoiceView.e(this.a) * 4;
      if (QLog.isDevelopLevel()) {
        QLog.i("SearchVoiceView", 2, " handle state = " + SearchVoiceView.h(this.a) + " frontOffsetY = " + this.a.dEl + " height = " + SearchVoiceView.f(this.a));
      }
      SearchVoiceView.a(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a) / 5.0F);
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.e(this.a));
      SearchVoiceView.a(this.a, (SearchVoiceView.a(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.b(this.a, (SearchVoiceView.d(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.c(this.a, (SearchVoiceView.f(this.a) + 360.0F) % 360.0F);
      if (this.a.dEl >= SearchVoiceView.f(this.a)) {}
      long l2;
      long l1;
      for (;;)
      {
        this.a.invalidate();
        SearchVoiceView.a(this.a).removeMessages(0);
        SearchVoiceView.a(this.a).removeMessages(1);
        SearchVoiceView.a(this.a).removeMessages(2);
        int j = 15;
        if (SearchVoiceView.a(this.a) != 0L)
        {
          l2 = SystemClock.uptimeMillis() - SearchVoiceView.a(this.a);
          l1 = l2;
          if (l2 > 30L) {
            l1 = 0L;
          }
          j = (int)l1;
        }
        SearchVoiceView.a(this.a, SystemClock.uptimeMillis());
        SearchVoiceView.a(this.a).sendEmptyMessageDelayed(i, j);
        break;
        SearchVoiceView.a(this.a, 0L);
        i = 2;
      }
      SearchVoiceView.a(this.a, 3);
      SearchVoiceView.a(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a) / 5.0F);
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.e(this.a));
      SearchVoiceView.a(this.a, (SearchVoiceView.a(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.b(this.a, (SearchVoiceView.d(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.c(this.a, (SearchVoiceView.f(this.a) + 360.0F) % 360.0F);
      this.a.invalidate();
      SearchVoiceView.a(this.a).removeMessages(0);
      SearchVoiceView.a(this.a).removeMessages(1);
      SearchVoiceView.a(this.a).removeMessages(2);
      SearchVoiceView.a(this.a).removeMessages(3);
      i = 30;
      if (SearchVoiceView.a(this.a) != 0L)
      {
        l2 = SystemClock.uptimeMillis() - SearchVoiceView.a(this.a);
        l1 = l2;
        if (l2 > 30L) {
          l1 = 0L;
        }
        i = (int)l1;
      }
      SearchVoiceView.a(this.a, SystemClock.uptimeMillis());
      SearchVoiceView.a(this.a).sendEmptyMessageDelayed(3, i);
      continue;
      SearchVoiceView.a(this.a, 4);
      SearchVoiceView.a(this.a, SearchVoiceView.a(this.a) + SearchVoiceView.b(this.a) / 2.0F);
      SearchVoiceView.d(this.a, SearchVoiceView.g(this.a) - SearchVoiceView.h(this.a) / 2.0F + 2.0F);
      SearchVoiceView.e(this.a, SearchVoiceView.c(this.a) - SearchVoiceView.i(this.a));
      SearchVoiceView.b(this.a, SearchVoiceView.a(this.a) - SearchVoiceView.c(this.a));
      SearchVoiceView.f(this.a, SearchVoiceView.c(this.a) - SearchVoiceView.j(this.a));
      SearchVoiceView.c(this.a, SearchVoiceView.d(this.a) - SearchVoiceView.e(this.a));
      SearchVoiceView.a(this.a, (SearchVoiceView.a(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.b(this.a, (SearchVoiceView.d(this.a) + 360.0F) % 360.0F);
      SearchVoiceView.c(this.a, (SearchVoiceView.f(this.a) + 360.0F) % 360.0F);
      if (SearchVoiceView.g(this.a) <= 0.0F)
      {
        SearchVoiceView.d(this.a, 0.0F);
        SearchVoiceView.d(this.a, 0);
      }
      for (i = 5;; i = 4)
      {
        this.a.invalidate();
        SearchVoiceView.a(this.a).removeMessages(0);
        SearchVoiceView.a(this.a).removeMessages(1);
        SearchVoiceView.a(this.a).removeMessages(2);
        SearchVoiceView.a(this.a).removeMessages(3);
        SearchVoiceView.a(this.a).removeMessages(4);
        SearchVoiceView.a(this.a).sendEmptyMessageDelayed(i, 15L);
        break;
        SearchVoiceView.d(this.a, (int)(255.0F * (1.0F - SearchVoiceView.g(this.a) / 360.0F)));
      }
      SearchVoiceView.a(this.a, 5);
      this.a.invalidate();
      SearchVoiceView.a(this.a).removeMessages(0);
      SearchVoiceView.a(this.a).removeMessages(1);
      SearchVoiceView.a(this.a).removeMessages(2);
      SearchVoiceView.a(this.a).removeMessages(3);
      SearchVoiceView.a(this.a).removeMessages(4);
      if (SearchVoiceView.a(this.a) != null) {
        SearchVoiceView.a(this.a).onStateEnd();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzl
 * JD-Core Version:    0.7.0.1
 */