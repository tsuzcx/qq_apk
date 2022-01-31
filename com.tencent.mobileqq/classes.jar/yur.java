import android.content.Context;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import java.lang.ref.WeakReference;

final class yur
  implements ArkViewImplement.LoadCallback
{
  yur(long paramLong, String paramString, WeakReference paramWeakReference, GdtInterstitialParams paramGdtInterstitialParams) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = yug.a(paramInt2);
    yxp.b("GdtInterstitialView", String.format("onLoadFailed state:%d duration:%d errCode:%d msg:%s canRetry:%b error:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
    yuq.a(i, paramInt2, this.jdField_a_of_type_JavaLangString);
    yyc.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, i, paramInt2);
  }
  
  public void onLoadState(int paramInt)
  {
    yxp.b("GdtInterstitialView", String.format("onLoadState state:%d duration:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
    if (paramInt == 1) {
      yyc.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, 0, -2147483648);
    }
    while (paramInt != -1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yur
 * JD-Core Version:    0.7.0.1
 */