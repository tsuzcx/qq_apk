import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

class pnc
  extends Job<Object, Object, Object>
{
  pnc(pnb parampnb, String paramString, png parampng)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_Png.a.a(this.jdField_a_of_type_Png);
    this.jdField_a_of_type_Pnb.atR = this.jdField_a_of_type_Png.downloadKey;
    this.jdField_a_of_type_Pnb.fC.put(this.jdField_a_of_type_Png.downloadKey, this.jdField_a_of_type_Png);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnc
 * JD-Core Version:    0.7.0.1
 */