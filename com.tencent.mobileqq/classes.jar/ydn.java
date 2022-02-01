import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class ydn
  extends wag<ydd, xwg>
{
  ydn(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull xwg paramxwg)
  {
    Object localObject = paramydd.a(paramxwg.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramxwg.jdField_a_of_type_Boolean))
    {
      ykq.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramxwg.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramxwg.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof ybu))
    {
      ykq.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (ybu)localObject;
    ((CommentLikeFeedItem)((ybu)localObject).a).mLikeCount = paramxwg.b;
    ((ybu)localObject).b(paramxwg.jdField_a_of_type_JavaUtilList, true);
    ydd.a(paramydd).b(paramxwg.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return xwg.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull xwg paramxwg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydn
 * JD-Core Version:    0.7.0.1
 */