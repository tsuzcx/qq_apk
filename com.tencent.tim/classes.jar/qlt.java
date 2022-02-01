import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qlt
{
  private qlu jdField_a_of_type_Qlu;
  private qlw jdField_a_of_type_Qlw;
  private List<qlv> nU = new ArrayList();
  
  public boolean JU()
  {
    boolean bool = false;
    Iterator localIterator = this.nU.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((qlv)localIterator.next()).JW()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      if (i == this.nU.size()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public qlv.a a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    qlv localqlv;
    label46:
    qlv.a locala;
    if (i == 0)
    {
      Iterator localIterator = this.nU.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localqlv = (qlv)localIterator.next();
        locala = localqlv.a();
        if (locala == null) {
          break label151;
        }
        if (localqlv == this.jdField_a_of_type_Qlw)
        {
          localObject1 = locala;
          label70:
          if (localqlv.W(false)) {
            break label152;
          }
          if (!localqlv.JW()) {
            break label154;
          }
          i += 1;
        }
      }
    }
    label151:
    label152:
    label154:
    for (;;)
    {
      break label24;
      localqlv.a(locala, 0L);
      break label46;
      if (localObject1 != null) {}
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!paramBoolean);
      if (i == this.nU.size())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      Log.d("Decoders", "EOS NULL");
      return null;
      break label70;
      break label70;
    }
  }
  
  public qlw a()
  {
    return this.jdField_a_of_type_Qlw;
  }
  
  public void a(MediaPlayer.b paramb, long paramLong)
    throws IOException
  {
    Iterator localIterator = this.nU.iterator();
    while (localIterator.hasNext()) {
      ((qlv)localIterator.next()).a(paramb, paramLong);
    }
  }
  
  public void a(qlv paramqlv)
  {
    this.nU.add(paramqlv);
    if ((paramqlv instanceof qlw)) {
      this.jdField_a_of_type_Qlw = ((qlw)paramqlv);
    }
    while (!(paramqlv instanceof qlu)) {
      return;
    }
    this.jdField_a_of_type_Qlu = ((qlu)paramqlv);
  }
  
  public List<qlv> bQ()
  {
    return this.nU;
  }
  
  public void boW()
  {
    Iterator localIterator = this.nU.iterator();
    while (localIterator.hasNext()) {
      ((qlv)localIterator.next()).bpa();
    }
  }
  
  public void boX()
  {
    Iterator localIterator = this.nU.iterator();
    while (localIterator.hasNext()) {
      ((qlv)localIterator.next()).bpb();
    }
  }
  
  public long dR()
  {
    Iterator localIterator = this.nU.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((qlv)localIterator.next()).dR();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label60;
      }
      l1 = l2;
    }
    label60:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public long getCachedDuration()
  {
    Iterator localIterator = this.nU.iterator();
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((qlv)localIterator.next()).getCachedDuration(), l1)) {}
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -1L;
    }
    return l2;
  }
  
  public boolean hasCacheReachedEndOfStream()
  {
    Iterator localIterator = this.nU.iterator();
    while (localIterator.hasNext()) {
      if (!((qlv)localIterator.next()).hasCacheReachedEndOfStream()) {
        return false;
      }
    }
    return true;
  }
  
  public void release()
  {
    Iterator localIterator = this.nU.iterator();
    while (localIterator.hasNext()) {
      ((qlv)localIterator.next()).release();
    }
    this.nU.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlt
 * JD-Core Version:    0.7.0.1
 */