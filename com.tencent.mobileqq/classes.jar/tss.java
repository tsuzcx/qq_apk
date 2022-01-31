import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class tss
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, wdl paramwdl, float paramFloat)
  {
    if (paramInt == ((Integer)paramwdl.a().getTag(2131373382)).intValue())
    {
      tlg.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramwdl.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(wdn paramwdn, wdm paramwdm, FrameLayout paramFrameLayout, wdb paramwdb, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      veg.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    veg.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      veg.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramwdb.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramwdb.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramwdn, paramwdm, paramFrameLayout, paramwdb, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(wdn paramwdn, wdm paramwdm, wdb paramwdb, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      veg.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramwdb instanceof wdl)) {
      return;
    }
    b(paramwdn, paramwdm, paramwdb, paramStoryVideoItem);
  }
  
  public static void b(wdn paramwdn, wdm paramwdm, FrameLayout paramFrameLayout, wdb paramwdb, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    veg.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramwdn, paramwdm, paramFrameLayout, paramwdb, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(wdn paramwdn, wdm paramwdm, FrameLayout paramFrameLayout, wdb paramwdb, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    tel localtel = paramStoryVideoItem.getInteractLayout();
    if (localtel == null) {
      veg.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      veg.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramwdb.a();
      localView.setTag(2131373382, Integer.valueOf(paramInt));
      i = localtel.b;
      j = localtel.c;
      k = localtel.d;
      m = localtel.e;
      f1 = localtel.f;
      f2 = localtel.g;
      f3 = localtel.h;
      String[] arrayOfString = localtel.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        veg.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      veg.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramwdb.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramwdn, paramwdm, paramFrameLayout, paramwdb, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramwdb.a(localtel.b, localtel.c, paramInt, n, localtel.d, localtel.e, localtel.f, localtel.g, localtel.h);
    paramwdb.a();
    a(paramwdn, paramwdm, paramwdb, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    veg.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    veg.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(wdn paramwdn, wdm paramwdm, wdb paramwdb, StoryVideoItem paramStoryVideoItem)
  {
    veg.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramwdb instanceof wdl)) {
      return;
    }
    paramwdb = (wdl)paramwdb;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramwdb.b(false);
      paramwdb.a(paramStoryVideoItem.mRateResult);
      paramwdb.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramwdb.a(true);
        paramwdb.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramwdb.a(paramwdm, true);
          return;
        }
        paramwdb.a(null, false);
        return;
      }
      paramwdb.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramwdb.b(false);
      paramwdb.a(0.0F);
      paramwdb.a(null);
      paramwdb.a(false);
      return;
    }
    paramwdb.b(true);
    paramwdb.a(0.0F);
    paramwdb.a(paramwdn);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramwdb.a(true);
      paramwdb.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramwdb.a(paramwdm, true);
      return;
    }
    paramwdb.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tss
 * JD-Core Version:    0.7.0.1
 */