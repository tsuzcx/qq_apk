import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BaseView;

public class amce
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new amcs();
    case 101: 
      new amct();
    case 102: 
      return new amco();
    }
    return new amcp();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new amda();
    case 101: 
      return new amdc();
    case 102: 
      return new amcw();
    }
    return new amcy();
  }
  
  public BaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramBasePresenter instanceof amda));
          return new amea(paramActivity, (amda)paramBasePresenter);
        } while (!(paramBasePresenter instanceof amdc));
        return new amem(paramActivity, (amdc)paramBasePresenter);
      } while (!(paramBasePresenter instanceof amcw));
      return new amdr(paramActivity, (amcw)paramBasePresenter);
    } while (!(paramBasePresenter instanceof amcy));
    return new amdw(paramActivity, (amcy)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amce
 * JD-Core Version:    0.7.0.1
 */