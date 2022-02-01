import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xjs
  implements wld<wyp, xan>
{
  xjs(xjr paramxjr, xjf paramxjf) {}
  
  public void a(@NonNull wyp paramwyp, @Nullable xan paramxan, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxan == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Xjf.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Xjr.jdField_a_of_type_Xix));
      return;
    }
    paramxan.jdField_a_of_type_JavaUtilList = ((wpj)wpm.a(5)).a(paramxan.jdField_a_of_type_JavaUtilList);
    paramwyp = paramxan.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwyp.hasNext()) {
      ((StoryVideoItem)paramwyp.next()).mOwnerUid = xjq.a(this.jdField_a_of_type_Xjr.jdField_a_of_type_Xjq).uid;
    }
    ((wfy)wpm.a(28)).a(paramxan.b);
    paramwyp = paramxan.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwyp.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramwyp.next();
      xjr.a(this.jdField_a_of_type_Xjr).add(paramErrorMessage.mVid);
    }
    if ((paramxan.jdField_a_of_type_Boolean) || (paramxan.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramwyp = new xiy(this.jdField_a_of_type_Xjr.jdField_a_of_type_Xix);
      paramwyp.jdField_a_of_type_JavaUtilList = xjr.a(this.jdField_a_of_type_Xjr);
      paramwyp.a(xjq.a(this.jdField_a_of_type_Xjr.jdField_a_of_type_Xjq).feedId);
      this.jdField_a_of_type_Xjf.a(Collections.singletonList(paramwyp), true);
      return;
    }
    xjr.a(this.jdField_a_of_type_Xjr);
    if (xjr.b(this.jdField_a_of_type_Xjr) > 50)
    {
      this.jdField_a_of_type_Xjf.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Xjr.jdField_a_of_type_Xix));
      return;
    }
    this.jdField_a_of_type_Xjr.a(paramxan.c, this.jdField_a_of_type_Xjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjs
 * JD-Core Version:    0.7.0.1
 */