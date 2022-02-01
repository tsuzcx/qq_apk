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

public class wsa
  extends wrz
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<woe> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wod jdField_a_of_type_Wod;
  private wrj jdField_a_of_type_Wrj;
  @NonNull
  final wrr jdField_a_of_type_Wrr;
  private final wsb jdField_a_of_type_Wsb;
  private final wsc jdField_a_of_type_Wsc;
  private wsl jdField_a_of_type_Wsl;
  private wsr jdField_a_of_type_Wsr;
  private final wty jdField_a_of_type_Wty;
  private wsl b;
  
  public wsa(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131380767);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Wrr = new wrr();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new wrk(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new wsc(this, null);
    this.jdField_a_of_type_Wsc = ((wsc)localObject);
    wsd localwsd = new wsd(this, null);
    this.jdField_a_of_type_Wty = localwsd;
    paramViewGroup.a((wrj)localObject, localwsd);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new wsb(this, null);
    this.jdField_a_of_type_Wsb = ((wsb)localObject);
    paramViewGroup.setOnPageChangeListener((wui)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<woe> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      woe localwoe = (woe)localIterator.next();
      if (localwoe.c()) {
        localArrayList.add(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localwoe.b()) {
        localArrayList.add(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString + "(" + localwoe.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    wue localwue = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localwue != null) {
      return (StoryPlayerGroupHolder)localwue.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<woe> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public wod a()
  {
    return this.jdField_a_of_type_Wod;
  }
  
  public void a(wob paramwob, wod paramwod)
  {
    xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramwob.jdField_a_of_type_Boolean), Boolean.valueOf(paramwob.jdField_b_of_type_Boolean), paramwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramwob.jdField_a_of_type_JavaUtilList.size()), paramwod.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Wod = paramwod;
    ArrayList localArrayList = new ArrayList(paramwob.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    woe localwoe;
    while (((Iterator)localObject).hasNext())
    {
      localwoe = (woe)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localwoe.jdField_a_of_type_JavaLangString))
        {
          xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, localwoe.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, localwoe.jdField_a_of_type_JavaLangString);
        }
        else if (localwoe.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, localwoe.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, localwoe.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localwoe.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localwoe.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Wrr.a(paramwob, paramwod.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramwob.jdField_a_of_type_JavaUtilList);
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
      xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (woe)localArrayList.get(0) });
      if (paramwob.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Wsl != null) && (this.jdField_a_of_type_Wsl.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Wsl = new wsl("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Wsl);
        if (j == 0) {
          break label1848;
        }
        xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (woe)localArrayList.get(localArrayList.size() - 1) });
        if (paramwob.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new wsl("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (woe)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (woe)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (woe)this.jdField_a_of_type_JavaUtilList.get(m);
        localwoe = (woe)localArrayList.get(n);
        if (localwoe == null) {
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
        if ((((woe)localObject).equals(localwoe)) && (((woe)localObject).b() == localwoe.b()) && (((woe)localObject).c() == localwoe.c())) {
          break label1047;
        }
        xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((woe)localObject).jdField_a_of_type_Wod, localwoe.jdField_a_of_type_Wod });
        this.jdField_a_of_type_JavaUtilList.set(m, localwoe);
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
        if (((woe)localObject).jdField_a_of_type_JavaUtilList.size() != localwoe.jdField_a_of_type_JavaUtilList.size())
        {
          xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((woe)localObject).jdField_a_of_type_Wod, ((woe)localObject).jdField_a_of_type_JavaUtilList, localwoe.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localwoe);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((woe)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((woe)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localwoe.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((woe)localObject).jdField_a_of_type_Wod, ((woe)localObject).jdField_a_of_type_JavaUtilList, localwoe.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localwoe);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localwoe.jdField_a_of_type_Wod);
          this.jdField_a_of_type_JavaUtilList.add(m, localwoe);
          i = 1;
        }
      }
      label1269:
      xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (woe)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localwoe = (woe)localArrayList.get(n);
            if (localwoe == null) {
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
            if ((((woe)localObject).equals(localwoe)) && (((woe)localObject).b() == localwoe.b()) && (((woe)localObject).c() == localwoe.c())) {
              break label1478;
            }
            xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((woe)localObject).jdField_a_of_type_Wod, localwoe.jdField_a_of_type_Wod });
            this.jdField_a_of_type_JavaUtilList.set(m, localwoe);
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
            if (((woe)localObject).jdField_a_of_type_JavaUtilList.size() == localwoe.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((woe)localObject).jdField_a_of_type_Wod, ((woe)localObject).jdField_a_of_type_JavaUtilList, localwoe.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localwoe);
            i = 1;
            continue;
            label1543:
            xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localwoe.jdField_a_of_type_Wod);
            this.jdField_a_of_type_JavaUtilList.add(0, localwoe);
            i = 1;
          }
          label1573:
          xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramwob.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          bcdb.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Wsl != null)
          {
            i = n;
            if (this.jdField_a_of_type_Wsl.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Wsl = new wsl(new ErrorMessage(paramwob.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Wsl);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Wsl == null) {
            break label611;
          }
          this.jdField_a_of_type_Wsl = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Wsl == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Wsl);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new wsl(new ErrorMessage(paramwob.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((woe)localArrayList.get(i)).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwod.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramwod.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Wsb.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(wod paramwod, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramwod == null) || (paramString == null))
    {
      xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramwod, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((woe)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Wod.equals(paramwod)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramwod.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramwod = (woe)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Wsl != null) {
            paramString.add(0, this.jdField_a_of_type_Wsl);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramwod != null) {
            break label809;
          }
          paramwod = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramwod == null)
        {
          xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramwod = null;
          break label161;
        }
        xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramwod.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Wod = paramwod.jdField_a_of_type_Wod;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((woe)paramString.get(i)).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwod.jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Wsb.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (woe)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((woe)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((woe)localObject).jdField_a_of_type_JavaUtilList });
            yos.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((woe)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((woe)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramwod = (wod)localObject;
          }
          for (;;)
          {
            ((woe)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Wsl != null) {
              localArrayList.add(0, this.jdField_a_of_type_Wsl);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramwod;
            if (paramwod == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramwod = (woe)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramwod = "vid";
                xvv.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramwod, ((woe)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Wod = ((woe)localObject).jdField_a_of_type_Wod;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((woe)localArrayList.get(i)).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, ((woe)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Wsb.a(i);
                  return;
                  paramwod = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramwod = null;
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
  
  public void a(wrj paramwrj)
  {
    this.jdField_a_of_type_Wrj = paramwrj;
  }
  
  public boolean a(@Nullable wsr paramwsr)
  {
    if (this.jdField_a_of_type_Wsb.jdField_a_of_type_Boolean) {
      xvv.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramwsr == null)
      {
        xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Wsr });
        if (this.jdField_a_of_type_Wsr != null) {
          this.jdField_a_of_type_Wsr.a(false);
        }
        this.jdField_a_of_type_Wsr = null;
        return false;
      }
      if (this.jdField_a_of_type_Wsr != paramwsr)
      {
        xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Wsr, paramwsr });
        if (this.jdField_a_of_type_Wsr != null) {
          this.jdField_a_of_type_Wsr.a(false);
        }
        this.jdField_a_of_type_Wsr = paramwsr;
        localObject = paramwsr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString);
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
          localObject = (xao)((StoryPlayerGroupHolder)localObject).b(xao.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramwsr.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((xao)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramwsr.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramwsr.c());
    xvv.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramwsr });
    Object localObject = paramwsr.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    xvv.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Wod.jdField_a_of_type_JavaLangString, paramwsr.jdField_a_of_type_Wsk.jdField_a_of_type_JavaLangString);
    localObject = (xao)((StoryPlayerGroupHolder)localObject).b(xao.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramwsr.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((xao)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramwsr.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Wsr != null) && (this.jdField_a_of_type_Wsr.c())) {
      this.jdField_a_of_type_Wsr.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Wrr.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Wsr != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Wsr.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    xwa.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Wrr.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */