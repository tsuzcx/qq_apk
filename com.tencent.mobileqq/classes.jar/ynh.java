import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class ynh
  extends wjm<ymx, yga>
{
  ynh(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull yga paramyga)
  {
    Object localObject = paramymx.a(paramyga.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramyga.jdField_a_of_type_Boolean))
    {
      yuk.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramyga.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramyga.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof ylo))
    {
      yuk.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (ylo)localObject;
    ((CommentLikeFeedItem)((ylo)localObject).a).mLikeCount = paramyga.b;
    ((ylo)localObject).b(paramyga.jdField_a_of_type_JavaUtilList, true);
    ymx.a(paramymx).b(paramyga.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return yga.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull yga paramyga) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynh
 * JD-Core Version:    0.7.0.1
 */