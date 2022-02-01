import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class agwq
  implements AdapterView.c
{
  agwq(agwn paramagwn) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!agwn.a(this.a))
    {
      bool = true;
      agwn.a(paramAdapterView, bool);
      if (this.a.b != null) {
        this.a.b.as(agwn.a(this.a));
      }
      if (!agwn.a(this.a)) {
        break label110;
      }
      this.a.a.JJ(false);
      this.a.a.JK(false);
    }
    for (;;)
    {
      this.a.a.JP(agwn.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.a.JJ(true);
      this.a.djT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */