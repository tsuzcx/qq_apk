import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aocr
  implements aocs.a
{
  public aocr(AIOMessageSpreadManager.1 param1, String paramString) {}
  
  public void mv(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      if (QLog.isDebugVersion())
      {
        if (paramList != null) {
          break label34;
        }
        paramList = "lst is null";
        QLog.i("AIOMessageSpreadManager", 1, paramList);
      }
    }
    label34:
    float f1;
    float f2;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        paramList = "lst.size() = 0";
        break;
        f1 = (float)aeus.a().w();
        paramList = paramList.iterator();
      }
      str = (String)paramList.next();
      f2 = aocq.a(this.a.this$0, this.ckb, str);
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "file[" + this.ckb + "] and [" + str + "], precentage[" + f2 + "]");
      }
    } while (f2 - f1 <= 0.0F);
    String str = aeus.a().uf();
    paramList = aeus.a().ug();
    str = str + "。" + paramList;
    aocq.a(this.a.this$0, this.a.b, str, paramList, "precent", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocr
 * JD-Core Version:    0.7.0.1
 */