import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afto
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private afwg a;
  private TextView ni;
  
  public afto(View paramView, afwg paramafwg)
  {
    super(paramView);
    this.a = paramafwg;
    this.ni = ((TextView)paramView.findViewById(2131381118));
    this.ni.setOnClickListener(this);
    this.ni.setOnTouchListener(afyk.A);
  }
  
  public void a(afto paramafto, afua paramafua)
  {
    String str = "";
    boolean bool = false;
    switch (paramafua.mFooterType)
    {
    default: 
      paramafua = str;
    }
    for (;;)
    {
      paramafto.ni.setText(paramafua);
      paramafto.ni.setEnabled(bool);
      return;
      paramafua = acfp.m(2131706417);
      continue;
      paramafua = acfp.m(2131706419);
      bool = true;
      continue;
      paramafua = acfp.m(2131706418);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dce();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afto
 * JD-Core Version:    0.7.0.1
 */