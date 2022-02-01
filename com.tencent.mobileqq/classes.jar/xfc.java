import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class xfc
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, zpu paramzpu, float paramFloat)
  {
    if (paramInt == ((Integer)paramzpu.a().getTag(2131374586)).intValue())
    {
      wxq.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramzpu.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(zpw paramzpw, zpv paramzpv, FrameLayout paramFrameLayout, zpk paramzpk, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      yqp.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    yqp.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      yqp.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramzpk.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramzpk.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramzpw, paramzpv, paramFrameLayout, paramzpk, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(zpw paramzpw, zpv paramzpv, zpk paramzpk, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      yqp.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramzpk instanceof zpu)) {
      return;
    }
    b(paramzpw, paramzpv, paramzpk, paramStoryVideoItem);
  }
  
  public static void b(zpw paramzpw, zpv paramzpv, FrameLayout paramFrameLayout, zpk paramzpk, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    yqp.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramzpw, paramzpv, paramFrameLayout, paramzpk, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(zpw paramzpw, zpv paramzpv, FrameLayout paramFrameLayout, zpk paramzpk, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    wqv localwqv = paramStoryVideoItem.getInteractLayout();
    if (localwqv == null) {
      yqp.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int i;
    int j;
    int k;
    int m;
    float f1;
    float f2;
    float f3;
    do
    {
      return;
      yqp.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramzpk.a();
      localView.setTag(2131374586, Integer.valueOf(paramInt));
      i = localwqv.b;
      j = localwqv.c;
      k = localwqv.d;
      m = localwqv.e;
      f1 = localwqv.f;
      f2 = localwqv.g;
      f3 = localwqv.h;
      String[] arrayOfString = localwqv.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        yqp.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      yqp.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramzpk.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramzpw, paramzpv, paramFrameLayout, paramzpk, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramzpk.a(localwqv.b, localwqv.c, paramInt, n, localwqv.d, localwqv.e, localwqv.f, localwqv.g, localwqv.h);
    paramzpk.a();
    a(paramzpw, paramzpv, paramzpk, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    yqp.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    yqp.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(zpw paramzpw, zpv paramzpv, zpk paramzpk, StoryVideoItem paramStoryVideoItem)
  {
    yqp.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramzpk instanceof zpu)) {
      return;
    }
    paramzpk = (zpu)paramzpk;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramzpk.b(false);
      paramzpk.a(paramStoryVideoItem.mRateResult);
      paramzpk.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramzpk.a(true);
        paramzpk.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramzpk.a(paramzpv, true);
          return;
        }
        paramzpk.a(null, false);
        return;
      }
      paramzpk.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramzpk.b(false);
      paramzpk.a(0.0F);
      paramzpk.a(null);
      paramzpk.a(false);
      return;
    }
    paramzpk.b(true);
    paramzpk.a(0.0F);
    paramzpk.a(paramzpw);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramzpk.a(true);
      paramzpk.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramzpk.a(paramzpv, true);
      return;
    }
    paramzpk.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */