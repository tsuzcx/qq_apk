import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class xgv
  extends xgu
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<xcz> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private xcy jdField_a_of_type_Xcy;
  private xge jdField_a_of_type_Xge;
  @NonNull
  final xgm jdField_a_of_type_Xgm;
  private final xgw jdField_a_of_type_Xgw;
  private final xgx jdField_a_of_type_Xgx;
  private xhg jdField_a_of_type_Xhg;
  private xhm jdField_a_of_type_Xhm;
  private final xit jdField_a_of_type_Xit;
  private xhg b;
  
  public xgv(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131381118);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Xgm = new xgm();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new xgf(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new xgx(this, null);
    this.jdField_a_of_type_Xgx = ((xgx)localObject);
    xgy localxgy = new xgy(this, null);
    this.jdField_a_of_type_Xit = localxgy;
    paramViewGroup.a((xge)localObject, localxgy);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new xgw(this, null);
    this.jdField_a_of_type_Xgw = ((xgw)localObject);
    paramViewGroup.setOnPageChangeListener((xjd)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<xcz> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xcz localxcz = (xcz)localIterator.next();
      if (localxcz.c()) {
        localArrayList.add(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localxcz.b()) {
        localArrayList.add(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString + "(" + localxcz.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    xiz localxiz = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localxiz != null) {
      return (StoryPlayerGroupHolder)localxiz.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<xcz> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public xcy a()
  {
    return this.jdField_a_of_type_Xcy;
  }
  
  public void a(xcw paramxcw, xcy paramxcy)
  {
    ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramxcw.jdField_a_of_type_Boolean), Boolean.valueOf(paramxcw.jdField_b_of_type_Boolean), paramxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramxcw.jdField_a_of_type_JavaUtilList.size()), paramxcy.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Xcy = paramxcy;
    ArrayList localArrayList = new ArrayList(paramxcw.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    xcz localxcz;
    while (((Iterator)localObject).hasNext())
    {
      localxcz = (xcz)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localxcz.jdField_a_of_type_JavaLangString))
        {
          ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, localxcz.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, localxcz.jdField_a_of_type_JavaLangString);
        }
        else if (localxcz.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, localxcz.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, localxcz.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localxcz.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Xgm.a(paramxcw, paramxcy.jdField_a_of_type_JavaLangString);
    int i;
    int j;
    int k;
    label464:
    int n;
    int m;
    label567:
    label611:
    int i2;
    label689:
    label736:
    int i3;
    label897:
    label922:
    label941:
    int i1;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramxcw.jdField_a_of_type_JavaUtilList);
      i = 1;
      j = 1;
      k = 1;
      a("onBind, currentGroupInfoList", this.jdField_a_of_type_JavaUtilList);
      localArrayList.clear();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      n = 0;
      m = 0;
      if (i == 0) {
        break label1743;
      }
      ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (xcz)localArrayList.get(0) });
      if (paramxcw.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Xhg != null) && (this.jdField_a_of_type_Xhg.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Xhg = new xhg("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Xhg);
        if (j == 0) {
          break label1848;
        }
        ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (xcz)localArrayList.get(localArrayList.size() - 1) });
        if (paramxcw.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new xhg("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (xcz)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (xcz)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
      if (i2 == -1) {
        break label2071;
      }
      m = i2;
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      if (n >= localArrayList.size()) {
        break label2068;
      }
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (xcz)this.jdField_a_of_type_JavaUtilList.get(m);
        localxcz = (xcz)localArrayList.get(n);
        if (localxcz == null) {
          break label1269;
        }
        if (m != 0) {
          break label2065;
        }
        k = 1;
        if (m != this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label2062;
        }
        j = 1;
        if (localObject == null) {
          break label1238;
        }
        if ((((xcz)localObject).equals(localxcz)) && (((xcz)localObject).b() == localxcz.b()) && (((xcz)localObject).c() == localxcz.c())) {
          break label1047;
        }
        ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((xcz)localObject).jdField_a_of_type_Xcy, localxcz.jdField_a_of_type_Xcy });
        this.jdField_a_of_type_JavaUtilList.set(m, localxcz);
        i = 1;
      }
      label1169:
      for (;;)
      {
        n += 1;
        m += 1;
        break;
        localObject = null;
        break label897;
        label1047:
        if (((xcz)localObject).jdField_a_of_type_JavaUtilList.size() != localxcz.jdField_a_of_type_JavaUtilList.size())
        {
          ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xcz)localObject).jdField_a_of_type_Xcy, ((xcz)localObject).jdField_a_of_type_JavaUtilList, localxcz.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localxcz);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((xcz)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((xcz)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localxcz.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((xcz)localObject).jdField_a_of_type_Xcy, ((xcz)localObject).jdField_a_of_type_JavaUtilList, localxcz.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localxcz);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localxcz.jdField_a_of_type_Xcy);
          this.jdField_a_of_type_JavaUtilList.add(m, localxcz);
          i = 1;
        }
      }
      label1269:
      ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
    }
    for (;;)
    {
      if ((i2 == -1) && (i3 != -1))
      {
        n = localArrayList.size() - 1;
        m = i3;
        if (n >= 0)
        {
          if (m >= 0)
          {
            localObject = (xcz)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localxcz = (xcz)localArrayList.get(n);
            if (localxcz == null) {
              break label1573;
            }
            if (m == 0) {
              k = 1;
            }
            if (m == this.jdField_a_of_type_JavaUtilList.size() - 1) {
              j = 1;
            }
            if (localObject == null) {
              break label1543;
            }
            if ((((xcz)localObject).equals(localxcz)) && (((xcz)localObject).b() == localxcz.b()) && (((xcz)localObject).c() == localxcz.c())) {
              break label1478;
            }
            ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((xcz)localObject).jdField_a_of_type_Xcy, localxcz.jdField_a_of_type_Xcy });
            this.jdField_a_of_type_JavaUtilList.set(m, localxcz);
            i = 1;
          }
          for (;;)
          {
            label1457:
            n -= 1;
            m -= 1;
            break;
            localObject = null;
            break label1328;
            label1478:
            if (((xcz)localObject).jdField_a_of_type_JavaUtilList.size() == localxcz.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((xcz)localObject).jdField_a_of_type_Xcy, ((xcz)localObject).jdField_a_of_type_JavaUtilList, localxcz.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localxcz);
            i = 1;
            continue;
            label1543:
            ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localxcz.jdField_a_of_type_Xcy);
            this.jdField_a_of_type_JavaUtilList.add(0, localxcz);
            i = 1;
          }
          label1573:
          ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramxcw.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          bdjw.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Xhg != null)
          {
            i = n;
            if (this.jdField_a_of_type_Xhg.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Xhg = new xhg(new ErrorMessage(paramxcw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Xhg);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Xhg == null) {
            break label611;
          }
          this.jdField_a_of_type_Xhg = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Xhg == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Xhg);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new xhg(new ErrorMessage(paramxcw.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1827:
          j = i;
          if (this.b == null) {
            break label736;
          }
          this.b = null;
          j = 1;
          break label736;
          label1848:
          j = i;
          if (this.b == null) {
            break label736;
          }
          localArrayList.add(this.b);
          j = i;
          break label736;
          label1874:
          ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((xcz)localArrayList.get(i)).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxcy.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramxcy.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Xgw.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
            return;
            i = -1;
          }
          label2026:
          break label689;
          label2029:
          i = 0;
          break label567;
        }
        m = i;
        i = k;
        k = m;
        break label464;
        label2047:
        break label1457;
      }
      label2056:
      i1 = 1;
      break label1169;
      label2062:
      break label941;
      label2065:
      break label922;
      label2068:
      continue;
      label2071:
      j = 0;
      k = 0;
      i = 0;
    }
  }
  
  public void a(xcy paramxcy, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramxcy == null) || (paramString == null))
    {
      ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramxcy, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((xcz)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Xcy.equals(paramxcy)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramxcy.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramxcy = (xcz)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Xhg != null) {
            paramString.add(0, this.jdField_a_of_type_Xhg);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramxcy != null) {
            break label809;
          }
          paramxcy = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramxcy == null)
        {
          ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramxcy = null;
          break label161;
        }
        ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramxcy.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Xcy = paramxcy.jdField_a_of_type_Xcy;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((xcz)paramString.get(i)).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxcy.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Xgw.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (xcz)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((xcz)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((xcz)localObject).jdField_a_of_type_JavaUtilList });
            zdl.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((xcz)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((xcz)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramxcy = (xcy)localObject;
          }
          for (;;)
          {
            ((xcz)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Xhg != null) {
              localArrayList.add(0, this.jdField_a_of_type_Xhg);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramxcy;
            if (paramxcy == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramxcy = (xcz)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramxcy = "vid";
                ykq.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramxcy, ((xcz)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Xcy = ((xcz)localObject).jdField_a_of_type_Xcy;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((xcz)localArrayList.get(i)).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, ((xcz)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Xgw.a(i);
                  return;
                  paramxcy = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramxcy = null;
            paramString = localArrayList;
          }
          i = -1;
        }
      }
      label769:
      label789:
      i = -1;
    }
  }
  
  public void a(xge paramxge)
  {
    this.jdField_a_of_type_Xge = paramxge;
  }
  
  public boolean a(@Nullable xhm paramxhm)
  {
    if (this.jdField_a_of_type_Xgw.jdField_a_of_type_Boolean) {
      ykq.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramxhm == null)
      {
        ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Xhm });
        if (this.jdField_a_of_type_Xhm != null) {
          this.jdField_a_of_type_Xhm.a(false);
        }
        this.jdField_a_of_type_Xhm = null;
        return false;
      }
      if (this.jdField_a_of_type_Xhm != paramxhm)
      {
        ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Xhm, paramxhm });
        if (this.jdField_a_of_type_Xhm != null) {
          this.jdField_a_of_type_Xhm.a(false);
        }
        this.jdField_a_of_type_Xhm = paramxhm;
        localObject = paramxhm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject).b == ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
        {
          bool1 = true;
          if (((StoryPlayerGroupHolder)localObject).b != 0) {
            break label292;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          boolean bool3 = bool1;
          if (bool1)
          {
            bool3 = bool1;
            if (((StoryPlayerGroupHolder)localObject).d()) {
              bool3 = false;
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(bool3, bool2, true, true);
          localObject = (xpj)((StoryPlayerGroupHolder)localObject).b(xpj.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramxhm.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((xpj)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramxhm.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramxhm.c());
    ykq.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramxhm });
    Object localObject = paramxhm.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    ykq.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, paramxhm.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
    localObject = (xpj)((StoryPlayerGroupHolder)localObject).b(xpj.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramxhm.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((xpj)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramxhm.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Xhm != null) && (this.jdField_a_of_type_Xhm.c())) {
      this.jdField_a_of_type_Xhm.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xgm.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Xhm != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Xhm.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    ykv.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Xgm.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgv
 * JD-Core Version:    0.7.0.1
 */