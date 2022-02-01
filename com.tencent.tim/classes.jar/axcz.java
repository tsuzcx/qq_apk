import android.support.annotation.Nullable;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class axcz
  extends axzy
{
  private axzu<List<axby>> j = new axzu();
  private axzu<axcb> k = new axzu();
  private axzu<axby> l = new axzu();
  private axzu<String> m = new axzu();
  private Map<String, axbv.a> qE = new HashMap();
  
  private void eIW()
  {
    Object localObject1 = axbk.a();
    if ((localObject1 == null) || (((GetCategoryMaterialRsp)localObject1).Categories == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = ((GetCategoryMaterialRsp)localObject1).Categories.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MetaCategory)((Iterator)localObject2).next();
      } while (!((MetaCategory)localObject1).name.equals(acfp.m(2131702174)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          axby localaxby = new axby();
          localaxby.id = localMetaMaterial.id;
          localaxby.b = localMetaMaterial;
          if (axbv.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localaxby.state = i;
            ((List)localObject2).add(localaxby);
            break;
          }
        }
        this.j.postValue(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public void d(axby paramaxby)
  {
    axdb localaxdb = new axdb(this);
    this.qE.put(paramaxby.id, localaxdb);
    axbv.a().a(axol.getAppInterface(), paramaxby.b, localaxdb);
  }
  
  public void e(@Nullable axby paramaxby)
  {
    this.l.postValue(paramaxby);
  }
  
  public void eIX()
  {
    axby localaxby = (axby)this.l.getValue();
    axiy.i("AEVideoStoryGIFTplViewModel", "applyGIFTplAgain---lastMaterial=" + localaxby);
    this.l.postValue(localaxby);
  }
  
  public void f(@Nullable axby paramaxby)
  {
    if (paramaxby != null)
    {
      paramaxby = (String)paramaxby.b.additionalFields.get("savename");
      this.m.postValue(paramaxby);
      return;
    }
    this.m.postValue(null);
  }
  
  public axzu<List<axby>> g()
  {
    return this.j;
  }
  
  public axzu<axcb> h()
  {
    return this.k;
  }
  
  public axzu<axby> i()
  {
    return this.l;
  }
  
  public axzu<String> j()
  {
    return this.m;
  }
  
  public void k(awtq paramawtq)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    axbk.d().a(paramawtq, new axda(this));
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.qE.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcz
 * JD-Core Version:    0.7.0.1
 */