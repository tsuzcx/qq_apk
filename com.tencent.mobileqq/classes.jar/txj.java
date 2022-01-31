import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class txj
  implements syt<tmf, tod>
{
  txj(txi paramtxi, tww paramtww) {}
  
  public void a(@NonNull tmf paramtmf, @Nullable tod paramtod, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtod == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_Tww.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_Txi.jdField_a_of_type_Two));
      return;
    }
    paramtod.jdField_a_of_type_JavaUtilList = ((tcz)tdc.a(5)).a(paramtod.jdField_a_of_type_JavaUtilList);
    paramtmf = paramtod.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmf.hasNext()) {
      ((StoryVideoItem)paramtmf.next()).mOwnerUid = txh.a(this.jdField_a_of_type_Txi.jdField_a_of_type_Txh).uid;
    }
    ((sto)tdc.a(28)).a(paramtod.b);
    paramtmf = paramtod.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmf.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramtmf.next();
      txi.a(this.jdField_a_of_type_Txi).add(paramErrorMessage.mVid);
    }
    if ((paramtod.jdField_a_of_type_Boolean) || (paramtod.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramtmf = new twp(this.jdField_a_of_type_Txi.jdField_a_of_type_Two);
      paramtmf.jdField_a_of_type_JavaUtilList = txi.a(this.jdField_a_of_type_Txi);
      paramtmf.a(txh.a(this.jdField_a_of_type_Txi.jdField_a_of_type_Txh).feedId);
      this.jdField_a_of_type_Tww.a(Collections.singletonList(paramtmf), true);
      return;
    }
    txi.a(this.jdField_a_of_type_Txi);
    if (txi.b(this.jdField_a_of_type_Txi) > 50)
    {
      this.jdField_a_of_type_Tww.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_Txi.jdField_a_of_type_Two));
      return;
    }
    this.jdField_a_of_type_Txi.a(paramtod.c, this.jdField_a_of_type_Tww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txj
 * JD-Core Version:    0.7.0.1
 */