import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import org.json.JSONObject;

final class kfk
  implements ViewFactory.FoundClickableViewListener
{
  kfk(String paramString, JSONObject paramJSONObject) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      paramViewBase.setOnClickListener(new kfm(this));
      return;
    }
    paramViewBase.setOnClickListener(new kfl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfk
 * JD-Core Version:    0.7.0.1
 */