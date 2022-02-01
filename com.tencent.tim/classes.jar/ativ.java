import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.tim.cloudfile.ListViewRefreshController.1;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

public class ativ
  implements auuo, AbsListView.e
{
  private View HG;
  private View HH;
  private TextView ZQ;
  private ativ.a a;
  private ProgressBar ax;
  private PullRefreshHeader b;
  private String cGQ;
  private boolean cLg;
  private boolean cLh;
  private Context context;
  private XListView m;
  private Handler mHandler;
  
  public ativ(Context paramContext, String paramString, XListView paramXListView, PullRefreshHeader paramPullRefreshHeader, ativ.a parama)
  {
    this.context = paramContext;
    this.cGQ = paramString;
    this.m = paramXListView;
    this.b = paramPullRefreshHeader;
    this.a = parama;
    this.m.setOverScrollListener(this);
    this.HG = LayoutInflater.from(paramContext).inflate(2131558971, null);
    this.HH = this.HG.findViewById(2131379288);
    this.ZQ = ((TextView)this.HG.findViewById(2131379287));
    this.ax = ((ProgressBar)this.HG.findViewById(2131379286));
    this.m.addFooterView(this.HG);
    this.mHandler = new Handler();
  }
  
  private void ckI()
  {
    long l = System.currentTimeMillis();
    this.context.getSharedPreferences("sp_name_refresh_time", 0).edit().putLong(this.cGQ, l).commit();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramInt == 0) && (this.b != null)) {
      this.b.Q(0L);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      if (this.b != null) {
        this.b.S(0L);
      }
      if (this.a != null) {
        this.a.bLR();
      }
      return true;
    }
    return false;
  }
  
  public void aGQ()
  {
    if (this.HH != null) {
      this.HH.setVisibility(8);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramInt == 0) && (this.b != null)) {
      this.b.R(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void cG(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ckI();
    }
    if (this.b != null)
    {
      if (!paramBoolean1) {
        break label63;
      }
      this.b.tT(0);
    }
    for (;;)
    {
      if (this.mHandler != null) {
        this.mHandler.postDelayed(new ListViewRefreshController.1(this), 2000L);
      }
      if (!paramBoolean2) {
        break;
      }
      lz(false);
      return;
      label63:
      this.b.tT(1);
    }
    lz(true);
  }
  
  public void lz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ax.setVisibility(0);
      this.ZQ.setText(2131720954);
      return;
    }
    this.ax.setVisibility(8);
    this.ZQ.setVisibility(8);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 0) && (paramInt1 + paramInt2 == paramInt3))
    {
      this.cLg = true;
      if (paramInt3 <= paramInt2)
      {
        this.cLh = false;
        return;
      }
      this.cLh = true;
      return;
    }
    this.cLg = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((this.cLg) && (this.m != null) && (this.m.getCount() > 0) && (this.cLh) && (paramInt != 0) && (this.a != null)) {
        this.a.aSa();
      }
      return;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.HH.setVisibility(0);
      return;
    }
    this.HH.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void aSa();
    
    public abstract void bLR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ativ
 * JD-Core Version:    0.7.0.1
 */