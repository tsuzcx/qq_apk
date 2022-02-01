import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import java.util.HashMap;
import java.util.Map;

public class uql
{
  private Map<String, uqo> a = new HashMap();
  private Map<String, uqf> b = new HashMap();
  
  private uqf a(String paramString)
  {
    uqf localuqf2 = (uqf)this.b.get(paramString);
    uqf localuqf1 = localuqf2;
    if (localuqf2 == null)
    {
      localuqf1 = new uqf();
      this.b.put(paramString, localuqf1);
    }
    return localuqf1;
  }
  
  public static uql a()
  {
    return uqn.a();
  }
  
  private uqo a(String paramString)
  {
    uqo localuqo2 = (uqo)this.a.get(paramString);
    uqo localuqo1 = localuqo2;
    if (localuqo2 == null)
    {
      localuqo1 = new uqo();
      this.a.put(paramString, localuqo1);
    }
    return localuqo1;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, TextView paramTextView, View paramView1, View paramView2)
  {
    uya.a("WSLikeAnimationManger", "doClickLike" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      uya.a("WSLikeAnimationManger", "feedId：is null");
      return;
    }
    if ((paramView1 != null) && (paramView2 != null)) {
      a(paramString).a(paramstSimpleMetaFeed, paramView1, paramView2, paramTextView, paramInt1, paramBoolean);
    }
    a(paramString, paramBoolean, paramInt2);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new LikeRspEvent(paramString, paramInt1);
    paramString.setRpsStatus(4301);
    paramString.setRspIsDing(paramInt2);
    unw.a().a(paramString);
  }
  
  private void a(String paramString, LikeRspEvent paramLikeRspEvent, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a != null) && (this.a.size() > 0))
    {
      paramString = (uqo)this.a.get(paramString);
      if (paramString != null) {
        a(paramString.a(), paramString.a(), paramString.a(), paramString.b());
      }
    }
    paramLikeRspEvent.setRpsStatus(4302);
    paramLikeRspEvent.setRspIsDing(paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    int i;
    if (!paramBoolean)
    {
      i = 2;
      uya.a("WSLikeAnimationManger", "此次是取消点赞：---------------");
    }
    for (;;)
    {
      if (paramBoolean) {}
      for (;;)
      {
        a(paramString, paramInt, j);
        paramString = new urj(new uwr(paramString, i), null, new uqm(this, paramString, paramInt, paramBoolean), 4001);
        urc.a().a(paramString);
        return;
        j = 0;
      }
      i = 1;
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3, TextView paramTextView, View paramView1, View paramView2, ViewGroup paramViewGroup)
  {
    if (paramstSimpleMetaFeed == null)
    {
      uya.d("WSLikeAnimationManger", "feed：is null");
      return;
    }
    String str = paramstSimpleMetaFeed.id;
    if (TextUtils.isEmpty(str))
    {
      uya.d("WSLikeAnimationManger", "feedId：is null");
      return;
    }
    if (paramstSimpleMetaFeed.is_ding == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramstSimpleMetaFeed.ding_count += 1;
        paramstSimpleMetaFeed.is_ding = 1;
      }
      if (paramViewGroup != null) {
        a(str).a(paramViewGroup, paramInt2, paramInt3);
      }
      if (i != 0) {
        break;
      }
      a(paramstSimpleMetaFeed, str, true, paramstSimpleMetaFeed.ding_count, paramInt1, paramTextView, paramView1, paramView2);
      return;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, TextView paramTextView, View paramView1, View paramView2, ViewGroup paramViewGroup)
  {
    int j = 1;
    label29:
    boolean bool;
    if (paramstSimpleMetaFeed.is_ding == 1)
    {
      i = 1;
      if (i == 0) {
        break label117;
      }
      paramstSimpleMetaFeed.ding_count -= 1;
      if (i != 0) {
        break label130;
      }
      bool = true;
      label37:
      if (!bool) {
        break label136;
      }
    }
    label130:
    label136:
    for (int i = j;; i = 0)
    {
      paramstSimpleMetaFeed.is_ding = i;
      a(paramstSimpleMetaFeed, paramstSimpleMetaFeed.id, bool, paramstSimpleMetaFeed.ding_count, paramInt, paramTextView, paramView1, paramView2);
      if ((bool) && (paramViewGroup != null)) {
        a(paramstSimpleMetaFeed.id).a(paramViewGroup, paramViewGroup.getMeasuredWidth() / 2, paramViewGroup.getMeasuredHeight() / 2);
      }
      return;
      i = 0;
      break;
      label117:
      paramstSimpleMetaFeed.ding_count += 1;
      break label29;
      bool = false;
      break label37;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, TextView paramTextView, View paramView1, View paramView2)
  {
    int j = 1;
    if (paramstSimpleMetaFeed == null)
    {
      uya.d("WSLikeAnimationManger", "resetLikeSate：is null");
      return;
    }
    label26:
    label41:
    boolean bool;
    if (paramstSimpleMetaFeed.is_ding == 1)
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      paramstSimpleMetaFeed.ding_count -= 1;
      if (i != 0) {
        break label127;
      }
      bool = true;
      label49:
      if (!bool) {
        break label133;
      }
    }
    label133:
    for (int i = j;; i = 0)
    {
      paramstSimpleMetaFeed.is_ding = i;
      if (paramView1 != null) {
        paramView1.setSelected(bool);
      }
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      if (paramTextView == null) {
        break;
      }
      if (paramstSimpleMetaFeed.ding_count <= 0) {
        break label139;
      }
      rwv.a(paramTextView, paramstSimpleMetaFeed.ding_count, "0");
      return;
      i = 0;
      break label26;
      label114:
      paramstSimpleMetaFeed.ding_count += 1;
      break label41;
      label127:
      bool = false;
      break label49;
    }
    label139:
    paramTextView.setText("赞");
  }
  
  public void a(String paramString)
  {
    if (this.a != null)
    {
      uqo localuqo = (uqo)this.a.get(paramString);
      if (localuqo != null)
      {
        localuqo.a();
        this.a.remove(localuqo);
      }
    }
    if (this.b != null)
    {
      paramString = (uqf)this.b.get(paramString);
      if (paramString != null)
      {
        paramString.a();
        this.b.remove(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */