import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils.1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class tst
{
  public static void a(vyu paramvyu, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramvyu.e(paramBoolean);
      return;
    }
  }
  
  public static void a(vyy paramvyy, vyw paramvyw, FrameLayout paramFrameLayout, vyu paramvyu, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      veg.c("Q.qqstory.PlayModePollViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    veg.a("Q.qqstory.PlayModePollViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getPollLayout() == null)
    {
      veg.b("Q.qqstory.PlayModePollViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramvyu.a(false);
    paramvyu.c(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramvyu.a(), localLayoutParams);
    if (!((Boolean)((tcv)tdc.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(false))).booleanValue()) {
      paramvyu.e(true);
    }
    paramFrameLayout.forceLayout();
    b(paramvyy, paramvyw, paramFrameLayout, paramvyu, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(vyy paramvyy, vyw paramvyw, vyu paramvyu, int paramInt, String paramString, @NonNull StoryVideoItem paramStoryVideoItem, vzc paramvzc)
  {
    int i = 1;
    if ((paramvzc instanceof vza)) {}
    int j;
    do
    {
      return;
      j = ((vyz)paramvzc).a();
    } while (paramInt != ((Integer)paramvyu.a().getTag(2131373382)).intValue());
    veg.c("Q.qqstory.PlayModePollViewUtils", "[%d]vid:%s  投票!! poll index %d!! %.2f %.2f", new Object[] { Integer.valueOf(paramInt), paramStoryVideoItem.mVid, Integer.valueOf(j), Float.valueOf(paramvyu.a().getX()), Float.valueOf(paramvyu.a().getY()) });
    tem localtem = paramStoryVideoItem.getPollLayout();
    if ((localtem != null) && (localtem.a.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localtem.a[0]);
      paramInt = 1;
      while (paramInt < localtem.a.length)
      {
        localStringBuilder.append(";");
        localStringBuilder.append(localtem.a[paramInt]);
        paramInt += 1;
      }
    }
    paramvyu.e(false);
    ((tcv)tdc.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(true));
    paramvyu.a(true);
    paramvyu.a(null);
    paramvzc.b(true);
    tle.a(paramString, paramStoryVideoItem.mVid, j);
    if (paramStoryVideoItem.mPollResult == -1)
    {
      paramString = QQStoryContext.a().b();
      paramvzc = paramStoryVideoItem.mPollUsers.iterator();
      do
      {
        if (!paramvzc.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((QQUserUIItem)paramvzc.next()).uid, paramString));
    }
    for (paramInt = i;; paramInt = 0)
    {
      if ((paramStoryVideoItem.mPollNumbers == null) && (paramStoryVideoItem.getPollLayout().a != null))
      {
        paramStoryVideoItem.mPollNumbers = new int[paramStoryVideoItem.getPollLayout().a.length - 1];
        Arrays.fill(paramStoryVideoItem.mPollNumbers, 0);
      }
      if ((paramStoryVideoItem.mPollNumbers != null) && (paramStoryVideoItem.mPollNumbers.length > j))
      {
        paramString = paramStoryVideoItem.mPollNumbers;
        paramString[j] += 1;
      }
      if (paramInt == 0)
      {
        paramString = ((tdo)tdc.a(2)).a();
        if (paramString == null) {
          break label439;
        }
        paramStoryVideoItem.mPollUsers.add(0, paramString);
      }
      for (;;)
      {
        paramStoryVideoItem.mPollResult = j;
        a(paramvyy, paramvyw, paramvyu, paramStoryVideoItem);
        return;
        label439:
        axps.a(vzj.a("Cached.Story.PollUtils getMySelfItem() return null"), "PlayModePollViewUtils PlayModePollViewUtils::onClickPollViewButton");
      }
    }
  }
  
  public static void a(vyy paramvyy, vyw paramvyw, vyu paramvyu, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = false;
    if (paramStoryVideoItem == null)
    {
      veg.c("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
    veg.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Users Count: %d", Integer.valueOf(localCopyOnWriteArrayList.size()));
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
      veg.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
      if (paramStoryVideoItem.mPollNumbers == null) {
        break label183;
      }
      paramvyu.a(paramStoryVideoItem.mPollNumbers);
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
      paramvyu.a(null);
      paramvyu.a(true);
      paramvyu.a(paramStoryVideoItem.mPollResult).b(true);
      boolean bool4 = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
      bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (localCopyOnWriteArrayList.size() > 0) {
          bool2 = true;
        }
      }
      if ((bool4) && (!bool2)) {
        veg.c("Q.qqstory.PlayModePollViewUtils", "PollUsers data is not ready, wait for User Icon data to display");
      }
      if ((bool4) && (k > 0)) {
        paramvyu.a(true);
      }
      if (!bool2) {
        break label377;
      }
    }
    for (;;)
    {
      paramvyu.a(paramvyw);
      paramvyu.a(localCopyOnWriteArrayList, k);
      paramvyu.b(bool2);
      a(paramvyu, bool1);
      return;
      bool1 = false;
      break;
      label347:
      if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
      {
        paramvyu.a(null);
        break label230;
      }
      paramvyu.a(paramvyy);
      break label230;
      label377:
      paramvyw = null;
    }
  }
  
  public static void b(vyy paramvyy, vyw paramvyw, FrameLayout paramFrameLayout, vyu paramvyu, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    veg.a("Q.qqstory.PlayModePollViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramvyy, paramvyw, paramFrameLayout, paramvyu, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(vyy paramvyy, vyw paramvyw, FrameLayout paramFrameLayout, vyu paramvyu, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    tem localtem = paramStoryVideoItem.getPollLayout();
    if (localtem == null) {
      veg.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int m;
    int n;
    int i1;
    int i2;
    float f1;
    float f2;
    float f3;
    label204:
    label216:
    do
    {
      return;
      veg.b("Q.qqstory.PlayModePollViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramvyu.a();
      localView.setTag(2131373382, Integer.valueOf(paramInt));
      veg.b("Q.qqstory.PlayModePollViewUtils", "Users Count: %d", Integer.valueOf(paramStoryVideoItem.mPollUsers.size()));
      if (paramStoryVideoItem.mPollNumbers == null)
      {
        i = 0;
        if (paramStoryVideoItem.mPollNumbers != null) {
          break label204;
        }
      }
      for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
      {
        veg.b("Q.qqstory.PlayModePollViewUtils", "Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
        m = localtem.c;
        n = localtem.d;
        i1 = localtem.e;
        i2 = localtem.f;
        f1 = localtem.g;
        f2 = localtem.h;
        f3 = localtem.i;
        localObject = localtem.a;
        if ((localObject != null) && (localObject.length != 0)) {
          break label216;
        }
        veg.c("Q.qqstory.PlayModePollViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
        i = paramStoryVideoItem.mPollNumbers[0];
        break;
      }
      veg.b("Q.qqstory.PlayModePollViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramvyu.a().a(localObject[0]);
      j = Math.min(localObject.length, paramvyu.a());
      i = 1;
      while (i < j)
      {
        paramvyu.a(i - 1).a(localObject[i]);
        paramvyu.a(i - 1).b(false);
        i += 1;
      }
      int k = 0;
      i = 0;
      Object localObject = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
      if (paramStoryVideoItem.mPollNumbers != null)
      {
        paramvyu.a(paramStoryVideoItem.mPollNumbers);
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
      paramvyu.a((List)localObject, k);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModePollViewUtils.1(paramvyy, paramvyw, paramFrameLayout, paramvyu, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int i = paramFrameLayout.getHeight();
    paramvyu.a(localtem, paramInt, i);
    paramvyu.a();
    a(paramvyy, paramvyw, paramvyu, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    veg.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(i) });
    veg.a("Q.qqstory.PlayModePollViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */