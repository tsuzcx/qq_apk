import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class advt
  implements advm.a
{
  advt(advr paramadvr) {}
  
  public void ei(String paramString, int paramInt) {}
  
  public void j(String arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onDownloadFinish url: " + ??? + " isSuccess: " + paramBoolean1 + " isFileExist: " + paramBoolean2);
    }
    if (TextUtils.isEmpty(???)) {
      return;
    }
    int i;
    synchronized (this.this$0.uV)
    {
      i = this.this$0.uV.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.this$0.uV.get(i);
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          this.this$0.uV.remove(i);
        }
        else if (???.equals(((aqcy)((WeakReference)this.this$0.uV.get(i)).get()).mUrl))
        {
          localWeakReference = (WeakReference)this.this$0.uV.remove(i);
          if (paramBoolean1)
          {
            this.this$0.uU.add(localWeakReference);
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish add to wait play list.");
            }
          }
        }
      }
    }
    if (!aqcy.cTz) {
      synchronized (this.this$0.uW)
      {
        i = this.this$0.uW.size() - 1;
        label257:
        if (i >= 0) {
          if ((this.this$0.uW.get(i) != null) && (((WeakReference)this.this$0.uW.get(i)).get() != null))
          {
            ??? = (WeakReference)this.this$0.uW.get(i);
            label314:
            if ((??? != null) && (???.get() != null)) {
              this.this$0.a((aqcy)???.get(), false, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.this$0.uT)
      {
        i = this.this$0.uT.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.this$0.uT.get(i)).get() == null) {
            this.this$0.uT.remove(i);
          }
          i -= 1;
          continue;
          this.this$0.uW.remove(i);
          i -= 1;
          break label257;
          ??? = finally;
          throw ???;
        }
        i = this.this$0.uU.size() - 1;
        if (i < 0) {
          break label695;
        }
        ??? = (WeakReference)this.this$0.uU.get(i);
        if ((??? == null) || (((WeakReference)???).get() == null))
        {
          this.this$0.uU.remove(i);
        }
        else if (this.this$0.uT.size() < advr.a(this.this$0).cKl)
        {
          this.this$0.uU.remove(i);
          if (this.this$0.uT.contains(???)) {
            break label712;
          }
          paramBoolean1 = this.this$0.a((aqcy)((WeakReference)???).get());
          if (paramBoolean1) {
            this.this$0.uT.add(???);
          }
          if (!QLog.isColorLevel()) {
            break label712;
          }
          QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 result : " + paramBoolean1 + " playing size: " + this.this$0.uT.size());
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 beyond maxPlayingCount : " + advr.a(this.this$0).cKl);
        break label712;
        label695:
        return;
        ??? = null;
        break label314;
        i -= 1;
        break;
      }
      label712:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advt
 * JD-Core Version:    0.7.0.1
 */