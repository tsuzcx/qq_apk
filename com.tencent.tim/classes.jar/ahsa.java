import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public abstract class ahsa
  extends RecyclerView.ViewHolder
{
  public ahsa(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramView);
  }
  
  public abstract void a(FeedsItemData paramFeedsItemData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsa
 * JD-Core Version:    0.7.0.1
 */