import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class wdo
  extends SimpleJob
{
  wdo(wdn paramwdn, String paramString, wdq paramwdq, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_Wdn.a();
    this.jdField_a_of_type_Wdn.b();
    ((uqo)urr.a(17)).a(this.jdField_a_of_type_Wdq.a, wdn.a(this.jdField_a_of_type_Wdn).a, wdn.a(this.jdField_a_of_type_Wdn).a(), this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wdn.a("Q.qqstory.detail:CommentListPageLoader");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdo
 * JD-Core Version:    0.7.0.1
 */