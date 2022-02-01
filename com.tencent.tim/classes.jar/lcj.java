import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class lcj
  implements lck.a
{
  lcj(lci paramlci) {}
  
  public int m(Bundle paramBundle)
  {
    int j = this.this$0.aNf;
    int i = -1;
    long l = System.currentTimeMillis();
    switch (this.this$0.aNf)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render CreateLoop:step[" + j + "] -> step[" + this.this$0.aNf + "] cost[" + (System.currentTimeMillis() - l) + "ms]" + " timestamps[" + System.currentTimeMillis() + "]");
      }
      kxm.a(kxm.getAppRuntime(), true, j, System.currentTimeMillis() - l);
      return i;
      i = this.this$0.d(paramBundle);
      continue;
      i = this.this$0.e(paramBundle);
      continue;
      i = this.this$0.f(paramBundle);
      continue;
      i = this.this$0.g(paramBundle);
      continue;
      i = this.this$0.h(paramBundle);
      continue;
      i = this.this$0.i(paramBundle);
      continue;
      i = this.this$0.j(paramBundle);
      continue;
      i = this.this$0.a(paramBundle);
      continue;
      i = this.this$0.k(paramBundle);
      continue;
      i = this.this$0.l(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcj
 * JD-Core Version:    0.7.0.1
 */