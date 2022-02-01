import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class avsv
  implements avsx.a
{
  public Collection<avsw> collect()
  {
    synchronized ()
    {
      if (avsu.access$000().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(avsu.access$000().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsv
 * JD-Core Version:    0.7.0.1
 */