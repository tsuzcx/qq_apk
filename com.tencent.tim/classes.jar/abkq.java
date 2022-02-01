import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogView.1;
import java.util.ArrayList;
import java.util.List;

public class abkq
{
  private abks a;
  private Context mContext;
  private int mLogLevel;
  private RecyclerView mRecyclerView;
  
  public abkq(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mLogLevel = paramInt;
  }
  
  private List<abkr> dE()
  {
    abkj localabkj = abmt.a();
    if (localabkj != null) {
      return localabkj.I(this.mLogLevel);
    }
    return new ArrayList();
  }
  
  public void DK(boolean paramBoolean)
  {
    if (this.a != null)
    {
      if (paramBoolean) {
        cCE();
      }
      this.a.setDatas(dE());
      this.a.notifyDataSetChanged();
      this.mRecyclerView.scrollToPosition(this.a.getItemCount() - 1);
    }
  }
  
  public void cCE()
  {
    this.mRecyclerView.post(new CmGameDebugLogView.1(this));
  }
  
  public View createView()
  {
    return LayoutInflater.from(this.mContext).inflate(2131559002, null);
  }
  
  public View getView()
  {
    View localView = createView();
    gk(localView);
    return localView;
  }
  
  public void gk(View paramView)
  {
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131364826));
    paramView = new LinearLayoutManager(this.mContext);
    this.mRecyclerView.setLayoutManager(paramView);
    this.a = new abks(this.mContext, dE());
    paramView = new View(this.mContext);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 32.0F)));
    this.a.setFooterView(paramView);
    paramView.setId(2131362775);
    this.mRecyclerView.setAdapter(this.a);
    cCE();
  }
  
  public int zC()
  {
    return this.mLogLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkq
 * JD-Core Version:    0.7.0.1
 */