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

public class vlr
{
  public static void a(xrs paramxrs, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramxrs.e(paramBoolean);
      return;
    }
  }
  
  public static void a(xrw paramxrw, xru paramxru, FrameLayout paramFrameLayout, xrs paramxrs, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      wxe.c("Q.qqstory.PlayModePollViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    wxe.a("Q.qqstory.PlayModePollViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getPollLayout() == null)
    {
      wxe.b("Q.qqstory.PlayModePollViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramxrs.a(false);
    paramxrs.c(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramxrs.a(), localLayoutParams);
    if (!((Boolean)((uvt)uwa.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(false))).booleanValue()) {
      paramxrs.e(true);
    }
    paramFrameLayout.forceLayout();
    b(paramxrw, paramxru, paramFrameLayout, paramxrs, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(xrw paramxrw, xru paramxru, xrs paramxrs, int paramInt, String paramString, @NonNull StoryVideoItem paramStoryVideoItem, xsa paramxsa)
  {
    int i = 1;
    if ((paramxsa instanceof xry)) {}
    int j;
    do
    {
      return;
      j = ((xrx)paramxsa).a();
    } while (paramInt != ((Integer)paramxrs.a().getTag(2131373884)).intValue());
    wxe.c("Q.qqstory.PlayModePollViewUtils", "[%d]vid:%s  投票!! poll index %d!! %.2f %.2f", new Object[] { Integer.valueOf(paramInt), paramStoryVideoItem.mVid, Integer.valueOf(j), Float.valueOf(paramxrs.a().getX()), Float.valueOf(paramxrs.a().getY()) });
    uxk localuxk = paramStoryVideoItem.getPollLayout();
    if ((localuxk != null) && (localuxk.a.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localuxk.a[0]);
      paramInt = 1;
      while (paramInt < localuxk.a.length)
      {
        localStringBuilder.append(";");
        localStringBuilder.append(localuxk.a[paramInt]);
        paramInt += 1;
      }
    }
    paramxrs.e(false);
    ((uvt)uwa.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(true));
    paramxrs.a(true);
    paramxrs.a(null);
    paramxsa.b(true);
    vec.a(paramString, paramStoryVideoItem.mVid, j);
    if (paramStoryVideoItem.mPollResult == -1)
    {
      paramString = QQStoryContext.a().b();
      paramxsa = paramStoryVideoItem.mPollUsers.iterator();
      do
      {
        if (!paramxsa.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((QQUserUIItem)paramxsa.next()).uid, paramString));
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
        paramString = ((uwm)uwa.a(2)).a();
        if (paramString == null) {
          break label439;
        }
        paramStoryVideoItem.mPollUsers.add(0, paramString);
      }
      for (;;)
      {
        paramStoryVideoItem.mPollResult = j;
        a(paramxrw, paramxru, paramxrs, paramStoryVideoItem);
        return;
        label439:
        azpo.a(xsh.a("Cached.Story.PollUtils getMySelfItem() return null"), "PlayModePollViewUtils PlayModePollViewUtils::onClickPollViewButton");
      }
    }
  }
  
  public static void a(xrw paramxrw, xru paramxru, xrs paramxrs, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool3 = false;
    if (paramStoryVideoItem == null)
    {
      wxe.c("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
    wxe.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Users Count: %d", Integer.valueOf(localCopyOnWriteArrayList.size()));
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
      wxe.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
      if (paramStoryVideoItem.mPollNumbers == null) {
        break label183;
      }
      paramxrs.a(paramStoryVideoItem.mPollNumbers);
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
      paramxrs.a(null);
      paramxrs.a(true);
      paramxrs.a(paramStoryVideoItem.mPollResult).b(true);
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
        wxe.c("Q.qqstory.PlayModePollViewUtils", "PollUsers data is not ready, wait for User Icon data to display");
      }
      if ((bool4) && (k > 0)) {
        paramxrs.a(true);
      }
      if (!bool2) {
        break label377;
      }
    }
    for (;;)
    {
      paramxrs.a(paramxru);
      paramxrs.a(localCopyOnWriteArrayList, k);
      paramxrs.b(bool2);
      a(paramxrs, bool1);
      return;
      bool1 = false;
      break;
      label347:
      if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
      {
        paramxrs.a(null);
        break label230;
      }
      paramxrs.a(paramxrw);
      break label230;
      label377:
      paramxru = null;
    }
  }
  
  public static void b(xrw paramxrw, xru paramxru, FrameLayout paramFrameLayout, xrs paramxrs, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    wxe.a("Q.qqstory.PlayModePollViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramxrw, paramxru, paramFrameLayout, paramxrs, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(xrw paramxrw, xru paramxru, FrameLayout paramFrameLayout, xrs paramxrs, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    uxk localuxk = paramStoryVideoItem.getPollLayout();
    if (localuxk == null) {
      wxe.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
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
      wxe.b("Q.qqstory.PlayModePollViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramxrs.a();
      localView.setTag(2131373884, Integer.valueOf(paramInt));
      wxe.b("Q.qqstory.PlayModePollViewUtils", "Users Count: %d", Integer.valueOf(paramStoryVideoItem.mPollUsers.size()));
      if (paramStoryVideoItem.mPollNumbers == null)
      {
        i = 0;
        if (paramStoryVideoItem.mPollNumbers != null) {
          break label204;
        }
      }
      for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
      {
        wxe.b("Q.qqstory.PlayModePollViewUtils", "Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
        m = localuxk.c;
        n = localuxk.d;
        i1 = localuxk.e;
        i2 = localuxk.f;
        f1 = localuxk.g;
        f2 = localuxk.h;
        f3 = localuxk.i;
        localObject = localuxk.a;
        if ((localObject != null) && (localObject.length != 0)) {
          break label216;
        }
        wxe.c("Q.qqstory.PlayModePollViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
        i = paramStoryVideoItem.mPollNumbers[0];
        break;
      }
      wxe.b("Q.qqstory.PlayModePollViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramxrs.a().a(localObject[0]);
      j = Math.min(localObject.length, paramxrs.a());
      i = 1;
      while (i < j)
      {
        paramxrs.a(i - 1).a(localObject[i]);
        paramxrs.a(i - 1).b(false);
        i += 1;
      }
      int k = 0;
      i = 0;
      Object localObject = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
      if (paramStoryVideoItem.mPollNumbers != null)
      {
        paramxrs.a(paramStoryVideoItem.mPollNumbers);
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
      paramxrs.a((List)localObject, k);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModePollViewUtils.1(paramxrw, paramxru, paramFrameLayout, paramxrs, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int i = paramFrameLayout.getHeight();
    paramxrs.a(localuxk, paramInt, i);
    paramxrs.a();
    a(paramxrw, paramxru, paramxrs, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    wxe.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(i) });
    wxe.a("Q.qqstory.PlayModePollViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */