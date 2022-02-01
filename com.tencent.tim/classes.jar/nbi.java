import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class nbi
  extends nbg
  implements nbk.a
{
  private final String TAG = "ReadInjoyPlayer<" + Integer.toHexString(hashCode()) + ">";
  public nbk a;
  private int mBusiType;
  private String mUrl;
  private String mVid;
  
  public nbi(int paramInt)
  {
    super(BaseApplicationImpl.getContext());
    this.a = new nbk(paramInt, this);
    a(this.a);
  }
  
  private void G(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    f(paramString, 1, paramLong);
  }
  
  private boolean J(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(this.mVid);
    boolean bool2 = TextUtils.isEmpty(this.mUrl);
    int i;
    int j;
    if ((!bool1) || (!bool2))
    {
      i = 1;
      if ((!bool1) && (!this.mVid.equals(paramString1))) {
        break label89;
      }
      j = 1;
      label49:
      if ((!bool2) && (!this.mUrl.equals(paramString2))) {
        break label95;
      }
    }
    label89:
    label95:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) || (j == 0) || (k == 0)) {
        break label101;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label49;
    }
    label101:
    return false;
  }
  
  private void e(String paramString, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramString, 101, paramLong, paramInt);
  }
  
  private void f(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    kxv.a().a(paramString, "PubAccountArticleCenter.GetUrlByVid", new nbj(this, paramString, paramLong, paramInt));
  }
  
  private void g(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    a(paramString, paramString, 101, paramLong, paramInt);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    this.mVid = paramString1;
    this.mUrl = paramString2;
    this.mBusiType = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "openByBusiType: vid=" + paramString1 + ", url=" + paramString2 + ", busiType=" + paramInt1);
    }
    if (nbe.dZ(paramInt1))
    {
      G(paramString1, paramLong);
      return;
    }
    if ((paramInt1 == 2) || ((paramInt1 == 6) && (!TextUtils.isEmpty(paramString1))))
    {
      f(paramString1, paramLong, paramInt2);
      return;
    }
    if (paramInt1 == 5)
    {
      g(paramString1, paramLong, paramInt2);
      return;
    }
    e(paramString2, paramLong, paramInt2);
  }
  
  public void c(mhu parammhu)
  {
    parammhu.busiType = this.mBusiType;
    parammhu.videoWidth = getVideoWidth();
    parammhu.videoHeight = getVideoHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbi
 * JD-Core Version:    0.7.0.1
 */