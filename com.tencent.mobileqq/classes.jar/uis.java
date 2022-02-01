import com.tencent.mobileqq.utils.StringUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ValueJudgeUtil;", "", "()V", "isValidate", "", "obj", "judgeAndGet", "T", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "judgeAndGetInt", "", "judgeAndGetLong", "", "judgeAndGetString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uis
{
  public static final uis a = new uis();
  
  private final <T> T a(T paramT1, T paramT2)
  {
    if (a(paramT1)) {}
    while (!a(paramT2)) {
      return paramT1;
    }
    return paramT2;
  }
  
  private final boolean a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      if (((Number)paramObject).intValue() <= 0) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!(paramObject instanceof Long)) {
            break;
          }
        } while (((Number)paramObject).longValue() > 0L);
        return false;
        if (!(paramObject instanceof String)) {
          break;
        }
      } while (!StringUtil.isEmpty((String)paramObject));
      return false;
    } while (paramObject != null);
    return false;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return ((Number)a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).intValue();
  }
  
  public final long a(long paramLong1, long paramLong2)
  {
    return ((Number)a(Long.valueOf(paramLong1), Long.valueOf(paramLong2))).longValue();
  }
  
  @Nullable
  public final String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (String)a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uis
 * JD-Core Version:    0.7.0.1
 */