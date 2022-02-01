import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.a;
import java.util.ArrayList;
import java.util.List;

public class amwa
  extends GroupSearchEngine.a
{
  public amwa(GroupSearchEngine paramGroupSearchEngine, amwd paramamwd, String paramString, int paramInt)
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
    paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramamwt = this.a.a(paramamwt);
    if (paramamwt != null) {
      localArrayList.addAll(paramamwt);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwa
 * JD-Core Version:    0.7.0.1
 */