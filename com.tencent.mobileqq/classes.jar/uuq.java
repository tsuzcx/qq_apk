import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uuq
  extends uuf
{
  public uuq(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  public List<uru> a(ArrayList paramArrayList)
  {
    return WSVerticalDataManager.a().a(paramArrayList);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    upe.d("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + paramInt);
    uqu localuqu = a();
    if (localuqu == null) {}
    do
    {
      do
      {
        return;
        if ((paramViewHolder instanceof utw))
        {
          paramViewHolder = new uhc(4, new Object[] { Integer.valueOf(paramInt), ((utw)paramViewHolder).a });
          wfo.a().dispatch(paramViewHolder);
        }
      } while (paramInt <= 0);
      if (uof.a(paramInt))
      {
        localuqu.d(paramInt);
        return;
      }
    } while (ugb.a().g() != paramInt);
    localuqu.d();
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    uqu localuqu = a();
    if (localuqu == null) {
      return false;
    }
    WSVerticalDataManager.a().a(2, paramBoolean1, paramBoolean2, paramString, localuqu.a(), this, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuq
 * JD-Core Version:    0.7.0.1
 */