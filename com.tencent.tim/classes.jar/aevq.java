import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public abstract class aevq
{
  public long WM;
  public long WN = -1L;
  public long WO = -1L;
  public short ab;
  private final int cPt = aehr.Cm();
  public byte cType = -1;
  private boolean isDefault;
  protected ArrayList items = new ArrayList();
  
  public aevq(short paramShort, byte paramByte)
  {
    this.ab = paramShort;
    this.cType = paramByte;
  }
  
  public final int CD()
  {
    return this.items.size();
  }
  
  public final void Hx(boolean paramBoolean)
  {
    this.isDefault = paramBoolean;
  }
  
  public void Hz(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {}
    label85:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.items.size())
      {
        aevv.a locala = (aevv.a)this.items.get(i);
        if ((locala.aaK == null) || (!locala.aaK.contains(paramString))) {}
      }
      for (;;)
      {
        if (i == -1) {
          break label85;
        }
        this.items.remove(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public abstract void a(DataOutputStream paramDataOutputStream)
    throws Exception;
  
  public void addElement(Object paramObject)
  {
    this.items.add(paramObject);
  }
  
  public final boolean aie()
  {
    return this.WN > System.currentTimeMillis();
  }
  
  public abstract void b(DataInputStream paramDataInputStream)
    throws Exception;
  
  public abstract void clearUp();
  
  public final boolean isOutDate()
  {
    return (this.WO > 0L) && (this.WO <= System.currentTimeMillis());
  }
  
  public void removeAll()
  {
    this.items.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevq
 * JD-Core Version:    0.7.0.1
 */