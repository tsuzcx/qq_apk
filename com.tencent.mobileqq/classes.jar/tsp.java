import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class tsp
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, wdi paramwdi, float paramFloat)
  {
    if (paramInt == ((Integer)paramwdi.a().getTag(2131373384)).intValue())
    {
      tld.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramwdi.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(wdk paramwdk, wdj paramwdj, FrameLayout paramFrameLayout, wcy paramwcy, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      ved.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    ved.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      ved.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramwcy.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramwcy.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramwdk, paramwdj, paramFrameLayout, paramwcy, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(wdk paramwdk, wdj paramwdj, wcy paramwcy, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      ved.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramwcy instanceof wdi)) {
      return;
    }
    b(paramwdk, paramwdj, paramwcy, paramStoryVideoItem);
  }
  
  public static void b(wdk paramwdk, wdj paramwdj, FrameLayout paramFrameLayout, wcy paramwcy, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    ved.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramwdk, paramwdj, paramFrameLayout, paramwcy, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(wdk paramwdk, wdj paramwdj, FrameLayout paramFrameLayout, wcy paramwcy, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    tei localtei = paramStoryVideoItem.getInteractLayout();
    if (localtei == null) {
      ved.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      ved.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramwcy.a();
      localView.setTag(2131373384, Integer.valueOf(paramInt));
      i = localtei.b;
      j = localtei.c;
      k = localtei.d;
      m = localtei.e;
      f1 = localtei.f;
      f2 = localtei.g;
      f3 = localtei.h;
      String[] arrayOfString = localtei.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        ved.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      ved.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramwcy.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramwdk, paramwdj, paramFrameLayout, paramwcy, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramwcy.a(localtei.b, localtei.c, paramInt, n, localtei.d, localtei.e, localtei.f, localtei.g, localtei.h);
    paramwcy.a();
    a(paramwdk, paramwdj, paramwcy, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    ved.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    ved.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(wdk paramwdk, wdj paramwdj, wcy paramwcy, StoryVideoItem paramStoryVideoItem)
  {
    ved.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramwcy instanceof wdi)) {
      return;
    }
    paramwcy = (wdi)paramwcy;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramwcy.b(false);
      paramwcy.a(paramStoryVideoItem.mRateResult);
      paramwcy.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramwcy.a(true);
        paramwcy.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramwcy.a(paramwdj, true);
          return;
        }
        paramwcy.a(null, false);
        return;
      }
      paramwcy.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramwcy.b(false);
      paramwcy.a(0.0F);
      paramwcy.a(null);
      paramwcy.a(false);
      return;
    }
    paramwcy.b(true);
    paramwcy.a(0.0F);
    paramwcy.a(paramwdk);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramwcy.a(true);
      paramwcy.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramwcy.a(paramwdj, true);
      return;
    }
    paramwcy.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsp
 * JD-Core Version:    0.7.0.1
 */