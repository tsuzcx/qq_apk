import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;

final class vog
  implements vmd
{
  vog(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo, int paramInt, Activity paramActivity, View paramView) {}
  
  public void a(int paramInt)
  {
    int i = 1;
    OpenPlayerBuilder.Data localData = new OpenPlayerBuilder(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo, this.jdField_a_of_type_Int).a();
    OpenPlayerBuilder.UIStyle localUIStyle;
    if (paramInt != -1)
    {
      localUIStyle = localData.mUIStyle;
      if (paramInt != 1) {
        break label58;
      }
    }
    label58:
    for (paramInt = i;; paramInt = 2)
    {
      localUIStyle.bottomWidgetShowFlag = paramInt;
      vod.a(this.jdField_a_of_type_AndroidAppActivity, localData, this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */