import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils.1;

public class qek
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, rsr paramrsr, float paramFloat)
  {
    if (paramInt == ((Integer)paramrsr.az().getTag(2131375266)).intValue())
    {
      pya.r(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramrsr.C()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(rsr.b paramb, rsr.a parama, FrameLayout paramFrameLayout, rsk paramrsk, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      ram.e("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    ram.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      ram.d("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramrsk.ug(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramrsk.az(), localLayoutParams);
    paramFrameLayout.forceLayout();
    a(paramb, parama, paramFrameLayout, paramrsk, paramInt, paramStoryVideoItem, false);
  }
  
  private static void a(rsr.b paramb, rsr.a parama, FrameLayout paramFrameLayout, rsk paramrsk, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    StoryVideoItem.a locala = paramStoryVideoItem.getInteractLayout();
    if (locala == null) {
      ram.d("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      ram.d("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramrsk.az();
      localView.setTag(2131375266, Integer.valueOf(paramInt));
      i = locala.screenWidth;
      j = locala.screenHeight;
      k = locala.bkn;
      m = locala.layoutHeight;
      f1 = locala.bko;
      f2 = locala.bkp;
      f3 = locala.rotation;
      String[] arrayOfString = locala.bR;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        ram.i("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      ram.d("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramrsk.t(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramb, parama, paramFrameLayout, paramrsk, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramrsk.a(locala.screenWidth, locala.screenHeight, paramInt, n, locala.bkn, locala.layoutHeight, locala.bko, locala.bkp, locala.rotation);
    paramrsk.acf();
    a(paramb, parama, paramrsk, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    ram.d("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    ram.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  public static void a(rsr.b paramb, rsr.a parama, rsk paramrsk, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      ram.e("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramrsk instanceof rsr)) {
      return;
    }
    b(paramb, parama, paramrsk, paramStoryVideoItem);
  }
  
  public static void b(rsr.b paramb, rsr.a parama, FrameLayout paramFrameLayout, rsk paramrsk, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    ram.b("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    a(paramb, parama, paramFrameLayout, paramrsk, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(rsr.b paramb, rsr.a parama, rsk paramrsk, StoryVideoItem paramStoryVideoItem)
  {
    ram.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramrsk instanceof rsr)) {
      return;
    }
    paramrsk = (rsr)paramrsk;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().getCurrentUid());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramrsk.setRatable(false);
      paramrsk.setRate(paramStoryVideoItem.mRateResult);
      paramrsk.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramrsk.ug(true);
        paramrsk.ae(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramrsk.a(parama, true);
          return;
        }
        paramrsk.a(null, false);
        return;
      }
      paramrsk.ug(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramrsk.setRatable(false);
      paramrsk.setRate(0.0F);
      paramrsk.a(null);
      paramrsk.ug(false);
      return;
    }
    paramrsk.setRatable(true);
    paramrsk.setRate(0.0F);
    paramrsk.a(paramb);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramrsk.ug(true);
      paramrsk.ae(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramrsk.a(parama, true);
      return;
    }
    paramrsk.ug(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qek
 * JD-Core Version:    0.7.0.1
 */