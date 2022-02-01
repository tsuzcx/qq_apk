import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class axmz
{
  private List<axna> MW = new ArrayList(9);
  private List<HashMap<Integer, Float>> MX = new ArrayList();
  private int imageCount;
  
  public axmz()
  {
    reset();
  }
  
  private axna a(int paramInt)
  {
    return (axna)this.MW.get(paramInt);
  }
  
  public float A(int paramInt)
  {
    return a(paramInt).getStrength();
  }
  
  public axkn a(int paramInt)
  {
    return a(paramInt).b();
  }
  
  public axkq a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public void a(int paramInt1, String paramString, float paramFloat, int paramInt2)
  {
    ((axna)this.MW.get(paramInt1)).b(paramString, paramFloat, paramInt2);
  }
  
  public void aen(int paramInt)
  {
    int i = 0;
    while (i < this.MW.size())
    {
      ((axna)this.MW.get(i)).b(((axna)this.MW.get(paramInt)).getLutPath(), ((axna)this.MW.get(paramInt)).getStrength(), ((axna)this.MW.get(paramInt)).Rf());
      ((HashMap)this.MX.get(i)).put(Integer.valueOf(((axna)this.MW.get(paramInt)).Rf()), Float.valueOf(((axna)this.MW.get(paramInt)).getStrength()));
      i += 1;
    }
  }
  
  public void aeo(int paramInt)
  {
    a(paramInt).eMU();
  }
  
  public void b(int paramInt, axkn paramaxkn)
  {
    a(paramInt).b(paramaxkn);
  }
  
  public void b(int paramInt, axkq paramaxkq)
  {
    a(paramInt).a(paramaxkq);
  }
  
  public float c(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!((HashMap)this.MX.get(paramInt1)).containsKey(Integer.valueOf(paramInt2))) {
      return paramFloat;
    }
    return ((Float)((HashMap)this.MX.get(paramInt1)).get(Integer.valueOf(paramInt2))).floatValue();
  }
  
  public void eMT()
  {
    int i = 0;
    while (i < this.imageCount)
    {
      ((axna)this.MW.get(i)).eMU();
      i += 1;
    }
  }
  
  public void f(int paramInt1, int paramInt2, float paramFloat)
  {
    ((HashMap)this.MX.get(paramInt1)).put(Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
  }
  
  public String gT(int paramInt)
  {
    return a(paramInt).getLutPath();
  }
  
  public void init(int paramInt)
  {
    if (paramInt > 9) {
      throw new IllegalArgumentException("image count > max count 9");
    }
    this.imageCount = paramInt;
  }
  
  public int lI(int paramInt)
  {
    return a(paramInt).Rf();
  }
  
  public int lJ(int paramInt)
  {
    return a(paramInt).Rg();
  }
  
  public boolean on(int paramInt)
  {
    return a(paramInt).aPc();
  }
  
  public boolean oo(int paramInt)
  {
    return a(paramInt).aPd();
  }
  
  public boolean op(int paramInt)
  {
    return a(paramInt).aPe();
  }
  
  public void reset()
  {
    this.MW.clear();
    this.MX.clear();
    int i = 0;
    while (i < 9)
    {
      this.MW.add(new axna());
      this.MX.add(new HashMap());
      i += 1;
    }
  }
  
  public void w(int paramInt, float paramFloat)
  {
    a(paramInt).setStrength(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmz
 * JD-Core Version:    0.7.0.1
 */