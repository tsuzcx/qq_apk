import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqmt
  implements View.OnClickListener
{
  protected View Gt;
  protected Context X;
  protected aqmt.a a;
  protected final ausj an;
  
  public aqmt(Context paramContext)
  {
    this.X = paramContext;
    this.an = ((ausj)auss.a(paramContext, null));
  }
  
  protected View L()
  {
    View localView1 = View.inflate(this.X, 2131561050, null);
    View localView2 = localView1.findViewById(2131365527);
    View localView3 = localView1.findViewById(2131365516);
    View localView4 = localView1.findViewById(2131365514);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    return localView1;
  }
  
  public void a(aqmt.a parama)
  {
    this.a = parama;
  }
  
  public void dismiss()
  {
    if (isShowing()) {}
    try
    {
      this.an.dismiss();
      this.Gt = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("TeamWorkCreateActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public boolean isShowing()
  {
    return this.an.isShowing();
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.Wq(i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void show()
  {
    if (this.Gt == null) {
      this.Gt = L();
    }
    this.an.setActionContentView(this.Gt, null);
    try
    {
      if (!isShowing()) {
        this.an.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TeamWorkCreateActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public static abstract interface a
  {
    public abstract void Wq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmt
 * JD-Core Version:    0.7.0.1
 */