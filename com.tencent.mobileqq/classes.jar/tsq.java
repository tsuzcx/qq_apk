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

public class tsq
{
  public static void a(vyr paramvyr, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramvyr.e(paramBoolean);
      return;
    }
  }
  
  public static void a(vyv paramvyv, vyt paramvyt, FrameLayout paramFrameLayout, vyr paramvyr, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      ved.c("Q.qqstory.PlayModePollViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    ved.a("Q.qqstory.PlayModePollViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getPollLayout() == null)
    {
      ved.b("Q.qqstory.PlayModePollViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramvyr.a(false);
    paramvyr.c(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramvyr.a(), localLayoutParams);
    if (!((Boolean)((tcs)tcz.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(false))).booleanValue()) {
      paramvyr.e(true);
    }
    paramFrameLayout.forceLayout();
    b(paramvyv, paramvyt, paramFrameLayout, paramvyr, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(vyv paramvyv, vyt paramvyt, vyr paramvyr, int paramInt, String paramString, @NonNull StoryVideoItem paramStoryVideoItem, vyz paramvyz)
  {
    int i = 1;
    if ((paramvyz instanceof vyx)) {}
    int j;
    do
    {
      return;
      j = ((vyw)paramvyz).a();
    } while (paramInt != ((Integer)paramvyr.a().getTag(2131373384)).intValue());
    ved.c("Q.qqstory.PlayModePollViewUtils", "[%d]vid:%s  投票!! poll index %d!! %.2f %.2f", new Object[] { Integer.valueOf(paramInt), paramStoryVideoItem.mVid, Integer.valueOf(j), Float.valueOf(paramvyr.a().getX()), Float.valueOf(paramvyr.a().getY()) });
    tej localtej = paramStoryVideoItem.getPollLayout();
    if ((localtej != null) && (localtej.a.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localtej.a[0]);
      paramInt = 1;
      while (paramInt < localtej.a.length)
      {
        localStringBuilder.append(";");
        localStringBuilder.append(localtej.a[paramInt]);
        paramInt += 1;
      }
    }
    paramvyr.e(false);
    ((tcs)tcz.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(true));
    paramvyr.a(true);
    paramvyr.a(null);
    paramvyz.b(true);
    tlb.a(paramString, paramStoryVideoItem.mVid, j);
    if (paramStoryVideoItem.mPollResult == -1)
    {
      paramString = QQStoryContext.a().b();
      paramvyz = paramStoryVideoItem.mPollUsers.iterator();
      do
      {
        if (!paramvyz.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((QQUserUIItem)paramvyz.next()).uid, paramString));
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
        paramString = ((tdl)tcz.a(2)).a();
        if (paramString == null) {
          break label439;
        }
        paramStoryVideoItem.mPollUsers.add(0, paramString);
      }
      for (;;)
      {
        paramStoryVideoItem.mPollResult = j;
        a(paramvyv, paramvyt, paramvyr, paramStoryVideoItem);
        return;
        label439:
        axpu.a(vzg.a("Cached.Story.PollUtils getMySelfItem() return null"), "PlayModePollViewUtils PlayModePollViewUtils::onClickPollViewButton");
      }
    }
  }
  
  public static void a(vyv paramvyv, vyt paramvyt, vyr paramvyr, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = false;
    if (paramStoryVideoItem == null)
    {
      ved.c("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
    ved.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Users Count: %d", Integer.valueOf(localCopyOnWriteArrayList.size()));
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
      ved.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
      if (paramStoryVideoItem.mPollNumbers == null) {
        break label183;
      }
      paramvyr.a(paramStoryVideoItem.mPollNumbers);
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
      paramvyr.a(null);
      paramvyr.a(true);
      paramvyr.a(paramStoryVideoItem.mPollResult).b(true);
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
        ved.c("Q.qqstory.PlayModePollViewUtils", "PollUsers data is not ready, wait for User Icon data to display");
      }
      if ((bool4) && (k > 0)) {
        paramvyr.a(true);
      }
      if (!bool2) {
        break label377;
      }
    }
    for (;;)
    {
      paramvyr.a(paramvyt);
      paramvyr.a(localCopyOnWriteArrayList, k);
      paramvyr.b(bool2);
      a(paramvyr, bool1);
      return;
      bool1 = false;
      break;
      label347:
      if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
      {
        paramvyr.a(null);
        break label230;
      }
      paramvyr.a(paramvyv);
      break label230;
      label377:
      paramvyt = null;
    }
  }
  
  public static void b(vyv paramvyv, vyt paramvyt, FrameLayout paramFrameLayout, vyr paramvyr, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    ved.a("Q.qqstory.PlayModePollViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramvyv, paramvyt, paramFrameLayout, paramvyr, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(vyv paramvyv, vyt paramvyt, FrameLayout paramFrameLayout, vyr paramvyr, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    tej localtej = paramStoryVideoItem.getPollLayout();
    if (localtej == null) {
      ved.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      ved.b("Q.qqstory.PlayModePollViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramvyr.a();
      localView.setTag(2131373384, Integer.valueOf(paramInt));
      ved.b("Q.qqstory.PlayModePollViewUtils", "Users Count: %d", Integer.valueOf(paramStoryVideoItem.mPollUsers.size()));
      if (paramStoryVideoItem.mPollNumbers == null)
      {
        i = 0;
        if (paramStoryVideoItem.mPollNumbers != null) {
          break label204;
        }
      }
      for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
      {
        ved.b("Q.qqstory.PlayModePollViewUtils", "Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
        m = localtej.c;
        n = localtej.d;
        i1 = localtej.e;
        i2 = localtej.f;
        f1 = localtej.g;
        f2 = localtej.h;
        f3 = localtej.i;
        localObject = localtej.a;
        if ((localObject != null) && (localObject.length != 0)) {
          break label216;
        }
        ved.c("Q.qqstory.PlayModePollViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
        i = paramStoryVideoItem.mPollNumbers[0];
        break;
      }
      ved.b("Q.qqstory.PlayModePollViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramvyr.a().a(localObject[0]);
      j = Math.min(localObject.length, paramvyr.a());
      i = 1;
      while (i < j)
      {
        paramvyr.a(i - 1).a(localObject[i]);
        paramvyr.a(i - 1).b(false);
        i += 1;
      }
      int k = 0;
      i = 0;
      Object localObject = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
      if (paramStoryVideoItem.mPollNumbers != null)
      {
        paramvyr.a(paramStoryVideoItem.mPollNumbers);
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
      paramvyr.a((List)localObject, k);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModePollViewUtils.1(paramvyv, paramvyt, paramFrameLayout, paramvyr, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int i = paramFrameLayout.getHeight();
    paramvyr.a(localtej, paramInt, i);
    paramvyr.a();
    a(paramvyv, paramvyt, paramvyr, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    ved.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(i) });
    ved.a("Q.qqstory.PlayModePollViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsq
 * JD-Core Version:    0.7.0.1
 */