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

public class ulu
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, tkk>
{
  public ulu(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull tkk paramtkk)
  {
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_JavaUtilList != null) && (!paramtkk.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
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
          localObject = paramtkk.jdField_a_of_type_JavaUtilList.iterator();
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
        paramtkk = paramtkk.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          j = i;
          if (!paramtkk.hasNext()) {
            break;
          }
          localObject = (QQUserUIItem)paramtkk.next();
        } while (!paramQQStoryShareGroupProfileActivity.d.equals(((QQUserUIItem)localObject).uid));
        j = 1;
      }
    } while (j == 0);
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */