import android.content.Context;
import com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView;
import com.tencent.mobileqq.richmedia.capture.view.FilterProviderView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alxe
{
  public static final int[] mR = { 101, 2130846831 };
  public static final int[] mS = { 102, 2130846834 };
  public static final int[] mT = { 103, 2130846830 };
  public static final int[] mU = { 104, 2130846837 };
  public boolean cAi = true;
  public boolean cAj = true;
  public boolean cAk = true;
  public boolean cAl = true;
  private int mType = 0;
  private ArrayList<int[]> uB = new ArrayList();
  
  public alxe(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void TK(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {}
    do
    {
      return;
      paramInt = ((int[])this.uB.get(paramInt))[0];
      if (paramInt == 101)
      {
        alwh.a().I(1, 0, "");
        return;
      }
    } while (paramInt != 102);
    alwd.a().I(1, 0, "");
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        paramContext = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        if (this.mType != 0) {
          break;
        }
        paramContext.setTabBarPosition(2);
      }
      return paramContext;
      paramContext = new FilterProviderView(paramContext, this.mType);
      paramContext.setId(2131364259);
      continue;
      paramContext = new PtvTemplateProviderView(paramContext);
      continue;
      paramContext = new BeautyProviderView(paramContext);
      continue;
      paramContext = new SubtitleProviderView(paramContext);
    }
    paramContext.setTabBarPosition(1);
    if (paramContext.ava())
    {
      paramContext.TZ(213);
      return paramContext;
    }
    paramContext.TZ(249);
    return paramContext;
  }
  
  public int iQ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {
      return -1;
    }
    return ((int[])this.uB.get(paramInt))[0];
  }
  
  public int iR(int paramInt)
  {
    int i = 0;
    while (i < this.uB.size())
    {
      if (((int[])this.uB.get(i))[0] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.cAi = paramBoolean;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.cAk = paramBoolean;
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.cAj = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.cAl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxe
 * JD-Core Version:    0.7.0.1
 */