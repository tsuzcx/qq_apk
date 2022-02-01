import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.handlers.DailyHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.Map;

public class lga
  extends lfz
{
  public void a(View paramView, ListView paramListView) {}
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    super.a(paramMap, paramBoolean);
    if (kys.dv(nh()))
    {
      paramMap = a();
      if (awit.aMU()) {
        break label36;
      }
      QLog.d("DailyHandler", 1, "detachFromViewGroup,now cmd is 0x68b");
    }
    label36:
    while (paramMap == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DailyHandler.1(this, paramMap.lB));
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ArticleInfo)getData((int)paramLong);
    if (kys.dv(nh())) {
      if (!kxm.j(paramAdapterView)) {
        break label35;
      }
    }
    label35:
    for (paramInt = 4;; paramInt = 2)
    {
      kvs.oT(paramInt);
      return;
    }
  }
  
  public int np()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lga
 * JD-Core Version:    0.7.0.1
 */