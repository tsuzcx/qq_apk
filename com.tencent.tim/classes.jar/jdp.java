import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class jdp
  extends jdl
{
  private int axo;
  
  public jdp(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.axo = ((int)aqho.convertDpToPixel(paramContext, 100.0F));
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, jfj> paramConcurrentHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(iiv paramiiv, izm[] paramArrayOfizm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.mContext == null) {}
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.mContext == null) {}
    while (paramArrayOfizm == null) {
      return;
    }
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131299735);
    int i2 = this.mContext.getResources().getDimensionPixelSize(2131299732);
    int m = this.mContext.getResources().getDimensionPixelSize(2131299733);
    int i = this.mContext.getResources().getDimensionPixelSize(2131299734);
    if (paramInt5 == 0) {
      i = m;
    }
    for (;;)
    {
      int j;
      int k;
      switch (paramInt1)
      {
      default: 
        j = 0;
        k = 0;
        m = 0;
        i = n;
      }
      for (;;)
      {
        paramArrayOfizm[1].layout(m, k, j, i);
        ild.by(i2, i1);
        ild.bx(m, k);
        ild.kV(paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("ScreenLayoutSliderWindow", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.axo + "]");
        return;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
      }
    }
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfizm[0].setPaddings(0, 0, 0, 0);
    paramArrayOfizm[0].layout(0, 0, paramInt1, paramInt2);
    paramArrayOfizm[0].setBackgroundColor(-15197410);
    paramArrayOfizm[1].setPaddings(3, 3, 3, 3);
    paramArrayOfizm[1].setBackgroundColor(-15197410);
    a(paramArrayOfizm, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public int getStyle()
  {
    return 4;
  }
  
  public boolean wD()
  {
    iya.d locald = new iya.d(null);
    if (this.mApp != null)
    {
      this.mApp.l(new Object[] { Integer.valueOf(8004), locald });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + locald.Wa + "], mBlockName[" + locald.Rj + "]");
      }
    }
    return !locald.Wa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdp
 * JD-Core Version:    0.7.0.1
 */