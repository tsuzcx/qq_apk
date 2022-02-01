import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xnn
  implements woy<xck, xei>
{
  xnn(xnm paramxnm, xna paramxna) {}
  
  public void a(@NonNull xck paramxck, @Nullable xei paramxei, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxei == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Xna.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Xnm.jdField_a_of_type_Xms));
      return;
    }
    paramxei.jdField_a_of_type_JavaUtilList = ((wte)wth.a(5)).a(paramxei.jdField_a_of_type_JavaUtilList);
    paramxck = paramxei.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxck.hasNext()) {
      ((StoryVideoItem)paramxck.next()).mOwnerUid = xnl.a(this.jdField_a_of_type_Xnm.jdField_a_of_type_Xnl).uid;
    }
    ((wjt)wth.a(28)).a(paramxei.b);
    paramxck = paramxei.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxck.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramxck.next();
      xnm.a(this.jdField_a_of_type_Xnm).add(paramErrorMessage.mVid);
    }
    if ((paramxei.jdField_a_of_type_Boolean) || (paramxei.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramxck = new xmt(this.jdField_a_of_type_Xnm.jdField_a_of_type_Xms);
      paramxck.jdField_a_of_type_JavaUtilList = xnm.a(this.jdField_a_of_type_Xnm);
      paramxck.a(xnl.a(this.jdField_a_of_type_Xnm.jdField_a_of_type_Xnl).feedId);
      this.jdField_a_of_type_Xna.a(Collections.singletonList(paramxck), true);
      return;
    }
    xnm.a(this.jdField_a_of_type_Xnm);
    if (xnm.b(this.jdField_a_of_type_Xnm) > 50)
    {
      this.jdField_a_of_type_Xna.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Xnm.jdField_a_of_type_Xms));
      return;
    }
    this.jdField_a_of_type_Xnm.a(paramxei.c, this.jdField_a_of_type_Xna);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnn
 * JD-Core Version:    0.7.0.1
 */