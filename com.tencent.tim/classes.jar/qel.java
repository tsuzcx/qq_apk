import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils.1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class qel
{
  public static void a(rpg.a parama, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      parama.ua(paramBoolean);
      return;
    }
  }
  
  public static void a(rpg.e parame, rpg.c paramc, FrameLayout paramFrameLayout, rpg.a parama, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      ram.e("Q.qqstory.PlayModePollViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    ram.b("Q.qqstory.PlayModePollViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getPollLayout() == null)
    {
      ram.d("Q.qqstory.PlayModePollViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    parama.tW(false);
    parama.tY(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(parama.getView(), localLayoutParams);
    if (!((Boolean)((psr)psx.a(10)).c("has_play_poll_animation_guide", Boolean.valueOf(false))).booleanValue()) {
      parama.ua(true);
    }
    paramFrameLayout.forceLayout();
    a(parame, paramc, paramFrameLayout, parama, paramInt, paramStoryVideoItem, false);
  }
  
  private static void a(rpg.e parame, rpg.c paramc, FrameLayout paramFrameLayout, rpg.a parama, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    StoryVideoItem.b localb = paramStoryVideoItem.getPollLayout();
    if (localb == null) {
      ram.d("Q.qqstory.PlayModePollViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int m;
    int n;
    int i1;
    int i2;
    float f1;
    float f2;
    float f3;
    label199:
    label211:
    do
    {
      return;
      ram.d("Q.qqstory.PlayModePollViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = parama.getView();
      localView.setTag(2131375266, Integer.valueOf(paramInt));
      ram.d("Q.qqstory.PlayModePollViewUtils", "Users Count: %d", Integer.valueOf(paramStoryVideoItem.mPollUsers.size()));
      if (paramStoryVideoItem.mPollNumbers == null)
      {
        i = 0;
        if (paramStoryVideoItem.mPollNumbers != null) {
          break label199;
        }
      }
      for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
      {
        ram.d("Q.qqstory.PlayModePollViewUtils", "Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
        m = localb.screenWidth;
        n = localb.screenHeight;
        i1 = localb.bkn;
        i2 = localb.layoutHeight;
        f1 = localb.bko;
        f2 = localb.bkp;
        f3 = localb.rotation;
        localObject = localb.bR;
        if ((localObject != null) && (localObject.length != 0)) {
          break label211;
        }
        ram.i("Q.qqstory.PlayModePollViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
        i = paramStoryVideoItem.mPollNumbers[0];
        break;
      }
      ram.d("Q.qqstory.PlayModePollViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      parama.a().setText(localObject[0]);
      j = Math.min(localObject.length, parama.tL());
      i = 1;
      while (i < j)
      {
        parama.a(i - 1).setText(localObject[i]);
        parama.a(i - 1).setSelect(false);
        i += 1;
      }
      int k = 0;
      i = 0;
      Object localObject = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
      if (paramStoryVideoItem.mPollNumbers != null)
      {
        parama.j(paramStoryVideoItem.mPollNumbers);
        int[] arrayOfInt = paramStoryVideoItem.mPollNumbers;
        int i3 = arrayOfInt.length;
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= i3) {
            break;
          }
          k = arrayOfInt[j];
          j += 1;
          i = k + i;
        }
      }
      parama.E((List)localObject, k);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModePollViewUtils.1(parame, paramc, paramFrameLayout, parama, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int i = paramFrameLayout.getHeight();
    parama.a(localb, paramInt, i);
    parama.bvM();
    a(parame, paramc, parama, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    ram.d("Q.qqstory.PlayModePollViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(i) });
    ram.a("Q.qqstory.PlayModePollViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  public static void a(rpg.e parame, rpg.c paramc, rpg.a parama, int paramInt, String paramString, @NonNull StoryVideoItem paramStoryVideoItem, rpg.i parami)
  {
    int i = 1;
    if ((parami instanceof rpg.g)) {}
    int j;
    do
    {
      return;
      j = ((rpg.f)parami).tM();
    } while (paramInt != ((Integer)parama.getView().getTag(2131375266)).intValue());
    ram.i("Q.qqstory.PlayModePollViewUtils", "[%d]vid:%s  投票!! poll index %d!! %.2f %.2f", new Object[] { Integer.valueOf(paramInt), paramStoryVideoItem.mVid, Integer.valueOf(j), Float.valueOf(parama.getView().getX()), Float.valueOf(parama.getView().getY()) });
    StoryVideoItem.b localb = paramStoryVideoItem.getPollLayout();
    if ((localb != null) && (localb.bR.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localb.bR[0]);
      paramInt = 1;
      while (paramInt < localb.bR.length)
      {
        localStringBuilder.append(";");
        localStringBuilder.append(localb.bR[paramInt]);
        paramInt += 1;
      }
    }
    parama.ua(false);
    ((psr)psx.a(10)).n("has_play_poll_animation_guide", Boolean.valueOf(true));
    parama.tW(true);
    parama.a(null);
    parami.setSelect(true);
    pxz.q(paramString, paramStoryVideoItem.mVid, j);
    if (paramStoryVideoItem.mPollResult == -1)
    {
      paramString = QQStoryContext.a().getCurrentUid();
      parami = paramStoryVideoItem.mPollUsers.iterator();
      do
      {
        if (!parami.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((QQUserUIItem)parami.next()).uid, paramString));
    }
    for (paramInt = i;; paramInt = 0)
    {
      if ((paramStoryVideoItem.mPollNumbers == null) && (paramStoryVideoItem.getPollLayout().bR != null))
      {
        paramStoryVideoItem.mPollNumbers = new int[paramStoryVideoItem.getPollLayout().bR.length - 1];
        Arrays.fill(paramStoryVideoItem.mPollNumbers, 0);
      }
      if ((paramStoryVideoItem.mPollNumbers != null) && (paramStoryVideoItem.mPollNumbers.length > j))
      {
        paramString = paramStoryVideoItem.mPollNumbers;
        paramString[j] += 1;
      }
      if (paramInt == 0)
      {
        paramString = ((ptf)psx.a(2)).a();
        if (paramString == null) {
          break label441;
        }
        paramStoryVideoItem.mPollUsers.add(0, paramString);
      }
      for (;;)
      {
        paramStoryVideoItem.mPollResult = j;
        a(parame, paramc, parama, paramStoryVideoItem);
        return;
        label441:
        annt.e(rpl.a.a("Cached.Story.PollUtils getMySelfItem() return null"), "PlayModePollViewUtils PlayModePollViewUtils::onClickPollViewButton");
      }
    }
  }
  
  public static void a(rpg.e parame, rpg.c paramc, rpg.a parama, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = false;
    if (paramStoryVideoItem == null)
    {
      ram.e("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
    ram.b("Q.qqstory.PlayModePollViewUtils", "bindPollView Users Count: %d", Integer.valueOf(localCopyOnWriteArrayList.size()));
    int i;
    if (paramStoryVideoItem.mPollNumbers == null)
    {
      i = 0;
      if (paramStoryVideoItem.mPollNumbers != null) {
        break label172;
      }
    }
    label172:
    for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
    {
      ram.b("Q.qqstory.PlayModePollViewUtils", "bindPollView Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
      if (paramStoryVideoItem.mPollNumbers == null) {
        break label183;
      }
      parama.j(paramStoryVideoItem.mPollNumbers);
      int[] arrayOfInt = paramStoryVideoItem.mPollNumbers;
      int m = arrayOfInt.length;
      j = 0;
      for (i = 0;; i = k + i)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        j += 1;
      }
      i = paramStoryVideoItem.mPollNumbers[0];
      break;
    }
    label183:
    int k = 0;
    boolean bool1;
    label230:
    boolean bool2;
    if (paramStoryVideoItem.mPollResult != -1)
    {
      bool1 = true;
      if (!bool1) {
        break label347;
      }
      parama.a(null);
      parama.tW(true);
      parama.a(paramStoryVideoItem.mPollResult).setSelect(true);
      boolean bool4 = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().getCurrentUid());
      bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (localCopyOnWriteArrayList.size() > 0) {
          bool2 = true;
        }
      }
      if ((bool4) && (!bool2)) {
        ram.i("Q.qqstory.PlayModePollViewUtils", "PollUsers data is not ready, wait for User Icon data to display");
      }
      if ((bool4) && (k > 0)) {
        parama.tW(true);
      }
      if (!bool2) {
        break label377;
      }
    }
    for (;;)
    {
      parama.a(paramc);
      parama.E(localCopyOnWriteArrayList, k);
      parama.tX(bool2);
      a(parama, bool1);
      return;
      bool1 = false;
      break;
      label347:
      if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
      {
        parama.a(null);
        break label230;
      }
      parama.a(parame);
      break label230;
      label377:
      paramc = null;
    }
  }
  
  public static void b(rpg.e parame, rpg.c paramc, FrameLayout paramFrameLayout, rpg.a parama, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    ram.b("Q.qqstory.PlayModePollViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    a(parame, paramc, paramFrameLayout, parama, paramInt, paramStoryVideoItem, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qel
 * JD-Core Version:    0.7.0.1
 */