import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;

final class tik
  extends tgl
{
  tik(String paramString1, String paramString2, int paramInt, Context paramContext) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      paramString = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaLangString, this.b), this.jdField_a_of_type_Int).a();
      OpenPlayerBuilder.UIStyle localUIStyle = paramString.mUIStyle;
      if (paramStoryVideoItem.mInteractStatus == 1) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localUIStyle.bottomWidgetShowFlag = paramInt;
        paramString.mUIStyle.mPlayerRepeatMode = 1;
        tij.a(this.jdField_a_of_type_AndroidContentContext, paramString, null);
        return;
      }
    }
    if (paramInt == 10100)
    {
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryWarningActivity.class);
      paramString.putExtra("tipsResource", ajjy.a(2131648754));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, paramString, 0).a();
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, ajjy.a(2131648755) + paramInt, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tik
 * JD-Core Version:    0.7.0.1
 */