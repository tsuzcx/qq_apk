import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqjv
  extends BaseAdapter
{
  aqjv(aqju paramaqju) {}
  
  public int getCount()
  {
    if (this.aG.items != null) {
      return this.aG.items.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.aG.inflater == null) {
      this.aG.inflater = ((LayoutInflater)this.aG.getContext().getSystemService("layout_inflater"));
    }
    aqju.c localc;
    if (paramView == null)
    {
      paramView = this.aG.inflater.inflate(this.aG.getDialogListItemLayout(), null);
      localc = new aqju.c(this.aG, null);
      localc.text = ((TextView)paramView.findViewById(2131369530));
      paramView.setTag(localc);
    }
    for (;;)
    {
      localc = (aqju.c)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localc.text != null)
      {
        localc.text.setText(this.aG.items[paramInt]);
        localc.text.setOnClickListener(new aqju.b(this.aG, paramInt));
        i = localc.text.getPaddingTop();
        j = localc.text.getPaddingLeft();
        k = localc.text.getPaddingRight();
        m = localc.text.getPaddingBottom();
        if (this.aG.items.length != 1) {
          break label237;
        }
        localc.text.setBackgroundResource(2130839807);
      }
      for (;;)
      {
        localc.text.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label237:
        if (paramInt == 0) {
          localc.text.setBackgroundResource(2130840055);
        } else if (paramInt == this.aG.items.length - 1) {
          localc.text.setBackgroundResource(2130839806);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqjv
 * JD-Core Version:    0.7.0.1
 */