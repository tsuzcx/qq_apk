import NS_COMM.COMM.StCommonExt;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.richframework.part.block.BlockContainer;
import java.util.ArrayList;

public class ryf
  extends rxq
{
  public ryf(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void biW()
  {
    setDatas(new ArrayList());
    notifyLoadingComplete(true);
  }
  
  public int getItemCount()
  {
    return getDataList().size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 100000;
    }
    if (paramInt >= getDataList().size()) {
      return 100001;
    }
    return 100002;
  }
  
  public int getSpanCount(int paramInt)
  {
    return 1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  protected void handleBlockChange(rxq paramrxq, int paramInt)
  {
    super.handleBlockChange(paramrxq, paramInt);
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    super.handleShareDataChange(paramString, paramb);
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
    while (!paramrxt.Mi()) {
      return;
    }
    getLoadInfo().a(new COMM.StCommonExt());
    getLoadInfo().setFinish(true);
    getLoadInfo().sQ("");
    addAll(new ArrayList());
    notifyLoadingComplete(true);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    getBlockContainer().setEnableRefresh(true);
    addFloatView(new Button(getContext()));
    getBlockContainer().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryf
 * JD-Core Version:    0.7.0.1
 */