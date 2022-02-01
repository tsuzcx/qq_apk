import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkg
  extends BaseAdapter
{
  aqkg(aqkf paramaqkf) {}
  
  public int getCount()
  {
    if (this.a.items != null) {
      return this.a.items.length;
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
    if (this.a.inflater == null) {
      this.a.inflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    aqkf.b localb;
    if (paramView == null)
    {
      paramView = this.a.inflater.inflate(2131559139, null);
      localb = new aqkf.b(this.a, null);
      localb.text = ((TextView)paramView.findViewById(2131369530));
      paramView.setTag(localb);
    }
    for (;;)
    {
      localb = (aqkf.b)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localb.text != null)
      {
        localb.text.setText(this.a.items[paramInt]);
        localb.text.setOnClickListener(new aqkf.a(this.a, paramInt));
        i = localb.text.getPaddingTop();
        j = localb.text.getPaddingLeft();
        k = localb.text.getPaddingRight();
        m = localb.text.getPaddingBottom();
        if (this.a.items.length != 1) {
          break label232;
        }
        localb.text.setBackgroundResource(2130839807);
      }
      for (;;)
      {
        localb.text.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localb.text.setBackgroundResource(2130840055);
        } else if (paramInt == this.a.items.length - 1) {
          localb.text.setBackgroundResource(2130839806);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkg
 * JD-Core Version:    0.7.0.1
 */