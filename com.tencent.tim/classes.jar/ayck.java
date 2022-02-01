import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ayck
  extends BaseAdapter
{
  private List<prt.c> mData = new ArrayList();
  private int mImageSize;
  private int mSelectedPosition;
  
  public ayck(List<prt.c> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
  }
  
  private void m(int paramInt, View paramView)
  {
    prt.c localc = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131379322);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379312);
    View localView = paramView.findViewById(2131379320);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131379317);
    localTextView.setText(localc.mName);
    if (this.mImageSize == 0) {
      this.mImageSize = rpq.dip2px(paramView.getContext(), 60.0F);
    }
    rpq.a(localImageView, localc.mImageUrl, this.mImageSize, this.mImageSize, paramView.getContext().getResources().getDrawable(2130847626), null);
    if (paramInt == this.mSelectedPosition)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(acfp.m(2131715274) + localc.mName + "’");
    }
    for (;;)
    {
      if (localc.aBq) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(acfp.m(2131715275) + localc.mName + acfp.m(2131715273));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public int OQ()
  {
    return this.mSelectedPosition;
  }
  
  public void Wc(int paramInt)
  {
    if (paramInt == this.mSelectedPosition) {
      return;
    }
    this.mSelectedPosition = paramInt;
    notifyDataSetChanged();
  }
  
  public prt.c a(int paramInt)
  {
    return (prt.c)this.mData.get(paramInt);
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561133, paramViewGroup, false);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      m(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayck
 * JD-Core Version:    0.7.0.1
 */