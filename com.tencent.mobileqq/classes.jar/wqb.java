import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class wqb
  extends umf<wpr, wiu>
{
  wqb(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull wiu paramwiu)
  {
    Object localObject = paramwpr.a(paramwiu.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramwiu.jdField_a_of_type_Boolean))
    {
      wxe.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramwiu.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramwiu.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof woi))
    {
      wxe.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (woi)localObject;
    ((CommentLikeFeedItem)((woi)localObject).a).mLikeCount = paramwiu.b;
    ((woi)localObject).b(paramwiu.jdField_a_of_type_JavaUtilList, true);
    wpr.a(paramwpr).b(paramwiu.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return wiu.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull wiu paramwiu) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */