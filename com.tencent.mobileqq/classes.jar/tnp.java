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

public class tnp
  extends tno
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<tjt> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private tjs jdField_a_of_type_Tjs;
  private tmy jdField_a_of_type_Tmy;
  @NonNull
  final tng jdField_a_of_type_Tng;
  private final tnq jdField_a_of_type_Tnq;
  private final tnr jdField_a_of_type_Tnr;
  private toa jdField_a_of_type_Toa;
  private tog jdField_a_of_type_Tog;
  private final tpn jdField_a_of_type_Tpn;
  private toa b;
  
  public tnp(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131313312);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Tng = new tng();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new tmz(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new tnr(this, null);
    this.jdField_a_of_type_Tnr = ((tnr)localObject);
    tns localtns = new tns(this, null);
    this.jdField_a_of_type_Tpn = localtns;
    paramViewGroup.a((tmy)localObject, localtns);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new tnq(this, null);
    this.jdField_a_of_type_Tnq = ((tnq)localObject);
    paramViewGroup.setOnPageChangeListener((tpx)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<tjt> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      tjt localtjt = (tjt)localIterator.next();
      if (localtjt.c()) {
        localArrayList.add(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localtjt.b()) {
        localArrayList.add(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString + "(" + localtjt.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    tpt localtpt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localtpt != null) {
      return (StoryPlayerGroupHolder)localtpt.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<tjt> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public tjs a()
  {
    return this.jdField_a_of_type_Tjs;
  }
  
  public void a(tjq paramtjq, tjs paramtjs)
  {
    urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramtjq.jdField_a_of_type_Boolean), Boolean.valueOf(paramtjq.jdField_b_of_type_Boolean), paramtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramtjq.jdField_a_of_type_JavaUtilList.size()), paramtjs.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Tjs = paramtjs;
    ArrayList localArrayList = new ArrayList(paramtjq.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    tjt localtjt;
    while (((Iterator)localObject).hasNext())
    {
      localtjt = (tjt)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localtjt.jdField_a_of_type_JavaLangString))
        {
          urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, localtjt.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, localtjt.jdField_a_of_type_JavaLangString);
        }
        else if (localtjt.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, localtjt.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, localtjt.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localtjt.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Tng.a(paramtjq, paramtjs.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramtjq.jdField_a_of_type_JavaUtilList);
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
      urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (tjt)localArrayList.get(0) });
      if (paramtjq.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Toa != null) && (this.jdField_a_of_type_Toa.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Toa = new toa("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Toa);
        if (j == 0) {
          break label1848;
        }
        urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (tjt)localArrayList.get(localArrayList.size() - 1) });
        if (paramtjq.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new toa("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (tjt)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (tjt)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (tjt)this.jdField_a_of_type_JavaUtilList.get(m);
        localtjt = (tjt)localArrayList.get(n);
        if (localtjt == null) {
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
        if ((((tjt)localObject).equals(localtjt)) && (((tjt)localObject).b() == localtjt.b()) && (((tjt)localObject).c() == localtjt.c())) {
          break label1047;
        }
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((tjt)localObject).jdField_a_of_type_Tjs, localtjt.jdField_a_of_type_Tjs });
        this.jdField_a_of_type_JavaUtilList.set(m, localtjt);
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
        if (((tjt)localObject).jdField_a_of_type_JavaUtilList.size() != localtjt.jdField_a_of_type_JavaUtilList.size())
        {
          urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((tjt)localObject).jdField_a_of_type_Tjs, ((tjt)localObject).jdField_a_of_type_JavaUtilList, localtjt.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localtjt);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((tjt)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((tjt)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localtjt.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((tjt)localObject).jdField_a_of_type_Tjs, ((tjt)localObject).jdField_a_of_type_JavaUtilList, localtjt.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localtjt);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localtjt.jdField_a_of_type_Tjs);
          this.jdField_a_of_type_JavaUtilList.add(m, localtjt);
          i = 1;
        }
      }
      label1269:
      urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (tjt)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localtjt = (tjt)localArrayList.get(n);
            if (localtjt == null) {
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
            if ((((tjt)localObject).equals(localtjt)) && (((tjt)localObject).b() == localtjt.b()) && (((tjt)localObject).c() == localtjt.c())) {
              break label1478;
            }
            urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((tjt)localObject).jdField_a_of_type_Tjs, localtjt.jdField_a_of_type_Tjs });
            this.jdField_a_of_type_JavaUtilList.set(m, localtjt);
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
            if (((tjt)localObject).jdField_a_of_type_JavaUtilList.size() == localtjt.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((tjt)localObject).jdField_a_of_type_Tjs, ((tjt)localObject).jdField_a_of_type_JavaUtilList, localtjt.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localtjt);
            i = 1;
            continue;
            label1543:
            urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localtjt.jdField_a_of_type_Tjs);
            this.jdField_a_of_type_JavaUtilList.add(0, localtjt);
            i = 1;
          }
          label1573:
          urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramtjq.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          awpu.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Toa != null)
          {
            i = n;
            if (this.jdField_a_of_type_Toa.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Toa = new toa(new ErrorMessage(paramtjq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Toa);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Toa == null) {
            break label611;
          }
          this.jdField_a_of_type_Toa = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Toa == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Toa);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new toa(new ErrorMessage(paramtjq.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((tjt)localArrayList.get(i)).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtjs.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramtjs.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Tnq.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(tjs paramtjs, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramtjs == null) || (paramString == null))
    {
      urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramtjs, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((tjt)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Tjs.equals(paramtjs)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramtjs.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramtjs = (tjt)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Toa != null) {
            paramString.add(0, this.jdField_a_of_type_Toa);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramtjs != null) {
            break label809;
          }
          paramtjs = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramtjs == null)
        {
          urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramtjs = null;
          break label161;
        }
        urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramtjs.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Tjs = paramtjs.jdField_a_of_type_Tjs;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((tjt)paramString.get(i)).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtjs.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Tnq.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (tjt)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((tjt)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((tjt)localObject).jdField_a_of_type_JavaUtilList });
            vkw.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((tjt)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((tjt)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramtjs = (tjs)localObject;
          }
          for (;;)
          {
            ((tjt)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Toa != null) {
              localArrayList.add(0, this.jdField_a_of_type_Toa);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramtjs;
            if (paramtjs == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramtjs = (tjt)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramtjs = "vid";
                urk.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramtjs, ((tjt)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Tjs = ((tjt)localObject).jdField_a_of_type_Tjs;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((tjt)localArrayList.get(i)).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, ((tjt)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Tnq.a(i);
                  return;
                  paramtjs = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramtjs = null;
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
  
  public void a(tmy paramtmy)
  {
    this.jdField_a_of_type_Tmy = paramtmy;
  }
  
  public boolean a(@Nullable tog paramtog)
  {
    if (this.jdField_a_of_type_Tnq.jdField_a_of_type_Boolean) {
      urk.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramtog == null)
      {
        urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Tog });
        if (this.jdField_a_of_type_Tog != null) {
          this.jdField_a_of_type_Tog.a(false);
        }
        this.jdField_a_of_type_Tog = null;
        return false;
      }
      if (this.jdField_a_of_type_Tog != paramtog)
      {
        urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Tog, paramtog });
        if (this.jdField_a_of_type_Tog != null) {
          this.jdField_a_of_type_Tog.a(false);
        }
        this.jdField_a_of_type_Tog = paramtog;
        localObject = paramtog.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString);
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
          localObject = (twd)((StoryPlayerGroupHolder)localObject).b(twd.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramtog.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((twd)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramtog.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramtog.c());
    urk.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramtog });
    Object localObject = paramtog.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    urk.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, paramtog.jdField_a_of_type_Tnz.jdField_a_of_type_JavaLangString);
    localObject = (twd)((StoryPlayerGroupHolder)localObject).b(twd.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramtog.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((twd)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramtog.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Tog != null) && (this.jdField_a_of_type_Tog.c())) {
      this.jdField_a_of_type_Tog.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Tng.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Tog != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Tog.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    urp.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Tng.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnp
 * JD-Core Version:    0.7.0.1
 */