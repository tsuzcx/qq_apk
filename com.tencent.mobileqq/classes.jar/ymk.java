import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;

public class ymk
{
  public final int a;
  public final String a;
  public final yml a;
  
  public ymk(qqstory_struct.TagItem paramTagItem)
  {
    this.jdField_a_of_type_Yml = new yml((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.jdField_a_of_type_Int = paramTagItem.join_count.get();
    this.jdField_a_of_type_JavaLangString = paramTagItem.wording.get();
  }
  
  public ymk(TagItemEntry paramTagItemEntry)
  {
    this.jdField_a_of_type_Yml = new yml(paramTagItemEntry.id, paramTagItemEntry.name, paramTagItemEntry.desc, paramTagItemEntry.type);
    this.jdField_a_of_type_Int = paramTagItemEntry.joinCount;
    this.jdField_a_of_type_JavaLangString = paramTagItemEntry.wording;
  }
  
  public ymk(yml paramyml, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Yml = paramyml;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public TagItemEntry a()
  {
    TagItemEntry localTagItemEntry = new TagItemEntry();
    localTagItemEntry.id = this.jdField_a_of_type_Yml.jdField_a_of_type_Long;
    localTagItemEntry.name = this.jdField_a_of_type_Yml.jdField_a_of_type_JavaLangString;
    localTagItemEntry.desc = this.jdField_a_of_type_Yml.b;
    localTagItemEntry.type = this.jdField_a_of_type_Yml.jdField_a_of_type_Int;
    localTagItemEntry.joinCount = this.jdField_a_of_type_Int;
    localTagItemEntry.wording = this.jdField_a_of_type_JavaLangString;
    return localTagItemEntry;
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Yml == null) {
        return null;
      }
      ((JSONObject)localObject).put("tag_id", this.jdField_a_of_type_Yml.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("tag_name", this.jdField_a_of_type_Yml.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("tag_desc", this.jdField_a_of_type_Yml.b);
      ((JSONObject)localObject).put("tag_type", this.jdField_a_of_type_Yml.jdField_a_of_type_Int);
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
      paramObject = (ymk)paramObject;
      if (this.jdField_a_of_type_Yml != null) {
        return this.jdField_a_of_type_Yml.equals(paramObject.jdField_a_of_type_Yml);
      }
    } while (paramObject.jdField_a_of_type_Yml == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Yml != null) {
      return this.jdField_a_of_type_Yml.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "TagItem{tagInfo=" + this.jdField_a_of_type_Yml + ", joinCount=" + this.jdField_a_of_type_Int + ", wording='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymk
 * JD-Core Version:    0.7.0.1
 */