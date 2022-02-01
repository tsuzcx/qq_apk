import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class woy
  implements vqp<wea, wfy>
{
  woy(wox paramwox, wol paramwol) {}
  
  public void a(@NonNull wea paramwea, @Nullable wfy paramwfy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwfy == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Wol.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Wox.jdField_a_of_type_Wod));
      return;
    }
    paramwfy.jdField_a_of_type_JavaUtilList = ((vuu)vux.a(5)).a(paramwfy.jdField_a_of_type_JavaUtilList);
    paramwea = paramwfy.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwea.hasNext()) {
      ((StoryVideoItem)paramwea.next()).mOwnerUid = wow.a(this.jdField_a_of_type_Wox.jdField_a_of_type_Wow).uid;
    }
    ((vls)vux.a(28)).a(paramwfy.b);
    paramwea = paramwfy.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwea.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramwea.next();
      wox.a(this.jdField_a_of_type_Wox).add(paramErrorMessage.mVid);
    }
    if ((paramwfy.jdField_a_of_type_Boolean) || (paramwfy.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramwea = new woe(this.jdField_a_of_type_Wox.jdField_a_of_type_Wod);
      paramwea.jdField_a_of_type_JavaUtilList = wox.a(this.jdField_a_of_type_Wox);
      paramwea.a(wow.a(this.jdField_a_of_type_Wox.jdField_a_of_type_Wow).feedId);
      this.jdField_a_of_type_Wol.a(Collections.singletonList(paramwea), true);
      return;
    }
    wox.a(this.jdField_a_of_type_Wox);
    if (wox.b(this.jdField_a_of_type_Wox) > 50)
    {
      this.jdField_a_of_type_Wol.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Wox.jdField_a_of_type_Wod));
      return;
    }
    this.jdField_a_of_type_Wox.a(paramwfy.c, this.jdField_a_of_type_Wol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woy
 * JD-Core Version:    0.7.0.1
 */