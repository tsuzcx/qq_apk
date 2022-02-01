import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class xos
  extends vll<xoi, xhl>
{
  xos(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull xhl paramxhl)
  {
    Object localObject = paramxoi.a(paramxhl.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramxhl.jdField_a_of_type_Boolean))
    {
      xvv.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramxhl.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramxhl.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof xmz))
    {
      xvv.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (xmz)localObject;
    ((CommentLikeFeedItem)((xmz)localObject).a).mLikeCount = paramxhl.b;
    ((xmz)localObject).b(paramxhl.jdField_a_of_type_JavaUtilList, true);
    xoi.a(paramxoi).b(paramxhl.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return xhl.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull xhl paramxhl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xos
 * JD-Core Version:    0.7.0.1
 */