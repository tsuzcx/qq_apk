import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class uka
{
  private ukb a = new ukb();
  
  public uka(HashMap<String, List<uja>> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject == null)
      {
        wxe.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "value is null key=%s", new Object[] { str });
      }
      else
      {
        localObject = (List)localObject;
        this.a.a(str, ((List)localObject).size());
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("AlbumTree=[\n");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(this.a);
    while (localLinkedList.size() > 0)
    {
      int j = localLinkedList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (ukb)localLinkedList.poll();
        if (localObject != null)
        {
          localStringBuilder.append(" [").append(((ukb)localObject).toString()).append("];");
          localObject = ((ukb)localObject).a.iterator();
          while (((Iterator)localObject).hasNext()) {
            localLinkedList.offer((ukb)((Iterator)localObject).next());
          }
        }
        i += 1;
      }
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n]");
    wxe.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "traverse " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public ukb a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uka
 * JD-Core Version:    0.7.0.1
 */