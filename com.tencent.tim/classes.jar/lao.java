import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class lao<D>
{
  public static int aMQ;
  protected int aLp = aMQ + 1;
  protected int aLq = this.aLp;
  protected int aLr = 2147483647;
  protected VafContext c;
  protected final Map<String, Integer> ed = new ConcurrentHashMap();
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    this.c = paramVafContext;
    int i = paramVafContext.getTemplateFactory().size();
    aMQ = paramInt;
    this.aLp = (aMQ + 1);
    this.aLq = this.aLp;
    if ((this.aLq < this.aLp + i) && (i > 0) && (this.aLq < this.aLr))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      paramInt = this.aLq;
      paramVafContext = paramVafContext.iterator();
      if (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (this.ed.containsKey(str)) {
          break label263;
        }
        this.ed.put(str, Integer.valueOf(paramInt));
        paramInt += 1;
      }
    }
    label263:
    for (;;)
    {
      break;
      this.aLq = (this.aLp + i);
      if (this.aLr == 2147483647) {
        this.aLr = (this.aLq + 30);
      }
      if (this.aLq > this.aLr) {
        this.aLq = this.aLr;
      }
      QLog.d("DynamicItemViewHelperCompatBase", 1, "init: templateCount : " + i + " TYPE_DYNAMIC_END : " + this.aLq + " max : " + this.aLr);
      if (this.aLr == 2147483647) {
        this.aLr = (this.aLp + 100);
      }
      return;
    }
  }
  
  public boolean dx(int paramInt)
  {
    return (paramInt >= aMQ) && (paramInt < this.aLq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lao
 * JD-Core Version:    0.7.0.1
 */