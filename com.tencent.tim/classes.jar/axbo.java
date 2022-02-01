import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;

public abstract class axbo
  implements acci
{
  public void a(boolean paramBoolean, axdd paramaxdd) {}
  
  protected void a(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp) {}
  
  public void cS(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void cc(boolean paramBoolean, int paramInt) {}
  
  public void cd(boolean paramBoolean, int paramInt) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (axdd)paramObject);
      return;
    case 2: 
      cS(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 3: 
      cc(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 4: 
      a(paramBoolean, (GetFontDataRsp)paramObject);
      return;
    }
    cd(paramBoolean, ((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbo
 * JD-Core Version:    0.7.0.1
 */