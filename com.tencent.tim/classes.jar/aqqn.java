import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;

public abstract interface aqqn
{
  public abstract boolean canUpdate(@Nullable QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2);
  
  public abstract boolean deleteFiles(@Nullable QQAppInterface paramQQAppInterface, long paramLong, String paramString);
  
  public abstract VasQuickUpdateEngine.TagItemInfo getItemInfo(@Nullable QQAppInterface paramQQAppInterface, long paramLong, String paramString);
  
  public abstract boolean isFileExists(@Nullable QQAppInterface paramQQAppInterface, long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqn
 * JD-Core Version:    0.7.0.1
 */