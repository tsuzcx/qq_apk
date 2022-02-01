import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class wur
  extends SimpleObserver<List<xfb>>
{
  wur(wui paramwui, wrs paramwrs, View paramView, Activity paramActivity) {}
  
  private void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString1))) {
      paramString1 = "NO_SUCH_FEED_ID";
    }
    for (;;)
    {
      paramString1 = new OpenPlayerBuilder(new MsgTabPlayInfo(this.jdField_a_of_type_Wrs.a, 0, null, paramString1, paramString2, paramArrayList, paramHashMap), 106);
      paramString1.a(this.jdField_a_of_type_Wui.a());
      paramString1 = paramString1.a();
      paramString1.mUIStyle.bottomWidgetShowFlag = 3;
      if ((this.jdField_a_of_type_AndroidViewView instanceof StoryMsgNodeFrameLayout))
      {
        xho.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, ((StoryMsgNodeFrameLayout)this.jdField_a_of_type_AndroidViewView).a);
        return;
      }
      xho.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
  
  public void a(List<xfb> paramList)
  {
    Object localObject = xjk.a(paramList);
    String str1;
    if (localObject != null)
    {
      str1 = ((xfb)localObject).a;
      localObject = ((xfb)localObject).b;
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      int i = 0;
      for (;;)
      {
        String str2;
        if (i < paramList.size())
        {
          str2 = ((xfb)paramList.get(i)).b;
          if (!TextUtils.isEmpty(str2)) {}
        }
        else
        {
          a(str1, (String)localObject, localArrayList, localHashMap);
          return;
        }
        localArrayList.add(str2);
        localHashMap.put(str2, ((xfb)paramList.get(i)).a);
        i += 1;
      }
      localObject = null;
      str1 = null;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    a("", "", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wur
 * JD-Core Version:    0.7.0.1
 */