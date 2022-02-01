package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MetaCategory
  extends JceStruct
{
  static Map<String, String> cache_dynamicFields;
  static ArrayList<MetaMaterial> cache_materials;
  static ArrayList<MetaCategory> cache_subCategories = new ArrayList();
  public Map<String, String> dynamicFields;
  public String id = "";
  public ArrayList<MetaMaterial> materials;
  public String name = "";
  public ArrayList<MetaCategory> subCategories;
  public String thumbUrl = "";
  
  static
  {
    Object localObject = new MetaCategory();
    cache_subCategories.add(localObject);
    cache_materials = new ArrayList();
    localObject = new MetaMaterial();
    cache_materials.add(localObject);
    cache_dynamicFields = new HashMap();
    cache_dynamicFields.put("", "");
  }
  
  public MetaCategory() {}
  
  public MetaCategory(String paramString1, String paramString2, String paramString3, ArrayList<MetaCategory> paramArrayList, ArrayList<MetaMaterial> paramArrayList1, Map<String, String> paramMap)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.thumbUrl = paramString3;
    this.subCategories = paramArrayList;
    this.materials = paramArrayList1;
    this.dynamicFields = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.thumbUrl = paramJceInputStream.readString(2, false);
    this.subCategories = ((ArrayList)paramJceInputStream.read(cache_subCategories, 3, false));
    this.materials = ((ArrayList)paramJceInputStream.read(cache_materials, 4, false));
    this.dynamicFields = ((Map)paramJceInputStream.read(cache_dynamicFields, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    if (this.thumbUrl != null) {
      paramJceOutputStream.write(this.thumbUrl, 2);
    }
    if (this.subCategories != null) {
      paramJceOutputStream.write(this.subCategories, 3);
    }
    if (this.materials != null) {
      paramJceOutputStream.write(this.materials, 4);
    }
    if (this.dynamicFields != null) {
      paramJceOutputStream.write(this.dynamicFields, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory
 * JD-Core Version:    0.7.0.1
 */