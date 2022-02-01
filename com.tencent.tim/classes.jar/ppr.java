import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;

public class ppr
{
  public static Intent a(Context paramContext, int paramInt, String paramString)
  {
    return QQStoryMemoriesActivity.b(paramContext, paramInt, paramString);
  }
  
  public static void b(Context paramContext, int paramInt, long paramLong)
  {
    QQStoryMemoriesActivity.c(paramContext, paramInt, paramLong);
  }
  
  public static void f(Context paramContext, int paramInt, String paramString)
  {
    paramContext.startActivity(a(paramContext, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppr
 * JD-Core Version:    0.7.0.1
 */