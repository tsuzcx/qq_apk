import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;

final class kgx
  implements adwr
{
  kgx(WeakReference paramWeakReference, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void co(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (kgw.access$000() == paramInt1)
    {
      adxf.a().oa(paramInt1);
      kgw.access$002(-1);
      if ((2 != paramInt2) && (1 != paramInt2)) {
        break label123;
      }
    }
    label123:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Context localContext = (Context)this.cd.get();
      Object localObject = localContext;
      if (localContext == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      if ((-1 == paramInt2) && (this.aeR) && (!TextUtils.isEmpty(this.Zi)) && (localObject != null)) {
        kxm.aM((Context)localObject, this.Zi);
      }
      localObject = this.Zj;
      if (this.aeR) {}
      for (paramInt2 = i;; paramInt2 = 0)
      {
        kxm.n((String)localObject, paramInt1, paramInt2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgx
 * JD-Core Version:    0.7.0.1
 */