import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoStoryId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tribe.async.utils.AssertUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class tny
{
  @NonNull
  public final String a;
  @NonNull
  public final Map<String, String> a;
  @NonNull
  public String b;
  
  public tny(@NonNull qqstory_group.GroupFeed paramGroupFeed)
  {
    this.jdField_a_of_type_JavaLangString = paramGroupFeed.union_id.get().toStringUtf8();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramGroupFeed.story_id_list.get().iterator();
    if (localIterator.hasNext())
    {
      qqstory_group.VideoStoryId localVideoStoryId = (qqstory_group.VideoStoryId)localIterator.next();
      String str = localVideoStoryId.story_id.get().toStringUtf8();
      if (!TextUtils.isEmpty(str)) {}
      for (boolean bool = true;; bool = false)
      {
        AssertUtils.assertTrue(bool);
        localHashMap.put(localVideoStoryId.vid.get().toStringUtf8(), str);
        this.b = localVideoStoryId.feed_id.get().toStringUtf8();
        break;
      }
    }
    if (TextUtils.isEmpty(this.b)) {
      this.b = paramGroupFeed.feed_id.get().toStringUtf8();
    }
    this.jdField_a_of_type_JavaUtilMap = Collections.unmodifiableMap(localHashMap);
  }
  
  public String toString()
  {
    return "AddGroupFeed[" + this.jdField_a_of_type_JavaLangString + "," + this.b + "," + this.jdField_a_of_type_JavaUtilMap + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tny
 * JD-Core Version:    0.7.0.1
 */