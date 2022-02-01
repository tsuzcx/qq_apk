import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;

public class zlk
{
  public final int a;
  public final String a;
  public final zll a;
  
  public zlk(qqstory_struct.TagItem paramTagItem)
  {
    this.jdField_a_of_type_Zll = new zll((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.jdField_a_of_type_Int = paramTagItem.join_count.get();
    this.jdField_a_of_type_JavaLangString = paramTagItem.wording.get();
  }
  
  public zlk(TagItemEntry paramTagItemEntry)
  {
    this.jdField_a_of_type_Zll = new zll(paramTagItemEntry.id, paramTagItemEntry.name, paramTagItemEntry.desc, paramTagItemEntry.type);
    this.jdField_a_of_type_Int = paramTagItemEntry.joinCount;
    this.jdField_a_of_type_JavaLangString = paramTagItemEntry.wording;
  }
  
  public zlk(zll paramzll, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Zll = paramzll;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public TagItemEntry a()
  {
    TagItemEntry localTagItemEntry = new TagItemEntry();
    localTagItemEntry.id = this.jdField_a_of_type_Zll.jdField_a_of_type_Long;
    localTagItemEntry.name = this.jdField_a_of_type_Zll.jdField_a_of_type_JavaLangString;
    localTagItemEntry.desc = this.jdField_a_of_type_Zll.b;
    localTagItemEntry.type = this.jdField_a_of_type_Zll.jdField_a_of_type_Int;
    localTagItemEntry.joinCount = this.jdField_a_of_type_Int;
    localTagItemEntry.wording = this.jdField_a_of_type_JavaLangString;
    return localTagItemEntry;
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Zll == null) {
        return null;
      }
      ((JSONObject)localObject).put("tag_id", this.jdField_a_of_type_Zll.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("tag_name", this.jdField_a_of_type_Zll.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("tag_desc", this.jdField_a_of_type_Zll.b);
      ((JSONObject)localObject).put("tag_type", this.jdField_a_of_type_Zll.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("join_count", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("wording", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("one_page", 1);
      ((JSONObject)localObject).put("src_type", "web");
      ((JSONObject)localObject).put("version", 1);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zlk)paramObject;
      if (this.jdField_a_of_type_Zll != null) {
        return this.jdField_a_of_type_Zll.equals(paramObject.jdField_a_of_type_Zll);
      }
    } while (paramObject.jdField_a_of_type_Zll == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Zll != null) {
      return this.jdField_a_of_type_Zll.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "TagItem{tagInfo=" + this.jdField_a_of_type_Zll + ", joinCount=" + this.jdField_a_of_type_Int + ", wording='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlk
 * JD-Core Version:    0.7.0.1
 */