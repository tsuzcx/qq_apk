import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class wkn
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, yta paramyta, float paramFloat)
  {
    if (paramInt == ((Integer)paramyta.a().getTag(2131374491)).intValue())
    {
      wdb.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramyta.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(ytc paramytc, ytb paramytb, FrameLayout paramFrameLayout, ysq paramysq, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      xvv.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    xvv.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      xvv.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramysq.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramysq.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramytc, paramytb, paramFrameLayout, paramysq, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(ytc paramytc, ytb paramytb, ysq paramysq, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      xvv.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramysq instanceof yta)) {
      return;
    }
    b(paramytc, paramytb, paramysq, paramStoryVideoItem);
  }
  
  public static void b(ytc paramytc, ytb paramytb, FrameLayout paramFrameLayout, ysq paramysq, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    xvv.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramytc, paramytb, paramFrameLayout, paramysq, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(ytc paramytc, ytb paramytb, FrameLayout paramFrameLayout, ysq paramysq, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    vwg localvwg = paramStoryVideoItem.getInteractLayout();
    if (localvwg == null) {
      xvv.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      xvv.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramysq.a();
      localView.setTag(2131374491, Integer.valueOf(paramInt));
      i = localvwg.b;
      j = localvwg.c;
      k = localvwg.d;
      m = localvwg.e;
      f1 = localvwg.f;
      f2 = localvwg.g;
      f3 = localvwg.h;
      String[] arrayOfString = localvwg.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        xvv.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      xvv.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramysq.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramytc, paramytb, paramFrameLayout, paramysq, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramysq.a(localvwg.b, localvwg.c, paramInt, n, localvwg.d, localvwg.e, localvwg.f, localvwg.g, localvwg.h);
    paramysq.a();
    a(paramytc, paramytb, paramysq, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    xvv.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    xvv.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(ytc paramytc, ytb paramytb, ysq paramysq, StoryVideoItem paramStoryVideoItem)
  {
    xvv.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramysq instanceof yta)) {
      return;
    }
    paramysq = (yta)paramysq;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramysq.b(false);
      paramysq.a(paramStoryVideoItem.mRateResult);
      paramysq.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramysq.a(true);
        paramysq.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramysq.a(paramytb, true);
          return;
        }
        paramysq.a(null, false);
        return;
      }
      paramysq.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramysq.b(false);
      paramysq.a(0.0F);
      paramysq.a(null);
      paramysq.a(false);
      return;
    }
    paramysq.b(true);
    paramysq.a(0.0F);
    paramysq.a(paramytc);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramysq.a(true);
      paramysq.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramysq.a(paramytb, true);
      return;
    }
    paramysq.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkn
 * JD-Core Version:    0.7.0.1
 */