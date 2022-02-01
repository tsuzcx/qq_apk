import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class xix
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, ztp paramztp, float paramFloat)
  {
    if (paramInt == ((Integer)paramztp.a().getTag(2131374723)).intValue())
    {
      xbl.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramztp.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(ztr paramztr, ztq paramztq, FrameLayout paramFrameLayout, ztf paramztf, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      yuk.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    yuk.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      yuk.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramztf.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramztf.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramztr, paramztq, paramFrameLayout, paramztf, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(ztr paramztr, ztq paramztq, ztf paramztf, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      yuk.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramztf instanceof ztp)) {
      return;
    }
    b(paramztr, paramztq, paramztf, paramStoryVideoItem);
  }
  
  public static void b(ztr paramztr, ztq paramztq, FrameLayout paramFrameLayout, ztf paramztf, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    yuk.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramztr, paramztq, paramFrameLayout, paramztf, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(ztr paramztr, ztq paramztq, FrameLayout paramFrameLayout, ztf paramztf, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    wuq localwuq = paramStoryVideoItem.getInteractLayout();
    if (localwuq == null) {
      yuk.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      yuk.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramztf.a();
      localView.setTag(2131374723, Integer.valueOf(paramInt));
      i = localwuq.b;
      j = localwuq.c;
      k = localwuq.d;
      m = localwuq.e;
      f1 = localwuq.f;
      f2 = localwuq.g;
      f3 = localwuq.h;
      String[] arrayOfString = localwuq.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        yuk.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      yuk.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramztf.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramztr, paramztq, paramFrameLayout, paramztf, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramztf.a(localwuq.b, localwuq.c, paramInt, n, localwuq.d, localwuq.e, localwuq.f, localwuq.g, localwuq.h);
    paramztf.a();
    a(paramztr, paramztq, paramztf, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    yuk.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    yuk.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(ztr paramztr, ztq paramztq, ztf paramztf, StoryVideoItem paramStoryVideoItem)
  {
    yuk.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramztf instanceof ztp)) {
      return;
    }
    paramztf = (ztp)paramztf;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramztf.b(false);
      paramztf.a(paramStoryVideoItem.mRateResult);
      paramztf.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramztf.a(true);
        paramztf.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramztf.a(paramztq, true);
          return;
        }
        paramztf.a(null, false);
        return;
      }
      paramztf.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramztf.b(false);
      paramztf.a(0.0F);
      paramztf.a(null);
      paramztf.a(false);
      return;
    }
    paramztf.b(true);
    paramztf.a(0.0F);
    paramztf.a(paramztr);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramztf.a(true);
      paramztf.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramztf.a(paramztq, true);
      return;
    }
    paramztf.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xix
 * JD-Core Version:    0.7.0.1
 */