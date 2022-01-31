import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class tzb
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, sxr>
{
  public tzb(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull sxr paramsxr)
  {
    if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxr.jdField_a_of_type_JavaUtilList != null) && (!paramsxr.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
    {
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label54;
      }
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.notifyDataSetChanged();
    }
    label54:
    int j;
    do
    {
      return;
      j = 0;
      int i = j;
      Object localObject;
      if (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList != null)
      {
        i = j;
        if (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.isEmpty())
        {
          localObject = paramsxr.jdField_a_of_type_JavaUtilList.iterator();
          QQUserUIItem localQQUserUIItem;
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
          } while (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.contains(localQQUserUIItem.uid));
          i = 1;
        }
      }
      j = i;
      if (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.d))
      {
        paramsxr = paramsxr.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          j = i;
          if (!paramsxr.hasNext()) {
            break;
          }
          localObject = (QQUserUIItem)paramsxr.next();
        } while (!paramQQStoryShareGroupProfileActivity.d.equals(((QQUserUIItem)localObject).uid));
        j = 1;
      }
    } while (j == 0);
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzb
 * JD-Core Version:    0.7.0.1
 */