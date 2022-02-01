import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import java.util.HashMap;
import java.util.Map;

public class okd
{
  private Map<String, okf> fn = new HashMap();
  private Map<String, okb> fo = new HashMap();
  
  private okb a(String paramString)
  {
    okb localokb2 = (okb)this.fo.get(paramString);
    okb localokb1 = localokb2;
    if (localokb2 == null)
    {
      localokb1 = new okb();
      this.fo.put(paramString, localokb1);
    }
    return localokb1;
  }
  
  public static okd a()
  {
    return okd.a.b();
  }
  
  private okf a(String paramString)
  {
    okf localokf2 = (okf)this.fn.get(paramString);
    okf localokf1 = localokf2;
    if (localokf2 == null)
    {
      localokf1 = new okf();
      this.fn.put(paramString, localokf1);
    }
    return localokf1;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, TextView paramTextView, View paramView1, View paramView2)
  {
    ooz.i("WSLikeAnimationManger", "doClickLike" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      ooz.i("WSLikeAnimationManger", "feedId：is null");
      return;
    }
    if ((paramView1 != null) && (paramView2 != null)) {
      a(paramString).a(paramstSimpleMetaFeed, paramView1, paramView2, paramTextView, paramInt1, paramBoolean);
    }
    b(paramString, paramBoolean, paramInt2);
  }
  
  private void a(String paramString, LikeRspEvent paramLikeRspEvent, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.fn != null) && (this.fn.size() > 0))
    {
      paramString = (okf)this.fn.get(paramString);
      if (paramString != null) {
        a(paramString.b(), paramString.s(), paramString.ar(), paramString.as());
      }
    }
    paramLikeRspEvent.setRpsStatus(4302);
    paramLikeRspEvent.setRspIsDing(paramInt);
  }
  
  private void b(String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    int i;
    if (!paramBoolean)
    {
      i = 2;
      ooz.i("WSLikeAnimationManger", "此次是取消点赞：---------------");
    }
    for (;;)
    {
      if (paramBoolean) {}
      for (;;)
      {
        v(paramString, paramInt, j);
        paramString = new okz(new ony(paramString, i), null, new oke(this, paramString, paramInt, paramBoolean), 4001);
        oks.a().b(paramString);
        return;
        j = 0;
      }
      i = 1;
    }
  }
  
  private void v(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new LikeRspEvent(paramString, paramInt1);
    paramString.setRpsStatus(4301);
    paramString.setRspIsDing(paramInt2);
    oiv.a().b(paramString);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3, TextView paramTextView, View paramView1, View paramView2, ViewGroup paramViewGroup)
  {
    if (paramstSimpleMetaFeed == null)
    {
      ooz.e("WSLikeAnimationManger", "feed：is null");
      return;
    }
    String str = paramstSimpleMetaFeed.id;
    if (TextUtils.isEmpty(str))
    {
      ooz.e("WSLikeAnimationManger", "feedId：is null");
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
      ooz.e("WSLikeAnimationManger", "resetLikeSate：is null");
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
      muj.a(paramTextView, paramstSimpleMetaFeed.ding_count, "0");
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
  
  public void pH(String paramString)
  {
    if (this.fn != null)
    {
      okf localokf = (okf)this.fn.get(paramString);
      if (localokf != null)
      {
        localokf.bfD();
        this.fn.remove(localokf);
      }
    }
    if (this.fo != null)
    {
      paramString = (okb)this.fo.get(paramString);
      if (paramString != null)
      {
        paramString.bfD();
        this.fn.remove(paramString);
      }
    }
  }
  
  public void release()
  {
    if (this.fn != null) {
      this.fn.clear();
    }
    if (this.fo != null) {
      this.fo.clear();
    }
  }
  
  static class a
  {
    private static final okd b = new okd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okd
 * JD-Core Version:    0.7.0.1
 */