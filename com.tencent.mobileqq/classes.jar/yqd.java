import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import java.util.HashSet;

public class yqd
  extends QQLruCache
{
  public yqd(ApolloManager paramApolloManager, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public ApolloBaseInfo a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (paramApolloBaseInfo != null) {
      ApolloManager.a(this.a).remove(paramApolloBaseInfo.uin);
    }
    return (ApolloBaseInfo)super.put(paramString, paramApolloBaseInfo);
  }
  
  protected void a(boolean paramBoolean, String paramString, ApolloBaseInfo paramApolloBaseInfo1, ApolloBaseInfo paramApolloBaseInfo2)
  {
    super.entryRemoved(paramBoolean, paramString, paramApolloBaseInfo1, paramApolloBaseInfo2);
    if (paramApolloBaseInfo1 != null) {}
    try
    {
      ApolloManager.a(this.a).add(paramApolloBaseInfo1.uin);
      return;
    }
    catch (OutOfMemoryError paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqd
 * JD-Core Version:    0.7.0.1
 */