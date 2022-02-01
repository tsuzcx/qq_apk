import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class osu
  extends oso
{
  public osu(oqi.b paramb)
  {
    super(paramb);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.a != null)
    {
      oqp.a().a(2, paramBoolean1, paramBoolean2, paramString, this.a.bq(), this, System.currentTimeMillis());
      return true;
    }
    return false;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    ooz.e("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof osf))
    {
      paramViewHolder = new sct(4, new Object[] { Integer.valueOf(paramInt), ((osf)paramViewHolder).be });
      pmi.a().dispatch(paramViewHolder);
    }
    if (paramInt > 0)
    {
      if ((!oog.et(paramInt)) || (this.a == null)) {
        break label105;
      }
      this.a.uU(paramInt);
    }
    label105:
    while ((ohy.a().rv() != paramInt) || (this.a == null)) {
      return;
    }
    this.a.bgh();
  }
  
  public List<oqr> d(ArrayList paramArrayList)
  {
    return oqp.a().e(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osu
 * JD-Core Version:    0.7.0.1
 */