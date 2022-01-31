import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class vlq
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, xwj paramxwj, float paramFloat)
  {
    if (paramInt == ((Integer)paramxwj.a().getTag(2131373884)).intValue())
    {
      vee.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramxwj.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(xwl paramxwl, xwk paramxwk, FrameLayout paramFrameLayout, xvz paramxvz, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      wxe.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    wxe.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      wxe.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramxvz.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramxvz.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramxwl, paramxwk, paramFrameLayout, paramxvz, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(xwl paramxwl, xwk paramxwk, xvz paramxvz, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      wxe.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramxvz instanceof xwj)) {
      return;
    }
    b(paramxwl, paramxwk, paramxvz, paramStoryVideoItem);
  }
  
  public static void b(xwl paramxwl, xwk paramxwk, FrameLayout paramFrameLayout, xvz paramxvz, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    wxe.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramxwl, paramxwk, paramFrameLayout, paramxvz, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(xwl paramxwl, xwk paramxwk, FrameLayout paramFrameLayout, xvz paramxvz, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    uxj localuxj = paramStoryVideoItem.getInteractLayout();
    if (localuxj == null) {
      wxe.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      wxe.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramxvz.a();
      localView.setTag(2131373884, Integer.valueOf(paramInt));
      i = localuxj.b;
      j = localuxj.c;
      k = localuxj.d;
      m = localuxj.e;
      f1 = localuxj.f;
      f2 = localuxj.g;
      f3 = localuxj.h;
      String[] arrayOfString = localuxj.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        wxe.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      wxe.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramxvz.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramxwl, paramxwk, paramFrameLayout, paramxvz, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramxvz.a(localuxj.b, localuxj.c, paramInt, n, localuxj.d, localuxj.e, localuxj.f, localuxj.g, localuxj.h);
    paramxvz.a();
    a(paramxwl, paramxwk, paramxvz, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    wxe.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    wxe.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(xwl paramxwl, xwk paramxwk, xvz paramxvz, StoryVideoItem paramStoryVideoItem)
  {
    wxe.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramxvz instanceof xwj)) {
      return;
    }
    paramxvz = (xwj)paramxvz;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramxvz.b(false);
      paramxvz.a(paramStoryVideoItem.mRateResult);
      paramxvz.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramxvz.a(true);
        paramxvz.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramxvz.a(paramxwk, true);
          return;
        }
        paramxvz.a(null, false);
        return;
      }
      paramxvz.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramxvz.b(false);
      paramxvz.a(0.0F);
      paramxvz.a(null);
      paramxvz.a(false);
      return;
    }
    paramxvz.b(true);
    paramxvz.a(0.0F);
    paramxvz.a(paramxwl);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramxvz.a(true);
      paramxvz.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramxvz.a(paramxwk, true);
      return;
    }
    paramxvz.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlq
 * JD-Core Version:    0.7.0.1
 */