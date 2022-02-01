import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class luh
  extends VafContext
{
  private static void aNw()
  {
    DrawableUtil.setDrawableHelper(new lui());
  }
  
  private void aNx() {}
  
  private void initLog()
  {
    LogUtil.setProteusLog(new lrl.a());
  }
  
  public void setContext(Context paramContext)
  {
    super.setContext(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f2 = acej.aV() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    Utils.init(paramContext.density / f1, paramContext.widthPixels);
    aNw();
    initLog();
    aNx();
    npv.init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luh
 * JD-Core Version:    0.7.0.1
 */