import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class tij
  implements tir
{
  tij(tia paramtia) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      ((AuthorData)paramProteusItemData).b(false);
      if (thz.a(this.a.a) != null) {
        thz.a(this.a.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */