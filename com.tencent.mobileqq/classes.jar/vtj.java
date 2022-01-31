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

public class vtj
  extends vti
{
  @NonNull
  public final View a;
  @NonNull
  private final StoryPlayerGroupAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
  @NonNull
  public final XViewPager a;
  private List<vpn> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vpm jdField_a_of_type_Vpm;
  private vss jdField_a_of_type_Vss;
  @NonNull
  final vta jdField_a_of_type_Vta;
  private final vtk jdField_a_of_type_Vtk;
  private final vtl jdField_a_of_type_Vtl;
  private vtu jdField_a_of_type_Vtu;
  private vua jdField_a_of_type_Vua;
  private final vvh jdField_a_of_type_Vvh;
  private vtu b;
  
  public vtj(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131379906);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.jdField_a_of_type_JavaLangString = "XViewPager_Vertical";
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(false, false, true, true);
    this.jdField_a_of_type_Vta = new vta();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTransformer(true, new vst(new ThreeDTransformer(true, true)));
    int i = (int)paramViewGroup.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.4F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter = new StoryPlayerGroupAdapter(this);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter;
    Object localObject = new vtl(this, null);
    this.jdField_a_of_type_Vtl = ((vtl)localObject);
    vtm localvtm = new vtm(this, null);
    this.jdField_a_of_type_Vvh = localvtm;
    paramViewGroup.a((vss)localObject, localvtm);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    localObject = new vtk(this, null);
    this.jdField_a_of_type_Vtk = ((vtk)localObject);
    paramViewGroup.setOnPageChangeListener((vvr)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter);
    new Handler(Looper.getMainLooper()).post(new StoryPlayerGlobalHolder.1(this));
  }
  
  private void a(@NonNull String paramString, @NonNull List<vpn> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vpn localvpn = (vpn)localIterator.next();
      if (localvpn.c()) {
        localArrayList.add(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString + "(Loading)");
      } else if (localvpn.b()) {
        localArrayList.add(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString + "(Error)");
      } else {
        localArrayList.add(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString + "(" + localvpn.jdField_a_of_type_JavaUtilList.size() + ")");
      }
    }
    wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", paramString + ", size=%d, list=%s", Integer.valueOf(paramList.size()), localArrayList);
  }
  
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    vvn localvvn = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
    if (localvvn != null) {
      return (StoryPlayerGroupHolder)localvvn.a;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public List<vpn> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a();
  }
  
  public vpm a()
  {
    return this.jdField_a_of_type_Vpm;
  }
  
  public void a(vpk paramvpk, vpm paramvpm)
  {
    wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, up-end=%s, down-end=%s, up-error=%s, down-error=%s, data-size=%d, selectedGroupId=%s", new Object[] { Boolean.valueOf(paramvpk.jdField_a_of_type_Boolean), Boolean.valueOf(paramvpk.jdField_b_of_type_Boolean), paramvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, paramvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage, Integer.valueOf(paramvpk.jdField_a_of_type_JavaUtilList.size()), paramvpm.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_Vpm = paramvpm;
    ArrayList localArrayList = new ArrayList(paramvpk.jdField_a_of_type_JavaUtilList);
    a("onBind, newGroupInfoList", localArrayList);
    if (localArrayList.size() == 0) {
      return;
    }
    Object localObject = localArrayList.iterator();
    vpn localvpn;
    while (((Iterator)localObject).hasNext())
    {
      localvpn = (vpn)((Iterator)localObject).next();
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (str.startsWith("LoadingGroup")) || (str.startsWith("ErrorGroup")))
      {
        if (!TextUtils.isEmpty(localvpn.jdField_a_of_type_JavaLangString))
        {
          wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, firstPlayVid=%s", localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, localvpn.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.put(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, localvpn.jdField_a_of_type_JavaLangString);
        }
        else if (localvpn.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, first - vid=%s", localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, localvpn.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_JavaUtilMap.put(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, localvpn.jdField_a_of_type_JavaUtilList.get(0));
        }
        else
        {
          wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, vid=%s", localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, null);
          this.jdField_a_of_type_JavaUtilMap.put(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, null);
        }
      }
      else if ((!TextUtils.isEmpty(str)) && (!localvpn.jdField_a_of_type_JavaUtilList.contains(str)))
      {
        wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, mark position, groupId=%s, CURRENT ! old=%s", localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_JavaUtilMap.put(localvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, null);
      }
    }
    this.jdField_a_of_type_Vta.a(paramvpk, paramvpm.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramvpk.jdField_a_of_type_JavaUtilList);
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
      wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "firstGroupInfo = %s", new Object[] { (vpn)localArrayList.get(0) });
      if (paramvpk.jdField_a_of_type_Boolean) {
        break label1723;
      }
      if ((paramvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) || (paramvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
      {
        if ((this.jdField_a_of_type_Vtu != null) && (this.jdField_a_of_type_Vtu.c())) {
          break label2029;
        }
        i = 1;
        this.jdField_a_of_type_Vtu = new vtu("top_" + SystemClock.uptimeMillis(), true);
        localArrayList.add(0, this.jdField_a_of_type_Vtu);
        if (j == 0) {
          break label1848;
        }
        wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "lastGroupInfo = %s", new Object[] { (vpn)localArrayList.get(localArrayList.size() - 1) });
        if (paramvpk.jdField_b_of_type_Boolean) {
          break label1827;
        }
        if ((paramvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (!paramvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
          break label1769;
        }
        if ((this.b != null) && (this.b.c())) {
          break label2026;
        }
        i = 1;
        this.b = new vtu("bottom_" + SystemClock.uptimeMillis(), false);
        localArrayList.add(this.b);
        j = i;
        a("onBind, allGroupInfoList", localArrayList);
        if ((j != 0) || (k != 0)) {
          break label1874;
        }
        wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, ignore because nothing changed");
      }
    }
    else
    {
      localObject = (vpn)localArrayList.get(0);
      i2 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      localObject = (vpn)localArrayList.get(localArrayList.size() - 1);
      i3 = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
      wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, firstPosition=%d, lastPosition=%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
        localObject = (vpn)this.jdField_a_of_type_JavaUtilList.get(m);
        localvpn = (vpn)localArrayList.get(n);
        if (localvpn == null) {
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
        if ((((vpn)localObject).equals(localvpn)) && (((vpn)localObject).b() == localvpn.b()) && (((vpn)localObject).c() == localvpn.c())) {
          break label1047;
        }
        wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info replace !! old = %s, new = %s", new Object[] { ((vpn)localObject).jdField_a_of_type_Vpm, localvpn.jdField_a_of_type_Vpm });
        this.jdField_a_of_type_JavaUtilList.set(m, localvpn);
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
        if (((vpn)localObject).jdField_a_of_type_JavaUtilList.size() != localvpn.jdField_a_of_type_JavaUtilList.size())
        {
          wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((vpn)localObject).jdField_a_of_type_Vpm, ((vpn)localObject).jdField_a_of_type_JavaUtilList, localvpn.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilList.set(m, localvpn);
          i = 1;
        }
        else
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= ((vpn)localObject).jdField_a_of_type_JavaUtilList.size()) {
              break label2056;
            }
            if (!TextUtils.equals((CharSequence)((vpn)localObject).jdField_a_of_type_JavaUtilList.get(i1), (CharSequence)localvpn.jdField_a_of_type_JavaUtilList.get(i1)))
            {
              i1 = 0;
              if (i1 == 0)
              {
                wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, the group info update, vid list size equal !! groupId=%s, old vid list = %s, new vid list = %s", new Object[] { ((vpn)localObject).jdField_a_of_type_Vpm, ((vpn)localObject).jdField_a_of_type_JavaUtilList, localvpn.jdField_a_of_type_JavaUtilList });
                this.jdField_a_of_type_JavaUtilList.set(m, localvpn);
                i = 1;
              }
              break;
            }
            i1 += 1;
          }
          label1238:
          wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info = %s", localvpn.jdField_a_of_type_Vpm);
          this.jdField_a_of_type_JavaUtilList.add(m, localvpn);
          i = 1;
        }
      }
      label1269:
      wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, --, new group info is null !!");
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
            localObject = (vpn)this.jdField_a_of_type_JavaUtilList.get(m);
            label1328:
            localvpn = (vpn)localArrayList.get(n);
            if (localvpn == null) {
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
            if ((((vpn)localObject).equals(localvpn)) && (((vpn)localObject).b() == localvpn.b()) && (((vpn)localObject).c() == localvpn.c())) {
              break label1478;
            }
            wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info replace !! old = %s, new = %s", new Object[] { ((vpn)localObject).jdField_a_of_type_Vpm, localvpn.jdField_a_of_type_Vpm });
            this.jdField_a_of_type_JavaUtilList.set(m, localvpn);
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
            if (((vpn)localObject).jdField_a_of_type_JavaUtilList.size() == localvpn.jdField_a_of_type_JavaUtilList.size()) {
              break label2047;
            }
            wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, the group info update !! groupId=%s, old vid list = %s, new vid list = %s", ((vpn)localObject).jdField_a_of_type_Vpm, ((vpn)localObject).jdField_a_of_type_JavaUtilList, localvpn.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.set(m, localvpn);
            i = 1;
            continue;
            label1543:
            wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info = %s", localvpn.jdField_a_of_type_Vpm);
            this.jdField_a_of_type_JavaUtilList.add(0, localvpn);
            i = 1;
          }
          label1573:
          wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, top, new group info is null !!");
        }
      }
      for (;;)
      {
        if ((i2 == -1) && (i3 == -1))
        {
          if (localArrayList.indexOf(this.jdField_a_of_type_JavaUtilList.get(0)) != -1)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramvpk.jdField_a_of_type_JavaUtilList);
            i = 1;
            j = 1;
            k = 1;
            break label464;
          }
          wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data conflict. ignore update !");
          azpo.a(new Throwable());
          return;
          if (this.jdField_a_of_type_Vtu != null)
          {
            i = n;
            if (this.jdField_a_of_type_Vtu.b()) {}
          }
          else
          {
            i = 1;
          }
          this.jdField_a_of_type_Vtu = new vtu(new ErrorMessage(paramvpk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage), true);
          localArrayList.add(0, this.jdField_a_of_type_Vtu);
          break label611;
          label1723:
          i = m;
          if (this.jdField_a_of_type_Vtu == null) {
            break label611;
          }
          this.jdField_a_of_type_Vtu = null;
          i = 1;
          break label611;
          label1743:
          i = m;
          if (this.jdField_a_of_type_Vtu == null) {
            break label611;
          }
          localArrayList.add(0, this.jdField_a_of_type_Vtu);
          i = m;
          break label611;
          label1769:
          if ((this.b == null) || (!this.b.b())) {
            i = 1;
          }
          this.b = new vtu(new ErrorMessage(paramvpk.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage), false);
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
          wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, update adapter because changed");
          if (localArrayList.size() <= 0) {
            break;
          }
          i = 0;
          if (i < localArrayList.size()) {
            if (!TextUtils.equals(((vpn)localArrayList.get(i)).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvpm.jdField_a_of_type_JavaLangString)) {}
          }
          for (;;)
          {
            wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, currentVerticalPosition=%d, selectedGroupId=%s", Integer.valueOf(i), paramvpm.jdField_a_of_type_JavaLangString);
            if (i != -1)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
              wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, setCurrentItem after setDataList, position=%d", new Object[] { Integer.valueOf(i) });
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
              {
                this.jdField_a_of_type_Vtk.a(i);
                return;
                i += 1;
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, false);
              return;
            }
            wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onBind, data update ignore !!");
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
  
  public void a(vpm paramvpm, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    int j = 0;
    int k = 0;
    if ((paramvpm == null) || (paramString == null))
    {
      wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, deleteGroupId=%s, deleteVid=%s", new Object[] { paramvpm, paramString });
      return;
    }
    int i = 0;
    label41:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((vpn)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Vpm.equals(paramvpm)) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, can not find the group which is deleted ! delete group = %s, vid = %s, isGroupDeleted = %s", new Object[] { paramvpm.jdField_a_of_type_JavaLangString, paramString, Boolean.valueOf(paramBoolean) });
        return;
        i += 1;
        break label41;
      }
      if (paramBoolean) {
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramvpm = (vpn)this.jdField_a_of_type_JavaUtilList.get(i + 1);
          label161:
          this.jdField_a_of_type_JavaUtilList.remove(i);
          paramString = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (this.jdField_a_of_type_Vtu != null) {
            paramString.add(0, this.jdField_a_of_type_Vtu);
          }
          if (this.b != null) {
            paramString.add(this.b);
          }
          if (paramvpm != null) {
            break label809;
          }
          paramvpm = this.b;
        }
      }
      label293:
      label809:
      for (;;)
      {
        if (paramvpm == null)
        {
          wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then no any more group, exit");
          a().finish();
          return;
          paramvpm = null;
          break label161;
        }
        wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, delete one group and then play next group, nextGroup = %s", new Object[] { paramvpm.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString });
        this.jdField_a_of_type_Vpm = paramvpm.jdField_a_of_type_Vpm;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(paramString);
        i = k;
        if (i < paramString.size()) {
          if (!TextUtils.equals(((vpn)paramString.get(i)).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvpm.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString)) {}
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
          {
            wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
            this.jdField_a_of_type_Vtk.a(i);
            return;
            i += 1;
            break label293;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
          return;
          Object localObject = (vpn)this.jdField_a_of_type_JavaUtilList.get(i);
          k = ((vpn)localObject).jdField_a_of_type_JavaUtilList.indexOf(paramString);
          if (k < 0)
          {
            wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "deletedVid=%s, vidList=%s", new Object[] { paramString, ((vpn)localObject).jdField_a_of_type_JavaUtilList });
            xqq.a(false, "找不到被删除的vid");
            return;
          }
          if (k < ((vpn)localObject).jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramString = (String)((vpn)localObject).jdField_a_of_type_JavaUtilList.get(k + 1);
            paramvpm = (vpm)localObject;
          }
          for (;;)
          {
            ((vpn)localObject).jdField_a_of_type_JavaUtilList.remove(k);
            localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
            if (this.jdField_a_of_type_Vtu != null) {
              localArrayList.add(0, this.jdField_a_of_type_Vtu);
            }
            if (this.b != null) {
              localArrayList.add(this.b);
            }
            localObject = paramvpm;
            if (paramvpm == null) {
              localObject = this.b;
            }
            if (localObject == null)
            {
              wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then no any more group, exit");
              a().finish();
              return;
              if (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                paramvpm = (vpn)this.jdField_a_of_type_JavaUtilList.get(i + 1);
                paramString = localArrayList;
              }
            }
            else
            {
              if (paramString != null)
              {
                paramvpm = "vid";
                wxe.d("Q.qqstory.playernew.StoryPlayerGlobalHolder", "delete one vid and then play next %s, nextGroup = %s, nextVid = %s", new Object[] { paramvpm, ((vpn)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramString });
                this.jdField_a_of_type_Vpm = ((vpn)localObject).jdField_a_of_type_Vpm;
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupAdapter.a(localArrayList);
                if (paramString != null) {
                  break;
                }
                i = j;
                label687:
                if (i >= localArrayList.size()) {
                  break label789;
                }
                if (!TextUtils.equals(((vpn)localArrayList.get(i)).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, ((vpn)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString)) {
                  break label769;
                }
              }
              for (;;)
              {
                if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == i)
                {
                  wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onGroupDataDelete, fake onPageSelected, position = %d", Integer.valueOf(i));
                  this.jdField_a_of_type_Vtk.a(i);
                  return;
                  paramvpm = "group";
                  break;
                  i += 1;
                  break label687;
                }
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(i, true);
                return;
                i = -1;
              }
            }
            paramvpm = null;
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
  
  public void a(vss paramvss)
  {
    this.jdField_a_of_type_Vss = paramvss;
  }
  
  public boolean a(@Nullable vua paramvua)
  {
    if (this.jdField_a_of_type_Vtk.jdField_a_of_type_Boolean) {
      wxe.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelectedImpl ignore");
    }
    VideoViewVideoHolder localVideoViewVideoHolder;
    label292:
    do
    {
      return false;
      if (paramvua == null)
      {
        wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => null", new Object[] { this.jdField_a_of_type_Vua });
        if (this.jdField_a_of_type_Vua != null) {
          this.jdField_a_of_type_Vua.a(false);
        }
        this.jdField_a_of_type_Vua = null;
        return false;
      }
      if (this.jdField_a_of_type_Vua != paramvua)
      {
        wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, %s => %s", new Object[] { this.jdField_a_of_type_Vua, paramvua });
        if (this.jdField_a_of_type_Vua != null) {
          this.jdField_a_of_type_Vua.a(false);
        }
        this.jdField_a_of_type_Vua = paramvua;
        localObject = paramvua.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
        wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
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
          localObject = (wbx)((StoryPlayerGroupHolder)localObject).b(wbx.class);
          if (localObject != null)
          {
            localVideoViewVideoHolder = (VideoViewVideoHolder)paramvua.a(VideoViewVideoHolder.class);
            if (localVideoViewVideoHolder != null) {
              ((wbx)localObject).a(localVideoViewVideoHolder.a);
            }
          }
          paramvua.a(true);
          return true;
          bool1 = false;
          break;
        }
      }
    } while (paramvua.c());
    wxe.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, selection re-trigger, %s", new Object[] { paramvua });
    Object localObject = paramvua.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    wxe.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "requestSelected, mark position, groupId=%s, vid=%s", ((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put(((StoryPlayerGroupHolder)localObject).jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, paramvua.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
    localObject = (wbx)((StoryPlayerGroupHolder)localObject).b(wbx.class);
    if (localObject != null)
    {
      localVideoViewVideoHolder = (VideoViewVideoHolder)paramvua.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        ((wbx)localObject).a(localVideoViewVideoHolder.a);
      }
    }
    paramvua.a(true);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vua != null) && (this.jdField_a_of_type_Vua.c())) {
      this.jdField_a_of_type_Vua.a(false);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Vta.a(this);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Vua != null)
    {
      VideoViewVideoHolder localVideoViewVideoHolder = (VideoViewVideoHolder)this.jdField_a_of_type_Vua.a(VideoViewVideoHolder.class);
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.d = 2;
      }
    }
    wxj.a("play_video", "clk_back", 0, 0, new String[0]);
    return this.jdField_a_of_type_Vta.c();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtj
 * JD-Core Version:    0.7.0.1
 */