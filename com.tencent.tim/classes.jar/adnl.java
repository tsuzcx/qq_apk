import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

class adnl
  implements awoe
{
  adnl(adnc paramadnc) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallback:" + paramArrayList.toString());
    }
    if (adnc.a(this.this$0) != null)
    {
      tbb.cI(paramArrayList);
      adnc.a(this.this$0).dT(paramArrayList);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallbackVia:" + paramArrayList.toString());
    }
    if (adnc.a(this.this$0) != null)
    {
      tbb.cI(paramArrayList);
      adnc.a(this.this$0).dU(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if (adnc.a(this.this$0) != null)
    {
      tbb.d(paramWadlResult);
      adnc.a(this.this$0).j(paramWadlResult);
      if (paramWadlResult != null) {}
    }
    else
    {
      return;
    }
    QLog.i("ark.download.module", 1, "ark.dctrl.onWadlTaskStatusChanged:" + paramWadlResult.toString());
    if (paramWadlResult.a != null) {}
    for (String str = paramWadlResult.a.appId;; str = "") {
      switch (paramWadlResult.bBa)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        anot.c(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str, "");
        return;
      }
    }
    anot.c(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str, "");
    return;
    anot.c(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str, "");
    return;
    anot.c(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnl
 * JD-Core Version:    0.7.0.1
 */