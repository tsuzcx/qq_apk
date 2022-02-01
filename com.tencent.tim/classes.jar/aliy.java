import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class aliy
  implements aliv
{
  private aliw a;
  private ArrayList<aliv> yJ = new ArrayList();
  
  public aliv.a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramArrayOfByte = new aliv.a(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.yJ.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      aliv localaliv;
      aliv.a locala;
      if (localIterator.hasNext())
      {
        localaliv = (aliv)localIterator.next();
        if (this.a != null) {
          this.a.b(localaliv, paramArrayOfByte);
        }
        locala = localaliv.a(paramArrayOfByte.data, paramArrayOfByte.offset, paramArrayOfByte.size);
        localObject = locala;
        if (locala != null)
        {
          localObject = locala;
          if (locala.data != null)
          {
            if (locala.size != 0) {
              break label121;
            }
            localObject = locala;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = locala;
      if (this.a != null)
      {
        this.a.a(localaliv, locala);
        paramArrayOfByte = locala;
      }
    }
  }
  
  public void a(aliv paramaliv)
  {
    this.yJ.add(paramaliv);
  }
  
  public void a(aliw paramaliw)
  {
    this.a = paramaliw;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    Iterator localIterator = this.yJ.iterator();
    while (localIterator.hasNext()) {
      ((aliv)localIterator.next()).init(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void release()
    throws IOException
  {
    Iterator localIterator = this.yJ.iterator();
    while (localIterator.hasNext()) {
      ((aliv)localIterator.next()).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aliy
 * JD-Core Version:    0.7.0.1
 */