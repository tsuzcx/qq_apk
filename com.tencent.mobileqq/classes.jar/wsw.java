import android.support.annotation.Nullable;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.videostory.capture.AEVideoStoryGIFTplViewModel.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class wsw
  extends bhwk
{
  private bhwf<List<wqk>> jdField_a_of_type_Bhwf = new bhwf();
  private Map<String, wqj> jdField_a_of_type_JavaUtilMap = new HashMap();
  private bhwf<wqg> b = new bhwf();
  private bhwf<String> c = new bhwf();
  private bhwf<String> d = new bhwf();
  
  private void c()
  {
    Object localObject1 = avzk.a();
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
      } while (!((MetaCategory)localObject1).name.equals(ajjy.a(2131634215)));
      while ((localObject1 != null) && (((MetaCategory)localObject1).materials != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((MetaCategory)localObject1).materials.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)((Iterator)localObject1).next();
          wqk localwqk = new wqk();
          localwqk.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
          localwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
          if (wqh.a().a(localMetaMaterial)) {}
          for (int i = 2;; i = 0)
          {
            localwqk.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localwqk);
            break;
          }
        }
        this.jdField_a_of_type_Bhwf.a(localObject2);
        return;
        localObject1 = null;
      }
    }
  }
  
  public bhwf<List<wqk>> a()
  {
    return this.jdField_a_of_type_Bhwf;
  }
  
  public void a()
  {
    this.c.a(this.c.a());
  }
  
  public void a(bhcw parambhcw)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.1(this));
    avzk.a().a(parambhcw, new wsx(this));
  }
  
  public void a(AppInterface paramAppInterface, wqk paramwqk)
  {
    wsy localwsy = new wsy(this);
    this.jdField_a_of_type_JavaUtilMap.put(paramwqk.jdField_a_of_type_JavaLangString, localwsy);
    wqh.a().a(paramAppInterface, paramwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, localwsy);
  }
  
  public void a(@Nullable wqk paramwqk)
  {
    if (paramwqk != null)
    {
      paramwqk = wqh.a().a(paramwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      this.c.a(paramwqk);
      return;
    }
    this.c.a(null);
  }
  
  public bhwf<wqg> b()
  {
    return this.b;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(@Nullable wqk paramwqk)
  {
    if (paramwqk != null)
    {
      paramwqk = (String)paramwqk.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.additionalFields.get("savename");
      this.d.a(paramwqk);
      return;
    }
    this.d.a(null);
  }
  
  public bhwf<String> c()
  {
    return this.c;
  }
  
  public bhwf<String> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsw
 * JD-Core Version:    0.7.0.1
 */