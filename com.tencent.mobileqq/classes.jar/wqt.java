import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wqt
  implements wev
{
  public String a;
  public String b;
  
  public wqt(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public qqstory_struct.UserId a()
  {
    qqstory_struct.UserId localUserId = new qqstory_struct.UserId();
    if (!TextUtils.isEmpty(this.a)) {
      localUserId.uid.set(Long.valueOf(this.a).longValue());
    }
    localUserId.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localUserId;
  }
  
  public boolean a()
  {
    return (QQStoryContext.a().a(this.b)) || (QQStoryContext.a().b(this.a));
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof wqt))
    {
      this.a = ((wqt)paramObject).a;
      this.b = ((wqt)paramObject).b;
    }
  }
  
  public String toString()
  {
    return "UserID{qq=" + this.a + ", unionId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqt
 * JD-Core Version:    0.7.0.1
 */