import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aycu
  implements AdapterView.OnItemClickListener
{
  aycu(aycm paramaycm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (aycm.a(this.this$0) != null) {
      asgr.mt(aycm.a(this.this$0).hashCode());
    }
    prt.c localc = aycm.a(this.this$0).a(paramInt);
    if (aycm.a(this.this$0).OQ() == paramInt) {
      if (localc.aBq) {
        aycm.a(this.this$0, true);
      }
    }
    for (;;)
    {
      rar.a("textEdit_patten", "clk_patten", aycm.b(this.this$0), 0, new String[] { "", localc.auD });
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (localc.aBr)
      {
        if (aqiw.isNetSupport(paramView.getContext()))
        {
          QQToast.a(aycm.a(this.this$0).getContext(), acfp.m(2131714836), 0).show();
          aycm.a(this.this$0, localc);
        }
        else
        {
          aycm.b(this.this$0);
        }
      }
      else
      {
        QQToast.a(aycm.a(this.this$0).getContext(), acfp.m(2131714834), 0).show();
        continue;
        aycm.a(this.this$0).Wc(paramInt);
        aycm.a(this.this$0, localc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycu
 * JD-Core Version:    0.7.0.1
 */