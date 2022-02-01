import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.a;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amwb
  extends GroupSearchEngine.a
{
  public amwb(GroupSearchEngine paramGroupSearchEngine, amwd paramamwd, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramamwd, paramString, paramInt);
  }
  
  public ampw a(List<ampx> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new ampi(paramList, paramString, GroupSearchEngine.a(this.this$0));
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    VADHelper.PZ("voice_search_accurate_cost");
    List localList = super.a(paramamwt);
    VADHelper.Qa("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramamwt.extra == null) {
        paramamwt.extra = new Bundle();
      }
      paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((ampw)localList.get(1)).eX().size());
        }
        paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((ampw)localList.get(1)).eX().size());
      }
      return localList;
    }
    paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  public ampw b(List<ampx> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ampx localampx = (ampx)paramList.next();
      if (!amxk.a(localampx)) {
        localArrayList.add(localampx);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ampi(localArrayList, paramString, GroupSearchEngine.a(this.this$0));
  }
  
  public ampw c(List<ampx> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ampx localampx = (ampx)paramList.next();
      if (amxk.a(localampx)) {
        localArrayList.add(localampx);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ampk(localArrayList, paramString, GroupSearchEngine.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwb
 * JD-Core Version:    0.7.0.1
 */