import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class uxd
  extends sth<uwt, upw>
{
  uxd(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull upw paramupw)
  {
    Object localObject = paramuwt.a(paramupw.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramupw.jdField_a_of_type_Boolean))
    {
      veg.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramupw.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramupw.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof uvk))
    {
      veg.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (uvk)localObject;
    ((CommentLikeFeedItem)((uvk)localObject).a).mLikeCount = paramupw.b;
    ((uvk)localObject).b(paramupw.jdField_a_of_type_JavaUtilList, true);
    uwt.a(paramuwt).b(paramupw.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return upw.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull upw paramupw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxd
 * JD-Core Version:    0.7.0.1
 */