import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class uxa
  extends ste<uwq, upt>
{
  uxa(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull upt paramupt)
  {
    Object localObject = paramuwq.a(paramupt.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramupt.jdField_a_of_type_Boolean))
    {
      ved.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramupt.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramupt.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof uvh))
    {
      ved.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (uvh)localObject;
    ((CommentLikeFeedItem)((uvh)localObject).a).mLikeCount = paramupt.b;
    ((uvh)localObject).b(paramupt.jdField_a_of_type_JavaUtilList, true);
    uwq.a(paramuwq).b(paramupt.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return upt.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull upt paramupt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */