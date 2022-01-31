import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class wls
  extends uhw<wli, wel>
{
  wls(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull wel paramwel)
  {
    Object localObject = paramwli.a(paramwel.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramwel.jdField_a_of_type_Boolean))
    {
      wsv.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramwel.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramwel.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof wjz))
    {
      wsv.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (wjz)localObject;
    ((CommentLikeFeedItem)((wjz)localObject).a).mLikeCount = paramwel.b;
    ((wjz)localObject).b(paramwel.jdField_a_of_type_JavaUtilList, true);
    wli.a(paramwli).b(paramwel.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return wel.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull wel paramwel) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wls
 * JD-Core Version:    0.7.0.1
 */