import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.a;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amvn
  extends GroupSearchEngine.a
{
  public amvn(GroupSearchEngine paramGroupSearchEngine, amwd paramamwd, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramamwd, paramString, paramInt);
  }
  
  public ampw a(List<ampx> paramList, String paramString)
  {
    return new ampj(paramList, paramString, GroupSearchEngine.a(this.this$0));
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    if (!GroupSearchEngine.a(this.this$0)) {
      return null;
    }
    VADHelper.PZ("voice_search_approximate_cost");
    List localList = super.a(paramamwt);
    VADHelper.Qa("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramamwt.extra.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvn
 * JD-Core Version:    0.7.0.1
 */