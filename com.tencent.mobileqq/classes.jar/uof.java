import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

class uof
  extends ulp
{
  uof(uoe paramuoe) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if (vms.b()) {}
    label6:
    do
    {
      do
      {
        do
        {
          break label6;
          do
          {
            return;
          } while ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()));
          paramObject = (StoryVideoItem)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while (TextUtils.isEmpty(paramObject.mOwnerUid));
        paramObject = uoe.a(this.a).b(paramObject.mOwnerUid);
      } while (paramObject == null);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (uoe.a(this.a) == null);
    uoe.a(this.a).a(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uof
 * JD-Core Version:    0.7.0.1
 */