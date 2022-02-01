import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

class tif
  implements tir
{
  tif(tia paramtia) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    if (tia.a(this.a, localJSONObject))
    {
      tia.a(this.a, paramViewBase, paramContext, paramProteusItemData);
      return;
    }
    tia.b(this.a, paramViewBase, paramContext, paramProteusItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */