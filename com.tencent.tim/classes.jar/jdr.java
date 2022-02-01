import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jdr
  extends jdl
{
  protected Display mDisplay;
  
  protected jdr(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public void a(iiv paramiiv, izm[] paramArrayOfizm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.mContext == null) {
      return;
    }
    int i = this.mContext.getResources().getDimensionPixelSize(2131299733);
    if (paramInt4 != 0) {}
    for (paramInt3 = this.mContext.getResources().getDimensionPixelSize(2131299734);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfizm[1].getBounds().left;
        paramInt2 = paramArrayOfizm[1].getBounds().right;
        paramArrayOfizm[1].layout(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label320;
        }
        paramInt2 = paramArrayOfizm[2].getBounds().left;
        paramInt1 = paramArrayOfizm[2].getBounds().right;
        label139:
        paramArrayOfizm[2].layout(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label329;
        }
        paramInt1 = paramArrayOfizm[3].getBounds().left;
        paramInt2 = paramArrayOfizm[3].getBounds().right;
        label178:
        paramArrayOfizm[3].layout(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label338;
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
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break;
        label320:
        paramInt2 = paramInt1 - k;
        break label139;
        label329:
        paramInt1 = paramInt2 - k;
        break label178;
        label338:
        paramInt2 = paramInt1 - k;
      }
    }
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout position: " + paramInt1);
    }
    if (this.mContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    this.mContext.getResources().getDimensionPixelSize(2131299735);
    this.mContext.getResources().getDimensionPixelSize(2131299732);
    this.mContext.getResources().getDimensionPixelSize(2131299733);
    this.mContext.getResources().getDimensionPixelSize(2131299734);
    int m;
    int k;
    int i;
    int j;
    if (this.mDisplay.getRotation() % 2 == 0)
    {
      m = this.mContext.getResources().getDimensionPixelSize(2131298330);
      k = this.mContext.getResources().getDimensionPixelSize(2131298327);
      i = this.mContext.getResources().getDimensionPixelSize(2131298328);
      j = this.mContext.getResources().getDimensionPixelSize(2131298329);
      if (paramInt5 != 0) {
        break label450;
      }
      j = i;
    }
    label450:
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = 0;
        paramInt3 = 0;
        i = 0;
        paramInt1 = n;
      }
      for (;;)
      {
        paramArrayOfizm[1].layout(i, paramInt3, paramInt2, paramInt1);
        ild.jb("setSmallVideoViewLayout " + m + "|" + k);
        return;
        m = this.mContext.getResources().getDimensionPixelSize(2131298327);
        k = this.mContext.getResources().getDimensionPixelSize(2131298330);
        i = this.mContext.getResources().getDimensionPixelSize(2131298329);
        j = this.mContext.getResources().getDimensionPixelSize(2131298328);
        break;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        paramInt2 = i + m;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt2 = i + m;
        paramInt1 = paramInt3 + k;
      }
    }
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdr
 * JD-Core Version:    0.7.0.1
 */