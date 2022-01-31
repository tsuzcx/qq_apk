import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

class tpm
  implements shc
{
  tpm(tpg paramtpg, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(sha paramsha)
  {
    if (this.jdField_a_of_type_Tpg.isCanceled())
    {
      urk.d(this.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramsha.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      urk.e(this.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramsha.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_Tpg.a.d())
    {
      tpg.c(this.jdField_a_of_type_Tpg, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramsha.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!shq.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        urk.d(this.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramsha.jdField_a_of_type_JavaLangString, Integer.valueOf(paramsha.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramsha.b))
    {
      tpg.d(this.jdField_a_of_type_Tpg, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = tio.a(new tiu(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramsha.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    urk.d(this.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramsha.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, sgs.a(paramsha.b));
      this.jdField_a_of_type_Tpg.a.c = paramsha.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_Tpg.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_Tpg.a.jdField_a_of_type_Tqg.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramsha.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_Tpg.a;
      StringBuilder localStringBuilder = new StringBuilder().append(ajjy.a(2131650658));
      if (this.jdField_a_of_type_Tpg.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a).a(this.jdField_a_of_type_Tpg.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramsha.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, ajjy.a(2131650656));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, ajjy.a(2131650650));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_Tpg.a, ajjy.a(2131650652));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpm
 * JD-Core Version:    0.7.0.1
 */