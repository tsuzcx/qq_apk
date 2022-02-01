import android.text.TextUtils;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class yml
{
  public final int a;
  public final long a;
  public final String a;
  public volatile long b;
  public final String b;
  
  public yml(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public yml(TagEntry paramTagEntry)
  {
    this.jdField_a_of_type_Long = paramTagEntry.id;
    this.jdField_a_of_type_JavaLangString = paramTagEntry.name;
    this.jdField_b_of_type_JavaLangString = paramTagEntry.desc;
    this.jdField_a_of_type_Int = paramTagEntry.type;
  }
  
  public yml(qqstory_struct.TagInfoBase paramTagInfoBase)
  {
    this.jdField_a_of_type_Long = paramTagInfoBase.tag_id.get();
    this.jdField_a_of_type_JavaLangString = paramTagInfoBase.tag_name.get();
    this.jdField_b_of_type_JavaLangString = paramTagInfoBase.tag_desc.get();
    this.jdField_a_of_type_Int = paramTagInfoBase.tag_type.get();
  }
  
  public static boolean a(yml paramyml)
  {
    return (paramyml != null) && (Math.abs(System.currentTimeMillis() - paramyml.jdField_b_of_type_Long) < 60000L);
  }
  
  public TagEntry a()
  {
    return new TagEntry();
  }
  
  public qqstory_struct.TagInfoBase a()
  {
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(this.jdField_a_of_type_Long);
    localTagInfoBase.tag_name.set(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localTagInfoBase.tag_desc.set(this.jdField_b_of_type_JavaLangString);
    }
    localTagInfoBase.tag_type.set(this.jdField_a_of_type_Int);
    return localTagInfoBase;
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
      paramObject = (yml)paramObject;
      if (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) {
        return false;
      }
    } while (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.jdField_a_of_type_Long ^ this.jdField_a_of_type_Long >>> 32) * 31 + this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    return "TagInfoBase{id=" + this.jdField_a_of_type_Long + ", name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", desc='" + this.jdField_b_of_type_JavaLangString + '\'' + ", type=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yml
 * JD-Core Version:    0.7.0.1
 */