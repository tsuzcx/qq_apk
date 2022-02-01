import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;

public class rye
  extends ryg
{
  public rye(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void biW()
  {
    setDatas(new ArrayList());
    setShareData("share_key_subscribe_user", new rxn.b(new ExtraTypeInfo()));
    notifyLoadingComplete(true);
  }
  
  public ryg.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void a(HorizontalRvInnerView paramHorizontalRvInnerView)
  {
    paramHorizontalRvInnerView.setOrientation(1);
  }
  
  public void e(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  protected void handleBlockChange(rxq paramrxq, int paramInt)
  {
    super.handleBlockChange(paramrxq, paramInt);
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(rxt paramrxt)
  {
    if ((paramrxt.Mh()) || (paramrxt.Mg())) {
      biW();
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    getBlockContainer().setEnableRefresh(true);
    addFloatView(new Button(getContext()));
    getBlockContainer().a();
  }
  
  public int ug()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rye
 * JD-Core Version:    0.7.0.1
 */