import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class tkn
  implements slx<szj, tbh>
{
  tkn(tkm paramtkm, tka paramtka) {}
  
  public void a(@NonNull szj paramszj, @Nullable tbh paramtbh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtbh == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Tka.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Tkm.jdField_a_of_type_Tjs));
      return;
    }
    paramtbh.jdField_a_of_type_JavaUtilList = ((sqd)sqg.a(5)).a(paramtbh.jdField_a_of_type_JavaUtilList);
    paramszj = paramtbh.jdField_a_of_type_JavaUtilList.iterator();
    while (paramszj.hasNext()) {
      ((StoryVideoItem)paramszj.next()).mOwnerUid = tkl.a(this.jdField_a_of_type_Tkm.jdField_a_of_type_Tkl).uid;
    }
    ((sgs)sqg.a(28)).a(paramtbh.b);
    paramszj = paramtbh.jdField_a_of_type_JavaUtilList.iterator();
    while (paramszj.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramszj.next();
      tkm.a(this.jdField_a_of_type_Tkm).add(paramErrorMessage.mVid);
    }
    if ((paramtbh.jdField_a_of_type_Boolean) || (paramtbh.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramszj = new tjt(this.jdField_a_of_type_Tkm.jdField_a_of_type_Tjs);
      paramszj.jdField_a_of_type_JavaUtilList = tkm.a(this.jdField_a_of_type_Tkm);
      paramszj.a(tkl.a(this.jdField_a_of_type_Tkm.jdField_a_of_type_Tkl).feedId);
      this.jdField_a_of_type_Tka.a(Collections.singletonList(paramszj), true);
      return;
    }
    tkm.a(this.jdField_a_of_type_Tkm);
    if (tkm.b(this.jdField_a_of_type_Tkm) > 50)
    {
      this.jdField_a_of_type_Tka.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Tkm.jdField_a_of_type_Tjs));
      return;
    }
    this.jdField_a_of_type_Tkm.a(paramtbh.c, this.jdField_a_of_type_Tka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkn
 * JD-Core Version:    0.7.0.1
 */