import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class vyh
{
  private vyi a = new vyi();
  
  public vyh(HashMap<String, List<vxh>> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject == null)
      {
        ykq.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "value is null key=%s", new Object[] { str });
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
        Object localObject = (vyi)localLinkedList.poll();
        if (localObject != null)
        {
          localStringBuilder.append(" [").append(((vyi)localObject).toString()).append("];");
          localObject = ((vyi)localObject).a.iterator();
          while (((Iterator)localObject).hasNext()) {
            localLinkedList.offer((vyi)((Iterator)localObject).next());
          }
        }
        i += 1;
      }
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n]");
    ykq.d("Q.qqstory.recommendAlbum.logic.AlbumTree", "traverse " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public vyi a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyh
 * JD-Core Version:    0.7.0.1
 */