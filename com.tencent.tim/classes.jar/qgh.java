import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.widget.QQToast;

final class qgh
  extends qem.e
{
  qgh(String paramString1, String paramString2, int paramInt, Context paramContext) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      paramString = new OpenPlayerBuilder(new VidListPlayInfo(this.dL, this.val$vid), this.val$from).b();
      OpenPlayerBuilder.UIStyle localUIStyle = paramString.mUIStyle;
      if (paramStoryVideoItem.mInteractStatus == 1) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localUIStyle.bottomWidgetShowFlag = paramInt;
        paramString.mUIStyle.mPlayerRepeatMode = 1;
        qgg.a(this.val$context, paramString, null);
        return;
      }
    }
    if (paramInt == 10100)
    {
      paramString = new Intent(this.val$context, QQStoryWarningActivity.class);
      paramString.putExtra("tipsResource", acfp.m(2131714964));
      this.val$context.startActivity(paramString);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.val$context.getApplicationContext(), 1, paramString, 0).show();
      return;
    }
    QQToast.a(this.val$context.getApplicationContext(), 1, acfp.m(2131714965) + paramInt, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgh
 * JD-Core Version:    0.7.0.1
 */