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

class pwi
  extends SimpleObserver<List<qej>>
{
  pwi(pvz parampvz, puh parampuh, View paramView, Activity paramActivity) {}
  
  private void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString1))) {
      paramString1 = "NO_SUCH_FEED_ID";
    }
    for (;;)
    {
      paramString1 = new OpenPlayerBuilder(new MsgTabPlayInfo(this.d.unionId, 0, null, paramString1, paramString2, paramArrayList, paramHashMap), 106);
      paramString1.a(this.this$0.mF());
      paramString1 = paramString1.b();
      paramString1.mUIStyle.bottomWidgetShowFlag = 3;
      if ((this.val$view instanceof StoryMsgNodeFrameLayout))
      {
        qgg.a(this.val$context, paramString1, ((StoryMsgNodeFrameLayout)this.val$view).a);
        return;
      }
      qgg.a(this.val$context, paramString1, this.val$view);
      return;
    }
  }
  
  public void dJ(List<qej> paramList)
  {
    Object localObject = qhc.a(paramList);
    String str1;
    if (localObject != null)
    {
      str1 = ((qej)localObject).feedId;
      localObject = ((qej)localObject).vid;
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
          str2 = ((qej)paramList.get(i)).vid;
          if (!TextUtils.isEmpty(str2)) {}
        }
        else
        {
          a(str1, (String)localObject, localArrayList, localHashMap);
          return;
        }
        localArrayList.add(str2);
        localHashMap.put(str2, ((qej)paramList.get(i)).feedId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwi
 * JD-Core Version:    0.7.0.1
 */