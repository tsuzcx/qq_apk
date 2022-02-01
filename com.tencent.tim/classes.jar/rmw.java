import android.text.TextUtils;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;

public class rmw
{
  public final rmw.a a;
  public final int joinCount;
  public final String wording;
  
  public rmw(qqstory_struct.TagItem paramTagItem)
  {
    this.a = new rmw.a((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.joinCount = paramTagItem.join_count.get();
    this.wording = paramTagItem.wording.get();
  }
  
  public rmw(TagItemEntry paramTagItemEntry)
  {
    this.a = new rmw.a(paramTagItemEntry.id, paramTagItemEntry.name, paramTagItemEntry.desc, paramTagItemEntry.type);
    this.joinCount = paramTagItemEntry.joinCount;
    this.wording = paramTagItemEntry.wording;
  }
  
  public rmw(rmw.a parama, int paramInt, String paramString)
  {
    this.a = parama;
    this.joinCount = paramInt;
    this.wording = paramString;
  }
  
  public TagItemEntry a()
  {
    TagItemEntry localTagItemEntry = new TagItemEntry();
    localTagItemEntry.id = this.a.id;
    localTagItemEntry.name = this.a.name;
    localTagItemEntry.desc = this.a.desc;
    localTagItemEntry.type = this.a.type;
    localTagItemEntry.joinCount = this.joinCount;
    localTagItemEntry.wording = this.wording;
    return localTagItemEntry;
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
      paramObject = (rmw)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toJSONString()
  {
    Object localObject = new JSONObject();
    try
    {
      if (this.a == null) {
        return null;
      }
      ((JSONObject)localObject).put("tag_id", this.a.id);
      ((JSONObject)localObject).put("tag_name", this.a.name);
      ((JSONObject)localObject).put("tag_desc", this.a.desc);
      ((JSONObject)localObject).put("tag_type", this.a.type);
      ((JSONObject)localObject).put("join_count", this.joinCount);
      ((JSONObject)localObject).put("wording", this.wording);
      ((JSONObject)localObject).put("one_page", 1);
      ((JSONObject)localObject).put("src_type", "web");
      ((JSONObject)localObject).put("version", 1);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public String toString()
  {
    return "TagItem{tagInfo=" + this.a + ", joinCount=" + this.joinCount + ", wording='" + this.wording + '\'' + '}';
  }
  
  public static class a
  {
    public final String desc;
    public final long id;
    public final String name;
    public final int type;
    public volatile long updateTime;
    
    public a(long paramLong, String paramString1, String paramString2, int paramInt)
    {
      this.id = paramLong;
      this.name = paramString1;
      this.desc = paramString2;
      this.type = paramInt;
    }
    
    public a(TagEntry paramTagEntry)
    {
      this.id = paramTagEntry.id;
      this.name = paramTagEntry.name;
      this.desc = paramTagEntry.desc;
      this.type = paramTagEntry.type;
    }
    
    public a(qqstory_struct.TagInfoBase paramTagInfoBase)
    {
      this.id = paramTagInfoBase.tag_id.get();
      this.name = paramTagInfoBase.tag_name.get();
      this.desc = paramTagInfoBase.tag_desc.get();
      this.type = paramTagInfoBase.tag_type.get();
    }
    
    public static boolean a(a parama)
    {
      return (parama != null) && (Math.abs(System.currentTimeMillis() - parama.updateTime) < 60000L);
    }
    
    public TagEntry a()
    {
      return new TagEntry();
    }
    
    public qqstory_struct.TagInfoBase a()
    {
      qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
      localTagInfoBase.tag_id.set(this.id);
      localTagInfoBase.tag_name.set(this.name);
      if (!TextUtils.isEmpty(this.desc)) {
        localTagInfoBase.tag_desc.set(this.desc);
      }
      localTagInfoBase.tag_type.set(this.type);
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
        paramObject = (a)paramObject;
        if (this.id != paramObject.id) {
          return false;
        }
      } while (this.type == paramObject.type);
      return false;
    }
    
    public int hashCode()
    {
      return (int)(this.id ^ this.id >>> 32) * 31 + this.type;
    }
    
    public String toString()
    {
      return "TagInfoBase{id=" + this.id + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", type=" + this.type + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmw
 * JD-Core Version:    0.7.0.1
 */