import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class xis
  implements wax
{
  xis(xim paramxim, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(wav paramwav)
  {
    if (this.jdField_a_of_type_Xim.isCanceled())
    {
      ykq.d(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramwav.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      ykq.e(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramwav.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Xim.a.d())
    {
      xim.c(this.jdField_a_of_type_Xim, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramwav.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!wbl.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        ykq.d(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramwav.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwav.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramwav.b))
    {
      xim.d(this.jdField_a_of_type_Xim, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = xbu.a(new xca(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwav.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    ykq.d(this.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramwav.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, wan.a(paramwav.b));
      this.jdField_a_of_type_Xim.a.c = paramwav.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Xim.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Xim.a.jdField_a_of_type_Xjm.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramwav.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Xim.a;
      StringBuilder localStringBuilder = new StringBuilder().append(anvx.a(2131715812));
      if (this.jdField_a_of_type_Xim.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a).a(this.jdField_a_of_type_Xim.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramwav.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, anvx.a(2131715810));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, anvx.a(2131715804));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Xim.a, anvx.a(2131715806));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xis
 * JD-Core Version:    0.7.0.1
 */