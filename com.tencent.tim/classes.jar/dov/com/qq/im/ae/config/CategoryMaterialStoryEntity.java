package dov.com.qq.im.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CategoryMaterialStoryEntity
  extends Entity
{
  public String additionalFields;
  public String bigId;
  public String bigName;
  public String bigThumbUrl;
  public String id;
  public String packageUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  public static List<CategoryMaterialStoryEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp paramGetCategoryMaterialRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramGetCategoryMaterialRsp = paramGetCategoryMaterialRsp.Categories.iterator();
    while (paramGetCategoryMaterialRsp.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)paramGetCategoryMaterialRsp.next();
      Iterator localIterator = localMetaCategory.materials.iterator();
      while (localIterator.hasNext())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
        CategoryMaterialStoryEntity localCategoryMaterialStoryEntity = new CategoryMaterialStoryEntity();
        localCategoryMaterialStoryEntity.bigId = localMetaCategory.id;
        localCategoryMaterialStoryEntity.bigName = localMetaCategory.name;
        localCategoryMaterialStoryEntity.bigThumbUrl = localMetaCategory.thumbUrl;
        localCategoryMaterialStoryEntity.id = localMetaMaterial.id;
        localCategoryMaterialStoryEntity.thumbUrl = localMetaMaterial.thumbUrl;
        localCategoryMaterialStoryEntity.thumbWidth = localMetaMaterial.thumbWidth;
        localCategoryMaterialStoryEntity.thumbHeight = localMetaMaterial.thumbHeight;
        localCategoryMaterialStoryEntity.packageUrl = localMetaMaterial.packageUrl;
        localCategoryMaterialStoryEntity.additionalFields = mapToJson(localMetaMaterial.additionalFields);
        localArrayList.add(localCategoryMaterialStoryEntity);
      }
    }
    return localArrayList;
  }
  
  private static String mapToJson(Map<String, String> paramMap)
  {
    return new Gson().toJson(paramMap);
  }
  
  public String toString()
  {
    return "CategoryMaterialStoryEntity{bigId='" + this.bigId + '\'' + ", bigName='" + this.bigName + '\'' + ", bigThumbUrl='" + this.bigThumbUrl + '\'' + ", id='" + this.id + '\'' + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", packageUrl='" + this.packageUrl + '\'' + ", additionalFields='" + this.additionalFields + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CategoryMaterialStoryEntity
 * JD-Core Version:    0.7.0.1
 */