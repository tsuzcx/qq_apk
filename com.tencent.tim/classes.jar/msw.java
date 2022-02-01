import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class msw
{
  public boolean anS;
  public ArrayList<Integer> lo;
  public int mSceneType;
  
  public msw(int paramInt)
  {
    this.mSceneType = paramInt;
    this.lo = new ArrayList();
  }
  
  private String l(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 2);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger != null) {
        localStringBuilder.append(localInteger);
      }
      if (paramArrayList.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void add(int paramInt)
  {
    this.lo.add(Integer.valueOf(paramInt));
  }
  
  public void clear()
  {
    this.mSceneType = -1;
    this.anS = false;
    this.lo.clear();
  }
  
  public boolean isEmpty()
  {
    if (this.lo != null) {
      return this.lo.isEmpty();
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("mSceneType: ").append(this.mSceneType);
    localStringBuilder.append(", mIsAutoPlay: ").append(this.anS);
    localStringBuilder.append(", mIndexList: ").append(l(this.lo));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_sceneType", String.valueOf(this.mSceneType));
    localHashMap.put("param_indexList", l(this.lo));
    localHashMap.put("param_isAutoPlay", String.valueOf(this.anS));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msw
 * JD-Core Version:    0.7.0.1
 */