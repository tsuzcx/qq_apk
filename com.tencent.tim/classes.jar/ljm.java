import android.support.annotation.Nullable;
import java.util.List;

public class ljm<BEAN, VIEW extends ljh.d<BEAN>>
  implements ljh.c<BEAN, VIEW>
{
  private ljh.b<BEAN> jdField_a_of_type_Ljh$b;
  private ljh.d<BEAN> jdField_a_of_type_Ljh$d;
  private boolean akE;
  
  public ljm(ljh.b<BEAN> paramb)
  {
    this.jdField_a_of_type_Ljh$b = paramb;
  }
  
  private void b(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    if ((this.akE) && (this.jdField_a_of_type_Ljh$d != null)) {
      this.jdField_a_of_type_Ljh$d.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Ljh$d != null))
    {
      this.jdField_a_of_type_Ljh$d.setCenterHide();
      this.jdField_a_of_type_Ljh$d.setListData(paramList, false);
      this.jdField_a_of_type_Ljh$d.setFooterNoMore();
    }
    while ((this.akE) || (this.jdField_a_of_type_Ljh$d == null)) {
      return;
    }
    this.jdField_a_of_type_Ljh$d.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_Ljh$d.setTotal(0);
  }
  
  private void c(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      cD(paramList);
      return;
    }
    v(paramInt, paramList);
  }
  
  private void cD(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Ljh$d != null)
      {
        this.jdField_a_of_type_Ljh$d.setCenterHide();
        this.jdField_a_of_type_Ljh$d.setListData(paramList, false);
        this.jdField_a_of_type_Ljh$d.setFooterNoMore();
        this.jdField_a_of_type_Ljh$d.setHeaderLoading();
      }
      this.akE = true;
    }
  }
  
  private void v(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Ljh$d != null)
    {
      if (this.akE) {
        this.jdField_a_of_type_Ljh$d.setHeaderSuccess();
      }
      u(paramInt, paramList);
    }
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Ljh$d = paramVIEW;
  }
  
  public void aMF()
  {
    if (this.jdField_a_of_type_Ljh$d != null) {
      this.jdField_a_of_type_Ljh$d.setCenterLoading();
    }
    this.jdField_a_of_type_Ljh$b.a(true, new ljn(this));
  }
  
  public void aMG()
  {
    if (!this.jdField_a_of_type_Ljh$b.Cz())
    {
      if (this.jdField_a_of_type_Ljh$d != null) {
        this.jdField_a_of_type_Ljh$d.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_Ljh$d != null) {
      this.jdField_a_of_type_Ljh$d.setFooterLoading();
    }
    this.jdField_a_of_type_Ljh$b.a(new ljo(this));
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Ljh$d = null;
  }
  
  public void u(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Ljh$d != null)
    {
      this.jdField_a_of_type_Ljh$d.setTotal(paramInt);
      this.jdField_a_of_type_Ljh$d.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Ljh$d.setCenterHide();
      if (this.jdField_a_of_type_Ljh$b.Cz()) {
        this.jdField_a_of_type_Ljh$d.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ljh$d.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_Ljh$d.setCenterEmpty();
    this.jdField_a_of_type_Ljh$d.setFooterHide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */