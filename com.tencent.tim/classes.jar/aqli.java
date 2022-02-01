import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqli
  extends BaseAdapter
{
  aqli(aqlh paramaqlh) {}
  
  public int getCount()
  {
    if (this.c.items != null) {
      return this.c.items.length;
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
    if (this.c.inflater == null) {
      this.c.inflater = ((LayoutInflater)this.c.getContext().getSystemService("layout_inflater"));
    }
    aqlh.b localb;
    if (paramView == null)
    {
      paramView = this.c.inflater.inflate(2131559139, null);
      localb = new aqlh.b(this.c, null);
      localb.text = ((TextView)paramView.findViewById(2131369530));
      paramView.setTag(localb);
    }
    for (;;)
    {
      localb = (aqlh.b)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localb.text != null)
      {
        localb.text.setText(this.c.items[paramInt]);
        localb.text.setOnClickListener(new aqlh.a(this.c, paramInt));
        i = localb.text.getPaddingTop();
        j = localb.text.getPaddingLeft();
        k = localb.text.getPaddingRight();
        m = localb.text.getPaddingBottom();
        if (this.c.items.length != 1) {
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
        } else if (paramInt == this.c.items.length - 1) {
          localb.text.setBackgroundResource(2130839806);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqli
 * JD-Core Version:    0.7.0.1
 */