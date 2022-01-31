import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class vvg
  implements umw
{
  vvg(vva paramvva, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(umu paramumu)
  {
    if (this.jdField_a_of_type_Vva.isCanceled())
    {
      wxe.d(this.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramumu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      wxe.e(this.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramumu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Vva.a.d())
    {
      vva.c(this.jdField_a_of_type_Vva, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramumu.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!unk.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        wxe.d(this.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramumu.jdField_a_of_type_JavaLangString, Integer.valueOf(paramumu.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramumu.b))
    {
      vva.d(this.jdField_a_of_type_Vva, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = voi.a(new voo(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramumu.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    wxe.d(this.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramumu.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, umm.a(paramumu.b));
      this.jdField_a_of_type_Vva.a.c = paramumu.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Vva.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Vva.a.jdField_a_of_type_Vwa.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramumu.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Vva.a;
      StringBuilder localStringBuilder = new StringBuilder().append(alud.a(2131716844));
      if (this.jdField_a_of_type_Vva.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a).a(this.jdField_a_of_type_Vva.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramumu.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, alud.a(2131716842));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, alud.a(2131716836));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Vva.a, alud.a(2131716838));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvg
 * JD-Core Version:    0.7.0.1
 */