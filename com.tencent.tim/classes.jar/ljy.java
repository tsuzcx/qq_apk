import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.a;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2;
import java.util.List;
import mqq.util.WeakReference;

public class ljy
  implements SelectPositionModule.a
{
  private SelectPositionModule a = lbz.a().a();
  private WeakReference<ljy.a> x;
  
  public ljy(ljy.a parama)
  {
    this.a.a(this);
    this.x = new WeakReference(parama);
  }
  
  private void ci(List<ljw.a> paramList)
  {
    ljy.a locala = (ljy.a)this.x.get();
    if ((locala != null) && (paramList != null)) {
      locala.ci(paramList);
    }
  }
  
  public void aMJ()
  {
    SelectPositionModule localSelectPositionModule = lbz.a().a();
    if (localSelectPositionModule != null) {
      ci(localSelectPositionModule.aR());
    }
  }
  
  public void cx(List<ljw.a> paramList)
  {
    asfe.getUIHandler().post(new SelectCityPresenter.1(this, paramList));
  }
  
  public void g(SelectPositionModule.PositionData paramPositionData)
  {
    asfe.getUIHandler().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public static abstract interface a
  {
    public abstract void b(SelectPositionModule.PositionData paramPositionData);
    
    public abstract void ci(List<ljw.a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */