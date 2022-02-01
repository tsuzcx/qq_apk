import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class axfg
  extends axzy
{
  private axzu<List<axby>> j = new axzu();
  private axzu<axcb> n = new axzu();
  private Map<String, axbv.a> qE = new HashMap();
  
  public void a(axzf paramaxzf, String paramString)
  {
    QLog.d("AEGIFMaterialViewModel", 4, "LoadingGifTplData");
    ThreadManager.getSubThreadHandler().post(new AEGIFMaterialViewModel.1(this, paramString));
    axbk.d().a(paramaxzf, new axfh(this, paramString));
  }
  
  public void a(AppInterface paramAppInterface, axdj paramaxdj)
  {
    axfi localaxfi = new axfi(this);
    this.qE.put(paramaxdj.c.id, localaxfi);
    axbv.a().a(paramAppInterface, paramaxdj.c, localaxfi);
  }
  
  public void acw(String paramString)
  {
    Object localObject1 = axbk.a();
    QLog.d("AEGIFMaterialViewModel", 4, "Parsing EmoCategories");
    if (localObject1 == null)
    {
      QLog.e("AEGIFMaterialViewModel", 4, "CategoryMaterialRsp is null");
      if ((localObject1 != null) && (((GetCategoryMaterialRsp)localObject1).Categories != null)) {
        break label54;
      }
    }
    for (;;)
    {
      return;
      if (((GetCategoryMaterialRsp)localObject1).Categories != null) {
        break;
      }
      QLog.e("AEGIFMaterialViewModel", 4, "Categories null");
      break;
      label54:
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.toLowerCase().equals(paramString));
      for (paramString = (String)localObject1; (paramString != null) && (paramString.materials != null); paramString = null)
      {
        localObject1 = new ArrayList();
        paramString = paramString.materials.iterator();
        if (paramString.hasNext())
        {
          localObject2 = (MetaMaterial)paramString.next();
          axby localaxby = new axby();
          localaxby.id = ((MetaMaterial)localObject2).id;
          localaxby.b = ((MetaMaterial)localObject2);
          if (axbv.a().a((MetaMaterial)localObject2)) {}
          for (int i = 2;; i = 0)
          {
            localaxby.state = i;
            ((List)localObject1).add(localaxby);
            break;
          }
        }
        QLog.e("AEGIFMaterialViewModel", 4, "Updating Materials size === " + ((List)localObject1).size());
        this.j.postValue(localObject1);
        return;
      }
    }
  }
  
  public axzu<List<axby>> g()
  {
    return this.j;
  }
  
  public axzu<axcb> k()
  {
    return this.n;
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.qE.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfg
 * JD-Core Version:    0.7.0.1
 */