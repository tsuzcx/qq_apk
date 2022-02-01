import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class amnm<M extends ampu, V extends amxw>
  extends amlu<M, V>
{
  private List<FTSEntity> FP;
  FTSEntitySearchDetailActivity a;
  private int dCM;
  private int dCN;
  private int dCO;
  private List<amnq> jl;
  private String keyword;
  
  public amnm(ListView paramListView, aqdf paramaqdf, List<FTSEntity> paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramaqdf);
    this.FP = paramList;
    this.keyword = paramString;
    this.a = paramFTSEntitySearchDetailActivity;
    this.jl = new ArrayList();
  }
  
  private void akx()
  {
    if ((this.dCO - this.dCN == this.dCM) && (this.mScrollState == 0)) {
      initData();
    }
  }
  
  public void initData()
  {
    ArrayList localArrayList = aqoe.K(this.keyword);
    int j = this.jl.size();
    int i;
    if (j + 50 < this.FP.size()) {
      i = j + 50;
    }
    while (j < i)
    {
      amnq localamnq = amns.a(this.a.app, this.a.dCD, this.keyword, localArrayList, (FTSEntity)this.FP.get(j));
      if (localamnq != null) {
        this.jl.add(localamnq);
      }
      j += 1;
      continue;
      i = this.FP.size();
    }
    cS(this.jl);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dCN = paramInt1;
    this.dCM = paramInt2;
    this.dCO = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    akx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnm
 * JD-Core Version:    0.7.0.1
 */