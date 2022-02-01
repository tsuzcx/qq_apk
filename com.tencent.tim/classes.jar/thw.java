import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import java.lang.ref.WeakReference;

final class thw
  implements ArkViewImplement.LoadCallback
{
  thw(long paramLong, String paramString, WeakReference paramWeakReference) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int j = thl.ew(paramInt2);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    tkw.i("GdtInterstitialView", String.format("onLoadFailed state:%d duration:%d errCode:%d msg:%s canRetry:%b error:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - this.Eq), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
    thv.s(i, paramInt2, this.aJp);
    if ((this.dx.get() != null) && (!((GdtInterstitialStatus)this.dx.get()).aPd)) {
      ((GdtInterstitialStatus)this.dx.get()).aPd = true;
    }
  }
  
  public void onLoadState(int paramInt)
  {
    tkw.i("GdtInterstitialView", String.format("onLoadState state:%d duration:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - this.Eq) }));
    if (paramInt == 1) {
      if ((this.dx.get() != null) && (!((GdtInterstitialStatus)this.dx.get()).aPd))
      {
        ((GdtInterstitialStatus)this.dx.get()).aPd = true;
        ((GdtInterstitialStatus)this.dx.get()).aPc = true;
      }
    }
    while (paramInt != -1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thw
 * JD-Core Version:    0.7.0.1
 */