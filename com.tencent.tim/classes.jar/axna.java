import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;

public class axna
{
  private AEEditorFilterBean.FilterID a = AEEditorFilterBean.FilterID.NON;
  private axkq b;
  private axkn c;
  private int eGc = 0;
  private int eGd = 0;
  private String lutPath;
  private float strength = 1.0F;
  
  public int Rf()
  {
    return this.eGd;
  }
  
  public int Rg()
  {
    return this.eGc;
  }
  
  public axkq a()
  {
    return this.b;
  }
  
  public void a(axkq paramaxkq)
  {
    this.b = paramaxkq;
    this.eGc = this.eGd;
    this.eGd = 2;
    this.a = AEEditorFilterBean.FilterID.Comics;
  }
  
  public boolean aPc()
  {
    return this.a == AEEditorFilterBean.FilterID.NON;
  }
  
  public boolean aPd()
  {
    return this.a == AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public boolean aPe()
  {
    return this.a == AEEditorFilterBean.FilterID.Comics;
  }
  
  public axkn b()
  {
    return this.c;
  }
  
  public void b(axkn paramaxkn)
  {
    this.lutPath = null;
    this.c = paramaxkn;
    this.eGc = this.eGd;
    this.eGd = 1;
    this.a = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void b(String paramString, float paramFloat, int paramInt)
  {
    this.lutPath = paramString;
    this.strength = paramFloat;
    this.eGc = this.eGd;
    this.eGd = paramInt;
    this.a = AEEditorFilterBean.FilterID.COLOR;
  }
  
  public void eMU()
  {
    this.lutPath = null;
    this.strength = 1.0F;
    this.eGc = this.eGd;
    this.eGd = 0;
    this.a = AEEditorFilterBean.FilterID.NON;
  }
  
  public String getLutPath()
  {
    return this.lutPath;
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public void setStrength(float paramFloat)
  {
    this.strength = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axna
 * JD-Core Version:    0.7.0.1
 */