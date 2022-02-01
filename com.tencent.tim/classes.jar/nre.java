import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class nre
  extends nrc
{
  private nre.a a;
  private List<String> gJ;
  private List<String> gK;
  protected boolean mHasInit;
  
  public nre(Activity paramActivity, nre.a parama, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.a = parama;
    this.gK = paramList1;
    this.gJ = paramList2;
  }
  
  public void aO(View paramView)
  {
    if (!this.mHasInit)
    {
      initUI();
      this.mHasInit = true;
    }
    dj(paramView);
  }
  
  public View b(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131560336, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131365216);
    kwu localkwu = new kwu(this.mActivity, this.gK, this.gJ, this.a);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
    localRecyclerView.setAdapter(localkwu);
    return paramLayoutInflater;
  }
  
  public static abstract interface a
  {
    public abstract void bz(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nre
 * JD-Core Version:    0.7.0.1
 */