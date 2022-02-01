import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;

class wcs
  extends Job<Object, Object, Object>
{
  wcs(wcn paramwcn, String paramString1, String paramString2, StoryVideoItem paramStoryVideoItem)
  {
    super(paramString1);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    paramJobContext = new wix(new ErrorMessage(), this.jdField_a_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
    {
      paramJobContext.b = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
      paramJobContext.c = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.shareGroupId;
      paramJobContext.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
      if (paramJobContext.a == 0L) {
        paramJobContext.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
      }
    }
    wad.a().dispatch(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcs
 * JD-Core Version:    0.7.0.1
 */