import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aebe
{
  public static void ea(ArrayList<ColorNote> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramArrayList.next();
      Integer localInteger = Integer.valueOf(localColorNote.getServiceType());
      if (localHashMap.containsKey(localInteger))
      {
        ((ArrayList)localHashMap.get(localInteger)).add(localColorNote);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localColorNote);
        localHashMap.put(localInteger, localArrayList);
      }
    }
    nns.dl((List)localHashMap.get(Integer.valueOf(16908290)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebe
 * JD-Core Version:    0.7.0.1
 */