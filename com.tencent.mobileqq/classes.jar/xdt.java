import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class xdt
  implements wfk<wsv, wut>
{
  xdt(xds paramxds, xdg paramxdg) {}
  
  public void a(@NonNull wsv paramwsv, @Nullable wut paramwut, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwut == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Xdg.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Xds.jdField_a_of_type_Xcy));
      return;
    }
    paramwut.jdField_a_of_type_JavaUtilList = ((wjp)wjs.a(5)).a(paramwut.jdField_a_of_type_JavaUtilList);
    paramwsv = paramwut.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwsv.hasNext()) {
      ((StoryVideoItem)paramwsv.next()).mOwnerUid = xdr.a(this.jdField_a_of_type_Xds.jdField_a_of_type_Xdr).uid;
    }
    ((wan)wjs.a(28)).a(paramwut.b);
    paramwsv = paramwut.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwsv.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramwsv.next();
      xds.a(this.jdField_a_of_type_Xds).add(paramErrorMessage.mVid);
    }
    if ((paramwut.jdField_a_of_type_Boolean) || (paramwut.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramwsv = new xcz(this.jdField_a_of_type_Xds.jdField_a_of_type_Xcy);
      paramwsv.jdField_a_of_type_JavaUtilList = xds.a(this.jdField_a_of_type_Xds);
      paramwsv.a(xdr.a(this.jdField_a_of_type_Xds.jdField_a_of_type_Xdr).feedId);
      this.jdField_a_of_type_Xdg.a(Collections.singletonList(paramwsv), true);
      return;
    }
    xds.a(this.jdField_a_of_type_Xds);
    if (xds.b(this.jdField_a_of_type_Xds) > 50)
    {
      this.jdField_a_of_type_Xdg.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Xds.jdField_a_of_type_Xcy));
      return;
    }
    this.jdField_a_of_type_Xds.a(paramwut.c, this.jdField_a_of_type_Xdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */