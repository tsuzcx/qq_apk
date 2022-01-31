import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class vhh
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, xsa paramxsa, float paramFloat)
  {
    if (paramInt == ((Integer)paramxsa.a().getTag(2131373833)).intValue())
    {
      uzv.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramxsa.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(xsc paramxsc, xsb paramxsb, FrameLayout paramFrameLayout, xrq paramxrq, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      wsv.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    wsv.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      wsv.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramxrq.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramxrq.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramxsc, paramxsb, paramFrameLayout, paramxrq, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(xsc paramxsc, xsb paramxsb, xrq paramxrq, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      wsv.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramxrq instanceof xsa)) {
      return;
    }
    b(paramxsc, paramxsb, paramxrq, paramStoryVideoItem);
  }
  
  public static void b(xsc paramxsc, xsb paramxsb, FrameLayout paramFrameLayout, xrq paramxrq, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    wsv.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramxsc, paramxsb, paramFrameLayout, paramxrq, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(xsc paramxsc, xsb paramxsb, FrameLayout paramFrameLayout, xrq paramxrq, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    uta localuta = paramStoryVideoItem.getInteractLayout();
    if (localuta == null) {
      wsv.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      wsv.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramxrq.a();
      localView.setTag(2131373833, Integer.valueOf(paramInt));
      i = localuta.b;
      j = localuta.c;
      k = localuta.d;
      m = localuta.e;
      f1 = localuta.f;
      f2 = localuta.g;
      f3 = localuta.h;
      String[] arrayOfString = localuta.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        wsv.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      wsv.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramxrq.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramxsc, paramxsb, paramFrameLayout, paramxrq, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramxrq.a(localuta.b, localuta.c, paramInt, n, localuta.d, localuta.e, localuta.f, localuta.g, localuta.h);
    paramxrq.a();
    a(paramxsc, paramxsb, paramxrq, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    wsv.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    wsv.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(xsc paramxsc, xsb paramxsb, xrq paramxrq, StoryVideoItem paramStoryVideoItem)
  {
    wsv.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramxrq instanceof xsa)) {
      return;
    }
    paramxrq = (xsa)paramxrq;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramxrq.b(false);
      paramxrq.a(paramStoryVideoItem.mRateResult);
      paramxrq.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramxrq.a(true);
        paramxrq.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramxrq.a(paramxsb, true);
          return;
        }
        paramxrq.a(null, false);
        return;
      }
      paramxrq.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramxrq.b(false);
      paramxrq.a(0.0F);
      paramxrq.a(null);
      paramxrq.a(false);
      return;
    }
    paramxrq.b(true);
    paramxrq.a(0.0F);
    paramxrq.a(paramxsc);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramxrq.a(true);
      paramxrq.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramxrq.a(paramxsb, true);
      return;
    }
    paramxrq.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vhh
 * JD-Core Version:    0.7.0.1
 */