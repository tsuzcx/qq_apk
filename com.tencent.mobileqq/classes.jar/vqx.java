import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class vqx
  implements uin
{
  vqx(vqr paramvqr, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(uil paramuil)
  {
    if (this.jdField_a_of_type_Vqr.isCanceled())
    {
      wsv.d(this.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramuil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      wsv.e(this.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramuil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Vqr.a.d())
    {
      vqr.c(this.jdField_a_of_type_Vqr, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramuil.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!ujb.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        wsv.d(this.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramuil.jdField_a_of_type_JavaLangString, Integer.valueOf(paramuil.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramuil.b))
    {
      vqr.d(this.jdField_a_of_type_Vqr, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = vjz.a(new vkf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramuil.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    wsv.d(this.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramuil.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, uid.a(paramuil.b));
      this.jdField_a_of_type_Vqr.a.c = paramuil.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Vqr.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Vqr.a.jdField_a_of_type_Vrr.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramuil.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Vqr.a;
      StringBuilder localStringBuilder = new StringBuilder().append(alpo.a(2131716832));
      if (this.jdField_a_of_type_Vqr.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a).a(this.jdField_a_of_type_Vqr.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramuil.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, alpo.a(2131716830));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, alpo.a(2131716824));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vqr.a, alpo.a(2131716826));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqx
 * JD-Core Version:    0.7.0.1
 */