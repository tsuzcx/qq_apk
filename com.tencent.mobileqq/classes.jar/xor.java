import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class xor
  implements wgi
{
  xor(xol paramxol, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(wgg paramwgg)
  {
    if (this.jdField_a_of_type_Xol.isCanceled())
    {
      yqp.d(this.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramwgg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      yqp.e(this.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramwgg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Xol.a.d())
    {
      xol.c(this.jdField_a_of_type_Xol, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramwgg.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!wgw.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        yqp.d(this.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramwgg.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwgg.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramwgg.b))
    {
      xol.d(this.jdField_a_of_type_Xol, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = xht.a(new xhz(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwgg.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    yqp.d(this.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramwgg.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, wfy.a(paramwgg.b));
      this.jdField_a_of_type_Xol.a.c = paramwgg.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Xol.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Xol.a.jdField_a_of_type_Xpl.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramwgg.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Xol.a;
      StringBuilder localStringBuilder = new StringBuilder().append(anni.a(2131715121));
      if (this.jdField_a_of_type_Xol.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a).a(this.jdField_a_of_type_Xol.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwgg.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, anni.a(2131715119));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, anni.a(2131715113));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xol.a, anni.a(2131715115));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xor
 * JD-Core Version:    0.7.0.1
 */