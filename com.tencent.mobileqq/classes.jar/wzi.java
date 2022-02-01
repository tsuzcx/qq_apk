import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class wzi
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, zht paramzht, float paramFloat)
  {
    if (paramInt == ((Integer)paramzht.a().getTag(2131374729)).intValue())
    {
      wrw.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramzht.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(zhv paramzhv, zhu paramzhu, FrameLayout paramFrameLayout, zhj paramzhj, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      ykq.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    ykq.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      ykq.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramzhj.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramzhj.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramzhv, paramzhu, paramFrameLayout, paramzhj, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(zhv paramzhv, zhu paramzhu, zhj paramzhj, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      ykq.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramzhj instanceof zht)) {
      return;
    }
    b(paramzhv, paramzhu, paramzhj, paramStoryVideoItem);
  }
  
  public static void b(zhv paramzhv, zhu paramzhu, FrameLayout paramFrameLayout, zhj paramzhj, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    ykq.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramzhv, paramzhu, paramFrameLayout, paramzhj, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(zhv paramzhv, zhu paramzhu, FrameLayout paramFrameLayout, zhj paramzhj, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    wlb localwlb = paramStoryVideoItem.getInteractLayout();
    if (localwlb == null) {
      ykq.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      ykq.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramzhj.a();
      localView.setTag(2131374729, Integer.valueOf(paramInt));
      i = localwlb.b;
      j = localwlb.c;
      k = localwlb.d;
      m = localwlb.e;
      f1 = localwlb.f;
      f2 = localwlb.g;
      f3 = localwlb.h;
      String[] arrayOfString = localwlb.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        ykq.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      ykq.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramzhj.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramzhv, paramzhu, paramFrameLayout, paramzhj, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramzhj.a(localwlb.b, localwlb.c, paramInt, n, localwlb.d, localwlb.e, localwlb.f, localwlb.g, localwlb.h);
    paramzhj.a();
    a(paramzhv, paramzhu, paramzhj, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    ykq.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    ykq.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(zhv paramzhv, zhu paramzhu, zhj paramzhj, StoryVideoItem paramStoryVideoItem)
  {
    ykq.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramzhj instanceof zht)) {
      return;
    }
    paramzhj = (zht)paramzhj;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramzhj.b(false);
      paramzhj.a(paramStoryVideoItem.mRateResult);
      paramzhj.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramzhj.a(true);
        paramzhj.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramzhj.a(paramzhu, true);
          return;
        }
        paramzhj.a(null, false);
        return;
      }
      paramzhj.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramzhj.b(false);
      paramzhj.a(0.0F);
      paramzhj.a(null);
      paramzhj.a(false);
      return;
    }
    paramzhj.b(true);
    paramzhj.a(0.0F);
    paramzhj.a(paramzhv);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramzhj.a(true);
      paramzhj.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramzhj.a(paramzhu, true);
      return;
    }
    paramzhj.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */