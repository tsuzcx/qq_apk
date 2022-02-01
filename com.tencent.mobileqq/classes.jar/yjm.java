import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class yjm
  extends wfr<yjc, ycf>
{
  yjm(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull ycf paramycf)
  {
    Object localObject = paramyjc.a(paramycf.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramycf.jdField_a_of_type_Boolean))
    {
      yqp.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramycf.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramycf.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof yht))
    {
      yqp.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (yht)localObject;
    ((CommentLikeFeedItem)((yht)localObject).a).mLikeCount = paramycf.b;
    ((yht)localObject).b(paramycf.jdField_a_of_type_JavaUtilList, true);
    yjc.a(paramyjc).b(paramycf.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return ycf.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull ycf paramycf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjm
 * JD-Core Version:    0.7.0.1
 */