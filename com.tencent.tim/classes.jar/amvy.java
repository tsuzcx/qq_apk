import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.a;
import java.util.ArrayList;
import java.util.List;

public class amvy
  extends GroupSearchEngine.a
{
  public amvy(GroupSearchEngine paramGroupSearchEngine, amwd paramamwd, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramamwd, paramString, paramInt);
  }
  
  public ampw a(List<ampx> paramList, String paramString)
  {
    return null;
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    this.akl = 0L;
    this.czb = -1;
    if (paramamwt.extra == null) {
      paramamwt.extra = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    paramamwt = new ampn(paramamwt.keyword, GroupSearchEngine.a(this.this$0));
    localArrayList.add(new ampf(paramamwt));
    localArrayList.add(paramamwt);
    amxj.UD(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvy
 * JD-Core Version:    0.7.0.1
 */