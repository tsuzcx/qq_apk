import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class uow
  extends SimpleJob<Void>
{
  uow(uoh paramuoh, String paramString, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    tio.a();
    paramJobContext = this.jdField_a_of_type_JavaUtilList.toArray();
    int j = paramJobContext.length;
    int i = 0;
    while (i < j)
    {
      tio.a(paramJobContext[i].toString());
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */