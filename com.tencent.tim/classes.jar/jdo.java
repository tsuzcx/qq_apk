import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jdo
  extends jdl
{
  private int axo;
  
  public jdo(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.axo = ((int)aqho.convertDpToPixel(paramContext, 100.0F));
  }
  
  public void a(iiv paramiiv, izm[] paramArrayOfizm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.mContext == null) {
      return;
    }
    paramArrayOfizm[0].setPaddings(0, 0, 0, 0);
    paramArrayOfizm[0].layout(0, 0, paramInt1, paramInt2);
    paramArrayOfizm[0].setBackgroundColor(-15197410);
    int i;
    if (paramiiv.anb == 2)
    {
      paramArrayOfizm[0].f(Boolean.valueOf(false));
      paramArrayOfizm[1].f(Boolean.valueOf(true));
      paramArrayOfizm[2].f(Boolean.valueOf(true));
      paramArrayOfizm[3].f(Boolean.valueOf(true));
      paramArrayOfizm[4].f(Boolean.valueOf(true));
      if ((!paramArrayOfizm[0].wf()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfizm[0].wj())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfizm[0].setPaddings(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(2131298196));
      }
    }
    else
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131299733);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.mContext.getResources().getDimensionPixelSize(2131299734);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfizm[1].getBounds().left;
        paramInt2 = paramArrayOfizm[1].getBounds().right;
        label244:
        paramArrayOfizm[1].layout(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfizm[2].getBounds().left;
        paramInt1 = paramArrayOfizm[2].getBounds().right;
        label283:
        paramArrayOfizm[2].layout(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfizm[3].getBounds().left;
        paramInt2 = paramArrayOfizm[3].getBounds().right;
        label322:
        paramArrayOfizm[3].layout(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfizm[4].getBounds().left;
        paramInt1 = paramArrayOfizm[4].getBounds().right;
      }
      for (;;)
      {
        paramArrayOfizm[4].layout(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfizm[1].setBackgroundColor(-15197410);
        paramArrayOfizm[2].setBackgroundColor(-15197410);
        paramArrayOfizm[3].setBackgroundColor(-15197410);
        paramArrayOfizm[4].setBackgroundColor(-15197410);
        paramArrayOfizm[1].setPaddings(2, 3, 3, 3);
        paramArrayOfizm[2].setPaddings(2, 3, 2, 3);
        paramArrayOfizm[3].setPaddings(2, 3, 2, 3);
        paramArrayOfizm[4].setPaddings(3, 3, 2, 3);
        return;
        paramArrayOfizm[0].setPaddings(0, this.mContext.getResources().getDimensionPixelSize(2131298196), 0, 0);
        break;
        label471:
        paramArrayOfizm[0].setPaddings(0, 0, 0, 0);
        break;
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break label244;
        label501:
        paramInt2 = paramInt1 - k;
        break label283;
        label510:
        paramInt1 = paramInt2 - k;
        break label322;
        paramInt2 = paramInt1 - k;
      }
    }
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
        QLog.w("OriginScreenLayout", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.axo + "]");
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
    return 1;
  }
  
  public boolean wD()
  {
    iya.d locald = new iya.d(null);
    if (this.mApp != null)
    {
      this.mApp.l(new Object[] { Integer.valueOf(8004), locald });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + locald.Wa + "], mBlockName[" + locald.Rj + "]");
      }
    }
    return !locald.Wa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdo
 * JD-Core Version:    0.7.0.1
 */