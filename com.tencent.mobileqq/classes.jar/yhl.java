import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.List;

class yhl
  extends yev
{
  yhl(yhk paramyhk) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if (UIUtils.isFastDoubleClick()) {}
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
        paramObject = yhk.a(this.a).b(paramObject.mOwnerUid);
      } while (paramObject == null);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (yhk.a(this.a) == null);
    yhk.a(this.a).a(paramView, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhl
 * JD-Core Version:    0.7.0.1
 */