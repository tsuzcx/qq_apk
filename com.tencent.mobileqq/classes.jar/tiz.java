import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.VideoCoverImgBorder;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import java.util.TimeZone;

class tiz
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoCoverImgBorder jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder;
  private String jdField_a_of_type_JavaLangString;
  
  public tiz(tiy paramtiy, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder = ((VideoCoverImgBorder)paramView.findViewById(2131297772));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311450));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setOnClickListener(new tja(this, paramtiy));
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      vms.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder, paramString, VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.c(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.d(this.jdField_a_of_type_Tiy.a), "VideoCoverList");
      return;
    }
    vms.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder, paramString, VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.b(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.c(this.jdField_a_of_type_Tiy.a), VideoCoverListBar.d(this.jdField_a_of_type_Tiy.a), "VideoCoverList");
  }
  
  public void a(int paramInt)
  {
    urk.a("Q.qqstory.player:VideoCoverListBar", "bindView, position=%d", Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Tiy.a(paramInt);
    Object localObject = VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a).b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      localObject = new StoryVideoItem();
      ((StoryVideoItem)localObject).mVid = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((StoryVideoItem)localObject).getThumbUrl()))
      {
        a(vmp.a(((StoryVideoItem)localObject).getThumbUrl()), paramInt);
        if (!((StoryVideoItem)localObject).isUploadFail()) {
          break label177;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(0);
      }
      for (;;)
      {
        if ((!VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a).a()) && (!VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a).b())) {
          break label246;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.clearColorFilter();
        return;
        a(vmp.a(urh.a(((StoryVideoItem)localObject).mVideoLocalThumbnailPath)), paramInt);
        break;
        label177:
        if (TextUtils.isEmpty(VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a))) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(2);
        } else if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, VideoCoverListBar.a(this.jdField_a_of_type_Tiy.a))) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(1);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(2);
        }
      }
      label246:
      if ((tfy.b((StoryVideoItem)localObject)) || (((StoryVideoItem)localObject).mErrorCode != 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      long l2 = ((StoryVideoItem)localObject).mCreateTime;
      long l1;
      if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L) {
        l1 = ((StoryVideoItem)localObject).mTimeZoneOffsetMillis;
      }
      for (boolean bool = true;; bool = false)
      {
        localObject = ulr.a(l2, l1, bool, false, true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
        return;
        l1 = TimeZone.getDefault().getRawOffset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiz
 * JD-Core Version:    0.7.0.1
 */