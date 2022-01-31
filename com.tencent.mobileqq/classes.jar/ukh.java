import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class ukh
  extends sgl<ujx, uda>
{
  ukh(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull uda paramuda)
  {
    Object localObject = paramujx.a(paramuda.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramuda.jdField_a_of_type_Boolean))
    {
      urk.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramuda.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramuda.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof uio))
    {
      urk.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (uio)localObject;
    ((CommentLikeFeedItem)((uio)localObject).a).mLikeCount = paramuda.b;
    ((uio)localObject).b(paramuda.jdField_a_of_type_JavaUtilList, true);
    ujx.a(paramujx).b(paramuda.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return uda.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull uda paramuda) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukh
 * JD-Core Version:    0.7.0.1
 */