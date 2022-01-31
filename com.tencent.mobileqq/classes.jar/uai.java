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

public class uai
  extends uah
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<twm> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private twl jdField_a_of_type_Twl;
  private tzr jdField_a_of_type_Tzr;
  @NonNull
  final tzz jdField_a_of_type_Tzz;
  private final uaj jdField_a_of_type_Uaj;
  private final uak jdField_a_of_type_Uak;
  private uat jdField_a_of_type_Uat;
  private uaz jdField_a_of_type_Uaz;
  private final ucg jdField_a_of_type_Ucg;
  private uat b;
  
  public uai(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131379152);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Tzz = new tzz();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new tzs(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new uak(this, null);
    this.jdField_a_of_type_Uak = ((uak)localObject);
    ual localual = new ual(this, null);
    this.jdField_a_of_type_Ucg = localual;
    paramViewGroup.a((tzr)localObject, localual);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new uaj(this, null);
    this.jdField_a_of_type_Uaj = ((uaj)localObject);
    paramViewGroup.setOnPageChangeListener((ucq)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<twm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      twm localtwm = (twm)localIterator.next();
      if (localtwm.c()) {
        localArrayList.add(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localtwm.b()) {
        localArrayList.add(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString + "(" + localtwm.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    ucm localucm = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localucm != null) {
      return (StoryPlayerGroupHolder)localucm.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<twm> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public twl a()
  {
    return this.jdField_a_of_type_Twl;
  }
  
  public void a(twj paramtwj, twl paramtwl)
  {
    ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramtwj.jdField_a_of_type_Boolean), Boolean.valueOf(paramtwj.jdField_b_of_type_Boolean), paramtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramtwj.jdField_a_of_type_JavaUtilList.size()), paramtwl.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Twl = paramtwl;
    ArrayList localArrayList = new ArrayList(paramtwj.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    twm localtwm;
    while (((Iterator)localObject).hasNext())
    {
      localtwm = (twm)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localtwm.jdField_a_of_type_JavaLangString))
        {
          ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, localtwm.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, localtwm.jdField_a_of_type_JavaLangString);
        }
        else if (localtwm.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, localtwm.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, localtwm.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localtwm.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Tzz.a(paramtwj, paramtwl.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramtwj.jdField_a_of_type_JavaUtilList);
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
      ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (twm)localArrayList.get(0) });
      if (paramtwj.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Uat != null) && (this.jdField_a_of_type_Uat.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Uat = new uat("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Uat);
        if (j == 0) {
          break label1848;
        }
        ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (twm)localArrayList.get(localArrayList.size() - 1) });
        if (paramtwj.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new uat("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (twm)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (twm)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (twm)this.jdField_a_of_type_JavaUtilList.get(m);
        localtwm = (twm)localArrayList.get(n);
        if (localtwm == null) {
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
        if ((((twm)localObject).equals(localtwm)) && (((twm)localObject).b() == localtwm.b()) && (((twm)localObject).c() == localtwm.c())) {
          break label1047;
        }
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((twm)localObject).jdField_a_of_type_Twl, localtwm.jdField_a_of_type_Twl });
        this.jdField_a_of_type_JavaUtilList.set(m, localtwm);
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
        if (((twm)localObject).jdField_a_of_type_JavaUtilList.size() != localtwm.jdField_a_of_type_JavaUtilList.size())
        {
          ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((twm)localObject).jdField_a_of_type_Twl, ((twm)localObject).jdField_a_of_type_JavaUtilList, localtwm.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localtwm);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((twm)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((twm)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localtwm.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((twm)localObject).jdField_a_of_type_Twl, ((twm)localObject).jdField_a_of_type_JavaUtilList, localtwm.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localtwm);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localtwm.jdField_a_of_type_Twl);
          this.jdField_a_of_type_JavaUtilList.add(m, localtwm);
          i = 1;
        }
      }
      label1269:
      ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (twm)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localtwm = (twm)localArrayList.get(n);
            if (localtwm == null) {
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
            if ((((twm)localObject).equals(localtwm)) && (((twm)localObject).b() == localtwm.b()) && (((twm)localObject).c() == localtwm.c())) {
              break label1478;
            }
            ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((twm)localObject).jdField_a_of_type_Twl, localtwm.jdField_a_of_type_Twl });
            this.jdField_a_of_type_JavaUtilList.set(m, localtwm);
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
            if (((twm)localObject).jdField_a_of_type_JavaUtilList.size() == localtwm.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((twm)localObject).jdField_a_of_type_Twl, ((twm)localObject).jdField_a_of_type_JavaUtilList, localtwm.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localtwm);
            i = 1;
            continue;
            label1543:
            ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localtwm.jdField_a_of_type_Twl);
            this.jdField_a_of_type_JavaUtilList.add(0, localtwm);
            i = 1;
          }
          label1573:
          ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramtwj.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          axpu.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Uat != null)
          {
            i = n;
            if (this.jdField_a_of_type_Uat.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Uat = new uat(new ErrorMessage(paramtwj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Uat);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Uat == null) {
            break label611;
          }
          this.jdField_a_of_type_Uat = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Uat == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Uat);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new uat(new ErrorMessage(paramtwj.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((twm)localArrayList.get(i)).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramtwl.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramtwl.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Uaj.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(twl paramtwl, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramtwl == null) || (paramString == null))
    {
      ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramtwl, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((twm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Twl.equals(paramtwl)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramtwl.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramtwl = (twm)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Uat != null) {
            paramString.add(0, this.jdField_a_of_type_Uat);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramtwl != null) {
            break label809;
          }
          paramtwl = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramtwl == null)
        {
          ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramtwl = null;
          break label161;
        }
        ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramtwl.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Twl = paramtwl.jdField_a_of_type_Twl;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((twm)paramString.get(i)).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramtwl.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Uaj.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (twm)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((twm)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((twm)localObject).jdField_a_of_type_JavaUtilList });
            vxp.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((twm)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((twm)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramtwl = (twl)localObject;
          }
          for (;;)
          {
            ((twm)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Uat != null) {
              localArrayList.add(0, this.jdField_a_of_type_Uat);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramtwl;
            if (paramtwl == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramtwl = (twm)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramtwl = "vid";
                ved.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramtwl, ((twm)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Twl = ((twm)localObject).jdField_a_of_type_Twl;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((twm)localArrayList.get(i)).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, ((twm)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Uaj.a(i);
                  return;
                  paramtwl = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramtwl = null;
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
  
  public void a(tzr paramtzr)
  {
    this.jdField_a_of_type_Tzr = paramtzr;
  }
  
  public boolean a(@Nullable uaz paramuaz)
  {
    if (this.jdField_a_of_type_Uaj.jdField_a_of_type_Boolean) {
      ved.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramuaz == null)
      {
        ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Uaz });
        if (this.jdField_a_of_type_Uaz != null) {
          this.jdField_a_of_type_Uaz.a(false);
        }
        this.jdField_a_of_type_Uaz = null;
        return false;
      }
      if (this.jdField_a_of_type_Uaz != paramuaz)
      {
        ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Uaz, paramuaz });
        if (this.jdField_a_of_type_Uaz != null) {
          this.jdField_a_of_type_Uaz.a(false);
        }
        this.jdField_a_of_type_Uaz = paramuaz;
        localObject = paramuaz.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
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
          localObject = (uiw)((StoryPlayerGroupHolder)localObject).b(uiw.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramuaz.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((uiw)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramuaz.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramuaz.c());
    ved.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramuaz });
    Object localObject = paramuaz.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    ved.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, paramuaz.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
    localObject = (uiw)((StoryPlayerGroupHolder)localObject).b(uiw.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramuaz.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((uiw)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramuaz.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Uaz != null) && (this.jdField_a_of_type_Uaz.c())) {
      this.jdField_a_of_type_Uaz.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Tzz.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Uaz != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Uaz.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    vei.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Tzz.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uai
 * JD-Core Version:    0.7.0.1
 */