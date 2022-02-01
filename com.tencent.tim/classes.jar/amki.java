import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class amki
  implements Callable<List<amka>>
{
  amki(amkg paramamkg, int paramInt1, int paramInt2) {}
  
  public List<amka> ge()
  {
    Object localObject = amkg.a(this.c).subList(this.val$start, this.val$end);
    ArrayList localArrayList = new ArrayList();
    amka localamka;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localamka = (amka)((Iterator)localObject).next();
        if (!this.c.isCancelled()) {
          break label141;
        }
      }
      if (!amkg.a(this.c).equals(amkg.b(this.c))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localamka = (amka)((Iterator)localObject).next();
        if (!this.c.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localamka.PG(amkg.a(this.c));
        if (localamka.gN() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localamka);
        if (-1 == i)
        {
          localArrayList.add(localamka);
          break;
        }
        if (((amka)localArrayList.get(i)).gN() >= localamka.gN()) {
          break;
        }
        localArrayList.set(i, localamka);
        break;
      }
      long l = localamka.gN();
      localamka.PG(amkg.b(this.c));
      if (localamka.gN() == -9223372036854775808L) {
        localamka.lg(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amki
 * JD-Core Version:    0.7.0.1
 */