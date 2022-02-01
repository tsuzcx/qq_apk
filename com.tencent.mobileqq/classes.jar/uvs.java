import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uvs
  extends uvh
{
  public uvs(urv paramurv)
  {
    super(paramurv);
  }
  
  public List<usv> a(ArrayList paramArrayList)
  {
    return WSVerticalDataManager.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    uqf.d("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    urv localurv = a();
    if (localurv == null) {}
    do
    {
      do
      {
        return;
        if ((paramViewHolder instanceof uuy))
        {
          paramViewHolder = new uhe(4, new Object[] { Integer.valueOf(paramInt), ((uuy)paramViewHolder).a });
          wjj.a().dispatch(paramViewHolder);
        }
      } while (paramInt <= 0);
      if (ugd.a().a(paramInt, 2))
      {
        localurv.a(paramInt, 2);
        return;
      }
    } while (ugd.a().d(2) != paramInt);
    localurv.a(ugd.a().a(2));
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    urv localurv = a();
    if (localurv == null) {
      return false;
    }
    WSVerticalDataManager.a().a(2, paramBoolean1, paramBoolean2, paramString, localurv.a(), this, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvs
 * JD-Core Version:    0.7.0.1
 */