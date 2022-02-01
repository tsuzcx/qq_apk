import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.qq.im.capture.view.SpeedProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import java.util.ArrayList;

public class axwg
{
  public static final int[] mR = { 101, 2130850655, 2130850655, 2131374658 };
  public static final int[] mS = { 102, 2130850657, 2130850657, 2131374662 };
  public static final int[] tZ = { 108, 2130850654, 2130850654, 2131374657 };
  public static final int[] ua = { 103, 2130850658, 2130850658, 2131374661 };
  public static final int[] ub = { 104, 2130850656, 2130850656, 2131374659 };
  public static final int[] uc = { 105, 2130850653, 2130850653, 2131374656 };
  public static final int[] ud = { 107, 2130845405, 2130845405, 2131374660 };
  public static final int[] ue = { 112, 2130845409, 2130845409, 2131374663 };
  public static final int[] uf = { 104 };
  public boolean cAi = true;
  public boolean cAj = true;
  public boolean cAk = true;
  public boolean drP = true;
  public boolean drQ = true;
  public boolean dwP = true;
  private int mType = 0;
  private ArrayList<int[]> uB = new ArrayList();
  
  public axwg(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void TK(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.uB.size())) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderViewBuilder", 2, "updateRedDotHasShow failed out bounds" + paramInt + " size:" + this.uB.size());
      }
    }
    do
    {
      return;
      paramInt = ((int[])this.uB.get(paramInt))[0];
      if (paramInt == 101)
      {
        ayva.a().I(1, 0, "");
        return;
      }
      if (paramInt == 108)
      {
        ayva.a().I(6, 0, "");
        return;
      }
    } while (paramInt != 102);
    ayzs localayzs = (ayzs)axov.a(3);
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    switch (paramInt)
    {
    case 106: 
    case 109: 
    case 110: 
    case 111: 
    default: 
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((ProviderView)localObject1).setCaptureScene(this.mType);
        if (this.mType != 0) {
          break;
        }
        ((ProviderView)localObject1).setTabBarPosition(2);
        ((ProviderView)localObject1).TZ(206);
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.drP)
      {
        localObject1 = new ComboProviderView(paramContext);
        ((ProviderView)localObject1).setId(2131364257);
        continue;
        localObject1 = localObject2;
        if (this.cAj)
        {
          localObject1 = new QIMFilterProviderView(paramContext);
          ((ProviderView)localObject1).setId(2131364259);
          continue;
          localObject1 = new StaticStickerProviderView(paramContext);
          ((ProviderView)localObject1).setId(2131364268);
          continue;
          localObject1 = new QIMPtvTemplateProviderView(paramContext);
          continue;
          localObject1 = localObject2;
          if (this.drQ)
          {
            localObject1 = new MusicProviderView(paramContext);
            ((ProviderView)localObject1).setId(2131364267);
            continue;
            localObject1 = localObject2;
            if (this.cAi)
            {
              localObject1 = new AdvancedProviderView(paramContext);
              ((ProviderView)localObject1).setNeedTabBar(false);
              continue;
              localObject1 = new SpeedProviderView(paramContext);
              ((ProviderView)localObject1).setNeedTabBar(false);
              continue;
              localObject1 = new TransitionProviderView(paramContext);
            }
          }
        }
      }
    }
    ((ProviderView)localObject1).setTabBarPosition(1);
    if (((ProviderView)localObject1).ava())
    {
      ((ProviderView)localObject1).TZ(213);
      return localObject1;
    }
    ((ProviderView)localObject1).TZ(249);
    return localObject1;
  }
  
  public int getCount()
  {
    return this.uB.size();
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
      if (paramInt == ((int[])this.uB.get(i))[0]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public void ie()
  {
    this.uB.clear();
    switch (this.mType)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!this.dwP);
          if (this.cAk) {
            this.uB.add(mS);
          }
          if (this.cAi) {
            this.uB.add(uc);
          }
          if (this.cAj) {
            this.uB.add(mR);
          }
          if (this.drQ) {
            this.uB.add(ub);
          }
        } while (!this.drP);
        this.uB.add(tZ);
        return;
      } while (!this.dwP);
      this.uB.add(tZ);
      this.uB.add(mR);
      this.uB.add(ua);
      return;
    }
    if (this.dwP)
    {
      this.uB.add(tZ);
      this.uB.add(mR);
      this.uB.add(ua);
      this.uB.add(ud);
    }
    this.uB.add(ub);
    this.uB.add(ue);
  }
  
  public int lR(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {
      return 0;
    }
    return ((int[])this.uB.get(paramInt))[1];
  }
  
  public int lS(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {
      return 0;
    }
    return ((int[])this.uB.get(paramInt))[3];
  }
  
  public int lT(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {
      return 0;
    }
    return ((int[])this.uB.get(paramInt))[2];
  }
  
  public boolean ow(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.uB.size())) {
      return false;
    }
    paramInt = ((int[])this.uB.get(paramInt))[0];
    if (paramInt == 101) {
      return ayva.needShowRedDot(1, 0, "");
    }
    if (paramInt == 108) {
      return ayva.needShowRedDot(6, 0, "");
    }
    return paramInt != 102;
  }
  
  public boolean ox(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = uf;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.cAi = paramBoolean;
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    this.drP = paramBoolean;
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    this.dwP = paramBoolean;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.cAk = paramBoolean;
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.cAj = paramBoolean;
  }
  
  public void setMusicEnable(boolean paramBoolean)
  {
    this.drQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwg
 * JD-Core Version:    0.7.0.1
 */