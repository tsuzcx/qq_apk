import java.util.ArrayList;
import java.util.List;

public abstract class anxu
{
  protected int JO;
  public anxv a;
  public anxx c;
  public boolean cKD;
  public int dNk;
  public int dNl = 1;
  public float height;
  protected List<anyb> mActions = new ArrayList();
  protected int mViewHeight;
  public String name;
  public int opacity = 255;
  public float rotate;
  public float scale = 1.0F;
  public int tag;
  public float width;
  public float x;
  public float y;
  public float zU = 1.0F;
  
  public int Ky()
  {
    float f = 1.0F;
    for (anxu localanxu = (anxu)this.c; localanxu != null; localanxu = (anxu)localanxu.c) {
      f *= localanxu.opacity / 255.0F;
    }
    return (int)(f * 255.0F);
  }
  
  public void VA(int paramInt)
  {
    this.dNk = paramInt;
  }
  
  public void VB(int paramInt)
  {
    this.dNl = paramInt;
  }
  
  public abstract anxz a();
  
  public void a(anxv paramanxv)
  {
    this.a = paramanxv;
  }
  
  public void a(anya paramanya)
  {
    float f1 = this.x;
    float f3 = this.y;
    float f2;
    switch (this.dNk)
    {
    default: 
      f2 = f3;
      switch (this.dNl)
      {
      default: 
        f2 = f3;
      }
      break;
    }
    for (;;)
    {
      for (anxu localanxu = (anxu)this.c; localanxu != null; localanxu = (anxu)localanxu.c)
      {
        f1 += localanxu.x;
        f2 += localanxu.y;
      }
      f1 = this.JO / this.zU - f1;
      break;
      f1 += this.JO / this.zU / 2.0F;
      break;
      f2 = this.mViewHeight / this.zU - f3;
      continue;
      f2 = this.mViewHeight / this.zU / 2.0F + f3;
    }
    paramanya.x = f1;
    paramanya.y = f2;
  }
  
  public void a(anyb... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      anyb localanyb = paramVarArgs[i];
      localanyb.start();
      this.mActions.add(localanyb);
      i += 1;
    }
  }
  
  public boolean azn()
  {
    return this.cKD;
  }
  
  protected boolean azo()
  {
    int i = 0;
    boolean bool1 = false;
    int j;
    if (i < this.mActions.size())
    {
      anyb localanyb = (anyb)this.mActions.get(i);
      if (localanyb.run())
      {
        if ((localanyb.type & 0x1) != 0)
        {
          this.x = localanyb.x;
          this.y = localanyb.y;
        }
        if ((localanyb.type & 0x2) != 0) {
          this.scale = localanyb.scale;
        }
        if ((localanyb.type & 0x4) != 0) {
          this.opacity = localanyb.opacity;
        }
        if ((localanyb.type & 0x8) != 0) {
          this.rotate = localanyb.rotate;
        }
        bool1 = true;
      }
      j = i;
      if (localanyb.isEnd)
      {
        if (!localanyb.isRepeat) {
          break label161;
        }
        localanyb.start();
      }
      for (j = i;; j = i - 1)
      {
        i = j + 1;
        break;
        label161:
        this.mActions.remove(i);
      }
    }
    boolean bool2 = bool1;
    if (this.a != null)
    {
      bool2 = bool1;
      if (a() != null)
      {
        j = a().Kz() * this.a.fps / 1000;
        i = j;
        if (j > 0) {
          i = j - 1;
        }
        bool2 = bool1;
        if (i < this.a.a.length)
        {
          this.x = this.a.a[i].x;
          this.y = this.a.a[i].y;
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public void be(float paramFloat)
  {
    this.zU = paramFloat;
  }
  
  public float bv()
  {
    float f = 1.0F;
    for (anxu localanxu = (anxu)this.c; localanxu != null; localanxu = (anxu)localanxu.c) {
      f *= localanxu.scale;
    }
    return f;
  }
  
  public void cw(int paramInt)
  {
    this.tag = paramInt;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public int getTag()
  {
    return this.tag;
  }
  
  public void pause()
  {
    int i = 0;
    while (i < this.mActions.size())
    {
      ((anyb)this.mActions.get(i)).pause();
      i += 1;
    }
  }
  
  public void release()
  {
    this.mActions.clear();
  }
  
  public void resume()
  {
    int i = 0;
    while (i < this.mActions.size())
    {
      ((anyb)this.mActions.get(i)).resume();
      i += 1;
    }
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOpacity(int paramInt)
  {
    this.opacity = paramInt;
  }
  
  public void setRotate(float paramFloat)
  {
    this.rotate = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxu
 * JD-Core Version:    0.7.0.1
 */