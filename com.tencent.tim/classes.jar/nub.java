import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.viola.adapter.IBridgeAdapter;
import com.tencent.viola.adapter.IBridgeAdapter.OnInovkeCallback;
import com.tencent.viola.core.ViolaInstance;
import java.util.ArrayList;

public class nub
  implements IBridgeAdapter
{
  public nub()
  {
    registerModuleFunction();
  }
  
  public ArrayList<String> getAdapterUnRegisterFunction()
  {
    return null;
  }
  
  public void registerModuleFunction() {}
  
  public void titleUiInvoke(String paramString, Object paramObject, IBridgeAdapter.OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance == null) {
      break label5;
    }
    for (;;)
    {
      label5:
      return;
      if (("change_title_transparent".equals(paramString)) && ((paramObject instanceof Boolean)))
      {
        paramString = paramViolaInstance.getFragment();
        if (paramString == null) {
          break;
        }
        if ((paramString instanceof ViolaFragment)) {}
        for (paramString = ((ViolaFragment)paramString).a(); paramString != null; paramString = null)
        {
          paramString.qh(((Boolean)paramObject).booleanValue());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nub
 * JD-Core Version:    0.7.0.1
 */